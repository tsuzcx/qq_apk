package com.pay.ui.realname;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.a;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.common.pickview.view.APOptionsViewWindow;
import com.pay.ui.common.pickview.view.APOptionsViewWindow.a;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import midas.x.a;
import midas.x.bq;
import midas.x.bs;
import midas.x.dj;
import midas.x.ec;
import midas.x.ed;
import midas.x.er;
import midas.x.fm;
import midas.x.fp;
import midas.x.gn;
import midas.x.hj;
import midas.x.hs;
import midas.x.iq;
import midas.x.jw;
import midas.x.kl;

public class APRealnameRegistActivity
  extends APActivity
{
  private ImageButton A;
  private ImageButton B;
  private LinearLayout C;
  private TextWatcher D = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (paramAnonymousEditable.length() != 0)
      {
        APRealnameRegistActivity.a(APRealnameRegistActivity.this).setImageResource(2131034262);
        ((LinearLayout)APRealnameRegistActivity.this.findViewById(2131099944)).setVisibility(8);
        return;
      }
      APRealnameRegistActivity.a(APRealnameRegistActivity.this).setImageResource(2131034144);
      APRealnameRegistActivity.b(APRealnameRegistActivity.this).setHintTextColor(-6710887);
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private TextWatcher E = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (paramAnonymousEditable.length() != 0)
      {
        APRealnameRegistActivity.c(APRealnameRegistActivity.this).setImageResource(2131034262);
        ((LinearLayout)APRealnameRegistActivity.this.findViewById(2131099937)).setVisibility(8);
        return;
      }
      APRealnameRegistActivity.c(APRealnameRegistActivity.this).setImageResource(2131034144);
      APRealnameRegistActivity.d(APRealnameRegistActivity.this).setHintTextColor(-6710887);
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private TextWatcher F = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (paramAnonymousEditable.length() != 0)
      {
        APRealnameRegistActivity.e(APRealnameRegistActivity.this).setHintTextColor(-13421773);
        ((LinearLayout)APRealnameRegistActivity.this.findViewById(2131099940)).setVisibility(8);
        return;
      }
      APRealnameRegistActivity.e(APRealnameRegistActivity.this).setHintTextColor(-6710887);
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private TextWatcher G = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (paramAnonymousEditable.length() != 0)
      {
        ((LinearLayout)APRealnameRegistActivity.this.findViewById(2131099942)).setVisibility(8);
        return;
      }
      APRealnameRegistActivity.f(APRealnameRegistActivity.this).setHintTextColor(-6710887);
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  iq q = new iq();
  private AP3PointsLoading r;
  private Button s;
  private Button t;
  private CheckBox u;
  private EditText v;
  private EditText w;
  private EditText x;
  private EditText y;
  private ImageButton z;
  
  private void a(int paramInt, String paramString)
  {
    APAlertDialog.a locala = new APAlertDialog.a(this);
    locala.b("提示");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showRegistResult ret:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msg:");
    ((StringBuilder)localObject).append(paramString);
    APLog.i("APRealnameRegistActivity", ((StringBuilder)localObject).toString());
    if (paramInt == 0)
    {
      locala.a("您的帐号已注册成功！您可以继续支付");
      locala.a("继续支付", new gn()
      {
        public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          paramAnonymousAPAlertDialog.a();
          APRealnameRegistActivity.this.finish();
          APUICommonMethod.b(APRealnameRegistActivity.this);
          APUICommonMethod.b();
          APLog.d("APRealnameRegistActivity", "showRegistResult() popActivity");
          APDataReportManager.getInstance().insertData("sdk.realname.succ", APRealnameRegistActivity.p(APRealnameRegistActivity.this), ed.b().n().e.l, null, null);
          if (a.a().c.get() != null)
          {
            a.a().a((Activity)a.a().c.get(), ed.b().n().a, a.a().a);
            return;
          }
          APUICommonMethod.b();
          fm.a(13, "");
        }
      });
    }
    else
    {
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = "注册失败";
      }
      locala.a((String)localObject);
      locala.a("重新注册", new gn()
      {
        public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          APDataReportManager.getInstance().insertData("sdk.realname.reconfirm", APRealnameRegistActivity.q(APRealnameRegistActivity.this), ed.b().n().e.l, null, null);
          paramAnonymousAPAlertDialog.a();
        }
      });
      locala.b("返回游戏", new gn()
      {
        public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          APDataReportManager.getInstance().insertData("sdk.realname.btbackgame", APRealnameRegistActivity.r(APRealnameRegistActivity.this), ed.b().n().e.l, null, null);
          paramAnonymousAPAlertDialog.a();
          APUICommonMethod.b();
          fm.a(13, "");
        }
      });
    }
    locala.b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APDataReportManager.getInstance().insertData("sdk.realname.backgame", APRealnameRegistActivity.s(APRealnameRegistActivity.this), ed.b().n().e.l, null, null);
          APUICommonMethod.b();
          fm.a(13, "");
        }
      }
    });
    try
    {
      locala.c();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(View paramView)
  {
    try
    {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      return;
    }
    catch (Exception paramView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doPay checkInput dismissNumInput:");
      localStringBuilder.append(paramView.toString());
      APLog.w("APQCardPayActivity", localStringBuilder.toString());
    }
  }
  
  private void a(jw paramjw)
  {
    paramjw = (dj)paramjw;
    a(paramjw.R(), paramjw.S());
  }
  
  private void c()
  {
    if (!b()) {
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.r.getLayoutParams();
    localLayoutParams.height = this.C.getMeasuredHeight();
    this.C.setVisibility(8);
    this.r.setLayoutParams(localLayoutParams);
    this.r.setVisibility(0);
    this.r.b();
    bs.a().a(this.a, this.b, this.c, this.d, this.e, new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        APRealnameRegistActivity.n(APRealnameRegistActivity.this).a();
        APRealnameRegistActivity.n(APRealnameRegistActivity.this).setVisibility(8);
        APRealnameRegistActivity.o(APRealnameRegistActivity.this).setVisibility(0);
        APRealnameRegistActivity.a(APRealnameRegistActivity.this, paramAnonymousjw);
      }
      
      public void b(jw paramAnonymousjw)
      {
        APRealnameRegistActivity localAPRealnameRegistActivity = APRealnameRegistActivity.this;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("系统繁忙:");
        localStringBuilder.append(bq.a(paramAnonymousjw.R()));
        APUICommonMethod.a(localAPRealnameRegistActivity, localStringBuilder.toString());
        APRealnameRegistActivity.n(APRealnameRegistActivity.this).a();
        APRealnameRegistActivity.n(APRealnameRegistActivity.this).setVisibility(8);
        APRealnameRegistActivity.o(APRealnameRegistActivity.this).setVisibility(0);
      }
      
      public void c(jw paramAnonymousjw)
      {
        APRealnameRegistActivity.n(APRealnameRegistActivity.this).a();
        APRealnameRegistActivity.n(APRealnameRegistActivity.this).setVisibility(8);
        APRealnameRegistActivity.o(APRealnameRegistActivity.this).setVisibility(0);
      }
    });
  }
  
  private void d()
  {
    APOptionsViewWindow localAPOptionsViewWindow = (APOptionsViewWindow)findViewById(2131099898);
    localAPOptionsViewWindow.setPicker(this.q.a(), this.q.b(), true);
    localAPOptionsViewWindow.setSelectOptions(0);
    localAPOptionsViewWindow.setOnoptionsSelectListener(new APOptionsViewWindow.a()
    {
      public void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("selectProvince pos1 :");
        ((StringBuilder)localObject1).append(paramAnonymousInt1);
        ((StringBuilder)localObject1).append(" pos2:");
        ((StringBuilder)localObject1).append(paramAnonymousInt2);
        APLog.e("APRealnameRegistActivity", ((StringBuilder)localObject1).toString());
        Object localObject2 = (String)APRealnameRegistActivity.this.q.a().get(paramAnonymousInt1);
        localObject1 = (String)((ArrayList)APRealnameRegistActivity.this.q.b().get(paramAnonymousInt1)).get(paramAnonymousInt2);
        APRealnameRegistActivity.this.d = String.valueOf(APRealnameRegistActivity.this.q.a((String)localObject2));
        APRealnameRegistActivity.this.e = String.valueOf(APRealnameRegistActivity.this.q.b((String)localObject1));
        Object localObject3 = APRealnameRegistActivity.f(APRealnameRegistActivity.this);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject1);
        ((EditText)localObject3).setText(localStringBuilder.toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(" province :");
        ((StringBuilder)localObject3).append((String)localObject2);
        APLog.i("selectProvinceView", ((StringBuilder)localObject3).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" city :");
        ((StringBuilder)localObject2).append((String)localObject1);
        APLog.i("selectProvinceView", ((StringBuilder)localObject2).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" provinceCode :");
        ((StringBuilder)localObject1).append(APRealnameRegistActivity.this.d);
        APLog.i("selectProvinceView", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" cityCode :");
        ((StringBuilder)localObject1).append(APRealnameRegistActivity.this.e);
        APLog.i("selectProvinceView", ((StringBuilder)localObject1).toString());
      }
    });
    localAPOptionsViewWindow.setFocusable(true);
    localAPOptionsViewWindow.setVisibility(0);
  }
  
  private void h()
  {
    APOptionsViewWindow localAPOptionsViewWindow = (APOptionsViewWindow)findViewById(2131100012);
    final ArrayList localArrayList = new ArrayList();
    localArrayList.add("港澳台身份证");
    localArrayList.add("港澳居民来往内地通行证");
    localArrayList.add("身份证");
    localArrayList.add("护照");
    localArrayList.add("军人/警察身份证");
    localAPOptionsViewWindow.setPicker(localArrayList);
    localAPOptionsViewWindow.setSelectOptions(2);
    localAPOptionsViewWindow.setOnoptionsSelectListener(new APOptionsViewWindow.a()
    {
      public void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("selectCardType  pos1 :");
        localStringBuilder.append(paramAnonymousInt1);
        APLog.e("APRealnameRegistActivity", localStringBuilder.toString());
        APRealnameRegistActivity.this.b = String.valueOf(paramAnonymousInt1);
        APRealnameRegistActivity.e(APRealnameRegistActivity.this).setText((CharSequence)localArrayList.get(paramAnonymousInt1));
        APRealnameRegistActivity.b(APRealnameRegistActivity.this).clearFocus();
        APRealnameRegistActivity.e(APRealnameRegistActivity.this).clearFocus();
        APRealnameRegistActivity.d(APRealnameRegistActivity.this).setFocusable(true);
        APRealnameRegistActivity.d(APRealnameRegistActivity.this).setFocusableInTouchMode(true);
        APRealnameRegistActivity.d(APRealnameRegistActivity.this).requestFocus();
        APRealnameRegistActivity.this.a(APRealnameRegistActivity.d(APRealnameRegistActivity.this), 500);
      }
    });
    localAPOptionsViewWindow.setFocusable(true);
    localAPOptionsViewWindow.setVisibility(0);
  }
  
  private void i()
  {
    APOptionsViewWindow localAPOptionsViewWindow = (APOptionsViewWindow)findViewById(2131100012);
    if ((localAPOptionsViewWindow != null) && (localAPOptionsViewWindow.getVisibility() == 0)) {
      localAPOptionsViewWindow.setVisibility(8);
    }
    localAPOptionsViewWindow = (APOptionsViewWindow)findViewById(2131099898);
    if ((localAPOptionsViewWindow != null) && (localAPOptionsViewWindow.getVisibility() == 0)) {
      localAPOptionsViewWindow.setVisibility(8);
    }
  }
  
  private boolean j()
  {
    APOptionsViewWindow localAPOptionsViewWindow = (APOptionsViewWindow)findViewById(2131100012);
    if ((localAPOptionsViewWindow != null) && (localAPOptionsViewWindow.getVisibility() == 0)) {
      return true;
    }
    localAPOptionsViewWindow = (APOptionsViewWindow)findViewById(2131099898);
    return (localAPOptionsViewWindow != null) && (localAPOptionsViewWindow.getVisibility() == 0);
  }
  
  protected void a()
  {
    this.u = ((CheckBox)findViewById(2131099921));
    this.u.setChecked(true);
    this.v = ((EditText)findViewById(2131099912));
    this.x = ((EditText)findViewById(2131099820));
    this.w = ((EditText)findViewById(2131099823));
    this.y = ((EditText)findViewById(2131099897));
    this.v.addTextChangedListener(this.D);
    this.w.addTextChangedListener(this.F);
    this.x.addTextChangedListener(this.E);
    this.y.addTextChangedListener(this.G);
    this.z = ((ImageButton)findViewById(2131099911));
    this.z.setVisibility(0);
    this.z.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APRealnameRegistActivity.b(APRealnameRegistActivity.this).setText("");
      }
    });
    this.B = ((ImageButton)findViewById(2131099822));
    this.B.setVisibility(0);
    this.A = ((ImageButton)findViewById(2131099819));
    this.A.setVisibility(0);
    this.A.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APRealnameRegistActivity.d(APRealnameRegistActivity.this).setText("");
      }
    });
    this.r = ((AP3PointsLoading)findViewById(2131099895));
    this.C = ((LinearLayout)findViewById(2131099805));
    this.w.setFocusable(true);
    this.w.setText("身份证");
    this.B.setImageResource(2131034278);
    this.w.setFocusableInTouchMode(true);
    this.w.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APRealnameRegistActivity.a(APRealnameRegistActivity.this, APRealnameRegistActivity.b(APRealnameRegistActivity.this));
        APRealnameRegistActivity.g(APRealnameRegistActivity.this);
        APRealnameRegistActivity.h(APRealnameRegistActivity.this);
      }
    });
    this.w.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          APRealnameRegistActivity.a(APRealnameRegistActivity.this, APRealnameRegistActivity.b(APRealnameRegistActivity.this));
          APRealnameRegistActivity.g(APRealnameRegistActivity.this);
          APRealnameRegistActivity.h(APRealnameRegistActivity.this);
          return;
        }
        if (APRealnameRegistActivity.e(APRealnameRegistActivity.this).getText().toString().trim().length() > 0) {
          APRealnameRegistActivity.i(APRealnameRegistActivity.this).setImageResource(2131034278);
        }
      }
    });
    this.y.setFocusable(true);
    this.y.setFocusableInTouchMode(true);
    this.y.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APRealnameRegistActivity.a(APRealnameRegistActivity.this, APRealnameRegistActivity.f(APRealnameRegistActivity.this));
        APRealnameRegistActivity.g(APRealnameRegistActivity.this);
        APRealnameRegistActivity.j(APRealnameRegistActivity.this);
      }
    });
    this.y.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          APRealnameRegistActivity.a(APRealnameRegistActivity.this, APRealnameRegistActivity.f(APRealnameRegistActivity.this));
          APRealnameRegistActivity.g(APRealnameRegistActivity.this);
          APRealnameRegistActivity.j(APRealnameRegistActivity.this);
        }
      }
    });
    this.v.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 5)
        {
          APRealnameRegistActivity.a(APRealnameRegistActivity.this, APRealnameRegistActivity.b(APRealnameRegistActivity.this));
          APRealnameRegistActivity.g(APRealnameRegistActivity.this);
          APRealnameRegistActivity.h(APRealnameRegistActivity.this);
        }
        return false;
      }
    });
    this.v.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        paramAnonymousView = APRealnameRegistActivity.b(APRealnameRegistActivity.this).getText().toString().trim();
        if (paramAnonymousBoolean)
        {
          if (paramAnonymousView.length() > 0) {
            APRealnameRegistActivity.a(APRealnameRegistActivity.this).setImageResource(2131034262);
          }
          APRealnameRegistActivity.g(APRealnameRegistActivity.this);
          return;
        }
        if (paramAnonymousView.length() >= 2) {
          APRealnameRegistActivity.a(APRealnameRegistActivity.this).setImageResource(2131034278);
        }
      }
    });
    this.x.setKeyListener(DigitsKeyListener.getInstance("0123456789abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    this.x.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 5)
        {
          APRealnameRegistActivity.a(APRealnameRegistActivity.this, APRealnameRegistActivity.d(APRealnameRegistActivity.this));
          APRealnameRegistActivity.g(APRealnameRegistActivity.this);
          APRealnameRegistActivity.j(APRealnameRegistActivity.this);
        }
        return false;
      }
    });
    this.x.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          APRealnameRegistActivity.g(APRealnameRegistActivity.this);
          return;
        }
        if ("身份证".equals(APRealnameRegistActivity.e(APRealnameRegistActivity.this).getText().toString()))
        {
          paramAnonymousView = APRealnameRegistActivity.d(APRealnameRegistActivity.this).getText().toString().trim().toUpperCase();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onFocusChange num:");
          localStringBuilder.append(paramAnonymousView);
          APLog.e("unipay_id_cardNumEdit", localStringBuilder.toString());
          if (APRealnameRegistActivity.this.a(paramAnonymousView)) {
            APRealnameRegistActivity.c(APRealnameRegistActivity.this).setImageResource(2131034278);
          }
        }
      }
    });
    this.s = ((Button)findViewById(2131099725));
    this.s.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.realname.btback", APRealnameRegistActivity.k(APRealnameRegistActivity.this), ed.b().n().e.l, null, null);
        APUICommonMethod.b();
        fm.a(13, "");
      }
    });
    this.t = ((Button)findViewById(2131099757));
    this.t.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.realname.submit", APRealnameRegistActivity.l(APRealnameRegistActivity.this), ed.b().n().e.l, null, null);
        APRealnameRegistActivity.m(APRealnameRegistActivity.this);
      }
    });
    ((TextView)findViewById(2131099948)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("pageName", hj.y);
        Intent localIntent = new Intent();
        if (hs.b(APRealnameRegistActivity.this.getApplicationContext())) {
          localIntent.setClass(APRealnameRegistActivity.this, APX5WebJSBridgeActivity.class);
        } else {
          localIntent.setClass(APRealnameRegistActivity.this, APWebJSBridgeActivity.class);
        }
        localIntent.putExtras(paramAnonymousView);
        APRealnameRegistActivity.this.startActivity(localIntent);
      }
    });
    this.v.requestFocus();
  }
  
  public boolean a(String paramString)
  {
    return Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$").matcher(paramString).matches();
  }
  
  protected boolean b()
  {
    this.a = this.v.getText().toString();
    if ((!TextUtils.isEmpty(this.a.trim())) && (this.a.trim().length() >= 2))
    {
      if (TextUtils.isEmpty(this.w.getText().toString().trim()))
      {
        ((LinearLayout)findViewById(2131099940)).setVisibility(0);
        return false;
      }
      this.c = this.x.getText().toString();
      if (TextUtils.isEmpty(this.c.trim()))
      {
        ((LinearLayout)findViewById(2131099937)).setVisibility(0);
        return false;
      }
      if ("身份证".equals(this.w.getText().toString()))
      {
        String str = this.x.getText().toString().trim().toUpperCase();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onFocusChange num:");
        localStringBuilder.append(str);
        APLog.e("unipay_id_cardNumEdit", localStringBuilder.toString());
        if (!a(str))
        {
          ((LinearLayout)findViewById(2131099937)).setVisibility(0);
          return false;
        }
      }
      if (!this.u.isChecked())
      {
        APUICommonMethod.a(this, "请同意用户隐私和保护政策");
        return false;
      }
      return true;
    }
    ((LinearLayout)findViewById(2131099944)).setVisibility(0);
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fp.a().f()) && (a.a().d != null))
    {
      setContentView(2131165247);
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
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (j())
      {
        i();
        return true;
      }
      APDataReportManager.getInstance().insertData("sdk.realname.back", this.f, ed.b().n().e.l, null, null);
      APUICommonMethod.b();
      fm.a(13, "");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    APDataReportManager.getInstance().insertData("sdk.realname.show", this.f, ed.b().n().e.l, null, null);
    super.onResume();
    if (getResources().getConfiguration().orientation == 2)
    {
      getWindow().setSoftInputMode(3);
      return;
    }
    if ((getResources().getConfiguration().orientation == 1) && (this.v != null)) {
      a(this.v, 100);
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.realname.APRealnameRegistActivity
 * JD-Core Version:    0.7.0.1
 */