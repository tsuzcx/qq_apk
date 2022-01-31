package com.tencent.mm.plugin.clean.ui.newui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class b$4
  extends ak
{
  b$4(b paramb) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(18850);
    if (!b.b(this.kJe)) {
      this.kJe.notifyDataSetChanged();
    }
    AppMethodBeat.o(18850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.b.4
 * JD-Core Version:    0.7.0.1
 */