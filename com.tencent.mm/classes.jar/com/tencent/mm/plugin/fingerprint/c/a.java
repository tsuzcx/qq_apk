package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.c.buy;
import com.tencent.mm.protocal.c.buz;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends com.tencent.mm.plugin.soter.b.d
  implements k
{
  public final b dmK;
  private f dmL;
  public String klM = "";
  public boolean klN = false;
  
  public a()
  {
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new buy();
    ((b.a)localObject1).ecI = new buz();
    ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
    ((b.a)localObject1).ecG = 1586;
    ((b.a)localObject1).ecJ = 0;
    ((b.a)localObject1).ecK = 0;
    this.dmK = ((b.a)localObject1).Kt();
    localObject1 = (buy)this.dmK.ecE.ecN;
    Object localObject2 = com.tencent.mm.plugin.soter.d.d.bKR();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject2).psl;
    localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).psm;
    y.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", new Object[] { str, localObject2 });
    ((buy)localObject1).psl = str;
    ((buy)localObject1).psm = ((String)localObject2);
    ((buy)localObject1).scene = 0;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void aTg()
  {
    y.e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
    if (this.dmL != null) {
      this.dmL.onSceneEnd(4, -1, "", this);
    }
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetSceneSoterGetPayChallenge", "hy: onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramq = (buz)((b)paramq).ecF.ecN;
      this.klM = paramq.klM;
      s.qyz.klM = this.klM;
      if (1 != paramq.tLu) {
        break label169;
      }
      bool = true;
      this.klN = bool;
      if (1 != paramq.tLu) {
        break label175;
      }
    }
    label169:
    label175:
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.NetSceneSoterGetPayChallenge", "get pay challenge needChangeAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
      s.qyz.klN = this.klN;
      y.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", new Object[] { this.klM, Boolean.valueOf(this.klN) });
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
      return;
      bool = false;
      break;
    }
  }
  
  public final int getType()
  {
    return 1586;
  }
  
  public final void rl(int paramInt)
  {
    if (this.dmL != null) {
      this.dmL.onSceneEnd(4, -1, "", this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.c.a
 * JD-Core Version:    0.7.0.1
 */