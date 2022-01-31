package com.tencent.mm.plugin.fts.ui.widget;

import android.os.Message;
import com.tencent.mm.modelvoiceaddr.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class VoiceInputLayout$1
  extends ah
{
  VoiceInputLayout$1(VoiceInputLayout paramVoiceInputLayout) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0)
    {
      if (paramMessage.what == 1) {
        y.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[] { Integer.valueOf(this.kGd.kFU) });
      }
    }
    else
    {
      y.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[] { Integer.valueOf(this.kGd.kFU) });
      if (this.kGd.kFU == 3) {
        break label75;
      }
    }
    return;
    label75:
    VoiceInputLayout.a(this.kGd).removeMessages(0);
    VoiceInputLayout.a(this.kGd).removeMessages(1);
    if (VoiceInputLayout.b(this.kGd) != null) {
      VoiceInputLayout.b(this.kGd).cancel(true);
    }
    this.kGd.reset(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.1
 * JD-Core Version:    0.7.0.1
 */