package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j
{
  public final int hVd;
  
  static
  {
    AppMethodBeat.i(188903);
    hUZ = new j("BIZ_CHAT_TYPE_UNKNOWN", 0, -1);
    hVa = new j("BIZ_CHAT_TYPE_GROUP", 1, 1);
    hVb = new j("BIZ_CHAT_TYPE_SINGLE", 2, 2);
    hVc = new j("BIZ_CHAT_TYPE_APP", 3, 3);
    hVe = new j[] { hUZ, hVa, hVb, hVc };
    AppMethodBeat.o(188903);
  }
  
  private j(int paramInt)
  {
    this.hVd = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a.j
 * JD-Core Version:    0.7.0.1
 */