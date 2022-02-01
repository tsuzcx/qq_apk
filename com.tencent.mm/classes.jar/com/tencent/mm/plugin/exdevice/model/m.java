package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.protocal.protobuf.lu;
import com.tencent.mm.protocal.protobuf.lv;

public final class m
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private String qcS;
  private long qcT;
  private String qcU;
  private long qcV;
  private com.tencent.mm.al.b rr;
  
  public m(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    this.qcT = paramLong1;
    this.qcU = paramString1;
    this.qcS = paramString2;
    this.qcV = paramLong2;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(23387);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hNM = new lu();
    paramf.hNN = new lv();
    paramf.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
    paramf.funcId = 1262;
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDC();
    paramf = (lu)this.rr.hNK.hNQ;
    paramf.mac = com.tencent.mm.plugin.exdevice.k.b.uP(this.qcT);
    paramf.FEz = this.qcU;
    paramf.FEy = this.qcS;
    paramf.FEA = this.qcV;
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
    lv locallv;
    bnj localbnj;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      locallv = (lv)this.rr.hNL.hNQ;
      localbnj = locallv.FDx;
      paramArrayOfByte = null;
      paramq = null;
      if (localbnj != null)
      {
        paramArrayOfByte = localbnj.nDr;
        paramq = localbnj.FzJ;
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", new Object[] { paramArrayOfByte, paramq });
      if (ad.clt().fF(paramq, paramArrayOfByte) == null) {
        break label291;
      }
      boolean bool = ad.clt().fG(paramArrayOfByte, paramq);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { paramq, Boolean.valueOf(bool) });
      if (!bool) {
        break label308;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      paramq = new com.tencent.mm.plugin.exdevice.i.b();
      paramq.field_connProto = this.qcS;
      paramq.field_connStrategy = 1;
      paramq.field_closeStrategy = 1;
      paramq.field_url = "";
      f.a(paramq, localbnj, locallv.FDy);
      if (paramq.field_mac == 0L)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
        paramq.field_mac = this.qcT;
      }
      if (paramInt1 != 0) {
        ad.clt().insert(paramq);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(23386);
        return;
        label291:
        paramInt1 = 1;
        break;
        ad.clt().e(paramq);
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