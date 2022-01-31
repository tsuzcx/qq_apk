package com.tencent.luggage.sdk.b.a.a;

import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener;
import com.tencent.mm.plugin.appbrand.o.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class a$2
  implements LockStepNative.ILockStepReportListener
{
  a$2(a parama) {}
  
  public final void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    AppMethodBeat.i(140698);
    ab.d("Luggage.LockStepNativeInstallHelper", "mmudp onIdKeyStat");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt1.length)
    {
      localArrayList.add(new IDKey(paramArrayOfInt1[i], paramArrayOfInt2[i], paramArrayOfInt3[i]));
      i += 1;
    }
    ((com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class)).b(localArrayList, false);
    AppMethodBeat.o(140698);
  }
  
  public final void onKvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(140697);
    ab.d("Luggage.LockStepNativeInstallHelper", "mmudp onKvStat logId:%d", new Object[] { Integer.valueOf(paramInt) });
    ((b)e.r(b.class)).kvStat(paramInt, paramString);
    AppMethodBeat.o(140697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.a.2
 * JD-Core Version:    0.7.0.1
 */