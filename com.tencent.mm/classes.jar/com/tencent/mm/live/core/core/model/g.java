package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "jumpInfo", "Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getJumpInfo", "()Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "setJumpInfo", "(Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "setLiveRoomInfo", "(Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;)V", "renderModel", "Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getRenderModel", "()Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getTrtcParams", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "setTrtcParams", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "plugin-core_release"})
public final class g
{
  private static final TRTCCloudDef.TRTCParams kms;
  private static final f kmt;
  public static final a kmu;
  public f kjd;
  public final e kmp;
  public TRTCCloudDef.TRTCParams kmq;
  public c kmr;
  
  static
  {
    AppMethodBeat.i(198875);
    kmu = new a((byte)0);
    kms = new TRTCCloudDef.TRTCParams(1400188366, "852082", "eJwtzE0LgkAUheH-creF3pnG8SK0iGhnEOiiwE01U1w-YlBTI-rvibo8zwvnC2mceJ2tIQLpIaynzca*Wn7wxBRIJLmUxhRX59hAJBSiINpoPRc7OK4tRBoVIc7WcjWKCEhK0oFYtOHneFvcM99w5ueZX6hdyQntb6XrkiqPV314HK7qlL9TbM-hof9ctvD7AxQcMac_", 12081, "", "");
    kmt = new f("test", 12081L, 0, null, 0L, 0L, null, null, 0L, null, 8188);
    AppMethodBeat.o(198875);
  }
  
  public g(TRTCCloudDef.TRTCParams paramTRTCParams, f paramf, c paramc)
  {
    AppMethodBeat.i(198872);
    this.kmq = paramTRTCParams;
    this.kjd = paramf;
    this.kmr = paramc;
    this.kmp = new e((byte)0);
    this.kmp.kmf = false;
    this.kmp.kmd = false;
    AppMethodBeat.o(198872);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(198868);
    p.k(paramc, "<set-?>");
    this.kmr = paramc;
    AppMethodBeat.o(198868);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(198866);
    p.k(paramf, "<set-?>");
    this.kjd = paramf;
    AppMethodBeat.o(198866);
  }
  
  public final void a(TRTCCloudDef.TRTCParams paramTRTCParams)
  {
    AppMethodBeat.i(198864);
    p.k(paramTRTCParams, "<set-?>");
    this.kmq = paramTRTCParams;
    AppMethodBeat.o(198864);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198879);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((!p.h(this.kmq, paramObject.kmq)) || (!p.h(this.kjd, paramObject.kjd)) || (!p.h(this.kmr, paramObject.kmr))) {}
      }
    }
    else
    {
      AppMethodBeat.o(198879);
      return true;
    }
    AppMethodBeat.o(198879);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(198878);
    Object localObject = this.kmq;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.kjd;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.kmr;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(198878);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198863);
    String str = "LiveRoomModel(liveRoomInfo=" + this.kjd + " liveName:" + this.kjd.kie + ", trtcParams=(sdkAppId:" + this.kmq.sdkAppId + ",uid:" + this.kmq.userId + ",roomId:" + this.kmq.roomId + "))";
    AppMethodBeat.o(198863);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/LiveRoomModel$Companion;", "", "()V", "testLiveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "getTestLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "testTrtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "getTestTrtcParams", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.g
 * JD-Core Version:    0.7.0.1
 */