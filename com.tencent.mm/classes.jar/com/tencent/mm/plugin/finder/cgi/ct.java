package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinerGetFavFeed;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "topicId", "", "tabType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;JI)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMegaVideoCount", "getRespLastBuffer", "getTopicId", "getTopics", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTotalCount", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ct
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  public int pullType;
  public d rr;
  
  private ct(String paramString, b paramb, bid parambid, long paramLong)
  {
    super(parambid);
    AppMethodBeat.i(232012);
    this.TAG = "Finder.NetSceneFinerGetFavFeed";
    d.a locala = new d.a();
    locala.vD(getType());
    aua localaua = new aua();
    localaua.lastBuffer = paramb;
    paramb = ao.xcj;
    localaua.SDi = ao.a(parambid);
    localaua.finderUsername = paramString;
    localaua.fEH = 0;
    localaua.xee = paramLong;
    paramString = ao.xcj;
    localaua.SCW = ao.dnP();
    locala.c((com.tencent.mm.cd.a)localaua);
    locala.vD(getType());
    locala.d((com.tencent.mm.cd.a)new aub());
    locala.TW("/cgi-bin/micromsg-bin/findergetfavlist");
    paramString = locala.bgN();
    p.j(paramString, "builder.buildInstance()");
    this.rr = paramString;
    AppMethodBeat.o(232012);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(232003);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.TAG;
    Object localObject1 = new StringBuilder("server increatment size:");
    Object localObject2 = this.rr.bhY();
    if (localObject2 == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(232003);
      throw paramString;
    }
    Log.i(params, ((aub)localObject2).object.size());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
        AppMethodBeat.o(232003);
        throw paramString;
      }
      params = (aub)params;
      localObject1 = com.tencent.mm.plugin.finder.preload.a.zKe;
      localObject1 = params.SDf;
      params = params.object;
      p.j(params, "resp.`object`");
      com.tencent.mm.plugin.finder.preload.a.a((bhh)localObject1, (List)params, 3966);
      params = ((Iterable)dow()).iterator();
      while (params.hasNext())
      {
        localObject1 = (FinderObject)params.next();
        localObject2 = n.zWF;
        n.c((FinderObject)localObject1, this.xbu);
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(232003);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(232002);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(232002);
    return i;
  }
  
  public final int dom()
  {
    AppMethodBeat.i(232006);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(232006);
      throw ((Throwable)localObject);
    }
    int i = ((aub)localObject).zwD;
    AppMethodBeat.o(232006);
    return i;
  }
  
  public final b don()
  {
    AppMethodBeat.i(232009);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(232009);
      throw ((Throwable)localObject);
    }
    localObject = ((aub)localObject).lastBuffer;
    AppMethodBeat.o(232009);
    return localObject;
  }
  
  public final int doo()
  {
    AppMethodBeat.i(232011);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(232011);
      throw ((Throwable)localObject);
    }
    int i = ((aub)localObject).continueFlag;
    AppMethodBeat.o(232011);
    return i;
  }
  
  public final LinkedList<FinderObject> dow()
  {
    AppMethodBeat.i(232004);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(232004);
      throw ((Throwable)localObject);
    }
    localObject = ((aub)localObject).object;
    p.j(localObject, "(rr.responseProtoBuf as …FavListResponse).`object`");
    AppMethodBeat.o(232004);
    return localObject;
  }
  
  public final int dpe()
  {
    AppMethodBeat.i(232005);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("favCount = ");
    com.tencent.mm.cd.a locala = this.rr.bhY();
    if (locala == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(232005);
      throw ((Throwable)localObject);
    }
    Log.i((String)localObject, ((aub)locala).jlf);
    localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(232005);
      throw ((Throwable)localObject);
    }
    int i = ((aub)localObject).jlf;
    AppMethodBeat.o(232005);
    return i;
  }
  
  public final long dpf()
  {
    AppMethodBeat.i(232007);
    Object localObject = this.rr.bhX();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListRequest");
      AppMethodBeat.o(232007);
      throw ((Throwable)localObject);
    }
    long l = ((aua)localObject).xee;
    AppMethodBeat.o(232007);
    return l;
  }
  
  public final int getType()
  {
    return 3966;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ct
 * JD-Core Version:    0.7.0.1
 */