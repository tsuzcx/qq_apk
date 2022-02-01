package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.protocal.protobuf.bec;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "scene", "sortRule", "(IIDDII)V", "sortType", "getSortType", "()I", "setSortType", "(I)V", "Companion", "plugin-card_release"})
public final class g
  extends j<bec>
{
  private static final String TAG = "MicroMsg.CgiGetMktCardHomePage";
  public static final a oBk;
  private int oBj;
  
  static
  {
    AppMethodBeat.i(112396);
    oBk = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktCardHomePage";
    AppMethodBeat.o(112396);
  }
  
  public g(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(112395);
    beb localbeb = new beb();
    bec localbec = new bec();
    localbeb.offset = paramInt1;
    localbeb.FRn = paramInt2;
    localbeb.latitude = paramDouble1;
    localbeb.longitude = paramDouble2;
    localbeb.scene = 1;
    localbeb.FRm = paramInt3;
    a((cvc)localbeb, (cvp)localbec, 2619, "/cgi-bin/mmpay-bin/mktgetmktcardhomepage");
    this.oBj = paramInt3;
    ad.i(TAG, "offset: %s, reqnum: %s, scene: %s, sortRule: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Integer.valueOf(paramInt3) });
    ad.d(TAG, "lat: %s, lng: %s", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    AppMethodBeat.o(112395);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.g
 * JD-Core Version:    0.7.0.1
 */