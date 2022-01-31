package com.tencent.mm.plugin.downloader_app.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader_app.b.c;
import com.tencent.mm.plugin.downloader_app.b.i;

final class DownloadMainUI$6
  implements Runnable
{
  DownloadMainUI$6(DownloadMainUI paramDownloadMainUI, a parama, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(136231);
    if (this.kYh != null)
    {
      if (this.kYh.field_status != 1)
      {
        if (this.kYh.field_status == 2)
        {
          c.a(this.lci, this.laI, false, null);
          AppMethodBeat.o(136231);
          return;
        }
        c.a(this.lci, this.laI, true);
        AppMethodBeat.o(136231);
      }
    }
    else {
      c.a(this.lci, this.laI, true);
    }
    AppMethodBeat.o(136231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.6
 * JD-Core Version:    0.7.0.1
 */