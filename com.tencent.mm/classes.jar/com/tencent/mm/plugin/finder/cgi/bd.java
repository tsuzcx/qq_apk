package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderTopicSuggest;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "query", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getQuery", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderTopicSuggestResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bd
  extends n
  implements k
{
  private static final String TAG = "Finder.NetSceneFinderTopicSuggest";
  public static final a rSi;
  private f callback;
  public final String query;
  public b rr;
  
  static
  {
    AppMethodBeat.i(165281);
    rSi = new a((byte)0);
    TAG = "Finder.NetSceneFinderTopicSuggest";
    AppMethodBeat.o(165281);
  }
  
  public bd(String paramString)
  {
    AppMethodBeat.i(165280);
    this.query = paramString;
    paramString = new b.a();
    paramString.oS(getType());
    Object localObject = new asx();
    v localv = v.rRb;
    ((asx)localObject).GGl = v.czz();
    ((asx)localObject).query = this.query;
    paramString.c((a)localObject);
    localObject = new asy();
    ((asy)localObject).setBaseResponse(new BaseResponse());
    paramString.d((a)localObject);
    paramString.DN("/cgi-bin/micromsg-bin/findertopicsuggest");
    paramString = paramString.aDS();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ae.i(TAG, "NetSceneFinderTopicSuggest init " + this.query);
    AppMethodBeat.o(165280);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(165278);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165278);
    return i;
  }
  
  public final int getType()
  {
    return 3875;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165279);
    ae.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gkB();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165279);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderTopicSuggest$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bd
 * JD-Core Version:    0.7.0.1
 */