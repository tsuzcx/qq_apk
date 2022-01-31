package com.tencent.mm.plugin.card.model.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "marchantId", "", "lastReceiveTime", "", "latitude", "", "longitude", "sortRule", "", "(Ljava/lang/String;JDDI)V", "Companion", "plugin-card_release"})
public final class g
  extends k<aif>
{
  private static final String TAG = "MicroMsg.CgiGetCardPkgMchInfo";
  public static final g.a kpy;
  
  static
  {
    AppMethodBeat.i(89168);
    kpy = new g.a((byte)0);
    TAG = "MicroMsg.CgiGetCardPkgMchInfo";
    AppMethodBeat.o(89168);
  }
  
  public g(String paramString, long paramLong, double paramDouble1, double paramDouble2, int paramInt)
  {
    AppMethodBeat.i(89167);
    aie localaie = new aie();
    aif localaif = new aif();
    localaie.wEJ = paramString;
    localaie.wFa = paramLong;
    localaie.latitude = paramDouble1;
    localaie.longitude = paramDouble2;
    localaie.wFN = paramInt;
    a((buy)localaie, (bvk)localaif, 2769, "/cgi-bin/mmpay-bin/mktgetcardpkgmchinfo");
    ab.i(TAG, "marchantid: %s, lastReceiveTime: %s, lat: %s, long: %s", new Object[] { paramString, Long.valueOf(paramLong), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    AppMethodBeat.o(89167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.g
 * JD-Core Version:    0.7.0.1
 */