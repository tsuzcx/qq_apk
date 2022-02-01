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
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APScrollView;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import midas.x.a;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.ez;
import midas.x.fa;
import midas.x.fb;
import midas.x.fe;
import midas.x.fv;
import midas.x.fy;

public class APMCardAccountSaveActivity
  extends APActivity
  implements TextView.OnEditorActionListener
{
  private ImageView A;
  private int B;
  private int C;
  private int D;
  private int E;
  private TextWatcher F = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (paramAnonymousEditable.length() != 0)
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
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      if (paramAnonymousInt1 == 0) {}
    }
  };
  private TextWatcher G = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (paramAnonymousEditable.length() != 0)
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
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  protected AP3PointsLoading a;
  Runnable b = new Runnable()
  {
    public void run()
    {
      try
      {
        ((APScrollView)APMCardAccountSaveActivity.this.findViewById(2131099755)).smoothScrollTo(0, 110);
        return;
      }
      catch (Exception localException) {}
    }
  };
  fe c = new fe()
  {
    public void a()
    {
      APRecoChannelActivity.b = false;
      APMCardAccountSaveActivity.this.a.a();
      APMCardAccountSaveActivity.this.a.setVisibility(8);
      APMCardAccountSaveActivity.a(APMCardAccountSaveActivity.this).setVisibility(0);
      APMCardAccountSaveActivity.b(APMCardAccountSaveActivity.this).setEnabled(true);
      APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).setEnabled(true);
    }
    
    public void a(int paramAnonymousInt)
    {
      APRecoChannelActivity.b = false;
      APMCardAccountSaveActivity.this.a.a();
      APMCardAccountSaveActivity.this.a.setVisibility(8);
      APMCardAccountSaveActivity.a(APMCardAccountSaveActivity.this).setVisibility(0);
      APMCardAccountSaveActivity.b(APMCardAccountSaveActivity.this).setEnabled(true);
      APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).setEnabled(true);
    }
    
    public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      APRecoChannelActivity.b = false;
      APMCardAccountSaveActivity.this.a.a();
      APMCardAccountSaveActivity.this.a.setVisibility(8);
      APMCardAccountSaveActivity.a(APMCardAccountSaveActivity.this).setVisibility(0);
      APMCardAccountSaveActivity.b(APMCardAccountSaveActivity.this).setEnabled(true);
      APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).setEnabled(true);
    }
  };
  private EditText d;
  private EditText e;
  private String q;
  private String r;
  private LinearLayout s;
  private LinearLayout t;
  private TextView u;
  private TextView v;
  private Button w;
  private ImageButton x;
  private ImageButton y;
  private ImageView z;
  
  private void a(boolean paramBoolean, String paramString)
  {
    paramString = new StringBuilder(paramString);
    int i = paramString.lastIndexOf("\n");
    if (i != -1) {
      paramString.replace(i, i + 1, " ");
    }
    this.u.setText(paramString.toString());
    if (paramBoolean)
    {
      this.z.setImageResource(this.B);
      this.u.setTextColor(this.D);
    }
    else
    {
      this.z.setImageResource(this.C);
      this.u.setTextColor(this.E);
    }
    this.s.setVisibility(0);
    a(2131099761);
  }
  
  private void b(boolean paramBoolean, String paramString)
  {
    paramString = new StringBuilder(paramString);
    int i = paramString.lastIndexOf("\n");
    if (i != -1) {
      paramString.replace(i, i + 1, " ");
    }
    this.v.setText(paramString.toString());
    if (paramBoolean)
    {
      this.A.setImageResource(this.B);
      this.v.setTextColor(this.D);
    }
    else
    {
      this.A.setImageResource(this.C);
      this.v.setTextColor(this.E);
    }
    this.t.setVisibility(0);
    a(2131099763);
  }
  
  private void d()
  {
    new Handler().postDelayed(this.b, 500L);
  }
  
  private void h()
  {
    this.x = ((ImageButton)findViewById(2131099727));
    this.x.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APMCardAccountSaveActivity.b(APMCardAccountSaveActivity.this).setText("");
        APMCardAccountSaveActivity.i(APMCardAccountSaveActivity.this).setVisibility(8);
      }
    });
    this.y = ((ImageButton)findViewById(2131099728));
    this.y.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).setText("");
        APMCardAccountSaveActivity.j(APMCardAccountSaveActivity.this).setVisibility(8);
      }
    });
  }
  
  protected void a()
  {
    this.B = 2131034135;
    this.C = 2131034150;
    this.D = 2130903056;
    this.E = 2130903073;
    this.z = ((ImageView)findViewById(2131099991));
    this.A = ((ImageView)findViewById(2131099994));
    this.s = ((LinearLayout)findViewById(2131099992));
    this.t = ((LinearLayout)findViewById(2131099995));
    this.u = ((TextView)findViewById(2131099990));
    this.v = ((TextView)findViewById(2131099993));
    this.w = ((Button)findViewById(2131099726));
    this.w.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.mcard.input.pay", APMCardAccountSaveActivity.f(APMCardAccountSaveActivity.this), em.b().n().e.l, em.b().n().e.f, null);
        APMCardAccountSaveActivity.this.c();
      }
    });
    ((ImageButton)findViewById(2131099802)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (APRecoChannelActivity.a()) {
          return;
        }
        APDataReportManager.getInstance().insertData("sdk.mcard.input.back", APMCardAccountSaveActivity.g(APMCardAccountSaveActivity.this), em.b().n().e.l, em.b().n().e.f, null);
        APMCardAccountSaveActivity.this.finish();
        APUICommonMethod.b(APMCardAccountSaveActivity.this);
      }
    });
    Object localObject = (TextView)findViewById(2131099903);
    ((TextView)localObject).setText(String.format(getString(2131230807), new Object[] { this.p.d.c() }));
    TextView localTextView = (TextView)findViewById(2131099908);
    if (!fy.a().A())
    {
      ((TextView)localObject).setVisibility(8);
      localTextView.setText("支持10~100面值充值卡，充值数量将由充值卡面值决定");
    }
    else
    {
      if ((this.f == 3) || (this.f == 2)) {
        ((TextView)localObject).setVisibility(8);
      }
      if (this.f == 3) {
        localTextView.setText("支持10~100面值充值卡，充值数量将由充值卡面值决定（1元=1Q币）");
      }
      if (this.f == 2) {
        localTextView.setText("支持10~100面值充值卡，充值数量将由充值卡面值决定（1元=10Q点）");
      }
    }
    ((TextView)findViewById(2131099772)).setText(String.format(getString(2131230927), new Object[] { this.p.b.a() }));
    this.d = ((EditText)findViewById(2131099760));
    this.d.addTextChangedListener(this.F);
    this.d.setFilters(new InputFilter[] { new InputFilter.LengthFilter(30) });
    this.d.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        paramAnonymousView = (ImageButton)APMCardAccountSaveActivity.this.findViewById(2131099727);
        if (APMCardAccountSaveActivity.b(APMCardAccountSaveActivity.this).getText().toString().length() > 0)
        {
          paramAnonymousView.setVisibility(0);
          return false;
        }
        paramAnonymousView.setVisibility(8);
        return false;
      }
    });
    this.d.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          APMCardAccountSaveActivity.h(APMCardAccountSaveActivity.this);
          return;
        }
        ((ImageButton)APMCardAccountSaveActivity.this.findViewById(2131099727)).setVisibility(8);
      }
    });
    this.e = ((EditText)findViewById(2131099762));
    this.e.addTextChangedListener(this.G);
    this.e.setFilters(new InputFilter[] { new InputFilter.LengthFilter(30) });
    this.e.setOnEditorActionListener(this);
    this.e.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        paramAnonymousView = (ImageButton)APMCardAccountSaveActivity.this.findViewById(2131099728);
        if (APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).getText().toString().length() > 0) {
          paramAnonymousView.setVisibility(0);
        } else {
          paramAnonymousView.setVisibility(8);
        }
        APMCardAccountSaveActivity.c(APMCardAccountSaveActivity.this).setCursorVisible(true);
        return false;
      }
    });
    localObject = (APScrollView)findViewById(2131099755);
    this.e.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          this.a.smoothScrollTo(0, 390);
          return;
        }
        ((ImageButton)APMCardAccountSaveActivity.this.findViewById(2131099728)).setVisibility(8);
      }
    });
    h();
    this.a = ((AP3PointsLoading)findViewById(2131099895));
    this.d.requestFocus();
  }
  
  protected boolean b()
  {
    this.q = this.d.getText().toString().trim();
    this.r = this.e.getText().toString().trim();
    if (this.q.length() == 0)
    {
      a(false, "请输入手机充值卡序列号");
      return false;
    }
    if (this.q.length() < 15)
    {
      a(false, "请输入正确的手机充值卡序列号");
      return false;
    }
    if (this.r.length() == 0)
    {
      b(false, "请输入手机充值卡密码");
      return false;
    }
    if (this.r.length() < 15)
    {
      b(false, "请输入正确的手机充值卡密码");
      return false;
    }
    return true;
  }
  
  protected void c()
  {
    if (b())
    {
      com.pay.paychannel.mcard.APMcardChannel.j = this.q;
      com.pay.paychannel.mcard.APMcardChannel.k = this.r;
      String str = em.b().n().e.f;
      this.d.setEnabled(false);
      this.e.setEnabled(false);
      this.x.setVisibility(8);
      this.y.setVisibility(8);
      this.w.setVisibility(8);
      this.a.setVisibility(0);
      this.a.b();
      APRecoChannelActivity.b = true;
      fb.a().a(this, str, this.c, null);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fy.a().f()) && (a.a().d != null))
    {
      this.f = this.p.a.saveType;
      setContentView(2131165198);
      a();
      a.a().f = true;
      return;
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramTextView = (InputMethodManager)getSystemService("input_method");
    if (paramInt != 0)
    {
      if (paramInt != 4)
      {
        if (paramInt == 6) {
          paramTextView.hideSoftInputFromWindow(this.e.getWindowToken(), 0);
        }
      }
      else {
        paramTextView.hideSoftInputFromWindow(this.e.getWindowToken(), 0);
      }
    }
    else {
      paramTextView.hideSoftInputFromWindow(this.e.getWindowToken(), 0);
    }
    return true;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (APRecoChannelActivity.a()) {
        return true;
      }
      APDataReportManager.getInstance().insertData("sdk.mcard.input.keyback", this.f, em.b().n().e.l, em.b().n().e.f, null);
      finish();
      APUICommonMethod.b(this);
      overridePendingTransition(fv.a(this, "unipay_anim_in_from_left"), fv.a(this, "unipay_anim_out_to_right"));
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager.getInstance().insertData("sdk.mcard.input.show", this.f, em.b().n().e.l, em.b().n().e.f, null);
    if (getResources().getConfiguration().orientation == 2)
    {
      getWindow().setSoftInputMode(3);
      return;
    }
    if ((getResources().getConfiguration().orientation == 1) && (this.d != null)) {
      a(this.d, 100);
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APMCardAccountSaveActivity
 * JD-Core Version:    0.7.0.1
 */