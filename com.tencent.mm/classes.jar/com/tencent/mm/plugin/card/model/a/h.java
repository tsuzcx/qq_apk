package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bev;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktInvalidTicketHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktInvalidTicketHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "(IIDD)V", "Companion", "plugin-card_release"})
public final class h
  extends j<bew>
{
  private static final String TAG = "MicroMsg.CgiGetMktInvalidTicketHomePage";
  public static final a oHN;
  
  static
  {
    AppMethodBeat.i(112398);
    oHN = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktInvalidTicketHomePage";
    AppMethodBeat.o(112398);
  }
  
  public h(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(112397);
    bev localbev = new bev();
    bew localbew = new bew();
    localbev.offset = paramInt1;
    localbev.GjM = paramInt2;
    localbev.latitude = paramDouble1;
    localbev.longitude = paramDouble2;
    a((cvw)localbev, (cwj)localbew, 2979, "/cgi-bin/mmpay-bin/mktgetmktinvalidtickethomepage");
    ae.i(TAG, "offset: %s, reqnum: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(112397);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktInvalidTicketHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.h
 * JD-Core Version:    0.7.0.1
 */