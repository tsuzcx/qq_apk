package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class l
  extends q
  implements m
{
  private i callback;
  private com.tencent.mm.an.d rr;
  
  public l(String paramString, int paramInt)
  {
    AppMethodBeat.i(23383);
    this.callback = null;
    this.rr = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new lr();
    ((d.a)localObject).lBV = new ls();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/bindharddevice";
    ((d.a)localObject).funcId = 536;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (lr)d.b.b(this.rr.lBR);
    ((lr)localObject).RPV = Util.nullAsNil(paramString);
    ((lr)localObject).RQA = Util.nullAsNil(Integer.valueOf(paramInt));
    AppMethodBeat.o(23383);
  }
  
  public final ls cZq()
  {
    AppMethodBeat.i(286104);
    if ((this.rr != null) && (d.c.b(this.rr.lBS) != null))
    {
      ls localls = (ls)d.c.b(this.rr.lBS);
      AppMethodBeat.o(286104);
      return localls;
    }
    AppMethodBeat.o(286104);
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
      paramArrayOfByte = cZq();
      Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", new Object[] { paramArrayOfByte.RQB.rVF, paramArrayOfByte.RQB.RMK });
      String str1 = paramArrayOfByte.RQC.RMc;
      String str2 = paramArrayOfByte.RQC.TpK;
      String str3 = paramArrayOfByte.RQC.RPQ;
      String str4 = paramArrayOfByte.RQC.TpL;
      paramInt1 = paramArrayOfByte.RQC.TpM;
      if (paramArrayOfByte.RIs != 0) {
        break label465;
      }
      params = "sync";
      Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(paramInt1), params });
      paramInt1 = 0;
      if (ae.cZx().gr(paramArrayOfByte.RQC.TpK, paramArrayOfByte.RQB.rVF) == null) {
        break label473;
      }
      boolean bool = ae.cZx().gs(paramArrayOfByte.RQB.rVF, paramArrayOfByte.RQC.TpK);
      Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { paramArrayOfByte.RQC.TpK, Boolean.valueOf(bool) });
      if (bool) {
        paramInt1 = 1;
      }
      params = new b();
      f.a(params, paramArrayOfByte.RQB, paramArrayOfByte.RQC);
      params.field_url = "";
      paramArrayOfByte = u.dak().Jm(params.field_mac);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.fAF == 2))
      {
        Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
        ae.cZF();
        d.IW(params.field_mac);
        paramArrayOfByte = u.dak();
        l = params.field_mac;
        if (!paramArrayOfByte.vjm.containsKey(Long.valueOf(l))) {
          break label478;
        }
        paramArrayOfByte.vjm.remove(Long.valueOf(l));
        Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", new Object[] { Long.valueOf(l) });
      }
      label431:
      if (paramInt1 == 0) {
        break label502;
      }
      ae.cZx().insert(params);
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
      ae.cZx().e(params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.l
 * JD-Core Version:    0.7.0.1
 */