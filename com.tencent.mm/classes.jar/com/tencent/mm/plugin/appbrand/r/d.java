package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.cno;
import com.tencent.mm.protocal.protobuf.cnp;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends e
{
  public d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, int paramInt5, e.a<e> parama)
  {
    super(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramString4, paramInt5, parama);
  }
  
  protected final d.a iX(boolean paramBoolean)
  {
    AppMethodBeat.i(279083);
    Log.d("MicroMsg.webview.NetSceneJSOperateImportantWxData", "getReqRespBuidler");
    d.a locala = new d.a();
    locala.lBU = new cno();
    locala.lBV = new cnp();
    locala.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata-vip";
    locala.funcId = 1912;
    locala.lBW = 0;
    locala.respCmdId = 0;
    AppMethodBeat.o(279083);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.d
 * JD-Core Version:    0.7.0.1
 */