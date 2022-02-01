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
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetWindowProducts;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "finderUsername", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFinderUsername", "()Ljava/lang/String;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getLastBuffer", "getProducts", "", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "getShopOpGuide", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bw
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xdk;
  private i callback;
  public final String finderUsername;
  public d lKU;
  public int pullType;
  
  static
  {
    AppMethodBeat.i(278718);
    xdk = new a((byte)0);
    AppMethodBeat.o(278718);
  }
  
  public bw(String paramString, b paramb, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(278717);
    this.finderUsername = paramString;
    paramString = new d.a();
    paramString.vD(getType());
    paramString.TW("/cgi-bin/micromsg-bin/findergetallwindowproducts");
    atm localatm = new atm();
    localatm.RLN = this.finderUsername;
    localatm.SDI = paramb;
    paramb = ao.xcj;
    localatm.RLM = ao.a(parambid);
    paramString.c((a)localatm);
    paramString.d((a)new atn());
    paramString = paramString.bgN();
    p.j(paramString, "builder.buildInstance()");
    this.lKU = paramString;
    Log.i("NetSceneFinderGetWindowProducts", "init finderUserName " + this.finderUsername);
    AppMethodBeat.o(278717);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(278714);
    Log.i("NetSceneFinderGetWindowProducts", "onCgiEnd: errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(278714);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(278713);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(278713);
    return i;
  }
  
  public final List<blm> doz()
  {
    AppMethodBeat.i(278715);
    Object localObject = this.lKU.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetAllWindowProductsResponse");
      AppMethodBeat.o(278715);
      throw ((Throwable)localObject);
    }
    localObject = ((atn)localObject).SGp;
    p.j(localObject, "(commReqResp.responsePro…roductsResponse).products");
    localObject = (List)localObject;
    AppMethodBeat.o(278715);
    return localObject;
  }
  
  public final b getLastBuffer()
  {
    AppMethodBeat.i(278716);
    Object localObject = this.lKU.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetAllWindowProductsResponse");
      AppMethodBeat.o(278716);
      throw ((Throwable)localObject);
    }
    localObject = ((atn)localObject).SDI;
    AppMethodBeat.o(278716);
    return localObject;
  }
  
  public final int getType()
  {
    return 5244;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetWindowProducts$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bw
 * JD-Core Version:    0.7.0.1
 */