package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.protocal.protobuf.cfo;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends com.tencent.mm.plugin.soter.b.d
  implements k
{
  private f callback;
  public String mGC;
  public boolean mGD;
  public final b rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(41568);
    this.mGC = "";
    this.mGD = false;
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new cfo();
    ((b.a)localObject1).fsY = new cfp();
    ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
    ((b.a)localObject1).funcId = 1586;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).ado();
    localObject1 = (cfo)this.rr.fsV.fta;
    Object localObject2 = com.tencent.mm.plugin.soter.d.d.cyc();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject2).son;
    localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).kbP;
    ab.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", new Object[] { str, localObject2 });
    ((cfo)localObject1).son = str;
    ((cfo)localObject1).kbP = ((String)localObject2);
    ((cfo)localObject1).scene = 0;
    ((cfo)localObject1).xPV = paramInt;
    ((cfo)localObject1).xPW = 1;
    AppMethodBeat.o(41568);
  }
  
  public final void bzB()
  {
    AppMethodBeat.i(41571);
    ab.e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(41571);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41570);
    ab.d("MicroMsg.NetSceneSoterGetPayChallenge", "hy: onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramq = (cfp)((b)paramq).fsW.fta;
      this.mGC = paramq.mGC;
      x.uli.mGC = this.mGC;
      if (1 != paramq.xPX) {
        break label179;
      }
      bool = true;
      this.mGD = bool;
      if (1 != paramq.xPX) {
        break label185;
      }
    }
    label179:
    label185:
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.NetSceneSoterGetPayChallenge", "get pay challenge needChangeAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
      x.uli.mGD = this.mGD;
      ab.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", new Object[] { this.mGC, Boolean.valueOf(this.mGD) });
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(41570);
      return;
      bool = false;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(41569);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(41569);
    return i;
  }
  
  public final int getType()
  {
    return 1586;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(41572);
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(41572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.a
 * JD-Core Version:    0.7.0.1
 */