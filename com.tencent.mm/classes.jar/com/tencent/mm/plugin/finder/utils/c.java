package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker;", "", "()V", "TAG", "", "configs", "", "Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "getConfigs", "()Ljava/util/List;", "uploadBigFileConfig", "getUploadBigFileConfig", "()Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "checkAll", "", "clean", "config", "mark", "CheckerConfig", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "Finder.FinderCrashChecker";
  private static final a sWe;
  private static final List<a> sWf;
  public static final c sWg;
  
  static
  {
    AppMethodBeat.i(205087);
    sWg = new c();
    TAG = "Finder.FinderCrashChecker";
    a locala = new a("Finder_UploadBigFileConfig");
    sWe = locala;
    sWf = j.listOf(locala);
    AppMethodBeat.o(205087);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(205084);
    p.h(parama, "config");
    ay localay = ay.fpb();
    p.g(localay, "mmkv");
    p.h(localay, "mmkv");
    localay.putLong(parama.sWh, System.currentTimeMillis());
    localay.commit();
    ae.i(TAG, "mark " + parama.sWh);
    AppMethodBeat.o(205084);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(205085);
    p.h(parama, "config");
    ay localay = ay.fpb();
    p.g(localay, "mmkv");
    parama.a(localay);
    AppMethodBeat.o(205085);
  }
  
  public static a cNE()
  {
    return sWe;
  }
  
  public static void cNF()
  {
    AppMethodBeat.i(205086);
    ay localay = ay.fpb();
    Iterator localIterator = ((Iterable)sWf).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      p.g(localay, "mmkv");
      p.h(localay, "mmkv");
      if (localay.getLong(locala.sWh, 0L) != 0L)
      {
        locala.a(localay);
        g.yxI.n(locala.id, locala.key, 1L);
        ae.i(TAG, "check " + locala.sWh + ", hit!");
      }
    }
    AppMethodBeat.o(205086);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "", "id", "", "key", "mmkvKey", "", "(JJLjava/lang/String;)V", "getId", "()J", "getKey", "getMmkvKey", "()Ljava/lang/String;", "check", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "clean", "mark", "plugin-finder_release"})
  public static final class a
  {
    final long id;
    final long key;
    final String sWh;
    
    public a(String paramString)
    {
      AppMethodBeat.i(205083);
      this.id = 1253L;
      this.key = 37L;
      this.sWh = paramString;
      AppMethodBeat.o(205083);
    }
    
    public final void a(ay paramay)
    {
      AppMethodBeat.i(205082);
      p.h(paramay, "mmkv");
      paramay.putLong(this.sWh, 0L);
      paramay.commit();
      paramay = c.sWg;
      ae.i(c.cNG(), "clean " + this.sWh);
      AppMethodBeat.o(205082);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.c
 * JD-Core Version:    0.7.0.1
 */