package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneDeleteFinderObject;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "objectId", "", "objectNonceId", "(Ljava/lang/String;JLjava/lang/String;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getDelId", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class m
  extends n
  implements com.tencent.mm.network.k
{
  private String TAG;
  private g callback;
  public long objectId;
  private com.tencent.mm.al.b rr;
  
  public m(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(165207);
    this.TAG = "Finder.NetSceneDeleteFinderObject";
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.wg("/cgi-bin/micromsg-bin/finderdelfeed");
    locala.nB(getType());
    aid localaid = new aid();
    localaid.id = paramLong;
    localaid.objectNonceId = paramString2;
    localaid.DkK = paramString1;
    paramString1 = am.KJy;
    localaid.Dkw = am.fRS();
    locala.c((com.tencent.mm.bx.a)localaid);
    locala.d((com.tencent.mm.bx.a)new aie());
    paramString1 = locala.atI();
    d.g.b.k.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    this.objectId = paramLong;
    AppMethodBeat.o(165207);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165205);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165205);
    return i;
  }
  
  public final int getType()
  {
    return 3627;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165206);
    ad.i(this.TAG, "errType " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
      if (com.tencent.mm.plugin.finder.storage.logic.b.a.qH(this.objectId))
      {
        paramq = new gw();
        paramq.dkx.id = this.objectId;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)paramq);
      }
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(165206);
      return;
    }
    AppMethodBeat.o(165206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.m
 * JD-Core Version:    0.7.0.1
 */