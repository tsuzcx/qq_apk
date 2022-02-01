package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends n
  implements k
{
  public String cLR;
  private g callback;
  public String deviceName;
  public String dfF;
  private b rr;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125516);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dgc();
    ((b.a)localObject).gUV = new dgd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/updatesafedevice";
    ((b.a)localObject).funcId = 361;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    this.cLR = paramString1;
    this.deviceName = paramString2;
    this.dfF = paramString3;
    localObject = (dgc)this.rr.gUS.gUX;
    ((dgc)localObject).CWZ = paramString1;
    ((dgc)localObject).Name = paramString2;
    ((dgc)localObject).CBS = paramString3;
    AppMethodBeat.o(125516);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(125518);
    if ((bt.isNullOrNil(this.cLR)) || (bt.isNullOrNil(this.deviceName)) || (bt.isNullOrNil(this.dfF)))
    {
      ad.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
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
    ad.i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.c
 * JD-Core Version:    0.7.0.1
 */