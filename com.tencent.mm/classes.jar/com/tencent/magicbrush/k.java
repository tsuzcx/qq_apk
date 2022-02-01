package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gjZ={1, 1, 13})
final class k
  extends t
{
  public static final h cyr;
  
  static
  {
    AppMethodBeat.i(140112);
    cyr = new k();
    AppMethodBeat.o(140112);
  }
  
  public final String HC()
  {
    return "getScreen_width_()I";
  }
  
  public final d HD()
  {
    AppMethodBeat.i(140113);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(140113);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140114);
    int i = ((MBRuntime.MBParams)paramObject).screen_width_;
    AppMethodBeat.o(140114);
    return Integer.valueOf(i);
  }
  
  public final String getName()
  {
    return "screen_width_";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140115);
    ((MBRuntime.MBParams)paramObject1).screen_width_ = ((Number)paramObject2).intValue();
    AppMethodBeat.o(140115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.k
 * JD-Core Version:    0.7.0.1
 */