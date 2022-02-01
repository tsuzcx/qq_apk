package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.sdk.platformtools.ac;

public class e
  extends n
  implements k
{
  private g gfX;
  private a<e> lvV;
  public final com.tencent.mm.ak.b rr;
  
  private e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(47753);
    ac.i("MicroMsg.webview.NetSceneJSOperateWxData", "<init> hash[%d] appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.rr = bpe().aAz();
    bmw localbmw = (bmw)this.rr.hvr.hvw;
    localbmw.hOf = paramString1;
    if (paramString2.getBytes() == null) {}
    for (paramString1 = new byte[0];; paramString1 = paramString2.getBytes())
    {
      localbmw.ncy = new com.tencent.mm.bw.b(paramString1);
      localbmw.Fce = paramString3;
      localbmw.FbR = paramInt1;
      localbmw.FbQ = paramInt3;
      localbmw.EuD = paramInt2;
      if (paramInt4 > 0)
      {
        localbmw.FbS = new eat();
        localbmw.FbS.scene = paramInt4;
      }
      AppMethodBeat.o(47753);
      return;
    }
  }
  
  public e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a<e> parama)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4);
    this.lvV = parama;
  }
  
  protected b.a bpe()
  {
    AppMethodBeat.i(47754);
    ac.d("MicroMsg.webview.NetSceneJSOperateWxData", "getReqRespBuidler");
    b.a locala = new b.a();
    locala.hvt = new bmw();
    locala.hvu = new bmx();
    locala.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata";
    locala.funcId = 1133;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    AppMethodBeat.o(47754);
    return locala;
  }
  
  public int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(47757);
    ac.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene hash=%d, funcid=%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.rr.getType()) });
    this.gfX = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(47757);
    return i;
  }
  
  public int getType()
  {
    return 1133;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(47756);
    ac.i("MicroMsg.webview.NetSceneJSOperateWxData", "onGYNetEnd, hash[%d] errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gfX != null) {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.lvV != null) {
      this.lvV.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(47756);
  }
  
  public final void ua(int paramInt)
  {
    AppMethodBeat.i(47755);
    bmw localbmw = (bmw)this.rr.hvr.hvw;
    if (localbmw.FbS == null) {
      localbmw.FbS = new eat();
    }
    localbmw.FbS.Ggv = paramInt;
    AppMethodBeat.o(47755);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.e
 * JD-Core Version:    0.7.0.1
 */