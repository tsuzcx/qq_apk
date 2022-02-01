package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.RecoveryCrash;
import com.tencent.mm.recoveryv2.c;
import com.tencent.mm.recoveryv2.h;
import com.tencent.mm.recoveryv2.h.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static void de(Context paramContext)
  {
    AppMethodBeat.i(231565);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, dump recovery status:");
    Object localObject = RecoveryCrash.iI(paramContext);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + ((RecoveryCrash)localObject).NBA.NBC);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + ((RecoveryCrash)localObject).NBx);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + ((RecoveryCrash)localObject).NBy);
    localObject = h.a.iN(paramContext);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting enable       = " + ((h.a)localObject).mEnabled);
    localObject = h.iM(paramContext);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 1  = " + ((h)localObject).NBK);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 2  = " + ((h)localObject).NBL);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting interval     = " + ((h)localObject).NBM);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting min interval = " + ((h)localObject).NBO);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting auto reset   = " + ((h)localObject).NBP);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, main process will crash immediately");
    localObject = RecoveryCrash.iI(paramContext).ajr(((h)localObject).NBK);
    ((RecoveryCrash)localObject).NBx = System.currentTimeMillis();
    ((RecoveryCrash)localObject).save();
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting new recovery status:");
    paramContext = RecoveryCrash.iI(paramContext);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + paramContext.NBA.NBC);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + paramContext.NBx);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + paramContext.NBy);
    paramContext = new RuntimeException("setLaunchRecovery");
    AppMethodBeat.o(231565);
    throw paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.a
 * JD-Core Version:    0.7.0.1
 */