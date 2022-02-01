package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayw;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "friendUsername", "", "feedId", "", "nonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFriendUsername", "()Ljava/lang/String;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFoldedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ci
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private final String ACh;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private final long feedId;
  public int pullType;
  public c rr;
  
  public ci(String paramString1, long paramLong, String paramString2, b paramb, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336704);
    this.ACh = paramString1;
    this.feedId = paramLong;
    this.TAG = "Finder.NetSceneFinderGetFoldedList";
    paramString1 = new c.a();
    paramString1.funcId = getType();
    ayw localayw = new ayw();
    localayw.ACh = this.ACh;
    localayw.hKN = this.feedId;
    localayw.lastBuffer = paramb;
    localayw.objectNonceId = paramString2;
    paramb = bi.ABn;
    localayw.ZEc = bi.a(parambui);
    paramString1.otE = ((a)localayw);
    paramString1.otF = ((a)new ayx());
    paramString1.uri = "/cgi-bin/micromsg-bin/findergetfoldedlist";
    paramString1 = paramString1.bEF();
    kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    Log.i(this.TAG, "NetSceneFinderGetFoldedList friendUsername:" + this.ACh + " feedId:" + this.feedId + " nonceId:" + paramString2);
    AppMethodBeat.o(336704);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336719);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject1;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      f.Ozc.idkeyStat(1279L, 9L, 1L, false);
      params = this.TAG;
      localObject1 = new StringBuilder("friendUsername ").append(this.ACh).append("  feedId:").append(this.feedId).append(' ');
      localObject2 = bg.ABl;
      Log.i(params, bg.fV((List)dVQ()));
      params = dVQ();
      if (params != null) {
        params = ((Iterable)params).iterator();
      }
    }
    else
    {
      while (params.hasNext())
      {
        localObject1 = (FinderObject)params.next();
        localObject2 = z.FrZ;
        z.a((FinderObject)localObject1, getContextObj());
        continue;
        f.Ozc.idkeyStat(1279L, 10L, 1L, false);
      }
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336719);
  }
  
  public final LinkedList<FinderObject> dVQ()
  {
    AppMethodBeat.i(336726);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
      AppMethodBeat.o(336726);
      throw ((Throwable)localObject);
    }
    localObject = ((ayx)localObject).object;
    if (localObject == null)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(336726);
      return localObject;
    }
    AppMethodBeat.o(336726);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336709);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336709);
    return i;
  }
  
  public final int getType()
  {
    return 3904;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ci
 * JD-Core Version:    0.7.0.1
 */