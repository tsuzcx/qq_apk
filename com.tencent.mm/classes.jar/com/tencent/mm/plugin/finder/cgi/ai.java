package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFansList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFansList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ai
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  public com.tencent.mm.ak.b rr;
  
  public ai(com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(165220);
    this.TAG = "Finder.NetSceneFinderGetFansList";
    b.a locala = new b.a();
    locala.oS(getType());
    anx localanx = new anx();
    localanx.sbR = com.tencent.mm.model.v.aAK();
    localanx.skw = paramb;
    paramb = v.rRb;
    localanx.GDR = v.czz();
    locala.c((a)localanx);
    locala.d((a)new any());
    locala.DN("/cgi-bin/micromsg-bin/findergetfanslist");
    paramb = locala.aDS();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ae.i(this.TAG, "NetSceneFinderGetFansList");
    AppMethodBeat.o(165220);
  }
  
  public final LinkedList<anb> czH()
  {
    AppMethodBeat.i(165219);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
      AppMethodBeat.o(165219);
      throw ((Throwable)localObject);
    }
    localObject = ((any)localObject).GFL;
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
    ae.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 9L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.gkB();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165218);
      return;
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 10L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ai
 * JD-Core Version:    0.7.0.1
 */