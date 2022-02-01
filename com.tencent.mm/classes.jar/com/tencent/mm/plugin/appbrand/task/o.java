package com.tencent.mm.plugin.appbrand.task;

import android.os.SystemClock;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.report.quality.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

final class o
  extends AppBrandMainProcessService.a
{
  final String mProcessName;
  final n nQA;
  long nQB = 0L;
  boolean nQC;
  
  public o(n paramn, String paramString)
  {
    this.nQA = paramn;
    this.mProcessName = paramString;
  }
  
  final void Bp(long paramLong)
  {
    AppMethodBeat.i(227529);
    Iterator localIterator = this.nQA.bWx().iterator();
    while (localIterator.hasNext())
    {
      AppBrandRemoteTaskController localAppBrandRemoteTaskController = (AppBrandRemoteTaskController)localIterator.next();
      if (localAppBrandRemoteTaskController == null)
      {
        AppMethodBeat.o(227529);
        return;
      }
      Object localObject = localAppBrandRemoteTaskController.mAppId;
      if ((localObject != null) && (!((String)localObject).isEmpty()))
      {
        localObject = new com.tencent.mm.g.b.a.n();
        ((com.tencent.mm.g.b.a.n)localObject).hR(localAppBrandRemoteTaskController.mAppId);
        ((com.tencent.mm.g.b.a.n)localObject).ekD = (System.currentTimeMillis() - this.nQA.afp(localAppBrandRemoteTaskController.mAppId));
        ((com.tencent.mm.g.b.a.n)localObject).ekC = localAppBrandRemoteTaskController.appType;
        a.a locala = a.nKn;
        ((com.tencent.mm.g.b.a.n)localObject).hS(a.a.getFlags());
        ((com.tencent.mm.g.b.a.n)localObject).ekE = 0L;
        ((com.tencent.mm.g.b.a.n)localObject).hT(localAppBrandRemoteTaskController.nPi);
        ((com.tencent.mm.g.b.a.n)localObject).bfK();
      }
    }
    Log.i("MicroMsg.ClientProcessStateListener", "onDied: name = [%s], alive = [%d]seconds", new Object[] { this.nQA.nQm, Long.valueOf(paramLong) });
    AppMethodBeat.o(227529);
  }
  
  public final void Uf(String paramString)
  {
    AppMethodBeat.i(227527);
    if (!this.mProcessName.equals(paramString))
    {
      AppMethodBeat.o(227527);
      return;
    }
    this.nQA.nQw.set(true);
    if (this.nQB == 0L) {
      this.nQB = SystemClock.elapsedRealtime();
    }
    Log.i("MicroMsg.ClientProcessStateListener", "onConnected: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(227527);
  }
  
  public final void onDisconnected(final String paramString)
  {
    AppMethodBeat.i(227528);
    h.RTc.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227526);
        o localo = o.this;
        String str = paramString;
        long l;
        if (localo.mProcessName.equals(str))
        {
          AppBrandMainProcessService.b(localo);
          localo.nQA.nQw.set(false);
          l = (int)((SystemClock.elapsedRealtime() - localo.nQB) / 1000L);
          if ((l < 0L) || (localo.nQB == 0L)) {
            break label329;
          }
          if ((!localo.nQC) || (!localo.nQA.bWp())) {
            break label321;
          }
          if (l > 60L) {
            break label204;
          }
          e.Cxv.idkeyStat(365L, 6L, 1L, false);
          com.tencent.mm.g.b.a.n localn = new com.tencent.mm.g.b.a.n();
          localn.ekD = (1000L * l);
          a.a locala = a.nKn;
          localn.hS(a.a.getFlags());
          localn.ekE = 3L;
          localn.bfK();
          Log.d("MicroMsg.ClientProcessStateListener", "onDisconnected: [%s]" + localn.abW(), new Object[] { str });
        }
        for (;;)
        {
          localo.nQB = 0L;
          AppMethodBeat.o(227526);
          return;
          label204:
          if (l <= 120L)
          {
            e.Cxv.idkeyStat(365L, 7L, 1L, false);
            break;
          }
          if (l <= 300L)
          {
            e.Cxv.idkeyStat(365L, 8L, 1L, false);
            break;
          }
          if (l <= 600L)
          {
            e.Cxv.idkeyStat(365L, 9L, 1L, false);
            break;
          }
          if (l <= 1200L)
          {
            e.Cxv.idkeyStat(365L, 10L, 1L, false);
            break;
          }
          e.Cxv.idkeyStat(365L, 11L, 1L, false);
          break;
          label321:
          localo.Bp(l);
          continue;
          label329:
          Log.e("MicroMsg.ClientProcessStateListener", "onDied: name = [%s], got a invalid time [%s] - [%s] = [%s]", new Object[] { localo.nQA.nQm, String.valueOf(SystemClock.elapsedRealtime()), String.valueOf(localo.nQB), String.valueOf(l) });
        }
      }
    });
    AppMethodBeat.o(227528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.o
 * JD-Core Version:    0.7.0.1
 */