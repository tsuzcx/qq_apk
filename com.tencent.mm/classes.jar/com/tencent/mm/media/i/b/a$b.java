package com.tencent.mm.media.i.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"valid", "", "size", "invoke"})
final class a$b
  extends d.g.b.l
  implements b<Float, Float>
{
  public static final b gVH;
  
  static
  {
    AppMethodBeat.i(209907);
    gVH = new b();
    AppMethodBeat.o(209907);
  }
  
  a$b()
  {
    super(1);
  }
  
  public static float ai(float paramFloat)
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
 * Qualified Name:     com.tencent.mm.media.i.b.a.b
 * JD-Core Version:    0.7.0.1
 */