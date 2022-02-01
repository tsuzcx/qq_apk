package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "query", "", "offset", "", "requestId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ba
  extends ad
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.ak.b hZD;
  public aru rSg;
  
  public ba(String paramString1, int paramInt1, String paramString2, com.tencent.mm.bw.b paramb, int paramInt2, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201582);
    this.TAG = "Finder.NetSceneFinderSearch";
    b.a locala = new b.a();
    locala.oS(getType());
    locala.DN("/cgi-bin/micromsg-bin/findersearch");
    art localart = new art();
    localart.query = paramString1;
    localart.offset = paramInt1;
    localart.skw = paramb;
    localart.scene = paramInt2;
    localart.dyb = paramString2;
    paramString2 = v.rRb;
    localart.GDR = v.a(paramarn);
    locala.c((a)localart);
    locala.d((a)new aru());
    paramString2 = locala.aDS();
    p.g(paramString2, "builder.buildInstance()");
    this.hZD = paramString2;
    ae.i(this.TAG, "NetSceneFinderSearch init query " + paramString1 + " offset " + paramInt1);
    this.rSg = new aru();
    AppMethodBeat.o(201582);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(165268);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.hZD, (k)this);
    AppMethodBeat.o(165268);
    return i;
  }
  
  public final int getType()
  {
    return 3820;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165269);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ae.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.hZD.aEV();
    if (paramq == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
      AppMethodBeat.o(165269);
      throw paramString;
    }
    this.rSg = ((aru)paramq);
    paramq = this.callback;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramString = this.rQw;
    if (paramString != null)
    {
      paramq = this.rSg.rBY;
      p.g(paramq, "response.objectList");
      paramq = ((Iterable)paramq).iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (FinderObject)paramq.next();
        String str = paramArrayOfByte.sessionBuffer;
        if (str != null)
        {
          i locali = i.syT;
          i.d(paramArrayOfByte.id, paramString.sch, str);
        }
      }
      AppMethodBeat.o(165269);
      return;
    }
    AppMethodBeat.o(165269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ba
 * JD-Core Version:    0.7.0.1
 */