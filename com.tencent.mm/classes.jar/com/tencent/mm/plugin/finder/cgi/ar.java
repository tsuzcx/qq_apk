package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderQRCode;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "(Ljava/lang/String;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getQRCodeBitmap", "Landroid/graphics/Bitmap;", "getQRCodeUrl", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ar
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g callback;
  public b qYo;
  
  public ar(String paramString)
  {
    AppMethodBeat.i(165267);
    this.TAG = "Finder.NetSceneFinderQRCode";
    b.a locala = new b.a();
    and localand = new and();
    localand.username = paramString;
    paramString = q.qXH;
    localand.EDL = q.csi();
    locala.c((a)localand);
    locala.d((a)new ane());
    locala.op(getType());
    locala.Am("/cgi-bin/micromsg-bin/finderqrcode");
    this.qYo = locala.aAz();
    AppMethodBeat.o(165267);
  }
  
  public final String csP()
  {
    AppMethodBeat.i(165265);
    Object localObject = this.qYo;
    if (localObject != null) {}
    for (localObject = ((b)localObject).aBD(); localObject == null; localObject = null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderQRCodeResponse");
      AppMethodBeat.o(165265);
      throw ((Throwable)localObject);
    }
    localObject = ((ane)localObject).DVj;
    AppMethodBeat.o(165265);
    return localObject;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165264);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.qYo, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165264);
    return i;
  }
  
  public final int getType()
  {
    return 258;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165266);
    ac.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fOy();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ar
 * JD-Core Version:    0.7.0.1
 */