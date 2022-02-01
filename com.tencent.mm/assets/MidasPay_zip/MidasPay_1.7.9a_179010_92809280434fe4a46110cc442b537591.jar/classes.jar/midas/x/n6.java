package midas.x;

import android.content.Context;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.tencent.midas.comm.APLog;

public class n6
{
  public static volatile n6 b;
  public Context a;
  
  public static n6 a(Context paramContext)
  {
    if (b == null) {
      try
      {
        if (b == null)
        {
          b = new n6();
          b.a = paramContext.getApplicationContext();
        }
      }
      finally {}
    }
    return b;
  }
  
  public final String a()
  {
    b.getClass();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("1oOx");
    localStringBuffer.append("sBbJ");
    localStringBuffer.append("caUd");
    localStringBuffer.append("MbPy");
    return localStringBuffer.toString();
  }
  
  public String a(String paramString)
  {
    d6 locald6 = new d6();
    try
    {
      Object localObject1 = this.a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(p4.p().e().b.offerId);
      ((StringBuilder)localObject2).append("_authKey_");
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = locald6.a((Context)localObject1, "TencentUnipayPayIdKey", ((StringBuilder)localObject2).toString());
      localObject2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(p4.p().e().b.offerId);
      localStringBuilder.append("_authKeyLen_");
      localStringBuilder.append(paramString);
      paramString = locald6.a((Context)localObject2, "TencentUnipayPayIdKey", localStringBuilder.toString());
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramString)))
      {
        paramString = l6.a((String)localObject1, a()).substring(0, Integer.parseInt(paramString));
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      APLog.e("readAuthKey", paramString.toString());
    }
    return "";
  }
  
  public String b(String paramString)
  {
    d6 locald6 = new d6();
    try
    {
      Context localContext = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(p4.p().e().b.offerId);
      localStringBuilder.append("_payId_");
      localStringBuilder.append(paramString);
      paramString = locald6.a(localContext, "TencentUnipayPayIdKey", localStringBuilder.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      APLog.e("readPayId", paramString.toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.n6
 * JD-Core Version:    0.7.0.1
 */