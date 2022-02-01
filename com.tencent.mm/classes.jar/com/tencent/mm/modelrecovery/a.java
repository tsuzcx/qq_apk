package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.RecoveryCrash;
import com.tencent.mm.recoveryv2.i;
import com.tencent.mm.recoveryv2.i.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static void db(Context paramContext)
  {
    AppMethodBeat.i(288283);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, dump recovery status:");
    Object localObject = RecoveryCrash.jL(paramContext);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + ((RecoveryCrash)localObject).hqb());
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + ((RecoveryCrash)localObject).hqa());
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + ((RecoveryCrash)localObject).hqc());
    localObject = i.a.jQ(paramContext);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting enable       = " + ((i.a)localObject).isEnabled());
    localObject = i.jP(paramContext);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 1  = " + ((i)localObject).hqp());
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 2  = " + ((i)localObject).hqq());
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting interval     = " + ((i)localObject).hqn());
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting min interval = " + ((i)localObject).hqs());
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting auto reset   = " + ((i)localObject).hqr());
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, main process will crash immediately");
    RecoveryCrash.jL(paramContext).arG(((i)localObject).hqp()).Uf(System.currentTimeMillis()).arg();
    Log.w("MicroMsg.Recovery.RecoveryHelper", "setting new recovery status:");
    paramContext = RecoveryCrash.jL(paramContext);
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + paramContext.hqb());
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + paramContext.hqa());
    Log.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + paramContext.hqc());
    paramContext = new RuntimeException("setLaunchRecovery");
    AppMethodBeat.o(288283);
    throw paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.a
 * JD-Core Version:    0.7.0.1
 */