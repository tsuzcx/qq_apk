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
import android.widget.GridView;
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

public class n7
  extends k7
{
  public View l = null;
  public boolean m = false;
  public TextWatcher n = new a();
  
  public n7(ScrollView paramScrollView, APGridView paramAPGridView, Activity paramActivity, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    this.d = paramScrollView;
    this.c = paramAPGridView;
    this.e = paramActivity;
    this.f = paramArrayOfString1;
    this.g = paramArrayOfString2;
    this.h = paramArrayOfString3;
    this.b = p4.p().e();
    this.k = this.b.b.extendInfo.isShowListOtherNum;
    this.a = 9999999;
  }
  
  public int a()
  {
    if (this.c.getNumColumns() != 1)
    {
      if (this.f.length % 2 == 0)
      {
        if ((this.k) && (g6.k().e() != g6.a.a)) {
          return this.f.length + 4;
        }
        return this.f.length + 2;
      }
      if ((this.k) && (g6.k().e() != g6.a.a)) {
        return this.f.length + 3;
      }
      return this.f.length + 3;
    }
    if ((this.k) && (g6.k().e() != g6.a.a)) {
      return this.f.length + 3;
    }
    return this.f.length + 1;
  }
  
  public int a(int paramInt)
  {
    if (this.c.getNumColumns() != 1)
    {
      if ((this.k) && (g6.k().e() != g6.a.a))
      {
        if (this.f.length % 2 == 0)
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
      if (this.f.length % 2 == 0)
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
    if ((this.k) && (g6.k().e() != g6.a.a))
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
        LayoutInflater localLayoutInflater = LayoutInflater.from(this.e);
        localObject1 = paramView;
        int i = a(paramInt);
        localView = paramView;
        if (paramView != null)
        {
          localObject1 = paramView;
          Object localObject2 = paramView.getTag();
          localView = paramView;
          if (localObject2 != null)
          {
            localView = paramView;
            localObject1 = paramView;
            if ((localObject2 instanceof Integer))
            {
              localObject1 = paramView;
              int j = ((Integer)localObject2).intValue();
              if (j == -1) {
                break label619;
              }
              localView = paramView;
              if (j != i) {
                break label619;
              }
            }
          }
        }
        if (localView == null)
        {
          if (i == 0)
          {
            localObject1 = localView;
            paramView = localLayoutInflater.inflate(2131165252, paramViewGroup, false);
            localObject1 = paramView;
            b(paramView, paramInt);
          }
          else if (i == 1)
          {
            localObject1 = localView;
            paramView = localLayoutInflater.inflate(2131165256, paramViewGroup, false);
            localObject1 = paramView;
            c(paramView, paramInt);
          }
          else if (i == 3)
          {
            localObject1 = localView;
            paramView = localLayoutInflater.inflate(2131165259, paramViewGroup, false);
            localObject1 = paramView;
            this.l = paramView;
          }
          else if (i == 2)
          {
            localObject1 = localView;
            paramViewGroup = localLayoutInflater.inflate(2131165257, paramViewGroup, false);
            localObject1 = paramViewGroup;
            this.l = paramViewGroup;
            paramView = paramViewGroup;
            try
            {
              if (!TextUtils.isEmpty(this.j.getText().toString().trim())) {
                continue;
              }
              this.l.setVisibility(8);
              paramView = paramViewGroup;
            }
            catch (Exception paramView)
            {
              localObject1 = paramViewGroup;
              paramView.printStackTrace();
              localObject1 = paramViewGroup;
              this.l.setVisibility(8);
              paramView = paramViewGroup;
            }
          }
          else if (i == 4)
          {
            localObject1 = localView;
            paramView = localLayoutInflater.inflate(2131165255, paramViewGroup, false);
          }
          else if (i == 5)
          {
            localObject1 = localView;
            paramView = localLayoutInflater.inflate(2131165253, paramViewGroup, false);
            localObject1 = paramView;
            a(paramView, paramInt);
          }
          else
          {
            paramView = localView;
            if (i == 6)
            {
              localObject1 = localView;
              paramView = localLayoutInflater.inflate(2131165254, paramViewGroup, false);
              localObject1 = paramView;
              this.l = paramView;
              localObject1 = paramView;
              a(paramView, paramInt);
            }
          }
        }
        else if (i == 0)
        {
          localObject1 = localView;
          b(localView, paramInt);
          paramView = localView;
        }
        else if (i == 1)
        {
          localObject1 = localView;
          c(localView, paramInt);
          paramView = localView;
        }
        else if (i == 3)
        {
          localObject1 = localView;
          this.l = localView;
          paramView = localView;
        }
        else if (i == 2)
        {
          localObject1 = localView;
          this.l = localView;
          paramView = localView;
          try
          {
            if (!TextUtils.isEmpty(this.j.getText().toString().trim())) {
              continue;
            }
            this.l.setVisibility(8);
            paramView = localView;
          }
          catch (Exception paramView)
          {
            localObject1 = localView;
            paramView.printStackTrace();
            localObject1 = localView;
            this.l.setVisibility(8);
            paramView = localView;
          }
        }
        else if (i == 5)
        {
          localObject1 = localView;
          a(localView, paramInt);
          paramView = localView;
        }
        else
        {
          paramView = localView;
          if (i == 6)
          {
            localObject1 = localView;
            this.l = localView;
            localObject1 = localView;
            a(localView, paramInt);
            paramView = localView;
          }
        }
        localObject1 = paramView;
        paramView.setTag(Integer.valueOf(i));
        return paramView;
      }
      catch (Exception paramView)
      {
        APLog.e("getView", paramView.toString());
        ((View)localObject1).setTag(Integer.valueOf(-1));
        return localObject1;
      }
      label619:
      View localView = null;
    }
  }
  
  public final void a(final View paramView, int paramInt)
  {
    label272:
    try
    {
      if (this.b.b.saveType != 5) {
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
      break label272;
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
    paramView = new x6(this.e, localCheckBox);
    if (((APMonthRequest)this.b.b).autoPay)
    {
      localCheckBox.setChecked(true);
      ((z4)this.b.c).n = "1";
      APDataReportManager.getInstance().insertData("sdk.gamelist.auto", this.b.b.saveType, null, "able", null);
      this.m = true;
      paramView.a(1000, 3000, false, false);
    }
    else
    {
      ((z4)this.b.c).n = "0";
      APDataReportManager.getInstance().insertData("sdk.gamelist.auto", this.b.b.saveType, null, "disable", null);
    }
    localCheckBox.setOnCheckedChangeListener(new b(paramView));
    return;
    APLog.i("APPayListValueAdapter", "monthAutoItem crash");
  }
  
  public final void b()
  {
    if (APTools.m()) {
      return;
    }
    Object localObject1 = this.j.getText().toString();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = this.b.f;
      ((d5)localObject2).f = ((String)localObject1);
      localObject2 = ((d5)localObject2).f;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("a");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      APDataReportManager.getInstance().insertData("sdk.gamelist.click", this.b.b.saveType, null, (String)localObject1, null);
      e5.h().a(this.e, "", null);
      return;
    }
    Toast.makeText(this.e, "充值数量不能为空", 1).show();
  }
  
  public final void b(View paramView, int paramInt)
  {
    Object localObject2 = (ImageView)paramView.findViewById(2131099776);
    Object localObject1 = (TextView)paramView.findViewById(2131099779);
    paramView = (TextView)paramView.findViewById(2131099781);
    if ((p4.p().e().b.resId == 0) && (p4.p().e().b.resData == null)) {
      ((ImageView)localObject2).setVisibility(8);
    } else {
      APUICommonMethod.a((ImageView)localObject2);
    }
    if (g6.k().e() == g6.a.a)
    {
      localObject2 = z5.a(Float.valueOf(APTools.j(this.g[paramInt])).floatValue());
      ((TextView)localObject1).setText(this.h[paramInt]);
      if (localObject2.length > 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.e.getString(2131230879));
        ((StringBuilder)localObject1).append(localObject2[0]);
        ((StringBuilder)localObject1).append(".");
        ((StringBuilder)localObject1).append(localObject2[1]);
        paramView.setText(((StringBuilder)localObject1).toString());
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.e.getString(2131230879));
      ((StringBuilder)localObject1).append(localObject2[0]);
      paramView.setText(((StringBuilder)localObject1).toString());
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((APSubscribeRequest)this.b.b).serviceName);
    ((StringBuilder)localObject2).append(" × ");
    ((StringBuilder)localObject2).append(this.f[paramInt]);
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.e.getString(2131230879));
    ((StringBuilder)localObject1).append(this.b.c.b(this.f[paramInt]));
    paramView.setText(((StringBuilder)localObject1).toString());
  }
  
  public boolean b(int paramInt)
  {
    return paramInt < this.f.length;
  }
  
  public final void c(View paramView, int paramInt)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131099776);
    if ((p4.p().e().b.resId == 0) && (p4.p().e().b.resData == null)) {
      localImageView.setVisibility(8);
    } else {
      APUICommonMethod.a(localImageView);
    }
    this.j = ((EditText)paramView.findViewById(2131099780));
    this.i = ((Button)paramView.findViewById(2131099782));
    if (TextUtils.isEmpty(this.j.getText().toString().trim())) {
      this.i.setVisibility(4);
    }
    this.i.setText("确定");
    this.j.setFilters(new InputFilter[] { new InputFilter.LengthFilter(3) });
    this.j.addTextChangedListener(this.n);
    this.j.setOnEditorActionListener(new c());
    if (this.e.getResources().getConfiguration().orientation == 1) {
      this.j.setOnTouchListener(new d());
    }
    this.i.setOnClickListener(new e());
  }
  
  public class a
    implements TextWatcher
  {
    public a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      Object localObject2 = (LinearLayout)n7.a(n7.this).findViewById(2131099860);
      Object localObject1 = (TextView)n7.a(n7.this).findViewById(2131099985);
      if (paramEditable.toString().length() > 0)
      {
        n7.this.i.setVisibility(0);
        if (paramEditable.toString().equals("0"))
        {
          n7.this.j.setText("");
          ((LinearLayout)localObject2).setVisibility(8);
          return;
        }
        n7.a(n7.this).setVisibility(0);
        ((LinearLayout)localObject2).setVisibility(0);
      }
      try
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(n7.this.e.getString(2131230879));
        ((StringBuilder)localObject2).append(p4.p().e().c.b(paramEditable.toString().trim()));
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      }
      catch (Exception localException)
      {
        label167:
        int i;
        break label167;
      }
      i = i.b(paramEditable.toString());
      localObject1 = n7.this;
      if (i > ((k7)localObject1).a)
      {
        localObject2 = ((k7)localObject1).b;
        if (((o4)localObject2).b.saveType == 4)
        {
          if (((z4)((o4)localObject2).c).l == 3)
          {
            paramEditable = ((k7)localObject1).e;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("升级时长最多不超过");
            ((StringBuilder)localObject1).append(n7.this.a);
            ((StringBuilder)localObject1).append("个月");
            APUICommonMethod.a(paramEditable, ((StringBuilder)localObject1).toString());
            paramEditable = n7.this;
            paramEditable.j.setText(String.valueOf(paramEditable.a));
            return;
          }
          APUICommonMethod.a(((k7)localObject1).e, "购买数量不能超过最大限制");
        }
        else
        {
          APUICommonMethod.a(((k7)localObject1).e, "购买数量不能超过最大限制");
        }
      }
      i = paramEditable.toString().length();
      if (i > 0)
      {
        n7.this.j.setSelection(i);
        return;
        n7.this.i.setVisibility(4);
        ((LinearLayout)localObject2).setVisibility(8);
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public class b
    implements CompoundButton.OnCheckedChangeListener
  {
    public b(x6 paramx6) {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        paramCompoundButton = n7.this;
        ((z4)paramCompoundButton.b.c).n = "1";
        if (!n7.b(paramCompoundButton))
        {
          n7.a(n7.this, true);
          paramView.a(0, 3000, false, false);
        }
      }
      else
      {
        ((z4)n7.this.b.c).n = "0";
        paramView.a();
      }
      if (paramBoolean) {
        paramCompoundButton = "able";
      } else {
        paramCompoundButton = "disable";
      }
      APDataReportManager.getInstance().insertData("sdk.gamelist.auto", n7.this.b.b.saveType, null, paramCompoundButton, null);
    }
  }
  
  public class c
    implements TextView.OnEditorActionListener
  {
    public c() {}
    
    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 6)
      {
        ((InputMethodManager)paramTextView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramTextView.getWindowToken(), 0);
        n7.c(n7.this);
        return true;
      }
      return false;
    }
  }
  
  public class d
    implements View.OnTouchListener
  {
    public d() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      n7.this.d.postDelayed(new a(), 1000L);
      return false;
    }
    
    public class a
      implements Runnable
    {
      public a() {}
      
      public void run()
      {
        n7.this.d.scrollTo(0, 360);
        n7.this.j.requestFocus();
      }
    }
  }
  
  public class e
    implements View.OnClickListener
  {
    public e() {}
    
    public void onClick(View paramView)
    {
      paramView = n7.this.j.getText().toString();
      if (!TextUtils.isEmpty(paramView))
      {
        Object localObject = n7.this.b.f;
        ((d5)localObject).f = paramView;
        localObject = ((d5)localObject).f;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("a");
        ((StringBuilder)localObject).append(paramView);
        paramView = ((StringBuilder)localObject).toString();
        APDataReportManager.getInstance().insertData("sdk.gamelist.else", n7.this.b.b.saveType, null, paramView, null);
      }
      n7.c(n7.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.n7
 * JD-Core Version:    0.7.0.1
 */