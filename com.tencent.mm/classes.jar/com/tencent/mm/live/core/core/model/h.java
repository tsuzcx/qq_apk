package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "jumpInfo", "Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getJumpInfo", "()Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "setJumpInfo", "(Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "setLiveRoomInfo", "(Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;)V", "renderModel", "Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getRenderModel", "()Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getTrtcParams", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "setTrtcParams", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final TRTCCloudDef.TRTCParams mNC;
  private static final g mND;
  public static final h.a mNy;
  public g mJH;
  public d mNA;
  public final f mNB;
  public TRTCCloudDef.TRTCParams mNz;
  
  static
  {
    AppMethodBeat.i(247968);
    mNy = new h.a((byte)0);
    mNC = new TRTCCloudDef.TRTCParams(1400188366, "852082", "eJwtzE0LgkAUheH-creF3pnG8SK0iGhnEOiiwE01U1w-YlBTI-rvibo8zwvnC2mceJ2tIQLpIaynzca*Wn7wxBRIJLmUxhRX59hAJBSiINpoPRc7OK4tRBoVIc7WcjWKCEhK0oFYtOHneFvcM99w5ueZX6hdyQntb6XrkiqPV314HK7qlL9TbM-hof9ctvD7AxQcMac_", 12081, "", "");
    mND = new g("test", 12081L, 0, null, 0L, 0L, null, 0, null, 0L, null, null, 131068);
    AppMethodBeat.o(247968);
  }
  
  public h(TRTCCloudDef.TRTCParams paramTRTCParams, g paramg, d paramd)
  {
    AppMethodBeat.i(247948);
    this.mNz = paramTRTCParams;
    this.mJH = paramg;
    this.mNA = paramd;
    this.mNB = new f((byte)0);
    this.mNB.mNk = false;
    this.mNB.mNi = false;
    AppMethodBeat.o(247948);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(247990);
    s.u(paramd, "<set-?>");
    this.mNA = paramd;
    AppMethodBeat.o(247990);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(247984);
    s.u(paramg, "<set-?>");
    this.mJH = paramg;
    AppMethodBeat.o(247984);
  }
  
  public final void a(TRTCCloudDef.TRTCParams paramTRTCParams)
  {
    AppMethodBeat.i(247977);
    s.u(paramTRTCParams, "<set-?>");
    this.mNz = paramTRTCParams;
    AppMethodBeat.o(247977);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(248006);
    if (this == paramObject)
    {
      AppMethodBeat.o(248006);
      return true;
    }
    if (!(paramObject instanceof h))
    {
      AppMethodBeat.o(248006);
      return false;
    }
    paramObject = (h)paramObject;
    if (!s.p(this.mNz, paramObject.mNz))
    {
      AppMethodBeat.o(248006);
      return false;
    }
    if (!s.p(this.mJH, paramObject.mJH))
    {
      AppMethodBeat.o(248006);
      return false;
    }
    if (!s.p(this.mNA, paramObject.mNA))
    {
      AppMethodBeat.o(248006);
      return false;
    }
    AppMethodBeat.o(248006);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(248000);
    int i = this.mNz.hashCode();
    int j = this.mJH.hashCode();
    int k = this.mNA.hashCode();
    AppMethodBeat.o(248000);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247995);
    String str = "LiveRoomModel(liveRoomInfo=" + this.mJH + " liveName:" + this.mJH.mIA + ", trtcParams=(sdkAppId:" + this.mNz.sdkAppId + ",uid:" + this.mNz.userId + ",roomId:" + this.mNz.roomId + "))";
    AppMethodBeat.o(247995);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.h
 * JD-Core Version:    0.7.0.1
 */