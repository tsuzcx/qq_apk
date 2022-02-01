package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/core/model/LiveStatus;", "", "()V", "anchorID", "", "availableAudioUsers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "floatMode", "Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;", "isDebugMode", "", "()Z", "setDebugMode", "(Z)V", "linkMicStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "liveID", "", "liveRoomStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveRoomStatus;", "networkQuality", "", "resumeFromPermissionCheck", "selfSdkID", "getSelfSdkID", "()Ljava/lang/String;", "setSelfSdkID", "(Ljava/lang/String;)V", "videoMicID", "addAvailableAudioUser", "", "sdkID", "audioLinkMic", "changeToFloatMode", "changeToNormalMode", "changeToPermissionMode", "checkInRoom", "currentRoomID", "enterRoom", "exitRoom", "getAnchorID", "getNetworkQuality", "getVideoMicID", "isEnterRoom", "isFloatMode", "isInAudioLinkMic", "isInRoom", "(Ljava/lang/Long;)Z", "isInVideoLinkMic", "isNormalMode", "isResumeFromPermissionCheck", "noLinkMic", "removeAvailableAudioUser", "setAnchorID", "id", "setResumeFromPermissionCheck", "value", "setVideoMicID", "updateNetworkQuality", "quality", "updateStart", "status", "videoLinkMic", "Companion", "LinkMicStatus", "LiveRoomStatus", "MiniWindowMode", "plugin-core_release"})
public final class e
{
  public static final e.a goj;
  public boolean gnZ;
  public e.c goa;
  public b gob;
  public d goc;
  public long god;
  public String goe;
  public String gof;
  public String gog;
  private ArrayList<String> goh;
  public int goi;
  public boolean isDebugMode;
  
  static
  {
    AppMethodBeat.i(209177);
    goj = new e.a((byte)0);
    AppMethodBeat.o(209177);
  }
  
  public e()
  {
    AppMethodBeat.i(209176);
    this.goa = e.c.goo;
    this.gob = b.gok;
    this.goc = d.got;
    this.god = -1L;
    this.goe = "";
    this.gof = "";
    this.goh = new ArrayList();
    Object localObject = c.c.gnz;
    this.goi = c.c.aiI();
    localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    if (((com.tencent.mm.kernel.e)localObject).agA().getInt(ah.a.GWc, 0) == 1) {}
    for (;;)
    {
      this.isDebugMode = bool;
      AppMethodBeat.o(209176);
      return;
      bool = false;
    }
  }
  
  private final boolean aiR()
  {
    return this.goa == e.c.goq;
  }
  
  public final boolean aiQ()
  {
    return this.goc == d.got;
  }
  
  public final boolean aiS()
  {
    return this.gob == b.gom;
  }
  
  public final boolean aiT()
  {
    return this.gob == b.gol;
  }
  
  public final boolean b(Long paramLong)
  {
    AppMethodBeat.i(209175);
    boolean bool;
    if (paramLong == null)
    {
      bool = aiR();
      AppMethodBeat.o(209175);
      return bool;
    }
    long l = this.god;
    if (paramLong.longValue() == l)
    {
      bool = aiR();
      AppMethodBeat.o(209175);
      return bool;
    }
    AppMethodBeat.o(209175);
    return false;
  }
  
  public final boolean isFloatMode()
  {
    return this.goc == d.gou;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "", "(Ljava/lang/String;I)V", "NO_LINK_MIC", "AUDIO_LINK_MIC", "VIDEO_LINK_MIC", "plugin-core_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(209166);
      b localb1 = new b("NO_LINK_MIC", 0);
      gok = localb1;
      b localb2 = new b("AUDIO_LINK_MIC", 1);
      gol = localb2;
      b localb3 = new b("VIDEO_LINK_MIC", 2);
      gom = localb3;
      gon = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(209166);
    }
    
    private b() {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;", "", "(Ljava/lang/String;I)V", "NORMAL_MODE", "FLOAT_MODE", "PERMISSION_MODE", "plugin-core_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(209172);
      d locald1 = new d("NORMAL_MODE", 0);
      got = locald1;
      d locald2 = new d("FLOAT_MODE", 1);
      gou = locald2;
      d locald3 = new d("PERMISSION_MODE", 2);
      gov = locald3;
      gow = new d[] { locald1, locald2, locald3 };
      AppMethodBeat.o(209172);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.e
 * JD-Core Version:    0.7.0.1
 */