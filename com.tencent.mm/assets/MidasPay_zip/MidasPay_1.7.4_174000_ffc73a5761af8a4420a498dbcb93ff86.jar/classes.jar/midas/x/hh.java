package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.common.APGridView;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class hh
  extends hg
{
  public static NumberFormat m = ;
  private View n = null;
  private TextWatcher o = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      Object localObject = (LinearLayout)hh.b(hh.this).findViewById(2131099860);
      TextView localTextView = (TextView)hh.b(hh.this).findViewById(2131099985);
      int i;
      if (paramAnonymousEditable.toString().length() > 0)
      {
        hh.this.j.setVisibility(0);
        if (paramAnonymousEditable.toString().equals("0"))
        {
          hh.this.k.setText("");
          ((LinearLayout)localObject).setVisibility(8);
          break label272;
        }
        hh.b(hh.this).setVisibility(0);
        ((LinearLayout)localObject).setVisibility(0);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(hh.this.f.getString(2131230879));
        ((StringBuilder)localObject).append(em.b().n().b.b(paramAnonymousEditable.toString().trim()));
        localTextView.setText(((StringBuilder)localObject).toString());
        i = i.a(paramAnonymousEditable.toString());
        if ((hh.this.a <= 0) || (i <= hh.this.a)) {}
      }
      try
      {
        paramAnonymousEditable.delete(paramAnonymousEditable.length() - 1, paramAnonymousEditable.length());
        label216:
        APUICommonMethod.a(hh.this.f, "购买数量不能超过最大限制");
        i = paramAnonymousEditable.toString().length();
        if (i > 0)
        {
          hh.this.k.setSelection(i);
          break label272;
          hh.this.j.setVisibility(4);
          ((LinearLayout)localObject).setVisibility(8);
        }
        label272:
        if (hh.this.c.a.saveType == 0) {
          hh.a(hh.this, paramAnonymousEditable.toString());
        }
        return;
      }
      catch (Exception localException)
      {
        break label216;
      }
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  
  public hh(ScrollView paramScrollView, APGridView paramAPGridView, Activity paramActivity, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    this.e = paramScrollView;
    this.d = paramAPGridView;
    this.f = paramActivity;
    this.g = paramArrayOfString1;
    this.h = paramArrayOfString2;
    this.i = paramArrayOfString3;
    this.c = em.b().n();
    this.l = this.c.a.extendInfo.isShowListOtherNum;
    if (fy.a().ae() > 0) {
      this.a = fy.a().ae();
    } else {
      this.a = 9999999;
    }
    this.b = 1;
  }
  
  private void a(View paramView, int paramInt)
  {
    Object localObject1 = (ImageView)paramView.findViewById(2131099776);
    TextView localTextView2 = (TextView)paramView.findViewById(2131099779);
    TextView localTextView1 = (TextView)paramView.findViewById(2131099781);
    Object localObject3 = (TextView)paramView.findViewById(2131099977);
    Object localObject4 = (TextView)paramView.findViewById(2131099978);
    Object localObject6 = (TextView)paramView.findViewById(2131099980);
    TextView localTextView3 = (TextView)paramView.findViewById(2131099784);
    Object localObject2 = (TextView)paramView.findViewById(2131099778);
    boolean bool1 = ac.a().c();
    boolean bool2 = ac.a().d();
    if (bool1)
    {
      paramView = ac.a().a(paramInt);
      if ((paramView != null) && (paramView.a > 0))
      {
        int i = paramView.a;
        paramView = String.valueOf(i);
        if (ac.a().d())
        {
          ArrayList localArrayList = ac.a().h(i);
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            ((TextView)localObject3).setText("首充");
            ((TextView)localObject3).setVisibility(0);
          }
          else
          {
            ((TextView)localObject3).setVisibility(8);
          }
        }
        else
        {
          ((TextView)localObject3).setVisibility(8);
        }
        localObject3 = ac.a().a(paramInt);
        if ((localObject3 != null) && (!TextUtils.isEmpty(((y)localObject3).c)))
        {
          ((TextView)localObject6).setText(((y)localObject3).c);
          ((TextView)localObject6).setVisibility(0);
          paramInt = 1;
        }
        else
        {
          ((TextView)localObject6).setVisibility(8);
          paramInt = 0;
        }
        if (ac.a().c())
        {
          localObject3 = ac.a().e(i);
          if (paramInt == 0)
          {
            if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
            {
              ((TextView)localObject4).setText("满赠");
              ((TextView)localObject4).setVisibility(0);
            }
            else
            {
              ((TextView)localObject4).setVisibility(8);
            }
          }
          else {
            ((TextView)localObject4).setVisibility(8);
          }
        }
        else
        {
          ((TextView)localObject4).setVisibility(8);
        }
        localObject4 = ac.a().j(i);
        if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
        {
          localObject3 = new StringBuffer();
          localObject4 = ((ArrayList)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject6 = (v)((Iterator)localObject4).next();
            ((StringBuffer)localObject3).append(((v)localObject6).a);
            ((StringBuffer)localObject3).append("×");
            ((StringBuffer)localObject3).append(((v)localObject6).b);
            ((StringBuffer)localObject3).append(",");
          }
          if (((StringBuffer)localObject3).length() > 0)
          {
            ((TextView)localObject2).setText(((StringBuffer)localObject3).substring(0, ((StringBuffer)localObject3).length() - 1).toString());
            ((TextView)localObject2).setVisibility(0);
          }
          else
          {
            ((TextView)localObject2).setText("");
            ((TextView)localObject2).setVisibility(8);
          }
        }
        else
        {
          ((TextView)localObject2).setText("");
          ((TextView)localObject2).setVisibility(8);
        }
        paramInt = ac.a().i(i);
        if (paramInt > 0)
        {
          localTextView3.setVisibility(0);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("+");
          ((StringBuilder)localObject2).append(paramInt);
          localTextView3.setText(((StringBuilder)localObject2).toString());
        }
        else
        {
          localTextView3.setVisibility(8);
        }
      }
      else
      {
        ((TextView)localObject3).setVisibility(8);
        ((TextView)localObject4).setVisibility(8);
        ((TextView)localObject6).setVisibility(8);
        localTextView3.setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
        paramView = "0";
      }
    }
    else
    {
      Object localObject5;
      if ((!bool1) && (bool2))
      {
        paramView = this.g[paramInt];
        try
        {
          float f = Float.parseFloat(m.parse(paramView).toString());
          paramInt = (int)f;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          paramInt = 0;
        }
        localObject5 = ac.a().h(paramInt);
        if ((localObject5 != null) && (((ArrayList)localObject5).size() > 0))
        {
          ((TextView)localObject3).setText("首充");
          ((TextView)localObject3).setVisibility(0);
        }
        else
        {
          ((TextView)localObject3).setVisibility(8);
        }
        localObject5 = ac.a().g(paramInt);
        if ((localObject5 != null) && (((ArrayList)localObject5).size() > 0))
        {
          localObject3 = new StringBuffer();
          localObject5 = ((ArrayList)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (v)((Iterator)localObject5).next();
            ((StringBuffer)localObject3).append(((v)localObject6).a);
            ((StringBuffer)localObject3).append("×");
            ((StringBuffer)localObject3).append(((v)localObject6).b);
            ((StringBuffer)localObject3).append(",");
          }
          if (((StringBuffer)localObject3).length() > 0)
          {
            ((TextView)localObject2).setText(((StringBuffer)localObject3).substring(0, ((StringBuffer)localObject3).length() - 1).toString());
            ((TextView)localObject2).setVisibility(0);
          }
          else
          {
            ((TextView)localObject2).setText("");
            ((TextView)localObject2).setVisibility(8);
          }
        }
        else
        {
          ((TextView)localObject2).setText("");
          ((TextView)localObject2).setVisibility(8);
        }
        paramInt = ac.a().f(paramInt);
        if (paramInt > 0)
        {
          localTextView3.setVisibility(0);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("+");
          ((StringBuilder)localObject2).append(paramInt);
          localTextView3.setText(((StringBuilder)localObject2).toString());
        }
        else
        {
          localTextView3.setVisibility(8);
        }
      }
      else
      {
        ((TextView)localObject3).setVisibility(8);
        ((TextView)localObject5).setVisibility(8);
        ((TextView)localObject6).setVisibility(8);
        localTextView3.setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
        paramView = this.g[paramInt];
      }
    }
    if ((em.b().n().a.resId == 0) && (em.b().n().a.resData == null))
    {
      ((ImageView)localObject1).setVisibility(8);
      localObject1 = paramView;
    }
    else
    {
      APUICommonMethod.a((ImageView)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("× ");
      ((StringBuilder)localObject1).append(paramView);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localTextView2.setText((CharSequence)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.f.getString(2131230879));
    ((StringBuilder)localObject1).append(em.b().n().b.b(paramView));
    localTextView1.setText(((StringBuilder)localObject1).toString());
  }
  
  private void a(String paramString)
  {
    if (this.n == null) {
      return;
    }
    Object localObject2 = (LinearLayout)this.n.findViewById(2131099771);
    LinearLayout localLinearLayout = (LinearLayout)this.n.findViewById(2131099983);
    if (TextUtils.isEmpty(paramString))
    {
      ((LinearLayout)localObject2).setVisibility(8);
      localLinearLayout.setVisibility(8);
      return;
    }
    int i1 = i.a(paramString);
    int k = 0;
    ((LinearLayout)localObject2).setVisibility(0);
    localLinearLayout.setVisibility(0);
    Object localObject3 = (TextView)this.n.findViewById(2131099987);
    ((TextView)localObject3).setText("优惠活动:");
    Object localObject4 = (TextView)this.n.findViewById(2131099977);
    TextView localTextView2 = (TextView)this.n.findViewById(2131099978);
    TextView localTextView3 = (TextView)this.n.findViewById(2131099980);
    TextView localTextView1 = (TextView)this.n.findViewById(2131099982);
    boolean bool = ac.a().d();
    Object localObject1 = null;
    if (bool)
    {
      paramString = ac.a().h(i1);
      if ((paramString != null) && (paramString.size() > 0))
      {
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject4).setText("首充");
        ((TextView)localObject4).setVisibility(0);
        i = 1;
        break label242;
      }
      ((TextView)localObject4).setVisibility(8);
    }
    else
    {
      ((TextView)localObject4).setVisibility(8);
      paramString = null;
    }
    int i = 0;
    label242:
    localObject4 = ac.a().b(i1);
    int j;
    if ((localObject4 != null) && (!TextUtils.isEmpty(((y)localObject4).c)))
    {
      ((TextView)localObject3).setVisibility(0);
      localTextView3.setText(((y)localObject4).c);
      localTextView3.setVisibility(0);
      j = 1;
      i = 1;
    }
    else
    {
      localTextView3.setVisibility(8);
      j = 0;
    }
    if (ac.a().c())
    {
      localObject1 = ac.a().e(i1);
      if (j == 0)
      {
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          ((TextView)localObject3).setVisibility(0);
          localTextView2.setText("满赠");
          localTextView2.setVisibility(0);
          i = 1;
        }
        else
        {
          localTextView2.setVisibility(8);
        }
      }
      else {
        localTextView2.setVisibility(8);
      }
    }
    else
    {
      localTextView2.setVisibility(8);
    }
    if (i == 0) {
      ((LinearLayout)localObject2).setVisibility(8);
    }
    localObject2 = (TextView)this.n.findViewById(2131100035);
    ((TextView)localObject2).setText("赠送物品:");
    localObject1 = ac.a().a(paramString, (ArrayList)localObject1);
    i = k;
    if (localObject1 != null)
    {
      i = k;
      if (((ArrayList)localObject1).size() > 0)
      {
        paramString = new StringBuffer();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (v)((Iterator)localObject1).next();
          paramString.append(((v)localObject3).a);
          paramString.append("×");
          paramString.append(((v)localObject3).b);
          paramString.append(",");
        }
        i = k;
        if (paramString.length() > 0)
        {
          localTextView1.setText(paramString.substring(0, paramString.length() - 1).toString());
          ((TextView)localObject2).setVisibility(0);
          i = 1;
        }
      }
    }
    if (i == 0) {
      localLinearLayout.setVisibility(8);
    }
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
    this.k.setFilters(new InputFilter[] { new InputFilter.LengthFilter(7) });
    this.k.addTextChangedListener(this.o);
    if (this.f.getResources().getConfiguration().orientation == 1) {
      this.k.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          hh.this.e.postDelayed(new Runnable()
          {
            public void run()
            {
              hh.this.e.fullScroll(130);
              hh.this.k.requestFocus();
            }
          }, 500L);
          return false;
        }
      });
    }
    this.k.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 6)
        {
          ((InputMethodManager)paramAnonymousTextView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousTextView.getWindowToken(), 0);
          hh.a(hh.this);
          return true;
        }
        return false;
      }
    });
    this.j.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = hh.this.k.getText().toString();
        if (!TextUtils.isEmpty(paramAnonymousView))
        {
          hh.this.c.e.g = paramAnonymousView;
          if (hh.this.c.e.g == null) {
            paramAnonymousView = "";
          } else {
            paramAnonymousView = hh.this.c.e.g;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("a");
          localStringBuilder.append(paramAnonymousView);
          paramAnonymousView = localStringBuilder.toString();
          APDataReportManager.getInstance().insertData("sdk.gamelist.else", hh.this.c.a.saveType, null, paramAnonymousView, null);
        }
        hh.a(hh.this);
      }
    });
  }
  
  public int a()
  {
    if (ac.a().c())
    {
      if (!this.l) {
        return ac.a().b();
      }
      if (this.d.getNumColumns() != 1) {
        return ac.a().b() + 3;
      }
      return ac.a().b() + 2;
    }
    if (!this.l) {
      return this.g.length;
    }
    if (this.d.getNumColumns() != 1) {
      return this.g.length + 3;
    }
    return this.g.length + 2;
  }
  
  public int a(int paramInt)
  {
    if (!this.l) {
      return 0;
    }
    if (this.d.getNumColumns() != 1)
    {
      if (paramInt == a() - 1) {
        return 2;
      }
      if (paramInt == a() - 2) {
        return 4;
      }
      if (paramInt == a() - 3) {
        return 1;
      }
      return 0;
    }
    if (paramInt == a() - 1) {
      return 2;
    }
    if (paramInt == a() - 2) {
      return 1;
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
                break label493;
              }
              localView = paramView;
              if (j != i) {
                break label493;
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
              a(paramViewGroup, paramInt);
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
            if (i == 4)
            {
              localObject1 = localView;
              paramViewGroup = localLayoutInflater.inflate(2131165255, paramViewGroup, false);
              paramView = paramViewGroup;
              try
              {
                paramViewGroup.setVisibility(8);
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
              paramView = localView;
              if (i == 2)
              {
                localObject1 = localView;
                paramViewGroup = localLayoutInflater.inflate(2131165257, paramViewGroup, false);
                paramView = paramViewGroup;
                this.n = paramViewGroup;
                paramView = paramViewGroup;
                try
                {
                  if (!TextUtils.isEmpty(this.k.getText().toString().trim())) {
                    continue;
                  }
                  this.n.setVisibility(8);
                  paramView = paramViewGroup;
                }
                catch (Exception localException)
                {
                  paramView = paramViewGroup;
                  localException.printStackTrace();
                  paramView = paramViewGroup;
                  this.n.setVisibility(8);
                  paramView = paramViewGroup;
                }
                continue;
              }
            }
          }
        }
        else if (i == 0)
        {
          localObject2 = localView;
          a(localView, paramInt);
          paramView = localView;
        }
        else if (i == 1)
        {
          localObject2 = localView;
          b(localView, paramInt);
          paramView = localView;
        }
        else if (i == 4)
        {
          localObject2 = localView;
          localView.setVisibility(8);
          paramView = localView;
        }
        else
        {
          paramView = localView;
          if (i == 2)
          {
            localObject2 = localView;
            this.n = localView;
            paramView = localView;
            try
            {
              if (TextUtils.isEmpty(this.k.getText().toString().trim()))
              {
                this.n.setVisibility(8);
                paramView = localView;
              }
            }
            catch (Exception paramView)
            {
              localObject2 = localView;
              paramView.printStackTrace();
              localObject2 = localView;
              this.n.setVisibility(8);
              paramView = localView;
            }
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
      label493:
      View localView = null;
    }
  }
  
  public boolean b(int paramInt)
  {
    if (ac.a().c()) {
      return paramInt < ac.a().b();
    }
    return paramInt < this.g.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.hh
 * JD-Core Version:    0.7.0.1
 */