package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cba;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
  extends q
  implements m
{
  private i heq;
  private d rAy;
  private String rzn;
  
  public s(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(23404);
    this.heq = null;
    this.rAy = null;
    this.rzn = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cba();
    ((d.a)localObject).iLO = new cbb();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
    ((d.a)localObject).funcId = 1090;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rAy = ((d.a)localObject).aXF();
    localObject = (cba)this.rAy.iLK.iLR;
    ((cba)localObject).KOk = b.bfZ(paramString2);
    ((cba)localObject).KOi = b.bfZ(paramString3);
    ((cba)localObject).him = paramInt;
    this.rzn = paramString1;
    AppMethodBeat.o(23404);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23406);
    this.heq = parami;
    int i = dispatch(paramg, this.rAy, this);
    AppMethodBeat.o(23406);
    return i;
  }
  
  public final int getType()
  {
    return 1090;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23405);
    Log.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    ad.cKL().anJ(this.rzn);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((cbb)this.rAy.iLL.iLR).getBaseResponse().Ret;
      Log.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + paramInt1 + ",msg=" + paramString);
    }
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.s
 * JD-Core Version:    0.7.0.1
 */