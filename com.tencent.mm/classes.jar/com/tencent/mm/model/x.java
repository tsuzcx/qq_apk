package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class x
{
  private static final List<a> hFn;
  
  static
  {
    AppMethodBeat.i(42940);
    hFn = new ArrayList();
    AppMethodBeat.o(42940);
  }
  
  public static int AA(String paramString)
  {
    AppMethodBeat.i(42933);
    if (!g.ajx())
    {
      ad.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
      AppMethodBeat.o(42933);
      return 0;
    }
    long l = bt.HI();
    paramString = AB(paramString).values().iterator();
    for (int i = 0; paramString.hasNext(); i = ((at)paramString.next()).field_unReadCount + i) {}
    ad.i("MicroMsg.ConversationLogic", "get count %d with black list use %d ms", new Object[] { Integer.valueOf(i), Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(42933);
    return i;
  }
  
  public static HashMap<String, at> AB(String paramString)
  {
    AppMethodBeat.i(192536);
    long l = bt.HI();
    Object localObject = ((l)g.ab(l.class)).azv().aTJ(paramString);
    paramString = new HashMap();
    if (localObject == null)
    {
      AppMethodBeat.o(192536);
      return paramString;
    }
    HashSet localHashSet = new HashSet();
    while (((Cursor)localObject).moveToNext())
    {
      at localat = new at();
      localat.convertFrom((Cursor)localObject);
      localHashSet.add(localat.field_username);
      paramString.put(localat.field_username, localat);
    }
    ((Cursor)localObject).close();
    localObject = g(localHashSet).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.remove((String)((Iterator)localObject).next());
    }
    ad.i("MicroMsg.ConversationLogic", "[getUnreadConversation] cost %d ms  unread conversations: %s, stack:%s", new Object[] { Long.valueOf(bt.aO(l)), paramString.keySet(), bt.flS() });
    AppMethodBeat.o(192536);
    return paramString;
  }
  
  public static Map<String, am> AC(String paramString)
  {
    AppMethodBeat.i(192537);
    HashMap localHashMap = new HashMap();
    if (!g.ajx())
    {
      ad.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
      AppMethodBeat.o(192537);
      return localHashMap;
    }
    long l = bt.HI();
    paramString = ((l)g.ab(l.class)).azv().aTK(paramString);
    if (paramString != null)
    {
      List localList = aBp();
      while (paramString.moveToNext())
      {
        am localam = new am();
        localam.convertFrom(paramString);
        if ((!localList.contains(localam.field_username)) && (!D(localam))) {
          localHashMap.put(localam.field_username, localam);
        } else {
          ad.d("MicroMsg.ConversationLogic", "ignore contact %s", new Object[] { localam.field_username });
        }
      }
      paramString.close();
    }
    ad.i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cost %d ms  unread contact: %s, stack %s", new Object[] { Long.valueOf(bt.aO(l)), localHashMap.keySet(), bt.flS() });
    AppMethodBeat.o(192537);
    return localHashMap;
  }
  
  public static boolean AD(String paramString)
  {
    AppMethodBeat.i(192539);
    if (!bt.isNullOrNil(paramString))
    {
      if (aBp().contains(paramString))
      {
        AppMethodBeat.o(192539);
        return true;
      }
      boolean bool = D(((l)g.ab(l.class)).azp().Bf(paramString));
      AppMethodBeat.o(192539);
      return bool;
    }
    AppMethodBeat.o(192539);
    return false;
  }
  
  private static boolean D(am paramam)
  {
    AppMethodBeat.i(192540);
    if ((paramam != null) && ((int)paramam.gfj != 0))
    {
      if ((paramam.Pf()) && (paramam.YY()))
      {
        AppMethodBeat.o(192540);
        return true;
      }
      if ((w.vF(paramam.field_username)) && (paramam.ePs == 0))
      {
        AppMethodBeat.o(192540);
        return true;
      }
    }
    AppMethodBeat.o(192540);
    return false;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(42939);
    Assert.assertNotNull(parama);
    synchronized (hFn)
    {
      hFn.add(parama);
      AppMethodBeat.o(42939);
      return;
    }
  }
  
  public static List<String> aBp()
  {
    AppMethodBeat.i(192541);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("floatbottle");
    if (!g.ajC().ajl().getBoolean(al.a.Iwg, true))
    {
      localArrayList.add("notifymessage");
      ad.d("MicroMsg.ConversationLogic", "add service notify message into show unread count blacklist.");
    }
    if (!g.ajC().ajl().getBoolean(al.a.Iwh, true))
    {
      localArrayList.add("appbrandcustomerservicemsg");
      ad.d("MicroMsg.ConversationLogic", "add wxa custom session notify message into show unread count blacklist.");
    }
    localArrayList.add("appbrand_notify_message");
    localArrayList.add("officialaccounts");
    ad.d("MicroMsg.ConversationLogic", "getUnreadCountBlacklist blacklist(%s).", new Object[] { localArrayList });
    AppMethodBeat.o(192541);
    return localArrayList;
  }
  
  public static int aF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42935);
    if (!g.ajx())
    {
      ad.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
      AppMethodBeat.o(42935);
      return 0;
    }
    paramString1 = ((l)g.ab(l.class)).azv().lY(paramString1, paramString2);
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
  
  public static int aG(String paramString1, String paramString2)
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
    List localList = hFn;
    i = 0;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (i >= hFn.size()) {
          break label172;
        }
        a locala = (a)hFn.get(i);
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
    AppMethodBeat.i(192538);
    Object localObject = aBp();
    HashSet localHashSet = new HashSet((Collection)localObject);
    paramSet = new HashSet(paramSet);
    paramSet.removeAll((Collection)localObject);
    if (!paramSet.isEmpty())
    {
      paramSet = ((l)g.ab(l.class)).azp().hx(new ArrayList(paramSet));
      if (paramSet != null)
      {
        while (paramSet.moveToNext())
        {
          localObject = new am();
          ((am)localObject).convertFrom(paramSet);
          if (D((am)localObject))
          {
            ad.d("MicroMsg.ConversationLogic", "ignore contact %s", new Object[] { ((aw)localObject).field_username });
            localHashSet.add(((aw)localObject).field_username);
          }
        }
        paramSet.close();
      }
    }
    AppMethodBeat.o(192538);
    return localHashSet;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(String paramString1, String paramString2, PInt paramPInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.x
 * JD-Core Version:    0.7.0.1
 */