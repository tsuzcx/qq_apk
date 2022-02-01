package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.platformtools.ad;

@Deprecated
public class HCETransparentUI
  extends HellActivity
{
  private ResultReceiver JX;
  
  public void finish()
  {
    AppMethodBeat.i(136182);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(136182);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(136179);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.HCETransparentUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a.kbz.rS(paramInt1);
    AppMethodBeat.o(136179);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(136177);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    setContentView(2131494432);
    this.JX = ((ResultReceiver)getIntent().getParcelableExtra("HCE_Result_Receiver"));
    a.kbz.a(this, this.JX);
    a.kbz.resetStatus();
    AppMethodBeat.o(136177);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(136181);
    super.onDestroy();
    AppMethodBeat.o(136181);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(136180);
    super.onPause();
    a.kbz.dismissDialog();
    AppMethodBeat.o(136180);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(136178);
    super.onResume();
    ad.i("MicroMsg.HCETransparentUI", "alvinluo onResume");
    overridePendingTransition(0, 0);
    ComponentName localComponentName = new ComponentName(this, HCEService.class.getCanonicalName());
    a.kbz.b(localComponentName);
    a.kbz.bbc();
    AppMethodBeat.o(136178);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCETransparentUI
 * JD-Core Version:    0.7.0.1
 */