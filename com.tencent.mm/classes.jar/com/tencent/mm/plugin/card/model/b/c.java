package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.protocal.protobuf.byk;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMktCardHomePageV3;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "offset", "", "reqNum", "(II)V", "Companion", "plugin-card_release"})
public final class c
  extends j<byk>
{
  private static final String TAG = "MicroMsg.CgiGetMktCardHomePageV3";
  public static final a trB;
  
  static
  {
    AppMethodBeat.i(250666);
    trB = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktCardHomePageV3";
    AppMethodBeat.o(250666);
  }
  
  public c(int paramInt)
  {
    AppMethodBeat.i(250663);
    byj localbyj = new byj();
    byk localbyk = new byk();
    localbyj.offset = paramInt;
    localbyj.SfE = 10;
    a((dyl)localbyj, (dyy)localbyk, 1701, "/cgi-bin/mmpay-bin/mktgetmktcardhomepagev2");
    Log.i(TAG, "offset: " + paramInt + ", reqnum: 10");
    AppMethodBeat.o(250663);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMktCardHomePageV3$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.c
 * JD-Core Version:    0.7.0.1
 */