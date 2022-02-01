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

public class iy
  extends ir
{
  private ib f = null;
  private Activity g = null;
  private in h = new in();
  private TextView i;
  private long j;
  
  public iy()
  {
    APLog.d("APX5WebRiskControlSoftPage", "new instance!");
    c();
  }
  
  private void b(int paramInt, String paramString)
  {
    APDataReportManager.getInstance().insertData("sdk.h5.riskcontrolsoft.staytime", em.a(), "", "", "", String.valueOf(SystemClock.elapsedRealtime() - this.j));
    if (du.a.a(paramString)) {
      APDataReportManager.getInstance().insertData("sdk.h5.riskcontrolsoft.close.testok", em.a());
    } else {
      APDataReportManager.getInstance().insertData("sdk.h5.riskcontrolsoft.close.testfail", em.a());
    }
    if (paramInt == 0)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("rcs_msg", paramString);
      if (this.h.e != null)
      {
        this.h.e.send(0, localBundle);
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
      if (this.h.e != null)
      {
        this.h.e.send(-1, paramString);
        APLog.d("APX5WebRiskControlSoftPage", "Call rcs callback!");
      }
      else
      {
        APLog.e("APX5WebRiskControlSoftPage", "Cannot call rcs callback, callback is null!");
      }
      if (fv.f())
      {
        APUICommonMethod.b();
        fv.a(2, "rcs, user cancel");
        return;
      }
      if ((fb.a().g()) && (!TextUtils.isEmpty(em.b().n().a.saveValue)) && (!em.b().n().a.isCanChange))
      {
        APUICommonMethod.b();
        fv.a(2, "rcs, user cancel");
      }
    }
  }
  
  private void g()
  {
    Object localObject = new DisplayMetrics();
    this.g.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int k = (int)(((DisplayMetrics)localObject).widthPixels * 0.85F);
    int m = (int)(((DisplayMetrics)localObject).heightPixels * 0.85F);
    int n = ha.a(this.g, 48.0F);
    localObject = this.f.b();
    ViewGroup.LayoutParams localLayoutParams;
    if (localObject != null)
    {
      localLayoutParams = ((ViewGroup)localObject).getLayoutParams();
      localLayoutParams.width = k;
      localLayoutParams.height = m;
      ((ViewGroup)localObject).setLayoutParams(localLayoutParams);
    }
    else
    {
      APLog.e("APX5WebRiskControlSoftPage", "Cannot set webview viewGroup initial size, viewGroup is null!");
    }
    localObject = this.f.c();
    if (localObject != null)
    {
      localLayoutParams = ((WebView)localObject).getLayoutParams();
      localLayoutParams.width = k;
      localLayoutParams.height = (m - n - 1);
      ((WebView)localObject).setLayoutParams(localLayoutParams);
      return;
    }
    APLog.e("APX5WebRiskControlSoftPage", "Cannot set webview initial size, webView is null!");
  }
  
  public void a(Activity paramActivity, ib paramib, Bundle paramBundle)
  {
    super.a(paramActivity, paramib, paramBundle);
    this.g = paramActivity;
    this.f = paramib;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    paramProgressDialog = this.f.d();
    this.i = ((TextView)paramProgressDialog.findViewById(2131099885));
    this.i.setText("安全验证");
    ((ImageButton)paramProgressDialog.findViewById(2131099802)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((iy.a(iy.this).c() != null) && (iy.a(iy.this).c().canGoBack()))
        {
          iy.a(iy.this).c().goBack();
          return;
        }
        if (iy.b(iy.this) != null)
        {
          iy.b(iy.this).finish();
          iy.a(iy.this, -1, "");
          APUICommonMethod.b(iy.b(iy.this));
        }
      }
    });
    if (this.f != null) {
      this.f.b(b());
    }
    paramProgressDialog = this.f.b();
    if (paramProgressDialog != null)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramProgressDialog.getLayoutParams();
      localMarginLayoutParams.topMargin = 0;
      localMarginLayoutParams.bottomMargin = 0;
      paramProgressDialog.setLayoutParams(localMarginLayoutParams);
    }
    APDataReportManager.getInstance().insertData("sdk.h5.riskcontrolsoft.show", em.a());
    this.j = SystemClock.elapsedRealtime();
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
      if (this.g != null)
      {
        this.g.finish();
        b(0, paramString);
        APUICommonMethod.b(this.g);
      }
      return;
    }
    if (paramString.startsWith("http://unipay.sdk.android/?"))
    {
      APLog.d("APX5WebRiskControlSoftPage", "enter rcs set size or set title protocol!");
      localObject1 = APTools.b(paramString);
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
      if (hu.Q.equals(paramString))
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
        int k;
        if (this.f.c() != null) {
          try
          {
            localObject2 = this.f.c().getLayoutParams();
            StringBuilder localStringBuilder;
            if (!TextUtils.isEmpty(paramString))
            {
              k = Float.valueOf(paramString).intValue();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("width dp = ");
              localStringBuilder.append(k);
              APLog.i("APX5WebRiskControlSoftPage", localStringBuilder.toString());
              k = ha.a(this.g, k);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("width px = ");
              localStringBuilder.append(k);
              APLog.i("APX5WebRiskControlSoftPage", localStringBuilder.toString());
              ((ViewGroup.LayoutParams)localObject2).width = k;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              k = Float.valueOf((String)localObject1).intValue();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("height dp = ");
              localStringBuilder.append(k);
              APLog.i("APX5WebRiskControlSoftPage", localStringBuilder.toString());
              k = ha.a(this.g, k);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("height px = ");
              localStringBuilder.append(k);
              APLog.i("APX5WebRiskControlSoftPage", localStringBuilder.toString());
              ((ViewGroup.LayoutParams)localObject2).height = k;
            }
            this.f.c().setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        if (this.f.b() == null) {
          break label911;
        }
        try
        {
          ViewGroup.LayoutParams localLayoutParams = this.f.b().getLayoutParams();
          if (!TextUtils.isEmpty(paramString))
          {
            k = Float.valueOf(paramString).intValue();
            paramString = new StringBuilder();
            paramString.append("width dp = ");
            paramString.append(k);
            APLog.i("APX5WebRiskControlSoftPage", paramString.toString());
            k = ha.a(this.g, k);
            paramString = new StringBuilder();
            paramString.append("width px = ");
            paramString.append(k);
            APLog.i("APX5WebRiskControlSoftPage", paramString.toString());
            localLayoutParams.width = k;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            k = Float.valueOf((String)localObject1).intValue();
            paramString = new StringBuilder();
            paramString.append("height dp = ");
            paramString.append(k);
            APLog.i("APX5WebRiskControlSoftPage", paramString.toString());
            k = ha.a(this.g, k + 48) + 1;
            paramString = new StringBuilder();
            paramString.append("height px = ");
            paramString.append(k);
            APLog.i("APX5WebRiskControlSoftPage", paramString.toString());
            localLayoutParams.height = k;
          }
          this.f.b().setLayoutParams(localLayoutParams);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      if (hu.R.equals(paramString))
      {
        paramString = (String)((HashMap)localObject1).get("title");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("enter rcs set title protocol! title = ");
        ((StringBuilder)localObject1).append(paramString);
        APLog.d("APX5WebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
        paramString = APTools.b(paramString, 1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("enter rcs set title protocol! title decode = ");
        ((StringBuilder)localObject1).append(paramString);
        APLog.d("APX5WebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
        if (this.i != null)
        {
          this.i.setText(paramString);
          return;
        }
        APLog.e("APX5WebRiskControlSoftPage", "Cannot set title, text view is null!");
      }
      label911:
      return;
    }
  }
  
  public void a(in paramin)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRiskControlSoftParams = ");
    localStringBuilder.append(paramin);
    APLog.d("APX5WebRiskControlSoftPage", localStringBuilder.toString());
    this.h = paramin;
  }
  
  public boolean a()
  {
    if ((this.f != null) && (this.f.c() != null) && (this.f.c().canGoBack()))
    {
      this.f.c().goBack();
    }
    else if (this.g != null)
    {
      this.g.finish();
      b(-1, "");
      APUICommonMethod.b(this.g);
    }
    return true;
  }
  
  public String b()
  {
    d();
    Object localObject = this.h.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("riskControlSoftUrl = ");
    localStringBuilder.append((String)localObject);
    APLog.d("APX5WebRiskControlSoftPage", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("?");
    localStringBuilder.append(APTools.a(this.d));
    this.a = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("full url = ");
    ((StringBuilder)localObject).append(this.a);
    APLog.d("APX5WebRiskControlSoftPage", ((StringBuilder)localObject).toString());
    return this.a;
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Receive title = ");
    localStringBuilder.append(paramString);
    APLog.e("APX5WebRiskControlSoftPage", localStringBuilder.toString());
    if (this.i == null)
    {
      APLog.e("APX5WebRiskControlSoftPage", "Cannot set title, view is null!");
      return;
    }
    if (!"Title".equals(paramString))
    {
      if ("title".equals(paramString)) {
        return;
      }
      this.i.setText(paramString);
      return;
    }
  }
  
  protected void c()
  {
    String str = APAppDataInterface.singleton().e();
    if (str.equals("release"))
    {
      this.c = hu.e;
      return;
    }
    if ((!str.equals("test")) && (!str.equals("dev")))
    {
      if ((str.equals("custom")) && ("dev".equals(APAppDataInterface.singleton().k())))
      {
        this.c = hu.f;
        return;
      }
      if (str.equals("testing"))
      {
        this.c = hu.f;
        return;
      }
      this.c = hu.e;
      return;
    }
    this.c = hu.f;
  }
  
  public void c(String paramString)
  {
    super.c(paramString);
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
  
  protected void d()
  {
    for (;;)
    {
      try
      {
        if (!APAppDataInterface.singleton().e().equals("release")) {
          if (APAppDataInterface.singleton().e().equals("dev")) {
            this.d.put("sandbox", "2");
          } else {
            this.d.put("sandbox", "1");
          }
        }
        if (this.g != null)
        {
          k = this.g.getResources().getConfiguration().orientation;
          if (2 == k)
          {
            this.d.put("orientation", "2");
            localObject1 = new DisplayMetrics();
            this.g.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("screen width px = ");
            ((StringBuilder)localObject2).append(((DisplayMetrics)localObject1).heightPixels);
            APLog.i("APX5WebRiskControlSoftPage", ((StringBuilder)localObject2).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("screen width dp = ");
            ((StringBuilder)localObject2).append(ha.b(this.g, ((DisplayMetrics)localObject1).heightPixels));
            APLog.i("APX5WebRiskControlSoftPage", ((StringBuilder)localObject2).toString());
            k = ha.b(this.g, ((DisplayMetrics)localObject1).heightPixels) - 40 - 48 - 25;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("inner_height  = ");
            ((StringBuilder)localObject1).append(k);
            APLog.i("APX5WebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
            this.d.put("inner_height", String.valueOf(k));
          }
          else if (1 == k)
          {
            this.d.put("orientation", "1");
            localObject1 = new DisplayMetrics();
            this.g.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
            k = ha.b(this.g, ((DisplayMetrics)localObject1).widthPixels) - 40;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("inner_width  = ");
            ((StringBuilder)localObject1).append(k);
            APLog.i("APX5WebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
            this.d.put("inner_width", String.valueOf(k));
          }
          else
          {
            this.d.put("orientation", "0");
          }
        }
        else
        {
          APLog.e("APX5WebRiskControlSoftPage", "Activity is null, cannot get orientation parameter!");
        }
        this.d.put("ismidas", "1");
        localObject2 = em.b().n().e.f;
        this.d.put("reqFrom", hu.q);
        this.d.put("openid", em.b().n().a.openId);
        this.d.put("appid", em.b().n().a.offerId);
        this.d.put("openkey", em.b().n().a.openKey);
        this.d.put("session_id", em.b().n().a.sessionId);
        this.d.put("session_type", em.b().n().a.sessionType);
        this.d.put("pf", em.b().n().a.pf);
        this.d.put("pfkey", em.b().n().a.pfKey);
        this.d.put("zoneid", em.b().n().a.zoneId);
        this.d.put("offerid", em.b().n().a.offerId);
        this.d.put("gameCoinName", APTools.a(em.b().n().b.b, 1));
        this.d.put("recommendList", APTools.a(hn.a().b(), ","));
        this.d.put("minNumber", String.valueOf(em.b().n().b.h));
        this.d.put("sdkversion", "1.7.4");
        this.d.put("sessiontoken", em.b().n().e.l);
        if ((!TextUtils.isEmpty(fy.a().N())) && (!TextUtils.isEmpty(fy.a().O())))
        {
          this.d.put("appId", fy.a().N());
          this.d.put("wxSignUrl", APTools.a(fy.a().O(), 1));
        }
        localObject3 = this.d;
        if (!em.b().n().d.f) {
          break label2122;
        }
        Object localObject1 = "1";
        ((HashMap)localObject3).put("have_changed_uin", localObject1);
        this.d.put("pay_id", em.b().n().e.a);
        this.d.put("auth_key", em.b().n().e.b);
        this.d.put("pay_session_id", em.b().n().e.c);
        this.d.put("pay_session_type", em.b().n().e.d);
        int m = -1;
        localObject1 = em.b();
        int k = m;
        if (localObject1 != null)
        {
          localObject1 = ((em)localObject1).n();
          k = m;
          if (localObject1 != null)
          {
            localObject1 = ((el)localObject1).a;
            k = m;
            if (localObject1 != null) {
              k = ((APBaseRequest)localObject1).saveType;
            }
          }
        }
        if (k == 4) {
          this.d.put("type", "month");
        } else if (k == 0) {
          this.d.put("type", "save");
        } else if (k == 1) {
          this.d.put("type", "bg");
        } else if (k == 3) {
          this.d.put("type", "qb");
        } else if (k == 2) {
          this.d.put("type", "qd");
        } else if (k == 5) {
          this.d.put("type", "unimonth");
        } else {
          this.d.put("type", "");
        }
        this.d.put("from", "android");
        this.d.put("rcs_version", "1.0");
        this.d.put("fk_info", this.h.a);
        this.d.put("uuid", APTools.a(fy.a().i(), 1));
        this.d.put("drm_resource", gf.b().e());
        this.d.put("payChannel", String.valueOf(gn.a((String)localObject2)));
        this.d.put("payChannelName", localObject2);
        this.d.put("pay_method", this.h.d);
        this.d.put("amt", this.h.c);
        this.d.put("extend", this.h.f);
        this.d.put("service_code", this.h.g);
        if (((String)localObject2).equals("hfpay"))
        {
          if (((em.b().n().a.saveType == 4) || (em.b().n().a.saveType == 5)) && (!TextUtils.isEmpty(APHFChannel.p)) && ("0" != APHFChannel.p)) {
            this.d.put("gameCoinRate", APHFChannel.p);
          } else if ((em.b().n().a.saveType == 0) && (!TextUtils.isEmpty(APHFChannel.o)) && ("0" != APHFChannel.o)) {
            this.d.put("gameCoinRate", APHFChannel.o);
          } else {
            this.d.put("gameCoinRate", em.b().n().b.e);
          }
        }
        else {
          this.d.put("gameCoinRate", em.b().n().b.e);
        }
        if (((String)localObject2).equals("hfpay"))
        {
          if (((em.b().n().a.saveType == 4) || (em.b().n().a.saveType == 5)) && (!TextUtils.isEmpty(APHFChannel.p)) && ("0" != APHFChannel.p)) {
            this.d.put("gameCoinRate", APHFChannel.p);
          } else if ((em.b().n().a.saveType == 0) && (!TextUtils.isEmpty(APHFChannel.o)) && ("0" != APHFChannel.o)) {
            this.d.put("gameCoinRate", APHFChannel.o);
          } else {
            this.d.put("gameCoinRate", em.b().n().b.e);
          }
        }
        else {
          this.d.put("gameCoinRate", em.b().n().b.e);
        }
        localObject1 = fy.a().g();
        if ("AndroidPay".equals(localObject1)) {
          this.d.put("entry", "game");
        } else if ("APPayGameListNumActivity".equals(localObject1)) {
          this.d.put("entry", "sdk");
        }
        this.d.put("hasMpTuan", w.a().d());
        if (em.b().n().d.b) {
          this.d.put("firstCharge", "1");
        } else {
          this.d.put("firstCharge", "0");
        }
        this.d.put("saveNumber", em.b().n().e.g);
        this.d.put("PortalExtendField", fy.a().L());
        if (!fy.a().B()) {
          this.d.put("notShowContinueBuy", "1");
        }
        k = em.b().n().a.saveType;
        if (k == 4)
        {
          localObject2 = ((APMonthRequest)em.b().n().a).serviceCode;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          this.d.put("serviceCode", localObject1);
          return;
        }
        if (k == 5)
        {
          localObject2 = ((APSubscribeRequest)em.b().n().a).serviceCode;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject3 = ((ew)em.b().n().b).k;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          this.d.put("serviceCode", localObject1);
          this.d.put("productId", localObject2);
          return;
        }
        if (k == 1)
        {
          localObject2 = ((APGoodsRequest)em.b().n().a).prodcutId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          this.d.put("productId", localObject1);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        Object localObject2 = APDataReportManager.getInstance();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("APWebBasePage_setCommonParams_");
        ((StringBuilder)localObject3).append(APTools.d(localThrowable));
        ((APDataReportManager)localObject2).a("sdk.err.view", ((StringBuilder)localObject3).toString());
      }
      return;
      label2122:
      String str = "0";
    }
  }
  
  public void d(String paramString)
  {
    super.d(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.iy
 * JD-Core Version:    0.7.0.1
 */