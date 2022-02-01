package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gjZ={1, 1, 13})
final class ag
  extends t
{
  public static final h cyr;
  
  static
  {
    AppMethodBeat.i(213346);
    cyr = new ag();
    AppMethodBeat.o(213346);
  }
  
  public final String HC()
  {
    return "getSupport_hardware_encode()Z";
  }
  
  public final d HD()
  {
    AppMethodBeat.i(213347);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(213347);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(213348);
    boolean bool = ((MBRuntime.MBParams)paramObject).support_hardware_encode;
    AppMethodBeat.o(213348);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "support_hardware_encode";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(213349);
    ((MBRuntime.MBParams)paramObject1).support_hardware_encode = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(213349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.ag
 * JD-Core Version:    0.7.0.1
 */