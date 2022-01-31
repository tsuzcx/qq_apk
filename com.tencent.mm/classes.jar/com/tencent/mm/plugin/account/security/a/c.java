package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends m
  implements k
{
  public String bYu;
  private f callback;
  public String cqJ;
  public String deviceName;
  private b rr;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(69831);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cnc();
    ((b.a)localObject).fsY = new cnd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/updatesafedevice";
    ((b.a)localObject).funcId = 361;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    this.bYu = paramString1;
    this.deviceName = paramString2;
    this.cqJ = paramString3;
    localObject = (cnc)this.rr.fsV.fta;
    ((cnc)localObject).wPa = paramString1;
    ((cnc)localObject).Name = paramString2;
    ((cnc)localObject).wsq = paramString3;
    AppMethodBeat.o(69831);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69833);
    if ((bo.isNullOrNil(this.bYu)) || (bo.isNullOrNil(this.deviceName)) || (bo.isNullOrNil(this.cqJ)))
    {
      ab.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
      AppMethodBeat.o(69833);
      return -1;
    }
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69833);
    return i;
  }
  
  public final int getType()
  {
    return 361;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69832);
    ab.i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.c
 * JD-Core Version:    0.7.0.1
 */