package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends e
  implements k
{
  public d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, e.a<e> parama)
  {
    super(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, parama);
  }
  
  protected final b.a bpe()
  {
    AppMethodBeat.i(47752);
    ac.d("MicroMsg.webview.NetSceneJSOperateImportantWxData", "getReqRespBuidler");
    b.a locala = new b.a();
    locala.hvt = new bmw();
    locala.hvu = new bmx();
    locala.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata-vip";
    locala.funcId = 1912;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    AppMethodBeat.o(47752);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.d
 * JD-Core Version:    0.7.0.1
 */