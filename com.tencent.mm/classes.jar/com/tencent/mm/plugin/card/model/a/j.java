package com.tencent.mm.plugin.card.model.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktTicketHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "(IIDD)V", "Companion", "plugin-card_release"})
public final class j
  extends k<amn>
{
  private static String TAG;
  public static final j.a kpC;
  
  static
  {
    AppMethodBeat.i(89174);
    kpC = new j.a((byte)0);
    TAG = "MicroMsg.CgiGetMktTicketHomePage";
    AppMethodBeat.o(89174);
  }
  
  public j(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(89173);
    amm localamm = new amm();
    amn localamn = new amn();
    localamm.offset = paramInt1;
    localamm.wvk = paramInt2;
    localamm.latitude = paramDouble1;
    localamm.longitude = paramDouble2;
    a((buy)localamm, (bvk)localamn, 2940, "/cgi-bin/mmpay-bin/mktgetmkttickethomepage");
    ab.i(TAG, "offset: %s, reqnum: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(89173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.j
 * JD-Core Version:    0.7.0.1
 */