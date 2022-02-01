package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ExpansionsGlobal
{
  private static final byte[] yFm;
  private static volatile boolean yFn;
  private static volatile boolean yFo;
  private static AtomicBoolean yFp;
  
  static
  {
    AppMethodBeat.i(152972);
    yFm = new byte[0];
    yFn = e.isMainProcess();
    yFo = false;
    yFp = new AtomicBoolean(false);
    AppMethodBeat.o(152972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.ExpansionsGlobal
 * JD-Core Version:    0.7.0.1
 */