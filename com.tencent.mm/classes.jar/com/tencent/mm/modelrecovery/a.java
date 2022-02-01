package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.RecoveryCrash;
import com.tencent.mm.recoveryv2.b;
import com.tencent.mm.recoveryv2.h;
import com.tencent.mm.recoveryv2.h.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static void dU(Context paramContext)
  {
    AppMethodBeat.i(231037);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, dump recovery status:");
    Object localObject = RecoveryCrash.lL(paramContext);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + ((RecoveryCrash)localObject).acjU.acjW);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + ((RecoveryCrash)localObject).acjR);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + ((RecoveryCrash)localObject).acjS);
    localObject = h.a.lS(paramContext);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting enable       = " + ((h.a)localObject).mEnabled);
    localObject = h.lR(paramContext);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 1  = " + ((h)localObject).ackd);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 2  = " + ((h)localObject).acke);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting interval     = " + ((h)localObject).ackf);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting min interval = " + ((h)localObject).ackh);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting auto reset   = " + ((h)localObject).acki);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, main process will crash immediately");
    localObject = RecoveryCrash.lL(paramContext).axO(((h)localObject).ackd);
    ((RecoveryCrash)localObject).acjR = System.currentTimeMillis();
    ((RecoveryCrash)localObject).sz();
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting new recovery status:");
    paramContext = RecoveryCrash.lL(paramContext);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + paramContext.acjU.acjW);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + paramContext.acjR);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + paramContext.acjS);
    paramContext = new RuntimeException("setLaunchRecovery");
    AppMethodBeat.o(231037);
    throw paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.a
 * JD-Core Version:    0.7.0.1
 */