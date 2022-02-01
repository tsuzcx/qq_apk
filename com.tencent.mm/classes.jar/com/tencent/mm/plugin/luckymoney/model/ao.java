package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.evs;
import com.tencent.mm.protocal.protobuf.evt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class ao
  extends r
{
  public evt EBk;
  
  public ao(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(268246);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new evs();
    ((d.a)localObject).lBV = new evt();
    ((d.a)localObject).funcId = 5160;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/unionhb/businesscallbackunionhb";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (evs)d.b.b(this.rr.lBR);
    ((evs)localObject).ybP = paramString1;
    ((evs)localObject).tUC = paramString2;
    ((evs)localObject).EBP = paramString3;
    ((evs)localObject).Uxm = 0;
    Log.i("MicroMsg.NetSceneLuckyMoneyBusinessCallbackUnion", "NetSceneLuckyMoneyBusinessCallbackUnion request sendId: %s, %s", new Object[] { paramString1, paramString3 });
    AppMethodBeat.o(268246);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(268247);
    this.EBk = ((evt)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneLuckyMoneyBusinessCallbackUnion", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.EBk.fwx), this.EBk.tVo });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(268247);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(268248);
    params = (evt)d.c.b(((d)params).lBS);
    this.YVy = params.fwx;
    this.YVz = params.tVo;
    AppMethodBeat.o(268248);
  }
  
  public final int getType()
  {
    return 5160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ao
 * JD-Core Version:    0.7.0.1
 */