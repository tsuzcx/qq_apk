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
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.findersdk.a.y.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPoiStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "fromScene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/SnsLocation;Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/Integer;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getNoticeWording", "", "getOnlyShowPoiName", "getPoiDetail", "Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "getRespLastBuffer", "getType", "getVideoCount", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ce
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xdO;
  private i callback;
  public int pullType;
  public d rr;
  
  static
  {
    AppMethodBeat.i(290104);
    xdO = new a((byte)0);
    AppMethodBeat.o(290104);
  }
  
  private ce(eka parameka, y.a parama, b paramb, Integer paramInteger)
  {
    super(null);
    AppMethodBeat.i(290102);
    d.a locala = new d.a();
    locala.vD(getType());
    bgr localbgr = new bgr();
    ao localao = ao.xcj;
    localbgr.RLM = ao.a(null);
    localbgr.fKO = parameka.SOz;
    localbgr.longitude = parameka.ScO;
    localbgr.latitude = parameka.ScP;
    localbgr.SRp = parama.ordinal();
    localbgr.SDI = paramb;
    parameka = ao.xcj;
    localbgr.SCW = ao.dnP();
    if (paramInteger != null) {
      localbgr.SRp = ((Number)paramInteger).intValue();
    }
    locala.c((a)localbgr);
    locala.vD(getType());
    locala.d((a)new bgs());
    locala.TW("/cgi-bin/micromsg-bin/finderpoistream");
    parameka = locala.bgN();
    p.j(parameka, "builder.buildInstance()");
    this.rr = parameka;
    AppMethodBeat.o(290102);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(290098);
    Log.i("Finder.NetSceneFinderPoiStream", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = new StringBuilder("server increatment size:");
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
      AppMethodBeat.o(290098);
      throw paramString;
    }
    Log.i("Finder.NetSceneFinderPoiStream", ((bgs)localObject).object.size());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (this.rr.bhY() == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
        AppMethodBeat.o(290098);
        throw paramString;
      }
      params = ((Iterable)dor()).iterator();
      while (params.hasNext())
      {
        localObject = (FinderObject)params.next();
        n localn = n.zWF;
        n.c((FinderObject)localObject, this.xbu);
      }
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(290098);
      return;
    }
    AppMethodBeat.o(290098);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(290097);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(290097);
    return i;
  }
  
  public final b don()
  {
    AppMethodBeat.i(290100);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
      AppMethodBeat.o(290100);
      throw ((Throwable)localObject);
    }
    localObject = ((bgs)localObject).SDI;
    AppMethodBeat.o(290100);
    return localObject;
  }
  
  public final int doo()
  {
    AppMethodBeat.i(290101);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
      AppMethodBeat.o(290101);
      throw ((Throwable)localObject);
    }
    int i = ((bgs)localObject).xFI;
    AppMethodBeat.o(290101);
    return i;
  }
  
  public final List<FinderObject> dor()
  {
    AppMethodBeat.i(290099);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
      AppMethodBeat.o(290099);
      throw ((Throwable)localObject);
    }
    localObject = ((bgs)localObject).object;
    p.j(localObject, "(rr.responseProtoBuf as …iStreamResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(290099);
    return localObject;
  }
  
  public final int getType()
  {
    return 5225;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPoiStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ce
 * JD-Core Version:    0.7.0.1
 */