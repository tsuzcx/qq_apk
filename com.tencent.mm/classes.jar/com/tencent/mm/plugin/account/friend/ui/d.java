package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.s;

public abstract class d
  extends s<com.tencent.mm.plugin.account.friend.a.as>
  implements e.a
{
  public d(Context paramContext, com.tencent.mm.plugin.account.friend.a.as paramas)
  {
    super(paramContext, paramas);
  }
  
  public static void Tk(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {
      Log.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
    }
    Object localObject;
    do
    {
      return;
      localObject = ((at)((a)g.ah(a.class)).getQQListStg()).Tg(paramString);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.account.friend.a.as)localObject).kfO = 2;
        ((at)((a)g.ah(a.class)).getQQListStg()).a(((com.tencent.mm.plugin.account.friend.a.as)localObject).kfN, (com.tencent.mm.plugin.account.friend.a.as)localObject);
      }
      localObject = ((l)g.af(l.class)).aSN().Kn(paramString);
      if (localObject == null)
      {
        Log.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
        return;
      }
      if (Util.isNullOrNil(((ax)localObject).field_username)) {
        ((com.tencent.mm.storage.as)localObject).setUsername(paramString);
      }
      if ((int)((c)localObject).gMZ != 0) {
        break;
      }
      ((l)g.af(l.class)).aSN().aq((com.tencent.mm.storage.as)localObject);
    } while (Util.isNullOrNil(((ax)localObject).field_username));
    for (paramString = ((l)g.af(l.class)).aSN().Kn(((ax)localObject).field_username);; paramString = (String)localObject)
    {
      if ((int)paramString.gMZ <= 0)
      {
        Log.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
        return;
      }
      ab.B(paramString);
      cf.aWl().f(26, new Object[0]);
      return;
    }
  }
  
  public void SM(String paramString) {}
  
  public void a(a parama) {}
  
  public static abstract interface a
  {
    public abstract void ve(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.d
 * JD-Core Version:    0.7.0.1
 */