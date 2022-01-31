package com.tencent.mm.plugin.fts.ui.widget;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class VoiceInputLayout$3
  extends ah
{
  VoiceInputLayout$3(VoiceInputLayout paramVoiceInputLayout) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.kGd.aWX();
      return;
    }
    paramMessage = paramMessage.getData();
    this.kGd.I(paramMessage.getInt("localCode"), paramMessage.getInt("errType"), paramMessage.getInt("errCode"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.3
 * JD-Core Version:    0.7.0.1
 */