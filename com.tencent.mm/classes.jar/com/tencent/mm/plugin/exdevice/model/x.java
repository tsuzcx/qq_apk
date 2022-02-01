package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.elc;
import com.tencent.mm.protocal.protobuf.eld;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
  extends q
  implements com.tencent.mm.network.m
{
  private com.tencent.mm.ak.i callback;
  public cat rAA;
  private d rr;
  
  public x(cat paramcat, int paramInt)
  {
    AppMethodBeat.i(23419);
    this.rAA = paramcat;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new elc();
    ((d.a)localObject).iLO = new eld();
    ((d.a)localObject).funcId = 537;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/unbindharddevice";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (elc)this.rr.iLK.iLR;
    ((elc)localObject).KPD = paramcat;
    ((elc)localObject).KHa = paramInt;
    AppMethodBeat.o(23419);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(23420);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23420);
    return i;
  }
  
  public final int getType()
  {
    return 537;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23421);
    Log.i("MicroMsg.exdevice.NetSceneUnBindHardDevice", "onGYNetEnd netId = %d, errType= %d, errCode = %d , errMsg =%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = i.rAi;
    i.CS(0L);
    params = ad.cKL().anJ(this.rAA.oTH);
    if (params != null)
    {
      if ((u.cLy().rxT != null) && (!u.cLy().rxT.De(params.field_mac))) {
        Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
      }
      if (!ad.cKL().gd(this.rAA.oTH, this.rAA.KLO)) {
        Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", new Object[] { Integer.valueOf(getType()) });
      }
      if ((this.rr == null) || (this.rr.iLL.iLR == null)) {
        break label258;
      }
    }
    label258:
    for (params = (eld)this.rr.iLL.iLR;; params = null)
    {
      if (params == null) {
        Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23421);
      return;
      Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", new Object[] { this.rAA.oTH });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.x
 * JD-Core Version:    0.7.0.1
 */