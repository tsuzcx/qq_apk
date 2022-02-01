package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gfx={1, 1, 13})
final class af
  extends t
{
  public static final h cxK;
  
  static
  {
    AppMethodBeat.i(215104);
    cxK = new af();
    AppMethodBeat.o(215104);
  }
  
  public final String Hu()
  {
    return "getSupport_hardware_encode()Z";
  }
  
  public final d Hv()
  {
    AppMethodBeat.i(215105);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(215105);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(215106);
    boolean bool = ((MBRuntime.MBParams)paramObject).support_hardware_encode;
    AppMethodBeat.o(215106);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "support_hardware_encode";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(215107);
    ((MBRuntime.MBParams)paramObject1).support_hardware_encode = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(215107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.af
 * JD-Core Version:    0.7.0.1
 */