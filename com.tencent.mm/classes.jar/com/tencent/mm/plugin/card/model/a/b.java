package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInInvalidList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class b
  extends j<abz>
{
  private static String TAG;
  public static final a nXJ;
  
  static
  {
    AppMethodBeat.i(112384);
    nXJ = new a((byte)0);
    TAG = "MicroMsg.CgiDeleteCardInInvalidList";
    AppMethodBeat.o(112384);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(112383);
    aby localaby = new aby();
    abz localabz = new abz();
    localaby.DMR = paramString;
    a((cpx)localaby, (cqk)localabz, 2707, "/cgi-bin/mmpay-bin/mktdeletecardininvalidlist");
    ac.i(TAG, "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(112383);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInInvalidList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.b
 * JD-Core Version:    0.7.0.1
 */