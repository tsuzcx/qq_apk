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
    AppMethodBeat.i(18636);
    if (this.bgLoop == null) {
      this.bgLoop = new KindaUIEventLoop();
    }
    KEventLoop localKEventLoop = this.bgLoop;
    AppMethodBeat.o(18636);
    return localKEventLoop;
  }
  
  public KEventLoop getMakeSureUIEventLoop()
  {
    AppMethodBeat.i(18637);
    if (this.makeSureUILoop == null) {
      this.makeSureUILoop = new KindaUIEventLoop();
    }
    KEventLoop localKEventLoop = this.makeSureUILoop;
    AppMethodBeat.o(18637);
    return localKEventLoop;
  }
  
  public KEventLoop getUIEventLoop()
  {
    AppMethodBeat.i(18635);
    if (this.uiLoop == null) {
      this.uiLoop = new KindaUIEventLoop();
    }
    KEventLoop localKEventLoop = this.uiLoop;
    AppMethodBeat.o(18635);
    return localKEventLoop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaEventLoopManagerImpl
 * JD-Core Version:    0.7.0.1
 */