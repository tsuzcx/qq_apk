package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;

public final class v
{
  private static v rDV = null;
  public MMHandler jkv;
  final HashMap<Long, Integer> rDW;
  
  private v()
  {
    AppMethodBeat.i(23698);
    this.rDW = new HashMap();
    this.jkv = new MMHandler("MMExDevicePushCore");
    AppMethodBeat.o(23698);
  }
  
  public static v cLz()
  {
    AppMethodBeat.i(23699);
    if (rDV == null) {
      rDV = new v();
    }
    v localv = rDV;
    AppMethodBeat.o(23699);
    return localv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.v
 * JD-Core Version:    0.7.0.1
 */