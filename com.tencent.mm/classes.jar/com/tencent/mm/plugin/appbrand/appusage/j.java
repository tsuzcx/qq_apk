package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.w.c;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class j
  extends k
{
  private static volatile j juz = null;
  
  public static boolean aYB()
  {
    AppMethodBeat.i(44485);
    if (!g.agM())
    {
      AppMethodBeat.o(44485);
      return false;
    }
    boolean bool = ((Boolean)g.agR().agA().get(ah.a.GJa, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44485);
    return bool;
  }
  
  public static j aYz()
  {
    AppMethodBeat.i(44482);
    if (juz == null) {}
    try
    {
      if (juz == null) {
        juz = new j();
      }
      j localj = juz;
      AppMethodBeat.o(44482);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(44482);
    }
  }
  
  public static void release()
  {
    juz = null;
  }
  
  public final void a(long paramLong, boolean paramBoolean, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44484);
    a(paramLong, paramBoolean, paramBundle, paramInt1, paramInt2, -1, -1L, null);
    AppMethodBeat.o(44484);
  }
  
  public final void a(final long paramLong1, final boolean paramBoolean, Bundle paramBundle, final int paramInt1, final int paramInt2, final int paramInt3, final long paramLong2, final a parama)
  {
    AppMethodBeat.i(186337);
    l.bxj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44480);
        j localj = j.this;
        int j = paramInt1;
        int k = paramInt2;
        if ((paramBoolean & v.aYU())) {}
        for (int i = 2;; i = 0)
        {
          j.a(localj, j, k, i | 0x1, paramLong1, paramBoolean, paramInt3, paramLong2, parama, this.juG);
          AppMethodBeat.o(44480);
          return;
        }
      }
    });
    AppMethodBeat.o(186337);
  }
  
  public final void aYA()
  {
    AppMethodBeat.i(44483);
    l.bxj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44478);
        j.a(j.this, 1, 0, 7, 0L, true, null, -1, -1L, null);
        AppMethodBeat.o(44478);
      }
    });
    AppMethodBeat.o(44483);
  }
  
  public static abstract interface a
  {
    public abstract void done();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.j
 * JD-Core Version:    0.7.0.1
 */