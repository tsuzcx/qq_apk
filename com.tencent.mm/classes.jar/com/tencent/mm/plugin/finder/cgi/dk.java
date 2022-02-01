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
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.buz;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/plugin/finder/cgi/INetSceneFinderSearch;", "query", "", "offset", "", "requestId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "hotWordSessionBuffer", "topicBuffer", "hotWordInfo", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "isFromHotSearch", "", "()Z", "setFromHotSearch", "(Z)V", "isPreload", "nextSearchHotWord", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "getQuery", "()Ljava/lang/String;", "getRequestId", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchResponse;", "searchType", "getSearchType", "()I", "setSearchType", "(I)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getNextHotWord", "getResponse", "getType", "isHotWordRequest", "isPreloadHotWord", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "setIsPreload", "setNextHotWord", "searchHotWord", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dk
  extends com.tencent.mm.plugin.findersdk.b.h
  implements bm
{
  public static final a ADg;
  public boolean ADh;
  private b ADi;
  public bux ADj;
  public bva ADk;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  public final String hOG;
  private c oDw;
  public final String query;
  public boolean rsE;
  public int xVf;
  
  static
  {
    AppMethodBeat.i(336913);
    ADg = new a((byte)0);
    AppMethodBeat.o(336913);
  }
  
  public dk(String paramString1, int paramInt1, String paramString2, b paramb1, int paramInt2, bui parambui, b paramb2, b paramb3, b paramb4)
  {
    super(parambui);
    AppMethodBeat.i(336893);
    this.query = paramString1;
    this.hOG = paramString2;
    this.TAG = "Finder.NetSceneFinderSearch";
    this.xVf = 1;
    paramString1 = new c.a();
    paramString1.funcId = getType();
    paramString1.uri = "/cgi-bin/micromsg-bin/findersearch";
    paramString2 = new buz();
    paramString2.query = this.query;
    paramString2.offset = paramInt1;
    paramString2.BgS = paramb1;
    paramString2.scene = paramInt2;
    paramString2.hOG = this.hOG;
    paramb1 = bi.ABn;
    paramString2.CJv = bi.a(parambui);
    paramString2.aacn = paramb2;
    paramString2.ZZM = null;
    paramString2.aaco = paramb4;
    this.ADi = paramb2;
    paramb1 = new gdd();
    paramb1.acaX = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtE());
    parambui = paramString2.CJv;
    if (parambui != null) {
      parambui.ZEq = new b(paramb1.toByteArray());
    }
    paramb1 = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
    com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999700);
    paramString1.otE = ((a)paramString2);
    paramString1.otF = ((a)new bva());
    paramString1 = paramString1.bEF();
    kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
    this.oDw = paramString1;
    Log.i(this.TAG, "NetSceneFinderSearch init query " + this.query + " offset " + paramInt1);
    this.ADk = new bva();
    AppMethodBeat.o(336893);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336927);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = c.c.b(this.oDw.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
      AppMethodBeat.o(336927);
      throw paramString;
    }
    this.ADk = ((bva)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    paramString = getContextObj();
    if (paramString != null)
    {
      params = this.ADk.AdW;
      kotlin.g.b.s.s(params, "response.objectList");
      params = ((Iterable)params).iterator();
      while (params.hasNext())
      {
        FinderObject localFinderObject = (FinderObject)params.next();
        if (localFinderObject.sessionBuffer != null)
        {
          z localz = z.FrZ;
          kotlin.g.b.s.s(localFinderObject, "finderObj");
          z.a(localFinderObject, paramString.AJo);
        }
      }
    }
    AppMethodBeat.o(336927);
  }
  
  public final bva dVz()
  {
    return this.ADk;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165268);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(165268);
    return i;
  }
  
  public final int getType()
  {
    return 3820;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch$Companion;", "", "()V", "GET_HOT_WORD_SCENE", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dk
 * JD-Core Version:    0.7.0.1
 */