package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.protocal.protobuf.bbh;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache;", "", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheKey;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheValue;", "requestInterval", "", "getRequestInterval", "()I", "setRequestInterval", "(I)V", "getNoticeState", "", "username", "", "noticeId", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "save", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "update", "reserved", "CacheKey", "CacheValue", "plugin-finder_release"})
public final class a
{
  private static final ConcurrentHashMap<a.a, b> cache;
  private static int xUB;
  public static final a xUC;
  
  static
  {
    AppMethodBeat.i(288888);
    xUC = new a();
    xUB = 60;
    cache = new ConcurrentHashMap();
    AppMethodBeat.o(288888);
  }
  
  public static void MT(int paramInt)
  {
    xUB = paramInt;
  }
  
  public static void a(String paramString1, String paramString2, bbh parambbh)
  {
    AppMethodBeat.i(288885);
    p.k(paramString1, "username");
    p.k(paramString2, "noticeId");
    p.k(parambbh, "noticeInfo");
    cache.put(new a.a(paramString1, paramString2), new b(parambbh, cm.bfF()));
    AppMethodBeat.o(288885);
  }
  
  public static Boolean gY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(288887);
    p.k(paramString1, "username");
    p.k(paramString2, "noticeId");
    paramString1 = (b)cache.get(new a.a(paramString1, paramString2));
    if ((paramString1 != null) && (cm.bfF() - paramString1.xUE < xUB))
    {
      if (paramString1.xUD.status == 0) {}
      for (boolean bool = true;; bool = false)
      {
        AppMethodBeat.o(288887);
        return Boolean.valueOf(bool);
      }
    }
    AppMethodBeat.o(288887);
    return null;
  }
  
  public static void r(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(288886);
    p.k(paramString1, "username");
    p.k(paramString2, "noticeId");
    paramString1 = new a.a(paramString1, paramString2);
    paramString1 = (b)cache.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.xUD;
      if (paramString1 != null)
      {
        if (paramBoolean) {}
        for (int i = 0;; i = 1)
        {
          paramString1.status = i;
          AppMethodBeat.o(288886);
          return;
        }
      }
    }
    AppMethodBeat.o(288886);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheValue;", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "saveTimeSec", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;I)V", "getNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getSaveTimeSec", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    final bbh xUD;
    final int xUE;
    
    public b(bbh parambbh, int paramInt)
    {
      AppMethodBeat.i(256856);
      this.xUD = parambbh;
      this.xUE = paramInt;
      AppMethodBeat.o(256856);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(256864);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.h(this.xUD, paramObject.xUD)) || (this.xUE != paramObject.xUE)) {}
        }
      }
      else
      {
        AppMethodBeat.o(256864);
        return true;
      }
      AppMethodBeat.o(256864);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(256861);
      bbh localbbh = this.xUD;
      if (localbbh != null) {}
      for (int i = localbbh.hashCode();; i = 0)
      {
        int j = this.xUE;
        AppMethodBeat.o(256861);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(256858);
      String str = "CacheValue(noticeInfo=" + this.xUD + ", saveTimeSec=" + this.xUE + ")";
      AppMethodBeat.o(256858);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.a
 * JD-Core Version:    0.7.0.1
 */