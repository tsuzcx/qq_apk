package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.sdk.platformtools.ad;

public class e
  extends n
  implements k
{
  private g gbr;
  private a<e> kUl;
  public final com.tencent.mm.al.b rr;
  
  private e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(47753);
    ad.i("MicroMsg.webview.NetSceneJSOperateWxData", "<init> hash[%d] appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.rr = bik().atI();
    bje localbje = (bje)this.rr.gUS.gUX;
    localbje.hnC = paramString1;
    if (paramString2.getBytes() == null) {}
    for (paramString1 = new byte[0];; paramString1 = paramString2.getBytes())
    {
      localbje.mAx = new com.tencent.mm.bx.b(paramString1);
      localbje.DGK = paramString3;
      localbje.DGx = paramInt1;
      localbje.DGw = paramInt3;
      localbje.Dbx = paramInt2;
      if (paramInt4 > 0)
      {
        localbje.DGy = new dvc();
        localbje.DGy.scene = paramInt4;
      }
      AppMethodBeat.o(47753);
      return;
    }
  }
  
  public e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a<e> parama)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4);
    this.kUl = parama;
  }
  
  protected b.a bik()
  {
    AppMethodBeat.i(47754);
    ad.d("MicroMsg.webview.NetSceneJSOperateWxData", "getReqRespBuidler");
    b.a locala = new b.a();
    locala.gUU = new bje();
    locala.gUV = new bjf();
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
    ad.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene hash=%d, funcid=%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.rr.getType()) });
    this.gbr = paramg;
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
    ad.i("MicroMsg.webview.NetSceneJSOperateWxData", "onGYNetEnd, hash[%d] errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gbr != null) {
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.kUl != null) {
      this.kUl.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(47756);
  }
  
  public final void tj(int paramInt)
  {
    AppMethodBeat.i(47755);
    bje localbje = (bje)this.rr.gUS.gUX;
    if (localbje.DGy == null) {
      localbje.DGy = new dvc();
    }
    localbje.DGy.EJj = paramInt;
    AppMethodBeat.o(47755);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.e
 * JD-Core Version:    0.7.0.1
 */