package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class f$1$1
  implements a.a
{
  f$1$1(f.1 param1) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108602);
    ab.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString1, paramString2 });
    long l = new p(p.cU(paramString2)).longValue();
    ao localao = ((ap)((a)g.G(a.class)).getQQListStg()).hn(l);
    if ((paramBoolean1) && (localao != null)) {
      localao.username = paramString1;
    }
    if (localao != null)
    {
      localao.fsi = 2;
      ab.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", new Object[] { localao.toString() });
      ((ap)((a)g.G(a.class)).getQQListStg()).a(l, localao);
      this.gzT.gzS.Ku();
    }
    for (;;)
    {
      if ((paramBoolean1) && (localao != null)) {
        f.xp(paramString1);
      }
      AppMethodBeat.o(108602);
      return;
      ab.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", new Object[] { paramString2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.f.1.1
 * JD-Core Version:    0.7.0.1
 */