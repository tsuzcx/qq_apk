package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ety;
import com.tencent.mm.protocal.protobuf.etz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r;

public final class j
  extends r
{
  public etz wYE;
  
  public j(String paramString, int paramInt)
  {
    AppMethodBeat.i(63825);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ety();
    ((c.a)localObject).otF = new etz();
    ((c.a)localObject).funcId = 1800;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/scanf2fmaterialcode";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ety)c.b.b(this.rr.otB);
    ((ety)localObject).Tox = paramString;
    ((ety)localObject).scene = paramInt;
    Log.i("MicroMsg.NetSceneF2fMaterial", "req url: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63825);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63826);
    this.wYE = ((etz)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneF2fMaterial", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wYE.hAV), this.wYE.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63826);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(293532);
    params = (etz)c.c.b(((c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(293532);
  }
  
  public final int getType()
  {
    return 1800;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.j
 * JD-Core Version:    0.7.0.1
 */