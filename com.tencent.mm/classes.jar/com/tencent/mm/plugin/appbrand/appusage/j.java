package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class j
  extends k
{
  private static volatile j iUn = null;
  
  public static j aRE()
  {
    AppMethodBeat.i(44482);
    if (iUn == null) {}
    try
    {
      if (iUn == null) {
        iUn = new j();
      }
      j localj = iUn;
      AppMethodBeat.o(44482);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(44482);
    }
  }
  
  public static boolean aRG()
  {
    AppMethodBeat.i(44485);
    if (!g.afw())
    {
      AppMethodBeat.o(44485);
      return false;
    }
    boolean bool = ((Boolean)g.afB().afk().get(ae.a.Fll, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44485);
    return bool;
  }
  
  public static void release()
  {
    iUn = null;
  }
  
  public final void a(final long paramLong, final boolean paramBoolean, Bundle paramBundle, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(44484);
    l.bqm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44480);
        j localj = j.this;
        int j = paramInt1;
        int k = paramInt2;
        if ((paramBoolean & v.aRZ())) {}
        for (int i = 2;; i = 0)
        {
          j.a(localj, j, k, i | 0x1, paramLong, paramBoolean, this.iUs);
          AppMethodBeat.o(44480);
          return;
        }
      }
    });
    AppMethodBeat.o(44484);
  }
  
  public final void aRF()
  {
    AppMethodBeat.i(44483);
    l.bqm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44478);
        j.a(j.this, 1, 0, 7, 0L, true, null);
        AppMethodBeat.o(44478);
      }
    });
    AppMethodBeat.o(44483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.j
 * JD-Core Version:    0.7.0.1
 */