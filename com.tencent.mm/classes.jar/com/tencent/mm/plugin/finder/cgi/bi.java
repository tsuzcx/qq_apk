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
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.protocal.protobuf.atx;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetDraft;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "finderUserName", "", "objectType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFinderUserName", "()Ljava/lang/String;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getObjectType", "()I", "getPullType", "setPullType", "(I)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getObjectList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getResponseLastBuffer", "getType", "hasMore", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bi
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xcP;
  private i callback;
  public d lKU;
  private final b lastBuffer;
  private final int objectType;
  private int pullType;
  private final String whH;
  
  static
  {
    AppMethodBeat.i(285402);
    xcP = new a((byte)0);
    AppMethodBeat.o(285402);
  }
  
  public bi(String paramString, int paramInt1, b paramb, int paramInt2, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(285401);
    this.whH = paramString;
    this.objectType = paramInt1;
    this.lastBuffer = paramb;
    paramString = new d.a();
    paramString.vD(getType());
    paramString.TW("/cgi-bin/micromsg-bin/findergetdraft");
    paramb = new atw();
    paramb.username = this.whH;
    paramb.objectType = this.objectType;
    paramb.lastBuffer = this.lastBuffer;
    ao localao = ao.xcj;
    paramb.RLM = ao.a(parambid);
    paramString.c((a)paramb);
    paramString.d((a)new atx());
    paramString = paramString.bgN();
    p.j(paramString, "builder.buildInstance()");
    this.lKU = paramString;
    this.pullType = paramInt2;
    Log.i("Finder.NetSceneFinderGetDraft", "NetSceneFinderGetDraft init finderUserName " + this.whH + " objectType: " + this.objectType + " lastBuffer:" + this.lastBuffer);
    AppMethodBeat.o(285401);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(285400);
    Log.i("Finder.NetSceneFinderMVUserPage", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.lKU.bhY() == null))
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetDraftResponse");
      AppMethodBeat.o(285400);
      throw paramString;
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(285400);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(285399);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(285399);
    return i;
  }
  
  public final int getType()
  {
    return 5801;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetDraft$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bi
 * JD-Core Version:    0.7.0.1
 */