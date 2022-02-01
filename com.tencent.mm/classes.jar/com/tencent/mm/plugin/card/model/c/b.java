package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.bte;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetCouponAndGiftHistoryRequest;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "pageNum", "", "pageSize", "scene", "", "(JJI)V", "Companion", "plugin-card_release"})
public final class b
  extends j<btf>
{
  public static final a trE;
  
  static
  {
    AppMethodBeat.i(244447);
    trE = new a((byte)0);
    AppMethodBeat.o(244447);
  }
  
  public b(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(244446);
    bte localbte = new bte();
    btf localbtf = new btf();
    localbte.Tdn = paramLong1;
    localbte.Tdo = paramLong2;
    localbte.scene = 1;
    a((dyl)localbte, (dyy)localbtf, 4735, "/cgi-bin/mmpay-bin/mktgetcouponandgifthistory");
    Log.i("MicroMsg.CgiGetMemberCardHistoryRequest", "pageNum: " + paramLong1 + ", pageSize: " + paramLong2);
    AppMethodBeat.o(244446);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetCouponAndGiftHistoryRequest$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.b
 * JD-Core Version:    0.7.0.1
 */