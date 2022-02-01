package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;
import d.l.h;

@l(gjZ={1, 1, 13})
final class o
  extends t
{
  public static final h cyr;
  
  static
  {
    AppMethodBeat.i(140128);
    cyr = new o();
    AppMethodBeat.o(140128);
  }
  
  public final String HC()
  {
    return "getAllow_antialias_()Z";
  }
  
  public final d HD()
  {
    AppMethodBeat.i(140129);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(140129);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(140130);
    boolean bool = ((MBRuntime.MBParams)paramObject).allow_antialias_;
    AppMethodBeat.o(140130);
    return Boolean.valueOf(bool);
  }
  
  public final String getName()
  {
    return "allow_antialias_";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(140131);
    ((MBRuntime.MBParams)paramObject1).allow_antialias_ = ((Boolean)paramObject2).booleanValue();
    AppMethodBeat.o(140131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.o
 * JD-Core Version:    0.7.0.1
 */