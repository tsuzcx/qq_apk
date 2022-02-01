package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.cth;
import com.tencent.mm.protocal.protobuf.cti;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v3/CgiRemoveCardInRecentlyUsedList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "cardId", "", "userCardId", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class d
  extends j<cti>
{
  private static final String TAG = "MicroMsg.CgiRemoveCardInRecentlyUsedList";
  public static final a oBq;
  
  static
  {
    AppMethodBeat.i(215445);
    oBq = new a((byte)0);
    TAG = "MicroMsg.CgiRemoveCardInRecentlyUsedList";
    AppMethodBeat.o(215445);
  }
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215444);
    cth localcth = new cth();
    cti localcti = new cti();
    localcth.dHX = paramString1;
    localcth.FrW = paramString2;
    a((cvc)localcth, (cvp)localcti, 2986, "/cgi-bin/mmpay-bin/mktremovecardinrecentlyusedlist");
    ad.i(TAG, "card_id: " + paramString1 + ", code: " + paramString2);
    AppMethodBeat.o(215444);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v3/CgiRemoveCardInRecentlyUsedList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.d
 * JD-Core Version:    0.7.0.1
 */