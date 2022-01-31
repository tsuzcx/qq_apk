package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.jw;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.sdk.platformtools.ab;

public final class m
  extends com.tencent.mm.ai.m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private String lFr;
  private long lFs;
  private String lFt;
  private long lFu;
  private com.tencent.mm.ai.b rr;
  
  public m(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    this.lFs = paramLong1;
    this.lFt = paramString1;
    this.lFr = paramString2;
    this.lFu = paramLong2;
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(19318);
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new jw();
    paramf.fsY = new jx();
    paramf.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
    paramf.funcId = 1262;
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.ado();
    paramf = (jw)this.rr.fsV.fta;
    paramf.mac = com.tencent.mm.plugin.exdevice.j.b.jx(this.lFs);
    paramf.wwu = this.lFt;
    paramf.wwt = this.lFr;
    paramf.wwv = this.lFu;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(19318);
    return i;
  }
  
  public final int getType()
  {
    return 1262;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19317);
    ab.i("MicroMsg.NetSceneBindUnauthDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    jx localjx;
    auh localauh;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localjx = (jx)this.rr.fsW.fta;
      localauh = localjx.wvw;
      paramArrayOfByte = null;
      paramq = null;
      if (localauh != null)
      {
        paramArrayOfByte = localauh.jJD;
        paramq = localauh.wsq;
      }
      ab.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", new Object[] { paramArrayOfByte, paramq });
      if (ad.bpY().dV(paramq, paramArrayOfByte) == null) {
        break label291;
      }
      boolean bool = ad.bpY().dW(paramArrayOfByte, paramq);
      ab.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { paramq, Boolean.valueOf(bool) });
      if (!bool) {
        break label308;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      paramq = new com.tencent.mm.plugin.exdevice.h.b();
      paramq.field_connProto = this.lFr;
      paramq.field_connStrategy = 1;
      paramq.field_closeStrategy = 1;
      paramq.field_url = "";
      f.a(paramq, localauh, localjx.wvx);
      if (paramq.field_mac == 0L)
      {
        ab.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
        paramq.field_mac = this.lFs;
      }
      if (paramInt1 != 0) {
        ad.bpY().insert(paramq);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(19317);
        return;
        label291:
        paramInt1 = 1;
        break;
        ad.bpY().e(paramq);
      }
      label308:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.m
 * JD-Core Version:    0.7.0.1
 */