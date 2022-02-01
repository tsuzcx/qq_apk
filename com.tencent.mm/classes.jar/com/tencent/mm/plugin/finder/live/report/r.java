package com.tencent.mm.plugin.finder.live.report;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveStaticsData_21056;", "", "liveId", "", "feedId", "description", "liveStartTimeMs", "", "liveEndTimeMs", "oriFansCount", "liveDurationSeconds", "audienceCount", "likeCount", "newFansNum", "errorCode", "", "floatingCount", "shareSnsCount", "shareSessionCount", "exchangeCameraCount", "complainCount", "allCommentCloseCount", "allCommentOpenCount", "personalCommentCloseCount", "personalCommentOpenCount", "kickOutCount", "promoteGoods", "Ljava/util/HashMap;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/report/HellPair;", "Lkotlin/collections/HashMap;", "topComment", "tickleTimes", "shopWindowId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJJJJIJJJJJJJJJJLjava/util/HashMap;JJLjava/lang/String;)V", "getAllCommentCloseCount", "()J", "setAllCommentCloseCount", "(J)V", "getAllCommentOpenCount", "setAllCommentOpenCount", "getAudienceCount", "setAudienceCount", "getComplainCount", "setComplainCount", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "getExchangeCameraCount", "setExchangeCameraCount", "getFeedId", "setFeedId", "getFloatingCount", "setFloatingCount", "getKickOutCount", "setKickOutCount", "getLikeCount", "setLikeCount", "getLiveDurationSeconds", "setLiveDurationSeconds", "getLiveEndTimeMs", "setLiveEndTimeMs", "getLiveId", "setLiveId", "getLiveStartTimeMs", "setLiveStartTimeMs", "getNewFansNum", "setNewFansNum", "getOriFansCount", "setOriFansCount", "getPersonalCommentCloseCount", "setPersonalCommentCloseCount", "getPersonalCommentOpenCount", "setPersonalCommentOpenCount", "getPromoteGoods", "()Ljava/util/HashMap;", "getShareSessionCount", "setShareSessionCount", "getShareSnsCount", "setShareSnsCount", "getShopWindowId", "setShopWindowId", "getTickleTimes", "setTickleTimes", "getTopComment", "setTopComment", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "reset", "", "intent", "Landroid/content/Intent;", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public long DFR;
  public long DFS;
  public long DFT;
  public long DFU;
  public long DFV;
  public long DFW;
  public long DFX;
  public long DFY;
  public long DFZ;
  public long DGa;
  public long DGb;
  public long DGc;
  public long DGd;
  public long DGe;
  public long DGf;
  public long DGg;
  public long DGh;
  public final HashMap<Long, LinkedList<m>> DGi;
  public long DGj;
  public long DGk;
  String DGl;
  public String description;
  public int errorCode;
  public String feedId;
  public String liveId;
  
  private r(String paramString1, String paramString2, String paramString3, HashMap<Long, LinkedList<m>> paramHashMap, String paramString4)
  {
    AppMethodBeat.i(351789);
    this.liveId = paramString1;
    this.feedId = paramString2;
    this.description = paramString3;
    this.DFR = 0L;
    this.DFS = 0L;
    this.DFT = 0L;
    this.DFU = 0L;
    this.DFV = 0L;
    this.DFW = 0L;
    this.DFX = 0L;
    this.errorCode = 0;
    this.DFY = 0L;
    this.DFZ = 0L;
    this.DGa = 0L;
    this.DGb = 0L;
    this.DGc = 0L;
    this.DGd = 0L;
    this.DGe = 0L;
    this.DGf = 0L;
    this.DGg = 0L;
    this.DGh = 0L;
    this.DGi = paramHashMap;
    this.DGj = 0L;
    this.DGk = 0L;
    this.DGl = paramString4;
    AppMethodBeat.o(351789);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(351819);
    if (this == paramObject)
    {
      AppMethodBeat.o(351819);
      return true;
    }
    if (!(paramObject instanceof r))
    {
      AppMethodBeat.o(351819);
      return false;
    }
    paramObject = (r)paramObject;
    if (!s.p(this.liveId, paramObject.liveId))
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (!s.p(this.feedId, paramObject.feedId))
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (!s.p(this.description, paramObject.description))
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DFR != paramObject.DFR)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DFS != paramObject.DFS)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DFT != paramObject.DFT)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DFU != paramObject.DFU)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DFV != paramObject.DFV)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DFW != paramObject.DFW)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DFX != paramObject.DFX)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.errorCode != paramObject.errorCode)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DFY != paramObject.DFY)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DFZ != paramObject.DFZ)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DGa != paramObject.DGa)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DGb != paramObject.DGb)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DGc != paramObject.DGc)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DGd != paramObject.DGd)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DGe != paramObject.DGe)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DGf != paramObject.DGf)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DGg != paramObject.DGg)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DGh != paramObject.DGh)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (!s.p(this.DGi, paramObject.DGi))
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DGj != paramObject.DGj)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (this.DGk != paramObject.DGk)
    {
      AppMethodBeat.o(351819);
      return false;
    }
    if (!s.p(this.DGl, paramObject.DGl))
    {
      AppMethodBeat.o(351819);
      return false;
    }
    AppMethodBeat.o(351819);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(351813);
    int i = this.liveId.hashCode();
    int j = this.feedId.hashCode();
    int k = this.description.hashCode();
    int m = q.a..ExternalSyntheticBackport0.m(this.DFR);
    int n = q.a..ExternalSyntheticBackport0.m(this.DFS);
    int i1 = q.a..ExternalSyntheticBackport0.m(this.DFT);
    int i2 = q.a..ExternalSyntheticBackport0.m(this.DFU);
    int i3 = q.a..ExternalSyntheticBackport0.m(this.DFV);
    int i4 = q.a..ExternalSyntheticBackport0.m(this.DFW);
    int i5 = q.a..ExternalSyntheticBackport0.m(this.DFX);
    int i6 = this.errorCode;
    int i7 = q.a..ExternalSyntheticBackport0.m(this.DFY);
    int i8 = q.a..ExternalSyntheticBackport0.m(this.DFZ);
    int i9 = q.a..ExternalSyntheticBackport0.m(this.DGa);
    int i10 = q.a..ExternalSyntheticBackport0.m(this.DGb);
    int i11 = q.a..ExternalSyntheticBackport0.m(this.DGc);
    int i12 = q.a..ExternalSyntheticBackport0.m(this.DGd);
    int i13 = q.a..ExternalSyntheticBackport0.m(this.DGe);
    int i14 = q.a..ExternalSyntheticBackport0.m(this.DGf);
    int i15 = q.a..ExternalSyntheticBackport0.m(this.DGg);
    int i16 = q.a..ExternalSyntheticBackport0.m(this.DGh);
    int i17 = this.DGi.hashCode();
    int i18 = q.a..ExternalSyntheticBackport0.m(this.DGj);
    int i19 = q.a..ExternalSyntheticBackport0.m(this.DGk);
    int i20 = this.DGl.hashCode();
    AppMethodBeat.o(351813);
    return (((((((((((((((((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31 + i19) * 31 + i20;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(351805);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("LiveStaticsData_21056(liveId=").append(this.liveId).append(", feedId=").append(this.feedId).append(", description=").append(this.description).append(", liveStartTimeMs=").append(this.DFR).append(", liveEndTimeMs=").append(this.DFS).append(", oriFansCount=").append(this.DFT).append(", liveDurationSeconds=").append(this.DFU).append(", audienceCount=").append(this.DFV).append(", likeCount=").append(this.DFW).append(", newFansNum=").append(this.DFX).append(", errorCode=").append(this.errorCode).append(", floatingCount=");
    ((StringBuilder)localObject).append(this.DFY).append(", shareSnsCount=").append(this.DFZ).append(", shareSessionCount=").append(this.DGa).append(", exchangeCameraCount=").append(this.DGb).append(", complainCount=").append(this.DGc).append(", allCommentCloseCount=").append(this.DGd).append(", allCommentOpenCount=").append(this.DGe).append(", personalCommentCloseCount=").append(this.DGf).append(", personalCommentOpenCount=").append(this.DGg).append(", kickOutCount=").append(this.DGh).append(", promoteGoods=").append(this.DGi).append(", topComment=").append(this.DGj);
    ((StringBuilder)localObject).append(", tickleTimes=").append(this.DGk).append(", shopWindowId=").append(this.DGl).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(351805);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.r
 * JD-Core Version:    0.7.0.1
 */