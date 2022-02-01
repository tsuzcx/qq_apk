package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends e
  implements m
{
  public d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, e.a<e> parama)
  {
    super(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, parama);
  }
  
  protected final d.a id(boolean paramBoolean)
  {
    AppMethodBeat.i(227219);
    Log.d("MicroMsg.webview.NetSceneJSOperateImportantWxData", "getReqRespBuidler");
    d.a locala = new d.a();
    locala.iLN = new ceu();
    locala.iLO = new cev();
    locala.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata-vip";
    locala.funcId = 1912;
    locala.iLP = 0;
    locala.respCmdId = 0;
    AppMethodBeat.o(227219);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.d
 * JD-Core Version:    0.7.0.1
 */