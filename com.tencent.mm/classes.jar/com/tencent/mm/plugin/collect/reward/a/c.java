package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class c
  extends r
{
  public cxh pbL;
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(63897);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cxg();
    ((b.a)localObject).hNN = new cxh();
    ((b.a)localObject).funcId = 2811;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardmaterialcode";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cxg)this.rr.hNK.hNQ;
    ((cxg)localObject).HoO = paramString;
    ((cxg)localObject).scene = paramInt;
    ad.i("MicroMsg.NetSceneQrRewardMaterial", "req url: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63897);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63898);
    this.pbL = ((cxh)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneQrRewardMaterial", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.pbL.dlw), this.pbL.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63898);
  }
  
  public final boolean caH()
  {
    return true;
  }
  
  public final void e(q paramq)
  {
    paramq = (cxh)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
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