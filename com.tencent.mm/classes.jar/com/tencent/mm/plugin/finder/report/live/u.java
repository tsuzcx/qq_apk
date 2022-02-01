package com.tencent.mm.plugin.finder.report.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/LiveStaticsData_21056;", "", "liveId", "", "feedId", "description", "liveStartTimeMs", "", "liveEndTimeMs", "oriFansCount", "liveDurationSeconds", "audienceCount", "likeCount", "newFansNum", "errorCode", "", "floatingCount", "shareSnsCount", "shareSessionCount", "exchangeCameraCount", "complainCount", "allCommentCloseCount", "allCommentOpenCount", "personalCommentCloseCount", "personalCommentOpenCount", "kickOutCount", "promoteGoods", "Ljava/util/HashMap;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/report/live/HellPair;", "Lkotlin/collections/HashMap;", "topComment", "tickleTimes", "shopWindowId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJJJJIJJJJJJJJJJLjava/util/HashMap;JJLjava/lang/String;)V", "getAllCommentCloseCount", "()J", "setAllCommentCloseCount", "(J)V", "getAllCommentOpenCount", "setAllCommentOpenCount", "getAudienceCount", "setAudienceCount", "getComplainCount", "setComplainCount", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "getExchangeCameraCount", "setExchangeCameraCount", "getFeedId", "setFeedId", "getFloatingCount", "setFloatingCount", "getKickOutCount", "setKickOutCount", "getLikeCount", "setLikeCount", "getLiveDurationSeconds", "setLiveDurationSeconds", "getLiveEndTimeMs", "setLiveEndTimeMs", "getLiveId", "setLiveId", "getLiveStartTimeMs", "setLiveStartTimeMs", "getNewFansNum", "setNewFansNum", "getOriFansCount", "setOriFansCount", "getPersonalCommentCloseCount", "setPersonalCommentCloseCount", "getPersonalCommentOpenCount", "setPersonalCommentOpenCount", "getPromoteGoods", "()Ljava/util/HashMap;", "getShareSessionCount", "setShareSessionCount", "getShareSnsCount", "setShareSnsCount", "getShopWindowId", "setShopWindowId", "getTickleTimes", "setTickleTimes", "getTopComment", "setTopComment", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "reset", "", "intent", "Landroid/content/Intent;", "toString", "plugin-finder_release"})
public final class u
{
  String description;
  public int errorCode;
  public String feedId;
  public String hJs;
  public final HashMap<Long, LinkedList<o>> vtA;
  public long vtB;
  public long vtC;
  String vtD;
  public long vtj;
  public long vtk;
  public long vtl;
  public long vtm;
  public long vtn;
  public long vto;
  public long vtp;
  public long vtq;
  public long vtr;
  public long vts;
  public long vtt;
  public long vtu;
  public long vtv;
  public long vtw;
  public long vtx;
  public long vty;
  public long vtz;
  
