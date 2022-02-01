package com.tencent.mm.plugin.flutter.b;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import io.flutter.embedding.engine.b.b;
import io.flutter.embedding.engine.c.f;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.m;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.view.FlutterMain;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
{
  public io.flutter.embedding.engine.a wJi;
  private com.tencent.mm.plugin.flutter.ui.a wJj;
  private HashMap<Integer, Pair<Integer, String>> wJk;
  private AtomicInteger wJl;
  public k wJm;
  public m wJn;
  private b wJo;
  
  public a()
  {
    AppMethodBeat.i(148849);
    this.wJk = new HashMap();
    this.wJl = new AtomicInteger(0);
    this.wJo = new a.3(this);
    AppMethodBeat.o(148849);
  }
  
  public final void a(com.tencent.mm.plugin.flutter.ui.a parama)
  {
    AppMethodBeat.i(240935);
    int i = this.wJl.incrementAndGet();
    Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onCreate %s InstanceCount %d", new Object[] { Integer.valueOf(parama.hashCode()), Integer.valueOf(i) });
    AppMethodBeat.o(240935);
  }
  
  public final boolean a(com.tencent.mm.plugin.flutter.a.c paramc, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(240934);
    if (this.wJi == null) {
      dLq();
    }
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "InitRoute %s ", new Object[] { paramc });
      long l = System.currentTimeMillis();
      paramc.wJh = true;
      this.wJi.SOc.setInitialRoute(paramc.bua());
      System.loadLibrary("wechatlv");
      paramc = this.wJi.SNW;
      MMApplicationContext.getContext().getAssets();
      paramc.a(new DartExecutor.a(FlutterMain.findAppBundlePath(MMApplicationContext.getContext()), paramString, (byte)0));
      this.wJi.SMr.addIsDisplayingFlutterUiListener(this.wJo);
      paramc = paramActivity;
      if (paramActivity == null) {
        paramc = MMApplicationContext.getContext();
      }
      this.wJn = new io.flutter.app.c(paramc);
      GeneratedPluginRegistrant.registerWith(this.wJn);
      this.wJm = new k(this.wJi.SNW, "com.tencent.mm.flutter.mmnative");
      this.wJm.a(new a.1(this));
      this.wJk.clear();
      l = System.currentTimeMillis() - l;
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "flutter engine init use time: %d", new Object[] { Long.valueOf(l) });
      h.CyF.dN(1529, 0);
      h.CyF.n(1529L, 2L, l);
      AppMethodBeat.o(240934);
      return bool;
    }
  }
  
  public final void b(com.tencent.mm.plugin.flutter.ui.a parama)
  {
    AppMethodBeat.i(240936);
    if (parama.equals(this.wJj)) {
      this.wJi.SNZ.hxd();
    }
    AppMethodBeat.o(240936);
  }
  
  public final void c(com.tencent.mm.plugin.flutter.ui.a parama)
  {
    AppMethodBeat.i(240937);
    this.wJj = parama;
    this.wJi.SNZ.hxc();
    AppMethodBeat.o(240937);
  }
  
  public final void d(com.tencent.mm.plugin.flutter.ui.a parama)
  {
    AppMethodBeat.i(240938);
    if (this.wJj.equals(parama))
    {
      this.wJi.SNZ.hxe();
      this.wJj = null;
    }
    AppMethodBeat.o(240938);
  }
  
  public final boolean dLq()
  {
    AppMethodBeat.i(240933);
    if (this.wJi == null)
    {
      long l = System.currentTimeMillis();
      this.wJi = new io.flutter.embedding.engine.a(MMApplicationContext.getContext());
      l = System.currentTimeMillis() - l;
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "flutter engine new use time: %d", new Object[] { Long.valueOf(l) });
      h.CyF.dN(1529, 0);
      h.CyF.n(1529L, 1L, l);
    }
    AppMethodBeat.o(240933);
    return true;
  }
  
  public final void dLr()
  {
    AppMethodBeat.i(148852);
    this.wJi.SOc.dLr();
    AppMethodBeat.o(148852);
  }
  
  public final com.tencent.mm.plugin.flutter.ui.a dLs()
  {
    return this.wJj;
  }
  
  public final void fP(Context paramContext)
  {
    AppMethodBeat.i(240940);
    if (this.wJm == null)
    {
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onBackPressed error. platformChannel is null.");
      ((Activity)paramContext).finish();
      AppMethodBeat.o(240940);
      return;
    }
    this.wJm.a("canPop", null, new a.4(this, paramContext));
    AppMethodBeat.o(240940);
  }
  
  public final boolean gA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240939);
    try
    {
      Pair localPair = (Pair)this.wJk.get(Integer.valueOf(paramInt1));
      if (localPair != null) {
        Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onActivityResult %s %d %d", new Object[] { localPair.second, localPair.first, Integer.valueOf(paramInt2) });
      }
    }
    catch (Exception localException)
    {
      label58:
      break label58;
    }
    AppMethodBeat.o(240939);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(148851);
    if (this.wJl.decrementAndGet() <= 0)
    {
      this.wJk.clear();
      if (this.wJi != null) {
        this.wJi.destroy();
      }
      this.wJi = null;
    }
    AppMethodBeat.o(148851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.b.a
 * JD-Core Version:    0.7.0.1
 */