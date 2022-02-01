package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v4/CgiDeleteCouponRequest;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCouponResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class a
  extends j<agx>
{
  public static final a trD;
  
  static
  {
    AppMethodBeat.i(253136);
    trD = new a((byte)0);
    AppMethodBeat.o(253136);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(253135);
    agv localagv = new agv();
    agx localagx = new agx();
    localagv.RFf = paramString;
    a((dyl)localagv, (dyy)localagx, 5027, "/cgi-bin/mmpay-bin/mktdeletecoupon");
    Log.i("MicroMsg.CgiDeleteCouponRequest", "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(253135);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v4/CgiDeleteCouponRequest$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.a
 * JD-Core Version:    0.7.0.1
 */