package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aue;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "friendUsername", "", "feedId", "", "nonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFriendUsername", "()Ljava/lang/String;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFoldedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bl
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private final long feedId;
  public int pullType;
  public d rr;
  private final String xcR;
  
  public bl(String paramString1, long paramLong, String paramString2, b paramb, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(232079);
    this.xcR = paramString1;
    this.feedId = paramLong;
    this.TAG = "Finder.NetSceneFinderGetFoldedList";
    paramString1 = new d.a();
    paramString1.vD(getType());
    aue localaue = new aue();
    localaue.xcR = this.xcR;
    localaue.xbk = this.feedId;
    localaue.lastBuffer = paramb;
    localaue.objectNonceId = paramString2;
    paramb = ao.xcj;
    localaue.SDi = ao.a(parambid);
    paramString1.c((a)localaue);
    paramString1.d((a)new auf());
    paramString1.TW("/cgi-bin/micromsg-bin/findergetfoldedlist");
    paramString1 = paramString1.bgN();
    p.j(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    Log.i(this.TAG, "NetSceneFinderGetFoldedList friendUsername:" + this.xcR + " feedId:" + this.feedId + " nonceId:" + paramString2);
    AppMethodBeat.o(232079);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(232074);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject1;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      f.Iyx.idkeyStat(1279L, 9L, 1L, false);
      params = this.TAG;
      localObject1 = new StringBuilder("friendUsername ").append(this.xcR).append("  feedId:").append(this.feedId).append(' ');
      localObject2 = am.xch;
      Log.i(params, am.dY((List)dog()));
      params = dog();
      if (params != null) {
        params = ((Iterable)params).iterator();
      }
    }
    else
    {
      while (params.hasNext())
      {
        localObject1 = (FinderObject)params.next();
        localObject2 = n.zWF;
        n.c((FinderObject)localObject1, this.xbu);
        continue;
        f.Iyx.idkeyStat(1279L, 10L, 1L, false);
      }
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(232074);
      return;
    }
    AppMethodBeat.o(232074);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(232073);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(232073);
    return i;
  }
  
  public final LinkedList<FinderObject> dog()
  {
    AppMethodBeat.i(232076);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
      AppMethodBeat.o(232076);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((auf)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(232076);
    return localObject;
  }
  
  public final int getType()
  {
    return 3904;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bl
 * JD-Core Version:    0.7.0.1
 */