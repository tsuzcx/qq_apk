package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.RecoveryCrash;
import com.tencent.mm.recoveryv2.c;
import com.tencent.mm.recoveryv2.h;
import com.tencent.mm.recoveryv2.h.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public static void cI(Context paramContext)
  {
    AppMethodBeat.i(186382);
    ae.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, dump recovery status:");
    Object localObject = RecoveryCrash.hP(paramContext);
    ae.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + ((RecoveryCrash)localObject).Ioc.Ioe);
    ae.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + ((RecoveryCrash)localObject).InZ);
    ae.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + ((RecoveryCrash)localObject).Ioa);
    localObject = h.a.hU(paramContext);
    ae.w("MicroMsg.Recovery.RecoveryHelper", "setting enable       = " + ((h.a)localObject).mEnabled);
    localObject = h.hT(paramContext);
    ae.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 1  = " + ((h)localObject).Iom);
    ae.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 2  = " + ((h)localObject).Ion);
    ae.w("MicroMsg.Recovery.RecoveryHelper", "setting interval     = " + ((h)localObject).Ioo);
    ae.w("MicroMsg.Recovery.RecoveryHelper", "setting min interval = " + ((h)localObject).Ioq);
    ae.w("MicroMsg.Recovery.RecoveryHelper", "setting auto reset   = " + ((h)localObject).Ior);
    ae.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, main process will crash immediately");
    localObject = RecoveryCrash.hP(paramContext).aaC(((h)localObject).Iom);
    ((RecoveryCrash)localObject).InZ = System.currentTimeMillis();
    ((RecoveryCrash)localObject).save();
    ae.w("MicroMsg.Recovery.RecoveryHelper", "setting new recovery status:");
    paramContext = RecoveryCrash.hP(paramContext);
    ae.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + paramContext.Ioc.Ioe);
    ae.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + paramContext.InZ);
    ae.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + paramContext.Ioa);
    paramContext = new RuntimeException("setLaunchRecovery");
    AppMethodBeat.o(186382);
    throw paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.a
 * JD-Core Version:    0.7.0.1
 */