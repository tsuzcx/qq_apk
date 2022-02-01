package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "jumpInfo", "Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getJumpInfo", "()Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "setJumpInfo", "(Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "setLiveRoomInfo", "(Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;)V", "getTrtcParams", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "setTrtcParams", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "plugin-core_release"})
public final class d
{
  private static final TRTCCloudDef.TRTCParams qzt;
  private static final c qzu;
  private static final b qzv;
  public static final a qzw;
  public TRTCCloudDef.TRTCParams qzq;
  public c qzr;
  public a qzs;
  
  static
  {
    AppMethodBeat.i(205630);
    qzw = new a((byte)0);
    qzt = new TRTCCloudDef.TRTCParams(1400188366, "852082", "eJwtzE0LgkAUheH-creF3pnG8SK0iGhnEOiiwE01U1w-YlBTI-rvibo8zwvnC2mceJ2tIQLpIaynzca*Wn7wxBRIJLmUxhRX59hAJBSiINpoPRc7OK4tRBoVIc7WcjWKCEhK0oFYtOHneFvcM99w5ueZX6hdyQntb6XrkiqPV314HK7qlL9TbM-hof9ctvD7AxQcMac_", 12081, "", "");
    qzu = new c("test", 12081L, null, 0, null, 0L, 0L, 124);
    b localb = new b((byte)0);
    qzv = localb;
    localb.qyW = false;
    qzv.qyF = false;
    AppMethodBeat.o(205630);
  }
  
  public d(TRTCCloudDef.TRTCParams paramTRTCParams, c paramc, a parama)
  {
    AppMethodBeat.i(205629);
    this.qzq = paramTRTCParams;
    this.qzr = paramc;
    this.qzs = parama;
    AppMethodBeat.o(205629);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205632);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((!k.g(this.qzq, paramObject.qzq)) || (!k.g(this.qzr, paramObject.qzr)) || (!k.g(this.qzs, paramObject.qzs))) {}
      }
    }
    else
    {
      AppMethodBeat.o(205632);
      return true;
    }
    AppMethodBeat.o(205632);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(205631);
    Object localObject = this.qzq;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.qzr;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.qzs;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(205631);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205628);
    String str = "LiveRoomModel(liveRoomInfo=" + this.qzr + ", trtcParams=(sdkAppId:" + this.qzq.sdkAppId + ",uid:" + this.qzq.userId + ",roomId:" + this.qzq.roomId + "))";
    AppMethodBeat.o(205628);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/model/LiveRoomModel$Companion;", "", "()V", "renderModel", "Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getRenderModel", "()Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "testLiveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "getTestLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "testTrtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "getTestTrtcParams", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.d
 * JD-Core Version:    0.7.0.1
 */