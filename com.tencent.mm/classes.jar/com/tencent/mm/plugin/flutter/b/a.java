package com.tencent.mm.plugin.flutter.b;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import io.flutter.embedding.engine.b.d;
import io.flutter.embedding.engine.b.g;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.embedding.engine.renderer.b;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.plugin.a.m;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.view.FlutterMain;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class a
{
  private AtomicInteger BCA;
  public k BCB;
  public m BCC;
  private b BCD;
  public io.flutter.embedding.engine.a BCx;
  private com.tencent.mm.plugin.flutter.ui.a BCy;
  private HashMap<Integer, Pair<Integer, String>> BCz;
  
  public a()
  {
    AppMethodBeat.i(148849);
    this.BCz = new HashMap();
    this.BCA = new AtomicInteger(0);
    this.BCD = new b()
    {
      public final void epX()
      {
        AppMethodBeat.i(220500);
        Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onFlutterUiDisplayed");
        if (a.a(a.this) != null) {
          a.a(a.this);
        }
        AppMethodBeat.o(220500);
      }
      
      public final void epY() {}
    };
    AppMethodBeat.o(148849);
  }
  
  public final void a(com.tencent.mm.plugin.flutter.ui.a parama)
  {
    AppMethodBeat.i(220589);
    int i = this.BCA.incrementAndGet();
    Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onCreate %s InstanceCount %d", new Object[] { Integer.valueOf(parama.hashCode()), Integer.valueOf(i) });
    AppMethodBeat.o(220589);
  }
  
  public final boolean a(com.tencent.mm.plugin.flutter.a.c paramc, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(220587);
    if (this.BCx == null) {
      epV();
    }
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "InitRoute %s ", new Object[] { paramc });
      long l = System.currentTimeMillis();
      paramc.BCw = true;
      this.BCx.aaqb.setInitialRoute(paramc.bFa());
      System.loadLibrary("wechatlv");
      this.BCx.aapU.a(new DartExecutor.a(FlutterMain.findAppBundlePath(MMApplicationContext.getContext()), paramString));
      this.BCx.aaos.addIsDisplayingFlutterUiListener(this.BCD);
      paramc = paramActivity;
      if (paramActivity == null) {
        paramc = MMApplicationContext.getContext();
      }
      this.BCC = new io.flutter.app.c(paramc);
      GeneratedPluginRegistrant.registerWith(this.BCC);
      this.BCB = new k(this.BCx.aapU, "com.tencent.mm.flutter.mmnative");
      this.BCB.a(new k.c()
      {
        public final void a(j paramAnonymousj, k.d paramAnonymousd)
        {
          AppMethodBeat.i(148847);
          Log.i("MicroMsg.Flutter.FlutterEngineMgr", "method:%s", new Object[] { paramAnonymousj.method });
          AppMethodBeat.o(148847);
        }
      });
      this.BCz.clear();
      l = System.currentTimeMillis() - l;
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "flutter engine init use time: %d", new Object[] { Long.valueOf(l) });
      h.IzE.el(1529, 0);
      h.IzE.p(1529L, 2L, l);
      AppMethodBeat.o(220587);
      return bool;
    }
  }
  
  public final void b(com.tencent.mm.plugin.flutter.ui.a parama)
  {
    AppMethodBeat.i(220592);
    if (parama.equals(this.BCy)) {
      this.BCx.aapY.iBe();
    }
    AppMethodBeat.o(220592);
  }
  
  public final void c(com.tencent.mm.plugin.flutter.ui.a parama)
  {
    AppMethodBeat.i(220594);
    this.BCy = parama;
    this.BCx.aapY.iBd();
    AppMethodBeat.o(220594);
  }
  
  public final void d(com.tencent.mm.plugin.flutter.ui.a parama)
  {
    AppMethodBeat.i(220596);
    if (this.BCy.equals(parama))
    {
      this.BCx.aapY.iBf();
      this.BCy = null;
    }
    AppMethodBeat.o(220596);
  }
  
  public final boolean epV()
  {
    AppMethodBeat.i(220582);
    if (this.BCx == null)
    {
      long l = System.currentTimeMillis();
      this.BCx = new io.flutter.embedding.engine.a(MMApplicationContext.getContext());
      l = System.currentTimeMillis() - l;
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "flutter engine new use time: %d", new Object[] { Long.valueOf(l) });
      h.IzE.el(1529, 0);
      h.IzE.p(1529L, 1L, l);
    }
    AppMethodBeat.o(220582);
    return true;
  }
  
  public final void epW()
  {
    AppMethodBeat.i(148852);
    this.BCx.aaqb.epW();
    AppMethodBeat.o(148852);
  }
  
  public final void gj(final Context paramContext)
  {
    AppMethodBeat.i(220602);
    if (this.BCB == null)
    {
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onBackPressed error. platformChannel is null.");
      ((Activity)paramContext).finish();
      AppMethodBeat.o(220602);
      return;
    }
    this.BCB.a("canPop", null, new k.d()
    {
      public final void b(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(220895);
        Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onBackPressed error");
        ((Activity)paramContext).finish();
        AppMethodBeat.o(220895);
      }
      
      public final void bb(Object paramAnonymousObject)
      {
        AppMethodBeat.i(220893);
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof Boolean)) && (((Boolean)paramAnonymousObject).booleanValue()))
        {
          a.this.epW();
          AppMethodBeat.o(220893);
          return;
        }
        Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onBackPressed success can not pop.");
        a.this.epW();
        AppMethodBeat.o(220893);
      }
      
      public final void epZ()
      {
        AppMethodBeat.i(220897);
        Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onBackPressed notImplemented");
        ((Activity)paramContext).finish();
        AppMethodBeat.o(220897);
      }
    });
    AppMethodBeat.o(220602);
  }
  
  public final boolean hv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220600);
    try
    {
      Pair localPair = (Pair)this.BCz.get(Integer.valueOf(paramInt1));
      if (localPair != null) {
        Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onActivityResult %s %d %d", new Object[] { localPair.second, localPair.first, Integer.valueOf(paramInt2) });
      }
    }
    catch (Exception localException)
    {
      label58:
      break label58;
    }
    AppMethodBeat.o(220600);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(148851);
    if (this.BCA.decrementAndGet() <= 0)
    {
      this.BCz.clear();
      if (this.BCx != null) {
        this.BCx.destroy();
      }
      this.BCx = null;
    }
    AppMethodBeat.o(148851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.b.a
 * JD-Core Version:    0.7.0.1
 */