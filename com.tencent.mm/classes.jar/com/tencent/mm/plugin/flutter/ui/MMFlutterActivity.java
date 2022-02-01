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
import com.tencent.mm.sdk.platformtools.ae;
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
  private boolean pwU;
  boolean ttA;
  private io.flutter.embedding.engine.a tti;
  private FlutterView ttx;
  private ImageView tty;
  private FrameLayout ttz;
  
  public final void cSU()
  {
    AppMethodBeat.i(148882);
    this.tty.setVisibility(8);
    AppMethodBeat.o(148882);
  }
  
  public final void cSV()
  {
    AppMethodBeat.i(148886);
    if (this.ttA)
    {
      if (!this.pwU)
      {
        Bitmap localBitmap = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().tti.MYh.MZl.getBitmap();
        this.tty.setImageBitmap(localBitmap);
        this.tty.setVisibility(0);
        ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().cSQ();
      }
      finish();
      AppMethodBeat.o(148886);
      return;
    }
    ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().cSQ();
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
  
  public final void mK(boolean paramBoolean)
  {
    AppMethodBeat.i(148883);
    this.ttA = paramBoolean;
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
    cSV();
    AppMethodBeat.o(148885);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(148876);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.pwU = getIntent().getBooleanExtra("first_create", false);
    int i = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().ttn.incrementAndGet();
    ae.i("MicroMsg.Flutter.FlutterEngineMgr", "onCreate %s InstanceCount %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i) });
    this.tti = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().tti;
    this.ttz = ((FrameLayout)findViewById(2131300142));
    this.tty = ((ImageView)findViewById(2131300143));
    this.tty.setVisibility(8);
    this.ttx = new FlutterView(this);
    this.ttz.addView(this.ttx);
    this.ttA = true;
    AppMethodBeat.o(148876);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(148877);
    super.onDestroy();
    ae.i("MicroMsg.Flutter.MMFlutterActivity", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().onDestroy();
    AppMethodBeat.o(148877);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(148881);
    super.onPause();
    ae.i("MicroMsg.Flutter.MMFlutterActivity", "onPause %s", new Object[] { Integer.valueOf(hashCode()) });
    ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr();
    AppMethodBeat.o(148881);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(148880);
    super.onResume();
    ae.i("MicroMsg.Flutter.MMFlutterActivity", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flutter.b.a locala = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr();
    if (equals(locala.ttj)) {
      locala.tti.MZp.gjB();
    }
    AppMethodBeat.o(148880);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(148878);
    super.onStart();
    ae.i("MicroMsg.Flutter.MMFlutterActivity", "onStart %s", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      this.ttx.c(this.tti);
      com.tencent.mm.plugin.flutter.b.a locala = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr();
      locala.ttj = this;
      locala.tti.MZp.gjA();
      AppMethodBeat.o(148878);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Flutter.MMFlutterActivity", localException, "onStart", new Object[0]);
      AppMethodBeat.o(148878);
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(148879);
    super.onStop();
    ae.i("MicroMsg.Flutter.MMFlutterActivity", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      com.tencent.mm.plugin.flutter.b.a locala = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr();
      if (locala.ttj.equals(this))
      {
        locala.tti.MZp.gjC();
        locala.ttj = null;
      }
      this.ttx.giZ();
      AppMethodBeat.o(148879);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Flutter.MMFlutterActivity", localException, "onStop", new Object[0]);
      AppMethodBeat.o(148879);
    }
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(148884);
    super.onSwipeBack();
    if (!this.pwU) {
      ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().cSQ();
    }
    AppMethodBeat.o(148884);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.ui.MMFlutterActivity
 * JD-Core Version:    0.7.0.1
 */