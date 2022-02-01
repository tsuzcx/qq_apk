package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMemberCardHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "offset", "", "reqNum", "latitude", "", "longitude", "sortRule", "(IIDDI)V", "Companion", "plugin-card_release"})
public final class b
  extends j<awe>
{
  private static final String TAG = "MicroMsg.CgiGetMemberCardHomePage";
  public static final a nuU;
  
  static
  {
    AppMethodBeat.i(192672);
    nuU = new a((byte)0);
    TAG = "MicroMsg.CgiGetMemberCardHomePage";
    AppMethodBeat.o(192672);
  }
  
  public b(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(192671);
    awd localawd = new awd();
    awe localawe = new awe();
    localawd.offset = paramInt1;
    localawd.CRt = paramInt2;
    localawd.latitude = paramDouble1;
    localawd.longitude = paramDouble2;
    localawd.CRs = paramInt3;
    a((ckq)localawd, (cld)localawe, 2833, "/cgi-bin/mmpay-bin/mktgetmembercardhomepage");
    ad.i(TAG, "offset: " + paramInt1 + ", reqnum: " + paramInt2);
    ad.d(TAG, "latitude: " + paramDouble1 + ", longitude: " + paramDouble2);
    AppMethodBeat.o(192671);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMemberCardHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.b
 * JD-Core Version:    0.7.0.1
 */