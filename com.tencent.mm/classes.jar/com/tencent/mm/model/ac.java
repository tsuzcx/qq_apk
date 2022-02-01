package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
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
  private static final List<a> iCP;
  
  static
  {
    AppMethodBeat.i(42940);
    iCP = new ArrayList();
    AppMethodBeat.o(42940);
  }
  
  public static int JP(String paramString)
  {
    AppMethodBeat.i(42933);
    if (!g.aAc())
    {
      Log.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
      AppMethodBeat.o(42933);
      return 0;
    }
    long l = Util.currentTicks();
    paramString = JQ(paramString).values().iterator();
    for (int i = 0; paramString.hasNext(); i = ((az)paramString.next()).field_unReadCount + i) {}
    Log.i("MicroMsg.ConversationLogic", "get count %d with black list use %d ms", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(42933);
    return i;
  }
  
  public static HashMap<String, az> JQ(String paramString)
  {
    AppMethodBeat.i(225943);
    long l = Util.currentTicks();
    Object localObject = ((l)g.af(l.class)).aST().bki(paramString);
    paramString = new HashMap();
    if (localObject == null)
    {
      AppMethodBeat.o(225943);
      return paramString;
    }
    HashSet localHashSet = new HashSet();
    while (((Cursor)localObject).moveToNext())
    {
      az localaz = new az();
      localaz.convertFrom((Cursor)localObject);
      localHashSet.add(localaz.field_username);
      paramString.put(localaz.field_username, localaz);
    }
    ((Cursor)localObject).close();
    localObject = g(localHashSet).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.remove((String)((Iterator)localObject).next());
    }
    Log.i("MicroMsg.ConversationLogic", "[getUnreadConversation] cost %d ms  unread conversations: %s, stack:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), paramString.keySet(), Util.getStack() });
    AppMethodBeat.o(225943);
    return paramString;
  }
  
  public static Map<String, as> JR(String paramString)
  {
    AppMethodBeat.i(225944);
    HashMap localHashMap = new HashMap();
    if (!g.aAc())
    {
      Log.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
      AppMethodBeat.o(225944);
      return localHashMap;
    }
    long l = Util.currentTicks();
    paramString = ((l)g.af(l.class)).aST().bkj(paramString);
    if (paramString != null)
    {
      List localList = aVd();
      while (paramString.moveToNext())
      {
        as localas = new as();
        localas.convertFrom(paramString);
        if ((!localList.contains(localas.field_username)) && (!K(localas))) {
          localHashMap.put(localas.field_username, localas);
        } else {
          Log.d("MicroMsg.ConversationLogic", "ignore contact %s", new Object[] { localas.field_username });
        }
      }
      paramString.close();
    }
    Log.i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cost %d ms  unread contact: %s, stack %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), localHashMap.keySet(), Util.getStack() });
    AppMethodBeat.o(225944);
    return localHashMap;
  }
  
  public static boolean JS(String paramString)
  {
    AppMethodBeat.i(225946);
    if (!Util.isNullOrNil(paramString))
    {
      if (aVd().contains(paramString))
      {
        AppMethodBeat.o(225946);
        return true;
      }
      boolean bool = K(((l)g.af(l.class)).aSN().Kn(paramString));
      AppMethodBeat.o(225946);
      return bool;
    }
    AppMethodBeat.o(225946);
    return false;
  }
  
  public static int JT(String paramString)
  {
    AppMethodBeat.i(225949);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(225949);
      return 0;
    }
    if (ab.Eq(paramString))
    {
      if (ab.JI(paramString))
      {
        AppMethodBeat.o(225949);
        return 3;
      }
      AppMethodBeat.o(225949);
      return 4;
    }
    if (ab.Js(paramString))
    {
      AppMethodBeat.o(225949);
      return 5;
    }
    if ((ab.JB(paramString)) || (ab.JC(paramString)) || (ab.Jx(paramString)))
    {
      AppMethodBeat.o(225949);
      return 7;
    }
    if (ab.Jz(paramString))
    {
      AppMethodBeat.o(225949);
      return 8;
    }
    if (ab.IT(paramString))
    {
      AppMethodBeat.o(225949);
      return 6;
    }
    if (ab.JJ(paramString))
    {
      AppMethodBeat.o(225949);
      return 2;
    }
    AppMethodBeat.o(225949);
    return 1;
  }
  
  private static boolean K(as paramas)
  {
    AppMethodBeat.i(225947);
    if ((paramas != null) && ((int)paramas.gMZ != 0))
    {
      if ((paramas.Zx()) && (paramas.amU()))
      {
        AppMethodBeat.o(225947);
        return true;
      }
      if ((ab.Eq(paramas.field_username)) && (paramas.fuH == 0))
      {
        AppMethodBeat.o(225947);
        return true;
      }
    }
    AppMethodBeat.o(225947);
    return false;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(42939);
    Assert.assertNotNull(parama);
    synchronized (iCP)
    {
      iCP.add(parama);
      AppMethodBeat.o(42939);
      return;
    }
  }
  
  public static int aI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42935);
    if (!g.aAc())
    {
      Log.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
      AppMethodBeat.o(42935);
      return 0;
    }
    paramString1 = ((l)g.af(l.class)).aST().mT(paramString1, paramString2);
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
  
  public static int aJ(String paramString1, String paramString2)
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
    List localList = iCP;
    i = 0;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (i >= iCP.size()) {
          break label172;
        }
        a locala = (a)iCP.get(i);
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
  
  public static List<String> aVd()
  {
    AppMethodBeat.i(225948);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("floatbottle");
    if (!g.aAh().azQ().getBoolean(ar.a.NYF, true))
    {
      localArrayList.add("notifymessage");
      Log.d("MicroMsg.ConversationLogic", "add service notify message into show unread count blacklist.");
    }
    if (!g.aAh().azQ().getBoolean(ar.a.NYG, true))
    {
      localArrayList.add("appbrandcustomerservicemsg");
      Log.d("MicroMsg.ConversationLogic", "add wxa custom session notify message into show unread count blacklist.");
    }
    localArrayList.add("appbrand_notify_message");
    localArrayList.add("officialaccounts");
    Log.d("MicroMsg.ConversationLogic", "getUnreadCountBlacklist blacklist(%s).", new Object[] { localArrayList });
    AppMethodBeat.o(225948);
    return localArrayList;
  }
  
  private static Set<String> g(Set<String> paramSet)
  {
    AppMethodBeat.i(225945);
    Object localObject = aVd();
    HashSet localHashSet = new HashSet((Collection)localObject);
    paramSet = new HashSet(paramSet);
    paramSet.removeAll((Collection)localObject);
    if (!paramSet.isEmpty())
    {
      paramSet = ((l)g.af(l.class)).aSN().iL(new ArrayList(paramSet));
      if (paramSet != null)
      {
        while (paramSet.moveToNext())
        {
          localObject = new as();
          ((as)localObject).convertFrom(paramSet);
          if (K((as)localObject))
          {
            Log.d("MicroMsg.ConversationLogic", "ignore contact %s", new Object[] { ((ax)localObject).field_username });
            localHashSet.add(((ax)localObject).field_username);
          }
        }
        paramSet.close();
      }
    }
    AppMethodBeat.o(225945);
    return localHashSet;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(String paramString1, String paramString2, PInt paramPInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ac
 * JD-Core Version:    0.7.0.1
 */