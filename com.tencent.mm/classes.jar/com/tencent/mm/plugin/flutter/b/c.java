package com.tencent.mm.plugin.flutter.b;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.ui.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugins.GeneratedPluginRegistrant;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.r;

public class c
{
  public b Hkl;
  public Activity Hkm;
  private HashMap<Integer, Pair<Integer, String>> Hkn;
  public AtomicInteger Hko;
  public MethodChannel Hkp;
  public m<Integer, KeyEvent, Boolean> Hkq;
  public r<Activity, Integer, Integer, String, ah> Hkr;
  public boolean Hks;
  private boolean Hkt;
  private FlutterUiDisplayListener Hku;
  public FlutterEngine flutterEngine;
  
  public c()
  {
    AppMethodBeat.i(148849);
    this.Hkn = new HashMap();
    this.Hko = new AtomicInteger(0);
    this.Hks = false;
    this.Hkt = false;
    this.Hku = new FlutterUiDisplayListener()
    {
      public final void onFlutterUiDisplayed()
      {
        AppMethodBeat.i(263092);
        Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onFlutterUiDisplayed");
        if (c.c(c.this) != null) {
          c.c(c.this);
        }
        AppMethodBeat.o(263092);
      }
      
      public final void onFlutterUiNoLongerDisplayed() {}
    };
    AppMethodBeat.o(148849);
  }
  
  private void destroyEngine()
  {
    AppMethodBeat.i(263144);
    FlutterEngine localFlutterEngine = FlutterEngineCache.getInstance().get("MMFlutterEngine");
    Log.w("MicroMsg.Flutter.FlutterEngineMgr", "destroy engine: ".concat(String.valueOf(localFlutterEngine)));
    if (localFlutterEngine != null)
    {
      FlutterEngineCache.getInstance().remove("MMFlutterEngine");
      localFlutterEngine.destroy();
    }
    for (;;)
    {
      this.flutterEngine = null;
      AppMethodBeat.o(263144);
      return;
      if (this.flutterEngine != null)
      {
        Log.w("MicroMsg.Flutter.FlutterEngineMgr", "destroy $flutterEngine: " + this.flutterEngine);
        this.flutterEngine.destroy();
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.flutter.a.c paramc, String paramString, Context paramContext)
  {
    AppMethodBeat.i(263183);
    if (this.flutterEngine == null) {
      fuZ();
    }
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "InitRoute %s ", new Object[] { paramc });
      long l = System.currentTimeMillis();
      paramc.Hkc = true;
      this.flutterEngine.getNavigationChannel().setInitialRoute(paramc.toJsonString());
      this.flutterEngine.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(), paramString));
      this.flutterEngine.getRenderer().addIsDisplayingFlutterUiListener(this.Hku);
      if (paramContext == null) {
        MMApplicationContext.getContext();
      }
      GeneratedPluginRegistrant.registerWith(this.flutterEngine);
      this.Hkp = new MethodChannel(this.flutterEngine.getDartExecutor(), "com.tencent.mm.flutter.mmnative");
      this.Hkp.setMethodCallHandler(new MethodChannel.MethodCallHandler()
      {
        public final void onMethodCall(MethodCall paramAnonymousMethodCall, MethodChannel.Result paramAnonymousResult)
        {
          AppMethodBeat.i(148847);
          if (paramAnonymousMethodCall.method.equals("pop"))
          {
            Log.i("MicroMsg.Flutter.FlutterEngineMgr", "call pop, bindingActivity=" + c.a(c.this));
            c.this.vD(false);
            if (c.a(c.this) == null) {
              break label96;
            }
            c.a(c.this).finish();
          }
          for (;;)
          {
            Log.i("MicroMsg.Flutter.FlutterEngineMgr", "method:%s", new Object[] { paramAnonymousMethodCall.method });
            AppMethodBeat.o(148847);
            return;
            label96:
            c.b(c.this);
          }
        }
      });
      this.Hkn.clear();
      l = System.currentTimeMillis() - l;
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "flutter engine init use time: %d", new Object[] { Long.valueOf(l) });
      h.OAn.kJ(1529, 0);
      h.OAn.p(1529L, 2L, l);
      AppMethodBeat.o(263183);
      return bool;
    }
  }
  
  public final boolean fuZ()
  {
    AppMethodBeat.i(263167);
    long l;
    if (this.flutterEngine == null)
    {
      l = System.currentTimeMillis();
      if (!FlutterEngineCache.getInstance().contains("MMFlutterEngine")) {
        break label102;
      }
      this.flutterEngine = FlutterEngineCache.getInstance().get("MMFlutterEngine");
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "preloadEngine get from cache");
    }
    for (;;)
    {
      l = System.currentTimeMillis() - l;
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "flutter engine new use time: %d", new Object[] { Long.valueOf(l) });
      h.OAn.kJ(1529, 0);
      h.OAn.p(1529L, 1L, l);
      AppMethodBeat.o(263167);
      return true;
      label102:
      this.flutterEngine = new FlutterEngine(MMApplicationContext.getContext());
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "preloadEngine create from new");
    }
  }
  
  public final boolean iQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263197);
    try
    {
      Pair localPair = (Pair)this.Hkn.get(Integer.valueOf(paramInt1));
      if (localPair != null) {
        Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onActivityResult %s %d %d", new Object[] { localPair.second, localPair.first, Integer.valueOf(paramInt2) });
      }
    }
    catch (Exception localException)
    {
      label58:
      break label58;
    }
    AppMethodBeat.o(263197);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(148851);
    this.Hkm = null;
    int i = this.Hko.decrementAndGet();
    Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onDestroy, needKeepEngineOnUiExit:%s， count=%d, flutterEngine=" + this.flutterEngine, new Object[] { Boolean.valueOf(this.Hkt), Integer.valueOf(i) });
    if (i <= 0)
    {
      this.Hkn.clear();
      if (this.flutterEngine != null)
      {
        if (!this.Hkt) {
          break label124;
        }
        FlutterEngineCache.getInstance().put("MMFlutterEngine", this.flutterEngine);
        this.flutterEngine.getRenderer().stopRenderingToSurface();
      }
    }
    for (;;)
    {
      this.flutterEngine = null;
      AppMethodBeat.o(148851);
      return;
      label124:
      destroyEngine();
    }
  }
  
  public final void vD(boolean paramBoolean)
  {
    AppMethodBeat.i(263172);
    Log.i("MicroMsg.Flutter.FlutterEngineMgr", "setNeedKeepEngineOnUiExit:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Hkt = paramBoolean;
    AppMethodBeat.o(263172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.b.c
 * JD-Core Version:    0.7.0.1
 */