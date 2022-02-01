package com.tencent.mm.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.platformtools.ad;

final class ac
  extends HellActivity
{
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(160031);
    super.onCreate(paramBundle);
    ad.i("WxSplash.SuicideHackActivity", "onCreate");
    finish();
    AppMethodBeat.o(160031);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.ac
 * JD-Core Version:    0.7.0.1
 */