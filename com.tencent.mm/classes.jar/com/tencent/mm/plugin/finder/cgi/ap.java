package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionedFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "username", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "getTotalCount", "", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ap
  extends ad
{
  private final String TAG;
  private f callback;
  public int pullType;
  public com.tencent.mm.ak.b rr;
  private final String username;
  
  public ap(String paramString, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(201565);
    this.username = paramString;
    this.TAG = "Finder.NetSceneFinderGetMentionedFeed";
    paramString = new b.a();
    paramString.oS(getType());
    aon localaon = new aon();
    localaon.GDP = this.username;
    localaon.GFN = paramb;
    paramb = v.rRb;
    localaon.GFS = v.czz();
    paramString.c((a)localaon);
    paramString.oS(getType());
    paramString.d((a)new aoo());
    paramString.DN("/cgi-bin/micromsg-bin/findergetmentionedlist");
    paramString = paramString.aDS();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ae.i(this.TAG, "NetSceneFinderGetMentionedFeed init: " + this.username);
    AppMethodBeat.o(201565);
  }
  
  public final List<FinderObject> czU()
  {
    AppMethodBeat.i(201564);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
      AppMethodBeat.o(201564);
      throw ((Throwable)localObject);
    }
    localObject = ((aoo)localObject).object;
    p.g(localObject, "(rr.responseProtoBuf as …nedListResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(201564);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201562);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201562);
    return i;
  }
  
  public final int getType()
  {
    return 3810;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201563);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ae.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("friendUsername ").append(this.username).append(' ');
      u localu = u.rRa;
      ae.i(paramq, u.dB(czU()));
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gkB();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ap
 * JD-Core Version:    0.7.0.1
 */