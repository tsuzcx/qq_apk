package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.le;
import com.tencent.mm.protocal.protobuf.lf;

public final class m
  extends n
  implements k
{
  private g callback;
  private String oWc;
  private long oWd;
  private String oWe;
  private long oWf;
  private com.tencent.mm.al.b rr;
  
  public m(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    this.oWd = paramLong1;
    this.oWe = paramString1;
    this.oWc = paramString2;
    this.oWf = paramLong2;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(23387);
    this.callback = paramg;
    paramg = new b.a();
    paramg.gUU = new le();
    paramg.gUV = new lf();
    paramg.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
    paramg.funcId = 1262;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.rr = paramg.atI();
    paramg = (le)this.rr.gUS.gUX;
    paramg.mac = com.tencent.mm.plugin.exdevice.k.b.pf(this.oWd);
    paramg.CGD = this.oWe;
    paramg.CGC = this.oWc;
    paramg.CGE = this.oWf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23387);
    return i;
  }
  
  public final int getType()
  {
    return 1262;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23386);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneBindUnauthDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    lf locallf;
    bfj localbfj;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      locallf = (lf)this.rr.gUT.gUX;
      localbfj = locallf.CFB;
      paramArrayOfByte = null;
      paramq = null;
      if (localbfj != null)
      {
        paramArrayOfByte = localbfj.mAT;
        paramq = localbfj.CBS;
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", new Object[] { paramArrayOfByte, paramq });
      if (ad.bZG().fi(paramq, paramArrayOfByte) == null) {
        break label291;
      }
      boolean bool = ad.bZG().fj(paramArrayOfByte, paramq);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { paramq, Boolean.valueOf(bool) });
      if (!bool) {
        break label308;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      paramq = new com.tencent.mm.plugin.exdevice.i.b();
      paramq.field_connProto = this.oWc;
      paramq.field_connStrategy = 1;
      paramq.field_closeStrategy = 1;
      paramq.field_url = "";
      f.a(paramq, localbfj, locallf.CFC);
      if (paramq.field_mac == 0L)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
        paramq.field_mac = this.oWd;
      }
      if (paramInt1 != 0) {
        ad.bZG().insert(paramq);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(23386);
        return;
        label291:
        paramInt1 = 1;
        break;
        ad.bZG().e(paramq);
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