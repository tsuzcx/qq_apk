package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.aza;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "", "sdkUserId", "", "headUrl", "username", "nickname", "micType", "", "sessionId", "pkSign", "Lcom/tencent/mm/protobuf/ByteString;", "isPkWithAnchor", "", "sdkLiveId", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "signature", "micStatus", "liveContactFlag", "notTalking", "bgUrl", "audioMode", "userAttrFlag", "", "finderLiveContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ZILcom/tencent/mm/protocal/protobuf/FinderAuthInfo;Ljava/lang/String;IIZLjava/lang/String;ZJLcom/tencent/mm/protocal/protobuf/FinderLiveContact;)V", "getAudioMode", "()Z", "setAudioMode", "(Z)V", "getAuthInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "setAuthInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;)V", "getBgUrl", "()Ljava/lang/String;", "setBgUrl", "(Ljava/lang/String;)V", "getFinderLiveContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getHeadUrl", "getLiveContactFlag", "()I", "getMicStatus", "setMicStatus", "(I)V", "getMicType", "getNickname", "getNotTalking", "setNotTalking", "getPkSign", "()Lcom/tencent/mm/protobuf/ByteString;", "getSdkLiveId", "getSdkUserId", "getSessionId", "getSignature", "getUserAttrFlag", "()J", "setUserAttrFlag", "(J)V", "getUsername", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "transToDefaultState", "", "transToLinkedState", "transToWaitingState", "plugin-finder-base_release"})
public final class h
{
  public FinderAuthInfo authInfo;
  public final String headUrl;
  public final int ktG;
  public final String ktR;
  public final int ktS;
  public final String nickname;
  public final String sessionId;
  public final String signature;
  public final String username;
  public boolean xzt;
  private final b zeE;
  public final boolean zeF;
  public int zeG;
  public final int zeH;
  public boolean zeI;
  public String zeJ;
  public long zeK;
  public final aza zeL;
  
  private h(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, b paramb, boolean paramBoolean1, int paramInt2, FinderAuthInfo paramFinderAuthInfo, String paramString6, int paramInt3, int paramInt4, boolean paramBoolean2, String paramString7, long paramLong, aza paramaza)
  {
    this.ktR = paramString1;
    this.headUrl = paramString2;
    this.username = paramString3;
    this.nickname = paramString4;
    this.ktS = paramInt1;
    this.sessionId = paramString5;
    this.zeE = paramb;
    this.zeF = paramBoolean1;
    this.ktG = paramInt2;
    this.authInfo = paramFinderAuthInfo;
    this.signature = paramString6;
    this.zeG = paramInt3;
    this.zeH = paramInt4;
    this.zeI = paramBoolean2;
    this.zeJ = paramString7;
    this.xzt = false;
    this.zeK = paramLong;
    this.zeL = paramaza;
  }
  
  public final void dGC()
  {
    int i = 2;
    if (this.ktS == 2) {}
    for (;;)
    {
      this.zeG = i;
      return;
      if (this.ktS == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void dGD()
  {
    int i;
    if (this.ktS == 2) {
      i = 4;
    }
    for (;;)
    {
      this.zeG = i;
      return;
      if (this.ktS == 1) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(258096);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!p.h(this.ktR, paramObject.ktR)) || (!p.h(this.headUrl, paramObject.headUrl)) || (!p.h(this.username, paramObject.username)) || (!p.h(this.nickname, paramObject.nickname)) || (this.ktS != paramObject.ktS) || (!p.h(this.sessionId, paramObject.sessionId)) || (!p.h(this.zeE, paramObject.zeE)) || (this.zeF != paramObject.zeF) || (this.ktG != paramObject.ktG) || (!p.h(this.authInfo, paramObject.authInfo)) || (!p.h(this.signature, paramObject.signature)) || (this.zeG != paramObject.zeG) || (this.zeH != paramObject.zeH) || (this.zeI != paramObject.zeI) || (!p.h(this.zeJ, paramObject.zeJ)) || (this.xzt != paramObject.xzt) || (this.zeK != paramObject.zeK) || (!p.h(this.zeL, paramObject.zeL))) {}
      }
    }
    else
    {
      AppMethodBeat.o(258096);
      return true;
    }
    AppMethodBeat.o(258096);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258094);
    String str = "FinderLiveLinkMicUser(sdkUserId=" + this.ktR + ", headUrl=" + this.headUrl + ", username=" + this.username + ", nickname=" + this.nickname + ", micType=" + this.ktS + ", sessionId=" + this.sessionId + ", pkSign=" + this.zeE + ", isPkWithAnchor=" + this.zeF + ", sdkLiveId=" + this.ktG + ", authInfo=" + this.authInfo + ", signature=" + this.signature + ", micStatus=" + this.zeG + ", liveContactFlag=" + this.zeH + ", notTalking=" + this.zeI + ", bgUrl=" + this.zeJ + ", audioMode=" + this.xzt + ", userAttrFlag=" + this.zeK + ", finderLiveContact=" + this.zeL + ")";
    AppMethodBeat.o(258094);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.h
 * JD-Core Version:    0.7.0.1
 */