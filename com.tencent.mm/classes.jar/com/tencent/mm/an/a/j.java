package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j
{
  public final int oyn;
  
  static
  {
    AppMethodBeat.i(239495);
    oyj = new j("BIZ_CHAT_TYPE_UNKNOWN", 0, -1);
    oyk = new j("BIZ_CHAT_TYPE_GROUP", 1, 1);
    oyl = new j("BIZ_CHAT_TYPE_SINGLE", 2, 2);
    oym = new j("BIZ_CHAT_TYPE_APP", 3, 3);
    oyo = new j[] { oyj, oyk, oyl, oym };
    AppMethodBeat.o(239495);
  }
  
  private j(int paramInt)
  {
    this.oyn = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.a.j
 * JD-Core Version:    0.7.0.1
 */