package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;

public final class v
{
  private static v qmO = null;
  public aq ipo;
  final HashMap<Long, Integer> qmP;
  
  private v()
  {
    AppMethodBeat.i(23698);
    this.qmP = new HashMap();
    this.ipo = new aq("MMExDevicePushCore");
    AppMethodBeat.o(23698);
  }
  
  public static v cnm()
  {
    AppMethodBeat.i(23699);
    if (qmO == null) {
      qmO = new v();
    }
    v localv = qmO;
    AppMethodBeat.o(23699);
    return localv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.v
 * JD-Core Version:    0.7.0.1
 */