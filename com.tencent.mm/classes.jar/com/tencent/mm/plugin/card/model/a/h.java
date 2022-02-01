package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bab;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktInvalidTicketHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktInvalidTicketHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "(IIDD)V", "Companion", "plugin-card_release"})
public final class h
  extends j<bac>
{
  private static final String TAG = "MicroMsg.CgiGetMktInvalidTicketHomePage";
  public static final h.a nXR;
  
  static
  {
    AppMethodBeat.i(112398);
    nXR = new h.a((byte)0);
    TAG = "MicroMsg.CgiGetMktInvalidTicketHomePage";
    AppMethodBeat.o(112398);
  }
  
  public h(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(112397);
    bab localbab = new bab();
    bac localbac = new bac();
    localbab.offset = paramInt1;
    localbab.Eke = paramInt2;
    localbab.latitude = paramDouble1;
    localbab.longitude = paramDouble2;
    a((cpx)localbab, (cqk)localbac, 2979, "/cgi-bin/mmpay-bin/mktgetmktinvalidtickethomepage");
    ac.i(TAG, "offset: %s, reqnum: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(112397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.h
 * JD-Core Version:    0.7.0.1
 */