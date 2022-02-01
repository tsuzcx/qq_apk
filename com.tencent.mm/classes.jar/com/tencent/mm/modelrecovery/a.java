package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.c;
import com.tencent.mm.bz.g;
import com.tencent.mm.bz.g.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public static void cJ(Context paramContext)
  {
    AppMethodBeat.i(195955);
    ac.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, dump recovery status:");
    Object localObject = c.hE(paramContext);
    ac.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + ((c)localObject).Giy);
    ac.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + ((c)localObject).Gix);
    ac.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + ((c)localObject).Giz);
    localObject = g.a.hH(paramContext);
    ac.w("MicroMsg.Recovery.RecoveryHelper", "setting enable       = " + ((g.a)localObject).mEnabled);
    localObject = g.hG(paramContext);
    ac.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 1  = " + ((g)localObject).GiG);
    ac.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 2  = " + ((g)localObject).GiH);
    ac.w("MicroMsg.Recovery.RecoveryHelper", "setting interval     = " + ((g)localObject).GiI);
    ac.w("MicroMsg.Recovery.RecoveryHelper", "setting min interval = " + ((g)localObject).GiJ);
    ac.w("MicroMsg.Recovery.RecoveryHelper", "setting auto reset   = " + ((g)localObject).GiK);
    ac.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, main process will crash immediately");
    c localc = c.hE(paramContext);
    localc.Giy = ((g)localObject).GiG;
    localc.Gix = System.currentTimeMillis();
    localc.save();
    ac.w("MicroMsg.Recovery.RecoveryHelper", "setting new recovery status:");
    paramContext = c.hE(paramContext);
    ac.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + paramContext.Giy);
    ac.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + paramContext.Gix);
    ac.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + paramContext.Giz);
    paramContext = new RuntimeException("setLaunchRecovery");
    AppMethodBeat.o(195955);
    throw paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.a
 * JD-Core Version:    0.7.0.1
 */