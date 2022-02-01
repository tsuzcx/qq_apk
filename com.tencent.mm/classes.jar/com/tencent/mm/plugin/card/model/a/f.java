package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ayn;
import com.tencent.mm.protocal.protobuf.ayo;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "marchantId", "", "lastReceiveTime", "", "latitude", "", "longitude", "sortRule", "", "scene", "(Ljava/lang/String;JDDII)V", "Companion", "plugin-card_release"})
public final class f
  extends j<ayo>
{
  private static final String TAG = "MicroMsg.CgiGetCardPkgMchInfo";
  public static final a oBi;
  
  static
  {
    AppMethodBeat.i(112394);
    oBi = new a((byte)0);
    TAG = "MicroMsg.CgiGetCardPkgMchInfo";
    AppMethodBeat.o(112394);
  }
  
  public f(String paramString, long paramLong, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215437);
    ayn localayn = new ayn();
    ayo localayo = new ayo();
    localayn.FQk = paramString;
    localayn.FQx = paramLong;
    localayn.latitude = paramDouble1;
    localayn.longitude = paramDouble2;
    localayn.FRm = paramInt1;
    localayn.scene = paramInt2;
    a((cvc)localayn, (cvp)localayo, 2769, "/cgi-bin/mmpay-bin/mktgetcardpkgmchinfo");
    ad.i(TAG, "marchantid: %s, lastReceiveTime: %s, lat: %s, long: %s", new Object[] { paramString, Long.valueOf(paramLong), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    AppMethodBeat.o(215437);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.f
 * JD-Core Version:    0.7.0.1
 */