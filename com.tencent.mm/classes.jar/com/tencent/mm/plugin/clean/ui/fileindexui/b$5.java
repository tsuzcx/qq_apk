package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class b$5
  extends ak
{
  b$5(b paramb) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(18750);
    if (!b.f(this.kHM)) {
      this.kHM.notifyDataSetChanged();
    }
    AppMethodBeat.o(18750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b.5
 * JD-Core Version:    0.7.0.1
 */