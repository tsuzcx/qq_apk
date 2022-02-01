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
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APPayProgressActivity;
import com.pay.ui.common.APUICommonMethod;
import midas.x.a;
import midas.x.by;
import midas.x.cx;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.ew;
import midas.x.fa;
import midas.x.fv;
import midas.x.fy;
import midas.x.gc;
import midas.x.gc.a;
import midas.x.i;
import midas.x.lh;
import midas.x.lw;

public class APHFSmsVercodeActivity
  extends APActivity
{
  protected AP3PointsLoading a;
  private View b;
  private String c;
  private EditText d;
  private Button e;
  private LinearLayout q;
  private ImageView r;
  private TextView s;
  private TextView t;
  private Button u;
  private int v;
  private CountDownTimer w;
  private String x;
  
  private void a()
  {
    this.p = em.b().n();
    this.f = this.p.a.saveType;
    this.x = getIntent().getStringExtra("phoneNumber");
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.r.setImageResource(2131034135);
      this.s.setTextColor(getResources().getColor(2130903056));
    }
    else
    {
      this.r.setImageResource(2131034150);
      this.s.setTextColor(getResources().getColor(2130903073));
    }
    this.q.setVisibility(0);
    this.s.setText(paramString);
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
    if (this.t != null)
    {
      this.t.setText(paramString);
      this.t.setVisibility(0);
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
    TextView localTextView1 = (TextView)findViewById(2131100005);
    Object localObject1 = "";
    switch (this.f)
    {
    default: 
      break;
    case 5: 
      if (gc.a().f() == gc.a.a)
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
      if (gc.a().f() == gc.a.a)
      {
        ((TextView)localObject2).setVisibility(8);
        localObject1 = this.p.b.b;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getString(2131230829));
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(this.p.e.g);
        ((StringBuilder)localObject1).append(((ew)this.p.b).h());
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      break;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getString(2131230829));
      ((StringBuilder)localObject1).append(this.p.e.g);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    ((TextView)localObject2).setText(this.p.b.b);
    localTextView1.setText((CharSequence)localObject1);
    if (!APAppDataInterface.singleton().h()) {
      localTextView1.setVisibility(4);
    }
    TextView localTextView3 = (TextView)findViewById(2131100000);
    localTextView1 = (TextView)findViewById(2131100003);
    TextView localTextView2 = (TextView)findViewById(2131100007);
    localObject2 = this.p.b.a(this.p.e.g);
    if (TextUtils.isEmpty(this.c)) {
      localObject1 = localObject2;
    } else {
      localObject1 = this.c;
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
  
  private void h()
  {
    Object localObject = (LinearLayout)findViewById(2131099674);
    localObject = (EditText)findViewById(2131099673);
    ImageButton localImageButton = (ImageButton)findViewById(2131099672);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131099676);
    ((EditText)localObject).setEnabled(false);
    localImageButton.setVisibility(8);
    localLinearLayout.setVisibility(8);
    ((EditText)localObject).setText(this.x);
  }
  
  private void i()
  {
    this.d = ((EditText)findViewById(2131099686));
    this.e = ((Button)findViewById(2131099687));
    this.q = ((LinearLayout)findViewById(2131099689));
    this.r = ((ImageView)findViewById(2131099688));
    this.s = ((TextView)findViewById(2131099690));
    this.q.setVisibility(8);
    this.d.setHint("请输入验证码");
    this.d.setText("");
    this.d.addTextChangedListener(new a(null));
    this.e.setText("获取验证码");
    this.e.setEnabled(true);
    this.e.requestFocus();
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APHFSmsVercodeActivity.b(APHFSmsVercodeActivity.this);
      }
    });
  }
  
  private void j()
  {
    this.t = ((TextView)findViewById(2131099671));
    String str = getIntent().getStringExtra("hfWarmTips");
    if (!TextUtils.isEmpty(str)) {
      b(str);
    } else if ((this.f == 4) || (this.f == 5)) {
      if ("1".equals(getIntent().getStringExtra("hfFeeType"))) {
        b(getString(2131230794));
      } else {
        b(getString(2131230793));
      }
    }
    this.a = ((AP3PointsLoading)findViewById(2131099670));
    this.b = findViewById(2131099669);
    p();
    this.u = ((Button)findViewById(2131099668));
    if (this.d.getText().length() <= 0) {
      this.u.setEnabled(false);
    }
    this.u.setOnClickListener(new View.OnClickListener()
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
        by.a().b("hfpay_direct_pay", APHFSmsVercodeActivity.f(APHFSmsVercodeActivity.this), paramAnonymousView, new lw()
        {
          public void a(lh paramAnonymous2lh)
          {
            APHFSmsVercodeActivity.g(APHFSmsVercodeActivity.this);
            APHFSmsVercodeActivity.h(APHFSmsVercodeActivity.this);
            cx localcx = (cx)paramAnonymous2lh;
            int i = localcx.T();
            Object localObject = localcx.U();
            paramAnonymous2lh = (lh)localObject;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              paramAnonymous2lh = "系统错误，请稍后再试！";
            }
            localObject = paramAnonymous2lh;
            if (TextUtils.isEmpty(localcx.a()))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramAnonymous2lh);
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
            paramAnonymous2lh = new Intent(APHFSmsVercodeActivity.this, APPayProgressActivity.class);
            paramAnonymous2lh.putExtra("channel", 9);
            APHFSmsVercodeActivity.this.startActivity(paramAnonymous2lh);
          }
          
          public void b(lh paramAnonymous2lh)
          {
            APHFSmsVercodeActivity.g(APHFSmsVercodeActivity.this);
            APHFSmsVercodeActivity.h(APHFSmsVercodeActivity.this);
            APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, "网络错误，请稍后再试(107-1005)");
          }
          
          public void c(lh paramAnonymous2lh)
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
    overridePendingTransition(fv.a(this, "unipay_anim_in_from_left"), fv.a(this, "unipay_anim_out_to_right"));
  }
  
  private void l()
  {
    if (this.w == null) {
      this.w = new CountDownTimer(60000L, 1000L)
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
    this.e.setEnabled(false);
    this.w.start();
    this.e.setTextSize(14.0F);
  }
  
  private void m()
  {
    if (this.w != null)
    {
      this.w.cancel();
      if (this.v > 0)
      {
        this.e.setTextSize(12.0F);
        this.e.setText("重新获取\n短信验证码");
      }
      else
      {
        this.e.setTextSize(14.0F);
        this.e.setText("获取\n短信验证码");
      }
      this.e.setEnabled(true);
    }
  }
  
  private void n()
  {
    this.v += 1;
    l();
    by.a().b("hfpay_send_sms", this.x, "", new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        paramAnonymouslh = (cx)paramAnonymouslh;
        if ((paramAnonymouslh != null) && (paramAnonymouslh.T() != 0))
        {
          paramAnonymouslh = paramAnonymouslh.U();
          APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, paramAnonymouslh);
          APHFSmsVercodeActivity.h(APHFSmsVercodeActivity.this);
        }
      }
      
      public void b(lh paramAnonymouslh)
      {
        String str = paramAnonymouslh.U();
        paramAnonymouslh = str;
        if (TextUtils.isEmpty(str)) {
          paramAnonymouslh = "遇到错误，请稍后再试";
        }
        APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, paramAnonymouslh);
        APHFSmsVercodeActivity.h(APHFSmsVercodeActivity.this);
      }
      
      public void c(lh paramAnonymouslh)
      {
        String str = paramAnonymouslh.U();
        paramAnonymouslh = str;
        if (TextUtils.isEmpty(str)) {
          paramAnonymouslh = "遇到错误，请稍后再试";
        }
        APHFSmsVercodeActivity.a(APHFSmsVercodeActivity.this, true, paramAnonymouslh);
        APHFSmsVercodeActivity.h(APHFSmsVercodeActivity.this);
      }
    });
  }
  
  private void o()
  {
    if (this.d != null) {
      this.d.setEnabled(false);
    }
    if (this.e != null) {
      this.e.setEnabled(false);
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
    if (this.d != null) {
      this.d.setEnabled(true);
    }
    if (this.e != null) {
      this.e.setEnabled(true);
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
    this.q.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fy.a().f()) && (a.a().d != null))
    {
      setContentView(2131165186);
      int i = i.a(getIntent().getStringExtra("hfPrice"));
      if (i > 0) {
        paramBundle = APTools.a(i, 2);
      } else {
        paramBundle = "";
      }
      this.c = paramBundle;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APHFSmsVercodeActivity
 * JD-Core Version:    0.7.0.1
 */