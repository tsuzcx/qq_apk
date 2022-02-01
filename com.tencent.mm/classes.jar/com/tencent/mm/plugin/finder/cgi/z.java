package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.akr;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderQRCode;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "(Ljava/lang/String;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getQRCodeBitmap", "Landroid/graphics/Bitmap;", "getQRCodeUrl", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class z
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g callback;
  public b qpm;
  
  public z(String paramString)
  {
    AppMethodBeat.i(165267);
    this.TAG = "Finder.NetSceneFinderQRCode";
    b.a locala = new b.a();
    akr localakr = new akr();
    localakr.username = paramString;
    paramString = am.KJy;
    localakr.Dkw = am.fRS();
    locala.c((a)localakr);
    locala.d((a)new aks());
    locala.nB(getType());
    locala.wg("/cgi-bin/micromsg-bin/finderqrcode");
    this.qpm = locala.atI();
    AppMethodBeat.o(165267);
  }
  
  public final String ckW()
  {
    AppMethodBeat.i(165265);
    Object localObject = this.qpm;
    if (localObject != null) {}
    for (localObject = ((b)localObject).auM(); localObject == null; localObject = null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderQRCodeResponse");
      AppMethodBeat.o(165265);
      throw ((Throwable)localObject);
    }
    localObject = ((aks)localObject).CCM;
    AppMethodBeat.o(165265);
    return localObject;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165264);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.qpm, (com.tencent.mm.network.k)this);
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
        d.g.b.k.fvU();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.z
 * JD-Core Version:    0.7.0.1
 */