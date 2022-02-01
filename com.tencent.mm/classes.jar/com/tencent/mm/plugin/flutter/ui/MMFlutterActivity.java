package com.tencent.mm.plugin.flutter.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.flutter.PluginFlutter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.c.c;
import java.util.concurrent.atomic.AtomicInteger;

public class MMFlutterActivity
  extends MMActivity
  implements a
{
  private boolean pqo;
  private FlutterView tiF;
  private ImageView tiG;
  private FrameLayout tiH;
  boolean tiI;
  private io.flutter.embedding.engine.a tiq;
  
  public final void cQp()
  {
    AppMethodBeat.i(148882);
    this.tiG.setVisibility(8);
    AppMethodBeat.o(148882);
  }
  
  public final void cQq()
  {
    AppMethodBeat.i(148886);
    if (this.tiI)
    {
      if (!this.pqo)
      {
        Bitmap localBitmap = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().tiq.MBc.MCg.getBitmap();
        this.tiG.setImageBitmap(localBitmap);
        this.tiG.setVisibility(0);
        ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().cQl();
      }
      finish();
      AppMethodBeat.o(148886);
      return;
    }
    ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().cQl();
    AppMethodBeat.o(148886);
  }
  
  public final MMActivity getActivity()
  {
    return this;
  }
  
  public int getLayoutId()
  {
    return 2131494144;
  }
  
  public final void mG(boolean paramBoolean)
  {
    AppMethodBeat.i(148883);
    this.tiI = paramBoolean;
    getSwipeBackLayout().setEnableGesture(paramBoolean);
    AppMethodBeat.o(148883);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(148887);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(148887);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(148885);
    cQq();
    AppMethodBeat.o(148885);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(148876);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.pqo = getIntent().getBooleanExtra("first_create", false);
    int i = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().tiv.incrementAndGet();
    ad.i("MicroMsg.Flutter.FlutterEngineMgr", "onCreate %s InstanceCount %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i) });
    this.tiq = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().tiq;
    this.tiH = ((FrameLayout)findViewById(2131300142));
    this.tiG = ((ImageView)findViewById(2131300143));
    this.tiG.setVisibility(8);
    this.tiF = new FlutterView(this);
    this.tiH.addView(this.tiF);
    this.tiI = true;
    AppMethodBeat.o(148876);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(148877);
    super.onDestroy();
    ad.i("MicroMsg.Flutter.MMFlutterActivity", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().onDestroy();
    AppMethodBeat.o(148877);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(148881);
    super.onPause();
    ad.i("MicroMsg.Flutter.MMFlutterActivity", "onPause %s", new Object[] { Integer.valueOf(hashCode()) });
    ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr();
    AppMethodBeat.o(148881);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(148880);
    super.onResume();
    ad.i("MicroMsg.Flutter.MMFlutterActivity", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flutter.b.a locala = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr();
    if (equals(locala.tir)) {
      locala.tiq.MCk.geZ();
    }
    AppMethodBeat.o(148880);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(148878);
    super.onStart();
    ad.i("MicroMsg.Flutter.MMFlutterActivity", "onStart %s", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      this.tiF.c(this.tiq);
      com.tencent.mm.plugin.flutter.b.a locala = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr();
      locala.tir = this;
      locala.tiq.MCk.geY();
      AppMethodBeat.o(148878);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Flutter.MMFlutterActivity", localException, "onStart", new Object[0]);
      AppMethodBeat.o(148878);
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(148879);
    super.onStop();
    ad.i("MicroMsg.Flutter.MMFlutterActivity", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      com.tencent.mm.plugin.flutter.b.a locala = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr();
      if (locala.tir.equals(this))
      {
        locala.tiq.MCk.gfa();
        locala.tir = null;
      }
      this.tiF.gex();
      AppMethodBeat.o(148879);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Flutter.MMFlutterActivity", localException, "onStop", new Object[0]);
      AppMethodBeat.o(148879);
    }
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(148884);
    super.onSwipeBack();
    if (!this.pqo) {
      ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().cQl();
    }
    AppMethodBeat.o(148884);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.ui.MMFlutterActivity
 * JD-Core Version:    0.7.0.1
 */