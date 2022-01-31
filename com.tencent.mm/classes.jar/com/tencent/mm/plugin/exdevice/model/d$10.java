package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.h.a.dc;
import com.tencent.mm.h.a.dc.a;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class d$10
  extends w
{
  d$10(d paramd) {}
  
  public final void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    y.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", new Object[] { com.tencent.mm.plugin.exdevice.j.b.ee(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (ae.getContext() == null) {
      y.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
    }
    Object localObject;
    for (;;)
    {
      return;
      if (4 == paramInt2)
      {
        u.aMm().dW(paramLong1);
        localObject = com.tencent.mm.plugin.exdevice.h.a.BE("shut_down_device");
        if ((localObject != null) && (localObject.length != 0))
        {
          int i = localObject.length;
          paramInt3 = 0;
          while (paramInt3 < i)
          {
            paramLong2 = localObject[paramInt3];
            if (paramLong2 == paramLong1)
            {
              y.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel in the shut down device list, deviceId = %d", new Object[] { Long.valueOf(paramLong2) });
              d.dH(paramLong2);
              if (!com.tencent.mm.plugin.exdevice.h.a.C("shut_down_device", paramLong2)) {
                y.e("MicroMsg.exdevice.ExdeviceConnectManager", "removeFromSharedPreferences failed!!!");
              }
            }
            paramInt3 += 1;
          }
        }
        if (d.e(this.jtE).get(Long.valueOf(paramLong1)) == null) {
          break label323;
        }
        y.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device connect strategy(%d)", new Object[] { d.e(this.jtE).get(Long.valueOf(paramLong1)) });
        localObject = new dc();
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
        if ((!((dc)localObject).bJm.byC) || ((((Integer)d.e(this.jtE).get(Long.valueOf(paramLong1))).intValue() & 0x1) != 1)) {
          d.dH(paramLong1);
        }
      }
      while (paramInt1 != paramInt2)
      {
        localObject = ad.aLL().BF(String.valueOf(paramLong1));
        if ((localObject != null) && (!bk.bl(((com.tencent.mm.plugin.exdevice.h.b)localObject).field_brandName))) {
          break label330;
        }
        y.e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", new Object[] { Long.valueOf(paramLong1) });
        return;
        label323:
        d.dH(paramLong1);
      }
    }
    label330:
    f.a locala = u.aMm().dT(paramLong1);
    if (locala != null) {
      locala.bKp = paramInt2;
    }
    while (paramInt2 == 2)
    {
      y.w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
      return;
      y.i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", new Object[] { Long.valueOf(paramLong1) });
    }
    ad.aLW();
    e.c(((com.tencent.mm.plugin.exdevice.h.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject).field_url, paramInt2, ((com.tencent.mm.plugin.exdevice.h.b)localObject).field_deviceID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.10
 * JD-Core Version:    0.7.0.1
 */