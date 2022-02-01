package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetActivityList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getActivityList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bd
  extends ax
  implements m
{
  public static final a tvh;
  private i callback;
  public d rr;
  
  static
  {
    AppMethodBeat.i(242383);
    tvh = new a((byte)0);
    AppMethodBeat.o(242383);
  }
  
  public bd(b paramb)
  {
    AppMethodBeat.i(242382);
    d.a locala = new d.a();
    locala.sG(getType());
    bbb localbbb = new bbb();
    localbbb.LDs = paramb;
    paramb = am.tuw;
    localbbb.LBM = am.cXY();
    locala.c((a)localbbb);
    locala.d((a)new bbc());
    locala.MB("/cgi-bin/micromsg-bin/finderrecommendevent");
    paramb = locala.aXF();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i("NetSceneFinderGetActivityList", "NetSceneFinderGetActivityList init ");
    AppMethodBeat.o(242382);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242379);
    Log.i("NetSceneFinderGetActivityList", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = new StringBuilder("firstPage ");
    if (cYm() == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("NetSceneFinderGetActivityList", bool + ", get " + cYl().size() + " activity");
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.hyc();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(242379);
      return;
    }
  }
  
  public final LinkedList<aqk> cYl()
  {
    AppMethodBeat.i(242380);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderRecommendEventResponse");
      AppMethodBeat.o(242380);
      throw ((Throwable)localObject);
    }
    localObject = ((bbc)localObject).LKG;
    p.g(localObject, "(rr.responseProtoBuf as …EventResponse).event_list");
    AppMethodBeat.o(242380);
    return localObject;
  }
  
  public final b cYm()
  {
    AppMethodBeat.i(242381);
    a locala = this.rr.aYK();
    Object localObject = locala;
    if (!(locala instanceof bbc)) {
      localObject = null;
    }
    localObject = (bbc)localObject;
    if (localObject != null)
    {
      localObject = ((bbc)localObject).LDs;
      AppMethodBeat.o(242381);
      return localObject;
    }
    AppMethodBeat.o(242381);
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242378);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242378);
    return i;
  }
  
  public final int getType()
  {
    return 5839;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetActivityList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bd
 * JD-Core Version:    0.7.0.1
 */