package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneDeleteFinderObject;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "objectId", "", "objectNonceId", "(Ljava/lang/String;JLjava/lang/String;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getDelId", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ab
  extends n
  implements k
{
  private String TAG;
  private f callback;
  public long rRn;
  private com.tencent.mm.ak.b rr;
  
  public ab(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(165207);
    this.TAG = "Finder.NetSceneDeleteFinderObject";
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.DN("/cgi-bin/micromsg-bin/finderdelfeed");
    locala.oS(getType());
    amu localamu = new amu();
    localamu.id = paramLong;
    localamu.objectNonceId = paramString2;
    localamu.GEX = paramString1;
    paramString1 = v.rRb;
    localamu.GDR = v.czz();
    locala.c((com.tencent.mm.bw.a)localamu);
    locala.d((com.tencent.mm.bw.a)new amv());
    paramString1 = locala.aDS();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    this.rRn = paramLong;
    AppMethodBeat.o(165207);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(165205);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165205);
    return i;
  }
  
  public final int getType()
  {
    return 3627;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165206);
    ae.i(this.TAG, "errType " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
      if (com.tencent.mm.plugin.finder.storage.logic.b.a.xy(this.rRn))
      {
        paramq = new hc();
        paramq.duz.id = this.rRn;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)paramq);
      }
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(165206);
      return;
    }
    AppMethodBeat.o(165206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ab
 * JD-Core Version:    0.7.0.1
 */