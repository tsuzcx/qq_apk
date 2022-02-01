package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ca.c;
import com.tencent.mm.ca.g;
import com.tencent.mm.ca.g.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public static void cA(Context paramContext)
  {
    AppMethodBeat.i(191153);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, dump recovery status:");
    Object localObject = c.ht(paramContext);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + ((c)localObject).ELm);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + ((c)localObject).ELl);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + ((c)localObject).ELn);
    localObject = g.a.hw(paramContext);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setting enable       = " + ((g.a)localObject).mEnabled);
    localObject = g.hv(paramContext);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 1  = " + ((g)localObject).ELu);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 2  = " + ((g)localObject).ELv);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setting interval     = " + ((g)localObject).ELw);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setting min interval = " + ((g)localObject).ELx);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setting auto reset   = " + ((g)localObject).ELy);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, main process will crash immediately");
    c localc = c.ht(paramContext);
    localc.ELm = ((g)localObject).ELu;
    localc.ELl = System.currentTimeMillis();
    localc.save();
    ad.w("MicroMsg.Recovery.RecoveryHelper", "setting new recovery status:");
    paramContext = c.ht(paramContext);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + paramContext.ELm);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + paramContext.ELl);
    ad.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + paramContext.ELn);
    paramContext = new RuntimeException("setLaunchRecovery");
    AppMethodBeat.o(191153);
    throw paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.a
 * JD-Core Version:    0.7.0.1
 */