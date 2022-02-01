package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class h
{
  public static a pvM;
  static g pvN;
  
  public static void a(LinkedList<String> paramLinkedList, a parama)
  {
    AppMethodBeat.i(8904);
    b.a locala = new b.a();
    com.tencent.mm.plugin.downloader.c.a.a.a locala1 = new com.tencent.mm.plugin.downloader.c.a.a.a();
    locala1.pqd = paramLinkedList;
    locala1.pqf = true;
    locala.hQF = locala1;
    locala.hQG = new com.tencent.mm.plugin.downloader.c.a.a.b();
    locala.uri = "/cgi-bin/mmgame-bin/batchgetappdownloadinfo";
    locala.funcId = 2560;
    pvM = parama;
    x.a(locala.aDS(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(8902);
        ae.i("MicroMsg.PbAppInfoManager", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          h.pvN = new g((com.tencent.mm.plugin.downloader.c.a.a.b)paramAnonymousb.hQE.hQJ);
          if (h.pvM != null) {
            h.pvM.jT(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(8902);
          return 0;
          if (h.pvM != null) {
            h.pvM.jT(false);
          }
        }
      }
    });
    AppMethodBeat.o(8904);
  }
  
  public static g cem()
  {
    AppMethodBeat.i(8903);
    if (pvN == null)
    {
      localObject = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).amj("pb_appinfo");
      if (localObject != null) {
        pvN = new g((byte[])localObject);
      }
    }
    Object localObject = pvN;
    AppMethodBeat.o(8903);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract void jT(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.h
 * JD-Core Version:    0.7.0.1
 */