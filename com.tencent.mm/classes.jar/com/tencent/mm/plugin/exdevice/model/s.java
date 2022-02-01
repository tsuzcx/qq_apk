package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.sdk.platformtools.ae;

public final class s
  extends n
  implements k
{
  private f gCo;
  private String qir;
  private com.tencent.mm.ak.b qjD;
  
  public s(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(23404);
    this.gCo = null;
    this.qjD = null;
    this.qir = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new boi();
    ((b.a)localObject).hQG = new boj();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
    ((b.a)localObject).funcId = 1090;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.qjD = ((b.a)localObject).aDS();
    localObject = (boi)this.qjD.hQD.hQJ;
    ((boi)localObject).FUB = com.tencent.mm.bw.b.aPw(paramString2);
    ((boi)localObject).FUz = com.tencent.mm.bw.b.aPw(paramString3);
    ((boi)localObject).gvx = paramInt;
    this.qir = paramString1;
    AppMethodBeat.o(23404);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23406);
    this.gCo = paramf;
    int i = dispatch(parame, this.qjD, this);
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
    ae.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    ad.cmJ().adA(this.qir);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((boj)this.qjD.hQE.hQJ).getBaseResponse().Ret;
      ae.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + paramInt1 + ",msg=" + paramString);
    }
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.s
 * JD-Core Version:    0.7.0.1
 */