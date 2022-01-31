package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class e$2
  implements a.a
{
  e$2(e parame) {}
  
  public final void X(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(108591);
    if (paramBoolean)
    {
      ao localao = ((ap)((a)g.G(a.class)).getQQListStg()).xn(paramString);
      if (localao == null) {
        break label109;
      }
      localao.aqS();
      ab.d("MicroMsg.QQFriendAdapter", "user " + paramString + " qq " + localao.gyE);
      ((ap)((a)g.G(a.class)).getQQListStg()).a(localao.gyE, localao);
    }
    for (;;)
    {
      this.gzL.notifyDataSetChanged();
      AppMethodBeat.o(108591);
      return;
      label109:
      ab.w("MicroMsg.QQFriendAdapter", "[cpan] dealFail failed. qqlist is null. username is :%s", new Object[] { String.valueOf(paramString) });
    }
  }
  
  public final void xo(String paramString)
  {
    AppMethodBeat.i(108590);
    Object localObject = (ap)((a)g.G(a.class)).getQQListStg();
    ao localao = ((ap)localObject).xn(paramString);
    if (localao == null)
    {
      ab.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", new Object[] { String.valueOf(paramString) });
      AppMethodBeat.o(108590);
      return;
    }
    localao.gyF = 2;
    ((ap)localObject).a(localao.gyE, localao);
    this.gzL.notifyDataSetChanged();
    localObject = ((j)g.E(j.class)).YA().arw(paramString);
    if (localObject != null) {
      if (((((aq)localObject).field_conRemark == null) || (((aq)localObject).field_conRemark.equals(""))) && (localao != null) && (localao.aqP() != null) && (!localao.aqP().equals(""))) {
        t.b((ad)localObject, localao.aqP());
      }
    }
    for (;;)
    {
      bv.abc().c(26, new Object[0]);
      AppMethodBeat.o(108590);
      return;
      localao = ((ap)((a)g.G(a.class)).getQQListStg()).xn(paramString);
      if (localao != null)
      {
        localao.aqS();
        ab.d("MicroMsg.QQFriendAdapter", "user " + paramString + " qq " + localao.gyE);
        ((ap)((a)g.G(a.class)).getQQListStg()).a(localao.gyE, localao);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e.2
 * JD-Core Version:    0.7.0.1
 */