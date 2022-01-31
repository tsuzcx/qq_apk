package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.sdk.platformtools.ab;

public final class s
  extends m
  implements k
{
  private f eGj;
  private String lEk;
  private com.tencent.mm.ai.b lFx;
  
  public s(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(19335);
    this.eGj = null;
    this.lFx = null;
    this.lEk = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new auo();
    ((b.a)localObject).fsY = new aup();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
    ((b.a)localObject).funcId = 1090;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFx = ((b.a)localObject).ado();
    localObject = (auo)this.lFx.fsV.fta;
    ((auo)localObject).wus = com.tencent.mm.bv.b.ank(paramString2);
    ((auo)localObject).wuq = com.tencent.mm.bv.b.ank(paramString3);
    ((auo)localObject).nrS = paramInt;
    this.lEk = paramString1;
    AppMethodBeat.o(19335);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(19337);
    this.eGj = paramf;
    int i = dispatch(parame, this.lFx, this);
    AppMethodBeat.o(19337);
    return i;
  }
  
  public final int getType()
  {
    return 1090;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19336);
    ab.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    ad.bpY().LI(this.lEk);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((aup)this.lFx.fsW.fta).getBaseResponse().Ret;
      ab.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + paramInt1 + ",msg=" + paramString);
    }
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(19336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.s
 * JD-Core Version:    0.7.0.1
 */