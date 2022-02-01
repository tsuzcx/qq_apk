package com.tencent.mm.plugin.flutter.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.plugin.flutter.PluginFlutter;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.c;

public class MMFlutterActivity
  extends HellActivity
  implements LifecycleOwner, a
{
  private LifecycleRegistry crq;
  private boolean qMl;
  private io.flutter.embedding.engine.a wJi;
  boolean wKL;
  private FlutterView wKM;
  private io.flutter.plugin.platform.b wKN;
  boolean wKO;
  
  public MMFlutterActivity()
  {
    AppMethodBeat.i(240964);
    this.crq = new LifecycleRegistry(this);
    AppMethodBeat.o(240964);
  }
  
  public final Activity getActivity()
  {
    return this;
  }
  
  public Lifecycle getLifecycle()
  {
    return this.crq;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(148887);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(148887);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(148885);
    ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().fP(this);
    AppMethodBeat.o(148885);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(148876);
    super.onCreate(paramBundle);
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    if (getActionBar() != null) {
      getActionBar().hide();
    }
    getWindow().setStatusBarColor(-16777216);
    getWindow().setNavigationBarColor(-16777216);
    this.qMl = getIntent().getBooleanExtra("first_create", false);
    ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().a(this);
    ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr();
    this.wJi = ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().wJi;
    paramBundle = new FrameLayout(this);
    this.wKO = getIntent().getBooleanExtra("videoEditor", false);
    if (this.wKO)
    {
      com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF.cMT();
      com.tencent.mm.plugin.recordvideo.res.g.BYp.bbA();
      this.wKM = new FlutterView(this, FlutterView.c.SND);
      setResult(0);
    }
    for (;;)
    {
      paramBundle.addView(this.wKM);
      setContentView(paramBundle);
      this.wKL = true;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(1073741824);
        paramBundle.getDecorView().setSystemUiVisibility(1280);
      }
      AppMethodBeat.o(148876);
      return;
      this.wKM = new FlutterView(this);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(148877);
    super.onDestroy();
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.wKN != null) {
      this.wKN.destroy();
    }
    this.wKN = null;
    ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().onDestroy();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    AppMethodBeat.o(148877);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(148881);
    if (!this.wKO) {
      overridePendingTransition(0, 0);
    }
    super.onPause();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onPause %s", new Object[] { Integer.valueOf(hashCode()) });
    ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr();
    AppMethodBeat.o(148881);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(148880);
    super.onResume();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().b(this);
    AppMethodBeat.o(148880);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(240965);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(240965);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(148878);
    super.onStart();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_START);
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onStart %s", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      this.wKN = new io.flutter.plugin.platform.b(this, this.wJi.SOe);
      this.wKM.d(this.wJi);
      this.wJi.SNX.a(this, getLifecycle());
      ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().c(this);
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
      this.wJi.SNX.hwK();
      ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().d(this);
      ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr();
      this.wKM.hwy();
      this.crq.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      AppMethodBeat.o(148879);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Flutter.MMBaseFlutterActivity", localException, "onStop", new Object[0]);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.ui.MMFlutterActivity
 * JD-Core Version:    0.7.0.1
 */