  private u(String paramString1, String paramString2, String paramString3, HashMap<Long, LinkedList<o>> paramHashMap, String paramString4)
  {
    AppMethodBeat.i(251207);
    this.hJs = paramString1;
    this.feedId = paramString2;
    this.description = paramString3;
    this.vtj = 0L;
    this.vtk = 0L;
    this.vtl = 0L;
    this.vtm = 0L;
    this.vtn = 0L;
    this.vto = 0L;
    this.vtp = 0L;
    this.errorCode = 0;
    this.vtq = 0L;
    this.vtr = 0L;
    this.vts = 0L;
    this.vtt = 0L;
    this.vtu = 0L;
    this.vtv = 0L;
    this.vtw = 0L;
    this.vtx = 0L;
    this.vty = 0L;
    this.vtz = 0L;
    this.vtA = paramHashMap;
    this.vtB = 0L;
    this.vtC = 0L;
    this.vtD = paramString4;
    AppMethodBeat.o(251207);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(251211);
    if (this != paramObject)
    {
      if ((paramObject instanceof u))
      {
        paramObject = (u)paramObject;
        if ((!p.j(this.hJs, paramObject.hJs)) || (!p.j(this.feedId, paramObject.feedId)) || (!p.j(this.description, paramObject.description)) || (this.vtj != paramObject.vtj) || (this.vtk != paramObject.vtk) || (this.vtl != paramObject.vtl) || (this.vtm != paramObject.vtm) || (this.vtn != paramObject.vtn) || (this.vto != paramObject.vto) || (this.vtp != paramObject.vtp) || (this.errorCode != paramObject.errorCode) || (this.vtq != paramObject.vtq) || (this.vtr != paramObject.vtr) || (this.vts != paramObject.vts) || (this.vtt != paramObject.vtt) || (this.vtu != paramObject.vtu) || (this.vtv != paramObject.vtv) || (this.vtw != paramObject.vtw) || (this.vtx != paramObject.vtx) || (this.vty != paramObject.vty) || (this.vtz != paramObject.vtz) || (!p.j(this.vtA, paramObject.vtA)) || (this.vtB != paramObject.vtB) || (this.vtC != paramObject.vtC) || (!p.j(this.vtD, paramObject.vtD))) {}
      }
    }
    else
    {
      AppMethodBeat.o(251211);
      return true;
    }
    AppMethodBeat.o(251211);
    return false;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(251210);
    Object localObject = this.hJs;
    int i;
    int j;
    label43:
    int k;
    label60:
    long l;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    int i13;
    int i14;
    int i15;
    int i16;
    int i17;
    int i18;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.feedId;
      if (localObject == null) {
        break label580;
      }
      j = localObject.hashCode();
      localObject = this.description;
      if (localObject == null) {
        break label585;
      }
      k = localObject.hashCode();
      l = this.vtj;
      i1 = (int)(l ^ l >>> 32);
      l = this.vtk;
      i2 = (int)(l ^ l >>> 32);
      l = this.vtl;
      i3 = (int)(l ^ l >>> 32);
      l = this.vtm;
      i4 = (int)(l ^ l >>> 32);
      l = this.vtn;
      i5 = (int)(l ^ l >>> 32);
      l = this.vto;
      i6 = (int)(l ^ l >>> 32);
      l = this.vtp;
      i7 = (int)(l ^ l >>> 32);
      i8 = this.errorCode;
      l = this.vtq;
      i9 = (int)(l ^ l >>> 32);
      l = this.vtr;
      i10 = (int)(l ^ l >>> 32);
      l = this.vts;
      i11 = (int)(l ^ l >>> 32);
      l = this.vtt;
      i12 = (int)(l ^ l >>> 32);
      l = this.vtu;
      i13 = (int)(l ^ l >>> 32);
      l = this.vtv;
      i14 = (int)(l ^ l >>> 32);
      l = this.vtw;
      i15 = (int)(l ^ l >>> 32);
      l = this.vtx;
      i16 = (int)(l ^ l >>> 32);
      l = this.vty;
      i17 = (int)(l ^ l >>> 32);
      l = this.vtz;
      i18 = (int)(l ^ l >>> 32);
      localObject = this.vtA;
      if (localObject == null) {
        break label590;
      }
    }
    label580:
    label585:
    label590:
    for (int m = localObject.hashCode();; m = 0)
    {
      l = this.vtB;
      int i19 = (int)(l ^ l >>> 32);
      l = this.vtC;
      int i20 = (int)(l ^ l >>> 32);
      localObject = this.vtD;
      if (localObject != null) {
        n = localObject.hashCode();
      }
      AppMethodBeat.o(251210);
      return (((m + (((((((((((((((((((k + (j + i * 31) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31) * 31 + i19) * 31 + i20) * 31 + n;
      i = 0;
      break;
      j = 0;
      break label43;
      k = 0;
      break label60;
    }
  }
  
  public final void setDescription(String paramString)
  {
    AppMethodBeat.i(251206);
    p.h(paramString, "<set-?>");
    this.description = paramString;
    AppMethodBeat.o(251206);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(251209);
    String str = "LiveStaticsData_21056(liveId=" + this.hJs + ", feedId=" + this.feedId + ", description=" + this.description + ", liveStartTimeMs=" + this.vtj + ", liveEndTimeMs=" + this.vtk + ", oriFansCount=" + this.vtl + ", liveDurationSeconds=" + this.vtm + ", audienceCount=" + this.vtn + ", likeCount=" + this.vto + ", newFansNum=" + this.vtp + ", errorCode=" + this.errorCode + ", floatingCount=" + this.vtq + ", shareSnsCount=" + this.vtr + ", shareSessionCount=" + this.vts + ", exchangeCameraCount=" + this.vtt + ", complainCount=" + this.vtu + ", allCommentCloseCount=" + this.vtv + ", allCommentOpenCount=" + this.vtw + ", personalCommentCloseCount=" + this.vtx + ", personalCommentOpenCount=" + this.vty + ", kickOutCount=" + this.vtz + ", promoteGoods=" + this.vtA + ", topComment=" + this.vtB + ", tickleTimes=" + this.vtC + ", shopWindowId=" + this.vtD + ")";
    AppMethodBeat.o(251209);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.live.u
 * JD-Core Version:    0.7.0.1
 */