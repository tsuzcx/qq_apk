package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gfx={1, 1, 13})
final class w
  extends t
{
  public static final h cxK;
  
  static
  {
    AppMethodBeat.i(140156);
    cxK = new w();
    AppMethodBeat.o(140156);
  }
  
  public final String Hu()
  {
    return "getEnable_wxbindcanvastexture()Z";
  }
  
  public final d Hv()
  {
    AppMethodBeat.i(140157);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(140157);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140158);
    boolean bool = ((MBRuntime.MBParams)paramObject).enable_wxbindcanvastexture;
    AppMethodBeat.o(140158);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "enable_wxbindcanvastexture";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140159);
    ((MBRuntime.MBParams)paramObject1).enable_wxbindcanvastexture = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(140159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.w
 * JD-Core Version:    0.7.0.1
 */