package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.live.core.core.e.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/LiveStatus;", "", "()V", "anchorID", "", "availableAudioUsers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "floatMode", "Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;", "isDebugMode", "", "()Z", "setDebugMode", "(Z)V", "isDocCast", "linkMicStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "liveID", "", "liveMode", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveMode;", "liveRoomStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveRoomStatus;", "networkQuality", "", "networkType", "pause", "pkLinkMicRole", "Lcom/tencent/mm/live/core/core/model/LiveStatus$PKLinkMicRole;", "pkLinkMicStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$PKLinkMicStatus;", "pkUserId", "resumeFromPermissionCheck", "selfSdkID", "getSelfSdkID", "()Ljava/lang/String;", "setSelfSdkID", "(Ljava/lang/String;)V", "videoMicID", "addAvailableAudioUser", "", "sdkID", "audioLinkMic", "changeToFloatMode", "changeToNormalMode", "changeToPermissionMode", "checkInRoom", "currentRoomID", "enterRoom", "exitRoom", "getAnchorID", "getNetworkQuality", "getNetworkType", "getPkUserID", "getVideoMicID", "isAudioMode", "isEnterRoom", "isFloatMode", "isInAudioLinkMic", "isInPkLinkMic", "isInPkWaitMic", "isInRoom", "(Ljava/lang/Long;)Z", "isInVideoLinkMic", "isLiving", "isNormalMode", "isPausing", "isPkRoleAccept", "isPkRoleApply", "isResumeFromPermissionCheck", "isScreenShareMode", "isVideoMode", "noLinkMic", "noPkLink", "pauseLive", "pkLinkMic", "pkRoleAccept", "pkRoleApply", "pkRoleDefault", "pkWaitMic", "removeAvailableAudioUser", "resumeLive", "setAnchorID", "id", "setPkUserID", "setResumeFromPermissionCheck", "value", "setVideoMicID", "switchAudioMode", "switchScreenShareMode", "docCast", "switchVideoMode", "updateNetworkQuality", "quality", "updateNetworkType", "type", "updateStart", "status", "videoLinkMic", "Companion", "LinkMicStatus", "LiveMode", "LiveRoomStatus", "MiniWindowMode", "PKLinkMicRole", "PKLinkMicStatus", "plugin-core_release"})
public final class h
{
  public static final a kmK;
  public boolean isDebugMode;
  public e kmA;
  public long kmB;
  public String kmC;
  private String kmD;
  public String kmE;
  public c kmF;
  public boolean kmG;
  public String kmH;
  private ArrayList<String> kmI;
  public int kmJ;
  public boolean kmv;
  public d kmw;
  public b kmx;
  private h.g kmy;
  public f kmz;
  public int networkType;
  public boolean pause;
  
  static
  {
    AppMethodBeat.i(199359);
    kmK = new a((byte)0);
    AppMethodBeat.o(199359);
  }
  
  public h()
  {
    AppMethodBeat.i(199358);
    this.kmw = d.kmS;
    this.kmx = b.kmL;
    this.kmy = h.g.kne;
    this.kmz = f.kna;
    this.kmA = e.kmW;
    this.kmB = -1L;
    this.kmC = "";
    this.kmD = "";
    this.kmE = "";
    this.kmF = c.kmP;
    this.kmI = new ArrayList();
    Object localObject = e.m.kkI;
    this.kmJ = e.m.aKG();
    this.networkType = -1;
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    if (((f)localObject).aHp().getInt(ar.a.VCx, 0) == 1) {}
    for (;;)
    {
      this.isDebugMode = bool;
      AppMethodBeat.o(199358);
      return;
      bool = false;
    }
  }
  
  private final boolean aLn()
  {
    return this.kmw == d.kmT;
  }
  
  public final boolean a(Long paramLong)
  {
    AppMethodBeat.i(199346);
    boolean bool;
    if (paramLong == null)
    {
      bool = aLn();
      AppMethodBeat.o(199346);
      return bool;
    }
    long l = this.kmB;
    if (paramLong.longValue() == l)
    {
      bool = aLn();
      AppMethodBeat.o(199346);
      return bool;
    }
    AppMethodBeat.o(199346);
    return false;
  }
  
