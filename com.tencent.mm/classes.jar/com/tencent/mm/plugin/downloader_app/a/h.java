package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class h
{
  public static a ppg;
  static g pph;
  
  public static void a(LinkedList<String> paramLinkedList, a parama)
  {
    AppMethodBeat.i(8904);
    b.a locala = new b.a();
    com.tencent.mm.plugin.downloader.c.a.a.a locala1 = new com.tencent.mm.plugin.downloader.c.a.a.a();
    locala1.pjy = paramLinkedList;
    locala1.pjA = true;
    locala.hNM = locala1;
    locala.hNN = new com.tencent.mm.plugin.downloader.c.a.a.b();
    locala.uri = "/cgi-bin/mmgame-bin/batchgetappdownloadinfo";
    locala.funcId = 2560;
    ppg = parama;
    x.a(locala.aDC(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(8902);
        ad.i("MicroMsg.PbAppInfoManager", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          h.pph = new g((com.tencent.mm.plugin.downloader.c.a.a.b)paramAnonymousb.hNL.hNQ);
          if (h.ppg != null) {
            h.ppg.jU(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(8902);
          return 0;
          if (h.ppg != null) {
            h.ppg.jU(false);
          }
        }
      }
    });
    AppMethodBeat.o(8904);
  }
  
  public static g ccX()
  {
    AppMethodBeat.i(8903);
    if (pph == null)
    {
      localObject = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).all("pb_appinfo");
      if (localObject != null) {
        pph = new g((byte[])localObject);
      }
    }
    Object localObject = pph;
    AppMethodBeat.o(8903);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract void jU(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.h
 * JD-Core Version:    0.7.0.1
 */