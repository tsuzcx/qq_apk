package com.tencent.mm.plugin.finder.live.report;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/HellVisitorEnterData;", "", "feedId", "", "liveId", "userName", "", "index", "onlineNum", "actionType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "commentscene", "enterStatus", "shareType", "shareUserName", "snsFeedid", "enterTime", "enterType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;", "sessionBuf", "clickTabContextId", "clickSubTabContextId", "chnlExtra", "(JJLjava/lang/String;JJLcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;JLcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "getChnlExtra", "()Ljava/lang/String;", "getClickSubTabContextId", "getClickTabContextId", "getCommentscene", "getEnterStatus", "()J", "getEnterTime", "getEnterType", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorEnterType;", "getFeedId", "getIndex", "getLiveId", "getOnlineNum", "getSessionBuf", "getShareType", "getShareUserName", "getSnsFeedid", "getUserName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  final q.w DnM;
  final String DnN;
  final String DnS;
  final String DnT;
  final long Dpr;
  final long Dps;
  final long Dpt;
  final String Dpu;
  final long Dpv;
  final q.ca Dpw;
  final String Dpx;
  final long enterTime;
  final long feedId;
  final long liveId;
  final String mIS;
  final String userName;
  private final String zIB;
  
  private o(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, q.w paramw, String paramString2, long paramLong5, long paramLong6, String paramString3, String paramString4, long paramLong7, q.ca paramca, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(351787);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.userName = paramString1;
    this.Dpr = paramLong3;
    this.Dps = paramLong4;
    this.DnM = paramw;
    this.DnN = paramString2;
    this.Dpv = paramLong5;
    this.Dpt = paramLong6;
    this.mIS = paramString3;
    this.Dpu = paramString4;
    this.enterTime = paramLong7;
    this.Dpw = paramca;
    this.Dpx = paramString5;
    this.zIB = paramString6;
    this.DnS = paramString7;
    this.DnT = paramString8;
    AppMethodBeat.o(351787);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(351824);
    if (this == paramObject)
    {
      AppMethodBeat.o(351824);
      return true;
    }
    if (!(paramObject instanceof o))
    {
      AppMethodBeat.o(351824);
      return false;
    }
    paramObject = (o)paramObject;
    if (this.feedId != paramObject.feedId)
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (this.liveId != paramObject.liveId)
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (!s.p(this.userName, paramObject.userName))
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (this.Dpr != paramObject.Dpr)
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (this.Dps != paramObject.Dps)
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (this.DnM != paramObject.DnM)
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (!s.p(this.DnN, paramObject.DnN))
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (this.Dpv != paramObject.Dpv)
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (this.Dpt != paramObject.Dpt)
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (!s.p(this.mIS, paramObject.mIS))
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (!s.p(this.Dpu, paramObject.Dpu))
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (this.enterTime != paramObject.enterTime)
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (this.Dpw != paramObject.Dpw)
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (!s.p(this.Dpx, paramObject.Dpx))
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (!s.p(this.zIB, paramObject.zIB))
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (!s.p(this.DnS, paramObject.DnS))
    {
      AppMethodBeat.o(351824);
      return false;
    }
    if (!s.p(this.DnT, paramObject.DnT))
    {
      AppMethodBeat.o(351824);
      return false;
    }
    AppMethodBeat.o(351824);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(351816);
    int i = q.a..ExternalSyntheticBackport0.m(this.feedId);
    int j = q.a..ExternalSyntheticBackport0.m(this.liveId);
    int k = this.userName.hashCode();
    int m = q.a..ExternalSyntheticBackport0.m(this.Dpr);
    int n = q.a..ExternalSyntheticBackport0.m(this.Dps);
    int i1 = this.DnM.hashCode();
    int i2 = this.DnN.hashCode();
    int i3 = q.a..ExternalSyntheticBackport0.m(this.Dpv);
    int i4 = q.a..ExternalSyntheticBackport0.m(this.Dpt);
    int i5 = this.mIS.hashCode();
    int i6 = this.Dpu.hashCode();
    int i7 = q.a..ExternalSyntheticBackport0.m(this.enterTime);
    int i8 = this.Dpw.hashCode();
    int i9 = this.Dpx.hashCode();
    int i10 = this.zIB.hashCode();
    int i11 = this.DnS.hashCode();
    int i12 = this.DnT.hashCode();
    AppMethodBeat.o(351816);
    return (((((((((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(351812);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HellVisitorEnterData(feedId=").append(this.feedId).append(", liveId=").append(this.liveId).append(", userName=").append(this.userName).append(", index=").append(this.Dpr).append(", onlineNum=").append(this.Dps).append(", actionType=").append(this.DnM).append(", commentscene=").append(this.DnN).append(", enterStatus=").append(this.Dpv).append(", shareType=").append(this.Dpt).append(", shareUserName=").append(this.mIS).append(", snsFeedid=").append(this.Dpu).append(", enterTime=");
    ((StringBuilder)localObject).append(this.enterTime).append(", enterType=").append(this.Dpw).append(", sessionBuf=").append(this.Dpx).append(", clickTabContextId=").append(this.zIB).append(", clickSubTabContextId=").append(this.DnS).append(", chnlExtra=").append(this.DnT).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(351812);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.o
 * JD-Core Version:    0.7.0.1
 */