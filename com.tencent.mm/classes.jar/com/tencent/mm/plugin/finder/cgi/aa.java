package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneDeleteFinderObject;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "objectId", "", "objectNonceId", "(Ljava/lang/String;JLjava/lang/String;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getDelId", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class aa
  extends n
  implements k
{
  private String TAG;
  private f callback;
  public long rIZ;
  private com.tencent.mm.al.b rr;
  
  public aa(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(165207);
    this.TAG = "Finder.NetSceneDeleteFinderObject";
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.Dl("/cgi-bin/micromsg-bin/finderdelfeed");
    locala.oP(getType());
    ami localami = new ami();
    localami.id = paramLong;
    localami.objectNonceId = paramString2;
    localami.GlV = paramString1;
    paramString1 = v.rIR;
    localami.Glv = v.cxY();
    locala.c((com.tencent.mm.bx.a)localami);
    locala.d((com.tencent.mm.bx.a)new amj());
    paramString1 = locala.aDC();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    this.rIZ = paramLong;
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
    ad.i(this.TAG, "errType " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
      if (com.tencent.mm.plugin.finder.storage.logic.b.a.xh(this.rIZ))
      {
        paramq = new hb();
        paramq.dtu.id = this.rIZ;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)paramq);
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
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aa
 * JD-Core Version:    0.7.0.1
 */