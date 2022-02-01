package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "jumpInfo", "Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getJumpInfo", "()Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "setJumpInfo", "(Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "setLiveRoomInfo", "(Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;)V", "renderModel", "Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getRenderModel", "()Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getTrtcParams", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "setTrtcParams", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "plugin-core_release"})
public final class d
{
  private static final TRTCCloudDef.TRTCParams gKo;
  private static final c gKp;
  public static final a gKq;
  public final b gKk;
  public TRTCCloudDef.TRTCParams gKl;
  public c gKm;
  public a gKn;
  
  static
  {
    AppMethodBeat.i(196832);
    gKq = new a((byte)0);
    gKo = new TRTCCloudDef.TRTCParams(1400188366, "852082", "eJwtzE0LgkAUheH-creF3pnG8SK0iGhnEOiiwE01U1w-YlBTI-rvibo8zwvnC2mceJ2tIQLpIaynzca*Wn7wxBRIJLmUxhRX59hAJBSiINpoPRc7OK4tRBoVIc7WcjWKCEhK0oFYtOHneFvcM99w5ueZX6hdyQntb6XrkiqPV314HK7qlL9TbM-hof9ctvD7AxQcMac_", 12081, "", "");
    gKp = new c("test", 12081L, null, 0, null, 0L, 0L, 124);
    AppMethodBeat.o(196832);
  }
  
  public d(TRTCCloudDef.TRTCParams paramTRTCParams, c paramc, a parama)
  {
    AppMethodBeat.i(196831);
    this.gKl = paramTRTCParams;
    this.gKm = paramc;
    this.gKn = parama;
    this.gKk = new b((byte)0);
    this.gKk.gKe = false;
    this.gKk.gKc = false;
    AppMethodBeat.o(196831);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196834);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((!p.i(this.gKl, paramObject.gKl)) || (!p.i(this.gKm, paramObject.gKm)) || (!p.i(this.gKn, paramObject.gKn))) {}
      }
    }
    else
    {
      AppMethodBeat.o(196834);
      return true;
    }
    AppMethodBeat.o(196834);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(196833);
    Object localObject = this.gKl;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.gKm;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.gKn;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(196833);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196830);
    String str = "LiveRoomModel(liveRoomInfo=" + this.gKm + ", trtcParams=(sdkAppId:" + this.gKl.sdkAppId + ",uid:" + this.gKl.userId + ",roomId:" + this.gKl.roomId + "))";
    AppMethodBeat.o(196830);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/core/model/LiveRoomModel$Companion;", "", "()V", "testLiveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "getTestLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "testTrtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "getTestTrtcParams", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.d
 * JD-Core Version:    0.7.0.1
 */