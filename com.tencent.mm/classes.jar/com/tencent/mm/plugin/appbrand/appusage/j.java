package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.x.c;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class j
  extends k
{
  private static volatile j jOs = null;
  
  public static j bbX()
  {
    AppMethodBeat.i(44482);
    if (jOs == null) {}
    try
    {
      if (jOs == null) {
        jOs = new j();
      }
      j localj = jOs;
      AppMethodBeat.o(44482);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(44482);
    }
  }
  
  public static boolean bbZ()
  {
    AppMethodBeat.i(44485);
    if (!g.ajx())
    {
      AppMethodBeat.o(44485);
      return false;
    }
    boolean bool = ((Boolean)g.ajC().ajl().get(al.a.Ivs, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44485);
    return bool;
  }
  
  public static void release()
  {
    jOs = null;
  }
  
  public final void a(long paramLong, boolean paramBoolean, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44484);
    a(paramLong, paramBoolean, paramBundle, paramInt1, paramInt2, -1, -1L, null);
    AppMethodBeat.o(44484);
  }
  
  public final void a(final long paramLong1, final boolean paramBoolean, Bundle paramBundle, final int paramInt1, final int paramInt2, final int paramInt3, final long paramLong2, final a parama)
  {
    AppMethodBeat.i(188027);
    m.bBp().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44480);
        j localj = j.this;
        int j = paramInt1;
        int k = paramInt2;
        if ((paramBoolean & v.bcs())) {}
        for (int i = 2;; i = 0)
        {
          j.a(localj, j, k, i | 0x1, paramLong1, paramBoolean, paramInt3, paramLong2, parama, this.jOz);
          AppMethodBeat.o(44480);
          return;
        }
      }
    });
    AppMethodBeat.o(188027);
  }
  
  public final void bbY()
  {
    AppMethodBeat.i(44483);
    m.bBp().postToWorker(new Runnable()
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
    public abstract void n(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.j
 * JD-Core Version:    0.7.0.1
 */