  public final boolean aLl()
  {
    return this.kmA == e.kmW;
  }
  
  public final boolean aLm()
  {
    return this.kmz == f.knb;
  }
  
  public final boolean aLo()
  {
    return this.kmx == b.kmN;
  }
  
  public final boolean aLp()
  {
    return this.kmx == b.kmM;
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(199351);
    Log.i("MicroMsg.LiveStatus", "switchAudioMode,pause:" + this.pause);
    this.pause = false;
    this.kmF = c.kmQ;
    AppMethodBeat.o(199351);
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(199353);
    Log.i("MicroMsg.LiveStatus", "switchVideoMode,pause:" + this.pause);
    this.pause = false;
    this.kmF = c.kmP;
    AppMethodBeat.o(199353);
  }
  
  public final boolean aLs()
  {
    return this.kmF == c.kmQ;
  }
  
  public final boolean isFloatMode()
  {
    return this.kmA == e.kmX;
  }
  
  public final boolean isLiving()
  {
    return this.kmw == d.kmT;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/LiveStatus$Companion;", "", "()V", "LIVE_DEFAULT", "", "TAG", "", "plugin-core_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "", "(Ljava/lang/String;I)V", "NO_LINK_MIC", "AUDIO_LINK_MIC", "VIDEO_LINK_MIC", "plugin-core_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(199121);
      b localb1 = new b("NO_LINK_MIC", 0);
      kmL = localb1;
      b localb2 = new b("AUDIO_LINK_MIC", 1);
      kmM = localb2;
      b localb3 = new b("VIDEO_LINK_MIC", 2);
      kmN = localb3;
      kmO = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(199121);
    }
    
    private b() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveMode;", "", "(Ljava/lang/String;I)V", "NORMAL_MODE", "AUDIO_MODE", "plugin-core_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(199002);
      c localc1 = new c("NORMAL_MODE", 0);
      kmP = localc1;
      c localc2 = new c("AUDIO_MODE", 1);
      kmQ = localc2;
      kmR = new c[] { localc1, localc2 };
      AppMethodBeat.o(199002);
    }
    
    private c() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveRoomStatus;", "", "(Ljava/lang/String;I)V", "LIVE_OUT_ROOM", "LIVE_IN_ROOM", "LIVE_JOIN_ROOM", "plugin-core_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(198527);
      d locald1 = new d("LIVE_OUT_ROOM", 0);
      kmS = locald1;
      d locald2 = new d("LIVE_IN_ROOM", 1);
      kmT = locald2;
      d locald3 = new d("LIVE_JOIN_ROOM", 2);
      kmU = locald3;
      kmV = new d[] { locald1, locald2, locald3 };
      AppMethodBeat.o(198527);
    }
    
    private d() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;", "", "(Ljava/lang/String;I)V", "NORMAL_MODE", "FLOAT_MODE", "PERMISSION_MODE", "plugin-core_release"})
  public static enum e
  {
    static
    {
      AppMethodBeat.i(200575);
      e locale1 = new e("NORMAL_MODE", 0);
      kmW = locale1;
      e locale2 = new e("FLOAT_MODE", 1);
      kmX = locale2;
      e locale3 = new e("PERMISSION_MODE", 2);
      kmY = locale3;
      kmZ = new e[] { locale1, locale2, locale3 };
      AppMethodBeat.o(200575);
    }
    
    private e() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/LiveStatus$PKLinkMicRole;", "", "(Ljava/lang/String;I)V", "ROLE_DEFAULT", "ROLE_APPLY_PK", "ROLE_ACCEPT_PK", "plugin-core_release"})
  public static enum f
  {
    static
    {
      AppMethodBeat.i(200671);
      f localf1 = new f("ROLE_DEFAULT", 0);
      kna = localf1;
      f localf2 = new f("ROLE_APPLY_PK", 1);
      knb = localf2;
      f localf3 = new f("ROLE_ACCEPT_PK", 2);
      knc = localf3;
      knd = new f[] { localf1, localf2, localf3 };
      AppMethodBeat.o(200671);
    }
    
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.h
 * JD-Core Version:    0.7.0.1
 */