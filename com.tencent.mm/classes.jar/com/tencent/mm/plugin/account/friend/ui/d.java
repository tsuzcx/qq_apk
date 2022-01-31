package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.p;

public abstract class d
  extends p<ao>
  implements com.tencent.mm.ah.d.a
{
  public d(Context paramContext, ao paramao)
  {
    super(paramContext, paramao);
  }
  
  public static void xp(String paramString)
  {
    if (bo.isNullOrNil(paramString)) {
      ab.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
    }
    Object localObject;
    do
    {
      return;
      localObject = ((ap)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).xn(paramString);
      if (localObject != null)
      {
        ((ao)localObject).gyF = 2;
        ((ap)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(((ao)localObject).gyE, (ao)localObject);
      }
      localObject = ((j)g.E(j.class)).YA().arw(paramString);
      if (localObject == null)
      {
        ab.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
        return;
      }
      if (bo.isNullOrNil(((aq)localObject).field_username)) {
        ((ad)localObject).setUsername(paramString);
      }
      if ((int)((com.tencent.mm.n.a)localObject).euF != 0) {
        break;
      }
      ((j)g.E(j.class)).YA().Z((ad)localObject);
    } while (bo.isNullOrNil(((aq)localObject).field_username));
    for (paramString = ((j)g.E(j.class)).YA().arw(((aq)localObject).field_username);; paramString = (String)localObject)
    {
      if ((int)paramString.euF <= 0)
      {
        ab.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
        return;
      }
      t.q(paramString);
      bv.abc().c(26, new Object[0]);
      return;
    }
  }
  
  public void a(d.a parama) {}
  
  public void wQ(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.d
 * JD-Core Version:    0.7.0.1
 */