package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eju;
import com.tencent.mm.protocal.protobuf.ejv;
import com.tencent.mm.protocal.protobuf.uj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r;

public final class l
  extends r
{
  public ejv JAH;
  private final String TAG;
  
  public l(String paramString)
  {
    AppMethodBeat.i(64634);
    this.TAG = "MicroMsg.NetSceneQryHoneyPayerDetail";
    c.a locala = new c.a();
    locala.otE = new eju();
    locala.otF = new ejv();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmpay-bin/qryhppayerdetail";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((eju)c.b.b(this.rr.otB)).aatc = paramString;
    Log.i("MicroMsg.NetSceneQryHoneyPayerDetail", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64634);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64635);
    Log.i("MicroMsg.NetSceneQryHoneyPayerDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.JAH = ((ejv)c.c.b(((com.tencent.mm.am.c)params).otC));
    Log.i("MicroMsg.NetSceneQryHoneyPayerDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.JAH.wuz), this.JAH.wuA });
    if (this.JAH.aatd != null) {
      com.tencent.mm.plugin.honey_pay.model.c.z(this.JAH.aatd.hWO, this.JAH.aatd.YZU, this.JAH.aatd.hVW, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64635);
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(267296);
    params = (ejv)c.c.b(((com.tencent.mm.am.c)params).otC);
    this.agTs = params.wuz;
    this.agTt = params.wuA;
    AppMethodBeat.o(267296);
  }
  
  public final int getType()
  {
    return 2876;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.l
 * JD-Core Version:    0.7.0.1
 */