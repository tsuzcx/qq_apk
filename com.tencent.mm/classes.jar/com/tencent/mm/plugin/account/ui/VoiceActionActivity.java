package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import com.google.android.search.verification.client.SearchActionVerificationClientActivity;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.model.VoiceActionService;
import com.tencent.mm.sdk.platformtools.ab;

public class VoiceActionActivity
  extends SearchActionVerificationClientActivity
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final Class<? extends SearchActionVerificationClientService> rx()
  {
    AppMethodBeat.i(125632);
    ab.d("MicroMsg.VoiceActionActivity", "getServiceClass");
    AppMethodBeat.o(125632);
    return VoiceActionService.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.VoiceActionActivity
 * JD-Core Version:    0.7.0.1
 */