package com.tencent.mm.plugin.game.commlib.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Map;

public final class b
{
  private static final String xvB;
  private static final String xvC;
  
  static
  {
    AppMethodBeat.i(89976);
    xvB = com.tencent.mm.loader.j.b.aKB() + "game/";
    xvC = com.tencent.mm.loader.j.b.aKJ() + "game/";
    AppMethodBeat.o(89976);
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(256621);
    parama = xvB + parama.name() + "/";
    AppMethodBeat.o(256621);
    return parama;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(89970);
    parama = dTg() + parama.name() + "/";
    AppMethodBeat.o(89970);
    return parama;
  }
  
  private static boolean b(o paramo, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(89974);
    if ((paramo == null) || (!paramo.exists()))
    {
      AppMethodBeat.o(89974);
      return false;
    }
    if (paramo.isFile()) {
      if (System.currentTimeMillis() - paramo.lastModified() > paramLong)
      {
        Log.i("MicroMsg.GameFileManager", "remove file:%s, lifetime:%d", new Object[] { aa.z(paramo.her()), Long.valueOf(paramLong) });
        paramo.delete();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(89974);
      return true;
      if (paramo.isDirectory())
      {
        paramo = paramo.het();
        if (paramo != null) {
          while (i < paramo.length)
          {
            b(paramo[i], paramLong);
            i += 1;
          }
        }
      }
    }
  }
  
  public static String c(a parama)
  {
    AppMethodBeat.i(89971);
    parama = xvC + parama.name() + "/";
    AppMethodBeat.o(89971);
    return parama;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(89972);
    if (Util.secondsToNow(Util.nullAsNil((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OcW, Long.valueOf(0L)))) > 86400L)
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OcW, Long.valueOf(Util.nowSecond()));
      com.tencent.mm.plugin.game.commlib.c.a.dTf().a("game_cache_clean", new a.a()
      {
        public final void cBm()
        {
          AppMethodBeat.i(256619);
          a.getWorkerHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(256618);
              b.access$000();
              AppMethodBeat.o(256618);
            }
          }, 0L);
          AppMethodBeat.o(256619);
        }
      });
    }
    AppMethodBeat.o(89972);
  }
  
  public static String dTg()
  {
    AppMethodBeat.i(256620);
    String str = (String)com.tencent.mm.vfs.g.hRR().hRV().get("account");
    if (!Util.isNullOrNil(str)) {}
    for (str = com.tencent.mm.loader.j.b.aKB() + str + "/game/";; str = xvB)
    {
      Log.i("MicroMsg.GameFileManager", "getGameDataRootPathByUin, validPath:%s", new Object[] { str });
      AppMethodBeat.o(256620);
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
    Log.i("MicroMsg.GameFileManager", "delete file:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(s.deleteFile(paramString)) });
    AppMethodBeat.o(89973);
  }
  
  public static enum a
  {
    long time;
    
    static
    {
      AppMethodBeat.i(89968);
      xvE = new a("ONE_DAY", 0, 86400000L);
      xvF = new a("THREE_DAY", 1, 259200000L);
      xvG = new a("ONE_WEEK", 2, 604800000L);
      xvH = new a("ONE_MONTH", 3, 2592000000L);
      xvI = new a("PERMANENT", 4, 9223372036854775807L);
      xvJ = new a[] { xvE, xvF, xvG, xvH, xvI };
      AppMethodBeat.o(89968);
    }
    
    private a(long paramLong)
    {
      this.time = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.util.b
 * JD-Core Version:    0.7.0.1
 */