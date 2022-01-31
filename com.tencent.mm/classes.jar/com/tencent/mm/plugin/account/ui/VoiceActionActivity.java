package com.tencent.mm.plugin.account.ui;

import com.google.android.search.verification.client.SearchActionVerificationClientActivity;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.mm.plugin.account.model.VoiceActionService;
import com.tencent.mm.sdk.platformtools.y;

public class VoiceActionActivity
  extends SearchActionVerificationClientActivity
{
  public final Class<? extends SearchActionVerificationClientService> oz()
  {
    y.d("MicroMsg.VoiceActionActivity", "getServiceClass");
    return VoiceActionService.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.VoiceActionActivity
 * JD-Core Version:    0.7.0.1
 */