package midas.x;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class lp
  implements kv
{
  private final lq a;
  
  lp(lq paramlq)
  {
    this.a = paramlq;
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
  
  public kz a(ky paramky, kz paramkz)
  {
    if (this.a == null) {
      return paramkz;
    }
    paramky = this.a.f();
    if (paramky == null) {
      return paramkz;
    }
    if (!a(paramky))
    {
      paramky = lk.a(20006, "网络未连接，请检查");
      paramky.d = true;
      return paramky;
    }
    return paramkz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.lp
 * JD-Core Version:    0.7.0.1
 */