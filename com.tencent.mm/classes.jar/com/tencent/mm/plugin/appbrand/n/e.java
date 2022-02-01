package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsa;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.sdk.platformtools.ae;

public class e
  extends n
  implements k
{
  private f gCo;
  private a<e> lZL;
  public final com.tencent.mm.ak.b rr;
  
  private e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(47753);
    ae.i("MicroMsg.webview.NetSceneJSOperateWxData", "<init> hash[%d] appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.rr = btO().aDS();
    bsa localbsa = (bsa)this.rr.hQD.hQJ;
    localbsa.ikm = paramString1;
    if (paramString2.getBytes() == null) {}
    for (paramString1 = new byte[0];; paramString1 = paramString2.getBytes())
    {
      localbsa.nIq = new com.tencent.mm.bw.b(paramString1);
      localbsa.Hff = paramString3;
      localbsa.HeR = paramInt1;
      localbsa.HeQ = paramInt3;
      localbsa.GuE = paramInt2;
      if (paramInt4 > 0)
      {
        localbsa.HeS = new eio();
        localbsa.HeS.scene = paramInt4;
      }
      AppMethodBeat.o(47753);
      return;
    }
  }
  
  public e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a<e> parama)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4);
    this.lZL = parama;
  }
  
  protected b.a btO()
  {
    AppMethodBeat.i(47754);
    ae.d("MicroMsg.webview.NetSceneJSOperateWxData", "getReqRespBuidler");
    b.a locala = new b.a();
    locala.hQF = new bsa();
    locala.hQG = new bsb();
    locala.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata";
    locala.funcId = 1133;
    locala.hQH = 0;
    locala.respCmdId = 0;
    AppMethodBeat.o(47754);
    return locala;
  }
  
  public int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(47757);
    ae.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene hash=%d, funcid=%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.rr.getType()) });
    this.gCo = paramf;
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
    ae.i("MicroMsg.webview.NetSceneJSOperateWxData", "onGYNetEnd, hash[%d] errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gCo != null) {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.lZL != null) {
      this.lZL.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(47756);
  }
  
  public final void uK(int paramInt)
  {
    AppMethodBeat.i(47755);
    bsa localbsa = (bsa)this.rr.hQD.hQJ;
    if (localbsa.HeS == null) {
      localbsa.HeS = new eio();
    }
    localbsa.HeS.IlP = paramInt;
    AppMethodBeat.o(47755);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.e
 * JD-Core Version:    0.7.0.1
 */