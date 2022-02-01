package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.lk;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
  extends n
  implements k
{
  private g callback;
  private String pzn;
  private long pzo;
  private String pzp;
  private long pzq;
  private com.tencent.mm.ak.b rr;
  
  public m(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    this.pzo = paramLong1;
    this.pzp = paramString1;
    this.pzn = paramString2;
    this.pzq = paramLong2;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(23387);
    this.callback = paramg;
    paramg = new b.a();
    paramg.hvt = new lk();
    paramg.hvu = new ll();
    paramg.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
    paramg.funcId = 1262;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.rr = paramg.aAz();
    paramg = (lk)this.rr.hvr.hvw;
    paramg.mac = com.tencent.mm.plugin.exdevice.k.b.sR(this.pzo);
    paramg.DZd = this.pzp;
    paramg.DZc = this.pzn;
    paramg.DZe = this.pzq;
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
    ac.i("MicroMsg.NetSceneBindUnauthDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    ll localll;
    bjb localbjb;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localll = (ll)this.rr.hvs.hvw;
      localbjb = localll.DYb;
      paramArrayOfByte = null;
      paramq = null;
      if (localbjb != null)
      {
        paramArrayOfByte = localbjb.ncU;
        paramq = localbjb.DUp;
      }
      ac.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", new Object[] { paramArrayOfByte, paramq });
      if (ad.cgP().fv(paramq, paramArrayOfByte) == null) {
        break label291;
      }
      boolean bool = ad.cgP().fw(paramArrayOfByte, paramq);
      ac.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { paramq, Boolean.valueOf(bool) });
      if (!bool) {
        break label308;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      paramq = new com.tencent.mm.plugin.exdevice.i.b();
      paramq.field_connProto = this.pzn;
      paramq.field_connStrategy = 1;
      paramq.field_closeStrategy = 1;
      paramq.field_url = "";
      f.a(paramq, localbjb, localll.DYc);
      if (paramq.field_mac == 0L)
      {
        ac.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
        paramq.field_mac = this.pzo;
      }
      if (paramInt1 != 0) {
        ad.cgP().insert(paramq);
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(23386);
        return;
        label291:
        paramInt1 = 1;
        break;
        ad.cgP().e(paramq);
      }
      label308:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.m
 * JD-Core Version:    0.7.0.1
 */