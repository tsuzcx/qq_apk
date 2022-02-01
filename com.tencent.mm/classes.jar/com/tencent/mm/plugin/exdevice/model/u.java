package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.cyz;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;

public final class u
  extends p
  implements com.tencent.mm.network.m
{
  private h callback;
  private String hEy;
  private com.tencent.mm.am.c rr;
  String ysc;
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23398);
    this.callback = null;
    this.rr = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cyz();
    ((c.a)localObject).otF = new cza();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/harddeviceauth";
    ((c.a)localObject).funcId = 541;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cyz)c.b.b(this.rr.otB);
    cyx localcyx = new cyx();
    localcyx.YJY = paramString2;
    localcyx.vgV = paramString3;
    ((cyz)localObject).YNR = localcyx;
    ((cyz)localObject).aaDX = paramInt;
    ((cyz)localObject).aaDY = new gol().df(paramArrayOfByte);
    this.ysc = paramString3;
    this.hEy = paramString1;
    AppMethodBeat.o(23398);
  }
  
  private byte[] dFJ()
  {
    AppMethodBeat.i(23403);
    Object localObject = (cza)c.c.b(this.rr.otC);
    try
    {
      localObject = ((cza)localObject).aaDZ.aaxD.Op;
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
    Object localObject = (cza)c.c.b(this.rr.otC);
    try
    {
      localObject = ((cza)localObject).YJi.aaxD.Op;
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
  
  public final byte[] dFI()
  {
    AppMethodBeat.i(23402);
    Object localObject = (cza)c.c.b(this.rr.otC);
    try
    {
      localObject = ((cza)localObject).aaEa.aaxD.Op;
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
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(23400);
    this.callback = paramh;
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
    params = ah.dFO().apI(this.ysc);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject = (cza)c.c.b(this.rr.otC);
      if (params != null)
      {
        paramArrayOfByte = dFI();
        if (paramArrayOfByte != null) {
          params.field_authBuf = paramArrayOfByte;
        }
        params.kCZ = ((cza)localObject).aaEc;
        params.jTR = true;
        params.kCY = ((cza)localObject).aaEb;
        params.jTR = true;
        localObject = getSessionKey();
        if (localObject != null)
        {
          com.tencent.mm.plugin.exdevice.service.u.dGD().b(params.field_mac, (byte[])localObject, 2);
          if (com.tencent.mm.plugin.exdevice.service.u.dGE().yps != null) {
            com.tencent.mm.plugin.exdevice.service.u.dGE().yps.setChannelSessionKey(params.field_mac, (byte[])localObject);
          }
          params.field_sessionKey = ((byte[])localObject);
        }
        localObject = dFJ();
        if (localObject != null)
        {
          com.tencent.mm.plugin.exdevice.service.u.dGD().b(params.field_mac, (byte[])localObject, 3);
          params.field_sessionBuf = ((byte[])localObject);
        }
        localObject = dFI();
        if (paramArrayOfByte != null)
        {
          com.tencent.mm.plugin.exdevice.service.u.dGD().b(params.field_mac, (byte[])localObject, 1);
          params.field_authBuf = paramArrayOfByte;
        }
        params.kDa = (System.currentTimeMillis() / 1000L);
        params.jTR = true;
        if (2 == com.tencent.mm.plugin.exdevice.service.u.dGD().lB(params.field_mac))
        {
          ah.dGc();
          g.d(this.hEy, params.field_url, 2, params.field_deviceID);
        }
        com.tencent.mm.plugin.exdevice.service.u.dGD().lE(params.field_mac);
        Log.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", new Object[] { Boolean.valueOf(ah.dFO().update(params, new String[0])) });
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
        com.tencent.mm.plugin.exdevice.service.u.dGD().lF(params.field_mac);
        ah.dGc();
        g.d(this.hEy, params.field_url, 4, params.field_deviceID);
      }
      ah.dGc();
      g.ef(this.hEy, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.u
 * JD-Core Version:    0.7.0.1
 */