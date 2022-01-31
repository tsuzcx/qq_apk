package com.tencent.mm.plugin.emojicapture.e;

import a.l;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b;
import com.tencent.mm.ui.base.t;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class c$c
  implements Runnable
{
  c$c(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(2767);
    c.h(this.lww).boS();
    t.makeText(c.f(this.lww), 2131299142, 0).show();
    this.lww.resume();
    AppMethodBeat.o(2767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.c.c
 * JD-Core Version:    0.7.0.1
 */