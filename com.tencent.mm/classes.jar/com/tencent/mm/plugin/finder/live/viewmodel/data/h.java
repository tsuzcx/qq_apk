package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.bgh;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "", "sdkUserId", "", "headUrl", "username", "nickname", "micType", "", "sessionId", "pkSign", "Lcom/tencent/mm/protobuf/ByteString;", "isPkWithAnchor", "", "sdkLiveId", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "signature", "micStatus", "liveContactFlag", "notTalking", "bgUrl", "audioMode", "userAttrFlag", "", "finderLiveContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "isRandomMatch", "isOtherRoomUser", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ZILcom/tencent/mm/protocal/protobuf/FinderAuthInfo;Ljava/lang/String;IIZLjava/lang/String;ZJLcom/tencent/mm/protocal/protobuf/FinderLiveContact;ZLjava/lang/Boolean;)V", "getAudioMode", "()Z", "setAudioMode", "(Z)V", "getAuthInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "setAuthInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;)V", "getBgUrl", "()Ljava/lang/String;", "setBgUrl", "(Ljava/lang/String;)V", "getFinderLiveContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getHeadUrl", "()Ljava/lang/Boolean;", "setOtherRoomUser", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getLiveContactFlag", "()I", "getMicStatus", "setMicStatus", "(I)V", "getMicType", "getNickname", "getNotTalking", "setNotTalking", "getPkSign", "()Lcom/tencent/mm/protobuf/ByteString;", "getSdkLiveId", "getSdkUserId", "getSessionId", "getSignature", "getUserAttrFlag", "()J", "setUserAttrFlag", "(J)V", "getUsername", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ZILcom/tencent/mm/protocal/protobuf/FinderAuthInfo;Ljava/lang/String;IIZLjava/lang/String;ZJLcom/tencent/mm/protocal/protobuf/FinderLiveContact;ZLjava/lang/Boolean;)Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "equals", "other", "hashCode", "inWaitingState", "toString", "transToDefaultState", "", "transToLinkedState", "transToWaitingState", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public boolean AWE;
  private final b EbC;
  public final boolean EbD;
  public int EbE;
  public final int EbF;
  public boolean EbG;
  public String EbH;
  public long EbI;
  public final bgh EbJ;
  public Boolean EbK;
  public FinderAuthInfo authInfo;
  public final String headUrl;
  public final boolean mXF;
  public final String mXL;
  public final int mXM;
  public final int mXz;
  public final String nickname;
  public final String sessionId;
  public final String signature;
  public final String username;
  
  private h(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, b paramb, boolean paramBoolean1, int paramInt2, FinderAuthInfo paramFinderAuthInfo, String paramString6, int paramInt3, int paramInt4, boolean paramBoolean2, String paramString7, long paramLong, bgh parambgh, boolean paramBoolean3)
  {
    this.mXL = paramString1;
    this.headUrl = paramString2;
    this.username = paramString3;
    this.nickname = paramString4;
    this.mXM = paramInt1;
    this.sessionId = paramString5;
    this.EbC = paramb;
    this.EbD = paramBoolean1;
    this.mXz = paramInt2;
    this.authInfo = paramFinderAuthInfo;
    this.signature = paramString6;
    this.EbE = paramInt3;
    this.EbF = paramInt4;
    this.EbG = paramBoolean2;
    this.EbH = paramString7;
    this.AWE = false;
    this.EbI = paramLong;
    this.EbJ = parambgh;
    this.mXF = paramBoolean3;
    this.EbK = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(356914);
    if (this == paramObject)
    {
      AppMethodBeat.o(356914);
      return true;
    }
    if (!(paramObject instanceof h))
    {
      AppMethodBeat.o(356914);
      return false;
    }
    paramObject = (h)paramObject;
    if (!s.p(this.mXL, paramObject.mXL))
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (!s.p(this.headUrl, paramObject.headUrl))
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (!s.p(this.username, paramObject.username))
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (!s.p(this.nickname, paramObject.nickname))
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (this.mXM != paramObject.mXM)
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (!s.p(this.sessionId, paramObject.sessionId))
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (!s.p(this.EbC, paramObject.EbC))
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (this.EbD != paramObject.EbD)
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (this.mXz != paramObject.mXz)
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (!s.p(this.authInfo, paramObject.authInfo))
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (!s.p(this.signature, paramObject.signature))
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (this.EbE != paramObject.EbE)
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (this.EbF != paramObject.EbF)
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (this.EbG != paramObject.EbG)
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (!s.p(this.EbH, paramObject.EbH))
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (this.AWE != paramObject.AWE)
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (this.EbI != paramObject.EbI)
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (!s.p(this.EbJ, paramObject.EbJ))
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (this.mXF != paramObject.mXF)
    {
      AppMethodBeat.o(356914);
      return false;
    }
    if (!s.p(this.EbK, paramObject.EbK))
    {
      AppMethodBeat.o(356914);
      return false;
    }
    AppMethodBeat.o(356914);
    return true;
  }
  
  public final String exZ()
  {
    return this.headUrl;
  }
  
  public final void eya()
  {
    int i = 2;
    if (this.mXM == 2) {}
    for (;;)
    {
      this.EbE = i;
      return;
      if (this.mXM == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void eyb()
  {
    int i;
    if (this.mXM == 2) {
      i = 4;
    }
    for (;;)
    {
      this.EbE = i;
      return;
      if (this.mXM == 1) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  public final String getNickname()
  {
    return this.nickname;
  }
  
  public final String getSessionId()
  {
    return this.sessionId;
  }
  
  public final String getUsername()
  {
    return this.username;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356894);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FinderLiveLinkMicUser(sdkUserId=").append(this.mXL).append(", headUrl=").append(this.headUrl).append(", username=").append(this.username).append(", nickname=").append(this.nickname).append(", micType=").append(this.mXM).append(", sessionId=").append(this.sessionId).append(", pkSign=").append(this.EbC).append(", isPkWithAnchor=").append(this.EbD).append(", sdkLiveId=").append(this.mXz).append(", authInfo=").append(this.authInfo).append(", signature=").append(this.signature).append(", micStatus=");
    ((StringBuilder)localObject).append(this.EbE).append(", liveContactFlag=").append(this.EbF).append(", notTalking=").append(this.EbG).append(", bgUrl=").append(this.EbH).append(", audioMode=").append(this.AWE).append(", userAttrFlag=").append(this.EbI).append(", finderLiveContact=").append(this.EbJ).append(", isRandomMatch=").append(this.mXF).append(", isOtherRoomUser=").append(this.EbK).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(356894);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.h
 * JD-Core Version:    0.7.0.1
 */