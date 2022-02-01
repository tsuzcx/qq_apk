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
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.aum;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinerCatelogStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "pullType", "", "tabType", "scene", "extBuff", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "(IIILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "setRr", "(Lcom/tencent/mm/modelbase/CommReqResp;)V", "getTabType", "setTabType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class du
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private int hJx;
  public int pullType;
  public c rr;
  
  public du(int paramInt1, int paramInt2, int paramInt3, b paramb1, b paramb2)
  {
    super(null);
    AppMethodBeat.i(336799);
    this.TAG = "Finder.NetSceneFinerCatelogStream";
    c.a locala = new c.a();
    locala.funcId = getType();
    this.pullType = paramInt1;
    this.hJx = paramInt2;
    aul localaul = new aul();
    bi localbi = bi.ABn;
    localaul.ZEc = bi.dVu();
    localbi = bi.ABn;
    localaul.ZDQ = bi.bTZ();
    localaul.ZER = paramInt1;
    localaul.tab_type = paramInt2;
    localaul.scene = paramInt3;
    localaul.ZEP = paramb1;
    localaul.ZEQ = paramb2;
    localaul.YIZ = com.tencent.mm.model.z.bAW();
    locala.otE = ((a)localaul);
    locala.funcId = getType();
    locala.otF = ((a)new aum());
    locala.uri = "/cgi-bin/micromsg-bin/findercatelogstream";
    paramb1 = locala.bEF();
    kotlin.g.b.s.s(paramb1, "builder.buildInstance()");
    this.rr = paramb1;
    AppMethodBeat.o(336799);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336819);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString + ", tabType:" + this.hJx);
    params = this.TAG;
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
      AppMethodBeat.o(336819);
      throw paramString;
    }
    Log.i(params, kotlin.g.b.s.X("server increatment size:", Integer.valueOf(((aum)localObject).object.size())));
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (c.c.b(this.rr.otC) == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
        AppMethodBeat.o(336819);
        throw paramString;
      }
      params = ((Iterable)dVW()).iterator();
      while (params.hasNext())
      {
        localObject = (FinderObject)params.next();
        com.tencent.mm.plugin.finder.report.z localz = com.tencent.mm.plugin.finder.report.z.FrZ;
        com.tencent.mm.plugin.finder.report.z.a((FinderObject)localObject, getContextObj());
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336819);
  }
  
  public final LinkedList<FinderObject> dVW()
  {
    AppMethodBeat.i(336824);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
      AppMethodBeat.o(336824);
      throw ((Throwable)localObject);
    }
    localObject = ((aum)localObject).object;
    kotlin.g.b.s.s(localObject, "rr.responseProtoBuf as F…gStreamResponse).`object`");
    AppMethodBeat.o(336824);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336807);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336807);
    return i;
  }
  
  public final int getType()
  {
    return 4239;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.du
 * JD-Core Version:    0.7.0.1
 */