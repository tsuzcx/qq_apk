package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "marchantId", "", "lastReceiveTime", "", "latitude", "", "longitude", "sortRule", "", "scene", "(Ljava/lang/String;JDDII)V", "Companion", "plugin-card_release"})
public final class f
  extends j<bko>
{
  private static final String TAG = "MicroMsg.CgiGetCardPkgMchInfo";
  public static final a pVt;
  
  static
  {
    AppMethodBeat.i(112394);
    pVt = new a((byte)0);
    TAG = "MicroMsg.CgiGetCardPkgMchInfo";
    AppMethodBeat.o(112394);
  }
  
  public f(String paramString, long paramLong, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201371);
    bkn localbkn = new bkn();
    bko localbko = new bko();
    localbkn.Ldn = paramString;
    localbkn.LdA = paramLong;
    localbkn.latitude = paramDouble1;
    localbkn.longitude = paramDouble2;
    localbkn.Leq = paramInt1;
    localbkn.scene = paramInt2;
    a((dop)localbkn, (dpc)localbko, 2769, "/cgi-bin/mmpay-bin/mktgetcardpkgmchinfo");
    Log.i(TAG, "marchantid: %s, lastReceiveTime: %s, lat: %s, long: %s", new Object[] { paramString, Long.valueOf(paramLong), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    AppMethodBeat.o(201371);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.f
 * JD-Core Version:    0.7.0.1
 */