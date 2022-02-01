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
import com.tencent.mm.protocal.protobuf.ayc;
import com.tencent.mm.protocal.protobuf.ayd;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetWindowProducts;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "finderUsername", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFinderUsername", "()Ljava/lang/String;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getLastBuffer", "getProducts", "", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "getShopOpGuide", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cu
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ACH;
  private com.tencent.mm.am.h callback;
  public final String finderUsername;
  public c oDw;
  public int pullType;
  
  static
  {
    AppMethodBeat.i(336619);
    ACH = new a((byte)0);
    AppMethodBeat.o(336619);
  }
  
  public cu(String paramString, b paramb, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336616);
    this.finderUsername = paramString;
    paramString = new c.a();
    paramString.funcId = getType();
    paramString.uri = "/cgi-bin/micromsg-bin/findergetallwindowproducts";
    ayc localayc = new ayc();
    localayc.YIZ = this.finderUsername;
    localayc.ZEQ = paramb;
    paramb = bi.ABn;
    localayc.YIY = bi.a(parambui);
    paramString.otE = ((a)localayc);
    paramString.otF = ((a)new ayd());
    paramString = paramString.bEF();
    kotlin.g.b.s.s(paramString, "builder.buildInstance()");
    this.oDw = paramString;
    Log.i("NetSceneFinderGetWindowProducts", kotlin.g.b.s.X("init finderUserName ", this.finderUsername));
    AppMethodBeat.o(336616);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336632);
    Log.i("NetSceneFinderGetWindowProducts", "onCgiEnd: errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336632);
  }
  
  public final List<bzc> dWk()
  {
    AppMethodBeat.i(336634);
    Object localObject = c.c.b(this.oDw.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetAllWindowProductsResponse");
      AppMethodBeat.o(336634);
      throw ((Throwable)localObject);
    }
    localObject = ((ayd)localObject).ZJa;
    kotlin.g.b.s.s(localObject, "commReqResp.responseProt…roductsResponse).products");
    localObject = (List)localObject;
    AppMethodBeat.o(336634);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336624);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(336624);
    return i;
  }
  
  public final b getLastBuffer()
  {
    AppMethodBeat.i(336640);
    Object localObject = c.c.b(this.oDw.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetAllWindowProductsResponse");
      AppMethodBeat.o(336640);
      throw ((Throwable)localObject);
    }
    localObject = ((ayd)localObject).ZEQ;
    AppMethodBeat.o(336640);
    return localObject;
  }
  
  public final int getType()
  {
    return 5244;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetWindowProducts$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cu
 * JD-Core Version:    0.7.0.1
 */