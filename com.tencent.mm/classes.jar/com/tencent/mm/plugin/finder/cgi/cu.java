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
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bik;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneGetHotWordList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "scene", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "hotWordSessionBuffer", "objHotWordInfoBuffer", "limit", "(ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;I)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "isPreload", "", "()Z", "setPreload", "(Z)V", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchGetHotWordListResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getHotWords", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "getLastBuffer", "getResponse", "getTitle", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class cu
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private d lKU;
  public boolean ooW;
  public bil xet;
  
  private cu(int paramInt, b paramb1, bid parambid, b paramb2, b paramb3)
  {
    super(parambid);
    AppMethodBeat.i(277670);
    this.TAG = "Finder.NetSceneGetHotWordList";
    d.a locala = new d.a();
    locala.vD(getType());
    locala.TW("/cgi-bin/micromsg-bin/findersearchgethotwordlist");
    bik localbik = new bik();
    ao localao = ao.xcj;
    localbik.yjp = ao.a(parambid);
    localbik.scene = paramInt;
    localbik.SSK = paramb1;
    localbik.SSL = paramb2;
    localbik.SSM = paramb3;
    localbik.limit = 0;
    locala.c((a)localbik);
    locala.d((a)new bil());
    paramb1 = locala.bgN();
    p.j(paramb1, "builder.buildInstance()");
    this.lKU = paramb1;
    Log.i(this.TAG, "NetSceneGetHotWordList init");
    AppMethodBeat.o(277670);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(277668);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.lKU.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchGetHotWordListResponse");
        AppMethodBeat.o(277668);
        throw paramString;
      }
      this.xet = ((bil)params);
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(277668);
      return;
    }
    AppMethodBeat.o(277668);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(277666);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(277666);
    return i;
  }
  
  public final LinkedList<bio> dpg()
  {
    bil localbil = this.xet;
    if (localbil != null) {
      return localbil.SRt;
    }
    return null;
  }
  
  public final int getType()
  {
    return 4069;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cu
 * JD-Core Version:    0.7.0.1
 */