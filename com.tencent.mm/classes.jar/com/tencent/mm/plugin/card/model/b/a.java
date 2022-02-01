package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetCouponHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "offset", "", "reqNum", "latitude", "", "longitude", "scene", "sortRule", "(IIDDII)V", "Companion", "plugin-card_release"})
public final class a
  extends j<ast>
{
  private static final String TAG = "MicroMsg.CgiGetCouponHomePage";
  public static final a nuT;
  
  static
  {
    AppMethodBeat.i(192670);
    nuT = new a((byte)0);
    TAG = "MicroMsg.CgiGetCouponHomePage";
    AppMethodBeat.o(192670);
  }
  
  public a(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(192669);
    ass localass = new ass();
    ast localast = new ast();
    localass.offset = paramInt1;
    localass.CRt = paramInt2;
    localass.latitude = paramDouble1;
    localass.longitude = paramDouble2;
    localass.CRs = paramInt3;
    localass.scene = 1;
    a((ckq)localass, (cld)localast, 2619, "/cgi-bin/mmpay-bin/mktgetcouponhomepage");
    ad.i(TAG, "offset: " + paramInt1 + ", reqnum: " + paramInt2);
    ad.d(TAG, "latitude: " + paramDouble1 + ", longitude: " + paramDouble2);
    AppMethodBeat.o(192669);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetCouponHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.a
 * JD-Core Version:    0.7.0.1
 */