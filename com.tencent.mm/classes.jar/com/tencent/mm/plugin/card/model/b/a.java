package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.blz;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetCouponHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "offset", "", "reqNum", "latitude", "", "longitude", "scene", "sortRule", "(IIDDII)V", "Companion", "plugin-card_release"})
public final class a
  extends j<bma>
{
  private static final String TAG = "MicroMsg.CgiGetCouponHomePage";
  public static final a pVy;
  
  static
  {
    AppMethodBeat.i(201373);
    pVy = new a((byte)0);
    TAG = "MicroMsg.CgiGetCouponHomePage";
    AppMethodBeat.o(201373);
  }
  
  public a(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(201372);
    blz localblz = new blz();
    bma localbma = new bma();
    localblz.offset = paramInt1;
    localblz.Ler = paramInt2;
    localblz.latitude = paramDouble1;
    localblz.longitude = paramDouble2;
    localblz.Leq = paramInt3;
    localblz.scene = 1;
    a((dop)localblz, (dpc)localbma, 2619, "/cgi-bin/mmpay-bin/mktgetcouponhomepage");
    Log.i(TAG, "offset: " + paramInt1 + ", reqnum: " + paramInt2);
    Log.d(TAG, "latitude: " + paramDouble1 + ", longitude: " + paramDouble2);
    AppMethodBeat.o(201372);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetCouponHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.a
 * JD-Core Version:    0.7.0.1
 */