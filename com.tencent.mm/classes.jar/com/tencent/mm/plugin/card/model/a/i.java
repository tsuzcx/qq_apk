package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bex;
import com.tencent.mm.protocal.protobuf.bey;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktTicketHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "(IIDD)V", "Companion", "plugin-card_release"})
public final class i
  extends j<bey>
{
  private static String TAG;
  public static final a oHO;
  
  static
  {
    AppMethodBeat.i(112400);
    oHO = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktTicketHomePage";
    AppMethodBeat.o(112400);
  }
  
  public i(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(112399);
    bex localbex = new bex();
    bey localbey = new bey();
    localbex.offset = paramInt1;
    localbex.GjM = paramInt2;
    localbex.latitude = paramDouble1;
    localbex.longitude = paramDouble2;
    a((cvw)localbex, (cwj)localbey, 2940, "/cgi-bin/mmpay-bin/mktgetmkttickethomepage");
    ae.i(TAG, "offset: %s, reqnum: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(112399);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.i
 * JD-Core Version:    0.7.0.1
 */