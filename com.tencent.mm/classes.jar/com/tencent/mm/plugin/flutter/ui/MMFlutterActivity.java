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
import com.tencent.mm.sdk.platformtools.ac;
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
  private boolean oMG;
  private io.flutter.embedding.engine.a slN;
  private FlutterView smb;
  private ImageView smc;
  private FrameLayout smd;
  boolean sme;
  
  public final void cIa()
  {
    AppMethodBeat.i(148882);
    this.smc.setVisibility(8);
    AppMethodBeat.o(148882);
  }
  
  public final void cIb()
  {
    AppMethodBeat.i(148886);
    if (this.sme)
    {
      if (!this.oMG)
      {
        Bitmap localBitmap = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().slN.KKo.KLj.getBitmap();
        this.smc.setImageBitmap(localBitmap);
        this.smc.setVisibility(0);
        ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().cHW();
      }
      finish();
      AppMethodBeat.o(148886);
      return;
    }
    ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().cHW();
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
  
  public final void mp(boolean paramBoolean)
  {
    AppMethodBeat.i(148883);
    this.sme = paramBoolean;
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
    cIb();
    AppMethodBeat.o(148885);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(148876);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.oMG = getIntent().getBooleanExtra("first_create", false);
    int i = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().slS.incrementAndGet();
    ac.i("MicroMsg.Flutter.FlutterEngineMgr", "onCreate %s InstanceCount %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i) });
    this.slN = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().slN;
    this.smd = ((FrameLayout)findViewById(2131300142));
    this.smc = ((ImageView)findViewById(2131300143));
    this.smc.setVisibility(8);
    this.smb = new FlutterView(this);
    this.smd.addView(this.smb);
    this.sme = true;
    AppMethodBeat.o(148876);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(148877);
    super.onDestroy();
    ac.i("MicroMsg.Flutter.MMFlutterActivity", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().onDestroy();
    AppMethodBeat.o(148877);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(148881);
    super.onPause();
    ac.i("MicroMsg.Flutter.MMFlutterActivity", "onPause %s", new Object[] { Integer.valueOf(hashCode()) });
    ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr();
    AppMethodBeat.o(148881);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(148880);
    super.onResume();
    ac.i("MicroMsg.Flutter.MMFlutterActivity", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.plugin.flutter.b.a locala = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr();
    if (equals(locala.slO)) {
      locala.slN.KLn.fNA();
    }
    AppMethodBeat.o(148880);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(148878);
    super.onStart();
    ac.i("MicroMsg.Flutter.MMFlutterActivity", "onStart %s", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      this.smb.c(this.slN);
      com.tencent.mm.plugin.flutter.b.a locala = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr();
      locala.slO = this;
      locala.slN.KLn.fNz();
      AppMethodBeat.o(148878);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Flutter.MMFlutterActivity", localException, "onStart", new Object[0]);
      AppMethodBeat.o(148878);
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(148879);
    super.onStop();
    ac.i("MicroMsg.Flutter.MMFlutterActivity", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      com.tencent.mm.plugin.flutter.b.a locala = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr();
      if (locala.slO.equals(this))
      {
        locala.slN.KLn.fNB();
        locala.slO = null;
      }
      this.smb.fMX();
      AppMethodBeat.o(148879);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Flutter.MMFlutterActivity", localException, "onStop", new Object[0]);
      AppMethodBeat.o(148879);
    }
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(148884);
    super.onSwipeBack();
    if (!this.oMG) {
      ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().cHW();
    }
    AppMethodBeat.o(148884);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.ui.MMFlutterActivity
 * JD-Core Version:    0.7.0.1
 */