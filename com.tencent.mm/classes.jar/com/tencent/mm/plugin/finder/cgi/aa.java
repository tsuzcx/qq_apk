package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "query", "", "offset", "", "requestId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderSearchResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class aa
  extends ap
{
  private final String TAG;
  private g callback;
  private com.tencent.mm.al.b hdD;
  public ala qpw;
  
  public aa(String paramString1, int paramInt1, String paramString2, com.tencent.mm.bx.b paramb, int paramInt2, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197334);
    this.TAG = "Finder.NetSceneFinderSearch";
    b.a locala = new b.a();
    locala.nB(getType());
    locala.wg("/cgi-bin/micromsg-bin/findersearch");
    akz localakz = new akz();
    localakz.query = paramString1;
    localakz.offset = paramInt1;
    localakz.qHz = paramb;
    localakz.scene = paramInt2;
    localakz.dnB = paramString2;
    paramString2 = am.KJy;
    localakz.Dkw = am.a(paramdzp);
    locala.c((a)localakz);
    locala.d((a)new ala());
    paramString2 = locala.atI();
    d.g.b.k.g(paramString2, "builder.buildInstance()");
    this.hdD = paramString2;
    ad.i(this.TAG, "NetSceneFinderSearch init query " + paramString1 + " offset " + paramInt1);
    this.qpw = new ala();
    AppMethodBeat.o(197334);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165268);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.hdD, (com.tencent.mm.network.k)this);
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
    paramq = this.hdD.auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
      AppMethodBeat.o(165269);
      throw paramString;
    }
    this.qpw = ((ala)paramq);
    paramq = this.callback;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramString = this.contextObj;
    if (paramString != null)
    {
      paramq = this.qpw.qbe;
      d.g.b.k.g(paramq, "response.objectList");
      paramq = ((Iterable)paramq).iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (FinderObject)paramq.next();
        String str = paramArrayOfByte.sessionBuffer;
        if (str != null)
        {
          com.tencent.mm.plugin.finder.report.b localb = com.tencent.mm.plugin.finder.report.b.qFq;
          com.tencent.mm.plugin.finder.report.b.j(paramArrayOfByte.id, paramString.qqE, str);
        }
      }
      AppMethodBeat.o(165269);
      return;
    }
    AppMethodBeat.o(165269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aa
 * JD-Core Version:    0.7.0.1
 */