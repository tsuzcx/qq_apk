package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderQRCode;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "(Ljava/lang/String;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getQRCodeBitmap", "Landroid/graphics/Bitmap;", "getQRCodeUrl", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ay
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  public b rJA;
  
  public ay(String paramString)
  {
    AppMethodBeat.i(165267);
    this.TAG = "Finder.NetSceneFinderQRCode";
    b.a locala = new b.a();
    aqp localaqp = new aqp();
    localaqp.username = paramString;
    paramString = v.rIR;
    localaqp.Glv = v.cxY();
    locala.c((a)localaqp);
    locala.d((a)new aqq());
    locala.oP(getType());
    locala.Dl("/cgi-bin/micromsg-bin/finderqrcode");
    this.rJA = locala.aDC();
    AppMethodBeat.o(165267);
  }
  
  public final String cyK()
  {
    AppMethodBeat.i(165265);
    Object localObject = this.rJA;
    if (localObject != null) {}
    for (localObject = ((b)localObject).aEF(); localObject == null; localObject = null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderQRCodeResponse");
      AppMethodBeat.o(165265);
      throw ((Throwable)localObject);
    }
    localObject = ((aqq)localObject).FAE;
    AppMethodBeat.o(165265);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(165264);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rJA, (k)this);
    AppMethodBeat.o(165264);
    return i;
  }
  
  public final int getType()
  {
    return 258;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165266);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ay
 * JD-Core Version:    0.7.0.1
 */