package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gfx={1, 1, 13})
final class v
  extends t
{
  public static final h cxK;
  
  static
  {
    AppMethodBeat.i(140152);
    cxK = new v();
    AppMethodBeat.o(140152);
  }
  
  public final String Hu()
  {
    return "getEnable_window_attributes_alpha()Z";
  }
  
  public final d Hv()
  {
    AppMethodBeat.i(140153);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(140153);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140154);
    boolean bool = ((MBRuntime.MBParams)paramObject).enable_window_attributes_alpha;
    AppMethodBeat.o(140154);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "enable_window_attributes_alpha";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140155);
    ((MBRuntime.MBParams)paramObject1).enable_window_attributes_alpha = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(140155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.v
 * JD-Core Version:    0.7.0.1
 */