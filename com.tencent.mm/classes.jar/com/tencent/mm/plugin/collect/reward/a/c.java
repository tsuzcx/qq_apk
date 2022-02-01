package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eua;
import com.tencent.mm.protocal.protobuf.eub;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r;

public final class c
  extends r
{
  public eub wZU;
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(63897);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eua();
    ((c.a)localObject).otF = new eub();
    ((c.a)localObject).funcId = 2811;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardmaterialcode";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (eua)c.b.b(this.rr.otB);
    ((eua)localObject).Tox = paramString;
    ((eua)localObject).scene = paramInt;
    Log.i("MicroMsg.NetSceneQrRewardMaterial", "req url: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63897);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63898);
    this.wZU = ((eub)c.c.b(((com.tencent.mm.am.c)params).otC));
    Log.i("MicroMsg.NetSceneQrRewardMaterial", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wZU.hAV), this.wZU.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63898);
  }
  
  public final boolean drV()
  {
    return true;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(293721);
    params = (eub)c.c.b(((com.tencent.mm.am.c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(293721);
  }
  
  public final int getType()
  {
    return 2811;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.c
 * JD-Core Version:    0.7.0.1
 */