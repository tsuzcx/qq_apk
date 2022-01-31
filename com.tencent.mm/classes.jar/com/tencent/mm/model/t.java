package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class t
{
  private static final List<t.a> dVd = new ArrayList();
  
  public static int Q(String paramString1, String paramString2)
  {
    int j;
    if (!g.DK())
    {
      y.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
      j = 0;
      return j;
    }
    paramString1 = ((j)g.r(j.class)).FB().go(paramString1, paramString2);
    if ((paramString1 != null) && (paramString1.getCount() > 0)) {
      paramString1.moveToFirst();
    }
    for (int i = paramString1.getInt(0);; i = 0)
    {
      j = i;
      if (paramString1 == null) {
        break;
      }
      paramString1.close();
      return i;
    }
  }
  
  public static int R(String paramString1, String paramString2)
  {
    int j = 0;
    if (bk.bl(paramString1)) {
      return 0;
    }
    if ("notification_messages".equals(paramString1)) {
      return 8;
    }
    if ((paramString2 != null) && (paramString2.endsWith("@chatroom"))) {
      return 2;
    }
    PInt localPInt = new PInt();
    List localList = dVd;
    int i = 0;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (i >= dVd.size()) {
          break label137;
        }
        t.a locala = (t.a)dVd.get(i);
        if (locala == null) {
          break label146;
        }
        bool2 = locala.a(paramString1, paramString2, localPInt);
        bool1 = bool2;
        if (!bool2) {
          break label146;
        }
        i = localPInt.value;
        if (!bool2) {
          return 1;
        }
      }
      finally {}
      return i;
      label137:
      boolean bool2 = bool1;
      i = j;
      continue;
      label146:
      i += 1;
    }
  }
  
  public static void a(t.a parama)
  {
    Assert.assertNotNull(parama);
    synchronized (dVd)
    {
      dVd.add(parama);
      return;
    }
  }
  
  public static int e(String paramString, List<String> paramList)
  {
    if (!g.DK())
    {
      y.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
      return 0;
    }
    long l1 = bk.UZ();
    paramList = ((j)g.r(j.class)).FB().x(paramString, paramList);
    long l2 = bk.UZ();
    if ((paramList != null) && (paramList.getCount() > 0)) {
      paramList.moveToFirst();
    }
    for (int i = paramList.getInt(0);; i = 0)
    {
      if (paramList != null) {
        paramList.close();
      }
      y.d("MicroMsg.ConversationLogic", "unreadcheck unRead getTotalUnread %d", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        i = 0;
      }
      for (;;)
      {
        paramList.close();
        y.i("MicroMsg.ConversationLogic", "get count with black list use %d ms", new Object[] { Long.valueOf(bk.cp(l1)) });
        return i;
        paramString = ((j)g.r(j.class)).FB().abF(paramString);
        if (paramString != null) {
          break;
        }
        y.w("MicroMsg.ConversationLogic", "cursor is null, return");
        y.i("MicroMsg.ConversationLogic", "get count use %d ms", new Object[] { Long.valueOf(bk.cp(l2)) });
      }
      paramString.moveToFirst();
      label199:
      if (!paramString.isAfterLast())
      {
        ad localad = ((j)g.r(j.class)).Fw().abl(paramString.getString(0));
        if ((localad == null) || (localad.cCy != 0)) {
          break label349;
        }
        i -= paramString.getInt(1);
        y.d("MicroMsg.ConversationLogic", "unreadcheck chatroom mute %s, unRead %d,", new Object[] { localad.field_username, Integer.valueOf(i) });
      }
      label349:
      for (;;)
      {
        paramString.moveToNext();
        break label199;
        y.i("MicroMsg.ConversationLogic", "unreadcheck  result talker count is %d", new Object[] { Integer.valueOf(i) });
        paramString.close();
        y.i("MicroMsg.ConversationLogic", "unreadcheck get count use %d ms", new Object[] { Long.valueOf(bk.cp(l2)) });
        i = Math.max(0, i);
        break;
      }
    }
  }
  
  public static int ie(String paramString)
  {
    return e(paramString, null);
  }
  
  public static int jdMethod_if(String paramString)
  {
    if (!g.DK())
    {
      y.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
      return 0;
    }
    long l = bk.UZ();
    Object localObject = ((j)g.r(j.class)).FB().abG(paramString);
    if (((Cursor)localObject).getCount() > 0) {
      ((Cursor)localObject).moveToFirst();
    }
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      if (i <= 0) {
        break;
      }
      paramString = ((j)g.r(j.class)).FB().abF(paramString);
      if (paramString == null)
      {
        y.w("MicroMsg.ConversationLogic", "cursor is null, return");
        y.i("MicroMsg.ConversationLogic", "get count use %d ms", new Object[] { Long.valueOf(bk.cp(l)) });
        return i;
      }
      paramString.moveToFirst();
      if (!paramString.isAfterLast())
      {
        localObject = ((j)g.r(j.class)).Fw().abl(paramString.getString(0));
        if ((localObject == null) || (((ao)localObject).cCy != 0)) {
          break label253;
        }
        i -= 1;
      }
      label253:
      for (;;)
      {
        paramString.moveToNext();
        break;
        y.i("MicroMsg.ConversationLogic", "result talker count is %d", new Object[] { Integer.valueOf(i) });
        paramString.close();
        y.i("MicroMsg.ConversationLogic", "get count use %d ms", new Object[] { Long.valueOf(bk.cp(l)) });
        return Math.max(0, i);
      }
    }
  }
  
  public static List<String> ig(String paramString)
  {
    ArrayList localArrayList = null;
    Object localObject = null;
    if (!g.DK()) {
      y.w("MicroMsg.ConversationLogic", "get Total Unread Talker T, but has not set uin");
    }
    do
    {
      do
      {
        return localObject;
        localObject = ((j)g.r(j.class)).FB().abH(paramString);
        if (((Cursor)localObject).moveToNext())
        {
          localArrayList = new ArrayList();
          do
          {
            y.d("MicroMsg.ConversationLogic", "jacks need notify talker display name: %s", new Object[] { ((Cursor)localObject).getString(0) });
            localArrayList.add(((Cursor)localObject).getString(0));
          } while (((Cursor)localObject).moveToNext());
        }
        ((Cursor)localObject).close();
        localObject = localArrayList;
      } while (localArrayList == null);
      paramString = ((j)g.r(j.class)).FB().abF(paramString);
      localObject = localArrayList;
    } while (paramString == null);
    paramString.moveToFirst();
    while (!paramString.isAfterLast())
    {
      localObject = ((j)g.r(j.class)).Fw().abl(paramString.getString(0));
      if ((localObject != null) && (((ao)localObject).cCy == 0))
      {
        y.d("MicroMsg.ConversationLogic", "jacks need mute notify:  %s", new Object[] { ((ad)localObject).Bp() });
        localArrayList.remove(((ad)localObject).Bp());
      }
      paramString.moveToNext();
    }
    paramString.close();
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.t
 * JD-Core Version:    0.7.0.1
 */