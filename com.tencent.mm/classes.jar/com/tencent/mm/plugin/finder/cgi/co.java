package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.asa;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinerGetFavFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMegaVideoCount", "getRespLastBuffer", "getTotalCount", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class co
  extends ax
  implements m
{
  private final String TAG;
  private i callback;
  public int pullType;
  private d rr;
  
  public co(String paramString, b paramb, bbn parambbn, int paramInt)
  {
    super(parambbn);
    AppMethodBeat.i(242541);
    this.TAG = "Finder.NetSceneFinerGetFavFeed";
    d.a locala = new d.a();
    locala.sG(getType());
    arz localarz = new arz();
    localarz.lastBuffer = paramb;
    paramb = am.tuw;
    localarz.LAI = am.a(parambbn);
    localarz.finderUsername = paramString;
    localarz.dLS = paramInt;
    paramString = am.tuw;
    localarz.LAv = am.cXZ();
    locala.c((com.tencent.mm.bw.a)localarz);
    locala.sG(getType());
    locala.d((com.tencent.mm.bw.a)new asa());
    locala.MB("/cgi-bin/micromsg-bin/findergetfavlist");
    paramString = locala.aXF();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    AppMethodBeat.o(242541);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242535);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.TAG;
    Object localObject = new StringBuilder("server increatment size:");
    com.tencent.mm.bw.a locala = this.rr.aYK();
    if (locala == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(242535);
      throw paramString;
    }
    Log.i(params, ((asa)locala).object.size());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
        AppMethodBeat.o(242535);
        throw paramString;
      }
      params = (asa)params;
      localObject = com.tencent.mm.plugin.finder.preload.a.uTO;
      localObject = params.LAF;
      params = params.object;
      p.g(params, "resp.`object`");
      com.tencent.mm.plugin.finder.preload.a.a((baw)localObject, (List)params, 3966);
      params = ((Iterable)cYD()).iterator();
      while (params.hasNext()) {
        d((FinderObject)params.next());
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(242535);
  }
  
  public final int cYA()
  {
    AppMethodBeat.i(242540);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(242540);
      throw ((Throwable)localObject);
    }
    int i = ((asa)localObject).continueFlag;
    AppMethodBeat.o(242540);
    return i;
  }
  
  public final List<FinderObject> cYD()
  {
    AppMethodBeat.i(242536);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(242536);
      throw ((Throwable)localObject);
    }
    localObject = ((asa)localObject).object;
    p.g(localObject, "(rr.responseProtoBuf as …FavListResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(242536);
    return localObject;
  }
  
  public final int cYy()
  {
    AppMethodBeat.i(242538);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(242538);
      throw ((Throwable)localObject);
    }
    int i = ((asa)localObject).uKM;
    AppMethodBeat.o(242538);
    return i;
  }
  
  public final b cYz()
  {
    AppMethodBeat.i(242539);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(242539);
      throw ((Throwable)localObject);
    }
    localObject = ((asa)localObject).lastBuffer;
    AppMethodBeat.o(242539);
    return localObject;
  }
  
  public final int cZm()
  {
    AppMethodBeat.i(242537);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("favCount = ");
    com.tencent.mm.bw.a locala = this.rr.aYK();
    if (locala == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(242537);
      throw ((Throwable)localObject);
    }
    Log.i((String)localObject, ((asa)locala).gAZ);
    localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(242537);
      throw ((Throwable)localObject);
    }
    int i = ((asa)localObject).gAZ;
    AppMethodBeat.o(242537);
    return i;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242534);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242534);
    return i;
  }
  
  public final int getType()
  {
    return 3966;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.co
 * JD-Core Version:    0.7.0.1
 */