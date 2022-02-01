package com.tencent.mm.plugin.box.webview;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ag;

public final class c
  extends ag
{
  private rx vAe;
  private e vAm;
  
  public c(rx paramrx, e parame)
  {
    this.vAe = paramrx;
    this.vAm = parame;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(76354);
    Log.i("MicroMsg.Box.BoxWebChromeClient", "shouldOverrideUrlLoading %s", new Object[] { paramString });
    boolean bool = super.a(paramWebView, paramString);
    AppMethodBeat.o(76354);
    return bool;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(76353);
    Log.i("MicroMsg.Box.BoxWebChromeClient", "onPageFinished %s  %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString);
    AppMethodBeat.o(76353);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(76352);
    Log.i("MicroMsg.Box.BoxWebChromeClient", "onPageStarted %s %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(76352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.webview.c
 * JD-Core Version:    0.7.0.1
 */