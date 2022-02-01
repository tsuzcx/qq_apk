package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gfx={1, 1, 13})
final class t
  extends d.g.b.t
{
  public static final h cxK;
  
  static
  {
    AppMethodBeat.i(140148);
    cxK = new t();
    AppMethodBeat.o(140148);
  }
  
  public final String Hu()
  {
    return "getEnable_request_animation_frame()Z";
  }
  
  public final d Hv()
  {
    AppMethodBeat.i(140149);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(140149);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140150);
    boolean bool = ((MBRuntime.MBParams)paramObject).enable_request_animation_frame;
    AppMethodBeat.o(140150);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "enable_request_animation_frame";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140151);
    ((MBRuntime.MBParams)paramObject1).enable_request_animation_frame = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(140151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.t
 * JD-Core Version:    0.7.0.1
 */