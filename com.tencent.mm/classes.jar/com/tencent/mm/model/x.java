package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class x
{
  private static final List<a> gMx;
  
  static
  {
    AppMethodBeat.i(42940);
    gMx = new ArrayList();
    AppMethodBeat.o(42940);
  }
  
  public static List<String> X(String paramString, int paramInt)
  {
    AppMethodBeat.i(42937);
    ArrayList localArrayList = null;
    Object localObject = null;
    if (!g.afw()) {
      ad.w("MicroMsg.ConversationLogic", "get Total Unread Talker T, but has not set uin");
    }
    for (;;)
    {
      AppMethodBeat.o(42937);
      return localObject;
      localObject = ((k)g.ab(k.class)).apR().fL(paramString, paramInt);
      if (((Cursor)localObject).moveToNext())
      {
        localArrayList = new ArrayList();
        do
        {
          ad.d("MicroMsg.ConversationLogic", "jacks need notify talker display name: %s", new Object[] { ((Cursor)localObject).getString(0) });
          localArrayList.add(((Cursor)localObject).getString(0));
        } while (((Cursor)localObject).moveToNext());
      }
      ((Cursor)localObject).close();
      localObject = localArrayList;
      if (localArrayList != null)
      {
        paramString = ((k)g.ab(k.class)).apR().aIx(paramString);
        localObject = localArrayList;
        if (paramString != null)
        {
          paramString.moveToFirst();
          while (!paramString.isAfterLast())
          {
            localObject = ((k)g.ab(k.class)).apM().aHY(paramString.getString(0));
            if ((localObject != null) && (((au)localObject).evx == 0))
            {
              ad.d("MicroMsg.ConversationLogic", "jacks need mute notify:  %s", new Object[] { ((af)localObject).ZW() });
              localArrayList.remove(((af)localObject).ZW());
            }
            paramString.moveToNext();
          }
          paramString.close();
          localObject = localArrayList;
        }
      }
    }
  }
  
  private static int a(String paramString, Cursor paramCursor)
  {
    AppMethodBeat.i(42932);
    if ((paramCursor != null) && (paramCursor.getCount() > 0)) {
      paramCursor.moveToFirst();
    }
    for (int i = paramCursor.getInt(0);; i = 0)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      if (i <= 0)
      {
        AppMethodBeat.o(42932);
        return 0;
      }
      paramString = ((k)g.ab(k.class)).apR().aIx(paramString);
      if (paramString == null)
      {
        ad.w("MicroMsg.ConversationLogic", "cursor is null, return");
        AppMethodBeat.o(42932);
        return i;
      }
      paramString.moveToFirst();
      if (!paramString.isAfterLast())
      {
        paramCursor = ((k)g.ab(k.class)).apM().aHY(paramString.getString(0));
        if ((paramCursor == null) || (paramCursor.evx != 0)) {
          break label209;
        }
        i -= paramString.getInt(1);
        ad.d("MicroMsg.ConversationLogic", "unreadcheck chatroom mute %s, unRead %d,", new Object[] { paramCursor.field_username, Integer.valueOf(i) });
      }
      label209:
      for (;;)
      {
        paramString.moveToNext();
        break;
        paramString.close();
        i = Math.max(0, i);
        AppMethodBeat.o(42932);
        return i;
      }
    }
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(42939);
    Assert.assertNotNull(parama);
    synchronized (gMx)
    {
      gMx.add(parama);
      AppMethodBeat.o(42939);
      return;
    }
  }
  
  public static int av(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42935);
    if (!g.afw())
    {
      ad.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
      AppMethodBeat.o(42935);
      return 0;
    }
    paramString1 = ((k)g.ab(k.class)).apR().ld(paramString1, paramString2);
    if ((paramString1 != null) && (paramString1.getCount() > 0)) {
      paramString1.moveToFirst();
    }
    for (int i = paramString1.getInt(0);; i = 0)
    {
      if (paramString1 != null) {
        paramString1.close();
      }
      AppMethodBeat.o(42935);
      return i;
    }
  }
  
  public static int aw(String paramString1, String paramString2)
  {
    int j = 0;
    AppMethodBeat.i(42938);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(42938);
      return 0;
    }
    if ("notification_messages".equals(paramString1)) {}
    for (int i = 8;; i = 2)
    {
      AppMethodBeat.o(42938);
      return i;
      if ((paramString2 == null) || (!paramString2.endsWith("@chatroom"))) {
        break;
      }
    }
    PInt localPInt = new PInt();
    List localList = gMx;
    i = 0;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (i >= gMx.size()) {
          break label166;
        }
        a locala = (a)gMx.get(i);
        if (locala == null) {
          break label175;
        }
        bool2 = locala.a(paramString1, paramString2, localPInt);
        bool1 = bool2;
        if (!bool2) {
          break label175;
        }
        i = localPInt.value;
        if (!bool2)
        {
          i = 1;
          break;
        }
      }
      finally
      {
        AppMethodBeat.o(42938);
      }
      break;
      label166:
      boolean bool2 = bool1;
      i = j;
      continue;
      label175:
      i += 1;
    }
  }
  
  public static int d(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(42934);
    if (!g.afw())
    {
      ad.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
      AppMethodBeat.o(42934);
      return 0;
    }
    long l = bt.GC();
    Cursor localCursor = ((k)g.ab(k.class)).apR().H(paramString, paramList);
    int j = a(paramString, localCursor);
    localCursor.close();
    l = bt.aS(l);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      ad.i("MicroMsg.ConversationLogic", "get count %d with black list use %d ms, blacklist size:%s", new Object[] { Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(42934);
      return j;
    }
  }
  
  public static int e(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(42936);
    if (!g.afw())
    {
      ad.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
      AppMethodBeat.o(42936);
      return 0;
    }
    long l = bt.GC();
    paramList = ((k)g.ab(k.class)).apR().I(paramString, paramList);
    if (paramList.getCount() > 0) {
      paramList.moveToFirst();
    }
    for (int j = paramList.getInt(0);; j = 0)
    {
      paramList.close();
      if (j <= 0)
      {
        AppMethodBeat.o(42936);
        return 0;
      }
      paramString = ((k)g.ab(k.class)).apR().aIx(paramString);
      if (paramString == null)
      {
        ad.i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cursor is null!cost %d ms count:%s ", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(j) });
        AppMethodBeat.o(42936);
        return j;
      }
      paramString.moveToFirst();
      int i = 0;
      if (!paramString.isAfterLast())
      {
        paramList = ((k)g.ab(k.class)).apM().aHY(paramString.getString(0));
        if ((paramList == null) || (paramList.evx != 0)) {
          break label280;
        }
        j -= 1;
        i += 1;
      }
      label280:
      for (;;)
      {
        paramString.moveToNext();
        break;
        paramString.close();
        ad.i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cost %d ms count:%s mute:%s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(j), Integer.valueOf(i) });
        i = Math.max(0, j);
        AppMethodBeat.o(42936);
        return i;
      }
    }
  }
  
  public static int tz(String paramString)
  {
    AppMethodBeat.i(42933);
    int i = d(paramString, new LinkedList());
    AppMethodBeat.o(42933);
    return i;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(String paramString1, String paramString2, PInt paramPInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.x
 * JD-Core Version:    0.7.0.1
 */