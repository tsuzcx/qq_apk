package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import d.a.j;
import d.b.a;
import d.g.b.k;
import d.l;
import d.o;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "", "path", "", "name", "maxSize", "", "markNoMedia", "", "enableClear", "(Ljava/lang/String;Ljava/lang/String;JZZ)V", "TAG", "getEnableClear", "()Z", "getMarkNoMedia", "getMaxSize", "()J", "getName", "()Ljava/lang/String;", "getPath", "dumpCacheDir", "Lkotlin/Pair;", "initFolder", "", "isNoMedia", "plugin-finder_release"})
public final class c
{
  private final String TAG;
  final long maxSize;
  final String name;
  final String path;
  private final boolean qSl;
  final boolean qSm;
  
  public c(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(167885);
    this.path = paramString1;
    this.name = paramString2;
    this.maxSize = paramLong;
    this.qSl = paramBoolean1;
    this.qSm = paramBoolean2;
    this.TAG = "Finder.FinderFolder";
    AppMethodBeat.o(167885);
  }
  
  public final void crM()
  {
    AppMethodBeat.i(167883);
    i.aMF(this.path);
    if (this.qSl) {
      i.aMT(this.path);
    }
    AppMethodBeat.o(167883);
  }
  
  public final o<String, Long> crN()
  {
    AppMethodBeat.i(167884);
    b localb = new b("dumpCacheDir");
    Object localObject1 = this.path;
    ad.i(this.TAG, "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    localObject1 = i.cT((String)localObject1, true);
    long l1;
    long l2;
    int i;
    label114:
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = q.b((Iterable)localObject1);
      if ((localObject1 != null) && (((List)localObject1).size() > 1)) {
        j.a((List)localObject1, (Comparator)new a());
      }
      l1 = 0L;
      l2 = l1;
      if (localObject1 == null) {
        break label221;
      }
      localObject2 = ((Iterable)localObject1).iterator();
      i = 0;
      l2 = l1;
      if (!((Iterator)localObject2).hasNext()) {
        break label221;
      }
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        j.fvx();
      }
      localObject3 = (FileSystem.a)localObject3;
      l2 = l1;
      if (localObject3 != null)
      {
        String str = ((FileSystem.a)localObject3).name;
        k.g(str, "fileEntry.name");
        if (!k.g(".nomedia", str)) {
          break label216;
        }
      }
    }
    label216:
    for (int j = 1;; j = 0)
    {
      l2 = l1;
      if (j == 0) {
        l2 = l1 + ((FileSystem.a)localObject3).size;
      }
      i += 1;
      l1 = l2;
      break label114;
      localObject1 = null;
      break;
    }
    label221:
    Object localObject2 = new StringBuilder("dump ").append(this.name).append(" fileCounts ");
    if (localObject1 != null) {}
    for (localObject1 = Integer.valueOf(((List)localObject1).size());; localObject1 = null)
    {
      localObject1 = localObject1 + ", cost: " + localb.ghu.XK() + "ms, totalSize " + bt.mK(l2) + " \n";
      ad.i(this.TAG, (String)localObject1);
      localObject1 = new o(localObject1, Long.valueOf(l2));
      AppMethodBeat.o(167884);
      return localObject1;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(167882);
      int i = a.a((Comparable)Long.valueOf(((FileSystem.a)paramT1).HRA), (Comparable)Long.valueOf(((FileSystem.a)paramT2).HRA));
      AppMethodBeat.o(167882);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.c
 * JD-Core Version:    0.7.0.1
 */