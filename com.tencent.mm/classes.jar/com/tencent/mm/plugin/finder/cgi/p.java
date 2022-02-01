package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.aix;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFansList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFansList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class p
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g callback;
  public com.tencent.mm.al.b rr;
  
  public p(com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(165220);
    this.TAG = "Finder.NetSceneFinderGetFansList";
    b.a locala = new b.a();
    locala.nB(getType());
    aix localaix = new aix();
    localaix.finderUsername = u.aqO();
    localaix.qHz = paramb;
    paramb = am.KJy;
    localaix.Dkw = am.fRS();
    locala.c((a)localaix);
    locala.d((a)new aiy());
    locala.wg("/cgi-bin/micromsg-bin/findergetfanslist");
    paramb = locala.atI();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ad.i(this.TAG, "NetSceneFinderGetFansList");
    AppMethodBeat.o(165220);
  }
  
  public final LinkedList<aii> ckH()
  {
    AppMethodBeat.i(165219);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
      AppMethodBeat.o(165219);
      throw ((Throwable)localObject);
    }
    localObject = ((aiy)localObject).Dlq;
    AppMethodBeat.o(165219);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(165217);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
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
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1279L, 9L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.fvU();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165218);
      return;
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1279L, 10L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.p
 * JD-Core Version:    0.7.0.1
 */