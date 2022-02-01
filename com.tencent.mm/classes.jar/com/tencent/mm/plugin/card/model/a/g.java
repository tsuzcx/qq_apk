package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ber;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "scene", "sortRule", "(IIDDII)V", "sortType", "getSortType", "()I", "setSortType", "(I)V", "Companion", "plugin-card_release"})
public final class g
  extends j<bes>
{
  private static final String TAG = "MicroMsg.CgiGetMktCardHomePage";
  public static final a oHM;
  private int oHL;
  
  static
  {
    AppMethodBeat.i(112396);
    oHM = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktCardHomePage";
    AppMethodBeat.o(112396);
  }
  
  public g(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(112395);
    ber localber = new ber();
    bes localbes = new bes();
    localber.offset = paramInt1;
    localber.GjM = paramInt2;
    localber.latitude = paramDouble1;
    localber.longitude = paramDouble2;
    localber.scene = 1;
    localber.GjL = paramInt3;
    a((cvw)localber, (cwj)localbes, 2619, "/cgi-bin/mmpay-bin/mktgetmktcardhomepage");
    this.oHL = paramInt3;
    ae.i(TAG, "offset: %s, reqnum: %s, scene: %s, sortRule: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Integer.valueOf(paramInt3) });
    ae.d(TAG, "lat: %s, lng: %s", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    AppMethodBeat.o(112395);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.g
 * JD-Core Version:    0.7.0.1
 */