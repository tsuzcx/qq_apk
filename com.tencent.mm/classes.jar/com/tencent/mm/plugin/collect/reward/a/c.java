package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dqv;
import com.tencent.mm.protocal.protobuf.dqw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class c
  extends r
{
  public dqw qxC;
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(63897);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dqv();
    ((d.a)localObject).iLO = new dqw();
    ((d.a)localObject).funcId = 2811;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardmaterialcode";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dqv)this.rr.iLK.iLR;
    ((dqv)localObject).MTB = paramString;
    ((dqv)localObject).scene = paramInt;
    Log.i("MicroMsg.NetSceneQrRewardMaterial", "req url: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63897);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63898);
    this.qxC = ((dqw)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneQrRewardMaterial", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qxC.dDN), this.qxC.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63898);
  }
  
  public final boolean czQ()
  {
    return true;
  }
  
  public final void e(s params)
  {
    params = (dqw)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
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