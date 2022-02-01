package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.w;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.r;

public abstract class d
  extends r<as>
  implements e.a
{
  public d(Context paramContext, as paramas)
  {
    super(paramContext, paramas);
  }
  
  public static void JN(String paramString)
  {
    if (bt.isNullOrNil(paramString)) {
      ad.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
    }
    Object localObject;
    do
    {
      return;
      localObject = ((at)((a)g.ad(a.class)).getQQListStg()).JJ(paramString);
      if (localObject != null)
      {
        ((as)localObject).jeS = 2;
        ((at)((a)g.ad(a.class)).getQQListStg()).a(((as)localObject).jeR, (as)localObject);
      }
      localObject = ((l)g.ab(l.class)).azp().Bf(paramString);
      if (localObject == null)
      {
        ad.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
        return;
      }
      if (bt.isNullOrNil(((aw)localObject).field_username)) {
        ((am)localObject).setUsername(paramString);
      }
      if ((int)((b)localObject).gfj != 0) {
        break;
      }
      ((l)g.ab(l.class)).azp().ah((am)localObject);
    } while (bt.isNullOrNil(((aw)localObject).field_username));
    for (paramString = ((l)g.ab(l.class)).azp().Bf(((aw)localObject).field_username);; paramString = (String)localObject)
    {
      if ((int)paramString.gfj <= 0)
      {
        ad.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
        return;
      }
      w.u(paramString);
      bz.aCx().d(26, new Object[0]);
      return;
    }
  }
  
  public void Jo(String paramString) {}
  
  public void a(a parama) {}
  
  public static abstract interface a
  {
    public abstract void rl(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.d
 * JD-Core Version:    0.7.0.1
 */