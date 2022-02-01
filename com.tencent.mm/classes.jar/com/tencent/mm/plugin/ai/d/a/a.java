package com.tencent.mm.plugin.ai.d.a;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.HashMap;

public final class a
{
  public HashMap<String, Long> npA;
  public b.a npB;
  
  public a()
  {
    AppMethodBeat.i(239226);
    this.npA = null;
    this.npB = new b.a()
    {
      public final void a(boolean paramAnonymousBoolean1, String paramAnonymousString1, final String paramAnonymousString2, boolean paramAnonymousBoolean2, final String paramAnonymousString3)
      {
        AppMethodBeat.i(240470);
        Log.i("MicroMsg.AiDownloadLogic", "%s download ai model [%b] [%s] [%s]", new Object[] { a.this.info(), Boolean.valueOf(paramAnonymousBoolean1), paramAnonymousString1, paramAnonymousString2 });
        if (paramAnonymousBoolean1) {
          com.tencent.mm.plugin.report.service.h.IzE.el(1559, 3);
        }
        for (;;)
        {
          if ((paramAnonymousBoolean1) && (paramAnonymousBoolean2)) {
            com.tencent.e.h.ZvG.d(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(239771);
                long l = Util.currentTicks();
                boolean bool = c.cl(paramAnonymousString3, paramAnonymousString2);
                Log.i("MicroMsg.AiDownloadLogic", "up zip [%b] unZipDir[%s] savePath[%s] cost[%d]", new Object[] { Boolean.valueOf(bool), paramAnonymousString3, paramAnonymousString2, Long.valueOf(Util.ticksToNow(l)) });
                if (bool) {
                  com.tencent.mm.plugin.report.service.h.IzE.el(1559, 8);
                }
                for (;;)
                {
                  u.deleteFile(paramAnonymousString2);
                  AppMethodBeat.o(239771);
                  return;
                  com.tencent.mm.plugin.report.service.h.IzE.el(1559, 9);
                }
              }
            }, "Ai_thread");
          }
          AppMethodBeat.o(240470);
          return;
          com.tencent.mm.plugin.report.service.h.IzE.el(1559, 4);
        }
      }
    };
    this.npA = new HashMap();
    AppMethodBeat.o(239226);
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, PString paramPString)
  {
    AppMethodBeat.i(239228);
    paramPString.value = "";
    paramString2 = paramString3 + paramString2;
    if (!u.agG(paramString2))
    {
      AppMethodBeat.o(239228);
      return -1;
    }
    if (paramString1.equalsIgnoreCase(g.getMD5(paramString2))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(239228);
      return -2;
    }
    paramPString.value = paramString2;
    AppMethodBeat.o(239228);
    return 0;
  }
  
  public final String info()
  {
    AppMethodBeat.i(239227);
    String str = hashCode();
    AppMethodBeat.o(239227);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.a.a
 * JD-Core Version:    0.7.0.1
 */