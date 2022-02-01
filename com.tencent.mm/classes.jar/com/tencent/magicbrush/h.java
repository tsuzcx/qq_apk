package com.tencent.magicbrush;

import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.n;
import d.g.b.w;
import d.l;
import d.l.b;
import d.l.d;

@l(fNY={1, 1, 13})
final class h
  extends n
{
  public static final d.l.h cnf;
  
  static
  {
    AppMethodBeat.i(140104);
    cnf = new h();
    AppMethodBeat.o(140104);
  }
  
  public final String FZ()
  {
    return "getAnimationFrameHandlerStrategy()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;";
  }
  
  public final d Ga()
  {
    AppMethodBeat.i(140105);
    b localb = w.bn(MBRuntime.MBParams.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.h
 * JD-Core Version:    0.7.0.1
 */