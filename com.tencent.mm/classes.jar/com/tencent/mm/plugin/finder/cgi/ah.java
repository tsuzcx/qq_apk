package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFansList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFansList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ah
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  public com.tencent.mm.al.b rr;
  
  public ah(com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(165220);
    this.TAG = "Finder.NetSceneFinderGetFansList";
    b.a locala = new b.a();
    locala.oP(getType());
    ank localank = new ank();
    localank.rTn = u.aAu();
    localank.sbF = paramb;
    paramb = v.rIR;
    localank.Glv = v.cxY();
    locala.c((a)localank);
    locala.d((a)new anl());
    locala.Dl("/cgi-bin/micromsg-bin/findergetfanslist");
    paramb = locala.aDC();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ad.i(this.TAG, "NetSceneFinderGetFansList");
    AppMethodBeat.o(165220);
  }
  
  public final LinkedList<amp> cyg()
  {
    AppMethodBeat.i(165219);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
      AppMethodBeat.o(165219);
      throw ((Throwable)localObject);
    }
    localObject = ((anl)localObject).GmE;
    AppMethodBeat.o(165219);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(165217);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165217);
    return i;
  }
  
  public final int getType()
  {
    return 3531;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165218);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 9L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.gfZ();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165218);
      return;
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 10L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ah
 * JD-Core Version:    0.7.0.1
 */