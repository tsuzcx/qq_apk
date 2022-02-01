package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.blv;
import com.tencent.mm.protocal.protobuf.blw;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetCouponAndGiftHistoryRequest;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "pageNum", "", "pageSize", "scene", "", "(JJI)V", "Companion", "plugin-card_release"})
public final class b
  extends j<blw>
{
  public static final a pVD;
  
  static
  {
    AppMethodBeat.i(201383);
    pVD = new a((byte)0);
    AppMethodBeat.o(201383);
  }
  
  public b(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(201382);
    blv localblv = new blv();
    blw localblw = new blw();
    localblv.LUF = paramLong1;
    localblv.LUG = paramLong2;
    localblv.scene = 1;
    a((dop)localblv, (dpc)localblw, 4735, "/cgi-bin/mmpay-bin/mktgetcouponandgifthistory");
    Log.i("MicroMsg.CgiGetMemberCardHistoryRequest", "pageNum: " + paramLong1 + ", pageSize: " + paramLong2);
    AppMethodBeat.o(201382);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetCouponAndGiftHistoryRequest$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.b
 * JD-Core Version:    0.7.0.1
 */