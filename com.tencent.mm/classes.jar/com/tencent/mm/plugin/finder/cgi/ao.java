package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoa;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionedFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "username", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "kotlin.jvm.PlatformType", "getTotalCount", "", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ao
  extends ac
{
  private final String TAG;
  private f callback;
  public int pullType;
  public com.tencent.mm.al.b rr;
  private final String username;
  
  public ao(String paramString, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(201143);
    this.username = paramString;
    this.TAG = "Finder.NetSceneFinderGetMentionedFeed";
    paramString = new b.a();
    paramString.oP(getType());
    aoa localaoa = new aoa();
    localaoa.Gmz = this.username;
    localaoa.GmG = paramb;
    paramb = v.rIR;
    localaoa.GmL = v.cxY();
    paramString.c((a)localaoa);
    paramString.oP(getType());
    paramString.d((a)new aob());
    paramString.Dl("/cgi-bin/micromsg-bin/findergetmentionedlist");
    paramString = paramString.aDC();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ad.i(this.TAG, "NetSceneFinderGetMentionedFeed init: " + this.username);
    AppMethodBeat.o(201143);
  }
  
  public final List<FinderObject> cyt()
  {
    AppMethodBeat.i(201142);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
      AppMethodBeat.o(201142);
      throw ((Throwable)localObject);
    }
    localObject = ((aob)localObject).object;
    p.g(localObject, "(rr.responseProtoBuf as …nedListResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(201142);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201140);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201140);
    return i;
  }
  
  public final int getType()
  {
    return 3810;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201141);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("friendUsername ").append(this.username).append(' ');
      u localu = u.rIQ;
      ad.i(paramq, u.dy(cyt()));
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ao
 * JD-Core Version:    0.7.0.1
 */