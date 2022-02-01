package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMemberCardHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "offset", "", "reqNum", "latitude", "", "longitude", "sortRule", "(IIDDI)V", "Companion", "plugin-card_release"})
public final class b
  extends j<bqk>
{
  private static final String TAG = "MicroMsg.CgiGetMemberCardHomePage";
  public static final a pVz;
  
  static
  {
    AppMethodBeat.i(201375);
    pVz = new a((byte)0);
    TAG = "MicroMsg.CgiGetMemberCardHomePage";
    AppMethodBeat.o(201375);
  }
  
  public b(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(201374);
    bqj localbqj = new bqj();
    bqk localbqk = new bqk();
    localbqj.offset = paramInt1;
    localbqj.Ler = paramInt2;
    localbqj.latitude = paramDouble1;
    localbqj.longitude = paramDouble2;
    localbqj.Leq = paramInt3;
    a((dop)localbqj, (dpc)localbqk, 2833, "/cgi-bin/mmpay-bin/mktgetmembercardhomepage");
    Log.i(TAG, "offset: " + paramInt1 + ", reqnum: " + paramInt2);
    Log.d(TAG, "latitude: " + paramDouble1 + ", longitude: " + paramDouble2);
    AppMethodBeat.o(201374);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v3/CgiGetMemberCardHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.b.b
 * JD-Core Version:    0.7.0.1
 */