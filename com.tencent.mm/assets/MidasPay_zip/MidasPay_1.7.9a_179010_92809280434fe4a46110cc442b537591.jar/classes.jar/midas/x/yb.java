package midas.x;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class yb
  implements cb
{
  public final zb a;
  
  public yb(zb paramzb)
  {
    this.a = paramzb;
  }
  
  public static boolean a(Context paramContext)
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
  
  public gb a(fb paramfb, gb paramgb)
  {
    paramfb = this.a;
    if (paramfb == null) {
      return paramgb;
    }
    paramfb = paramfb.b();
    if (paramfb == null) {
      return paramgb;
    }
    if (!a(paramfb))
    {
      paramfb = rb.b(20006, "网络未连接，请检查");
      paramfb.e = true;
      return paramfb;
    }
    return paramgb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.yb
 * JD-Core Version:    0.7.0.1
 */