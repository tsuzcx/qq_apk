package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.c;
import com.tencent.mm.vfs.w;
import d.a.j;
import d.b.a;
import d.g.b.p;
import d.l;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "", "path", "", "name", "maxSize", "", "markNoMedia", "", "enableClear", "(Ljava/lang/String;Ljava/lang/String;JZZ)V", "TAG", "getEnableClear", "()Z", "getMarkNoMedia", "getMaxSize", "()J", "getName", "()Ljava/lang/String;", "getPath", "dumpCacheDir", "Lkotlin/Pair;", "initFolder", "", "isNoMedia", "plugin-finder_release"})
public final class f
{
  private final String TAG;
  final long maxSize;
  final String name;
  public final String path;
  private final boolean sWr;
  final boolean sWs;
  
  public f(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(167885);
    this.path = paramString1;
    this.name = paramString2;
    this.maxSize = paramLong;
    this.sWr = paramBoolean1;
    this.sWs = paramBoolean2;
    this.TAG = "Finder.FinderFolder";
    AppMethodBeat.o(167885);
  }
  
  private static boolean aDc(String paramString)
  {
    AppMethodBeat.i(224307);
    if (p.i(".nomedia", paramString))
    {
      AppMethodBeat.o(224307);
      return true;
    }
    AppMethodBeat.o(224307);
    return false;
  }
  
  public final void cNI()
  {
    AppMethodBeat.i(167883);
    com.tencent.mm.vfs.o.aZI(this.path);
    if (this.sWr) {
      com.tencent.mm.vfs.o.aZX(this.path);
    }
    AppMethodBeat.o(167883);
  }
  
  public final d.o<String, Long> cNJ()
  {
    AppMethodBeat.i(167884);
    b localb = new b("dumpCacheDir");
    Object localObject1 = this.path;
    ae.i(this.TAG, "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    localObject1 = com.tencent.mm.vfs.o.dh((String)localObject1, true);
    long l1;
    long l2;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = w.b((Iterable)localObject1);
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
          j.gkd();
        }
        localObject3 = (c)localObject3;
        l2 = l1;
        if (localObject3 != null)
        {
          String str = ((c)localObject3).name;
          p.g(str, "fileEntry.name");
          if (aDc(str)) {
            break label336;
          }
          l2 = l1 + ((c)localObject3).size;
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
        localObject1 = localObject1 + ", cost: " + localb.gIr.abs() + "ms, totalSize " + bu.sL(l2) + " \n";
        ae.i(this.TAG, (String)localObject1);
        localObject1 = new d.o(localObject1, Long.valueOf(l2));
        AppMethodBeat.o(167884);
        return localObject1;
      }
      label336:
      i = j;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(167882);
      int i = a.a((Comparable)Long.valueOf(((c)paramT1).LGc), (Comparable)Long.valueOf(((c)paramT2).LGc));
      AppMethodBeat.o(167882);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.f
 * JD-Core Version:    0.7.0.1
 */