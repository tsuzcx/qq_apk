package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class io
  extends ig
{
  private Activity f = null;
  private hq g = null;
  private ProgressDialog h = null;
  private boolean i = false;
  
  public io()
  {
    c();
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.g.b(paramString1, paramString2);
  }
  
  private void a(JSONArray paramJSONArray)
  {
    for (;;)
    {
      int j;
      try
      {
        n.a().j();
        j = 0;
        if (j < paramJSONArray.length())
        {
          JSONObject localJSONObject1 = (JSONObject)paramJSONArray.get(j);
          Object localObject2 = "";
          Object localObject3 = "";
          Object localObject4 = "";
          Object localObject5 = "";
          String str4 = "";
          Object localObject9 = "";
          String str1 = "";
          String str3 = "";
          Object localObject6 = localObject2;
          Object localObject7 = localObject3;
          Object localObject1 = localObject4;
          Object localObject8 = localObject5;
          String str2 = str4;
          if (localJSONObject1.has("cardInfo"))
          {
            JSONObject localJSONObject2 = localJSONObject1.getJSONObject("cardInfo");
            if (localJSONObject2.has("card_id")) {
              localObject2 = localJSONObject2.getString("card_id");
            }
            if (localJSONObject2.has("amt")) {
              localObject3 = localJSONObject2.getString("amt");
            }
            if (localJSONObject2.has("allow_pay_channel")) {
              localObject4 = localJSONObject2.getString("allow_pay_channel");
            }
            if (localJSONObject2.has("rank_type")) {
              localObject5 = localJSONObject2.getString("rank_type");
            }
            localObject6 = localObject2;
            localObject7 = localObject3;
            localObject1 = localObject4;
            localObject8 = localObject5;
            str2 = str4;
            if (localJSONObject2.has("least_price"))
            {
              str2 = localJSONObject2.getString("least_price");
              localObject8 = localObject5;
              localObject1 = localObject4;
              localObject7 = localObject3;
              localObject6 = localObject2;
            }
          }
          localObject4 = localObject1;
          localObject3 = localObject9;
          if (localJSONObject1.has("batchInfo"))
          {
            localObject5 = localJSONObject1.getJSONObject("batchInfo");
            localObject2 = localObject9;
            if (((JSONObject)localObject5).has("batch_id")) {
              localObject2 = ((JSONObject)localObject5).getString("batch_id");
            }
            localObject4 = localObject1;
            localObject3 = localObject2;
            if (((JSONObject)localObject5).has("allow_pay_channel"))
            {
              localObject4 = localObject1;
              localObject3 = localObject2;
              if (!TextUtils.isEmpty(((JSONObject)localObject5).getString("allow_pay_channel")))
              {
                localObject4 = ((JSONObject)localObject5).getString("allow_pay_channel");
                localObject3 = localObject2;
              }
            }
          }
          localObject2 = str1;
          localObject5 = str3;
          if (localJSONObject1.has("codeInfo"))
          {
            localObject9 = localJSONObject1.getJSONObject("codeInfo");
            localObject1 = str1;
            if (((JSONObject)localObject9).has("code_id")) {
              localObject1 = ((JSONObject)localObject9).getString("code_id");
            }
            localObject2 = localObject1;
            localObject5 = str3;
            if (((JSONObject)localObject9).has("status"))
            {
              localObject5 = ((JSONObject)localObject9).getString("status");
              localObject2 = localObject1;
            }
          }
          localObject1 = new m();
          ((m)localObject1).a(localObject6);
          ((m)localObject1).b(localObject7);
          ((m)localObject1).d((String)localObject4);
          ((m)localObject1).a(n.a().f((String)localObject4));
          ((m)localObject1).e(localObject8);
          ((m)localObject1).c(str2);
          ((m)localObject1).f((String)localObject3);
          ((m)localObject1).g((String)localObject2);
          ((m)localObject1).h((String)localObject5);
          if (n.a().a((m)localObject1))
          {
            n.a().f().add(localObject1);
            if (!n.a().a((m)localObject1, n.a().c())) {
              n.a().c().add(localObject1);
            }
          }
        }
        else
        {
          n.a().a(n.a().f(), n.a().i());
          return;
        }
      }
      catch (Exception paramJSONArray)
      {
        APLog.w("resolveWebCouponJson", paramJSONArray.toString());
        return;
      }
      j += 1;
    }
  }
  
  private void e(String paramString)
  {
    new ArrayList();
    List localList = n.a().h(ed.b().n().e.f);
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    if (localList != null)
    {
      int j = 0;
      while (j < localList.size())
      {
        try
        {
          localJSONObject.put("card_id", ((m)localList.get(j)).a());
          localJSONObject.put("amt", ((m)localList.get(j)).b());
          localJSONObject.put("least_price", ((m)localList.get(j)).c());
          localJSONObject.put("allow_pay_channel", ((m)localList.get(j)).d());
          localJSONObject.put("rank_type", ((m)localList.get(j)).e());
          localJSONObject.put("batch_id", ((m)localList.get(j)).g());
          localJSONObject.put("code_id", ((m)localList.get(j)).h());
          localJSONObject.put("status", ((m)localList.get(j)).i());
          localJSONArray.put(localJSONObject);
        }
        catch (Exception localException)
        {
          APLog.i("sendCouponInfo", localException.toString());
        }
        j += 1;
      }
    }
    this.g.a(paramString, localJSONArray.toString());
  }
  
  private HashMap<String, String> g()
  {
    d();
    Object localObject = APAppDataInterface.singleton().e();
    if (((String)localObject).equals("test")) {
      this.d.put("sandbox", "1");
    } else if (((String)localObject).equals("dev")) {
      this.d.put("sandbox", "2");
    }
    this.d.put("page", hj.B);
    this.d.put("expressChannel", ed.b().n().e.f);
    this.d.put("sdkType", "android");
    this.d.put("saveType", String.valueOf(ed.b().n().a.saveType));
    if (fm.f()) {
      this.d.put("supportChannel", ed.b().n().a.mpInfo.payChannel);
    } else {
      this.d.put("supportChannel", gd.a().h());
    }
    localObject = this.f.getResources().getConfiguration();
    if (((Configuration)localObject).orientation == 1) {
      this.d.put("orientation", "0");
    } else if (((Configuration)localObject).orientation == 2) {
      this.d.put("orientation", "1");
    }
    return this.d;
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(Activity paramActivity, hq paramhq)
  {
    super.a(paramActivity, paramhq);
    this.f = paramActivity;
    this.g = paramhq;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    APDataReportManager.getInstance().insertData("sdk.coupons.page.show", ed.b().n().a.saveType, null, null, null);
    if (this.h != null) {
      this.h.show();
    }
    if (this.g != null) {
      this.g.b(b());
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    APLog.i("message:", paramString);
    new HashMap();
    paramString = APTools.b(paramString);
    String str1 = (String)paramString.get("page");
    String str3 = (String)paramString.get("action");
    String str4 = (String)paramString.get("selectedCoupons");
    str1 = (String)paramString.get("channelid");
    String str2 = (String)paramString.get("ischange");
    APLog.i("action:", str3);
    APLog.i("selectedCoupons:", str4);
    APLog.i("channelid:", str1);
    APLog.i("ischange:", str2);
    if (hj.M.equals(str3))
    {
      this.i = true;
      return;
    }
    if (hj.P.equals(str3))
    {
      paramString = (String)paramString.get("callback");
      APLog.i("callback:", paramString);
      e(paramString);
      return;
    }
    if (hj.R.equals(str3))
    {
      a((String)paramString.get("h5_width"), (String)paramString.get("h5_height"));
      return;
    }
    if (hj.U.equals(str3))
    {
      paramString = (String)paramString.get("errCode");
      APLog.i("errCode:", paramString);
      if ("-1000".equals(paramString))
      {
        APUICommonMethod.b();
        fm.d();
      }
    }
    else if (!hj.T.equals(str3)) {}
    try
    {
      if (TextUtils.isEmpty(str4))
      {
        this.f.finish();
        APUICommonMethod.b(this.f);
        return;
      }
      paramString = new JSONArray(str4);
      if (paramString.length() < 1)
      {
        if ("1".equals(str2))
        {
          n.a().j();
          this.f.setResult(101);
          this.f.finish();
          APUICommonMethod.b(this.f);
          return;
        }
        this.f.finish();
        APUICommonMethod.b(this.f);
        return;
      }
      a(paramString);
      if (!TextUtils.isEmpty(str1))
      {
        n.a().k(str1);
        if (!str1.equals(ed.b().n().e.f))
        {
          ed.b().n().e.f = str1;
          if ("channellist".equals(str1)) {
            this.f.setResult(102);
          } else {
            this.f.setResult(103);
          }
        }
        else
        {
          this.f.setResult(101);
        }
      }
      this.f.finish();
      APUICommonMethod.b(this.f);
      return;
    }
    catch (Exception paramString)
    {
      label461:
      break label461;
    }
    this.f.finish();
    APUICommonMethod.b(this.f);
    return;
    if (hj.K.equals(str3))
    {
      this.f.finish();
      APUICommonMethod.b(this.f);
    }
  }
  
  public boolean a()
  {
    if (this.i) {}
    try
    {
      this.g.a("onAndroidBack", "");
    }
    catch (Exception localException)
    {
      label22:
      break label22;
    }
    this.f.finish();
    APUICommonMethod.b(this.f);
    break label53;
    this.f.finish();
    APUICommonMethod.b(this.f);
    label53:
    return true;
  }
  
  public String b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(hj.a);
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append("/h5/sdk_v2/coupons/views/index.shtml?");
    String str = ((StringBuilder)localObject1).toString();
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
      Object localObject2;
      label79:
      break label79;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(APTools.a(g()));
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    APLog.i("constructUrl", (String)localObject1);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.io
 * JD-Core Version:    0.7.0.1
 */