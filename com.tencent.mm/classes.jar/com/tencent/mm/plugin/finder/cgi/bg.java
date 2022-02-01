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
import com.tencent.mm.protocal.protobuf.anz;
import com.tencent.mm.protocal.protobuf.aoa;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinerGetFavFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "getTotalCount", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bg
  extends ad
  implements k
{
  public final String TAG;
  private f callback;
  public int pullType;
  public com.tencent.mm.ak.b rr;
  
  public bg(String paramString, com.tencent.mm.bw.b paramb, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201594);
    this.TAG = "Finder.NetSceneFinerGetFavFeed";
    b.a locala = new b.a();
    locala.oS(getType());
    anz localanz = new anz();
    localanz.lastBuffer = paramb;
    paramb = v.rRb;
    localanz.GEg = v.a(paramarn);
    localanz.sbR = paramString;
    locala.c((a)localanz);
    locala.oS(getType());
    locala.d((a)new aoa());
    locala.DN("/cgi-bin/micromsg-bin/findergetfavlist");
    paramString = locala.aDS();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    AppMethodBeat.o(201594);
  }
  
  public final List<FinderObject> czU()
  {
    AppMethodBeat.i(201593);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(201593);
      throw ((Throwable)localObject);
    }
    localObject = ((aoa)localObject).object;
    p.g(localObject, "(rr.responseProtoBuf as …FavListResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(201593);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201591);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201591);
    return i;
  }
  
  public final int getType()
  {
    return 3966;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201592);
    ae.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    paramq = this.TAG;
    paramArrayOfByte = new StringBuilder("server increatment size:");
    a locala = this.rr.aEV();
    if (locala == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(201592);
      throw paramString;
    }
    ae.i(paramq, ((aoa)locala).object.size());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((Iterable)czU()).iterator();
      while (paramq.hasNext()) {
        d((FinderObject)paramq.next());
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gkB();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bg
 * JD-Core Version:    0.7.0.1
 */