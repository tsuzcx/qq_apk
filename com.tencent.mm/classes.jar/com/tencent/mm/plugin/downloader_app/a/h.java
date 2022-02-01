package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.downloader.c.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class h
{
  public static a qLd;
  static g qLe;
  
  public static void a(LinkedList<String> paramLinkedList, a parama)
  {
    AppMethodBeat.i(8904);
    d.a locala = new d.a();
    com.tencent.mm.plugin.downloader.c.a.a.a locala1 = new com.tencent.mm.plugin.downloader.c.a.a.a();
    locala1.qFI = paramLinkedList;
    locala1.qFK = true;
    locala.iLN = locala1;
    locala.iLO = new b();
    locala.uri = "/cgi-bin/mmgame-bin/batchgetappdownloadinfo";
    locala.funcId = 2560;
    qLd = parama;
    aa.a(locala.aXF(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(8902);
        Log.i("MicroMsg.PbAppInfoManager", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          h.qLe = new g((b)paramAnonymousd.iLL.iLR);
          if (h.qLd != null) {
            h.qLd.kW(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(8902);
          return 0;
          if (h.qLd != null) {
            h.qLd.kW(false);
          }
        }
      }
    });
    AppMethodBeat.o(8904);
  }
  
  public static g cCc()
  {
    AppMethodBeat.i(8903);
    if (qLe == null)
    {
      localObject = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.commlib.a.a.class)).azn("pb_appinfo");
      if (localObject != null) {
        qLe = new g((byte[])localObject);
      }
    }
    Object localObject = qLe;
    AppMethodBeat.o(8903);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract void kW(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.h
 * JD-Core Version:    0.7.0.1
 */