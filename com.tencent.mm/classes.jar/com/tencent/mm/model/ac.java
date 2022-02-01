package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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
  private static final List<a> lsP;
  
  static
  {
    AppMethodBeat.i(42940);
    lsP = new ArrayList();
    AppMethodBeat.o(42940);
  }
  
  private static boolean R(as paramas)
  {
    AppMethodBeat.i(239641);
    if ((paramas != null) && ((int)paramas.jxt != 0))
    {
      if ((paramas.aeg()) && (paramas.asV()))
      {
        AppMethodBeat.o(239641);
        return true;
      }
      if ((ab.Lj(paramas.field_username)) && (paramas.hDj == 0))
      {
        AppMethodBeat.o(239641);
        return true;
      }
    }
    AppMethodBeat.o(239641);
    return false;
  }
  
  public static Map<String, as> Rj(String paramString)
  {
    AppMethodBeat.i(239627);
    HashMap localHashMap = new HashMap();
    if (!h.aHB())
    {
      Log.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
      AppMethodBeat.o(239627);
      return localHashMap;
    }
    long l = Util.currentTicks();
    paramString = ((n)h.ae(n.class)).bbR().bwH(paramString);
    if (paramString != null)
    {
      List localList = beg();
      while (paramString.moveToNext())
      {
        as localas = new as();
        localas.convertFrom(paramString);
        if ((!localList.contains(localas.field_username)) && (!R(localas))) {
          localHashMap.put(localas.field_username, localas);
        } else {
          Log.d("MicroMsg.ConversationLogic", "ignore contact %s", new Object[] { localas.field_username });
        }
      }
      paramString.close();
    }
    Log.i("MicroMsg.ConversationLogic", "[getTotalUnreadTalker] cost %d ms  unread contact: %s, stack %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), localHashMap.keySet(), Util.getStack() });
    AppMethodBeat.o(239627);
    return localHashMap;
  }
  
  public static boolean Rk(String paramString)
  {
    AppMethodBeat.i(239635);
    if (!Util.isNullOrNil(paramString))
    {
      if (beg().contains(paramString))
      {
        AppMethodBeat.o(239635);
        return true;
      }
      boolean bool = R(ab.Ri(paramString));
      AppMethodBeat.o(239635);
      return bool;
    }
    AppMethodBeat.o(239635);
    return false;
  }
  
  public static int Rl(String paramString)
  {
    AppMethodBeat.i(239652);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(239652);
      return 0;
    }
    if (ab.Lj(paramString))
    {
      if (ab.Rb(paramString))
      {
        AppMethodBeat.o(239652);
        return 3;
      }
      AppMethodBeat.o(239652);
      return 4;
    }
    if (ab.QL(paramString))
    {
      AppMethodBeat.o(239652);
      return 5;
    }
    if ((ab.QU(paramString)) || (ab.QV(paramString)) || (ab.QQ(paramString)))
    {
      AppMethodBeat.o(239652);
      return 7;
    }
    if (ab.QS(paramString))
    {
      AppMethodBeat.o(239652);
      return 8;
    }
    if (ab.Qm(paramString))
    {
      AppMethodBeat.o(239652);
      return 6;
    }
    if (ab.Rc(paramString))
    {
      AppMethodBeat.o(239652);
      return 2;
    }
    AppMethodBeat.o(239652);
    return 1;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(42939);
    Assert.assertNotNull(parama);
    synchronized (lsP)
    {
      lsP.add(parama);
      AppMethodBeat.o(42939);
      return;
    }
  }
  
  public static int aM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42935);
    if (!h.aHB())
    {
      Log.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
      AppMethodBeat.o(42935);
      return 0;
    }
    paramString1 = ((n)h.ae(n.class)).bbR().nK(paramString1, paramString2);
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
  
  public static int aN(String paramString1, String paramString2)
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
    List localList = lsP;
    i = 0;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (i < lsP.size())
        {
          a locala = (a)lsP.get(i);
          if (locala != null)
          {
            bool2 = locala.a(paramString1, paramString2, localPInt);
            bool1 = bool2;
            if (bool2)
            {
              i = localPInt.value;
              if (bool2) {
                break label170;
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
      label170:
      boolean bool2 = bool1;
      i = j;
    }
  }
  
  public static List<String> beg()
  {
    AppMethodBeat.i(239649);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("floatbottle");
    if (!h.aHG().aHp().getBoolean(ar.a.VmF, true))
    {
      localArrayList.add("notifymessage");
      Log.d("MicroMsg.ConversationLogic", "add service notify message into show unread count blacklist.");
    }
    if (!h.aHG().aHp().getBoolean(ar.a.VmG, true))
    {
      localArrayList.add("appbrandcustomerservicemsg");
      Log.d("MicroMsg.ConversationLogic", "add wxa custom session notify message into show unread count blacklist.");
    }
    localArrayList.add("appbrand_notify_message");
    localArrayList.add("officialaccounts");
    Log.d("MicroMsg.ConversationLogic", "getUnreadCountBlacklist blacklist(%s).", new Object[] { localArrayList });
    AppMethodBeat.o(239649);
    return localArrayList;
  }
  
  private static Set<String> g(Set<String> paramSet)
  {
    AppMethodBeat.i(239631);
    Object localObject = beg();
    HashSet localHashSet = new HashSet((Collection)localObject);
    paramSet = new HashSet(paramSet);
    paramSet.removeAll((Collection)localObject);
    if (!paramSet.isEmpty())
    {
      paramSet = ((n)h.ae(n.class)).bbL().jD(new ArrayList(paramSet));
      if (paramSet != null)
      {
        while (paramSet.moveToNext())
        {
          localObject = new as();
          ((as)localObject).convertFrom(paramSet);
          if (R((as)localObject))
          {
            Log.d("MicroMsg.ConversationLogic", "ignore contact %s", new Object[] { ((ax)localObject).field_username });
            localHashSet.add(((ax)localObject).field_username);
          }
        }
        paramSet.close();
      }
    }
    AppMethodBeat.o(239631);
    return localHashSet;
  }
  
  public static int uM(int paramInt)
  {
    AppMethodBeat.i(239618);
    if (!h.aHB())
    {
      Log.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
      AppMethodBeat.o(239618);
      return 0;
    }
    long l = Util.currentTicks();
    Iterator localIterator = uN(paramInt).values().iterator();
    for (paramInt = 0; localIterator.hasNext(); paramInt = ((az)localIterator.next()).field_unReadCount + paramInt) {}
    Log.i("MicroMsg.ConversationLogic", "get count %d with black list use %d ms", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(239618);
    return paramInt;
  }
  
  public static HashMap<String, az> uN(int paramInt)
  {
    AppMethodBeat.i(239621);
    long l = Util.currentTicks();
    Object localObject = ((n)h.ae(n.class)).bbR().asE(paramInt);
    HashMap localHashMap = new HashMap();
    if (localObject == null)
    {
      AppMethodBeat.o(239621);
      return localHashMap;
    }
    HashSet localHashSet = new HashSet();
    while (((Cursor)localObject).moveToNext())
    {
      az localaz = new az();
      localaz.convertFrom((Cursor)localObject);
      localHashSet.add(localaz.field_username);
      localHashMap.put(localaz.field_username, localaz);
    }
    ((Cursor)localObject).close();
    localObject = g(localHashSet).iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashMap.remove((String)((Iterator)localObject).next());
    }
    Log.i("MicroMsg.ConversationLogic", "[getUnreadConversation] cost %d ms  unread conversations: %s, stack:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), localHashMap.keySet(), Util.getStack() });
    AppMethodBeat.o(239621);
    return localHashMap;
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