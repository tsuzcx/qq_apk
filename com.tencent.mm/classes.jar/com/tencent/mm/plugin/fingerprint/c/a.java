package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.protocal.protobuf.dhm;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends com.tencent.mm.plugin.soter.b.d
  implements k
{
  private f callback;
  public final b rr;
  public String thf;
  public boolean thn;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(64453);
    this.thf = "";
    this.thn = false;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hNM = new dhm();
    ((b.a)localObject1).hNN = new dhn();
    ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
    ((b.a)localObject1).funcId = 1586;
    ((b.a)localObject1).hNO = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).aDC();
    localObject1 = (dhm)this.rr.hNK.hNQ;
    Object localObject2 = com.tencent.mm.plugin.soter.d.d.efE();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject2).AFy;
    localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).AFz;
    ad.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", new Object[] { str, localObject2 });
    ((dhm)localObject1).AFy = str;
    ((dhm)localObject1).AFz = ((String)localObject2);
    ((dhm)localObject1).scene = 0;
    ((dhm)localObject1).HvW = paramInt;
    ((dhm)localObject1).HvX = 1;
    AppMethodBeat.o(64453);
  }
  
  public final void GC(int paramInt)
  {
    AppMethodBeat.i(64457);
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64457);
  }
  
  public final void cQb()
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
      paramq = (dhn)((b)paramq).hNL.hNQ;
      this.thf = paramq.thf;
      p.thl.thf = this.thf;
      if (1 != paramq.HvY) {
        break label179;
      }
      bool = true;
      this.thn = bool;
      if (1 != paramq.HvY) {
        break label185;
      }
    }
    label179:
    label185:
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.NetSceneSoterGetPayChallenge", "get pay challenge needChangeAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
      p.thl.thn = this.thn;
      ad.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", new Object[] { this.thf, Boolean.valueOf(this.thn) });
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