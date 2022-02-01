package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMemberCardHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "offset", "", "reqNum", "latitude", "", "longitude", "sortRule", "(IIDDI)V", "Companion", "plugin-card_release"})
public final class b
  extends j<azw>
{
  private static final String TAG = "MicroMsg.CgiGetMemberCardHomePage";
  public static final b.a nXU;
  
  static
  {
    AppMethodBeat.i(206246);
    nXU = new b.a((byte)0);
    TAG = "MicroMsg.CgiGetMemberCardHomePage";
    AppMethodBeat.o(206246);
  }
  
  public b(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(206245);
    azv localazv = new azv();
    azw localazw = new azw();
    localazv.offset = paramInt1;
    localazv.Eke = paramInt2;
    localazv.latitude = paramDouble1;
    localazv.longitude = paramDouble2;
    localazv.Ekd = paramInt3;
    a((cpx)localazv, (cqk)localazw, 2833, "/cgi-bin/mmpay-bin/mktgetmembercardhomepage");
    ac.i(TAG, "offset: " + paramInt1 + ", reqnum: " + paramInt2);
    ac.d(TAG, "latitude: " + paramDouble1 + ", longitude: " + paramDouble2);
    AppMethodBeat.o(206245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.b
 * JD-Core Version:    0.7.0.1
 */