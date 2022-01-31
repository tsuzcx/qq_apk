package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class e$1$2
  implements a.a
{
  e$1$2(e.1 param1) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    y.i("MicroMsg.QQFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString1, paramString2 });
    long l = new o(o.bS(paramString2)).longValue();
    ao localao = ((ap)((a)g.t(a.class)).getQQListStg()).cr(l);
    if ((localao != null) && (paramBoolean1)) {
      localao.username = paramString1;
    }
    if (localao != null)
    {
      localao.ebQ = 2;
      y.d("MicroMsg.QQFriendAdapter", "f :%s", new Object[] { localao.toString() });
      ((ap)((a)g.t(a.class)).getQQListStg()).a(l, localao);
      this.fif.fie.yc();
    }
    for (;;)
    {
      if ((paramBoolean1) && (localao != null)) {
        e.pT(paramString1);
      }
      return;
      y.w("MicroMsg.QQFriendAdapter", "cpan qq friend is null. qq:%s", new Object[] { paramString2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e.1.2
 * JD-Core Version:    0.7.0.1
 */