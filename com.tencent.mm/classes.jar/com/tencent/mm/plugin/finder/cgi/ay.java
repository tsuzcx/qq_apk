package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dyp;
import com.tencent.mm.protocal.protobuf.dyq;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinerGetFavFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "kotlin.jvm.PlatformType", "getTotalCount", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ay
  extends ap
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g callback;
  public int pullType;
  public com.tencent.mm.al.b rr;
  
  public ay(String paramString, com.tencent.mm.bx.b paramb, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197340);
    this.TAG = "Finder.NetSceneFinerGetFavFeed";
    b.a locala = new b.a();
    locala.nB(getType());
    dyp localdyp = new dyp();
    localdyp.lastBuffer = paramb;
    paramb = am.KJy;
    localdyp.DlF = am.a(paramdzp);
    localdyp.finderUsername = paramString;
    locala.c((a)localdyp);
    locala.nB(getType());
    locala.d((a)new dyq());
    locala.wg("/cgi-bin/micromsg-bin/findergetfavlist");
    paramString = locala.atI();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    AppMethodBeat.o(197340);
  }
  
  public final List<FinderObject> ckL()
  {
    AppMethodBeat.i(197339);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(197339);
      throw ((Throwable)localObject);
    }
    localObject = ((dyq)localObject).object;
    d.g.b.k.g(localObject, "(rr.responseProtoBuf as …FavListResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(197339);
    return localObject;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(197337);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(197337);
    return i;
  }
  
  public final int getType()
  {
    return 3966;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197338);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    paramq = this.TAG;
    paramArrayOfByte = new StringBuilder("server increatment size:");
    a locala = this.rr.auM();
    if (locala == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(197338);
      throw paramString;
    }
    ad.i(paramq, ((dyq)locala).object.size());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((Iterable)ckL()).iterator();
      while (paramq.hasNext()) {
        k((FinderObject)paramq.next());
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fvU();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(197338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ay
 * JD-Core Version:    0.7.0.1
 */