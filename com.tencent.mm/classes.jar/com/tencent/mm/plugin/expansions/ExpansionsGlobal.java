package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ExpansionsGlobal
{
  private static final byte[] vtd;
  private static volatile boolean vte;
  private static volatile boolean vtf;
  private static AtomicBoolean vtg;
  
  static
  {
    AppMethodBeat.i(152972);
    vtd = new byte[0];
    vte = a.isMainProcess();
    vtf = false;
    vtg = new AtomicBoolean(false);
    AppMethodBeat.o(152972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.ExpansionsGlobal
 * JD-Core Version:    0.7.0.1
 */