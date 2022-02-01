package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInTicketList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class c
  extends j<acb>
{
  private static String TAG;
  public static final a nXK;
  
  static
  {
    AppMethodBeat.i(112386);
    nXK = new a((byte)0);
    TAG = "MicroMsg.CgiDeleteCardInTicketList";
    AppMethodBeat.o(112386);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(112385);
    aca localaca = new aca();
    acb localacb = new acb();
    localaca.DMR = paramString;
    a((cpx)localaca, (cqk)localacb, 1739, "/cgi-bin/mmpay-bin/mktdeletecardinticketlist");
    ac.i(TAG, "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(112385);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInTicketList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.c
 * JD-Core Version:    0.7.0.1
 */