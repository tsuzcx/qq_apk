package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.common.APGridView;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;

public class hj
  extends hg
{
  private View m = null;
  private boolean n = false;
  private TextWatcher o = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      Object localObject2 = (LinearLayout)hj.a(hj.this).findViewById(2131099860);
      Object localObject1 = (TextView)hj.a(hj.this).findViewById(2131099985);
      if (paramAnonymousEditable.toString().length() > 0)
      {
        hj.this.j.setVisibility(0);
        if (paramAnonymousEditable.toString().equals("0"))
        {
          hj.this.k.setText("");
          ((LinearLayout)localObject2).setVisibility(8);
          return;
        }
        hj.a(hj.this).setVisibility(0);
        ((LinearLayout)localObject2).setVisibility(0);
      }
      try
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(hj.this.f.getString(2131230879));
        ((StringBuilder)localObject2).append(em.b().n().b.b(paramAnonymousEditable.toString().trim()));
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        label164:
        if (i.a(paramAnonymousEditable.toString()) > hj.this.a) {
          if (hj.this.c.a.saveType == 4)
          {
            if (((ew)hj.this.c.b).l == 3)
            {
              paramAnonymousEditable = hj.this.f;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("升级时长最多不超过");
              ((StringBuilder)localObject1).append(hj.this.a);
              ((StringBuilder)localObject1).append("个月");
              APUICommonMethod.a(paramAnonymousEditable, ((StringBuilder)localObject1).toString());
              hj.this.k.setText(String.valueOf(hj.this.a));
              return;
            }
            APUICommonMethod.a(hj.this.f, "购买数量不能超过最大限制");
          }
          else
          {
            APUICommonMethod.a(hj.this.f, "购买数量不能超过最大限制");
          }
        }
        int i = paramAnonymousEditable.toString().length();
        if (i > 0)
        {
          hj.this.k.setSelection(i);
          return;
          hj.this.j.setVisibility(4);
          ((LinearLayout)localObject2).setVisibility(8);
        }
        return;
      }
      catch (Exception localException)
      {
        break label164;
      }
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  
  public hj(ScrollView paramScrollView, APGridView paramAPGridView, Activity paramActivity, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    this.e = paramScrollView;
    this.d = paramAPGridView;
    this.f = paramActivity;
    this.g = paramArrayOfString1;
    this.h = paramArrayOfString2;
    this.i = paramArrayOfString3;
    this.c = em.b().n();
    this.l = this.c.a.extendInfo.isShowListOtherNum;
    this.a = 9999999;
    this.b = 1;
  }
  
  private void a(final View paramView, int paramInt)
  {
    label266:
    try
    {
      if (this.c.a.saveType != 5) {
        return;
      }
      ((LinearLayout)paramView.findViewById(2131099777)).setVisibility(0);
      localCheckBox = (CheckBox)paramView.findViewById(2131099969);
      f = paramView.getResources().getDisplayMetrics().density;
    }
    catch (Exception paramView)
    {
      CheckBox localCheckBox;
      float f;
      label67:
      break label266;
    }
    try
    {
      paramInt = localCheckBox.getResources().getDrawable(2131034130).getIntrinsicWidth();
    }
    catch (Exception paramView)
    {
      break label67;
    }
    paramInt = Math.round(f * 15.0F);
    if (Build.VERSION.SDK_INT < 17) {
      paramInt = localCheckBox.getPaddingLeft() + paramInt;
    } else {
      paramInt = localCheckBox.getPaddingLeft();
    }
    localCheckBox.setPadding(paramInt, localCheckBox.getPaddingTop(), localCheckBox.getPaddingRight(), localCheckBox.getPaddingBottom());
    paramView = new gt(this.f, localCheckBox);
    if (((APMonthRequest)this.c.a).autoPay)
    {
      localCheckBox.setChecked(true);
      ((ew)this.c.b).n = "1";
      APDataReportManager.getInstance().insertData("sdk.gamelist.auto", this.c.a.saveType, null, "able", null);
      this.n = true;
      paramView.a(1000, 3000, false, false);
    }
    else
    {
      ((ew)this.c.b).n = "0";
      APDataReportManager.getInstance().insertData("sdk.gamelist.auto", this.c.a.saveType, null, "disable", null);
    }
    localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          ((ew)hj.this.c.b).n = "1";
          if (!hj.b(hj.this))
          {
            hj.a(hj.this, true);
            paramView.a(0, 3000, false, false);
          }
        }
        else
        {
          ((ew)hj.this.c.b).n = "0";
          paramView.a();
        }
        if (paramAnonymousBoolean) {}
        for (paramAnonymousCompoundButton = "able";; paramAnonymousCompoundButton = "disable") {
          break;
        }
        APDataReportManager.getInstance().insertData("sdk.gamelist.auto", hj.this.c.a.saveType, null, paramAnonymousCompoundButton, null);
      }
    });
    return;
    APLog.i("APPayListValueAdapter", "monthAutoItem crash");
  }
  
  private void b()
  {
    if (APTools.j()) {
      return;
    }
    String str = this.k.getText().toString();
    if (!TextUtils.isEmpty(str))
    {
      this.c.e.g = str;
      if (this.c.e.g == null) {
        str = "";
      } else {
        str = this.c.e.g;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("a");
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
      APDataReportManager.getInstance().insertData("sdk.gamelist.click", this.c.a.saveType, null, str, null);
      fb.a().a(this.f, "", null);
      return;
    }
    Toast.makeText(this.f, "充值数量不能为空", 1).show();
  }
  
  private void b(View paramView, int paramInt)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131099776);
    if ((em.b().n().a.resId == 0) && (em.b().n().a.resData == null)) {
      localImageView.setVisibility(8);
    } else {
      APUICommonMethod.a(localImageView);
    }
    this.k = ((EditText)paramView.findViewById(2131099780));
    this.j = ((Button)paramView.findViewById(2131099782));
    if (TextUtils.isEmpty(this.k.getText().toString().trim())) {
      this.j.setVisibility(4);
    }
    this.j.setText("确定");
    this.k.setFilters(new InputFilter[] { new InputFilter.LengthFilter(3) });
    this.k.addTextChangedListener(this.o);
    this.k.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 6)
        {
          ((InputMethodManager)paramAnonymousTextView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousTextView.getWindowToken(), 0);
          hj.c(hj.this);
          return true;
        }
        return false;
      }
    });
    if (this.f.getResources().getConfiguration().orientation == 1) {
      this.k.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          hj.this.e.postDelayed(new Runnable()
          {
            public void run()
            {
              hj.this.e.scrollTo(0, 360);
              hj.this.k.requestFocus();
            }
          }, 1000L);
          return false;
        }
      });
    }
    this.j.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = hj.this.k.getText().toString();
        if (!TextUtils.isEmpty(paramAnonymousView))
        {
          hj.this.c.e.g = paramAnonymousView;
          if (hj.this.c.e.g == null) {
            paramAnonymousView = "";
          } else {
            paramAnonymousView = hj.this.c.e.g;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("a");
          localStringBuilder.append(paramAnonymousView);
          paramAnonymousView = localStringBuilder.toString();
          APDataReportManager.getInstance().insertData("sdk.gamelist.else", hj.this.c.a.saveType, null, paramAnonymousView, null);
        }
        hj.c(hj.this);
      }
    });
  }
  
  private void c(View paramView, int paramInt)
  {
    Object localObject2 = (ImageView)paramView.findViewById(2131099776);
    Object localObject1 = (TextView)paramView.findViewById(2131099779);
    paramView = (TextView)paramView.findViewById(2131099781);
    if ((em.b().n().a.resId == 0) && (em.b().n().a.resData == null)) {
      ((ImageView)localObject2).setVisibility(8);
    } else {
      APUICommonMethod.a((ImageView)localObject2);
    }
    if (gc.a().f() == gc.a.a)
    {
      localObject2 = fv.a(Float.valueOf(APTools.i(this.h[paramInt])).floatValue());
      ((TextView)localObject1).setText(this.i[paramInt]);
      if (localObject2.length > 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.f.getString(2131230879));
        ((StringBuilder)localObject1).append(localObject2[0]);
        ((StringBuilder)localObject1).append(".");
        ((StringBuilder)localObject1).append(localObject2[1]);
        paramView.setText(((StringBuilder)localObject1).toString());
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.f.getString(2131230879));
      ((StringBuilder)localObject1).append(localObject2[0]);
      paramView.setText(((StringBuilder)localObject1).toString());
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((APSubscribeRequest)this.c.a).serviceName);
    ((StringBuilder)localObject2).append(" × ");
    ((StringBuilder)localObject2).append(this.g[paramInt]);
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.f.getString(2131230879));
    ((StringBuilder)localObject1).append(this.c.b.b(this.g[paramInt]));
    paramView.setText(((StringBuilder)localObject1).toString());
  }
  
  public int a()
  {
    if (this.d.getNumColumns() != 1)
    {
      if (this.g.length % 2 == 0)
      {
        if ((this.l) && (gc.a().f() != gc.a.a)) {
          return this.g.length + 4;
        }
        return this.g.length + 2;
      }
      if ((this.l) && (gc.a().f() != gc.a.a)) {
        return this.g.length + 3;
      }
      return this.g.length + 3;
    }
    if ((this.l) && (gc.a().f() != gc.a.a)) {
      return this.g.length + 3;
    }
    return this.g.length + 1;
  }
  
  public int a(int paramInt)
  {
    if (this.d.getNumColumns() != 1)
    {
      if ((this.l) && (gc.a().f() != gc.a.a))
      {
        if (this.g.length % 2 == 0)
        {
          if (paramInt == a() - 1) {
            return 5;
          }
          if (paramInt == a() - 2) {
            return 3;
          }
          if (paramInt == a() - 3) {
            return 4;
          }
          if (paramInt == a() - 4) {
            return 1;
          }
          return 0;
        }
        if (paramInt == a() - 1) {
          return 6;
        }
        if (paramInt == a() - 2) {
          return 4;
        }
        if (paramInt == a() - 3) {
          return 1;
        }
        return 0;
      }
      if (this.g.length % 2 == 0)
      {
        if (paramInt == a() - 1) {
          return 5;
        }
        if (paramInt == a() - 2) {
          return 4;
        }
        return 0;
      }
      if (paramInt == a() - 1) {
        return 5;
      }
      if (paramInt == a() - 2) {
        return 4;
      }
      if (paramInt == a() - 3) {
        return 4;
      }
      return 0;
    }
    if ((this.l) && (gc.a().f() != gc.a.a))
    {
      if (paramInt == a() - 1) {
        return 5;
      }
      if (paramInt == a() - 2) {
        return 2;
      }
      if (paramInt == a() - 3) {
        return 1;
      }
      return 0;
    }
    if (paramInt == a() - 1) {
      return 5;
    }
    return 0;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = paramView;
    for (;;)
    {
      try
      {
        LayoutInflater localLayoutInflater = LayoutInflater.from(this.f);
        localObject1 = paramView;
        int i = a(paramInt);
        localView = paramView;
        if (paramView != null)
        {
          localObject1 = paramView;
          Object localObject3 = paramView.getTag();
          localView = paramView;
          if (localObject3 != null)
          {
            localView = paramView;
            localObject1 = paramView;
            if ((localObject3 instanceof Integer))
            {
              localObject1 = paramView;
              int j = ((Integer)localObject3).intValue();
              if (j == -1) {
                break label648;
              }
              localView = paramView;
              if (j != i) {
                break label648;
              }
            }
          }
        }
        if (localView == null)
        {
          if (i == 0)
          {
            localObject1 = localView;
            paramViewGroup = localLayoutInflater.inflate(2131165252, paramViewGroup, false);
            paramView = paramViewGroup;
            try
            {
              c(paramViewGroup, paramInt);
              paramView = paramViewGroup;
            }
            catch (Exception paramViewGroup)
            {
              localObject1 = paramView;
              paramView = paramViewGroup;
              continue;
            }
          }
          else
          {
            if (i == 1)
            {
              localObject1 = localView;
              paramViewGroup = localLayoutInflater.inflate(2131165256, paramViewGroup, false);
              paramView = paramViewGroup;
              b(paramViewGroup, paramInt);
              paramView = paramViewGroup;
              continue;
            }
            if (i == 3)
            {
              localObject1 = localView;
              paramViewGroup = localLayoutInflater.inflate(2131165259, paramViewGroup, false);
              paramView = paramViewGroup;
              try
              {
                this.m = paramViewGroup;
                paramView = paramViewGroup;
              }
              catch (Exception paramViewGroup)
              {
                localObject1 = paramView;
                paramView = paramViewGroup;
                continue;
              }
            }
            else
            {
              if (i == 2)
              {
                localObject1 = localView;
                paramViewGroup = localLayoutInflater.inflate(2131165257, paramViewGroup, false);
                paramView = paramViewGroup;
                this.m = paramViewGroup;
                paramView = paramViewGroup;
                try
                {
                  if (!TextUtils.isEmpty(this.k.getText().toString().trim())) {
                    continue;
                  }
                  this.m.setVisibility(8);
                  paramView = paramViewGroup;
                }
                catch (Exception localException)
                {
                  paramView = paramViewGroup;
                  localException.printStackTrace();
                  paramView = paramViewGroup;
                  this.m.setVisibility(8);
                  paramView = paramViewGroup;
                }
                continue;
              }
              if (i == 4)
              {
                localObject2 = localView;
                paramView = localLayoutInflater.inflate(2131165255, paramViewGroup, false);
                continue;
              }
              if (i == 5)
              {
                localObject2 = localView;
                paramViewGroup = localLayoutInflater.inflate(2131165253, paramViewGroup, false);
                paramView = paramViewGroup;
                a(paramViewGroup, paramInt);
                paramView = paramViewGroup;
                continue;
              }
              paramView = localView;
              if (i == 6)
              {
                localObject2 = localView;
                paramViewGroup = localLayoutInflater.inflate(2131165254, paramViewGroup, false);
                paramView = paramViewGroup;
                this.m = paramViewGroup;
                paramView = paramViewGroup;
                a(paramViewGroup, paramInt);
                paramView = paramViewGroup;
                continue;
              }
            }
          }
        }
        else if (i == 0)
        {
          localObject2 = localView;
          c(localView, paramInt);
          paramView = localView;
        }
        else if (i == 1)
        {
          localObject2 = localView;
          b(localView, paramInt);
          paramView = localView;
        }
        else if (i == 3)
        {
          localObject2 = localView;
          this.m = localView;
          paramView = localView;
        }
        else if (i == 2)
        {
          localObject2 = localView;
          this.m = localView;
          paramView = localView;
          try
          {
            if (!TextUtils.isEmpty(this.k.getText().toString().trim())) {
              continue;
            }
            this.m.setVisibility(8);
            paramView = localView;
          }
          catch (Exception paramView)
          {
            localObject2 = localView;
            paramView.printStackTrace();
            localObject2 = localView;
            this.m.setVisibility(8);
            paramView = localView;
          }
        }
        else if (i == 5)
        {
          localObject2 = localView;
          a(localView, paramInt);
          paramView = localView;
        }
        else
        {
          paramView = localView;
          if (i == 6)
          {
            localObject2 = localView;
            this.m = localView;
            localObject2 = localView;
            a(localView, paramInt);
            paramView = localView;
          }
        }
        localObject2 = paramView;
        paramView.setTag(Integer.valueOf(i));
        return paramView;
      }
      catch (Exception paramView)
      {
        Object localObject2;
        APLog.e("getView", paramView.toString());
        ((View)localObject2).setTag(Integer.valueOf(-1));
        return localObject2;
      }
      label648:
      View localView = null;
    }
  }
  
  public boolean b(int paramInt)
  {
    return paramInt < this.g.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.hj
 * JD-Core Version:    0.7.0.1
 */