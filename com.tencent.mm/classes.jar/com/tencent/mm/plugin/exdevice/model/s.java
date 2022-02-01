package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.ciw;
import com.tencent.mm.protocal.protobuf.cix;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  private String fzM;
  private d rr;
  String vge;
  
  public s(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23398);
    this.callback = null;
    this.rr = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ciw();
    ((d.a)localObject).lBV = new cix();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/harddeviceauth";
    ((d.a)localObject).funcId = 541;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ciw)d.b.b(this.rr.lBR);
    ciu localciu = new ciu();
    localciu.RMK = paramString2;
    localciu.rVF = paramString3;
    ((ciw)localObject).RQB = localciu;
    ((ciw)localObject).TpV = paramInt;
    ((ciw)localObject).TpW = new eae().dc(paramArrayOfByte);
    this.vge = paramString3;
    this.fzM = paramString1;
    AppMethodBeat.o(23398);
  }
  
  private byte[] cZs()
  {
    AppMethodBeat.i(23403);
    Object localObject = (cix)d.c.b(this.rr.lBS);
    try
    {
      localObject = ((cix)localObject).TpX.Tkb.UH;
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
    Object localObject = (cix)d.c.b(this.rr.lBS);
    try
    {
      localObject = ((cix)localObject).RLU.Tkb.UH;
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
  
  public final byte[] cZr()
  {
    AppMethodBeat.i(23402);
    Object localObject = (cix)d.c.b(this.rr.lBS);
    try
    {
      localObject = ((cix)localObject).TpY.Tkb.UH;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23399);
    Log.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    params = ae.cZx().avI(this.vge);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject = (cix)d.c.b(this.rr.lBS);
      if (params != null)
      {
        paramArrayOfByte = cZr();
        if (paramArrayOfByte != null) {
          params.field_authBuf = paramArrayOfByte;
        }
        params.idP = ((cix)localObject).Tqa;
        params.hwY = true;
        params.idO = ((cix)localObject).TpZ;
        params.hwY = true;
        localObject = getSessionKey();
        if (localObject != null)
        {
          u.dak().b(params.field_mac, (byte[])localObject, 2);
          if (u.dal().vdz != null) {
            u.dal().vdz.setChannelSessionKey(params.field_mac, (byte[])localObject);
          }
          params.field_sessionKey = ((byte[])localObject);
        }
        localObject = cZs();
        if (localObject != null)
        {
          u.dak().b(params.field_mac, (byte[])localObject, 3);
          params.field_sessionBuf = ((byte[])localObject);
        }
        localObject = cZr();
        if (paramArrayOfByte != null)
        {
          u.dak().b(params.field_mac, (byte[])localObject, 1);
          params.field_authBuf = paramArrayOfByte;
        }
        params.idQ = (System.currentTimeMillis() / 1000L);
        params.hwY = true;
        if (2 == u.dak().Jl(params.field_mac))
        {
          ae.cZJ();
          e.d(this.fzM, params.field_url, 2, params.field_deviceID);
        }
        u.dak().Jo(params.field_mac);
        Log.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", new Object[] { Boolean.valueOf(ae.cZx().update(params, new String[0])) });
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
        u.dak().Jp(params.field_mac);
        ae.cZJ();
        e.d(this.fzM, params.field_url, 4, params.field_deviceID);
      }
      ae.cZJ();
      e.dC(this.fzM, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.s
 * JD-Core Version:    0.7.0.1
 */