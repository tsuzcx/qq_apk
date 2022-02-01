package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.r;

public abstract class d
  extends r<as>
  implements e.a
{
  public d(Context paramContext, as paramas)
  {
    super(paramContext, paramas);
  }
  
  public static void Km(String paramString)
  {
    if (bu.isNullOrNil(paramString)) {
      ae.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
    }
    Object localObject;
    do
    {
      return;
      localObject = ((at)((a)g.ad(a.class)).getQQListStg()).Ki(paramString);
      if (localObject != null)
      {
        ((as)localObject).jhL = 2;
        ((at)((a)g.ad(a.class)).getQQListStg()).a(((as)localObject).jhK, (as)localObject);
      }
      localObject = ((l)g.ab(l.class)).azF().BH(paramString);
      if (localObject == null)
      {
        ae.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
        return;
      }
      if (bu.isNullOrNil(((aw)localObject).field_username)) {
        ((an)localObject).setUsername(paramString);
      }
      if ((int)((c)localObject).ght != 0) {
        break;
      }
      ((l)g.ab(l.class)).azF().ao((an)localObject);
    } while (bu.isNullOrNil(((aw)localObject).field_username));
    for (paramString = ((l)g.ab(l.class)).azF().BH(((aw)localObject).field_username);; paramString = (String)localObject)
    {
      if ((int)paramString.ght <= 0)
      {
        ae.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
        return;
      }
      x.B(paramString);
      cb.aCN().d(26, new Object[0]);
      return;
    }
  }
  
  public void JN(String paramString) {}
  
  public void a(a parama) {}
  
  public static abstract interface a
  {
    public abstract void ro(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.d
 * JD-Core Version:    0.7.0.1
 */