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
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import midas.x.a;
import midas.x.bw;
import midas.x.by;
import midas.x.cq;
import midas.x.e;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.fa;
import midas.x.fb;
import midas.x.fd;
import midas.x.fe;
import midas.x.fv;
import midas.x.fy;
import midas.x.gw;
import midas.x.lh;
import midas.x.lw;

public class APQCardPayActivity
  extends APActivity
  implements TextView.OnEditorActionListener
{
  private LinearLayout A;
  private ImageView B;
  private TextView C;
  private LinearLayout D;
  private ImageView E;
  private TextView F;
  private String G;
  private String H;
  private ImageView I;
  private EditText J;
  private String K;
  private String L;
  private TextWatcher M = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (paramAnonymousEditable.length() != 0)
      {
        if (APQCardPayActivity.a(APQCardPayActivity.this).getText().toString().replace("\n", "").trim().length() >= 9)
        {
          APQCardPayActivity.a(APQCardPayActivity.this, 1, false, false, null);
          APQCardPayActivity.this.b(2131099919);
        }
        APQCardPayActivity.this.a.setVisibility(0);
        APQCardPayActivity.a(APQCardPayActivity.this).setTextSize(19.0F);
        APQCardPayActivity.a(APQCardPayActivity.this).setHintTextColor(-13421773);
        if (APQCardPayActivity.this.getResources().getConfiguration().orientation == 1) {
          APQCardPayActivity.a(APQCardPayActivity.this, paramAnonymousEditable, APQCardPayActivity.this.c);
        }
      }
      else
      {
        APQCardPayActivity.this.a.setVisibility(8);
        APQCardPayActivity.a(APQCardPayActivity.this).setTextSize(16.0F);
        APQCardPayActivity.a(APQCardPayActivity.this).setHintTextColor(-6710887);
      }
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private TextWatcher N = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (paramAnonymousEditable.length() != 0)
      {
        if (APQCardPayActivity.b(APQCardPayActivity.this).getText().toString().replace("\n", "").trim().length() >= 12)
        {
          APQCardPayActivity.a(APQCardPayActivity.this, 2, false, false, null);
          APQCardPayActivity.this.b(2131099950);
        }
        APQCardPayActivity.this.b.setVisibility(0);
        APQCardPayActivity.b(APQCardPayActivity.this).setTextSize(19.0F);
        APQCardPayActivity.b(APQCardPayActivity.this).setHintTextColor(-13421773);
        if (APQCardPayActivity.this.getResources().getConfiguration().orientation == 1) {
          APQCardPayActivity.a(APQCardPayActivity.this, paramAnonymousEditable, APQCardPayActivity.this.d);
        }
      }
      else
      {
        APQCardPayActivity.this.b.setVisibility(8);
        APQCardPayActivity.b(APQCardPayActivity.this).setTextSize(16.0F);
        APQCardPayActivity.b(APQCardPayActivity.this).setHintTextColor(-6710887);
      }
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  ImageButton a;
  ImageButton b;
  int c = 3;
  int d = 4;
  boolean e = false;
  private final int q = 9;
  private final int r = 12;
  private EditText s;
  private EditText t;
  private AP3PointsLoading u;
  private Button v;
  private LinearLayout w;
  private LinearLayout x;
  private ImageView y;
  private TextView z;
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    LinearLayout localLinearLayout;
    ImageView localImageView;
    TextView localTextView;
    switch (paramInt)
    {
    default: 
      localLinearLayout = this.D;
      localImageView = this.E;
      localTextView = this.F;
      break;
    case 3: 
      localLinearLayout = this.D;
      localImageView = this.E;
      localTextView = this.F;
      break;
    case 2: 
      localLinearLayout = this.A;
      localImageView = this.B;
      localTextView = this.C;
      break;
    case 1: 
      localLinearLayout = this.x;
      localImageView = this.y;
      localTextView = this.z;
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
  
  private void a(Bundle paramBundle)
  {
    this.e = true;
    APDataReportManager.getInstance().insertData("sdk.vc.show", this.f, em.b().n().e.l, em.b().n().e.f, null);
    ((LinearLayout)findViewById(2131100014)).setVisibility(0);
    this.K = paramBundle.getString("vc");
    this.L = paramBundle.getString("vs");
    this.J = ((EditText)findViewById(2131100021));
    this.J.setFilters(new InputFilter[] { new InputFilter.LengthFilter(4) });
    this.J.requestFocus();
    this.J.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        paramAnonymousEditable.length();
        APQCardPayActivity.a(APQCardPayActivity.this, 3, false, false, null);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.J.setOnEditorActionListener(this);
    this.I = ((ImageView)findViewById(2131100022));
    this.I.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.vc.picchange", APQCardPayActivity.h(APQCardPayActivity.this), em.b().n().e.l, String.valueOf(4), null);
        APQCardPayActivity.i(APQCardPayActivity.this).setText("");
        APQCardPayActivity.j(APQCardPayActivity.this);
        APQCardPayActivity.i(APQCardPayActivity.this).requestFocus();
      }
    });
    if ((!this.K.equals("")) && (this.K.length() > 20))
    {
      if (this.K.length() % 2 != 0)
      {
        paramBundle = new StringBuilder();
        paramBundle.append(this.K);
        paramBundle.append("F");
        this.K = paramBundle.toString();
      }
      paramBundle = e.a(this.K);
      paramBundle = BitmapFactory.decodeByteArray(paramBundle, 0, paramBundle.length, null);
      this.I.setImageBitmap(paramBundle);
    }
  }
  
  private void a(Editable paramEditable, int paramInt)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    int j = paramEditable.length();
    int i = 0;
    while (i < j)
    {
      char c1 = paramEditable.charAt(i);
      if (c1 != '\n') {
        localStringBuffer1.append(c1);
      }
      i += 1;
    }
    StringBuffer localStringBuffer2 = new StringBuffer();
    i = 0;
    while (i < localStringBuffer1.length())
    {
      if ((i > 0) && (i % paramInt == 0)) {
        localStringBuffer2.append('\n');
      }
      localStringBuffer2.append(localStringBuffer1.charAt(i));
      i += 1;
    }
    if (!localStringBuffer2.toString().equals(paramEditable.toString())) {
      paramEditable.replace(0, j, localStringBuffer2);
    }
  }
  
  private void a(lh paramlh)
  {
    paramlh = (cq)paramlh;
    if (paramlh.T() == 0)
    {
      this.L = paramlh.b();
      paramlh = paramlh.a();
      paramlh = BitmapFactory.decodeByteArray(paramlh, 0, paramlh.length, null);
      this.I.setImageBitmap(paramlh);
      return;
    }
    a(3, true, true, paramlh.U());
  }
  
  private void b(Bundle paramBundle)
  {
    this.e = true;
    this.J.setText("");
    this.K = paramBundle.getString("vc");
    this.L = paramBundle.getString("vs");
    if ((!this.K.equals("")) && (this.K.length() > 20))
    {
      if (this.K.length() % 2 != 0)
      {
        paramBundle = new StringBuilder();
        paramBundle.append(this.K);
        paramBundle.append("F");
        this.K = paramBundle.toString();
      }
      paramBundle = e.a(this.K);
      paramBundle = BitmapFactory.decodeByteArray(paramBundle, 0, paramBundle.length, null);
      this.I.setImageBitmap(paramBundle);
    }
    a(3, true, true, "请输入正确的验证码");
  }
  
  private void h()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.u.getLayoutParams();
    localLayoutParams.height = this.w.getMeasuredHeight();
    this.w.setVisibility(8);
    this.u.setLayoutParams(localLayoutParams);
    this.u.setVisibility(0);
    this.u.b();
    by.a().e("qqcard", new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        APQCardPayActivity.f(APQCardPayActivity.this).a();
        APQCardPayActivity.f(APQCardPayActivity.this).setVisibility(8);
        APQCardPayActivity.g(APQCardPayActivity.this).setVisibility(0);
        APQCardPayActivity.a(APQCardPayActivity.this, paramAnonymouslh);
      }
      
      public void b(lh paramAnonymouslh)
      {
        APQCardPayActivity localAPQCardPayActivity = APQCardPayActivity.this;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("系统繁忙:");
        localStringBuilder.append(bw.a(paramAnonymouslh.T()));
        APUICommonMethod.a(localAPQCardPayActivity, localStringBuilder.toString());
        APQCardPayActivity.f(APQCardPayActivity.this).a();
        APQCardPayActivity.f(APQCardPayActivity.this).setVisibility(8);
        APQCardPayActivity.g(APQCardPayActivity.this).setVisibility(0);
      }
      
      public void c(lh paramAnonymouslh)
      {
        APQCardPayActivity.f(APQCardPayActivity.this).a();
        APQCardPayActivity.f(APQCardPayActivity.this).setVisibility(8);
        APQCardPayActivity.g(APQCardPayActivity.this).setVisibility(0);
      }
    });
  }
  
  private void i()
  {
    StringBuilder localStringBuilder;
    try
    {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.s.getWindowToken(), 0);
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
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.t.getWindowToken(), 0);
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
  
  protected void a()
  {
    this.x = ((LinearLayout)findViewById(2131099917));
    this.y = ((ImageView)findViewById(2131099916));
    this.z = ((TextView)findViewById(2131099918));
    this.A = ((LinearLayout)findViewById(2131099923));
    this.B = ((ImageView)findViewById(2131099922));
    this.C = ((TextView)findViewById(2131099924));
    this.D = ((LinearLayout)findViewById(2131100018));
    this.E = ((ImageView)findViewById(2131100017));
    this.F = ((TextView)findViewById(2131100019));
    a(1, false, false, null);
    a(2, false, false, null);
    a(3, false, false, null);
    this.a = ((ImageButton)findViewById(2131099727));
    this.a.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APQCardPayActivity.a(APQCardPayActivity.this).setText("");
      }
    });
    this.b = ((ImageButton)findViewById(2131099728));
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APQCardPayActivity.b(APQCardPayActivity.this).setText("");
      }
    });
    this.u = ((AP3PointsLoading)findViewById(2131099895));
    this.w = ((LinearLayout)findViewById(2131099805));
    Object localObject = (TextView)findViewById(2131099851);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("待支付金额：");
    localStringBuilder.append(getString(2131230879));
    localStringBuilder.append(em.b().n().b.a());
    ((TextView)localObject).setText(localStringBuilder.toString());
    this.v = ((Button)findViewById(2131099726));
    this.v.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (APQCardPayActivity.this.e) {
          APDataReportManager.getInstance().insertData("sdk.vc.sure", APQCardPayActivity.c(APQCardPayActivity.this), em.b().n().e.l, String.valueOf(4), null);
        } else {
          APDataReportManager.getInstance().insertData("sdk.qcard.pay", APQCardPayActivity.d(APQCardPayActivity.this), em.b().n().e.l, String.valueOf(4), null);
        }
        APQCardPayActivity.this.d();
      }
    });
    localObject = new gw();
    this.s = ((EditText)findViewById(2131099792));
    this.s.addTextChangedListener(this.M);
    this.s.setTransformationMethod((TransformationMethod)localObject);
    this.s.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (APQCardPayActivity.a(APQCardPayActivity.this).getText().toString().trim().length() > 0) {
          APQCardPayActivity.this.a.setVisibility(0);
        }
        return false;
      }
    });
    this.s.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        paramAnonymousView = new StringBuilder();
        paramAnonymousView.append("Num onFocusChange hasFocus:");
        paramAnonymousView.append(paramAnonymousBoolean);
        APLog.i("APQCardPayActivity", paramAnonymousView.toString());
        if (paramAnonymousBoolean) {
          return;
        }
        APQCardPayActivity.this.a.setVisibility(8);
      }
    });
    this.t = ((EditText)findViewById(2131099793));
    this.t.addTextChangedListener(this.N);
    this.t.setOnEditorActionListener(this);
    this.t.setTransformationMethod((TransformationMethod)localObject);
    this.t.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (APQCardPayActivity.b(APQCardPayActivity.this).getText().toString().length() > 0) {
          APQCardPayActivity.this.b.setVisibility(0);
        }
        return false;
      }
    });
    this.t.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          APQCardPayActivity.this.b.setVisibility(8);
        }
      }
    });
    if (getResources().getConfiguration().orientation == 2)
    {
      this.s.setFilters(new InputFilter[] { new InputFilter.LengthFilter(10) });
      this.t.setFilters(new InputFilter[] { new InputFilter.LengthFilter(12) });
    }
    else
    {
      this.s.setFilters(new InputFilter[] { new InputFilter.LengthFilter(13) });
      this.t.setFilters(new InputFilter[] { new InputFilter.LengthFilter(14) });
    }
    ((ImageButton)findViewById(2131099802)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (APRecoChannelActivity.a()) {
          return;
        }
        APDataReportManager.getInstance().insertData("sdk.qcard.back", APQCardPayActivity.e(APQCardPayActivity.this), em.b().n().e.l, String.valueOf(4), null);
        APQCardPayActivity.this.finish();
        APUICommonMethod.b(APQCardPayActivity.this);
      }
    });
    this.s.requestFocus();
  }
  
  protected boolean b()
  {
    this.s = ((EditText)findViewById(2131099792));
    this.t = ((EditText)findViewById(2131099793));
    this.G = this.s.getText().toString().replace("\n", "").trim();
    this.H = this.t.getText().toString().replace("\n", "").trim();
    if (this.G.length() == 0)
    {
      a(2131099919);
      a(1, true, false, "请输入QQ卡卡号");
      return false;
    }
    if (this.G.length() < 9)
    {
      a(2131099919);
      a(1, true, true, "请输入正确的QQ卡卡号");
      return false;
    }
    if (this.H.length() == 0)
    {
      a(2131099950);
      a(2, true, false, "请输入QQ卡密码");
      return false;
    }
    if (this.H.length() < 12)
    {
      a(2131099950);
      a(2, true, true, "请输入正确的QQ卡密码");
      return false;
    }
    this.J = ((EditText)findViewById(2131100021));
    if ((this.e) && (this.J.getText().length() == 0)) {
      a(3, true, true, "请输入验证码");
    }
    return c();
  }
  
  protected boolean c()
  {
    return true;
  }
  
  protected void d()
  {
    if (b())
    {
      i();
      a(3, false, false, null);
      this.w.setVisibility(8);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.u.getLayoutParams();
      localLayoutParams.height = this.w.getMeasuredHeight();
      this.u.setLayoutParams(localLayoutParams);
      this.u.setVisibility(0);
      this.u.b();
      com.pay.paychannel.qqcard.APQQCardChannel.j = this.G;
      com.pay.paychannel.qqcard.APQQCardChannel.k = this.H;
      if (this.e)
      {
        com.pay.paychannel.qqcard.APQQCardChannel.l = this.J.getText().toString().trim();
        com.pay.paychannel.qqcard.APQQCardChannel.m = this.L;
      }
      else
      {
        com.pay.paychannel.qqcard.APQQCardChannel.l = "";
        com.pay.paychannel.qqcard.APQQCardChannel.m = "";
      }
      APRecoChannelActivity.b = true;
      fb.a().a(this, "qqcard", new fe()new fd
      {
        public void a()
        {
          APRecoChannelActivity.b = false;
          APQCardPayActivity.f(APQCardPayActivity.this).a();
          APQCardPayActivity.g(APQCardPayActivity.this).setVisibility(0);
          APQCardPayActivity.f(APQCardPayActivity.this).setVisibility(8);
        }
        
        public void a(int paramAnonymousInt)
        {
          APRecoChannelActivity.b = false;
          APQCardPayActivity.f(APQCardPayActivity.this).a();
          APQCardPayActivity.g(APQCardPayActivity.this).setVisibility(0);
          APQCardPayActivity.f(APQCardPayActivity.this).setVisibility(8);
        }
        
        public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          APRecoChannelActivity.b = false;
          APQCardPayActivity.f(APQCardPayActivity.this).a();
          APQCardPayActivity.g(APQCardPayActivity.this).setVisibility(0);
          APQCardPayActivity.f(APQCardPayActivity.this).setVisibility(8);
        }
      }, new fd()
      {
        public void a(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" callBack:");
          localStringBuilder.append(paramAnonymousInt);
          APLog.i("QQCard", localStringBuilder.toString());
          if (paramAnonymousInt != 1)
          {
            if (paramAnonymousInt != 10002)
            {
              if (paramAnonymousInt != 10006) {
                return;
              }
              APQCardPayActivity.b(APQCardPayActivity.this, paramAnonymousBundle);
              return;
            }
            APQCardPayActivity.a(APQCardPayActivity.this, paramAnonymousBundle);
            return;
          }
          APQCardPayActivity.this.d();
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fy.a().f()) && (a.a().d != null))
    {
      setContentView(2131165246);
      a();
      return;
    }
    finish();
    APUICommonMethod.b(this);
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
          paramTextView.hideSoftInputFromWindow(this.t.getWindowToken(), 0);
        }
      }
      else {
        paramTextView.hideSoftInputFromWindow(this.t.getWindowToken(), 0);
      }
    }
    else {
      paramTextView.hideSoftInputFromWindow(this.t.getWindowToken(), 0);
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
      if (this.e) {
        APDataReportManager.getInstance().insertData("sdk.vc.keyback", this.f, em.b().n().e.l, String.valueOf(4), null);
      } else {
        APDataReportManager.getInstance().insertData("sdk.qcard.keyback", this.f, em.b().n().e.l, String.valueOf(4), null);
      }
      APUICommonMethod.b(this);
      finish();
      overridePendingTransition(fv.a(this, "unipay_anim_in_from_left"), fv.a(this, "unipay_anim_out_to_right"));
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    APDataReportManager.getInstance().insertData("sdk.qcard.show", this.f, em.b().n().e.l, String.valueOf(4), null);
    super.onResume();
    if (getResources().getConfiguration().orientation == 2)
    {
      getWindow().setSoftInputMode(3);
      return;
    }
    if ((getResources().getConfiguration().orientation == 1) && (this.s != null)) {
      a(this.s, 100);
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APQCardPayActivity
 * JD-Core Version:    0.7.0.1
 */