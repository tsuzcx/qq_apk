package com.tencent.magicbrush;

import a.y;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.c.a;
import com.tencent.magicbrush.c.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MBRuntime$3
  implements Runnable
{
  MBRuntime$3(MBRuntime paramMBRuntime) {}
  
  public final void run()
  {
    AppMethodBeat.i(115788);
    if (this.bJl.mNativeInst == 0L)
    {
      AppMethodBeat.o(115788);
      return;
    }
    MBRuntime.access$200(this.bJl, this.bJl.mNativeInst);
    if (MBRuntime.access$300(this.bJl).enable_request_animation_frame)
    {
      Object localObject2 = this.bJl.mAnimationFrameHandler;
      c.c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] resume", new Object[] { ((a)localObject2).yx().name() });
      synchronized (((a)localObject2).bLl)
      {
        boolean bool = ((a)localObject2).isRunning;
        if (bool)
        {
          AppMethodBeat.o(115788);
          return;
        }
        ((a)localObject2).onResume();
        ((a)localObject2).isRunning = true;
        localObject2 = y.BMg;
        AppMethodBeat.o(115788);
        return;
      }
    }
    AppMethodBeat.o(115788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.3
 * JD-Core Version:    0.7.0.1
 */