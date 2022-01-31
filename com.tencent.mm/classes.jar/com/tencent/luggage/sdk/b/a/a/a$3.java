package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.liblockstep.LockStepNative;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepListener;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.i.s;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3
  implements Runnable
{
  a$3(a parama, i parami, LockStepNative.ILockStepListener paramILockStepListener, LockStepNative.ILockStepReportListener paramILockStepReportListener) {}
  
  public final void run()
  {
    AppMethodBeat.i(140699);
    ab.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding setCallback ");
    s locals = (s)this.bEc.v(s.class);
    if (locals == null)
    {
      ab.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding v8Addon is null");
      AppMethodBeat.o(140699);
      return;
    }
    this.bDZ.bDW = new LockStepNative(locals.getIsolatePtr(), locals.aGD());
    ab.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding setCallback ret:%d", new Object[] { Integer.valueOf(this.bDZ.bDW.setCallback(this.bEd, this.bEe)) });
    AppMethodBeat.o(140699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.a.3
 * JD-Core Version:    0.7.0.1
 */