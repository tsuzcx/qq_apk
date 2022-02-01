package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.n;
import d.g.b.w;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(fNY={1, 1, 13})
final class ad
  extends n
{
  public static final h cnf;
  
  static
  {
    AppMethodBeat.i(190923);
    cnf = new ad();
    AppMethodBeat.o(190923);
  }
  
  public final String FZ()
  {
    return "getSupport_gfximage_share_texture()Z";
  }
  
  public final d Ga()
  {
    AppMethodBeat.i(190924);
    b localb = w.bn(MBRuntime.MBParams.class);
    AppMethodBeat.o(190924);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(190925);
    boolean bool = ((MBRuntime.MBParams)paramObject).support_gfximage_share_texture;
    AppMethodBeat.o(190925);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "support_gfximage_share_texture";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(190926);
    ((MBRuntime.MBParams)paramObject1).support_gfximage_share_texture = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(190926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.ad
 * JD-Core Version:    0.7.0.1
 */