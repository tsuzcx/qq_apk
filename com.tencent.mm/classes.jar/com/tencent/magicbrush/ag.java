package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gfx={1, 1, 13})
final class ag
  extends t
{
  public static final h cxK;
  
  static
  {
    AppMethodBeat.i(215108);
    cxK = new ag();
    AppMethodBeat.o(215108);
  }
  
  public final String Hu()
  {
    return "getSync_surface_destroy()Z";
  }
  
  public final d Hv()
  {
    AppMethodBeat.i(215109);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(215109);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(215110);
    boolean bool = ((MBRuntime.MBParams)paramObject).sync_surface_destroy;
    AppMethodBeat.o(215110);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "sync_surface_destroy";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(215111);
    ((MBRuntime.MBParams)paramObject1).sync_surface_destroy = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(215111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.ag
 * JD-Core Version:    0.7.0.1
 */