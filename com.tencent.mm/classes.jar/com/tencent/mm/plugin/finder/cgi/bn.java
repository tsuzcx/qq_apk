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
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFollowTopicList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "userName", "", "(Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRequestBuffer", "getResponseBuffer", "getTopicCount", "getTopicList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getType", "hasContine", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bn
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  public d rr;
  
  public bn(b paramb, String paramString)
  {
    AppMethodBeat.i(226886);
    this.TAG = "Finder.NetSceneFinderGetFollowTopicList";
    d.a locala = new d.a();
    locala.vD(getType());
    aui localaui = new aui();
    localaui.SDI = paramb;
    paramb = ao.xcj;
    localaui.SFL = ao.dnO();
    localaui.RLN = paramString;
    locala.c((a)localaui);
    locala.d((a)new auj());
    locala.TW("/cgi-bin/micromsg-bin/findergetfollowtopiclist");
    paramb = locala.bgN();
    p.j(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetFollowList init ");
    AppMethodBeat.o(226886);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(226875);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      f.Iyx.idkeyStat(1279L, 7L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.iCn();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(226875);
      return;
      f.Iyx.idkeyStat(1279L, 8L, 1L, false);
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(226869);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(226869);
    return i;
  }
  
  public final LinkedList<bkr> doi()
  {
    AppMethodBeat.i(226878);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowTopicListResponse");
      AppMethodBeat.o(226878);
      throw ((Throwable)localObject);
    }
    localObject = ((auj)localObject).topics;
    p.j(localObject, "(rr.responseProtoBuf as …TopicListResponse).topics");
    AppMethodBeat.o(226878);
    return localObject;
  }
  
  public final int doj()
  {
    AppMethodBeat.i(226881);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowTopicListResponse");
      AppMethodBeat.o(226881);
      throw ((Throwable)localObject);
    }
    int i = ((auj)localObject).topic_count;
    AppMethodBeat.o(226881);
    return i;
  }
  
  public final int getType()
  {
    return 712;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bn
 * JD-Core Version:    0.7.0.1
 */