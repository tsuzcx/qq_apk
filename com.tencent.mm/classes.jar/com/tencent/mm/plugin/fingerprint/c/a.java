package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.protocal.protobuf.cwn;
import com.tencent.mm.protocal.protobuf.cwo;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends com.tencent.mm.plugin.soter.b.d
  implements k
{
  private g callback;
  public String rcj;
  public boolean rcr;
  public final b rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(64453);
    this.rcj = "";
    this.rcr = false;
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new cwn();
    ((b.a)localObject1).gUV = new cwo();
    ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
    ((b.a)localObject1).funcId = 1586;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).atI();
    localObject1 = (cwn)this.rr.gUS.gUX;
    Object localObject2 = com.tencent.mm.plugin.soter.d.d.dEQ();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject2).yaF;
    localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).yaG;
    ad.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", new Object[] { str, localObject2 });
    ((cwn)localObject1).yaF = str;
    ((cwn)localObject1).yaG = ((String)localObject2);
    ((cwn)localObject1).scene = 0;
    ((cwn)localObject1).Eop = paramInt;
    ((cwn)localObject1).Eoq = 1;
    AppMethodBeat.o(64453);
  }
  
  public final void Dr(int paramInt)
  {
    AppMethodBeat.i(64457);
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64457);
  }
  
  public final void cuA()
  {
    AppMethodBeat.i(64456);
    ad.e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64456);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64455);
    ad.d("MicroMsg.NetSceneSoterGetPayChallenge", "hy: onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramq = (cwo)((b)paramq).gUT.gUX;
      this.rcj = paramq.rcj;
      p.rcp.rcj = this.rcj;
      if (1 != paramq.Eor) {
        break label179;
      }
      bool = true;
      this.rcr = bool;
      if (1 != paramq.Eor) {
        break label185;
      }
    }
    label179:
    label185:
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.NetSceneSoterGetPayChallenge", "get pay challenge needChangeAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
      p.rcp.rcr = this.rcr;
      ad.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", new Object[] { this.rcj, Boolean.valueOf(this.rcr) });
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(64455);
      return;
      bool = false;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(64454);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(64454);
    return i;
  }
  
  public final int getType()
  {
    return 1586;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.a
 * JD-Core Version:    0.7.0.1
 */