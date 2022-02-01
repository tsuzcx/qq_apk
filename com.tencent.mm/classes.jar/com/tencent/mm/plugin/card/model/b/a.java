package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetCouponHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "offset", "", "reqNum", "latitude", "", "longitude", "scene", "sortRule", "(IIDDII)V", "Companion", "plugin-card_release"})
public final class a
  extends j<avx>
{
  private static final String TAG = "MicroMsg.CgiGetCouponHomePage";
  public static final a.a nXT;
  
  static
  {
    AppMethodBeat.i(206244);
    nXT = new a.a((byte)0);
    TAG = "MicroMsg.CgiGetCouponHomePage";
    AppMethodBeat.o(206244);
  }
  
  public a(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(206243);
    avw localavw = new avw();
    avx localavx = new avx();
    localavw.offset = paramInt1;
    localavw.Eke = paramInt2;
    localavw.latitude = paramDouble1;
    localavw.longitude = paramDouble2;
    localavw.Ekd = paramInt3;
    localavw.scene = 1;
    a((cpx)localavw, (cqk)localavx, 2619, "/cgi-bin/mmpay-bin/mktgetcouponhomepage");
    ac.i(TAG, "offset: " + paramInt1 + ", reqnum: " + paramInt2);
    ac.d(TAG, "latitude: " + paramDouble1 + ", longitude: " + paramDouble2);
    AppMethodBeat.o(206243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.a
 * JD-Core Version:    0.7.0.1
 */