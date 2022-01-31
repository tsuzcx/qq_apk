package com.tencent.mm.plugin.appbrand.page;

import android.webkit.DownloadListener;
import com.tencent.mm.sdk.platformtools.y;

final class w$2
  implements DownloadListener
{
  w$2(w paramw) {}
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    y.i("MicroMsg.AppBrandWebView", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", new Object[] { paramString1, paramString4, paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.w.2
 * JD-Core Version:    0.7.0.1
 */