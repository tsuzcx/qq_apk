package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d
{
  private int a;
  
  static
  {
    AppMethodBeat.i(242938);
    b = new d("UUID_EXPIRED", 0, 402);
    c = new d("UUID_CANCELED", 1, 403);
    d = new d("UUID_SCANED", 2, 404);
    e = new d("UUID_CONFIRM", 3, 405);
    f = new d("UUID_KEEP_CONNECT", 4, 408);
    d locald = new d("UUID_ERROR", 5, 500);
    g = locald;
    h = new d[] { b, c, d, e, f, locald };
    AppMethodBeat.o(242938);
  }
  
  private d(int paramInt)
  {
    AppMethodBeat.i(242933);
    this.a = paramInt;
    AppMethodBeat.o(242933);
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(242944);
    String str = "UUIDStatusCode:" + this.a;
    AppMethodBeat.o(242944);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.d
 * JD-Core Version:    0.7.0.1
 */