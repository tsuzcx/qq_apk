package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetHotWordFeed;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "", "byPassInfo", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cm
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private final String TAG;
  private com.tencent.mm.am.h callback;
  public c rr;
  
  public cm(b paramb1, int paramInt, b paramb2, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336668);
    this.TAG = "Finder.NetSceneFinderGetHotWordTopicFeed";
    c.a locala = new c.a();
    locala.funcId = getType();
    bbs localbbs = new bbs();
    localbbs.ZEQ = paramb1;
    paramb1 = bi.ABn;
    localbbs.YIY = bi.a(parambui);
    localbbs.scene = paramInt;
    localbbs.ZMn = paramb2;
    locala.otE = ((com.tencent.mm.bx.a)localbbs);
    locala.otF = ((com.tencent.mm.bx.a)new bbt());
    locala.uri = "/cgi-bin/micromsg-bin/finderhotwordstream";
    paramb1 = locala.bEF();
    kotlin.g.b.s.s(paramb1, "builder.buildInstance()");
    this.rr = paramb1;
    Log.i(this.TAG, "NetSceneFinderGetHotWordTopicFeed get word init");
    AppMethodBeat.o(336668);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336689);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      localObject = bg.ABl;
      Log.i(params, bg.fV((List)dVW()));
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderHotWordStreamResp");
        AppMethodBeat.o(336689);
        throw paramString;
      }
      params = (bbt)params;
      localObject = com.tencent.mm.plugin.finder.preload.a.EUs;
      params = params.YMW;
      kotlin.g.b.s.s(params, "resp.object_list");
      com.tencent.mm.plugin.finder.preload.a.a(null, (List)params, 4007);
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    paramString = getContextObj();
    if (paramString != null)
    {
      params = ((Iterable)dVW()).iterator();
      while (params.hasNext())
      {
        localObject = (FinderObject)params.next();
        z localz = z.FrZ;
        z.a((FinderObject)localObject, paramString.AJo);
      }
    }
    AppMethodBeat.o(336689);
  }
  
  public final LinkedList<FinderObject> dVW()
  {
    AppMethodBeat.i(336696);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderHotWordStreamResp");
      AppMethodBeat.o(336696);
      throw ((Throwable)localObject);
    }
    localObject = ((bbt)localObject).YMW;
    kotlin.g.b.s.s(localObject, "rr.responseProtoBuf as F…rdStreamResp).object_list");
    AppMethodBeat.o(336696);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336675);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336675);
    return i;
  }
  
  public final int getType()
  {
    return 4007;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cm
 * JD-Core Version:    0.7.0.1
 */