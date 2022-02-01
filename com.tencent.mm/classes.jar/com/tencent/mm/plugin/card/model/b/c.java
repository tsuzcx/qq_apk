package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.protocal.protobuf.beu;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMktCardHomePageV3;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "offset", "", "reqNum", "(II)V", "Companion", "plugin-card_release"})
public final class c
  extends j<beu>
{
  private static final String TAG = "MicroMsg.CgiGetMktCardHomePageV3";
  public static final a oHR;
  
  static
  {
    AppMethodBeat.i(218404);
    oHR = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktCardHomePageV3";
    AppMethodBeat.o(218404);
  }
  
  public c(int paramInt)
  {
    AppMethodBeat.i(218403);
    bet localbet = new bet();
    beu localbeu = new beu();
    localbet.offset = paramInt;
    localbet.GjM = 10;
    a((cvw)localbet, (cwj)localbeu, 1701, "/cgi-bin/mmpay-bin/mktgetmktcardhomepagev2");
    ae.i(TAG, "offset: " + paramInt + ", reqnum: 10");
    AppMethodBeat.o(218403);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMktCardHomePageV3$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.c
 * JD-Core Version:    0.7.0.1
 */