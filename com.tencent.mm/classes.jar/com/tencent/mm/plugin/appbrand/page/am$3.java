package com.tencent.mm.plugin.appbrand.page;

import android.webkit.DownloadListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class am$3
  implements DownloadListener
{
  am$3(am paramam) {}
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(47913);
    Log.i("MicroMsg.AppBrandWebView", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", new Object[] { paramString1, paramString4, paramString2 });
    AppMethodBeat.o(47913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.am.3
 * JD-Core Version:    0.7.0.1
 */