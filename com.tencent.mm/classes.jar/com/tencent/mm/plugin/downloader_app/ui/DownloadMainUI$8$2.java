package com.tencent.mm.plugin.downloader_app.ui;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.downloader_app.b.f;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class DownloadMainUI$8$2
  implements Runnable
{
  DownloadMainUI$8$2(DownloadMainUI.8 param8) {}
  
  public final void run()
  {
    AppMethodBeat.i(136235);
    if (!bo.isNullOrNil(this.lcl.lck))
    {
      i locali = DownloadMainUI.c(this.lcl.lci).Kb(this.lcl.lck);
      if (locali == null) {
        break label96;
      }
      j.JP(this.lcl.lck);
      l.postDelayed(new DownloadMainUI.8.2.1(this, locali), 200L);
    }
    for (;;)
    {
      DownloadMainUI.a(this.lcl.lci, DownloadMainUI.c(this.lcl.lci), true);
      AppMethodBeat.o(136235);
      return;
      label96:
      h.b(this.lcl.lci, "", this.lcl.lci.getResources().getString(2131301858), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.8.2
 * JD-Core Version:    0.7.0.1
 */