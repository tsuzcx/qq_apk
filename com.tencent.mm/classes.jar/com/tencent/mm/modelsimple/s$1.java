package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class s$1
  implements Runnable
{
  s$1(s params, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(123437);
    new k().doScene(this.fPC.dispatcher(), new s.1.1(this));
    AppMethodBeat.o(123437);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123438);
    String str = super.toString() + "|onGYNetEnd1";
    AppMethodBeat.o(123438);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.s.1
 * JD-Core Version:    0.7.0.1
 */