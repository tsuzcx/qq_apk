package com.tencent.mm.plugin.card.model.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.protocal.protobuf.xu;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInTicketList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class d
  extends k<xu>
{
  private static String TAG;
  public static final d.a kpu;
  
  static
  {
    AppMethodBeat.i(89159);
    kpu = new d.a((byte)0);
    TAG = "MicroMsg.CgiDeleteCardInTicketList";
    AppMethodBeat.o(89159);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(89158);
    xt localxt = new xt();
    xu localxu = new xu();
    localxt.wmm = paramString;
    a((buy)localxt, (bvk)localxu, 1739, "/cgi-bin/mmpay-bin/mktdeletecardinticketlist");
    ab.i(TAG, "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(89158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.d
 * JD-Core Version:    0.7.0.1
 */