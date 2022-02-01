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
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetDraft;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "finderUserName", "", "objectType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFinderUserName", "()Ljava/lang/String;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getObjectType", "()I", "getPullType", "setPullType", "(I)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getObjectList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getResponseLastBuffer", "getType", "hasMore", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bf
  extends ax
{
  public static final a tvi;
  private i callback;
  public d iUB;
  private final b lastBuffer;
  private final int objectType;
  private int pullType;
  private final String sBN;
  
  static
  {
    AppMethodBeat.i(242388);
    tvi = new a((byte)0);
    AppMethodBeat.o(242388);
  }
  
  public bf(String paramString, int paramInt1, b paramb, int paramInt2, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242387);
    this.sBN = paramString;
    this.objectType = paramInt1;
    this.lastBuffer = paramb;
    paramString = new d.a();
    paramString.sG(getType());
    paramString.MB("/cgi-bin/micromsg-bin/findergetdraft");
    paramb = new arv();
    paramb.username = this.sBN;
    paramb.objectType = this.objectType;
    paramb.lastBuffer = this.lastBuffer;
    am localam = am.tuw;
    paramb.LBM = am.a(parambbn);
    paramString.c((a)paramb);
    paramString.d((a)new arw());
    paramString = paramString.aXF();
    p.g(paramString, "builder.buildInstance()");
    this.iUB = paramString;
    this.pullType = paramInt2;
    Log.i("Finder.NetSceneFinderGetDraft", "NetSceneFinderGetDraft init finderUserName " + this.sBN + " objectType: " + this.objectType + " lastBuffer:" + this.lastBuffer);
    AppMethodBeat.o(242387);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242386);
    Log.i("Finder.NetSceneFinderMVUserPage", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.iUB.aYK() == null))
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetDraftResponse");
      AppMethodBeat.o(242386);
      throw paramString;
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(242386);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242385);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(242385);
    return i;
  }
  
  public final int getType()
  {
    return 5801;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetDraft$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bf
 * JD-Core Version:    0.7.0.1
 */