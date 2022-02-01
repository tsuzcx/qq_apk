package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;

public class c9
  extends v8
{
  public f8 e = null;
  public Activity f = null;
  public r8 g = new r8();
  public TextView h;
  public long i;
  
  public c9()
  {
    APLog.d("APX5WebRiskControlSoftPage", "new instance!");
    c();
  }
  
  public void a(Activity paramActivity, f8 paramf8, Bundle paramBundle)
  {
    super.a(paramActivity, paramf8, paramBundle);
    this.f = paramActivity;
    this.e = paramf8;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    paramProgressDialog = this.e.c();
    this.h = ((TextView)paramProgressDialog.findViewById(2131099885));
    this.h.setText("安全验证");
    ((ImageButton)paramProgressDialog.findViewById(2131099802)).setOnClickListener(new a());
    paramProgressDialog = this.e;
    if (paramProgressDialog != null) {
      paramProgressDialog.b(f());
    }
    paramProgressDialog = this.e.f();
    if (paramProgressDialog != null)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramProgressDialog.getLayoutParams();
      localMarginLayoutParams.topMargin = 0;
      localMarginLayoutParams.bottomMargin = 0;
      paramProgressDialog.setLayoutParams(localMarginLayoutParams);
    }
    APDataReportManager.getInstance().insertData("sdk.h5.riskcontrolsoft.show", p4.o());
    this.i = SystemClock.elapsedRealtime();
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      APLog.e("APX5WebRiskControlSoftPage", "web call back empty message!");
      return;
    }
    Object localObject1;
    if (paramString.startsWith("rcs://"))
    {
      APLog.d("APX5WebRiskControlSoftPage", "enter rcs protocol return!");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("RiskContorlPage js alert = ");
      ((StringBuilder)localObject1).append(paramString);
      APLog.d("APX5WebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
      paramString = paramString.substring(6);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("rcs message = ");
      ((StringBuilder)localObject1).append(paramString);
      APLog.d("APX5WebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
      localObject1 = this.f;
      if (localObject1 != null)
      {
        ((Activity)localObject1).finish();
        b(0, paramString);
        APUICommonMethod.a(this.f);
      }
      return;
    }
    if (paramString.startsWith("http://unipay.sdk.android/?"))
    {
      APLog.d("APX5WebRiskControlSoftPage", "enter rcs set size or set title protocol!");
      localObject1 = APTools.n(paramString);
      if (localObject1 == null)
      {
        APLog.e("APX5WebRiskControlSoftPage", "enter rcs set size or set title protocol, empty message!");
        return;
      }
      paramString = (String)((HashMap)localObject1).get("action");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("enter rcs set size or set title protocol! action = ");
      ((StringBuilder)localObject2).append(paramString);
      APLog.d("APX5WebRiskControlSoftPage", ((StringBuilder)localObject2).toString());
      if (y7.K.equals(paramString))
      {
        paramString = (String)((HashMap)localObject1).get("h5_width");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("enter rcs set size protocol! h5_width = ");
        ((StringBuilder)localObject2).append(paramString);
        APLog.d("APX5WebRiskControlSoftPage", ((StringBuilder)localObject2).toString());
        localObject1 = (String)((HashMap)localObject1).get("h5_height");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("enter rcs set size protocol! h5_height = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        APLog.d("APX5WebRiskControlSoftPage", ((StringBuilder)localObject2).toString());
        int j;
        if (this.e.e() != null) {
          try
          {
            localObject2 = this.e.e().getLayoutParams();
            StringBuilder localStringBuilder;
            if (!TextUtils.isEmpty(paramString))
            {
              j = Float.valueOf(paramString).intValue();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("width dp = ");
              localStringBuilder.append(j);
              APLog.i("APX5WebRiskControlSoftPage", localStringBuilder.toString());
              j = e7.a(this.f, j);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("width px = ");
              localStringBuilder.append(j);
              APLog.i("APX5WebRiskControlSoftPage", localStringBuilder.toString());
              ((ViewGroup.LayoutParams)localObject2).width = j;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              j = Float.valueOf((String)localObject1).intValue();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("height dp = ");
              localStringBuilder.append(j);
              APLog.i("APX5WebRiskControlSoftPage", localStringBuilder.toString());
              j = e7.a(this.f, j);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("height px = ");
              localStringBuilder.append(j);
              APLog.i("APX5WebRiskControlSoftPage", localStringBuilder.toString());
              ((ViewGroup.LayoutParams)localObject2).height = j;
            }
            this.e.e().setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        if (this.e.f() == null) {
          return;
        }
        try
        {
          ViewGroup.LayoutParams localLayoutParams = this.e.f().getLayoutParams();
          if (!TextUtils.isEmpty(paramString))
          {
            j = Float.valueOf(paramString).intValue();
            paramString = new StringBuilder();
            paramString.append("width dp = ");
            paramString.append(j);
            APLog.i("APX5WebRiskControlSoftPage", paramString.toString());
            j = e7.a(this.f, j);
            paramString = new StringBuilder();
            paramString.append("width px = ");
            paramString.append(j);
            APLog.i("APX5WebRiskControlSoftPage", paramString.toString());
            localLayoutParams.width = j;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            j = Float.valueOf((String)localObject1).intValue();
            paramString = new StringBuilder();
            paramString.append("height dp = ");
            paramString.append(j);
            APLog.i("APX5WebRiskControlSoftPage", paramString.toString());
            j = e7.a(this.f, j + 48) + 1;
            paramString = new StringBuilder();
            paramString.append("height px = ");
            paramString.append(j);
            APLog.i("APX5WebRiskControlSoftPage", paramString.toString());
            localLayoutParams.height = j;
          }
          this.e.f().setLayoutParams(localLayoutParams);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      if (y7.L.equals(paramString))
      {
        paramString = (String)((HashMap)localObject1).get("title");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("enter rcs set title protocol! title = ");
        ((StringBuilder)localObject1).append(paramString);
        APLog.d("APX5WebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
        paramString = APTools.a(paramString, 1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("enter rcs set title protocol! title decode = ");
        ((StringBuilder)localObject1).append(paramString);
        APLog.d("APX5WebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
        localObject1 = this.h;
        if (localObject1 != null)
        {
          ((TextView)localObject1).setText(paramString);
          return;
        }
        APLog.e("APX5WebRiskControlSoftPage", "Cannot set title, text view is null!");
      }
    }
  }
  
  public void a(r8 paramr8)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRiskControlSoftParams = ");
    localStringBuilder.append(paramr8);
    APLog.d("APX5WebRiskControlSoftPage", localStringBuilder.toString());
    this.g = paramr8;
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        boolean bool = APAppDataInterface.singleton().h().equals("release");
        if (!bool)
        {
          bool = APAppDataInterface.singleton().h().equals("dev");
          if (bool) {
            this.c.put("sandbox", "2");
          } else {
            this.c.put("sandbox", "1");
          }
        }
        Object localObject1 = this.f;
        if (localObject1 != null)
        {
          j = this.f.getResources().getConfiguration().orientation;
          if (2 == j)
          {
            this.c.put("orientation", "2");
            localObject1 = new DisplayMetrics();
            this.f.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("screen width px = ");
            ((StringBuilder)localObject2).append(((DisplayMetrics)localObject1).heightPixels);
            APLog.i("APX5WebRiskControlSoftPage", ((StringBuilder)localObject2).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("screen width dp = ");
            ((StringBuilder)localObject2).append(e7.b(this.f, ((DisplayMetrics)localObject1).heightPixels));
            APLog.i("APX5WebRiskControlSoftPage", ((StringBuilder)localObject2).toString());
            j = e7.b(this.f, ((DisplayMetrics)localObject1).heightPixels) - 40 - 48 - 25;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("inner_height  = ");
            ((StringBuilder)localObject1).append(j);
            APLog.i("APX5WebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
            this.c.put("inner_height", String.valueOf(j));
          }
          else if (1 == j)
          {
            this.c.put("orientation", "1");
            localObject1 = new DisplayMetrics();
            this.f.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
            j = e7.b(this.f, ((DisplayMetrics)localObject1).widthPixels) - 40;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("inner_width  = ");
            ((StringBuilder)localObject1).append(j);
            APLog.i("APX5WebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
            this.c.put("inner_width", String.valueOf(j));
          }
          else
          {
            this.c.put("orientation", "0");
          }
        }
        else
        {
          APLog.e("APX5WebRiskControlSoftPage", "Activity is null, cannot get orientation parameter!");
        }
        this.c.put("ismidas", "1");
        localObject2 = p4.p().e().f.e;
        this.c.put("reqFrom", y7.p);
        this.c.put("openid", p4.p().e().b.openId);
        this.c.put("appid", p4.p().e().b.offerId);
        this.c.put("openkey", p4.p().e().b.openKey);
        this.c.put("session_id", p4.p().e().b.sessionId);
        this.c.put("session_type", p4.p().e().b.sessionType);
        this.c.put("pf", p4.p().e().b.pf);
        this.c.put("pfkey", p4.p().e().b.pfKey);
        this.c.put("zoneid", p4.p().e().b.zoneId);
        this.c.put("offerid", p4.p().e().b.offerId);
        this.c.put("gameCoinName", APTools.b(p4.p().e().c.b, 1));
        this.c.put("recommendList", APTools.a(r7.e().c(), ","));
        this.c.put("minNumber", String.valueOf(p4.p().e().c.e));
        this.c.put("sdkversion", "1.7.9a");
        this.c.put("sessiontoken", p4.p().e().f.k);
        if ((!TextUtils.isEmpty(c6.s0().b0())) && (!TextUtils.isEmpty(c6.s0().d0())))
        {
          this.c.put("appId", c6.s0().b0());
          this.c.put("wxSignUrl", APTools.b(c6.s0().d0(), 1));
        }
        localObject3 = this.c;
        if (!p4.p().e().e.f) {
          break label2179;
        }
        localObject1 = "1";
        ((HashMap)localObject3).put("have_changed_uin", localObject1);
        this.c.put("pay_id", p4.p().e().f.a);
        this.c.put("auth_key", p4.p().e().f.b);
        this.c.put("pay_session_id", p4.p().e().f.c);
        this.c.put("pay_session_type", p4.p().e().f.d);
        int k = -1;
        localObject1 = p4.p();
        int j = k;
        if (localObject1 != null)
        {
          localObject1 = ((p4)localObject1).e();
          j = k;
          if (localObject1 != null)
          {
            localObject1 = ((o4)localObject1).b;
            j = k;
            if (localObject1 != null) {
              j = ((APBaseRequest)localObject1).saveType;
            }
          }
        }
        if (j == 4) {
          this.c.put("type", "month");
        } else if (j == 0) {
          this.c.put("type", "save");
        } else if (j == 1) {
          this.c.put("type", "bg");
        } else if (j == 3) {
          this.c.put("type", "qb");
        } else if (j == 2) {
          this.c.put("type", "qd");
        } else if (j == 5) {
          this.c.put("type", "unimonth");
        } else {
          this.c.put("type", "");
        }
        this.c.put("from", "android");
        this.c.put("rcs_version", "1.0");
        this.c.put("fk_info", this.g.a);
        this.c.put("uuid", APTools.b(c6.s0().Z(), 1));
        this.c.put("drm_resource", j6.e().b());
        this.c.put("payChannel", String.valueOf(r6.e((String)localObject2)));
        this.c.put("payChannelName", localObject2);
        this.c.put("pay_method", this.g.d);
        this.c.put("amt", this.g.c);
        this.c.put("extend", this.g.f);
        this.c.put("service_code", this.g.g);
        bool = ((String)localObject2).equals("hfpay");
        if (bool)
        {
          if (((p4.p().e().b.saveType == 4) || (p4.p().e().b.saveType == 5)) && (!TextUtils.isEmpty(APHFChannel.w)) && ("0" != APHFChannel.w)) {
            this.c.put("gameCoinRate", APHFChannel.w);
          } else if ((p4.p().e().b.saveType == 0) && (!TextUtils.isEmpty(APHFChannel.v)) && ("0" != APHFChannel.v)) {
            this.c.put("gameCoinRate", APHFChannel.v);
          } else {
            this.c.put("gameCoinRate", p4.p().e().c.c);
          }
        }
        else {
          this.c.put("gameCoinRate", p4.p().e().c.c);
        }
        if (((String)localObject2).equals("hfpay"))
        {
          if (((p4.p().e().b.saveType == 4) || (p4.p().e().b.saveType == 5)) && (!TextUtils.isEmpty(APHFChannel.w)) && ("0" != APHFChannel.w)) {
            this.c.put("gameCoinRate", APHFChannel.w);
          } else if ((p4.p().e().b.saveType == 0) && (!TextUtils.isEmpty(APHFChannel.v)) && ("0" != APHFChannel.v)) {
            this.c.put("gameCoinRate", APHFChannel.v);
          } else {
            this.c.put("gameCoinRate", p4.p().e().c.c);
          }
        }
        else {
          this.c.put("gameCoinRate", p4.p().e().c.c);
        }
        localObject1 = c6.s0().Q();
        if ("AndroidPay".equals(localObject1)) {
          this.c.put("entry", "game");
        } else if ("APPayGameListNumActivity".equals(localObject1)) {
          this.c.put("entry", "sdk");
        }
        this.c.put("hasMpTuan", x.f().e());
        if (p4.p().e().e.b) {
          this.c.put("firstCharge", "1");
        } else {
          this.c.put("firstCharge", "0");
        }
        this.c.put("saveNumber", p4.p().e().f.f);
        this.c.put("PortalExtendField", c6.s0().D());
        if (!c6.s0().z()) {
          this.c.put("notShowContinueBuy", "1");
        }
        j = p4.p().e().b.saveType;
        if (j == 4)
        {
          localObject2 = ((APMonthRequest)p4.p().e().b).serviceCode;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          this.c.put("serviceCode", localObject1);
          return;
        }
        if (j == 5)
        {
          localObject2 = ((APSubscribeRequest)p4.p().e().b).serviceCode;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject3 = ((z4)p4.p().e().c).k;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          this.c.put("serviceCode", localObject1);
          this.c.put("productId", localObject2);
          return;
        }
        if (j == 1)
        {
          localObject2 = ((APGoodsRequest)p4.p().e().b).prodcutId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          this.c.put("productId", localObject1);
          return;
        }
      }
      finally
      {
        localThrowable.printStackTrace();
        Object localObject2 = APDataReportManager.getInstance();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("APWebBasePage_setCommonParams_");
        ((StringBuilder)localObject3).append(APTools.d(localThrowable));
        ((APDataReportManager)localObject2).a("sdk.err.view", ((StringBuilder)localObject3).toString());
      }
      return;
      label2179:
      String str = "0";
    }
  }
  
  public final void b(int paramInt, String paramString)
  {
    APDataReportManager.getInstance().insertData("sdk.h5.riskcontrolsoft.staytime", p4.o(), "", "", "", String.valueOf(SystemClock.elapsedRealtime() - this.i));
    if (x3.a.b(paramString)) {
      APDataReportManager.getInstance().insertData("sdk.h5.riskcontrolsoft.close.testok", p4.o());
    } else {
      APDataReportManager.getInstance().insertData("sdk.h5.riskcontrolsoft.close.testfail", p4.o());
    }
    Object localObject;
    if (paramInt == 0)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("rcs_msg", paramString);
      paramString = this.g.e;
      if (paramString != null)
      {
        paramString.send(0, (Bundle)localObject);
        APLog.d("APX5WebRiskControlSoftPage", "Call rcs callback!");
      }
      else
      {
        APLog.e("APX5WebRiskControlSoftPage", "Cannot call rcs callback, callback is null!");
      }
    }
    if (paramInt == -1)
    {
      paramString = new Bundle();
      paramString.putString("rcs_msg", "");
      localObject = this.g.e;
      if (localObject != null)
      {
        ((ResultReceiver)localObject).send(-1, paramString);
        APLog.d("APX5WebRiskControlSoftPage", "Call rcs callback!");
      }
      else
      {
        APLog.e("APX5WebRiskControlSoftPage", "Cannot call rcs callback, callback is null!");
      }
      if (z5.d())
      {
        APUICommonMethod.f();
        z5.a(2, "rcs, user cancel");
        return;
      }
      if ((e5.h().e()) && (!TextUtils.isEmpty(p4.p().e().b.saveValue)) && (!p4.p().e().b.isCanChange))
      {
        APUICommonMethod.f();
        z5.a(2, "rcs, user cancel");
      }
    }
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
  }
  
  public void c()
  {
    String str = APAppDataInterface.singleton().h();
    if (str.equals("release"))
    {
      this.b = y7.e;
      return;
    }
    if ((!str.equals("test")) && (!str.equals("dev")))
    {
      if ((str.equals("custom")) && ("dev".equals(APAppDataInterface.singleton().f())))
      {
        this.b = y7.f;
        return;
      }
      if (str.equals("testing"))
      {
        this.b = y7.f;
        return;
      }
      this.b = y7.e;
      return;
    }
    this.b = y7.f;
  }
  
  public void c(String paramString)
  {
    super.c(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Receive title = ");
    localStringBuilder.append(paramString);
    APLog.e("APX5WebRiskControlSoftPage", localStringBuilder.toString());
    if (this.h == null)
    {
      APLog.e("APX5WebRiskControlSoftPage", "Cannot set title, view is null!");
      return;
    }
    if (!"Title".equals(paramString))
    {
      if ("title".equals(paramString)) {
        return;
      }
      this.h.setText(paramString);
    }
  }
  
  public void d(String paramString)
  {
    super.d(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("webPageStarted url = ");
    localStringBuilder.append(paramString);
    APLog.d("APX5WebRiskControlSoftPage", localStringBuilder.toString());
    if (paramString.contains("&ismidas=1"))
    {
      APLog.d("APX5WebRiskControlSoftPage", "ismidas = 1 don't set fixed size!");
      return;
    }
    g();
    APLog.d("APX5WebRiskControlSoftPage", "not has ismidas = 1 set fixed size!");
  }
  
  public boolean e()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((f8)localObject).e() != null) && (this.e.e().canGoBack()))
    {
      this.e.e().goBack();
    }
    else
    {
      localObject = this.f;
      if (localObject != null)
      {
        ((Activity)localObject).finish();
        b(-1, "");
        APUICommonMethod.a(this.f);
      }
    }
    return true;
  }
  
  public String f()
  {
    b();
    Object localObject = this.g.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("riskControlSoftUrl = ");
    localStringBuilder.append((String)localObject);
    APLog.d("APX5WebRiskControlSoftPage", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("?");
    localStringBuilder.append(APTools.a(this.c));
    this.a = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("full url = ");
    ((StringBuilder)localObject).append(this.a);
    APLog.d("APX5WebRiskControlSoftPage", ((StringBuilder)localObject).toString());
    return this.a;
  }
  
  public final void g()
  {
    Object localObject = new DisplayMetrics();
    this.f.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int j = (int)(((DisplayMetrics)localObject).widthPixels * 0.85F);
    int k = (int)(((DisplayMetrics)localObject).heightPixels * 0.85F);
    int m = e7.a(this.f, 48.0F);
    localObject = this.e.f();
    ViewGroup.LayoutParams localLayoutParams;
    if (localObject != null)
    {
      localLayoutParams = ((ViewGroup)localObject).getLayoutParams();
      localLayoutParams.width = j;
      localLayoutParams.height = k;
      ((ViewGroup)localObject).setLayoutParams(localLayoutParams);
    }
    else
    {
      APLog.e("APX5WebRiskControlSoftPage", "Cannot set webview viewGroup initial size, viewGroup is null!");
    }
    localObject = this.e.e();
    if (localObject != null)
    {
      localLayoutParams = ((WebView)localObject).getLayoutParams();
      localLayoutParams.width = j;
      localLayoutParams.height = (k - m - 1);
      ((WebView)localObject).setLayoutParams(localLayoutParams);
      return;
    }
    APLog.e("APX5WebRiskControlSoftPage", "Cannot set webview initial size, webView is null!");
  }
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      if ((c9.a(c9.this).e() != null) && (c9.a(c9.this).e().canGoBack()))
      {
        c9.a(c9.this).e().goBack();
        return;
      }
      if (c9.b(c9.this) != null)
      {
        c9.b(c9.this).finish();
        c9.a(c9.this, -1, "");
        APUICommonMethod.a(c9.b(c9.this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.c9
 * JD-Core Version:    0.7.0.1
 */