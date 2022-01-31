package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class GoogleFriendUI$3
  implements a.a
{
  GoogleFriendUI$3(GoogleFriendUI paramGoogleFriendUI) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    y.d("MicroMsg.GoogleContact.GoogleFriendUI", "MicroMsg.AddContact ok:%b hasSentVerify:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if ((paramBoolean1) || (paramBoolean2))
    {
      y.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[] { paramString2 });
      ((o)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).ab(paramString2, 1);
    }
    for (;;)
    {
      GoogleFriendUI.a(this.fdH).yc();
      return;
      ((o)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).ab(paramString2, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.3
 * JD-Core Version:    0.7.0.1
 */