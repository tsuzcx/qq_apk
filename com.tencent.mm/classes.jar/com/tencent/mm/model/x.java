package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.az;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
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
  private static final List<a> hmX;
  
  static
  {
    AppMethodBeat.i(42940);
    hmX = new ArrayList();
    AppMethodBeat.o(42940);
  }
  
  private static boolean D(ai paramai)
  {
    AppMethodBeat.i(194038);
    if ((paramai != null) && ((int)paramai.fLJ != 0))
    {
      if ((paramai.Nw()) && (paramai.WE()))
      {
        AppMethodBeat.o(194038);
        return true;
      }
      if ((w.sQ(paramai.field_username)) && (paramai.exT == 0))
      {
        AppMethodBeat.o(194038);
        return true;
      }
    }
    AppMethodBeat.o(194038);
    return false;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(42939);
    Assert.assertNotNull(parama);
    synchronized (hmX)
    {
      hmX.add(parama);
      AppMethodBeat.o(42939);
      return;
    }
  }
  
  public static int aD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42935);
    if (!g.agM())
    {
      ac.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
      AppMethodBeat.o(42935);
      return 0;
    }
    paramString1 = ((k)g.ab(k.class)).awG().lA(paramString1, paramString2);
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
  
  public static int aE(String paramString1, String paramString2)
  {
    int j = 0;
    AppMethodBeat.i(42938);
    if (bs.isNullOrNil(paramString1))
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
    List localList = hmX;
    i = 0;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (i >= hmX.size()) {
          break label166;
        }
        a locala = (a)hmX.get(i);
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
  
  public static List<String> ayp()
  {
    AppMethodBeat.i(194039);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("floatbottle");
    if (!g.agR().agA().getBoolean(ah.a.GJO, true))
    {
      localArrayList.add("notifymessage");
      ac.d("MicroMsg.ConversationLogic", "add service notify message into show unread count blacklist.");
    }
    if (!g.agR().agA().getBoolean(ah.a.GJP, true))
    {
      localArrayList.add("appbrandcustomerservicemsg");
      ac.d("MicroMsg.ConversationLogic", "add wxa custom session notify message into show unread count blacklist.");
    }
    localArrayList.add("appbrand_notify_message");
    localArrayList.add("officialaccounts");
    ac.d("MicroMsg.ConversationLogic", "getUnreadCountBlacklist blacklist(%s).", new Object[] { localArrayList });
    AppMethodBeat.o(194039);
    return localArrayList;
  }
  
  private static Set<String> c(Set<String> paramSet)
  {
    AppMethodBeat.i(194036);
    Object localObject = ayp();
    HashSet localHashSet = new HashSet((Collection)localObject);
    paramSet = new HashSet(paramSet);
    paramSet.removeAll((Collection)localObject);
    if (!paramSet.isEmpty())
    {
      paramSet = ((k)g.ab(k.class)).awB().hl(new ArrayList(paramSet));
      if (paramSet != null)
      {
        paramSet.moveToFirst();
        while (!paramSet.isAfterLast())
        {
          localObject = new ai();
          ((ai)localObject).convertFrom(paramSet);
          if (D((ai)localObject))
          {
            ac.d("MicroMsg.ConversationLogic", "ignore contact %s", new Object[] { ((av)localObject).field_username });
            localHashSet.add(((av)localObject).field_username);
          }
          paramSet.moveToNext();
        }
        paramSet.close();
      }
    }
    AppMethodBeat.o(194036);
    return localHashSet;
  }
  
  public static int xC(String paramString)
  {
    AppMethodBeat.i(42933);
    if (!g.agM())
    {
      ac.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
      AppMethodBeat.o(42933);
      return 0;
    }
    long l = bs.Gn();
    paramString = xD(paramString).values().iterator();
    for (int i = 0; paramString.hasNext(); i = ((ap)paramString.next()).field_unReadCount + i) {}
    ac.i("MicroMsg.ConversationLogic", "get count %d with black list use %d ms", new Object[] { Integer.valueOf(i), Long.valueOf(bs.aO(l)) });
    AppMethodBeat.o(42933);
    return i;
  }
  
  public static HashMap<String, ap> xD(String paramString)
  {
    AppMethodBeat.i(194034);
    long l = bs.Gn();
    Object localObject = ((k)g.ab(k.class)).awG().aNS(paramString);
    paramString = new HashMap();
    if (localObject == null)
    {
      AppMethodBeat.o(194034);
      return paramString;
    }
    HashSet localHashSet = new HashSet();
    ((Cursor)localObject).moveToFirst();
    while (!((Cursor)localObject).isAfterLast())
    {
      ap localap = new ap();
      localap.convertFrom((Cursor)localObject);
      localHashSet.add(localap.field_username);
      paramString.put(localap.field_username, localap);
      ((Cursor)localObject).moveToNext();
    }
    ((Cursor)localObject).close();
    localObject = c(localHashSet).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.remove((String)((Iterator)localObject).next());
    }
    ac.i("MicroMsg.ConversationLogic", "[getUnreadConversation] cost %d ms  unread conversations: %s, stack:%s", new Object[] { Long.valueOf(bs.aO(l)), paramString.keySet(), bs.eWi() });
    AppMethodBeat.o(194034);
    return paramString;
  }
  
  public static Map<String, ai> xE(String paramString)
  {
    AppMethodBeat.i(194035);
    HashMap localHashMap = new HashMap();
    if (!g.agM())
    {
      ac.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
      AppMethodBeat.o(194035);
      return localHashMap;
    }
    long l = bs.Gn();
    paramString = ((k)g.ab(k.class)).awG().aNT(paramString);
    if (paramString != null)
    {
      List localList = ayp();
      paramString.moveToFirst();
      if (!paramString.isAfterLast())
      {
        ai localai = new ai();
        localai.convertFrom(paramString);
        if ((!localList.contains(localai.field_username)) && (!D(localai))) {
          localHashMap.put(localai.field_username, localai);
        }
        for (;;)
        {
          paramString.moveToNext();
          break;
          ac.d("MicroMsg.ConversationLogic", "ignore contact %s", new Object[] { localai.field_username });
        }
      }
      paramString.close();
    }
    ac.i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cost %d ms  unread contact: %s, stack %s", new Object[] { Long.valueOf(bs.aO(l)), localHashMap.keySet(), bs.eWi() });
    AppMethodBeat.o(194035);
    return localHashMap;
  }
  
  public static boolean xF(String paramString)
  {
    AppMethodBeat.i(194037);
    if (!bs.isNullOrNil(paramString))
    {
      if (ayp().contains(paramString))
      {
        AppMethodBeat.o(194037);
        return true;
      }
      boolean bool = D(((k)g.ab(k.class)).awB().aNt(paramString));
      AppMethodBeat.o(194037);
      return bool;
    }
    AppMethodBeat.o(194037);
    return false;
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