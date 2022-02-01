package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.bkk;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveAdNoticeCache;", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheKey;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheValue;", "requestInterval", "", "getRequestInterval", "()I", "setRequestInterval", "(I)V", "assignRequestInterval", "", "_requestInterval", "getNoticeState", "", "username", "", "noticeId", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "save", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "update", "reserved", "CacheKey", "CacheValue", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements aj
{
  public static final a BvB;
  private static int BvC;
  private static final ConcurrentHashMap<a.a, b> BvD;
  
  static
  {
    AppMethodBeat.i(350719);
    BvB = new a();
    BvC = 60;
    BvD = new ConcurrentHashMap();
    AppMethodBeat.o(350719);
  }
  
  public final void Ow(int paramInt)
  {
    BvC = paramInt;
  }
  
  public final void a(String paramString1, String paramString2, bkk parambkk)
  {
    AppMethodBeat.i(350727);
    s.u(paramString1, "username");
    s.u(paramString2, "noticeId");
    s.u(parambkk, "noticeInfo");
    BvD.put(new a.a(paramString1, paramString2), new b(parambkk, cn.getSyncServerTimeSecond()));
    AppMethodBeat.o(350727);
  }
  
  public final Boolean hJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(350737);
    s.u(paramString1, "username");
    s.u(paramString2, "noticeId");
    paramString1 = (b)BvD.get(new a.a(paramString1, paramString2));
    if ((paramString1 != null) && (cn.getSyncServerTimeSecond() - paramString1.BvF < BvC))
    {
      if (paramString1.BvE.status == 0) {}
      for (boolean bool = true;; bool = false)
      {
        AppMethodBeat.o(350737);
        return Boolean.valueOf(bool);
      }
    }
    AppMethodBeat.o(350737);
    return null;
  }
  
  public final void u(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(350732);
    s.u(paramString1, "username");
    s.u(paramString2, "noticeId");
    paramString1 = new a.a(paramString1, paramString2);
    paramString1 = (b)BvD.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.BvE;
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (int i = 0;; i = 1)
    {
      paramString1.status = i;
      AppMethodBeat.o(350732);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdNoticeCache$CacheValue;", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "saveTimeSec", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;I)V", "getNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getSaveTimeSec", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final bkk BvE;
    final int BvF;
    
    public b(bkk parambkk, int paramInt)
    {
      AppMethodBeat.i(351222);
      this.BvE = parambkk;
      this.BvF = paramInt;
      AppMethodBeat.o(351222);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(351259);
      if (this == paramObject)
      {
        AppMethodBeat.o(351259);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(351259);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.BvE, paramObject.BvE))
      {
        AppMethodBeat.o(351259);
        return false;
      }
      if (this.BvF != paramObject.BvF)
      {
        AppMethodBeat.o(351259);
        return false;
      }
      AppMethodBeat.o(351259);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(351251);
      int i = this.BvE.hashCode();
      int j = this.BvF;
      AppMethodBeat.o(351251);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(351239);
      String str = "CacheValue(noticeInfo=" + this.BvE + ", saveTimeSec=" + this.BvF + ')';
      AppMethodBeat.o(351239);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.a
 * JD-Core Version:    0.7.0.1
 */