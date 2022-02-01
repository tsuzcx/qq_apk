package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.protocal.protobuf.mb;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class l
  extends q
  implements m
{
  private i callback;
  private com.tencent.mm.ak.d rr;
  
  public l(String paramString, int paramInt)
  {
    AppMethodBeat.i(23383);
    this.callback = null;
    this.rr = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new mb();
    ((d.a)localObject).iLO = new mc();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/bindharddevice";
    ((d.a)localObject).funcId = 536;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (mb)this.rr.iLK.iLR;
    ((mb)localObject).KOX = Util.nullAsNil(paramString);
    ((mb)localObject).KPC = Util.nullAsNil(Integer.valueOf(paramInt));
    AppMethodBeat.o(23383);
  }
  
  public final mc cKE()
  {
    if ((this.rr != null) && (this.rr.iLL.iLR != null)) {
      return (mc)this.rr.iLL.iLR;
    }
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23385);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23385);
    return i;
  }
  
  public final int getType()
  {
    return 536;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23384);
    Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    label290:
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = cKE();
      Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", new Object[] { paramArrayOfByte.KPD.oTH, paramArrayOfByte.KPD.KLO });
      String str1 = paramArrayOfByte.KPE.KLg;
      String str2 = paramArrayOfByte.KPE.MfY;
      String str3 = paramArrayOfByte.KPE.KOS;
      String str4 = paramArrayOfByte.KPE.MfZ;
      paramInt1 = paramArrayOfByte.KPE.Mga;
      if (paramArrayOfByte.KHa != 0) {
        break label464;
      }
      params = "sync";
      Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(paramInt1), params });
      paramInt1 = 0;
      if (ad.cKL().gc(paramArrayOfByte.KPE.MfY, paramArrayOfByte.KPD.oTH) == null) {
        break label472;
      }
      boolean bool = ad.cKL().gd(paramArrayOfByte.KPD.oTH, paramArrayOfByte.KPE.MfY);
      Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { paramArrayOfByte.KPE.MfY, Boolean.valueOf(bool) });
      if (bool) {
        paramInt1 = 1;
      }
      params = new b();
      f.a(params, paramArrayOfByte.KPD, paramArrayOfByte.KPE);
      params.field_url = "";
      paramArrayOfByte = u.cLx().CY(params.field_mac);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.dHO == 2))
      {
        Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
        ad.cKS();
        d.CM(params.field_mac);
        paramArrayOfByte = u.cLx();
        l = params.field_mac;
        if (!paramArrayOfByte.rDC.containsKey(Long.valueOf(l))) {
          break label477;
        }
        paramArrayOfByte.rDC.remove(Long.valueOf(l));
        Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", new Object[] { Long.valueOf(l) });
      }
      label430:
      if (paramInt1 == 0) {
        break label501;
      }
      ad.cKL().insert(params);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23384);
      return;
      label464:
      params = "async";
      break;
      label472:
      paramInt1 = 1;
      break label290;
      label477:
      Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "device id not contains in the map : %d", new Object[] { Long.valueOf(l) });
      break label430;
      label501:
      ad.cKL().e(params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.l
 * JD-Core Version:    0.7.0.1
 */