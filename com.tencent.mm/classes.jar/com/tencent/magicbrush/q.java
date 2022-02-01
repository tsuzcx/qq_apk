package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.n;
import d.g.b.w;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(fNY={1, 1, 13})
final class q
  extends n
{
  public static final h cnf;
  
  static
  {
    AppMethodBeat.i(140136);
    cnf = new q();
    AppMethodBeat.o(140136);
  }
  
  public final String FZ()
  {
    return "getEnable_font_batch()Z";
  }
  
  public final d Ga()
  {
    AppMethodBeat.i(140137);
    b localb = w.bn(MBRuntime.MBParams.class);
    AppMethodBeat.o(140137);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140138);
    boolean bool = ((MBRuntime.MBParams)paramObject).enable_font_batch;
    AppMethodBeat.o(140138);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "enable_font_batch";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140139);
    ((MBRuntime.MBParams)paramObject1).enable_font_batch = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(140139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.q
 * JD-Core Version:    0.7.0.1
 */