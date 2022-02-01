package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ady;
import com.tencent.mm.protocal.protobuf.adz;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInInvalidList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class b
  extends j<adz>
{
  private static String TAG;
  public static final a oBd;
  
  static
  {
    AppMethodBeat.i(112384);
    oBd = new a((byte)0);
    TAG = "MicroMsg.CgiDeleteCardInInvalidList";
    AppMethodBeat.o(112384);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(112383);
    ady localady = new ady();
    adz localadz = new adz();
    localady.FrW = paramString;
    a((cvc)localady, (cvp)localadz, 2707, "/cgi-bin/mmpay-bin/mktdeletecardininvalidlist");
    ad.i(TAG, "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(112383);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInInvalidList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.b
 * JD-Core Version:    0.7.0.1
 */