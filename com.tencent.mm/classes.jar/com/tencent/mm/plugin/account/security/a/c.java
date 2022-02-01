package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.emd;
import com.tencent.mm.protocal.protobuf.eme;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends q
  implements m
{
  private i callback;
  public String dGL;
  public String dGP;
  public String deviceName;
  private d rr;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125516);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new emd();
    ((d.a)localObject).iLO = new eme();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/updatesafedevice";
    ((d.a)localObject).funcId = 361;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    this.dGL = paramString1;
    this.deviceName = paramString2;
    this.dGP = paramString3;
    localObject = (emd)this.rr.iLK.iLR;
    ((emd)localObject).Lke = paramString1;
    ((emd)localObject).Name = paramString2;
    ((emd)localObject).KLO = paramString3;
    AppMethodBeat.o(125516);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(125518);
    if ((Util.isNullOrNil(this.dGL)) || (Util.isNullOrNil(this.deviceName)) || (Util.isNullOrNil(this.dGP)))
    {
      Log.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
      AppMethodBeat.o(125518);
      return -1;
    }
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125518);
    return i;
  }
  
  public final int getType()
  {
    return 361;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125517);
    Log.i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.c
 * JD-Core Version:    0.7.0.1
 */