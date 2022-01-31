package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;

public final class v
{
  private static v lII = null;
  public al fPW;
  final HashMap<Long, Integer> lIJ;
  
  private v()
  {
    AppMethodBeat.i(19630);
    this.lIJ = new HashMap();
    this.fPW = new al();
    AppMethodBeat.o(19630);
  }
  
  public static v bqB()
  {
    AppMethodBeat.i(19631);
    if (lII == null) {
      lII = new v();
    }
    v localv = lII;
    AppMethodBeat.o(19631);
    return localv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.v
 * JD-Core Version:    0.7.0.1
 */