package com.tencent.mm.plugin.masssend.ui;

import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.j.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements j.a
{
  b$2(b paramb) {}
  
  public final void onError()
  {
    this.mbb.maW.reset();
    this.mbb.eNb.stopTimer();
    this.mbb.ibI.stopTimer();
    ag.Zn("keep_app_silent");
    this.mbb.maV.aRj();
    y.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
    Toast.makeText(this.mbb.maU, this.mbb.maU.getString(R.l.chatting_rcd_err), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b.2
 * JD-Core Version:    0.7.0.1
 */