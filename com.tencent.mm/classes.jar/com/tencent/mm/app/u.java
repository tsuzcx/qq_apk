package com.tencent.mm.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class u
  extends Activity
{
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(137942);
    super.onCreate(paramBundle);
    ab.i("WxSplash.SuicideHackActivity", "onCreate");
    finish();
    AppMethodBeat.o(137942);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.u
 * JD-Core Version:    0.7.0.1
 */