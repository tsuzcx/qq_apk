package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class h
{
  public static a oLy;
  static g oLz;
  
  public static void a(LinkedList<String> paramLinkedList, a parama)
  {
    AppMethodBeat.i(8904);
    b.a locala = new b.a();
    com.tencent.mm.plugin.downloader.c.a.a.a locala1 = new com.tencent.mm.plugin.downloader.c.a.a.a();
    locala1.oFU = paramLinkedList;
    locala1.oFW = true;
    locala.hvt = locala1;
    locala.hvu = new com.tencent.mm.plugin.downloader.c.a.a.b();
    locala.uri = "/cgi-bin/mmgame-bin/batchgetappdownloadinfo";
    locala.funcId = 2560;
    oLy = parama;
    x.a(locala.aAz(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(8902);
        ac.i("MicroMsg.PbAppInfoManager", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          h.oLz = new g((com.tencent.mm.plugin.downloader.c.a.a.b)paramAnonymousb.hvs.hvw);
          if (h.oLy != null) {
            h.oLy.jJ(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(8902);
          return 0;
          if (h.oLy != null) {
            h.oLy.jJ(false);
          }
        }
      }
    });
    AppMethodBeat.o(8904);
  }
  
  public static g bYt()
  {
    AppMethodBeat.i(8903);
    if (oLz == null)
    {
      localObject = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).agO("pb_appinfo");
      if (localObject != null) {
        oLz = new g((byte[])localObject);
      }
    }
    Object localObject = oLz;
    AppMethodBeat.o(8903);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract void jJ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.h
 * JD-Core Version:    0.7.0.1
 */