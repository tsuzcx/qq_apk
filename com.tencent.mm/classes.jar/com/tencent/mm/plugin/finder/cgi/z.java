package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetBlackList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getBlackList", "", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "getLastBuf", "getType", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class z
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g callback;
  public com.tencent.mm.ak.b rr;
  
  public z(com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(165216);
    this.TAG = "Finder.NetSceneFinderGetBlackList";
    b.a locala = new b.a();
    locala.op(getType());
    akf localakf = new akf();
    localakf.rfC = u.axE();
    localakf.rmJ = paramb;
    paramb = q.qXH;
    localakf.EDL = q.csi();
    locala.c((a)localakf);
    locala.d((a)new akg());
    locala.Am("/cgi-bin/micromsg-bin/findergetblacklist");
    paramb = locala.aAz();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ac.i(this.TAG, "NetSceneFinderGetBlackList");
    AppMethodBeat.o(165216);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165214);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165214);
    return i;
  }
  
  public final int getType()
  {
    return 3717;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165215);
    ac.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fOy();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.z
 * JD-Core Version:    0.7.0.1
 */