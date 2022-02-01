package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j
{
  public final int iQq;
  
  static
  {
    AppMethodBeat.i(212201);
    iQm = new j("BIZ_CHAT_TYPE_UNKNOWN", 0, -1);
    iQn = new j("BIZ_CHAT_TYPE_GROUP", 1, 1);
    iQo = new j("BIZ_CHAT_TYPE_SINGLE", 2, 2);
    iQp = new j("BIZ_CHAT_TYPE_APP", 3, 3);
    iQr = new j[] { iQm, iQn, iQo, iQp };
    AppMethodBeat.o(212201);
  }
  
  private j(int paramInt)
  {
    this.iQq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.j
 * JD-Core Version:    0.7.0.1
 */