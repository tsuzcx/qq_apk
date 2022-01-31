package com.tencent.mm.plugin.downloader_app.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.downloader_app.b.g;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedList;

final class DownloadMainUI$4
  implements Runnable
{
  DownloadMainUI$4(DownloadMainUI paramDownloadMainUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(136229);
    DownloadMainUI.a(this.lci, g.bjR());
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136227);
        DownloadMainUI.a(DownloadMainUI.4.this.lci, DownloadMainUI.c(DownloadMainUI.4.this.lci), false);
        AppMethodBeat.o(136227);
      }
    });
    boolean bool = DownloadMainUI.a(this.lci, DownloadMainUI.d(this.lci));
    if ((DownloadMainUI.e(this.lci)) || (bool))
    {
      this.lci.c(j.bjU(), null);
      AppMethodBeat.o(136229);
      return;
    }
    LinkedList localLinkedList = j.bjU();
    if (!localLinkedList.contains(DownloadMainUI.d(this.lci))) {
      localLinkedList.add(DownloadMainUI.d(this.lci));
    }
    this.lci.c(localLinkedList, DownloadMainUI.d(this.lci));
    l.q(new DownloadMainUI.4.2(this));
    AppMethodBeat.o(136229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.4
 * JD-Core Version:    0.7.0.1
 */