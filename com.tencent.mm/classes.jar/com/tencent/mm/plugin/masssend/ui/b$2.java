package com.tencent.mm.plugin.masssend.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;

final class b$2
  implements j.a
{
  b$2(b paramb) {}
  
  public final void onError()
  {
    AppMethodBeat.i(22768);
    this.oBD.oBx.reset();
    this.oBD.gcG.stopTimer();
    this.oBD.mwY.stopTimer();
    aj.apl("keep_app_silent");
    this.oBD.oBw.bxy();
    ab.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
    Toast.makeText(this.oBD.oBv, this.oBD.oBv.getString(2131298285), 0).show();
    AppMethodBeat.o(22768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b.2
 * JD-Core Version:    0.7.0.1
 */