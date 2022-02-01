package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.by;
import com.tencent.mm.model.w;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.q;

public abstract class d
  extends q<as>
  implements e.a
{
  public d(Context paramContext, as paramas)
  {
    super(paramContext, paramas);
  }
  
  public static void Cv(String paramString)
  {
    if (bt.isNullOrNil(paramString)) {
      ad.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
    }
    Object localObject;
    do
    {
      return;
      localObject = ((at)((a)g.ad(a.class)).getQQListStg()).Cr(paramString);
      if (localObject != null)
      {
        ((as)localObject).ilC = 2;
        ((at)((a)g.ad(a.class)).getQQListStg()).a(((as)localObject).ilB, (as)localObject);
      }
      localObject = ((k)g.ab(k.class)).apM().aHY(paramString);
      if (localObject == null)
      {
        ad.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
        return;
      }
      if (bt.isNullOrNil(((au)localObject).field_username)) {
        ((af)localObject).setUsername(paramString);
      }
      if ((int)((b)localObject).fId != 0) {
        break;
      }
      ((k)g.ab(k.class)).apM().ag((af)localObject);
    } while (bt.isNullOrNil(((au)localObject).field_username));
    for (paramString = ((k)g.ab(k.class)).apM().aHY(((au)localObject).field_username);; paramString = (String)localObject)
    {
      if ((int)paramString.fId <= 0)
      {
        ad.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
        return;
      }
      w.u(paramString);
      by.asD().d(26, new Object[0]);
      return;
    }
  }
  
  public void BW(String paramString) {}
  
  public void a(a parama) {}
  
  public static abstract interface a
  {
    public abstract void pY(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.d
 * JD-Core Version:    0.7.0.1
 */