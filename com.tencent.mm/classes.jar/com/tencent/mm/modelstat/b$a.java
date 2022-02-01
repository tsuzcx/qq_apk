package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b$a
{
  public int value = 0;
  
  static
  {
    AppMethodBeat.i(150979);
    oVf = new a("OP_Chatting", 0, 1);
    oVg = new a("OP_Msg", 1, 2);
    oVh = new a[] { oVf, oVg };
    AppMethodBeat.o(150979);
  }
  
  private b$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.b.a
 * JD-Core Version:    0.7.0.1
 */