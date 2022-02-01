package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aql;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinerCatelogStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "pullType", "", "tabType", "scene", "extBuff", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "(IIILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "setRr", "(Lcom/tencent/mm/modelbase/CommReqResp;)V", "getTabType", "setTabType", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class cs
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private int fEH;
  public int pullType;
  public d rr;
  
  public cs(int paramInt1, int paramInt2, int paramInt3, b paramb1, b paramb2)
  {
    super(null);
    AppMethodBeat.i(273775);
    this.TAG = "Finder.NetSceneFinerCatelogStream";
    d.a locala = new d.a();
    locala.vD(getType());
    this.pullType = paramInt1;
    this.fEH = paramInt2;
    aql localaql = new aql();
    ao localao = ao.xcj;
    localaql.SDi = ao.dnO();
    localao = ao.xcj;
    localaql.SCW = ao.dnP();
    localaql.SDJ = paramInt1;
    localaql.tab_type = paramInt2;
    localaql.scene = paramInt3;
    localaql.SDH = paramb1;
    localaql.SDI = paramb2;
    localaql.RLN = z.bdh();
    locala.c((a)localaql);
    locala.vD(getType());
    locala.d((a)new aqm());
    locala.TW("/cgi-bin/micromsg-bin/findercatelogstream");
    paramb1 = locala.bgN();
    p.j(paramb1, "builder.buildInstance()");
    this.rr = paramb1;
    AppMethodBeat.o(273775);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(273772);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString + ", tabType:" + this.fEH);
    params = this.TAG;
    Object localObject1 = new StringBuilder("server increatment size:");
    Object localObject2 = this.rr.bhY();
    if (localObject2 == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
      AppMethodBeat.o(273772);
      throw paramString;
    }
    Log.i(params, ((aqm)localObject2).object.size());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (this.rr.bhY() == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
        AppMethodBeat.o(273772);
        throw paramString;
      }
      params = ((Iterable)dow()).iterator();
      while (params.hasNext())
      {
        localObject1 = (FinderObject)params.next();
        localObject2 = n.zWF;
        n.c((FinderObject)localObject1, this.xbu);
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(273772);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(273771);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(273771);
    return i;
  }
  
  public final LinkedList<FinderObject> dow()
  {
    AppMethodBeat.i(273773);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
      AppMethodBeat.o(273773);
      throw ((Throwable)localObject);
    }
    localObject = ((aqm)localObject).object;
    p.j(localObject, "(rr.responseProtoBuf as …gStreamResponse).`object`");
    AppMethodBeat.o(273773);
    return localObject;
  }
  
  public final int getType()
  {
    return 4239;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cs
 * JD-Core Version:    0.7.0.1
 */