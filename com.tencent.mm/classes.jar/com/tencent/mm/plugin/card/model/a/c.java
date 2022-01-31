package com.tencent.mm.plugin.card.model.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.protocal.protobuf.xs;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInInvalidList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class c
  extends k<xs>
{
  private static String TAG;
  public static final c.a kpt;
  
  static
  {
    AppMethodBeat.i(89157);
    kpt = new c.a((byte)0);
    TAG = "MicroMsg.CgiDeleteCardInInvalidList";
    AppMethodBeat.o(89157);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(89156);
    xr localxr = new xr();
    xs localxs = new xs();
    localxr.wmm = paramString;
    a((buy)localxr, (bvk)localxs, 2707, "/cgi-bin/mmpay-bin/mktdeletecardininvalidlist");
    ab.i(TAG, "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(89156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.c
 * JD-Core Version:    0.7.0.1
 */