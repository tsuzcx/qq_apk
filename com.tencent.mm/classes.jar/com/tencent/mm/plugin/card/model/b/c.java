package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.bqp;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMktCardHomePageV3;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "offset", "", "reqNum", "(II)V", "Companion", "plugin-card_release"})
public final class c
  extends j<bqq>
{
  private static final String TAG = "MicroMsg.CgiGetMktCardHomePageV3";
  public static final a pVA;
  
  static
  {
    AppMethodBeat.i(201377);
    pVA = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktCardHomePageV3";
    AppMethodBeat.o(201377);
  }
  
  public c(int paramInt)
  {
    AppMethodBeat.i(201376);
    bqp localbqp = new bqp();
    bqq localbqq = new bqq();
    localbqp.offset = paramInt;
    localbqp.Ler = 10;
    a((dop)localbqp, (dpc)localbqq, 1701, "/cgi-bin/mmpay-bin/mktgetmktcardhomepagev2");
    Log.i(TAG, "offset: " + paramInt + ", reqnum: 10");
    AppMethodBeat.o(201376);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMktCardHomePageV3$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.c
 * JD-Core Version:    0.7.0.1
 */