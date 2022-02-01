package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker;", "", "()V", "TAG", "", "configs", "", "Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "getConfigs", "()Ljava/util/List;", "uploadBigFileConfig", "getUploadBigFileConfig", "()Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "checkAll", "", "clean", "config", "mark", "CheckerConfig", "plugin-finder_release"})
public final class g
{
  private static final a ADb;
  private static final List<a> ADc;
  public static final g ADd;
  private static final String TAG = "Finder.FinderCrashChecker";
  
  static
  {
    AppMethodBeat.i(274247);
    ADd = new g();
    TAG = "Finder.FinderCrashChecker";
    a locala = new a("Finder_UploadBigFileConfig");
    ADb = locala;
    ADc = j.listOf(locala);
    AppMethodBeat.o(274247);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(274243);
    p.k(parama, "config");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
    p.j(localMultiProcessMMKV, "mmkv");
    p.k(localMultiProcessMMKV, "mmkv");
    localMultiProcessMMKV.putLong(parama.ADe, System.currentTimeMillis());
    localMultiProcessMMKV.commit();
    Log.i(TAG, "mark " + parama.ADe);
    AppMethodBeat.o(274243);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(274244);
    p.k(parama, "config");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
    p.j(localMultiProcessMMKV, "mmkv");
    parama.a(localMultiProcessMMKV);
    AppMethodBeat.o(274244);
  }
  
  public static a ecO()
  {
    return ADb;
  }
  
  public static void ecP()
  {
    AppMethodBeat.i(274245);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
    Iterator localIterator = ((Iterable)ADc).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      p.j(localMultiProcessMMKV, "mmkv");
      p.k(localMultiProcessMMKV, "mmkv");
      if (localMultiProcessMMKV.getLong(locala.ADe, 0L) != 0L)
      {
        locala.a(localMultiProcessMMKV);
        h.IzE.p(locala.id, locala.key, 1L);
        Log.i(TAG, "check " + locala.ADe + ", hit!");
      }
    }
    AppMethodBeat.o(274245);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "", "id", "", "key", "mmkvKey", "", "(JJLjava/lang/String;)V", "getId", "()J", "getKey", "getMmkvKey", "()Ljava/lang/String;", "check", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "clean", "mark", "plugin-finder_release"})
  public static final class a
  {
    final String ADe;
    final long id;
    final long key;
    
    public a(String paramString)
    {
      AppMethodBeat.i(281092);
      this.id = 1253L;
      this.key = 37L;
      this.ADe = paramString;
      AppMethodBeat.o(281092);
    }
    
    public final void a(MultiProcessMMKV paramMultiProcessMMKV)
    {
      AppMethodBeat.i(281091);
      p.k(paramMultiProcessMMKV, "mmkv");
      paramMultiProcessMMKV.putLong(this.ADe, 0L);
      paramMultiProcessMMKV.commit();
      paramMultiProcessMMKV = g.ADd;
      Log.i(g.ecQ(), "clean " + this.ADe);
      AppMethodBeat.o(281091);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.g
 * JD-Core Version:    0.7.0.1
 */