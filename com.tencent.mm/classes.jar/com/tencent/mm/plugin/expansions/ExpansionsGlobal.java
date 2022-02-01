package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ExpansionsGlobal
{
  private static final byte[] rNt;
  private static volatile boolean rNu;
  private static volatile boolean rNv;
  private static AtomicBoolean rNw;
  
  static
  {
    AppMethodBeat.i(152972);
    rNt = new byte[0];
    rNu = a.isMainProcess();
    rNv = false;
    rNw = new AtomicBoolean(false);
    AppMethodBeat.o(152972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.ExpansionsGlobal
 * JD-Core Version:    0.7.0.1
 */