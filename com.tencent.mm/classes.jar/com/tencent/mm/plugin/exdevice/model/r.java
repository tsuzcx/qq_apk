package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bfm;

public final class r
  extends n
  implements k
{
  private g callback;
  private String dfM;
  String oWh;
  private com.tencent.mm.al.b rr;
  
  public r(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23398);
    this.callback = null;
    this.rr = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bfl();
    ((b.a)localObject).gUV = new bfm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/harddeviceauth";
    ((b.a)localObject).funcId = 541;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bfl)this.rr.gUS.gUX;
    bfj localbfj = new bfj();
    localbfj.CBS = paramString2;
    localbfj.mAT = paramString3;
    ((bfl)localObject).CFB = localbfj;
    ((bfl)localObject).DCO = paramInt;
    ((bfl)localObject).DCP = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    this.oWh = paramString3;
    this.dfM = paramString1;
    AppMethodBeat.o(23398);
  }
  
  private byte[] bZB()
  {
    AppMethodBeat.i(23403);
    Object localObject = (bfm)this.rr.gUT.gUX;
    try
    {
      localObject = ((bfm)localObject).DCQ.getBufferToBytes();
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
    Object localObject = (bfm)this.rr.gUT.gUX;
    try
    {
      localObject = ((bfm)localObject).CBb.getBufferToBytes();
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
  
  public final byte[] bZA()
  {
    AppMethodBeat.i(23402);
    Object localObject = (bfm)this.rr.gUT.gUX;
    try
    {
      localObject = ((bfm)localObject).DCR.getBufferToBytes();
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    paramq = ad.bZG().UR(this.oWh);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject = (bfm)this.rr.gUT.gUX;
      if (paramq != null)
      {
        paramArrayOfByte = bZA();
        if (paramArrayOfByte != null) {
          paramq.field_authBuf = paramArrayOfByte;
        }
        paramq.eKk = ((bfm)localObject).DCT;
        paramq.erH = true;
        paramq.eKj = ((bfm)localObject).DCS;
        paramq.erH = true;
        localObject = getSessionKey();
        if (localObject != null)
        {
          u.cah().b(paramq.field_mac, (byte[])localObject, 2);
          if (u.cai().oTC != null) {
            u.cai().oTC.setChannelSessionKey(paramq.field_mac, (byte[])localObject);
          }
          paramq.field_sessionKey = ((byte[])localObject);
        }
        localObject = bZB();
        if (localObject != null)
        {
          u.cah().b(paramq.field_mac, (byte[])localObject, 3);
          paramq.field_sessionBuf = ((byte[])localObject);
        }
        localObject = bZA();
        if (paramArrayOfByte != null)
        {
          u.cah().b(paramq.field_mac, (byte[])localObject, 1);
          paramq.field_authBuf = paramArrayOfByte;
        }
        paramq.eKl = (System.currentTimeMillis() / 1000L);
        paramq.erH = true;
        if (2 == u.cah().oS(paramq.field_mac))
        {
          ad.bZR();
          e.d(this.dfM, paramq.field_url, 2, paramq.field_deviceID);
        }
        u.cah().oV(paramq.field_mac);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", new Object[] { Boolean.valueOf(ad.bZG().update(paramq, new String[0])) });
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
        u.cah().oW(paramq.field_mac);
        ad.bZR();
        e.d(this.dfM, paramq.field_url, 4, paramq.field_deviceID);
      }
      ad.bZR();
      e.cP(this.dfM, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.r
 * JD-Core Version:    0.7.0.1
 */