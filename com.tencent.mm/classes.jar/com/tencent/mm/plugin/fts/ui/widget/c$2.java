package com.tencent.mm.plugin.fts.ui.widget;

import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class c$2
  implements VoiceInputLayout.a
{
  c$2(c paramc) {}
  
  public final void bDz()
  {
    AppMethodBeat.i(62177);
    c localc = this.nbY;
    if (localc.nbU != null) {
      localc.nbU.cancel();
    }
    localc.nbU = Toast.makeText(localc.cmc, localc.cmc.getResources().getString(2131300245), 0);
    localc.nbU.setGravity(17, 0, 0);
    localc.nbU.show();
    this.nbY.nbL.a(true, false, "");
    AppMethodBeat.o(62177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.c.2
 * JD-Core Version:    0.7.0.1
 */