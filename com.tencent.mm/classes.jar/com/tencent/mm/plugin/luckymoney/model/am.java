package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.protocal.protobuf.cah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class am
  extends r
{
  public cah yXe;
  
  public am() {}
  
  public am(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65283);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cag();
    ((d.a)localObject).iLO = new cah();
    ((d.a)localObject).funcId = 2929;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/businesscallbackwxhb";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cag)this.rr.iLK.iLR;
    ((cag)localObject).yQE = paramString1;
    ((cag)localObject).qvD = paramString2;
    ((cag)localObject).yXL = paramString3;
    Log.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "sendId: %s, %s", new Object[] { paramString1, paramString3 });
    AppMethodBeat.o(65283);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(65284);
    this.yXe = ((cah)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yXe.dDN), this.yXe.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(65284);
  }
  
  public final void e(s params)
  {
    params = (cah)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
  }
  
  public final int getType()
  {
    return 2929;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.am
 * JD-Core Version:    0.7.0.1
 */