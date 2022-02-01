package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/FinderLiveAcceptLiveMicInfo;", "", "liveId", "", "objectId", "acceptMicSdkUserId", "", "acceptMicSdkLiveId", "acceptMicFinderUsername", "liveMicId", "scene", "", "businessType", "sdkPkSign", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getAcceptMicFinderUsername", "()Ljava/lang/String;", "getAcceptMicSdkLiveId", "getAcceptMicSdkUserId", "getBusinessType", "()I", "getLiveId", "()J", "getLiveMicId", "getObjectId", "getScene", "getSdkPkSign", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class g
{
  public final int businessType;
  public final long hFK;
  public final String hFL;
  public final String hFM;
  public final String hFN;
  public final String hFO;
  public final String hFP;
  public final long liveId;
  public final int scene;
  
  public g(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5)
  {
    this.liveId = paramLong1;
    this.hFK = paramLong2;
    this.hFL = paramString1;
    this.hFM = paramString2;
    this.hFN = paramString3;
    this.hFO = paramString4;
    this.scene = paramInt1;
    this.businessType = paramInt2;
    this.hFP = paramString5;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207566);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((this.liveId != paramObject.liveId) || (this.hFK != paramObject.hFK) || (!p.j(this.hFL, paramObject.hFL)) || (!p.j(this.hFM, paramObject.hFM)) || (!p.j(this.hFN, paramObject.hFN)) || (!p.j(this.hFO, paramObject.hFO)) || (this.scene != paramObject.scene) || (this.businessType != paramObject.businessType) || (!p.j(this.hFP, paramObject.hFP))) {}
      }
    }
    else
    {
      AppMethodBeat.o(207566);
      return true;
    }
    AppMethodBeat.o(207566);
    return false;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(207565);
    long l = this.liveId;
    int i1 = (int)(l ^ l >>> 32);
    l = this.hFK;
    int i2 = (int)(l ^ l >>> 32);
    String str = this.hFL;
    int i;
    int j;
    label76:
    int k;
    if (str != null)
    {
      i = str.hashCode();
      str = this.hFM;
      if (str == null) {
        break label199;
      }
      j = str.hashCode();
      str = this.hFN;
      if (str == null) {
        break label204;
      }
      k = str.hashCode();
      label93:
      str = this.hFO;
      if (str == null) {
        break label209;
      }
    }
    label199:
    label204:
    label209:
    for (int m = str.hashCode();; m = 0)
    {
      int i3 = this.scene;
      int i4 = this.businessType;
      str = this.hFP;
      if (str != null) {
        n = str.hashCode();
      }
      AppMethodBeat.o(207565);
      return (((m + (k + (j + (i + (i1 * 31 + i2) * 31) * 31) * 31) * 31) * 31 + i3) * 31 + i4) * 31 + n;
      i = 0;
      break;
      j = 0;
      break label76;
      k = 0;
      break label93;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207564);
    String str = "FinderLiveAcceptLiveMicInfo(liveId=" + this.liveId + ", objectId=" + this.hFK + ", acceptMicSdkUserId=" + this.hFL + ", acceptMicSdkLiveId=" + this.hFM + ", acceptMicFinderUsername=" + this.hFN + ", liveMicId=" + this.hFO + ", scene=" + this.scene + ", businessType=" + this.businessType + ", sdkPkSign=" + this.hFP + ")";
    AppMethodBeat.o(207564);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.g
 * JD-Core Version:    0.7.0.1
 */