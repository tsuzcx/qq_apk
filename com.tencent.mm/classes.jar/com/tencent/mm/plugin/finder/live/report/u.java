package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/LiveStaticsData_21056;", "", "liveId", "", "feedId", "description", "liveStartTimeMs", "", "liveEndTimeMs", "oriFansCount", "liveDurationSeconds", "audienceCount", "likeCount", "newFansNum", "errorCode", "", "floatingCount", "shareSnsCount", "shareSessionCount", "exchangeCameraCount", "complainCount", "allCommentCloseCount", "allCommentOpenCount", "personalCommentCloseCount", "personalCommentOpenCount", "kickOutCount", "promoteGoods", "Ljava/util/HashMap;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/report/HellPair;", "Lkotlin/collections/HashMap;", "topComment", "tickleTimes", "shopWindowId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJJJJIJJJJJJJJJJLjava/util/HashMap;JJLjava/lang/String;)V", "getAllCommentCloseCount", "()J", "setAllCommentCloseCount", "(J)V", "getAllCommentOpenCount", "setAllCommentOpenCount", "getAudienceCount", "setAudienceCount", "getComplainCount", "setComplainCount", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "getExchangeCameraCount", "setExchangeCameraCount", "getFeedId", "setFeedId", "getFloatingCount", "setFloatingCount", "getKickOutCount", "setKickOutCount", "getLikeCount", "setLikeCount", "getLiveDurationSeconds", "setLiveDurationSeconds", "getLiveEndTimeMs", "setLiveEndTimeMs", "getLiveId", "setLiveId", "getLiveStartTimeMs", "setLiveStartTimeMs", "getNewFansNum", "setNewFansNum", "getOriFansCount", "setOriFansCount", "getPersonalCommentCloseCount", "setPersonalCommentCloseCount", "getPersonalCommentOpenCount", "setPersonalCommentOpenCount", "getPromoteGoods", "()Ljava/util/HashMap;", "getShareSessionCount", "setShareSessionCount", "getShareSnsCount", "setShareSnsCount", "getShopWindowId", "setShopWindowId", "getTickleTimes", "setTickleTimes", "getTopComment", "setTopComment", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "reset", "", "intent", "Landroid/content/Intent;", "toString", "plugin-finder_release"})
public final class u
{
  String description;
  public int errorCode;
  public String feedId;
  public String kwM;
  public long yNA;
  public long yNB;
  public long yNC;
  public long yND;
  public long yNE;
  public long yNF;
  public long yNG;
  public final HashMap<Long, LinkedList<o>> yNH;
  public long yNI;
  public long yNJ;
  String yNK;
  public long yNq;
  public long yNr;
  public long yNs;
  public long yNt;
  public long yNu;
  public long yNv;
  public long yNw;
  public long yNx;
  public long yNy;
  public long yNz;
  
