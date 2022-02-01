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
import android.webkit.WebView;
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
import java.util.HashMap;

public class id
  extends hv
{
  private hp f = null;
  private Activity g = null;
  private ic h = new ic();
  private TextView i;
  private long j;
  
  public id()
  {
    APLog.d("APWebRiskControlSoftPage", "new instance!");
    c();
  }
  
  private void b(int paramInt, String paramString)
  {
    APDataReportManager.getInstance().insertData("sdk.h5.riskcontrolsoft.staytime", ed.a(), "", "", "", String.valueOf(SystemClock.elapsedRealtime() - this.j));
    if (dm.a.a(paramString)) {
      APDataReportManager.getInstance().insertData("sdk.h5.riskcontrolsoft.close.testok", ed.a());
    } else {
      APDataReportManager.getInstance().insertData("sdk.h5.riskcontrolsoft.close.testfail", ed.a());
    }
    if (paramInt == 0)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("rcs_msg", paramString);
      if (this.h.e != null)
      {
        this.h.e.send(0, localBundle);
        APLog.d("APWebRiskControlSoftPage", "Call rcs callback!");
      }
      else
      {
        APLog.e("APWebRiskControlSoftPage", "Cannot call rcs callback, callback is null!");
      }
    }
    if (paramInt == -1)
    {
      paramString = new Bundle();
      paramString.putString("rcs_msg", "");
      if (this.h.e != null)
      {
        this.h.e.send(-1, paramString);
        APLog.d("APWebRiskControlSoftPage", "Call rcs callback!");
      }
      else
      {
        APLog.e("APWebRiskControlSoftPage", "Cannot call rcs callback, callback is null!");
      }
      if (fm.f())
      {
        APUICommonMethod.b();
        fm.a(2, "rcs, user cancel");
        return;
      }
      if ((es.a().g()) && (!TextUtils.isEmpty(ed.b().n().a.saveValue)) && (!ed.b().n().a.isCanChange))
      {
        APUICommonMethod.b();
        fm.a(2, "rcs, user cancel");
      }
    }
  }
  
  private void g()
  {
    Object localObject = new DisplayMetrics();
    this.g.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int k = (int)(((DisplayMetrics)localObject).widthPixels * 0.85F);
    int m = (int)(((DisplayMetrics)localObject).heightPixels * 0.85F);
    int n = gp.a(this.g, 48.0F);
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
      APLog.e("APWebRiskControlSoftPage", "Cannot set webview viewGroup initial size, viewGroup is null!");
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
    APLog.e("APWebRiskControlSoftPage", "Cannot set webview initial size, webView is null!");
  }
  
  public void a(Activity paramActivity, hp paramhp)
  {
    super.a(paramActivity, paramhp);
    this.g = paramActivity;
    this.f = paramhp;
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
        if ((id.a(id.this).c() != null) && (id.a(id.this).c().canGoBack()))
        {
          id.a(id.this).c().goBack();
          return;
        }
        if (id.b(id.this) != null)
        {
          id.b(id.this).finish();
          id.a(id.this, -1, "");
          APUICommonMethod.b(id.b(id.this));
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
    APDataReportManager.getInstance().insertData("sdk.h5.riskcontrolsoft.show", ed.a());
    this.j = SystemClock.elapsedRealtime();
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      APLog.e("APWebRiskControlSoftPage", "web call back empty message!");
      return;
    }
    Object localObject1;
    if (paramString.startsWith("rcs://"))
    {
      APLog.d("APWebRiskControlSoftPage", "enter rcs protocol return!");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("RiskContorlPage js alert = ");
      ((StringBuilder)localObject1).append(paramString);
      APLog.d("APWebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
      paramString = paramString.substring(6);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("rcs message = ");
      ((StringBuilder)localObject1).append(paramString);
      APLog.d("APWebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
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
      APLog.d("APWebRiskControlSoftPage", "enter rcs set size or set title protocol!");
      localObject1 = APTools.b(paramString);
      if (localObject1 == null)
      {
        APLog.e("APWebRiskControlSoftPage", "enter rcs set size or set title protocol, empty message!");
        return;
      }
      paramString = (String)((HashMap)localObject1).get("action");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("enter rcs set size or set title protocol! action = ");
      ((StringBuilder)localObject2).append(paramString);
      APLog.d("APWebRiskControlSoftPage", ((StringBuilder)localObject2).toString());
      if (hj.R.equals(paramString))
      {
        paramString = (String)((HashMap)localObject1).get("h5_width");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("enter rcs set size protocol! h5_width = ");
        ((StringBuilder)localObject2).append(paramString);
        APLog.d("APWebRiskControlSoftPage", ((StringBuilder)localObject2).toString());
        localObject1 = (String)((HashMap)localObject1).get("h5_height");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("enter rcs set size protocol! h5_height = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        APLog.d("APWebRiskControlSoftPage", ((StringBuilder)localObject2).toString());
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
              APLog.i("APWebRiskControlSoftPage", localStringBuilder.toString());
              k = gp.a(this.g, k);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("width px = ");
              localStringBuilder.append(k);
              APLog.i("APWebRiskControlSoftPage", localStringBuilder.toString());
              ((ViewGroup.LayoutParams)localObject2).width = k;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              k = Float.valueOf((String)localObject1).intValue();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("height dp = ");
              localStringBuilder.append(k);
              APLog.i("APWebRiskControlSoftPage", localStringBuilder.toString());
              k = gp.a(this.g, k);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("height px = ");
              localStringBuilder.append(k);
              APLog.i("APWebRiskControlSoftPage", localStringBuilder.toString());
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
            APLog.i("APWebRiskControlSoftPage", paramString.toString());
            k = gp.a(this.g, k);
            paramString = new StringBuilder();
            paramString.append("width px = ");
            paramString.append(k);
            APLog.i("APWebRiskControlSoftPage", paramString.toString());
            localLayoutParams.width = k;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            k = Float.valueOf((String)localObject1).intValue();
            paramString = new StringBuilder();
            paramString.append("height dp = ");
            paramString.append(k);
            APLog.i("APWebRiskControlSoftPage", paramString.toString());
            k = gp.a(this.g, k + 48) + 1;
            paramString = new StringBuilder();
            paramString.append("height px = ");
            paramString.append(k);
            APLog.i("APWebRiskControlSoftPage", paramString.toString());
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
      if (hj.S.equals(paramString))
      {
        paramString = (String)((HashMap)localObject1).get("title");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("enter rcs set title protocol! title = ");
        ((StringBuilder)localObject1).append(paramString);
        APLog.d("APWebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
        paramString = APTools.b(paramString, 1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("enter rcs set title protocol! title decode = ");
        ((StringBuilder)localObject1).append(paramString);
        APLog.d("APWebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
        if (this.i != null)
        {
          this.i.setText(paramString);
          return;
        }
        APLog.e("APWebRiskControlSoftPage", "Cannot set title, text view is null!");
      }
      label911:
      return;
    }
  }
  
  public void a(ic paramic)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRiskControlSoftParams = ");
    localStringBuilder.append(paramic);
    APLog.d("APWebRiskControlSoftPage", localStringBuilder.toString());
    this.h = paramic;
  }
  
  public boolean a()
  {
    if (this.f.c().canGoBack())
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
    APLog.d("APWebRiskControlSoftPage", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("?");
    localStringBuilder.append(APTools.a(this.d));
    this.a = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("full url = ");
    ((StringBuilder)localObject).append(this.a);
    APLog.d("APWebRiskControlSoftPage", ((StringBuilder)localObject).toString());
    return this.a;
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Receive title = ");
    localStringBuilder.append(paramString);
    APLog.e("APWebRiskControlSoftPage", localStringBuilder.toString());
    if (this.i == null)
    {
      APLog.e("APWebRiskControlSoftPage", "Cannot set title, view is null!");
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
      this.c = hj.e;
      return;
    }
    if ((!str.equals("test")) && (!str.equals("dev")))
    {
      if ((str.equals("custom")) && ("dev".equals(APAppDataInterface.singleton().k())))
      {
        this.c = hj.f;
        return;
      }
      if (str.equals("testing"))
      {
        this.c = hj.f;
        return;
      }
      this.c = hj.e;
      return;
    }
    this.c = hj.f;
  }
  
  public void c(String paramString)
  {
    super.c(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("webPageStarted url = ");
    localStringBuilder.append(paramString);
    APLog.d("APWebRiskControlSoftPage", localStringBuilder.toString());
    if (paramString.contains("&ismidas=1"))
    {
      APLog.d("APWebRiskControlSoftPage", "ismidas = 1 don't set fixed size!");
      return;
    }
    g();
    APLog.d("APWebRiskControlSoftPage", "not has ismidas = 1 set fixed size!");
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
            APLog.i("APWebRiskControlSoftPage", ((StringBuilder)localObject2).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("screen width dp = ");
            ((StringBuilder)localObject2).append(gp.b(this.g, ((DisplayMetrics)localObject1).heightPixels));
            APLog.i("APWebRiskControlSoftPage", ((StringBuilder)localObject2).toString());
            k = gp.b(this.g, ((DisplayMetrics)localObject1).heightPixels) - 40 - 48 - 25;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("inner_height  = ");
            ((StringBuilder)localObject1).append(k);
            APLog.i("APWebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
            this.d.put("inner_height", String.valueOf(k));
          }
          else if (1 == k)
          {
            this.d.put("orientation", "1");
            localObject1 = new DisplayMetrics();
            this.g.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
            k = gp.b(this.g, ((DisplayMetrics)localObject1).widthPixels) - 40;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("inner_width  = ");
            ((StringBuilder)localObject1).append(k);
            APLog.i("APWebRiskControlSoftPage", ((StringBuilder)localObject1).toString());
            this.d.put("inner_width", String.valueOf(k));
          }
          else
          {
            this.d.put("orientation", "0");
          }
        }
        else
        {
          APLog.e("APWebRiskControlSoftPage", "Activity is null, cannot get orientation parameter!");
        }
        this.d.put("ismidas", "1");
        localObject2 = ed.b().n().e.f;
        this.d.put("reqFrom", hj.q);
        this.d.put("openid", ed.b().n().a.openId);
        this.d.put("appid", ed.b().n().a.offerId);
        this.d.put("openkey", ed.b().n().a.openKey);
        this.d.put("session_id", ed.b().n().a.sessionId);
        this.d.put("session_type", ed.b().n().a.sessionType);
        this.d.put("pf", ed.b().n().a.pf);
        this.d.put("pfkey", ed.b().n().a.pfKey);
        this.d.put("zoneid", ed.b().n().a.zoneId);
        this.d.put("offerid", ed.b().n().a.offerId);
        this.d.put("gameCoinName", APTools.a(ed.b().n().b.b, 1));
        this.d.put("recommendList", APTools.a(hc.a().b(), ","));
        this.d.put("minNumber", String.valueOf(ed.b().n().b.h));
        this.d.put("sdkversion", "1.7.1f");
        this.d.put("sessiontoken", ed.b().n().e.l);
        if ((!TextUtils.isEmpty(fp.a().N())) && (!TextUtils.isEmpty(fp.a().O())))
        {
          this.d.put("appId", fp.a().N());
          this.d.put("wxSignUrl", APTools.a(fp.a().O(), 1));
        }
        localObject3 = this.d;
        if (!ed.b().n().d.f) {
          break label2122;
        }
        Object localObject1 = "1";
        ((HashMap)localObject3).put("have_changed_uin", localObject1);
        this.d.put("pay_id", ed.b().n().e.a);
        this.d.put("auth_key", ed.b().n().e.b);
        this.d.put("pay_session_id", ed.b().n().e.c);
        this.d.put("pay_session_type", ed.b().n().e.d);
        int m = -1;
        localObject1 = ed.b();
        int k = m;
        if (localObject1 != null)
        {
          localObject1 = ((ed)localObject1).n();
          k = m;
          if (localObject1 != null)
          {
            localObject1 = ((ec)localObject1).a;
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
        this.d.put("uuid", APTools.a(fp.a().i(), 1));
        this.d.put("drm_resource", fv.b().e());
        this.d.put("payChannel", String.valueOf(gd.a((String)localObject2)));
        this.d.put("payChannelName", localObject2);
        this.d.put("pay_method", this.h.d);
        this.d.put("amt", this.h.c);
        this.d.put("extend", this.h.f);
        this.d.put("service_code", this.h.g);
        if (((String)localObject2).equals("hfpay"))
        {
          if (((ed.b().n().a.saveType == 4) || (ed.b().n().a.saveType == 5)) && (!TextUtils.isEmpty(APHFChannel.o)) && ("0" != APHFChannel.o)) {
            this.d.put("gameCoinRate", APHFChannel.o);
          } else if ((ed.b().n().a.saveType == 0) && (!TextUtils.isEmpty(APHFChannel.n)) && ("0" != APHFChannel.n)) {
            this.d.put("gameCoinRate", APHFChannel.n);
          } else {
            this.d.put("gameCoinRate", ed.b().n().b.e);
          }
        }
        else {
          this.d.put("gameCoinRate", ed.b().n().b.e);
        }
        if (((String)localObject2).equals("hfpay"))
        {
          if (((ed.b().n().a.saveType == 4) || (ed.b().n().a.saveType == 5)) && (!TextUtils.isEmpty(APHFChannel.o)) && ("0" != APHFChannel.o)) {
            this.d.put("gameCoinRate", APHFChannel.o);
          } else if ((ed.b().n().a.saveType == 0) && (!TextUtils.isEmpty(APHFChannel.n)) && ("0" != APHFChannel.n)) {
            this.d.put("gameCoinRate", APHFChannel.n);
          } else {
            this.d.put("gameCoinRate", ed.b().n().b.e);
          }
        }
        else {
          this.d.put("gameCoinRate", ed.b().n().b.e);
        }
        localObject1 = fp.a().g();
        if ("AndroidPay".equals(localObject1)) {
          this.d.put("entry", "game");
        } else if ("APPayGameListNumActivity".equals(localObject1)) {
          this.d.put("entry", "sdk");
        }
        this.d.put("hasMpTuan", w.a().d());
        if (ed.b().n().d.b) {
          this.d.put("firstCharge", "1");
        } else {
          this.d.put("firstCharge", "0");
        }
        this.d.put("saveNumber", ed.b().n().e.g);
        this.d.put("PortalExtendField", fp.a().L());
        if (!fp.a().B()) {
          this.d.put("notShowContinueBuy", "1");
        }
        k = ed.b().n().a.saveType;
        if (k == 4)
        {
          localObject2 = ((APMonthRequest)ed.b().n().a).serviceCode;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          this.d.put("serviceCode", localObject1);
          return;
        }
        if (k == 5)
        {
          localObject2 = ((APSubscribeRequest)ed.b().n().a).serviceCode;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject3 = ((APSubscribeRequest)ed.b().n().a).productId;
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
          localObject2 = ((APGoodsRequest)ed.b().n().a).prodcutId;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.id
 * JD-Core Version:    0.7.0.1
 */