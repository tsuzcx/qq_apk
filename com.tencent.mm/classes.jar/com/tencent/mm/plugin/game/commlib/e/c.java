package com.tencent.mm.plugin.game.commlib.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.commlib.c.a;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class c
{
  private static final String Ith;
  private static final String Iti;
  
  static
  {
    AppMethodBeat.i(89976);
    Ith = com.tencent.mm.loader.i.b.bmr() + "game/";
    Iti = com.tencent.mm.loader.i.b.bmz() + "game/";
    AppMethodBeat.o(89976);
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(275349);
    parama = Ith + parama.name() + "/";
    AppMethodBeat.o(275349);
    return parama;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(89970);
    parama = fEg() + parama.name() + "/";
    AppMethodBeat.o(89970);
    return parama;
  }
  
  private static boolean b(u paramu, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(89974);
    if ((paramu == null) || (!paramu.jKS()))
    {
      AppMethodBeat.o(89974);
      return false;
    }
    if (paramu.jKV()) {
      if (System.currentTimeMillis() - paramu.lastModified() > paramLong)
      {
        Log.i("MicroMsg.GameFileManager", "remove file:%s, lifetime:%d", new Object[] { ah.v(paramu.jKT()), Long.valueOf(paramLong) });
        paramu.diJ();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(89974);
      return true;
      if (paramu.isDirectory())
      {
        paramu = paramu.jKX();
        if (paramu != null) {
          while (i < paramu.length)
          {
            b(paramu[i], paramLong);
            i += 1;
          }
        }
      }
    }
  }
  
  public static String c(a parama)
  {
    AppMethodBeat.i(89971);
    parama = Iti + parama.name() + "/";
    AppMethodBeat.o(89971);
    return parama;
  }
  
  public static void clean()
  {
    AppMethodBeat.i(89972);
    if (Util.secondsToNow(Util.nullAsNil((Long)h.baE().ban().get(at.a.acSF, Long.valueOf(0L)))) > 86400L)
    {
      h.baE().ban().set(at.a.acSF, Long.valueOf(Util.nowSecond()));
      a.fEf().a("game_cache_clean", new a.a()
      {
        public final void dun()
        {
          AppMethodBeat.i(275344);
          b.getWorkerHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(275355);
              c.access$000();
              AppMethodBeat.o(275355);
            }
          }, 0L);
          AppMethodBeat.o(275344);
        }
      });
    }
    AppMethodBeat.o(89972);
  }
  
  public static String fEg()
  {
    AppMethodBeat.i(275346);
    String str = ah.aA(k.kMs().kMx(), "account");
    if (!Util.isNullOrNil(str)) {}
    for (str = com.tencent.mm.loader.i.b.bmr() + str + "/game/";; str = Ith)
    {
      Log.i("MicroMsg.GameFileManager", "getGameDataRootPathByUin, validPath:%s", new Object[] { str });
      AppMethodBeat.o(275346);
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
    Log.i("MicroMsg.GameFileManager", "delete file:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(y.deleteFile(paramString)) });
    AppMethodBeat.o(89973);
  }
  
  public static enum a
  {
    long time;
    
    static
    {
      AppMethodBeat.i(89968);
      Itk = new a("ONE_DAY", 0, 86400000L);
      Itl = new a("THREE_DAY", 1, 259200000L);
      Itm = new a("ONE_WEEK", 2, 604800000L);
      Itn = new a("ONE_MONTH", 3, 2592000000L);
      Ito = new a("PERMANENT", 4, 9223372036854775807L);
      Itp = new a[] { Itk, Itl, Itm, Itn, Ito };
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