package com.tencent.mm.plugin.game.commlib.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.game.commlib.c.a;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Map;

public final class c
{
  private static final String Czr;
  private static final String Czs;
  
  static
  {
    AppMethodBeat.i(89976);
    Czr = com.tencent.mm.loader.j.b.aSD() + "game/";
    Czs = com.tencent.mm.loader.j.b.aSL() + "game/";
    AppMethodBeat.o(89976);
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(207326);
    parama = Czr + parama.name() + "/";
    AppMethodBeat.o(207326);
    return parama;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(89970);
    parama = ewp() + parama.name() + "/";
    AppMethodBeat.o(89970);
    return parama;
  }
  
  private static boolean b(q paramq, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(89974);
    if ((paramq == null) || (!paramq.ifE()))
    {
      AppMethodBeat.o(89974);
      return false;
    }
    if (paramq.ifH()) {
      if (System.currentTimeMillis() - paramq.lastModified() > paramLong)
      {
        Log.i("MicroMsg.GameFileManager", "remove file:%s, lifetime:%d", new Object[] { paramq.bOF(), Long.valueOf(paramLong) });
        paramq.cFq();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(89974);
      return true;
      if (paramq.isDirectory())
      {
        paramq = paramq.ifJ();
        if (paramq != null) {
          while (i < paramq.length)
          {
            b(paramq[i], paramLong);
            i += 1;
          }
        }
      }
    }
  }
  
  public static String c(a parama)
  {
    AppMethodBeat.i(89971);
    parama = Czs + parama.name() + "/";
    AppMethodBeat.o(89971);
    return parama;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(89972);
    if (Util.secondsToNow(Util.nullAsNil((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vrd, Long.valueOf(0L)))) > 86400L)
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vrd, Long.valueOf(Util.nowSecond()));
      a.ewo().a("game_cache_clean", new a.a()
      {
        public final void cPQ()
        {
          AppMethodBeat.i(207151);
          b.getWorkerHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(207108);
              c.access$000();
              AppMethodBeat.o(207108);
            }
          }, 0L);
          AppMethodBeat.o(207151);
        }
      });
    }
    AppMethodBeat.o(89972);
  }
  
  public static String ewp()
  {
    AppMethodBeat.i(207325);
    String str = (String)com.tencent.mm.vfs.h.iWH().iWM().get("account");
    if (!Util.isNullOrNil(str)) {}
    for (str = com.tencent.mm.loader.j.b.aSD() + str + "/game/";; str = Czr)
    {
      Log.i("MicroMsg.GameFileManager", "getGameDataRootPathByUin, validPath:%s", new Object[] { str });
      AppMethodBeat.o(207325);
      return str;
    }
  }
  
  public static void remove(String paramString)
  {
    AppMethodBeat.i(89973);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(89973);
      return;
    }
    Log.i("MicroMsg.GameFileManager", "delete file:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(u.deleteFile(paramString)) });
    AppMethodBeat.o(89973);
  }
  
  public static enum a
  {
    long time;
    
    static
    {
      AppMethodBeat.i(89968);
      Czu = new a("ONE_DAY", 0, 86400000L);
      Czv = new a("THREE_DAY", 1, 259200000L);
      Czw = new a("ONE_WEEK", 2, 604800000L);
      Czx = new a("ONE_MONTH", 3, 2592000000L);
      Czy = new a("PERMANENT", 4, 9223372036854775807L);
      Czz = new a[] { Czu, Czv, Czw, Czx, Czy };
      AppMethodBeat.o(89968);
    }
    
    private a(long paramLong)
    {
      this.time = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e.c
 * JD-Core Version:    0.7.0.1
 */