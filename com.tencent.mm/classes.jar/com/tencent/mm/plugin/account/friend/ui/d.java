package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.plugin.account.friend.model.ap;
import com.tencent.mm.plugin.account.friend.model.aq;
import com.tencent.mm.plugin.account.sdk.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.x;

public abstract class d
  extends x<ap>
  implements AvatarStorage.a
{
  public d(Context paramContext, ap paramap)
  {
    super(paramContext, paramap);
  }
  
  public static void Tj(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {
      Log.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
    }
    Object localObject;
    do
    {
      return;
      localObject = ((aq)((a)h.az(a.class)).getQQListStg()).Tf(paramString);
      if (localObject != null)
      {
        ((ap)localObject).pTV = 2;
        ((aq)((a)h.az(a.class)).getQQListStg()).a(((ap)localObject).pTU, (ap)localObject);
      }
      localObject = ((n)h.ax(n.class)).bzA().JE(paramString);
      if (localObject == null)
      {
        Log.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
        return;
      }
      if (Util.isNullOrNil(((az)localObject).field_username)) {
        ((au)localObject).setUsername(paramString);
      }
      if ((int)((com.tencent.mm.contact.d)localObject).maN != 0) {
        break;
      }
      ((n)h.ax(n.class)).bzA().aC((au)localObject);
    } while (Util.isNullOrNil(((az)localObject).field_username));
    for (paramString = ((n)h.ax(n.class)).bzA().JE(((az)localObject).field_username);; paramString = (String)localObject)
    {
      if ((int)paramString.maN <= 0)
      {
        Log.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
        return;
      }
      ab.I(paramString);
      ch.bDg().f(26, new Object[0]);
      return;
    }
  }
  
  public void SM(String paramString) {}
  
  public void a(a parama) {}
  
  public static abstract interface a
  {
    public abstract void yo(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.d
 * JD-Core Version:    0.7.0.1
 */