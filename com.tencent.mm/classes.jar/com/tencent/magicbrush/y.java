package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gjZ={1, 1, 13})
final class y
  extends t
{
  public static final h cyr;
  
  static
  {
    AppMethodBeat.i(140162);
    cyr = new y();
    AppMethodBeat.o(140162);
  }
  
  public final String HC()
  {
    return "getGc_factor()F";
  }
  
  public final d HD()
  {
    AppMethodBeat.i(140163);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(140163);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140164);
    float f = ((MBRuntime.MBParams)paramObject).gc_factor;
    AppMethodBeat.o(140164);
    return Float.valueOf(f);
  }
  
  public final String getName()
  {
    return "gc_factor";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140165);
    ((MBRuntime.MBParams)paramObject1).gc_factor = ((Number)paramObject2).floatValue();
    AppMethodBeat.o(140165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.y
 * JD-Core Version:    0.7.0.1
 */