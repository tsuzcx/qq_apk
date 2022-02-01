package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;

public final class v
{
  private static v qgj = null;
  public ap imu;
  final HashMap<Long, Integer> qgk;
  
  private v()
  {
    AppMethodBeat.i(23698);
    this.qgk = new HashMap();
    this.imu = new ap("MMExDevicePushCore");
    AppMethodBeat.o(23698);
  }
  
  public static v clW()
  {
    AppMethodBeat.i(23699);
    if (qgj == null) {
      qgj = new v();
    }
    v localv = qgj;
    AppMethodBeat.o(23699);
    return localv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.v
 * JD-Core Version:    0.7.0.1
 */