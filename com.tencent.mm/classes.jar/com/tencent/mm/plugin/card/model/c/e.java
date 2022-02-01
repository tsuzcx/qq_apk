package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.epp;
import com.tencent.mm.protocal.protobuf.epq;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v4/CgiRemoveCouponRequest;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/RemoveCouponResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends j<epq>
{
  public static final a wwf;
  
  static
  {
    AppMethodBeat.i(294529);
    wwf = new a((byte)0);
    AppMethodBeat.o(294529);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(294525);
    epp localepp = new epp();
    epq localepq = new epq();
    localepp.YBH = paramString;
    a((erp)localepp, (esc)localepq, 5170, "/cgi-bin/mmpay-bin/mktremovecoupon");
    Log.i("MicroMsg.CgiRemoveCouponRequest", "cardid: %s", new Object[] { paramString });
    AppMethodBeat.o(294525);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v4/CgiRemoveCouponRequest$Companion;", "", "()V", "TAG", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.e
 * JD-Core Version:    0.7.0.1
 */