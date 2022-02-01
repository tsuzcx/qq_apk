package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetCouponHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "offset", "", "reqNum", "latitude", "", "longitude", "scene", "sortRule", "(IIDDII)V", "Companion", "plugin-card_release"})
public final class a
  extends j<azv>
{
  private static final String TAG = "MicroMsg.CgiGetCouponHomePage";
  public static final a oBn;
  
  static
  {
    AppMethodBeat.i(215439);
    oBn = new a((byte)0);
    TAG = "MicroMsg.CgiGetCouponHomePage";
    AppMethodBeat.o(215439);
  }
  
  public a(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(215438);
    azu localazu = new azu();
    azv localazv = new azv();
    localazu.offset = paramInt1;
    localazu.FRn = paramInt2;
    localazu.latitude = paramDouble1;
    localazu.longitude = paramDouble2;
    localazu.FRm = paramInt3;
    localazu.scene = 1;
    a((cvc)localazu, (cvp)localazv, 2619, "/cgi-bin/mmpay-bin/mktgetcouponhomepage");
    ad.i(TAG, "offset: " + paramInt1 + ", reqnum: " + paramInt2);
    ad.d(TAG, "latitude: " + paramDouble1 + ", longitude: " + paramDouble2);
    AppMethodBeat.o(215438);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetCouponHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.a
 * JD-Core Version:    0.7.0.1
 */