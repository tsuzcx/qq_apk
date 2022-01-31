package com.tencent.mm.plugin.downloader_app.detail;

import android.os.Bundle;
import com.tencent.luggage.e.e;
import com.tencent.luggage.e.f;
import com.tencent.luggage.e.j;
import com.tencent.luggage.e.k;
import com.tencent.mm.sdk.platformtools.y;

final class DownloadDetailUI$2
  implements j
{
  DownloadDetailUI$2(DownloadDetailUI paramDownloadDetailUI) {}
  
  public final e f(String paramString, Bundle paramBundle)
  {
    boolean bool = true;
    k localk = d.cU(this.iRw);
    if (localk == null) {}
    for (;;)
    {
      y.i("MicroMsg.DownloadDetailUI", "preloadDetail is null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (localk == null) {
        d.zV(paramString);
      }
      return new c(DownloadDetailUI.a(this.iRw).bix, localk, paramBundle);
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.DownloadDetailUI.2
 * JD-Core Version:    0.7.0.1
 */