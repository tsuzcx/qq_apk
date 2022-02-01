package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bbu;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneGetHotWordList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchGetHotWordListResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getHotWords", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "getResponse", "getTitle", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class cp
  extends ax
{
  private final String TAG;
  private i callback;
  private d iUB;
  public bbv twE;
  
  private cp()
  {
    super(null);
    AppMethodBeat.i(242544);
    this.TAG = "Finder.NetSceneGetHotWordList";
    Object localObject = new d.a();
    ((d.a)localObject).sG(getType());
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/findersearchgethotwordlist");
    bbu localbbu = new bbu();
    am localam = am.tuw;
    localbbu.uli = am.a(null);
    ((d.a)localObject).c((a)localbbu);
    ((d.a)localObject).d((a)new bbv());
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.iUB = ((d)localObject);
    Log.i(this.TAG, "NetSceneGetHotWordList init");
    AppMethodBeat.o(242544);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242543);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.iUB.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchGetHotWordListResponse");
        AppMethodBeat.o(242543);
        throw paramString;
      }
      this.twE = ((bbv)params);
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242543);
      return;
    }
    AppMethodBeat.o(242543);
  }
  
  public final LinkedList<bby> cZn()
  {
    bbv localbbv = this.twE;
    if (localbbv != null) {
      return localbbv.LJY;
    }
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242542);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(242542);
    return i;
  }
  
  public final int getType()
  {
    return 4069;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cp
 * JD-Core Version:    0.7.0.1
 */