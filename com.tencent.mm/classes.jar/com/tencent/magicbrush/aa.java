package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.n;
import d.g.b.w;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(fNY={1, 1, 13})
final class aa
  extends n
{
  public static final h cnf;
  
  static
  {
    AppMethodBeat.i(190915);
    cnf = new aa();
    AppMethodBeat.o(190915);
  }
  
  public final String FZ()
  {
    return "getRevert_cpu_optimizer_test()Z";
  }
  
  public final d Ga()
  {
    AppMethodBeat.i(190916);
    b localb = w.bn(MBRuntime.MBParams.class);
    AppMethodBeat.o(190916);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(190917);
    boolean bool = ((MBRuntime.MBParams)paramObject).revert_cpu_optimizer_test;
    AppMethodBeat.o(190917);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "revert_cpu_optimizer_test";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(190918);
    ((MBRuntime.MBParams)paramObject1).revert_cpu_optimizer_test = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(190918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.aa
 * JD-Core Version:    0.7.0.1
 */