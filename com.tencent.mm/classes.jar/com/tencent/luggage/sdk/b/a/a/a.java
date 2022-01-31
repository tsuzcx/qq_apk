package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.liblockstep.LockStepNative;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.i.m;
import com.tencent.mm.plugin.appbrand.i.n;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  protected LockStepNative bDW;
  private final a.a bDX;
  
  public a()
  {
    AppMethodBeat.i(140702);
    this.bDX = new a.a(this, new a.4(this));
    AppMethodBeat.o(140702);
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(140703);
    ab.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding");
    if (this.bDW != null)
    {
      ab.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding udpNative != null");
      AppMethodBeat.o(140703);
      return;
    }
    if (parami == null)
    {
      ab.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsruntime is null");
      AppMethodBeat.o(140703);
      return;
    }
    com.tencent.mm.game.a.a.loadLibraries();
    n localn = (n)parami.v(n.class);
    if (localn == null)
    {
      ab.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsThreadHandler is null");
      AppMethodBeat.o(140703);
      return;
    }
    localn.post(new a.3(this, parami, new a.1(this, localn), new a.2(this)));
    AppMethodBeat.o(140703);
  }
  
  public final void c(i parami)
  {
    AppMethodBeat.i(140704);
    ab.i("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding");
    if (this.bDW == null)
    {
      ab.i("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding is null");
      AppMethodBeat.o(140704);
      return;
    }
    if (parami == null)
    {
      ab.e("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding jsruntime is null");
      AppMethodBeat.o(140704);
      return;
    }
    ((m)parami.v(m.class)).a(this.bDX);
    AppMethodBeat.o(140704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */