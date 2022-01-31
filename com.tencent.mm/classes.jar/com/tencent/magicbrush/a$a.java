package com.tencent.magicbrush;

import com.tencent.magicbrush.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  public float bJg;
  public float bJh;
  
  public a$a(a parama) {}
  
  public final String toString()
  {
    AppMethodBeat.i(151469);
    String str = e.format("fps(%.2f, %.2f)", new Object[] { Float.valueOf(this.bJg), Float.valueOf(this.bJh) });
    AppMethodBeat.o(151469);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.a.a
 * JD-Core Version:    0.7.0.1
 */