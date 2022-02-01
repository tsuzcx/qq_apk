package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.sdk.platformtools.ae;

public final class r
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private String dpI;
  String qjC;
  private com.tencent.mm.ak.b rr;
  
  public r(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23398);
    this.callback = null;
    this.rr = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bod();
    ((b.a)localObject).hQG = new boe();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/harddeviceauth";
    ((b.a)localObject).funcId = 541;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bod)this.rr.hQD.hQJ;
    bob localbob = new bob();
    localbob.FSh = paramString2;
    localbob.nIM = paramString3;
    ((bod)localObject).FVS = localbob;
    ((bod)localObject).Hbi = paramInt;
    ((bod)localObject).Hbj = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    this.qjC = paramString3;
    this.dpI = paramString1;
    AppMethodBeat.o(23398);
  }
  
  private byte[] cmE()
  {
    AppMethodBeat.i(23403);
    Object localObject = (boe)this.rr.hQE.hQJ;
    try
    {
      localObject = ((boe)localObject).Hbk.getBufferToBytes();
      AppMethodBeat.o(23403);
      return localObject;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(23403);
    }
    return null;
  }
  
  private byte[] getSessionKey()
  {
    AppMethodBeat.i(23401);
    Object localObject = (boe)this.rr.hQE.hQJ;
    try
    {
      localObject = ((boe)localObject).FRr.getBufferToBytes();
      AppMethodBeat.o(23401);
      return localObject;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(23401);
    }
    return null;
  }
  
  public final byte[] cmD()
  {
    AppMethodBeat.i(23402);
    Object localObject = (boe)this.rr.hQE.hQJ;
    try
    {
      localObject = ((boe)localObject).Hbl.getBufferToBytes();
      AppMethodBeat.o(23402);
      return localObject;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(23402);
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
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
    ae.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    paramq = ad.cmJ().adA(this.qjC);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject = (boe)this.rr.hQE.hQJ;
      if (paramq != null)
      {
        paramArrayOfByte = cmD();
        if (paramArrayOfByte != null) {
          paramq.field_authBuf = paramArrayOfByte;
        }
        paramq.fhv = ((boe)localObject).Hbn;
        paramq.eMD = true;
        paramq.fhu = ((boe)localObject).Hbm;
        paramq.eMD = true;
        localObject = getSessionKey();
        if (localObject != null)
        {
          u.cnk().b(paramq.field_mac, (byte[])localObject, 2);
          if (u.cnl().qgX != null) {
            u.cnl().qgX.setChannelSessionKey(paramq.field_mac, (byte[])localObject);
          }
          paramq.field_sessionKey = ((byte[])localObject);
        }
        localObject = cmE();
        if (localObject != null)
        {
          u.cnk().b(paramq.field_mac, (byte[])localObject, 3);
          paramq.field_sessionBuf = ((byte[])localObject);
        }
        localObject = cmD();
        if (paramArrayOfByte != null)
        {
          u.cnk().b(paramq.field_mac, (byte[])localObject, 1);
          paramq.field_authBuf = paramArrayOfByte;
        }
        paramq.fhw = (System.currentTimeMillis() / 1000L);
        paramq.eMD = true;
        if (2 == u.cnk().uT(paramq.field_mac))
        {
          ad.cmU();
          e.e(this.dpI, paramq.field_url, 2, paramq.field_deviceID);
        }
        u.cnk().uW(paramq.field_mac);
        ae.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", new Object[] { Boolean.valueOf(ad.cmJ().update(paramq, new String[0])) });
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23399);
      return;
      ae.e("MicroMsg.exdevice.NetSceneHardDeviceAuth", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceIdServer == null");
      continue;
      if (paramq != null)
      {
        u.cnk().uX(paramq.field_mac);
        ad.cmU();
        e.e(this.dpI, paramq.field_url, 4, paramq.field_deviceID);
      }
      ad.cmU();
      e.db(this.dpI, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.r
 * JD-Core Version:    0.7.0.1
 */