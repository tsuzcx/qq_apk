package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetCouponAndGiftList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "pageNum", "", "pageSize", "scene", "", "(JJI)V", "Companion", "plugin-card_release"})
public final class c
  extends j<bth>
{
  public static final a trF;
  
  static
  {
    AppMethodBeat.i(251246);
    trF = new a((byte)0);
    AppMethodBeat.o(251246);
  }
  
  public c(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(251243);
    btg localbtg = new btg();
    bth localbth = new bth();
    localbtg.Tdn = paramLong1;
    localbtg.Tdo = paramLong2;
    localbtg.scene = 1;
    a((dyl)localbtg, (dyy)localbth, 4796, "/cgi-bin/mmpay-bin/mktgetcouponandgiftlist");
    Log.i("MicroMsg.CgiGetCouponAndGiftList", "pageNum: " + paramLong1 + ", pageSize: " + paramLong2);
    AppMethodBeat.o(251243);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetCouponAndGiftList$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.c
 * JD-Core Version:    0.7.0.1
 */