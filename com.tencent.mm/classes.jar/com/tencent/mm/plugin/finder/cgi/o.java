package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetBlackList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getBlackList", "", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "getLastBuf", "getType", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class o
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g callback;
  public com.tencent.mm.al.b rr;
  
  public o(com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(165216);
    this.TAG = "Finder.NetSceneFinderGetBlackList";
    b.a locala = new b.a();
    locala.nB(getType());
    ait localait = new ait();
    localait.finderUsername = u.aqO();
    localait.qHz = paramb;
    paramb = am.KJy;
    localait.Dkw = am.fRS();
    locala.c((a)localait);
    locala.d((a)new aiu());
    locala.wg("/cgi-bin/micromsg-bin/findergetblacklist");
    paramb = locala.atI();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ad.i(this.TAG, "NetSceneFinderGetBlackList");
    AppMethodBeat.o(165216);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165214);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
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
        d.g.b.k.fvU();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.o
 * JD-Core Version:    0.7.0.1
 */