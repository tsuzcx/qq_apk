package com.tencent.mm.plugin.fts.ui.widget;

import com.tencent.mm.modelvoiceaddr.b;
import com.tencent.mm.sdk.platformtools.am.a;

final class VoiceInputLayout$4
  implements am.a
{
  VoiceInputLayout$4(VoiceInputLayout paramVoiceInputLayout) {}
  
  public final boolean tC()
  {
    if (VoiceInputLayout.b(this.kGd) == null) {}
    int i;
    do
    {
      return true;
      i = VoiceInputLayout.b(this.kGd).getMaxAmplitudeRate();
    } while (this.kGd.kFU != 2);
    this.kGd.rH(i);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.4
 * JD-Core Version:    0.7.0.1
 */