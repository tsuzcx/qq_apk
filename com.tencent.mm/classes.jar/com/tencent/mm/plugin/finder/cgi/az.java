package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "query", "", "offset", "", "requestId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class az
  extends ac
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.al.b hWL;
  public arf rJS;
  
  public az(String paramString1, int paramInt1, String paramString2, com.tencent.mm.bx.b paramb, int paramInt2, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201160);
    this.TAG = "Finder.NetSceneFinderSearch";
    b.a locala = new b.a();
    locala.oP(getType());
    locala.Dl("/cgi-bin/micromsg-bin/findersearch");
    are localare = new are();
    localare.query = paramString1;
    localare.offset = paramInt1;
    localare.sbF = paramb;
    localare.scene = paramInt2;
    localare.dwW = paramString2;
    paramString2 = v.rIR;
    localare.Glv = v.a(paramaqy);
    locala.c((a)localare);
    locala.d((a)new arf());
    paramString2 = locala.aDC();
    p.g(paramString2, "builder.buildInstance()");
    this.hWL = paramString2;
    ad.i(this.TAG, "NetSceneFinderSearch init query " + paramString1 + " offset " + paramInt1);
    this.rJS = new arf();
    AppMethodBeat.o(201160);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(165268);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.hWL, (k)this);
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
    ad.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.hWL.aEF();
    if (paramq == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
      AppMethodBeat.o(165269);
      throw paramString;
    }
    this.rJS = ((arf)paramq);
    paramq = this.callback;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramString = this.rIl;
    if (paramString != null)
    {
      paramq = this.rJS.rtM;
      p.g(paramq, "response.objectList");
      paramq = ((Iterable)paramq).iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (FinderObject)paramq.next();
        String str = paramArrayOfByte.sessionBuffer;
        if (str != null)
        {
          h localh = h.soM;
          h.d(paramArrayOfByte.id, paramString.rTD, str);
        }
      }
      AppMethodBeat.o(165269);
      return;
    }
    AppMethodBeat.o(165269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.az
 * JD-Core Version:    0.7.0.1
 */