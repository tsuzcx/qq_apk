package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.dmu;
import com.tencent.mm.protocal.protobuf.dmv;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v4/CgiRemoveCouponRequest;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/RemoveCouponResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class e
  extends j<dmv>
{
  public static final a pVG;
  
  static
  {
    AppMethodBeat.i(201389);
    pVG = new a((byte)0);
    AppMethodBeat.o(201389);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(201388);
    dmu localdmu = new dmu();
    dmv localdmv = new dmv();
    localdmu.KDM = paramString;
    a((dop)localdmu, (dpc)localdmv, 5170, "/cgi-bin/mmpay-bin/mktremovecoupon");
    Log.i("MicroMsg.CgiRemoveCouponRequest", "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(201388);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v4/CgiRemoveCouponRequest$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.e
 * JD-Core Version:    0.7.0.1
 */