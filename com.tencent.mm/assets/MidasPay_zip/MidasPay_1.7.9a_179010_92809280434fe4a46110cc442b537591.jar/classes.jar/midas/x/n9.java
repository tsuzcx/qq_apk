package midas.x;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.qdqb.APQDQBChannel;
import com.pay.permission.APPermissionActivity;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.channel.APGoldCouponsDeductSelectValueActivity;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.pay.ui.qdsafe.APSafeCenterWebActivity;
import com.pay.ui.qdsafe.APSafeCenterX5WebActivity;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.io.PrintStream;

public class n9
  extends j9
{
  public TextView A;
  public EditText c;
  public TextView d;
  public LinearLayout e;
  public AP3PointsLoading f;
  public LinearLayout g;
  public Button h;
  public TextView i;
  public int j = 60;
  public int k;
  public String l;
  public Handler m;
  public p n;
  public w5 o;
  public x5 p;
  public ContentResolver q;
  public Button r;
  public View s;
  public Context t;
  public boolean u = false;
  public String v;
  public boolean w;
  public c4 x;
  public LinearLayout y;
  public ImageView z;
  
  public View a(APRecoChannelActivity paramAPRecoChannelActivity, Context paramContext, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getContentView activity:");
    ((StringBuilder)localObject).append(paramAPRecoChannelActivity);
    APLog.i("APViewQDQB", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getContentView context:");
    ((StringBuilder)localObject).append(paramContext);
    APLog.i("APViewQDQB", ((StringBuilder)localObject).toString());
    localObject = LayoutInflater.from(paramContext).inflate(2131165250, null);
    this.s = ((View)localObject);
    this.t = paramContext;
    this.a = paramAPRecoChannelActivity;
    try
    {
      a(paramContext, (View)localObject, paramBundle);
      return localObject;
    }
    finally
    {
      paramAPRecoChannelActivity.printStackTrace();
      paramContext = APDataReportManager.getInstance();
      paramBundle = p4.p().e().f.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("APViewQDQB_getContentView_");
      localStringBuilder.append(APTools.d(paramAPRecoChannelActivity));
      paramContext.a("sdk.err.view", paramBundle, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public final void a(Context paramContext, View paramView, Bundle paramBundle)
  {
    o4 localo4 = p4.p().e();
    final int i1 = localo4.b.saveType;
    this.f = ((AP3PointsLoading)paramView.findViewById(2131099895));
    this.g = ((LinearLayout)paramView.findViewById(2131100016));
    this.e = ((LinearLayout)paramView.findViewById(2131099805));
    this.y = ((LinearLayout)paramView.findViewById(2131100018));
    this.z = ((ImageView)paramView.findViewById(2131100017));
    this.A = ((TextView)paramView.findViewById(2131100019));
    a(false, false, null);
    ((ImageButton)paramView.findViewById(2131099702)).setOnClickListener(new g(i1));
    this.r = ((Button)paramView.findViewById(2131099724));
    this.r.setEnabled(true);
    this.r.setOnClickListener(new h(i1));
    ((LinearLayout)paramView.findViewById(2131099909)).setOnClickListener(new i(i1));
    Object localObject1 = (TextView)paramView.findViewById(2131099831);
    if ((!d.a()) && (!d.b()))
    {
      if (a.r().e())
      {
        k();
      }
      else
      {
        String str;
        StringBuilder localStringBuilder;
        if ("qdqb".equals(localo4.f.e))
        {
          localObject2 = paramContext.getString(2131230870);
          str = p4.p().e().e.c();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("(余额");
          localStringBuilder.append(str);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(")");
          str = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(paramContext.getString(2131230858));
          localStringBuilder.append(str);
          ((TextView)localObject1).setText(localStringBuilder.toString());
        }
        else
        {
          localObject2 = paramContext.getString(2131230863);
          str = p4.p().e().e.b();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("(余额");
          localStringBuilder.append(str);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(")");
          str = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(paramContext.getString(2131230858));
          localStringBuilder.append(str);
          ((TextView)localObject1).setText(localStringBuilder.toString());
        }
      }
    }
    else if ("qdqb".equals(localo4.f.e))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramContext.getString(2131230870));
      ((StringBuilder)localObject2).append(paramContext.getString(2131230858));
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramContext.getString(2131230863));
      ((StringBuilder)localObject2).append(paramContext.getString(2131230858));
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
    localObject1 = (TextView)paramView.findViewById(2131100041);
    int i2 = localo4.b.saveType;
    if ((i2 != 4) && (i2 != 5)) {
      ((TextView)localObject1).setVisibility(8);
    } else if (((z4)localo4.c).n.equals("1"))
    {
      if (!APTools.e(localo4.f.e))
      {
        ((TextView)localObject1).setText("(不支持自动续费)");
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setTextColor(paramView.getResources().getColor(2130903085));
      }
      else
      {
        ((TextView)localObject1).setVisibility(8);
      }
    }
    else {
      ((TextView)localObject1).setVisibility(8);
    }
    localObject1 = r6.j().b(localo4.f.e);
    Object localObject2 = (TextView)paramView.findViewById(2131099842);
    if (localObject1 != null)
    {
      if (!TextUtils.isEmpty(((q6)localObject1).g))
      {
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(((q6)localObject1).g);
      }
      else
      {
        ((TextView)localObject2).setVisibility(8);
      }
    }
    else {
      ((TextView)localObject2).setVisibility(8);
    }
    this.d = ((TextView)paramView.findViewById(2131100042));
    localObject1 = (TextView)paramView.findViewById(2131100002);
    ((TextView)localObject1).setText(localo4.c.b);
    if ((i1 != 0) && (i1 != 1) && (i1 != 2) && (i1 != 3))
    {
      if (i1 != 4)
      {
        if (i1 != 5)
        {
          paramContext = null;
        }
        else if (g6.k().e() == g6.a.a)
        {
          ((TextView)localObject1).setVisibility(8);
          paramContext = localo4.c.b;
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append(" × ");
          paramContext.append(localo4.f.f);
          paramContext = paramContext.toString();
        }
      }
      else if (g6.k().e() == g6.a.a)
      {
        ((TextView)localObject1).setVisibility(8);
        paramContext = localo4.c.b;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramContext.getString(2131230829));
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(localo4.f.f);
        ((StringBuilder)localObject1).append(((z4)localo4.c).h());
        paramContext = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext.getString(2131230829));
      ((StringBuilder)localObject1).append(localo4.f.f);
      paramContext = ((StringBuilder)localObject1).toString();
    }
    localObject1 = (TextView)paramView.findViewById(2131100005);
    if (APUICommonMethod.e())
    {
      ((TextView)localObject1).setText(((x4)localo4.c).h());
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append(localo4.b.extendInfo.unit);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
    if (!APAppDataInterface.singleton().n()) {
      ((TextView)localObject1).setVisibility(8);
    }
    b(paramView);
    this.d.setText(p4.p().e().c.a);
    this.h = ((Button)paramView.findViewById(2131099863));
    this.c = ((EditText)paramView.findViewById(2131100015));
    if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.getString("mbUrl"))))
    {
      a(paramBundle);
      return;
    }
    if ((!TextUtils.isEmpty(this.l)) && (this.u)) {
      g();
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    this.u = true;
    this.r.setEnabled(false);
    this.g.setVisibility(0);
    this.d.setText("请输入验证码");
    this.v = paramBundle.getString("mbUrl");
    this.k = paramBundle.getInt("smsRemain", -1);
    this.l = paramBundle.getString("mbSmsInfo");
    this.w = paramBundle.getBoolean("smsMbOnly", false);
    APDataReportManager.getInstance().insertData("sdk.smm.show", 0, p4.p().e().f.k, p4.p().e().f.e, null);
    paramBundle = new StringBuilder();
    paramBundle.append("processVC smsInfo:");
    paramBundle.append(this.l);
    APLog.i("APPayQDQBActivity", paramBundle.toString());
    paramBundle = new StringBuilder();
    paramBundle.append("processVC count:");
    paramBundle.append(this.k);
    APLog.i("APPayQDQBActivity", paramBundle.toString());
    paramBundle = new StringBuilder();
    paramBundle.append("processVC h5Url:");
    paramBundle.append(this.v);
    APLog.i("APPayQDQBActivity", paramBundle.toString());
    this.c.setText("");
    this.c.setFilters(new InputFilter[] { new InputFilter.LengthFilter(8) });
    this.c.setSelectAllOnFocus(false);
    this.c.requestFocus();
    this.c.setFocusable(true);
    this.c.setHint(this.t.getString(2131230757));
    this.c.addTextChangedListener(new b());
    this.m = new Handler();
    this.n = new p(null);
    this.p = new x5(this);
    this.q = this.t.getContentResolver();
    this.h.setEnabled(true);
    this.h.requestFocus();
    this.h.setFocusable(true);
    this.h.setOnClickListener(new c());
    this.i = ((TextView)this.s.findViewById(2131099827));
    this.i.setVisibility(0);
    if (this.w)
    {
      this.i.setText(this.t.getString(2131230740));
      APDataReportManager.getInstance().insertData("sdk.smm.shensu", 0, p4.p().e().f.k, p4.p().e().f.e, null);
    }
    this.i.setOnClickListener(new d());
  }
  
  public final void a(View paramView)
  {
    if (p.o().h())
    {
      if (!p.o().j()) {
        return;
      }
      if (!p.o().f()) {
        return;
      }
      p.o().a(false);
      Object localObject = p4.p().e().c.a(p4.p().e().f.f);
      p.o().a(true);
      int i1 = APTools.p((String)localObject);
      i1 = p.o().a(i1);
      localObject = (LinearLayout)paramView.findViewById(2131099855);
      ((LinearLayout)localObject).setVisibility(0);
      ((ImageView)paramView.findViewById(2131099854)).setVisibility(0);
      if (i1 <= 0)
      {
        ((TextView)paramView.findViewById(2131099856)).setVisibility(8);
        ((TextView)paramView.findViewById(2131099857)).setText("选择抵扣券 >");
      }
      else
      {
        ((TextView)paramView.findViewById(2131099856)).setVisibility(0);
        paramView = (TextView)paramView.findViewById(2131099857);
        m localm = o.m().a(p4.p().e().f.e);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localm.b);
        localStringBuilder.append("已减");
        localStringBuilder.append(APTools.a(i1, 2));
        localStringBuilder.append("元 >");
        paramView.setText(localStringBuilder.toString());
      }
      ((LinearLayout)localObject).setOnClickListener(new k());
    }
  }
  
  public final void a(View paramView, int paramInt)
  {
    int i1 = this.t.getResources().getConfiguration().orientation;
    if (i1 == 1)
    {
      paramView = (LinearLayout)paramView.findViewById(2131099909);
      if (paramInt != 0)
      {
        paramView.setVisibility(0);
        return;
      }
      paramView.setVisibility(8);
      return;
    }
    if (i1 == 2)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131099909);
      paramView = (Button)paramView.findViewById(2131099704);
      if (paramInt != 0)
      {
        localLinearLayout.setVisibility(0);
        return;
      }
      localLinearLayout.setVisibility(8);
    }
  }
  
  public final void a(ob paramob)
  {
    if (paramob == null) {
      return;
    }
    this.x = ((c4)paramob);
    int i1 = this.x.d();
    if (i1 != 0)
    {
      if ((i1 != 1094) && (i1 != 1099))
      {
        this.j = 0;
        this.h.setText("获取验证码");
        this.h.setVisibility(0);
        a(true, true, this.t.getString(2131230881));
      }
    }
    else
    {
      paramob = this.x.h();
      String str = this.x.g();
      if (!TextUtils.isEmpty(paramob))
      {
        EditText localEditText = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("手机");
        localStringBuilder.append(paramob);
        localStringBuilder.append("验证码");
        localEditText.setHint(localStringBuilder.toString());
      }
      this.k = Integer.valueOf(str).intValue();
      if ((APPermissionActivity.c(this.t, "android.permission.READ_SMS")) && (this.o == null))
      {
        this.o = new w5(this.q, this.p);
        this.q.registerContentObserver(Uri.parse("content://sms/"), true, this.o);
      }
      if (this.k == 0)
      {
        this.h.setText(this.t.getString(2131230921));
        this.h.setEnabled(false);
        paramob = this.m;
        if (paramob != null) {
          paramob.removeCallbacksAndMessages(null);
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    LinearLayout localLinearLayout = this.y;
    ImageView localImageView = this.z;
    TextView localTextView = this.A;
    if (paramBoolean1)
    {
      localLinearLayout.setVisibility(0);
      if (paramString != null) {
        localTextView.setText(paramString);
      }
      if (paramBoolean2)
      {
        localImageView.setImageResource(2131034135);
        localTextView.setTextColor(this.a.getResources().getColor(2130903056));
        return;
      }
      localImageView.setImageResource(2131034150);
      localTextView.setTextColor(this.a.getResources().getColor(2130903073));
      return;
    }
    localLinearLayout.setVisibility(8);
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onActivityResult resultCode=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" requestCode=");
    ((StringBuilder)localObject).append(paramInt1);
    APLog.i("APViewQDQB", ((StringBuilder)localObject).toString());
    if ((paramInt1 == 100002) && (paramInt2 == 10))
    {
      if (paramIntent != null)
      {
        localObject = (i6.a)paramIntent.getSerializableExtra("channel");
        paramIntent = paramIntent.getStringExtra("sig");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onActivityResult sig.size=");
        localStringBuilder.append(paramIntent.length());
        localStringBuilder.append(" channel=");
        localStringBuilder.append(localObject);
        APLog.i("APViewQDQB", localStringBuilder.toString());
        if (paramIntent.length() > 15) {
          APQDQBChannel.p = paramIntent;
        } else {
          APQDQBChannel.p = "";
        }
        if (localObject == i6.a.a) {
          APQDQBChannel.q = "2";
        } else {
          APQDQBChannel.q = "";
        }
        if (!APQDQBChannel.p.equals(""))
        {
          b(false);
          return true;
        }
      }
    }
    else if (paramInt1 == 1)
    {
      if (paramInt2 == 101)
      {
        b(this.s);
        return true;
      }
      if (paramInt2 == 102)
      {
        this.a.a(2, 1, null);
        return true;
      }
      if (paramInt2 == 103)
      {
        this.a.a(2, 2, null);
        return true;
      }
    }
    else
    {
      b(this.s);
    }
    return true;
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!TextUtils.isEmpty(this.l)) && (this.u)) {
      APDataReportManager.getInstance().insertData("sdk.smm.keyback", p4.p().e().b.saveType, p4.p().e().f.k, p4.p().e().f.e, null);
    } else {
      APDataReportManager.getInstance().insertData("sdk.payexpress.keyback", p4.p().e().b.saveType, p4.p().e().f.k, p4.p().e().f.e, null);
    }
    c();
    return true;
  }
  
  public final void b(View paramView)
  {
    if (o.m().i()) {
      e();
    } else if (p.o().h()) {
      a(paramView);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131100000);
    String str;
    StringBuilder localStringBuilder;
    int i1;
    if ("qdqb".equals(p4.p().e().f.e))
    {
      str = p4.p().e().c.d();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" Q点");
      localTextView.setText(localStringBuilder.toString());
      i1 = APTools.h(str);
    }
    else
    {
      str = p4.p().e().c.c();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" Q币");
      localTextView.setText(localStringBuilder.toString());
      i1 = APTools.p(str);
    }
    a(paramView, i1);
  }
  
  public final void b(boolean paramBoolean)
  {
    APRecoChannelActivity.h = true;
    ((LinearLayout)this.s.findViewById(2131099855)).setEnabled(false);
    j();
    String str2 = p4.p().e().f.e;
    String str1 = str2;
    if (((LinearLayout)this.s.findViewById(2131099909)).getVisibility() == 8)
    {
      str1 = str2;
      if (p.o().h()) {
        str1 = "goldcouponsdeduct";
      }
    }
    e5.h().a(this.t, str1, null, new e(), new f());
  }
  
  public final void c()
  {
    if (APRecoChannelActivity.h) {
      return;
    }
    i();
    f();
    int i1 = p4.p().e().b.saveType;
    if (c6.s0().Q().equals("AndroidPay"))
    {
      APUICommonMethod.f();
      z5.a(2, "");
      return;
    }
    this.a.finish();
    APUICommonMethod.a(this.a);
  }
  
  public void d()
  {
    ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.c.getWindowToken(), 0);
  }
  
  public final void e()
  {
    if (!o.m().i()) {
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)this.s.findViewById(2131099855);
    localLinearLayout.setVisibility(0);
    ((TextView)this.s.findViewById(2131099856)).setVisibility(8);
    ((ImageView)this.s.findViewById(2131099854)).setVisibility(8);
    Object localObject1;
    if (o.m().g(p4.p().e().f.e))
    {
      int i1 = APTools.p(p4.p().e().c.b(p4.p().e().f.f));
      if ("qdqb".equals(p4.p().e().f.e))
      {
        localObject1 = APTools.a(i1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(String.valueOf(localObject1));
        ((StringBuilder)localObject2).append(" Q点");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject1 = APTools.b(i1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(String.valueOf(localObject1));
        ((StringBuilder)localObject2).append(" Q币");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      Object localObject2 = (TextView)this.s.findViewById(2131099857);
      m localm = o.m().a(p4.p().e().f.e);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localm.b);
      localStringBuilder.append("已减");
      localStringBuilder.append(localm.c);
      localStringBuilder.append("元 >");
      ((TextView)localObject2).setText(localStringBuilder.toString());
      ((TextView)localObject2).setTextColor(Color.parseColor("#338aec".toUpperCase()));
      localObject2 = (TextView)this.s.findViewById(2131100003);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).getPaint().setFlags(16);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)this.s.findViewById(2131100007)).setVisibility(4);
    }
    else
    {
      localObject1 = (TextView)this.s.findViewById(2131099857);
      ((TextView)localObject1).setText("选择抵扣券 >");
      ((TextView)localObject1).setTextColor(Color.parseColor("#338aec".toUpperCase()));
      ((TextView)this.s.findViewById(2131100003)).setVisibility(8);
      ((TextView)this.s.findViewById(2131100007)).setVisibility(8);
    }
    localLinearLayout.setOnClickListener(new j());
  }
  
  public final void f()
  {
    if (a.r().e()) {
      boolean bool = p4.p().e().e.e;
    }
  }
  
  public final void g()
  {
    this.r = ((Button)this.s.findViewById(2131099724));
    this.r.setEnabled(true);
    this.g = ((LinearLayout)this.s.findViewById(2131100016));
    this.g.setVisibility(0);
    this.d = ((TextView)this.s.findViewById(2131100042));
    this.d.setText("请输入验证码");
    this.c = ((EditText)this.s.findViewById(2131100015));
    this.c.setText("");
    this.c.setFilters(new InputFilter[] { new InputFilter.LengthFilter(8) });
    this.c.setSelectAllOnFocus(false);
    this.c.requestFocus();
    this.c.setFocusable(true);
    this.c.setHint(this.t.getString(2131230757));
    this.c.addTextChangedListener(new m());
    if (this.m == null) {
      this.m = new Handler();
    }
    if (this.n == null) {
      this.n = new p(null);
    }
    this.h = ((Button)this.s.findViewById(2131099863));
    this.h.setEnabled(true);
    this.h.requestFocus();
    this.h.setFocusable(true);
    this.h.setOnClickListener(new n());
    this.i = ((TextView)this.s.findViewById(2131099827));
    this.i.setVisibility(0);
    if (this.w)
    {
      this.i.setText(this.t.getString(2131230740));
      APDataReportManager.getInstance().insertData("sdk.smm.shensu", 0, p4.p().e().f.k, p4.p().e().f.e, null);
    }
    this.i.setOnClickListener(new o());
    if (this.p == null) {
      this.p = new x5(this);
    }
    if (this.q == null) {
      this.q = this.t.getContentResolver();
    }
    a(this.x);
  }
  
  public final void h()
  {
    z1.d().b(this.l, new a());
    this.h.setEnabled(false);
    this.m.post(this.n);
  }
  
  public final void i()
  {
    this.j = 0;
    Object localObject = this.h;
    if (localObject != null)
    {
      ((Button)localObject).setText("获取验证码");
      this.h.setVisibility(0);
    }
    else
    {
      APLog.w("APViewQDQB", "resetState() getVerCodeButton==Null");
    }
    this.r.setEnabled(true);
    this.h.setEnabled(true);
    localObject = this.c;
    if (localObject != null) {
      ((EditText)localObject).setText("");
    } else {
      APLog.w("APViewQDQB", "resetState() vercodeEdit==Null");
    }
    this.l = "";
    APQDQBChannel.q = "";
    APQDQBChannel.p = "";
    APRecoChannelActivity.h = false;
    this.u = false;
  }
  
  public final void j()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    localLayoutParams.height = this.e.getMeasuredHeight();
    this.e.setVisibility(8);
    this.f.setLayoutParams(localLayoutParams);
    this.f.setVisibility(0);
    this.f.c();
  }
  
  public final void k()
  {
    TextView localTextView = (TextView)this.s.findViewById(2131099831);
    Object localObject1;
    if ("qdqb".equals(p4.p().e().f.e))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.t.getString(2131230870));
      ((StringBuilder)localObject1).append(this.t.getString(2131230858));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.t.getString(2131230863));
      ((StringBuilder)localObject1).append(this.t.getString(2131230858));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (a.r().e())
    {
      Object localObject2;
      if (p4.p().e().e.e)
      {
        if ((g6.k().c()) && (c6.s0().v()))
        {
          str = g6.k().b();
          localObject2 = "uin";
        }
        else
        {
          str = p4.p().e().e.i;
          localObject2 = p4.p().e().e.j;
        }
        if ((!TextUtils.isEmpty(str)) && ("uin".equals(localObject2)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str.charAt(0));
          ((StringBuilder)localObject2).append("***");
          ((StringBuilder)localObject2).append(str.substring(str.length() - 3, str.length()));
          str = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("(QQ:");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(")");
          localTextView.setText(((StringBuilder)localObject2).toString());
          return;
        }
        localTextView.setText((CharSequence)localObject1);
        return;
      }
      if ((!p4.p().e().f.j.equals("qdqb")) && (!p4.p().e().f.j.equals("qbqd")))
      {
        localTextView.setText((CharSequence)localObject1);
        return;
      }
      String str = p4.p().e().f.a;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str.charAt(0));
        ((StringBuilder)localObject2).append("***");
        ((StringBuilder)localObject2).append(str.substring(str.length() - 3, str.length()));
        str = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("(QQ:");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(")");
        localTextView.setText(((StringBuilder)localObject2).toString());
        localObject1 = (TextView)this.s.findViewById(2131099828);
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setOnClickListener(new l());
        return;
      }
      localTextView.setText((CharSequence)localObject1);
    }
  }
  
  public class a
    implements fc
  {
    public a() {}
    
    public void a(ob paramob)
    {
      n9.a(n9.this, paramob);
    }
    
    public void b(ob paramob) {}
    
    public void c(ob paramob) {}
  }
  
  public class b
    implements TextWatcher
  {
    public b() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      n9.a(n9.this, false, false, null);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.smm.getsmmcode", 0, p4.p().e().f.k, p4.p().e().f.e, null);
      i6.a = System.currentTimeMillis();
      paramView = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("click time=");
      localStringBuilder.append(i6.a);
      paramView.println(localStringBuilder.toString());
      n9.this.r.setEnabled(true);
      z1.d().b(n9.this.l, new a());
      n9.this.h.setEnabled(false);
      paramView = n9.this;
      paramView.m.post(paramView.n);
    }
    
    public class a
      implements fc
    {
      public a() {}
      
      public void a(ob paramob)
      {
        n9.a(n9.this, paramob);
      }
      
      public void b(ob paramob) {}
      
      public void c(ob paramob) {}
    }
  }
  
  public class d
    implements View.OnClickListener
  {
    public d() {}
    
    public void onClick(View paramView)
    {
      if (h8.d(n9.this.t)) {
        paramView = new Intent(n9.this.t, APSafeCenterX5WebActivity.class);
      } else {
        paramView = new Intent(n9.this.t, APSafeCenterWebActivity.class);
      }
      paramView.putExtra("requesturl", n9.this.v);
      ((Activity)n9.this.t).startActivityForResult(paramView, 100002);
    }
  }
  
  public class e
    implements h5
  {
    public e() {}
    
    public void a()
    {
      APRecoChannelActivity.h = false;
      ((LinearLayout)n9.this.s.findViewById(2131099855)).setEnabled(true);
      n9.this.f.d();
      n9.this.e.setVisibility(0);
      n9.this.f.setVisibility(8);
    }
    
    public void a(int paramInt)
    {
      if (paramInt == -999)
      {
        n9.e(n9.this);
        return;
      }
      ((LinearLayout)n9.this.s.findViewById(2131099855)).setEnabled(true);
      if (paramInt == 0)
      {
        APRecoChannelActivity.h = true;
        n9.this.f.d();
        return;
      }
      APRecoChannelActivity.h = false;
      n9.this.f.d();
      n9.this.e.setVisibility(0);
      n9.this.f.setVisibility(8);
    }
    
    public void a(int paramInt, String paramString1, String paramString2)
    {
      APRecoChannelActivity.h = false;
      ((LinearLayout)n9.this.s.findViewById(2131099855)).setEnabled(true);
      n9.this.f.d();
      n9.this.e.setVisibility(0);
      n9.this.f.setVisibility(8);
    }
  }
  
  public class f
    implements g5
  {
    public f() {}
    
    public void a(int paramInt, Bundle paramBundle)
    {
      if (paramInt != 1125)
      {
        if (paramInt != 10001)
        {
          n9.c(n9.this);
          return;
        }
        n9.a(n9.this, paramBundle);
        return;
      }
      n9.this.u = true;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getString("errMsg");
        n9.a(n9.this, true, true, paramBundle);
      }
    }
  }
  
  public class g
    implements View.OnClickListener
  {
    public g(int paramInt) {}
    
    public void onClick(View paramView)
    {
      if ((!TextUtils.isEmpty(n9.this.l)) && (n9.this.u)) {
        APDataReportManager.getInstance().insertData("sdk.smm.close", p4.p().e().b.saveType, p4.p().e().f.k, p4.p().e().f.e, null);
      } else {
        APDataReportManager.getInstance().insertData("sdk.payexpress.close", i1, p4.p().e().f.k, p4.p().e().f.e, null);
      }
      n9.a(n9.this);
    }
  }
  
  public class h
    implements View.OnClickListener
  {
    public h(int paramInt) {}
    
    public void onClick(View paramView)
    {
      n9.b(n9.this);
      APDataReportManager.getInstance().insertData("sdk.payexpress.sure", i1, p4.p().e().f.k, p4.p().e().f.e, null);
      if ((!TextUtils.isEmpty(n9.this.l)) && (n9.this.u))
      {
        APDataReportManager.getInstance().insertData("sdk.smm.ok", i1, p4.p().e().f.k, p4.p().e().f.e, null);
        paramView = n9.this.c.getText().toString().trim();
        if (TextUtils.isEmpty(paramView))
        {
          n9.a(n9.this, true, false, "请输入验证码");
          return;
        }
        APLog.i("vercodeEdit", "被调用*****");
        APQDQBChannel.q = "2";
        APQDQBChannel.p = paramView;
        n9.this.u = false;
      }
      n9.a(n9.this, true);
    }
  }
  
  public class i
    implements View.OnClickListener
  {
    public i(int paramInt) {}
    
    public void onClick(View paramView)
    {
      c6.s0().x(true);
      APDataReportManager.getInstance().insertData("sdk.payexpress.change", i1, p4.p().e().f.k, p4.p().e().f.e, null);
      n9.c(n9.this);
      n9.this.d();
      n9.b(n9.this);
      paramView = new Bundle();
      paramView.putBoolean("isFromExpress", true);
      n9.this.a.a(2, 1, paramView);
    }
  }
  
  public class j
    extends w6
  {
    public j() {}
    
    public void a(View paramView)
    {
      paramView = new Intent();
      if (h8.d(n9.this.t)) {
        paramView.setClass(n9.this.t, APX5WebJSBridgeActivity.class);
      } else {
        paramView.setClass(n9.this.t, APWebJSBridgeActivity.class);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("pageName", y7.y);
      paramView.putExtras(localBundle);
      ((Activity)n9.this.t).startActivityForResult(paramView, 1);
    }
  }
  
  public class k
    implements View.OnClickListener
  {
    public k() {}
    
    public void onClick(View paramView)
    {
      paramView = n9.this;
      Object localObject = paramView.a;
      if (localObject != null)
      {
        paramView = new Intent((Context)localObject, APGoldCouponsDeductSelectValueActivity.class);
        n9.this.a.startActivityForResult(paramView, 1001);
        paramView = n9.this.a;
        paramView.overridePendingTransition(z5.a(paramView, "unipay_anim_in_from_right"), z5.a(n9.this.a, "unipay_anim_out_to_left"));
        return;
      }
      paramView = paramView.t;
      if (paramView != null)
      {
        paramView = new Intent(paramView, APGoldCouponsDeductSelectValueActivity.class);
        localObject = n9.this.t;
        if ((localObject instanceof Activity))
        {
          ((Activity)localObject).startActivityForResult(paramView, 1001);
          paramView = n9.this.t;
          ((Activity)paramView).overridePendingTransition(z5.a(paramView, "unipay_anim_in_from_right"), z5.a(n9.this.t, "unipay_anim_out_to_left"));
          return;
        }
        APLog.e("APChannelView", "initDeductCoupons(): onClick context is not activity!");
        return;
      }
      APLog.e("APChannelView", "initDeductCoupons(): onClick context is null!");
    }
  }
  
  public class l
    implements View.OnClickListener
  {
    public l() {}
    
    public void onClick(View paramView)
    {
      c6.s0().u(true);
      n9.a(n9.this, false);
    }
  }
  
  public class m
    implements TextWatcher
  {
    public m() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      n9.a(n9.this, false, false, null);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public class n
    implements View.OnClickListener
  {
    public n() {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.smm.getsmmcode", 0, p4.p().e().f.k, p4.p().e().f.e, null);
      i6.a = System.currentTimeMillis();
      paramView = System.out;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("click time=");
      ((StringBuilder)localObject).append(i6.a);
      paramView.println(((StringBuilder)localObject).toString());
      n9.this.r.setEnabled(true);
      paramView = n9.this.t;
      localObject = new a(new Handler(Looper.getMainLooper()));
      APPermissionActivity.b(paramView, new String[] { "android.permission.READ_SMS" }, (ResultReceiver)localObject);
    }
    
    public class a
      extends ResultReceiver
    {
      public a(Handler paramHandler)
      {
        super();
      }
      
      public void onReceiveResult(int paramInt, Bundle paramBundle)
      {
        n9.d(n9.this);
      }
    }
  }
  
  public class o
    implements View.OnClickListener
  {
    public o() {}
    
    public void onClick(View paramView)
    {
      if (h8.d(n9.this.t)) {
        paramView = new Intent(n9.this.t, APSafeCenterX5WebActivity.class);
      } else {
        paramView = new Intent(n9.this.t, APSafeCenterWebActivity.class);
      }
      paramView.putExtra("requesturl", n9.this.v);
      ((Activity)n9.this.t).startActivityForResult(paramView, 100002);
    }
  }
  
  public class p
    implements Runnable
  {
    public p() {}
    
    public void run()
    {
      Object localObject = n9.this;
      if (((n9)localObject).j == 0)
      {
        ((n9)localObject).h.setTextSize(14.0F);
        localObject = n9.this;
        int i = ((n9)localObject).k;
        if ((i <= 0) && (i >= 0))
        {
          ((n9)localObject).h.setText(((n9)localObject).t.getString(2131230921));
          n9.this.h.setEnabled(false);
        }
        else
        {
          localObject = n9.this;
          ((n9)localObject).h.setText(((n9)localObject).t.getString(2131230919));
          n9.this.h.setEnabled(true);
        }
        localObject = n9.this;
        ((n9)localObject).j = 60;
        ((n9)localObject).m.removeCallbacksAndMessages(null);
        return;
      }
      ((n9)localObject).r.setEnabled(true);
      n9.this.h.setEnabled(false);
      n9.this.m.removeCallbacksAndMessages(null);
      n9.this.h.setTextSize(12.0F);
      localObject = n9.this.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(n9.this.j));
      localStringBuilder.append(n9.this.t.getString(2131230917));
      ((Button)localObject).setText(localStringBuilder.toString());
      localObject = n9.this;
      ((n9)localObject).j -= 1;
      ((n9)localObject).m.postDelayed(((n9)localObject).n, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.n9
 * JD-Core Version:    0.7.0.1
 */