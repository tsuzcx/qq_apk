package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderTopicSuggest;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "query", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getQuery", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderTopicSuggestResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class au
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "Finder.NetSceneFinderTopicSuggest";
  public static final au.a qYE;
  private g callback;
  public final String query;
  public b rr;
  
  static
  {
    AppMethodBeat.i(165281);
    qYE = new au.a((byte)0);
    TAG = "Finder.NetSceneFinderTopicSuggest";
    AppMethodBeat.o(165281);
  }
  
  public au(String paramString)
  {
    AppMethodBeat.i(165280);
    this.query = paramString;
    paramString = new b.a();
    paramString.op(getType());
    Object localObject = new aor();
    q localq = q.qXH;
    ((aor)localObject).EEZ = q.csi();
    ((aor)localObject).query = this.query;
    paramString.c((a)localObject);
    localObject = new aos();
    ((aos)localObject).setBaseResponse(new BaseResponse());
    paramString.d((a)localObject);
    paramString.Am("/cgi-bin/micromsg-bin/findertopicsuggest");
    paramString = paramString.aAz();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ac.i(TAG, "NetSceneFinderTopicSuggest init " + this.query);
    AppMethodBeat.o(165280);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165278);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165278);
    return i;
  }
  
  public final int getType()
  {
    return 3875;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165279);
    ac.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fOy();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.au
 * JD-Core Version:    0.7.0.1
 */