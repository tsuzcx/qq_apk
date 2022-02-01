package com.tencent.mm.plugin.finder.report.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/HellVisitorEnterData;", "", "feedId", "", "liveId", "userName", "", "index", "onlineNum", "actionType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "commentscene", "enterStatus", "shareType", "shareUserName", "snsFeedid", "enterTime", "enterType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;", "(JJLjava/lang/String;JJLcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;JLcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "getCommentscene", "()Ljava/lang/String;", "getEnterStatus", "()J", "getEnterTime", "getEnterType", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;", "getFeedId", "getIndex", "getLiveId", "getOnlineNum", "getShareType", "getShareUserName", "getSnsFeedid", "getUserName", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
public final class q
{
  final long enterTime;
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
  final long vlt;
  final s.av vlu;
  
  public q(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, s.p paramp, String paramString2, long paramLong5, long paramLong6, String paramString3, String paramString4, long paramLong7, s.av paramav)
  {
    AppMethodBeat.i(251012);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.userName = paramString1;
    this.vln = paramLong3;
    this.vlo = paramLong4;
    this.vjL = paramp;
    this.vjM = paramString2;
    this.vlt = paramLong5;
    this.vlp = paramLong6;
    this.vlq = paramString3;
    this.vlr = paramString4;
    this.enterTime = paramLong7;
    this.vlu = paramav;
    AppMethodBeat.o(251012);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(251015);
    if (this != paramObject)
    {
      if ((paramObject instanceof q))
      {
        paramObject = (q)paramObject;
        if ((this.feedId != paramObject.feedId) || (this.liveId != paramObject.liveId) || (!p.j(this.userName, paramObject.userName)) || (this.vln != paramObject.vln) || (this.vlo != paramObject.vlo) || (!p.j(this.vjL, paramObject.vjL)) || (!p.j(this.vjM, paramObject.vjM)) || (this.vlt != paramObject.vlt) || (this.vlp != paramObject.vlp) || (!p.j(this.vlq, paramObject.vlq)) || (!p.j(this.vlr, paramObject.vlr)) || (this.enterTime != paramObject.enterTime) || (!p.j(this.vlu, paramObject.vlu))) {}
      }
    }
    else
    {
      AppMethodBeat.o(251015);
      return true;
    }
    AppMethodBeat.o(251015);
    return false;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(251014);
    long l = this.feedId;
    int i2 = (int)(l ^ l >>> 32);
    l = this.liveId;
    int i3 = (int)(l ^ l >>> 32);
    Object localObject = this.userName;
    int i;
    int i4;
    int i5;
    int j;
    label110:
    int k;
    label127:
    int i6;
    int i7;
    int m;
    if (localObject != null)
    {
      i = localObject.hashCode();
      l = this.vln;
      i4 = (int)(l ^ l >>> 32);
      l = this.vlo;
      i5 = (int)(l ^ l >>> 32);
      localObject = this.vjL;
      if (localObject == null) {
        break label314;
      }
      j = localObject.hashCode();
      localObject = this.vjM;
      if (localObject == null) {
        break label319;
      }
      k = localObject.hashCode();
      l = this.vlt;
      i6 = (int)(l ^ l >>> 32);
      l = this.vlp;
      i7 = (int)(l ^ l >>> 32);
      localObject = this.vlq;
      if (localObject == null) {
        break label324;
      }
      m = localObject.hashCode();
      label179:
      localObject = this.vlr;
      if (localObject == null) {
        break label330;
      }
    }
    label314:
    label319:
    label324:
    label330:
    for (int n = localObject.hashCode();; n = 0)
    {
      l = this.enterTime;
      int i8 = (int)(l ^ l >>> 32);
      localObject = this.vlu;
      if (localObject != null) {
        i1 = localObject.hashCode();
      }
      AppMethodBeat.o(251014);
      return ((n + (m + (((k + (j + (((i + (i2 * 31 + i3) * 31) * 31 + i4) * 31 + i5) * 31) * 31) * 31 + i6) * 31 + i7) * 31) * 31) * 31 + i8) * 31 + i1;
      i = 0;
      break;
      j = 0;
      break label110;
      k = 0;
      break label127;
      m = 0;
      break label179;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(251013);
    String str = "HellVisitorEnterData(feedId=" + this.feedId + ", liveId=" + this.liveId + ", userName=" + this.userName + ", index=" + this.vln + ", onlineNum=" + this.vlo + ", actionType=" + this.vjL + ", commentscene=" + this.vjM + ", enterStatus=" + this.vlt + ", shareType=" + this.vlp + ", shareUserName=" + this.vlq + ", snsFeedid=" + this.vlr + ", enterTime=" + this.enterTime + ", enterType=" + this.vlu + ")";
    AppMethodBeat.o(251013);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.live.q
 * JD-Core Version:    0.7.0.1
 */