package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.deg;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends e
{
  public d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, int paramInt5, boolean paramBoolean, e.a<e> parama)
  {
    super(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramString4, paramInt5, paramBoolean, parama);
  }
  
  protected final c.a kf(boolean paramBoolean)
  {
    AppMethodBeat.i(319809);
    Log.d("MicroMsg.webview.NetSceneJSOperateImportantWxData", "getReqRespBuidler");
    c.a locala = new c.a();
    locala.otE = new deg();
    locala.otF = new deh();
    locala.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata-vip";
    locala.funcId = 1912;
    locala.otG = 0;
    locala.respCmdId = 0;
    AppMethodBeat.o(319809);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.d
 * JD-Core Version:    0.7.0.1
 */