package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import com.tencent.mm.am.f.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.sdk.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.v;

public abstract class d
  extends v<com.tencent.mm.plugin.account.friend.a.as>
  implements f.a
{
  public d(Context paramContext, com.tencent.mm.plugin.account.friend.a.as paramas)
  {
    super(paramContext, paramas);
  }
  
  public static void aaQ(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {
      Log.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
    }
    Object localObject;
    do
    {
      return;
      localObject = ((at)((a)h.ag(a.class)).getQQListStg()).aaM(paramString);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.account.friend.a.as)localObject).mXn = 2;
        ((at)((a)h.ag(a.class)).getQQListStg()).a(((com.tencent.mm.plugin.account.friend.a.as)localObject).mXm, (com.tencent.mm.plugin.account.friend.a.as)localObject);
      }
      localObject = ((n)h.ae(n.class)).bbL().RG(paramString);
      if (localObject == null)
      {
        Log.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
        return;
      }
      if (Util.isNullOrNil(((ax)localObject).field_username)) {
        ((com.tencent.mm.storage.as)localObject).setUsername(paramString);
      }
      if ((int)((com.tencent.mm.contact.d)localObject).jxt != 0) {
        break;
      }
      ((n)h.ae(n.class)).bbL().aw((com.tencent.mm.storage.as)localObject);
    } while (Util.isNullOrNil(((ax)localObject).field_username));
    for (paramString = ((n)h.ae(n.class)).bbL().RG(((ax)localObject).field_username);; paramString = (String)localObject)
    {
      if ((int)paramString.jxt <= 0)
      {
        Log.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
        return;
      }
      ab.H(paramString);
      cg.bfp().e(26, new Object[0]);
      return;
    }
  }
  
  public void a(d.a parama) {}
  
  public void aas(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.d
 * JD-Core Version:    0.7.0.1
 */