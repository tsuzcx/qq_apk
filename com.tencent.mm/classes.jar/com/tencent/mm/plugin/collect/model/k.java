package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.protocal.protobuf.dqt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class k
  extends r
{
  public dqt qwj;
  
  public k(String paramString, int paramInt)
  {
    AppMethodBeat.i(63825);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dqs();
    ((d.a)localObject).iLO = new dqt();
    ((d.a)localObject).funcId = 1800;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/scanf2fmaterialcode";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dqs)this.rr.iLK.iLR;
    ((dqs)localObject).MTB = paramString;
    ((dqs)localObject).scene = paramInt;
    Log.i("MicroMsg.NetSceneF2fMaterial", "req url: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63825);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63826);
    this.qwj = ((dqt)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneF2fMaterial", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qwj.dDN), this.qwj.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63826);
  }
  
  public final void e(s params)
  {
    params = (dqt)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
  }
  
  public final int getType()
  {
    return 1800;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.k
 * JD-Core Version:    0.7.0.1
 */