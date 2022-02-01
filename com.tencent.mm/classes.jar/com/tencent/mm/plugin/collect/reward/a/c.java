package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class c
  extends r
{
  public cyb pir;
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(63897);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cya();
    ((b.a)localObject).hQG = new cyb();
    ((b.a)localObject).funcId = 2811;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardmaterialcode";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cya)this.rr.hQD.hQJ;
    ((cya)localObject).HIq = paramString;
    ((cya)localObject).scene = paramInt;
    ae.i("MicroMsg.NetSceneQrRewardMaterial", "req url: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63897);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63898);
    this.pir = ((cyb)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneQrRewardMaterial", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.pir.dmy), this.pir.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63898);
  }
  
  public final boolean cbW()
  {
    return true;
  }
  
  public final void e(q paramq)
  {
    paramq = (cyb)((b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
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