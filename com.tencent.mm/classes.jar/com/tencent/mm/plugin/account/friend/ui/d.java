package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.by;
import com.tencent.mm.model.w;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.r;

public abstract class d
  extends r<as>
  implements e.a
{
  public d(Context paramContext, as paramas)
  {
    super(paramContext, paramas);
  }
  
  public static void Gy(String paramString)
  {
    if (bs.isNullOrNil(paramString)) {
      ac.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
    }
    Object localObject;
    do
    {
      return;
      localObject = ((at)((a)g.ad(a.class)).getQQListStg()).Gu(paramString);
      if (localObject != null)
      {
        ((as)localObject).iLJ = 2;
        ((at)((a)g.ad(a.class)).getQQListStg()).a(((as)localObject).iLI, (as)localObject);
      }
      localObject = ((k)g.ab(k.class)).awB().aNt(paramString);
      if (localObject == null)
      {
        ac.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
        return;
      }
      if (bs.isNullOrNil(((av)localObject).field_username)) {
        ((ai)localObject).setUsername(paramString);
      }
      if ((int)((b)localObject).fLJ != 0) {
        break;
      }
      ((k)g.ab(k.class)).awB().ah((ai)localObject);
    } while (bs.isNullOrNil(((av)localObject).field_username));
    for (paramString = ((k)g.ab(k.class)).awB().aNt(((av)localObject).field_username);; paramString = (String)localObject)
    {
      if ((int)paramString.fLJ <= 0)
      {
        ac.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
        return;
      }
      w.u(paramString);
      by.azu().d(26, new Object[0]);
      return;
    }
  }
  
  public void FZ(String paramString) {}
  
  public void a(a parama) {}
  
  public static abstract interface a
  {
    public abstract void qL(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.d
 * JD-Core Version:    0.7.0.1
 */