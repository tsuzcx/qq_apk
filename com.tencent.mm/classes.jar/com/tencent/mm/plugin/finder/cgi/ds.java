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
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.awv;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserActivity;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "posterUserName", "", "(Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getActivityList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ds
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final ds.a ADA;
  private com.tencent.mm.am.h callback;
  public c rr;
  
  static
  {
    AppMethodBeat.i(336791);
    ADA = new ds.a((byte)0);
    AppMethodBeat.o(336791);
  }
  
  public ds(b paramb, String paramString)
  {
    AppMethodBeat.i(336787);
    c.a locala = new c.a();
    locala.funcId = getType();
    awv localawv = new awv();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localawv.ZHZ = str;
    localawv.lastBuffer = paramb;
    paramb = bi.ABn;
    localawv.ZHY = bi.dVu();
    locala.otE = ((a)localawv);
    locala.otF = ((a)new aww());
    locala.uri = "/cgi-bin/micromsg-bin/findereventuserpage";
    paramb = locala.bEF();
    kotlin.g.b.s.s(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i("NetSceneFinderGetActivityList", "NetSceneFinderGetActivityList init ");
    AppMethodBeat.o(336787);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336805);
    Log.i("NetSceneFinderGetActivityList", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = new StringBuilder("firstPage ");
    if (dVJ() == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("NetSceneFinderGetActivityList", bool + ", get " + dVI().size() + " activity");
      if (this.callback != null)
      {
        params = this.callback;
        kotlin.g.b.s.checkNotNull(params);
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(336805);
      return;
    }
  }
  
  public final LinkedList<awt> dVI()
  {
    AppMethodBeat.i(336810);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderEventUserPageResponse");
      AppMethodBeat.o(336810);
      throw ((Throwable)localObject);
    }
    localObject = ((aww)localObject).ZIa;
    kotlin.g.b.s.s(localObject, "rr.responseProtoBuf as F…erPageResponse).eventList");
    AppMethodBeat.o(336810);
    return localObject;
  }
  
  public final b dVJ()
  {
    AppMethodBeat.i(336814);
    Object localObject = c.c.b(this.rr.otC);
    if ((localObject instanceof aww)) {}
    for (localObject = (aww)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(336814);
      return null;
    }
    localObject = ((aww)localObject).lastBuffer;
    AppMethodBeat.o(336814);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336797);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336797);
    return i;
  }
  
  public final int getType()
  {
    return 6833;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ds
 * JD-Core Version:    0.7.0.1
 */