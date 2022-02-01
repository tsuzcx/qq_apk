package com.pay.ui.payWeb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.JsResult;
import android.webkit.WebView;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.api.request.APGameRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.marketing.APWebMarketActivity;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import midas.x.a;
import midas.x.a6;
import midas.x.a8;
import midas.x.b8;
import midas.x.c6;
import midas.x.d0;
import midas.x.d5;
import midas.x.fc;
import midas.x.g6;
import midas.x.j;
import midas.x.j6;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.t5;
import midas.x.w4;
import midas.x.x;
import midas.x.x7;
import midas.x.y;
import midas.x.y7;
import midas.x.z1;
import midas.x.z4;
import midas.x.z5;

public class APWebBuyActivity
  extends APWebActivity
{
  public static String q = y7.q;
  public boolean k = false;
  public int l = -1;
  public b8 m = new a();
  public String n = "";
  public String o = "";
  public a8 p = new b();
  
  public final void a(String paramString)
  {
    Object localObject = d0.i().d();
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
  
  public final void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return;
    }
    APUICommonMethod.a(this, "产品ID或数量不能为空");
  }
  
  public final void b(String paramString)
  {
    new HashMap();
    Object localObject4 = APTools.n(paramString);
    paramString = (String)((HashMap)localObject4).get("page");
    String str1 = (String)((HashMap)localObject4).get("action");
    Object localObject3 = (String)((HashMap)localObject4).get("saveNumber");
    Object localObject2 = (String)((HashMap)localObject4).get("saveType");
    Object localObject5 = (String)((HashMap)localObject4).get("callback");
    if (y7.q.equals(paramString))
    {
      this.d.goBack();
      if (y7.C.equals(str1))
      {
        APDataReportManager.getInstance().insertData(this.f.e, 0, null, null, (String)localObject3);
        if (((String)localObject2).equals(String.valueOf(0)))
        {
          c((String)localObject3);
          return;
        }
        APLog.e("APWebBuyActivity", "saveType不匹配");
        return;
      }
      if (y7.I.equals(str1))
      {
        a((String)localObject5);
        return;
      }
      if (y7.E.equals(str1))
      {
        APUICommonMethod.f();
        z5.a(2, "支付取消");
        return;
      }
      if (y7.F.equals(str1))
      {
        APDataReportManager.getInstance().insertData(this.f.d, 0, null, null, (String)localObject3);
        APUICommonMethod.f();
        z5.a(2, "支付关闭");
      }
    }
    else if (y7.r.equals(paramString))
    {
      if (y7.C.equals(str1))
      {
        paramString = (String)((HashMap)localObject4).get("productId");
        APDataReportManager.getInstance().insertData("sdk.tuan.h5.pay", 0, paramString, null, null, null);
        a(paramString, (String)localObject3);
        return;
      }
      if (y7.F.equals(str1))
      {
        APDataReportManager.getInstance().insertData("sdk.tuan.h5.close", 0);
        APUICommonMethod.f();
        z5.a(2, "支付关闭");
      }
    }
    else if (y7.s.equals(paramString))
    {
      this.d.goBack();
      if (y7.C.equals(str1))
      {
        APDataReportManager.getInstance().insertData(this.f.f, 0, null, null, (String)localObject3);
        c((String)localObject3);
        return;
      }
      if (y7.E.equals(str1))
      {
        APUICommonMethod.f();
        z5.a(2, "支付取消");
        return;
      }
      if (y7.F.equals(str1))
      {
        APDataReportManager.getInstance().insertData(this.f.d, 0, null, null, (String)localObject3);
        APUICommonMethod.f();
        z5.a(2, "支付关闭");
      }
    }
    else if (y7.t.equals(paramString))
    {
      this.d.goBack();
      boolean bool = y7.D.equals(str1);
      paramString = "";
      if (bool) {
        APDataReportManager.getInstance().insertData(this.f.h, 0, null, null, (String)localObject3);
      }
    }
    try
    {
      str1 = (String)((HashMap)localObject4).get("pre_uuid");
    }
    catch (Exception paramString)
    {
      label522:
      String str10;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      String str7;
      String str8;
      String str11;
      String str9;
      Object localObject1;
      break label528;
    }
    try
    {
      paramString = (String)((HashMap)localObject4).get("canChange");
      paramString = (String)((HashMap)localObject4).get("drm_act_type");
    }
    catch (Exception paramString)
    {
      break label522;
    }
    try
    {
      localObject2 = (String)((HashMap)localObject4).get("drm_resource");
    }
    catch (Exception localException5)
    {
      break label535;
    }
    paramString = "";
    break label535;
    label528:
    str1 = "";
    paramString = str1;
    label535:
    localObject2 = "";
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str1)) && (paramString.equals("rtg_type")))
    {
      localObject4 = c6.s0();
      localObject5 = new APGameRequest();
      ((APBaseRequest)localObject5).offerId = p4.p().e().b.offerId;
      ((APBaseRequest)localObject5).openId = p4.p().e().b.openId;
      ((APBaseRequest)localObject5).openKey = p4.p().e().b.openKey;
      ((APBaseRequest)localObject5).pf = p4.p().e().b.pf;
      ((APBaseRequest)localObject5).pfKey = p4.p().e().b.pfKey;
      ((APBaseRequest)localObject5).sessionId = p4.p().e().b.sessionId;
      ((APBaseRequest)localObject5).sessionType = p4.p().e().b.sessionType;
      ((APBaseRequest)localObject5).zoneId = p4.p().e().b.zoneId;
      ((APBaseRequest)localObject5).resData = ((c6)localObject4).b();
      ((APBaseRequest)localObject5).saveValue = ((String)localObject3);
      ((APBaseRequest)localObject5).isCanChange = false;
      j6.e().c(str1);
      j6.e().a(paramString);
      j6.e().b((String)localObject2);
      APUICommonMethod.g();
      a.r().a(this, (APBaseRequest)localObject5, a.r().a);
      return;
    }
    p();
    return;
    if (y7.I.equals(str1))
    {
      a((String)localObject5);
      return;
    }
    if (y7.C.equals(str1))
    {
      if (((String)localObject2).equals(String.valueOf(0)))
      {
        APUICommonMethod.a(this, "暂不支持充值游戏币");
        return;
      }
      if (((String)localObject2).equals(String.valueOf(1)))
      {
        APDataReportManager.getInstance().insertData(this.f.g, 1, null, null, (String)localObject3);
        str10 = (String)((HashMap)localObject4).get("offerId");
        localObject2 = (String)((HashMap)localObject4).get("openId");
        localObject5 = (String)((HashMap)localObject4).get("openKey");
        str2 = (String)((HashMap)localObject4).get("pf");
        str3 = (String)((HashMap)localObject4).get("pfKey");
        str4 = (String)((HashMap)localObject4).get("sessionId");
        str5 = (String)((HashMap)localObject4).get("sessionType");
        str6 = (String)((HashMap)localObject4).get("zoneId");
        str7 = (String)((HashMap)localObject4).get("canChange");
        str8 = (String)((HashMap)localObject4).get("productId");
        str11 = (String)((HashMap)localObject4).get("goodsExtras");
        str9 = (String)((HashMap)localObject4).get("isToken");
        try
        {
          str1 = URLDecoder.decode((String)((HashMap)localObject4).get("tokenUrl"), "utf-8");
          paramString = str1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str10);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append((String)localObject5);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(str4);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(str5);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(str6);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(str3);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(str8);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(str9);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(str11);
        APLog.i("params: offerId , openId , openKey, sessionId, sessionType, zoneId, pf, pfKey, productId, saveNumber, isToken, goodsExtras", ((StringBuilder)localObject1).toString());
        localObject1 = new APGoodsRequest();
        ((APBaseRequest)localObject1).openId = ((String)localObject2);
        ((APBaseRequest)localObject1).openKey = ((String)localObject5);
        ((APBaseRequest)localObject1).sessionId = str4;
        ((APBaseRequest)localObject1).sessionType = str5;
        ((APBaseRequest)localObject1).zoneId = str6;
        ((APBaseRequest)localObject1).pf = str2;
        ((APBaseRequest)localObject1).pfKey = str3;
        if (str9.equals("0"))
        {
          ((APGoodsRequest)localObject1).tokenType = 2;
          ((APGoodsRequest)localObject1).prodcutId = str8;
          ((APBaseRequest)localObject1).saveValue = ((String)localObject3);
          if (str7.equals("0"))
          {
            ((APBaseRequest)localObject1).isCanChange = false;
            a.r().a(this, (APBaseRequest)localObject1, null);
            return;
          }
          ((APBaseRequest)localObject1).isCanChange = true;
          a.r().a(this, (APBaseRequest)localObject1, null);
          return;
        }
        if (str9.equals("1"))
        {
          ((APGoodsRequest)localObject1).tokenType = 1;
          ((APGoodsRequest)localObject1).goodsTokenUrl = paramString;
          a.r().a(this, (APBaseRequest)localObject1, null);
          return;
        }
        APUICommonMethod.a(this, "参数错误");
      }
    }
    else
    {
      if (y7.E.equals(localObject1))
      {
        APDataReportManager.getInstance().insertData(this.f.d, 0, null, null, (String)localObject3);
        if ((a.r().e(p4.p().e().b)) && ("bank".equals(p4.p().e().b.mpInfo.payChannel)))
        {
          APUICommonMethod.f();
          paramString = new Intent();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("loadUI", "showBankResultActivity");
          paramString.putExtras((Bundle)localObject1);
          paramString.setClass(this, APWebMarketActivity.class);
          startActivity(paramString);
          return;
        }
        if ((a.r().e(p4.p().e().b)) && ("wechat".equals(p4.p().e().b.mpInfo.payChannel)))
        {
          APUICommonMethod.f();
          paramString = new Intent();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("loadUI", "showWechatResultActivity");
          paramString.putExtras((Bundle)localObject1);
          paramString.setClass(this, APWebMarketActivity.class);
          startActivity(paramString);
          return;
        }
        i = this.l;
        if ((i != 0) && (i != 11) && (i != 4))
        {
          APUICommonMethod.f();
          z5.a(this.l, 0, -1);
          return;
        }
        APUICommonMethod.f();
        z5.a(this.l, 0, 0);
        return;
      }
      if (!y7.O.equals(localObject1)) {}
    }
    try
    {
      localObject2 = APTools.a((String)((HashMap)localObject4).get("wx_link_title"), 1);
    }
    catch (Exception localException1)
    {
      label1775:
      break label1782;
    }
    try
    {
      localObject1 = APTools.a((String)((HashMap)localObject4).get("wx_link"), 1);
    }
    catch (Exception localException2)
    {
      break label1775;
    }
    try
    {
      localObject3 = APTools.a((String)((HashMap)localObject4).get("wx_description"), 1);
      paramString = (String)localObject3;
    }
    catch (Exception localException6)
    {
      break label1790;
    }
    localObject1 = "";
    break label1790;
    label1782:
    localObject2 = "";
    localObject1 = localObject2;
    label1790:
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("shareTitle, shareLink, shareDescription");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(",");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(",");
    ((StringBuilder)localObject3).append(paramString);
    APLog.i("分享好友", ((StringBuilder)localObject3).toString());
    new t5(this).a(0, (String)localObject2, (String)localObject1, paramString);
    return;
    if (y7.P.equals(localObject1)) {}
    try
    {
      localObject2 = APTools.a((String)((HashMap)localObject4).get("wx_link_title"), 1);
    }
    catch (Exception localException3)
    {
      label1946:
      label1953:
      label1961:
      break label1953;
    }
    try
    {
      localObject1 = APTools.a((String)((HashMap)localObject4).get("wx_link"), 1);
    }
    catch (Exception localException4)
    {
      break label1946;
    }
    try
    {
      localObject3 = APTools.a((String)((HashMap)localObject4).get("wx_description"), 1);
      paramString = (String)localObject3;
    }
    catch (Exception localException7)
    {
      break label1961;
    }
    localObject1 = "";
    break label1961;
    localObject2 = "";
    localObject1 = localObject2;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("shareTitle, shareLink, shareDescription");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(",");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(",");
    ((StringBuilder)localObject3).append(paramString);
    APLog.i("恩赐朋友圈", ((StringBuilder)localObject3).toString());
    new t5(this).a(1, (String)localObject2, (String)localObject1, paramString);
    return;
    if (y7.Q.equals(localObject1)) {}
    try
    {
      paramString = APTools.a(this, "com.tencent.mm");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("微信版本号：");
      ((StringBuilder)localObject1).append(paramString);
      APLog.i("APWebBuyActivity微信版本号", ((StringBuilder)localObject1).toString());
      if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
        break label2438;
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
              break label2438;
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
        continue;
        i = 1;
        continue;
        i = 0;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("微信版本号：");
    ((StringBuilder)localObject1).append(paramString);
    APLog.i("APWebBuyActivity微信版本号", ((StringBuilder)localObject1).toString());
    if (i != 0)
    {
      paramString = (String)((HashMap)localObject4).get("cardId");
      localObject1 = APTools.a((String)((HashMap)localObject4).get("wxsign"), 1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("h5回调SDK,cardId=");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(";;wxsign=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(";wxAppId=");
      ((StringBuilder)localObject2).append(t5.g);
      APLog.i("领取话费券", ((StringBuilder)localObject2).toString());
      new t5(this, t5.g).a(paramString, (String)localObject1);
      return;
    }
    z1.d().g(new c());
    APUICommonMethod.a(this, "当前微信版本过低，请升级到最新版本！");
    return;
    APLog.i("APWebBuyActivity", "微信版本号判断异常!");
  }
  
  public final void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      p4.p().e().f.f = paramString;
      paramString = new Intent(this, APRecoChannelActivity.class);
      paramString.putExtra("to", 3);
      startActivity(paramString);
      return;
    }
    APUICommonMethod.a(this, "充值数量不能为空");
  }
  
  public void f()
  {
    Object localObject;
    if (p4.p().e().b.saveType == 4)
    {
      localObject = (APMonthRequest)p4.p().e().b;
      this.f.n.put("service_code", ((APMonthRequest)localObject).serviceCode);
      this.f.n.put("service_name", ((APMonthRequest)localObject).serviceName);
      localObject = (z4)p4.p().e().c;
      this.f.n.put("uin", ((z4)localObject).m);
    }
    if (p4.p().e().b.saveType == 5)
    {
      localObject = (APMonthRequest)p4.p().e().b;
      this.f.n.put("service_code", ((APMonthRequest)localObject).serviceCode);
      this.f.n.put("service_name", ((APMonthRequest)localObject).serviceName);
      localObject = (z4)p4.p().e().c;
      this.f.n.put("productid", ((z4)localObject).k);
      this.f.n.put("uin", ((z4)localObject).m);
    }
    this.f.n.put("aid", p4.p().e().b.remark);
  }
  
  public String h()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(y7.a);
    ((StringBuilder)localObject1).append(this.f.b);
    ((StringBuilder)localObject1).append(this.f.a);
    ((StringBuilder)localObject1).append(o());
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
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&random=");
      ((StringBuilder)localObject2).append(String.valueOf(Math.random() * 100.0D));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    catch (Exception localException)
    {
      label172:
      StringBuilder localStringBuilder;
      break label172;
    }
    localObject2 = "";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(APTools.a(this.f.n));
    localStringBuilder.append((String)localObject2);
    return localStringBuilder.toString();
  }
  
  public void i()
  {
    String str = APAppDataInterface.singleton().h();
    if (str.equals("release"))
    {
      this.f.b = y7.d;
      return;
    }
    if ((!str.equals("test")) && (!str.equals("dev")))
    {
      if ((str.equals("custom")) && ("dev".equals(APAppDataInterface.singleton().f())))
      {
        this.f.b = y7.c;
        return;
      }
      this.f.b = y7.d;
      return;
    }
    this.f.b = y7.c;
  }
  
  public void j()
  {
    x7 localx7 = new x7();
    localx7.l = this.m;
    localx7.m = this.p;
    if (q.equals(y7.q))
    {
      localx7.a = c6.s0().B();
      localx7.n.put("page", y7.q);
      localx7.c = "sdk.gamelist.h5.show";
      localx7.d = "sdk.gamelist.h5.back";
      localx7.e = "sdk.gamelist.h5.click";
      localx7.f = "sdk.gameinput.h5.pay";
      localx7.i = "sdk.gamelist.h5.keyback";
      localx7.j = "sdk.gamelist.h5.error";
      localx7.k = "sdk.gamelist.h5.refresh";
    }
    else if (q.equals(y7.r))
    {
      String str = x.f().b();
      if (TextUtils.isEmpty(str))
      {
        APUICommonMethod.f();
        z5.a(-1, 1004, "没有配置团购mallUrl");
      }
      localx7.a = str;
      localx7.n.put("page", y7.r);
      localx7.c = "sdk.tuan.h5.show";
      localx7.d = "sdk.tuan.h5.close";
      localx7.f = "sdk.tuan.h5.pay";
      localx7.i = "sdk.tuan.h5.keyback";
      localx7.j = "sdk.tuan.h5.error";
      localx7.k = "sdk.tuan.h5.refresh";
    }
    else if ((!q.equals(y7.s)) && (q.equals(y7.t)))
    {
      if (p4.p().e().c.g == "buytuan") {
        localx7.a = x.f().d();
      } else {
        localx7.a = c6.s0().N();
      }
      localx7.n.put("page", y7.t);
      localx7.n.put("saveNumber", p4.p().e().f.f);
      localx7.n.put("PortalExtendField", c6.s0().D());
      localx7.n.put("appId", this.n);
      localx7.n.put("wxSignUrl", this.o);
      if ((c6.s0().U()) && (this.l == 5))
      {
        int i = getIntent().getIntExtra("mcardDepositBalance", 0);
        if (i > 0) {
          localx7.n.put("mcardDepositBalance", APTools.b(i));
        }
      }
      if (!c6.s0().z()) {
        localx7.n.put("notShowContinueBuy", "1");
      }
      localx7.g = "sdk.result.h5.pay";
      localx7.d = "sdk.result.h5.back";
      localx7.h = "sdk.result.h5.repay";
      localx7.i = "sdk.result.h5.keyback";
      localx7.c = "sdk.result.h5.show";
      localx7.j = "sdk.result.h5.error";
      localx7.k = "sdk.result.h5.refresh";
    }
    this.f = localx7;
  }
  
  public void k()
  {
    setContentView(2131165265);
    this.d = ((WebView)findViewById(2131099770));
    this.e = ((AP3PointsLoading)findViewById(2131099699));
    this.d.setVisibility(8);
    this.e.c();
  }
  
  public final String o()
  {
    return y7.o;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("appid"))
      {
        this.n = paramBundle.getString("appid");
        if (paramBundle.containsKey("wxSignUrl")) {
          this.o = APTools.b(paramBundle.getString("wxSignUrl"), 1);
        }
      }
      this.l = paramBundle.getInt("channel");
    }
    a.r().f = true;
    n();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.k) {
      APLog.i("APWebBuyAct", "destroy");
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      APDataReportManager.getInstance().insertData(this.f.i, this.a);
      if (q.equals(y7.q))
      {
        if (this.d.canGoBack())
        {
          this.d.goBack();
          return true;
        }
        APUICommonMethod.f();
        z5.a(2, "支付取消");
      }
      else if (q.equals(y7.r))
      {
        if (this.d.canGoBack())
        {
          this.d.goBack();
          return true;
        }
        if (c6.s0().Q().equals("APPayGameListNumActivity"))
        {
          finish();
          APUICommonMethod.a(this);
        }
        else
        {
          APUICommonMethod.f();
          z5.a(2, "支付取消");
        }
      }
      else if ((!q.equals(y7.s)) && (q.equals(y7.t)))
      {
        Intent localIntent;
        Bundle localBundle;
        if ((a.r().e(p4.p().e().b)) && ("bank".equals(p4.p().e().b.mpInfo.payChannel)))
        {
          APUICommonMethod.f();
          localIntent = new Intent();
          localBundle = new Bundle();
          localBundle.putString("loadUI", "showBankResultActivity");
          localIntent.putExtras(localBundle);
          localIntent.setClass(this, APWebMarketActivity.class);
          startActivity(localIntent);
        }
        else if ((a.r().e(p4.p().e().b)) && ("wechat".equals(p4.p().e().b.mpInfo.payChannel)))
        {
          APUICommonMethod.f();
          localIntent = new Intent();
          localBundle = new Bundle();
          localBundle.putString("loadUI", "showWechatResultActivity");
          localIntent.putExtras(localBundle);
          localIntent.setClass(this, APWebMarketActivity.class);
          startActivity(localIntent);
        }
        else
        {
          int i = this.l;
          if ((i != 0) && (i != 11) && (i != 4))
          {
            APUICommonMethod.f();
            z5.a(this.l, 0, -1);
          }
          else
          {
            APUICommonMethod.f();
            z5.a(this.l, 0, 0);
          }
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager.getInstance().insertData(this.f.c, this.a);
  }
  
  public final void p()
  {
    int i = this.l;
    if ((i != 0) && (i != 11) && (i != 4)) {
      z5.a(0, 0, i, 0, -1, "", "");
    } else {
      z5.a(0, 0, this.l, 0, 0, "", "");
    }
    i = this.l;
    if ((i == 0) || (i == 11))
    {
      Bundle localBundle = getIntent().getExtras();
      if ((localBundle != null) && (!TextUtils.isEmpty(localBundle.getString("changeQQ"))))
      {
        g6.k().a(true);
        APLog.i("APTag", "resultData=更换QQ号码继续充值按钮点击");
      }
    }
    APUICommonMethod.g();
    this.k = true;
  }
  
  public class a
    implements b8
  {
    public a() {}
    
    public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      APLog.i("APWebBuyActivity", "WebReceivedError");
    }
    
    public void a(WebView paramWebView, String paramString)
    {
      APLog.i("APWebBuyActivity", "WebPageFinished");
      paramWebView = x.f().c();
      if ((paramWebView != null) && (("1".equals(paramWebView.a())) || ("-1".equals(paramWebView.a()))))
      {
        paramWebView = a6.b().a();
        paramString = new StringBuilder();
        paramString.append("javascript:setTime");
        paramString.append(paramWebView);
        APLog.i("APWebBuyActivity", paramString.toString());
        paramString = APWebBuyActivity.this.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:setTime(");
        localStringBuilder.append(paramWebView);
        localStringBuilder.append(")");
        paramString.loadUrl(localStringBuilder.toString());
      }
    }
    
    public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      APLog.i("APWebBuyActivity", "WebPageStarted");
      if (paramString.startsWith("http://unipay.sdk.android/?"))
      {
        APWebBuyActivity.this.d.stopLoading();
        APWebBuyActivity.a(APWebBuyActivity.this, paramString);
      }
    }
    
    public void b(WebView paramWebView, String paramString)
    {
      APLog.i("APWebBuyActivity", "WebShouldUrlLoading");
      if (paramString.startsWith("http://unipay.sdk.android/?")) {
        APWebBuyActivity.a(APWebBuyActivity.this, paramString);
      }
    }
  }
  
  public class b
    implements a8
  {
    public b() {}
    
    public void a(WebView paramWebView) {}
    
    public void a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      APLog.i("APWebBuyActivity webJsAlert url=", paramString1);
      APLog.i("APWebBuyActivity webJsAlert message=", paramString2);
      paramWebView = paramString2.toString();
      if (paramWebView.startsWith("http://unipay.sdk.android/?"))
      {
        APWebBuyActivity.a(APWebBuyActivity.this, paramWebView);
      }
      else if (j.a(APWebBuyActivity.this, paramString1, paramString2) == 0)
      {
        paramWebView = new StringBuilder();
        paramWebView.append("url=");
        paramWebView.append(paramString1);
        paramWebView.append("  hook=true");
        APLog.d("h5PayHook", paramWebView.toString());
        paramJsResult.cancel();
        return;
      }
      paramJsResult.cancel();
    }
    
    public void a(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage) {}
  }
  
  public class c
    implements fc
  {
    public c() {}
    
    public void a(ob paramob)
    {
      APLog.i("APAndroidPay", "插话费卡券onFinish");
    }
    
    public void b(ob paramob)
    {
      APLog.i("APAndroidPay", "插话费卡券onError");
    }
    
    public void c(ob paramob)
    {
      APLog.i("APAndroidPay", "插话费卡券onStop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.APWebBuyActivity
 * JD-Core Version:    0.7.0.1
 */