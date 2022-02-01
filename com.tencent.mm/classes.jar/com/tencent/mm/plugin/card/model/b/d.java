package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.coe;
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v3/CgiRemoveCardInRecentlyUsedList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "cardId", "", "userCardId", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class d
  extends j<cof>
{
  private static final String TAG = "MicroMsg.CgiRemoveCardInRecentlyUsedList";
  public static final a nXW;
  
  static
  {
    AppMethodBeat.i(206250);
    nXW = new a((byte)0);
    TAG = "MicroMsg.CgiRemoveCardInRecentlyUsedList";
    AppMethodBeat.o(206250);
  }
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206249);
    coe localcoe = new coe();
    cof localcof = new cof();
    localcoe.dvO = paramString1;
    localcoe.DMR = paramString2;
    a((cpx)localcoe, (cqk)localcof, 2986, "/cgi-bin/mmpay-bin/mktremovecardinrecentlyusedlist");
    ac.i(TAG, "card_id: " + paramString1 + ", code: " + paramString2);
    AppMethodBeat.o(206249);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v3/CgiRemoveCardInRecentlyUsedList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.d
 * JD-Core Version:    0.7.0.1
 */