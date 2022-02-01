package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/core/model/LiveStatus;", "", "()V", "anchorID", "", "availableAudioUsers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "floatMode", "Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;", "isDebugMode", "", "()Z", "setDebugMode", "(Z)V", "linkMicStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "liveID", "", "liveRoomStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveRoomStatus;", "networkQuality", "", "resumeFromPermissionCheck", "selfSdkID", "getSelfSdkID", "()Ljava/lang/String;", "setSelfSdkID", "(Ljava/lang/String;)V", "videoMicID", "addAvailableAudioUser", "", "sdkID", "audioLinkMic", "changeToFloatMode", "changeToNormalMode", "changeToPermissionMode", "checkInRoom", "currentRoomID", "enterRoom", "exitRoom", "getAnchorID", "getNetworkQuality", "getVideoMicID", "isEnterRoom", "isFloatMode", "isInAudioLinkMic", "isInRoom", "(Ljava/lang/Long;)Z", "isInVideoLinkMic", "isNormalMode", "isResumeFromPermissionCheck", "noLinkMic", "removeAvailableAudioUser", "setAnchorID", "id", "setResumeFromPermissionCheck", "value", "setVideoMicID", "updateNetworkQuality", "quality", "updateStart", "status", "videoLinkMic", "Companion", "LinkMicStatus", "LiveRoomStatus", "MiniWindowMode", "plugin-core_release"})
public final class e
{
  public static final e.a gKB;
  public int gKA;
  public boolean gKr;
  public e.c gKs;
  public b gKt;
  public d gKu;
  public long gKv;
  public String gKw;
  public String gKx;
  public String gKy;
  private ArrayList<String> gKz;
  public boolean isDebugMode;
  
  static
  {
    AppMethodBeat.i(196846);
    gKB = new e.a((byte)0);
    AppMethodBeat.o(196846);
  }
  
  public e()
  {
    AppMethodBeat.i(196845);
    this.gKs = e.c.gKG;
    this.gKt = b.gKC;
    this.gKu = d.gKK;
    this.gKv = -1L;
    this.gKw = "";
    this.gKx = "";
    this.gKz = new ArrayList();
    Object localObject = c.c.gJR;
    this.gKA = c.c.alJ();
    localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    if (((com.tencent.mm.kernel.e)localObject).ajA().getInt(am.a.JdF, 0) == 1) {}
    for (;;)
    {
      this.isDebugMode = bool;
      AppMethodBeat.o(196845);
      return;
      bool = false;
    }
  }
  
  private final boolean alS()
  {
    return this.gKs == e.c.gKH;
  }
  
  public final boolean alR()
  {
    return this.gKu == d.gKK;
  }
  
  public final boolean alT()
  {
    return this.gKt == b.gKE;
  }
  
  public final boolean alU()
  {
    return this.gKt == b.gKD;
  }
  
  public final boolean b(Long paramLong)
  {
    AppMethodBeat.i(196844);
    boolean bool;
    if (paramLong == null)
    {
      bool = alS();
      AppMethodBeat.o(196844);
      return bool;
    }
    long l = this.gKv;
    if (paramLong.longValue() == l)
    {
      bool = alS();
      AppMethodBeat.o(196844);
      return bool;
    }
    AppMethodBeat.o(196844);
    return false;
  }
  
  public final boolean isFloatMode()
  {
    return this.gKu == d.gKL;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "", "(Ljava/lang/String;I)V", "NO_LINK_MIC", "AUDIO_LINK_MIC", "VIDEO_LINK_MIC", "plugin-core_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(196835);
      b localb1 = new b("NO_LINK_MIC", 0);
      gKC = localb1;
      b localb2 = new b("AUDIO_LINK_MIC", 1);
      gKD = localb2;
      b localb3 = new b("VIDEO_LINK_MIC", 2);
      gKE = localb3;
      gKF = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(196835);
    }
    
    private b() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;", "", "(Ljava/lang/String;I)V", "NORMAL_MODE", "FLOAT_MODE", "PERMISSION_MODE", "plugin-core_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(196841);
      d locald1 = new d("NORMAL_MODE", 0);
      gKK = locald1;
      d locald2 = new d("FLOAT_MODE", 1);
      gKL = locald2;
      d locald3 = new d("PERMISSION_MODE", 2);
      gKM = locald3;
      gKN = new d[] { locald1, locald2, locald3 };
      AppMethodBeat.o(196841);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.e
 * JD-Core Version:    0.7.0.1
 */