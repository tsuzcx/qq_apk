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
import com.tencent.mm.protocal.protobuf.aql;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserActivity;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "posterUserName", "", "(Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getActivityList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cm
  extends ax
  implements m
{
  public static final a twB;
  private i callback;
  public d rr;
  
  static
  {
    AppMethodBeat.i(242526);
    twB = new a((byte)0);
    AppMethodBeat.o(242526);
  }
  
  public cm(b paramb, String paramString)
  {
    AppMethodBeat.i(242525);
    d.a locala = new d.a();
    locala.sG(getType());
    aql localaql = new aql();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localaql.LCB = str;
    localaql.lastBuffer = paramb;
    paramb = am.tuw;
    localaql.LCA = am.cXY();
    locala.c((a)localaql);
    locala.d((a)new aqm());
    locala.MB("/cgi-bin/micromsg-bin/findereventuserpage");
    paramb = locala.aXF();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i("NetSceneFinderGetActivityList", "NetSceneFinderGetActivityList init ");
    AppMethodBeat.o(242525);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242522);
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
      AppMethodBeat.o(242522);
      return;
    }
  }
  
  public final LinkedList<aqk> cYl()
  {
    AppMethodBeat.i(242523);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderEventUserPageResponse");
      AppMethodBeat.o(242523);
      throw ((Throwable)localObject);
    }
    localObject = ((aqm)localObject).LCC;
    p.g(localObject, "(rr.responseProtoBuf as …erPageResponse).eventList");
    AppMethodBeat.o(242523);
    return localObject;
  }
  
  public final b cYm()
  {
    AppMethodBeat.i(242524);
    a locala = this.rr.aYK();
    Object localObject = locala;
    if (!(locala instanceof aqm)) {
      localObject = null;
    }
    localObject = (aqm)localObject;
    if (localObject != null)
    {
      localObject = ((aqm)localObject).lastBuffer;
      AppMethodBeat.o(242524);
      return localObject;
    }
    AppMethodBeat.o(242524);
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242521);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242521);
    return i;
  }
  
  public final int getType()
  {
    return 6833;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserActivity$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cm
 * JD-Core Version:    0.7.0.1
 */