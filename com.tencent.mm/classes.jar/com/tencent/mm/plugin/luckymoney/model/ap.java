package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.frh;
import com.tencent.mm.protocal.protobuf.fri;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r;

public final class ap
  extends r
{
  public fri Kui;
  
  public ap(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(283916);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new frh();
    ((c.a)localObject).otF = new fri();
    ((c.a)localObject).funcId = 5160;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/unionhb/businesscallbackunionhb";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (frh)c.b.b(this.rr.otB);
    ((frh)localObject).CAf = paramString1;
    ((frh)localObject).wXY = paramString2;
    ((frh)localObject).KuQ = paramString3;
    ((frh)localObject).abQU = 0;
    Log.i("MicroMsg.NetSceneLuckyMoneyBusinessCallbackUnion", "NetSceneLuckyMoneyBusinessCallbackUnion request sendId: %s, %s", new Object[] { paramString1, paramString3 });
    AppMethodBeat.o(283916);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(283918);
    this.Kui = ((fri)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneLuckyMoneyBusinessCallbackUnion", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.Kui.hAV), this.Kui.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(283918);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(283919);
    params = (fri)c.c.b(((c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(283919);
  }
  
  public final int getType()
  {
    return 5160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ap
 * JD-Core Version:    0.7.0.1
 */