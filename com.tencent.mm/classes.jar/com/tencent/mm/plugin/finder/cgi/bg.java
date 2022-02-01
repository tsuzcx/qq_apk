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
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.bhp;
import com.tencent.mm.protocal.protobuf.bhq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetActivityList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getActivityList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bg
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xcO;
  private i callback;
  public d rr;
  
  static
  {
    AppMethodBeat.i(289531);
    xcO = new a((byte)0);
    AppMethodBeat.o(289531);
  }
  
  public bg(b paramb)
  {
    AppMethodBeat.i(289530);
    d.a locala = new d.a();
    locala.vD(getType());
    bhp localbhp = new bhp();
    localbhp.SDI = paramb;
    paramb = ao.xcj;
    localbhp.RLM = ao.dnO();
    locala.c((a)localbhp);
    locala.d((a)new bhq());
    locala.TW("/cgi-bin/micromsg-bin/finderrecommendevent");
    paramb = locala.bgN();
    p.j(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i("NetSceneFinderGetActivityList", "NetSceneFinderGetActivityList init ");
    AppMethodBeat.o(289530);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(289526);
    Log.i("NetSceneFinderGetActivityList", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = new StringBuilder("firstPage ");
    if (doa() == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("NetSceneFinderGetActivityList", bool + ", get " + dnZ().size() + " activity");
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.iCn();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(289526);
      return;
    }
  }
  
  public final LinkedList<asg> dnZ()
  {
    AppMethodBeat.i(289527);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderRecommendEventResponse");
      AppMethodBeat.o(289527);
      throw ((Throwable)localObject);
    }
    localObject = ((bhq)localObject).SSf;
    p.j(localObject, "(rr.responseProtoBuf as …EventResponse).event_list");
    AppMethodBeat.o(289527);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(289525);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(289525);
    return i;
  }
  
  public final b doa()
  {
    AppMethodBeat.i(289528);
    a locala = this.rr.bhY();
    Object localObject = locala;
    if (!(locala instanceof bhq)) {
      localObject = null;
    }
    localObject = (bhq)localObject;
    if (localObject != null)
    {
      localObject = ((bhq)localObject).SDI;
      AppMethodBeat.o(289528);
      return localObject;
    }
    AppMethodBeat.o(289528);
    return null;
  }
  
  public final int getType()
  {
    return 5839;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetActivityList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bg
 * JD-Core Version:    0.7.0.1
 */