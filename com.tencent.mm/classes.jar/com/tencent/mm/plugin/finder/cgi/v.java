package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneDeleteFinderObject;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "objectId", "", "objectNonceId", "(Ljava/lang/String;JLjava/lang/String;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getDelId", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class v
  extends n
  implements com.tencent.mm.network.k
{
  private String TAG;
  private g callback;
  public long qXP;
  private com.tencent.mm.ak.b rr;
  
  public v(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(165207);
    this.TAG = "Finder.NetSceneDeleteFinderObject";
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.Am("/cgi-bin/micromsg-bin/finderdelfeed");
    locala.op(getType());
    ajn localajn = new ajn();
    localajn.id = paramLong;
    localajn.objectNonceId = paramString2;
    localajn.EEg = paramString1;
    paramString1 = q.qXH;
    localajn.EDL = q.csi();
    locala.c((com.tencent.mm.bw.a)localajn);
    locala.d((com.tencent.mm.bw.a)new ajo());
    paramString1 = locala.aAz();
    d.g.b.k.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    this.qXP = paramLong;
    AppMethodBeat.o(165207);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165205);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165205);
    return i;
  }
  
  public final int getType()
  {
    return 3627;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165206);
    ac.i(this.TAG, "errType " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
      if (com.tencent.mm.plugin.finder.storage.logic.b.a.vf(this.qXP))
      {
        paramq = new gx();
        paramq.dhS.id = this.qXP;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)paramq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.v
 * JD-Core Version:    0.7.0.1
 */