package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.protocal.protobuf.bnl;
import com.tencent.mm.protocal.protobuf.bnm;

public final class r
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private String doD;
  String qcX;
  private com.tencent.mm.al.b rr;
  
  public r(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23398);
    this.callback = null;
    this.rr = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bnl();
    ((b.a)localObject).hNN = new bnm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/harddeviceauth";
    ((b.a)localObject).funcId = 541;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bnl)this.rr.hNK.hNQ;
    bnj localbnj = new bnj();
    localbnj.FzJ = paramString2;
    localbnj.nDr = paramString3;
    ((bnl)localObject).FDx = localbnj;
    ((bnl)localObject).GHG = paramInt;
    ((bnl)localObject).GHH = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    this.qcX = paramString3;
    this.doD = paramString1;
    AppMethodBeat.o(23398);
  }
  
  private byte[] clo()
  {
    AppMethodBeat.i(23403);
    Object localObject = (bnm)this.rr.hNL.hNQ;
    try
    {
      localObject = ((bnm)localObject).GHI.getBufferToBytes();
      AppMethodBeat.o(23403);
      return localObject;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(23403);
    }
    return null;
  }
  
  private byte[] getSessionKey()
  {
    AppMethodBeat.i(23401);
    Object localObject = (bnm)this.rr.hNL.hNQ;
    try
    {
      localObject = ((bnm)localObject).FyT.getBufferToBytes();
      AppMethodBeat.o(23401);
      return localObject;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(23401);
    }
    return null;
  }
  
  public final byte[] cln()
  {
    AppMethodBeat.i(23402);
    Object localObject = (bnm)this.rr.hNL.hNQ;
    try
    {
      localObject = ((bnm)localObject).GHJ.getBufferToBytes();
      AppMethodBeat.o(23402);
      return localObject;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(23402);
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(23400);
    this.callback = paramf;
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    paramq = ad.clt().acJ(this.qcX);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject = (bnm)this.rr.hNL.hNQ;
      if (paramq != null)
      {
        paramArrayOfByte = cln();
        if (paramArrayOfByte != null) {
          paramq.field_authBuf = paramArrayOfByte;
        }
        paramq.ffy = ((bnm)localObject).GHL;
        paramq.eKU = true;
        paramq.ffx = ((bnm)localObject).GHK;
        paramq.eKU = true;
        localObject = getSessionKey();
        if (localObject != null)
        {
          u.clU().b(paramq.field_mac, (byte[])localObject, 2);
          if (u.clV().qas != null) {
            u.clV().qas.setChannelSessionKey(paramq.field_mac, (byte[])localObject);
          }
          paramq.field_sessionKey = ((byte[])localObject);
        }
        localObject = clo();
        if (localObject != null)
        {
          u.clU().b(paramq.field_mac, (byte[])localObject, 3);
          paramq.field_sessionBuf = ((byte[])localObject);
        }
        localObject = cln();
        if (paramArrayOfByte != null)
        {
          u.clU().b(paramq.field_mac, (byte[])localObject, 1);
          paramq.field_authBuf = paramArrayOfByte;
        }
        paramq.ffz = (System.currentTimeMillis() / 1000L);
        paramq.eKU = true;
        if (2 == u.clU().uC(paramq.field_mac))
        {
          ad.clE();
          e.e(this.doD, paramq.field_url, 2, paramq.field_deviceID);
        }
        u.clU().uF(paramq.field_mac);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", new Object[] { Boolean.valueOf(ad.clt().update(paramq, new String[0])) });
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23399);
      return;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.NetSceneHardDeviceAuth", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceIdServer == null");
      continue;
      if (paramq != null)
      {
        u.clU().uG(paramq.field_mac);
        ad.clE();
        e.e(this.doD, paramq.field_url, 4, paramq.field_deviceID);
      }
      ad.clE();
      e.cX(this.doD, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.r
 * JD-Core Version:    0.7.0.1
 */