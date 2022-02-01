package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInInvalidList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class b
  extends j<aba>
{
  private static String TAG;
  public static final a nuJ;
  
  static
  {
    AppMethodBeat.i(112384);
    nuJ = new a((byte)0);
    TAG = "MicroMsg.CgiDeleteCardInInvalidList";
    AppMethodBeat.o(112384);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(112383);
    aaz localaaz = new aaz();
    aba localaba = new aba();
    localaaz.CuA = paramString;
    a((ckq)localaaz, (cld)localaba, 2707, "/cgi-bin/mmpay-bin/mktdeletecardininvalidlist");
    ad.i(TAG, "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(112383);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInInvalidList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.b
 * JD-Core Version:    0.7.0.1
 */