package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.dyv;
import com.tencent.mm.protocal.protobuf.dyw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.l;
import d.v;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionedFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "username", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "kotlin.jvm.PlatformType", "getTotalCount", "", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class au
  extends ap
{
  private final String TAG;
  private com.tencent.mm.al.g callback;
  public int pullType;
  public com.tencent.mm.al.b rr;
  private final String username;
  
  public au(String paramString, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(197317);
    this.username = paramString;
    this.TAG = "Finder.NetSceneFinderGetMentionedFeed";
    paramString = new b.a();
    paramString.nB(getType());
    dyv localdyv = new dyv();
    localdyv.Dls = this.username;
    localdyv.Dlt = paramb;
    localdyv.Lxt = new aht();
    paramb = localdyv.Lxt;
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    paramb.Dko = locale.afk().getInt(ae.a.Fxg, 0);
    paramString.c((a)localdyv);
    paramString.nB(getType());
    paramString.d((a)new dyw());
    paramString.wg("/cgi-bin/micromsg-bin/findergetmentionedlist");
    paramString = paramString.atI();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ad.i(this.TAG, "NetSceneFinderGetMentionedFeed init: " + this.username);
    AppMethodBeat.o(197317);
  }
  
  public final List<FinderObject> ckL()
  {
    AppMethodBeat.i(197316);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
      AppMethodBeat.o(197316);
      throw ((Throwable)localObject);
    }
    localObject = ((dyw)localObject).object;
    d.g.b.k.g(localObject, "(rr.responseProtoBuf as …nedListResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(197316);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(197314);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(197314);
    return i;
  }
  
  public final int getType()
  {
    return 3810;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197315);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("friendUsername ").append(this.username).append(' ');
      i locali = i.qoK;
      ad.i(paramq, i.du(ckL()));
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fvU();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(197315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.au
 * JD-Core Version:    0.7.0.1
 */