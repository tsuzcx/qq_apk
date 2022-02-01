package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.downloader.c.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class h
{
  public static a ump;
  static g umq;
  
  public static void a(LinkedList<String> paramLinkedList, a parama)
  {
    AppMethodBeat.i(8904);
    d.a locala = new d.a();
    com.tencent.mm.plugin.downloader.c.a.a.a locala1 = new com.tencent.mm.plugin.downloader.c.a.a.a();
    locala1.ueK = paramLinkedList;
    locala1.ueM = true;
    locala.lBU = locala1;
    locala.lBV = new b();
    locala.uri = "/cgi-bin/mmgame-bin/batchgetappdownloadinfo";
    locala.funcId = 2560;
    ump = parama;
    aa.a(locala.bgN(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(8902);
        Log.i("MicroMsg.PbAppInfoManager", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          h.umq = new g((b)d.c.b(paramAnonymousd.lBS));
          if (h.ump != null) {
            h.ump.mi(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(8902);
          return 0;
          if (h.ump != null) {
            h.ump.mi(false);
          }
        }
      }
    });
    AppMethodBeat.o(8904);
  }
  
  public static g cQG()
  {
    AppMethodBeat.i(8903);
    if (umq == null)
    {
      localObject = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.commlib.a.a.class)).aIX("pb_appinfo");
      if (localObject != null) {
        umq = new g((byte[])localObject);
      }
    }
    Object localObject = umq;
    AppMethodBeat.o(8903);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract void mi(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.h
 * JD-Core Version:    0.7.0.1
 */