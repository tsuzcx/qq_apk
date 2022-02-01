package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"valid", "", "size", "invoke"})
final class c$a
  extends q
  implements b<Float, Float>
{
  public static final a sYx;
  
  static
  {
    AppMethodBeat.i(205233);
    sYx = new a();
    AppMethodBeat.o(205233);
  }
  
  c$a()
  {
    super(1);
  }
  
  public static float al(float paramFloat)
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
 * Qualified Name:     com.tencent.mm.plugin.finder.video.c.a
 * JD-Core Version:    0.7.0.1
 */