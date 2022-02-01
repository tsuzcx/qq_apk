package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.azz;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMktCardHomePageV3;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "offset", "", "reqNum", "(II)V", "Companion", "plugin-card_release"})
public final class c
  extends j<baa>
{
  private static final String TAG = "MicroMsg.CgiGetMktCardHomePageV3";
  public static final a nXV;
  
  static
  {
    AppMethodBeat.i(206248);
    nXV = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktCardHomePageV3";
    AppMethodBeat.o(206248);
  }
  
  public c(int paramInt)
  {
    AppMethodBeat.i(206247);
    azz localazz = new azz();
    baa localbaa = new baa();
    localazz.offset = paramInt;
    localazz.Eke = 10;
    a((cpx)localazz, (cqk)localbaa, 1701, "/cgi-bin/mmpay-bin/mktgetmktcardhomepagev2");
    ac.i(TAG, "offset: " + paramInt + ", reqnum: 10");
    AppMethodBeat.o(206247);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMktCardHomePageV3$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.c
 * JD-Core Version:    0.7.0.1
 */