package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.b.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "", "path", "", "name", "maxSize", "", "markNoMedia", "", "enableClear", "(Ljava/lang/String;Ljava/lang/String;JZZ)V", "TAG", "getEnableClear", "()Z", "getMarkNoMedia", "getMaxSize", "()J", "getName", "()Ljava/lang/String;", "getPath", "dumpCacheDir", "Lkotlin/Pair;", "initFolder", "", "isNoMedia", "plugin-finder_release"})
public final class i
{
  private final String TAG;
  final long maxSize;
  final String name;
  public final String path;
  private final boolean vVx;
  final boolean vVy;
  
  public i(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(167885);
    this.path = paramString1;
    this.name = paramString2;
    this.maxSize = paramLong;
    this.vVx = paramBoolean1;
    this.vVy = paramBoolean2;
    this.TAG = "Finder.FinderFolder";
    AppMethodBeat.o(167885);
  }
  
  private static boolean awg(String paramString)
  {
    AppMethodBeat.i(253394);
    if (p.j(".nomedia", paramString))
    {
      AppMethodBeat.o(253394);
      return true;
    }
    AppMethodBeat.o(253394);
    return false;
  }
  
  public final void dBE()
  {
    AppMethodBeat.i(167883);
    s.boN(this.path);
    if (this.vVx) {
      s.bpc(this.path);
    }
    AppMethodBeat.o(167883);
  }
  
  public final o<String, Long> dBF()
  {
    AppMethodBeat.i(167884);
    c localc = new c("dumpCacheDir");
    Object localObject1 = this.path;
    Log.i(this.TAG, "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    localObject1 = s.dC((String)localObject1, true);
    long l1;
    long l2;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = aa.c((Iterable)localObject1);
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
          j.hxH();
        }
        localObject3 = (e)localObject3;
        l2 = l1;
        if (localObject3 != null)
        {
          String str = ((e)localObject3).name;
          p.g(str, "fileEntry.name");
          if (awg(str)) {
            break label336;
          }
          l2 = l1 + ((e)localObject3).size;
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
        localObject1 = localObject1 + ", cost: " + localc.hvh.apr() + "ms, totalSize " + Util.getSizeKB(l2) + " \n";
        Log.i(this.TAG, (String)localObject1);
        localObject1 = new o(localObject1, Long.valueOf(l2));
        AppMethodBeat.o(167884);
        return localObject1;
      }
      label336:
      i = j;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(167882);
      int i = a.a((Comparable)Long.valueOf(((e)paramT1).RbI), (Comparable)Long.valueOf(((e)paramT2).RbI));
      AppMethodBeat.o(167882);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.i
 * JD-Core Version:    0.7.0.1
 */