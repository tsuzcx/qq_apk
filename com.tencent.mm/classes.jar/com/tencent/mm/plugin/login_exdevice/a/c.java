package com.tencent.mm.plugin.login_exdevice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.dgd;
import com.tencent.mm.protocal.protobuf.dge;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends q
  implements m
{
  private i callback;
  public com.tencent.mm.ak.d hJu;
  
  public c(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(231735);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dgd();
    ((d.a)localObject).iLO = new dge();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/pushloginurl";
    this.hJu = ((d.a)localObject).aXF();
    localObject = (dgd)this.hJu.iLK.iLR;
    ((dgd)localObject).UserName = paramString;
    ((dgd)localObject).KKZ = z.aC(paramArrayOfByte);
    ((dgd)localObject).KQy = 3;
    ((dgd)localObject).MrO = com.tencent.mm.b.g.getMessageDigest(Util.currentTicks().getBytes());
    ((dgd)localObject).oTI = com.tencent.mm.protocal.d.DEVICE_NAME;
    paramString = Util.getUuidRandom();
    ((dgd)localObject).KPW = z.aC(paramString);
    this.hJu.setRsaInfo(ac.gtT());
    this.hJu.option = 1;
    this.hJu.getReqObj().setPassKey(paramString);
    AppMethodBeat.o(231735);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(231737);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(231737);
    return i;
  }
  
  public final int getType()
  {
    return 654;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(231736);
    Log.i("MicroMsg.NetScenePushLoginUrl", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(231736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.login_exdevice.a.c
 * JD-Core Version:    0.7.0.1
 */