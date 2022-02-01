package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.protocal.protobuf.eln;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class an
  extends r
{
  public eln yXf;
  
  public an(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213316);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new elm();
    ((d.a)localObject).iLO = new eln();
    ((d.a)localObject).funcId = 5160;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/unionhb/businesscallbackunionhb";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (elm)this.rr.iLK.iLR;
    ((elm)localObject).yQE = paramString1;
    ((elm)localObject).qvD = paramString2;
    ((elm)localObject).yXL = paramString3;
    ((elm)localObject).NkC = 0;
    Log.i("MicroMsg.NetSceneLuckyMoneyBusinessCallbackUnion", "NetSceneLuckyMoneyBusinessCallbackUnion request sendId: %s, %s", new Object[] { paramString1, paramString3 });
    AppMethodBeat.o(213316);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(213317);
    this.yXf = ((eln)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneLuckyMoneyBusinessCallbackUnion", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yXf.dDN), this.yXf.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(213317);
  }
  
  public final void e(s params)
  {
    params = (eln)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
  }
  
  public final int getType()
  {
    return 5160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.an
 * JD-Core Version:    0.7.0.1
 */