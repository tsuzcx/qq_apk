package com.tencent.mm.plugin.appbrand.game.d;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.game.d.f.b;
import com.tencent.luggage.game.d.f.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.w;

final class a$2
  extends w
{
  a$2(a parama, f.b paramb) {}
  
  private s Bz(String paramString)
  {
    AppMethodBeat.i(143136);
    if (this.bAw.bO(paramString))
    {
      paramString = this.bAw.bR(f.b.bAN);
      paramString = new s(paramString.mimeType, paramString.charset, paramString.bAO);
      AppMethodBeat.o(143136);
      return paramString;
    }
    AppMethodBeat.o(143136);
    return null;
  }
  
  public final s a(WebView paramWebView, r paramr)
  {
    AppMethodBeat.i(143135);
    paramWebView = Bz(paramr.getUrl().toString());
    AppMethodBeat.o(143135);
    return paramWebView;
  }
  
  public final s a(WebView paramWebView, r paramr, Bundle paramBundle)
  {
    AppMethodBeat.i(143134);
    paramWebView = Bz(paramr.getUrl().toString());
    AppMethodBeat.o(143134);
    return paramWebView;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(143137);
    this.bAw.uG();
    AppMethodBeat.o(143137);
  }
  
  public final s c(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(143133);
    paramWebView = Bz(paramString);
    AppMethodBeat.o(143133);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.a.2
 * JD-Core Version:    0.7.0.1
 */