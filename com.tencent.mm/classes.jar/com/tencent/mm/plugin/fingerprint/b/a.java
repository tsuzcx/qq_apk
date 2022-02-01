package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.mgr.j;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.plugin.soter.model.b;
import com.tencent.mm.protocal.protobuf.fgj;
import com.tencent.mm.protocal.protobuf.fgk;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends d
{
  public String Hgd;
  public boolean Hgl;
  private h callback;
  public final com.tencent.mm.am.c rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(64453);
    this.Hgd = "";
    this.Hgl = false;
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new fgj();
    ((c.a)localObject1).otF = new fgk();
    ((c.a)localObject1).uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
    ((c.a)localObject1).funcId = 1586;
    ((c.a)localObject1).otG = 0;
    ((c.a)localObject1).respCmdId = 0;
    this.rr = ((c.a)localObject1).bEF();
    localObject1 = (fgj)c.b.b(this.rr.otB);
    Object localObject2 = b.htz();
    String str = ((com.tencent.mm.plugin.soter.model.c)localObject2).RZY;
    localObject2 = ((com.tencent.mm.plugin.soter.model.c)localObject2).mXG;
    Log.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", new Object[] { str, localObject2 });
    ((fgj)localObject1).RZY = str;
    ((fgj)localObject1).mXG = ((String)localObject2);
    ((fgj)localObject1).scene = 0;
    ((fgj)localObject1).abGn = paramInt;
    ((fgj)localObject1).aamt = 1;
    AppMethodBeat.o(64453);
  }
  
  public final void VE(int paramInt)
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
      params = (fgk)c.c.b(((com.tencent.mm.am.c)params).otC);
      this.Hgd = params.Hgd;
      j.Hgj.Hgd = this.Hgd;
      if (1 != params.abGo) {
        break label179;
      }
      bool = true;
      this.Hgl = bool;
      if (1 != params.abGo) {
        break label185;
      }
    }
    label179:
    label185:
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.NetSceneSoterGetPayChallenge", "get pay challenge needChangeAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
      j.Hgj.Hgl = this.Hgl;
      Log.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", new Object[] { this.Hgd, Boolean.valueOf(this.Hgl) });
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      AppMethodBeat.o(64455);
      return;
      bool = false;
      break;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(64454);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(64454);
    return i;
  }
  
  public final void fuc()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a
 * JD-Core Version:    0.7.0.1
 */