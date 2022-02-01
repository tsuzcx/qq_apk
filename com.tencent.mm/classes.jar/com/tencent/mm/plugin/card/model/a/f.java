package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "marchantId", "", "lastReceiveTime", "", "latitude", "", "longitude", "sortRule", "", "scene", "(Ljava/lang/String;JDDII)V", "Companion", "plugin-card_release"})
public final class f
  extends j<arm>
{
  private static final String TAG = "MicroMsg.CgiGetCardPkgMchInfo";
  public static final a nuO;
  
  static
  {
    AppMethodBeat.i(112394);
    nuO = new a((byte)0);
    TAG = "MicroMsg.CgiGetCardPkgMchInfo";
    AppMethodBeat.o(112394);
  }
  
  public f(String paramString, long paramLong, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192668);
    arl localarl = new arl();
    arm localarm = new arm();
    localarl.CQp = paramString;
    localarl.CQC = paramLong;
    localarl.latitude = paramDouble1;
    localarl.longitude = paramDouble2;
    localarl.CRs = paramInt1;
    localarl.scene = paramInt2;
    a((ckq)localarl, (cld)localarm, 2769, "/cgi-bin/mmpay-bin/mktgetcardpkgmchinfo");
    ad.i(TAG, "marchantid: %s, lastReceiveTime: %s, lat: %s, long: %s", new Object[] { paramString, Long.valueOf(paramLong), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    AppMethodBeat.o(192668);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.f
 * JD-Core Version:    0.7.0.1
 */