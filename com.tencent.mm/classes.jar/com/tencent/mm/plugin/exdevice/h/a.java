package com.tencent.mm.plugin.exdevice.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public static void t(long paramLong, int paramInt)
  {
    AppMethodBeat.i(23587);
    b localb = ad.cmJ().adz(String.valueOf(paramLong));
    if (localb == null)
    {
      ae.e("MicroMsg.exdevice.BTDeviceReport", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
      AppMethodBeat.o(23587);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localb.field_deviceType).append(',');
    localStringBuilder.append(localb.field_deviceID).append(',');
    localStringBuilder.append(paramInt);
    g.yxI.kvStat(11232, localStringBuilder.toString());
    AppMethodBeat.o(23587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.h.a
 * JD-Core Version:    0.7.0.1
 */