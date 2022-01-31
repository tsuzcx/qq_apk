package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class u
{
  private static final List<u.a> flm;
  
  static
  {
    AppMethodBeat.i(59887);
    flm = new ArrayList();
    AppMethodBeat.o(59887);
  }
  
  public static List<String> P(String paramString, int paramInt)
  {
    AppMethodBeat.i(59884);
    ArrayList localArrayList = null;
    Object localObject = null;
    if (!g.RG()) {
      ab.w("MicroMsg.ConversationLogic", "get Total Unread Talker T, but has not set uin");
    }
    for (;;)
    {
      AppMethodBeat.o(59884);
      return localObject;
      localObject = ((j)g.E(j.class)).YF().eC(paramString, paramInt);
      if (((Cursor)localObject).moveToNext())
      {
        localArrayList = new ArrayList();
        do
        {
          ab.d("MicroMsg.ConversationLogic", "jacks need notify talker display name: %s", new Object[] { ((Cursor)localObject).getString(0) });
          localArrayList.add(((Cursor)localObject).getString(0));
        } while (((Cursor)localObject).moveToNext());
      }
      ((Cursor)localObject).close();
      localObject = localArrayList;
      if (localArrayList != null)
      {
        paramString = ((j)g.E(j.class)).YF().arR(paramString);
        localObject = localArrayList;
        if (paramString != null)
        {
          paramString.moveToFirst();
          while (!paramString.isAfterLast())
          {
            localObject = ((j)g.E(j.class)).YA().arw(paramString.getString(0));
            if ((localObject != null) && (((aq)localObject).dqK == 0))
            {
              ab.d("MicroMsg.ConversationLogic", "jacks need mute notify:  %s", new Object[] { ((ad)localObject).Oe() });
              localArrayList.remove(((ad)localObject).Oe());
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
    AppMethodBeat.i(59879);
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
        AppMethodBeat.o(59879);
        return 0;
      }
      paramString = ((j)g.E(j.class)).YF().arR(paramString);
      if (paramString == null)
      {
        ab.w("MicroMsg.ConversationLogic", "cursor is null, return");
        AppMethodBeat.o(59879);
        return i;
      }
      paramString.moveToFirst();
      if (!paramString.isAfterLast())
      {
        paramCursor = ((j)g.E(j.class)).YA().arw(paramString.getString(0));
        if ((paramCursor == null) || (paramCursor.dqK != 0)) {
          break label209;
        }
        i -= paramString.getInt(1);
        ab.d("MicroMsg.ConversationLogic", "unreadcheck chatroom mute %s, unRead %d,", new Object[] { paramCursor.field_username, Integer.valueOf(i) });
      }
      label209:
      for (;;)
      {
        paramString.moveToNext();
        break;
        paramString.close();
        i = Math.max(0, i);
        AppMethodBeat.o(59879);
        return i;
      }
    }
  }
  
  public static void a(u.a parama)
  {
    AppMethodBeat.i(59886);
    Assert.assertNotNull(parama);
    synchronized (flm)
    {
      flm.add(parama);
      AppMethodBeat.o(59886);
      return;
    }
  }
  
  public static int ag(String paramString1, String paramString2)
  {
    AppMethodBeat.i(59882);
    if (!g.RG())
    {
      ab.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
      AppMethodBeat.o(59882);
      return 0;
    }
    paramString1 = ((j)g.E(j.class)).YF().ip(paramString1, paramString2);
    if ((paramString1 != null) && (paramString1.getCount() > 0)) {
      paramString1.moveToFirst();
    }
    for (int i = paramString1.getInt(0);; i = 0)
    {
      if (paramString1 != null) {
        paramString1.close();
      }
      AppMethodBeat.o(59882);
      return i;
    }
  }
  
  public static int ah(String paramString1, String paramString2)
  {
    int j = 0;
    AppMethodBeat.i(59885);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(59885);
      return 0;
    }
    if ("notification_messages".equals(paramString1)) {}
    for (int i = 8;; i = 2)
    {
      AppMethodBeat.o(59885);
      return i;
      if ((paramString2 == null) || (!paramString2.endsWith("@chatroom"))) {
        break;
      }
    }
    PInt localPInt = new PInt();
    List localList = flm;
    i = 0;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (i >= flm.size()) {
          break label166;
        }
        u.a locala = (u.a)flm.get(i);
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
        AppMethodBeat.o(59885);
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
  
  public static int e(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(59881);
    if (!g.RG())
    {
      ab.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
      AppMethodBeat.o(59881);
      return 0;
    }
    long l = bo.yB();
    Cursor localCursor = ((j)g.E(j.class)).YF().B(paramString, paramList);
    int j = a(paramString, localCursor);
    localCursor.close();
    l = bo.av(l);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      ab.i("MicroMsg.ConversationLogic", "get count with black list use %d ms, blacklist size:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(59881);
      return j;
    }
  }
  
  public static int f(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(141741);
    if (!g.RG())
    {
      ab.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
      AppMethodBeat.o(141741);
      return 0;
    }
    long l = bo.yB();
    paramList = ((j)g.E(j.class)).YF().C(paramString, paramList);
    if (paramList.getCount() > 0) {
      paramList.moveToFirst();
    }
    for (int j = paramList.getInt(0);; j = 0)
    {
      paramList.close();
      if (j <= 0)
      {
        AppMethodBeat.o(141741);
        return 0;
      }
      paramString = ((j)g.E(j.class)).YF().arR(paramString);
      if (paramString == null)
      {
        ab.i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cursor is null!cost %d ms count:%s ", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(j) });
        AppMethodBeat.o(141741);
        return j;
      }
      paramString.moveToFirst();
      int i = 0;
      if (!paramString.isAfterLast())
      {
        paramList = ((j)g.E(j.class)).YA().arw(paramString.getString(0));
        if ((paramList == null) || (paramList.dqK != 0)) {
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
        ab.i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cost %d ms count:%s mute:%s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(j), Integer.valueOf(i) });
        i = Math.max(0, j);
        AppMethodBeat.o(141741);
        return i;
      }
    }
  }
  
  public static int oM(String paramString)
  {
    AppMethodBeat.i(59880);
    int i = e(paramString, new LinkedList());
    AppMethodBeat.o(59880);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.u
 * JD-Core Version:    0.7.0.1
 */