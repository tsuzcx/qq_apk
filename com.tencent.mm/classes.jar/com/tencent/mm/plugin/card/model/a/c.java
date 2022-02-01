package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInTicketList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends j<ajl>
{
  private static String TAG;
  public static final a wvP;
  
  static
  {
    AppMethodBeat.i(112386);
    wvP = new a((byte)0);
    TAG = "MicroMsg.CgiDeleteCardInTicketList";
    AppMethodBeat.o(112386);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(112385);
    ajk localajk = new ajk();
    ajl localajl = new ajl();
    localajk.YBH = paramString;
    a((erp)localajk, (esc)localajl, 1739, "/cgi-bin/mmpay-bin/mktdeletecardinticketlist");
    Log.i(TAG, "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(112385);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInTicketList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.c
 * JD-Core Version:    0.7.0.1
 */