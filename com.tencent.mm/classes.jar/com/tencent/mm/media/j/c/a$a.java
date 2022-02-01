package com.tencent.mm.media.j.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"valid", "", "size", "invoke"})
public final class a$a
  extends q
  implements b<Float, Float>
{
  public static final a lah;
  
  static
  {
    AppMethodBeat.i(257988);
    lah = new a();
    AppMethodBeat.o(257988);
  }
  
  a$a()
  {
    super(1);
  }
  
  public static float au(float paramFloat)
  {
    float f;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    do
    {
      return f;
      f = paramFloat;
    } while (paramFloat >= 0.0F);
    return 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.j.c.a.a
 * JD-Core Version:    0.7.0.1
 */