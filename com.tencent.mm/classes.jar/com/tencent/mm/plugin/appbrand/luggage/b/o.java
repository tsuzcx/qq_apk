package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.tencent.luggage.bridge.impl.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.e.a.a;
import com.tencent.mm.plugin.appbrand.e.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.t;

public final class o
  extends a
  implements com.tencent.mm.plugin.appbrand.e.b
{
  private final com.tencent.mm.plugin.appbrand.i gRG;
  
  public o(com.tencent.mm.plugin.appbrand.i parami)
  {
    this.gRG = parami;
  }
  
  public final void a(String paramString, a.a parama)
  {
    AppMethodBeat.i(87001);
    byte[] arrayOfByte = new byte[0];
    Object localObject = arrayOfByte;
    if (match(paramString))
    {
      localObject = Uri.parse(paramString);
      paramString = ((Uri)localObject).getQueryParameter("appId");
      String str = ((Uri)localObject).getQueryParameter("path");
      localObject = arrayOfByte;
      if (paramString != null)
      {
        localObject = arrayOfByte;
        if (paramString.length() != 0)
        {
          localObject = arrayOfByte;
          if (str != null)
          {
            localObject = arrayOfByte;
            if (str.length() != 0)
            {
              paramString = ax.f(this.gRG, Uri.decode(str));
              localObject = com.tencent.luggage.g.i.g(paramString);
              com.tencent.luggage.g.i.b(paramString);
            }
          }
        }
      }
    }
    if (parama != null) {
      parama.P((byte[])localObject);
    }
    AppMethodBeat.o(87001);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(86999);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(86999);
      return false;
    }
    if ((!paramString.startsWith("wxapkg://")) && (!paramString.startsWith("http://")) && (!paramString.startsWith("https://")) && (!paramString.startsWith("wxfile://")) && (!paramString.contains("://")))
    {
      AppMethodBeat.o(86999);
      return true;
    }
    AppMethodBeat.o(86999);
    return false;
  }
  
  public final Bitmap b(String paramString, Rect paramRect, a.c paramc)
  {
    AppMethodBeat.i(86998);
    if (!match(paramString))
    {
      AppMethodBeat.o(86998);
      return null;
    }
    paramc = Uri.parse(paramString);
    paramString = paramc.getQueryParameter("appId");
    paramc = paramc.getQueryParameter("path");
    if ((paramString == null) || (paramString.length() == 0) || (paramc == null) || (paramc.length() == 0))
    {
      AppMethodBeat.o(86998);
      return null;
    }
    paramc = t.j(this.gRG, Uri.decode(paramc));
    paramString = paramc;
    if (paramRect != null) {
      paramString = new com.tencent.mm.plugin.appbrand.luggage.a.b(paramRect.left, paramRect.top, paramRect.width(), paramRect.height()).x(paramc);
    }
    AppMethodBeat.o(86998);
    return paramString;
  }
  
  public final String b(c paramc, String paramString)
  {
    AppMethodBeat.i(87000);
    if (!a(paramc, paramString))
    {
      AppMethodBeat.o(87000);
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wxapkg://");
    localStringBuilder.append("icon?");
    localStringBuilder.append("appId=");
    localStringBuilder.append(paramc.getAppId());
    localStringBuilder.append("&");
    localStringBuilder.append("path=");
    localStringBuilder.append(Uri.encode(paramString));
    paramc = localStringBuilder.toString();
    AppMethodBeat.o(87000);
    return paramc;
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(86997);
    if ((paramString != null) && (paramString.startsWith("wxapkg://")))
    {
      AppMethodBeat.o(86997);
      return true;
    }
    AppMethodBeat.o(86997);
    return false;
  }
  
  public final String tX()
  {
    return "WxaPkgImageReader";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.o
 * JD-Core Version:    0.7.0.1
 */