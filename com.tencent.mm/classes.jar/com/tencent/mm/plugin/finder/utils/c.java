package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker;", "", "()V", "TAG", "", "configs", "", "Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "getConfigs", "()Ljava/util/List;", "uploadBigFileConfig", "getUploadBigFileConfig", "()Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "checkAll", "", "clean", "config", "mark", "CheckerConfig", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "Finder.FinderCrashChecker";
  private static final a sKS;
  private static final List<a> sKT;
  public static final c sKU;
  
  static
  {
    AppMethodBeat.i(204469);
    sKU = new c();
    TAG = "Finder.FinderCrashChecker";
    a locala = new a("Finder_UploadBigFileConfig");
    sKS = locala;
    sKT = j.listOf(locala);
    AppMethodBeat.o(204469);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(204466);
    p.h(parama, "config");
    ax localax = ax.flg();
    p.g(localax, "mmkv");
    p.h(localax, "mmkv");
    localax.putLong(parama.sKV, System.currentTimeMillis());
    localax.commit();
    ad.i(TAG, "mark " + parama.sKV);
    AppMethodBeat.o(204466);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(204467);
    p.h(parama, "config");
    ax localax = ax.flg();
    p.g(localax, "mmkv");
    parama.a(localax);
    AppMethodBeat.o(204467);
  }
  
  public static a cLa()
  {
    return sKS;
  }
  
  public static void cLb()
  {
    AppMethodBeat.i(204468);
    ax localax = ax.flg();
    Iterator localIterator = ((Iterable)sKT).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      p.g(localax, "mmkv");
      p.h(localax, "mmkv");
      if (localax.getLong(locala.sKV, 0L) != 0L)
      {
        locala.a(localax);
        g.yhR.n(locala.id, locala.key, 1L);
        ad.i(TAG, "check " + locala.sKV + ", hit!");
      }
    }
    AppMethodBeat.o(204468);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "", "id", "", "key", "mmkvKey", "", "(JJLjava/lang/String;)V", "getId", "()J", "getKey", "getMmkvKey", "()Ljava/lang/String;", "check", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "clean", "mark", "plugin-finder_release"})
  public static final class a
  {
    final long id;
    final long key;
    final String sKV;
    
    public a(String paramString)
    {
      AppMethodBeat.i(204465);
      this.id = 1253L;
      this.key = 37L;
      this.sKV = paramString;
      AppMethodBeat.o(204465);
    }
    
    public final void a(ax paramax)
    {
      AppMethodBeat.i(204464);
      p.h(paramax, "mmkv");
      paramax.putLong(this.sKV, 0L);
      paramax.commit();
      paramax = c.sKU;
      ad.i(c.cLc(), "clean " + this.sKV);
      AppMethodBeat.o(204464);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.c
 * JD-Core Version:    0.7.0.1
 */