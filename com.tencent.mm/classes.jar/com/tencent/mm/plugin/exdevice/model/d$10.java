package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.df.a;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class d$10
  extends w
{
  d$10(d paramd) {}
  
  public final void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    AppMethodBeat.i(19108);
    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", new Object[] { com.tencent.mm.plugin.exdevice.j.b.jw(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (ah.getContext() == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
      AppMethodBeat.o(19108);
      return;
    }
    Object localObject;
    if (4 == paramInt2)
    {
      u.bqz().jo(paramLong1);
      localObject = com.tencent.mm.plugin.exdevice.h.a.LG("shut_down_device");
      if ((localObject != null) && (localObject.length != 0))
      {
        int i = localObject.length;
        paramInt3 = 0;
        while (paramInt3 < i)
        {
          paramLong2 = localObject[paramInt3];
          if (paramLong2 == paramLong1)
          {
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel in the shut down device list, deviceId = %d", new Object[] { Long.valueOf(paramLong2) });
            d.iZ(paramLong2);
            if (!com.tencent.mm.plugin.exdevice.h.a.M("shut_down_device", paramLong2)) {
              ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "removeFromSharedPreferences failed!!!");
            }
          }
          paramInt3 += 1;
        }
      }
      if (d.d(this.lDd).get(Long.valueOf(paramLong1)) == null) {
        break label341;
      }
      ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device connect strategy(%d)", new Object[] { d.d(this.lDd).get(Long.valueOf(paramLong1)) });
      localObject = new df();
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      if ((!((df)localObject).cqG.caE) || ((((Integer)d.d(this.lDd).get(Long.valueOf(paramLong1))).intValue() & 0x1) != 1)) {
        d.iZ(paramLong1);
      }
    }
    while (paramInt1 != paramInt2)
    {
      localObject = ad.bpY().LH(String.valueOf(paramLong1));
      if ((localObject == null) || (bo.isNullOrNil(((com.tencent.mm.plugin.exdevice.h.b)localObject).field_brandName)))
      {
        ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", new Object[] { Long.valueOf(paramLong1) });
        AppMethodBeat.o(19108);
        return;
        label341:
        d.iZ(paramLong1);
      }
      else
      {
        f.a locala = u.bqz().jl(paramLong1);
        if (locala != null) {
          locala.crJ = paramInt2;
        }
        while (paramInt2 == 2)
        {
          ab.w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
          AppMethodBeat.o(19108);
          return;
          ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", new Object[] { Long.valueOf(paramLong1) });
        }
        ad.bqj();
        e.c(((com.tencent.mm.plugin.exdevice.h.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject).field_url, paramInt2, ((com.tencent.mm.plugin.exdevice.h.b)localObject).field_deviceID);
      }
    }
    AppMethodBeat.o(19108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.10
 * JD-Core Version:    0.7.0.1
 */