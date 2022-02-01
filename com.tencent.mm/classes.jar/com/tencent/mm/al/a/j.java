package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j
{
  public final int hzQ;
  
  static
  {
    AppMethodBeat.i(209552);
    hzM = new j("BIZ_CHAT_TYPE_UNKNOWN", 0, -1);
    hzN = new j("BIZ_CHAT_TYPE_GROUP", 1, 1);
    hzO = new j("BIZ_CHAT_TYPE_SINGLE", 2, 2);
    hzP = new j("BIZ_CHAT_TYPE_APP", 3, 3);
    hzR = new j[] { hzM, hzN, hzO, hzP };
    AppMethodBeat.o(209552);
  }
  
  private j(int paramInt)
  {
    this.hzQ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.j
 * JD-Core Version:    0.7.0.1
 */