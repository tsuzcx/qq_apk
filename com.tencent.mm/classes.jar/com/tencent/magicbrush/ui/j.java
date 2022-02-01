package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 13}, fNZ={""}, fOa={"Lcom/tencent/magicbrush/ui/NativeAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"})
final class j
  extends a
  implements Runnable
{
  public j(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(190946);
    AppMethodBeat.o(190946);
  }
  
  public final a.b Gj()
  {
    return a.b.coY;
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(190944);
    this.coS.post((Runnable)new a(this));
    AppMethodBeat.o(190944);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(190943);
    this.coS.post((Runnable)this);
    AppMethodBeat.o(190943);
  }
  
  public final void run()
  {
    AppMethodBeat.i(190945);
    c.c.i("AnimationFrameHandler", "hy: start native raf looper", new Object[0]);
    this.clw.FL();
    AppMethodBeat.o(190945);
  }
  
  @l(fNY={1, 1, 13}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(190942);
      this.cpG.clw.FM();
      AppMethodBeat.o(190942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.ui.j
 * JD-Core Version:    0.7.0.1
 */