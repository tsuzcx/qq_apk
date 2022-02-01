package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ays;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinerGetFavFeed;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "topicId", "", "tabType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;JI)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMegaVideoCount", "getRespLastBuffer", "getTopicId", "getTopics", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTotalCount", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dv
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private final String TAG;
  private com.tencent.mm.am.h callback;
  public int pullType;
  public c rr;
  
  private dv(String paramString, b paramb, bui parambui, long paramLong)
  {
    super(parambui);
    AppMethodBeat.i(336875);
    this.TAG = "Finder.NetSceneFinerGetFavFeed";
    c.a locala = new c.a();
    locala.funcId = getType();
    ays localays = new ays();
    localays.lastBuffer = paramb;
    paramb = bi.ABn;
    localays.ZEc = bi.a(parambui);
    localays.finderUsername = paramString;
    localays.hJx = 0;
    localays.ADo = paramLong;
    paramString = bi.ABn;
    localays.ZDQ = bi.bTZ();
    locala.otE = ((com.tencent.mm.bx.a)localays);
    locala.funcId = getType();
    locala.otF = ((com.tencent.mm.bx.a)new ayt());
    locala.uri = "/cgi-bin/micromsg-bin/findergetfavlist";
    paramString = locala.bEF();
    kotlin.g.b.s.s(paramString, "builder.buildInstance()");
    this.rr = paramString;
    AppMethodBeat.o(336875);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336898);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.TAG;
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(336898);
      throw paramString;
    }
    Log.i(params, kotlin.g.b.s.X("server increatment size:", Integer.valueOf(((ayt)localObject).object.size())));
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
        AppMethodBeat.o(336898);
        throw paramString;
      }
      params = (ayt)params;
      localObject = com.tencent.mm.plugin.finder.preload.a.EUs;
      localObject = params.ZDZ;
      params = params.object;
      kotlin.g.b.s.s(params, "resp.`object`");
      com.tencent.mm.plugin.finder.preload.a.a((btc)localObject, (List)params, 3966);
      params = ((Iterable)dVW()).iterator();
      while (params.hasNext())
      {
        localObject = (FinderObject)params.next();
        z localz = z.FrZ;
        z.a((FinderObject)localObject, getContextObj());
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336898);
  }
  
  public final LinkedList<FinderObject> dVW()
  {
    AppMethodBeat.i(336910);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(336910);
      throw ((Throwable)localObject);
    }
    localObject = ((ayt)localObject).object;
    kotlin.g.b.s.s(localObject, "rr.responseProtoBuf as F…FavListResponse).`object`");
    AppMethodBeat.o(336910);
    return localObject;
  }
  
  public final int dVX()
  {
    AppMethodBeat.i(336921);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(336921);
      throw ((Throwable)localObject);
    }
    int i = ((ayt)localObject).EzH;
    AppMethodBeat.o(336921);
    return i;
  }
  
  public final b dVY()
  {
    AppMethodBeat.i(336928);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(336928);
      throw ((Throwable)localObject);
    }
    localObject = ((ayt)localObject).lastBuffer;
    AppMethodBeat.o(336928);
    return localObject;
  }
  
  public final int dVZ()
  {
    AppMethodBeat.i(336934);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(336934);
      throw ((Throwable)localObject);
    }
    int i = ((ayt)localObject).continueFlag;
    AppMethodBeat.o(336934);
    return i;
  }
  
  public final int dWF()
  {
    AppMethodBeat.i(336915);
    Object localObject = this.TAG;
    com.tencent.mm.bx.a locala = c.c.b(this.rr.otC);
    if (locala == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(336915);
      throw ((Throwable)localObject);
    }
    Log.i((String)localObject, kotlin.g.b.s.X("favCount = ", Integer.valueOf(((ayt)locala).lNX)));
    localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(336915);
      throw ((Throwable)localObject);
    }
    int i = ((ayt)localObject).lNX;
    AppMethodBeat.o(336915);
    return i;
  }
  
  public final long dWG()
  {
    AppMethodBeat.i(336925);
    Object localObject = c.b.b(this.rr.otB);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListRequest");
      AppMethodBeat.o(336925);
      throw ((Throwable)localObject);
    }
    long l = ((ays)localObject).ADo;
    AppMethodBeat.o(336925);
    return l;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336886);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336886);
    return i;
  }
  
  public final int getType()
  {
    return 3966;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dv
 * JD-Core Version:    0.7.0.1
 */