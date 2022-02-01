package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cacheCommentExtras", "", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$CacheKey;", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$Extra;", "cacheComments", "", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "addCommentsCache", "", "feedId", "", "refCommentId", "comments", "addExtraCache", "pos", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "", "downContinue", "hasExpand", "clearCache", "getComments", "getExtra", "getStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage;", "markUnsentCommentsCanRemove", "CacheKey", "Extra", "plugin-finder_release"})
public final class e
{
  private static final String TAG = "Finder.FinderCommentCache";
  private static final Map<e.a, List<t>> rEG;
  private static final Map<e.a, e.b> rEH;
  public static final e rEI;
  
  static
  {
    AppMethodBeat.i(167059);
    rEI = new e();
    TAG = "Finder.FinderCommentCache";
    rEG = (Map)new LinkedHashMap();
    rEH = (Map)new LinkedHashMap();
    AppMethodBeat.o(167059);
  }
  
  private void N(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(167054);
    try
    {
      rEG.remove(new e.a(paramLong1, paramLong2));
      rEH.remove(new e.a(paramLong1, paramLong2));
      return;
    }
    finally
    {
      AppMethodBeat.o(167054);
    }
  }
  
  public final List<t> O(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(167057);
    try
    {
      List localList = (List)rEG.get(new e.a(paramLong1, paramLong2));
      return localList;
    }
    finally
    {
      AppMethodBeat.o(167057);
    }
  }
  
  public final e.b P(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(167058);
    try
    {
      e.b localb = (e.b)rEH.get(new e.a(paramLong1, paramLong2));
      return localb;
    }
    finally
    {
      AppMethodBeat.o(167058);
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt, b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(178422);
    try
    {
      rEH.put(new e.a(paramLong1, paramLong2), new e.b(paramInt, paramb, paramBoolean1, paramBoolean2, paramBoolean3));
      return;
    }
    finally
    {
      AppMethodBeat.o(178422);
    }
  }
  
  public final void a(long paramLong1, long paramLong2, List<t> paramList)
  {
    AppMethodBeat.i(167052);
    k.h(paramList, "comments");
    try
    {
      rEI.N(paramLong1, paramLong2);
      rEG.put(new e.a(paramLong1, paramLong2), paramList);
      return;
    }
    finally
    {
      AppMethodBeat.o(167052);
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(167056);
    ac.i(TAG, "clearCache all");
    try
    {
      rEG.clear();
      rEH.clear();
      y localy = y.KTp;
      return;
    }
    finally
    {
      AppMethodBeat.o(167056);
    }
  }
  
  public final void uU(long paramLong)
  {
    AppMethodBeat.i(167055);
    Map.Entry localEntry;
    int i;
    for (;;)
    {
      try
      {
        localObject2 = rEG;
        Map localMap1 = (Map)new LinkedHashMap();
        localObject2 = ((Map)localObject2).entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localEntry = (Map.Entry)((Iterator)localObject2).next();
        if (((e.a)localEntry.getKey()).dig != paramLong)
        {
          i = 1;
          if (i != 0) {
            localMap1.put(localEntry.getKey(), localEntry.getValue());
          }
        }
        else
        {
          i = 0;
        }
      }
      finally
      {
        AppMethodBeat.o(167055);
      }
    }
    rEG.clear();
    rEG.putAll(localMap2);
    Object localObject2 = rEH;
    Object localObject1 = (Map)new LinkedHashMap();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    label277:
    label280:
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject2).next();
        if (((e.a)localEntry.getKey()).dig == paramLong) {
          break label277;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label280;
        }
        ((Map)localObject1).put(localEntry.getKey(), localEntry.getValue());
        break;
        rEH.clear();
        rEH.putAll((Map)localObject1);
        localObject1 = y.KTp;
        AppMethodBeat.o(167055);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.e
 * JD-Core Version:    0.7.0.1
 */