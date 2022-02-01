package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.c;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ad;
import com.tencent.mm.vfs.f;
import com.tencent.mm.vfs.u;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.b.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "", "path", "", "name", "maxSize", "", "markNoMedia", "", "enableClear", "(Ljava/lang/String;Ljava/lang/String;JZZ)V", "TAG", "getEnableClear", "()Z", "getMarkNoMedia", "getMaxSize", "()J", "getName", "()Ljava/lang/String;", "getPath", "dumpCacheDir", "Lkotlin/Pair;", "initFolder", "", "isNoMedia", "plugin-finder_release"})
public final class k
{
  private final boolean ADr;
  final boolean ADs;
  private final String TAG;
  final long aFQ;
  final String name;
  public final String path;
  
  public k(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(167885);
    this.path = paramString1;
    this.name = paramString2;
    this.aFQ = paramLong;
    this.ADr = paramBoolean1;
    this.ADs = paramBoolean2;
    this.TAG = "Finder.FinderFolder";
    AppMethodBeat.o(167885);
  }
  
  private static boolean aFB(String paramString)
  {
    AppMethodBeat.i(265497);
    if (p.h(".nomedia", paramString))
    {
      AppMethodBeat.o(265497);
      return true;
    }
    AppMethodBeat.o(265497);
    return false;
  }
  
  public final void ecR()
  {
    AppMethodBeat.i(167883);
    u.bBD(this.path);
    if (this.ADr) {
      u.bBX(this.path);
    }
    AppMethodBeat.o(167883);
  }
  
  public final o<String, Long> ecS()
  {
    AppMethodBeat.i(167884);
    c localc = new c("dumpCacheDir");
    Object localObject1 = this.path;
    Log.i(this.TAG, "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    localObject1 = u.dP((String)localObject1, true);
    long l1;
    long l2;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ad.c((Iterable)localObject1);
      if ((localObject1 != null) && (((List)localObject1).size() > 1)) {
        j.a((List)localObject1, (Comparator)new a());
      }
      l1 = 0L;
      l2 = l1;
      if (localObject1 == null) {
        break label211;
      }
      localObject2 = (Iterable)localObject1;
      i = 0;
      localObject2 = ((Iterable)localObject2).iterator();
    }
    for (;;)
    {
      l2 = l1;
      int j;
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        j = i + 1;
        if (i < 0) {
          j.iBO();
        }
        localObject3 = (f)localObject3;
        l2 = l1;
        if (localObject3 != null)
        {
          String str = ((f)localObject3).name;
          p.j(str, "fileEntry.name");
          if (aFB(str)) {
            break label336;
          }
          l2 = l1 + ((f)localObject3).size;
        }
        i = j;
        l1 = l2;
        continue;
        localObject1 = null;
        break;
      }
      label211:
      localObject2 = new StringBuilder("dump ").append(this.name).append(" fileCounts ");
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((List)localObject1).size());; localObject1 = null)
      {
        localObject1 = localObject1 + ", cost: " + localc.khd.avE() + "ms, totalSize " + Util.getSizeKB(l2) + " \n";
        Log.i(this.TAG, (String)localObject1);
        localObject1 = new o(localObject1, Long.valueOf(l2));
        AppMethodBeat.o(167884);
        return localObject1;
      }
      label336:
      i = j;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(167882);
      int i = a.a((Comparable)Long.valueOf(((f)paramT1).YCi), (Comparable)Long.valueOf(((f)paramT2).YCi));
      AppMethodBeat.o(167882);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.k
 * JD-Core Version:    0.7.0.1
 */