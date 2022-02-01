package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.dwl;
import com.tencent.mm.protocal.protobuf.dwm;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v4/CgiRemoveCouponRequest;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/RemoveCouponResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class e
  extends j<dwm>
{
  public static final a trH;
  
  static
  {
    AppMethodBeat.i(246721);
    trH = new a((byte)0);
    AppMethodBeat.o(246721);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(246720);
    dwl localdwl = new dwl();
    dwm localdwm = new dwm();
    localdwl.RFf = paramString;
    a((dyl)localdwl, (dyy)localdwm, 5170, "/cgi-bin/mmpay-bin/mktremovecoupon");
    Log.i("MicroMsg.CgiRemoveCouponRequest", "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(246720);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v4/CgiRemoveCouponRequest$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.e
 * JD-Core Version:    0.7.0.1
 */