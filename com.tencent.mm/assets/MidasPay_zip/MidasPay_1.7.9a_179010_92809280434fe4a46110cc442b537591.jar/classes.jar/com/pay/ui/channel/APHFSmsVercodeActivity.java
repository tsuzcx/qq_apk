package com.pay.ui.channel;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APPayProgressActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.plugin.APPluginActivity;
import midas.x.a;
import midas.x.c6;
import midas.x.d5;
import midas.x.fc;
import midas.x.g6;
import midas.x.g6.a;
import midas.x.i;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.w4;
import midas.x.y2;
import midas.x.z1;
import midas.x.z4;
import midas.x.z5;

public class APHFSmsVercodeActivity
  extends APActivity
{
  public AP3PointsLoading d;
  public View e;
  public String f;
  public EditText g;
  public Button h;
  public LinearLayout i;
  public ImageView j;
  public TextView k;
  public TextView l;
  public Button m;
  public int n;
  public CountDownTimer o;
  public String p;
  
  public final void a(String paramString)
  {
    TextView localTextView = this.l;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      this.l.setVisibility(0);
    }
  }
  
  public final void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.j.setImageResource(2131034135);
      this.k.setTextColor(getResources().getColor(2130903056));
    }
    else
    {
      this.j.setImageResource(2131034150);
      this.k.setTextColor(getResources().getColor(2130903073));
    }
    this.i.setVisibility(0);
    this.k.setText(paramString);
  }
  
  public final boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.length() >= 3);
  }
  
  public final void f()
  {
    finish();
    APUICommonMethod.a(this);
    overridePendingTransition(z5.a(this, "unipay_anim_in_from_left"), z5.a(this, "unipay_anim_out_to_right"));
  }
  
  public final void g()
  {
    CountDownTimer localCountDownTimer = this.o;
    if (localCountDownTimer != null)
    {
      localCountDownTimer.cancel();
      if (this.n > 0)
      {
        this.h.setTextSize(12.0F);
        this.h.setText("重新获取\n短信验证码");
      }
      else
      {
        this.h.setTextSize(14.0F);
        this.h.setText("获取\n短信验证码");
      }
      this.h.setEnabled(true);
    }
  }
  
  public final void h()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((EditText)localObject).setEnabled(true);
    }
    localObject = this.h;
    if (localObject != null) {
      ((Button)localObject).setEnabled(true);
    }
    localObject = this.e;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).setVisibility(8);
      this.d.d();
    }
  }
  
  public final void i()
  {
    this.i.setVisibility(8);
  }
  
  public final void j()
  {
    this.c = p4.p().e();
    this.a = this.c.b.saveType;
    this.p = getIntent().getStringExtra("phoneNumber");
  }
  
  public final void k()
  {
    this.l = ((TextView)findViewById(2131099671));
    String str = getIntent().getStringExtra("hfWarmTips");
    if (!TextUtils.isEmpty(str))
    {
      a(str);
    }
    else
    {
      int i1 = this.a;
      if ((i1 == 4) || (i1 == 5)) {
        if ("1".equals(getIntent().getStringExtra("hfFeeType"))) {
          a(getString(2131230794));
        } else {
          a(getString(2131230793));
        }
      }
    }
    this.d = ((AP3PointsLoading)findViewById(2131099670));
    this.e = findViewById(2131099669);
    h();
    this.m = ((Button)findViewById(2131099668));
    if (this.g.getText().length() <= 0) {
      this.m.setEnabled(false);
    }
    this.m.setOnClickListener(new c());
  }
  
  public final void l()
  {
    Object localObject = (LinearLayout)findViewById(2131099674);
    localObject = (EditText)findViewById(2131099673);
    ImageButton localImageButton = (ImageButton)findViewById(2131099672);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131099676);
    ((EditText)localObject).setEnabled(false);
    localImageButton.setVisibility(8);
    localLinearLayout.setVisibility(8);
    ((EditText)localObject).setText(this.p);
  }
  
  public final void m()
  {
    Object localObject2 = (TextView)findViewById(2131100002);
    TextView localTextView1 = (TextView)findViewById(2131100005);
    int i1 = this.a;
    if ((i1 != 0) && (i1 != 1) && (i1 != 2) && (i1 != 3))
    {
      if (i1 != 4)
      {
        if (i1 != 5)
        {
          localObject1 = "";
        }
        else if (g6.k().e() == g6.a.a)
        {
          ((TextView)localObject2).setVisibility(8);
          localObject1 = this.c.c.b;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" × ");
          ((StringBuilder)localObject1).append(this.c.f.f);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      else if (g6.k().e() == g6.a.a)
      {
        ((TextView)localObject2).setVisibility(8);
        localObject1 = this.c.c.b;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getString(2131230829));
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(this.c.f.f);
        ((StringBuilder)localObject1).append(((z4)this.c.c).h());
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getString(2131230829));
      ((StringBuilder)localObject1).append(this.c.f.f);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    ((TextView)localObject2).setText(this.c.c.b);
    localTextView1.setText((CharSequence)localObject1);
    if (!APAppDataInterface.singleton().n()) {
      localTextView1.setVisibility(4);
    }
    TextView localTextView3 = (TextView)findViewById(2131100000);
    localTextView1 = (TextView)findViewById(2131100003);
    TextView localTextView2 = (TextView)findViewById(2131100007);
    Object localObject1 = this.c;
    localObject2 = ((o4)localObject1).c.a(((o4)localObject1).f.f);
    if (TextUtils.isEmpty(this.f)) {
      localObject1 = localObject2;
    } else {
      localObject1 = this.f;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131230879));
    localStringBuilder.append((String)localObject1);
    localTextView3.setText(localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject1).equals(localObject2)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getString(2131230879));
      ((StringBuilder)localObject1).append((String)localObject2);
      localTextView1.setText(((StringBuilder)localObject1).toString());
      localTextView1.getPaint().setFlags(16);
      localTextView1.setVisibility(0);
      localTextView2.setVisibility(0);
      return;
    }
    localTextView1.setVisibility(4);
    localTextView2.setVisibility(4);
  }
  
  public final void n()
  {
    ((TextView)findViewById(2131100042)).setText("请输入手机号码");
    ImageButton localImageButton = (ImageButton)findViewById(2131099702);
    localImageButton.setImageResource(2131034194);
    localImageButton.setContentDescription("返回");
    localImageButton.setOnClickListener(new a());
  }
  
  public final void o()
  {
    n();
    m();
    l();
    p();
    k();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((c6.s0().i()) && (a.r().d != null))
    {
      setContentView(2131165186);
      int i1 = i.b(getIntent().getStringExtra("hfPrice"));
      if (i1 > 0) {
        paramBundle = APTools.a(i1, 2);
      } else {
        paramBundle = "";
      }
      this.f = paramBundle;
      j();
      o();
      return;
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      f();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public final void p()
  {
    this.g = ((EditText)findViewById(2131099686));
    this.h = ((Button)findViewById(2131099687));
    this.i = ((LinearLayout)findViewById(2131099689));
    this.j = ((ImageView)findViewById(2131099688));
    this.k = ((TextView)findViewById(2131099690));
    this.i.setVisibility(8);
    this.g.setHint("请输入验证码");
    this.g.setText("");
    this.g.addTextChangedListener(new f(null));
    this.h.setText("获取验证码");
    this.h.setEnabled(true);
    this.h.requestFocus();
    this.h.setOnClickListener(new b());
  }
  
  public final void q()
  {
    this.n += 1;
    s();
    z1.d().a("hfpay_send_sms", this.p, "", new e());
  }
  
  public final void r()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((EditText)localObject).setEnabled(false);
    }
    localObject = this.h;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    localObject = this.e;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((AP3PointsLoading)localObject).c();
      this.d.setVisibility(0);
    }
  }
  
  public final void s()
  {
    if (this.o == null) {
      this.o = new d(60000L, 1000L);
    }
    this.h.setEnabled(false);
    this.o.start();
    this.h.setTextSize(14.0F);
  }
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this);
    }
  }
  
  public class b
    implements View.OnClickListener
  {
    public b() {}
    
    public void onClick(View paramView)
    {
      APHFSmsVercodeActivity.f(APHFSmsVercodeActivity.this);
    }
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      paramView = APHFSmsVercodeActivity.g(APHFSmsVercodeActivity.this).getText().toString();
      if (!APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, paramView))
      {
        APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, false, "请输入正确的验证码");
        return;
      }
      APHFSmsVercodeActivity.h(APHFSmsVercodeActivity.this);
      APHFSmsVercodeActivity.i(APHFSmsVercodeActivity.this);
      paramView = APHFSmsVercodeActivity.g(APHFSmsVercodeActivity.this).getText().toString().trim();
      z1.d().a("hfpay_direct_pay", APHFSmsVercodeActivity.j(APHFSmsVercodeActivity.this), paramView, new a());
    }
    
    public class a
      implements fc
    {
      public a() {}
      
      public void a(ob paramob)
      {
        APHFSmsVercodeActivity.k(APHFSmsVercodeActivity.this);
        APHFSmsVercodeActivity.b(APHFSmsVercodeActivity.this);
        y2 localy2 = (y2)paramob;
        int i = localy2.d();
        Object localObject = localy2.f();
        paramob = (ob)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramob = "系统错误，请稍后再试！";
        }
        localObject = paramob;
        if (TextUtils.isEmpty(localy2.g()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramob);
          ((StringBuilder)localObject).append("(107-1003-");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(")");
          localObject = ((StringBuilder)localObject).toString();
        }
        if (i != 0)
        {
          APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, (String)localObject);
          return;
        }
        paramob = new Intent(APHFSmsVercodeActivity.this, APPayProgressActivity.class);
        paramob.putExtra("channel", 9);
        APHFSmsVercodeActivity.this.startActivity(paramob);
      }
      
      public void b(ob paramob)
      {
        APHFSmsVercodeActivity.k(APHFSmsVercodeActivity.this);
        APHFSmsVercodeActivity.b(APHFSmsVercodeActivity.this);
        APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, "网络错误，请稍后再试(107-1005)");
      }
      
      public void c(ob paramob)
      {
        APHFSmsVercodeActivity.k(APHFSmsVercodeActivity.this);
        APHFSmsVercodeActivity.b(APHFSmsVercodeActivity.this);
        APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, "网络错误，请稍后再试(107-1004)");
      }
    }
  }
  
  public class d
    extends CountDownTimer
  {
    public d(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      APHFSmsVercodeActivity.c(APHFSmsVercodeActivity.this).setEnabled(true);
      if (APHFSmsVercodeActivity.d(APHFSmsVercodeActivity.this) > 0)
      {
        APHFSmsVercodeActivity.c(APHFSmsVercodeActivity.this).setTextSize(12.0F);
        APHFSmsVercodeActivity.c(APHFSmsVercodeActivity.this).setText("重新获取\n短信验证码");
        return;
      }
      APHFSmsVercodeActivity.c(APHFSmsVercodeActivity.this).setTextSize(14.0F);
      APHFSmsVercodeActivity.c(APHFSmsVercodeActivity.this).setText("获取\n短信验证码");
    }
    
    public void onTick(long paramLong)
    {
      try
      {
        paramLong /= 1000L;
        Button localButton = APHFSmsVercodeActivity.c(APHFSmsVercodeActivity.this);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(String.valueOf(paramLong));
        localStringBuilder.append("秒后\n可重新获取");
        localButton.setText(localStringBuilder.toString());
        return;
      }
      catch (NumberFormatException|Exception localNumberFormatException) {}
    }
  }
  
  public class e
    implements fc
  {
    public e() {}
    
    public void a(ob paramob)
    {
      paramob = (y2)paramob;
      if ((paramob != null) && (paramob.d() != 0))
      {
        paramob = paramob.f();
        APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, paramob);
        APHFSmsVercodeActivity.b(APHFSmsVercodeActivity.this);
      }
    }
    
    public void b(ob paramob)
    {
      String str = paramob.f();
      paramob = str;
      if (TextUtils.isEmpty(str)) {
        paramob = "遇到错误，请稍后再试";
      }
      APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, paramob);
      APHFSmsVercodeActivity.b(APHFSmsVercodeActivity.this);
    }
    
    public void c(ob paramob)
    {
      String str = paramob.f();
      paramob = str;
      if (TextUtils.isEmpty(str)) {
        paramob = "遇到错误，请稍后再试";
      }
      APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, paramob);
      APHFSmsVercodeActivity.b(APHFSmsVercodeActivity.this);
    }
  }
  
  public class f
    implements TextWatcher
  {
    public f() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.toString().length() >= 2) {
        APHFSmsVercodeActivity.e(APHFSmsVercodeActivity.this).setEnabled(true);
      } else {
        APHFSmsVercodeActivity.e(APHFSmsVercodeActivity.this).setEnabled(false);
      }
      APHFSmsVercodeActivity.h(APHFSmsVercodeActivity.this);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APHFSmsVercodeActivity
 * JD-Core Version:    0.7.0.1
 */