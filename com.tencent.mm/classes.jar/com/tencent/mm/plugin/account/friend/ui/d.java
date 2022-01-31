package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.r;

public abstract class d
  extends r<com.tencent.mm.plugin.account.friend.a.ao>
  implements com.tencent.mm.ag.d.a
{
  public d(Context paramContext, com.tencent.mm.plugin.account.friend.a.ao paramao)
  {
    super(paramContext, paramao);
  }
  
  public static void pT(String paramString)
  {
    if (bk.bl(paramString)) {
      y.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
    }
    Object localObject;
    do
    {
      return;
      localObject = ((ap)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).pR(paramString);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.account.friend.a.ao)localObject).fgX = 2;
        ((ap)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(((com.tencent.mm.plugin.account.friend.a.ao)localObject).fgW, (com.tencent.mm.plugin.account.friend.a.ao)localObject);
      }
      localObject = ((j)g.r(j.class)).Fw().abl(paramString);
      if (localObject == null)
      {
        y.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
        return;
      }
      if (bk.bl(((com.tencent.mm.h.c.ao)localObject).field_username)) {
        ((ad)localObject).setUsername(paramString);
      }
      if ((int)((com.tencent.mm.n.a)localObject).dBe != 0) {
        break;
      }
      ((j)g.r(j.class)).Fw().W((ad)localObject);
    } while (bk.bl(((com.tencent.mm.h.c.ao)localObject).field_username));
    for (paramString = ((j)g.r(j.class)).Fw().abl(((com.tencent.mm.h.c.ao)localObject).field_username);; paramString = (String)localObject)
    {
      if ((int)paramString.dBe <= 0)
      {
        y.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
        return;
      }
      s.q(paramString);
      bt.If().d(26, new Object[0]);
      return;
    }
  }
  
  public void a(d.a parama) {}
  
  public void pA(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.d
 * JD-Core Version:    0.7.0.1
 */