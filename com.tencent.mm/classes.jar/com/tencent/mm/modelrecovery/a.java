package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.RecoveryCrash;
import com.tencent.mm.recoveryv2.c;
import com.tencent.mm.recoveryv2.h;
import com.tencent.mm.recoveryv2.h.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public static void cG(Context paramContext)
  {
    AppMethodBeat.i(193137);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, dump recovery status:");
    Object localObject = RecoveryCrash.hJ(paramContext);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + ((RecoveryCrash)localObject).HTU.HTW);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + ((RecoveryCrash)localObject).HTR);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + ((RecoveryCrash)localObject).HTS);
    localObject = h.a.hO(paramContext);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setting enable       = " + ((h.a)localObject).mEnabled);
    localObject = h.hN(paramContext);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 1  = " + ((h)localObject).HUe);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 2  = " + ((h)localObject).HUf);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setting interval     = " + ((h)localObject).HUg);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setting min interval = " + ((h)localObject).HUi);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setting auto reset   = " + ((h)localObject).HUj);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, main process will crash immediately");
    localObject = RecoveryCrash.hJ(paramContext).ZW(((h)localObject).HUe);
    ((RecoveryCrash)localObject).HTR = System.currentTimeMillis();
    ((RecoveryCrash)localObject).save();
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setting new recovery status:");
    paramContext = RecoveryCrash.hJ(paramContext);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + paramContext.HTU.HTW);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + paramContext.HTR);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + paramContext.HTS);
    paramContext = new RuntimeException("setLaunchRecovery");
    AppMethodBeat.o(193137);
    throw paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.a
 * JD-Core Version:    0.7.0.1
 */