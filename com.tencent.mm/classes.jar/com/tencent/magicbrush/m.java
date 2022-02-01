package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gfx={1, 1, 13})
final class m
  extends t
{
  public static final h cxK;
  
  static
  {
    AppMethodBeat.i(140120);
    cxK = new m();
    AppMethodBeat.o(140120);
  }
  
  public final String Hu()
  {
    return "getDevice_pixel_ratio_()F";
  }
  
  public final d Hv()
  {
    AppMethodBeat.i(140121);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(140121);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140122);
    float f = ((MBRuntime.MBParams)paramObject).device_pixel_ratio_;
    AppMethodBeat.o(140122);
    return Float.valueOf(f);
  }
  
  public final String getName()
  {
    return "device_pixel_ratio_";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140123);
    ((MBRuntime.MBParams)paramObject1).device_pixel_ratio_ = ((Number)paramObject2).floatValue();
    AppMethodBeat.o(140123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.m
 * JD-Core Version:    0.7.0.1
 */