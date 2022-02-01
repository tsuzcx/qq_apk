package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bok;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class e
  extends r
{
  private final String TAG;
  public bol yjB;
  
  public e(String paramString)
  {
    AppMethodBeat.i(64620);
    this.TAG = "MicroMsg.NetSceneGetHoneyPayCard";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bok();
    ((d.a)localObject).iLO = new bol();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/gethpcard";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bok)this.rr.iLK.iLR;
    ((bok)localObject).LWD = paramString;
    ((bok)localObject).LUV = k.elk();
    Log.i("MicroMsg.NetSceneGetHoneyPayCard", "card no: %s", new Object[] { paramString });
    AppMethodBeat.o(64620);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64621);
    Log.i("MicroMsg.NetSceneGetHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yjB = ((bol)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneGetHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yjB.pTZ), this.yjB.pUa });
    if (this.yjB.LWE != null) {
      c.s(this.yjB.LWE.dXf, this.yjB.LWE.LaR, this.yjB.LWE.dWw, null);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64621);
  }
  
  public final void e(s params)
  {
    params = (bol)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 1983;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.e
 * JD-Core Version:    0.7.0.1
 */