package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.w;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(fNY={1, 1, 13})
final class n
  extends d.g.b.n
{
  public static final h cnf;
  
  static
  {
    AppMethodBeat.i(140124);
    cnf = new n();
    AppMethodBeat.o(140124);
  }
  
  public final String FZ()
  {
    return "getEnable_2d()Z";
  }
  
  public final d Ga()
  {
    AppMethodBeat.i(140125);
    b localb = w.bn(MBRuntime.MBParams.class);
    AppMethodBeat.o(140125);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140126);
    boolean bool = ((MBRuntime.MBParams)paramObject).enable_2d;
    AppMethodBeat.o(140126);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "enable_2d";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140127);
    ((MBRuntime.MBParams)paramObject1).enable_2d = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(140127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.n
 * JD-Core Version:    0.7.0.1
 */