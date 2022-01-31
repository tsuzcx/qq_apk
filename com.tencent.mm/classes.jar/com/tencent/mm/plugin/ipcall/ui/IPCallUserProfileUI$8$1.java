package com.tencent.mm.plugin.ipcall.ui;

import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class IPCallUserProfileUI$8$1
  implements a.a
{
  IPCallUserProfileUI$8$1(IPCallUserProfileUI.8 param8) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    y.d("MicroMsg.IPCallUserProfileUI", "canAddContact, ok: %b, hasSentVerify: %b, respUsername: %s, itemID: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString1, paramString2 });
    if (paramBoolean1)
    {
      IPCallUserProfileUI.a(this.lzI.lzF).setVisibility(8);
      IPCallUserProfileUI.b(this.lzI.lzF).setVisibility(8);
      IPCallUserProfileUI.b(this.lzI.lzF, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.8.1
 * JD-Core Version:    0.7.0.1
 */