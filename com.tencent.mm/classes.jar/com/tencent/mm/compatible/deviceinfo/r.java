package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;

final class r
{
  static void kX(int paramInt)
  {
    AppMethodBeat.i(155742);
    ad.i("MicroMsg.DeviceInfoDiagHelper", "[+] report idkey id: %s, key: %s, val: %s, isImportant: %s", new Object[] { Integer.valueOf(1064), Integer.valueOf(paramInt), Integer.valueOf(1), Boolean.TRUE });
    e.vIY.idkeyStat(1064L, paramInt, 1L, true);
    AppMethodBeat.o(155742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.r
 * JD-Core Version:    0.7.0.1
 */