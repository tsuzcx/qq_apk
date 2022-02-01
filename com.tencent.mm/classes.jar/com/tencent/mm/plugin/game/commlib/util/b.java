package com.tencent.mm.plugin.game.commlib.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.Map;

public final class b
{
  private static final String tSY;
  private static final String tSZ;
  
  static
  {
    AppMethodBeat.i(89976);
    tSY = com.tencent.mm.loader.j.b.arM() + "game/";
    tSZ = com.tencent.mm.loader.j.b.arU() + "game/";
    AppMethodBeat.o(89976);
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(199573);
    parama = tSY + parama.name() + "/";
    AppMethodBeat.o(199573);
    return parama;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(89970);
    parama = cWZ() + parama.name() + "/";
    AppMethodBeat.o(89970);
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
        ad.i("MicroMsg.GameFileManager", "remove file:%s, lifetime:%d", new Object[] { q.B(parame.fOK()), Long.valueOf(paramLong) });
        parame.delete();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(89974);
      return true;
      if (parame.isDirectory())
      {
        parame = parame.fOM();
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
  
  public static String c(a parama)
  {
    AppMethodBeat.i(89971);
    parama = tSZ + parama.name() + "/";
    AppMethodBeat.o(89971);
    return parama;
  }
  
  public static String cWZ()
  {
    AppMethodBeat.i(199572);
    String str = (String)com.tencent.mm.vfs.a.gzU().gzZ().get("account");
    if (!bt.isNullOrNil(str)) {}
    for (str = com.tencent.mm.loader.j.b.arM() + str + "/game/";; str = tSY)
    {
      ad.i("MicroMsg.GameFileManager", "getGameDataRootPathByUin, validPath:%s", new Object[] { str });
      AppMethodBeat.o(199572);
      return str;
    }
  }
  
  public static void clean()
  {
    AppMethodBeat.i(89972);
    if (bt.rM(bt.g((Long)g.ajC().ajl().get(al.a.IAj, Long.valueOf(0L)))) > 86400L)
    {
      g.ajC().ajl().set(al.a.IAj, Long.valueOf(bt.aQJ()));
      com.tencent.mm.plugin.game.commlib.c.a.cWX().a("game_cache_clean", new a.a()
      {
        public final void ccc()
        {
          AppMethodBeat.i(199571);
          a.cWY().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(199570);
              b.access$000();
              AppMethodBeat.o(199570);
            }
          }, 0L);
          AppMethodBeat.o(199571);
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
      tTb = new a("ONE_DAY", 0, 86400000L);
      tTc = new a("THREE_DAY", 1, 259200000L);
      tTd = new a("ONE_WEEK", 2, 604800000L);
      tTe = new a("ONE_MONTH", 3, 2592000000L);
      tTf = new a("PERMANENT", 4, 9223372036854775807L);
      tTg = new a[] { tTb, tTc, tTd, tTe, tTf };
      AppMethodBeat.o(89968);
    }
    
    private a(long paramLong)
    {
      this.time = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.util.b
 * JD-Core Version:    0.7.0.1
 */