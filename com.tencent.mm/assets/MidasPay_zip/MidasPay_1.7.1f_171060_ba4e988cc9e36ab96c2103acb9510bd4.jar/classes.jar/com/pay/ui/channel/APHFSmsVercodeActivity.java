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
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APPayProgressActivity;
import com.pay.ui.common.APUICommonMethod;
import midas.x.a;
import midas.x.bs;
import midas.x.cr;
import midas.x.ec;
import midas.x.ed;
import midas.x.ek;
import midas.x.el;
import midas.x.en;
import midas.x.er;
import midas.x.fm;
import midas.x.fp;
import midas.x.fs;
import midas.x.fs.a;
import midas.x.jw;
import midas.x.kl;

public class APHFSmsVercodeActivity
  extends APActivity
{
  protected AP3PointsLoading a;
  private View b;
  private EditText c;
  private Button d;
  private LinearLayout e;
  private ImageView q;
  private TextView r;
  private TextView s;
  private Button t;
  private int u;
  private CountDownTimer v;
  private String w;
  
  private void a()
  {
    this.p = ed.b().n();
    this.f = this.p.a.saveType;
    this.w = getIntent().getStringExtra("phoneNumber");
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.q.setImageResource(2131034135);
      this.r.setTextColor(getResources().getColor(2130903056));
    }
    else
    {
      this.q.setImageResource(2131034150);
      this.r.setTextColor(getResources().getColor(2130903073));
    }
    this.e.setVisibility(0);
    this.r.setText(paramString);
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.length() >= 3);
  }
  
  private void b()
  {
    c();
    d();
    h();
    i();
    j();
  }
  
  private void b(String paramString)
  {
    if (this.s != null)
    {
      this.s.setText(paramString);
      this.s.setVisibility(0);
    }
  }
  
  private void c()
  {
    ((TextView)findViewById(2131100042)).setText("请输入手机号码");
    ImageButton localImageButton = (ImageButton)findViewById(2131099702);
    localImageButton.setImageResource(2131034194);
    localImageButton.setContentDescription("返回");
    localImageButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this);
      }
    });
  }
  
  private void d()
  {
    Object localObject2 = (TextView)findViewById(2131100002);
    Object localObject3 = (TextView)findViewById(2131100005);
    Object localObject1 = "";
    switch (this.f)
    {
    default: 
      break;
    case 5: 
      if (fs.a().f() == fs.a.a)
      {
        ((TextView)localObject2).setVisibility(8);
        localObject1 = this.p.b.b;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" × ");
        ((StringBuilder)localObject1).append(this.p.e.g);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      break;
    case 4: 
      if (fs.a().f() == fs.a.a)
      {
        ((TextView)localObject2).setVisibility(8);
        localObject1 = this.p.b.b;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getString(2131230828));
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(this.p.e.g);
        ((StringBuilder)localObject1).append(((en)this.p.b).h());
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      break;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getString(2131230828));
      ((StringBuilder)localObject1).append(this.p.e.g);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    ((TextView)localObject2).setText(this.p.b.b);
    ((TextView)localObject3).setText((CharSequence)localObject1);
    if (!APAppDataInterface.singleton().h()) {
      ((TextView)localObject3).setVisibility(4);
    }
    TextView localTextView3 = (TextView)findViewById(2131100000);
    TextView localTextView1 = (TextView)findViewById(2131100003);
    TextView localTextView2 = (TextView)findViewById(2131100007);
    localObject1 = this.p.b.a(this.p.e.g);
    if ((this.f == 0) && (!TextUtils.isEmpty(APHFChannel.n)))
    {
      localObject3 = ((el)this.p.b).b(this.p.e.g, APHFChannel.n);
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    else
    {
      if (this.f == 4) {
        localObject1 = this.p.b.a(this.p.e.g);
      }
      localObject2 = localObject1;
    }
    Object localObject4;
    if (this.f != 4)
    {
      localObject3 = localObject1;
      if (this.f != 5) {}
    }
    else
    {
      localObject3 = localObject1;
      if (!TextUtils.isEmpty(APHFChannel.o))
      {
        localObject3 = localObject1;
        if (!"0".equals(APHFChannel.o))
        {
          int i;
          try
          {
            i = Integer.parseInt(APHFChannel.o);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            i = 0;
          }
          localObject4 = localObject1;
          if (i > 0) {
            localObject4 = APTools.a(i, 2);
          }
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getString(2131230878));
    ((StringBuilder)localObject1).append((String)localObject4);
    localTextView3.setText(((StringBuilder)localObject1).toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject4).equals(localObject2)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getString(2131230878));
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
  
  private void h()
  {
    Object localObject = (LinearLayout)findViewById(2131099674);
    localObject = (EditText)findViewById(2131099673);
    ImageButton localImageButton = (ImageButton)findViewById(2131099672);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131099676);
    ((EditText)localObject).setEnabled(false);
    localImageButton.setVisibility(8);
    localLinearLayout.setVisibility(8);
    ((EditText)localObject).setText(this.w);
  }
  
  private void i()
  {
    this.c = ((EditText)findViewById(2131099686));
    this.d = ((Button)findViewById(2131099687));
    this.e = ((LinearLayout)findViewById(2131099689));
    this.q = ((ImageView)findViewById(2131099688));
    this.r = ((TextView)findViewById(2131099690));
    this.e.setVisibility(8);
    this.c.setHint("请输入验证码");
    this.c.setText("");
    this.c.addTextChangedListener(new a(null));
    this.d.setText("获取验证码");
    this.d.setEnabled(true);
    this.d.requestFocus();
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APHFSmsVercodeActivity.b(APHFSmsVercodeActivity.this);
      }
    });
  }
  
  private void j()
  {
    this.s = ((TextView)findViewById(2131099671));
    String str = getIntent().getStringExtra("hfWarmTips");
    if (!TextUtils.isEmpty(str)) {
      b(str);
    } else if ("1".equals(getIntent().getStringExtra("hfFeeType"))) {
      b(getString(2131230793));
    } else {
      b(getString(2131230792));
    }
    this.a = ((AP3PointsLoading)findViewById(2131099670));
    this.b = findViewById(2131099669);
    p();
    this.t = ((Button)findViewById(2131099668));
    if (this.c.getText().length() <= 0) {
      this.t.setEnabled(false);
    }
    this.t.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = APHFSmsVercodeActivity.c(APHFSmsVercodeActivity.this).getText().toString();
        if (!APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, paramAnonymousView))
        {
          APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, false, "请输入正确的验证码");
          return;
        }
        APHFSmsVercodeActivity.d(APHFSmsVercodeActivity.this);
        APHFSmsVercodeActivity.e(APHFSmsVercodeActivity.this);
        paramAnonymousView = APHFSmsVercodeActivity.c(APHFSmsVercodeActivity.this).getText().toString().trim();
        bs.a().b("hfpay_direct_pay", APHFSmsVercodeActivity.f(APHFSmsVercodeActivity.this), paramAnonymousView, new kl()
        {
          public void a(jw paramAnonymous2jw)
          {
            APHFSmsVercodeActivity.g(APHFSmsVercodeActivity.this);
            APHFSmsVercodeActivity.h(APHFSmsVercodeActivity.this);
            cr localcr = (cr)paramAnonymous2jw;
            int i = localcr.R();
            Object localObject = localcr.S();
            paramAnonymous2jw = (jw)localObject;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              paramAnonymous2jw = "系统错误，请稍后再试！";
            }
            localObject = paramAnonymous2jw;
            if (TextUtils.isEmpty(localcr.a()))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramAnonymous2jw);
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
            paramAnonymous2jw = new Intent(APHFSmsVercodeActivity.this, APPayProgressActivity.class);
            paramAnonymous2jw.putExtra("channel", 9);
            APHFSmsVercodeActivity.this.startActivity(paramAnonymous2jw);
          }
          
          public void b(jw paramAnonymous2jw)
          {
            APHFSmsVercodeActivity.g(APHFSmsVercodeActivity.this);
            APHFSmsVercodeActivity.h(APHFSmsVercodeActivity.this);
            APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, "网络错误，请稍后再试(107-1005)");
          }
          
          public void c(jw paramAnonymous2jw)
          {
            APHFSmsVercodeActivity.g(APHFSmsVercodeActivity.this);
            APHFSmsVercodeActivity.h(APHFSmsVercodeActivity.this);
            APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, "网络错误，请稍后再试(107-1004)");
          }
        });
      }
    });
  }
  
  private void k()
  {
    finish();
    APUICommonMethod.b(this);
    overridePendingTransition(fm.a(this, "unipay_anim_in_from_left"), fm.a(this, "unipay_anim_out_to_right"));
  }
  
  private void l()
  {
    if (this.v == null) {
      this.v = new CountDownTimer(60000L, 1000L)
      {
        public void onFinish()
        {
          APHFSmsVercodeActivity.i(APHFSmsVercodeActivity.this).setEnabled(true);
          if (APHFSmsVercodeActivity.j(APHFSmsVercodeActivity.this) > 0)
          {
            APHFSmsVercodeActivity.i(APHFSmsVercodeActivity.this).setTextSize(12.0F);
            APHFSmsVercodeActivity.i(APHFSmsVercodeActivity.this).setText("重新获取\n短信验证码");
            return;
          }
          APHFSmsVercodeActivity.i(APHFSmsVercodeActivity.this).setTextSize(14.0F);
          APHFSmsVercodeActivity.i(APHFSmsVercodeActivity.this).setText("获取\n短信验证码");
        }
        
        public void onTick(long paramAnonymousLong)
        {
          try
          {
            paramAnonymousLong /= 1000L;
            Button localButton = APHFSmsVercodeActivity.i(APHFSmsVercodeActivity.this);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(String.valueOf(paramAnonymousLong));
            localStringBuilder.append("秒后\n可重新获取");
            localButton.setText(localStringBuilder.toString());
            return;
          }
          catch (NumberFormatException|Exception localNumberFormatException) {}
        }
      };
    }
    this.d.setEnabled(false);
    this.v.start();
    this.d.setTextSize(14.0F);
  }
  
  private void m()
  {
    if (this.v != null)
    {
      this.v.cancel();
      if (this.u > 0)
      {
        this.d.setTextSize(12.0F);
        this.d.setText("重新获取\n短信验证码");
      }
      else
      {
        this.d.setTextSize(14.0F);
        this.d.setText("获取\n短信验证码");
      }
      this.d.setEnabled(true);
    }
  }
  
  private void n()
  {
    this.u += 1;
    l();
    bs.a().b("hfpay_send_sms", this.w, "", new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        paramAnonymousjw = (cr)paramAnonymousjw;
        if ((paramAnonymousjw != null) && (paramAnonymousjw.R() != 0))
        {
          paramAnonymousjw = paramAnonymousjw.S();
          APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, paramAnonymousjw);
          APHFSmsVercodeActivity.h(APHFSmsVercodeActivity.this);
        }
      }
      
      public void b(jw paramAnonymousjw)
      {
        String str = paramAnonymousjw.S();
        paramAnonymousjw = str;
        if (TextUtils.isEmpty(str)) {
          paramAnonymousjw = "遇到错误，请稍后再试";
        }
        APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, paramAnonymousjw);
        APHFSmsVercodeActivity.h(APHFSmsVercodeActivity.this);
      }
      
      public void c(jw paramAnonymousjw)
      {
        String str = paramAnonymousjw.S();
        paramAnonymousjw = str;
        if (TextUtils.isEmpty(str)) {
          paramAnonymousjw = "遇到错误，请稍后再试";
        }
        APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, paramAnonymousjw);
        APHFSmsVercodeActivity.h(APHFSmsVercodeActivity.this);
      }
    });
  }
  
  private void o()
  {
    if (this.c != null) {
      this.c.setEnabled(false);
    }
    if (this.d != null) {
      this.d.setEnabled(false);
    }
    if (this.b != null) {
      this.b.setVisibility(8);
    }
    if (this.a != null)
    {
      this.a.b();
      this.a.setVisibility(0);
    }
  }
  
  private void p()
  {
    if (this.c != null) {
      this.c.setEnabled(true);
    }
    if (this.d != null) {
      this.d.setEnabled(true);
    }
    if (this.b != null) {
      this.b.setVisibility(0);
    }
    if (this.a != null)
    {
      this.a.setVisibility(8);
      this.a.a();
    }
  }
  
  private void q()
  {
    this.e.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fp.a().f()) && (a.a().d != null))
    {
      setContentView(2131165186);
      a();
      b();
      return;
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      k();
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
  
  class a
    implements TextWatcher
  {
    private a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.toString().length() >= 2) {
        APHFSmsVercodeActivity.k(APHFSmsVercodeActivity.this).setEnabled(true);
      } else {
        APHFSmsVercodeActivity.k(APHFSmsVercodeActivity.this).setEnabled(false);
      }
      APHFSmsVercodeActivity.d(APHFSmsVercodeActivity.this);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APHFSmsVercodeActivity
 * JD-Core Version:    0.7.0.1
 */