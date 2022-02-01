package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gfx={1, 1, 13})
final class aa
  extends t
{
  public static final h cxK;
  
  static
  {
    AppMethodBeat.i(215088);
    cxK = new aa();
    AppMethodBeat.o(215088);
  }
  
  public final String Hu()
  {
    return "getRevert_cpu_optimizer_test()Z";
  }
  
  public final d Hv()
  {
    AppMethodBeat.i(215089);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(215089);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(215090);
    boolean bool = ((MBRuntime.MBParams)paramObject).revert_cpu_optimizer_test;
    AppMethodBeat.o(215090);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "revert_cpu_optimizer_test";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(215091);
    ((MBRuntime.MBParams)paramObject1).revert_cpu_optimizer_test = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(215091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.aa
 * JD-Core Version:    0.7.0.1
 */