package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.sdk.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;

final class e$2
  implements a.a
{
  e$2(e parame) {}
  
  public final void aaP(String paramString)
  {
    AppMethodBeat.i(131251);
    Object localObject = (at)((a)h.ag(a.class)).getQQListStg();
    com.tencent.mm.plugin.account.friend.a.as localas = ((at)localObject).aaM(paramString);
    if (localas == null)
    {
      Log.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", new Object[] { String.valueOf(paramString) });
      AppMethodBeat.o(131251);
      return;
    }
    localas.mXn = 2;
    ((at)localObject).a(localas.mXm, localas);
    this.mYE.notifyDataSetChanged();
    localObject = ((n)h.ae(n.class)).bbL().RG(paramString);
    if (localObject != null) {
      if (((((ax)localObject).field_conRemark == null) || (((ax)localObject).field_conRemark.equals(""))) && (localas != null) && (localas.byI() != null) && (!localas.byI().equals(""))) {
        ab.c((com.tencent.mm.storage.as)localObject, localas.byI());
      }
    }
    for (;;)
    {
      cg.bfp().e(26, new Object[0]);
      AppMethodBeat.o(131251);
      return;
      localas = ((at)((a)h.ag(a.class)).getQQListStg()).aaM(paramString);
      if (localas != null)
      {
        localas.byL();
        Log.d("MicroMsg.QQFriendAdapter", "user " + paramString + " qq " + localas.mXm);
        ((at)((a)h.ag(a.class)).getQQListStg()).a(localas.mXm, localas);
      }
    }
  }
  
  public final void af(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131252);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.account.friend.a.as localas = ((at)((a)h.ag(a.class)).getQQListStg()).aaM(paramString);
      if (localas == null) {
        break label109;
      }
      localas.byL();
      Log.d("MicroMsg.QQFriendAdapter", "user " + paramString + " qq " + localas.mXm);
      ((at)((a)h.ag(a.class)).getQQListStg()).a(localas.mXm, localas);
    }
    for (;;)
    {
      this.mYE.notifyDataSetChanged();
      AppMethodBeat.o(131252);
      return;
      label109:
      Log.w("MicroMsg.QQFriendAdapter", "[cpan] dealFail failed. qqlist is null. username is :%s", new Object[] { String.valueOf(paramString) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e.2
 * JD-Core Version:    0.7.0.1
 */