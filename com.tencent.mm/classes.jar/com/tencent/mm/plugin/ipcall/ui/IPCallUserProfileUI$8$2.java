package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.ui.e.a;

final class IPCallUserProfileUI$8$2
  implements a.b
{
  IPCallUserProfileUI$8$2(IPCallUserProfileUI.8 param8) {}
  
  public final boolean pE(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", IPCallUserProfileUI.c(this.lzI.lzF));
    localIntent.putExtra("Contact_Scene", 13);
    localIntent.putExtra(e.a.uHO, paramString);
    d.b(this.lzI.lzF, "profile", ".ui.SayHiWithSnsPermissionUI", localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.8.2
 * JD-Core Version:    0.7.0.1
 */