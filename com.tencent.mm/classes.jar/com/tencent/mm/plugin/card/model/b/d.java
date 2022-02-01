package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.dmt;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v3/CgiRemoveCardInRecentlyUsedList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "cardId", "", "userCardId", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class d
  extends j<dmt>
{
  private static final String TAG = "MicroMsg.CgiRemoveCardInRecentlyUsedList";
  public static final a pVB;
  
  static
  {
    AppMethodBeat.i(201379);
    pVB = new a((byte)0);
    TAG = "MicroMsg.CgiRemoveCardInRecentlyUsedList";
    AppMethodBeat.o(201379);
  }
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(201378);
    dms localdms = new dms();
    dmt localdmt = new dmt();
    localdms.eaO = paramString1;
    localdms.KDM = paramString2;
    a((dop)localdms, (dpc)localdmt, 2986, "/cgi-bin/mmpay-bin/mktremovecardinrecentlyusedlist");
    Log.i(TAG, "card_id: " + paramString1 + ", code: " + paramString2);
    AppMethodBeat.o(201378);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v3/CgiRemoveCardInRecentlyUsedList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.d
 * JD-Core Version:    0.7.0.1
 */