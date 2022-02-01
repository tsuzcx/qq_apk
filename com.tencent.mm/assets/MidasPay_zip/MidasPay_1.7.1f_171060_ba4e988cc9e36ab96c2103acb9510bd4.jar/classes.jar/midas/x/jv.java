package midas.x;

import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class jv
  extends jr
{
  private final kf a;
  private final ThreadLocal<String> b = new ThreadLocal()
  {
    protected String a()
    {
      return "";
    }
  };
  
  jv(kf paramkf)
  {
    this.a = paramkf;
  }
  
  public final void a(jn paramjn)
  {
    super.a(paramjn);
    if (paramjn == null)
    {
      jh.a("APMidasHostHeader", "Set host header, request null");
      return;
    }
    if (!(paramjn instanceof jy))
    {
      jh.a("APMidasHostHeader", "Set host header, not midas request");
      return;
    }
    if (this.a == null)
    {
      jh.a("APMidasHostHeader", "Set host header, net manager null");
      return;
    }
    if (!((jy)paramjn).u)
    {
      jh.c("APMidasHostHeader", "Set host header, request set no need midas header!");
      return;
    }
    Object localObject = this.a.g();
    if (localObject == null)
    {
      jh.a("APMidasHostHeader", "Set host header, common info getter null");
      return;
    }
    localObject = ((kk)localObject).b();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      jh.a("APMidasHostHeader", "Set host header, got empty host");
      return;
    }
    if (ku.b((String)localObject))
    {
      paramjn = new StringBuilder();
      paramjn.append("Set host header, host is ip address = ");
      paramjn.append((String)localObject);
      jh.a("APMidasHostHeader", paramjn.toString());
      return;
    }
    if (!Patterns.WEB_URL.matcher((CharSequence)localObject).matches())
    {
      paramjn = new StringBuilder();
      paramjn.append("Set host header, host not web url = ");
      paramjn.append((String)localObject);
      jh.a("APMidasHostHeader", paramjn.toString());
      return;
    }
    paramjn.b("Host", (String)localObject);
    this.b.set(localObject);
    paramjn = new StringBuilder();
    paramjn.append("Set host = ");
    paramjn.append((String)localObject);
    jh.b("APMidasHostHeader", paramjn.toString());
  }
  
  public final void a(jn paramjn, jo paramjo)
  {
    super.a(paramjn, paramjo);
    paramjo = (String)this.b.get();
    if (!TextUtils.isEmpty(paramjo))
    {
      paramjn.d("Host", paramjo);
      this.b.set("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.jv
 * JD-Core Version:    0.7.0.1
 */