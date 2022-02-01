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
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneGetHotWordList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "scene", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "hotWordSessionBuffer", "objHotWordInfoBuffer", "limit", "(ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;I)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "isPreload", "", "()Z", "setPreload", "(Z)V", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchGetHotWordListResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getHotWords", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "getLastBuffer", "getResponse", "getTitle", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dw
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public buu ADG;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private c oDw;
  public boolean rsE;
  
  private dw(int paramInt, b paramb1, bui parambui, b paramb2, b paramb3)
  {
    super(parambui);
    AppMethodBeat.i(336769);
    this.TAG = "Finder.NetSceneGetHotWordList";
    c.a locala = new c.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/micromsg-bin/findersearchgethotwordlist";
    but localbut = new but();
    bi localbi = bi.ABn;
    localbut.CJv = bi.a(parambui);
    localbut.scene = paramInt;
    localbut.aacm = paramb1;
    localbut.aacn = paramb2;
    localbut.aaco = paramb3;
    localbut.limit = 0;
    locala.otE = ((a)localbut);
    locala.otF = ((a)new buu());
    paramb1 = locala.bEF();
    kotlin.g.b.s.s(paramb1, "builder.buildInstance()");
    this.oDw = paramb1;
    Log.i(this.TAG, "NetSceneGetHotWordList init");
    AppMethodBeat.o(336769);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336792);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.oDw.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchGetHotWordListResponse");
        AppMethodBeat.o(336792);
        throw paramString;
      }
      this.ADG = ((buu)params);
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336792);
  }
  
  public final LinkedList<bux> dWH()
  {
    buu localbuu = this.ADG;
    if (localbuu == null) {
      return null;
    }
    return localbuu.aaam;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336788);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(336788);
    return i;
  }
  
  public final int getType()
  {
    return 4069;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dw
 * JD-Core Version:    0.7.0.1
 */