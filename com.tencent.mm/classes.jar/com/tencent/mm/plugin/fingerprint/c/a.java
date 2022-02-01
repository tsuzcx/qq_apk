package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.protocal.protobuf.elq;
import com.tencent.mm.protocal.protobuf.elr;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends com.tencent.mm.plugin.soter.b.d
{
  public String ByB;
  public boolean ByJ;
  private i callback;
  public final com.tencent.mm.an.d rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(64453);
    this.ByB = "";
    this.ByJ = false;
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new elq();
    ((d.a)localObject1).lBV = new elr();
    ((d.a)localObject1).uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
    ((d.a)localObject1).funcId = 1586;
    ((d.a)localObject1).lBW = 0;
    ((d.a)localObject1).respCmdId = 0;
    this.rr = ((d.a)localObject1).bgN();
    localObject1 = (elq)d.b.b(this.rr.lBR);
    Object localObject2 = com.tencent.mm.plugin.soter.d.d.gai();
    String str = ((e)localObject2).Lwz;
    localObject2 = ((e)localObject2).ktM;
    Log.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", new Object[] { str, localObject2 });
    ((elq)localObject1).Lwz = str;
    ((elq)localObject1).ktM = ((String)localObject2);
    ((elq)localObject1).scene = 0;
    ((elq)localObject1).UnL = paramInt;
    ((elq)localObject1).SZz = 1;
    AppMethodBeat.o(64453);
  }
  
  public final void Sl(int paramInt)
  {
    AppMethodBeat.i(64457);
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64457);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64455);
    Log.d("MicroMsg.NetSceneSoterGetPayChallenge", "hy: onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      params = (elr)d.c.b(((com.tencent.mm.an.d)params).lBS);
      this.ByB = params.ByB;
      p.ByH.ByB = this.ByB;
      if (1 != params.UnM) {
        break label179;
      }
      bool = true;
      this.ByJ = bool;
      if (1 != params.UnM) {
        break label185;
      }
    }
    label179:
    label185:
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.NetSceneSoterGetPayChallenge", "get pay challenge needChangeAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
      p.ByH.ByJ = this.ByJ;
      Log.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", new Object[] { this.ByB, Boolean.valueOf(this.ByJ) });
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(64455);
      return;
      bool = false;
      break;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(64454);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(64454);
    return i;
  }
  
  public final void epa()
  {
    AppMethodBeat.i(64456);
    Log.e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64456);
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