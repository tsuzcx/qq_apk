package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.protocal.protobuf.dig;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends com.tencent.mm.plugin.soter.b.d
  implements k
{
  private f callback;
  public final b rr;
  public String trY;
  public boolean tsg;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(64453);
    this.trY = "";
    this.tsg = false;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new dig();
    ((b.a)localObject1).hQG = new dih();
    ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
    ((b.a)localObject1).funcId = 1586;
    ((b.a)localObject1).hQH = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).aDS();
    localObject1 = (dig)this.rr.hQD.hQJ;
    Object localObject2 = com.tencent.mm.plugin.soter.d.d.ejm();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject2).AXb;
    localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).AXc;
    ae.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", new Object[] { str, localObject2 });
    ((dig)localObject1).AXb = str;
    ((dig)localObject1).AXc = ((String)localObject2);
    ((dig)localObject1).scene = 0;
    ((dig)localObject1).HPz = paramInt;
    ((dig)localObject1).HPA = 1;
    AppMethodBeat.o(64453);
  }
  
  public final void GZ(int paramInt)
  {
    AppMethodBeat.i(64457);
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64457);
  }
  
  public final void cSG()
  {
    AppMethodBeat.i(64456);
    ae.e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64456);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64455);
    ae.d("MicroMsg.NetSceneSoterGetPayChallenge", "hy: onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramq = (dih)((b)paramq).hQE.hQJ;
      this.trY = paramq.trY;
      p.tse.trY = this.trY;
      if (1 != paramq.HPB) {
        break label179;
      }
      bool = true;
      this.tsg = bool;
      if (1 != paramq.HPB) {
        break label185;
      }
    }
    label179:
    label185:
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.NetSceneSoterGetPayChallenge", "get pay challenge needChangeAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
      p.tse.tsg = this.tsg;
      ae.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", new Object[] { this.trY, Boolean.valueOf(this.tsg) });
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(64455);
      return;
      bool = false;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(64454);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(64454);
    return i;
  }
  
  public final int getType()
  {
    return 1586;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.a
 * JD-Core Version:    0.7.0.1
 */