package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "scene", "sortRule", "(IIDDII)V", "sortType", "getSortType", "()I", "setSortType", "(I)V", "Companion", "plugin-card_release"})
public final class g
  extends j<azy>
{
  private static final String TAG = "MicroMsg.CgiGetMktCardHomePage";
  public static final g.a nXQ;
  private int nXP;
  
  static
  {
    AppMethodBeat.i(112396);
    nXQ = new g.a((byte)0);
    TAG = "MicroMsg.CgiGetMktCardHomePage";
    AppMethodBeat.o(112396);
  }
  
  public g(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(112395);
    azx localazx = new azx();
    azy localazy = new azy();
    localazx.offset = paramInt1;
    localazx.Eke = paramInt2;
    localazx.latitude = paramDouble1;
    localazx.longitude = paramDouble2;
    localazx.scene = 1;
    localazx.Ekd = paramInt3;
    a((cpx)localazx, (cqk)localazy, 2619, "/cgi-bin/mmpay-bin/mktgetmktcardhomepage");
    this.nXP = paramInt3;
    ac.i(TAG, "offset: %s, reqnum: %s, scene: %s, sortRule: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Integer.valueOf(paramInt3) });
    ac.d(TAG, "lat: %s, lng: %s", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    AppMethodBeat.o(112395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.g
 * JD-Core Version:    0.7.0.1
 */