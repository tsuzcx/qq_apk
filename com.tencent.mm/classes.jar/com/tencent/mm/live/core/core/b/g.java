package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/model/LiveStatus;", "", "()V", "anchorID", "", "availableAudioUsers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "floatMode", "Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;", "isDebugMode", "", "()Z", "setDebugMode", "(Z)V", "linkMicStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "liveID", "", "liveRoomStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveRoomStatus;", "networkQuality", "", "networkType", "pkLinkMicRole", "Lcom/tencent/mm/live/core/core/model/LiveStatus$PKLinkMicRole;", "pkLinkMicStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$PKLinkMicStatus;", "pkUserId", "resumeFromPermissionCheck", "selfSdkID", "getSelfSdkID", "()Ljava/lang/String;", "setSelfSdkID", "(Ljava/lang/String;)V", "videoMicID", "addAvailableAudioUser", "", "sdkID", "audioLinkMic", "changeToFloatMode", "changeToNormalMode", "changeToPermissionMode", "checkInRoom", "currentRoomID", "enterRoom", "exitRoom", "getAnchorID", "getNetworkQuality", "getNetworkType", "getPkUserID", "getVideoMicID", "isEnterRoom", "isFloatMode", "isInAudioLinkMic", "isInPkLinkMic", "isInPkWaitMic", "isInRoom", "(Ljava/lang/Long;)Z", "isInVideoLinkMic", "isNormalMode", "isPkRoleAccept", "isPkRoleApply", "isResumeFromPermissionCheck", "noLinkMic", "noPkLink", "pkLinkMic", "pkRoleAccept", "pkRoleApply", "pkRoleDefault", "pkWaitMic", "removeAvailableAudioUser", "setAnchorID", "id", "setPkUserID", "setResumeFromPermissionCheck", "value", "setVideoMicID", "updateNetworkQuality", "quality", "updateNetworkType", "type", "updateStart", "status", "videoLinkMic", "Companion", "LinkMicStatus", "LiveRoomStatus", "MiniWindowMode", "PKLinkMicRole", "PKLinkMicStatus", "plugin-core_release"})
public final class g
{
  public static final a hzM;
  public c hzA;
  public b hzB;
  public f hzC;
  private g.e hzD;
  public d hzE;
  public long hzF;
  public String hzG;
  private String hzH;
  public String hzI;
  public String hzJ;
  private ArrayList<String> hzK;
  public int hzL;
  public boolean hzz;
  public boolean isDebugMode;
  public int networkType;
  
  static
  {
    AppMethodBeat.i(196485);
    hzM = new a((byte)0);
    AppMethodBeat.o(196485);
  }
  
  public g()
  {
    AppMethodBeat.i(196484);
    this.hzA = c.hzS;
    this.hzB = b.hzN;
    this.hzC = f.hAe;
    this.hzD = g.e.hAa;
    this.hzE = d.hzW;
    this.hzF = -1L;
    this.hzG = "";
    this.hzH = "";
    this.hzI = "";
    this.hzK = new ArrayList();
    Object localObject = e.h.hya;
    this.hzL = e.h.aCS();
    this.networkType = -1;
    localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    if (((e)localObject).azQ().getInt(ar.a.Onl, 0) == 1) {}
    for (;;)
    {
      this.isDebugMode = bool;
      AppMethodBeat.o(196484);
      return;
      bool = false;
    }
  }
  
  private final boolean aDs()
  {
    return this.hzA == c.hzT;
  }
  
  public final boolean aDt()
  {
    return this.hzB == b.hzP;
  }
  
  public final boolean aDu()
  {
    return this.hzB == b.hzO;
  }
  
  public final boolean b(Long paramLong)
  {
    AppMethodBeat.i(196483);
    boolean bool;
    if (paramLong == null)
    {
      bool = aDs();
      AppMethodBeat.o(196483);
      return bool;
    }
    long l = this.hzF;
    if (paramLong.longValue() == l)
    {
      bool = aDs();
      AppMethodBeat.o(196483);
      return bool;
    }
    AppMethodBeat.o(196483);
    return false;
  }
  
  public final boolean isFloatMode()
  {
    return this.hzE == d.hzX;
  }
  
  public final boolean isNormalMode()
  {
    return this.hzE == d.hzW;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/model/LiveStatus$Companion;", "", "()V", "LIVE_DEFAULT", "", "plugin-core_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "", "(Ljava/lang/String;I)V", "NO_LINK_MIC", "AUDIO_LINK_MIC", "VIDEO_LINK_MIC", "PK_LINK_MIC", "plugin-core_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(196468);
      b localb1 = new b("NO_LINK_MIC", 0);
      hzN = localb1;
      b localb2 = new b("AUDIO_LINK_MIC", 1);
      hzO = localb2;
      b localb3 = new b("VIDEO_LINK_MIC", 2);
      hzP = localb3;
      b localb4 = new b("PK_LINK_MIC", 3);
      hzQ = localb4;
      hzR = new b[] { localb1, localb2, localb3, localb4 };
      AppMethodBeat.o(196468);
    }
    
    private b() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveRoomStatus;", "", "(Ljava/lang/String;I)V", "LIVE_OUT_ROOM", "LIVE_IN_ROOM", "LIVE_JOIN_ROOM", "plugin-core_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(196471);
      c localc1 = new c("LIVE_OUT_ROOM", 0);
      hzS = localc1;
      c localc2 = new c("LIVE_IN_ROOM", 1);
      hzT = localc2;
      c localc3 = new c("LIVE_JOIN_ROOM", 2);
      hzU = localc3;
      hzV = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(196471);
    }
    
    private c() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;", "", "(Ljava/lang/String;I)V", "NORMAL_MODE", "FLOAT_MODE", "PERMISSION_MODE", "plugin-core_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(196474);
      d locald1 = new d("NORMAL_MODE", 0);
      hzW = locald1;
      d locald2 = new d("FLOAT_MODE", 1);
      hzX = locald2;
      d locald3 = new d("PERMISSION_MODE", 2);
      hzY = locald3;
      hzZ = new d[] { locald1, locald2, locald3 };
      AppMethodBeat.o(196474);
    }
    
    private d() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/model/LiveStatus$PKLinkMicStatus;", "", "(Ljava/lang/String;I)V", "NO_PK", "PK_WAITING", "PK_LINKING", "plugin-core_release"})
  public static enum f
  {
    static
    {
      AppMethodBeat.i(196480);
      f localf1 = new f("NO_PK", 0);
      hAe = localf1;
      f localf2 = new f("PK_WAITING", 1);
      hAf = localf2;
      f localf3 = new f("PK_LINKING", 2);
      hAg = localf3;
      hAh = new f[] { localf1, localf2, localf3 };
      AppMethodBeat.o(196480);
    }
    
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.g
 * JD-Core Version:    0.7.0.1
 */