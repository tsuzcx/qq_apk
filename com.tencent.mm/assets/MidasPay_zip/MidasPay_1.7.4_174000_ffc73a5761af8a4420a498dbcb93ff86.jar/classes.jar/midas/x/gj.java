package midas.x;

import android.content.Context;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.tencent.midas.comm.APLog;

public class gj
{
  private static volatile gj a;
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
  
  public static gj a(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          a = new gj();
          a.c = paramContext.getApplicationContext();
        }
      }
      finally {}
    }
    return a;
  }
  
  public String a(String paramString)
  {
    fz localfz = new fz();
    try
    {
      Context localContext = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(em.b().n().a.offerId);
      localStringBuilder.append("_payId_");
      localStringBuilder.append(paramString);
      paramString = localfz.a(localContext, "TencentUnipayPayIdKey", localStringBuilder.toString());
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
    fz localfz = new fz();
    try
    {
      Object localObject1 = this.c;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(em.b().n().a.offerId);
      ((StringBuilder)localObject2).append("_authKey_");
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = localfz.a((Context)localObject1, "TencentUnipayPayIdKey", ((StringBuilder)localObject2).toString());
      localObject2 = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(em.b().n().a.offerId);
      localStringBuilder.append("_authKeyLen_");
      localStringBuilder.append(paramString);
      paramString = localfz.a((Context)localObject2, "TencentUnipayPayIdKey", localStringBuilder.toString());
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramString)))
      {
        paramString = gh.b((String)localObject1, a()).substring(0, Integer.parseInt(paramString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.gj
 * JD-Core Version:    0.7.0.1
 */