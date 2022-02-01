package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.n;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(fNY={1, 1, 13})
final class w
  extends n
{
  public static final h cnf;
  
  static
  {
    AppMethodBeat.i(140156);
    cnf = new w();
    AppMethodBeat.o(140156);
  }
  
  public final String FZ()
  {
    return "getEnable_wxbindcanvastexture()Z";
  }
  
  public final d Ga()
  {
    AppMethodBeat.i(140157);
    b localb = d.g.b.w.bn(MBRuntime.MBParams.class);
    AppMethodBeat.o(140157);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140158);
    boolean bool = ((MBRuntime.MBParams)paramObject).enable_wxbindcanvastexture;
    AppMethodBeat.o(140158);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "enable_wxbindcanvastexture";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140159);
    ((MBRuntime.MBParams)paramObject1).enable_wxbindcanvastexture = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(140159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.w
 * JD-Core Version:    0.7.0.1
 */