package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bnq;
import com.tencent.mm.protocal.protobuf.bnr;

public final class s
  extends n
  implements k
{
  private f gzH;
  private String qbM;
  private com.tencent.mm.al.b qcY;
  
  public s(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(23404);
    this.gzH = null;
    this.qcY = null;
    this.qbM = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bnq();
    ((b.a)localObject).hNN = new bnr();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
    ((b.a)localObject).funcId = 1090;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.qcY = ((b.a)localObject).aDC();
    localObject = (bnq)this.qcY.hNK.hNQ;
    ((bnq)localObject).FCg = com.tencent.mm.bx.b.aNZ(paramString2);
    ((bnq)localObject).FCe = com.tencent.mm.bx.b.aNZ(paramString3);
    ((bnq)localObject).gsV = paramInt;
    this.qbM = paramString1;
    AppMethodBeat.o(23404);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23406);
    this.gzH = paramf;
    int i = dispatch(parame, this.qcY, this);
    AppMethodBeat.o(23406);
    return i;
  }
  
  public final int getType()
  {
    return 1090;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23405);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    ad.clt().acJ(this.qbM);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((bnr)this.qcY.hNL.hNQ).getBaseResponse().Ret;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + paramInt1 + ",msg=" + paramString);
    }
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.s
 * JD-Core Version:    0.7.0.1
 */