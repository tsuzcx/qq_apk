package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;

public class bq
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e = "";
  private String f = "";
  
  public static bq a()
  {
    return a.a();
  }
  
  public static String b()
  {
    String str;
    if (TextUtils.isEmpty(a().d)) {
      str = a().b;
    } else {
      str = a().d;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("linkId linkId= ");
    localStringBuilder.append(str);
    APLog.d("APCloudHelper", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("linkId mCloudLinkId= ");
    localStringBuilder.append(a().d);
    APLog.d("APCloudHelper", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("linkId mClientLinkId= ");
    localStringBuilder.append(a().b);
    APLog.d("APCloudHelper", localStringBuilder.toString());
    return gh.a(str, 32);
  }
  
  public static boolean b(String paramString)
  {
    return ("wechat".equals(paramString)) || ("qqwallet".equals(paramString));
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
  
  public static boolean c()
  {
    return "cloud".equals(a().e);
  }
  
  public static String d(String paramString)
  {
    paramString = gh.a(paramString, 32);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("linkId key= ");
    localStringBuilder.append(paramString);
    APLog.d("APCloudHelper", localStringBuilder.toString());
    return paramString;
  }
  
  public static boolean d()
  {
    return "client".equals(a().e);
  }
  
  public static String e()
  {
    return a().a;
  }
  
  public static String f()
  {
    return a().c;
  }
  
  public static String g()
  {
    return a().f;
  }
  
  public static String h()
  {
    if (!TextUtils.isEmpty(a().d)) {
      return a().d;
    }
    return a().b;
  }
  
  public String a(String paramString)
  {
    Object localObject1 = "";
    StringBuilder localStringBuilder;
    try
    {
      String str = System.getenv(paramString);
      localObject1 = str;
    }
    catch (Exception localException1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getEnvVariable().getenv key = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", e=");
      localStringBuilder.append(localException1.toString());
      APLog.d("APCloudHelper", localStringBuilder.toString());
    }
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (!((String)localObject1).equals("")) {}
    }
    else
    {
      try
      {
        localObject2 = System.getProperty(paramString);
      }
      catch (Exception localException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getEnvVariable().getProperty key = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", e=");
        localStringBuilder.append(localException2.toString());
        APLog.d("APCloudHelper", localStringBuilder.toString());
        localObject3 = localObject1;
      }
    }
    paramString = localObject3;
    if (localObject3 == null) {
      paramString = "";
    }
    return paramString;
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
      paramAPBaseRequest = APTools.b(paramAPBaseRequest.reserv);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initCloud() request = ");
    ((StringBuilder)localObject).append(paramAPBaseRequest.toString());
    APLog.d("APCloudHelper", ((StringBuilder)localObject).toString());
    paramAPBaseRequest = a("linkid");
    if (!TextUtils.isEmpty(paramAPBaseRequest)) {
      this.d = paramAPBaseRequest;
    }
    paramAPBaseRequest = a("cloud_platform");
    if (!TextUtils.isEmpty(paramAPBaseRequest)) {
      this.e = paramAPBaseRequest;
    }
    localObject = a("platformid");
    if (!TextUtils.isEmpty(paramAPBaseRequest)) {
      this.f = ((String)localObject);
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
  }
  
  static class a
  {
    private static bq a = new bq(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.bq
 * JD-Core Version:    0.7.0.1
 */