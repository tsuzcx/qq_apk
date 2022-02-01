package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aea;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInTicketList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class c
  extends j<aeb>
{
  private static String TAG;
  public static final a oBe;
  
  static
  {
    AppMethodBeat.i(112386);
    oBe = new a((byte)0);
    TAG = "MicroMsg.CgiDeleteCardInTicketList";
    AppMethodBeat.o(112386);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(112385);
    aea localaea = new aea();
    aeb localaeb = new aeb();
    localaea.FrW = paramString;
    a((cvc)localaea, (cvp)localaeb, 1739, "/cgi-bin/mmpay-bin/mktdeletecardinticketlist");
    ad.i(TAG, "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(112385);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInTicketList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.c
 * JD-Core Version:    0.7.0.1
 */