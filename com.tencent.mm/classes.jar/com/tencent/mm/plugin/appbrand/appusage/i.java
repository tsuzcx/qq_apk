package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class i
  extends MStorage
{
  private static volatile i qOz = null;
  
  public static i ciJ()
  {
    AppMethodBeat.i(44482);
    if (qOz == null) {}
    try
    {
      if (qOz == null) {
        qOz = new i();
      }
      i locali = qOz;
      AppMethodBeat.o(44482);
      return locali;
    }
    finally
    {
      AppMethodBeat.o(44482);
    }
  }
  
  public static boolean ciL()
  {
    AppMethodBeat.i(44485);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(44485);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNm, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44485);
    return bool;
  }
  
  public static void release()
  {
    qOz = null;
  }
  
  public final void a(long paramLong, boolean paramBoolean, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44484);
    a(paramLong, paramBoolean, paramBundle, paramInt1, paramInt2, -1, -1L, null);
    AppMethodBeat.o(44484);
  }
  
  public final void a(final long paramLong1, final boolean paramBoolean, Bundle paramBundle, final int paramInt1, final int paramInt2, final int paramInt3, final long paramLong2, final i.a parama)
  {
    AppMethodBeat.i(319331);
    o.cNm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44480);
        i locali = i.this;
        int j = paramInt1;
        int k = paramInt2;
        if ((paramBoolean & u.cjf())) {}
        for (int i = 2;; i = 0)
        {
          i.a(locali, j, k, i | 0x1, paramLong1, paramBoolean, paramInt3, paramLong2, parama, this.qOG);
          AppMethodBeat.o(44480);
          return;
        }
      }
    });
    AppMethodBeat.o(319331);
  }
  
  public final void ciK()
  {
    AppMethodBeat.i(44483);
    o.cNm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44478);
        i.a(i.this, 1, 0, 7, 0L, true, null, -1, -1L, null);
        AppMethodBeat.o(44478);
      }
    });
    AppMethodBeat.o(44483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.i
 * JD-Core Version:    0.7.0.1
 */