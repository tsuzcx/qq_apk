package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMktCardHomePageV3;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "offset", "", "reqNum", "(II)V", "Companion", "plugin-card_release"})
public final class c
  extends j<awi>
{
  private static final String TAG = "MicroMsg.CgiGetMktCardHomePageV3";
  public static final a nuV;
  
  static
  {
    AppMethodBeat.i(192674);
    nuV = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktCardHomePageV3";
    AppMethodBeat.o(192674);
  }
  
  public c(int paramInt)
  {
    AppMethodBeat.i(192673);
    awh localawh = new awh();
    awi localawi = new awi();
    localawh.offset = paramInt;
    localawh.CRt = 10;
    a((ckq)localawh, (cld)localawi, 1701, "/cgi-bin/mmpay-bin/mktgetmktcardhomepagev2");
    ad.i(TAG, "offset: " + paramInt + ", reqnum: 10");
    AppMethodBeat.o(192673);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMktCardHomePageV3$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.c
 * JD-Core Version:    0.7.0.1
 */