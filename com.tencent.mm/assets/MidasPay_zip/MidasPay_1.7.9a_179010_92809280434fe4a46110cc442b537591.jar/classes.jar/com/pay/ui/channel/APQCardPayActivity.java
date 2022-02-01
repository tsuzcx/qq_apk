package com.pay.ui.channel;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.text.method.TransformationMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import midas.x.a;
import midas.x.a7;
import midas.x.c6;
import midas.x.d5;
import midas.x.e;
import midas.x.e5;
import midas.x.fc;
import midas.x.g5;
import midas.x.h5;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.r2;
import midas.x.w4;
import midas.x.x1;
import midas.x.z1;
import midas.x.z5;

public class APQCardPayActivity
  extends APActivity
  implements TextView.OnEditorActionListener
{
  public String A;
  public String B;
  public TextWatcher C = new g();
  public TextWatcher D = new h();
  public ImageButton d;
  public ImageButton e;
  public int f = 3;
  public int g = 4;
  public boolean h = false;
  public EditText i;
  public EditText j;
  public AP3PointsLoading k;
  public Button l;
  public LinearLayout m;
  public LinearLayout n;
  public ImageView o;
  public TextView p;
  public LinearLayout q;
  public ImageView r;
  public TextView s;
  public LinearLayout t;
  public ImageView u;
  public TextView v;
  public String w;
  public String x;
  public ImageView y;
  public EditText z;
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    LinearLayout localLinearLayout;
    ImageView localImageView;
    TextView localTextView;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          localLinearLayout = this.t;
          localImageView = this.u;
          localTextView = this.v;
        }
        else
        {
          localLinearLayout = this.t;
          localImageView = this.u;
          localTextView = this.v;
        }
      }
      else
      {
        localLinearLayout = this.q;
        localImageView = this.r;
        localTextView = this.s;
      }
    }
    else
    {
      localLinearLayout = this.n;
      localImageView = this.o;
      localTextView = this.p;
    }
    if (paramBoolean1)
    {
      localLinearLayout.setVisibility(0);
      if (paramString != null) {
        localTextView.setText(paramString);
      }
      if (paramBoolean2)
      {
        localImageView.setImageResource(2131034135);
        localTextView.setTextColor(getResources().getColor(2130903056));
        return;
      }
      localImageView.setImageResource(2131034150);
      localTextView.setTextColor(getResources().getColor(2130903073));
      return;
    }
    localLinearLayout.setVisibility(8);
  }
  
  public final void a(Bundle paramBundle)
  {
    this.h = true;
    this.z.setText("");
    this.A = paramBundle.getString("vc");
    this.B = paramBundle.getString("vs");
    if ((!this.A.equals("")) && (this.A.length() > 20))
    {
      if (this.A.length() % 2 != 0)
      {
        paramBundle = new StringBuilder();
        paramBundle.append(this.A);
        paramBundle.append("F");
        this.A = paramBundle.toString();
      }
      paramBundle = e.a(this.A);
      paramBundle = BitmapFactory.decodeByteArray(paramBundle, 0, paramBundle.length, null);
      this.y.setImageBitmap(paramBundle);
    }
    a(3, true, true, "请输入正确的验证码");
  }
  
  public final void a(Editable paramEditable, int paramInt)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    int i2 = paramEditable.length();
    int i1 = 0;
    while (i1 < i2)
    {
      char c = paramEditable.charAt(i1);
      if (c != '\n') {
        localStringBuffer1.append(c);
      }
      i1 += 1;
    }
    StringBuffer localStringBuffer2 = new StringBuffer();
    i1 = 0;
    while (i1 < localStringBuffer1.length())
    {
      if ((i1 > 0) && (i1 % paramInt == 0)) {
        localStringBuffer2.append('\n');
      }
      localStringBuffer2.append(localStringBuffer1.charAt(i1));
      i1 += 1;
    }
    if (!localStringBuffer2.toString().equals(paramEditable.toString())) {
      paramEditable.replace(0, i2, localStringBuffer2);
    }
  }
  
  public final void b(Bundle paramBundle)
  {
    this.h = true;
    APDataReportManager.getInstance().insertData("sdk.vc.show", this.a, p4.p().e().f.k, p4.p().e().f.e, null);
    ((LinearLayout)findViewById(2131100014)).setVisibility(0);
    this.A = paramBundle.getString("vc");
    this.B = paramBundle.getString("vs");
    this.z = ((EditText)findViewById(2131100021));
    this.z.setFilters(new InputFilter[] { new InputFilter.LengthFilter(4) });
    this.z.requestFocus();
    this.z.addTextChangedListener(new d());
    this.z.setOnEditorActionListener(this);
    this.y = ((ImageView)findViewById(2131100022));
    this.y.setOnClickListener(new e());
    if ((!this.A.equals("")) && (this.A.length() > 20))
    {
      if (this.A.length() % 2 != 0)
      {
        paramBundle = new StringBuilder();
        paramBundle.append(this.A);
        paramBundle.append("F");
        this.A = paramBundle.toString();
      }
      paramBundle = e.a(this.A);
      paramBundle = BitmapFactory.decodeByteArray(paramBundle, 0, paramBundle.length, null);
      this.y.setImageBitmap(paramBundle);
    }
  }
  
  public final void d(ob paramob)
  {
    paramob = (r2)paramob;
    if (paramob.d() == 0)
    {
      this.B = paramob.h();
      paramob = paramob.g();
      paramob = BitmapFactory.decodeByteArray(paramob, 0, paramob.length, null);
      this.y.setImageBitmap(paramob);
      return;
    }
    a(3, true, true, paramob.f());
  }
  
  public boolean f()
  {
    this.i = ((EditText)findViewById(2131099792));
    this.j = ((EditText)findViewById(2131099793));
    this.w = this.i.getText().toString().replace("\n", "").trim();
    this.x = this.j.getText().toString().replace("\n", "").trim();
    if (this.w.length() == 0)
    {
      a(2131099919);
      a(1, true, false, "请输入QQ卡卡号");
      return false;
    }
    if (this.w.length() < 9)
    {
      a(2131099919);
      a(1, true, true, "请输入正确的QQ卡卡号");
      return false;
    }
    if (this.x.length() == 0)
    {
      a(2131099950);
      a(2, true, false, "请输入QQ卡密码");
      return false;
    }
    if (this.x.length() < 12)
    {
      a(2131099950);
      a(2, true, true, "请输入正确的QQ卡密码");
      return false;
    }
    this.z = ((EditText)findViewById(2131100021));
    if ((this.h) && (this.z.getText().length() == 0)) {
      a(3, true, true, "请输入验证码");
    }
    return k();
  }
  
  public void g()
  {
    if (f())
    {
      i();
      a(3, false, false, null);
      this.m.setVisibility(8);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.k.getLayoutParams();
      localLayoutParams.height = this.m.getMeasuredHeight();
      this.k.setLayoutParams(localLayoutParams);
      this.k.setVisibility(0);
      this.k.c();
      com.pay.paychannel.qqcard.APQQCardChannel.p = this.w;
      com.pay.paychannel.qqcard.APQQCardChannel.q = this.x;
      if (this.h)
      {
        com.pay.paychannel.qqcard.APQQCardChannel.r = this.z.getText().toString().trim();
        com.pay.paychannel.qqcard.APQQCardChannel.s = this.B;
      }
      else
      {
        com.pay.paychannel.qqcard.APQQCardChannel.r = "";
        com.pay.paychannel.qqcard.APQQCardChannel.s = "";
      }
      APRecoChannelActivity.h = true;
      e5.h().a(this, "qqcard", new b(), new c());
    }
  }
  
  public final void h()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.k.getLayoutParams();
    localLayoutParams.height = this.m.getMeasuredHeight();
    this.m.setVisibility(8);
    this.k.setLayoutParams(localLayoutParams);
    this.k.setVisibility(0);
    this.k.c();
    z1.d().c("qqcard", new f());
  }
  
  public final void i()
  {
    StringBuilder localStringBuilder;
    try
    {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.i.getWindowToken(), 0);
    }
    catch (Exception localException1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doPay checkInput dismissNumInput:");
      localStringBuilder.append(localException1.toString());
      APLog.w("APQCardPayActivity", localStringBuilder.toString());
    }
    try
    {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.j.getWindowToken(), 0);
      return;
    }
    catch (Exception localException2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doPay checkInput dismissPwdInput:");
      localStringBuilder.append(localException2.toString());
      APLog.w("APQCardPayActivity", localStringBuilder.toString());
    }
  }
  
  public void j()
  {
    this.n = ((LinearLayout)findViewById(2131099917));
    this.o = ((ImageView)findViewById(2131099916));
    this.p = ((TextView)findViewById(2131099918));
    this.q = ((LinearLayout)findViewById(2131099923));
    this.r = ((ImageView)findViewById(2131099922));
    this.s = ((TextView)findViewById(2131099924));
    this.t = ((LinearLayout)findViewById(2131100018));
    this.u = ((ImageView)findViewById(2131100017));
    this.v = ((TextView)findViewById(2131100019));
    a(1, false, false, null);
    a(2, false, false, null);
    a(3, false, false, null);
    this.d = ((ImageButton)findViewById(2131099727));
    this.d.setOnClickListener(new i());
    this.e = ((ImageButton)findViewById(2131099728));
    this.e.setOnClickListener(new j());
    this.k = ((AP3PointsLoading)findViewById(2131099895));
    this.m = ((LinearLayout)findViewById(2131099805));
    Object localObject = (TextView)findViewById(2131099851);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("待支付金额：");
    localStringBuilder.append(getString(2131230879));
    localStringBuilder.append(p4.p().e().c.a());
    ((TextView)localObject).setText(localStringBuilder.toString());
    this.l = ((Button)findViewById(2131099726));
    this.l.setOnClickListener(new k());
    localObject = new a7();
    this.i = ((EditText)findViewById(2131099792));
    this.i.addTextChangedListener(this.C);
    this.i.setTransformationMethod((TransformationMethod)localObject);
    this.i.setOnTouchListener(new l());
    this.i.setOnFocusChangeListener(new m());
    this.j = ((EditText)findViewById(2131099793));
    this.j.addTextChangedListener(this.D);
    this.j.setOnEditorActionListener(this);
    this.j.setTransformationMethod((TransformationMethod)localObject);
    this.j.setOnTouchListener(new n());
    this.j.setOnFocusChangeListener(new o());
    if (getResources().getConfiguration().orientation == 2)
    {
      this.i.setFilters(new InputFilter[] { new InputFilter.LengthFilter(10) });
      this.j.setFilters(new InputFilter[] { new InputFilter.LengthFilter(12) });
    }
    else
    {
      this.i.setFilters(new InputFilter[] { new InputFilter.LengthFilter(13) });
      this.j.setFilters(new InputFilter[] { new InputFilter.LengthFilter(14) });
    }
    ((ImageButton)findViewById(2131099802)).setOnClickListener(new a());
    this.i.requestFocus();
  }
  
  public boolean k()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((c6.s0().i()) && (a.r().d != null))
    {
      setContentView(2131165246);
      j();
      return;
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramTextView = (InputMethodManager)getSystemService("input_method");
    if (paramInt != 0)
    {
      if (paramInt != 4)
      {
        if (paramInt == 6) {
          paramTextView.hideSoftInputFromWindow(this.j.getWindowToken(), 0);
        }
      }
      else {
        paramTextView.hideSoftInputFromWindow(this.j.getWindowToken(), 0);
      }
    }
    else {
      paramTextView.hideSoftInputFromWindow(this.j.getWindowToken(), 0);
    }
    return true;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (APRecoChannelActivity.f()) {
        return true;
      }
      if (this.h) {
        APDataReportManager.getInstance().insertData("sdk.vc.keyback", this.a, p4.p().e().f.k, String.valueOf(4), null);
      } else {
        APDataReportManager.getInstance().insertData("sdk.qcard.keyback", this.a, p4.p().e().f.k, String.valueOf(4), null);
      }
      APUICommonMethod.a(this);
      finish();
      overridePendingTransition(z5.a(this, "unipay_anim_in_from_left"), z5.a(this, "unipay_anim_out_to_right"));
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    APDataReportManager.getInstance().insertData("sdk.qcard.show", this.a, p4.p().e().f.k, String.valueOf(4), null);
    super.onResume();
    if (getResources().getConfiguration().orientation == 2)
    {
      getWindow().setSoftInputMode(3);
      return;
    }
    if (getResources().getConfiguration().orientation == 1)
    {
      EditText localEditText = this.i;
      if (localEditText != null) {
        a(localEditText, 100);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      if (APRecoChannelActivity.f()) {
        return;
      }
      APDataReportManager.getInstance().insertData("sdk.qcard.back", APQCardPayActivity.h(APQCardPayActivity.this), p4.p().e().f.k, String.valueOf(4), null);
      APQCardPayActivity.this.finish();
      APUICommonMethod.a(APQCardPayActivity.this);
    }
  }
  
  public class b
    implements h5
  {
    public b() {}
    
    public void a()
    {
      APRecoChannelActivity.h = false;
      APQCardPayActivity.i(APQCardPayActivity.this).d();
      APQCardPayActivity.j(APQCardPayActivity.this).setVisibility(0);
      APQCardPayActivity.i(APQCardPayActivity.this).setVisibility(8);
    }
    
    public void a(int paramInt)
    {
      APRecoChannelActivity.h = false;
      APQCardPayActivity.i(APQCardPayActivity.this).d();
      APQCardPayActivity.j(APQCardPayActivity.this).setVisibility(0);
      APQCardPayActivity.i(APQCardPayActivity.this).setVisibility(8);
    }
    
    public void a(int paramInt, String paramString1, String paramString2)
    {
      APRecoChannelActivity.h = false;
      APQCardPayActivity.i(APQCardPayActivity.this).d();
      APQCardPayActivity.j(APQCardPayActivity.this).setVisibility(0);
      APQCardPayActivity.i(APQCardPayActivity.this).setVisibility(8);
    }
  }
  
  public class c
    implements g5
  {
    public c() {}
    
    public void a(int paramInt, Bundle paramBundle)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" callBack:");
      localStringBuilder.append(paramInt);
      APLog.i("QQCard", localStringBuilder.toString());
      if (paramInt != 1)
      {
        if (paramInt != 10002)
        {
          if (paramInt != 10006) {
            return;
          }
          APQCardPayActivity.a(APQCardPayActivity.this, paramBundle);
          return;
        }
        APQCardPayActivity.b(APQCardPayActivity.this, paramBundle);
        return;
      }
      APQCardPayActivity.this.g();
    }
  }
  
  public class d
    implements TextWatcher
  {
    public d() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      paramEditable.length();
      APQCardPayActivity.a(APQCardPayActivity.this, 3, false, false, null);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public class e
    implements View.OnClickListener
  {
    public e() {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.vc.picchange", APQCardPayActivity.b(APQCardPayActivity.this), p4.p().e().f.k, String.valueOf(4), null);
      APQCardPayActivity.c(APQCardPayActivity.this).setText("");
      APQCardPayActivity.d(APQCardPayActivity.this);
      APQCardPayActivity.c(APQCardPayActivity.this).requestFocus();
    }
  }
  
  public class f
    implements fc
  {
    public f() {}
    
    public void a(ob paramob)
    {
      APQCardPayActivity.i(APQCardPayActivity.this).d();
      APQCardPayActivity.i(APQCardPayActivity.this).setVisibility(8);
      APQCardPayActivity.j(APQCardPayActivity.this).setVisibility(0);
      APQCardPayActivity.a(APQCardPayActivity.this, paramob);
    }
    
    public void b(ob paramob)
    {
      APQCardPayActivity localAPQCardPayActivity = APQCardPayActivity.this;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("系统繁忙:");
      localStringBuilder.append(x1.a(paramob.d()));
      APUICommonMethod.a(localAPQCardPayActivity, localStringBuilder.toString());
      APQCardPayActivity.i(APQCardPayActivity.this).d();
      APQCardPayActivity.i(APQCardPayActivity.this).setVisibility(8);
      APQCardPayActivity.j(APQCardPayActivity.this).setVisibility(0);
    }
    
    public void c(ob paramob)
    {
      APQCardPayActivity.i(APQCardPayActivity.this).d();
      APQCardPayActivity.i(APQCardPayActivity.this).setVisibility(8);
      APQCardPayActivity.j(APQCardPayActivity.this).setVisibility(0);
    }
  }
  
  public class g
    implements TextWatcher
  {
    public g() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.length() != 0)
      {
        if (APQCardPayActivity.a(APQCardPayActivity.this).getText().toString().replace("\n", "").trim().length() >= 9)
        {
          APQCardPayActivity.a(APQCardPayActivity.this, 1, false, false, null);
          APQCardPayActivity.this.b(2131099919);
        }
        APQCardPayActivity.this.d.setVisibility(0);
        APQCardPayActivity.a(APQCardPayActivity.this).setTextSize(19.0F);
        APQCardPayActivity.a(APQCardPayActivity.this).setHintTextColor(-13421773);
        if (APQCardPayActivity.this.getResources().getConfiguration().orientation == 1)
        {
          APQCardPayActivity localAPQCardPayActivity = APQCardPayActivity.this;
          APQCardPayActivity.a(localAPQCardPayActivity, paramEditable, localAPQCardPayActivity.f);
        }
      }
      else
      {
        APQCardPayActivity.this.d.setVisibility(8);
        APQCardPayActivity.a(APQCardPayActivity.this).setTextSize(16.0F);
        APQCardPayActivity.a(APQCardPayActivity.this).setHintTextColor(-6710887);
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public class h
    implements TextWatcher
  {
    public h() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.length() != 0)
      {
        if (APQCardPayActivity.e(APQCardPayActivity.this).getText().toString().replace("\n", "").trim().length() >= 12)
        {
          APQCardPayActivity.a(APQCardPayActivity.this, 2, false, false, null);
          APQCardPayActivity.this.b(2131099950);
        }
        APQCardPayActivity.this.e.setVisibility(0);
        APQCardPayActivity.e(APQCardPayActivity.this).setTextSize(19.0F);
        APQCardPayActivity.e(APQCardPayActivity.this).setHintTextColor(-13421773);
        if (APQCardPayActivity.this.getResources().getConfiguration().orientation == 1)
        {
          APQCardPayActivity localAPQCardPayActivity = APQCardPayActivity.this;
          APQCardPayActivity.a(localAPQCardPayActivity, paramEditable, localAPQCardPayActivity.g);
        }
      }
      else
      {
        APQCardPayActivity.this.e.setVisibility(8);
        APQCardPayActivity.e(APQCardPayActivity.this).setTextSize(16.0F);
        APQCardPayActivity.e(APQCardPayActivity.this).setHintTextColor(-6710887);
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public class i
    implements View.OnClickListener
  {
    public i() {}
    
    public void onClick(View paramView)
    {
      APQCardPayActivity.a(APQCardPayActivity.this).setText("");
    }
  }
  
  public class j
    implements View.OnClickListener
  {
    public j() {}
    
    public void onClick(View paramView)
    {
      APQCardPayActivity.e(APQCardPayActivity.this).setText("");
    }
  }
  
  public class k
    implements View.OnClickListener
  {
    public k() {}
    
    public void onClick(View paramView)
    {
      if (APQCardPayActivity.this.h) {
        APDataReportManager.getInstance().insertData("sdk.vc.sure", APQCardPayActivity.f(APQCardPayActivity.this), p4.p().e().f.k, String.valueOf(4), null);
      } else {
        APDataReportManager.getInstance().insertData("sdk.qcard.pay", APQCardPayActivity.g(APQCardPayActivity.this), p4.p().e().f.k, String.valueOf(4), null);
      }
      APQCardPayActivity.this.g();
    }
  }
  
  public class l
    implements View.OnTouchListener
  {
    public l() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (APQCardPayActivity.a(APQCardPayActivity.this).getText().toString().trim().length() > 0) {
        APQCardPayActivity.this.d.setVisibility(0);
      }
      return false;
    }
  }
  
  public class m
    implements View.OnFocusChangeListener
  {
    public m() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      paramView = new StringBuilder();
      paramView.append("Num onFocusChange hasFocus:");
      paramView.append(paramBoolean);
      APLog.i("APQCardPayActivity", paramView.toString());
      if (paramBoolean) {
        return;
      }
      APQCardPayActivity.this.d.setVisibility(8);
    }
  }
  
  public class n
    implements View.OnTouchListener
  {
    public n() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (APQCardPayActivity.e(APQCardPayActivity.this).getText().toString().length() > 0) {
        APQCardPayActivity.this.e.setVisibility(0);
      }
      return false;
    }
  }
  
  public class o
    implements View.OnFocusChangeListener
  {
    public o() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      if (!paramBoolean) {
        APQCardPayActivity.this.e.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APQCardPayActivity
 * JD-Core Version:    0.7.0.1
 */