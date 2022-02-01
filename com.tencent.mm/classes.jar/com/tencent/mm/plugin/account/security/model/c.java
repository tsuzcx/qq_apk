package com.tencent.mm.plugin.account.security.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fsa;
import com.tencent.mm.protocal.protobuf.fsb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends p
  implements m
{
  private h callback;
  public String deviceName;
  public String hEl;
  public String hEr;
  private com.tencent.mm.am.c rr;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125516);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fsa();
    ((c.a)localObject).otF = new fsb();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/updatesafedevice";
    ((c.a)localObject).funcId = 361;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    this.hEl = paramString1;
    this.deviceName = paramString2;
    this.hEr = paramString3;
    localObject = (fsa)c.b.b(this.rr.otB);
    ((fsa)localObject).Zjv = paramString1;
    ((fsa)localObject).IGU = paramString2;
    ((fsa)localObject).YJY = paramString3;
    AppMethodBeat.o(125516);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(125518);
    if ((Util.isNullOrNil(this.hEl)) || (Util.isNullOrNil(this.deviceName)) || (Util.isNullOrNil(this.hEr)))
    {
      Log.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
      AppMethodBeat.o(125518);
      return -1;
    }
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.plugin.account.security.model.c
 * JD-Core Version:    0.7.0.1
 */