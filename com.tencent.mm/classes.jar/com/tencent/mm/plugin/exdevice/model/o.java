package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.ne;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private com.tencent.mm.am.c rr;
  private String yrX;
  private long yrY;
  private String yrZ;
  private long ysa;
  
  public o(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    this.yrY = paramLong1;
    this.yrZ = paramString1;
    this.yrX = paramString2;
    this.ysa = paramLong2;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(23387);
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new ne();
    paramh.otF = new nf();
    paramh.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
    paramh.funcId = 1262;
    paramh.otG = 0;
    paramh.respCmdId = 0;
    this.rr = paramh.bEF();
    paramh = (ne)c.b.b(this.rr.otB);
    paramh.mac = com.tencent.mm.plugin.exdevice.k.b.lP(this.yrY);
    paramh.YOW = this.yrZ;
    paramh.YOV = this.yrX;
    paramh.YOX = this.ysa;
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
    nf localnf;
    cyx localcyx;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localnf = (nf)c.c.b(this.rr.otC);
      localcyx = localnf.YNR;
      paramArrayOfByte = null;
      params = null;
      if (localcyx != null)
      {
        paramArrayOfByte = localcyx.vgV;
        params = localcyx.YJY;
      }
      Log.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", new Object[] { paramArrayOfByte, params });
      if (ah.dFO().gV(params, paramArrayOfByte) == null) {
        break label291;
      }
      boolean bool = ah.dFO().gW(paramArrayOfByte, params);
      Log.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { params, Boolean.valueOf(bool) });
      if (!bool) {
        break label308;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      params = new com.tencent.mm.plugin.exdevice.i.b();
      params.field_connProto = this.yrX;
      params.field_connStrategy = 1;
      params.field_closeStrategy = 1;
      params.field_url = "";
      h.a(params, localcyx, localnf.YNS);
      if (params.field_mac == 0L)
      {
        Log.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
        params.field_mac = this.yrY;
      }
      if (paramInt1 != 0) {
        ah.dFO().insert(params);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(23386);
        return;
        label291:
        paramInt1 = 1;
        break;
        ah.dFO().e(params);
      }
      label308:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.o
 * JD-Core Version:    0.7.0.1
 */