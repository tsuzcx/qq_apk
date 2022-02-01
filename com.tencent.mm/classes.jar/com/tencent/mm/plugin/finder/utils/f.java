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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker;", "", "()V", "TAG", "", "configs", "", "Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "getConfigs", "()Ljava/util/List;", "uploadBigFileConfig", "getUploadBigFileConfig", "()Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "checkAll", "", "clean", "config", "mark", "CheckerConfig", "plugin-finder_release"})
public final class f
{
  private static final String TAG = "Finder.FinderCrashChecker";
  private static final a vVm;
  private static final List<a> vVn;
  public static final f vVo;
  
  static
  {
    AppMethodBeat.i(253393);
    vVo = new f();
    TAG = "Finder.FinderCrashChecker";
    a locala = new a("Finder_UploadBigFileConfig");
    vVm = locala;
    vVn = j.listOf(locala);
    AppMethodBeat.o(253393);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(253390);
    p.h(parama, "config");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
    p.g(localMultiProcessMMKV, "mmkv");
    p.h(localMultiProcessMMKV, "mmkv");
    localMultiProcessMMKV.putLong(parama.vVp, System.currentTimeMillis());
    localMultiProcessMMKV.commit();
    Log.i(TAG, "mark " + parama.vVp);
    AppMethodBeat.o(253390);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(253391);
    p.h(parama, "config");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
    p.g(localMultiProcessMMKV, "mmkv");
    parama.a(localMultiProcessMMKV);
    AppMethodBeat.o(253391);
  }
  
  public static a dBB()
  {
    return vVm;
  }
  
  public static void dBC()
  {
    AppMethodBeat.i(253392);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
    Iterator localIterator = ((Iterable)vVn).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      p.g(localMultiProcessMMKV, "mmkv");
      p.h(localMultiProcessMMKV, "mmkv");
      if (localMultiProcessMMKV.getLong(locala.vVp, 0L) != 0L)
      {
        locala.a(localMultiProcessMMKV);
        h.CyF.n(locala.id, locala.key, 1L);
        Log.i(TAG, "check " + locala.vVp + ", hit!");
      }
    }
    AppMethodBeat.o(253392);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "", "id", "", "key", "mmkvKey", "", "(JJLjava/lang/String;)V", "getId", "()J", "getKey", "getMmkvKey", "()Ljava/lang/String;", "check", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "clean", "mark", "plugin-finder_release"})
  public static final class a
  {
    final long id;
    final long key;
    final String vVp;
    
    public a(String paramString)
    {
      AppMethodBeat.i(253389);
      this.id = 1253L;
      this.key = 37L;
      this.vVp = paramString;
      AppMethodBeat.o(253389);
    }
    
    public final void a(MultiProcessMMKV paramMultiProcessMMKV)
    {
      AppMethodBeat.i(253388);
      p.h(paramMultiProcessMMKV, "mmkv");
      paramMultiProcessMMKV.putLong(this.vVp, 0L);
      paramMultiProcessMMKV.commit();
      paramMultiProcessMMKV = f.vVo;
      Log.i(f.dBD(), "clean " + this.vVp);
      AppMethodBeat.o(253388);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.f
 * JD-Core Version:    0.7.0.1
 */