package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktTicketHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "(IIDD)V", "Companion", "plugin-card_release"})
public final class i
  extends j<bei>
{
  private static String TAG;
  public static final a oBm;
  
  static
  {
    AppMethodBeat.i(112400);
    oBm = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktTicketHomePage";
    AppMethodBeat.o(112400);
  }
  
  public i(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(112399);
    beh localbeh = new beh();
    bei localbei = new bei();
    localbeh.offset = paramInt1;
    localbeh.FRn = paramInt2;
    localbeh.latitude = paramDouble1;
    localbeh.longitude = paramDouble2;
    a((cvc)localbeh, (cvp)localbei, 2940, "/cgi-bin/mmpay-bin/mktgetmkttickethomepage");
    ad.i(TAG, "offset: %s, reqnum: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(112399);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.i
 * JD-Core Version:    0.7.0.1
 */