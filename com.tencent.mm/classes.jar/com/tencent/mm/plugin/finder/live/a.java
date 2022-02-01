package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.awt;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache;", "", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheKey;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheValue;", "requestInterval", "", "getRequestInterval", "()I", "setRequestInterval", "(I)V", "getNoticeState", "", "username", "", "noticeId", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "save", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "update", "reserved", "CacheKey", "CacheValue", "plugin-finder_release"})
public final class a
{
  private static final ConcurrentHashMap<a.a, b> cache;
  private static int ufh;
  public static final a ufi;
  
  static
  {
    AppMethodBeat.i(245785);
    ufi = new a();
    ufh = 60;
    cache = new ConcurrentHashMap();
    AppMethodBeat.o(245785);
  }
  
  public static void IV(int paramInt)
  {
    ufh = paramInt;
  }
  
  public static void a(String paramString1, String paramString2, awt paramawt)
  {
    AppMethodBeat.i(245782);
    p.h(paramString1, "username");
    p.h(paramString2, "noticeId");
    p.h(paramawt, "noticeInfo");
    cache.put(new a.a(paramString1, paramString2), new b(paramawt, cl.aWB()));
    AppMethodBeat.o(245782);
  }
  
  public static Boolean gK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(245784);
    p.h(paramString1, "username");
    p.h(paramString2, "noticeId");
    paramString1 = (b)cache.get(new a.a(paramString1, paramString2));
    if ((paramString1 != null) && (cl.aWB() - paramString1.ufk < ufh))
    {
      if (paramString1.ufj.status == 0) {}
      for (boolean bool = true;; bool = false)
      {
        AppMethodBeat.o(245784);
        return Boolean.valueOf(bool);
      }
    }
    AppMethodBeat.o(245784);
    return null;
  }
  
  public static void q(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(245783);
    p.h(paramString1, "username");
    p.h(paramString2, "noticeId");
    paramString1 = new a.a(paramString1, paramString2);
    paramString1 = (b)cache.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.ufj;
      if (paramString1 != null)
      {
        if (paramBoolean) {}
        for (int i = 0;; i = 1)
        {
          paramString1.status = i;
          AppMethodBeat.o(245783);
          return;
        }
      }
    }
    AppMethodBeat.o(245783);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheValue;", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "saveTimeSec", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;I)V", "getNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getSaveTimeSec", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    final awt ufj;
    final int ufk;
    
    public b(awt paramawt, int paramInt)
    {
      AppMethodBeat.i(245778);
      this.ufj = paramawt;
      this.ufk = paramInt;
      AppMethodBeat.o(245778);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(245781);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.ufj, paramObject.ufj)) || (this.ufk != paramObject.ufk)) {}
        }
      }
      else
      {
        AppMethodBeat.o(245781);
        return true;
      }
      AppMethodBeat.o(245781);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(245780);
      awt localawt = this.ufj;
      if (localawt != null) {}
      for (int i = localawt.hashCode();; i = 0)
      {
        int j = this.ufk;
        AppMethodBeat.o(245780);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(245779);
      String str = "CacheValue(noticeInfo=" + this.ufj + ", saveTimeSec=" + this.ufk + ")";
      AppMethodBeat.o(245779);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.a
 * JD-Core Version:    0.7.0.1
 */