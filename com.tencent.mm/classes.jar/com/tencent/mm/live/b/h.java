package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/FinderLiveApplyLiveMicInfo;", "", "liveId", "", "objectId", "applyMicSdkUserId", "", "applyMicSdkLiveId", "applyMicFinderUsername", "liveMicId", "seq", "scene", "", "businessType", "applyNickname", "applyAvatarUrl", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getApplyAvatarUrl", "()Ljava/lang/String;", "getApplyMicFinderUsername", "getApplyMicSdkLiveId", "getApplyMicSdkUserId", "getApplyNickname", "getBusinessType", "()I", "getLiveId", "()J", "getLiveMicId", "getObjectId", "getScene", "getSeq", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class h
{
  public final int businessType;
  public final long hFK;
  public final String hFO;
  public final String hFQ;
  public final String hFR;
  public final String hFS;
  public final String hFT;
  public final String hFU;
  public final long liveId;
  public final int scene;
  private final String seq;
  
  public h(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7)
  {
    this.liveId = paramLong1;
    this.hFK = paramLong2;
    this.hFQ = paramString1;
    this.hFR = paramString2;
    this.hFS = paramString3;
    this.hFO = paramString4;
    this.seq = paramString5;
    this.scene = paramInt1;
    this.businessType = paramInt2;
    this.hFT = paramString6;
    this.hFU = paramString7;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207569);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((this.liveId != paramObject.liveId) || (this.hFK != paramObject.hFK) || (!p.j(this.hFQ, paramObject.hFQ)) || (!p.j(this.hFR, paramObject.hFR)) || (!p.j(this.hFS, paramObject.hFS)) || (!p.j(this.hFO, paramObject.hFO)) || (!p.j(this.seq, paramObject.seq)) || (this.scene != paramObject.scene) || (this.businessType != paramObject.businessType) || (!p.j(this.hFT, paramObject.hFT)) || (!p.j(this.hFU, paramObject.hFU))) {}
      }
    }
    else
    {
      AppMethodBeat.o(207569);
      return true;
    }
    AppMethodBeat.o(207569);
    return false;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    AppMethodBeat.i(207568);
    long l = this.liveId;
    int i3 = (int)(l ^ l >>> 32);
    l = this.hFK;
    int i4 = (int)(l ^ l >>> 32);
    String str = this.hFQ;
    int i;
    int j;
    label76:
    int k;
    label93:
    int m;
    label111:
    int n;
    label129:
    int i5;
    int i6;
    if (str != null)
    {
      i = str.hashCode();
      str = this.hFR;
      if (str == null) {
        break label247;
      }
      j = str.hashCode();
      str = this.hFS;
      if (str == null) {
        break label252;
      }
      k = str.hashCode();
      str = this.hFO;
      if (str == null) {
        break label257;
      }
      m = str.hashCode();
      str = this.seq;
      if (str == null) {
        break label263;
      }
      n = str.hashCode();
      i5 = this.scene;
      i6 = this.businessType;
      str = this.hFT;
      if (str == null) {
        break label269;
      }
    }
    label257:
    label263:
    label269:
    for (int i1 = str.hashCode();; i1 = 0)
    {
      str = this.hFU;
      if (str != null) {
        i2 = str.hashCode();
      }
      AppMethodBeat.o(207568);
      return (i1 + (((n + (m + (k + (j + (i + (i3 * 31 + i4) * 31) * 31) * 31) * 31) * 31) * 31 + i5) * 31 + i6) * 31) * 31 + i2;
      i = 0;
      break;
      label247:
      j = 0;
      break label76;
      label252:
      k = 0;
      break label93;
      m = 0;
      break label111;
      n = 0;
      break label129;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207567);
    String str = "FinderLiveApplyLiveMicInfo(liveId=" + this.liveId + ", objectId=" + this.hFK + ", applyMicSdkUserId=" + this.hFQ + ", applyMicSdkLiveId=" + this.hFR + ", applyMicFinderUsername=" + this.hFS + ", liveMicId=" + this.hFO + ", seq=" + this.seq + ", scene=" + this.scene + ", businessType=" + this.businessType + ", applyNickname=" + this.hFT + ", applyAvatarUrl=" + this.hFU + ")";
    AppMethodBeat.o(207567);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.h
 * JD-Core Version:    0.7.0.1
 */