package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwp;
import com.tencent.mm.protocal.protobuf.bwq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class c
  extends p
{
  public bwq kOH;
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(41037);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bwp();
    ((b.a)localObject).fsY = new bwq();
    ((b.a)localObject).funcId = 2811;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardmaterialcode";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bwp)this.rr.fsV.fta;
    ((bwp)localObject).xJR = paramString;
    ((bwp)localObject).scene = paramInt;
    ab.i("MicroMsg.NetSceneQrRewardMaterial", "req url: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(41037);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41038);
    this.kOH = ((bwq)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneQrRewardMaterial", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.kOH.cnK), this.kOH.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(41038);
  }
  
  public final boolean bhS()
  {
    return true;
  }
  
  public final void e(q paramq)
  {
    paramq = (bwq)((b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
  }
  
  public final int getType()
  {
    return 2811;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.c
 * JD-Core Version:    0.7.0.1
 */