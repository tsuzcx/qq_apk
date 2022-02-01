package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class ag
  extends r
{
  public bmy vpZ;
  
  public ag(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65283);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bmx();
    ((b.a)localObject).hNN = new bmy();
    ((b.a)localObject).funcId = 2929;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/businesscallbackwxhb";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bmx)this.rr.hNK.hNQ;
    ((bmx)localObject).vkl = paramString1;
    ((bmx)localObject).oZO = paramString2;
    ((bmx)localObject).vqD = paramString3;
    ad.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "sendId: %s, %s", new Object[] { paramString1, paramString3 });
    AppMethodBeat.o(65283);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(65284);
    this.vpZ = ((bmy)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.vpZ.dlw), this.vpZ.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(65284);
  }
  
  public final void e(q paramq)
  {
    paramq = (bmy)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
  }
  
  public final int getType()
  {
    return 2929;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ag
 * JD-Core Version:    0.7.0.1
 */