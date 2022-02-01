package com.tencent.mm.plugin.login_exdevice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.dpx;
import com.tencent.mm.protocal.protobuf.dpy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends q
  implements m
{
  private i callback;
  public com.tencent.mm.an.d kwO;
  
  public c(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(285833);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dpx();
    ((d.a)localObject).lBV = new dpy();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/pushloginurl";
    this.kwO = ((d.a)localObject).bgN();
    localObject = (dpx)d.b.b(this.kwO.lBR);
    ((dpx)localObject).UserName = paramString;
    ((dpx)localObject).RLV = z.aN(paramArrayOfByte);
    ((dpx)localObject).RRw = 3;
    ((dpx)localObject).TCU = com.tencent.mm.b.g.getMessageDigest(Util.currentTicks().getBytes());
    ((dpx)localObject).rVG = com.tencent.mm.protocal.d.RAB;
    paramString = Util.getUuidRandom();
    ((dpx)localObject).RQU = z.aN(paramString);
    this.kwO.setRsaInfo(ac.hpj());
    this.kwO.option = 1;
    this.kwO.getReqObj().setPassKey(paramString);
    AppMethodBeat.o(285833);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(285835);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(285835);
    return i;
  }
  
  public final int getType()
  {
    return 654;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(285834);
    Log.i("MicroMsg.NetScenePushLoginUrl", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(285834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.login_exdevice.a.c
 * JD-Core Version:    0.7.0.1
 */