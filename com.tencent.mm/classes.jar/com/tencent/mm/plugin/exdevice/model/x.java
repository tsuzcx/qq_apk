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
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.protocal.protobuf.dqj;
import com.tencent.mm.protocal.protobuf.dqk;

public final class x
  extends n
  implements k
{
  private f callback;
  public bnj qda;
  private com.tencent.mm.al.b rr;
  
  public x(bnj parambnj, int paramInt)
  {
    AppMethodBeat.i(23419);
    this.qda = parambnj;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dqj();
    ((b.a)localObject).hNN = new dqk();
    ((b.a)localObject).funcId = 537;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/unbindharddevice";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dqj)this.rr.hNK.hNQ;
    ((dqj)localObject).FDx = parambnj;
    ((dqj)localObject).FuX = paramInt;
    AppMethodBeat.o(23419);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23420);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23420);
    return i;
  }
  
  public final int getType()
  {
    return 537;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23421);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneUnBindHardDevice", "onGYNetEnd netId = %d, errType= %d, errCode = %d , errMsg =%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = i.qcH;
    i.ux(0L);
    paramq = ad.clt().acJ(this.qda.nDr);
    if (paramq != null)
    {
      if ((u.clV().qas != null) && (!u.clV().qas.uJ(paramq.field_mac))) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
      }
      if (!ad.clt().fG(this.qda.nDr, this.qda.FzJ)) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", new Object[] { Integer.valueOf(getType()) });
      }
      if ((this.rr == null) || (this.rr.hNL.hNQ == null)) {
        break label258;
      }
    }
    label258:
    for (paramq = (dqk)this.rr.hNL.hNQ;; paramq = null)
    {
      if (paramq == null) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23421);
      return;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", new Object[] { this.qda.nDr });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.x
 * JD-Core Version:    0.7.0.1
 */