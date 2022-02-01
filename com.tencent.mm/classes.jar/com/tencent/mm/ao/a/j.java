package com.tencent.mm.ao.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j
{
  public final int lGG;
  
  static
  {
    AppMethodBeat.i(206429);
    lGC = new j("BIZ_CHAT_TYPE_UNKNOWN", 0, -1);
    lGD = new j("BIZ_CHAT_TYPE_GROUP", 1, 1);
    lGE = new j("BIZ_CHAT_TYPE_SINGLE", 2, 2);
    lGF = new j("BIZ_CHAT_TYPE_APP", 3, 3);
    lGH = new j[] { lGC, lGD, lGE, lGF };
    AppMethodBeat.o(206429);
  }
  
  private j(int paramInt)
  {
    this.lGG = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.a.j
 * JD-Core Version:    0.7.0.1
 */