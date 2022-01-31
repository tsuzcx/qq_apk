package com.tencent.mm.plugin.downloader_app.ui;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.downloader_app.b.g;
import com.tencent.mm.plugin.downloader_app.b.g.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class DownloadMainUI$8
  implements g.a
{
  DownloadMainUI$8(DownloadMainUI paramDownloadMainUI, String paramString) {}
  
  public final void gu(boolean paramBoolean)
  {
    AppMethodBeat.i(136236);
    l.q(new DownloadMainUI.8.1(this));
    if (paramBoolean)
    {
      DownloadMainUI.a(this.lci, g.bjR());
      al.d(new DownloadMainUI.8.2(this));
      AppMethodBeat.o(136236);
      return;
    }
    if (!bo.isNullOrNil(this.lck)) {
      h.b(this.lci, "", this.lci.getResources().getString(2131298089), true);
    }
    AppMethodBeat.o(136236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.8
 * JD-Core Version:    0.7.0.1
 */