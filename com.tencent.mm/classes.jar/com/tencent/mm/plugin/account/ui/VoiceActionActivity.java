package com.tencent.mm.plugin.account.ui;

import com.google.android.search.verification.client.SearchActionVerificationClientActivity;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.model.VoiceActionService;
import com.tencent.mm.sdk.platformtools.Log;

public class VoiceActionActivity
  extends SearchActionVerificationClientActivity
{
  public final Class<? extends SearchActionVerificationClientService> XO()
  {
    AppMethodBeat.i(128793);
    Log.d("MicroMsg.VoiceActionActivity", "getServiceClass");
    AppMethodBeat.o(128793);
    return VoiceActionService.class;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.VoiceActionActivity
 * JD-Core Version:    0.7.0.1
 */