  private u(String paramString1, String paramString2, String paramString3, HashMap<Long, LinkedList<o>> paramHashMap, String paramString4)
  {
    AppMethodBeat.i(285219);
    this.kwM = paramString1;
    this.feedId = paramString2;
    this.description = paramString3;
    this.yNq = 0L;
    this.yNr = 0L;
    this.yNs = 0L;
    this.yNt = 0L;
    this.yNu = 0L;
    this.yNv = 0L;
    this.yNw = 0L;
    this.errorCode = 0;
    this.yNx = 0L;
    this.yNy = 0L;
    this.yNz = 0L;
    this.yNA = 0L;
    this.yNB = 0L;
    this.yNC = 0L;
    this.yND = 0L;
    this.yNE = 0L;
    this.yNF = 0L;
    this.yNG = 0L;
    this.yNH = paramHashMap;
    this.yNI = 0L;
    this.yNJ = 0L;
    this.yNK = paramString4;
    AppMethodBeat.o(285219);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(285226);
    if (this != paramObject)
    {
      if ((paramObject instanceof u))
      {
        paramObject = (u)paramObject;
        if ((!p.h(this.kwM, paramObject.kwM)) || (!p.h(this.feedId, paramObject.feedId)) || (!p.h(this.description, paramObject.description)) || (this.yNq != paramObject.yNq) || (this.yNr != paramObject.yNr) || (this.yNs != paramObject.yNs) || (this.yNt != paramObject.yNt) || (this.yNu != paramObject.yNu) || (this.yNv != paramObject.yNv) || (this.yNw != paramObject.yNw) || (this.errorCode != paramObject.errorCode) || (this.yNx != paramObject.yNx) || (this.yNy != paramObject.yNy) || (this.yNz != paramObject.yNz) || (this.yNA != paramObject.yNA) || (this.yNB != paramObject.yNB) || (this.yNC != paramObject.yNC) || (this.yND != paramObject.yND) || (this.yNE != paramObject.yNE) || (this.yNF != paramObject.yNF) || (this.yNG != paramObject.yNG) || (!p.h(this.yNH, paramObject.yNH)) || (this.yNI != paramObject.yNI) || (this.yNJ != paramObject.yNJ) || (!p.h(this.yNK, paramObject.yNK))) {}
      }
    }
    else
    {
      AppMethodBeat.o(285226);
      return true;
    }
    AppMethodBeat.o(285226);
    return false;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(285224);
    Object localObject = this.kwM;
    int i;
    int j;
    label42:
    int k;
    label59:
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
        break label578;
      }
      j = localObject.hashCode();
      localObject = this.description;
      if (localObject == null) {
        break label583;
      }
      k = localObject.hashCode();
      l = this.yNq;
      i1 = (int)(l ^ l >>> 32);
      l = this.yNr;
      i2 = (int)(l ^ l >>> 32);
      l = this.yNs;
      i3 = (int)(l ^ l >>> 32);
      l = this.yNt;
      i4 = (int)(l ^ l >>> 32);
      l = this.yNu;
      i5 = (int)(l ^ l >>> 32);
      l = this.yNv;
      i6 = (int)(l ^ l >>> 32);
      l = this.yNw;
      i7 = (int)(l ^ l >>> 32);
      i8 = this.errorCode;
      l = this.yNx;
      i9 = (int)(l ^ l >>> 32);
      l = this.yNy;
      i10 = (int)(l ^ l >>> 32);
      l = this.yNz;
      i11 = (int)(l ^ l >>> 32);
      l = this.yNA;
      i12 = (int)(l ^ l >>> 32);
      l = this.yNB;
      i13 = (int)(l ^ l >>> 32);
      l = this.yNC;
      i14 = (int)(l ^ l >>> 32);
      l = this.yND;
      i15 = (int)(l ^ l >>> 32);
      l = this.yNE;
      i16 = (int)(l ^ l >>> 32);
      l = this.yNF;
      i17 = (int)(l ^ l >>> 32);
      l = this.yNG;
      i18 = (int)(l ^ l >>> 32);
      localObject = this.yNH;
      if (localObject == null) {
        break label588;
      }
    }
    label578:
    label583:
    label588:
    for (int m = localObject.hashCode();; m = 0)
    {
      l = this.yNI;
      int i19 = (int)(l ^ l >>> 32);
      l = this.yNJ;
      int i20 = (int)(l ^ l >>> 32);
      localObject = this.yNK;
      if (localObject != null) {
        n = localObject.hashCode();
      }
      AppMethodBeat.o(285224);
      return (((m + (((((((((((((((((((k + (j + i * 31) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31) * 31 + i19) * 31 + i20) * 31 + n;
      i = 0;
      break;
      j = 0;
      break label42;
      k = 0;
      break label59;
    }
  }
  
  public final void setDescription(String paramString)
  {
    AppMethodBeat.i(285218);
    p.k(paramString, "<set-?>");
    this.description = paramString;
    AppMethodBeat.o(285218);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(285223);
    String str = "LiveStaticsData_21056(liveId=" + this.kwM + ", feedId=" + this.feedId + ", description=" + this.description + ", liveStartTimeMs=" + this.yNq + ", liveEndTimeMs=" + this.yNr + ", oriFansCount=" + this.yNs + ", liveDurationSeconds=" + this.yNt + ", audienceCount=" + this.yNu + ", likeCount=" + this.yNv + ", newFansNum=" + this.yNw + ", errorCode=" + this.errorCode + ", floatingCount=" + this.yNx + ", shareSnsCount=" + this.yNy + ", shareSessionCount=" + this.yNz + ", exchangeCameraCount=" + this.yNA + ", complainCount=" + this.yNB + ", allCommentCloseCount=" + this.yNC + ", allCommentOpenCount=" + this.yND + ", personalCommentCloseCount=" + this.yNE + ", personalCommentOpenCount=" + this.yNF + ", kickOutCount=" + this.yNG + ", promoteGoods=" + this.yNH + ", topComment=" + this.yNI + ", tickleTimes=" + this.yNJ + ", shopWindowId=" + this.yNK + ")";
    AppMethodBeat.o(285223);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.u
 * JD-Core Version:    0.7.0.1
 */