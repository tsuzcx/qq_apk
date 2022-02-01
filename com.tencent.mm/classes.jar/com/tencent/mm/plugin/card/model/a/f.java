package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "marchantId", "", "lastReceiveTime", "", "latitude", "", "longitude", "sortRule", "", "scene", "(Ljava/lang/String;JDDII)V", "Companion", "plugin-card_release"})
public final class f
  extends j<auq>
{
  private static final String TAG = "MicroMsg.CgiGetCardPkgMchInfo";
  public static final f.a nXO;
  
  static
  {
    AppMethodBeat.i(112394);
    nXO = new f.a((byte)0);
    TAG = "MicroMsg.CgiGetCardPkgMchInfo";
    AppMethodBeat.o(112394);
  }
  
  public f(String paramString, long paramLong, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206242);
    aup localaup = new aup();
    auq localauq = new auq();
    localaup.Eja = paramString;
    localaup.Ejn = paramLong;
    localaup.latitude = paramDouble1;
    localaup.longitude = paramDouble2;
    localaup.Ekd = paramInt1;
    localaup.scene = paramInt2;
    a((cpx)localaup, (cqk)localauq, 2769, "/cgi-bin/mmpay-bin/mktgetcardpkgmchinfo");
    ac.i(TAG, "marchantid: %s, lastReceiveTime: %s, lat: %s, long: %s", new Object[] { paramString, Long.valueOf(paramLong), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    AppMethodBeat.o(206242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.f
 * JD-Core Version:    0.7.0.1
 */