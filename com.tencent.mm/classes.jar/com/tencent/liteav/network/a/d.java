package com.tencent.liteav.network.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public static final d a;
  public static final d b;
  public final int c;
  public final a d;
  
  static
  {
    AppMethodBeat.i(15433);
    a = new d(a.a, 0);
    b = new d(a.b, 0);
    AppMethodBeat.o(15433);
  }
  
  public d(a parama, int paramInt)
  {
    this.d = parama;
    this.c = paramInt;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(15436);
      a = new a("NO_NETWORK", 0);
      b = new a("WIFI", 1);
      c = new a("MOBILE", 2);
      d = new a[] { a, b, c };
      AppMethodBeat.o(15436);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.network.a.d
 * JD-Core Version:    0.7.0.1
 */