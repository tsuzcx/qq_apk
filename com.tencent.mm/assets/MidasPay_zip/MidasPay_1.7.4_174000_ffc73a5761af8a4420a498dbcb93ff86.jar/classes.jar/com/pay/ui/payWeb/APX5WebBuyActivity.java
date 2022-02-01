package com.pay.ui.payWeb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.api.request.APGameRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.marketing.APX5WebMarketActivity;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import midas.x.a;
import midas.x.ac;
import midas.x.by;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.ew;
import midas.x.fa;
import midas.x.fp;
import midas.x.fv;
import midas.x.fw;
import midas.x.fy;
import midas.x.gc;
import midas.x.gf;
import midas.x.hu;
import midas.x.hv;
import midas.x.hy;
import midas.x.hz;
import midas.x.j;
import midas.x.lh;
import midas.x.lw;
import midas.x.w;
import midas.x.x;

public class APX5WebBuyActivity
  extends APX5WebActivity
{
  public static String a = hu.s;
  boolean u = false;
  public hz v = new hz()
  {
    public void a(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      APLog.i("APX5WebBuyActivity", "WebReceivedError");
    }
    
    public void a(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      APLog.i("APX5WebBuyActivity", "WebShouldUrlLoading");
      if (paramAnonymousString.startsWith("http://unipay.sdk.android/?")) {
        APX5WebBuyActivity.a(APX5WebBuyActivity.this, paramAnonymousString);
      }
    }
    
    public void a(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      APLog.i("APX5WebBuyActivity", "WebPageStarted");
      if (paramAnonymousString.startsWith("http://unipay.sdk.android/?"))
      {
        APX5WebBuyActivity.this.d.stopLoading();
        APX5WebBuyActivity.a(APX5WebBuyActivity.this, paramAnonymousString);
      }
    }
    
    public void b(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      APLog.i("APX5WebBuyActivity", "WebPageFinished");
      paramAnonymousWebView = w.a().g();
      if ((paramAnonymousWebView != null) && (("1".equals(paramAnonymousWebView.a())) || ("-1".equals(paramAnonymousWebView.a()))))
      {
        paramAnonymousWebView = fw.a().c();
        paramAnonymousString = new StringBuilder();
        paramAnonymousString.append("javascript:setTime");
        paramAnonymousString.append(paramAnonymousWebView);
        APLog.i("APX5WebBuyActivity", paramAnonymousString.toString());
        paramAnonymousString = APX5WebBuyActivity.this.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:setTime(");
        localStringBuilder.append(paramAnonymousWebView);
        localStringBuilder.append(")");
        paramAnonymousString.loadUrl(localStringBuilder.toString());
      }
    }
  };
  private int w = -1;
  private String x = "";
  private String y = "";
  private hy z = new hy()
  {
    public void a(WebView paramAnonymousWebView) {}
    
    public void a(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
    {
      APLog.i("APX5WebBuyActivity webJsAlert url=", paramAnonymousString1);
      APLog.i("APX5WebBuyActivity webJsAlert message=", paramAnonymousString2);
      paramAnonymousWebView = paramAnonymousString2.toString();
      if (paramAnonymousWebView.startsWith("http://unipay.sdk.android/?"))
      {
        APX5WebBuyActivity.a(APX5WebBuyActivity.this, paramAnonymousWebView);
      }
      else if (j.a(APX5WebBuyActivity.this, paramAnonymousString1, paramAnonymousString2) == 0)
      {
        paramAnonymousWebView = new StringBuilder();
        paramAnonymousWebView.append("url=");
        paramAnonymousWebView.append(paramAnonymousString1);
        paramAnonymousWebView.append("  hook=true");
        APLog.d("h5PayHook", paramAnonymousWebView.toString());
        paramAnonymousJsResult.cancel();
        return;
      }
      paramAnonymousJsResult.cancel();
    }
    
    public void a(WebView paramAnonymousWebView, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, Message paramAnonymousMessage) {}
  };
  
  private void a(String paramString)
  {
    new HashMap();
    Object localObject4 = APTools.b(paramString);
    paramString = (String)((HashMap)localObject4).get("page");
    Object localObject1 = (String)((HashMap)localObject4).get("action");
    String str1 = (String)((HashMap)localObject4).get("saveNumber");
    localObject3 = (String)((HashMap)localObject4).get("saveType");
    Object localObject5 = (String)((HashMap)localObject4).get("callback");
    if (hu.s.equals(paramString))
    {
      this.d.goBack();
      if (hu.G.equals(localObject1))
      {
        APDataReportManager.getInstance().insertData(this.q.e, 0, null, null, str1);
        if (((String)localObject3).equals(String.valueOf(0)))
        {
          c(str1);
          return;
        }
        APLog.e("APX5WebBuyActivity", "saveType不匹配");
        return;
      }
      if (hu.N.equals(localObject1))
      {
        b((String)localObject5);
        return;
      }
      if (hu.I.equals(localObject1))
      {
        APUICommonMethod.b();
        fv.a(2, "支付取消");
        return;
      }
      if (hu.J.equals(localObject1))
      {
        APDataReportManager.getInstance().insertData(this.q.d, 0, null, null, str1);
        APUICommonMethod.b();
        fv.a(2, "支付关闭");
      }
    }
    else if (hu.t.equals(paramString))
    {
      if (hu.G.equals(localObject1))
      {
        paramString = (String)((HashMap)localObject4).get("productId");
        APDataReportManager.getInstance().insertData("sdk.tuan.h5.pay", 0, paramString, null, null, null);
        a(paramString, str1);
        return;
      }
      if (hu.J.equals(localObject1))
      {
        APDataReportManager.getInstance().insertData("sdk.tuan.h5.close", 0);
        APUICommonMethod.b();
        fv.a(2, "支付关闭");
      }
    }
    else if (hu.u.equals(paramString))
    {
      this.d.goBack();
      if (hu.G.equals(localObject1))
      {
        APDataReportManager.getInstance().insertData(this.q.g, 0, null, null, str1);
        c(str1);
        return;
      }
      if (hu.I.equals(localObject1))
      {
        APUICommonMethod.b();
        fv.a(2, "支付取消");
        return;
      }
      if (hu.J.equals(localObject1))
      {
        APDataReportManager.getInstance().insertData(this.q.d, 0, null, null, str1);
        APUICommonMethod.b();
        fv.a(2, "支付关闭");
      }
    }
    else if (hu.v.equals(paramString))
    {
      this.d.goBack();
      if (hu.H.equals(localObject1)) {
        APDataReportManager.getInstance().insertData(this.q.i, 0, null, null, str1);
      }
    }
    try
    {
      paramString = (String)((HashMap)localObject4).get("pre_uuid");
    }
    catch (Exception paramString)
    {
      label516:
      String str9;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      String str7;
      String str10;
      String str8;
      break label516;
    }
    try
    {
      localObject1 = (String)((HashMap)localObject4).get("canChange");
      localObject3 = (String)((HashMap)localObject4).get("drm_act_type");
    }
    catch (Exception localException1)
    {
      break label519;
    }
    try
    {
      localObject1 = (String)((HashMap)localObject4).get("drm_resource");
    }
    catch (Exception localException2)
    {
      localObject2 = localObject3;
      break label523;
    }
    paramString = "";
    label519:
    localObject1 = "";
    label523:
    localObject4 = "";
    localObject3 = localObject1;
    localObject1 = localObject4;
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty(paramString)) && (((String)localObject3).equals("rtg_type")))
    {
      localObject4 = fy.a();
      localObject5 = new APGameRequest();
      ((APGameRequest)localObject5).offerId = em.b().n().a.offerId;
      ((APGameRequest)localObject5).openId = em.b().n().a.openId;
      ((APGameRequest)localObject5).openKey = em.b().n().a.openKey;
      ((APGameRequest)localObject5).pf = em.b().n().a.pf;
      ((APGameRequest)localObject5).pfKey = em.b().n().a.pfKey;
      ((APGameRequest)localObject5).sessionId = em.b().n().a.sessionId;
      ((APGameRequest)localObject5).sessionType = em.b().n().a.sessionType;
      ((APGameRequest)localObject5).zoneId = em.b().n().a.zoneId;
      ((APGameRequest)localObject5).resData = ((fy)localObject4).e();
      ((APGameRequest)localObject5).saveValue = str1;
      ((APGameRequest)localObject5).isCanChange = false;
      gf.b().a(paramString);
      gf.b().b((String)localObject3);
      gf.b().c((String)localObject1);
      APUICommonMethod.d();
      a.a().a(this, (APBaseRequest)localObject5, a.a().a);
      return;
    }
    m();
    return;
    if (hu.N.equals(localObject1))
    {
      b((String)localObject5);
      return;
    }
    if (hu.G.equals(localObject1))
    {
      if (((String)localObject3).equals(String.valueOf(0)))
      {
        APUICommonMethod.a(this, "暂不支持充值游戏币");
        return;
      }
      if (((String)localObject3).equals(String.valueOf(1)))
      {
        APDataReportManager.getInstance().insertData(this.q.h, 1, null, null, str1);
        str9 = (String)((HashMap)localObject4).get("offerId");
        localObject1 = (String)((HashMap)localObject4).get("openId");
        localObject3 = (String)((HashMap)localObject4).get("openKey");
        localObject5 = (String)((HashMap)localObject4).get("pf");
        str2 = (String)((HashMap)localObject4).get("pfKey");
        str3 = (String)((HashMap)localObject4).get("sessionId");
        str4 = (String)((HashMap)localObject4).get("sessionType");
        str5 = (String)((HashMap)localObject4).get("zoneId");
        str6 = (String)((HashMap)localObject4).get("canChange");
        str7 = (String)((HashMap)localObject4).get("productId");
        str10 = (String)((HashMap)localObject4).get("goodsExtras");
        str8 = (String)((HashMap)localObject4).get("isToken");
        try
        {
          paramString = URLDecoder.decode((String)((HashMap)localObject4).get("tokenUrl"), "utf-8");
        }
        catch (UnsupportedEncodingException paramString)
        {
          paramString.printStackTrace();
          paramString = "";
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(str9);
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject4).append((String)localObject1);
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject4).append(str3);
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject4).append(str4);
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject4).append(str5);
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject4).append((String)localObject5);
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject4).append(str2);
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject4).append(str7);
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject4).append(str1);
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject4).append(str8);
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject4).append(str10);
        APLog.i("params: offerId , openId , openKey, sessionId, sessionType, zoneId, pf, pfKey, productId, saveNumber, isToken, goodsExtras", ((StringBuilder)localObject4).toString());
        localObject4 = new APGoodsRequest();
        ((APGoodsRequest)localObject4).openId = ((String)localObject1);
        ((APGoodsRequest)localObject4).openKey = ((String)localObject3);
        ((APGoodsRequest)localObject4).sessionId = str3;
        ((APGoodsRequest)localObject4).sessionType = str4;
        ((APGoodsRequest)localObject4).zoneId = str5;
        ((APGoodsRequest)localObject4).pf = ((String)localObject5);
        ((APGoodsRequest)localObject4).pfKey = str2;
        if (str8.equals("0"))
        {
          ((APGoodsRequest)localObject4).tokenType = 2;
          ((APGoodsRequest)localObject4).prodcutId = str7;
          ((APGoodsRequest)localObject4).saveValue = str1;
          if (str6.equals("0"))
          {
            ((APGoodsRequest)localObject4).isCanChange = false;
            a.a().a(this, (APBaseRequest)localObject4, null);
            return;
          }
          ((APGoodsRequest)localObject4).isCanChange = true;
          a.a().a(this, (APBaseRequest)localObject4, null);
          return;
        }
        if (str8.equals("1"))
        {
          ((APGoodsRequest)localObject4).tokenType = 1;
          ((APGoodsRequest)localObject4).goodsTokenUrl = paramString;
          a.a().a(this, (APBaseRequest)localObject4, null);
          return;
        }
        APUICommonMethod.a(this, "参数错误");
      }
    }
    else
    {
      if (hu.I.equals(localObject1))
      {
        APDataReportManager.getInstance().insertData(this.q.d, 0, null, null, str1);
        if ((a.a().a(em.b().n().a)) && ("bank".equals(em.b().n().a.mpInfo.payChannel)))
        {
          APUICommonMethod.b();
          paramString = new Intent();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("loadUI", "showBankResultActivity");
          paramString.putExtras((Bundle)localObject1);
          paramString.setClass(this, APX5WebMarketActivity.class);
          startActivity(paramString);
          return;
        }
        if ((a.a().a(em.b().n().a)) && ("wechat".equals(em.b().n().a.mpInfo.payChannel)))
        {
          APUICommonMethod.b();
          paramString = new Intent();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("loadUI", "showWechatResultActivity");
          paramString.putExtras((Bundle)localObject1);
          paramString.setClass(this, APX5WebMarketActivity.class);
          startActivity(paramString);
          return;
        }
        if ((this.w != 0) && (this.w != 11) && (this.w != 4))
        {
          APUICommonMethod.b();
          fv.a(this.w, 0, -1);
          return;
        }
        APUICommonMethod.b();
        fv.a(this.w, 0, 0);
        return;
      }
      if (!hu.U.equals(localObject1)) {}
    }
    try
    {
      paramString = APTools.b((String)((HashMap)localObject4).get("wx_link_title"), 1);
    }
    catch (Exception paramString)
    {
      label1769:
      label1772:
      label1776:
      break label1769;
    }
    try
    {
      localObject1 = APTools.b((String)((HashMap)localObject4).get("wx_link"), 1);
    }
    catch (Exception localException3)
    {
      break label1772;
    }
    try
    {
      localObject3 = APTools.b((String)((HashMap)localObject4).get("wx_description"), 1);
    }
    catch (Exception localException5)
    {
      break label1776;
    }
    paramString = "";
    localObject1 = "";
    localObject3 = "";
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("shareTitle, shareLink, shareDescription");
    ((StringBuilder)localObject4).append(paramString);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append((String)localObject3);
    APLog.i("分享好友", ((StringBuilder)localObject4).toString());
    new fp(this).a(0, paramString, (String)localObject1, (String)localObject3);
    return;
    if (hu.V.equals(localObject1)) {}
    try
    {
      paramString = APTools.b((String)((HashMap)localObject4).get("wx_link_title"), 1);
    }
    catch (Exception paramString)
    {
      label1932:
      label1935:
      label1939:
      break label1932;
    }
    try
    {
      localObject1 = APTools.b((String)((HashMap)localObject4).get("wx_link"), 1);
    }
    catch (Exception localException4)
    {
      break label1935;
    }
    try
    {
      localObject3 = APTools.b((String)((HashMap)localObject4).get("wx_description"), 1);
    }
    catch (Exception localException6)
    {
      break label1939;
    }
    paramString = "";
    localObject1 = "";
    localObject3 = "";
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("shareTitle, shareLink, shareDescription");
    ((StringBuilder)localObject4).append(paramString);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append((String)localObject3);
    APLog.i("恩赐朋友圈", ((StringBuilder)localObject4).toString());
    new fp(this).a(1, paramString, (String)localObject1, (String)localObject3);
    return;
    if (hu.W.equals(localObject1)) {}
    try
    {
      paramString = APTools.c(this, "com.tencent.mm");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("微信版本号：");
      ((StringBuilder)localObject1).append(paramString);
      APLog.i("APX5WebBuyActivity微信版本号", ((StringBuilder)localObject1).toString());
      if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
        break label2423;
      }
      localObject1 = paramString.split("\\.");
      int j = 0;
      i = j;
      if (!TextUtils.isEmpty(localObject1[0]))
      {
        i = j;
        if (!TextUtils.isEmpty(localObject1[1])) {
          if (localObject1[0].compareTo("6") == 0)
          {
            if (localObject1[1].compareTo("2") < 0) {
              break label2423;
            }
          }
          else
          {
            i = 0;
            if (localObject1[0].compareTo("6") <= 0) {}
          }
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject2;
        continue;
        int i = 1;
        continue;
        i = 0;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("微信版本号：");
    ((StringBuilder)localObject1).append(paramString);
    APLog.i("APX5WebBuyActivity微信版本号", ((StringBuilder)localObject1).toString());
    if (i != 0)
    {
      paramString = (String)((HashMap)localObject4).get("cardId");
      localObject1 = APTools.b((String)((HashMap)localObject4).get("wxsign"), 1);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("h5回调SDK,cardId=");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append(";;wxsign=");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(";wxAppId=");
      ((StringBuilder)localObject3).append(fp.a);
      APLog.i("领取话费券", ((StringBuilder)localObject3).toString());
      new fp(this, fp.a).a(paramString, (String)localObject1);
      return;
    }
    by.a().k(new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        APLog.i("APAndroidPay", "插话费卡券onFinish");
      }
      
      public void b(lh paramAnonymouslh)
      {
        APLog.i("APAndroidPay", "插话费卡券onError");
      }
      
      public void c(lh paramAnonymouslh)
      {
        APLog.i("APAndroidPay", "插话费卡券onStop");
      }
    });
    APUICommonMethod.a(this, "当前微信版本过低，请升级到最新版本！");
    return;
    APLog.i("APX5WebBuyActivity", "微信版本号判断异常!");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return;
    }
    APUICommonMethod.a(this, "产品ID或数量不能为空");
  }
  
  private void b(String paramString)
  {
    Object localObject = ac.a().f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("window['");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'](");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(")");
    paramString = localStringBuilder.toString();
    APLog.e("sendMpInfo callback=============", paramString);
    localObject = this.d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:");
    localStringBuilder.append(paramString);
    ((WebView)localObject).loadUrl(localStringBuilder.toString());
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      em.b().n().e.g = paramString;
      paramString = new Intent(this, APRecoChannelActivity.class);
      paramString.putExtra("to", 3);
      startActivity(paramString);
      return;
    }
    APUICommonMethod.a(this, "充值数量不能为空");
  }
  
  private String l()
  {
    return hu.p;
  }
  
  private void m()
  {
    if ((this.w != 0) && (this.w != 11) && (this.w != 4)) {
      fv.a(0, 0, this.w, 0, -1, "", "");
    } else {
      fv.a(0, 0, this.w, 0, 0, "", "");
    }
    if ((this.w == 0) || (this.w == 11))
    {
      Bundle localBundle = getIntent().getExtras();
      if ((localBundle != null) && (!TextUtils.isEmpty(localBundle.getString("changeQQ"))))
      {
        gc.a().a(true);
        APLog.i("APTag", "resultData=更换QQ号码继续充值按钮点击");
      }
    }
    APUICommonMethod.d();
    this.u = true;
  }
  
  public void a()
  {
    setContentView(2131165269);
    this.d = ((WebView)findViewById(2131099770));
    this.e = ((AP3PointsLoading)findViewById(2131099699));
    this.d.setVisibility(8);
    this.e.b();
  }
  
  public void c()
  {
    hv localhv = new hv();
    localhv.n = this.v;
    localhv.o = this.z;
    if (a.equals(hu.s))
    {
      localhv.a = fy.a().o();
      localhv.p.put("page", hu.s);
      localhv.c = "sdk.gamelist.h5.show";
      localhv.d = "sdk.gamelist.h5.back";
      localhv.e = "sdk.gamelist.h5.click";
      localhv.g = "sdk.gameinput.h5.pay";
      localhv.j = "sdk.gamelist.h5.keyback";
      localhv.k = "sdk.gamelist.h5.error";
      localhv.l = "sdk.gamelist.h5.refresh";
    }
    else if (a.equals(hu.t))
    {
      String str = w.a().e();
      if (TextUtils.isEmpty(str))
      {
        APUICommonMethod.b();
        fv.a(-1, 1004, "没有配置团购mallUrl");
      }
      localhv.a = str;
      localhv.p.put("page", hu.t);
      localhv.c = "sdk.tuan.h5.show";
      localhv.d = "sdk.tuan.h5.close";
      localhv.g = "sdk.tuan.h5.pay";
      localhv.j = "sdk.tuan.h5.keyback";
      localhv.k = "sdk.tuan.h5.error";
      localhv.l = "sdk.tuan.h5.refresh";
    }
    else if ((!a.equals(hu.u)) && (a.equals(hu.v)))
    {
      if (em.b().n().b.j == "buytuan") {
        localhv.a = w.a().f();
      } else {
        localhv.a = fy.a().p();
      }
      localhv.p.put("page", hu.v);
      localhv.p.put("saveNumber", em.b().n().e.g);
      localhv.p.put("PortalExtendField", fy.a().L());
      localhv.p.put("appId", this.x);
      localhv.p.put("wxSignUrl", this.y);
      if ((fy.a().A()) && (this.w == 5))
      {
        int i = getIntent().getIntExtra("mcardDepositBalance", 0);
        if (i > 0) {
          localhv.p.put("mcardDepositBalance", APTools.a(i));
        }
      }
      if (!fy.a().B()) {
        localhv.p.put("notShowContinueBuy", "1");
      }
      localhv.h = "sdk.result.h5.pay";
      localhv.d = "sdk.result.h5.back";
      localhv.i = "sdk.result.h5.repay";
      localhv.j = "sdk.result.h5.keyback";
      localhv.c = "sdk.result.h5.show";
      localhv.k = "sdk.result.h5.error";
      localhv.l = "sdk.result.h5.refresh";
    }
    this.q = localhv;
  }
  
  protected void h()
  {
    String str = APAppDataInterface.singleton().e();
    if (str.equals("release"))
    {
      this.q.b = hu.d;
      return;
    }
    if ((!str.equals("test")) && (!str.equals("dev")))
    {
      if ((str.equals("custom")) && ("dev".equals(APAppDataInterface.singleton().k())))
      {
        this.q.b = hu.c;
        return;
      }
      this.q.b = hu.d;
      return;
    }
    this.q.b = hu.c;
  }
  
  protected String i()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(hu.a);
    ((StringBuilder)localObject1).append(this.q.b);
    ((StringBuilder)localObject1).append(this.q.a);
    ((StringBuilder)localObject1).append(l());
    Object localObject2 = ((StringBuilder)localObject1).toString();
    if (((String)localObject2).contains("?"))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).endsWith("?"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("&");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("?");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = "";
    try
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("&random=");
      ((StringBuilder)localObject3).append(String.valueOf(Math.random() * 100.0D));
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject2 = localObject3;
    }
    catch (Exception localException)
    {
      Object localObject3;
      label174:
      break label174;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(APTools.a(this.q.p));
    ((StringBuilder)localObject3).append((String)localObject2);
    return ((StringBuilder)localObject3).toString();
  }
  
  protected void k()
  {
    Object localObject;
    if (em.b().n().a.saveType == 4)
    {
      localObject = (APMonthRequest)em.b().n().a;
      this.q.p.put("service_code", ((APMonthRequest)localObject).serviceCode);
      this.q.p.put("service_name", ((APMonthRequest)localObject).serviceName);
      localObject = (ew)em.b().n().b;
      this.q.p.put("uin", ((ew)localObject).m);
    }
    if (em.b().n().a.saveType == 5)
    {
      localObject = (APMonthRequest)em.b().n().a;
      this.q.p.put("service_code", ((APMonthRequest)localObject).serviceCode);
      this.q.p.put("service_name", ((APMonthRequest)localObject).serviceName);
      localObject = (ew)em.b().n().b;
      this.q.p.put("productid", ((ew)localObject).k);
      this.q.p.put("uin", ((ew)localObject).m);
    }
    this.q.p.put("aid", em.b().n().a.remark);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("appid"))
      {
        this.x = paramBundle.getString("appid");
        if (paramBundle.containsKey("wxSignUrl")) {
          this.y = APTools.a(paramBundle.getString("wxSignUrl"), 1);
        }
      }
      this.w = paramBundle.getInt("channel");
    }
    a.a().f = true;
    j();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.u) {
      APLog.i("APWebBuyAct", "destroy");
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      APDataReportManager.getInstance().insertData(this.q.j, this.f);
      if (a.equals(hu.s))
      {
        if (this.d.canGoBack())
        {
          this.d.goBack();
          return true;
        }
        APUICommonMethod.b();
        fv.a(2, "支付取消");
      }
      else if (a.equals(hu.t))
      {
        if (this.d.canGoBack())
        {
          this.d.goBack();
          return true;
        }
        if (fy.a().g().equals("APPayGameListNumActivity"))
        {
          finish();
          APUICommonMethod.b(this);
        }
        else
        {
          APUICommonMethod.b();
          fv.a(2, "支付取消");
        }
      }
      else if ((!a.equals(hu.u)) && (a.equals(hu.v)))
      {
        Intent localIntent;
        Bundle localBundle;
        if ((a.a().a(em.b().n().a)) && ("bank".equals(em.b().n().a.mpInfo.payChannel)))
        {
          APUICommonMethod.b();
          localIntent = new Intent();
          localBundle = new Bundle();
          localBundle.putString("loadUI", "showBankResultActivity");
          localIntent.putExtras(localBundle);
          localIntent.setClass(this, APX5WebMarketActivity.class);
          startActivity(localIntent);
        }
        else if ((a.a().a(em.b().n().a)) && ("wechat".equals(em.b().n().a.mpInfo.payChannel)))
        {
          APUICommonMethod.b();
          localIntent = new Intent();
          localBundle = new Bundle();
          localBundle.putString("loadUI", "showWechatResultActivity");
          localIntent.putExtras(localBundle);
          localIntent.setClass(this, APX5WebMarketActivity.class);
          startActivity(localIntent);
        }
        else if ((this.w != 0) && (this.w != 11) && (this.w != 4))
        {
          APUICommonMethod.b();
          fv.a(this.w, 0, -1);
        }
        else
        {
          APUICommonMethod.b();
          fv.a(this.w, 0, 0);
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager.getInstance().insertData(this.q.c, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.APX5WebBuyActivity
 * JD-Core Version:    0.7.0.1
 */