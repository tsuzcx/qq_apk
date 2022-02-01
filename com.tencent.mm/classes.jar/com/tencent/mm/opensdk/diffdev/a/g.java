package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g
{
  private int code;
  
  static
  {
    AppMethodBeat.i(3735);
    w = new g("UUID_EXPIRED", 0, 402);
    x = new g("UUID_CANCELED", 1, 403);
    y = new g("UUID_SCANED", 2, 404);
    z = new g("UUID_CONFIRM", 3, 405);
    A = new g("UUID_KEEP_CONNECT", 4, 408);
    B = new g("UUID_ERROR", 5, 500);
    C = new g[] { w, x, y, z, A, B };
    AppMethodBeat.o(3735);
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
    AppMethodBeat.i(3734);
    String str = "UUIDStatusCode:" + this.code;
    AppMethodBeat.o(3734);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.g
 * JD-Core Version:    0.7.0.1
 */