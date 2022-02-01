package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.fqv;
import com.tencent.mm.protocal.protobuf.fqw;
import com.tencent.mm.sdk.platformtools.Log;

public final class ab
  extends p
  implements com.tencent.mm.network.m
{
  private h callback;
  private com.tencent.mm.am.c rr;
  public cyx ysg;
  
  public ab(cyx paramcyx, int paramInt)
  {
    AppMethodBeat.i(23419);
    this.ysg = paramcyx;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fqv();
    ((c.a)localObject).otF = new fqw();
    ((c.a)localObject).funcId = 537;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/unbindharddevice";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fqv)c.b.b(this.rr.otB);
    ((fqv)localObject).YNR = paramcyx;
    ((fqv)localObject).YFu = paramInt;
    AppMethodBeat.o(23419);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(23420);
    this.callback = paramh;
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
    params = k.yrL;
    k.lv(0L);
    params = ah.dFO().apI(this.ysg.vgV);
    if (params != null)
    {
      if ((u.dGE().yps != null) && (!u.dGE().yps.lI(params.field_mac))) {
        Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
      }
      if (!ah.dFO().gW(this.ysg.vgV, this.ysg.YJY)) {
        Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", new Object[] { Integer.valueOf(getType()) });
      }
      if ((this.rr == null) || (c.c.b(this.rr.otC) == null)) {
        break label258;
      }
    }
    label258:
    for (params = (fqw)c.c.b(this.rr.otC);; params = null)
    {
      if (params == null) {
        Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23421);
      return;
      Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", new Object[] { this.ysg.vgV });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ab
 * JD-Core Version:    0.7.0.1
 */