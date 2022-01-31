package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@Deprecated
public class HCETransparentUI
  extends Activity
{
  private ResultReceiver Di;
  
  public void finish()
  {
    AppMethodBeat.i(141923);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(141923);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(137931);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.HCETransparentUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a.hUM.oi(paramInt1);
    AppMethodBeat.o(137931);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(137929);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    setContentView(2130969855);
    this.Di = ((ResultReceiver)getIntent().getParcelableExtra("HCE_Result_Receiver"));
    a.hUM.a(this, this.Di);
    a.hUM.aEa();
    AppMethodBeat.o(137929);
  }
  
  protected void onDestroy()
  {
    AppMethodBeat.i(137933);
    super.onDestroy();
    AppMethodBeat.o(137933);
  }
  
  protected void onPause()
  {
    AppMethodBeat.i(137932);
    super.onPause();
    a.hUM.dismissDialog();
    AppMethodBeat.o(137932);
  }
  
  protected void onResume()
  {
    AppMethodBeat.i(137930);
    super.onResume();
    ab.i("MicroMsg.HCETransparentUI", "alvinluo onResume");
    overridePendingTransition(0, 0);
    ComponentName localComponentName = new ComponentName(this, HCEService.class.getCanonicalName());
    a.hUM.b(localComponentName);
    a.hUM.aDZ();
    AppMethodBeat.o(137930);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCETransparentUI
 * JD-Core Version:    0.7.0.1
 */