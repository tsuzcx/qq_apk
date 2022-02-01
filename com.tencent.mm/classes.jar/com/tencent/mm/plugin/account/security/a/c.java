package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dsf;
import com.tencent.mm.protocal.protobuf.dsg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
  extends n
  implements k
{
  public String cVh;
  private f callback;
  public String deviceName;
  public String dpB;
  private b rr;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125516);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dsf();
    ((b.a)localObject).hQG = new dsg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/updatesafedevice";
    ((b.a)localObject).funcId = 361;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    this.cVh = paramString1;
    this.deviceName = paramString2;
    this.dpB = paramString3;
    localObject = (dsf)this.rr.hQD.hQJ;
    ((dsf)localObject).Gps = paramString1;
    ((dsf)localObject).Name = paramString2;
    ((dsf)localObject).FSh = paramString3;
    AppMethodBeat.o(125516);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(125518);
    if ((bu.isNullOrNil(this.cVh)) || (bu.isNullOrNil(this.deviceName)) || (bu.isNullOrNil(this.dpB)))
    {
      ae.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
      AppMethodBeat.o(125518);
      return -1;
    }
    this.callback = paramf;
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
    ae.i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.c
 * JD-Core Version:    0.7.0.1
 */