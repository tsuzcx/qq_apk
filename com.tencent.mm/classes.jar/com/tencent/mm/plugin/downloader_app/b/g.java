package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.downloader.c.a.a.b;
import java.util.LinkedList;

public final class g
{
  public static g.a laW;
  static f laX;
  
  public static void a(LinkedList<String> paramLinkedList, g.a parama)
  {
    AppMethodBeat.i(136143);
    b.a locala = new b.a();
    com.tencent.mm.plugin.downloader.c.a.a.a locala1 = new com.tencent.mm.plugin.downloader.c.a.a.a();
    locala1.kVJ = paramLinkedList;
    locala1.kVL = true;
    locala.fsX = locala1;
    locala.fsY = new b();
    locala.uri = "/cgi-bin/mmgame-bin/batchgetappdownloadinfo";
    locala.funcId = 2560;
    laW = parama;
    w.a(locala.ado(), new g.1());
    AppMethodBeat.o(136143);
  }
  
  public static f bjR()
  {
    AppMethodBeat.i(136142);
    if (laX == null)
    {
      localObject = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.commlib.a.a.class)).PN("pb_appinfo");
      if (localObject != null) {
        laX = new f((byte[])localObject);
      }
    }
    Object localObject = laX;
    AppMethodBeat.o(136142);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.g
 * JD-Core Version:    0.7.0.1
 */