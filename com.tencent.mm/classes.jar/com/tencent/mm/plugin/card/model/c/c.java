package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetCouponAndGiftList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "pageNum", "", "pageSize", "scene", "", "(JJI)V", "Companion", "plugin-card_release"})
public final class c
  extends j<bly>
{
  public static final a pVE;
  
  static
  {
    AppMethodBeat.i(201385);
    pVE = new a((byte)0);
    AppMethodBeat.o(201385);
  }
  
  public c(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(201384);
    blx localblx = new blx();
    bly localbly = new bly();
    localblx.LUF = paramLong1;
    localblx.LUG = paramLong2;
    localblx.scene = 1;
    a((dop)localblx, (dpc)localbly, 4796, "/cgi-bin/mmpay-bin/mktgetcouponandgiftlist");
    Log.i("MicroMsg.CgiGetCouponAndGiftList", "pageNum: " + paramLong1 + ", pageSize: " + paramLong2);
    AppMethodBeat.o(201384);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetCouponAndGiftList$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.c
 * JD-Core Version:    0.7.0.1
 */