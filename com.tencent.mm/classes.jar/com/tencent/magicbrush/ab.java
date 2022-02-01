package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.n;
import d.g.b.w;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(fNY={1, 1, 13})
final class ab
  extends n
{
  public static final h cnf;
  
  static
  {
    AppMethodBeat.i(175883);
    cnf = new ab();
    AppMethodBeat.o(175883);
  }
  
  public final String FZ()
  {
    return "getSdcard_path()Ljava/lang/String;";
  }
  
  public final d Ga()
  {
    AppMethodBeat.i(175884);
    b localb = w.bn(MBRuntime.MBParams.class);
    AppMethodBeat.o(175884);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    return ((MBRuntime.MBParams)paramObject).sdcard_path;
  }
  
  public final String getName()
  {
    return "sdcard_path";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    ((MBRuntime.MBParams)paramObject1).sdcard_path = ((String)paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.ab
 * JD-Core Version:    0.7.0.1
 */