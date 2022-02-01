package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInInvalidList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends j<ajj>
{
  private static String TAG;
  public static final a wvO;
  
  static
  {
    AppMethodBeat.i(112384);
    wvO = new a((byte)0);
    TAG = "MicroMsg.CgiDeleteCardInInvalidList";
    AppMethodBeat.o(112384);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(112383);
    aji localaji = new aji();
    ajj localajj = new ajj();
    localaji.YBH = paramString;
    a((erp)localaji, (esc)localajj, 2707, "/cgi-bin/mmpay-bin/mktdeletecardininvalidlist");
    Log.i(TAG, "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(112383);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInInvalidList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.b
 * JD-Core Version:    0.7.0.1
 */