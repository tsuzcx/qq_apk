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
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.protocal.protobuf.biq;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/plugin/finder/cgi/INetSceneFinderSearch;", "query", "", "offset", "", "requestId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "hotWordSessionBuffer", "topicBuffer", "hotWordInfo", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "isFromHotSearch", "", "()Z", "setFromHotSearch", "(Z)V", "isPreload", "nextSearchHotWord", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "getQuery", "()Ljava/lang/String;", "getRequestId", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchResponse;", "searchType", "getSearchType", "()I", "setSearchType", "(I)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getNextHotWord", "getResponse", "getType", "isHotWordRequest", "isPreloadHotWord", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "setIsPreload", "setNextHotWord", "searchHotWord", "Companion", "plugin-finder_release"})
public final class cj
  extends com.tencent.mm.plugin.findersdk.b.g
  implements ar
{
  public static final a xeb;
  private final String TAG;
  private i callback;
  public final String fIY;
  private d lKU;
  public boolean ooW;
  public final String query;
  public int uMD;
  public boolean xdX;
  private b xdY;
  public bio xdZ;
  public bir xea;
  
  static
  {
    AppMethodBeat.i(292080);
    xeb = new a((byte)0);
    AppMethodBeat.o(292080);
  }
  
  public cj(String paramString1, int paramInt1, String paramString2, b paramb1, int paramInt2, bid parambid, b paramb2, b paramb3, b paramb4)
  {
    super(parambid);
    AppMethodBeat.i(292078);
    this.query = paramString1;
    this.fIY = paramString2;
    this.TAG = "Finder.NetSceneFinderSearch";
    this.uMD = 1;
    paramString1 = new d.a();
    paramString1.vD(getType());
    paramString1.TW("/cgi-bin/micromsg-bin/findersearch");
    paramString2 = new biq();
    paramString2.query = this.query;
    paramString2.offset = paramInt1;
    paramString2.xHE = paramb1;
    paramString2.scene = paramInt2;
    paramString2.fIY = this.fIY;
    paramb1 = ao.xcj;
    paramString2.yjp = ao.a(parambid);
    paramString2.SSL = paramb2;
    paramString2.SQZ = null;
    paramString2.SSM = paramb4;
    this.xdY = paramb2;
    paramString1.c((a)paramString2);
    paramString1.d((a)new bir());
    paramString1 = paramString1.bgN();
    p.j(paramString1, "builder.buildInstance()");
    this.lKU = paramString1;
    Log.i(this.TAG, "NetSceneFinderSearch init query " + this.query + " offset " + paramInt1);
    this.xea = new bir();
    AppMethodBeat.o(292078);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(292077);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.lKU.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
      AppMethodBeat.o(292077);
      throw paramString;
    }
    this.xea = ((bir)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    paramString = this.xbu;
    if (paramString != null)
    {
      params = this.xea.wHI;
      p.j(params, "response.objectList");
      params = ((Iterable)params).iterator();
      while (params.hasNext())
      {
        FinderObject localFinderObject = (FinderObject)params.next();
        if (localFinderObject.sessionBuffer != null)
        {
          n localn = n.zWF;
          p.j(localFinderObject, "finderObj");
          n.a(localFinderObject, paramString.xkX);
        }
      }
      AppMethodBeat.o(292077);
      return;
    }
    AppMethodBeat.o(292077);
  }
  
  public final bir dnS()
  {
    return this.xea;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165268);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(165268);
    return i;
  }
  
  public final int getType()
  {
    return 3820;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch$Companion;", "", "()V", "GET_HOT_WORD_SCENE", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cj
 * JD-Core Version:    0.7.0.1
 */