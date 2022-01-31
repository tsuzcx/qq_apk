package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class e$2
  implements a.a
{
  e$2(e parame) {}
  
  public final void T(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      com.tencent.mm.plugin.account.friend.a.ao localao = ((ap)((a)g.t(a.class)).getQQListStg()).pR(paramString);
      if (localao == null) {
        break label99;
      }
      localao.Xo();
      y.d("MicroMsg.QQFriendAdapter", "user " + paramString + " qq " + localao.fgW);
      ((ap)((a)g.t(a.class)).getQQListStg()).a(localao.fgW, localao);
    }
    for (;;)
    {
      this.fie.notifyDataSetChanged();
      return;
      label99:
      y.w("MicroMsg.QQFriendAdapter", "[cpan] dealFail failed. qqlist is null. username is :%s", new Object[] { paramString });
    }
  }
  
  public final void pS(String paramString)
  {
    Object localObject = (ap)((a)g.t(a.class)).getQQListStg();
    com.tencent.mm.plugin.account.friend.a.ao localao = ((ap)localObject).pR(paramString);
    if (localao == null)
    {
      y.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", new Object[] { paramString });
      return;
    }
    localao.fgX = 2;
    ((ap)localObject).a(localao.fgW, localao);
    this.fie.notifyDataSetChanged();
    localObject = ((j)g.r(j.class)).Fw().abl(paramString);
    if (localObject != null) {
      if (((((com.tencent.mm.h.c.ao)localObject).field_conRemark == null) || (((com.tencent.mm.h.c.ao)localObject).field_conRemark.equals(""))) && (localao != null) && (localao.Xl() != null) && (!localao.Xl().equals(""))) {
        s.b((ad)localObject, localao.Xl());
      }
    }
    for (;;)
    {
      bt.If().d(26, new Object[0]);
      return;
      localao = ((ap)((a)g.t(a.class)).getQQListStg()).pR(paramString);
      if (localao != null)
      {
        localao.Xo();
        y.d("MicroMsg.QQFriendAdapter", "user " + paramString + " qq " + localao.fgW);
        ((ap)((a)g.t(a.class)).getQQListStg()).a(localao.fgW, localao);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e.2
 * JD-Core Version:    0.7.0.1
 */