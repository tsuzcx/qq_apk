package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import com.google.android.search.verification.client.SearchActionVerificationClientActivity;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.model.VoiceActionService;
import com.tencent.mm.sdk.platformtools.ac;

public class VoiceActionActivity
  extends SearchActionVerificationClientActivity
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final Class<? extends SearchActionVerificationClientService> wk()
  {
    AppMethodBeat.i(128793);
    ac.d("MicroMsg.VoiceActionActivity", "getServiceClass");
    AppMethodBeat.o(128793);
    return VoiceActionService.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.VoiceActionActivity
 * JD-Core Version:    0.7.0.1
 */