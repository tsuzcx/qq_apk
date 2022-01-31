package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b$a
{
  public int value = 0;
  
  static
  {
    AppMethodBeat.i(78629);
    fRz = new a("OP_Chatting", 0, 1);
    fRA = new a("OP_Msg", 1, 2);
    fRB = new a[] { fRz, fRA };
    AppMethodBeat.o(78629);
  }
  
  private b$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.b.a
 * JD-Core Version:    0.7.0.1
 */