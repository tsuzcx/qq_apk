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
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ix
  extends ir
{
  private static final long serialVersionUID = 1L;
  private Activity f = null;
  private ib g = null;
  private ProgressDialog h = null;
  private Handler i = new Handler();
  private Runnable j = new Runnable()
  {
    public void run()
    {
      APLog.i("APX5WebResultPage", "web result page timeout runnable");
      if (!ix.this.e)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("web result page load timeout ");
        ((StringBuilder)localObject).append(fy.a().af());
        APLog.e("APX5WebResultPage", ((StringBuilder)localObject).toString());
        localObject = APDataReportManager.getInstance();
        int i = em.b().n().a.saveType;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(fy.a().af());
        ((APDataReportManager)localObject).insertData("sdk.timeout.webpage.result", i, null, null, localStringBuilder.toString());
        ix.a(ix.this);
      }
    }
  };
  
  public ix()
  {
    c();
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.g.b(paramString1, paramString2);
  }
  
  private void e(String paramString)
  {
    String str = fy.a().y();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendCgiExtends() callback=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", extendStr=");
    localStringBuilder.append(str);
    APLog.d("APX5WebResultPage", localStringBuilder.toString());
    this.g.a(paramString, str);
  }
  
  private void f(String paramString)
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
    localObject = this.g.c();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:");
    localStringBuilder.append(paramString);
    ((WebView)localObject).loadUrl(localStringBuilder.toString());
  }
  
  private HashMap<String, String> g()
  {
    d();
    this.d.put("page", hu.v);
    int k = gn.a(em.b().n().e.f);
    if ((fy.a().A()) && (k == 5))
    {
      k = this.f.getIntent().getIntExtra("mcardDepositBalance", 0);
      if (k > 0) {
        this.d.put("mcardDepositBalance", APTools.a(k));
      }
      if (em.b().n().d.h >= 0) {
        this.d.put("mcardAccountBalance", APTools.a(em.b().n().d.h));
      }
    }
    this.d.put("saveType", String.valueOf(em.b().n().a.saveType));
    this.d.put("gameCoinUnit", APTools.a(em.b().n().a.extendInfo.unit, 1));
    Object localObject;
    if (APUICommonMethod.h())
    {
      localObject = (eu)em.b().n().b;
      this.d.put("specialUnit", APTools.a(((eu)localObject).h(), 1));
    }
    HashMap localHashMap = this.d;
    if (em.b().n().a.extendInfo.isShowNum) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("showNum", localObject);
    this.d.put("portal_serial_no", fy.a().I());
    if ((this.f.getResources().getConfiguration().orientation != 1) && (this.f.getResources().getConfiguration().orientation == 2)) {
      this.d.put("orientation", "1");
    }
    return this.d;
  }
  
  private void g(String paramString)
  {
    new ArrayList();
    List localList = n.a().h(em.b().n().e.f);
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    if (localList != null)
    {
      int k = 0;
      while (k < localList.size())
      {
        try
        {
          localJSONObject.put("card_id", ((m)localList.get(k)).a());
          localJSONObject.put("amt", ((m)localList.get(k)).b());
          localJSONObject.put("least_price", ((m)localList.get(k)).c());
          localJSONObject.put("allow_pay_channel", ((m)localList.get(k)).d());
          localJSONObject.put("rank_type", ((m)localList.get(k)).e());
          localJSONObject.put("batch_id", ((m)localList.get(k)).g());
          localJSONObject.put("code_id", ((m)localList.get(k)).h());
          localJSONObject.put("status", ((m)localList.get(k)).i());
          localJSONArray.put(localJSONObject);
        }
        catch (Exception localException)
        {
          APLog.i("sendCouponInfo", localException.toString());
        }
        k += 1;
      }
    }
    this.g.a(paramString, localJSONArray.toString());
  }
  
  private String h()
  {
    return hu.p;
  }
  
  private void i()
  {
    int k = gn.a(em.b().n().e.f);
    if ((k != 0) && (k != 11) && (k != 4))
    {
      APUICommonMethod.b();
      fv.a(k, 0, -1);
      return;
    }
    APUICommonMethod.b();
    fv.a(k, 0, 0);
  }
  
  private void j()
  {
    int k = fy.a().af();
    this.i.postDelayed(this.j, k);
  }
  
  private void k()
  {
    if (this.i != null) {
      this.i.removeCallbacksAndMessages(null);
    }
  }
  
  private void l()
  {
    APDataReportManager.getInstance().insertData("sdk.web.pay.result.native.page.show", em.b().n().a.saveType);
    View localView = LayoutInflater.from(this.f).inflate(2131165212, null);
    TextView localTextView = (TextView)localView.findViewById(2131099683);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("成功购买");
    ((StringBuilder)localObject).append(em.b().n().b.b);
    ((StringBuilder)localObject).append(" x ");
    ((StringBuilder)localObject).append(m());
    localTextView.setText(((StringBuilder)localObject).toString());
    localTextView = (TextView)localView.findViewById(2131099678);
    localObject = em.b().n().e.f;
    localTextView.setText(gn.a().e((String)localObject));
    localTextView = (TextView)localView.findViewById(2131099681);
    int k = 1;
    localObject = em.b().n().b.a();
    int m = 0;
    localTextView.setText(String.format("%s元", new Object[] { localObject }));
    int n = gn.a(em.b().n().e.f);
    if ((fy.a().A()) && (n == 5))
    {
      localView.findViewById(2131099680).setVisibility(0);
      ((TextView)localView.findViewById(2131099679)).setText(String.format("%s元", new Object[] { APTools.a(em.b().n().d.h) }));
    }
    if (em.b().n().a.saveType != 0) {
      k = 0;
    }
    localTextView = (TextView)localView.findViewById(2131099684);
    if (k != 0) {
      k = m;
    } else {
      k = 8;
    }
    localTextView.setVisibility(k);
    this.f.setContentView(localView);
    localView.findViewById(2131099685).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ix.a(ix.this);
      }
    });
  }
  
  private String m()
  {
    el localel = em.b().n();
    int k = localel.a.saveType;
    Object localObject1 = "";
    switch (k)
    {
    default: 
      break;
    case 5: 
      if (gc.a().f() == gc.a.a) {
        localObject1 = localel.b.b;
      } else {
        localObject1 = localel.e.g;
      }
      break;
    case 4: 
      if (gc.a().f() == gc.a.a)
      {
        localObject1 = localel.b.b;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localel.e.g);
        ((StringBuilder)localObject1).append(((ew)localel.b).h());
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      break;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      localObject1 = localel.e.g;
    }
    Object localObject2 = localObject1;
    if (k != 3)
    {
      localObject2 = localObject1;
      if (k != 2)
      {
        if (APUICommonMethod.h()) {
          return ((eu)localel.b).h();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(localel.a.extendInfo.unit);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    return localObject2;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!this.e)
    {
      l();
      e();
    }
  }
  
  public void a(Activity paramActivity, ib paramib, Bundle paramBundle)
  {
    super.a(paramActivity, paramib, paramBundle);
    this.f = paramActivity;
    this.g = paramib;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    try
    {
      if (this.h != null) {
        this.h.show();
      }
      if (this.g != null)
      {
        this.g.b(b());
        j();
        return;
      }
    }
    catch (Throwable paramProgressDialog)
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
    Object localObject4 = APTools.b(paramString);
    paramString = (String)((HashMap)localObject4).get("page");
    paramString = (String)((HashMap)localObject4).get("action");
    String str1 = (String)((HashMap)localObject4).get("saveNumber");
    Object localObject1 = (String)((HashMap)localObject4).get("saveType");
    localObject3 = (String)((HashMap)localObject4).get("callback");
    if (hu.H.equals(paramString)) {}
    try
    {
      paramString = (String)((HashMap)localObject4).get("pre_uuid");
    }
    catch (Exception paramString)
    {
      label144:
      Object localObject5;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      String str7;
      String str8;
      String str10;
      String str9;
      break label144;
    }
    try
    {
      localObject1 = (String)((HashMap)localObject4).get("canChange");
      localObject3 = (String)((HashMap)localObject4).get("drm_act_type");
    }
    catch (Exception localException1)
    {
      break label148;
    }
    try
    {
      localObject1 = (String)((HashMap)localObject4).get("drm_resource");
    }
    catch (Exception localException2)
    {
      localObject2 = localObject3;
      break label153;
    }
    paramString = "";
    label148:
    localObject1 = "";
    label153:
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
      a.a().a(this.f, (APBaseRequest)localObject5, a.a().a);
      break label428;
      if (!hu.M.equals(paramString)) {
        break label429;
      }
      e((String)localObject3);
    }
    label428:
    label429:
    do
    {
      for (;;)
      {
        return;
        if (hu.N.equals(paramString))
        {
          f((String)localObject3);
        }
        else if (hu.O.equals(paramString))
        {
          g((String)localObject3);
        }
        else if (hu.Q.equals(paramString))
        {
          a((String)((HashMap)localObject4).get("h5_width"), (String)((HashMap)localObject4).get("h5_height"));
        }
        else
        {
          if (!hu.G.equals(paramString)) {
            break label1146;
          }
          if (!((String)localObject1).equals(String.valueOf(0))) {
            break;
          }
          APUICommonMethod.a(this.f, "暂不支持充值游戏币");
        }
      }
    } while (!((String)localObject1).equals(String.valueOf(1)));
    localObject1 = (String)((HashMap)localObject4).get("offerId");
    localObject3 = (String)((HashMap)localObject4).get("openId");
    localObject5 = (String)((HashMap)localObject4).get("openKey");
    str2 = (String)((HashMap)localObject4).get("pf");
    str3 = (String)((HashMap)localObject4).get("pfKey");
    str4 = (String)((HashMap)localObject4).get("sessionId");
    str5 = (String)((HashMap)localObject4).get("sessionType");
    str6 = (String)((HashMap)localObject4).get("zoneId");
    str7 = (String)((HashMap)localObject4).get("canChange");
    str8 = (String)((HashMap)localObject4).get("productId");
    str10 = (String)((HashMap)localObject4).get("goodsExtras");
    str9 = (String)((HashMap)localObject4).get("isToken");
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
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append((String)localObject3);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append((String)localObject5);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append(str4);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append(str5);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append(str6);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append(str2);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append(str3);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append(str8);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append(str1);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append(str9);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append(str10);
    APLog.i("params: offerId , openId , openKey, sessionId, sessionType, zoneId, pf, pfKey, productId, saveNumber, isToken, goodsExtras", ((StringBuilder)localObject4).toString());
    localObject4 = new APGoodsRequest();
    ((APGoodsRequest)localObject4).offerId = ((String)localObject1);
    ((APGoodsRequest)localObject4).openId = ((String)localObject3);
    ((APGoodsRequest)localObject4).openKey = ((String)localObject5);
    ((APGoodsRequest)localObject4).sessionId = str4;
    ((APGoodsRequest)localObject4).sessionType = str5;
    ((APGoodsRequest)localObject4).zoneId = str6;
    ((APGoodsRequest)localObject4).pf = str2;
    ((APGoodsRequest)localObject4).pfKey = str3;
    if (str9.equals("0"))
    {
      ((APGoodsRequest)localObject4).tokenType = 2;
      ((APGoodsRequest)localObject4).prodcutId = str8;
      ((APGoodsRequest)localObject4).saveValue = str1;
      if (str7.equals("0"))
      {
        ((APGoodsRequest)localObject4).isCanChange = false;
        a.a().a(this.f, (APBaseRequest)localObject4, null);
        return;
      }
      ((APGoodsRequest)localObject4).isCanChange = true;
      a.a().a(this.f, (APBaseRequest)localObject4, null);
      return;
    }
    if (str9.equals("1"))
    {
      ((APGoodsRequest)localObject4).tokenType = 1;
      ((APGoodsRequest)localObject4).goodsTokenUrl = paramString;
      a.a().a(this.f, (APBaseRequest)localObject4, null);
      return;
    }
    APUICommonMethod.a(this.f, "参数错误");
    return;
    label1146:
    if (hu.I.equals(paramString))
    {
      APDataReportManager.getInstance().insertData(hu.ad, em.b().n().a.saveType, null, null, str1);
      if ((a.a().a(em.b().n().a)) && ("bank".equals(em.b().n().a.mpInfo.payChannel)))
      {
        APUICommonMethod.b();
        paramString = new Intent();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("loadUI", "showBankResultActivity");
        paramString.putExtras((Bundle)localObject1);
        paramString.setClass(this.f, APWebMarketActivity.class);
        this.f.startActivity(paramString);
        return;
      }
      if ((a.a().a(em.b().n().a)) && ("wechat".equals(em.b().n().a.mpInfo.payChannel)))
      {
        APUICommonMethod.b();
        paramString = new Intent();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("loadUI", "showWechatResultActivity");
        paramString.putExtras((Bundle)localObject1);
        paramString.setClass(this.f, APWebMarketActivity.class);
        this.f.startActivity(paramString);
        return;
      }
      k = gn.a(em.b().n().e.f);
      if ((k != 0) && (k != 11) && (k != 4))
      {
        APUICommonMethod.b();
        fv.a(k, 0, -1);
        return;
      }
      APUICommonMethod.b();
      fv.a(k, 0, 0);
      return;
    }
    if (hu.U.equals(paramString)) {}
    try
    {
      paramString = APTools.b((String)((HashMap)localObject4).get("wx_link_title"), 1);
    }
    catch (Exception paramString)
    {
      label1500:
      label1504:
      label1509:
      break label1500;
    }
    try
    {
      localObject1 = APTools.b((String)((HashMap)localObject4).get("wx_link"), 1);
    }
    catch (Exception localException3)
    {
      break label1504;
    }
    try
    {
      localObject3 = APTools.b((String)((HashMap)localObject4).get("wx_description"), 1);
    }
    catch (Exception localException5)
    {
      break label1509;
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
    new fp(this.f).a(0, paramString, (String)localObject1, (String)localObject3);
    return;
    if (hu.V.equals(paramString)) {}
    try
    {
      paramString = APTools.b((String)((HashMap)localObject4).get("wx_link_title"), 1);
    }
    catch (Exception paramString)
    {
      label1668:
      label1672:
      break label1668;
    }
    try
    {
      localObject1 = APTools.b((String)((HashMap)localObject4).get("wx_link"), 1);
    }
    catch (Exception localException4)
    {
      break label1672;
    }
    try
    {
      localObject3 = APTools.b((String)((HashMap)localObject4).get("wx_description"), 1);
    }
    catch (Exception localException6)
    {
      break label1677;
    }
    paramString = "";
    localObject1 = "";
    label1677:
    localObject3 = "";
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("shareTitle, shareLink, shareDescription");
    ((StringBuilder)localObject4).append(paramString);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append(",");
    ((StringBuilder)localObject4).append((String)localObject3);
    APLog.i("恩赐朋友圈", ((StringBuilder)localObject4).toString());
    new fp(this.f).a(1, paramString, (String)localObject1, (String)localObject3);
    return;
    if (hu.W.equals(paramString)) {}
    try
    {
      paramString = APTools.c(this.f, "com.tencent.mm");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("微信版本号：");
      ((StringBuilder)localObject1).append(paramString);
      APLog.i("APWebBuyActivity微信版本号", ((StringBuilder)localObject1).toString());
      if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
        break label2174;
      }
      localObject1 = paramString.split("\\.");
      int m = 0;
      k = m;
      if (!TextUtils.isEmpty(localObject1[0]))
      {
        k = m;
        if (!TextUtils.isEmpty(localObject1[1])) {
          if (localObject1[0].compareTo("6") == 0)
          {
            if (localObject1[1].compareTo("2") < 0) {
              break label2174;
            }
          }
          else
          {
            k = 0;
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
        k = 1;
        continue;
        k = 0;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("微信版本号：");
    ((StringBuilder)localObject1).append(paramString);
    APLog.i("APWebBuyActivity微信版本号", ((StringBuilder)localObject1).toString());
    if (k != 0)
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
      new fp(this.f, fp.a).a(paramString, (String)localObject1);
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
    APUICommonMethod.a(this.f, "当前微信版本过低，请升级到最新版本！");
    return;
    APLog.i("APWebBuyActivity", "微信版本号判断异常!");
  }
  
  public void a(Throwable paramThrowable)
  {
    super.a(paramThrowable);
    i();
  }
  
  public boolean a()
  {
    k();
    Intent localIntent;
    Bundle localBundle;
    if ((a.a().a(em.b().n().a)) && ("bank".equals(em.b().n().a.mpInfo.payChannel)))
    {
      APUICommonMethod.b();
      localIntent = new Intent();
      localBundle = new Bundle();
      localBundle.putString("loadUI", "showBankResultActivity");
      localIntent.putExtras(localBundle);
      localIntent.setClass(this.f, APWebMarketActivity.class);
      this.f.startActivity(localIntent);
    }
    else if ((a.a().a(em.b().n().a)) && ("wechat".equals(em.b().n().a.mpInfo.payChannel)))
    {
      APUICommonMethod.b();
      localIntent = new Intent();
      localBundle = new Bundle();
      localBundle.putString("loadUI", "showWechatResultActivity");
      localIntent.putExtras(localBundle);
      localIntent.setClass(this.f, APWebMarketActivity.class);
      this.f.startActivity(localIntent);
    }
    else
    {
      i();
    }
    return true;
  }
  
  public String b()
  {
    Object localObject3 = fy.a().p();
    Object localObject2 = hu.a;
    Object localObject1 = localObject2;
    if (!APAppDataInterface.singleton().e().equals("release"))
    {
      localObject1 = localObject2;
      if (APAppDataInterface.singleton().y()) {
        localObject1 = hu.b;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append((String)localObject3);
    ((StringBuilder)localObject2).append(h());
    localObject3 = new StringBuffer(((StringBuilder)localObject2).toString());
    if (!((StringBuffer)localObject3).toString().contains("?")) {
      ((StringBuffer)localObject3).append("?");
    } else if (!((StringBuffer)localObject3).toString().endsWith("?")) {
      ((StringBuffer)localObject3).append("&");
    }
    localObject1 = "";
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&random=");
      ((StringBuilder)localObject2).append(String.valueOf(Math.random() * 100.0D));
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label180:
      break label180;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((StringBuffer)localObject3).toString());
    ((StringBuilder)localObject2).append(APTools.a(g()));
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    APLog.i("constructUrl", (String)localObject1);
    return localObject1;
  }
  
  protected void e()
  {
    if (!this.e) {
      k();
    }
    super.e();
  }
  
  public boolean f()
  {
    return this.e ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ix
 * JD-Core Version:    0.7.0.1
 */