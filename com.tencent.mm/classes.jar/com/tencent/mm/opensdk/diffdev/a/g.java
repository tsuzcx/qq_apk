package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  private int code;
  
  static
  {
    AppMethodBeat.i(128050);
    x = new g("UUID_EXPIRED", 0, 402);
    y = new g("UUID_CANCELED", 1, 403);
    z = new g("UUID_SCANED", 2, 404);
    A = new g("UUID_CONFIRM", 3, 405);
    B = new g("UUID_KEEP_CONNECT", 4, 408);
    C = new g("UUID_ERROR", 5, 500);
    D = new g[] { x, y, z, A, B, C };
    AppMethodBeat.o(128050);
  }
  
  private g(int paramInt)
  {
    this.code = paramInt;
  }
  
  public final int getCode()
  {
    return this.code;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(128049);
    String str = "UUIDStatusCode:" + this.code;
    AppMethodBeat.o(128049);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.g
 * JD-Core Version:    0.7.0.1
 */