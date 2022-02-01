package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gjZ={1, 1, 13})
final class ae
  extends t
{
  public static final h cyr;
  
  static
  {
    AppMethodBeat.i(213338);
    cyr = new ae();
    AppMethodBeat.o(213338);
  }
  
  public final String HC()
  {
    return "getSupport_gfximage_share_texture()Z";
  }
  
  public final d HD()
  {
    AppMethodBeat.i(213339);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(213339);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(213340);
    boolean bool = ((MBRuntime.MBParams)paramObject).support_gfximage_share_texture;
    AppMethodBeat.o(213340);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "support_gfximage_share_texture";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(213341);
    ((MBRuntime.MBParams)paramObject1).support_gfximage_share_texture = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(213341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.ae
 * JD-Core Version:    0.7.0.1
 */