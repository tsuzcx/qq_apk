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
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserActivity;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "posterUserName", "", "(Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getActivityList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cq
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xeq;
  private i callback;
  public d rr;
  
  static
  {
    AppMethodBeat.i(285772);
    xeq = new a((byte)0);
    AppMethodBeat.o(285772);
  }
  
  public cq(b paramb, String paramString)
  {
    AppMethodBeat.i(285771);
    d.a locala = new d.a();
    locala.vD(getType());
    ash localash = new ash();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localash.SFM = str;
    localash.lastBuffer = paramb;
    paramb = ao.xcj;
    localash.SFL = ao.dnO();
    locala.c((a)localash);
    locala.d((a)new asi());
    locala.TW("/cgi-bin/micromsg-bin/findereventuserpage");
    paramb = locala.bgN();
    p.j(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i("NetSceneFinderGetActivityList", "NetSceneFinderGetActivityList init ");
    AppMethodBeat.o(285771);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(285768);
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
      AppMethodBeat.o(285768);
      return;
    }
  }
  
  public final LinkedList<asg> dnZ()
  {
    AppMethodBeat.i(285769);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderEventUserPageResponse");
      AppMethodBeat.o(285769);
      throw ((Throwable)localObject);
    }
    localObject = ((asi)localObject).SFN;
    p.j(localObject, "(rr.responseProtoBuf as …erPageResponse).eventList");
    AppMethodBeat.o(285769);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(285767);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(285767);
    return i;
  }
  
  public final b doa()
  {
    AppMethodBeat.i(285770);
    a locala = this.rr.bhY();
    Object localObject = locala;
    if (!(locala instanceof asi)) {
      localObject = null;
    }
    localObject = (asi)localObject;
    if (localObject != null)
    {
      localObject = ((asi)localObject).lastBuffer;
      AppMethodBeat.o(285770);
      return localObject;
    }
    AppMethodBeat.o(285770);
    return null;
  }
  
  public final int getType()
  {
    return 6833;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserActivity$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cq
 * JD-Core Version:    0.7.0.1
 */