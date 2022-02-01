package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.n;
import d.g.b.w;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(fNY={1, 1, 13})
final class ae
  extends n
{
  public static final h cnf;
  
  static
  {
    AppMethodBeat.i(190927);
    cnf = new ae();
    AppMethodBeat.o(190927);
  }
  
  public final String FZ()
  {
    return "getSync_surface_destroy()Z";
  }
  
  public final d Ga()
  {
    AppMethodBeat.i(190928);
    b localb = w.bn(MBRuntime.MBParams.class);
    AppMethodBeat.o(190928);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(190929);
    boolean bool = ((MBRuntime.MBParams)paramObject).sync_surface_destroy;
    AppMethodBeat.o(190929);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "sync_surface_destroy";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(190930);
    ((MBRuntime.MBParams)paramObject1).sync_surface_destroy = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(190930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.ae
 * JD-Core Version:    0.7.0.1
 */