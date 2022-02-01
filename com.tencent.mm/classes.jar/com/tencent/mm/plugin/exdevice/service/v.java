package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;

public final class v
{
  private static v oZt = null;
  public ap hsB;
  final HashMap<Long, Integer> oZu;
  
  private v()
  {
    AppMethodBeat.i(23698);
    this.oZu = new HashMap();
    this.hsB = new ap("MMExDevicePushCore");
    AppMethodBeat.o(23698);
  }
  
  public static v caj()
  {
    AppMethodBeat.i(23699);
    if (oZt == null) {
      oZt = new v();
    }
    v localv = oZt;
    AppMethodBeat.o(23699);
    return localv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.v
 * JD-Core Version:    0.7.0.1
 */