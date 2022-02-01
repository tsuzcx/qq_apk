package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gjZ={1, 1, 13})
final class aa
  extends t
{
  public static final h cyr;
  
  static
  {
    AppMethodBeat.i(213326);
    cyr = new aa();
    AppMethodBeat.o(213326);
  }
  
  public final String HC()
  {
    return "is_logic_only()Z";
  }
  
  public final d HD()
  {
    AppMethodBeat.i(213327);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(213327);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(213328);
    boolean bool = ((MBRuntime.MBParams)paramObject).is_logic_only;
    AppMethodBeat.o(213328);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "is_logic_only";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(213329);
    ((MBRuntime.MBParams)paramObject1).is_logic_only = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(213329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.aa
 * JD-Core Version:    0.7.0.1
 */