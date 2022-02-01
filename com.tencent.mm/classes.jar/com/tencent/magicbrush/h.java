package com.tencent.magicbrush;

import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.t;
import d.g.b.z;
import d.l;
import d.l.b;
import d.l.d;

@l(gfx={1, 1, 13})
final class h
  extends t
{
  public static final d.l.h cxK;
  
  static
  {
    AppMethodBeat.i(140104);
    cxK = new h();
    AppMethodBeat.o(140104);
  }
  
  public final String Hu()
  {
    return "getAnimationFrameHandlerStrategy()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;";
  }
  
  public final d Hv()
  {
    AppMethodBeat.i(140105);
    b localb = z.bp(MBRuntime.MBParams.class);
    AppMethodBeat.o(140105);
    return localb;
  }
  
  public final Object get(Object paramObject)
  {
    return ((MBRuntime.MBParams)paramObject).animationFrameHandlerStrategy;
  }
  
  public final String getName()
  {
    return "animationFrameHandlerStrategy";
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    ((MBRuntime.MBParams)paramObject1).animationFrameHandlerStrategy = ((a.b)paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.h
 * JD-Core Version:    0.7.0.1
 */