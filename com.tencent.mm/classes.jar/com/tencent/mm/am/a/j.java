package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j
{
  public final int hSl;
  
  static
  {
    AppMethodBeat.i(207205);
    hSh = new j("BIZ_CHAT_TYPE_UNKNOWN", 0, -1);
    hSi = new j("BIZ_CHAT_TYPE_GROUP", 1, 1);
    hSj = new j("BIZ_CHAT_TYPE_SINGLE", 2, 2);
    hSk = new j("BIZ_CHAT_TYPE_APP", 3, 3);
    hSm = new j[] { hSh, hSi, hSj, hSk };
    AppMethodBeat.o(207205);
  }
  
  private j(int paramInt)
  {
    this.hSl = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.j
 * JD-Core Version:    0.7.0.1
 */