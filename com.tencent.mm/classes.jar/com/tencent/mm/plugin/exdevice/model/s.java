package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bfq;
import com.tencent.mm.protocal.protobuf.bfr;

public final class s
  extends n
  implements k
{
  private g gbr;
  private String oUW;
  private com.tencent.mm.al.b oWi;
  
  public s(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(23404);
    this.gbr = null;
    this.oWi = null;
    this.oUW = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bfq();
    ((b.a)localObject).gUV = new bfr();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
    ((b.a)localObject).funcId = 1090;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.oWi = ((b.a)localObject).atI();
    localObject = (bfq)this.oWi.gUS.gUX;
    ((bfq)localObject).CEk = com.tencent.mm.bx.b.aDf(paramString2);
    ((bfq)localObject).CEi = com.tencent.mm.bx.b.aDf(paramString3);
    ((bfq)localObject).fVE = paramInt;
    this.oUW = paramString1;
    AppMethodBeat.o(23404);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(23406);
    this.gbr = paramg;
    int i = dispatch(parame, this.oWi, this);
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
    ad.bZG().UR(this.oUW);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((bfr)this.oWi.gUT.gUX).getBaseResponse().Ret;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + paramInt1 + ",msg=" + paramString);
    }
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.s
 * JD-Core Version:    0.7.0.1
 */