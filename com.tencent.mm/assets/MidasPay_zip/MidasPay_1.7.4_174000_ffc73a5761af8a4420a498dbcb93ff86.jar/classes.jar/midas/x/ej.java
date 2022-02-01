package midas.x;

import android.net.Uri;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ej
  extends bx
{
  public ej(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Parameter tokenUrl = ");
    ((StringBuilder)localObject1).append(paramString);
    APLog.d("QRCodePay-QRCodeReq", ((StringBuilder)localObject1).toString());
    String str = em.b().f();
    Object localObject2 = "";
    if (em.b().l())
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = Pattern.compile(".+v1/([^/]+)/[a-zA-Z0-9]+/.+").matcher(paramString);
        if ((((Matcher)localObject1).matches()) && (((Matcher)localObject1).groupCount() == 1))
        {
          localObject1 = ((Matcher)localObject1).group(1);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Token url = ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" match result = ");
          localStringBuilder.append(((Matcher)localObject1).matches());
          localStringBuilder.append(" match count = ");
          localStringBuilder.append(((Matcher)localObject1).groupCount());
          APLog.e("QRCodePay-QRCodeReq", localStringBuilder.toString());
          localObject1 = localObject2;
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Cannot get r from token url = ");
        ((StringBuilder)localObject2).append(paramString);
        APLog.e("QRCodePay-QRCodeReq", ((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("r = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        APLog.d("QRCodePay-QRCodeReq", ((StringBuilder)localObject2).toString());
      }
      localObject1 = String.format("/v1/%s/%s/mobile_get_qrcode", new Object[] { localObject1, str });
      paramString = f(paramString);
    }
    else
    {
      localObject1 = String.format("/v1/%s/%s/mobile_get_qrcode", new Object[] { "r", str });
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Url = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.d("QRCodePay-QRCodeReq", ((StringBuilder)localObject2).toString());
    a("https", (String)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TokenID = ");
    ((StringBuilder)localObject1).append(paramString);
    APLog.d("QRCodePay-QRCodeReq", ((StringBuilder)localObject1).toString());
    a(paramString);
  }
  
  private static String f(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      APLog.e("QRCodePay-QRCodeReq", "Cannot get token id, token url empty!");
      return "";
    }
    return Uri.parse(paramString).getQueryParameter("token_id");
  }
  
  public void a(String paramString)
  {
    int i = em.b().g();
    Object localObject3 = em.b().n();
    if (localObject3 == null)
    {
      APLog.e("QRCodePay-QRCodeReq", "Cannot get qr code with null order info!");
      return;
    }
    Object localObject2 = ((el)localObject3).a;
    if (localObject2 == null)
    {
      APLog.e("QRCodePay-QRCodeReq", "Cannot get qr code with null request!");
      return;
    }
    Object localObject1 = fy.a();
    e("offer_id", em.b().f());
    e("openid", ((APBaseRequest)localObject2).openId);
    e("pf", ((el)localObject3).a.pf);
    e("pfkey", ((el)localObject3).a.pfKey);
    e("format", "json");
    e("sdkversion", "1.7.4");
    e("size", "600");
    e("uuid", fy.a().i());
    e("pushtype", "NodeJS");
    e("extend", ((fy)localObject1).y());
    e("user_imei", APTools.a(((fy)localObject1).r(), 1));
    e("user_androidid", APTools.a(((fy)localObject1).s(), 1));
    e("user_mac", APTools.a(((fy)localObject1).t(), 1));
    e("xg_mid", APAppDataInterface.singleton().l());
    f("openid", ((APBaseRequest)localObject2).openId);
    f("openkey", ((APBaseRequest)localObject2).openKey);
    f("session_id", ((APBaseRequest)localObject2).sessionId);
    f("session_type", ((APBaseRequest)localObject2).sessionType);
    localObject1 = "";
    String str;
    switch (i)
    {
    case 2: 
    case 3: 
    default: 
      break;
    case 5: 
      localObject1 = (ew)em.b().n().b;
      f("service_code", ((APMonthRequest)((el)localObject3).a).serviceCode);
      e("product_id", ((ew)localObject1).k);
      localObject1 = "unimonth";
      break;
    case 4: 
      localObject1 = (ew)em.b().n().b;
      if (!(localObject2 instanceof APMonthRequest))
      {
        APLog.e("QRCodePay-QRCodeReq", "Get qr code cannot change request type to month request!");
        return;
      }
      localObject3 = (APMonthRequest)localObject2;
      if (((ew)localObject1).l == 3) {
        f("service_update", "1");
      }
      try
      {
        e("service_code", ((APMonthRequest)localObject3).serviceCode);
        if (TextUtils.isEmpty(((APMonthRequest)localObject3).serviceName)) {
          e("service_name", "");
        } else {
          e("service_name", URLEncoder.encode(((APMonthRequest)localObject3).serviceName, "UTF-8"));
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      str = "month";
      break;
    case 1: 
      str = "bg";
      break;
    case 0: 
      str = "save";
    }
    if (TextUtils.isEmpty(((APBaseRequest)localObject2).remark)) {
      e("remark", "");
    } else {
      e("remark", APTools.a(((APBaseRequest)localObject2).remark, 1));
    }
    if (!TextUtils.isEmpty(str))
    {
      f("type", str);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Type = ");
      ((StringBuilder)localObject2).append(str);
      APLog.d("QRCodePay-QRCodeReq", ((StringBuilder)localObject2).toString());
    }
    else
    {
      APLog.e("QRCodePay-QRCodeReq", "Type empty!");
    }
    f("token_id", paramString);
    f("discountid", em.b().o());
  }
  
  protected void a_()
  {
    super.a_();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("encode key = ");
    localStringBuilder.append(z());
    APLog.d("QRCodePay-QRCodeReq", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("encode parameter = ");
    localStringBuilder.append(H());
    APLog.d("QRCodePay-QRCodeReq", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("parameter = ");
    localStringBuilder.append(k());
    APLog.d("QRCodePay-QRCodeReq", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ej
 * JD-Core Version:    0.7.0.1
 */