package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dlr;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
  extends n
  implements k
{
  public String cIZ;
  private g callback;
  public String dda;
  public String deviceName;
  private b rr;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125516);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dlr();
    ((b.a)localObject).hvu = new dls();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/updatesafedevice";
    ((b.a)localObject).funcId = 361;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    this.cIZ = paramString1;
    this.deviceName = paramString2;
    this.dda = paramString3;
    localObject = (dlr)this.rr.hvr.hvw;
    ((dlr)localObject).EpI = paramString1;
    ((dlr)localObject).Name = paramString2;
    ((dlr)localObject).DUp = paramString3;
    AppMethodBeat.o(125516);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(125518);
    if ((bs.isNullOrNil(this.cIZ)) || (bs.isNullOrNil(this.deviceName)) || (bs.isNullOrNil(this.dda)))
    {
      ac.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
      AppMethodBeat.o(125518);
      return -1;
    }
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(125518);
    return i;
  }
  
  public final int getType()
  {
    return 361;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125517);
    ac.i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.c
 * JD-Core Version:    0.7.0.1
 */