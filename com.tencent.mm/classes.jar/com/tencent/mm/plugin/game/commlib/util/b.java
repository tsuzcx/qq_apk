package com.tencent.mm.plugin.game.commlib.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.Map;

public final class b
{
  private static final String udP;
  private static final String udQ;
  
  static
  {
    AppMethodBeat.i(89976);
    udP = com.tencent.mm.loader.j.b.asb() + "game/";
    udQ = com.tencent.mm.loader.j.b.asj() + "game/";
    AppMethodBeat.o(89976);
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(221871);
    parama = udP + parama.name() + "/";
    AppMethodBeat.o(221871);
    return parama;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(89970);
    parama = cZG() + parama.name() + "/";
    AppMethodBeat.o(89970);
    return parama;
  }
  
  private static boolean b(k paramk, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(89974);
    if ((paramk == null) || (!paramk.exists()))
    {
      AppMethodBeat.o(89974);
      return false;
    }
    if (paramk.isFile()) {
      if (System.currentTimeMillis() - paramk.lastModified() > paramLong)
      {
        ae.i("MicroMsg.GameFileManager", "remove file:%s, lifetime:%d", new Object[] { w.B(paramk.fTh()), Long.valueOf(paramLong) });
        paramk.delete();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(89974);
      return true;
      if (paramk.isDirectory())
      {
        paramk = paramk.fTj();
        if (paramk != null) {
          while (i < paramk.length)
          {
            b(paramk[i], paramLong);
            i += 1;
          }
        }
      }
    }
  }
  
  public static String c(a parama)
  {
    AppMethodBeat.i(89971);
    parama = udQ + parama.name() + "/";
    AppMethodBeat.o(89971);
    return parama;
  }
  
  public static String cZG()
  {
    AppMethodBeat.i(221870);
    String str = (String)com.tencent.mm.vfs.e.fSU().gEn().get("account");
    if (!bu.isNullOrNil(str)) {}
    for (str = com.tencent.mm.loader.j.b.asb() + str + "/game/";; str = udP)
    {
      ae.i("MicroMsg.GameFileManager", "getGameDataRootPathByUin, validPath:%s", new Object[] { str });
      AppMethodBeat.o(221870);
      return str;
    }
  }
  
  public static void clean()
  {
    AppMethodBeat.i(89972);
    if (bu.rZ(bu.i((Long)g.ajR().ajA().get(am.a.IUI, Long.valueOf(0L)))) > 86400L)
    {
      g.ajR().ajA().set(am.a.IUI, Long.valueOf(bu.aRi()));
      com.tencent.mm.plugin.game.commlib.c.a.cZE().a("game_cache_clean", new a.a()
      {
        public final void cdr()
        {
          AppMethodBeat.i(221869);
          a.cZF().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(221868);
              b.access$000();
              AppMethodBeat.o(221868);
            }
          }, 0L);
          AppMethodBeat.o(221869);
        }
      });
    }
    AppMethodBeat.o(89972);
  }
  
  public static void remove(String paramString)
  {
    AppMethodBeat.i(89973);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(89973);
      return;
    }
    ae.i("MicroMsg.GameFileManager", "delete file:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(o.deleteFile(paramString)) });
    AppMethodBeat.o(89973);
  }
  
  public static enum a
  {
    long time;
    
    static
    {
      AppMethodBeat.i(89968);
      udS = new a("ONE_DAY", 0, 86400000L);
      udT = new a("THREE_DAY", 1, 259200000L);
      udU = new a("ONE_WEEK", 2, 604800000L);
      udV = new a("ONE_MONTH", 3, 2592000000L);
      udW = new a("PERMANENT", 4, 9223372036854775807L);
      udX = new a[] { udS, udT, udU, udV, udW };
      AppMethodBeat.o(89968);
    }
    
    private a(long paramLong)
    {
      this.time = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.util.b
 * JD-Core Version:    0.7.0.1
 */