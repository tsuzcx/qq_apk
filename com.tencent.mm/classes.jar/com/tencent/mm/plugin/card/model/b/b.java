package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.bep;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMemberCardHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "offset", "", "reqNum", "latitude", "", "longitude", "sortRule", "(IIDDI)V", "Companion", "plugin-card_release"})
public final class b
  extends j<beq>
{
  private static final String TAG = "MicroMsg.CgiGetMemberCardHomePage";
  public static final a oHQ;
  
  static
  {
    AppMethodBeat.i(218402);
    oHQ = new a((byte)0);
    TAG = "MicroMsg.CgiGetMemberCardHomePage";
    AppMethodBeat.o(218402);
  }
  
  public b(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(218401);
    bep localbep = new bep();
    beq localbeq = new beq();
    localbep.offset = paramInt1;
    localbep.GjM = paramInt2;
    localbep.latitude = paramDouble1;
    localbep.longitude = paramDouble2;
    localbep.GjL = paramInt3;
    a((cvw)localbep, (cwj)localbeq, 2833, "/cgi-bin/mmpay-bin/mktgetmembercardhomepage");
    ae.i(TAG, "offset: " + paramInt1 + ", reqnum: " + paramInt2);
    ae.d(TAG, "latitude: " + paramDouble1 + ", longitude: " + paramDouble2);
    AppMethodBeat.o(218401);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMemberCardHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.b
 * JD-Core Version:    0.7.0.1
 */