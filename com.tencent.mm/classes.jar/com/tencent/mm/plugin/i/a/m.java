package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/findersdk/api/NetSceneFinderGetUser;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "urlList", "", "", "(Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "finder-sdk_release"})
public final class m
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g callback;
  private b qYo;
  
  public m(List<String> paramList)
  {
    AppMethodBeat.i(168877);
    this.TAG = "Finder.NetSceneFinderGetUser";
    b.a locala = new b.a();
    alk localalk = new alk();
    localalk.qXM.addAll((Collection)paramList);
    paramList = new all();
    locala.c((a)localalk);
    locala.d((a)paramList);
    locala.op(getType());
    locala.Am("/cgi-bin/micromsg-bin/findergetuser");
    this.qYo = locala.aAz();
    AppMethodBeat.o(168877);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(168875);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.qYo, (com.tencent.mm.network.k)this);
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
    ac.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fOy();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(168876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.m
 * JD-Core Version:    0.7.0.1
 */