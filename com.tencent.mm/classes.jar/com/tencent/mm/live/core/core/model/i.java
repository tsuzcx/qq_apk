package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.core.core.e.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/LiveStatus;", "", "()V", "anchorID", "", "availableAudioUsers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "floatMode", "Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;", "isDebugMode", "", "()Z", "setDebugMode", "(Z)V", "isDocCast", "linkMicStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "liveID", "", "liveMode", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveMode;", "liveRoomStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveRoomStatus;", "networkQuality", "", "networkType", "pause", "pkLinkMicRole", "Lcom/tencent/mm/live/core/core/model/LiveStatus$PKLinkMicRole;", "pkLinkMicStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$PKLinkMicStatus;", "pkUserId", "resumeFromPermissionCheck", "selfSdkID", "getSelfSdkID", "()Ljava/lang/String;", "setSelfSdkID", "(Ljava/lang/String;)V", "videoMicID", "addAvailableAudioUser", "", "sdkID", "audioLinkMic", "changeToFloatMode", "changeToNormalMode", "changeToPermissionMode", "checkInRoom", "currentRoomID", "enterRoom", "exitRoom", "getAnchorID", "getNetworkQuality", "getNetworkType", "getPkUserID", "getVideoMicID", "isAudioMode", "isEnterRoom", "isFloatMode", "isInAudioLinkMic", "isInPkLinkMic", "isInPkWaitMic", "isInRoom", "(Ljava/lang/Long;)Z", "isInVideoLinkMic", "isLiving", "isNoLinkMic", "isNormalMode", "isPausing", "isPkRoleAccept", "isPkRoleApply", "isResumeFromPermissionCheck", "isScreenShareMode", "isVideoMode", "noLinkMic", "noPkLink", "pauseLive", "pkLinkMic", "pkRoleAccept", "pkRoleApply", "pkRoleDefault", "pkWaitMic", "removeAvailableAudioUser", "resumeLive", "setAnchorID", "id", "setPkUserID", "setResumeFromPermissionCheck", "value", "setVideoMicID", "switchAudioMode", "switchScreenShareMode", "docCast", "switchVideoMode", "updateNetworkQuality", "quality", "updateNetworkType", "type", "updateStart", "status", "videoLinkMic", "Companion", "LinkMicStatus", "LiveMode", "LiveRoomStatus", "MiniWindowMode", "PKLinkMicRole", "PKLinkMicStatus", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i.a mNE;
  public boolean isDebugMode;
  public boolean mNF;
  public i.d mNG;
  public i.b mNH;
  private i.g mNI;
  public i.f mNJ;
  public i.e mNK;
  public long mNL;
  public String mNM;
  private String mNN;
  public String mNO;
  public i.c mNP;
  public boolean mNQ;
  public String mNR;
  private ArrayList<String> mNS;
  public int mNT;
  public int networkType;
  public boolean pause;
  
  static
  {
    AppMethodBeat.i(247930);
    mNE = new i.a((byte)0);
    AppMethodBeat.o(247930);
  }
  
  public i()
  {
    AppMethodBeat.i(247916);
    this.mNG = i.d.mOb;
    this.mNH = i.b.mNU;
    this.mNI = i.g.mOn;
    this.mNJ = i.f.mOj;
    this.mNK = i.e.mOf;
    this.mNL = -1L;
    this.mNM = "";
    this.mNN = "";
    this.mNO = "";
    this.mNP = i.c.mNY;
    this.mNS = new ArrayList();
    e.o localo = e.o.mLz;
    this.mNT = e.o.bdC();
    this.networkType = -1;
    if (h.baE().ban().getInt(at.a.adfq, 0) == 1) {}
    for (;;)
    {
      this.isDebugMode = bool;
      AppMethodBeat.o(247916);
      return;
      bool = false;
    }
  }
  
  private final boolean bes()
  {
    return this.mNG == i.d.mOc;
  }
  
  public final boolean a(Long paramLong)
  {
    AppMethodBeat.i(247956);
    boolean bool;
    if (paramLong == null)
    {
      bool = bes();
      AppMethodBeat.o(247956);
      return bool;
    }
    long l = this.mNL;
    if (paramLong.longValue() == l)
    {
      bool = bes();
      AppMethodBeat.o(247956);
      return bool;
    }
    AppMethodBeat.o(247956);
    return false;
  }
  
  public final boolean bep()
  {
    return this.mNK == i.e.mOf;
  }
  
  public final boolean beq()
  {
    return this.mNH == i.b.mNU;
  }
  
  public final boolean ber()
  {
    return this.mNJ == i.f.mOk;
  }
  
  public final boolean bet()
  {
    return this.mNH == i.b.mNW;
  }
  
  public final boolean beu()
  {
    return this.mNH == i.b.mNV;
  }
  
  public final void bev()
  {
    AppMethodBeat.i(247973);
    Log.i("MicroMsg.LiveStatus", s.X("switchAudioMode,pause:", Boolean.valueOf(this.pause)));
    this.pause = false;
    this.mNP = i.c.mNZ;
    AppMethodBeat.o(247973);
  }
  
  public final void bew()
  {
    AppMethodBeat.i(247981);
    Log.i("MicroMsg.LiveStatus", s.X("switchVideoMode,pause:", Boolean.valueOf(this.pause)));
    this.pause = false;
    this.mNP = i.c.mNY;
    AppMethodBeat.o(247981);
  }
  
  public final boolean bex()
  {
    return this.mNP == i.c.mNZ;
  }
  
  public final boolean isFloatMode()
  {
    return this.mNK == i.e.mOg;
  }
  
  public final boolean isLiving()
  {
    return this.mNG == i.d.mOc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.i
 * JD-Core Version:    0.7.0.1
 */