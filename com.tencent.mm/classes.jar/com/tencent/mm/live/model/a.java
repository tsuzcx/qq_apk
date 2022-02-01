package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "", "liveId", "", "micId", "", "userId", "sdkAppId", "", "roleId", "sdkLiveId", "userSig", "privateMapKey", "expireForPmk", "sdkParam", "", "micType", "seq", "pkSign", "isAnchorPk", "", "isRandomMatch", "(JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;J[BLjava/lang/Integer;JLjava/lang/String;ZZ)V", "getExpireForPmk", "()J", "()Z", "getLiveId", "getMicId", "()Ljava/lang/String;", "getMicType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPkSign", "getPrivateMapKey", "getRoleId", "()I", "getSdkAppId", "getSdkLiveId", "getSdkParam", "()[B", "getSeq", "getUserId", "getUserSig", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;J[BLjava/lang/Integer;JLjava/lang/String;ZZ)Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "equals", "other", "hashCode", "toString", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final long liveId;
  public final long mXA;
  public final byte[] mXB;
  public final Integer mXC;
  public final String mXD;
  private final boolean mXE;
  public final boolean mXF;
  public final String mXx;
  public final int mXy;
  public final int mXz;
  public final String privateMapKey;
  public final int sdkAppId;
  private final long seq;
  public final String userId;
  public final String userSig;
  
  public a(long paramLong1, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, long paramLong2, byte[] paramArrayOfByte, Integer paramInteger, long paramLong3, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.liveId = paramLong1;
    this.mXx = paramString1;
    this.userId = paramString2;
    this.sdkAppId = paramInt1;
    this.mXy = paramInt2;
    this.mXz = paramInt3;
    this.userSig = paramString3;
    this.privateMapKey = paramString4;
    this.mXA = paramLong2;
    this.mXB = paramArrayOfByte;
    this.mXC = paramInteger;
    this.seq = paramLong3;
    this.mXD = paramString5;
    this.mXE = paramBoolean1;
    this.mXF = paramBoolean2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(246624);
    if (this == paramObject)
    {
      AppMethodBeat.o(246624);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(246624);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.liveId != paramObject.liveId)
    {
      AppMethodBeat.o(246624);
      return false;
    }
    if (!s.p(this.mXx, paramObject.mXx))
    {
      AppMethodBeat.o(246624);
      return false;
    }
    if (!s.p(this.userId, paramObject.userId))
    {
      AppMethodBeat.o(246624);
      return false;
    }
    if (this.sdkAppId != paramObject.sdkAppId)
    {
      AppMethodBeat.o(246624);
      return false;
    }
    if (this.mXy != paramObject.mXy)
    {
      AppMethodBeat.o(246624);
      return false;
    }
    if (this.mXz != paramObject.mXz)
    {
      AppMethodBeat.o(246624);
      return false;
    }
    if (!s.p(this.userSig, paramObject.userSig))
    {
      AppMethodBeat.o(246624);
      return false;
    }
    if (!s.p(this.privateMapKey, paramObject.privateMapKey))
    {
      AppMethodBeat.o(246624);
      return false;
    }
    if (this.mXA != paramObject.mXA)
    {
      AppMethodBeat.o(246624);
      return false;
    }
    if (!s.p(this.mXB, paramObject.mXB))
    {
      AppMethodBeat.o(246624);
      return false;
    }
    if (!s.p(this.mXC, paramObject.mXC))
    {
      AppMethodBeat.o(246624);
      return false;
    }
    if (this.seq != paramObject.seq)
    {
      AppMethodBeat.o(246624);
      return false;
    }
    if (!s.p(this.mXD, paramObject.mXD))
    {
      AppMethodBeat.o(246624);
      return false;
    }
    if (this.mXE != paramObject.mXE)
    {
      AppMethodBeat.o(246624);
      return false;
    }
    if (this.mXF != paramObject.mXF)
    {
      AppMethodBeat.o(246624);
      return false;
    }
    AppMethodBeat.o(246624);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246609);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AcceptLiveMicInfo(liveId=").append(this.liveId).append(", micId=").append(this.mXx).append(", userId=").append(this.userId).append(", sdkAppId=").append(this.sdkAppId).append(", roleId=").append(this.mXy).append(", sdkLiveId=").append(this.mXz).append(", userSig=").append(this.userSig).append(", privateMapKey=").append(this.privateMapKey).append(", expireForPmk=").append(this.mXA).append(", sdkParam=").append(Arrays.toString(this.mXB)).append(", micType=").append(this.mXC).append(", seq=");
    ((StringBuilder)localObject).append(this.seq).append(", pkSign=").append(this.mXD).append(", isAnchorPk=").append(this.mXE).append(", isRandomMatch=").append(this.mXF).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(246609);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.model.a
 * JD-Core Version:    0.7.0.1
 */