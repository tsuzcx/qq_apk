package com.tencent.mm.plugin.ai.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.ai.d.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.HashMap;

public final class a
{
  private HashMap<String, Long> qof;
  private b.a qog;
  
  public a()
  {
    AppMethodBeat.i(267444);
    this.qof = null;
    this.qog = new b.a()
    {
      public final void a(boolean paramAnonymousBoolean1, String paramAnonymousString1, final String paramAnonymousString2, boolean paramAnonymousBoolean2, final String paramAnonymousString3)
      {
        AppMethodBeat.i(267461);
        Log.i("MicroMsg.AiDownloadLogic", "%s download ai model [%b] [%s] [%s]", new Object[] { a.this.info(), Boolean.valueOf(paramAnonymousBoolean1), paramAnonymousString1, paramAnonymousString2 });
        if (paramAnonymousBoolean1) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1559, 3);
        }
        for (;;)
        {
          if ((paramAnonymousBoolean1) && (paramAnonymousBoolean2)) {
            com.tencent.threadpool.h.ahAA.g(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(267458);
                long l = Util.currentTicks();
                boolean bool = c.cB(paramAnonymousString3, paramAnonymousString2);
                Log.i("MicroMsg.AiDownloadLogic", "up zip [%b] unZipDir[%s] savePath[%s] cost[%d]", new Object[] { Boolean.valueOf(bool), paramAnonymousString3, paramAnonymousString2, Long.valueOf(Util.ticksToNow(l)) });
                if (bool) {
                  com.tencent.mm.plugin.report.service.h.OAn.kJ(1559, 8);
                }
                for (;;)
                {
                  y.deleteFile(paramAnonymousString2);
                  AppMethodBeat.o(267458);
                  return;
                  com.tencent.mm.plugin.report.service.h.OAn.kJ(1559, 9);
                }
              }
            }, "Ai_thread");
          }
          AppMethodBeat.o(267461);
          return;
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1559, 4);
        }
      }
    };
    this.qof = new HashMap();
    AppMethodBeat.o(267444);
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, PString paramPString)
  {
    AppMethodBeat.i(267459);
    paramPString.value = "";
    paramString2 = paramString3 + paramString2;
    if (!y.ZC(paramString2))
    {
      AppMethodBeat.o(267459);
      return -1;
    }
    if (!cA(paramString2, paramString1))
    {
      AppMethodBeat.o(267459);
      return -2;
    }
    paramPString.value = paramString2;
    AppMethodBeat.o(267459);
    return 0;
  }
  
  public static boolean cA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267453);
    if (paramString2.equalsIgnoreCase(g.getMD5(paramString1)))
    {
      AppMethodBeat.o(267453);
      return true;
    }
    AppMethodBeat.o(267453);
    return false;
  }
  
  final String info()
  {
    AppMethodBeat.i(267473);
    String str = hashCode();
    AppMethodBeat.o(267473);
    return str;
  }
  
  public final void l(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(267466);
    long l = 0L;
    if (this.qof.containsKey(paramString1)) {
      l = ((Long)this.qof.get(paramString1)).longValue();
    }
    if (Util.milliSecondsToNow(l) > 1800000L)
    {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1559, 0);
      this.qof.put(paramString1, new Long(Util.nowMilliSecond()));
      String str1 = e.caH().TX(paramString1);
      String str2 = e.caH().TY(paramString1);
      new b(paramString1, str1, paramString2, this.qog, paramBoolean, str2).blf();
      Log.i("MicroMsg.AiDownloadLogic", "%s add to download url[%s] path[%s] md5[%s]", new Object[] { info(), paramString1, str1, paramString2 });
    }
    AppMethodBeat.o(267466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.c.a.a
 * JD-Core Version:    0.7.0.1
 */