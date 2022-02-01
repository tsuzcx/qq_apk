package midas.x;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ke
  implements jk
{
  private final kf a;
  
  ke(kf paramkf)
  {
    this.a = paramkf;
  }
  
  private static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext != null) {
      return paramContext.isAvailable();
    }
    return false;
  }
  
  public jo a(jn paramjn, jo paramjo)
  {
    if (this.a == null) {
      return paramjo;
    }
    paramjn = this.a.f();
    if (paramjn == null) {
      return paramjo;
    }
    if (!a(paramjn))
    {
      paramjn = jz.a(20006, "网络未连接，请检查");
      paramjn.d = true;
      return paramjn;
    }
    return paramjo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ke
 * JD-Core Version:    0.7.0.1
 */