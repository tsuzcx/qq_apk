package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "query", "", "offset", "", "requestId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class as
  extends w
{
  private final String TAG;
  private g callback;
  private com.tencent.mm.ak.b hEg;
  public ant qYC;
  
  public as(String paramString1, int paramInt1, String paramString2, com.tencent.mm.bw.b paramb, int paramInt2, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201212);
    this.TAG = "Finder.NetSceneFinderSearch";
    b.a locala = new b.a();
    locala.op(getType());
    locala.Am("/cgi-bin/micromsg-bin/findersearch");
    ans localans = new ans();
    localans.query = paramString1;
    localans.offset = paramInt1;
    localans.rmJ = paramb;
    localans.scene = paramInt2;
    localans.dlj = paramString2;
    paramString2 = q.qXH;
    localans.EDL = q.a(paramanm);
    locala.c((a)localans);
    locala.d((a)new ant());
    paramString2 = locala.aAz();
    d.g.b.k.g(paramString2, "builder.buildInstance()");
    this.hEg = paramString2;
    ac.i(this.TAG, "NetSceneFinderSearch init query " + paramString1 + " offset " + paramInt1);
    this.qYC = new ant();
    AppMethodBeat.o(201212);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165268);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.hEg, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165268);
    return i;
  }
  
  public final int getType()
  {
    return 3820;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165269);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ac.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.hEg.aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
      AppMethodBeat.o(165269);
      throw paramString;
    }
    this.qYC = ((ant)paramq);
    paramq = this.callback;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramString = this.contextObj;
    if (paramString != null)
    {
      paramq = this.qYC.qJK;
      d.g.b.k.g(paramq, "response.objectList");
      paramq = ((Iterable)paramq).iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (FinderObject)paramq.next();
        String str = paramArrayOfByte.sessionBuffer;
        if (str != null)
        {
          d locald = d.rxr;
          d.d(paramArrayOfByte.id, paramString.rfR, str);
        }
      }
      AppMethodBeat.o(165269);
      return;
    }
    AppMethodBeat.o(165269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.as
 * JD-Core Version:    0.7.0.1
 */