package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bqn;
import com.tencent.mm.protocal.protobuf.bqo;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "scene", "sortRule", "(IIDDII)V", "sortType", "getSortType", "()I", "setSortType", "(I)V", "Companion", "plugin-card_release"})
public final class g
  extends j<bqo>
{
  private static final String TAG = "MicroMsg.CgiGetMktCardHomePage";
  public static final a pVv;
  private int pVu;
  
  static
  {
    AppMethodBeat.i(112396);
    pVv = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktCardHomePage";
    AppMethodBeat.o(112396);
  }
  
  public g(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    AppMethodBeat.i(112395);
    bqn localbqn = new bqn();
    bqo localbqo = new bqo();
    localbqn.offset = paramInt1;
    localbqn.Ler = paramInt2;
    localbqn.latitude = paramDouble1;
    localbqn.longitude = paramDouble2;
    localbqn.scene = 1;
    localbqn.Leq = paramInt3;
    a((dop)localbqn, (dpc)localbqo, 2619, "/cgi-bin/mmpay-bin/mktgetmktcardhomepage");
    this.pVu = paramInt3;
    Log.i(TAG, "offset: %s, reqnum: %s, scene: %s, sortRule: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Integer.valueOf(paramInt3) });
    Log.d(TAG, "lat: %s, lng: %s", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    AppMethodBeat.o(112395);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.g
 * JD-Core Version:    0.7.0.1
 */