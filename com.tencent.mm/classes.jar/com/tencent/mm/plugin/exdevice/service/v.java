package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;

public final class v
{
  private static v vjF = null;
  public MMHandler mat;
  final HashMap<Long, Integer> vjG;
  
  private v()
  {
    AppMethodBeat.i(23698);
    this.vjG = new HashMap();
    this.mat = new MMHandler("MMExDevicePushCore");
    AppMethodBeat.o(23698);
  }
  
  public static v dam()
  {
    AppMethodBeat.i(23699);
    if (vjF == null) {
      vjF = new v();
    }
    v localv = vjF;
    AppMethodBeat.o(23699);
    return localv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.v
 * JD-Core Version:    0.7.0.1
 */