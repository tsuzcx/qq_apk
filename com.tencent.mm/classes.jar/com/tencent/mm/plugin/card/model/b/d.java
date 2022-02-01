package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.epn;
import com.tencent.mm.protocal.protobuf.epo;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v3/CgiRemoveCardInRecentlyUsedList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "cardId", "", "userCardId", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends j<epo>
{
  private static final String TAG;
  public static final a wwa;
  
  static
  {
    AppMethodBeat.i(294522);
    wwa = new a((byte)0);
    TAG = "MicroMsg.CgiRemoveCardInRecentlyUsedList";
    AppMethodBeat.o(294522);
  }
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(294519);
    epn localepn = new epn();
    epo localepo = new epo();
    localepn.iaI = paramString1;
    localepn.YBH = paramString2;
    a((erp)localepn, (esc)localepo, 2986, "/cgi-bin/mmpay-bin/mktremovecardinrecentlyusedlist");
    Log.i(TAG, "card_id: " + paramString1 + ", code: " + paramString2);
    AppMethodBeat.o(294519);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v3/CgiRemoveCardInRecentlyUsedList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.d
 * JD-Core Version:    0.7.0.1
 */