package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetCouponAndGiftList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "pageNum", "", "pageSize", "scene", "", "(JJI)V", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends j<cia>
{
  public static final a wwd;
  
  static
  {
    AppMethodBeat.i(294527);
    wwd = new a((byte)0);
    AppMethodBeat.o(294527);
  }
  
  public c(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(294523);
    chz localchz = new chz();
    cia localcia = new cia();
    localchz.aaqC = paramLong1;
    localchz.aaqD = paramLong2;
    localchz.scene = 1;
    a((erp)localchz, (esc)localcia, 4796, "/cgi-bin/mmpay-bin/mktgetcouponandgiftlist");
    Log.i("MicroMsg.CgiGetCouponAndGiftList", "pageNum: " + paramLong1 + ", pageSize: " + paramLong2);
    AppMethodBeat.o(294523);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetCouponAndGiftList$Companion;", "", "()V", "TAG", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.c
 * JD-Core Version:    0.7.0.1
 */