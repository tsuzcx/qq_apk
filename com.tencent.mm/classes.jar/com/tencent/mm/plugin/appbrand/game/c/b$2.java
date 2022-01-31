package com.tencent.mm.plugin.appbrand.game.c;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import java.util.Iterator;
import java.util.LinkedList;

final class b$2
  extends p
{
  b$2(b paramb) {}
  
  private static m tw(String paramString)
  {
    if ("wagame://WAGameVConsole.html".equals(paramString)) {
      return WxaCommLibRuntimeReader.qY("WAGameVConsole.html");
    }
    return null;
  }
  
  public final m a(WebView paramWebView, l paraml)
  {
    return tw(paraml.getUrl().toString());
  }
  
  public final m a(WebView paramWebView, l paraml, Bundle paramBundle)
  {
    return tw(paraml.getUrl().toString());
  }
  
  public final void a(WebView paramWebView, String paramString)
  {
    b.a(this.gbg);
    if ((b.b(this.gbg) != null) && (!b.b(this.gbg).isEmpty()))
    {
      paramWebView = b.b(this.gbg).iterator();
      while (paramWebView.hasNext())
      {
        paramString = (String)paramWebView.next();
        b.a(this.gbg, paramString);
      }
    }
  }
  
  public final m c(WebView paramWebView, String paramString)
  {
    return tw(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.b.2
 * JD-Core Version:    0.7.0.1
 */