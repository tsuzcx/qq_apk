package com.tencent.mm.plugin.finder.report.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/HellVisitorClickData;", "", "feedId", "", "liveId", "userName", "", "index", "onlineNum", "actionType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "commentscene", "shareType", "shareUserName", "snsFeedid", "enterIconType", "", "(JJLjava/lang/String;JJLcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "getCommentscene", "()Ljava/lang/String;", "getEnterIconType", "()I", "getFeedId", "()J", "getIndex", "getLiveId", "getOnlineNum", "getShareType", "getShareUserName", "getSnsFeedid", "getUserName", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class p
{
  final long feedId;
  final long liveId;
  final String userName;
  final s.p vjL;
  final String vjM;
  final long vln;
  final long vlo;
  final long vlp;
  final String vlq;
  final String vlr;
  private final int vls;
  
  private p(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, s.p paramp, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(251007);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.userName = paramString1;
    this.vln = paramLong3;
    this.vlo = paramLong4;
    this.vjL = paramp;
    this.vjM = paramString2;
    this.vlp = 0L;
    this.vlq = paramString3;
    this.vlr = paramString4;
    this.vls = 0;
    AppMethodBeat.o(251007);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(251011);
    if (this != paramObject)
    {
      if ((paramObject instanceof p))
      {
        paramObject = (p)paramObject;
        if ((this.feedId != paramObject.feedId) || (this.liveId != paramObject.liveId) || (!kotlin.g.b.p.j(this.userName, paramObject.userName)) || (this.vln != paramObject.vln) || (this.vlo != paramObject.vlo) || (!kotlin.g.b.p.j(this.vjL, paramObject.vjL)) || (!kotlin.g.b.p.j(this.vjM, paramObject.vjM)) || (this.vlp != paramObject.vlp) || (!kotlin.g.b.p.j(this.vlq, paramObject.vlq)) || (!kotlin.g.b.p.j(this.vlr, paramObject.vlr)) || (this.vls != paramObject.vls)) {}
      }
    }
    else
    {
      AppMethodBeat.o(251011);
      return true;
    }
    AppMethodBeat.o(251011);
    return false;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(251010);
    long l = this.feedId;
    int i1 = (int)(l ^ l >>> 32);
    l = this.liveId;
    int i2 = (int)(l ^ l >>> 32);
    Object localObject = this.userName;
    int i;
    int i3;
    int i4;
    int j;
    label110:
    int k;
    label127:
    int i5;
    if (localObject != null)
    {
      i = localObject.hashCode();
      l = this.vln;
      i3 = (int)(l ^ l >>> 32);
      l = this.vlo;
      i4 = (int)(l ^ l >>> 32);
      localObject = this.vjL;
      if (localObject == null) {
        break label256;
      }
      j = localObject.hashCode();
      localObject = this.vjM;
      if (localObject == null) {
        break label261;
      }
      k = localObject.hashCode();
      l = this.vlp;
      i5 = (int)(l ^ l >>> 32);
      localObject = this.vlq;
      if (localObject == null) {
        break label266;
      }
    }
    label256:
    label261:
    label266:
    for (int m = localObject.hashCode();; m = 0)
    {
      localObject = this.vlr;
      if (localObject != null) {
        n = localObject.hashCode();
      }
      int i6 = this.vls;
      AppMethodBeat.o(251010);
      return ((m + ((k + (j + (((i + (i1 * 31 + i2) * 31) * 31 + i3) * 31 + i4) * 31) * 31) * 31 + i5) * 31) * 31 + n) * 31 + i6;
      i = 0;
      break;
      j = 0;
      break label110;
      k = 0;
      break label127;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(251009);
    String str = "HellVisitorClickData(feedId=" + this.feedId + ", liveId=" + this.liveId + ", userName=" + this.userName + ", index=" + this.vln + ", onlineNum=" + this.vlo + ", actionType=" + this.vjL + ", commentscene=" + this.vjM + ", shareType=" + this.vlp + ", shareUserName=" + this.vlq + ", snsFeedid=" + this.vlr + ", enterIconType=" + this.vls + ")";
    AppMethodBeat.o(251009);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.live.p
 * JD-Core Version:    0.7.0.1
 */