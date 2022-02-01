package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;

public final class b
  extends RuntimeException
{
  private final int dvm;
  
  public b()
  {
    super(a.aza());
    AppMethodBeat.i(132231);
    this.dvm = 0;
    AppMethodBeat.o(132231);
  }
  
  public b(byte paramByte)
  {
    super(a.aza());
    AppMethodBeat.i(132232);
    this.dvm = 1;
    AppMethodBeat.o(132232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.b
 * JD-Core Version:    0.7.0.1
 */