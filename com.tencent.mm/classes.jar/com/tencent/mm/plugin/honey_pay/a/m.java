package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ejw;
import com.tencent.mm.protocal.protobuf.ejx;
import com.tencent.mm.protocal.protobuf.uj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r;

public final class m
  extends r
{
  public ejx JAI;
  private final String TAG;
  
  public m(String paramString)
  {
    AppMethodBeat.i(64636);
    this.TAG = "MicroMsg.NetSceneQryHoneyUserDetail";
    c.a locala = new c.a();
    locala.otE = new ejw();
    locala.otF = new ejx();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qryhpusererdetail";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((ejw)c.b.b(this.rr.otB)).aatc = paramString;
    Log.i("MicroMsg.NetSceneQryHoneyUserDetail", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64636);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64637);
    Log.i("MicroMsg.NetSceneQryHoneyUserDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.JAI = ((ejx)c.c.b(((com.tencent.mm.am.c)params).otC));
    Log.i("MicroMsg.NetSceneQryHoneyUserDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.JAI.wuz), this.JAI.wuA });
    if (this.JAI.aatd != null) {
      com.tencent.mm.plugin.honey_pay.model.c.z(this.JAI.aatd.hWO, this.JAI.aatd.YZU, this.JAI.aatd.hVW, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64637);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(267297);
    params = (ejx)c.c.b(((com.tencent.mm.am.c)params).otC);
    this.agTs = params.wuz;
    this.agTt = params.wuA;
    AppMethodBeat.o(267297);
  }
  
  public final int getType()
  {
    return 2613;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.m
 * JD-Core Version:    0.7.0.1
 */