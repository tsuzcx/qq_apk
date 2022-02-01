package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.bqu;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktTicketHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "(IIDD)V", "Companion", "plugin-card_release"})
public final class i
  extends j<bqu>
{
  private static String TAG;
  public static final a pVx;
  
  static
  {
    AppMethodBeat.i(112400);
    pVx = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktTicketHomePage";
    AppMethodBeat.o(112400);
  }
  
  public i(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(112399);
    bqt localbqt = new bqt();
    bqu localbqu = new bqu();
    localbqt.offset = paramInt1;
    localbqt.Ler = paramInt2;
    localbqt.latitude = paramDouble1;
    localbqt.longitude = paramDouble2;
    a((dop)localbqt, (dpc)localbqu, 2940, "/cgi-bin/mmpay-bin/mktgetmkttickethomepage");
    Log.i(TAG, "offset: %s, reqnum: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(112399);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.i
 * JD-Core Version:    0.7.0.1
 */