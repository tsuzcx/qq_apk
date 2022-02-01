package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bef;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktInvalidTicketHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktInvalidTicketHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "(IIDD)V", "Companion", "plugin-card_release"})
public final class h
  extends j<beg>
{
  private static final String TAG = "MicroMsg.CgiGetMktInvalidTicketHomePage";
  public static final a oBl;
  
  static
  {
    AppMethodBeat.i(112398);
    oBl = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktInvalidTicketHomePage";
    AppMethodBeat.o(112398);
  }
  
  public h(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(112397);
    bef localbef = new bef();
    beg localbeg = new beg();
    localbef.offset = paramInt1;
    localbef.FRn = paramInt2;
    localbef.latitude = paramDouble1;
    localbef.longitude = paramDouble2;
    a((cvc)localbef, (cvp)localbeg, 2979, "/cgi-bin/mmpay-bin/mktgetmktinvalidtickethomepage");
    ad.i(TAG, "offset: %s, reqnum: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(112397);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktInvalidTicketHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.h
 * JD-Core Version:    0.7.0.1
 */