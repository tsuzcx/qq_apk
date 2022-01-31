package com.tencent.mm.plugin.exdevice.g;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static void k(long paramLong, int paramInt)
  {
    b localb = ad.aLL().BF(String.valueOf(paramLong));
    if (localb == null)
    {
      y.e("MicroMsg.exdevice.BTDeviceReport", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localb.field_deviceType).append(',');
    localStringBuilder.append(localb.field_deviceID).append(',');
    localStringBuilder.append(paramInt);
    h.nFQ.aC(11232, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a
 * JD-Core Version:    0.7.0.1
 */