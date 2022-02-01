package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;

public class r1
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e = "";
  public String f = "";
  public String g = "";
  
  public static String a()
  {
    return d().a;
  }
  
  public static String b()
  {
    return d().c;
  }
  
  public static String b(String paramString)
  {
    paramString = l6.a(paramString, 32);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("linkId key= ");
    localStringBuilder.append(paramString);
    APLog.d("APCloudHelper", localStringBuilder.toString());
    return paramString;
  }
  
  public static int c(String paramString)
  {
    if ("wechat".equals(paramString)) {
      return 8;
    }
    if ("qqwallet".equals(paramString)) {
      return 13;
    }
    return -1;
  }
  
  public static String c()
  {
    String str;
    if (TextUtils.isEmpty(d().d)) {
      str = d().b;
    } else {
      str = d().d;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("linkId linkId= ");
    localStringBuilder.append(str);
    APLog.d("APCloudHelper", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("linkId mCloudLinkId= ");
    localStringBuilder.append(d().d);
    APLog.d("APCloudHelper", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("linkId mClientLinkId= ");
    localStringBuilder.append(d().b);
    APLog.d("APCloudHelper", localStringBuilder.toString());
    return l6.a(str, 32);
  }
  
  public static r1 d()
  {
    return b.a();
  }
  
  public static boolean d(String paramString)
  {
    if (h()) {
      return false;
    }
    return ("wechat".equals(paramString)) || ("qqwallet".equals(paramString));
  }
  
  public static String e()
  {
    if (!TextUtils.isEmpty(d().d)) {
      return d().d;
    }
    return d().b;
  }
  
  public static String f()
  {
    return d().f;
  }
  
  public static boolean g()
  {
    return "client".equals(d().e);
  }
  
  public static boolean h()
  {
    return ("LGS".equals(d().g)) || ("TV".equals(d().g));
  }
  
  public static boolean i()
  {
    return "cloud".equals(d().e);
  }
  
  public String a(String paramString)
  {
    Object localObject;
    try
    {
      String str1 = System.getenv(paramString);
    }
    catch (Exception localException1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getEnvVariable().getenv key = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", e=");
      ((StringBuilder)localObject).append(localException1.toString());
      APLog.d("APCloudHelper", ((StringBuilder)localObject).toString());
      str2 = "";
    }
    if ((str2 == null) || (str2.equals(""))) {
      try
      {
        localObject = System.getProperty(paramString);
        paramString = (String)localObject;
      }
      catch (Exception localException2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getEnvVariable().getProperty key = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", e=");
        localStringBuilder.append(localException2.toString());
        APLog.d("APCloudHelper", localStringBuilder.toString());
      }
    } else {
      paramString = str2;
    }
    String str2 = paramString;
    if (paramString == null) {
      str2 = "";
    }
    return str2;
  }
  
  public void a(APBaseRequest paramAPBaseRequest)
  {
    if (paramAPBaseRequest == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initClient() request.reserv = ");
    ((StringBuilder)localObject).append(paramAPBaseRequest.reserv);
    APLog.d("APCloudHelper", ((StringBuilder)localObject).toString());
    this.a = paramAPBaseRequest.offerId;
    this.c = paramAPBaseRequest.openId;
    if (!TextUtils.isEmpty(paramAPBaseRequest.reserv))
    {
      paramAPBaseRequest = APTools.n(paramAPBaseRequest.reserv);
      localObject = (String)paramAPBaseRequest.get("cloud_platform");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.e = ((String)localObject);
      }
      paramAPBaseRequest = (String)paramAPBaseRequest.get("linkid");
      if (!TextUtils.isEmpty(paramAPBaseRequest)) {
        this.b = paramAPBaseRequest;
      }
    }
    paramAPBaseRequest = new StringBuilder();
    paramAPBaseRequest.append("initClient() mClientLinkId = ");
    paramAPBaseRequest.append(this.b);
    APLog.d("APCloudHelper", paramAPBaseRequest.toString());
    paramAPBaseRequest = new StringBuilder();
    paramAPBaseRequest.append("initClient() mPlatform = ");
    paramAPBaseRequest.append(this.e);
    APLog.d("APCloudHelper", paramAPBaseRequest.toString());
    paramAPBaseRequest = new StringBuilder();
    paramAPBaseRequest.append("initClient() mClientOfferId = ");
    paramAPBaseRequest.append(this.a);
    APLog.d("APCloudHelper", paramAPBaseRequest.toString());
    paramAPBaseRequest = new StringBuilder();
    paramAPBaseRequest.append("initClient() mClientOpenId = ");
    paramAPBaseRequest.append(this.c);
    APLog.d("APCloudHelper", paramAPBaseRequest.toString());
  }
  
  public void b(APBaseRequest paramAPBaseRequest)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initCloud() request = ");
    localStringBuilder.append(paramAPBaseRequest.toString());
    APLog.d("APCloudHelper", localStringBuilder.toString());
    paramAPBaseRequest = a("linkid");
    if (!TextUtils.isEmpty(paramAPBaseRequest)) {
      this.d = paramAPBaseRequest;
    }
    paramAPBaseRequest = a("cloud_platform");
    if (!TextUtils.isEmpty(paramAPBaseRequest)) {
      this.e = paramAPBaseRequest;
    }
    paramAPBaseRequest = a("platformid");
    if (!TextUtils.isEmpty(paramAPBaseRequest)) {
      this.f = paramAPBaseRequest;
    }
    paramAPBaseRequest = a("platform_type");
    if (!TextUtils.isEmpty(paramAPBaseRequest)) {
      this.g = paramAPBaseRequest;
    }
    paramAPBaseRequest = a("client_offerid");
    if (!TextUtils.isEmpty(paramAPBaseRequest)) {
      this.a = paramAPBaseRequest;
    }
    paramAPBaseRequest = a("client_openid");
    if (!TextUtils.isEmpty(paramAPBaseRequest)) {
      this.c = paramAPBaseRequest;
    }
    paramAPBaseRequest = new StringBuilder();
    paramAPBaseRequest.append("initCloud() mPlatformId = ");
    paramAPBaseRequest.append(this.f);
    APLog.d("APCloudHelper", paramAPBaseRequest.toString());
    paramAPBaseRequest = new StringBuilder();
    paramAPBaseRequest.append("initCloud() mCloudLinkId = ");
    paramAPBaseRequest.append(this.d);
    APLog.d("APCloudHelper", paramAPBaseRequest.toString());
    paramAPBaseRequest = new StringBuilder();
    paramAPBaseRequest.append("initCloud() mPlatform = ");
    paramAPBaseRequest.append(this.e);
    APLog.d("APCloudHelper", paramAPBaseRequest.toString());
    paramAPBaseRequest = new StringBuilder();
    paramAPBaseRequest.append("initCloud() mClientOfferId = ");
    paramAPBaseRequest.append(this.a);
    APLog.d("APCloudHelper", paramAPBaseRequest.toString());
    paramAPBaseRequest = new StringBuilder();
    paramAPBaseRequest.append("initCloud() mClientOpenId = ");
    paramAPBaseRequest.append(this.c);
    APLog.d("APCloudHelper", paramAPBaseRequest.toString());
    paramAPBaseRequest = new StringBuilder();
    paramAPBaseRequest.append("initCloud() mPlatformType = ");
    paramAPBaseRequest.append(this.g);
    APLog.d("APCloudHelper", paramAPBaseRequest.toString());
  }
  
  public static class b
  {
    public static r1 a = new r1(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.r1
 * JD-Core Version:    0.7.0.1
 */