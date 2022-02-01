package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.cix;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v3/CgiRemoveCardInRecentlyUsedList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "cardId", "", "userCardId", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class d
  extends j<ciy>
{
  private static final String TAG = "MicroMsg.CgiRemoveCardInRecentlyUsedList";
  public static final a nuW;
  
  static
  {
    AppMethodBeat.i(192676);
    nuW = new a((byte)0);
    TAG = "MicroMsg.CgiRemoveCardInRecentlyUsedList";
    AppMethodBeat.o(192676);
  }
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192675);
    cix localcix = new cix();
    ciy localciy = new ciy();
    localcix.dyc = paramString1;
    localcix.CuA = paramString2;
    a((ckq)localcix, (cld)localciy, 2986, "/cgi-bin/mmpay-bin/mktremovecardinrecentlyusedlist");
    ad.i(TAG, "card_id: " + paramString1 + ", code: " + paramString2);
    AppMethodBeat.o(192675);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v3/CgiRemoveCardInRecentlyUsedList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.d
 * JD-Core Version:    0.7.0.1
 */