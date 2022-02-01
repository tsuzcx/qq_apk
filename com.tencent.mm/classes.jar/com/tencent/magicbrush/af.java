package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gjZ={1, 1, 13})
final class af
  extends t
{
  public static final h cyr;
  
  static
  {
    AppMethodBeat.i(213342);
    cyr = new af();
    AppMethodBeat.o(213342);
  }
  
  public final String HC()
  {
    return "getSupport_hardware_decode()Z";
  }
  
  public final d HD()
  {
    AppMethodBeat.i(213343);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(213343);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(213344);
    boolean bool = ((MBRuntime.MBParams)paramObject).support_hardware_decode;
    AppMethodBeat.o(213344);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "support_hardware_decode";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(213345);
    ((MBRuntime.MBParams)paramObject1).support_hardware_decode = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(213345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.af
 * JD-Core Version:    0.7.0.1
 */