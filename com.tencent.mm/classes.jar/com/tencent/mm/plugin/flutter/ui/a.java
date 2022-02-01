package com.tencent.mm.plugin.flutter.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import io.flutter.embedding.android.PatchedFlutterActivityController;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/ui/CachedFlutterActivityController;", "Lio/flutter/embedding/android/PatchedFlutterActivityController;", "activity", "Lcom/tencent/mm/plugin/voip/ui/VideoActivity;", "(Lcom/tencent/mm/plugin/voip/ui/VideoActivity;)V", "engineFromCached", "", "onKeyListener", "Lcom/tencent/mm/plugin/flutter/ui/CachedFlutterActivity$OnKeyListener;", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "configureFlutterEngine", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "dealContentView", "v", "Landroid/view/View;", "finish", "getCachedEngineId", "", "getForceOrientation", "", "getLayoutId", "importUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onOrientationChange", "orientation", "onResume", "setOnKeyListener", "listener", "setupConfiguration", "configuration", "setupLocale", "shouldDestroyEngineWithHost", "Companion", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends PatchedFlutterActivityController
{
  public static final a.a Hlo;
  private boolean Hlm;
  public CachedFlutterActivity.b Hln;
  private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  
  static
  {
    AppMethodBeat.i(263289);
    Hlo = new a.a((byte)0);
    AppMethodBeat.o(263289);
  }
  
  public a(VideoActivity paramVideoActivity)
  {
    super(paramVideoActivity);
    AppMethodBeat.i(263285);
    AppMethodBeat.o(263285);
  }
  
  public final void c(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(263357);
    s.u(paramHashSet, "set");
    AppMethodBeat.o(263357);
  }
  
  public final void configureFlutterEngine(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(263364);
    s.u(paramFlutterEngine, "flutterEngine");
    AppMethodBeat.o(263364);
  }
  
  public final void dealContentView(View paramView) {}
  
  public final void finish()
  {
    AppMethodBeat.i(263383);
    com.tencent.mm.plugin.mmsight.model.d locald = this.orientationEventListener;
    if (locald != null) {
      locald.disable();
    }
    locald = this.orientationEventListener;
    if (locald != null) {
      locald.KUU = null;
    }
    this.orientationEventListener = null;
    this.vActivity.ias();
    AppMethodBeat.o(263383);
  }
  
  public final String getCachedEngineId()
  {
    AppMethodBeat.i(263293);
    String str = super.getCachedEngineId();
    if ((str == null) || (FlutterEngineCache.getInstance().get(str) == null))
    {
      this.Hlm = false;
      AppMethodBeat.o(263293);
      return null;
    }
    this.Hlm = true;
    AppMethodBeat.o(263293);
    return str;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final boolean onBackPressed()
  {
    return true;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(263318);
    s.u(paramConfiguration, "newConfig");
    setupConfiguration(paramConfiguration);
    getActivity().getResources().getDisplayMetrics().setTo(MMApplicationContext.getResources().getDisplayMetrics());
    AppMethodBeat.o(263318);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(263305);
    Configuration localConfiguration = getActivity().getResources().getConfiguration();
    s.s(localConfiguration, "activity.resources.configuration");
    setupConfiguration(localConfiguration);
    getActivity().getResources().getDisplayMetrics().setTo(MMApplicationContext.getResources().getDisplayMetrics());
    super.onCreate(paramBundle);
    paramBundle = super.getCachedEngineId();
    Log.i("MicroMsg.CachedFlutterActivity", s.X("onCreate: cachedEngineId=", paramBundle));
    if ((paramBundle == null) && (((c)h.ax(c.class)).a(c.a.ySI, true)))
    {
      Log.w("MicroMsg.CachedFlutterActivity", "finish activity because null cachedEngineId");
      this.vActivity.ias();
      AppMethodBeat.o(263305);
      return;
    }
    if ((paramBundle != null) && (FlutterEngineCache.getInstance().get(paramBundle) == null))
    {
      Log.e("MicroMsg.CachedFlutterActivity", "launch with cached engine id " + paramBundle + ", but it has been destroyed");
      this.vActivity.ias();
      AppMethodBeat.o(263305);
      return;
    }
    this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d((Context)getActivity());
    paramBundle = this.orientationEventListener;
    if (paramBundle != null) {
      paramBundle.enable();
    }
    paramBundle = this.orientationEventListener;
    if (paramBundle != null) {
      paramBundle.KUU = ((d.a)this);
    }
    paramBundle = SubCoreVoip.hVp();
    if (paramBundle != null) {
      com.tencent.mm.plugin.voip.floatcard.a.a(paramBundle.UCa, false, false, 3);
    }
    AppMethodBeat.o(263305);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(263374);
    s.u(paramKeyEvent, "event");
    CachedFlutterActivity.b localb = this.Hln;
    if (localb == null)
    {
      AppMethodBeat.o(263374);
      return false;
    }
    boolean bool = localb.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(263374);
    return bool;
  }
  
  public final void onOrientationChange(int paramInt)
  {
    AppMethodBeat.i(263405);
    Object localObject = this.vActivity.getSystemService("window");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(263405);
      throw ((Throwable)localObject);
    }
    int i = ((WindowManager)localObject).getDefaultDisplay().getRotation();
    localObject = com.tencent.mm.plugin.voip.video.a.d.UPM;
    com.tencent.mm.plugin.voip.video.a.d.nU(paramInt, i);
    switch (i)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      localObject = SubCoreVoip.hVp();
      if (localObject != null)
      {
        localObject = ((u)localObject).UBF;
        if (localObject != null) {
          ((com.tencent.mm.plugin.voip.a)localObject).apT(paramInt);
        }
      }
      AppMethodBeat.o(263405);
      return;
      paramInt = 0;
      continue;
      paramInt = 180;
      continue;
      paramInt = 90;
      continue;
      paramInt = 270;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(263310);
    super.onResume();
    onOrientationChange(0);
    AppMethodBeat.o(263310);
  }
  
  public final void setupConfiguration(Configuration paramConfiguration)
  {
    AppMethodBeat.i(263335);
    s.u(paramConfiguration, "configuration");
    int i;
    if (aw.isDarkMode())
    {
      i = 32;
      paramConfiguration.uiMode = i;
      paramConfiguration.fontScale = com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext());
      localObject1 = LocaleUtil.getApplicationLanguage();
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label245;
      }
      i = 1;
      label64:
      if (i != 0) {
        break label483;
      }
      s.s(localObject1, "language");
      localObject1 = n.a((CharSequence)localObject1, new char[] { '_' }, 0, 6);
      localObject2 = (String)((List)localObject1).get(0);
      if (((List)localObject1).size() <= 1) {
        break label250;
      }
    }
    Object localObject4;
    label245:
    label250:
    for (Object localObject1 = (String)((List)localObject1).get(1);; localObject1 = "")
    {
      localObject1 = new Locale((String)localObject2, (String)localObject1, "");
      if (Build.VERSION.SDK_INT < 24) {
        break label478;
      }
      localObject2 = paramConfiguration.getLocales();
      s.s(localObject2, "configuration.locales");
      localObject4 = (Iterable)k.qt(0, ((LocaleList)localObject2).size());
      localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(((LocaleList)localObject2).get(((ah)localObject4).Zo()));
      }
      i = 16;
      break;
      i = 0;
      break label64;
    }
    Object localObject3 = (Iterable)localObject3;
    Object localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    label366:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      Locale localLocale = (Locale)localObject4;
      if ((!s.p(localLocale.getLanguage(), ((Locale)localObject1).getLanguage())) && (!s.p(localLocale.getCountry(), ((Locale)localObject1).getCountry()))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label366;
        }
        ((Collection)localObject2).add(localObject4);
        break;
      }
    }
    localObject2 = ((Collection)localObject2).toArray(new Locale[0]);
    if (localObject2 == null)
    {
      paramConfiguration = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(263335);
      throw paramConfiguration;
    }
    localObject2 = (Locale[])localObject2;
    localObject3 = new al(2);
    ((al)localObject3).add(localObject1);
    ((al)localObject3).hx(localObject2);
    paramConfiguration.setLocales(new LocaleList((Locale[])((al)localObject3).toArray(new Locale[((al)localObject3).hqL.size()])));
    AppMethodBeat.o(263335);
    return;
    label478:
    paramConfiguration.locale = ((Locale)localObject1);
    label483:
    AppMethodBeat.o(263335);
  }
  
  public final boolean shouldDestroyEngineWithHost()
  {
    AppMethodBeat.i(263349);
    String str = super.getCachedEngineId();
    if (!this.Hlm)
    {
      AppMethodBeat.o(263349);
      return true;
    }
    if ((str != null) && (FlutterEngineCache.getInstance().get(str) == null))
    {
      AppMethodBeat.o(263349);
      return false;
    }
    boolean bool = super.shouldDestroyEngineWithHost();
    AppMethodBeat.o(263349);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.ui.a
 * JD-Core Version:    0.7.0.1
 */