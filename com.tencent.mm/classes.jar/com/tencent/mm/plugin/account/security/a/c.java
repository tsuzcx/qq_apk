package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.protocal.protobuf.drj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends n
  implements k
{
  public String cUi;
  private f callback;
  public String deviceName;
  public String dow;
  private b rr;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125516);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dri();
    ((b.a)localObject).hNN = new drj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/updatesafedevice";
    ((b.a)localObject).funcId = 361;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    this.cUi = paramString1;
    this.deviceName = paramString2;
    this.dow = paramString3;
    localObject = (dri)this.rr.hNK.hNQ;
    ((dri)localObject).FWT = paramString1;
    ((dri)localObject).Name = paramString2;
    ((dri)localObject).FzJ = paramString3;
    AppMethodBeat.o(125516);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(125518);
    if ((bt.isNullOrNil(this.cUi)) || (bt.isNullOrNil(this.deviceName)) || (bt.isNullOrNil(this.dow)))
    {
      ad.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
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
    ad.i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.c
 * JD-Core Version:    0.7.0.1
 */