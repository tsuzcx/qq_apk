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

public class m4
  extends y1
{
  public m4(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Parameter tokenUrl = ");
    ((StringBuilder)localObject1).append(paramString);
    APLog.d("QRCodePay-QRCodeReq", ((StringBuilder)localObject1).toString());
    Object localObject2 = p4.p().c();
    if (p4.p().i())
    {
      StringBuilder localStringBuilder;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = Pattern.compile(".+v1/([^/]+)/[a-zA-Z0-9]+/.+").matcher(paramString);
        if ((((Matcher)localObject1).matches()) && (((Matcher)localObject1).groupCount() == 1))
        {
          localObject1 = ((Matcher)localObject1).group(1);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Token url = ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" match result = ");
          localStringBuilder.append(((Matcher)localObject1).matches());
          localStringBuilder.append(" match count = ");
          localStringBuilder.append(((Matcher)localObject1).groupCount());
          APLog.e("QRCodePay-QRCodeReq", localStringBuilder.toString());
        }
      }
      else
      {
        localObject1 = "";
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot get r from token url = ");
        localStringBuilder.append(paramString);
        APLog.e("QRCodePay-QRCodeReq", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("r = ");
        localStringBuilder.append((String)localObject1);
        APLog.d("QRCodePay-QRCodeReq", localStringBuilder.toString());
      }
      localObject1 = String.format("/v1/%s/%s/mobile_get_qrcode", new Object[] { localObject1, localObject2 });
      paramString = f(paramString);
    }
    else
    {
      localObject1 = String.format("/v1/%s/%s/mobile_get_qrcode", new Object[] { "r", localObject2 });
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Url = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.d("QRCodePay-QRCodeReq", ((StringBuilder)localObject2).toString());
    f("https", (String)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TokenID = ");
    ((StringBuilder)localObject1).append(paramString);
    APLog.d("QRCodePay-QRCodeReq", ((StringBuilder)localObject1).toString());
    e(paramString);
  }
  
  public static String f(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      APLog.e("QRCodePay-QRCodeReq", "Cannot get token id, token url empty!");
      return "";
    }
    return Uri.parse(paramString).getQueryParameter("token_id");
  }
  
  public void D()
  {
    super.D();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("encode key = ");
    localStringBuilder.append(v());
    APLog.d("QRCodePay-QRCodeReq", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("encode parameter = ");
    localStringBuilder.append(t());
    APLog.d("QRCodePay-QRCodeReq", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("parameter = ");
    localStringBuilder.append(c());
    APLog.d("QRCodePay-QRCodeReq", localStringBuilder.toString());
  }
  
  public void e(String paramString)
  {
    int i = p4.p().g();
    Object localObject1 = p4.p().e();
    if (localObject1 == null)
    {
      APLog.e("QRCodePay-QRCodeReq", "Cannot get qr code with null order info!");
      return;
    }
    Object localObject2 = ((o4)localObject1).b;
    if (localObject2 == null)
    {
      APLog.e("QRCodePay-QRCodeReq", "Cannot get qr code with null request!");
      return;
    }
    Object localObject3 = c6.s0();
    b("offer_id", p4.p().c());
    b("openid", ((APBaseRequest)localObject2).openId);
    b("pf", ((o4)localObject1).b.pf);
    b("pfkey", ((o4)localObject1).b.pfKey);
    b("format", "json");
    b("sdkversion", "1.7.9a");
    b("size", "600");
    b("uuid", c6.s0().Z());
    b("pushtype", "NodeJS");
    b("extend", ((c6)localObject3).e());
    b("user_imei", APTools.b(((c6)localObject3).W(), 1));
    b("user_androidid", APTools.b(((c6)localObject3).V(), 1));
    b("user_mac", APTools.b(((c6)localObject3).X(), 1));
    b("xg_mid", APAppDataInterface.singleton().C());
    e("openid", ((APBaseRequest)localObject2).openId);
    e("openkey", ((APBaseRequest)localObject2).openKey);
    e("session_id", ((APBaseRequest)localObject2).sessionId);
    e("session_type", ((APBaseRequest)localObject2).sessionType);
    String str;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 4)
        {
          if (i != 5)
          {
            localObject1 = "";
          }
          else
          {
            localObject3 = (z4)p4.p().e().c;
            e("service_code", ((APMonthRequest)((o4)localObject1).b).serviceCode);
            b("product_id", ((z4)localObject3).k);
            localObject1 = "unimonth";
          }
        }
        else
        {
          localObject1 = (z4)p4.p().e().c;
          if (!(localObject2 instanceof APMonthRequest))
          {
            APLog.e("QRCodePay-QRCodeReq", "Get qr code cannot change request type to month request!");
            return;
          }
          localObject3 = (APMonthRequest)localObject2;
          if (((z4)localObject1).l == 3) {
            e("service_update", "1");
          }
          try
          {
            b("service_code", ((APMonthRequest)localObject3).serviceCode);
            boolean bool = TextUtils.isEmpty(((APMonthRequest)localObject3).serviceName);
            if (bool) {
              b("service_name", "");
            } else {
              b("service_name", URLEncoder.encode(((APMonthRequest)localObject3).serviceName, "UTF-8"));
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
          str = "month";
        }
      }
      else {
        str = "bg";
      }
    }
    else {
      str = "save";
    }
    if (TextUtils.isEmpty(((APBaseRequest)localObject2).remark)) {
      b("remark", "");
    } else {
      b("remark", APTools.b(((APBaseRequest)localObject2).remark, 1));
    }
    if (!TextUtils.isEmpty(str))
    {
      e("type", str);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Type = ");
      ((StringBuilder)localObject2).append(str);
      APLog.d("QRCodePay-QRCodeReq", ((StringBuilder)localObject2).toString());
    }
    else
    {
      APLog.e("QRCodePay-QRCodeReq", "Type empty!");
    }
    e("token_id", paramString);
    e("discountid", p4.p().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.m4
 * JD-Core Version:    0.7.0.1
 */