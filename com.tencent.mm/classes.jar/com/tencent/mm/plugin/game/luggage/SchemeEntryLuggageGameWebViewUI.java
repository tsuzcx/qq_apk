package com.tencent.mm.plugin.game.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class SchemeEntryLuggageGameWebViewUI
  extends LuggageGameWebViewMpUI
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(276936);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.SchemeEntryLuggageGameWebViewUI", "onCreate");
    AppMethodBeat.o(276936);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.SchemeEntryLuggageGameWebViewUI
 * JD-Core Version:    0.7.0.1
 */