package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gjZ={1, 1, 13})
final class ab
  extends t
{
  public static final h cyr;
  
  static
  {
    AppMethodBeat.i(213330);
    cyr = new ab();
    AppMethodBeat.o(213330);
  }
  
  public final String HC()
  {
    return "getRevert_cpu_optimizer_test()Z";
  }
  
  public final d HD()
  {
    AppMethodBeat.i(213331);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(213331);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(213332);
    boolean bool = ((MBRuntime.MBParams)paramObject).revert_cpu_optimizer_test;
    AppMethodBeat.o(213332);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "revert_cpu_optimizer_test";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(213333);
    ((MBRuntime.MBParams)paramObject1).revert_cpu_optimizer_test = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(213333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.ab
 * JD-Core Version:    0.7.0.1
 */