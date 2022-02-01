package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class y
{
  private static final List<a> hIf;
  
  static
  {
    AppMethodBeat.i(42940);
    hIf = new ArrayList();
    AppMethodBeat.o(42940);
  }
  
  public static int Bk(String paramString)
  {
    AppMethodBeat.i(42933);
    if (!g.ajM())
    {
      ae.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
      AppMethodBeat.o(42933);
      return 0;
    }
    long l = bu.HQ();
    paramString = Bl(paramString).values().iterator();
    for (int i = 0; paramString.hasNext(); i = ((au)paramString.next()).field_unReadCount + i) {}
    ae.i("MicroMsg.ConversationLogic", "get count %d with black list use %d ms", new Object[] { Integer.valueOf(i), Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(42933);
    return i;
  }
  
  public static HashMap<String, au> Bl(String paramString)
  {
    AppMethodBeat.i(213410);
    long l = bu.HQ();
    Object localObject = ((l)g.ab(l.class)).azL().aVk(paramString);
    paramString = new HashMap();
    if (localObject == null)
    {
      AppMethodBeat.o(213410);
      return paramString;
    }
    HashSet localHashSet = new HashSet();
    while (((Cursor)localObject).moveToNext())
    {
      au localau = new au();
      localau.convertFrom((Cursor)localObject);
      localHashSet.add(localau.field_username);
      paramString.put(localau.field_username, localau);
    }
    ((Cursor)localObject).close();
    localObject = g(localHashSet).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.remove((String)((Iterator)localObject).next());
    }
    ae.i("MicroMsg.ConversationLogic", "[getUnreadConversation] cost %d ms  unread conversations: %s, stack:%s", new Object[] { Long.valueOf(bu.aO(l)), paramString.keySet(), bu.fpN() });
    AppMethodBeat.o(213410);
    return paramString;
  }
  
  public static Map<String, an> Bm(String paramString)
  {
    AppMethodBeat.i(213411);
    HashMap localHashMap = new HashMap();
    if (!g.ajM())
    {
      ae.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
      AppMethodBeat.o(213411);
      return localHashMap;
    }
    long l = bu.HQ();
    paramString = ((l)g.ab(l.class)).azL().aVl(paramString);
    if (paramString != null)
    {
      List localList = aBF();
      while (paramString.moveToNext())
      {
        an localan = new an();
        localan.convertFrom(paramString);
        if ((!localList.contains(localan.field_username)) && (!K(localan))) {
          localHashMap.put(localan.field_username, localan);
        } else {
          ae.d("MicroMsg.ConversationLogic", "ignore contact %s", new Object[] { localan.field_username });
        }
      }
      paramString.close();
    }
    ae.i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cost %d ms  unread contact: %s, stack %s", new Object[] { Long.valueOf(bu.aO(l)), localHashMap.keySet(), bu.fpN() });
    AppMethodBeat.o(213411);
    return localHashMap;
  }
  
  public static boolean Bn(String paramString)
  {
    AppMethodBeat.i(213413);
    if (!bu.isNullOrNil(paramString))
    {
      if (aBF().contains(paramString))
      {
        AppMethodBeat.o(213413);
        return true;
      }
      boolean bool = K(((l)g.ab(l.class)).azF().BH(paramString));
      AppMethodBeat.o(213413);
      return bool;
    }
    AppMethodBeat.o(213413);
    return false;
  }
  
  private static boolean K(an paraman)
  {
    AppMethodBeat.i(213414);
    if ((paraman != null) && ((int)paraman.ght != 0))
    {
      if ((paraman.Pd()) && (paraman.Zh()))
      {
        AppMethodBeat.o(213414);
        return true;
      }
      if ((x.wb(paraman.field_username)) && (paraman.eRd == 0))
      {
        AppMethodBeat.o(213414);
        return true;
      }
    }
    AppMethodBeat.o(213414);
    return false;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(42939);
    Assert.assertNotNull(parama);
    synchronized (hIf)
    {
      hIf.add(parama);
      AppMethodBeat.o(42939);
      return;
    }
  }
  
  public static List<String> aBF()
  {
    AppMethodBeat.i(213415);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("floatbottle");
    if (!g.ajR().ajA().getBoolean(am.a.IQE, true))
    {
      localArrayList.add("notifymessage");
      ae.d("MicroMsg.ConversationLogic", "add service notify message into show unread count blacklist.");
    }
    if (!g.ajR().ajA().getBoolean(am.a.IQF, true))
    {
      localArrayList.add("appbrandcustomerservicemsg");
      ae.d("MicroMsg.ConversationLogic", "add wxa custom session notify message into show unread count blacklist.");
    }
    localArrayList.add("appbrand_notify_message");
    localArrayList.add("officialaccounts");
    ae.d("MicroMsg.ConversationLogic", "getUnreadCountBlacklist blacklist(%s).", new Object[] { localArrayList });
    AppMethodBeat.o(213415);
    return localArrayList;
  }
  
  public static int aG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42935);
    if (!g.ajM())
    {
      ae.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
      AppMethodBeat.o(42935);
      return 0;
    }
    paramString1 = ((l)g.ab(l.class)).azL().mf(paramString1, paramString2);
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
  
  public static int aH(String paramString1, String paramString2)
  {
    int j = 0;
    AppMethodBeat.i(42938);
    if (bu.isNullOrNil(paramString1))
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
    List localList = hIf;
    i = 0;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (i >= hIf.size()) {
          break label172;
        }
        a locala = (a)hIf.get(i);
        if (locala == null) {
          break label181;
        }
        bool2 = locala.a(paramString1, paramString2, localPInt);
        bool1 = bool2;
        if (!bool2) {
          break label181;
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
      label172:
      boolean bool2 = bool1;
      i = j;
      continue;
      label181:
      i += 1;
    }
  }
  
  private static Set<String> g(Set<String> paramSet)
  {
    AppMethodBeat.i(213412);
    Object localObject = aBF();
    HashSet localHashSet = new HashSet((Collection)localObject);
    paramSet = new HashSet(paramSet);
    paramSet.removeAll((Collection)localObject);
    if (!paramSet.isEmpty())
    {
      paramSet = ((l)g.ab(l.class)).azF().hH(new ArrayList(paramSet));
      if (paramSet != null)
      {
        while (paramSet.moveToNext())
        {
          localObject = new an();
          ((an)localObject).convertFrom(paramSet);
          if (K((an)localObject))
          {
            ae.d("MicroMsg.ConversationLogic", "ignore contact %s", new Object[] { ((aw)localObject).field_username });
            localHashSet.add(((aw)localObject).field_username);
          }
        }
        paramSet.close();
      }
    }
    AppMethodBeat.o(213412);
    return localHashSet;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(String paramString1, String paramString2, PInt paramPInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.y
 * JD-Core Version:    0.7.0.1
 */