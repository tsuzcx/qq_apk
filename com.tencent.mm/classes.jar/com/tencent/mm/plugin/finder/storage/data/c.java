package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.y;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cacheCommentExtras", "", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$CacheKey;", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$Extra;", "cacheComments", "", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "addCommentsCache", "", "feedId", "", "refCommentId", "comments", "addExtraCache", "pos", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "", "downContinue", "hasExpand", "clearCache", "getComments", "getExtra", "getStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage;", "markUnsentCommentsCanRemove", "CacheKey", "Extra", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "Finder.FinderCommentCache";
  private static final Map<a, List<com.tencent.mm.plugin.finder.storage.k>> qKm;
  private static final Map<a, b> qKn;
  public static final c qKo;
  
  static
  {
    AppMethodBeat.i(167059);
    qKo = new c();
    TAG = "Finder.FinderCommentCache";
    qKm = (Map)new LinkedHashMap();
    qKn = (Map)new LinkedHashMap();
    AppMethodBeat.o(167059);
  }
  
  private void Q(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(167054);
    try
    {
      qKm.remove(new a(paramLong1, paramLong2));
      qKn.remove(new a(paramLong1, paramLong2));
      return;
    }
    finally
    {
      AppMethodBeat.o(167054);
    }
  }
  
  public final List<com.tencent.mm.plugin.finder.storage.k> R(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(167057);
    try
    {
      List localList = (List)qKm.get(new a(paramLong1, paramLong2));
      return localList;
    }
    finally
    {
      AppMethodBeat.o(167057);
    }
  }
  
  public final b S(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(167058);
    try
    {
      b localb = (b)qKn.get(new a(paramLong1, paramLong2));
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
      qKn.put(new a(paramLong1, paramLong2), new b(paramInt, paramb, paramBoolean1, paramBoolean2, paramBoolean3));
      return;
    }
    finally
    {
      AppMethodBeat.o(178422);
    }
  }
  
  public final void a(long paramLong1, long paramLong2, List<com.tencent.mm.plugin.finder.storage.k> paramList)
  {
    AppMethodBeat.i(167052);
    d.g.b.k.h(paramList, "comments");
    try
    {
      qKo.Q(paramLong1, paramLong2);
      qKm.put(new a(paramLong1, paramLong2), paramList);
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
    ad.i(TAG, "clearCache all");
    try
    {
      qKm.clear();
      qKn.clear();
      y localy = y.JfV;
      return;
    }
    finally
    {
      AppMethodBeat.o(167056);
    }
  }
  
  public final void qD(long paramLong)
  {
    AppMethodBeat.i(167055);
    Map.Entry localEntry;
    int i;
    for (;;)
    {
      try
      {
        localObject2 = qKm;
        Map localMap1 = (Map)new LinkedHashMap();
        localObject2 = ((Map)localObject2).entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localEntry = (Map.Entry)((Iterator)localObject2).next();
        if (((a)localEntry.getKey()).feedId != paramLong)
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
    qKm.clear();
    qKm.putAll(localMap2);
    Object localObject2 = qKn;
    Object localObject1 = (Map)new LinkedHashMap();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    label277:
    label280:
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject2).next();
        if (((a)localEntry.getKey()).feedId == paramLong) {
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
        qKn.clear();
        qKn.putAll((Map)localObject1);
        localObject1 = y.JfV;
        AppMethodBeat.o(167055);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$CacheKey;", "", "feedId", "", "refCommentId", "(JJ)V", "getFeedId", "()J", "getRefCommentId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    final long feedId;
    private final long qoE;
    
    public a(long paramLong1, long paramLong2)
    {
      this.feedId = paramLong1;
      this.qoE = paramLong2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.feedId != paramObject.feedId) || (this.qoE != paramObject.qoE)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      long l = this.feedId;
      int i = (int)(l ^ l >>> 32);
      l = this.qoE;
      return i * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(167048);
      String str = "CacheKey(feedId=" + this.feedId + ", refCommentId=" + this.qoE + ")";
      AppMethodBeat.o(167048);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$Extra;", "", "pos", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "", "downContinue", "hasExpand", "(ILcom/tencent/mm/protobuf/ByteString;ZZZ)V", "getDownContinue", "()Z", "getHasExpand", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPos", "()I", "getUpContinue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    public final b lastBuffer;
    public final int pos;
    public final boolean qKp;
    public final boolean quA;
    public final boolean quz;
    
    public b(int paramInt, b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.pos = paramInt;
      this.lastBuffer = paramb;
      this.quz = paramBoolean1;
      this.quA = paramBoolean2;
      this.qKp = paramBoolean3;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(167051);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.pos != paramObject.pos) || (!d.g.b.k.g(this.lastBuffer, paramObject.lastBuffer)) || (this.quz != paramObject.quz) || (this.quA != paramObject.quA) || (this.qKp != paramObject.qKp)) {}
        }
      }
      else
      {
        AppMethodBeat.o(167051);
        return true;
      }
      AppMethodBeat.o(167051);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(167049);
      String str = "Extra(pos=" + this.pos + ", lastBuffer=" + this.lastBuffer + ", upContinue=" + this.quz + ", downContinue=" + this.quA + ", hasExpand=" + this.qKp + ")";
      AppMethodBeat.o(167049);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.c
 * JD-Core Version:    0.7.0.1
 */