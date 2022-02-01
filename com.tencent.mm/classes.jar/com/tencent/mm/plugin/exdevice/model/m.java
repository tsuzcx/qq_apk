package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.lu;
import com.tencent.mm.protocal.protobuf.lv;
import com.tencent.mm.sdk.platformtools.ae;

public final class m
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private long qjA;
  private String qjx;
  private long qjy;
  private String qjz;
  private com.tencent.mm.ak.b rr;
  
  public m(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    this.qjy = paramLong1;
    this.qjz = paramString1;
    this.qjx = paramString2;
    this.qjA = paramLong2;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(23387);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hQF = new lu();
    paramf.hQG = new lv();
    paramf.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
    paramf.funcId = 1262;
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDS();
    paramf = (lu)this.rr.hQD.hQJ;
    paramf.mac = com.tencent.mm.plugin.exdevice.k.b.vg(this.qjy);
    paramf.FWU = this.qjz;
    paramf.FWT = this.qjx;
    paramf.FWV = this.qjA;
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
    ae.i("MicroMsg.NetSceneBindUnauthDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    lv locallv;
    bob localbob;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      locallv = (lv)this.rr.hQE.hQJ;
      localbob = locallv.FVS;
      paramArrayOfByte = null;
      paramq = null;
      if (localbob != null)
      {
        paramArrayOfByte = localbob.nIM;
        paramq = localbob.FSh;
      }
      ae.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", new Object[] { paramArrayOfByte, paramq });
      if (ad.cmJ().fJ(paramq, paramArrayOfByte) == null) {
        break label291;
      }
      boolean bool = ad.cmJ().fK(paramArrayOfByte, paramq);
      ae.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { paramq, Boolean.valueOf(bool) });
      if (!bool) {
        break label308;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      paramq = new com.tencent.mm.plugin.exdevice.i.b();
      paramq.field_connProto = this.qjx;
      paramq.field_connStrategy = 1;
      paramq.field_closeStrategy = 1;
      paramq.field_url = "";
      f.a(paramq, localbob, locallv.FVT);
      if (paramq.field_mac == 0L)
      {
        ae.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
        paramq.field_mac = this.qjy;
      }
      if (paramInt1 != 0) {
        ad.cmJ().insert(paramq);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(23386);
        return;
        label291:
        paramInt1 = 1;
        break;
        ad.cmJ().e(paramq);
      }
      label308:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.m
 * JD-Core Version:    0.7.0.1
 */