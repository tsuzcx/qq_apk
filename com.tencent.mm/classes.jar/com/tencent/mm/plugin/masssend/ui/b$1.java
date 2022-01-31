package com.tencent.mm.plugin.masssend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ap.a;

final class b$1
  implements ap.a
{
  b$1(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(22767);
    this.oBD.oBw.Mj(this.oBD.oBx.getMaxAmplitude());
    AppMethodBeat.o(22767);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b.1
 * JD-Core Version:    0.7.0.1
 */