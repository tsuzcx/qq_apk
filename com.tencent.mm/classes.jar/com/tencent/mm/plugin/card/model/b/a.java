package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetCouponHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "offset", "", "reqNum", "latitude", "", "longitude", "scene", "sortRule", "(IIDDII)V", "Companion", "plugin-card_release"})
public final class a
  extends j<bal>
{
  private static final String TAG = "MicroMsg.CgiGetCouponHomePage";
  public static final a oHP;
  
  static
  {
    AppMethodBeat.i(218400);
    oHP = new a((byte)0);
    TAG = "MicroMsg.CgiGetCouponHomePage";
    AppMethodBeat.o(218400);
  }
  
  public a(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(218399);
    bak localbak = new bak();
    bal localbal = new bal();
    localbak.offset = paramInt1;
    localbak.GjM = paramInt2;
    localbak.latitude = paramDouble1;
    localbak.longitude = paramDouble2;
    localbak.GjL = paramInt3;
    localbak.scene = 1;
    a((cvw)localbak, (cwj)localbal, 2619, "/cgi-bin/mmpay-bin/mktgetcouponhomepage");
    ae.i(TAG, "offset: " + paramInt1 + ", reqnum: " + paramInt2);
    ae.d(TAG, "latitude: " + paramDouble1 + ", longitude: " + paramDouble2);
    AppMethodBeat.o(218399);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetCouponHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.a
 * JD-Core Version:    0.7.0.1
 */