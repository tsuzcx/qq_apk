package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class b
  extends r
{
  private final String TAG;
  public String username;
  public yp yjy;
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(64614);
    this.TAG = "MicroMsg.NetSceneCheckHoneyUser";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new yo();
    ((d.a)localObject).iLO = new yp();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/checkhoneyuser";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (yo)this.rr.iLK.iLR;
    ((yo)localObject).LjD = paramString;
    ((yo)localObject).nHh = paramInt;
    this.username = paramString;
    AppMethodBeat.o(64614);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(64615);
    Log.i("MicroMsg.NetSceneCheckHoneyUser", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yjy = ((yp)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneCheckHoneyUser", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yjy.pTZ), this.yjy.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(64615);
  }
  
  public final void e(s params)
  {
    params = (yp)((d)params).iLL.iLR;
    this.RtZ = params.pTZ;
    this.Rua = params.pUa;
  }
  
  public final int getType()
  {
    return 2926;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.b
 * JD-Core Version:    0.7.0.1
 */