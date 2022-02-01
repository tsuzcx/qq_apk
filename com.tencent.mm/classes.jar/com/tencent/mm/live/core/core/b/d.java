package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "jumpInfo", "Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getJumpInfo", "()Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "setJumpInfo", "(Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "setLiveRoomInfo", "(Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;)V", "renderModel", "Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getRenderModel", "()Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getTrtcParams", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "setTrtcParams", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "plugin-core_release"})
public final class d
{
  private static final TRTCCloudDef.TRTCParams gnW;
  private static final c gnX;
  public static final d.a gnY;
  public final b gnS;
  public TRTCCloudDef.TRTCParams gnT;
  public c gnU;
  public a gnV;
  
  static
  {
    AppMethodBeat.i(209163);
    gnY = new d.a((byte)0);
    gnW = new TRTCCloudDef.TRTCParams(1400188366, "852082", "eJwtzE0LgkAUheH-creF3pnG8SK0iGhnEOiiwE01U1w-YlBTI-rvibo8zwvnC2mceJ2tIQLpIaynzca*Wn7wxBRIJLmUxhRX59hAJBSiINpoPRc7OK4tRBoVIc7WcjWKCEhK0oFYtOHneFvcM99w5ueZX6hdyQntb6XrkiqPV314HK7qlL9TbM-hof9ctvD7AxQcMac_", 12081, "", "");
    gnX = new c("test", 12081L, null, 0, null, 0L, 0L, 124);
    AppMethodBeat.o(209163);
  }
  
  public d(TRTCCloudDef.TRTCParams paramTRTCParams, c paramc, a parama)
  {
    AppMethodBeat.i(209162);
    this.gnT = paramTRTCParams;
    this.gnU = paramc;
    this.gnV = parama;
    this.gnS = new b((byte)0);
    this.gnS.gnM = false;
    this.gnS.gnK = false;
    AppMethodBeat.o(209162);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(209165);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((!k.g(this.gnT, paramObject.gnT)) || (!k.g(this.gnU, paramObject.gnU)) || (!k.g(this.gnV, paramObject.gnV))) {}
      }
    }
    else
    {
      AppMethodBeat.o(209165);
      return true;
    }
    AppMethodBeat.o(209165);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(209164);
    Object localObject = this.gnT;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.gnU;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.gnV;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(209164);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(209161);
    String str = "LiveRoomModel(liveRoomInfo=" + this.gnU + ", trtcParams=(sdkAppId:" + this.gnT.sdkAppId + ",uid:" + this.gnT.userId + ",roomId:" + this.gnT.roomId + "))";
    AppMethodBeat.o(209161);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.d
 * JD-Core Version:    0.7.0.1
 */