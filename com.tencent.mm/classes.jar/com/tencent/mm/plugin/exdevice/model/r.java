package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends q
  implements com.tencent.mm.network.m
{
  private String brandName;
  private i callback;
  String rAx;
  private d rr;
  
  public r(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23398);
    this.callback = null;
    this.rr = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cav();
    ((d.a)localObject).iLO = new caw();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/harddeviceauth";
    ((d.a)localObject).funcId = 541;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cav)this.rr.iLK.iLR;
    cat localcat = new cat();
    localcat.KLO = paramString2;
    localcat.oTH = paramString3;
    ((cav)localObject).KPD = localcat;
    ((cav)localObject).Mgj = paramInt;
    ((cav)localObject).Mgk = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    this.rAx = paramString3;
    this.brandName = paramString1;
    AppMethodBeat.o(23398);
  }
  
  private byte[] cKG()
  {
    AppMethodBeat.i(23403);
    Object localObject = (caw)this.rr.iLL.iLR;
    try
    {
      localObject = ((caw)localObject).Mgl.getBufferToBytes();
      AppMethodBeat.o(23403);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(23403);
    }
    return null;
  }
  
  private byte[] getSessionKey()
  {
    AppMethodBeat.i(23401);
    Object localObject = (caw)this.rr.iLL.iLR;
    try
    {
      localObject = ((caw)localObject).KKY.getBufferToBytes();
      AppMethodBeat.o(23401);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(23401);
    }
    return null;
  }
  
  public final byte[] cKF()
  {
    AppMethodBeat.i(23402);
    Object localObject = (caw)this.rr.iLL.iLR;
    try
    {
      localObject = ((caw)localObject).Mgm.getBufferToBytes();
      AppMethodBeat.o(23402);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
      AppMethodBeat.o(23402);
    }
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23400);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23400);
    return i;
  }
  
  public final int getType()
  {
    return 541;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23399);
    Log.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    params = ad.cKL().anJ(this.rAx);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject = (caw)this.rr.iLL.iLR;
      if (params != null)
      {
        paramArrayOfByte = cKF();
        if (paramArrayOfByte != null) {
          params.field_authBuf = paramArrayOfByte;
        }
        params.fLY = ((caw)localObject).Mgo;
        params.fqk = true;
        params.fLX = ((caw)localObject).Mgn;
        params.fqk = true;
        localObject = getSessionKey();
        if (localObject != null)
        {
          u.cLx().b(params.field_mac, (byte[])localObject, 2);
          if (u.cLy().rxT != null) {
            u.cLy().rxT.setChannelSessionKey(params.field_mac, (byte[])localObject);
          }
          params.field_sessionKey = ((byte[])localObject);
        }
        localObject = cKG();
        if (localObject != null)
        {
          u.cLx().b(params.field_mac, (byte[])localObject, 3);
          params.field_sessionBuf = ((byte[])localObject);
        }
        localObject = cKF();
        if (paramArrayOfByte != null)
        {
          u.cLx().b(params.field_mac, (byte[])localObject, 1);
          params.field_authBuf = paramArrayOfByte;
        }
        params.fLZ = (System.currentTimeMillis() / 1000L);
        params.fqk = true;
        if (2 == u.cLx().CX(params.field_mac))
        {
          ad.cKW();
          e.d(this.brandName, params.field_url, 2, params.field_deviceID);
        }
        u.cLx().Da(params.field_mac);
        Log.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", new Object[] { Boolean.valueOf(ad.cKL().update(params, new String[0])) });
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23399);
      return;
      Log.e("MicroMsg.exdevice.NetSceneHardDeviceAuth", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceIdServer == null");
      continue;
      if (params != null)
      {
        u.cLx().Db(params.field_mac);
        ad.cKW();
        e.d(this.brandName, params.field_url, 4, params.field_deviceID);
      }
      ad.cKW();
      e.dh(this.brandName, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.r
 * JD-Core Version:    0.7.0.1
 */