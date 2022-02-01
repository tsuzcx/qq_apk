package com.tencent.mm.plugin.flutter.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.flutter.PluginFlutter;
import com.tencent.mm.plugin.flutter.b.c;
import com.tencent.mm.plugin.flutter.b.c.4;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.a.m;
import kotlin.g.a.r;

public class MMFlutterActivity
  extends HellActivity
  implements q, b
{
  boolean Hlp;
  boolean Hlq;
  private boolean Hlr;
  private FlutterEngine flutterEngine;
  private FlutterView flutterView;
  private s lifecycle;
  private PlatformPlugin platformPlugin;
  private boolean xtT;
  
  public MMFlutterActivity()
  {
    AppMethodBeat.i(263286);
    this.lifecycle = new s(this);
    AppMethodBeat.o(263286);
  }
  
  public final Activity getActivity()
  {
    return this;
  }
  
  public j getLifecycle()
  {
    return this.lifecycle;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(148887);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr().iQ(paramInt1, paramInt2);
    AppMethodBeat.o(148887);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(148885);
    c localc = ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr();
    if (localc.Hkp == null)
    {
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onBackPressed error. platformChannel is null.");
      ((Activity)this).finish();
      AppMethodBeat.o(148885);
      return;
    }
    localc.Hkp.invokeMethod("canPop", null, new c.4(localc, this));
    AppMethodBeat.o(148885);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(148876);
    super.onCreate(paramBundle);
    this.lifecycle.a(j.a.ON_CREATE);
    if (getActionBar() != null) {
      getActionBar().hide();
    }
    getWindow().setStatusBarColor(-16777216);
    getWindow().setNavigationBarColor(-16777216);
    this.xtT = getIntent().getBooleanExtra("first_create", false);
    this.Hlr = getIntent().getBooleanExtra("kee_engine", false);
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "keepEngine:%s", new Object[] { Boolean.valueOf(this.Hlr) });
    ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr().vD(this.Hlr);
    paramBundle = ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr();
    int i = paramBundle.Hko.incrementAndGet();
    paramBundle.Hkl = this;
    paramBundle.Hkm = getActivity();
    Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onCreate %s InstanceCount %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i) });
    ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr();
    this.flutterEngine = ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr().flutterEngine;
    paramBundle = new FrameLayout(this);
    this.Hlq = getIntent().getBooleanExtra("videoEditor", false);
    if (this.Hlq)
    {
      this.flutterView = new FlutterView(this, FlutterView.TransparencyMode.transparent);
      setResult(0);
    }
    for (;;)
    {
      paramBundle.addView(this.flutterView);
      setContentView(paramBundle);
      this.Hlp = true;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(1073741824);
        paramBundle.getDecorView().setSystemUiVisibility(1280);
      }
      if (Build.VERSION.SDK_INT >= 28)
      {
        paramBundle = getWindow().getAttributes();
        paramBundle.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(paramBundle);
      }
      AppMethodBeat.o(148876);
      return;
      this.flutterView = new FlutterView(this);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(148877);
    super.onDestroy();
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.platformPlugin != null) {
      this.platformPlugin.destroy();
    }
    this.platformPlugin = null;
    ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr().onDestroy();
    this.lifecycle.a(j.a.ON_DESTROY);
    AppMethodBeat.o(148877);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(263303);
    c localc = ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr();
    if (localc.Hkq == null) {}
    for (boolean bool = false; bool; bool = ((Boolean)localc.Hkq.invoke(Integer.valueOf(paramInt), paramKeyEvent)).booleanValue())
    {
      AppMethodBeat.o(263303);
      return true;
    }
    bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(263303);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(148881);
    super.onPause();
    if (!((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr().Hks)
    {
      if (!this.Hlq) {
        overridePendingTransition(0, 0);
      }
      this.lifecycle.a(j.a.ON_PAUSE);
      Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onPause %s", new Object[] { Integer.valueOf(hashCode()) });
      c localc = ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr();
      if ((localc.flutterEngine != null) && (equals(localc.Hkl))) {
        localc.flutterEngine.getLifecycleChannel().appIsPaused();
      }
    }
    AppMethodBeat.o(148881);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(263373);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(263373);
      return;
    }
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    c localc = ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr();
    localc.Hkr.a(this, Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), paramArrayOfString[0]);
    localc.Hkr = null;
    localc.Hks = false;
    AppMethodBeat.o(263373);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(148880);
    super.onResume();
    this.lifecycle.a(j.a.ON_RESUME);
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    c localc = ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr();
    if ((localc.flutterEngine != null) && (equals(localc.Hkl))) {
      localc.flutterEngine.getLifecycleChannel().appIsResumed();
    }
    AppMethodBeat.o(148880);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(263396);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(263396);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(148878);
    super.onStart();
    this.lifecycle.a(j.a.ON_START);
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onStart %s", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      if (this.flutterEngine == null) {
        this.flutterEngine = ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr().flutterEngine;
      }
      this.platformPlugin = new PlatformPlugin(this, this.flutterEngine.getPlatformChannel());
      this.flutterView.attachToFlutterEngine(this.flutterEngine);
      this.flutterEngine.getActivityControlSurface().attachToActivity(this, getLifecycle());
      c localc = ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr();
      localc.Hkl = this;
      if (localc.flutterEngine != null) {
        localc.flutterEngine.getLifecycleChannel().appIsInactive();
      }
      AppMethodBeat.o(148878);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Flutter.MMBaseFlutterActivity", localException, "onStart", new Object[0]);
      AppMethodBeat.o(148878);
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(148879);
    super.onStop();
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      this.flutterEngine.getActivityControlSurface().detachFromActivity();
      c localc = ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr();
      Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onStop");
      if ((localc.flutterEngine != null) && (localc.Hkl.equals(this)))
      {
        localc.flutterEngine.getLifecycleChannel().appIsPaused();
        localc.Hkl = null;
      }
      ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr();
      this.flutterView.detachFromFlutterEngine();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Flutter.MMBaseFlutterActivity", localException, "onStop", new Object[0]);
      }
    }
    this.lifecycle.a(j.a.ON_STOP);
    AppMethodBeat.o(148879);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(263317);
    if (Build.VERSION.SDK_INT == 26) {
      try
      {
        super.setRequestedOrientation(paramInt);
        AppMethodBeat.o(263317);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.Flutter.MMBaseFlutterActivity", "setRequestedOrientation() couldn't be called successfully");
        AppMethodBeat.o(263317);
        return;
      }
    }
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(263317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.ui.MMFlutterActivity
 * JD-Core Version:    0.7.0.1
 */