package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.sdk.platformtools.y;

final class e$1$1
  implements g.a
{
  e$1$1(e.1 param1) {}
  
  public final void c(boolean paramBoolean, String paramString)
  {
    paramString = ((ap)((a)g.t(a.class)).getQQListStg()).cr(o.bS(paramString));
    if (paramString != null)
    {
      paramString.ebQ = 2;
      y.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", new Object[] { paramString.toString() });
      ((ap)((a)g.t(a.class)).getQQListStg()).a(paramString.fgW, paramString);
      this.fif.fie.yc();
      return;
    }
    y.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e.1.1
 * JD-Core Version:    0.7.0.1
 */