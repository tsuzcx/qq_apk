package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.c;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "", "path", "", "name", "maxSize", "", "markNoMedia", "", "enableClear", "(Ljava/lang/String;Ljava/lang/String;JZZ)V", "TAG", "getEnableClear", "()Z", "getMarkNoMedia", "getMaxSize", "()J", "getName", "()Ljava/lang/String;", "getPath", "dumpCacheDir", "Lkotlin/Pair;", "initFolder", "", "isNoMedia", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  private final boolean GgB;
  final boolean GgC;
  private final String TAG;
  final long cBA;
  final String name;
  final String path;
  
  public p(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(167885);
    this.path = paramString1;
    this.name = paramString2;
    this.cBA = paramLong;
    this.GgB = paramBoolean1;
    this.GgC = paramBoolean2;
    this.TAG = "Finder.FinderFolder";
    AppMethodBeat.o(167885);
  }
  
  private static boolean aBw(String paramString)
  {
    AppMethodBeat.i(333663);
    if (s.p(".nomedia", paramString))
    {
      AppMethodBeat.o(333663);
      return true;
    }
    AppMethodBeat.o(333663);
    return false;
  }
  
  public final void feO()
  {
    AppMethodBeat.i(167883);
    y.bDX(this.path);
    if (this.GgB) {
      y.bEr(this.path);
    }
    AppMethodBeat.o(167883);
  }
  
  public final r<String, Long> feP()
  {
    AppMethodBeat.i(167884);
    c localc = new c("dumpCacheDir");
    Object localObject1 = this.path;
    Log.i(this.TAG, s.X("dumpCacheDir cache ", localObject1));
    localObject1 = y.eB((String)localObject1, true);
    long l1;
    long l2;
    Object localObject2;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 != null) && (((List)localObject1).size() > 1)) {
        kotlin.a.p.a((List)localObject1, (Comparator)new p.a());
      }
      l1 = 0L;
      l2 = l1;
      if (localObject1 == null) {
        break label208;
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
          kotlin.a.p.kkW();
        }
        localObject3 = (j)localObject3;
        l2 = l1;
        if (localObject3 != null)
        {
          String str = ((j)localObject3).name;
          s.s(str, "fileEntry.name");
          if (aBw(str)) {
            break label333;
          }
          l2 = l1 + ((j)localObject3).size;
        }
        i = j;
        l1 = l2;
        continue;
        localObject1 = ah.c((Iterable)localObject1);
        break;
      }
      label208:
      localObject2 = new StringBuilder("dump ").append(this.name).append(" fileCounts ");
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = Integer.valueOf(((List)localObject1).size()))
      {
        localObject1 = localObject1 + ", cost: " + localc.mHw.aPY() + "ms, totalSize " + Util.getSizeKB(l2) + " \n";
        Log.i(this.TAG, (String)localObject1);
        localObject1 = new r(localObject1, Long.valueOf(l2));
        AppMethodBeat.o(167884);
        return localObject1;
      }
      label333:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.p
 * JD-Core Version:    0.7.0.1
 */