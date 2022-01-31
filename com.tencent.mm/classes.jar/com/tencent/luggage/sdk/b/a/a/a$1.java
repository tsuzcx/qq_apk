package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepListener;
import com.tencent.mm.plugin.appbrand.i.n;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements LockStepNative.ILockStepListener
{
  a$1(a parama, n paramn) {}
  
  public final void onCallBack(String paramString)
  {
    AppMethodBeat.i(140696);
    ab.d("Luggage.LockStepNativeInstallHelper", "mmudp onCallBack apiName:%s", new Object[] { paramString });
    this.bDY.post(new a.1.1(this, paramString));
    AppMethodBeat.o(140696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */