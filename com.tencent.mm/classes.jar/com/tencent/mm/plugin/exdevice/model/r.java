package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjd;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.platformtools.ac;

public final class r
  extends n
  implements k
{
  private g callback;
  private String ddh;
  String pzs;
  private com.tencent.mm.ak.b rr;
  
  public r(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23398);
    this.callback = null;
    this.rr = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bjd();
    ((b.a)localObject).hvu = new bje();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/harddeviceauth";
    ((b.a)localObject).funcId = 541;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bjd)this.rr.hvr.hvw;
    bjb localbjb = new bjb();
    localbjb.DUp = paramString2;
    localbjb.ncU = paramString3;
    ((bjd)localObject).DYb = localbjb;
    ((bjd)localObject).EYk = paramInt;
    ((bjd)localObject).EYl = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    this.pzs = paramString3;
    this.ddh = paramString1;
    AppMethodBeat.o(23398);
  }
  
  private byte[] cgK()
  {
    AppMethodBeat.i(23403);
    Object localObject = (bje)this.rr.hvs.hvw;
    try
    {
      localObject = ((bje)localObject).EYm.getBufferToBytes();
      AppMethodBeat.o(23403);
      return localObject;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(23403);
    }
    return null;
  }
  
  private byte[] getSessionKey()
  {
    AppMethodBeat.i(23401);
    Object localObject = (bje)this.rr.hvs.hvw;
    try
    {
      localObject = ((bje)localObject).DTz.getBufferToBytes();
      AppMethodBeat.o(23401);
      return localObject;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(23401);
    }
    return null;
  }
  
  public final byte[] cgJ()
  {
    AppMethodBeat.i(23402);
    Object localObject = (bje)this.rr.hvs.hvw;
    try
    {
      localObject = ((bje)localObject).EYn.getBufferToBytes();
      AppMethodBeat.o(23402);
      return localObject;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(23402);
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(23400);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23400);
    return i;
  }
  
  public final int getType()
  {
    return 541;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23399);
    ac.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    paramq = ad.cgP().Zd(this.pzs);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject = (bje)this.rr.hvs.hvw;
      if (paramq != null)
      {
        paramArrayOfByte = cgJ();
        if (paramArrayOfByte != null) {
          paramq.field_authBuf = paramArrayOfByte;
        }
        paramq.eNc = ((bje)localObject).EYp;
        paramq.etL = true;
        paramq.eNb = ((bje)localObject).EYo;
        paramq.etL = true;
        localObject = getSessionKey();
        if (localObject != null)
        {
          u.chq().b(paramq.field_mac, (byte[])localObject, 2);
          if (u.chr().pwN != null) {
            u.chr().pwN.setChannelSessionKey(paramq.field_mac, (byte[])localObject);
          }
          paramq.field_sessionKey = ((byte[])localObject);
        }
        localObject = cgK();
        if (localObject != null)
        {
          u.chq().b(paramq.field_mac, (byte[])localObject, 3);
          paramq.field_sessionBuf = ((byte[])localObject);
        }
        localObject = cgJ();
        if (paramArrayOfByte != null)
        {
          u.chq().b(paramq.field_mac, (byte[])localObject, 1);
          paramq.field_authBuf = paramArrayOfByte;
        }
        paramq.eNd = (System.currentTimeMillis() / 1000L);
        paramq.etL = true;
        if (2 == u.chq().sE(paramq.field_mac))
        {
          ad.cha();
          e.e(this.ddh, paramq.field_url, 2, paramq.field_deviceID);
        }
        u.chq().sH(paramq.field_mac);
        ac.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", new Object[] { Boolean.valueOf(ad.cgP().update(paramq, new String[0])) });
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23399);
      return;
      ac.e("MicroMsg.exdevice.NetSceneHardDeviceAuth", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceIdServer == null");
      continue;
      if (paramq != null)
      {
        u.chq().sI(paramq.field_mac);
        ad.cha();
        e.e(this.ddh, paramq.field_url, 4, paramq.field_deviceID);
      }
      ad.cha();
      e.cU(this.ddh, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.r
 * JD-Core Version:    0.7.0.1
 */