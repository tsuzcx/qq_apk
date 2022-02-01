package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetCouponAndGiftHistoryRequest;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "pageNum", "", "pageSize", "scene", "", "(JJI)V", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends j<chy>
{
  public static final a wwc;
  
  static
  {
    AppMethodBeat.i(294533);
    wwc = new a((byte)0);
    AppMethodBeat.o(294533);
  }
  
  public b(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(294532);
    chx localchx = new chx();
    chy localchy = new chy();
    localchx.aaqC = paramLong1;
    localchx.aaqD = paramLong2;
    localchx.scene = 1;
    a((erp)localchx, (esc)localchy, 4735, "/cgi-bin/mmpay-bin/mktgetcouponandgifthistory");
    Log.i("MicroMsg.CgiGetMemberCardHistoryRequest", "pageNum: " + paramLong1 + ", pageSize: " + paramLong2);
    AppMethodBeat.o(294532);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetCouponAndGiftHistoryRequest$Companion;", "", "()V", "TAG", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.b
 * JD-Core Version:    0.7.0.1
 */