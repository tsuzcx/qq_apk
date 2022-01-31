package com.tencent.mm.plugin.card.model.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "scene", "sortRule", "(IIDDII)V", "sortType", "getSortType", "()I", "setSortType", "(I)V", "Companion", "plugin-card_release"})
public final class h
  extends k<amj>
{
  private static final String TAG = "MicroMsg.CgiGetMktCardHomePage";
  public static final h.a kpA;
  private int kpz;
  
  static
  {
    AppMethodBeat.i(89170);
    kpA = new h.a((byte)0);
    TAG = "MicroMsg.CgiGetMktCardHomePage";
    AppMethodBeat.o(89170);
  }
  
  public h(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(89169);
    ami localami = new ami();
    amj localamj = new amj();
    localami.offset = paramInt1;
    localami.wvk = paramInt2;
    localami.latitude = paramDouble1;
    localami.longitude = paramDouble2;
    localami.scene = 1;
    localami.wFN = paramInt3;
    a((buy)localami, (bvk)localamj, 2619, "/cgi-bin/mmpay-bin/mktgetmktcardhomepage");
    this.kpz = paramInt3;
    ab.i(TAG, "offset: %s, reqnum: %s, scene: %s, sortRule: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Integer.valueOf(paramInt3) });
    ab.d(TAG, "lat: %s, lng: %s", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    AppMethodBeat.o(89169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.h
 * JD-Core Version:    0.7.0.1
 */