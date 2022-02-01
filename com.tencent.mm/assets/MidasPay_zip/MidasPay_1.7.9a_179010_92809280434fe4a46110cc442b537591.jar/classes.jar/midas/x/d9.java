package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
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

public class d9
  extends v8
{
  public Activity e = null;
  public f8 f = null;
  public ProgressDialog g = null;
  public boolean h = false;
  
  public d9()
  {
    c();
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(Activity paramActivity, f8 paramf8, Bundle paramBundle)
  {
    super.a(paramActivity, paramf8, paramBundle);
    this.e = paramActivity;
    this.f = paramf8;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    APDataReportManager.getInstance().insertData("sdk.coupons.page.show", p4.p().e().b.saveType, null, null, null);
    paramProgressDialog = this.g;
    if (paramProgressDialog != null) {
      paramProgressDialog.show();
    }
    paramProgressDialog = this.f;
    if (paramProgressDialog != null) {
      paramProgressDialog.b(f());
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    APLog.i("message:", paramString);
    new HashMap();
    paramString = APTools.n(paramString);
    String str1 = (String)paramString.get("page");
    String str3 = (String)paramString.get("action");
    String str4 = (String)paramString.get("selectedCoupons");
    str1 = (String)paramString.get("channelid");
    String str2 = (String)paramString.get("ischange");
    APLog.i("action:", str3);
    APLog.i("selectedCoupons:", str4);
    APLog.i("channelid:", str1);
    APLog.i("ischange:", str2);
    if (y7.G.equals(str3))
    {
      this.h = true;
      return;
    }
    if (y7.J.equals(str3))
    {
      paramString = (String)paramString.get("callback");
      APLog.i("callback:", paramString);
      e(paramString);
      return;
    }
    if (y7.K.equals(str3))
    {
      a((String)paramString.get("h5_width"), (String)paramString.get("h5_height"));
      return;
    }
    if (y7.N.equals(str3))
    {
      paramString = (String)paramString.get("errCode");
      APLog.i("errCode:", paramString);
      if ("-1000".equals(paramString))
      {
        APUICommonMethod.f();
        z5.f();
      }
    }
    else if (!y7.M.equals(str3)) {}
    try
    {
      if (TextUtils.isEmpty(str4))
      {
        this.e.finish();
        APUICommonMethod.a(this.e);
        return;
      }
      paramString = new JSONArray(str4);
      if (paramString.length() < 1)
      {
        if ("1".equals(str2))
        {
          o.m().b();
          this.e.setResult(101);
          this.e.finish();
          APUICommonMethod.a(this.e);
          return;
        }
        this.e.finish();
        APUICommonMethod.a(this.e);
        return;
      }
      a(paramString);
      if (!TextUtils.isEmpty(str1))
      {
        o.m().j(str1);
        if (!str1.equals(p4.p().e().f.e))
        {
          p4.p().e().f.e = str1;
          if ("channellist".equals(str1)) {
            this.e.setResult(102);
          } else {
            this.e.setResult(103);
          }
        }
        else
        {
          this.e.setResult(101);
        }
      }
      this.e.finish();
      APUICommonMethod.a(this.e);
      return;
    }
    catch (Exception paramString)
    {
      label443:
      break label443;
    }
    this.e.finish();
    APUICommonMethod.a(this.e);
    return;
    if (y7.F.equals(str3))
    {
      this.e.finish();
      APUICommonMethod.a(this.e);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.f.b(paramString1, paramString2);
  }
  
  public final void a(JSONArray paramJSONArray)
  {
    String str9 = "name";
    String str8 = "least_price";
    String str7 = "rank_type";
    String str10 = "status";
    String str6 = "code_id";
    String str5 = "amt";
    String str4 = "card_id";
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("22 Web json array = ");
        ((StringBuilder)localObject1).append(paramJSONArray.toString());
        APLog.d("FFAIP-C", ((StringBuilder)localObject1).toString());
        o.m().b();
        i = 0;
        if (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
          boolean bool = localJSONObject.has("cardInfo");
          localObject7 = "";
          if (!bool) {
            break label657;
          }
          localObject2 = localJSONObject.getJSONObject("cardInfo");
          if (((JSONObject)localObject2).has(str4))
          {
            localObject1 = ((JSONObject)localObject2).getString(str4);
            if (!((JSONObject)localObject2).has(str5)) {
              break label609;
            }
            str1 = ((JSONObject)localObject2).getString(str5);
            if (!((JSONObject)localObject2).has("allow_pay_channel")) {
              break label617;
            }
            localObject4 = ((JSONObject)localObject2).getString("allow_pay_channel");
            if (!((JSONObject)localObject2).has(str7)) {
              break label625;
            }
            str2 = ((JSONObject)localObject2).getString(str7);
            if (!((JSONObject)localObject2).has(str8)) {
              break label633;
            }
            str3 = ((JSONObject)localObject2).getString(str8);
            if (!((JSONObject)localObject2).has(str9)) {
              break label641;
            }
            localObject2 = ((JSONObject)localObject2).getString(str9);
            localObject3 = localObject1;
            localObject1 = localObject4;
            if (!localJSONObject.has("batchInfo")) {
              break label700;
            }
            localObject6 = localJSONObject.getJSONObject("batchInfo");
            if (!((JSONObject)localObject6).has("batch_id")) {
              break label685;
            }
            localObject4 = ((JSONObject)localObject6).getString("batch_id");
            localObject5 = localObject1;
            if (!((JSONObject)localObject6).has("allow_pay_channel")) {
              break label693;
            }
            localObject5 = localObject1;
            if (TextUtils.isEmpty(((JSONObject)localObject6).getString("allow_pay_channel"))) {
              break label693;
            }
            localObject5 = ((JSONObject)localObject6).getString("allow_pay_channel");
            break label693;
            if (!localJSONObject.has("codeInfo")) {
              break label731;
            }
            localJSONObject = localJSONObject.getJSONObject("codeInfo");
            if (!localJSONObject.has(str6)) {
              break label712;
            }
            localObject1 = localJSONObject.getString(str6);
            localObject4 = localObject7;
            if (!localJSONObject.has(str10)) {
              break label720;
            }
            localObject4 = localJSONObject.getString(str10);
            break label720;
            localObject4 = new n();
            ((n)localObject4).d(localObject3);
            ((n)localObject4).b(str1);
            ((n)localObject4).a((String)localObject5);
            ((n)localObject4).a(o.m().h((String)localObject5));
            ((n)localObject4).g(str2);
            ((n)localObject4).f(str3);
            ((n)localObject4).c((String)localObject6);
            ((n)localObject4).e((String)localObject7);
            ((n)localObject4).h((String)localObject1);
            ((n)localObject4).j = APTools.a((String)localObject2, 1);
            if (!o.m().a((n)localObject4)) {
              break label743;
            }
            o.m().d().add(localObject4);
            if (o.m().a((n)localObject4, o.m().e())) {
              break label743;
            }
            o.m().e().add(localObject4);
            break label743;
          }
        }
        else
        {
          o.m().a(o.m().d(), o.m().c());
          return;
        }
      }
      catch (Exception paramJSONArray)
      {
        APLog.w("resolveWebCouponJson", paramJSONArray.toString());
        return;
      }
      Object localObject1 = "";
      continue;
      label609:
      String str1 = "";
      continue;
      label617:
      Object localObject4 = "";
      continue;
      label625:
      String str2 = "";
      continue;
      label633:
      String str3 = "";
      continue;
      label641:
      Object localObject2 = "";
      Object localObject3 = localObject1;
      localObject1 = localObject4;
      continue;
      label657:
      str1 = "";
      str2 = str1;
      str3 = str2;
      localObject2 = str3;
      localObject3 = localObject2;
      localObject1 = localObject3;
      continue;
      label685:
      localObject4 = "";
      continue;
      label693:
      Object localObject6 = localObject4;
      continue;
      label700:
      localObject6 = "";
      Object localObject5 = localObject1;
      continue;
      label712:
      localObject1 = "";
      continue;
      label720:
      Object localObject7 = localObject1;
      localObject1 = localObject4;
      continue;
      label731:
      localObject7 = "";
      localObject1 = localObject7;
      continue;
      label743:
      i += 1;
    }
  }
  
  public final void e(String paramString)
  {
    new ArrayList();
    List localList = o.m().b(p4.p().e().f.e);
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        try
        {
          localJSONObject.put("card_id", ((n)localList.get(i)).e());
          localJSONObject.put("amt", ((n)localList.get(i)).c());
          localJSONObject.put("least_price", ((n)localList.get(i)).g());
          localJSONObject.put("allow_pay_channel", ((n)localList.get(i)).a());
          localJSONObject.put("rank_type", ((n)localList.get(i)).h());
          localJSONObject.put("batch_id", ((n)localList.get(i)).d());
          localJSONObject.put("code_id", ((n)localList.get(i)).f());
          localJSONObject.put("status", ((n)localList.get(i)).i());
          localJSONArray.put(localJSONObject);
        }
        catch (Exception localException)
        {
          APLog.i("sendCouponInfo", localException.toString());
        }
        i += 1;
      }
    }
    this.f.a(paramString, localJSONArray.toString());
  }
  
  public boolean e()
  {
    if (this.h) {}
    try
    {
      this.f.a("onAndroidBack", "");
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    this.e.finish();
    APUICommonMethod.a(this.e);
    break label54;
    this.e.finish();
    APUICommonMethod.a(this.e);
    label54:
    return true;
  }
  
  public String f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(y7.a);
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("/h5/sdk_v2/coupons/views/index.shtml?");
    String str = ((StringBuilder)localObject).toString();
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("&random=");
      ((StringBuilder)localObject).append(String.valueOf(Math.random() * 100.0D));
      localObject = ((StringBuilder)localObject).toString();
    }
    catch (Exception localException)
    {
      label77:
      StringBuilder localStringBuilder;
      break label77;
    }
    localObject = "";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(APTools.a(g()));
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    APLog.i("constructUrl", (String)localObject);
    return localObject;
  }
  
  public final HashMap<String, String> g()
  {
    b();
    String str = APAppDataInterface.singleton().h();
    if (str.equals("test")) {
      this.c.put("sandbox", "1");
    } else if (str.equals("dev")) {
      this.c.put("sandbox", "2");
    }
    this.c.put("page", y7.y);
    this.c.put("expressChannel", p4.p().e().f.e);
    this.c.put("sdkType", "android");
    this.c.put("saveType", String.valueOf(p4.p().e().b.saveType));
    if (z5.d()) {
      this.c.put("supportChannel", p4.p().e().b.mpInfo.payChannel);
    } else {
      this.c.put("supportChannel", r6.j().e());
    }
    int i = this.e.getResources().getConfiguration().orientation;
    if (i == 1) {
      this.c.put("orientation", "0");
    } else if (i == 2) {
      this.c.put("orientation", "1");
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.d9
 * JD-Core Version:    0.7.0.1
 */