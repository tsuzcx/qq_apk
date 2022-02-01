package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;

public final class v
{
  private static v yvD = null;
  public MMHandler oTi;
  final HashMap<Long, Integer> yvE;
  
  private v()
  {
    AppMethodBeat.i(23698);
    this.yvE = new HashMap();
    this.oTi = new MMHandler("MMExDevicePushCore");
    AppMethodBeat.o(23698);
  }
  
  public static v dGF()
  {
    AppMethodBeat.i(23699);
    if (yvD == null) {
      yvD = new v();
    }
    v localv = yvD;
    AppMethodBeat.o(23699);
    return localv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.v
 * JD-Core Version:    0.7.0.1
 */