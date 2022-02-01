package com.tencent.mm.plugin.fts.ui.webview;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;

public final class b
  extends ac
{
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(176929);
    ad.i("MicroMsg.FTS.PardusWebViewClient", "shouldOverrideUrlLoading %s", new Object[] { paramString });
    boolean bool = super.a(paramWebView, paramString);
    AppMethodBeat.o(176929);
    return bool;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(176928);
    ad.i("MicroMsg.FTS.PardusWebViewClient", "onPageFinished %s  %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString);
    AppMethodBeat.o(176928);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(176927);
    ad.i("MicroMsg.FTS.PardusWebViewClient", "onPageStarted %s %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(176927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.webview.b
 * JD-Core Version:    0.7.0.1
 */