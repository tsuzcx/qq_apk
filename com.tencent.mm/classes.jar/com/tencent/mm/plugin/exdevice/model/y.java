package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.evi;
import com.tencent.mm.protocal.protobuf.evj;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends q
  implements com.tencent.mm.network.m
{
  private com.tencent.mm.an.i callback;
  private d rr;
  public ciu vgh;
  
  public y(ciu paramciu, int paramInt)
  {
    AppMethodBeat.i(23419);
    this.vgh = paramciu;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new evi();
    ((d.a)localObject).lBV = new evj();
    ((d.a)localObject).funcId = 537;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/unbindharddevice";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (evi)d.b.b(this.rr.lBR);
    ((evi)localObject).RQB = paramciu;
    ((evi)localObject).RIs = paramInt;
    AppMethodBeat.o(23419);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
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
    params = i.vfP;
    i.Jg(0L);
    params = ae.cZx().avI(this.vgh.rVF);
    if (params != null)
    {
      if ((u.dal().vdz != null) && (!u.dal().vdz.Js(params.field_mac))) {
        Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
      }
      if (!ae.cZx().gs(this.vgh.rVF, this.vgh.RMK)) {
        Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", new Object[] { Integer.valueOf(getType()) });
      }
      if ((this.rr == null) || (d.c.b(this.rr.lBS) == null)) {
        break label258;
      }
    }
    label258:
    for (params = (evj)d.c.b(this.rr.lBS);; params = null)
    {
      if (params == null) {
        Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23421);
      return;
      Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", new Object[] { this.vgh.rVF });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.y
 * JD-Core Version:    0.7.0.1
 */