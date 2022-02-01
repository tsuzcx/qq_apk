package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ExpansionsGlobal
{
  private static final byte[] qvM;
  private static volatile boolean qvN;
  private static volatile boolean qvO;
  private static AtomicBoolean qvP;
  
  static
  {
    AppMethodBeat.i(152972);
    qvM = new byte[0];
    qvN = a.coh();
    qvO = false;
    qvP = new AtomicBoolean(false);
    AppMethodBeat.o(152972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.ExpansionsGlobal
 * JD-Core Version:    0.7.0.1
 */