package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderQRCode;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "(Ljava/lang/String;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getQRCodeBitmap", "Landroid/graphics/Bitmap;", "getQRCodeUrl", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class az
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  public b rRO;
  
  public az(String paramString)
  {
    AppMethodBeat.i(165267);
    this.TAG = "Finder.NetSceneFinderQRCode";
    b.a locala = new b.a();
    are localare = new are();
    localare.username = paramString;
    paramString = v.rRb;
    localare.GDR = v.czz();
    locala.c((a)localare);
    locala.d((a)new arf());
    locala.oS(getType());
    locala.DN("/cgi-bin/micromsg-bin/finderqrcode");
    this.rRO = locala.aDS();
    AppMethodBeat.o(165267);
  }
  
  public final String cAl()
  {
    AppMethodBeat.i(165265);
    Object localObject = this.rRO;
    if (localObject != null) {}
    for (localObject = ((b)localObject).aEV(); localObject == null; localObject = null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderQRCodeResponse");
      AppMethodBeat.o(165265);
      throw ((Throwable)localObject);
    }
    localObject = ((arf)localObject).FTa;
    AppMethodBeat.o(165265);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(165264);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rRO, (k)this);
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
    ae.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gkB();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.az
 * JD-Core Version:    0.7.0.1
 */