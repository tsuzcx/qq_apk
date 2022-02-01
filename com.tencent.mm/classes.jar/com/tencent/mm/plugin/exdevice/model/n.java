package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.protocal.protobuf.ms;
import com.tencent.mm.protocal.protobuf.mt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class n
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private com.tencent.mm.am.c rr;
  
  public n(String paramString, int paramInt)
  {
    AppMethodBeat.i(23383);
    this.callback = null;
    this.rr = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ms();
    ((c.a)localObject).otF = new mt();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/bindharddevice";
    ((c.a)localObject).funcId = 536;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ms)c.b.b(this.rr.otB);
    ((ms)localObject).YNj = Util.nullAsNil(paramString);
    ((ms)localObject).YNQ = Util.nullAsNil(Integer.valueOf(paramInt));
    AppMethodBeat.o(23383);
  }
  
  public final mt dFH()
  {
    AppMethodBeat.i(274632);
    if ((this.rr != null) && (c.c.b(this.rr.otC) != null))
    {
      mt localmt = (mt)c.c.b(this.rr.otC);
      AppMethodBeat.o(274632);
      return localmt;
    }
    AppMethodBeat.o(274632);
    return null;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(23385);
    this.callback = paramh;
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
      paramArrayOfByte = dFH();
      Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", new Object[] { paramArrayOfByte.YNR.vgV, paramArrayOfByte.YNR.YJY });
      String str1 = paramArrayOfByte.YNS.YJq;
      String str2 = paramArrayOfByte.YNS.aaDM;
      String str3 = paramArrayOfByte.YNS.YNe;
      String str4 = paramArrayOfByte.YNS.aaDN;
      paramInt1 = paramArrayOfByte.YNS.aaDO;
      if (paramArrayOfByte.YFu != 0) {
        break label465;
      }
      params = "sync";
      Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(paramInt1), params });
      paramInt1 = 0;
      if (ah.dFO().gV(paramArrayOfByte.YNS.aaDM, paramArrayOfByte.YNR.vgV) == null) {
        break label473;
      }
      boolean bool = ah.dFO().gW(paramArrayOfByte.YNR.vgV, paramArrayOfByte.YNS.aaDM);
      Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { paramArrayOfByte.YNS.aaDM, Boolean.valueOf(bool) });
      if (bool) {
        paramInt1 = 1;
      }
      params = new b();
      h.a(params, paramArrayOfByte.YNR, paramArrayOfByte.YNS);
      params.field_url = "";
      paramArrayOfByte = u.dGD().lC(params.field_mac);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.hFs == 2))
      {
        Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
        ah.dFY();
        f.lt(params.field_mac);
        paramArrayOfByte = u.dGD();
        l = params.field_mac;
        if (!paramArrayOfByte.yvk.containsKey(Long.valueOf(l))) {
          break label478;
        }
        paramArrayOfByte.yvk.remove(Long.valueOf(l));
        Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", new Object[] { Long.valueOf(l) });
      }
      label431:
      if (paramInt1 == 0) {
        break label502;
      }
      ah.dFO().insert(params);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23384);
      return;
      label465:
      params = "async";
      break;
      label473:
      paramInt1 = 1;
      break label290;
      label478:
      Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "device id not contains in the map : %d", new Object[] { Long.valueOf(l) });
      break label431;
      label502:
      ah.dFO().e(params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.n
 * JD-Core Version:    0.7.0.1
 */