package midas.x;

import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class nb
  extends jb
{
  public final zb a;
  public final ThreadLocal<String> b = new a();
  
  public nb(zb paramzb)
  {
    this.a = paramzb;
  }
  
  public final void a(fb paramfb)
  {
    super.a(paramfb);
    if (paramfb == null)
    {
      ya.b("APMidasHostHeader", "Set host header, request null");
      return;
    }
    if (!(paramfb instanceof qb))
    {
      ya.b("APMidasHostHeader", "Set host header, not midas request");
      return;
    }
    Object localObject = this.a;
    if (localObject == null)
    {
      ya.b("APMidasHostHeader", "Set host header, net manager null");
      return;
    }
    if (!((qb)paramfb).y)
    {
      ya.c("APMidasHostHeader", "Set host header, request set no need midas header!");
      return;
    }
    localObject = ((zb)localObject).d();
    if (localObject == null)
    {
      ya.b("APMidasHostHeader", "Set host header, common info getter null");
      return;
    }
    localObject = ((ec)localObject).a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ya.b("APMidasHostHeader", "Set host header, got empty host");
      return;
    }
    if (oc.a((String)localObject))
    {
      paramfb = new StringBuilder();
      paramfb.append("Set host header, host is ip address = ");
      paramfb.append((String)localObject);
      ya.b("APMidasHostHeader", paramfb.toString());
      return;
    }
    if (!Patterns.WEB_URL.matcher((CharSequence)localObject).matches())
    {
      paramfb = new StringBuilder();
      paramfb.append("Set host header, host not web url = ");
      paramfb.append((String)localObject);
      ya.b("APMidasHostHeader", paramfb.toString());
      return;
    }
    paramfb.a("Host", (String)localObject);
    this.b.set(localObject);
    paramfb = new StringBuilder();
    paramfb.append("Set host = ");
    paramfb.append((String)localObject);
    ya.a("APMidasHostHeader", paramfb.toString());
  }
  
  public final void a(fb paramfb, gb paramgb)
  {
    super.a(paramfb, paramgb);
    paramgb = (String)this.b.get();
    if (!TextUtils.isEmpty(paramgb))
    {
      paramfb.d("Host", paramgb);
      this.b.set("");
    }
  }
  
  public class a
    extends ThreadLocal<String>
  {
    public a() {}
    
    public String initialValue()
    {
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.nb
 * JD-Core Version:    0.7.0.1
 */