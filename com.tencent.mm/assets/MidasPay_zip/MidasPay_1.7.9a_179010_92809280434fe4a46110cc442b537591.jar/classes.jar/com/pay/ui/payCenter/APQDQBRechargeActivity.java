package com.pay.ui.payCenter;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import midas.x.a;
import midas.x.a5;
import midas.x.b5;
import midas.x.c5;
import midas.x.c6;
import midas.x.d5;
import midas.x.e5;
import midas.x.o4;
import midas.x.p4;
import midas.x.r6;
import midas.x.u4;
import midas.x.w4;
import midas.x.z5;

public class APQDQBRechargeActivity
  extends APActivity
{
  public int d = -1;
  public EditText e;
  public TextView f;
  public TextWatcher g = new a();
  
  public final boolean f()
  {
    return !TextUtils.isEmpty(this.e.getText().toString().trim());
  }
  
  public void g()
  {
    p4.p().e().f.f = this.e.getText().toString().trim();
    e();
    e5.h().a(this, "", null);
  }
  
  public final int h()
  {
    int i = p4.p().e().c.b();
    int j = p4.p().e().e.g;
    if (i % 100 == 0) {
      i /= 100;
    } else {
      i = i / 100 + 1;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    return j;
  }
  
  public final int i()
  {
    int i = p4.p().e().c.b();
    int j = p4.p().e().e.g;
    if (i % 10 == 0) {
      i /= 10;
    } else {
      i = i / 10 + 1;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    return j;
  }
  
  public final void j()
  {
    Object localObject1 = (TextView)findViewById(2131100013);
    ((TextView)localObject1).setText(p4.p().e().e.i);
    Object localObject2 = p4.p().e().e.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQ号：");
    localStringBuilder.append((String)localObject2);
    ((TextView)localObject1).setText(localStringBuilder.toString());
    localObject2 = (TextView)findViewById(2131099803);
    if (this.d == 3)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("余额：");
      ((StringBuilder)localObject1).append(p4.p().e().e.b());
      ((StringBuilder)localObject1).append(" Q币");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("余额：");
      ((StringBuilder)localObject1).append(p4.p().e().e.c());
      ((StringBuilder)localObject1).append(" Q点");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    ((TextView)localObject2).setText((CharSequence)localObject1);
    localObject1 = (TextView)findViewById(2131099951);
    if (this.d == 3) {
      ((TextView)localObject1).setText("Q币充值");
    } else {
      ((TextView)localObject1).setText("Q点充值");
    }
    localObject1 = p4.p().e().f.f;
    this.e = ((EditText)findViewById(2131099963));
    this.e.setText((CharSequence)localObject1);
    this.e.setSelection(((String)localObject1).length());
    this.e.setFilters(new InputFilter[] { new InputFilter.LengthFilter(8) });
    this.e.addTextChangedListener(this.g);
    this.e.setOnTouchListener(new b());
    this.f = ((TextView)findViewById(2131099851));
    this.f.setText(p4.p().e().c.b((String)localObject1));
    ((Button)findViewById(2131099962)).setOnClickListener(new c());
    ((ImageView)findViewById(2131099702)).setOnClickListener(new d());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((c6.s0().i()) && (a.r().d != null))
    {
      setContentView(2131165244);
      a.r().f = true;
      c6.s0().n(true);
      APHFChannel.j();
      try
      {
        o4 localo41 = p4.p().e();
        o4 localo42 = (o4)localo41.clone();
        String str1;
        String str2;
        if (r6.j().c() == 11)
        {
          this.d = 3;
          paramBundle = String.valueOf(h());
          str1 = String.valueOf(h());
          str2 = "Q币";
          localo42.c = new a5();
          localo42.d = new u4();
          localo42.c.c = "100";
        }
        else
        {
          this.d = 2;
          paramBundle = String.valueOf(i());
          str1 = String.valueOf(i());
          str2 = "Q点";
          localo42.c = new b5();
          localo42.d = new u4();
          localo42.c.c = "10";
        }
        localo42.b.saveType = this.d;
        localo42.b.saveValue = paramBundle;
        localo42.f.f = str1;
        localo42.c.b = str2;
        localo42.c.a = localo41.c.a;
        p4.p().a(localo42);
      }
      catch (CloneNotSupportedException paramBundle)
      {
        paramBundle.printStackTrace();
      }
      j();
      return;
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      APDataReportManager.getInstance().insertData("sdk.accountinput.keyback", this.d, p4.p().e().f.k, null, null);
      p4.p().n();
      finish();
      APUICommonMethod.f();
      z5.a(2, "");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    APDataReportManager.getInstance().insertData("sdk.accountinput.show", this.d, p4.p().e().f.k, null, null);
    super.onResume();
  }
  
  public void onStop()
  {
    e();
    APUICommonMethod.b();
    super.onStop();
  }
  
  public class a
    implements TextWatcher
  {
    public a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      String str = paramEditable.toString().trim();
      paramEditable = new StringBuilder();
      paramEditable.append("afterTextChanged num:");
      paramEditable.append(str);
      APLog.i("APQDQBRecharge", paramEditable.toString());
      if (str.toString().equals("0")) {
        APQDQBRechargeActivity.a(APQDQBRechargeActivity.this).setText("");
      }
      paramEditable = str;
      if (TextUtils.isEmpty(str)) {
        paramEditable = "0";
      }
      try
      {
        APQDQBRechargeActivity.b(APQDQBRechargeActivity.this).setText(p4.p().e().c.b(paramEditable));
        return;
      }
      catch (Exception paramEditable)
      {
        paramEditable.printStackTrace();
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public class b
    implements View.OnTouchListener
  {
    public b() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      APQDQBRechargeActivity.a(APQDQBRechargeActivity.this).setCursorVisible(true);
      return false;
    }
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      paramView = APQDQBRechargeActivity.a(APQDQBRechargeActivity.this).getText().toString().trim();
      if (APQDQBRechargeActivity.c(APQDQBRechargeActivity.this))
      {
        APDataReportManager.getInstance().insertData("sdk.accountinput.sure", APQDQBRechargeActivity.this.d, p4.p().e().f.k, paramView, null);
        APQDQBRechargeActivity.this.g();
      }
    }
  }
  
  public class d
    implements View.OnClickListener
  {
    public d() {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.accountinput.close", APQDQBRechargeActivity.this.d, p4.p().e().f.k, null, null);
      p4.p().n();
      APQDQBRechargeActivity.this.finish();
      APUICommonMethod.f();
      z5.a(2, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.payCenter.APQDQBRechargeActivity
 * JD-Core Version:    0.7.0.1
 */