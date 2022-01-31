package com.tencent.mm.plugin.masssend.ui;

import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;

final class b$4
  implements ap.a
{
  b$4(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(22770);
    if (this.oBD.mwM == -1L) {
      this.oBD.mwM = bo.yB();
    }
    long l = bo.av(this.oBD.mwM);
    int i;
    if ((l >= 50000L) && (l <= 60000L))
    {
      if (this.oBD.mwN != null) {
        break label198;
      }
      i = (int)((60000L - l) / 1000L);
      this.oBD.mwN = Toast.makeText(this.oBD.oBv, this.oBD.oBv.getResources().getQuantityString(2131361794, i, new Object[] { Integer.valueOf(i) }), 0);
    }
    for (;;)
    {
      this.oBD.mwN.show();
      if (l < 60000L) {
        break;
      }
      ab.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
      if (this.oBD.oBx.Ez()) {
        this.oBD.bPg();
      }
      this.oBD.oBw.bxy();
      ay.ax(this.oBD.oBv, 2131304298);
      AppMethodBeat.o(22770);
      return false;
      label198:
      i = (int)((60000L - l) / 1000L);
      this.oBD.mwN.setText(this.oBD.oBv.getResources().getQuantityString(2131361794, i, new Object[] { Integer.valueOf(i) }));
    }
    AppMethodBeat.o(22770);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b.4
 * JD-Core Version:    0.7.0.1
 */