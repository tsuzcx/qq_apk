package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gfx={1, 1, 13})
final class ac
  extends t
{
  public static final h cxK;
  
  static
  {
    AppMethodBeat.i(215092);
    cxK = new ac();
    AppMethodBeat.o(215092);
  }
  
  public final String Hu()
  {
    return "getSupport_client_vertex_buffer()Z";
  }
  
  public final d Hv()
  {
    AppMethodBeat.i(215093);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(215093);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(215094);
    boolean bool = ((MBRuntime.MBParams)paramObject).support_client_vertex_buffer;
    AppMethodBeat.o(215094);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "support_client_vertex_buffer";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(215095);
    ((MBRuntime.MBParams)paramObject1).support_client_vertex_buffer = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(215095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.ac
 * JD-Core Version:    0.7.0.1
 */