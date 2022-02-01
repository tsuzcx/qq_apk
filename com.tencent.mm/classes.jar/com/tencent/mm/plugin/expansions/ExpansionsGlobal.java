package com.tencent.mm.plugin.expansions;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ExpansionsGlobal
{
  private static final byte[] qpg;
  private static volatile boolean qph;
  private static volatile boolean qpi;
  private static AtomicBoolean qpj;
  
  static
  {
    AppMethodBeat.i(152972);
    qpg = new byte[0];
    qph = a.cmR();
    qpi = false;
    qpj = new AtomicBoolean(false);
    AppMethodBeat.o(152972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.ExpansionsGlobal
 * JD-Core Version:    0.7.0.1
 */