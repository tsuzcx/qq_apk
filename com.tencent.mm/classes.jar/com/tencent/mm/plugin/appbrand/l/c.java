package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends m
  implements k
{
  private f eGj;
  private c.a<c> isk;
  public final com.tencent.mm.ai.b rr;
  
  private c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(132312);
    ab.i("MicroMsg.webview.NetSceneJSOperateWxData", "NetSceneJSLogin doScene appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new axy();
    ((b.a)localObject).fsY = new axz();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-operatewxdata";
    ((b.a)localObject).funcId = 1133;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (axy)this.rr.fsV.fta;
    ((axy)localObject).fKw = paramString1;
    if (paramString2.getBytes() == null) {}
    for (paramString1 = new byte[0];; paramString1 = paramString2.getBytes())
    {
      ((axy)localObject).jJh = new com.tencent.mm.bv.b(paramString1);
      ((axy)localObject).xnc = paramString3;
      ((axy)localObject).xmQ = paramInt1;
      ((axy)localObject).xmP = paramInt2;
      if (paramInt3 > 0)
      {
        ((axy)localObject).xmR = new dam();
        ((axy)localObject).xmR.scene = paramInt3;
      }
      AppMethodBeat.o(132312);
      return;
    }
  }
  
  public c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, c.a<c> parama)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3);
    this.isk = parama;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(132315);
    ab.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene");
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(132315);
    return i;
  }
  
  public final int getType()
  {
    return 1133;
  }
  
  public final void oU(int paramInt)
  {
    AppMethodBeat.i(132313);
    axy localaxy = (axy)this.rr.fsV.fta;
    if (localaxy.xmR == null) {
      localaxy.xmR = new dam();
    }
    localaxy.xmR.ygT = paramInt;
    AppMethodBeat.o(132313);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132314);
    ab.i("MicroMsg.webview.NetSceneJSOperateWxData", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.eGj != null) {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.isk != null) {
      this.isk.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(132314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.c
 * JD-Core Version:    0.7.0.1
 */