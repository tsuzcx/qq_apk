package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gfx={1, 1, 13})
final class ad
  extends t
{
  public static final h cxK;
  
  static
  {
    AppMethodBeat.i(215096);
    cxK = new ad();
    AppMethodBeat.o(215096);
  }
  
  public final String Hu()
  {
    return "getSupport_gfximage_share_texture()Z";
  }
  
  public final d Hv()
  {
    AppMethodBeat.i(215097);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(215097);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(215098);
    boolean bool = ((MBRuntime.MBParams)paramObject).support_gfximage_share_texture;
    AppMethodBeat.o(215098);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "support_gfximage_share_texture";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(215099);
    ((MBRuntime.MBParams)paramObject1).support_gfximage_share_texture = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(215099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.ad
 * JD-Core Version:    0.7.0.1
 */