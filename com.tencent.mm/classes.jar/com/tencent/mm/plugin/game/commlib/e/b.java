package com.tencent.mm.plugin.game.commlib.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.Map;

public final class b
{
  private static final String sWq;
  private static final String sWr;
  
  static
  {
    AppMethodBeat.i(89976);
    sWq = com.tencent.mm.loader.j.b.aoZ() + "game/";
    sWr = com.tencent.mm.loader.j.b.aph() + "game/";
    AppMethodBeat.o(89976);
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(89970);
    parama = cOD() + parama.name() + "/";
    AppMethodBeat.o(89970);
    return parama;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(89971);
    parama = sWr + parama.name() + "/";
    AppMethodBeat.o(89971);
    return parama;
  }
  
  private static boolean b(com.tencent.mm.vfs.e parame, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(89974);
    if ((parame == null) || (!parame.exists()))
    {
      AppMethodBeat.o(89974);
      return false;
    }
    if (parame.isFile()) {
      if (System.currentTimeMillis() - parame.lastModified() > paramLong)
      {
        ac.i("MicroMsg.GameFileManager", "remove file:%s, lifetime:%d", new Object[] { q.B(parame.fxV()), Long.valueOf(paramLong) });
        parame.delete();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(89974);
      return true;
      if (parame.isDirectory())
      {
        parame = parame.fxX();
        if (parame != null) {
          while (i < parame.length)
          {
            b(parame[i], paramLong);
            i += 1;
          }
        }
      }
    }
  }
  
  public static String cOD()
  {
    AppMethodBeat.i(190956);
    String str = (String)com.tencent.mm.vfs.a.ghk().ghp().get("account");
    if (!bs.isNullOrNil(str)) {}
    for (str = com.tencent.mm.loader.j.b.aoZ() + str + "/game/";; str = sWq)
    {
      ac.i("MicroMsg.GameFileManager", "getGameDataRootPathByUin, validPath:%s", new Object[] { str });
      AppMethodBeat.o(190956);
      return str;
    }
  }
  
  public static void clean()
  {
    AppMethodBeat.i(89972);
    if (bs.pN(bs.g((Long)g.agR().agA().get(ah.a.GNS, Long.valueOf(0L)))) > 86400L)
    {
      g.agR().agA().set(ah.a.GNS, Long.valueOf(bs.aNx()));
      com.tencent.mm.plugin.game.commlib.c.a.cOB().a("game_cache_clean", new a.a()
      {
        public final void bXz()
        {
          AppMethodBeat.i(190955);
          a.cOC().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(190954);
              b.access$000();
              AppMethodBeat.o(190954);
            }
          }, 0L);
          AppMethodBeat.o(190955);
        }
      });
    }
    AppMethodBeat.o(89972);
  }
  
  public static void remove(String paramString)
  {
    AppMethodBeat.i(89973);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(89973);
      return;
    }
    ac.i("MicroMsg.GameFileManager", "delete file:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(i.deleteFile(paramString)) });
    AppMethodBeat.o(89973);
  }
  
  public static enum a
  {
    long time;
    
    static
    {
      AppMethodBeat.i(89968);
      sWt = new a("ONE_DAY", 0, 86400000L);
      sWu = new a("THREE_DAY", 1, 259200000L);
      sWv = new a("ONE_WEEK", 2, 604800000L);
      sWw = new a("ONE_MONTH", 3, 2592000000L);
      sWx = new a("PERMANENT", 4, 9223372036854775807L);
      sWy = new a[] { sWt, sWu, sWv, sWw, sWx };
      AppMethodBeat.o(89968);
    }
    
    private a(long paramLong)
    {
      this.time = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e.b
 * JD-Core Version:    0.7.0.1
 */