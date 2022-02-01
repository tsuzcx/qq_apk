package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.agm;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInTicketList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class c
  extends j<agn>
{
  private static String TAG;
  public static final a pVp;
  
  static
  {
    AppMethodBeat.i(112386);
    pVp = new a((byte)0);
    TAG = "MicroMsg.CgiDeleteCardInTicketList";
    AppMethodBeat.o(112386);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(112385);
    agm localagm = new agm();
    agn localagn = new agn();
    localagm.KDM = paramString;
    a((dop)localagm, (dpc)localagn, 1739, "/cgi-bin/mmpay-bin/mktdeletecardinticketlist");
    Log.i(TAG, "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(112385);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInTicketList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.c
 * JD-Core Version:    0.7.0.1
 */