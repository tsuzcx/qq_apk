package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
  extends q
  implements m
{
  private i jQg;
  private String veU;
  private d vgf;
  
  public t(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(23404);
    this.jQg = null;
    this.vgf = null;
    this.veU = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cjb();
    ((d.a)localObject).lBV = new cjc();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
    ((d.a)localObject).funcId = 1090;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.vgf = ((d.a)localObject).bgN();
    localObject = (cjb)d.b.b(this.vgf.lBR);
    ((cjb)localObject).RPf = b.bss(paramString2);
    ((cjb)localObject).RPd = b.bss(paramString3);
    ((cjb)localObject).jUk = paramInt;
    this.veU = paramString1;
    AppMethodBeat.o(23404);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23406);
    this.jQg = parami;
    int i = dispatch(paramg, this.vgf, this);
    AppMethodBeat.o(23406);
    return i;
  }
  
  public final int getType()
  {
    return 1090;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23405);
    Log.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    ae.cZx().avI(this.veU);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((cjc)d.c.b(this.vgf.lBS)).getBaseResponse().CqV;
      Log.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + paramInt1 + ",msg=" + paramString);
    }
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.t
 * JD-Core Version:    0.7.0.1
 */