package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.EventLoopManager;
import com.tencent.kinda.gen.KEventLoop;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaEventLoopManagerImpl
  implements EventLoopManager
{
  private KEventLoop bgLoop;
  private KEventLoop makeSureUILoop;
  private KEventLoop uiLoop;
  
  public KEventLoop getBackGroundEventLoop()
  {
    AppMethodBeat.i(144522);
    if (this.bgLoop == null) {
      this.bgLoop = new KindaUIEventLoop();
    }
    KEventLoop localKEventLoop = this.bgLoop;
    AppMethodBeat.o(144522);
    return localKEventLoop;
  }
  
  public KEventLoop getMakeSureUIEventLoop()
  {
    AppMethodBeat.i(144523);
    if (this.makeSureUILoop == null) {
      this.makeSureUILoop = new KindaUIEventLoop();
    }
    KEventLoop localKEventLoop = this.makeSureUILoop;
    AppMethodBeat.o(144523);
    return localKEventLoop;
  }
  
  public KEventLoop getUIEventLoop()
  {
    AppMethodBeat.i(144521);
    if (this.uiLoop == null) {
      this.uiLoop = new KindaUIEventLoop();
    }
    KEventLoop localKEventLoop = this.uiLoop;
    AppMethodBeat.o(144521);
    return localKEventLoop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaEventLoopManagerImpl
 * JD-Core Version:    0.7.0.1
 */