package com.tencent.mm.plugin.flutter.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.lifecycle.h.a;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.plugin.flutter.PluginFlutter;
import com.tencent.mm.plugin.recordvideo.res.g;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.c;

public class MMFlutterVideoEditorActivity
  extends HellActivity
  implements l, a
{
  boolean BCH;
  private FlutterView BCI;
  private io.flutter.plugin.platform.b BCJ;
  private m BCL;
  private io.flutter.embedding.engine.a BCx;
  private boolean unx;
  
  public MMFlutterVideoEditorActivity()
  {
    AppMethodBeat.i(221145);
    this.BCL = new m(this);
    AppMethodBeat.o(221145);
  }
  
  public androidx.lifecycle.h getLifecycle()
  {
    return this.BCL;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(221173);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((PluginFlutter)com.tencent.mm.kernel.h.ag(PluginFlutter.class)).getFlutterEngineMgr().hv(paramInt1, paramInt2);
    AppMethodBeat.o(221173);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(221172);
    ((PluginFlutter)com.tencent.mm.kernel.h.ag(PluginFlutter.class)).getFlutterEngineMgr().gj(this);
    AppMethodBeat.o(221172);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(221154);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.Nzf.dbH();
    g.HVd.bkQ();
    this.BCL.a(h.a.ON_CREATE);
    if (getActionBar() != null) {
      getActionBar().hide();
    }
    getWindow().setStatusBarColor(-16777216);
    getWindow().setNavigationBarColor(-16777216);
    this.unx = getIntent().getBooleanExtra("first_create", false);
    ((PluginFlutter)com.tencent.mm.kernel.h.ag(PluginFlutter.class)).getFlutterEngineMgr().a(this);
    ((PluginFlutter)com.tencent.mm.kernel.h.ag(PluginFlutter.class)).getFlutterEngineMgr();
    this.BCx = ((PluginFlutter)com.tencent.mm.kernel.h.ag(PluginFlutter.class)).getFlutterEngineMgr().BCx;
    paramBundle = new FrameLayout(this);
    this.BCI = new FlutterView(this, FlutterView.c.aapB);
    paramBundle.addView(this.BCI);
    setContentView(paramBundle);
    this.BCH = true;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(1073741824);
      paramBundle.getDecorView().setSystemUiVisibility(1280);
    }
    setResult(0);
    AppMethodBeat.o(221154);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(221159);
    super.onDestroy();
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    if (this.BCJ != null) {
      this.BCJ.destroy();
    }
    this.BCJ = null;
    ((PluginFlutter)com.tencent.mm.kernel.h.ag(PluginFlutter.class)).getFlutterEngineMgr().onDestroy();
    this.BCL.a(h.a.ON_DESTROY);
    AppMethodBeat.o(221159);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(221171);
    super.onPause();
    this.BCL.a(h.a.ON_PAUSE);
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onPause %s", new Object[] { Integer.valueOf(hashCode()) });
    ((PluginFlutter)com.tencent.mm.kernel.h.ag(PluginFlutter.class)).getFlutterEngineMgr();
    AppMethodBeat.o(221171);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(221167);
    super.onResume();
    this.BCL.a(h.a.ON_RESUME);
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    ((PluginFlutter)com.tencent.mm.kernel.h.ag(PluginFlutter.class)).getFlutterEngineMgr().b(this);
    AppMethodBeat.o(221167);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(221174);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(221174);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(221163);
    super.onStart();
    this.BCL.a(h.a.ON_START);
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onStart %s", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      this.BCJ = new io.flutter.plugin.platform.b(this, this.BCx.aaqd);
      this.BCI.d(this.BCx);
      this.BCx.aapV.a(this, getLifecycle());
      ((PluginFlutter)com.tencent.mm.kernel.h.ag(PluginFlutter.class)).getFlutterEngineMgr().c(this);
      AppMethodBeat.o(221163);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Flutter.MMBaseFlutterActivity", localException, "onStart", new Object[0]);
      AppMethodBeat.o(221163);
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(221165);
    super.onStop();
    Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      this.BCx.aapV.iAO();
      ((PluginFlutter)com.tencent.mm.kernel.h.ag(PluginFlutter.class)).getFlutterEngineMgr().d(this);
      ((PluginFlutter)com.tencent.mm.kernel.h.ag(PluginFlutter.class)).getFlutterEngineMgr();
      this.BCI.iAm();
      this.BCL.a(h.a.ON_STOP);
      AppMethodBeat.o(221165);
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