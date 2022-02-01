package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.plugin.downloader.b.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class h
{
  public static a xsB;
  static g xsC;
  
  public static void a(LinkedList<String> paramLinkedList, a parama)
  {
    AppMethodBeat.i(8904);
    c.a locala = new c.a();
    com.tencent.mm.plugin.downloader.b.a.a.a locala1 = new com.tencent.mm.plugin.downloader.b.a.a.a();
    locala1.xkL = paramLinkedList;
    locala1.xkN = true;
    locala.otE = locala1;
    locala.otF = new b();
    locala.uri = "/cgi-bin/mmgame-bin/batchgetappdownloadinfo";
    locala.funcId = 2560;
    xsB = parama;
    z.a(locala.bEF(), new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc, p paramAnonymousp)
      {
        AppMethodBeat.i(8902);
        Log.i("MicroMsg.PbAppInfoManager", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          h.xsC = new g((b)c.c.b(paramAnonymousc.otC));
          if (h.xsB != null) {
            h.xsB.nE(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(8902);
          return 0;
          if (h.xsB != null) {
            h.xsB.nE(false);
          }
        }
      }
    });
    AppMethodBeat.o(8904);
  }
  
  public static g duZ()
  {
    AppMethodBeat.i(8903);
    if (xsC == null)
    {
      localObject = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.commlib.a.a.class)).aFI("pb_appinfo");
      if (localObject != null) {
        xsC = new g((byte[])localObject);
      }
    }
    Object localObject = xsC;
    AppMethodBeat.o(8903);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract void nE(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.h
 * JD-Core Version:    0.7.0.1
 */