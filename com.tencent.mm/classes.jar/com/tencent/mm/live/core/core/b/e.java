package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/model/LiveStatus;", "", "()V", "anchorID", "", "availableAudioUsers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isDebugMode", "", "()Z", "setDebugMode", "(Z)V", "isFloatMode", "linkMicStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "liveID", "", "liveRoomStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveRoomStatus;", "networkQuality", "", "selfSdkID", "getSelfSdkID", "()Ljava/lang/String;", "setSelfSdkID", "(Ljava/lang/String;)V", "videoMicID", "addAvailableAudioUser", "", "sdkID", "audioLinkMic", "changeToFloatMode", "changeToNormalMode", "checkInRoom", "currentRoomID", "enterRoom", "exitRoom", "getAnchorID", "getNetworkQuality", "getVideoMicID", "isEnterRoom", "isInAudioLinkMic", "isInRoom", "(Ljava/lang/Long;)Z", "isInVideoLinkMic", "noLinkMic", "removeAvailableAudioUser", "setAnchorID", "id", "setVideoMicID", "updateNetworkQuality", "quality", "updateStart", "status", "videoLinkMic", "Companion", "LinkMicStatus", "LiveRoomStatus", "plugin-core_release"})
public final class e
{
  public static final a qAO;
  public boolean isDebugMode;
  public String qAd;
  public String qAh;
  private ArrayList<String> qAn;
  public c qzN;
  public b qzO;
  public boolean qzP;
  public long qzQ;
  public String qzR;
  public int zCj;
  
  static
  {
    AppMethodBeat.i(205641);
    qAO = new a((byte)0);
    AppMethodBeat.o(205641);
  }
  
  public e()
  {
    AppMethodBeat.i(205640);
    this.qzN = c.qBA;
    this.qzO = b.qAR;
    this.qzQ = -1L;
    this.qzR = "";
    this.qAd = "";
    this.qAn = new ArrayList();
    Object localObject = c.c.qyj;
    this.zCj = c.c.cmA();
    localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    if (((com.tencent.mm.kernel.e)localObject).afk().getInt(ae.a.LBD, 0) == 1) {}
    for (;;)
    {
      this.isDebugMode = bool;
      AppMethodBeat.o(205640);
      return;
      bool = false;
    }
  }
  
  private final boolean cnv()
  {
    return this.qzN == c.qCR;
  }
  
  public final boolean cnw()
  {
    return this.qzO == b.qAY;
  }
  
  public final boolean cnx()
  {
    return this.qzO == b.qAX;
  }
  
  public final boolean h(Long paramLong)
  {
    AppMethodBeat.i(205639);
    boolean bool;
    if (paramLong == null)
    {
      bool = cnv();
      AppMethodBeat.o(205639);
      return bool;
    }
    long l = this.qzQ;
    if (paramLong.longValue() == l)
    {
      bool = cnv();
      AppMethodBeat.o(205639);
      return bool;
    }
    AppMethodBeat.o(205639);
    return false;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/model/LiveStatus$Companion;", "", "()V", "LIVE_DEFAULT", "", "plugin-core_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "", "(Ljava/lang/String;I)V", "NO_LINK_MIC", "AUDIO_LINK_MIC", "VIDEO_LINK_MIC", "plugin-core_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(205633);
      b localb1 = new b("NO_LINK_MIC", 0);
      qAR = localb1;
      b localb2 = new b("AUDIO_LINK_MIC", 1);
      qAX = localb2;
      b localb3 = new b("VIDEO_LINK_MIC", 2);
      qAY = localb3;
      qBz = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(205633);
    }
    
    private b() {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveRoomStatus;", "", "(Ljava/lang/String;I)V", "LIVE_OUT_ROOM", "LIVE_IN_ROOM", "LIVE_JOIN_ROOM", "plugin-core_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(205636);
      c localc1 = new c("LIVE_OUT_ROOM", 0);
      qBA = localc1;
      c localc2 = new c("LIVE_IN_ROOM", 1);
      qCR = localc2;
      c localc3 = new c("LIVE_JOIN_ROOM", 2);
      qCT = localc3;
      qDh = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(205636);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.e
 * JD-Core Version:    0.7.0.1
 */