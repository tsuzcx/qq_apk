package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.protocal.protobuf.bjj;
import com.tencent.mm.sdk.platformtools.ac;

public final class s
  extends n
  implements k
{
  private g gfX;
  private String pyh;
  private com.tencent.mm.ak.b pzt;
  
  public s(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(23404);
    this.gfX = null;
    this.pzt = null;
    this.pyh = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bji();
    ((b.a)localObject).hvu = new bjj();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
    ((b.a)localObject).funcId = 1090;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.pzt = ((b.a)localObject).aAz();
    localObject = (bji)this.pzt.hvr.hvw;
    ((bji)localObject).DWK = com.tencent.mm.bw.b.aIw(paramString2);
    ((bji)localObject).DWI = com.tencent.mm.bw.b.aIw(paramString3);
    ((bji)localObject).fZz = paramInt;
    this.pyh = paramString1;
    AppMethodBeat.o(23404);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(23406);
    this.gfX = paramg;
    int i = dispatch(parame, this.pzt, this);
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
    ac.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    ad.cgP().Zd(this.pyh);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((bjj)this.pzt.hvs.hvw).getBaseResponse().Ret;
      ac.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + paramInt1 + ",msg=" + paramString);
    }
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.s
 * JD-Core Version:    0.7.0.1
 */