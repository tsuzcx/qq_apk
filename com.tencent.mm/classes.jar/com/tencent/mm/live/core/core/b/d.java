package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "jumpInfo", "Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getJumpInfo", "()Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "setJumpInfo", "(Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "setLiveRoomInfo", "(Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;)V", "renderModel", "Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getRenderModel", "()Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getTrtcParams", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "setTrtcParams", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "plugin-core_release"})
public final class d
{
  private static final TRTCCloudDef.TRTCParams gHF;
  private static final c gHG;
  public static final a gHH;
  public final b gHB;
  public TRTCCloudDef.TRTCParams gHC;
  public c gHD;
  public a gHE;
  
  static
  {
    AppMethodBeat.i(216820);
    gHH = new a((byte)0);
    gHF = new TRTCCloudDef.TRTCParams(1400188366, "852082", "eJwtzE0LgkAUheH-creF3pnG8SK0iGhnEOiiwE01U1w-YlBTI-rvibo8zwvnC2mceJ2tIQLpIaynzca*Wn7wxBRIJLmUxhRX59hAJBSiINpoPRc7OK4tRBoVIc7WcjWKCEhK0oFYtOHneFvcM99w5ueZX6hdyQntb6XrkiqPV314HK7qlL9TbM-hof9ctvD7AxQcMac_", 12081, "", "");
    gHG = new c("test", 12081L, null, 0, null, 0L, 0L, 124);
    AppMethodBeat.o(216820);
  }
  
  public d(TRTCCloudDef.TRTCParams paramTRTCParams, c paramc, a parama)
  {
    AppMethodBeat.i(216819);
    this.gHC = paramTRTCParams;
    this.gHD = paramc;
    this.gHE = parama;
    this.gHB = new b((byte)0);
    this.gHB.gHv = false;
    this.gHB.gHt = false;
    AppMethodBeat.o(216819);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(216822);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((!p.i(this.gHC, paramObject.gHC)) || (!p.i(this.gHD, paramObject.gHD)) || (!p.i(this.gHE, paramObject.gHE))) {}
      }
    }
    else
    {
      AppMethodBeat.o(216822);
      return true;
    }
    AppMethodBeat.o(216822);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(216821);
    Object localObject = this.gHC;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.gHD;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.gHE;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(216821);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216818);
    String str = "LiveRoomModel(liveRoomInfo=" + this.gHD + ", trtcParams=(sdkAppId:" + this.gHC.sdkAppId + ",uid:" + this.gHC.userId + ",roomId:" + this.gHC.roomId + "))";
    AppMethodBeat.o(216818);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/core/model/LiveRoomModel$Companion;", "", "()V", "testLiveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "getTestLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "testTrtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "getTestTrtcParams", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.d
 * JD-Core Version:    0.7.0.1
 */