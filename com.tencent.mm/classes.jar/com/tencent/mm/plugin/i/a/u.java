package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/findersdk/api/NetSceneFinderGetUser;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "urlList", "", "", "(Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "finder-sdk_release"})
public final class u
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  private b rRO;
  
  public u(List<String> paramList)
  {
    AppMethodBeat.i(168877);
    this.TAG = "Finder.NetSceneFinderGetUser";
    b.a locala = new b.a();
    apc localapc = new apc();
    localapc.rRk.addAll((Collection)paramList);
    paramList = new apd();
    locala.c((a)localapc);
    locala.d((a)paramList);
    locala.oS(getType());
    locala.DN("/cgi-bin/micromsg-bin/findergetuser");
    this.rRO = locala.aDS();
    AppMethodBeat.o(168877);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(168875);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rRO, (k)this);
    AppMethodBeat.o(168875);
    return i;
  }
  
  public final int getType()
  {
    return 3512;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(168876);
    ae.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gkB();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(168876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.u
 * JD-Core Version:    0.7.0.1
 */