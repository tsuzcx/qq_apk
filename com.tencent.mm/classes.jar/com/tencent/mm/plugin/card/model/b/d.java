package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.cub;
import com.tencent.mm.protocal.protobuf.cuc;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v3/CgiRemoveCardInRecentlyUsedList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "cardId", "", "userCardId", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class d
  extends j<cuc>
{
  private static final String TAG = "MicroMsg.CgiRemoveCardInRecentlyUsedList";
  public static final a oHS;
  
  static
  {
    AppMethodBeat.i(218406);
    oHS = new a((byte)0);
    TAG = "MicroMsg.CgiRemoveCardInRecentlyUsedList";
    AppMethodBeat.o(218406);
  }
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218405);
    cub localcub = new cub();
    cuc localcuc = new cuc();
    localcub.dJb = paramString1;
    localcub.FKu = paramString2;
    a((cvw)localcub, (cwj)localcuc, 2986, "/cgi-bin/mmpay-bin/mktremovecardinrecentlyusedlist");
    ae.i(TAG, "card_id: " + paramString1 + ", code: " + paramString2);
    AppMethodBeat.o(218405);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v3/CgiRemoveCardInRecentlyUsedList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.d
 * JD-Core Version:    0.7.0.1
 */