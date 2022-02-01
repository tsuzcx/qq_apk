package com.pay.ui.channel;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
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
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APScrollView;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.plugin.APPluginActivity;
import midas.x.a;
import midas.x.c5;
import midas.x.c6;
import midas.x.d5;
import midas.x.e5;
import midas.x.h5;
import midas.x.o4;
import midas.x.p4;
import midas.x.w4;
import midas.x.z5;

public class APMCardAccountSaveActivity
  extends APActivity
  implements TextView.OnEditorActionListener
{
  public AP3PointsLoading d;
  public Runnable e = new d();
  public EditText f;
  public EditText g;
  public String h;
  public String i;
  public LinearLayout j;
  public LinearLayout k;
  public TextView l;
  public TextView m;
  public Button n;
  public h5 o = new e();
  public ImageButton p;
  public ImageButton q;
  public ImageView r;
  public ImageView s;
  public int t;
  public int u;
  public int v;
  public int w;
  public TextWatcher x = new f();
  public TextWatcher y = new g();
  
  public final void a(boolean paramBoolean, String paramString)
  {
    paramString = new StringBuilder(paramString);
    int i1 = paramString.lastIndexOf("\n");
    if (i1 != -1) {
      paramString.replace(i1, i1 + 1, " ");
    }
    this.l.setText(paramString.toString());
    if (paramBoolean)
    {
      this.r.setImageResource(this.t);
      this.l.setTextColor(this.v);
    }
    else
    {
      this.r.setImageResource(this.u);
      this.l.setTextColor(this.w);
    }
    this.j.setVisibility(0);
    a(2131099761);
  }
  
  public final void b(boolean paramBoolean, String paramString)
  {
    paramString = new StringBuilder(paramString);
    int i1 = paramString.lastIndexOf("\n");
    if (i1 != -1) {
      paramString.replace(i1, i1 + 1, " ");
    }
    this.m.setText(paramString.toString());
    if (paramBoolean)
    {
      this.s.setImageResource(this.t);
      this.m.setTextColor(this.v);
    }
    else
    {
      this.s.setImageResource(this.u);
      this.m.setTextColor(this.w);
    }
    this.k.setVisibility(0);
    a(2131099763);
  }
  
  public boolean f()
  {
    this.h = this.f.getText().toString().trim();
    this.i = this.g.getText().toString().trim();
    if (this.h.length() == 0)
    {
      a(false, "请输入手机充值卡序列号");
      return false;
    }
    if (this.h.length() < 15)
    {
      a(false, "请输入正确的手机充值卡序列号");
      return false;
    }
    if (this.i.length() == 0)
    {
      b(false, "请输入手机充值卡密码");
      return false;
    }
    if (this.i.length() < 15)
    {
      b(false, "请输入正确的手机充值卡密码");
      return false;
    }
    return true;
  }
  
  public void g()
  {
    if (f())
    {
      com.pay.paychannel.mcard.APMcardChannel.o = this.h;
      com.pay.paychannel.mcard.APMcardChannel.p = this.i;
      String str = p4.p().e().f.e;
      this.f.setEnabled(false);
      this.g.setEnabled(false);
      this.p.setVisibility(8);
      this.q.setVisibility(8);
      this.n.setVisibility(8);
      this.d.setVisibility(0);
      this.d.c();
      APRecoChannelActivity.h = true;
      e5.h().a(this, str, this.o, null);
    }
  }
  
  public void h()
  {
    this.t = 2131034135;
    this.u = 2131034150;
    this.v = 2130903056;
    this.w = 2130903073;
    this.r = ((ImageView)findViewById(2131099991));
    this.s = ((ImageView)findViewById(2131099994));
    this.j = ((LinearLayout)findViewById(2131099992));
    this.k = ((LinearLayout)findViewById(2131099995));
    this.l = ((TextView)findViewById(2131099990));
    this.m = ((TextView)findViewById(2131099993));
    this.n = ((Button)findViewById(2131099726));
    this.n.setOnClickListener(new h());
    ((ImageButton)findViewById(2131099802)).setOnClickListener(new i());
    Object localObject = (TextView)findViewById(2131099903);
    ((TextView)localObject).setText(String.format(getString(2131230807), new Object[] { this.c.e.a() }));
    TextView localTextView = (TextView)findViewById(2131099908);
    if (!c6.s0().U())
    {
      ((TextView)localObject).setVisibility(8);
      localTextView.setText("支持10~100面值充值卡，充值数量将由充值卡面值决定");
    }
    else
    {
      int i1 = this.a;
      if ((i1 == 3) || (i1 == 2)) {
        ((TextView)localObject).setVisibility(8);
      }
      if (this.a == 3) {
        localTextView.setText("支持10~100面值充值卡，充值数量将由充值卡面值决定（1元=1Q币）");
      }
      if (this.a == 2) {
        localTextView.setText("支持10~100面值充值卡，充值数量将由充值卡面值决定（1元=10Q点）");
      }
    }
    ((TextView)findViewById(2131099772)).setText(String.format(getString(2131230927), new Object[] { this.c.c.a() }));
    this.f = ((EditText)findViewById(2131099760));
    this.f.addTextChangedListener(this.x);
    this.f.setFilters(new InputFilter[] { new InputFilter.LengthFilter(30) });
    this.f.setOnTouchListener(new j());
    this.f.setOnFocusChangeListener(new k());
    this.g = ((EditText)findViewById(2131099762));
    this.g.addTextChangedListener(this.y);
    this.g.setFilters(new InputFilter[] { new InputFilter.LengthFilter(30) });
    this.g.setOnEditorActionListener(this);
    this.g.setOnTouchListener(new l());
    localObject = (APScrollView)findViewById(2131099755);
    this.g.setOnFocusChangeListener(new a((APScrollView)localObject));
    i();
    this.d = ((AP3PointsLoading)findViewById(2131099895));
    this.f.requestFocus();
  }
  
  public final void i()
  {
    this.p = ((ImageButton)findViewById(2131099727));
    this.p.setOnClickListener(new b());
    this.q = ((ImageButton)findViewById(2131099728));
    this.q.setOnClickListener(new c());
  }
  
  public final void j()
  {
    new Handler().postDelayed(this.e, 500L);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((c6.s0().i()) && (a.r().d != null))
    {
      this.a = this.c.b.saveType;
      setContentView(2131165198);
      h();
      a.r().f = true;
      return;
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramTextView = (InputMethodManager)getSystemService("input_method");
    if (paramInt != 0)
    {
      if (paramInt != 4)
      {
        if (paramInt == 6) {
          paramTextView.hideSoftInputFromWindow(this.g.getWindowToken(), 0);
        }
      }
      else {
        paramTextView.hideSoftInputFromWindow(this.g.getWindowToken(), 0);
      }
    }
    else {
      paramTextView.hideSoftInputFromWindow(this.g.getWindowToken(), 0);
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
      APDataReportManager.getInstance().insertData("sdk.mcard.input.keyback", this.a, p4.p().e().f.k, p4.p().e().f.e, null);
      finish();
      APUICommonMethod.a(this);
      overridePendingTransition(z5.a(this, "unipay_anim_in_from_left"), z5.a(this, "unipay_anim_out_to_right"));
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager.getInstance().insertData("sdk.mcard.input.show", this.a, p4.p().e().f.k, p4.p().e().f.e, null);
    if (getResources().getConfiguration().orientation == 2)
    {
      getWindow().setSoftInputMode(3);
      return;
    }
    if (getResources().getConfiguration().orientation == 1)
    {
      EditText localEditText = this.f;
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
    implements View.OnFocusChangeListener
  {
    public a(APScrollView paramAPScrollView) {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.a.smoothScrollTo(0, 390);
        return;
      }
      ((ImageButton)APMCardAccountSaveActivity.this.findViewById(2131099728)).setVisibility(8);
    }
  }
  
  public class b
    implements View.OnClickListener
  {
    public b() {}
    
    public void onClick(View paramView)
    {
      APMCardAccountSaveActivity.b(APMCardAccountSaveActivity.this).setText("");
      APMCardAccountSaveActivity.i(APMCardAccountSaveActivity.this).setVisibility(8);
    }
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).setText("");
      APMCardAccountSaveActivity.j(APMCardAccountSaveActivity.this).setVisibility(8);
    }
  }
  
  public class d
    implements Runnable
  {
    public d() {}
    
    public void run()
    {
      try
      {
        ((APScrollView)APMCardAccountSaveActivity.this.findViewById(2131099755)).smoothScrollTo(0, 110);
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  public class e
    implements h5
  {
    public e() {}
    
    public void a()
    {
      APRecoChannelActivity.h = false;
      APMCardAccountSaveActivity.this.d.d();
      APMCardAccountSaveActivity.this.d.setVisibility(8);
      APMCardAccountSaveActivity.a(APMCardAccountSaveActivity.this).setVisibility(0);
      APMCardAccountSaveActivity.b(APMCardAccountSaveActivity.this).setEnabled(true);
      APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).setEnabled(true);
    }
    
    public void a(int paramInt)
    {
      APRecoChannelActivity.h = false;
      APMCardAccountSaveActivity.this.d.d();
      APMCardAccountSaveActivity.this.d.setVisibility(8);
      APMCardAccountSaveActivity.a(APMCardAccountSaveActivity.this).setVisibility(0);
      APMCardAccountSaveActivity.b(APMCardAccountSaveActivity.this).setEnabled(true);
      APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).setEnabled(true);
    }
    
    public void a(int paramInt, String paramString1, String paramString2)
    {
      APRecoChannelActivity.h = false;
      APMCardAccountSaveActivity.this.d.d();
      APMCardAccountSaveActivity.this.d.setVisibility(8);
      APMCardAccountSaveActivity.a(APMCardAccountSaveActivity.this).setVisibility(0);
      APMCardAccountSaveActivity.b(APMCardAccountSaveActivity.this).setEnabled(true);
      APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).setEnabled(true);
    }
  }
  
  public class f
    implements TextWatcher
  {
    public f() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.length() != 0)
      {
        APMCardAccountSaveActivity.this.b(2131099761);
        ((ImageButton)APMCardAccountSaveActivity.this.findViewById(2131099727)).setVisibility(0);
        APMCardAccountSaveActivity.d(APMCardAccountSaveActivity.this).setVisibility(8);
        APMCardAccountSaveActivity.b(APMCardAccountSaveActivity.this).setTextSize(19.0F);
        APMCardAccountSaveActivity.b(APMCardAccountSaveActivity.this).setHintTextColor(-13421773);
        return;
      }
      APMCardAccountSaveActivity.b(APMCardAccountSaveActivity.this).setTextSize(16.0F);
      APMCardAccountSaveActivity.b(APMCardAccountSaveActivity.this).setHintTextColor(-6710887);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 == 0) {}
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
        APMCardAccountSaveActivity.this.b(2131099763);
        ((ImageButton)APMCardAccountSaveActivity.this.findViewById(2131099728)).setVisibility(0);
        APMCardAccountSaveActivity.e(APMCardAccountSaveActivity.this).setVisibility(8);
        APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).setTextSize(19.0F);
        APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).setHintTextColor(-13421773);
        return;
      }
      APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).setTextSize(16.0F);
      APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).setHintTextColor(-6710887);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public class h
    implements View.OnClickListener
  {
    public h() {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.mcard.input.pay", APMCardAccountSaveActivity.f(APMCardAccountSaveActivity.this), p4.p().e().f.k, p4.p().e().f.e, null);
      APMCardAccountSaveActivity.this.g();
    }
  }
  
  public class i
    implements View.OnClickListener
  {
    public i() {}
    
    public void onClick(View paramView)
    {
      if (APRecoChannelActivity.f()) {
        return;
      }
      APDataReportManager.getInstance().insertData("sdk.mcard.input.back", APMCardAccountSaveActivity.g(APMCardAccountSaveActivity.this), p4.p().e().f.k, p4.p().e().f.e, null);
      APMCardAccountSaveActivity.this.finish();
      APUICommonMethod.a(APMCardAccountSaveActivity.this);
    }
  }
  
  public class j
    implements View.OnTouchListener
  {
    public j() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      paramView = (ImageButton)APMCardAccountSaveActivity.this.findViewById(2131099727);
      if (APMCardAccountSaveActivity.b(APMCardAccountSaveActivity.this).getText().toString().length() > 0)
      {
        paramView.setVisibility(0);
        return false;
      }
      paramView.setVisibility(8);
      return false;
    }
  }
  
  public class k
    implements View.OnFocusChangeListener
  {
    public k() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        APMCardAccountSaveActivity.h(APMCardAccountSaveActivity.this);
        return;
      }
      ((ImageButton)APMCardAccountSaveActivity.this.findViewById(2131099727)).setVisibility(8);
    }
  }
  
  public class l
    implements View.OnTouchListener
  {
    public l() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      paramView = (ImageButton)APMCardAccountSaveActivity.this.findViewById(2131099728);
      if (APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).getText().toString().length() > 0) {
        paramView.setVisibility(0);
      } else {
        paramView.setVisibility(8);
      }
      APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).setCursorVisible(true);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APMCardAccountSaveActivity
 * JD-Core Version:    0.7.0.1
 */