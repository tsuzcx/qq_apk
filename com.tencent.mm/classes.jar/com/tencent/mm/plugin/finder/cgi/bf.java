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
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinerGetFavFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "kotlin.jvm.PlatformType", "getTotalCount", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bf
  extends ac
  implements k
{
  public final String TAG;
  private f callback;
  public int pullType;
  public com.tencent.mm.al.b rr;
  
  public bf(String paramString, com.tencent.mm.bx.b paramb, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201172);
    this.TAG = "Finder.NetSceneFinerGetFavFeed";
    b.a locala = new b.a();
    locala.oP(getType());
    anm localanm = new anm();
    localanm.lastBuffer = paramb;
    paramb = v.rIR;
    localanm.Gle = v.a(paramaqy);
    localanm.rTn = paramString;
    locala.c((a)localanm);
    locala.oP(getType());
    locala.d((a)new ann());
    locala.Dl("/cgi-bin/micromsg-bin/findergetfavlist");
    paramString = locala.aDC();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    AppMethodBeat.o(201172);
  }
  
  public final List<FinderObject> cyt()
  {
    AppMethodBeat.i(201171);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(201171);
      throw ((Throwable)localObject);
    }
    localObject = ((ann)localObject).object;
    p.g(localObject, "(rr.responseProtoBuf as …FavListResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(201171);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201169);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201169);
    return i;
  }
  
  public final int getType()
  {
    return 3966;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201170);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    paramq = this.TAG;
    paramArrayOfByte = new StringBuilder("server increatment size:");
    a locala = this.rr.aEF();
    if (locala == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(201170);
      throw paramString;
    }
    ad.i(paramq, ((ann)locala).object.size());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((Iterable)cyt()).iterator();
      while (paramq.hasNext()) {
        d((FinderObject)paramq.next());
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bf
 * JD-Core Version:    0.7.0.1
 */