package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;

final class r
{
  static void qS(int paramInt)
  {
    AppMethodBeat.i(155742);
    Log.i("MicroMsg.DeviceInfoDiagHelper", "[+] report idkey id: %s, key: %s, val: %s, isImportant: %s", new Object[] { Integer.valueOf(1064), Integer.valueOf(paramInt), Integer.valueOf(1), Boolean.TRUE });
    f.Ozc.idkeyStat(1064L, paramInt, 1L, true);
    AppMethodBeat.o(155742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.r
 * JD-Core Version:    0.7.0.1
 */