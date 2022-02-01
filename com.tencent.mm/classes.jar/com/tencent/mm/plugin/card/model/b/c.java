package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bee;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMktCardHomePageV3;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "offset", "", "reqNum", "(II)V", "Companion", "plugin-card_release"})
public final class c
  extends j<bee>
{
  private static final String TAG = "MicroMsg.CgiGetMktCardHomePageV3";
  public static final a oBp;
  
  static
  {
    AppMethodBeat.i(215443);
    oBp = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktCardHomePageV3";
    AppMethodBeat.o(215443);
  }
  
  public c(int paramInt)
  {
    AppMethodBeat.i(215442);
    bed localbed = new bed();
    bee localbee = new bee();
    localbed.offset = paramInt;
    localbed.FRn = 10;
    a((cvc)localbed, (cvp)localbee, 1701, "/cgi-bin/mmpay-bin/mktgetmktcardhomepagev2");
    ad.i(TAG, "offset: " + paramInt + ", reqnum: 10");
    AppMethodBeat.o(215442);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMktCardHomePageV3$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.c
 * JD-Core Version:    0.7.0.1
 */