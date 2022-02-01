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
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.drg;
import com.tencent.mm.protocal.protobuf.drh;
import com.tencent.mm.sdk.platformtools.ae;

public final class x
  extends n
  implements k
{
  private f callback;
  public bob qjF;
  private com.tencent.mm.ak.b rr;
  
  public x(bob parambob, int paramInt)
  {
    AppMethodBeat.i(23419);
    this.qjF = parambob;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new drg();
    ((b.a)localObject).hQG = new drh();
    ((b.a)localObject).funcId = 537;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/unbindharddevice";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (drg)this.rr.hQD.hQJ;
    ((drg)localObject).FVS = parambob;
    ((drg)localObject).FNv = paramInt;
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
    ae.i("MicroMsg.exdevice.NetSceneUnBindHardDevice", "onGYNetEnd netId = %d, errType= %d, errCode = %d , errMsg =%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = i.qjm;
    i.uO(0L);
    paramq = ad.cmJ().adA(this.qjF.nIM);
    if (paramq != null)
    {
      if ((u.cnl().qgX != null) && (!u.cnl().qgX.va(paramq.field_mac))) {
        ae.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
      }
      if (!ad.cmJ().fK(this.qjF.nIM, this.qjF.FSh)) {
        ae.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        ae.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", new Object[] { Integer.valueOf(getType()) });
      }
      if ((this.rr == null) || (this.rr.hQE.hQJ == null)) {
        break label258;
      }
    }
    label258:
    for (paramq = (drh)this.rr.hQE.hQJ;; paramq = null)
    {
      if (paramq == null) {
        ae.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23421);
      return;
      ae.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", new Object[] { this.qjF.nIM });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.x
 * JD-Core Version:    0.7.0.1
 */