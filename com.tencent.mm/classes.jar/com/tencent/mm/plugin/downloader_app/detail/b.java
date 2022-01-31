package com.tencent.mm.plugin.downloader_app.detail;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.xweb.WebView;

public class b
  extends e
{
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(136042);
    super.b(paramWebView, paramString);
    AppMethodBeat.o(136042);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(136041);
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(136041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.b
 * JD-Core Version:    0.7.0.1
 */