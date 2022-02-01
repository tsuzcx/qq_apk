package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetBlackList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getBlackList", "", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "getLastBuf", "getType", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ah
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  public com.tencent.mm.ak.b rr;
  
  public ah(com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(165216);
    this.TAG = "Finder.NetSceneFinderGetBlackList";
    b.a locala = new b.a();
    locala.oS(getType());
    anr localanr = new anr();
    localanr.sbR = com.tencent.mm.model.v.aAK();
    localanr.skw = paramb;
    paramb = v.rRb;
    localanr.GDR = v.czz();
    locala.c((a)localanr);
    locala.d((a)new ans());
    locala.DN("/cgi-bin/micromsg-bin/findergetblacklist");
    paramb = locala.aDS();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ae.i(this.TAG, "NetSceneFinderGetBlackList");
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
    ae.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gkB();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ah
 * JD-Core Version:    0.7.0.1
 */