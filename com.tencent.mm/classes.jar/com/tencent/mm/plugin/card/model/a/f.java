package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "marchantId", "", "lastReceiveTime", "", "latitude", "", "longitude", "sortRule", "", "scene", "(Ljava/lang/String;JDDII)V", "Companion", "plugin-card_release"})
public final class f
  extends j<aze>
{
  private static final String TAG = "MicroMsg.CgiGetCardPkgMchInfo";
  public static final a oHK;
  
  static
  {
    AppMethodBeat.i(112394);
    oHK = new a((byte)0);
    TAG = "MicroMsg.CgiGetCardPkgMchInfo";
    AppMethodBeat.o(112394);
  }
  
  public f(String paramString, long paramLong, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218398);
    azd localazd = new azd();
    aze localaze = new aze();
    localazd.GiJ = paramString;
    localazd.GiW = paramLong;
    localazd.latitude = paramDouble1;
    localazd.longitude = paramDouble2;
    localazd.GjL = paramInt1;
    localazd.scene = paramInt2;
    a((cvw)localazd, (cwj)localaze, 2769, "/cgi-bin/mmpay-bin/mktgetcardpkgmchinfo");
    ae.i(TAG, "marchantid: %s, lastReceiveTime: %s, lat: %s, long: %s", new Object[] { paramString, Long.valueOf(paramLong), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    AppMethodBeat.o(218398);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.f
 * JD-Core Version:    0.7.0.1
 */