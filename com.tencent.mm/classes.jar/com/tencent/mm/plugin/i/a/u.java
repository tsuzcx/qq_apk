package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/findersdk/api/NetSceneFinderGetUser;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "urlList", "", "", "(Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "finder-sdk_release"})
public final class u
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  private b rJA;
  
  public u(List<String> paramList)
  {
    AppMethodBeat.i(168877);
    this.TAG = "Finder.NetSceneFinderGetUser";
    b.a locala = new b.a();
    aop localaop = new aop();
    localaop.rIW.addAll((Collection)paramList);
    paramList = new aoq();
    locala.c((a)localaop);
    locala.d((a)paramList);
    locala.oP(getType());
    locala.Dl("/cgi-bin/micromsg-bin/findergetuser");
    this.rJA = locala.aDC();
    AppMethodBeat.o(168877);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(168875);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rJA, (k)this);
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
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(168876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.u
 * JD-Core Version:    0.7.0.1
 */