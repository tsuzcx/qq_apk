package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.protocal.protobuf.ajm;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v4/CgiDeleteCouponRequest;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCouponResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends j<ajm>
{
  public static final a wwb;
  
  static
  {
    AppMethodBeat.i(294531);
    wwb = new a((byte)0);
    AppMethodBeat.o(294531);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(294526);
    ajk localajk = new ajk();
    ajm localajm = new ajm();
    localajk.YBH = paramString;
    a((erp)localajk, (esc)localajm, 5027, "/cgi-bin/mmpay-bin/mktdeletecoupon");
    Log.i("MicroMsg.CgiDeleteCouponRequest", "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(294526);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v4/CgiDeleteCouponRequest$Companion;", "", "()V", "TAG", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.a
 * JD-Core Version:    0.7.0.1
 */