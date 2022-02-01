package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.n;
import d.g.b.w;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(fNY={1, 1, 13})
final class s
  extends n
{
  public static final h cnf;
  
  static
  {
    AppMethodBeat.i(140144);
    cnf = new s();
    AppMethodBeat.o(140144);
  }
  
  public final String FZ()
  {
    return "getAllow_opengl3()Z";
  }
  
  public final d Ga()
  {
    AppMethodBeat.i(140145);
    b localb = w.bn(MBRuntime.MBParams.class);
    AppMethodBeat.o(140145);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140146);
    boolean bool = ((MBRuntime.MBParams)paramObject).allow_opengl3;
    AppMethodBeat.o(140146);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "allow_opengl3";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140147);
    ((MBRuntime.MBParams)paramObject1).allow_opengl3 = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(140147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.s
 * JD-Core Version:    0.7.0.1
 */