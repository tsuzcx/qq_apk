package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashMap;

public final class v
{
  private static v pCE = null;
  public ao hTd;
  final HashMap<Long, Integer> pCF;
  
  private v()
  {
    AppMethodBeat.i(23698);
    this.pCF = new HashMap();
    this.hTd = new ao("MMExDevicePushCore");
    AppMethodBeat.o(23698);
  }
  
  public static v chs()
  {
    AppMethodBeat.i(23699);
    if (pCE == null) {
      pCE = new v();
    }
    v localv = pCE;
    AppMethodBeat.o(23699);
    return localv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.v
 * JD-Core Version:    0.7.0.1
 */