package com.tencent.mm.plugin.downloader_app.detail;

import android.os.Bundle;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.f;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class DownloadDetailUI$2
  implements j
{
  DownloadDetailUI$2(DownloadDetailUI paramDownloadDetailUI) {}
  
  public final e j(String paramString, Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(136032);
    k localk = d.dH(this.laf);
    if (localk == null) {}
    for (;;)
    {
      ab.i("MicroMsg.DownloadDetailUI", "preloadDetail is null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (localk == null) {
        d.JS(paramString);
      }
      paramString = new c(DownloadDetailUI.a(this.laf).byV, localk, paramBundle);
      AppMethodBeat.o(136032);
      return paramString;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.DownloadDetailUI.2
 * JD-Core Version:    0.7.0.1
 */