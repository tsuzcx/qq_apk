package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.awk;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktInvalidTicketHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktInvalidTicketHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "(IIDD)V", "Companion", "plugin-card_release"})
public final class h
  extends j<awk>
{
  private static final String TAG = "MicroMsg.CgiGetMktInvalidTicketHomePage";
  public static final a nuR;
  
  static
  {
    AppMethodBeat.i(112398);
    nuR = new a((byte)0);
    TAG = "MicroMsg.CgiGetMktInvalidTicketHomePage";
    AppMethodBeat.o(112398);
  }
  
  public h(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(112397);
    awj localawj = new awj();
    awk localawk = new awk();
    localawj.offset = paramInt1;
    localawj.CRt = paramInt2;
    localawj.latitude = paramDouble1;
    localawj.longitude = paramDouble2;
    a((ckq)localawj, (cld)localawk, 2979, "/cgi-bin/mmpay-bin/mktgetmktinvalidtickethomepage");
    ad.i(TAG, "offset: %s, reqnum: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(112397);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktInvalidTicketHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.h
 * JD-Core Version:    0.7.0.1
 */