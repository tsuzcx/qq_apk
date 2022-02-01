package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ewj;
import com.tencent.mm.protocal.protobuf.ewk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends q
  implements m
{
  private i callback;
  public String deviceName;
  public String fzB;
  public String fzF;
  private d rr;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125516);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ewj();
    ((d.a)localObject).lBV = new ewk();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/updatesafedevice";
    ((d.a)localObject).funcId = 361;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    this.fzB = paramString1;
    this.deviceName = paramString2;
    this.fzF = paramString3;
    localObject = (ewj)d.b.b(this.rr.lBR);
    ((ewj)localObject).Sll = paramString1;
    ((ewj)localObject).CMP = paramString2;
    ((ewj)localObject).RMK = paramString3;
    AppMethodBeat.o(125516);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(125518);
    if ((Util.isNullOrNil(this.fzB)) || (Util.isNullOrNil(this.deviceName)) || (Util.isNullOrNil(this.fzF)))
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