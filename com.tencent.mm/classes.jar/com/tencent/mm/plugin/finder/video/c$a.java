package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"valid", "", "size", "invoke"})
final class c$a
  extends q
  implements b<Float, Float>
{
  public static final a sNm;
  
  static
  {
    AppMethodBeat.i(204609);
    sNm = new a();
    AppMethodBeat.o(204609);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.c.a
 * JD-Core Version:    0.7.0.1
 */