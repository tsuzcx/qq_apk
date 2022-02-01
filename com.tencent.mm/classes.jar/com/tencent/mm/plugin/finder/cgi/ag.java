package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.protocal.protobuf.anf;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetBlackList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getBlackList", "", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "getLastBuf", "getType", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ag
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  public com.tencent.mm.al.b rr;
  
  public ag(com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(165216);
    this.TAG = "Finder.NetSceneFinderGetBlackList";
    b.a locala = new b.a();
    locala.oP(getType());
    ane localane = new ane();
    localane.rTn = u.aAu();
    localane.sbF = paramb;
    paramb = v.rIR;
    localane.Glv = v.cxY();
    locala.c((a)localane);
    locala.d((a)new anf());
    locala.Dl("/cgi-bin/micromsg-bin/findergetblacklist");
    paramb = locala.aDC();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ad.i(this.TAG, "NetSceneFinderGetBlackList");
    AppMethodBeat.o(165216);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(165214);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165214);
    return i;
  }
  
  public final int getType()
  {
    return 3717;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165215);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ag
 * JD-Core Version:    0.7.0.1
 */