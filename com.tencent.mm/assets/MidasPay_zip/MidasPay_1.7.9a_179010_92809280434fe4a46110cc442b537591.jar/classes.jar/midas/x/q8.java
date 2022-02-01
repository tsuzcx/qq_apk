package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.api.request.APGameRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.marketing.APWebMarketActivity;
import com.tencent.midas.comm.APLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class q8
  extends k8
{
  public static final long serialVersionUID = 1L;
  public Activity e = null;
  public e8 f = null;
  public ProgressDialog g = null;
  public Handler h = new Handler();
  public Runnable i = new a();
  
  public q8()
  {
    c();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!this.d)
    {
      m();
      d();
    }
  }
  
  public void a(Activity paramActivity, e8 parame8, Bundle paramBundle)
  {
    super.a(paramActivity, parame8, paramBundle);
    this.e = paramActivity;
    this.f = parame8;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    try
    {
      if (this.g != null) {
        this.g.show();
      }
      if (this.f != null)
      {
        this.f.b(g());
        f();
        return;
      }
    }
    finally
    {
      paramProgressDialog.printStackTrace();
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("APWebResultPage_webOnCreate_");
      localStringBuilder.append(APTools.d(paramProgressDialog));
      localAPDataReportManager.a("sdk.err.view", localStringBuilder.toString());
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    new HashMap();
    Object localObject2 = APTools.n(paramString);
    paramString = (String)((HashMap)localObject2).get("page");
    paramString = (String)((HashMap)localObject2).get("action");
    Object localObject3 = (String)((HashMap)localObject2).get("saveNumber");
    Object localObject1 = (String)((HashMap)localObject2).get("saveType");
    Object localObject4 = (String)((HashMap)localObject2).get("callback");
    if (y7.D.equals(paramString)) {}
    try
    {
      localObject1 = (String)((HashMap)localObject2).get("pre_uuid");
    }
    catch (Exception paramString)
    {
      label136:
      label142:
      Object localObject5;
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      String str7;
      String str9;
      String str8;
      break label142;
    }
    try
    {
      paramString = (String)((HashMap)localObject2).get("canChange");
      paramString = (String)((HashMap)localObject2).get("drm_act_type");
    }
    catch (Exception paramString)
    {
      break label136;
    }
    try
    {
      localObject2 = (String)((HashMap)localObject2).get("drm_resource");
    }
    catch (Exception localException1)
    {
      break label149;
    }
    paramString = "";
    break label149;
    localObject1 = "";
    paramString = (String)localObject1;
    label149:
    localObject2 = "";
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (paramString.equals("rtg_type")))
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
      j6.e().c((String)localObject1);
      j6.e().a(paramString);
      j6.e().b((String)localObject2);
      APUICommonMethod.g();
      a.r().a(this.e, (APBaseRequest)localObject5, a.r().a);
      return;
      if (y7.H.equals(paramString))
      {
        e((String)localObject4);
        return;
      }
      if (y7.I.equals(paramString))
      {
        g((String)localObject4);
        return;
      }
      if (y7.J.equals(paramString))
      {
        f((String)localObject4);
        return;
      }
      if (y7.K.equals(paramString))
      {
        a((String)((HashMap)localObject2).get("h5_width"), (String)((HashMap)localObject2).get("h5_height"));
        return;
      }
      if (y7.C.equals(paramString))
      {
        if (((String)localObject1).equals(String.valueOf(0)))
        {
          APUICommonMethod.a(this.e, "暂不支持充值游戏币");
          return;
        }
        if (((String)localObject1).equals(String.valueOf(1)))
        {
          localObject1 = (String)((HashMap)localObject2).get("offerId");
          localObject4 = (String)((HashMap)localObject2).get("openId");
          localObject5 = (String)((HashMap)localObject2).get("openKey");
          str1 = (String)((HashMap)localObject2).get("pf");
          str2 = (String)((HashMap)localObject2).get("pfKey");
          str3 = (String)((HashMap)localObject2).get("sessionId");
          str4 = (String)((HashMap)localObject2).get("sessionType");
          str5 = (String)((HashMap)localObject2).get("zoneId");
          str6 = (String)((HashMap)localObject2).get("canChange");
          str7 = (String)((HashMap)localObject2).get("productId");
          str9 = (String)((HashMap)localObject2).get("goodsExtras");
          str8 = (String)((HashMap)localObject2).get("isToken");
          try
          {
            paramString = URLDecoder.decode((String)((HashMap)localObject2).get("tokenUrl"), "utf-8");
          }
          catch (UnsupportedEncodingException paramString)
          {
            paramString.printStackTrace();
            paramString = "";
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append((String)localObject4);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append((String)localObject5);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(str3);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(str4);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(str5);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(str1);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(str2);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(str7);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append((String)localObject3);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(str8);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(str9);
          APLog.i("params: offerId , openId , openKey, sessionId, sessionType, zoneId, pf, pfKey, productId, saveNumber, isToken, goodsExtras", ((StringBuilder)localObject2).toString());
          localObject2 = new APGoodsRequest();
          ((APBaseRequest)localObject2).offerId = ((String)localObject1);
          ((APBaseRequest)localObject2).openId = ((String)localObject4);
          ((APBaseRequest)localObject2).openKey = ((String)localObject5);
          ((APBaseRequest)localObject2).sessionId = str3;
          ((APBaseRequest)localObject2).sessionType = str4;
          ((APBaseRequest)localObject2).zoneId = str5;
          ((APBaseRequest)localObject2).pf = str1;
          ((APBaseRequest)localObject2).pfKey = str2;
          if (str8.equals("0"))
          {
            ((APGoodsRequest)localObject2).tokenType = 2;
            ((APGoodsRequest)localObject2).prodcutId = str7;
            ((APBaseRequest)localObject2).saveValue = ((String)localObject3);
            if (str6.equals("0"))
            {
              ((APBaseRequest)localObject2).isCanChange = false;
              a.r().a(this.e, (APBaseRequest)localObject2, null);
              return;
            }
            ((APBaseRequest)localObject2).isCanChange = true;
            a.r().a(this.e, (APBaseRequest)localObject2, null);
            return;
          }
          if (str8.equals("1"))
          {
            ((APGoodsRequest)localObject2).tokenType = 1;
            ((APGoodsRequest)localObject2).goodsTokenUrl = paramString;
            a.r().a(this.e, (APBaseRequest)localObject2, null);
            return;
          }
          APUICommonMethod.a(this.e, "参数错误");
        }
      }
      else
      {
        if (y7.E.equals(paramString))
        {
          APDataReportManager.getInstance().insertData(y7.U, p4.p().e().b.saveType, null, null, (String)localObject3);
          if ((a.r().e(p4.p().e().b)) && ("bank".equals(p4.p().e().b.mpInfo.payChannel)))
          {
            APUICommonMethod.f();
            paramString = new Intent();
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("loadUI", "showBankResultActivity");
            paramString.putExtras((Bundle)localObject1);
            paramString.setClass(this.e, APWebMarketActivity.class);
            this.e.startActivity(paramString);
            return;
          }
          if ((a.r().e(p4.p().e().b)) && ("wechat".equals(p4.p().e().b.mpInfo.payChannel)))
          {
            APUICommonMethod.f();
            paramString = new Intent();
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("loadUI", "showWechatResultActivity");
            paramString.putExtras((Bundle)localObject1);
            paramString.setClass(this.e, APWebMarketActivity.class);
            this.e.startActivity(paramString);
            return;
          }
          j = r6.e(p4.p().e().f.e);
          if ((j != 0) && (j != 11) && (j != 4))
          {
            APUICommonMethod.f();
            z5.a(j, 0, -1);
            return;
          }
          APUICommonMethod.f();
          z5.a(j, 0, 0);
          return;
        }
        if (!y7.O.equals(paramString)) {}
      }
    }
    try
    {
      localObject1 = APTools.a((String)((HashMap)localObject2).get("wx_link_title"), 1);
    }
    catch (Exception paramString)
    {
      label1476:
      label1482:
      break label1482;
    }
    try
    {
      paramString = APTools.a((String)((HashMap)localObject2).get("wx_link"), 1);
    }
    catch (Exception paramString)
    {
      break label1476;
    }
    try
    {
      localObject2 = APTools.a((String)((HashMap)localObject2).get("wx_description"), 1);
    }
    catch (Exception localException2)
    {
      break label1489;
    }
    paramString = "";
    break label1489;
    localObject1 = "";
    paramString = (String)localObject1;
    label1489:
    localObject2 = "";
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("shareTitle, shareLink, shareDescription");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(",");
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append(",");
    ((StringBuilder)localObject3).append((String)localObject2);
    APLog.i("分享好友", ((StringBuilder)localObject3).toString());
    new t5(this.e).a(0, (String)localObject1, paramString, (String)localObject2);
    return;
    if (y7.P.equals(paramString)) {}
    try
    {
      localObject1 = APTools.a((String)((HashMap)localObject2).get("wx_link_title"), 1);
    }
    catch (Exception paramString)
    {
      label1647:
      break label1653;
    }
    try
    {
      paramString = APTools.a((String)((HashMap)localObject2).get("wx_link"), 1);
    }
    catch (Exception paramString)
    {
      break label1647;
    }
    try
    {
      localObject2 = APTools.a((String)((HashMap)localObject2).get("wx_description"), 1);
    }
    catch (Exception localException3)
    {
      break label1660;
    }
    paramString = "";
    break label1660;
    label1653:
    localObject1 = "";
    paramString = (String)localObject1;
    label1660:
    localObject2 = "";
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("shareTitle, shareLink, shareDescription");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(",");
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append(",");
    ((StringBuilder)localObject3).append((String)localObject2);
    APLog.i("恩赐朋友圈", ((StringBuilder)localObject3).toString());
    new t5(this.e).a(1, (String)localObject1, paramString, (String)localObject2);
    return;
    if (y7.Q.equals(paramString)) {}
    try
    {
      paramString = APTools.a(this.e, "com.tencent.mm");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("微信版本号：");
      ((StringBuilder)localObject1).append(paramString);
      APLog.i("APWebBuyActivity微信版本号", ((StringBuilder)localObject1).toString());
      if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
        break label2149;
      }
      localObject1 = paramString.split("\\.");
      int k = 0;
      j = k;
      if (!TextUtils.isEmpty(localObject1[0]))
      {
        j = k;
        if (!TextUtils.isEmpty(localObject1[1])) {
          if (localObject1[0].compareTo("6") == 0)
          {
            if (localObject1[1].compareTo("2") < 0) {
              break label2149;
            }
          }
          else
          {
            j = 0;
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
        j = 1;
        continue;
        j = 0;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("微信版本号：");
    ((StringBuilder)localObject1).append(paramString);
    APLog.i("APWebBuyActivity微信版本号", ((StringBuilder)localObject1).toString());
    if (j != 0)
    {
      paramString = (String)((HashMap)localObject2).get("cardId");
      localObject1 = APTools.a((String)((HashMap)localObject2).get("wxsign"), 1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("h5回调SDK,cardId=");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(";;wxsign=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(";wxAppId=");
      ((StringBuilder)localObject2).append(t5.g);
      APLog.i("领取话费券", ((StringBuilder)localObject2).toString());
      new t5(this.e, t5.g).a(paramString, (String)localObject1);
      return;
    }
    z1.d().g(new b());
    APUICommonMethod.a(this.e, "当前微信版本过低，请升级到最新版本！");
    return;
    APLog.i("APWebBuyActivity", "微信版本号判断异常!");
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.f.b(paramString1, paramString2);
  }
  
  public void a(Throwable paramThrowable)
  {
    super.a(paramThrowable);
    j();
  }
  
  public boolean a()
  {
    return this.d ^ true;
  }
  
  public void d()
  {
    if (!this.d) {
      k();
    }
    super.d();
  }
  
  public final void e(String paramString)
  {
    String str = c6.s0().e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendCgiExtends() callback=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", extendStr=");
    localStringBuilder.append(str);
    APLog.d("APWebResultPage", localStringBuilder.toString());
    this.f.a(paramString, str);
  }
  
  public boolean e()
  {
    k();
    Intent localIntent;
    Bundle localBundle;
    if ((a.r().e(p4.p().e().b)) && ("bank".equals(p4.p().e().b.mpInfo.payChannel)))
    {
      APUICommonMethod.f();
      localIntent = new Intent();
      localBundle = new Bundle();
      localBundle.putString("loadUI", "showBankResultActivity");
      localIntent.putExtras(localBundle);
      localIntent.setClass(this.e, APWebMarketActivity.class);
      this.e.startActivity(localIntent);
    }
    else if ((a.r().e(p4.p().e().b)) && ("wechat".equals(p4.p().e().b.mpInfo.payChannel)))
    {
      APUICommonMethod.f();
      localIntent = new Intent();
      localBundle = new Bundle();
      localBundle.putString("loadUI", "showWechatResultActivity");
      localIntent.putExtras(localBundle);
      localIntent.setClass(this.e, APWebMarketActivity.class);
      this.e.startActivity(localIntent);
    }
    else
    {
      j();
    }
    return true;
  }
  
  public final void f()
  {
    int j = c6.s0().a0();
    this.h.postDelayed(this.i, j);
  }
  
  public final void f(String paramString)
  {
    new ArrayList();
    List localList = o.m().b(p4.p().e().f.e);
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    if (localList != null)
    {
      int j = 0;
      while (j < localList.size())
      {
        try
        {
          localJSONObject.put("card_id", ((n)localList.get(j)).e());
          localJSONObject.put("amt", ((n)localList.get(j)).c());
          localJSONObject.put("least_price", ((n)localList.get(j)).g());
          localJSONObject.put("allow_pay_channel", ((n)localList.get(j)).a());
          localJSONObject.put("rank_type", ((n)localList.get(j)).h());
          localJSONObject.put("batch_id", ((n)localList.get(j)).d());
          localJSONObject.put("code_id", ((n)localList.get(j)).f());
          localJSONObject.put("status", ((n)localList.get(j)).i());
          localJSONObject.put("coupon_display_name", ((n)localList.get(j)).j);
          localJSONArray.put(localJSONObject);
        }
        catch (Exception localException)
        {
          APLog.i("sendCouponInfo", localException.toString());
        }
        j += 1;
      }
    }
    this.f.a(paramString, localJSONArray.toString());
  }
  
  public String g()
  {
    Object localObject3 = c6.s0().N();
    Object localObject2 = y7.a;
    Object localObject1 = localObject2;
    if (!APAppDataInterface.singleton().h().equals("release"))
    {
      localObject1 = localObject2;
      if (APAppDataInterface.singleton().E()) {
        localObject1 = y7.b;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append((String)localObject3);
    ((StringBuilder)localObject2).append(l());
    localObject2 = new StringBuffer(((StringBuilder)localObject2).toString());
    if (!((StringBuffer)localObject2).toString().contains("?")) {
      ((StringBuffer)localObject2).append("?");
    } else if (!((StringBuffer)localObject2).toString().endsWith("?")) {
      ((StringBuffer)localObject2).append("&");
    }
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("&random=");
      ((StringBuilder)localObject1).append(String.valueOf(Math.random() * 100.0D));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    catch (Exception localException)
    {
      label177:
      break label177;
    }
    localObject1 = "";
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((StringBuffer)localObject2).toString());
    ((StringBuilder)localObject3).append(APTools.a(h()));
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject3).toString();
    APLog.i("constructUrl", (String)localObject1);
    return localObject1;
  }
  
  public final void g(String paramString)
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
    localObject = this.f.e();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:");
    localStringBuilder.append(paramString);
    ((WebView)localObject).loadUrl(localStringBuilder.toString());
  }
  
  public final HashMap<String, String> h()
  {
    b();
    this.c.put("page", y7.t);
    int j = r6.e(p4.p().e().f.e);
    if ((c6.s0().U()) && (j == 5))
    {
      j = this.e.getIntent().getIntExtra("mcardDepositBalance", 0);
      if (j > 0) {
        this.c.put("mcardDepositBalance", APTools.b(j));
      }
      if (p4.p().e().e.h >= 0) {
        this.c.put("mcardAccountBalance", APTools.b(p4.p().e().e.h));
      }
    }
    this.c.put("saveType", String.valueOf(p4.p().e().b.saveType));
    this.c.put("gameCoinUnit", APTools.b(p4.p().e().b.extendInfo.unit, 1));
    Object localObject;
    if (APUICommonMethod.e())
    {
      localObject = (x4)p4.p().e().c;
      this.c.put("specialUnit", APTools.b(((x4)localObject).h(), 1));
    }
    HashMap localHashMap = this.c;
    if (p4.p().e().b.extendInfo.isShowNum) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("showNum", localObject);
    this.c.put("portal_serial_no", c6.s0().E());
    if ((this.e.getResources().getConfiguration().orientation != 1) && (this.e.getResources().getConfiguration().orientation == 2)) {
      this.c.put("orientation", "1");
    }
    return this.c;
  }
  
  public final String i()
  {
    o4 localo4 = p4.p().e();
    int j = localo4.b.saveType;
    Object localObject1;
    if ((j != 0) && (j != 1) && (j != 2) && (j != 3))
    {
      if (j != 4)
      {
        if (j != 5) {
          localObject1 = "";
        } else if (g6.k().e() == g6.a.a) {
          localObject1 = localo4.c.b;
        } else {
          localObject1 = localo4.f.f;
        }
      }
      else if (g6.k().e() == g6.a.a)
      {
        localObject1 = localo4.c.b;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localo4.f.f);
        ((StringBuilder)localObject1).append(((z4)localo4.c).h());
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else {
      localObject1 = localo4.f.f;
    }
    Object localObject2 = localObject1;
    if (j != 3)
    {
      localObject2 = localObject1;
      if (j != 2)
      {
        if (APUICommonMethod.e()) {
          return ((x4)localo4.c).h();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(localo4.b.extendInfo.unit);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    return localObject2;
  }
  
  public final void j()
  {
    int j = r6.e(p4.p().e().f.e);
    if ((j != 0) && (j != 11) && (j != 4))
    {
      APUICommonMethod.f();
      z5.a(j, 0, -1);
      return;
    }
    APUICommonMethod.f();
    z5.a(j, 0, 0);
  }
  
  public final void k()
  {
    Handler localHandler = this.h;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public final String l()
  {
    return y7.o;
  }
  
  public final void m()
  {
    APDataReportManager.getInstance().insertData("sdk.web.pay.result.native.page.show", p4.p().e().b.saveType);
    View localView = LayoutInflater.from(this.e).inflate(2131165212, null);
    TextView localTextView = (TextView)localView.findViewById(2131099683);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("成功购买");
    ((StringBuilder)localObject).append(p4.p().e().c.b);
    ((StringBuilder)localObject).append(" x ");
    ((StringBuilder)localObject).append(i());
    localTextView.setText(((StringBuilder)localObject).toString());
    localTextView = (TextView)localView.findViewById(2131099678);
    localObject = p4.p().e().f.e;
    localTextView.setText(r6.j().c((String)localObject));
    localTextView = (TextView)localView.findViewById(2131099681);
    int j = 1;
    localObject = p4.p().e().c.a();
    int k = 0;
    localTextView.setText(String.format("%s元", new Object[] { localObject }));
    int m = r6.e(p4.p().e().f.e);
    if ((c6.s0().U()) && (m == 5))
    {
      localView.findViewById(2131099680).setVisibility(0);
      ((TextView)localView.findViewById(2131099679)).setText(String.format("%s元", new Object[] { APTools.b(p4.p().e().e.h) }));
    }
    if (p4.p().e().b.saveType != 0) {
      j = 0;
    }
    localTextView = (TextView)localView.findViewById(2131099684);
    if (j != 0) {
      j = k;
    } else {
      j = 8;
    }
    localTextView.setVisibility(j);
    this.e.setContentView(localView);
    localView.findViewById(2131099685).setOnClickListener(new c());
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      APLog.i("APWebResultPage", "web result page timeout runnable");
      if (!q8.this.d)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("web result page load timeout ");
        ((StringBuilder)localObject).append(c6.s0().a0());
        APLog.e("APWebResultPage", ((StringBuilder)localObject).toString());
        localObject = APDataReportManager.getInstance();
        int i = p4.p().e().b.saveType;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(c6.s0().a0());
        ((APDataReportManager)localObject).insertData("sdk.timeout.webpage.result", i, null, null, localStringBuilder.toString());
        q8.a(q8.this);
      }
    }
  }
  
  public class b
    implements fc
  {
    public b() {}
    
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
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      q8.a(q8.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.q8
 * JD-Core Version:    0.7.0.1
 */