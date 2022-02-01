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
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "query", "", "offset", "", "requestId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "hotWordSessionBuffer", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "isFromHistory", "", "()Z", "setFromHistory", "(Z)V", "isFromHotSearch", "setFromHotSearch", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "isHotWordRequest", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cf
  extends ax
{
  public static final a twm;
  private final String TAG;
  private i callback;
  private d iUB;
  public boolean twi;
  public boolean twj;
  private b twk;
  public bcb twl;
  
  static
  {
    AppMethodBeat.i(242504);
    twm = new a((byte)0);
    AppMethodBeat.o(242504);
  }
  
  public cf(String paramString1, int paramInt1, String paramString2, b paramb1, int paramInt2, bbn parambbn, b paramb2)
  {
    super(parambbn);
    AppMethodBeat.i(242502);
    this.TAG = "Finder.NetSceneFinderSearch";
    d.a locala = new d.a();
    locala.sG(getType());
    locala.MB("/cgi-bin/micromsg-bin/findersearch");
    bca localbca = new bca();
    localbca.query = paramString1;
    localbca.offset = paramInt1;
    localbca.tVM = paramb1;
    localbca.scene = paramInt2;
    localbca.dPI = paramString2;
    paramString2 = am.tuw;
    localbca.uli = am.a(parambbn);
    localbca.LLg = paramb2;
    this.twk = paramb2;
    locala.c((a)localbca);
    locala.d((a)new bcb());
    paramString2 = locala.aXF();
    p.g(paramString2, "builder.buildInstance()");
    this.iUB = paramString2;
    Log.i(this.TAG, "NetSceneFinderSearch init query " + paramString1 + " offset " + paramInt1);
    this.twl = new bcb();
    AppMethodBeat.o(242502);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242501);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.iUB.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
      AppMethodBeat.o(242501);
      throw paramString;
    }
    this.twl = ((bcb)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    paramString = this.ttO;
    if (paramString != null)
    {
      params = this.twl.tbD;
      p.g(params, "response.objectList");
      params = ((Iterable)params).iterator();
      while (params.hasNext())
      {
        FinderObject localFinderObject = (FinderObject)params.next();
        String str = localFinderObject.sessionBuffer;
        if (str != null)
        {
          k localk = k.vfA;
          k.e(localFinderObject.id, paramString.tCE, str);
        }
      }
      AppMethodBeat.o(242501);
      return;
    }
    AppMethodBeat.o(242501);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(165268);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(165268);
    return i;
  }
  
  public final int getType()
  {
    return 3820;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch$Companion;", "", "()V", "GET_HOT_WORD_SCENE", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cf
 * JD-Core Version:    0.7.0.1
 */