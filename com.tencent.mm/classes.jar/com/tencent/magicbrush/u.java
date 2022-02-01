package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gjZ={1, 1, 13})
final class u
  extends t
{
  public static final h cyr;
  
  static
  {
    AppMethodBeat.i(182574);
    cyr = new u();
    AppMethodBeat.o(182574);
  }
  
  public final String HC()
  {
    return "getEnable_switch_thread_native_for_jsapis()Z";
  }
  
  public final d HD()
  {
    AppMethodBeat.i(182575);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(182575);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(182576);
    boolean bool = ((MBRuntime.MBParams)paramObject).enable_switch_thread_native_for_jsapis;
    AppMethodBeat.o(182576);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "enable_switch_thread_native_for_jsapis";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(182577);
    ((MBRuntime.MBParams)paramObject1).enable_switch_thread_native_for_jsapis = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(182577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.u
 * JD-Core Version:    0.7.0.1
 */