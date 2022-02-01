package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.bdz;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMemberCardHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "offset", "", "reqNum", "latitude", "", "longitude", "sortRule", "(IIDDI)V", "Companion", "plugin-card_release"})
public final class b
  extends j<bea>
{
  private static final String TAG = "MicroMsg.CgiGetMemberCardHomePage";
  public static final a oBo;
  
  static
  {
    AppMethodBeat.i(215441);
    oBo = new a((byte)0);
    TAG = "MicroMsg.CgiGetMemberCardHomePage";
    AppMethodBeat.o(215441);
  }
  
  public b(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(215440);
    bdz localbdz = new bdz();
    bea localbea = new bea();
    localbdz.offset = paramInt1;
    localbdz.FRn = paramInt2;
    localbdz.latitude = paramDouble1;
    localbdz.longitude = paramDouble2;
    localbdz.FRm = paramInt3;
    a((cvc)localbdz, (cvp)localbea, 2833, "/cgi-bin/mmpay-bin/mktgetmembercardhomepage");
    ad.i(TAG, "offset: " + paramInt1 + ", reqnum: " + paramInt2);
    ad.d(TAG, "latitude: " + paramDouble1 + ", longitude: " + paramDouble2);
    AppMethodBeat.o(215440);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMemberCardHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.b
 * JD-Core Version:    0.7.0.1
 */