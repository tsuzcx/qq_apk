package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gfx={1, 1, 13})
final class ae
  extends t
{
  public static final h cxK;
  
  static
  {
    AppMethodBeat.i(215100);
    cxK = new ae();
    AppMethodBeat.o(215100);
  }
  
  public final String Hu()
  {
    return "getSupport_hardware_decode()Z";
  }
  
  public final d Hv()
  {
    AppMethodBeat.i(215101);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(215101);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(215102);
    boolean bool = ((MBRuntime.MBParams)paramObject).support_hardware_decode;
    AppMethodBeat.o(215102);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "support_hardware_decode";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(215103);
    ((MBRuntime.MBParams)paramObject1).support_hardware_decode = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(215103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.ae
 * JD-Core Version:    0.7.0.1
 */