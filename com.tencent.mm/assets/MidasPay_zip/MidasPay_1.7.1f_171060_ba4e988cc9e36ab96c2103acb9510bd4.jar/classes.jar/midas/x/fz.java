package midas.x;

import android.content.Context;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.tencent.midas.comm.APLog;

public class fz
{
  private static volatile fz a;
  private final String b = "caUdsBbJ1oOxMbPy";
  private Context c;
  
  private String a()
  {
    a.getClass();
    String str1 = "caUdsBbJ1oOxMbPy".substring(0, 4);
    String str2 = "caUdsBbJ1oOxMbPy".substring(4, 8);
    String str3 = "caUdsBbJ1oOxMbPy".substring(8, 12);
    String str4 = "caUdsBbJ1oOxMbPy".substring(12, 16);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(str3);
    localStringBuffer.append(str2);
    localStringBuffer.append(str1);
    localStringBuffer.append(str4);
    return localStringBuffer.toString();
  }
  
  public static fz a(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          a = new fz();
          a.c = paramContext.getApplicationContext();
        }
      }
      finally {}
    }
    return a;
  }
  
  public String a(String paramString)
  {
    fq localfq = new fq();
    try
    {
      Context localContext = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ed.b().n().a.offerId);
      localStringBuilder.append("_payId_");
      localStringBuilder.append(paramString);
      paramString = localfq.a(localContext, "TencentUnipayPayIdKey", localStringBuilder.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      APLog.e("readPayId", paramString.toString());
    }
    return "";
  }
  
  public String b(String paramString)
  {
    fq localfq = new fq();
    try
    {
      Object localObject1 = this.c;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(ed.b().n().a.offerId);
      ((StringBuilder)localObject2).append("_authKey_");
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = localfq.a((Context)localObject1, "TencentUnipayPayIdKey", ((StringBuilder)localObject2).toString());
      localObject2 = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ed.b().n().a.offerId);
      localStringBuilder.append("_authKeyLen_");
      localStringBuilder.append(paramString);
      paramString = localfq.a((Context)localObject2, "TencentUnipayPayIdKey", localStringBuilder.toString());
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramString)))
      {
        paramString = fx.b((String)localObject1, a()).substring(0, Integer.parseInt(paramString));
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      APLog.e("readAuthKey", paramString.toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.fz
 * JD-Core Version:    0.7.0.1
 */