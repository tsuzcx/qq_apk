package com.tencent.mm.plugin.finder.live.report;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/HellVisitorClickData;", "", "feedId", "", "liveId", "userName", "", "index", "onlineNum", "actionType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "commentscene", "shareType", "shareUserName", "snsFeedid", "enterIconType", "", "clickTabContextId", "clickSubTabContextId", "chnlExtra", "(JJLjava/lang/String;JJLcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "getChnlExtra", "()Ljava/lang/String;", "getClickSubTabContextId", "getClickTabContextId", "getCommentscene", "getEnterIconType", "()I", "getFeedId", "()J", "getIndex", "getLiveId", "getOnlineNum", "getShareType", "getShareUserName", "getSnsFeedid", "getUserName", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  private final int CRV;
  final q.w DnM;
  final String DnN;
  final String DnS;
  final String DnT;
  final long Dpr;
  final long Dps;
  final long Dpt;
  final String Dpu;
  final long feedId;
  final long liveId;
  final String mIS;
  final String userName;
  private final String zIB;
  
  private n(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, q.w paramw, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(351786);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.userName = paramString1;
    this.Dpr = paramLong3;
    this.Dps = paramLong4;
    this.DnM = paramw;
    this.DnN = paramString2;
    this.Dpt = 0L;
    this.mIS = paramString3;
    this.Dpu = paramString4;
    this.CRV = 0;
    this.zIB = paramString5;
    this.DnS = paramString6;
    this.DnT = paramString7;
    AppMethodBeat.o(351786);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(351815);
    if (this == paramObject)
    {
      AppMethodBeat.o(351815);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(351815);
      return false;
    }
    paramObject = (n)paramObject;
    if (this.feedId != paramObject.feedId)
    {
      AppMethodBeat.o(351815);
      return false;
    }
    if (this.liveId != paramObject.liveId)
    {
      AppMethodBeat.o(351815);
      return false;
    }
    if (!s.p(this.userName, paramObject.userName))
    {
      AppMethodBeat.o(351815);
      return false;
    }
    if (this.Dpr != paramObject.Dpr)
    {
      AppMethodBeat.o(351815);
      return false;
    }
    if (this.Dps != paramObject.Dps)
    {
      AppMethodBeat.o(351815);
      return false;
    }
    if (this.DnM != paramObject.DnM)
    {
      AppMethodBeat.o(351815);
      return false;
    }
    if (!s.p(this.DnN, paramObject.DnN))
    {
      AppMethodBeat.o(351815);
      return false;
    }
    if (this.Dpt != paramObject.Dpt)
    {
      AppMethodBeat.o(351815);
      return false;
    }
    if (!s.p(this.mIS, paramObject.mIS))
    {
      AppMethodBeat.o(351815);
      return false;
    }
    if (!s.p(this.Dpu, paramObject.Dpu))
    {
      AppMethodBeat.o(351815);
      return false;
    }
    if (this.CRV != paramObject.CRV)
    {
      AppMethodBeat.o(351815);
      return false;
    }
    if (!s.p(this.zIB, paramObject.zIB))
    {
      AppMethodBeat.o(351815);
      return false;
    }
    if (!s.p(this.DnS, paramObject.DnS))
    {
      AppMethodBeat.o(351815);
      return false;
    }
    if (!s.p(this.DnT, paramObject.DnT))
    {
      AppMethodBeat.o(351815);
      return false;
    }
    AppMethodBeat.o(351815);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(351809);
    int j = q.a..ExternalSyntheticBackport0.m(this.feedId);
    int k = q.a..ExternalSyntheticBackport0.m(this.liveId);
    int m = this.userName.hashCode();
    int n = q.a..ExternalSyntheticBackport0.m(this.Dpr);
    int i1 = q.a..ExternalSyntheticBackport0.m(this.Dps);
    int i2 = this.DnM.hashCode();
    int i3 = this.DnN.hashCode();
    int i4 = q.a..ExternalSyntheticBackport0.m(this.Dpt);
    int i5 = this.mIS.hashCode();
    if (this.Dpu == null) {}
    for (int i = 0;; i = this.Dpu.hashCode())
    {
      int i6 = this.CRV;
      int i7 = this.zIB.hashCode();
      int i8 = this.DnS.hashCode();
      int i9 = this.DnT.hashCode();
      AppMethodBeat.o(351809);
      return ((((i + ((((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(351803);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HellVisitorClickData(feedId=").append(this.feedId).append(", liveId=").append(this.liveId).append(", userName=").append(this.userName).append(", index=").append(this.Dpr).append(", onlineNum=").append(this.Dps).append(", actionType=").append(this.DnM).append(", commentscene=").append(this.DnN).append(", shareType=").append(this.Dpt).append(", shareUserName=").append(this.mIS).append(", snsFeedid=").append(this.Dpu).append(", enterIconType=").append(this.CRV).append(", clickTabContextId=");
    ((StringBuilder)localObject).append(this.zIB).append(", clickSubTabContextId=").append(this.DnS).append(", chnlExtra=").append(this.DnT).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(351803);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.n
 * JD-Core Version:    0.7.0.1
 */