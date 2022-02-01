package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends e
  implements k
{
  public d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, e.a<e> parama)
  {
    super(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, parama);
  }
  
  protected final b.a btd()
  {
    AppMethodBeat.i(47752);
    ad.d("MicroMsg.webview.NetSceneJSOperateImportantWxData", "getReqRespBuidler");
    b.a locala = new b.a();
    locala.hNM = new brg();
    locala.hNN = new brh();
    locala.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata-vip";
    locala.funcId = 1912;
    locala.hNO = 0;
    locala.respCmdId = 0;
    AppMethodBeat.o(47752);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.d
 * JD-Core Version:    0.7.0.1
 */