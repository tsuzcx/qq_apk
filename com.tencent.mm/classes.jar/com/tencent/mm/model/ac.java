package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class ac
{
  private static final List<a> okp;
  
  static
  {
    AppMethodBeat.i(42940);
    okp = new ArrayList();
    AppMethodBeat.o(42940);
  }
  
  public static Map<String, au> Jh(String paramString)
  {
    AppMethodBeat.i(242070);
    HashMap localHashMap = new HashMap();
    if (!h.baz())
    {
      Log.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
      AppMethodBeat.o(242070);
      return localHashMap;
    }
    long l = Util.currentTicks();
    paramString = ((n)h.ax(n.class)).bzG().bya(paramString);
    if (paramString != null)
    {
      List localList = bCa();
      while (paramString.moveToNext())
      {
        au localau = new au();
        localau.convertFrom(paramString);
        if ((!localList.contains(localau.field_username)) && (!S(localau))) {
          localHashMap.put(localau.field_username, localau);
        } else {
          Log.d("MicroMsg.ConversationLogic", "ignore contact %s", new Object[] { localau.field_username });
        }
      }
      paramString.close();
    }
    Log.i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cost %d ms  unread contact: %s, stack %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), localHashMap.keySet(), Util.getStack() });
    AppMethodBeat.o(242070);
    return localHashMap;
  }
  
  public static boolean Ji(String paramString)
  {
    AppMethodBeat.i(242080);
    if (!Util.isNullOrNil(paramString))
    {
      if (bCa().contains(paramString))
      {
        AppMethodBeat.o(242080);
        return true;
      }
      boolean bool = S(ab.Jg(paramString));
      AppMethodBeat.o(242080);
      return bool;
    }
    AppMethodBeat.o(242080);
    return false;
  }
  
  public static int Jj(String paramString)
  {
    AppMethodBeat.i(242095);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(242095);
      return 0;
    }
    if (au.bwE(paramString))
    {
      if (ab.IZ(paramString))
      {
        AppMethodBeat.o(242095);
        return 3;
      }
      AppMethodBeat.o(242095);
      return 4;
    }
    if (au.bwp(paramString))
    {
      AppMethodBeat.o(242095);
      return 5;
    }
    if ((au.bwy(paramString)) || (au.bwA(paramString)) || (au.bwu(paramString)))
    {
      AppMethodBeat.o(242095);
      return 7;
    }
    if (au.bwD(paramString))
    {
      AppMethodBeat.o(242095);
      return 9;
    }
    if (au.bww(paramString))
    {
      AppMethodBeat.o(242095);
      return 8;
    }
    if (ab.IS(paramString))
    {
      AppMethodBeat.o(242095);
      return 6;
    }
    if (au.bwQ(paramString))
    {
      AppMethodBeat.o(242095);
      return 10;
    }
    if (ab.Ja(paramString))
    {
      AppMethodBeat.o(242095);
      return 2;
    }
    AppMethodBeat.o(242095);
    return 1;
  }
  
  public static void Jk(String paramString)
  {
    AppMethodBeat.i(242099);
    bb localbb = ((n)h.ax(n.class)).bzG().bxM(paramString);
    if ((localbb != null) && ((Util.isNullOrNil(localbb.field_parentRef)) || ("message_fold".equalsIgnoreCase(localbb.field_parentRef)) || ("conversationboxservice".equalsIgnoreCase(localbb.field_parentRef))))
    {
      ((n)h.ax(n.class)).bzG().e(new String[] { paramString }, "hidden_conv_parent");
      AppMethodBeat.o(242099);
      return;
    }
    ((n)h.ax(n.class)).bzG().bxK(paramString);
    AppMethodBeat.o(242099);
  }
  
  private static boolean S(au paramau)
  {
    AppMethodBeat.i(242083);
    if ((paramau != null) && ((int)paramau.maN != 0))
    {
      if ((paramau.aGe()) && (paramau.aMW()))
      {
        AppMethodBeat.o(242083);
        return true;
      }
      if ((au.bwE(paramau.field_username)) && (paramau.kaf == 0))
      {
        AppMethodBeat.o(242083);
        return true;
      }
    }
    AppMethodBeat.o(242083);
    return false;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(42939);
    Assert.assertNotNull(parama);
    synchronized (okp)
    {
      okp.add(parama);
      AppMethodBeat.o(42939);
      return;
    }
  }
  
  public static int aX(String paramString1, String paramString2)
  {
    int j = 0;
    AppMethodBeat.i(42938);
    if (Util.isNullOrNil(paramString1))
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
    List localList = okp;
    i = 0;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (i < okp.size())
        {
          a locala = (a)okp.get(i);
          if (locala != null)
          {
            bool2 = locala.a(paramString1, paramString2, localPInt);
            bool1 = bool2;
            if (bool2)
            {
              i = localPInt.value;
              if (bool2) {
                break label172;
              }
              i = 1;
              break;
            }
          }
          i += 1;
          continue;
          break;
        }
      }
      finally
      {
        AppMethodBeat.o(42938);
      }
      label172:
      boolean bool2 = bool1;
      i = j;
    }
  }
  
  public static int b(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(242062);
    if (!h.baz())
    {
      Log.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
      AppMethodBeat.o(242062);
      return 0;
    }
    Cursor localCursor = ((n)h.ax(n.class)).bzG().bxZ(paramString);
    if ((localCursor != null) && (localCursor.getCount() > 0))
    {
      localCursor.moveToFirst();
      String str = localCursor.getString(1);
      if ((!((n)h.ax(n.class)).bzG().bxR(str)) || (!ab.b(paramArrayOfString, paramString))) {}
    }
    for (int i = localCursor.getInt(0);; i = 0)
    {
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(242062);
      return i;
    }
  }
  
  public static int bBY()
  {
    AppMethodBeat.i(242052);
    if (!h.baz())
    {
      Log.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
      AppMethodBeat.o(242052);
      return 0;
    }
    long l = Util.currentTicks();
    Iterator localIterator = bBZ().values().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((bb)localIterator.next()).field_unReadCount + i) {}
    Log.i("MicroMsg.ConversationLogic", "get count %d with black list use %d ms", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(242052);
    return i;
  }
  
  public static HashMap<String, bb> bBZ()
  {
    AppMethodBeat.i(242057);
    long l = Util.currentTicks();
    Object localObject = ((n)h.ax(n.class)).bzG().ayU(1);
    HashMap localHashMap = new HashMap();
    if (localObject == null)
    {
      AppMethodBeat.o(242057);
      return localHashMap;
    }
    HashSet localHashSet = new HashSet();
    while (((Cursor)localObject).moveToNext())
    {
      bb localbb = new bb();
      localbb.convertFrom((Cursor)localObject);
      localHashSet.add(localbb.field_username);
      localHashMap.put(localbb.field_username, localbb);
    }
    ((Cursor)localObject).close();
    localObject = n(localHashSet).iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashMap.remove((String)((Iterator)localObject).next());
    }
    Log.i("MicroMsg.ConversationLogic", "[getUnreadConversation] cost %d ms  unread conversations: %s, stack:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), localHashMap.keySet(), Util.getStack() });
    AppMethodBeat.o(242057);
    return localHashMap;
  }
  
  public static List<String> bCa()
  {
    AppMethodBeat.i(242091);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("floatbottle");
    if (!h.baE().ban().getBoolean(at.a.acOa, true))
    {
      localArrayList.add("notifymessage");
      Log.d("MicroMsg.ConversationLogic", "add service notify message into show unread count blacklist.");
    }
    if (!h.baE().ban().getBoolean(at.a.acOb, true))
    {
      localArrayList.add("appbrandcustomerservicemsg");
      Log.d("MicroMsg.ConversationLogic", "add wxa custom session notify message into show unread count blacklist.");
    }
    localArrayList.add("appbrand_notify_message");
    localArrayList.add("officialaccounts");
    localArrayList.add("conversationboxservice");
    Log.d("MicroMsg.ConversationLogic", "getUnreadCountBlacklist blacklist(%s).", new Object[] { localArrayList });
    AppMethodBeat.o(242091);
    return localArrayList;
  }
  
  private static Set<String> n(Set<String> paramSet)
  {
    AppMethodBeat.i(242076);
    Object localObject = bCa();
    HashSet localHashSet = new HashSet((Collection)localObject);
    paramSet = new HashSet(paramSet);
    paramSet.removeAll((Collection)localObject);
    if (!paramSet.isEmpty())
    {
      paramSet = ((n)h.ax(n.class)).bzA().mQ(new ArrayList(paramSet));
      if (paramSet != null)
      {
        while (paramSet.moveToNext())
        {
          localObject = new au();
          ((au)localObject).convertFrom(paramSet);
          if (S((au)localObject))
          {
            Log.d("MicroMsg.ConversationLogic", "ignore contact %s", new Object[] { ((az)localObject).field_username });
            localHashSet.add(((az)localObject).field_username);
          }
        }
        paramSet.close();
      }
    }
    AppMethodBeat.o(242076);
    return localHashSet;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(String paramString1, String paramString2, PInt paramPInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ac
 * JD-Core Version:    0.7.0.1
 */