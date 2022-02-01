package com.tencent.mm.media.i.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"valid", "", "size", "invoke"})
final class a$b
  extends d.g.b.l
  implements b<Float, Float>
{
  public static final b KBF;
  
  static
  {
    AppMethodBeat.i(205874);
    KBF = new b();
    AppMethodBeat.o(205874);
  }
  
  a$b()
  {
    super(1);
  }
  
  public static float ae(float paramFloat)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.i.b.a.b
 * JD-Core Version:    0.7.0.1
 */