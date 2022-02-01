package com.tencent.mm.media.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"valid", "", "size", "invoke"})
final class a$b
  extends q
  implements b<Float, Float>
{
  public static final b ijX;
  
  static
  {
    AppMethodBeat.i(218759);
    ijX = new b();
    AppMethodBeat.o(218759);
  }
  
  a$b()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.j.b.a.b
 * JD-Core Version:    0.7.0.1
 */