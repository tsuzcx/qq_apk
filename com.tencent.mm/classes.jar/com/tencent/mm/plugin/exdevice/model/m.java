package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.ml;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  private String rAs;
  private long rAt;
  private String rAu;
  private long rAv;
  private d rr;
  
  public m(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    this.rAt = paramLong1;
    this.rAu = paramString1;
    this.rAs = paramString2;
    this.rAv = paramLong2;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23387);
    this.callback = parami;
    parami = new d.a();
    parami.iLN = new ml();
    parami.iLO = new mm();
    parami.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
    parami.funcId = 1262;
    parami.iLP = 0;
    parami.respCmdId = 0;
    this.rr = parami.aXF();
    parami = (ml)this.rr.iLK.iLR;
    parami.mac = com.tencent.mm.plugin.exdevice.k.b.Dk(this.rAt);
    parami.KQG = this.rAu;
    parami.KQF = this.rAs;
    parami.KQH = this.rAv;
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
    mm localmm;
    cat localcat;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localmm = (mm)this.rr.iLL.iLR;
      localcat = localmm.KPD;
      paramArrayOfByte = null;
      params = null;
      if (localcat != null)
      {
        paramArrayOfByte = localcat.oTH;
        params = localcat.KLO;
      }
      Log.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", new Object[] { paramArrayOfByte, params });
      if (ad.cKL().gc(params, paramArrayOfByte) == null) {
        break label291;
      }
      boolean bool = ad.cKL().gd(paramArrayOfByte, params);
      Log.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { params, Boolean.valueOf(bool) });
      if (!bool) {
        break label308;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      params = new com.tencent.mm.plugin.exdevice.i.b();
      params.field_connProto = this.rAs;
      params.field_connStrategy = 1;
      params.field_closeStrategy = 1;
      params.field_url = "";
      f.a(params, localcat, localmm.KPE);
      if (params.field_mac == 0L)
      {
        Log.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
        params.field_mac = this.rAt;
      }
      if (paramInt1 != 0) {
        ad.cKL().insert(params);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(23386);
        return;
        label291:
        paramInt1 = 1;
        break;
        ad.cKL().e(params);
      }
      label308:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.m
 * JD-Core Version:    0.7.0.1
 */