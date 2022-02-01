package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.protocal.protobuf.ebq;
import com.tencent.mm.protocal.protobuf.ebr;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends com.tencent.mm.plugin.soter.b.d
  implements m
{
  private i callback;
  public final com.tencent.mm.ak.d rr;
  public String wFE;
  public boolean wFM;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(64453);
    this.wFE = "";
    this.wFM = false;
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new ebq();
    ((d.a)localObject1).iLO = new ebr();
    ((d.a)localObject1).uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
    ((d.a)localObject1).funcId = 1586;
    ((d.a)localObject1).iLP = 0;
    ((d.a)localObject1).respCmdId = 0;
    this.rr = ((d.a)localObject1).aXF();
    localObject1 = (ebq)this.rr.iLK.iLR;
    Object localObject2 = com.tencent.mm.plugin.soter.d.d.flM();
    String str = ((e)localObject2).FhU;
    localObject2 = ((e)localObject2).hFF;
    Log.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", new Object[] { str, localObject2 });
    ((ebq)localObject1).FhU = str;
    ((ebq)localObject1).hFF = ((String)localObject2);
    ((ebq)localObject1).scene = 0;
    ((ebq)localObject1).Nbr = paramInt;
    ((ebq)localObject1).Nbs = 1;
    AppMethodBeat.o(64453);
  }
  
  public final void MO(int paramInt)
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
      params = (ebr)((com.tencent.mm.ak.d)params).iLL.iLR;
      this.wFE = params.wFE;
      p.wFK.wFE = this.wFE;
      if (1 != params.Nbt) {
        break label179;
      }
      bool = true;
      this.wFM = bool;
      if (1 != params.Nbt) {
        break label185;
      }
    }
    label179:
    label185:
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.NetSceneSoterGetPayChallenge", "get pay challenge needChangeAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
      p.wFK.wFM = this.wFM;
      Log.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", new Object[] { this.wFE, Boolean.valueOf(this.wFM) });
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(64455);
      return;
      bool = false;
      break;
    }
  }
  
  public final void dKB()
  {
    AppMethodBeat.i(64456);
    Log.e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
    if (this.callback != null) {
      this.callback.onSceneEnd(4, -1, "", this);
    }
    AppMethodBeat.o(64456);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(64454);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
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