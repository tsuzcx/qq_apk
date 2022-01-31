package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.liblockstep.LockStepNative;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1$1
  implements Runnable
{
  a$1$1(a.1 param1, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(140695);
    ab.d("Luggage.LockStepNativeInstallHelper", "mmudp jsThreadHandler run onCallBack apiName:%s", new Object[] { this.bEa });
    this.bEb.bDZ.bDW.updateNativeInterface();
    AppMethodBeat.o(140695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.a.1.1
 * JD-Core Version:    0.7.0.1
 */