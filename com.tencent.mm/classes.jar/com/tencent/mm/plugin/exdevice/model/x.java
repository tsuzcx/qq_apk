package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.cmd;
import com.tencent.mm.protocal.protobuf.cme;
import com.tencent.mm.sdk.platformtools.ab;

public final class x
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  public auh lFz;
  private com.tencent.mm.ai.b rr;
  
  public x(auh paramauh, int paramInt)
  {
    AppMethodBeat.i(19350);
    this.lFz = paramauh;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cmd();
    ((b.a)localObject).fsY = new cme();
    ((b.a)localObject).funcId = 537;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/unbindharddevice";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cmd)this.rr.fsV.fta;
    ((cmd)localObject).wvw = paramauh;
    ((cmd)localObject).woE = paramInt;
    AppMethodBeat.o(19350);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(19351);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(19351);
    return i;
  }
  
  public final int getType()
  {
    return 537;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19352);
    ab.i("MicroMsg.exdevice.NetSceneUnBindHardDevice", "onGYNetEnd netId = %d, errType= %d, errCode = %d , errMsg =%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = i.lFf;
    i.jf(0L);
    paramq = ad.bpY().LI(this.lFz.jJD);
    if (paramq != null)
    {
      if ((u.bqA().lCQ != null) && (!u.bqA().lCQ.jr(paramq.field_mac))) {
        ab.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
      }
      if (!ad.bpY().dW(this.lFz.jJD, this.lFz.wsq)) {
        ab.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        ab.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", new Object[] { Integer.valueOf(getType()) });
      }
      if ((this.rr == null) || (this.rr.fsW.fta == null)) {
        break label258;
      }
    }
    label258:
    for (paramq = (cme)this.rr.fsW.fta;; paramq = null)
    {
      if (paramq == null) {
        ab.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(19352);
      return;
      ab.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", new Object[] { this.lFz.jJD });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.x
 * JD-Core Version:    0.7.0.1
 */