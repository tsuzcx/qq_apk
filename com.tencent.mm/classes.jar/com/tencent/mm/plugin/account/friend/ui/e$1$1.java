package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1$1
  implements g.a
{
  e$1$1(e.1 param1) {}
  
  public final void f(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(108587);
    paramString = ((ap)((a)g.G(a.class)).getQQListStg()).hn(p.cU(paramString));
    if (paramString != null)
    {
      paramString.fsi = 2;
      ab.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", new Object[] { paramString.toString() });
      ((ap)((a)g.G(a.class)).getQQListStg()).a(paramString.gyE, paramString);
      this.gzM.gzL.Ku();
      AppMethodBeat.o(108587);
      return;
    }
    ab.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", new Object[] { paramString });
    AppMethodBeat.o(108587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e.1.1
 * JD-Core Version:    0.7.0.1
 */