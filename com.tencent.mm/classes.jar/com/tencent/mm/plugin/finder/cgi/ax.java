package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.akl;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinerGetFavFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "kotlin.jvm.PlatformType", "getTotalCount", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ax
  extends w
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g callback;
  public int pullType;
  public com.tencent.mm.ak.b rr;
  
  public ax(String paramString, com.tencent.mm.bw.b paramb, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201218);
    this.TAG = "Finder.NetSceneFinerGetFavFeed";
    b.a locala = new b.a();
    locala.op(getType());
    akl localakl = new akl();
    localakl.lastBuffer = paramb;
    paramb = q.qXH;
    localakl.EDu = q.a(paramanm);
    localakl.rfC = paramString;
    locala.c((a)localakl);
    locala.op(getType());
    locala.d((a)new akm());
    locala.Am("/cgi-bin/micromsg-bin/findergetfavlist");
    paramString = locala.aAz();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    AppMethodBeat.o(201218);
  }
  
  public final List<FinderObject> csC()
  {
    AppMethodBeat.i(201217);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(201217);
      throw ((Throwable)localObject);
    }
    localObject = ((akm)localObject).object;
    d.g.b.k.g(localObject, "(rr.responseProtoBuf as …FavListResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(201217);
    return localObject;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(201215);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(201215);
    return i;
  }
  
  public final int getType()
  {
    return 3966;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201216);
    ac.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    paramq = this.TAG;
    paramArrayOfByte = new StringBuilder("server increatment size:");
    a locala = this.rr.aBD();
    if (locala == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(201216);
      throw paramString;
    }
    ac.i(paramq, ((akm)locala).object.size());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((Iterable)csC()).iterator();
      while (paramq.hasNext()) {
        d((FinderObject)paramq.next());
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fOy();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ax
 * JD-Core Version:    0.7.0.1
 */