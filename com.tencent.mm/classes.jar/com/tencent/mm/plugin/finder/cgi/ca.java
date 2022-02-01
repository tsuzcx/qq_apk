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
import com.tencent.mm.plugin.i.a.y.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPoiStream;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/SnsLocation;Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getNoticeWording", "", "getPoiDetail", "Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "getRespLastBuffer", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ca
  extends ax
  implements m
{
  public static final a twa;
  private i callback;
  public int pullType;
  public d rr;
  
  static
  {
    AppMethodBeat.i(242491);
    twa = new a((byte)0);
    AppMethodBeat.o(242491);
  }
  
  private ca(eaa parameaa, y.a parama, b paramb)
  {
    super(null);
    AppMethodBeat.i(242490);
    d.a locala = new d.a();
    locala.sG(getType());
    bag localbag = new bag();
    am localam = am.tuw;
    localbag.LBM = am.a(null);
    localbag.dRy = parameaa.LIb;
    localbag.dTj = parameaa.LbC;
    localbag.latitude = parameaa.LbD;
    localbag.LJW = parama.ordinal();
    localbag.LDs = paramb;
    parameaa = am.tuw;
    localbag.LAv = am.cXZ();
    locala.c((a)localbag);
    locala.sG(getType());
    locala.d((a)new bah());
    locala.MB("/cgi-bin/micromsg-bin/finderpoistream");
    parameaa = locala.aXF();
    p.g(parameaa, "builder.buildInstance()");
    this.rr = parameaa;
    AppMethodBeat.o(242490);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242488);
    Log.i("Finder.NetSceneFinderPoiStream", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = new StringBuilder("server increatment size:");
    a locala = this.rr.aYK();
    if (locala == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
      AppMethodBeat.o(242488);
      throw paramString;
    }
    Log.i("Finder.NetSceneFinderPoiStream", ((bah)locala).object.size());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (this.rr.aYK() == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
        AppMethodBeat.o(242488);
        throw paramString;
      }
      params = ((Iterable)cYD()).iterator();
      while (params.hasNext()) {
        d((FinderObject)params.next());
      }
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242488);
      return;
    }
    AppMethodBeat.o(242488);
  }
  
  public final List<FinderObject> cYD()
  {
    AppMethodBeat.i(242489);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
      AppMethodBeat.o(242489);
      throw ((Throwable)localObject);
    }
    localObject = ((bah)localObject).object;
    p.g(localObject, "(rr.responseProtoBuf as …iStreamResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(242489);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242487);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242487);
    return i;
  }
  
  public final int getType()
  {
    return 5225;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPoiStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ca
 * JD-Core Version:    0.7.0.1
 */