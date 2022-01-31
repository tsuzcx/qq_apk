package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.sdk.platformtools.ab;

public final class r
  extends com.tencent.mm.ai.m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private String cqQ;
  String lFw;
  private com.tencent.mm.ai.b rr;
  
  public r(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19329);
    this.callback = null;
    this.rr = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new auj();
    ((b.a)localObject).fsY = new auk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/harddeviceauth";
    ((b.a)localObject).funcId = 541;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (auj)this.rr.fsV.fta;
    auh localauh = new auh();
    localauh.wsq = paramString2;
    localauh.jJD = paramString3;
    ((auj)localObject).wvw = localauh;
    ((auj)localObject).xjt = paramInt;
    ((auj)localObject).xju = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    this.lFw = paramString3;
    this.cqQ = paramString1;
    AppMethodBeat.o(19329);
  }
  
  private byte[] bpT()
  {
    AppMethodBeat.i(19334);
    Object localObject = (auk)this.rr.fsW.fta;
    try
    {
      localObject = ((auk)localObject).xjv.getBufferToBytes();
      AppMethodBeat.o(19334);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(19334);
    }
    return null;
  }
  
  private byte[] getSessionKey()
  {
    AppMethodBeat.i(19332);
    Object localObject = (auk)this.rr.fsW.fta;
    try
    {
      localObject = ((auk)localObject).wrK.getBufferToBytes();
      AppMethodBeat.o(19332);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(19332);
    }
    return null;
  }
  
  public final byte[] bpS()
  {
    AppMethodBeat.i(19333);
    Object localObject = (auk)this.rr.fsW.fta;
    try
    {
      localObject = ((auk)localObject).xjw.getBufferToBytes();
      AppMethodBeat.o(19333);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(19333);
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(19331);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(19331);
    return i;
  }
  
  public final int getType()
  {
    return 541;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19330);
    ab.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    paramq = ad.bpY().LI(this.lFw);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject = (auk)this.rr.fsW.fta;
      if (paramq != null)
      {
        paramArrayOfByte = bpS();
        if (paramArrayOfByte != null) {
          paramq.field_authBuf = paramArrayOfByte;
        }
        paramq.dCG = ((auk)localObject).xjy;
        paramq.dmY = true;
        paramq.dCF = ((auk)localObject).xjx;
        paramq.dmY = true;
        localObject = getSessionKey();
        if (localObject != null)
        {
          u.bqz().b(paramq.field_mac, (byte[])localObject, 2);
          if (u.bqA().lCQ != null) {
            u.bqA().lCQ.setChannelSessionKey(paramq.field_mac, (byte[])localObject);
          }
          paramq.field_sessionKey = ((byte[])localObject);
        }
        localObject = bpT();
        if (localObject != null)
        {
          u.bqz().b(paramq.field_mac, (byte[])localObject, 3);
          paramq.field_sessionBuf = ((byte[])localObject);
        }
        localObject = bpS();
        if (paramArrayOfByte != null)
        {
          u.bqz().b(paramq.field_mac, (byte[])localObject, 1);
          paramq.field_authBuf = paramArrayOfByte;
        }
        paramq.dCH = (System.currentTimeMillis() / 1000L);
        paramq.dmY = true;
        if (2 == u.bqz().jk(paramq.field_mac))
        {
          ad.bqj();
          e.c(this.cqQ, paramq.field_url, 2, paramq.field_deviceID);
        }
        u.bqz().jn(paramq.field_mac);
        ab.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", new Object[] { Boolean.valueOf(ad.bpY().update(paramq, new String[0])) });
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(19330);
      return;
      ab.e("MicroMsg.exdevice.NetSceneHardDeviceAuth", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceIdServer == null");
      continue;
      if (paramq != null)
      {
        u.bqz().jo(paramq.field_mac);
        ad.bqj();
        e.c(this.cqQ, paramq.field_url, 4, paramq.field_deviceID);
      }
      ad.bqj();
      e.cd(this.cqQ, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.r
 * JD-Core Version:    0.7.0.1
 */