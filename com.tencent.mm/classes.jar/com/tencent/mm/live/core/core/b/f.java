package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "jumpInfo", "Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getJumpInfo", "()Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "setJumpInfo", "(Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "setLiveRoomInfo", "(Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;)V", "renderModel", "Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getRenderModel", "()Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getTrtcParams", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "setTrtcParams", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "plugin-core_release"})
public final class f
{
  private static final TRTCCloudDef.TRTCParams hzw;
  private static final e hzx;
  public static final a hzy;
  public e hwP;
  public final d hzt;
  public TRTCCloudDef.TRTCParams hzu;
  public b hzv;
  
  static
  {
    AppMethodBeat.i(196465);
    hzy = new a((byte)0);
    hzw = new TRTCCloudDef.TRTCParams(1400188366, "852082", "eJwtzE0LgkAUheH-creF3pnG8SK0iGhnEOiiwE01U1w-YlBTI-rvibo8zwvnC2mceJ2tIQLpIaynzca*Wn7wxBRIJLmUxhRX59hAJBSiINpoPRc7OK4tRBoVIc7WcjWKCEhK0oFYtOHneFvcM99w5ueZX6hdyQntb6XrkiqPV314HK7qlL9TbM-hof9ctvD7AxQcMac_", 12081, "", "");
    hzx = new e("test", 12081L, 0, null, 0L, 0L, 0, null, null, 0L, 4092);
    AppMethodBeat.o(196465);
  }
  
  public f(TRTCCloudDef.TRTCParams paramTRTCParams, e parame, b paramb)
  {
    AppMethodBeat.i(196464);
    this.hzu = paramTRTCParams;
    this.hwP = parame;
    this.hzv = paramb;
    this.hzt = new d((byte)0);
    this.hzt.hzi = false;
    this.hzt.hzg = false;
    AppMethodBeat.o(196464);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196467);
    if (this != paramObject)
    {
      if ((paramObject instanceof f))
      {
        paramObject = (f)paramObject;
        if ((!p.j(this.hzu, paramObject.hzu)) || (!p.j(this.hwP, paramObject.hwP)) || (!p.j(this.hzv, paramObject.hzv))) {}
      }
    }
    else
    {
      AppMethodBeat.o(196467);
      return true;
    }
    AppMethodBeat.o(196467);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(196466);
    Object localObject = this.hzu;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.hwP;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.hzv;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(196466);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196463);
    String str = "LiveRoomModel(liveRoomInfo=" + this.hwP + ", trtcParams=(sdkAppId:" + this.hzu.sdkAppId + ",uid:" + this.hzu.userId + ",roomId:" + this.hzu.roomId + "))";
    AppMethodBeat.o(196463);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/model/LiveRoomModel$Companion;", "", "()V", "testLiveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "getTestLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "testTrtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "getTestTrtcParams", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.f
 * JD-Core Version:    0.7.0.1
 */