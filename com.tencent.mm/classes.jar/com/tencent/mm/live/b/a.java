package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "", "liveId", "", "micId", "", "userId", "sdkAppId", "", "roleId", "sdkLiveId", "userSig", "privateMapKey", "expireForPmk", "sdkParam", "", "micType", "seq", "pkSign", "isAnchorPk", "", "(JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;J[BLjava/lang/Integer;JLjava/lang/String;Z)V", "getExpireForPmk", "()J", "()Z", "getLiveId", "getMicId", "()Ljava/lang/String;", "getMicType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPkSign", "getPrivateMapKey", "getRoleId", "()I", "getSdkAppId", "getSdkLiveId", "getSdkParam", "()[B", "getSeq", "getUserId", "getUserSig", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;J[BLjava/lang/Integer;JLjava/lang/String;Z)Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "equals", "other", "hashCode", "toString", "plugin-logic_release"})
public final class a
{
  public final String ktE;
  public final int ktF;
  public final int ktG;
  public final long ktH;
  public final byte[] ktI;
  public final Integer ktJ;
  public final String ktK;
  private final boolean ktL;
  public final long liveId;
  public final String privateMapKey;
  public final int sdkAppId;
  private final long seq;
  public final String userId;
  public final String userSig;
  
  public a(long paramLong1, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, long paramLong2, byte[] paramArrayOfByte, Integer paramInteger, long paramLong3, String paramString5, boolean paramBoolean)
  {
    this.liveId = paramLong1;
    this.ktE = paramString1;
    this.userId = paramString2;
    this.sdkAppId = paramInt1;
    this.ktF = paramInt2;
    this.ktG = paramInt3;
    this.userSig = paramString3;
    this.privateMapKey = paramString4;
    this.ktH = paramLong2;
    this.ktI = paramArrayOfByte;
    this.ktJ = paramInteger;
    this.seq = paramLong3;
    this.ktK = paramString5;
    this.ktL = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(189737);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.liveId != paramObject.liveId) || (!p.h(this.ktE, paramObject.ktE)) || (!p.h(this.userId, paramObject.userId)) || (this.sdkAppId != paramObject.sdkAppId) || (this.ktF != paramObject.ktF) || (this.ktG != paramObject.ktG) || (!p.h(this.userSig, paramObject.userSig)) || (!p.h(this.privateMapKey, paramObject.privateMapKey)) || (this.ktH != paramObject.ktH) || (!p.h(this.ktI, paramObject.ktI)) || (!p.h(this.ktJ, paramObject.ktJ)) || (this.seq != paramObject.seq) || (!p.h(this.ktK, paramObject.ktK)) || (this.ktL != paramObject.ktL)) {}
      }
    }
    else
    {
      AppMethodBeat.o(189737);
      return true;
    }
    AppMethodBeat.o(189737);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189718);
    String str = "AcceptLiveMicInfo(liveId=" + this.liveId + ", micId=" + this.ktE + ", userId=" + this.userId + ", sdkAppId=" + this.sdkAppId + ", roleId=" + this.ktF + ", sdkLiveId=" + this.ktG + ", userSig=" + this.userSig + ", privateMapKey=" + this.privateMapKey + ", expireForPmk=" + this.ktH + ", sdkParam=" + Arrays.toString(this.ktI) + ", micType=" + this.ktJ + ", seq=" + this.seq + ", pkSign=" + this.ktK + ", isAnchorPk=" + this.ktL + ")";
    AppMethodBeat.o(189718);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.a
 * JD-Core Version:    0.7.0.1
 */