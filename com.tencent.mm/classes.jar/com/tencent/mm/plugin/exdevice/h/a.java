package com.tencent.mm.plugin.exdevice.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.report.service.h;

public final class a
{
  public static void s(long paramLong, int paramInt)
  {
    AppMethodBeat.i(23587);
    b localb = com.tencent.mm.plugin.exdevice.model.ad.bZG().UQ(String.valueOf(paramLong));
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.BTDeviceReport", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
      AppMethodBeat.o(23587);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localb.field_deviceType).append(',');
    localStringBuilder.append(localb.field_deviceID).append(',');
    localStringBuilder.append(paramInt);
    h.vKh.kvStat(11232, localStringBuilder.toString());
    AppMethodBeat.o(23587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.h.a
 * JD-Core Version:    0.7.0.1
 */