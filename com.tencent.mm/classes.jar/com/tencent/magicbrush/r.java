package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.n;
import d.g.b.w;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(fNY={1, 1, 13})
final class r
  extends n
{
  public static final h cnf;
  
  static
  {
    AppMethodBeat.i(140140);
    cnf = new r();
    AppMethodBeat.o(140140);
  }
  
  public final String FZ()
  {
    return "getEnable_gfx()Z";
  }
  
  public final d Ga()
  {
    AppMethodBeat.i(140141);
    b localb = w.bn(MBRuntime.MBParams.class);
    AppMethodBeat.o(140141);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140142);
    boolean bool = ((MBRuntime.MBParams)paramObject).enable_gfx;
    AppMethodBeat.o(140142);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "enable_gfx";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140143);
    ((MBRuntime.MBParams)paramObject1).enable_gfx = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(140143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.r
 * JD-Core Version:    0.7.0.1
 */