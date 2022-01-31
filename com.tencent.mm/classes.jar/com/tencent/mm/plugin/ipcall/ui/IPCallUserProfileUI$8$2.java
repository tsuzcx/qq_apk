package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.ui.e.b;

final class IPCallUserProfileUI$8$2
  implements a.b
{
  IPCallUserProfileUI$8$2(IPCallUserProfileUI.8 param8) {}
  
  public final boolean wU(String paramString)
  {
    AppMethodBeat.i(22379);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", IPCallUserProfileUI.c(this.nWU.nWR));
    localIntent.putExtra("Contact_Scene", 13);
    localIntent.putExtra(e.b.yUZ, paramString);
    d.b(this.nWU.nWR, "profile", ".ui.SayHiWithSnsPermissionUI", localIntent);
    AppMethodBeat.o(22379);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.8.2
 * JD-Core Version:    0.7.0.1
 */