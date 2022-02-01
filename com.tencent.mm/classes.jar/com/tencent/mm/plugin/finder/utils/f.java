package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import d.a.j;
import d.b.a;
import d.g.b.p;
import d.l;
import d.o;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "", "path", "", "name", "maxSize", "", "markNoMedia", "", "enableClear", "(Ljava/lang/String;Ljava/lang/String;JZZ)V", "TAG", "getEnableClear", "()Z", "getMarkNoMedia", "getMaxSize", "()J", "getName", "()Ljava/lang/String;", "getPath", "dumpCacheDir", "Lkotlin/Pair;", "initFolder", "", "isNoMedia", "plugin-finder_release"})
public final class f
{
  private final String TAG;
  final long maxSize;
  final String name;
  final String path;
  private final boolean sLg;
  final boolean sLh;
  
  public f(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(167885);
    this.path = paramString1;
    this.name = paramString2;
    this.maxSize = paramLong;
    this.sLg = paramBoolean1;
    this.sLh = paramBoolean2;
    this.TAG = "Finder.FinderFolder";
    AppMethodBeat.o(167885);
  }
  
  public final void cLe()
  {
    AppMethodBeat.i(167883);
    i.aYg(this.path);
    if (this.sLg) {
      i.aYu(this.path);
    }
    AppMethodBeat.o(167883);
  }
  
  public final o<String, Long> cLf()
  {
    AppMethodBeat.i(167884);
    b localb = new b("dumpCacheDir");
    Object localObject1 = this.path;
    ad.i(this.TAG, "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    localObject1 = i.de((String)localObject1, true);
    Object localObject2;
    int i;
    long l1;
    if (localObject1 != null)
    {
      localObject1 = q.b((Iterable)localObject1);
      if ((localObject1 != null) && (((List)localObject1).size() > 1)) {
        j.a((List)localObject1, (Comparator)new a());
      }
      if (localObject1 == null) {
        break label217;
      }
      localObject2 = ((Iterable)localObject1).iterator();
      i = 0;
      l1 = 0L;
    }
    for (;;)
    {
      label111:
      long l2 = l1;
      int j;
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        j = i + 1;
        if (i < 0) {
          j.gfB();
        }
        localObject3 = (FileSystem.a)localObject3;
        l2 = l1;
        if (localObject3 != null)
        {
          String str = ((FileSystem.a)localObject3).name;
          p.g(str, "fileEntry.name");
          if (!p.i(".nomedia", str)) {
            break label212;
          }
        }
        label212:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label345;
          }
          l2 = l1 + ((FileSystem.a)localObject3).size;
          i = j;
          l1 = l2;
          break label111;
          localObject1 = null;
          break;
        }
        label217:
        l2 = 0L;
      }
      localObject2 = new StringBuilder("dump ").append(this.name).append(" fileCounts ");
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((List)localObject1).size());; localObject1 = null)
      {
        localObject1 = localObject1 + ", cost: " + localb.gFK.abj() + "ms, totalSize " + bt.sy(l2) + " \n";
        ad.i(this.TAG, (String)localObject1);
        localObject1 = new o(localObject1, Long.valueOf(l2));
        AppMethodBeat.o(167884);
        return localObject1;
      }
      label345:
      i = j;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(167882);
      int i = a.a((Comparable)Long.valueOf(((FileSystem.a)paramT1).LjK), (Comparable)Long.valueOf(((FileSystem.a)paramT2).LjK));
      AppMethodBeat.o(167882);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.f
 * JD-Core Version:    0.7.0.1
 */