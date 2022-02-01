package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.agm;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v4/CgiDeleteCouponRequest;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCouponResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class a
  extends j<ago>
{
  public static final a pVC;
  
  static
  {
    AppMethodBeat.i(201381);
    pVC = new a((byte)0);
    AppMethodBeat.o(201381);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(201380);
    agm localagm = new agm();
    ago localago = new ago();
    localagm.KDM = paramString;
    a((dop)localagm, (dpc)localago, 5027, "/cgi-bin/mmpay-bin/mktdeletecoupon");
    Log.i("MicroMsg.CgiDeleteCouponRequest", "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(201380);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v4/CgiDeleteCouponRequest$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.a
 * JD-Core Version:    0.7.0.1
 */