package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.mb;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  private d rr;
  private String vfZ;
  private long vga;
  private String vgb;
  private long vgc;
  
  public m(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    this.vga = paramLong1;
    this.vgb = paramString1;
    this.vfZ = paramString2;
    this.vgc = paramLong2;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23387);
    this.callback = parami;
    parami = new d.a();
    parami.lBU = new mb();
    parami.lBV = new mc();
    parami.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
    parami.funcId = 1262;
    parami.lBW = 0;
    parami.respCmdId = 0;
    this.rr = parami.bgN();
    parami = (mb)d.b.b(this.rr.lBR);
    parami.mac = com.tencent.mm.plugin.exdevice.k.b.Jy(this.vga);
    parami.RRE = this.vgb;
    parami.RRD = this.vfZ;
    parami.RRF = this.vgc;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23387);
    return i;
  }
  
  public final int getType()
  {
    return 1262;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23386);
    Log.i("MicroMsg.NetSceneBindUnauthDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    mc localmc;
    ciu localciu;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localmc = (mc)d.c.b(this.rr.lBS);
      localciu = localmc.RQB;
      paramArrayOfByte = null;
      params = null;
      if (localciu != null)
      {
        paramArrayOfByte = localciu.rVF;
        params = localciu.RMK;
      }
      Log.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", new Object[] { paramArrayOfByte, params });
      if (ae.cZx().gr(params, paramArrayOfByte) == null) {
        break label291;
      }
      boolean bool = ae.cZx().gs(paramArrayOfByte, params);
      Log.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { params, Boolean.valueOf(bool) });
      if (!bool) {
        break label308;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      params = new com.tencent.mm.plugin.exdevice.i.b();
      params.field_connProto = this.vfZ;
      params.field_connStrategy = 1;
      params.field_closeStrategy = 1;
      params.field_url = "";
      f.a(params, localciu, localmc.RQC);
      if (params.field_mac == 0L)
      {
        Log.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
        params.field_mac = this.vga;
      }
      if (paramInt1 != 0) {
        ae.cZx().insert(params);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(23386);
        return;
        label291:
        paramInt1 = 1;
        break;
        ae.cZx().e(params);
      }
      label308:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.m
 * JD-Core Version:    0.7.0.1
 */