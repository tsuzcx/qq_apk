package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.crz;
import com.tencent.mm.protocal.protobuf.csa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class c
  extends r
{
  public csa oyq;
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(63897);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new crz();
    ((b.a)localObject).hvu = new csa();
    ((b.a)localObject).funcId = 2811;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardmaterialcode";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (crz)this.rr.hvr.hvw;
    ((crz)localObject).FEz = paramString;
    ((crz)localObject).scene = paramInt;
    ac.i("MicroMsg.NetSceneQrRewardMaterial", "req url: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63897);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63898);
    this.oyq = ((csa)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneQrRewardMaterial", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.oyq.dae), this.oyq.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63898);
  }
  
  public final boolean bWe()
  {
    return true;
  }
  
  public final void e(q paramq)
  {
    paramq = (csa)((b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 2811;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.c
 * JD-Core Version:    0.7.0.1
 */