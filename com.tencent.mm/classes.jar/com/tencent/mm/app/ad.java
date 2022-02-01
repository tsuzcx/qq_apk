package com.tencent.mm.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

final class ad
  extends HellActivity
{
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(160031);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ad.i("WxSplash.SuicideHackActivity", "onCreate");
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
 * Qualified Name:     com.tencent.mm.app.ad
 * JD-Core Version:    0.7.0.1
 */