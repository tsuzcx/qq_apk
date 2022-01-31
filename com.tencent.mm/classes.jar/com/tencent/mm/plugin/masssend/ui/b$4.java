package com.tencent.mm.plugin.masssend.ui;

import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$4
  implements am.a
{
  b$4(b paramb) {}
  
  public final boolean tC()
  {
    if (this.mbb.ibp == -1L) {
      this.mbb.ibp = bk.UZ();
    }
    long l = bk.cp(this.mbb.ibp);
    int i;
    if ((l >= 50000L) && (l <= 60000L))
    {
      if (this.mbb.ibq != null) {
        break label188;
      }
      i = (int)((60000L - l) / 1000L);
      this.mbb.ibq = Toast.makeText(this.mbb.maU, this.mbb.maU.getResources().getQuantityString(R.j.chatting_rcd_time_limit, i, new Object[] { Integer.valueOf(i) }), 0);
    }
    for (;;)
    {
      this.mbb.ibq.show();
      if (l < 60000L) {
        break;
      }
      y.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
      if (this.mbb.maW.un()) {
        this.mbb.bhg();
      }
      this.mbb.maV.aRj();
      au.G(this.mbb.maU, R.l.time_limit);
      return false;
      label188:
      i = (int)((60000L - l) / 1000L);
      this.mbb.ibq.setText(this.mbb.maU.getResources().getQuantityString(R.j.chatting_rcd_time_limit, i, new Object[] { Integer.valueOf(i) }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b.4
 * JD-Core Version:    0.7.0.1
 */