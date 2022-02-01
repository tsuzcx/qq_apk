package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.protocal.protobuf.dbz;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends com.tencent.mm.plugin.soter.b.d
  implements k
{
  private g callback;
  public final b rr;
  public String skD;
  public boolean skL;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(64453);
    this.skD = "";
    this.skL = false;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hvt = new dbz();
    ((b.a)localObject1).hvu = new dca();
    ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
    ((b.a)localObject1).funcId = 1586;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).aAz();
    localObject1 = (dbz)this.rr.hvr.hvw;
    Object localObject2 = com.tencent.mm.plugin.soter.d.d.dTq();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject2).znE;
    localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).znF;
    ac.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", new Object[] { str, localObject2 });
    ((dbz)localObject1).znE = str;
    ((dbz)localObject1).znF = ((String)localObject2);
    ((dbz)localObject1).scene = 0;
    ((dbz)localObject1).FLo = paramInt;
    ((dbz)localObject1).FLp = 1;
    AppMethodBeat.o(64453);
  }
  
  public final void Fn(int paramInt)
  {
    AppMethodBeat.i(64457);
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64457);
  }
  
  public final void cHM()
  {
    AppMethodBeat.i(64456);
    ac.e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64456);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64455);
    ac.d("MicroMsg.NetSceneSoterGetPayChallenge", "hy: onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramq = (dca)((b)paramq).hvs.hvw;
      this.skD = paramq.skD;
      p.skJ.skD = this.skD;
      if (1 != paramq.FLq) {
        break label179;
      }
      bool = true;
      this.skL = bool;
      if (1 != paramq.FLq) {
        break label185;
      }
    }
    label179:
    label185:
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.NetSceneSoterGetPayChallenge", "get pay challenge needChangeAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
      p.skJ.skL = this.skL;
      ac.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", new Object[] { this.skD, Boolean.valueOf(this.skL) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.a
 * JD-Core Version:    0.7.0.1
 */