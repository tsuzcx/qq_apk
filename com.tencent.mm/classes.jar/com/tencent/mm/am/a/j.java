package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j
{
  public final int gZr;
  
  static
  {
    AppMethodBeat.i(191076);
    gZn = new j("BIZ_CHAT_TYPE_UNKNOWN", 0, -1);
    gZo = new j("BIZ_CHAT_TYPE_GROUP", 1, 1);
    gZp = new j("BIZ_CHAT_TYPE_SINGLE", 2, 2);
    gZq = new j("BIZ_CHAT_TYPE_APP", 3, 3);
    gZs = new j[] { gZn, gZo, gZp, gZq };
    AppMethodBeat.o(191076);
  }
  
  private j(int paramInt)
  {
    this.gZr = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.a.j
 * JD-Core Version:    0.7.0.1
 */