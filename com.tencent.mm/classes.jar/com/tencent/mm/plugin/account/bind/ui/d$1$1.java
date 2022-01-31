package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bt;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class d$1$1
  implements a.a
{
  d$1$1(d.1 param1) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    y.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString1, paramString2 });
    com.tencent.mm.plugin.account.friend.a.a locala = ((b)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pI(paramString2);
    if (locala != null)
    {
      if (paramBoolean1)
      {
        locala.username = paramString1;
        locala.status = 2;
        locala.ebQ = 2;
        y.d("MicroMsg.MobileFriendAdapter", "f :%s", new Object[] { locala.toString() });
        ((b)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(paramString2, locala);
        this.fef.fed.yc();
        bt.If().d(26, new Object[0]);
      }
      return;
    }
    y.w("MicroMsg.MobileFriendAdapter", "cpan mobile friend is null. qq:%s", new Object[] { paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.d.1.1
 * JD-Core Version:    0.7.0.1
 */