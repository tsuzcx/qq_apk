package com.tencent.mm.plugin.finder.storage.data;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cacheBulletSubtitleComments", "", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$CacheKey;", "", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "cacheCommentExtras", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$Extra;", "cacheComments", "addBulletSubtitleComments", "", "feedId", "", "refCommentId", "comments", "addCommentsCache", "addExtraCache", "pos", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "", "downContinue", "hasExpand", "clearBulletSubtitleCache", "clearCache", "getBulletSubtitleComments", "getComments", "getExtra", "getStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage;", "markUnsentCommentsCanRemove", "CacheKey", "Extra", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f FMT;
  private static final Map<a, List<au>> FMU;
  private static final Map<a, b> FMV;
  public static final Map<a, List<au>> FMW;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(167059);
    FMT = new f();
    TAG = "Finder.FinderCommentCache";
    FMU = (Map)new LinkedHashMap();
    FMV = (Map)new LinkedHashMap();
    FMW = (Map)new LinkedHashMap();
    AppMethodBeat.o(167059);
  }
  
  private void av(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(167054);
    try
    {
      FMU.remove(new a(paramLong1, paramLong2));
      FMV.remove(new a(paramLong1, paramLong2));
      return;
    }
    finally
    {
      AppMethodBeat.o(167054);
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt, b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(178422);
    try
    {
      FMV.put(new a(paramLong1, paramLong2), new b(paramInt, paramb, paramBoolean1, paramBoolean2, paramBoolean3));
      return;
    }
    finally
    {
      AppMethodBeat.o(178422);
    }
  }
  
  public final void a(long paramLong1, long paramLong2, List<au> paramList)
  {
    AppMethodBeat.i(167052);
    s.u(paramList, "comments");
    try
    {
      FMT.av(paramLong1, paramLong2);
      FMU.put(new a(paramLong1, paramLong2), paramList);
      return;
    }
    finally
    {
      AppMethodBeat.o(167052);
    }
  }
  
  public final List<au> aw(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(167057);
    try
    {
      List localList = (List)FMU.get(new a(paramLong1, paramLong2));
      return localList;
    }
    finally
    {
      AppMethodBeat.o(167057);
    }
  }
  
  public final b ax(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(167058);
    try
    {
      b localb = (b)FMV.get(new a(paramLong1, paramLong2));
      return localb;
    }
    finally
    {
      AppMethodBeat.o(167058);
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(167056);
    Log.i(TAG, "clearCache all");
    try
    {
      FMU.clear();
      FMV.clear();
      FMW.clear();
      ah localah = ah.aiuX;
      return;
    }
    finally
    {
      AppMethodBeat.o(167056);
    }
  }
  
  public final void oz(long paramLong)
  {
    AppMethodBeat.i(167055);
    Map.Entry localEntry;
    int i;
    for (;;)
    {
      try
      {
        localObject2 = FMU;
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
    FMU.clear();
    FMU.putAll(localMap2);
    Object localObject2 = FMV;
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
        FMV.clear();
        FMV.putAll((Map)localObject1);
        localObject1 = ah.aiuX;
        AppMethodBeat.o(167055);
        return;
      }
    }
  }
  
  public final List<au> qj(long paramLong)
  {
    AppMethodBeat.i(339387);
    try
    {
      List localList = (List)FMW.get(new a(paramLong, 0L));
      return localList;
    }
    finally
    {
      AppMethodBeat.o(339387);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$CacheKey;", "", "feedId", "", "refCommentId", "(JJ)V", "getFeedId", "()J", "getRefCommentId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private final long AAW;
    final long feedId;
    
    public a(long paramLong1, long paramLong2)
    {
      this.feedId = paramLong1;
      this.AAW = paramLong2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.feedId != paramObject.feedId) {
          return false;
        }
      } while (this.AAW == paramObject.AAW);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(339277);
      int i = q.a..ExternalSyntheticBackport0.m(this.feedId);
      int j = q.a..ExternalSyntheticBackport0.m(this.AAW);
      AppMethodBeat.o(339277);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(167048);
      String str = "CacheKey(feedId=" + this.feedId + ", refCommentId=" + this.AAW + ')';
      AppMethodBeat.o(167048);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$Extra;", "", "pos", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "", "downContinue", "hasExpand", "(ILcom/tencent/mm/protobuf/ByteString;ZZZ)V", "getDownContinue", "()Z", "getHasExpand", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPos", "()I", "getUpContinue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public final boolean AUo;
    public final boolean AUp;
    public final boolean FMX;
    public final b lastBuffer;
    public final int pos;
    
    public b(int paramInt, b paramb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.pos = paramInt;
      this.lastBuffer = paramb;
      this.AUo = paramBoolean1;
      this.AUp = paramBoolean2;
      this.FMX = paramBoolean3;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(167051);
      if (this == paramObject)
      {
        AppMethodBeat.o(167051);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(167051);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.pos != paramObject.pos)
      {
        AppMethodBeat.o(167051);
        return false;
      }
      if (!s.p(this.lastBuffer, paramObject.lastBuffer))
      {
        AppMethodBeat.o(167051);
        return false;
      }
      if (this.AUo != paramObject.AUo)
      {
        AppMethodBeat.o(167051);
        return false;
      }
      if (this.AUp != paramObject.AUp)
      {
        AppMethodBeat.o(167051);
        return false;
      }
      if (this.FMX != paramObject.FMX)
      {
        AppMethodBeat.o(167051);
        return false;
      }
      AppMethodBeat.o(167051);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(167049);
      String str = "Extra(pos=" + this.pos + ", lastBuffer=" + this.lastBuffer + ", upContinue=" + this.AUo + ", downContinue=" + this.AUp + ", hasExpand=" + this.FMX + ')';
      AppMethodBeat.o(167049);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.f
 * JD-Core Version:    0.7.0.1
 */