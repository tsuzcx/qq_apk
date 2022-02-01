package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/core/model/LiveStatus;", "", "()V", "anchorID", "", "availableAudioUsers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "floatMode", "Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;", "isDebugMode", "", "()Z", "setDebugMode", "(Z)V", "linkMicStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "liveID", "", "liveRoomStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveRoomStatus;", "networkQuality", "", "resumeFromPermissionCheck", "selfSdkID", "getSelfSdkID", "()Ljava/lang/String;", "setSelfSdkID", "(Ljava/lang/String;)V", "videoMicID", "addAvailableAudioUser", "", "sdkID", "audioLinkMic", "changeToFloatMode", "changeToNormalMode", "changeToPermissionMode", "checkInRoom", "currentRoomID", "enterRoom", "exitRoom", "getAnchorID", "getNetworkQuality", "getVideoMicID", "isEnterRoom", "isFloatMode", "isInAudioLinkMic", "isInRoom", "(Ljava/lang/Long;)Z", "isInVideoLinkMic", "isNormalMode", "isResumeFromPermissionCheck", "noLinkMic", "removeAvailableAudioUser", "setAnchorID", "id", "setResumeFromPermissionCheck", "value", "setVideoMicID", "updateNetworkQuality", "quality", "updateStart", "status", "videoLinkMic", "Companion", "LinkMicStatus", "LiveRoomStatus", "MiniWindowMode", "plugin-core_release"})
public final class e
{
  public static final e.a gHS;
  public boolean gHI;
  public e.c gHJ;
  public e.b gHK;
  public e.d gHL;
  public long gHM;
  public String gHN;
  public String gHO;
  public String gHP;
  private ArrayList<String> gHQ;
  public int gHR;
  public boolean isDebugMode;
  
  static
  {
    AppMethodBeat.i(216834);
    gHS = new e.a((byte)0);
    AppMethodBeat.o(216834);
  }
  
  public e()
  {
    AppMethodBeat.i(216833);
    this.gHJ = e.c.gHX;
    this.gHK = e.b.gHT;
    this.gHL = e.d.gIb;
    this.gHM = -1L;
    this.gHN = "";
    this.gHO = "";
    this.gHQ = new ArrayList();
    Object localObject = c.c.gHi;
    this.gHR = c.c.alu();
    localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    if (((com.tencent.mm.kernel.e)localObject).ajl().getInt(al.a.IIZ, 0) == 1) {}
    for (;;)
    {
      this.isDebugMode = bool;
      AppMethodBeat.o(216833);
      return;
      bool = false;
    }
  }
  
  private final boolean alD()
  {
    return this.gHJ == e.c.gHY;
  }
  
  public final boolean alC()
  {
    return this.gHL == e.d.gIb;
  }
  
  public final boolean alE()
  {
    return this.gHK == e.b.gHV;
  }
  
  public final boolean alF()
  {
    return this.gHK == e.b.gHU;
  }
  
  public final boolean b(Long paramLong)
  {
    AppMethodBeat.i(216832);
    boolean bool;
    if (paramLong == null)
    {
      bool = alD();
      AppMethodBeat.o(216832);
      return bool;
    }
    long l = this.gHM;
    if (paramLong.longValue() == l)
    {
      bool = alD();
      AppMethodBeat.o(216832);
      return bool;
    }
    AppMethodBeat.o(216832);
    return false;
  }
  
  public final boolean isFloatMode()
  {
    return this.gHL == e.d.gIc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.e
 * JD-Core Version:    0.7.0.1
 */