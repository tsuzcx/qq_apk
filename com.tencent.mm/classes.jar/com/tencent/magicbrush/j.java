package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gjZ={1, 1, 13})
final class j
  extends t
{
  public static final h cyr;
  
  static
  {
    AppMethodBeat.i(140108);
    cyr = new j();
    AppMethodBeat.o(140108);
  }
  
  public final String HC()
  {
    return "getScreen_height_()I";
  }
  
  public final d HD()
  {
    AppMethodBeat.i(140109);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(140109);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140110);
    int i = ((MBRuntime.MBParams)paramObject).screen_height_;
    AppMethodBeat.o(140110);
    return Integer.valueOf(i);
  }
  
  public final String getName()
  {
    return "screen_height_";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140111);
    ((MBRuntime.MBParams)paramObject1).screen_height_ = ((Number)paramObject2).intValue();
    AppMethodBeat.o(140111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.j
 * JD-Core Version:    0.7.0.1
 */