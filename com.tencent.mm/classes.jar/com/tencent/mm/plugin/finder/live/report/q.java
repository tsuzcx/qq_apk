package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/HellVisitorEnterData;", "", "feedId", "", "liveId", "userName", "", "index", "onlineNum", "actionType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "commentscene", "enterStatus", "shareType", "shareUserName", "snsFeedid", "enterTime", "enterType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;", "sessionBuf", "clickTabContextId", "clickSubTabContextId", "chnlExtra", "(JJLjava/lang/String;JJLcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;JLcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "getChnlExtra", "()Ljava/lang/String;", "getClickSubTabContextId", "getClickTabContextId", "getCommentscene", "getEnterStatus", "()J", "getEnterTime", "getEnterType", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;", "getFeedId", "getIndex", "getLiveId", "getOnlineNum", "getSessionBuf", "getShareType", "getShareUserName", "getSnsFeedid", "getUserName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
public final class q
{
  final long enterTime;
  final long feedId;
  final String kit;
  final long liveId;
  final String userName;
  private final String wmz;
  final s.t yAO;
  final String yAP;
  final String yAU;
  final String yAV;
  final String yCA;
  final long yCC;
  final s.bj yCD;
  final String yCE;
  final long yCx;
  final long yCy;
  final long yCz;
  
  private q(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, s.t paramt, String paramString2, long paramLong5, long paramLong6, String paramString3, String paramString4, long paramLong7, s.bj parambj, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(288709);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.userName = paramString1;
    this.yCx = paramLong3;
    this.yCy = paramLong4;
    this.yAO = paramt;
    this.yAP = paramString2;
    this.yCC = paramLong5;
    this.yCz = paramLong6;
    this.kit = paramString3;
    this.yCA = paramString4;
    this.enterTime = paramLong7;
    this.yCD = parambj;
    this.yCE = paramString5;
    this.wmz = paramString6;
    this.yAU = paramString7;
    this.yAV = paramString8;
    AppMethodBeat.o(288709);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(288713);
    if (this != paramObject)
    {
      if ((paramObject instanceof q))
      {
        paramObject = (q)paramObject;
        if ((this.feedId != paramObject.feedId) || (this.liveId != paramObject.liveId) || (!p.h(this.userName, paramObject.userName)) || (this.yCx != paramObject.yCx) || (this.yCy != paramObject.yCy) || (!p.h(this.yAO, paramObject.yAO)) || (!p.h(this.yAP, paramObject.yAP)) || (this.yCC != paramObject.yCC) || (this.yCz != paramObject.yCz) || (!p.h(this.kit, paramObject.kit)) || (!p.h(this.yCA, paramObject.yCA)) || (this.enterTime != paramObject.enterTime) || (!p.h(this.yCD, paramObject.yCD)) || (!p.h(this.yCE, paramObject.yCE)) || (!p.h(this.wmz, paramObject.wmz)) || (!p.h(this.yAU, paramObject.yAU)) || (!p.h(this.yAV, paramObject.yAV))) {}
      }
    }
    else
    {
      AppMethodBeat.o(288713);
      return true;
    }
    AppMethodBeat.o(288713);
    return false;
  }
  
  public final int hashCode()
  {
    int i5 = 0;
    AppMethodBeat.i(288712);
    long l = this.feedId;
    int i6 = (int)(l ^ l >>> 32);
    l = this.liveId;
    int i7 = (int)(l ^ l >>> 32);
    Object localObject = this.userName;
    int i;
    int i8;
    int i9;
    int j;
    label110:
    int k;
    label127:
    int i10;
    int i11;
    int m;
    label179:
    int n;
    label197:
    int i12;
    int i1;
    label232:
    int i2;
    label250:
    int i3;
    if (localObject != null)
    {
      i = localObject.hashCode();
      l = this.yCx;
      i8 = (int)(l ^ l >>> 32);
      l = this.yCy;
      i9 = (int)(l ^ l >>> 32);
      localObject = this.yAO;
      if (localObject == null) {
        break label410;
      }
      j = localObject.hashCode();
      localObject = this.yAP;
      if (localObject == null) {
        break label415;
      }
      k = localObject.hashCode();
      l = this.yCC;
      i10 = (int)(l ^ l >>> 32);
      l = this.yCz;
      i11 = (int)(l ^ l >>> 32);
      localObject = this.kit;
      if (localObject == null) {
        break label420;
      }
      m = localObject.hashCode();
      localObject = this.yCA;
      if (localObject == null) {
        break label426;
      }
      n = localObject.hashCode();
      l = this.enterTime;
      i12 = (int)(l ^ l >>> 32);
      localObject = this.yCD;
      if (localObject == null) {
        break label432;
      }
      i1 = localObject.hashCode();
      localObject = this.yCE;
      if (localObject == null) {
        break label438;
      }
      i2 = localObject.hashCode();
      localObject = this.wmz;
      if (localObject == null) {
        break label444;
      }
      i3 = localObject.hashCode();
      label268:
      localObject = this.yAU;
      if (localObject == null) {
        break label450;
      }
    }
    label410:
    label415:
    label420:
    label426:
    label432:
    label438:
    label444:
    label450:
    for (int i4 = localObject.hashCode();; i4 = 0)
    {
      localObject = this.yAV;
      if (localObject != null) {
        i5 = localObject.hashCode();
      }
      AppMethodBeat.o(288712);
      return (i4 + (i3 + (i2 + (i1 + ((n + (m + (((k + (j + (((i + (i6 * 31 + i7) * 31) * 31 + i8) * 31 + i9) * 31) * 31) * 31 + i10) * 31 + i11) * 31) * 31) * 31 + i12) * 31) * 31) * 31) * 31) * 31 + i5;
      i = 0;
      break;
      j = 0;
      break label110;
      k = 0;
      break label127;
      m = 0;
      break label179;
      n = 0;
      break label197;
      i1 = 0;
      break label232;
      i2 = 0;
      break label250;
      i3 = 0;
      break label268;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(288711);
    String str = "HellVisitorEnterData(feedId=" + this.feedId + ", liveId=" + this.liveId + ", userName=" + this.userName + ", index=" + this.yCx + ", onlineNum=" + this.yCy + ", actionType=" + this.yAO + ", commentscene=" + this.yAP + ", enterStatus=" + this.yCC + ", shareType=" + this.yCz + ", shareUserName=" + this.kit + ", snsFeedid=" + this.yCA + ", enterTime=" + this.enterTime + ", enterType=" + this.yCD + ", sessionBuf=" + this.yCE + ", clickTabContextId=" + this.wmz + ", clickSubTabContextId=" + this.yAU + ", chnlExtra=" + this.yAV + ")";
    AppMethodBeat.o(288711);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.q
 * JD-Core Version:    0.7.0.1
 */