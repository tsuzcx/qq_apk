package com.tencent.mm.plugin.ai.d.a;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.HashMap;

public final class a
{
  public HashMap<String, Long> kwG;
  public b.a kwH;
  
  public a()
  {
    AppMethodBeat.i(238903);
    this.kwG = null;
    this.kwH = new b.a()
    {
      public final void a(boolean paramAnonymousBoolean1, String paramAnonymousString1, final String paramAnonymousString2, boolean paramAnonymousBoolean2, final String paramAnonymousString3)
      {
        AppMethodBeat.i(238902);
        Log.i("MicroMsg.AiDownloadLogic", "%s download ai model [%b] [%s] [%s]", new Object[] { a.this.info(), Boolean.valueOf(paramAnonymousBoolean1), paramAnonymousString1, paramAnonymousString2 });
        if (paramAnonymousBoolean1) {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1559, 3);
        }
        for (;;)
        {
          if ((paramAnonymousBoolean1) && (paramAnonymousBoolean2)) {
            com.tencent.f.h.RTc.b(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(238901);
                long l = Util.currentTicks();
                boolean bool = c.cg(paramAnonymousString3, paramAnonymousString2);
                Log.i("MicroMsg.AiDownloadLogic", "up zip [%b] unZipDir[%s] savePath[%s] cost[%d]", new Object[] { Boolean.valueOf(bool), paramAnonymousString3, paramAnonymousString2, Long.valueOf(Util.ticksToNow(l)) });
                if (bool) {
                  com.tencent.mm.plugin.report.service.h.CyF.dN(1559, 8);
                }
                for (;;)
                {
                  s.deleteFile(paramAnonymousString2);
                  AppMethodBeat.o(238901);
                  return;
                  com.tencent.mm.plugin.report.service.h.CyF.dN(1559, 9);
                }
              }
            }, "Ai_thread");
          }
          AppMethodBeat.o(238902);
          return;
          com.tencent.mm.plugin.report.service.h.CyF.dN(1559, 4);
        }
      }
    };
    this.kwG = new HashMap();
    AppMethodBeat.o(238903);
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, PString paramPString)
  {
    AppMethodBeat.i(238905);
    paramPString.value = "";
    paramString2 = paramString3 + paramString2;
    if (!s.YS(paramString2))
    {
      AppMethodBeat.o(238905);
      return -1;
    }
    if (paramString1.equalsIgnoreCase(g.getMD5(paramString2))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(238905);
      return -2;
    }
    paramPString.value = paramString2;
    AppMethodBeat.o(238905);
    return 0;
  }
  
  public final String info()
  {
    AppMethodBeat.i(238904);
    String str = hashCode();
    AppMethodBeat.o(238904);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.a.a
 * JD-Core Version:    0.7.0.1
 */