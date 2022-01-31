package com.tencent.mm.compatible.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;

final class r
{
  static void iO(int paramInt)
  {
    AppMethodBeat.i(155880);
    ab.i("MicroMsg.DeviceInfoDiagHelper", "[+] report idkey id: %s, key: %s, val: %s, isImportant: %s", new Object[] { Integer.valueOf(1064), Integer.valueOf(paramInt), Integer.valueOf(1), Boolean.TRUE });
    e.qrI.idkeyStat(1064L, paramInt, 1L, true);
    AppMethodBeat.o(155880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.r
 * JD-Core Version:    0.7.0.1
 */