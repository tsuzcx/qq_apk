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

public class MMFlutterVideoEditorActivity
  extends HellActivity
  implements LifecycleOwner, a
{
  private LifecycleRegistry crq;
  private boolean qMl;
  private io.flutter.embedding.engine.a wJi;
  boolean wKL;
  private FlutterView wKM;
  private io.flutter.plugin.platform.b wKN;
  
  public MMFlutterVideoEditorActivity()
  {
    AppMethodBeat.i(240966);
    this.crq = new LifecycleRegistry(this);
    AppMethodBeat.o(240966);
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
    AppMethodBeat.i(240974);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().gA(paramInt1, paramInt2);
    AppMethodBeat.o(240974);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(240973);
    ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().fP(this);
    AppMethodBeat.o(240973);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(240967);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF.cMT();
    com.tencent.mm.plugin.recordvideo.res.g.BYp.bbA();
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
    this.wKM = new FlutterView(this, FlutterView.c.SND);
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
    setResult(0);
    AppMethodBeat.o(240967);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(240968);
    super.onDestroy();
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.wKN != null) {
      this.wKN.destroy();
    }
    this.wKN = null;
    ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().onDestroy();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    AppMethodBeat.o(240968);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(240972);
    super.onPause();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onPause %s", new Object[] { Integer.valueOf(hashCode()) });
    ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr();
    AppMethodBeat.o(240972);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(240971);
    super.onResume();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().b(this);
    AppMethodBeat.o(240971);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(240975);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(240975);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(240969);
    super.onStart();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_START);
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onStart %s", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      this.wKN = new io.flutter.plugin.platform.b(this, this.wJi.SOe);
      this.wKM.d(this.wJi);
      this.wJi.SNX.a(this, getLifecycle());
      ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().c(this);
      AppMethodBeat.o(240969);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Flutter.MMBaseFlutterActivity", localException, "onStart", new Object[0]);
      AppMethodBeat.o(240969);
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(240970);
    super.onStop();
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      this.wJi.SNX.hwK();
      ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().d(this);
      ((PluginFlutter)com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr();
      this.wKM.hwy();
      this.crq.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      AppMethodBeat.o(240970);
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
 * Qualified Name:     com.tencent.mm.plugin.flutter.ui.MMFlutterVideoEditorActivity
 * JD-Core Version:    0.7.0.1
 */