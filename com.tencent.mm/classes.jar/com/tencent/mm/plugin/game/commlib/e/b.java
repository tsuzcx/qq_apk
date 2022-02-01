package com.tencent.mm.plugin.game.commlib.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.Map;

public final class b
{
  private static final String rOA;
  private static final String rOB;
  
  static
  {
    AppMethodBeat.i(89976);
    rOA = com.tencent.mm.loader.j.b.ahZ() + "game/";
    rOB = com.tencent.mm.loader.j.b.aih() + "game/";
    AppMethodBeat.o(89976);
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(89970);
    parama = cBu() + parama.name() + "/";
    AppMethodBeat.o(89970);
    return parama;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(89971);
    parama = rOB + parama.name() + "/";
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
        ad.i("MicroMsg.GameFileManager", "remove file:%s, lifetime:%d", new Object[] { q.B(parame.fhU()), Long.valueOf(paramLong) });
        parame.delete();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(89974);
      return true;
      if (parame.isDirectory())
      {
        parame = parame.fhW();
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
  
  public static String cBu()
  {
    AppMethodBeat.i(190560);
    String str = (String)com.tencent.mm.vfs.a.gap().gav().get("account");
    if (!bt.isNullOrNil(str)) {}
    for (str = com.tencent.mm.loader.j.b.ahZ() + str + "/game/";; str = rOA)
    {
      ad.i("MicroMsg.GameFileManager", "getGameDataRootPathByUin, validPath:%s", new Object[] { str });
      AppMethodBeat.o(190560);
      return str;
    }
  }
  
  public static void clean()
  {
    AppMethodBeat.i(89972);
    if (bt.lZ(bt.f((Long)g.afB().afk().get(ae.a.Fqc, Long.valueOf(0L)))) > 86400L)
    {
      g.afB().afk().set(ae.a.Fqc, Long.valueOf(bt.aGK()));
      com.tencent.mm.plugin.game.commlib.c.a.cBs().a("game_cache_clean", new a.a()
      {
        public final void bQi()
        {
          AppMethodBeat.i(190559);
          a.cBt().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(190558);
              b.access$000();
              AppMethodBeat.o(190558);
            }
          }, 0L);
          AppMethodBeat.o(190559);
        }
      });
    }
    AppMethodBeat.o(89972);
  }
  
  public static void remove(String paramString)
  {
    AppMethodBeat.i(89973);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(89973);
      return;
    }
    ad.i("MicroMsg.GameFileManager", "delete file:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(i.deleteFile(paramString)) });
    AppMethodBeat.o(89973);
  }
  
  public static enum a
  {
    long time;
    
    static
    {
      AppMethodBeat.i(89968);
      rOD = new a("ONE_DAY", 0, 86400000L);
      rOE = new a("THREE_DAY", 1, 259200000L);
      rOF = new a("ONE_WEEK", 2, 604800000L);
      rOG = new a("ONE_MONTH", 3, 2592000000L);
      rOH = new a("PERMANENT", 4, 9223372036854775807L);
      rOI = new a[] { rOD, rOE, rOF, rOG, rOH };
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