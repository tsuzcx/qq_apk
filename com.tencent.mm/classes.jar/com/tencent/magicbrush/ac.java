package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.n;
import d.g.b.w;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(fNY={1, 1, 13})
final class ac
  extends n
{
  public static final h cnf;
  
  static
  {
    AppMethodBeat.i(190919);
    cnf = new ac();
    AppMethodBeat.o(190919);
  }
  
  public final String FZ()
  {
    return "getSupport_client_vertex_buffer()Z";
  }
  
  public final d Ga()
  {
    AppMethodBeat.i(190920);
    b localb = w.bn(MBRuntime.MBParams.class);
    AppMethodBeat.o(190920);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(190921);
    boolean bool = ((MBRuntime.MBParams)paramObject).support_client_vertex_buffer;
    AppMethodBeat.o(190921);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "support_client_vertex_buffer";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(190922);
    ((MBRuntime.MBParams)paramObject1).support_client_vertex_buffer = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(190922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.ac
 * JD-Core Version:    0.7.0.1
 */