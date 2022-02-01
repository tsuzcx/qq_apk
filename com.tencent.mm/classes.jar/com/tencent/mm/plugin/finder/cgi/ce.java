package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bay;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderQRCode;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "(Ljava/lang/String;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getQRCodeBitmap", "Landroid/graphics/Bitmap;", "getQRCodeUrl", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ce
  extends ax
  implements m
{
  private final String TAG;
  private i callback;
  public d tvD;
  
  public ce(String paramString)
  {
    AppMethodBeat.i(165267);
    this.TAG = "Finder.NetSceneFinderQRCode";
    d.a locala = new d.a();
    bay localbay = new bay();
    localbay.username = paramString;
    paramString = am.tuw;
    localbay.uli = am.cXY();
    locala.c((a)localbay);
    locala.d((a)new baz());
    locala.sG(getType());
    locala.MB("/cgi-bin/micromsg-bin/finderqrcode");
    this.tvD = locala.aXF();
    AppMethodBeat.o(165267);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242500);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(242500);
  }
  
  public final String cZd()
  {
    AppMethodBeat.i(165265);
    Object localObject = this.tvD;
    if (localObject != null) {}
    for (localObject = ((d)localObject).aYK(); localObject == null; localObject = null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderQRCodeResponse");
      AppMethodBeat.o(165265);
      throw ((Throwable)localObject);
    }
    localObject = ((baz)localObject).KMJ;
    AppMethodBeat.o(165265);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(165264);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.tvD, (m)this);
    AppMethodBeat.o(165264);
    return i;
  }
  
  public final int getType()
  {
    return 258;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ce
 * JD-Core Version:    0.7.0.1
 */