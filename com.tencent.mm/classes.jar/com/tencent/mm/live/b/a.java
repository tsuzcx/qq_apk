package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "", "liveId", "", "micId", "", "userId", "sdkAppId", "", "roleId", "sdkLiveId", "userSig", "privateMapKey", "expireForPmk", "sdkParam", "micType", "seq", "(JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;J)V", "getExpireForPmk", "()J", "getLiveId", "getMicId", "()Ljava/lang/String;", "getMicType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPrivateMapKey", "getRoleId", "()I", "getSdkAppId", "getSdkLiveId", "getSdkParam", "getSeq", "getUserId", "getUserSig", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;J)Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class a
{
  public final int hFA;
  public final int hFB;
  public final long hFC;
  public final String hFD;
  public final Integer hFE;
  public final String hFz;
  public final long liveId;
  public final String privateMapKey;
  public final int sdkAppId;
  public final long seq;
  public final String userId;
  public final String userSig;
  
  public a(long paramLong1, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, long paramLong2, String paramString5, Integer paramInteger, long paramLong3)
  {
    this.liveId = paramLong1;
    this.hFz = paramString1;
    this.userId = paramString2;
    this.sdkAppId = paramInt1;
    this.hFA = paramInt2;
    this.hFB = paramInt3;
    this.userSig = paramString3;
    this.privateMapKey = paramString4;
    this.hFC = paramLong2;
    this.hFD = paramString5;
    this.hFE = paramInteger;
    this.seq = paramLong3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207552);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.liveId != paramObject.liveId) || (!p.j(this.hFz, paramObject.hFz)) || (!p.j(this.userId, paramObject.userId)) || (this.sdkAppId != paramObject.sdkAppId) || (this.hFA != paramObject.hFA) || (this.hFB != paramObject.hFB) || (!p.j(this.userSig, paramObject.userSig)) || (!p.j(this.privateMapKey, paramObject.privateMapKey)) || (this.hFC != paramObject.hFC) || (!p.j(this.hFD, paramObject.hFD)) || (!p.j(this.hFE, paramObject.hFE)) || (this.seq != paramObject.seq)) {}
      }
    }
    else
    {
      AppMethodBeat.o(207552);
      return true;
    }
    AppMethodBeat.o(207552);
    return false;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(207551);
    long l = this.liveId;
    int i2 = (int)(l ^ l >>> 32);
    Object localObject = this.hFz;
    int i;
    int j;
    label59:
    int i3;
    int i4;
    int i5;
    int k;
    label94:
    int m;
    label112:
    int i6;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.userId;
      if (localObject == null) {
        break label258;
      }
      j = localObject.hashCode();
      i3 = this.sdkAppId;
      i4 = this.hFA;
      i5 = this.hFB;
      localObject = this.userSig;
      if (localObject == null) {
        break label263;
      }
      k = localObject.hashCode();
      localObject = this.privateMapKey;
      if (localObject == null) {
        break label268;
      }
      m = localObject.hashCode();
      l = this.hFC;
      i6 = (int)(l ^ l >>> 32);
      localObject = this.hFD;
      if (localObject == null) {
        break label274;
      }
    }
    label258:
    label263:
    label268:
    label274:
    for (int n = localObject.hashCode();; n = 0)
    {
      localObject = this.hFE;
      if (localObject != null) {
        i1 = localObject.hashCode();
      }
      l = this.seq;
      int i7 = (int)(l ^ l >>> 32);
      AppMethodBeat.o(207551);
      return ((n + ((m + (k + ((((j + (i + i2 * 31) * 31) * 31 + i3) * 31 + i4) * 31 + i5) * 31) * 31) * 31 + i6) * 31) * 31 + i1) * 31 + i7;
      i = 0;
      break;
      j = 0;
      break label59;
      k = 0;
      break label94;
      m = 0;
      break label112;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207550);
    String str = "AcceptLiveMicInfo(liveId=" + this.liveId + ", micId=" + this.hFz + ", userId=" + this.userId + ", sdkAppId=" + this.sdkAppId + ", roleId=" + this.hFA + ", sdkLiveId=" + this.hFB + ", userSig=" + this.userSig + ", privateMapKey=" + this.privateMapKey + ", expireForPmk=" + this.hFC + ", sdkParam=" + this.hFD + ", micType=" + this.hFE + ", seq=" + this.seq + ")";
    AppMethodBeat.o(207550);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a
 * JD-Core Version:    0.7.0.1
 */