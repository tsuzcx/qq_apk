package midas.x;

import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class lg
  extends lc
{
  private final lq a;
  private final ThreadLocal<String> b = new ThreadLocal()
  {
    protected String a()
    {
      return "";
    }
  };
  
  lg(lq paramlq)
  {
    this.a = paramlq;
  }
  
  public final void a(ky paramky)
  {
    super.a(paramky);
    if (paramky == null)
    {
      ks.a("APMidasHostHeader", "Set host header, request null");
      return;
    }
    if (!(paramky instanceof lj))
    {
      ks.a("APMidasHostHeader", "Set host header, not midas request");
      return;
    }
    if (this.a == null)
    {
      ks.a("APMidasHostHeader", "Set host header, net manager null");
      return;
    }
    if (!((lj)paramky).u)
    {
      ks.c("APMidasHostHeader", "Set host header, request set no need midas header!");
      return;
    }
    Object localObject = this.a.g();
    if (localObject == null)
    {
      ks.a("APMidasHostHeader", "Set host header, common info getter null");
      return;
    }
    localObject = ((lv)localObject).b();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ks.a("APMidasHostHeader", "Set host header, got empty host");
      return;
    }
    if (mf.b((String)localObject))
    {
      paramky = new StringBuilder();
      paramky.append("Set host header, host is ip address = ");
      paramky.append((String)localObject);
      ks.a("APMidasHostHeader", paramky.toString());
      return;
    }
    if (!Patterns.WEB_URL.matcher((CharSequence)localObject).matches())
    {
      paramky = new StringBuilder();
      paramky.append("Set host header, host not web url = ");
      paramky.append((String)localObject);
      ks.a("APMidasHostHeader", paramky.toString());
      return;
    }
    paramky.b("Host", (String)localObject);
    this.b.set(localObject);
    paramky = new StringBuilder();
    paramky.append("Set host = ");
    paramky.append((String)localObject);
    ks.b("APMidasHostHeader", paramky.toString());
  }
  
  public final void a(ky paramky, kz paramkz)
  {
    super.a(paramky, paramkz);
    paramkz = (String)this.b.get();
    if (!TextUtils.isEmpty(paramkz))
    {
      paramky.d("Host", paramkz);
      this.b.set("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.lg
 * JD-Core Version:    0.7.0.1
 */