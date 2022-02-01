package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.n;
import d.g.b.w;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(fNY={1, 1, 13})
final class p
  extends n
{
  public static final h cnf;
  
  static
  {
    AppMethodBeat.i(140132);
    cnf = new p();
    AppMethodBeat.o(140132);
  }
  
  public final String FZ()
  {
    return "getUse_command_buffer()Z";
  }
  
  public final d Ga()
  {
    AppMethodBeat.i(140133);
    b localb = w.bn(MBRuntime.MBParams.class);
    AppMethodBeat.o(140133);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140134);
    boolean bool = ((MBRuntime.MBParams)paramObject).use_command_buffer;
    AppMethodBeat.o(140134);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "use_command_buffer";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140135);
    ((MBRuntime.MBParams)paramObject1).use_command_buffer = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(140135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.p
 * JD-Core Version:    0.7.0.1
 */