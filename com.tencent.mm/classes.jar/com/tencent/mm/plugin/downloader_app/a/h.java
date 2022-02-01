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
  public static a ohY;
  static g ohZ;
  
  public static void a(LinkedList<String> paramLinkedList, a parama)
  {
    AppMethodBeat.i(8904);
    b.a locala = new b.a();
    com.tencent.mm.plugin.downloader.c.a.a.a locala1 = new com.tencent.mm.plugin.downloader.c.a.a.a();
    locala1.ocv = paramLinkedList;
    locala1.ocx = true;
    locala.gUU = locala1;
    locala.gUV = new com.tencent.mm.plugin.downloader.c.a.a.b();
    locala.uri = "/cgi-bin/mmgame-bin/batchgetappdownloadinfo";
    locala.funcId = 2560;
    ohY = parama;
    x.a(locala.atI(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(8902);
        ad.i("MicroMsg.PbAppInfoManager", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          h.ohZ = new g((com.tencent.mm.plugin.downloader.c.a.a.b)paramAnonymousb.gUT.gUX);
          if (h.ohY != null) {
            h.ohY.jg(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(8902);
          return 0;
          if (h.ohY != null) {
            h.ohY.jg(false);
          }
        }
      }
    });
    AppMethodBeat.o(8904);
  }
  
  public static g bRe()
  {
    AppMethodBeat.i(8903);
    if (ohZ == null)
    {
      localObject = ((com.tencent.mm.plugin.game.commlib.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.commlib.a.a.class)).abW("pb_appinfo");
      if (localObject != null) {
        ohZ = new g((byte[])localObject);
      }
    }
    Object localObject = ohZ;
    AppMethodBeat.o(8903);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract void jg(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.h
 * JD-Core Version:    0.7.0.1
 */