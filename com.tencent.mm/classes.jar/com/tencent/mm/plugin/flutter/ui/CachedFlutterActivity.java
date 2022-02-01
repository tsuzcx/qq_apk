package com.tencent.mm.plugin.flutter.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.flutter.c.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode;
import io.flutter.embedding.android.PatchedFlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.a.ah;
import kotlin.a.p;
import kotlin.g.b.al;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/ui/CachedFlutterActivity;", "Lio/flutter/embedding/android/PatchedFlutterActivity;", "()V", "engineFromCached", "", "onKeyListener", "Lcom/tencent/mm/plugin/flutter/ui/CachedFlutterActivity$OnKeyListener;", "configureFlutterEngine", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "finish", "getCachedEngineId", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyDown", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKeyLongPress", "onKeyMultiple", "repeatCount", "onKeyUp", "setOnKeyListener", "listener", "setRequestedOrientation", "requestedOrientation", "setupConfiguration", "configuration", "setupLocale", "shouldDestroyEngineWithHost", "Companion", "OnKeyListener", "OnKeyListenerAdapter", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public class CachedFlutterActivity
  extends PatchedFlutterActivity
{
  public static final CachedFlutterActivity.a Hll;
  private boolean Hlm;
  private b Hln;
  
  static
  {
    AppMethodBeat.i(263308);
    Hll = new CachedFlutterActivity.a((byte)0);
    AppMethodBeat.o(263308);
  }
  
  private static void g(Configuration paramConfiguration)
  {
    AppMethodBeat.i(263300);
    Object localObject1 = LocaleUtil.getApplicationLanguage();
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(263300);
      return;
    }
    s.s(localObject1, "language");
    localObject1 = n.a((CharSequence)localObject1, new char[] { '_' }, 0, 6);
    localObject2 = (String)((List)localObject1).get(0);
    if (((List)localObject1).size() > 1) {}
    Object localObject4;
    for (localObject1 = (String)((List)localObject1).get(1);; localObject1 = "")
    {
      localObject1 = new Locale((String)localObject2, (String)localObject1, "");
      if (Build.VERSION.SDK_INT < 24) {
        break label422;
      }
      localObject2 = paramConfiguration.getLocales();
      s.s(localObject2, "configuration.locales");
      localObject4 = (Iterable)k.qt(0, ((LocaleList)localObject2).size());
      localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(((LocaleList)localObject2).get(((ah)localObject4).Zo()));
      }
    }
    Object localObject3 = (Iterable)localObject3;
    localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    label319:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      Locale localLocale = (Locale)localObject4;
      if ((!s.p(localLocale.getLanguage(), ((Locale)localObject1).getLanguage())) && (!s.p(localLocale.getCountry(), ((Locale)localObject1).getCountry()))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label319;
        }
        ((Collection)localObject2).add(localObject4);
        break;
      }
    }
    localObject2 = ((Collection)localObject2).toArray(new Locale[0]);
    if (localObject2 == null)
    {
      paramConfiguration = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(263300);
      throw paramConfiguration;
    }
    localObject2 = (Locale[])localObject2;
    localObject3 = new al(2);
    ((al)localObject3).add(localObject1);
    ((al)localObject3).hx(localObject2);
    paramConfiguration.setLocales(new LocaleList((Locale[])((al)localObject3).toArray(new Locale[((al)localObject3).hqL.size()])));
    AppMethodBeat.o(263300);
    return;
    label422:
    paramConfiguration.locale = ((Locale)localObject1);
    AppMethodBeat.o(263300);
  }
  
  private final void setupConfiguration(Configuration paramConfiguration)
  {
    AppMethodBeat.i(263291);
    if (aw.isDarkMode()) {}
    for (int i = 32;; i = 16)
    {
      paramConfiguration.uiMode = i;
      paramConfiguration.fontScale = a.getScaleSize((Context)this);
      g(paramConfiguration);
      getResources().getDisplayMetrics().setTo(MMApplicationContext.getResources().getDisplayMetrics());
      AppMethodBeat.o(263291);
      return;
    }
  }
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(263352);
    s.u(paramFlutterEngine, "flutterEngine");
    AppMethodBeat.o(263352);
  }
  
  public void finish()
  {
    AppMethodBeat.i(263392);
    super.finish();
    if (getBackgroundMode() != FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
      overridePendingTransition(0, c.a.slide_right_out);
    }
    AppMethodBeat.o(263392);
  }
  
  public String getCachedEngineId()
  {
    AppMethodBeat.i(263314);
    String str = super.getCachedEngineId();
    if ((str == null) || (FlutterEngineCache.getInstance().get(str) == null))
    {
      this.Hlm = false;
      AppMethodBeat.o(263314);
      return null;
    }
    this.Hlm = true;
    AppMethodBeat.o(263314);
    return str;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(263330);
    s.u(paramConfiguration, "newConfig");
    setupConfiguration(paramConfiguration);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(263330);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(263321);
    Configuration localConfiguration = getResources().getConfiguration();
    s.s(localConfiguration, "resources.configuration");
    setupConfiguration(localConfiguration);
    super.onCreate(paramBundle);
    paramBundle = super.getCachedEngineId();
    if ((paramBundle != null) && (FlutterEngineCache.getInstance().get(paramBundle) == null))
    {
      Log.e("MicroMsg.CachedFlutterActivity", "launch with cached engine id " + paramBundle + ", but it has been destroyed");
      finish();
    }
    AppMethodBeat.o(263321);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(263359);
    s.u(paramKeyEvent, "event");
    b localb = this.Hln;
    if (localb == null)
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(263359);
      return bool;
    }
    boolean bool = localb.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(263359);
    return bool;
  }
  
  public boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(263378);
    s.u(paramKeyEvent, "event");
    b localb = this.Hln;
    if (localb == null)
    {
      bool = super.onKeyLongPress(paramInt, paramKeyEvent);
      AppMethodBeat.o(263378);
      return bool;
    }
    boolean bool = localb.l(paramKeyEvent);
    AppMethodBeat.o(263378);
    return bool;
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(263386);
    s.u(paramKeyEvent, "event");
    b localb = this.Hln;
    if (localb == null)
    {
      bool = super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
      AppMethodBeat.o(263386);
      return bool;
    }
    boolean bool = localb.m(paramKeyEvent);
    AppMethodBeat.o(263386);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(263366);
    s.u(paramKeyEvent, "event");
    b localb = this.Hln;
    if (localb == null)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(263366);
      return bool;
    }
    boolean bool = localb.k(paramKeyEvent);
    AppMethodBeat.o(263366);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(263345);
    if (Build.VERSION.SDK_INT == 26) {
      try
      {
        super.setRequestedOrientation(paramInt);
        AppMethodBeat.o(263345);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.CachedFlutterActivity", "setRequestedOrientation() couldn't be called successfully");
        AppMethodBeat.o(263345);
        return;
      }
    }
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(263345);
  }
  
  public boolean shouldDestroyEngineWithHost()
  {
    AppMethodBeat.i(263338);
    String str = super.getCachedEngineId();
    if (!this.Hlm)
    {
      AppMethodBeat.o(263338);
      return true;
    }
    if ((str != null) && (FlutterEngineCache.getInstance().get(str) == null))
    {
      AppMethodBeat.o(263338);
      return false;
    }
    boolean bool = super.shouldDestroyEngineWithHost();
    AppMethodBeat.o(263338);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/ui/CachedFlutterActivity$OnKeyListener;", "", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKeyLongPress", "onKeyMultiple", "repeatCount", "onKeyUp", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract boolean k(KeyEvent paramKeyEvent);
    
    public abstract boolean l(KeyEvent paramKeyEvent);
    
    public abstract boolean m(KeyEvent paramKeyEvent);
    
    public abstract boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.ui.CachedFlutterActivity
 * JD-Core Version:    0.7.0.1
 */