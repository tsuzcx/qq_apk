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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.common.pickview.view.APOptionsViewWindow;
import com.pay.ui.common.pickview.view.APOptionsViewWindow.a;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import midas.x.a;
import midas.x.c6;
import midas.x.c7;
import midas.x.d5;
import midas.x.fc;
import midas.x.h8;
import midas.x.h9;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.u3;
import midas.x.x1;
import midas.x.y7;
import midas.x.z1;
import midas.x.z5;

public class APRealnameRegistActivity
  extends APActivity
{
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public h9 i = new h9();
  public AP3PointsLoading j;
  public Button k;
  public Button l;
  public CheckBox m;
  public EditText n;
  public EditText o;
  public EditText p;
  public EditText q;
  public ImageButton r;
  public ImageButton s;
  public ImageButton t;
  public LinearLayout u;
  public TextWatcher v = new k();
  public TextWatcher w = new q();
  public TextWatcher x = new r();
  public TextWatcher y = new s();
  
  public final void a(int paramInt, String paramString)
  {
    APAlertDialog.f localf = new APAlertDialog.f(this);
    localf.b("提示");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showRegistResult ret:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msg:");
    ((StringBuilder)localObject).append(paramString);
    APLog.i("APRealnameRegistActivity", ((StringBuilder)localObject).toString());
    if (paramInt == 0)
    {
      localf.a("您的帐号已注册成功！您可以继续支付");
      localf.b("继续支付", new m());
    }
    else
    {
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = "注册失败";
      }
      localf.a((String)localObject);
      localf.b("重新注册", new n());
      localf.a("返回游戏", new o());
    }
    localf.b(new p());
    try
    {
      localf.b();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public final void a(View paramView)
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
  
  public boolean a(String paramString)
  {
    return Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$").matcher(paramString).matches();
  }
  
  public final void d(ob paramob)
  {
    paramob = (u3)paramob;
    a(paramob.d(), paramob.f());
  }
  
  public boolean f()
  {
    this.d = this.n.getText().toString();
    if ((!TextUtils.isEmpty(this.d.trim())) && (this.d.trim().length() >= 2))
    {
      if (TextUtils.isEmpty(this.o.getText().toString().trim()))
      {
        ((LinearLayout)findViewById(2131099940)).setVisibility(0);
        return false;
      }
      this.f = this.p.getText().toString();
      if (TextUtils.isEmpty(this.f.trim()))
      {
        ((LinearLayout)findViewById(2131099937)).setVisibility(0);
        return false;
      }
      if ("身份证".equals(this.o.getText().toString()))
      {
        String str = this.p.getText().toString().trim().toUpperCase();
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
      if (!this.m.isChecked())
      {
        APUICommonMethod.a(this, "请同意用户隐私和保护政策");
        return false;
      }
      return true;
    }
    ((LinearLayout)findViewById(2131099944)).setVisibility(0);
    return false;
  }
  
  public final void g()
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
  
  public final void h()
  {
    if (!f()) {
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.j.getLayoutParams();
    localLayoutParams.height = this.u.getMeasuredHeight();
    this.u.setVisibility(8);
    this.j.setLayoutParams(localLayoutParams);
    this.j.setVisibility(0);
    this.j.c();
    z1.d().a(this.d, this.e, this.f, this.g, this.h, new i());
  }
  
  public void i()
  {
    this.m = ((CheckBox)findViewById(2131099921));
    this.m.setChecked(true);
    this.n = ((EditText)findViewById(2131099912));
    this.p = ((EditText)findViewById(2131099820));
    this.o = ((EditText)findViewById(2131099823));
    this.q = ((EditText)findViewById(2131099897));
    this.n.addTextChangedListener(this.v);
    this.o.addTextChangedListener(this.x);
    this.p.addTextChangedListener(this.w);
    this.q.addTextChangedListener(this.y);
    this.r = ((ImageButton)findViewById(2131099911));
    this.r.setVisibility(0);
    this.r.setOnClickListener(new t());
    this.t = ((ImageButton)findViewById(2131099822));
    this.t.setVisibility(0);
    this.s = ((ImageButton)findViewById(2131099819));
    this.s.setVisibility(0);
    this.s.setOnClickListener(new u());
    this.j = ((AP3PointsLoading)findViewById(2131099895));
    this.u = ((LinearLayout)findViewById(2131099805));
    this.o.setFocusable(true);
    this.o.setText("身份证");
    this.t.setImageResource(2131034279);
    this.o.setFocusableInTouchMode(true);
    this.o.setOnClickListener(new v());
    this.o.setOnFocusChangeListener(new w());
    this.q.setFocusable(true);
    this.q.setFocusableInTouchMode(true);
    this.q.setOnClickListener(new x());
    this.q.setOnFocusChangeListener(new a());
    this.n.setOnEditorActionListener(new b());
    this.n.setOnFocusChangeListener(new c());
    this.p.setKeyListener(DigitsKeyListener.getInstance("0123456789abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    this.p.setOnEditorActionListener(new d());
    this.p.setOnFocusChangeListener(new e());
    this.k = ((Button)findViewById(2131099725));
    this.k.setOnClickListener(new f());
    this.l = ((Button)findViewById(2131099757));
    this.l.setOnClickListener(new g());
    ((TextView)findViewById(2131099948)).setOnClickListener(new h());
    this.n.requestFocus();
  }
  
  public final boolean j()
  {
    APOptionsViewWindow localAPOptionsViewWindow = (APOptionsViewWindow)findViewById(2131100012);
    if ((localAPOptionsViewWindow != null) && (localAPOptionsViewWindow.getVisibility() == 0)) {
      return true;
    }
    localAPOptionsViewWindow = (APOptionsViewWindow)findViewById(2131099898);
    return (localAPOptionsViewWindow != null) && (localAPOptionsViewWindow.getVisibility() == 0);
  }
  
  public final void k()
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
    localAPOptionsViewWindow.setOnoptionsSelectListener(new l(localArrayList));
    localAPOptionsViewWindow.setFocusable(true);
    localAPOptionsViewWindow.setVisibility(0);
  }
  
  public final void l()
  {
    APOptionsViewWindow localAPOptionsViewWindow = (APOptionsViewWindow)findViewById(2131099898);
    localAPOptionsViewWindow.setPicker(this.i.b(), this.i.a(), true);
    localAPOptionsViewWindow.setSelectOptions(0);
    localAPOptionsViewWindow.setOnoptionsSelectListener(new j());
    localAPOptionsViewWindow.setFocusable(true);
    localAPOptionsViewWindow.setVisibility(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((c6.s0().i()) && (a.r().d != null))
    {
      setContentView(2131165248);
      i();
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
      if (j())
      {
        g();
        return true;
      }
      APDataReportManager.getInstance().insertData("sdk.realname.back", this.a, p4.p().e().f.k, null, null);
      APUICommonMethod.f();
      z5.a(13, "");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    APDataReportManager.getInstance().insertData("sdk.realname.show", this.a, p4.p().e().f.k, null, null);
    super.onResume();
    if (getResources().getConfiguration().orientation == 2)
    {
      getWindow().setSoftInputMode(3);
      return;
    }
    if (getResources().getConfiguration().orientation == 1)
    {
      EditText localEditText = this.n;
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
    public a() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        paramView = APRealnameRegistActivity.this;
        APRealnameRegistActivity.a(paramView, APRealnameRegistActivity.p(paramView));
        APRealnameRegistActivity.q(APRealnameRegistActivity.this);
        APRealnameRegistActivity.c(APRealnameRegistActivity.this);
      }
    }
  }
  
  public class b
    implements TextView.OnEditorActionListener
  {
    public b() {}
    
    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 5)
      {
        paramTextView = APRealnameRegistActivity.this;
        APRealnameRegistActivity.a(paramTextView, APRealnameRegistActivity.b(paramTextView));
        APRealnameRegistActivity.q(APRealnameRegistActivity.this);
        APRealnameRegistActivity.r(APRealnameRegistActivity.this);
      }
      return false;
    }
  }
  
  public class c
    implements View.OnFocusChangeListener
  {
    public c() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      paramView = APRealnameRegistActivity.b(APRealnameRegistActivity.this).getText().toString().trim();
      if (paramBoolean)
      {
        if (paramView.length() > 0) {
          APRealnameRegistActivity.a(APRealnameRegistActivity.this).setImageResource(2131034263);
        }
        APRealnameRegistActivity.q(APRealnameRegistActivity.this);
        return;
      }
      if (paramView.length() >= 2) {
        APRealnameRegistActivity.a(APRealnameRegistActivity.this).setImageResource(2131034279);
      }
    }
  }
  
  public class d
    implements TextView.OnEditorActionListener
  {
    public d() {}
    
    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 5)
      {
        paramTextView = APRealnameRegistActivity.this;
        APRealnameRegistActivity.a(paramTextView, APRealnameRegistActivity.n(paramTextView));
        APRealnameRegistActivity.q(APRealnameRegistActivity.this);
        APRealnameRegistActivity.c(APRealnameRegistActivity.this);
      }
      return false;
    }
  }
  
  public class e
    implements View.OnFocusChangeListener
  {
    public e() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        APRealnameRegistActivity.q(APRealnameRegistActivity.this);
        return;
      }
      if ("身份证".equals(APRealnameRegistActivity.o(APRealnameRegistActivity.this).getText().toString()))
      {
        paramView = APRealnameRegistActivity.n(APRealnameRegistActivity.this).getText().toString().trim().toUpperCase();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onFocusChange num:");
        localStringBuilder.append(paramView);
        APLog.e("unipay_id_cardNumEdit", localStringBuilder.toString());
        if (APRealnameRegistActivity.this.a(paramView)) {
          APRealnameRegistActivity.l(APRealnameRegistActivity.this).setImageResource(2131034279);
        }
      }
    }
  }
  
  public class f
    implements View.OnClickListener
  {
    public f() {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.realname.btback", APRealnameRegistActivity.d(APRealnameRegistActivity.this), p4.p().e().f.k, null, null);
      APUICommonMethod.f();
      z5.a(13, "");
    }
  }
  
  public class g
    implements View.OnClickListener
  {
    public g() {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.realname.submit", APRealnameRegistActivity.e(APRealnameRegistActivity.this), p4.p().e().f.k, null, null);
      APRealnameRegistActivity.f(APRealnameRegistActivity.this);
    }
  }
  
  public class h
    implements View.OnClickListener
  {
    public h() {}
    
    public void onClick(View paramView)
    {
      paramView = new Bundle();
      paramView.putString("pageName", y7.v);
      Intent localIntent = new Intent();
      if (h8.d(APRealnameRegistActivity.this.getApplicationContext())) {
        localIntent.setClass(APRealnameRegistActivity.this, APX5WebJSBridgeActivity.class);
      } else {
        localIntent.setClass(APRealnameRegistActivity.this, APWebJSBridgeActivity.class);
      }
      localIntent.putExtras(paramView);
      APRealnameRegistActivity.this.startActivity(localIntent);
    }
  }
  
  public class i
    implements fc
  {
    public i() {}
    
    public void a(ob paramob)
    {
      APRealnameRegistActivity.g(APRealnameRegistActivity.this).d();
      APRealnameRegistActivity.g(APRealnameRegistActivity.this).setVisibility(8);
      APRealnameRegistActivity.h(APRealnameRegistActivity.this).setVisibility(0);
      APRealnameRegistActivity.a(APRealnameRegistActivity.this, paramob);
    }
    
    public void b(ob paramob)
    {
      APRealnameRegistActivity localAPRealnameRegistActivity = APRealnameRegistActivity.this;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("系统繁忙:");
      localStringBuilder.append(x1.a(paramob.d()));
      APUICommonMethod.a(localAPRealnameRegistActivity, localStringBuilder.toString());
      APRealnameRegistActivity.g(APRealnameRegistActivity.this).d();
      APRealnameRegistActivity.g(APRealnameRegistActivity.this).setVisibility(8);
      APRealnameRegistActivity.h(APRealnameRegistActivity.this).setVisibility(0);
    }
    
    public void c(ob paramob)
    {
      APRealnameRegistActivity.g(APRealnameRegistActivity.this).d();
      APRealnameRegistActivity.g(APRealnameRegistActivity.this).setVisibility(8);
      APRealnameRegistActivity.h(APRealnameRegistActivity.this).setVisibility(0);
    }
  }
  
  public class j
    implements APOptionsViewWindow.a
  {
    public j() {}
    
    public void a(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("selectProvince pos1 :");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" pos2:");
      ((StringBuilder)localObject1).append(paramInt2);
      APLog.e("APRealnameRegistActivity", ((StringBuilder)localObject1).toString());
      Object localObject2 = (String)APRealnameRegistActivity.this.i.b().get(paramInt1);
      localObject1 = (String)((ArrayList)APRealnameRegistActivity.this.i.a().get(paramInt1)).get(paramInt2);
      Object localObject3 = APRealnameRegistActivity.this;
      ((APRealnameRegistActivity)localObject3).g = String.valueOf(((APRealnameRegistActivity)localObject3).i.b((String)localObject2));
      localObject3 = APRealnameRegistActivity.this;
      ((APRealnameRegistActivity)localObject3).h = String.valueOf(((APRealnameRegistActivity)localObject3).i.a((String)localObject1));
      localObject3 = APRealnameRegistActivity.p(APRealnameRegistActivity.this);
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
      ((StringBuilder)localObject1).append(APRealnameRegistActivity.this.g);
      APLog.i("selectProvinceView", ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" cityCode :");
      ((StringBuilder)localObject1).append(APRealnameRegistActivity.this.h);
      APLog.i("selectProvinceView", ((StringBuilder)localObject1).toString());
    }
  }
  
  public class k
    implements TextWatcher
  {
    public k() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.length() != 0)
      {
        APRealnameRegistActivity.a(APRealnameRegistActivity.this).setImageResource(2131034263);
        ((LinearLayout)APRealnameRegistActivity.this.findViewById(2131099944)).setVisibility(8);
        return;
      }
      APRealnameRegistActivity.a(APRealnameRegistActivity.this).setImageResource(2131034144);
      APRealnameRegistActivity.b(APRealnameRegistActivity.this).setHintTextColor(-6710887);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public class l
    implements APOptionsViewWindow.a
  {
    public l(ArrayList paramArrayList) {}
    
    public void a(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("selectCardType  pos1 :");
      ((StringBuilder)localObject).append(paramInt1);
      APLog.e("APRealnameRegistActivity", ((StringBuilder)localObject).toString());
      APRealnameRegistActivity.this.e = String.valueOf(paramInt1);
      APRealnameRegistActivity.o(APRealnameRegistActivity.this).setText((CharSequence)localArrayList.get(paramInt1));
      APRealnameRegistActivity.b(APRealnameRegistActivity.this).clearFocus();
      APRealnameRegistActivity.o(APRealnameRegistActivity.this).clearFocus();
      APRealnameRegistActivity.n(APRealnameRegistActivity.this).setFocusable(true);
      APRealnameRegistActivity.n(APRealnameRegistActivity.this).setFocusableInTouchMode(true);
      APRealnameRegistActivity.n(APRealnameRegistActivity.this).requestFocus();
      localObject = APRealnameRegistActivity.this;
      ((APActivity)localObject).a(APRealnameRegistActivity.n((APRealnameRegistActivity)localObject), 500);
    }
  }
  
  public class m
    implements c7
  {
    public m() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      paramAPAlertDialog.f();
      APRealnameRegistActivity.this.finish();
      APUICommonMethod.a(APRealnameRegistActivity.this);
      APUICommonMethod.f();
      APLog.d("APRealnameRegistActivity", "showRegistResult() popActivity");
      APDataReportManager.getInstance().insertData("sdk.realname.succ", APRealnameRegistActivity.i(APRealnameRegistActivity.this), p4.p().e().f.k, null, null);
      if (a.r().c.get() != null)
      {
        a.r().a((Activity)a.r().c.get(), p4.p().e().b, a.r().a);
        return;
      }
      APUICommonMethod.f();
      z5.a(13, "");
    }
  }
  
  public class n
    implements c7
  {
    public n() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      APDataReportManager.getInstance().insertData("sdk.realname.reconfirm", APRealnameRegistActivity.j(APRealnameRegistActivity.this), p4.p().e().f.k, null, null);
      paramAPAlertDialog.f();
    }
  }
  
  public class o
    implements c7
  {
    public o() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      APDataReportManager.getInstance().insertData("sdk.realname.btbackgame", APRealnameRegistActivity.k(APRealnameRegistActivity.this), p4.p().e().f.k, null, null);
      paramAPAlertDialog.f();
      APUICommonMethod.f();
      z5.a(13, "");
    }
  }
  
  public class p
    implements c7
  {
    public p() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APDataReportManager.getInstance().insertData("sdk.realname.backgame", APRealnameRegistActivity.m(APRealnameRegistActivity.this), p4.p().e().f.k, null, null);
        APUICommonMethod.f();
        z5.a(13, "");
      }
    }
  }
  
  public class q
    implements TextWatcher
  {
    public q() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.length() != 0)
      {
        APRealnameRegistActivity.l(APRealnameRegistActivity.this).setImageResource(2131034263);
        ((LinearLayout)APRealnameRegistActivity.this.findViewById(2131099937)).setVisibility(8);
        return;
      }
      APRealnameRegistActivity.l(APRealnameRegistActivity.this).setImageResource(2131034144);
      APRealnameRegistActivity.n(APRealnameRegistActivity.this).setHintTextColor(-6710887);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public class r
    implements TextWatcher
  {
    public r() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.length() != 0)
      {
        APRealnameRegistActivity.o(APRealnameRegistActivity.this).setHintTextColor(-13421773);
        ((LinearLayout)APRealnameRegistActivity.this.findViewById(2131099940)).setVisibility(8);
        return;
      }
      APRealnameRegistActivity.o(APRealnameRegistActivity.this).setHintTextColor(-6710887);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public class s
    implements TextWatcher
  {
    public s() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.length() != 0)
      {
        ((LinearLayout)APRealnameRegistActivity.this.findViewById(2131099942)).setVisibility(8);
        return;
      }
      APRealnameRegistActivity.p(APRealnameRegistActivity.this).setHintTextColor(-6710887);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public class t
    implements View.OnClickListener
  {
    public t() {}
    
    public void onClick(View paramView)
    {
      APRealnameRegistActivity.b(APRealnameRegistActivity.this).setText("");
    }
  }
  
  public class u
    implements View.OnClickListener
  {
    public u() {}
    
    public void onClick(View paramView)
    {
      APRealnameRegistActivity.n(APRealnameRegistActivity.this).setText("");
    }
  }
  
  public class v
    implements View.OnClickListener
  {
    public v() {}
    
    public void onClick(View paramView)
    {
      paramView = APRealnameRegistActivity.this;
      APRealnameRegistActivity.a(paramView, APRealnameRegistActivity.b(paramView));
      APRealnameRegistActivity.q(APRealnameRegistActivity.this);
      APRealnameRegistActivity.r(APRealnameRegistActivity.this);
    }
  }
  
  public class w
    implements View.OnFocusChangeListener
  {
    public w() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        paramView = APRealnameRegistActivity.this;
        APRealnameRegistActivity.a(paramView, APRealnameRegistActivity.b(paramView));
        APRealnameRegistActivity.q(APRealnameRegistActivity.this);
        APRealnameRegistActivity.r(APRealnameRegistActivity.this);
        return;
      }
      if (APRealnameRegistActivity.o(APRealnameRegistActivity.this).getText().toString().trim().length() > 0) {
        APRealnameRegistActivity.s(APRealnameRegistActivity.this).setImageResource(2131034279);
      }
    }
  }
  
  public class x
    implements View.OnClickListener
  {
    public x() {}
    
    public void onClick(View paramView)
    {
      paramView = APRealnameRegistActivity.this;
      APRealnameRegistActivity.a(paramView, APRealnameRegistActivity.p(paramView));
      APRealnameRegistActivity.q(APRealnameRegistActivity.this);
      APRealnameRegistActivity.c(APRealnameRegistActivity.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.realname.APRealnameRegistActivity
 * JD-Core Version:    0.7.0.1
 */