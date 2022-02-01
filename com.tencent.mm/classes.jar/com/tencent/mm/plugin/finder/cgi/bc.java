package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderTopicSuggest;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "query", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getQuery", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderTopicSuggestResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bc
  extends n
  implements k
{
  private static final String TAG = "Finder.NetSceneFinderTopicSuggest";
  public static final a rJU;
  private f callback;
  public final String query;
  public b rr;
  
  static
  {
    AppMethodBeat.i(165281);
    rJU = new a((byte)0);
    TAG = "Finder.NetSceneFinderTopicSuggest";
    AppMethodBeat.o(165281);
  }
  
  public bc(String paramString)
  {
    AppMethodBeat.i(165280);
    this.query = paramString;
    paramString = new b.a();
    paramString.oP(getType());
    Object localObject = new asi();
    v localv = v.rIR;
    ((asi)localObject).Gnf = v.cxY();
    ((asi)localObject).query = this.query;
    paramString.c((a)localObject);
    localObject = new asj();
    ((asj)localObject).setBaseResponse(new BaseResponse());
    paramString.d((a)localObject);
    paramString.Dl("/cgi-bin/micromsg-bin/findertopicsuggest");
    paramString = paramString.aDC();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ad.i(TAG, "NetSceneFinderTopicSuggest init " + this.query);
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
    ad.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165279);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderTopicSuggest$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bc
 * JD-Core Version:    0.7.0.1
 */