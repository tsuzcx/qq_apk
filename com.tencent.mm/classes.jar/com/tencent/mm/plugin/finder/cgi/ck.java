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
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.azb;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFollowTopicList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "userName", "", "(Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRequestBuffer", "getResponseBuffer", "getTopicCount", "getTopicList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getType", "hasContine", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ck
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private final String TAG;
  private com.tencent.mm.am.h callback;
  public c rr;
  
  public ck(b paramb, String paramString)
  {
    AppMethodBeat.i(336644);
    this.TAG = "Finder.NetSceneFinderGetFollowTopicList";
    c.a locala = new c.a();
    locala.funcId = getType();
    aza localaza = new aza();
    localaza.ZEQ = paramb;
    paramb = bi.ABn;
    localaza.ZHY = bi.dVu();
    localaza.YIZ = paramString;
    locala.otE = ((a)localaza);
    locala.otF = ((a)new azb());
    locala.uri = "/cgi-bin/micromsg-bin/findergetfollowtopiclist";
    paramb = locala.bEF();
    kotlin.g.b.s.s(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetFollowList init ");
    AppMethodBeat.o(336644);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336662);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      f.Ozc.idkeyStat(1279L, 7L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        params = this.callback;
        kotlin.g.b.s.checkNotNull(params);
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(336662);
      return;
      f.Ozc.idkeyStat(1279L, 8L, 1L, false);
    }
  }
  
  public final LinkedList<bxv> dVS()
  {
    AppMethodBeat.i(336667);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowTopicListResponse");
      AppMethodBeat.o(336667);
      throw ((Throwable)localObject);
    }
    localObject = ((azb)localObject).topics;
    kotlin.g.b.s.s(localObject, "rr.responseProtoBuf as F…TopicListResponse).topics");
    AppMethodBeat.o(336667);
    return localObject;
  }
  
  public final int dVT()
  {
    AppMethodBeat.i(336674);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowTopicListResponse");
      AppMethodBeat.o(336674);
      throw ((Throwable)localObject);
    }
    int i = ((azb)localObject).topic_count;
    AppMethodBeat.o(336674);
    return i;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336649);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336649);
    return i;
  }
  
  public final int getType()
  {
    return 712;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ck
 * JD-Core Version:    0.7.0.1
 */