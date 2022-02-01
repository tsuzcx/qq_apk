package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.n;
import d.g.b.w;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(fNY={1, 1, 13})
final class g
  extends n
{
  public static final h cnf;
  
  static
  {
    AppMethodBeat.i(140100);
    cnf = new g();
    AppMethodBeat.o(140100);
  }
  
  public final String FZ()
  {
    return "getAdjust_thread_priority()Z";
  }
  
  public final d Ga()
  {
    AppMethodBeat.i(140101);
    b localb = w.bn(MBRuntime.MBParams.class);
    AppMethodBeat.o(140101);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140102);
    boolean bool = ((MBRuntime.MBParams)paramObject).adjust_thread_priority;
    AppMethodBeat.o(140102);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "adjust_thread_priority";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140103);
    ((MBRuntime.MBParams)paramObject1).adjust_thread_priority = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(140103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.g
 * JD-Core Version:    0.7.0.1
 */