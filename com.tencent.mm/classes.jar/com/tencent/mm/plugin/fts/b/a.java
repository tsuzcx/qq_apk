package com.tencent.mm.plugin.fts.b;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yn;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.wcdb.database.SQLiteStatement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import junit.framework.AssertionFailedError;

public final class a
  extends com.tencent.mm.plugin.fts.a.b
{
  private static Set<String> wYj;
  private com.tencent.mm.plugin.fts.a.m hgI;
  private com.tencent.mm.plugin.fts.a.j tbO;
  private com.tencent.mm.plugin.fts.c.a wXV;
  private HashSet<String> wXW;
  private HashMap<String, List<Long>> wXX;
  private HashMap<String, String[]> wXY;
  private HashMap<String, List<Long>> wXZ;
  private Method wYa;
  private MStorageEx.IOnStorageChange wYb;
  private MStorageEx.IOnStorageChange wYc;
  private MStorage.IOnStorageChange wYd;
  private MStorage.IOnStorageChange wYe;
  private IListener wYf;
  private IListener wYg;
  private MTimerHandler wYh;
  private MTimerHandler wYi;
  
  static
  {
    AppMethodBeat.i(52693);
    wYj = new HashSet();
    String[] arrayOfString = MMApplicationContext.getContext().getString(2131758201).split(";");
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        wYj.add(str);
        i += 1;
      }
    }
    AppMethodBeat.o(52693);
  }
  
  public a()
  {
    AppMethodBeat.i(52681);
    this.wYb = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(52631);
        paramAnonymousMStorageEx = (String)paramAnonymousObject;
        if (!a.ayB(paramAnonymousMStorageEx))
        {
          Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "onConversationChangeListener filterByUsername %s", new Object[] { paramAnonymousMStorageEx });
          AppMethodBeat.o(52631);
          return;
        }
        paramAnonymousObject = ((l)g.af(l.class)).aSN().bjF(paramAnonymousMStorageEx);
        if ((paramAnonymousObject != null) && ((!a.U(paramAnonymousObject)) || (paramAnonymousObject.gBM())))
        {
          Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[] { paramAnonymousMStorageEx });
          AppMethodBeat.o(52631);
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(52631);
          return;
          if (!a.b(a.this).containsKey(paramAnonymousMStorageEx))
          {
            a.e(a.this).a(65556, new a.h(a.this, paramAnonymousMStorageEx));
            AppMethodBeat.o(52631);
            return;
            if ((!a.c(a.this).contains(paramAnonymousMStorageEx)) && (!a.b(a.this).containsKey(paramAnonymousMStorageEx))) {
              a.e(a.this).a(65556, new a.i(a.this, paramAnonymousMStorageEx));
            }
          }
        }
      }
    };
    this.wYc = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(52632);
        paramAnonymousMStorageEx = (String)paramAnonymousObject;
        if (!a.ayB(paramAnonymousMStorageEx))
        {
          Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", new Object[] { paramAnonymousMStorageEx });
          AppMethodBeat.o(52632);
          return;
        }
        paramAnonymousObject = ((l)g.af(l.class)).aSN().bjF(paramAnonymousMStorageEx);
        if ((paramAnonymousObject != null) && (!a.U(paramAnonymousObject)))
        {
          Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[] { paramAnonymousMStorageEx });
          AppMethodBeat.o(52632);
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(52632);
          return;
          if (!a.b(a.this).containsKey(paramAnonymousMStorageEx))
          {
            a.e(a.this).a(65556, new a.h(a.this, paramAnonymousMStorageEx));
            AppMethodBeat.o(52632);
            return;
            a.e(a.this).a(65556, new a.e(a.this, paramAnonymousMStorageEx));
            AppMethodBeat.o(52632);
            return;
            a.e(a.this).a(65556, new a.d(a.this, paramAnonymousMStorageEx));
          }
        }
      }
    };
    this.wYd = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(52633);
        if ((paramAnonymousString.equals("*")) || (paramAnonymousString.equals("chatroomname")))
        {
          AppMethodBeat.o(52633);
          return;
        }
        if (!a.b(a.this).containsKey(paramAnonymousString)) {
          a.e(a.this).a(65556, new a.h(a.this, paramAnonymousString));
        }
        AppMethodBeat.o(52633);
      }
    };
    this.wYe = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(52634);
        paramAnonymousString = paramAnonymousString.split(" ");
        if ((paramAnonymousString == null) || (paramAnonymousString.length == 0))
        {
          AppMethodBeat.o(52634);
          return;
        }
        if (paramAnonymousString[0].equals("update"))
        {
          int i = 1;
          while (i < paramAnonymousString.length)
          {
            long l = Util.getLong(paramAnonymousString[i], 0L);
            a.e(a.this).a(65554, new a.w(a.this, l));
            i += 1;
          }
          a.e(a.this).a(65556, new a.v(a.this, (byte)0));
        }
        AppMethodBeat.o(52634);
      }
    };
    this.wYf = new IListener() {};
    this.wYg = new IListener() {};
    this.wYh = new MTimerHandler(g.aAk().getLooper(), new MTimerHandler.CallBack()
    {
      private int wYl = 0;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52637);
        PluginFTS localPluginFTS = (PluginFTS)g.ah(PluginFTS.class);
        if ((localPluginFTS.isCharging()) || (!localPluginFTS.isInBackground())) {}
        for (int i = 1; i == 0; i = 0)
        {
          i = this.wYl + 1;
          this.wYl = i;
          if (i >= 6) {
            break;
          }
          AppMethodBeat.o(52637);
          return true;
        }
        a.e(a.this).a(131093, new a.v(a.this, (byte)0));
        this.wYl = 0;
        AppMethodBeat.o(52637);
        return true;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(52638);
        String str = super.toString() + "|delayIndexTimer";
        AppMethodBeat.o(52638);
        return str;
      }
    }, true);
    this.wYi = new MTimerHandler(g.aAk().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52639);
        a.e(a.this).a(131093, new a.v(a.this, (byte)0));
        AppMethodBeat.o(52639);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(52640);
        String str = super.toString() + "|atOnceIndexTimer";
        AppMethodBeat.o(52640);
        return str;
      }
    }, false);
    AppMethodBeat.o(52681);
  }
  
  private static String It(String paramString)
  {
    AppMethodBeat.i(52691);
    if (wYj.contains(paramString))
    {
      AppMethodBeat.o(52691);
      return "";
    }
    AppMethodBeat.o(52691);
    return paramString;
  }
  
  static boolean U(as paramas)
  {
    AppMethodBeat.i(52684);
    if ((paramas.isHidden()) && (!"notifymessage".equals(paramas.field_username)))
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (paramas.ary())
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (paramas.field_deleteFlag != 0)
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (!com.tencent.mm.contact.c.oR(paramas.field_type))
    {
      if (paramas.arx())
      {
        AppMethodBeat.o(52684);
        return false;
      }
      if (paramas.gBM())
      {
        AppMethodBeat.o(52684);
        return false;
      }
    }
    AppMethodBeat.o(52684);
    return true;
  }
  
  private int a(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    AppMethodBeat.i(52690);
    String str;
    if (paramString2 != null)
    {
      str = paramString2;
      if (paramString2.endsWith("")) {
        str = paramString2.substring(0, paramString2.length() - 1);
      }
      if (str.length() == 0)
      {
        AppMethodBeat.o(52690);
        return 0;
      }
    }
    else
    {
      AppMethodBeat.o(52690);
      return 0;
    }
    hx(paramString1, str);
    paramString2 = this.tbO.aym(str);
    if (paramString2.size() == 0)
    {
      AppMethodBeat.o(52690);
      return 0;
    }
    paramString2 = Util.listToString(paramString2, "​");
    this.wXV.a(131072, 11, paramLong1, paramString1, paramLong2, paramString2);
    AppMethodBeat.o(52690);
    return 1;
  }
  
  private int a(as paramas, long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(52688);
    Object localObject = paramas.fvb;
    int i = j;
    if (!Util.isNullOrNil((String)localObject))
    {
      com.tencent.mm.openim.a.b localb = new com.tencent.mm.openim.a.b();
      localb.Sa((String)localObject);
      localObject = new StringBuffer();
      i = 0;
      while (i < localb.jGV.size())
      {
        Iterator localIterator = ((b.a)localb.jGV.get(i)).jGW.iterator();
        while (localIterator.hasNext())
        {
          String str = ((b.b)localIterator.next()).Sb(paramas.field_openImAppid);
          if (!Util.isNullOrNil(str))
          {
            ((StringBuffer)localObject).append(str);
            ((StringBuffer)localObject).append("‌");
          }
        }
        ((StringBuffer)localObject).append("​");
        i += 1;
      }
      i = j;
      if (!Util.isNullOrNil(((StringBuffer)localObject).toString()))
      {
        this.wXV.a(131081, 51, paramas.gMZ, paramas.field_username, paramLong, ((StringBuffer)localObject).toString());
        i = 1;
      }
    }
    AppMethodBeat.o(52688);
    return i;
  }
  
  static boolean ayB(String paramString)
  {
    AppMethodBeat.i(52683);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(52683);
      return false;
    }
    if (paramString.endsWith("@stranger"))
    {
      AppMethodBeat.o(52683);
      return false;
    }
    if (paramString.endsWith("@qqim"))
    {
      AppMethodBeat.o(52683);
      return false;
    }
    if (paramString.endsWith("@app"))
    {
      AppMethodBeat.o(52683);
      return false;
    }
    if (paramString.startsWith("fake_"))
    {
      AppMethodBeat.o(52683);
      return false;
    }
    if ((paramString.endsWith("@gamelifesess")) || (paramString.endsWith("@gamelife")) || (paramString.endsWith("@gamelifehistory")))
    {
      AppMethodBeat.o(52683);
      return false;
    }
    AppMethodBeat.o(52683);
    return true;
  }
  
  public static boolean ayC(String paramString)
  {
    AppMethodBeat.i(52692);
    boolean bool = Util.nullAs(paramString, "").contains(z.aTY());
    AppMethodBeat.o(52692);
    return bool;
  }
  
  private void hx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52689);
    Object localObject1 = c.a.wVf.split(paramString2);
    if (localObject1.length != 0)
    {
      paramString2 = new ArrayList(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        paramString2.add(Long.valueOf(Util.getLong(localObject1[i], 0L)));
        i += 1;
      }
    }
    for (;;)
    {
      localObject1 = (List)this.wXZ.get(paramString1);
      if (localObject1 == null)
      {
        this.wXV.ayG(paramString1);
        if ((paramString2 != null) && (!paramString2.isEmpty()))
        {
          this.wXV.u(paramString1, paramString2);
          this.wXZ.put(paramString1, paramString2);
          AppMethodBeat.o(52689);
        }
      }
      else
      {
        if ((paramString2 == null) || (paramString2.isEmpty()))
        {
          this.wXV.ayG(paramString1);
          this.wXZ.remove(paramString1);
          AppMethodBeat.o(52689);
          return;
        }
        localObject1 = new HashSet((Collection)localObject1);
        Object localObject2 = paramString2.iterator();
        long l;
        while (((Iterator)localObject2).hasNext())
        {
          l = ((Long)((Iterator)localObject2).next()).longValue();
          if (!((HashSet)localObject1).remove(Long.valueOf(l)))
          {
            com.tencent.mm.plugin.fts.c.a locala = this.wXV;
            locala.wZD.bindString(1, paramString1);
            locala.wZD.bindLong(2, l);
            locala.wZD.execute();
          }
        }
        localObject1 = ((HashSet)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          l = ((Long)((Iterator)localObject1).next()).longValue();
          localObject2 = this.wXV;
          ((com.tencent.mm.plugin.fts.c.a)localObject2).wZE.bindString(1, paramString1);
          ((com.tencent.mm.plugin.fts.c.a)localObject2).wZE.bindLong(2, l);
          ((com.tencent.mm.plugin.fts.c.a)localObject2).wZE.execute();
        }
        this.wXZ.put(paramString1, paramString2);
      }
      AppMethodBeat.o(52689);
      return;
      paramString2 = null;
    }
  }
  
  final void T(as paramas)
  {
    AppMethodBeat.i(52682);
    try
    {
      this.wYa.invoke(paramas, new Object[0]);
      AppMethodBeat.o(52682);
      return;
    }
    catch (Exception paramas)
    {
      Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paramas, "Failed parsing RContact LVBuffer.", new Object[0]);
      AppMethodBeat.o(52682);
    }
  }
  
  final boolean V(as paramas)
  {
    AppMethodBeat.i(52685);
    String str = paramas.field_username;
    if (!U(paramas))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if (!ayB(str))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if ((as.bjt(str)) || (as.bjs(str)))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if (!com.tencent.mm.contact.c.oR(paramas.field_type))
    {
      if ((!paramas.arx()) && (!paramas.gBM()))
      {
        if (this.tbO.ayk(str))
        {
          AppMethodBeat.o(52685);
          return true;
        }
        AppMethodBeat.o(52685);
        return false;
      }
      AppMethodBeat.o(52685);
      return false;
    }
    AppMethodBeat.o(52685);
    return true;
  }
  
  final int W(as paramas)
  {
    AppMethodBeat.i(52686);
    Object localObject1;
    Object localObject3;
    if (ab.Eq(paramas.field_username))
    {
      localObject1 = String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", new Object[] { "chatroom" });
      localObject3 = this.tbO.i((String)localObject1, new String[] { paramas.field_username });
    }
    for (;;)
    {
      try
      {
        if (!((Cursor)localObject3).moveToNext()) {
          break label506;
        }
        localObject2 = ((Cursor)localObject3).getString(0);
        localObject1 = ((Cursor)localObject3).getBlob(1);
        if (localObject3 != null) {
          ((Cursor)localObject3).close();
        }
        if ((Util.isNullOrNil((String)localObject2)) || (localObject1 == null) || (!ayC((String)localObject2)))
        {
          Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", new Object[] { paramas.field_username });
          i = j(paramas.field_username, null);
          if (i > 0) {
            Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paramas.field_username, Integer.valueOf(i) });
          }
          AppMethodBeat.o(52686);
          return 0;
        }
      }
      finally
      {
        if (localObject3 != null) {
          ((Cursor)localObject3).close();
        }
        AppMethodBeat.o(52686);
      }
      Object localObject2 = c.a.wUY.split((CharSequence)localObject2);
      Arrays.sort((Object[])localObject2, new Comparator() {});
      int i = j(paramas.field_username, (String[])localObject2);
      if (i > 0) {
        Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paramas.field_username, Integer.valueOf(i) });
      }
      localObject3 = new HashMap();
      Object localObject4 = "SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + d.J((String[])localObject2) + ";";
      localObject4 = this.tbO.i((String)localObject4, null);
      try
      {
        while (((Cursor)localObject4).moveToNext())
        {
          as localas = new as();
          localas.gMZ = ((Cursor)localObject4).getLong(0);
          localas.setUsername(((Cursor)localObject4).getString(1));
          localas.BC(((Cursor)localObject4).getString(2));
          localas.BD(((Cursor)localObject4).getString(3));
          localas.setNickname(((Cursor)localObject4).getString(4));
          localas.Z(((Cursor)localObject4).getBlob(5));
          ((HashMap)localObject3).put(localas.field_username, localas);
        }
        AppMethodBeat.o(52686);
      }
      finally
      {
        if (localObject4 != null) {
          ((Cursor)localObject4).close();
        }
        AppMethodBeat.o(52686);
      }
      return i;
      i = X(paramas);
      AppMethodBeat.o(52686);
      return i;
      label506:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  final int X(as paramas)
  {
    AppMethodBeat.i(52687);
    long l2 = paramas.gMZ;
    String str2 = paramas.field_username;
    Object localObject7 = paramas.ajx();
    Object localObject1 = paramas.field_nickname;
    Object localObject2 = d.bB((String)localObject1, false);
    Object localObject3 = d.bB((String)localObject1, true);
    Object localObject6 = paramas.field_conRemark;
    Object localObject4 = d.bB((String)localObject6, false);
    Object localObject5 = d.bB((String)localObject6, true);
    String str3 = paramas.fuR;
    String str1 = paramas.field_contactLabelIds;
    String str4 = paramas.fuX;
    int i = paramas.field_verifyFlag;
    long l1 = System.currentTimeMillis();
    int j;
    if ((i & as.gBP()) != 0)
    {
      str1 = Util.listToString(((com.tencent.mm.api.n)g.af(com.tencent.mm.api.n.class)).fE(str2), "​");
      i = 0;
      j = 131076;
    }
    for (;;)
    {
      localObject7 = d.hw(str2, (String)localObject7);
      if ((localObject7 != null) && (((String)localObject7).length() != 0))
      {
        this.wXV.a(j, 15, l2, str2, l1, (String)localObject7);
        i += 1;
      }
      for (;;)
      {
        if ((localObject6 == null) || (((String)localObject6).length() == 0))
        {
          localObject6 = null;
          localObject7 = null;
          localObject4 = localObject2;
          localObject5 = null;
          localObject2 = localObject6;
          localObject6 = localObject1;
          localObject1 = localObject7;
        }
        for (;;)
        {
          int k = i;
          if (localObject6 != null)
          {
            k = i;
            if (((String)localObject6).length() != 0)
            {
              if (!((String)localObject6).equalsIgnoreCase((String)localObject4)) {
                break label1012;
              }
              localObject4 = null;
            }
          }
          label416:
          label1012:
          for (;;)
          {
            if ((localObject4 != null) && (((String)localObject4).length() != 0))
            {
              localObject7 = localObject3;
              if (!((String)localObject4).equalsIgnoreCase((String)localObject3)) {}
            }
            else
            {
              localObject7 = null;
            }
            this.wXV.a(j, 1, l2, str2, l1, (String)localObject6);
            if ((localObject4 != null) && (((String)localObject4).length() != 0)) {
              this.wXV.a(j, 2, l2, str2, l1, (String)localObject4);
            }
            if ((localObject7 != null) && (((String)localObject7).length() != 0)) {
              this.wXV.a(j, 3, l2, str2, l1, (String)localObject7);
            }
            k = i + 3;
            if ((localObject5 != null) && (((String)localObject5).length() != 0))
            {
              localObject3 = localObject2;
              if (((String)localObject5).equalsIgnoreCase((String)localObject2)) {
                localObject3 = null;
              }
              if ((localObject3 == null) || (((String)localObject3).length() == 0) || (((String)localObject3).equalsIgnoreCase((String)localObject1)))
              {
                localObject1 = null;
                this.wXV.a(j, 5, l2, str2, l1, (String)localObject5);
                if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
                  this.wXV.a(j, 6, l2, str2, l1, (String)localObject3);
                }
                if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
                  this.wXV.a(j, 7, l2, str2, l1, (String)localObject1);
                }
                k += 3;
              }
            }
            for (;;)
            {
              i = k;
              if (str3 != null)
              {
                i = k;
                if (str3.length() > 0)
                {
                  this.wXV.a(j, 4, l2, str2, l1, str3);
                  i = k + 1;
                }
              }
              k = i;
              if (j == 131072)
              {
                if (Util.isNullOrNil(str4)) {
                  break label927;
                }
                localObject1 = str4.replace(com.tencent.mm.contact.a.d(paramas), "​");
                this.wXV.a(j, 16, l2, str2, l1, (String)localObject1);
                k = i + 1;
              }
              for (;;)
              {
                localObject1 = It(paramas.getProvince());
                i = k;
                if (localObject1 != null)
                {
                  i = k;
                  if (((String)localObject1).length() != 0)
                  {
                    this.wXV.a(j, 18, l2, str2, l1, (String)localObject1);
                    i = k + 1;
                  }
                }
                localObject1 = paramas.getCity();
                k = i;
                if (localObject1 != null)
                {
                  k = i;
                  if (((String)localObject1).length() != 0)
                  {
                    this.wXV.a(j, 17, l2, str2, l1, (String)localObject1);
                    k = i + 1;
                  }
                }
                i = k;
                if (j == 131076)
                {
                  i = k;
                  if (!Util.isNullOrNil(str1))
                  {
                    this.wXV.a(j, 19, l2, str2, l1, str1);
                    i = k + 1;
                    localObject1 = d.bB(str1, false);
                    k = i;
                    if (!Util.isNullOrNil((String)localObject1))
                    {
                      this.wXV.a(j, 20, l2, str2, l1, (String)localObject1);
                      k = i + 1;
                    }
                    str1 = d.bB(str1, true);
                    i = k;
                    if (!Util.isNullOrNil(str1))
                    {
                      this.wXV.a(j, 21, l2, str2, l1, str1);
                      i = k + 1;
                    }
                  }
                }
                k = i;
                if (j == 131081) {
                  k = i + a(paramas, l1);
                }
                AppMethodBeat.o(52687);
                return k;
                if (as.bjp(str2))
                {
                  i = 0;
                  str1 = "";
                  j = 131081;
                  break;
                }
                l1 = this.tbO.ayl(str2);
                if ((str1 == null) || (str1.length() <= 0)) {
                  break label1041;
                }
                i = a(l2, str2, str1, l1) + 0;
                str1 = "";
                j = 131072;
                break;
                localObject1 = this.tbO.i("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[] { str2 });
                k = i;
                if (((Cursor)localObject1).moveToFirst())
                {
                  localObject2 = ((Cursor)localObject1).getString(0);
                  this.wXV.a(j, 16, l2, str2, l1, (String)localObject2);
                  k = i + 1;
                }
                ((Cursor)localObject1).close();
              }
              break label416;
            }
          }
          label927:
          Object localObject8 = localObject3;
          localObject7 = localObject1;
          localObject3 = localObject5;
          localObject1 = localObject8;
          localObject5 = localObject7;
        }
      }
      label1041:
      i = 0;
      str1 = "";
      j = 131072;
    }
  }
  
  final int a(String paramString, as paramas, String[] paramArrayOfString, byte[] paramArrayOfByte, HashMap<String, as> paramHashMap)
  {
    AppMethodBeat.i(52679);
    int j = 0;
    String str1 = paramas.field_nickname;
    paramas = paramas.field_conRemark;
    String str2 = d.bB(paramas, false);
    String str3 = d.bB(paramas, true);
    String str4 = d.bB(str1, false);
    String str5 = d.bB(str1, true);
    long l1 = 0L;
    long l3 = this.tbO.ayl(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayOfString != null)
    {
      long l2 = paramArrayOfString.length;
      HashMap localHashMap = new HashMap();
      Object localObject = new com.tencent.mm.k.a.a.a();
      int k;
      try
      {
        ((com.tencent.mm.k.a.a.a)localObject).parseFrom(paramArrayOfByte);
        paramArrayOfByte = ((com.tencent.mm.k.a.a.a)localObject).gCs.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject = (com.tencent.mm.k.a.a.b)paramArrayOfByte.next();
          if (!Util.isNullOrNil(((com.tencent.mm.k.a.a.b)localObject).gCv)) {
            localHashMap.put(((com.tencent.mm.k.a.a.b)localObject).userName, ((com.tencent.mm.k.a.a.b)localObject).gCv);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paramArrayOfByte, "parse chatroom data", new Object[0]);
        }
        k = paramArrayOfString.length;
        i = 0;
      }
      for (;;)
      {
        l1 = l2;
        if (i >= k) {
          break;
        }
        paramArrayOfByte = paramArrayOfString[i];
        localObject = (as)paramHashMap.get(paramArrayOfByte);
        if (localObject != null)
        {
          String str7 = ((ax)localObject).field_conRemark;
          String str6 = ((ax)localObject).field_nickname;
          String str8 = d.bB(str7, false);
          String str9 = d.bB(str7, true);
          localStringBuffer.append(Util.nullAs(str7, " ")).append("‌");
          localStringBuffer.append(Util.nullAs(str8, " ")).append("‌");
          localStringBuffer.append(Util.nullAs(str9, " ")).append("‌");
          str7 = d.bB(str6, false);
          str8 = d.bB(str6, true);
          localStringBuffer.append(Util.nullAs(str6, " ")).append("‌");
          localStringBuffer.append(Util.nullAs(str7, " ")).append("‌");
          localStringBuffer.append(Util.nullAs(str8, " ")).append("‌");
          localStringBuffer.append(Util.nullAs((String)localHashMap.get(paramArrayOfByte), " ")).append("‌");
          T((as)localObject);
          localStringBuffer.append(Util.nullAs(((ax)localObject).fuR, " ")).append("‌");
          localStringBuffer.append(Util.nullAs(d.hw(paramArrayOfByte, ((as)localObject).ajx()), " ")).append("‌");
          localStringBuffer.append("​");
        }
        i += 1;
      }
    }
    if (!Util.isNullOrNil(str1))
    {
      this.wXV.a(131075, 5, l1, paramString, l3, str1);
      if (Util.isNullOrNil(str4)) {
        break label761;
      }
      this.wXV.a(131075, 6, l1, paramString, l3, str4);
    }
    label761:
    for (int i = 2;; i = 1)
    {
      j = i;
      if (!Util.isNullOrNil(str5))
      {
        this.wXV.a(131075, 7, l1, paramString, l3, str5);
        j = i + 1;
      }
      i = j;
      if (!Util.isNullOrNil(paramas))
      {
        this.wXV.a(131075, 1, l1, paramString, l3, paramas);
        i = j + 1;
        j = i;
        if (!Util.isNullOrNil(str4))
        {
          this.wXV.a(131075, 2, l1, paramString, l3, str2);
          j = i + 1;
        }
        i = j;
        if (!Util.isNullOrNil(str5))
        {
          this.wXV.a(131075, 3, l1, paramString, l3, str3);
          i = j + 1;
        }
      }
      j = i;
      if (localStringBuffer.length() > 0)
      {
        localStringBuffer.setLength(localStringBuffer.length() - 1);
        this.wXV.a(131075, 38, l1, paramString, l3, localStringBuffer.toString());
        j = i + 1;
      }
      AppMethodBeat.o(52679);
      return j;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(52676);
    switch (paramj.kXb)
    {
    default: 
      paramj = new j(paramj);
    }
    for (;;)
    {
      paramj = this.hgI.a(-65536, paramj);
      AppMethodBeat.o(52676);
      return paramj;
      paramj = new r(paramj);
      continue;
      paramj = new o(paramj);
      continue;
      paramj = new u(paramj);
      continue;
      paramj = new t(paramj);
      continue;
      paramj = new l(paramj);
      continue;
      paramj = new k(paramj);
      continue;
      paramj = new m(paramj);
      continue;
      paramj = new s(paramj);
      continue;
      paramj = new p(paramj);
      continue;
      paramj = new q(paramj);
      continue;
      paramj = new n(paramj);
    }
  }
  
  public final boolean axa()
  {
    AppMethodBeat.i(52678);
    this.wYf.dead();
    this.wYg.dead();
    this.wYi.stopTimer();
    this.wYh.stopTimer();
    ((l)g.af(l.class)).aSN().remove(this.wYc);
    ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().remove(this.wYd);
    ((l)g.af(l.class)).aST().remove(this.wYb);
    MStorage.IOnStorageChange localIOnStorageChange = this.wYe;
    if (com.tencent.mm.ax.b.jcc != null) {
      com.tencent.mm.ax.b.jcc.b(localIOnStorageChange);
    }
    if (this.wXX != null) {
      this.wXX.clear();
    }
    if (this.wXW != null) {
      this.wXW.clear();
    }
    this.wXV = null;
    this.hgI = null;
    AppMethodBeat.o(52678);
    return true;
  }
  
  public final String getName()
  {
    return "FTS5SearchContactLogic";
  }
  
  public final int j(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(52680);
    Object localObject = (String[])this.wXY.get(paramString);
    this.wXV.beginTransaction();
    int j;
    int i;
    if (localObject == null)
    {
      this.wXV.ayI(paramString);
      j = (int)this.wXV.wZG.simpleQueryForLong() + 0;
      i = j;
      if (paramArrayOfString != null)
      {
        this.wXV.k(paramString, paramArrayOfString);
        this.wXY.put(paramString, paramArrayOfString);
        i = j + paramArrayOfString.length;
      }
    }
    for (;;)
    {
      this.wXV.commit();
      AppMethodBeat.o(52680);
      return i;
      if (paramArrayOfString == null)
      {
        this.wXV.ayI(paramString);
        i = (int)this.wXV.wZG.simpleQueryForLong() + 0;
        this.wXY.remove(paramString);
      }
      else
      {
        localObject = new HashSet(Arrays.asList((Object[])localObject));
        int m = paramArrayOfString.length;
        j = 0;
        String str;
        int k;
        com.tencent.mm.plugin.fts.c.a locala;
        for (i = 0; j < m; i = k)
        {
          str = paramArrayOfString[j];
          k = i;
          if (!((HashSet)localObject).remove(str))
          {
            locala = this.wXV;
            locala.wZA.bindString(1, paramString);
            locala.wZA.bindString(2, str);
            locala.wZA.execute();
            k = i + 1;
          }
          j += 1;
        }
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          locala = this.wXV;
          locala.wZB.bindString(1, paramString);
          locala.wZB.bindString(2, str);
          locala.wZB.execute();
          i += 1;
        }
        this.wXY.put(paramString, paramArrayOfString);
      }
    }
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(52677);
    if (!((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
      AppMethodBeat.o(52677);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
    this.wXV = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3));
    this.hgI = ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.tbO = ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
    this.wXW = new HashSet();
    this.wXX = new HashMap();
    this.wXY = new HashMap();
    this.wXZ = new HashMap();
    try
    {
      this.wYa = ax.class.getDeclaredMethod("parseBuff", new Class[0]);
      this.wYa.setAccessible(true);
      this.hgI.a(131072, new f((byte)0));
      this.hgI.a(131082, new a((byte)0));
      this.hgI.a(131092, new b((byte)0));
      this.hgI.a(2147483647, new c((byte)0));
      ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().add(this.wYd);
      ((l)g.af(l.class)).aSN().add(this.wYc);
      ((l)g.af(l.class)).aST().add(this.wYb);
      MStorage.IOnStorageChange localIOnStorageChange = this.wYe;
      if (com.tencent.mm.ax.b.jcc != null) {
        com.tencent.mm.ax.b.jcc.a(localIOnStorageChange);
      }
      this.wYh.startTimer(600000L);
      this.wYf.alive();
      this.wYg.alive();
      AppMethodBeat.o(52677);
      return true;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      AssertionFailedError localAssertionFailedError = new AssertionFailedError("Can't find BaseContact.parseBuff method, class prototype has changed.");
      localAssertionFailedError.initCause(localNoSuchMethodException);
      AppMethodBeat.o(52677);
      throw localAssertionFailedError;
    }
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int tbV = 0;
    private int tbW = 0;
    
    private a() {}
    
    public final String bCQ()
    {
      AppMethodBeat.i(52643);
      String str = String.format("{new: %d removed: %d}", new Object[] { Integer.valueOf(this.tbV), Integer.valueOf(this.tbW) });
      AppMethodBeat.o(52643);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52642);
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
      Object localObject1 = new HashSet();
      Object localObject2 = a.a(a.this).wUt.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
      while (((Cursor)localObject2).moveToNext()) {
        ((HashSet)localObject1).add(((Cursor)localObject2).getString(0));
      }
      ((Cursor)localObject2).close();
      localObject2 = a.d(a.this).i("SELECT chatroomname, memberlist FROM chatroom;", null);
      int i = 5;
      int j;
      while (((Cursor)localObject2).moveToNext())
      {
        if (Thread.interrupted())
        {
          ((Cursor)localObject2).close();
          a.a(a.this).commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52642);
          throw ((Throwable)localObject1);
        }
        String str = ((Cursor)localObject2).getString(0);
        Object localObject3 = ((Cursor)localObject2).getString(1);
        if ((!Util.isNullOrNil((String)localObject3)) && (!Util.isNullOrNil(str)) && (a.ayC((String)localObject3)))
        {
          localObject3 = c.a.wUY.split((CharSequence)localObject3);
          a.f(a.this).put(str, localObject3);
          if (!((HashSet)localObject1).remove(str))
          {
            j = i;
            if (i >= 5)
            {
              a.a(a.this).commit();
              a.a(a.this).beginTransaction();
              j = 0;
            }
            a.a(a.this).k(str, (String[])localObject3);
            i = j + 1;
            this.tbV += 1;
          }
        }
      }
      ((Cursor)localObject2).close();
      a.a(a.this).commit();
      localObject1 = ((HashSet)localObject1).iterator();
      for (i = 5; ((Iterator)localObject1).hasNext(); i = j + 1)
      {
        localObject2 = (String)((Iterator)localObject1).next();
        j = i;
        if (i >= 5)
        {
          a.a(a.this).commit();
          a.a(a.this).beginTransaction();
          j = 0;
        }
        a.a(a.this).ayI((String)localObject2);
        this.tbW += 1;
      }
      a.a(a.this).commit();
      AppMethodBeat.o(52642);
      return true;
    }
    
    public final int getId()
    {
      return 3;
    }
    
    public final String getName()
    {
      return "BuildChatroomIndexTask";
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private HashSet<String> wYm;
    private HashMap<String, as> wYn;
    private long wYo;
    private long wYp;
    private int wYq;
    private int wYr;
    private int wYs;
    private int wYt;
    private int wYu;
    private int wYv;
    private int wYw;
    private int wYx;
    
    private b()
    {
      AppMethodBeat.i(52645);
      this.wYn = new HashMap();
      this.wYo = -1L;
      this.wYp = -1L;
      this.wYq = 0;
      this.wYr = 0;
      this.wYs = 0;
      this.wYt = 0;
      this.wYu = 0;
      AppMethodBeat.o(52645);
    }
    
    public final String bCQ()
    {
      AppMethodBeat.i(52647);
      String str = String.format("{build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, failContact: %d, failChatroom}", new Object[] { Integer.valueOf(this.wYx), Integer.valueOf(this.wYr), Integer.valueOf(this.wYq), Integer.valueOf(this.wYs), Integer.valueOf(this.wYv), Integer.valueOf(this.wYw), Integer.valueOf(this.wYt), Integer.valueOf(this.wYu) });
      AppMethodBeat.o(52647);
      return str;
    }
    
    /* Error */
    public final boolean execute()
    {
      // Byte code:
      //   0: ldc 101
      //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: ldc 103
      //   7: ldc 105
      //   9: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   12: aload_0
      //   13: ldc 112
      //   15: invokevirtual 116	com/tencent/mm/plugin/fts/b/a$b:ayx	(Ljava/lang/String;)V
      //   18: aload_0
      //   19: getfield 118	com/tencent/mm/plugin/fts/b/a$b:wYm	Ljava/util/HashSet;
      //   22: ifnonnull +239 -> 261
      //   25: aload_0
      //   26: new 120	java/util/HashSet
      //   29: dup
      //   30: invokespecial 121	java/util/HashSet:<init>	()V
      //   33: putfield 118	com/tencent/mm/plugin/fts/b/a$b:wYm	Ljava/util/HashSet;
      //   36: aload_0
      //   37: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   40: invokestatic 125	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   43: getstatic 131	com/tencent/mm/plugin/fts/a/c:wUK	[I
      //   46: iconst_1
      //   47: iconst_0
      //   48: iconst_1
      //   49: iconst_0
      //   50: iconst_1
      //   51: invokevirtual 136	com/tencent/mm/plugin/fts/c/a:a	([IZZZZZ)Landroid/database/Cursor;
      //   54: astore 7
      //   56: aload 7
      //   58: invokeinterface 141 1 0
      //   63: ifeq +134 -> 197
      //   66: aload 7
      //   68: iconst_1
      //   69: invokeinterface 145 2 0
      //   74: astore 8
      //   76: aload 7
      //   78: iconst_2
      //   79: invokeinterface 149 2 0
      //   84: istore_1
      //   85: aload 7
      //   87: iconst_0
      //   88: invokeinterface 153 2 0
      //   93: lstore_3
      //   94: iload_1
      //   95: iconst_1
      //   96: if_icmpne +70 -> 166
      //   99: aload_0
      //   100: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   103: invokestatic 156	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashMap;
      //   106: aload 8
      //   108: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   111: checkcast 162	java/util/List
      //   114: astore 6
      //   116: aload 6
      //   118: astore 5
      //   120: aload 6
      //   122: ifnonnull +29 -> 151
      //   125: new 164	java/util/ArrayList
      //   128: dup
      //   129: bipush 16
      //   131: invokespecial 166	java/util/ArrayList:<init>	(I)V
      //   134: astore 5
      //   136: aload_0
      //   137: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   140: invokestatic 156	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashMap;
      //   143: aload 8
      //   145: aload 5
      //   147: invokevirtual 170	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   150: pop
      //   151: aload 5
      //   153: lload_3
      //   154: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   157: invokeinterface 179 2 0
      //   162: pop
      //   163: goto -107 -> 56
      //   166: aload_0
      //   167: getfield 118	com/tencent/mm/plugin/fts/b/a$b:wYm	Ljava/util/HashSet;
      //   170: aload 8
      //   172: invokevirtual 180	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   175: pop
      //   176: iload_1
      //   177: iconst_2
      //   178: if_icmpne -122 -> 56
      //   181: aload_0
      //   182: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   185: invokestatic 184	com/tencent/mm/plugin/fts/b/a:c	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashSet;
      //   188: aload 8
      //   190: invokevirtual 180	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   193: pop
      //   194: goto -138 -> 56
      //   197: aload 7
      //   199: invokeinterface 187 1 0
      //   204: aload_0
      //   205: aload_0
      //   206: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   209: invokestatic 156	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashMap;
      //   212: invokevirtual 191	java/util/HashMap:size	()I
      //   215: putfield 88	com/tencent/mm/plugin/fts/b/a$b:wYv	I
      //   218: aload_0
      //   219: aload_0
      //   220: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   223: invokestatic 184	com/tencent/mm/plugin/fts/b/a:c	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashSet;
      //   226: invokevirtual 192	java/util/HashSet:size	()I
      //   229: putfield 90	com/tencent/mm/plugin/fts/b/a$b:wYw	I
      //   232: aload_0
      //   233: aload_0
      //   234: getfield 118	com/tencent/mm/plugin/fts/b/a$b:wYm	Ljava/util/HashSet;
      //   237: invokevirtual 192	java/util/HashSet:size	()I
      //   240: putfield 80	com/tencent/mm/plugin/fts/b/a$b:wYx	I
      //   243: aload_0
      //   244: getfield 80	com/tencent/mm/plugin/fts/b/a$b:wYx	I
      //   247: iconst_5
      //   248: if_icmpge +13 -> 261
      //   251: aload_0
      //   252: aload_0
      //   253: getfield 195	com/tencent/mm/plugin/fts/a/a/a:wVQ	J
      //   256: lconst_1
      //   257: lor
      //   258: putfield 195	com/tencent/mm/plugin/fts/a/a/a:wVQ	J
      //   261: aload_0
      //   262: ldc 197
      //   264: invokevirtual 116	com/tencent/mm/plugin/fts/b/a$b:ayx	(Ljava/lang/String;)V
      //   267: invokestatic 202	java/lang/Thread:interrupted	()Z
      //   270: ifeq +20 -> 290
      //   273: new 204	java/lang/InterruptedException
      //   276: dup
      //   277: invokespecial 205	java/lang/InterruptedException:<init>	()V
      //   280: astore 5
      //   282: ldc 101
      //   284: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   287: aload 5
      //   289: athrow
      //   290: aload_0
      //   291: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   294: invokestatic 156	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashMap;
      //   297: invokevirtual 191	java/util/HashMap:size	()I
      //   300: ifle +82 -> 382
      //   303: new 164	java/util/ArrayList
      //   306: dup
      //   307: invokespecial 206	java/util/ArrayList:<init>	()V
      //   310: astore 5
      //   312: aload_0
      //   313: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   316: invokestatic 156	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashMap;
      //   319: invokevirtual 210	java/util/HashMap:values	()Ljava/util/Collection;
      //   322: invokeinterface 216 1 0
      //   327: astore 6
      //   329: aload 6
      //   331: invokeinterface 221 1 0
      //   336: ifeq +24 -> 360
      //   339: aload 5
      //   341: aload 6
      //   343: invokeinterface 225 1 0
      //   348: checkcast 162	java/util/List
      //   351: invokeinterface 229 2 0
      //   356: pop
      //   357: goto -28 -> 329
      //   360: aload_0
      //   361: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   364: invokestatic 156	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashMap;
      //   367: invokevirtual 232	java/util/HashMap:clear	()V
      //   370: aload_0
      //   371: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   374: invokestatic 125	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   377: aload 5
      //   379: invokevirtual 236	com/tencent/mm/plugin/fts/c/a:eN	(Ljava/util/List;)V
      //   382: aload_0
      //   383: ldc 238
      //   385: invokevirtual 116	com/tencent/mm/plugin/fts/b/a$b:ayx	(Ljava/lang/String;)V
      //   388: invokestatic 202	java/lang/Thread:interrupted	()Z
      //   391: ifeq +20 -> 411
      //   394: new 204	java/lang/InterruptedException
      //   397: dup
      //   398: invokespecial 205	java/lang/InterruptedException:<init>	()V
      //   401: astore 5
      //   403: ldc 101
      //   405: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   408: aload 5
      //   410: athrow
      //   411: aload_0
      //   412: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   415: invokestatic 184	com/tencent/mm/plugin/fts/b/a:c	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashSet;
      //   418: invokevirtual 192	java/util/HashSet:size	()I
      //   421: ifle +78 -> 499
      //   424: aload_0
      //   425: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   428: invokestatic 184	com/tencent/mm/plugin/fts/b/a:c	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashSet;
      //   431: invokevirtual 239	java/util/HashSet:iterator	()Ljava/util/Iterator;
      //   434: astore 5
      //   436: aload 5
      //   438: invokeinterface 221 1 0
      //   443: ifeq +46 -> 489
      //   446: aload 5
      //   448: invokeinterface 225 1 0
      //   453: checkcast 92	java/lang/String
      //   456: astore 6
      //   458: aload_0
      //   459: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   462: invokestatic 243	com/tencent/mm/plugin/fts/b/a:d	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/a/j;
      //   465: aload 6
      //   467: invokeinterface 249 2 0
      //   472: lstore_3
      //   473: aload_0
      //   474: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   477: invokestatic 125	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   480: aload 6
      //   482: lload_3
      //   483: invokevirtual 253	com/tencent/mm/plugin/fts/c/a:av	(Ljava/lang/String;J)V
      //   486: goto -50 -> 436
      //   489: aload_0
      //   490: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   493: invokestatic 184	com/tencent/mm/plugin/fts/b/a:c	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashSet;
      //   496: invokevirtual 254	java/util/HashSet:clear	()V
      //   499: aload_0
      //   500: ldc_w 256
      //   503: invokevirtual 116	com/tencent/mm/plugin/fts/b/a$b:ayx	(Ljava/lang/String;)V
      //   506: invokestatic 202	java/lang/Thread:interrupted	()Z
      //   509: ifeq +20 -> 529
      //   512: new 204	java/lang/InterruptedException
      //   515: dup
      //   516: invokespecial 205	java/lang/InterruptedException:<init>	()V
      //   519: astore 5
      //   521: ldc 101
      //   523: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   526: aload 5
      //   528: athrow
      //   529: aload_0
      //   530: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   533: invokestatic 243	com/tencent/mm/plugin/fts/b/a:d	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/a/j;
      //   536: ldc_w 258
      //   539: iconst_1
      //   540: anewarray 92	java/lang/String
      //   543: dup
      //   544: iconst_0
      //   545: aload_0
      //   546: getfield 52	com/tencent/mm/plugin/fts/b/a$b:wYo	J
      //   549: invokestatic 262	java/lang/Long:toString	(J)Ljava/lang/String;
      //   552: aastore
      //   553: invokeinterface 265 3 0
      //   558: astore 5
      //   560: bipush 50
      //   562: istore_1
      //   563: aload 5
      //   565: invokeinterface 141 1 0
      //   570: ifeq +376 -> 946
      //   573: invokestatic 202	java/lang/Thread:interrupted	()Z
      //   576: ifeq +37 -> 613
      //   579: aload 5
      //   581: invokeinterface 187 1 0
      //   586: aload_0
      //   587: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   590: invokestatic 125	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   593: invokevirtual 268	com/tencent/mm/plugin/fts/c/a:commit	()V
      //   596: new 204	java/lang/InterruptedException
      //   599: dup
      //   600: invokespecial 205	java/lang/InterruptedException:<init>	()V
      //   603: astore 5
      //   605: ldc 101
      //   607: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   610: aload 5
      //   612: athrow
      //   613: aload 5
      //   615: iconst_0
      //   616: invokeinterface 153 2 0
      //   621: lstore_3
      //   622: aload_0
      //   623: lload_3
      //   624: putfield 52	com/tencent/mm/plugin/fts/b/a$b:wYo	J
      //   627: new 270	com/tencent/mm/storage/as
      //   630: dup
      //   631: invokespecial 271	com/tencent/mm/storage/as:<init>	()V
      //   634: astore 6
      //   636: aload 6
      //   638: lload_3
      //   639: putfield 274	com/tencent/mm/storage/as:gMZ	J
      //   642: aload 6
      //   644: aload 5
      //   646: iconst_1
      //   647: invokeinterface 145 2 0
      //   652: invokevirtual 277	com/tencent/mm/storage/as:setUsername	(Ljava/lang/String;)V
      //   655: aload 6
      //   657: aload 5
      //   659: iconst_2
      //   660: invokeinterface 145 2 0
      //   665: invokevirtual 280	com/tencent/mm/storage/as:BC	(Ljava/lang/String;)V
      //   668: aload 6
      //   670: aload 5
      //   672: iconst_3
      //   673: invokeinterface 145 2 0
      //   678: invokevirtual 283	com/tencent/mm/storage/as:BD	(Ljava/lang/String;)V
      //   681: aload 6
      //   683: aload 5
      //   685: iconst_4
      //   686: invokeinterface 145 2 0
      //   691: invokevirtual 286	com/tencent/mm/storage/as:setNickname	(Ljava/lang/String;)V
      //   694: aload 6
      //   696: aload 5
      //   698: iconst_5
      //   699: invokeinterface 149 2 0
      //   704: invokevirtual 289	com/tencent/mm/storage/as:nf	(I)V
      //   707: aload 6
      //   709: aload 5
      //   711: bipush 6
      //   713: invokeinterface 149 2 0
      //   718: invokevirtual 292	com/tencent/mm/storage/as:setType	(I)V
      //   721: aload 6
      //   723: aload 5
      //   725: bipush 7
      //   727: invokeinterface 296 2 0
      //   732: invokevirtual 300	com/tencent/mm/storage/as:Z	([B)V
      //   735: aload 6
      //   737: aload 5
      //   739: bipush 8
      //   741: invokeinterface 145 2 0
      //   746: invokevirtual 303	com/tencent/mm/storage/as:BL	(Ljava/lang/String;)V
      //   749: aload 6
      //   751: iconst_0
      //   752: invokevirtual 306	com/tencent/mm/storage/as:nh	(I)V
      //   755: aload_0
      //   756: getfield 48	com/tencent/mm/plugin/fts/b/a$b:wYn	Ljava/util/HashMap;
      //   759: aload 6
      //   761: getfield 312	com/tencent/mm/g/c/ax:field_username	Ljava/lang/String;
      //   764: aload 6
      //   766: invokevirtual 170	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   769: pop
      //   770: aload 6
      //   772: getfield 312	com/tencent/mm/g/c/ax:field_username	Ljava/lang/String;
      //   775: invokestatic 318	com/tencent/mm/model/ab:Eq	(Ljava/lang/String;)Z
      //   778: ifne -215 -> 563
      //   781: aload_0
      //   782: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   785: aload 6
      //   787: invokevirtual 322	com/tencent/mm/plugin/fts/b/a:V	(Lcom/tencent/mm/storage/as;)Z
      //   790: ifeq -227 -> 563
      //   793: aload_0
      //   794: getfield 118	com/tencent/mm/plugin/fts/b/a$b:wYm	Ljava/util/HashSet;
      //   797: aload 6
      //   799: getfield 312	com/tencent/mm/g/c/ax:field_username	Ljava/lang/String;
      //   802: invokevirtual 325	java/util/HashSet:remove	(Ljava/lang/Object;)Z
      //   805: ifne -242 -> 563
      //   808: iload_1
      //   809: istore_2
      //   810: iload_1
      //   811: bipush 50
      //   813: if_icmplt +25 -> 838
      //   816: aload_0
      //   817: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   820: invokestatic 125	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   823: invokevirtual 268	com/tencent/mm/plugin/fts/c/a:commit	()V
      //   826: aload_0
      //   827: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   830: invokestatic 125	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   833: invokevirtual 328	com/tencent/mm/plugin/fts/c/a:beginTransaction	()V
      //   836: iconst_0
      //   837: istore_2
      //   838: iload_2
      //   839: istore_1
      //   840: aload 6
      //   842: getfield 312	com/tencent/mm/g/c/ax:field_username	Ljava/lang/String;
      //   845: ldc_w 330
      //   848: invokevirtual 333	java/lang/String:endsWith	(Ljava/lang/String;)Z
      //   851: ifne +35 -> 886
      //   854: iload_2
      //   855: istore_1
      //   856: aload 6
      //   858: getfield 336	com/tencent/mm/g/c/ax:field_verifyFlag	I
      //   861: invokestatic 339	com/tencent/mm/storage/as:gBP	()I
      //   864: iand
      //   865: ifne +21 -> 886
      //   868: iload_2
      //   869: istore_1
      //   870: aload_0
      //   871: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   874: aload 6
      //   876: invokevirtual 343	com/tencent/mm/plugin/fts/b/a:T	(Lcom/tencent/mm/storage/as;)V
      //   879: iload_2
      //   880: istore_1
      //   881: aload 6
      //   883: invokevirtual 346	com/tencent/mm/storage/as:gBS	()V
      //   886: iload_2
      //   887: istore_1
      //   888: iload_2
      //   889: aload_0
      //   890: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   893: aload 6
      //   895: invokevirtual 350	com/tencent/mm/plugin/fts/b/a:X	(Lcom/tencent/mm/storage/as;)I
      //   898: iadd
      //   899: istore_2
      //   900: iload_2
      //   901: istore_1
      //   902: aload_0
      //   903: aload_0
      //   904: getfield 58	com/tencent/mm/plugin/fts/b/a$b:wYr	I
      //   907: iconst_1
      //   908: iadd
      //   909: putfield 58	com/tencent/mm/plugin/fts/b/a$b:wYr	I
      //   912: iload_2
      //   913: istore_1
      //   914: goto -351 -> 563
      //   917: astore 6
      //   919: ldc 103
      //   921: aload 6
      //   923: ldc_w 352
      //   926: iconst_0
      //   927: anewarray 78	java/lang/Object
      //   930: invokestatic 356	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   933: aload_0
      //   934: aload_0
      //   935: getfield 62	com/tencent/mm/plugin/fts/b/a$b:wYt	I
      //   938: iconst_1
      //   939: iadd
      //   940: putfield 62	com/tencent/mm/plugin/fts/b/a$b:wYt	I
      //   943: goto -380 -> 563
      //   946: aload 5
      //   948: invokeinterface 187 1 0
      //   953: aload_0
      //   954: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   957: invokestatic 125	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   960: invokevirtual 268	com/tencent/mm/plugin/fts/c/a:commit	()V
      //   963: aload_0
      //   964: ldc_w 358
      //   967: invokevirtual 116	com/tencent/mm/plugin/fts/b/a$b:ayx	(Ljava/lang/String;)V
      //   970: invokestatic 202	java/lang/Thread:interrupted	()Z
      //   973: ifeq +20 -> 993
      //   976: new 204	java/lang/InterruptedException
      //   979: dup
      //   980: invokespecial 205	java/lang/InterruptedException:<init>	()V
      //   983: astore 5
      //   985: ldc 101
      //   987: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   990: aload 5
      //   992: athrow
      //   993: aload_0
      //   994: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   997: invokestatic 243	com/tencent/mm/plugin/fts/b/a:d	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/a/j;
      //   1000: ldc_w 360
      //   1003: iconst_1
      //   1004: anewarray 92	java/lang/String
      //   1007: dup
      //   1008: iconst_0
      //   1009: aload_0
      //   1010: getfield 54	com/tencent/mm/plugin/fts/b/a$b:wYp	J
      //   1013: invokestatic 262	java/lang/Long:toString	(J)Ljava/lang/String;
      //   1016: aastore
      //   1017: invokeinterface 265 3 0
      //   1022: astore 6
      //   1024: bipush 50
      //   1026: istore_1
      //   1027: aload 6
      //   1029: invokeinterface 141 1 0
      //   1034: ifeq +289 -> 1323
      //   1037: invokestatic 202	java/lang/Thread:interrupted	()Z
      //   1040: ifeq +37 -> 1077
      //   1043: aload 6
      //   1045: invokeinterface 187 1 0
      //   1050: aload_0
      //   1051: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   1054: invokestatic 125	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   1057: invokevirtual 268	com/tencent/mm/plugin/fts/c/a:commit	()V
      //   1060: new 204	java/lang/InterruptedException
      //   1063: dup
      //   1064: invokespecial 205	java/lang/InterruptedException:<init>	()V
      //   1067: astore 5
      //   1069: ldc 101
      //   1071: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1074: aload 5
      //   1076: athrow
      //   1077: aload_0
      //   1078: aload 6
      //   1080: iconst_0
      //   1081: invokeinterface 153 2 0
      //   1086: putfield 54	com/tencent/mm/plugin/fts/b/a$b:wYp	J
      //   1089: aload 6
      //   1091: iconst_1
      //   1092: invokeinterface 145 2 0
      //   1097: astore 5
      //   1099: aload_0
      //   1100: getfield 118	com/tencent/mm/plugin/fts/b/a$b:wYm	Ljava/util/HashSet;
      //   1103: aload 5
      //   1105: invokevirtual 325	java/util/HashSet:remove	(Ljava/lang/Object;)Z
      //   1108: ifne -81 -> 1027
      //   1111: aload_0
      //   1112: getfield 48	com/tencent/mm/plugin/fts/b/a$b:wYn	Ljava/util/HashMap;
      //   1115: aload 5
      //   1117: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1120: checkcast 270	com/tencent/mm/storage/as
      //   1123: astore 7
      //   1125: aload 7
      //   1127: ifnonnull +16 -> 1143
      //   1130: aload_0
      //   1131: aload_0
      //   1132: getfield 64	com/tencent/mm/plugin/fts/b/a$b:wYu	I
      //   1135: iconst_1
      //   1136: iadd
      //   1137: putfield 64	com/tencent/mm/plugin/fts/b/a$b:wYu	I
      //   1140: goto -113 -> 1027
      //   1143: aload 6
      //   1145: iconst_2
      //   1146: invokeinterface 145 2 0
      //   1151: astore 9
      //   1153: aload 9
      //   1155: invokestatic 363	com/tencent/mm/plugin/fts/b/a:ayC	(Ljava/lang/String;)Z
      //   1158: ifne +16 -> 1174
      //   1161: aload_0
      //   1162: aload_0
      //   1163: getfield 64	com/tencent/mm/plugin/fts/b/a$b:wYu	I
      //   1166: iconst_1
      //   1167: iadd
      //   1168: putfield 64	com/tencent/mm/plugin/fts/b/a$b:wYu	I
      //   1171: goto -144 -> 1027
      //   1174: aload 6
      //   1176: iconst_3
      //   1177: invokeinterface 296 2 0
      //   1182: astore 8
      //   1184: getstatic 369	com/tencent/mm/plugin/fts/a/c$a:wUY	Ljava/util/regex/Pattern;
      //   1187: aload 9
      //   1189: invokevirtual 375	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;)[Ljava/lang/String;
      //   1192: astore 9
      //   1194: aload 9
      //   1196: new 9	com/tencent/mm/plugin/fts/b/a$b$1
      //   1199: dup
      //   1200: aload_0
      //   1201: invokespecial 378	com/tencent/mm/plugin/fts/b/a$b$1:<init>	(Lcom/tencent/mm/plugin/fts/b/a$b;)V
      //   1204: invokestatic 384	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
      //   1207: aload_0
      //   1208: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   1211: aload 5
      //   1213: aload 9
      //   1215: invokevirtual 388	com/tencent/mm/plugin/fts/b/a:j	(Ljava/lang/String;[Ljava/lang/String;)I
      //   1218: istore_2
      //   1219: iload_1
      //   1220: iload_2
      //   1221: iadd
      //   1222: istore_1
      //   1223: aload_0
      //   1224: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   1227: aload 5
      //   1229: aload 7
      //   1231: aload 9
      //   1233: aload 8
      //   1235: aload_0
      //   1236: getfield 48	com/tencent/mm/plugin/fts/b/a$b:wYn	Ljava/util/HashMap;
      //   1239: invokevirtual 391	com/tencent/mm/plugin/fts/b/a:a	(Ljava/lang/String;Lcom/tencent/mm/storage/as;[Ljava/lang/String;[BLjava/util/HashMap;)I
      //   1242: istore_2
      //   1243: iload_1
      //   1244: iload_2
      //   1245: iadd
      //   1246: istore_1
      //   1247: aload_0
      //   1248: aload_0
      //   1249: getfield 56	com/tencent/mm/plugin/fts/b/a$b:wYq	I
      //   1252: iconst_1
      //   1253: iadd
      //   1254: putfield 56	com/tencent/mm/plugin/fts/b/a$b:wYq	I
      //   1257: iload_1
      //   1258: istore_2
      //   1259: iload_2
      //   1260: istore_1
      //   1261: iload_2
      //   1262: bipush 50
      //   1264: if_icmplt -237 -> 1027
      //   1267: aload_0
      //   1268: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   1271: invokestatic 125	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   1274: invokevirtual 268	com/tencent/mm/plugin/fts/c/a:commit	()V
      //   1277: aload_0
      //   1278: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   1281: invokestatic 125	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   1284: invokevirtual 328	com/tencent/mm/plugin/fts/c/a:beginTransaction	()V
      //   1287: iconst_0
      //   1288: istore_1
      //   1289: goto -262 -> 1027
      //   1292: astore 5
      //   1294: ldc 103
      //   1296: aload 5
      //   1298: ldc_w 352
      //   1301: iconst_0
      //   1302: anewarray 78	java/lang/Object
      //   1305: invokestatic 356	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1308: aload_0
      //   1309: aload_0
      //   1310: getfield 64	com/tencent/mm/plugin/fts/b/a$b:wYu	I
      //   1313: iconst_1
      //   1314: iadd
      //   1315: putfield 64	com/tencent/mm/plugin/fts/b/a$b:wYu	I
      //   1318: iload_1
      //   1319: istore_2
      //   1320: goto -61 -> 1259
      //   1323: aload 6
      //   1325: invokeinterface 187 1 0
      //   1330: aload_0
      //   1331: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   1334: invokestatic 125	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   1337: invokevirtual 268	com/tencent/mm/plugin/fts/c/a:commit	()V
      //   1340: aload_0
      //   1341: ldc_w 393
      //   1344: invokevirtual 116	com/tencent/mm/plugin/fts/b/a$b:ayx	(Ljava/lang/String;)V
      //   1347: invokestatic 202	java/lang/Thread:interrupted	()Z
      //   1350: ifeq +20 -> 1370
      //   1353: new 204	java/lang/InterruptedException
      //   1356: dup
      //   1357: invokespecial 205	java/lang/InterruptedException:<init>	()V
      //   1360: astore 5
      //   1362: ldc 101
      //   1364: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1367: aload 5
      //   1369: athrow
      //   1370: aload_0
      //   1371: aload_0
      //   1372: getfield 118	com/tencent/mm/plugin/fts/b/a$b:wYm	Ljava/util/HashSet;
      //   1375: invokevirtual 192	java/util/HashSet:size	()I
      //   1378: putfield 60	com/tencent/mm/plugin/fts/b/a$b:wYs	I
      //   1381: aload_0
      //   1382: getfield 118	com/tencent/mm/plugin/fts/b/a$b:wYm	Ljava/util/HashSet;
      //   1385: invokevirtual 239	java/util/HashSet:iterator	()Ljava/util/Iterator;
      //   1388: astore 5
      //   1390: aload 5
      //   1392: invokeinterface 221 1 0
      //   1397: ifeq +53 -> 1450
      //   1400: aload 5
      //   1402: invokeinterface 225 1 0
      //   1407: checkcast 92	java/lang/String
      //   1410: astore 6
      //   1412: aload_0
      //   1413: getfield 33	com/tencent/mm/plugin/fts/b/a$b:wYk	Lcom/tencent/mm/plugin/fts/b/a;
      //   1416: invokestatic 125	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   1419: getstatic 131	com/tencent/mm/plugin/fts/a/c:wUK	[I
      //   1422: aload 6
      //   1424: invokevirtual 396	com/tencent/mm/plugin/fts/c/a:a	([ILjava/lang/String;)V
      //   1427: ldc_w 398
      //   1430: invokestatic 404	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   1433: checkcast 398	com/tencent/mm/plugin/fts/PluginFTS
      //   1436: invokevirtual 408	com/tencent/mm/plugin/fts/PluginFTS:getTopHitsLogic	()Lcom/tencent/mm/plugin/fts/b/e;
      //   1439: getstatic 131	com/tencent/mm/plugin/fts/a/c:wUK	[I
      //   1442: aload 6
      //   1444: invokevirtual 412	com/tencent/mm/plugin/fts/b/e:c	([ILjava/lang/String;)V
      //   1447: goto -57 -> 1390
      //   1450: aload_0
      //   1451: getfield 118	com/tencent/mm/plugin/fts/b/a$b:wYm	Ljava/util/HashSet;
      //   1454: invokevirtual 254	java/util/HashSet:clear	()V
      //   1457: aload_0
      //   1458: getfield 48	com/tencent/mm/plugin/fts/b/a$b:wYn	Ljava/util/HashMap;
      //   1461: invokevirtual 232	java/util/HashMap:clear	()V
      //   1464: aload_0
      //   1465: ldc_w 414
      //   1468: invokevirtual 116	com/tencent/mm/plugin/fts/b/a$b:ayx	(Ljava/lang/String;)V
      //   1471: ldc 101
      //   1473: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1476: iconst_1
      //   1477: ireturn
      //   1478: astore 5
      //   1480: goto -186 -> 1294
      //   1483: astore 5
      //   1485: goto -191 -> 1294
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1488	0	this	b
      //   84	1235	1	i	int
      //   809	511	2	j	int
      //   93	546	3	l	long
      //   118	1110	5	localObject1	Object
      //   1292	5	5	localException1	Exception
      //   1360	41	5	localObject2	Object
      //   1478	1	5	localException2	Exception
      //   1483	1	5	localException3	Exception
      //   114	780	6	localObject3	Object
      //   917	5	6	localException4	Exception
      //   1022	421	6	localObject4	Object
      //   54	1176	7	localObject5	Object
      //   74	1160	8	localObject6	Object
      //   1151	81	9	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   840	854	917	java/lang/Exception
      //   856	868	917	java/lang/Exception
      //   870	879	917	java/lang/Exception
      //   881	886	917	java/lang/Exception
      //   888	900	917	java/lang/Exception
      //   902	912	917	java/lang/Exception
      //   1184	1219	1292	java/lang/Exception
      //   1223	1243	1478	java/lang/Exception
      //   1247	1257	1483	java/lang/Exception
    }
    
    public final int getId()
    {
      return 1;
    }
    
    public final String getName()
    {
      return "BuildContactIndexTask";
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private c() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(52648);
      a.a(a.this).B(com.tencent.mm.plugin.fts.a.c.wUI);
      AppMethodBeat.o(52648);
      return true;
    }
    
    public final String getName()
    {
      return "DeleteAllFriendTask";
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private String goe;
    private int wYz = 0;
    
    public d(String paramString)
    {
      this.goe = paramString;
    }
    
    public final String bCQ()
    {
      AppMethodBeat.i(52650);
      String str = String.format("{username: %s mDirtyCount: %d}", new Object[] { this.goe, Integer.valueOf(this.wYz) });
      AppMethodBeat.o(52650);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52649);
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", new Object[] { this.goe });
      a.a(a.this).a(com.tencent.mm.plugin.fts.a.c.wUK, this.goe);
      ((PluginFTS)g.ah(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.wUK, this.goe);
      Object localObject1 = a.a(a.this).ayH(this.goe);
      Object localObject2 = new HashSet();
      while (((Cursor)localObject1).moveToNext()) {
        ((HashSet)localObject2).add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
      localObject1 = ((HashSet)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!a.b(a.this).containsKey(localObject2))
        {
          List localList = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.wUK, (String)localObject2);
          a.b(a.this).put(localObject2, localList);
          ((PluginFTS)g.ah(PluginFTS.class)).getTopHitsLogic().ayF((String)localObject2);
          this.wYz += 1;
        }
      }
      AppMethodBeat.o(52649);
      return true;
    }
    
    public final String getName()
    {
      return "DeleteContactTask";
    }
  }
  
  final class e
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private String goe;
    private boolean hgZ = false;
    
    public e(String paramString)
    {
      this.goe = paramString;
    }
    
    public final String bCQ()
    {
      AppMethodBeat.i(52652);
      String str = String.format("{username: %s isSkipped: %b}", new Object[] { this.goe, Boolean.valueOf(this.hgZ) });
      AppMethodBeat.o(52652);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52651);
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", new Object[] { this.goe });
      as localas = a.d(a.this).ayj(this.goe);
      if ((localas != null) && (localas.field_username.length() > 0) && (a.this.V(localas))) {
        a.this.W(localas);
      }
      for (;;)
      {
        a.b(a.this).remove(this.goe);
        a.c(a.this).remove(this.goe);
        AppMethodBeat.o(52651);
        return true;
        this.hgZ = true;
      }
    }
    
    public final String getName()
    {
      return "InsertContactTask";
    }
  }
  
  final class f
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int wYA = 0;
    private int wYB = 0;
    
    private f() {}
    
    public final String bCQ()
    {
      AppMethodBeat.i(52654);
      String str = String.format("{users: %d labels: %d}", new Object[] { Integer.valueOf(this.wYA), Integer.valueOf(this.wYB) });
      AppMethodBeat.o(52654);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52653);
      Cursor localCursor = a.a(a.this).wUt.rawQuery("SELECT user, label_id FROM FTS5ContactLabels;", null);
      while (localCursor.moveToNext())
      {
        String str = localCursor.getString(0);
        long l = localCursor.getLong(1);
        List localList = (List)a.g(a.this).get(str);
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new ArrayList(16);
          a.g(a.this).put(str, localObject);
          this.wYA += 1;
        }
        ((List)localObject).add(Long.valueOf(l));
        this.wYB += 1;
      }
      localCursor.close();
      AppMethodBeat.o(52653);
      return true;
    }
    
    public final String getName()
    {
      return "LoadLabelCacheTask";
    }
  }
  
  final class g
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int tkX = 0;
    private int[] wYC;
    private int wYD = 0;
    
    public g(int[] paramArrayOfInt)
    {
      this.wYC = paramArrayOfInt;
    }
    
    public final String bCQ()
    {
      AppMethodBeat.i(52656);
      String str = String.format("{touched: %d users: %d}", new Object[] { Integer.valueOf(this.tkX), Integer.valueOf(this.wYD) });
      AppMethodBeat.o(52656);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52655);
      Object localObject = a.a(a.this).j(this.wYC, 1);
      this.tkX = ((List)localObject).size();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.fts.a.a.b localb = (com.tencent.mm.plugin.fts.a.a.b)localIterator.next();
        String str = localb.wVX;
        if (!a.b(a.this).containsKey(str))
        {
          List localList = (List)localHashMap.get(str);
          localObject = localList;
          if (localList == null)
          {
            localObject = new ArrayList(16);
            localHashMap.put(str, localObject);
          }
          ((List)localObject).add(Long.valueOf(localb.wVV));
        }
      }
      a.b(a.this).putAll(localHashMap);
      this.wYD = localHashMap.size();
      AppMethodBeat.o(52655);
      return true;
    }
    
    public final String getName()
    {
      return "MarkAllContactDirtyTask";
    }
  }
  
  final class h
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private String goe;
    private boolean hgZ = false;
    private boolean wYE = false;
    
    public h(String paramString)
    {
      this.goe = paramString;
    }
    
    public final String bCQ()
    {
      AppMethodBeat.i(52658);
      String str = String.format("{username: %s cached: %b isSkipped: %b}", new Object[] { this.goe, Boolean.valueOf(this.wYE), Boolean.valueOf(this.hgZ) });
      AppMethodBeat.o(52658);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52657);
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", new Object[] { this.goe });
      if (a.b(a.this).containsKey(this.goe))
      {
        this.wYE = true;
        AppMethodBeat.o(52657);
        return true;
      }
      a.a(a.this).ayn(this.goe);
      Object localObject1 = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.wUK, this.goe);
      a.b(a.this).put(this.goe, localObject1);
      if (((List)localObject1).isEmpty())
      {
        this.hgZ = true;
        a.e(a.this).a(65556, new a.e(a.this, this.goe));
        AppMethodBeat.o(52657);
        return true;
      }
      localObject1 = a.a(a.this).ayH(this.goe);
      Object localObject2 = new HashSet();
      while (((Cursor)localObject1).moveToNext()) {
        ((HashSet)localObject2).add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
      localObject1 = ((HashSet)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        a.a(a.this).ayn((String)localObject2);
        if (!a.b(a.this).containsKey(localObject2))
        {
          List localList = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.wUK, (String)localObject2);
          a.b(a.this).put(localObject2, localList);
        }
      }
      a.c(a.this).remove(this.goe);
      ((PluginFTS)g.ah(PluginFTS.class)).getTopHitsLogic().ayF(this.goe);
      AppMethodBeat.o(52657);
      return true;
    }
    
    public final int getId()
    {
      return 17;
    }
    
    public final String getName()
    {
      return "MarkContactDirtyTask";
    }
  }
  
  final class i
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private String username;
    private boolean wYF;
    
    public i(String paramString)
    {
      this.username = paramString;
    }
    
    public final String bCQ()
    {
      AppMethodBeat.i(52660);
      String str = String.format("{username: %s isSkipped: %b}", new Object[] { this.username, Boolean.valueOf(this.wYF) });
      AppMethodBeat.o(52660);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52659);
      if (a.b(a.this).containsKey(this.username))
      {
        this.wYF = true;
        AppMethodBeat.o(52659);
        return true;
      }
      if (!a.c(a.this).add(this.username))
      {
        this.wYF = true;
        AppMethodBeat.o(52659);
        return true;
      }
      Object localObject = a.d(a.this).ayj(this.username);
      if ((localObject != null) && (!a.this.V((as)localObject)))
      {
        this.wYF = true;
        AppMethodBeat.o(52659);
        return true;
      }
      localObject = a.a(a.this);
      String str = this.username;
      ((com.tencent.mm.plugin.fts.a.a)localObject).wUz.bindLong(1, 2L);
      ((com.tencent.mm.plugin.fts.a.a)localObject).wUz.bindString(2, str);
      ((com.tencent.mm.plugin.fts.a.a)localObject).wUz.bindLong(3, 0L);
      ((com.tencent.mm.plugin.fts.a.a)localObject).wUz.execute();
      AppMethodBeat.o(52659);
      return true;
    }
    
    public final String getName()
    {
      return "MarkContactTimestampTask";
    }
  }
  
  final class j
    extends i
  {
    public j(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52661);
      paramk.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
      Object localObject1 = a.a(a.this).a(paramk.wWd, this.wWO.wWU, this.wWO.wWV, true, true);
      Object localObject2 = new HashMap();
      HashMap localHashMap = new HashMap();
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject1);
        if (!this.wWO.wWX.contains(localn.wVX))
        {
          com.tencent.mm.plugin.fts.a.a.m localm;
          if (d.k(com.tencent.mm.plugin.fts.a.c.wUK, localn.type))
          {
            localm = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject2).get(localn.wVX);
            if ((localm == null) || (d.f(com.tencent.mm.plugin.fts.a.c.wUV, localn.wVW, localm.wVW) < 0)) {
              ((HashMap)localObject2).put(localn.wVX, localn);
            }
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException();
            AppMethodBeat.o(52661);
            throw paramk;
            if (d.k(com.tencent.mm.plugin.fts.a.c.wUM, localn.type))
            {
              localm = (com.tencent.mm.plugin.fts.a.a.m)localHashMap.get(Long.valueOf(localn.wXe));
              if ((localm == null) || (d.f(com.tencent.mm.plugin.fts.a.c.wUV, localn.wVW, localm.wVW) < 0)) {
                localHashMap.put(Long.valueOf(localn.wXe), localn);
              }
            }
          }
        }
      }
      ((Cursor)localObject1).close();
      if (Thread.interrupted())
      {
        paramk = new InterruptedException();
        AppMethodBeat.o(52661);
        throw paramk;
      }
      paramk.wXb = new ArrayList(((HashMap)localObject2).size());
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).dOC();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.wWd);
        paramk.wXb.add(localObject2);
      }
      paramk.wXb.addAll(localHashMap.values());
      if (Thread.interrupted())
      {
        paramk = new InterruptedException();
        AppMethodBeat.o(52661);
        throw paramk;
      }
      if (this.wWO.wWY != null) {
        Collections.sort(paramk.wXb, this.wWO.wWY);
      }
      AppMethodBeat.o(52661);
    }
    
    public final int getId()
    {
      return 11;
    }
    
    public final String getName()
    {
      return "SearchContactLogic.SearchTask";
    }
  }
  
  final class k
    extends i
  {
    public k(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52662);
      super.a(paramk);
      Object localObject1 = a.a(a.this);
      Object localObject2 = this.wWO.query;
      String str = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075 ORDER BY timestamp desc", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt() });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).wUt.rawQuery(str, new String[] { localObject2 });
      paramk.wXb = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).wVX = ((Cursor)localObject1).getString(0);
        paramk.wXb.add(localObject2);
      }
      ((Cursor)localObject1).close();
      paramk.resultCode = 0;
      AppMethodBeat.o(52662);
    }
    
    public final String getName()
    {
      return "SearchChatroomByMemberTask";
    }
  }
  
  final class l
    extends i
  {
    public l(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      int i = 0;
      AppMethodBeat.i(52663);
      super.a(paramk);
      Object localObject = a.a(a.this);
      String str1 = this.wWO.query;
      String str2 = String.format("SELECT count(aux_index) FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject).dOt() });
      localObject = ((com.tencent.mm.plugin.fts.a.a)localObject).wUt.rawQuery(str2, new String[] { str1 });
      if (((Cursor)localObject).moveToNext()) {
        i = ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
      localObject = new com.tencent.mm.plugin.fts.a.a.m();
      ((com.tencent.mm.plugin.fts.a.a.m)localObject).userData = Integer.valueOf(i);
      paramk.wXb = new ArrayList();
      paramk.wXb.add(localObject);
      AppMethodBeat.o(52663);
    }
    
    public final String getName()
    {
      return "SearchChatroomCountTask";
    }
  }
  
  final class m
    extends i
  {
    public m(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52664);
      super.a(paramk);
      Object localObject1 = a.a(a.this);
      Object localObject2 = this.wWO.wWS;
      Object localObject3 = paramk.wWd.dOz();
      localObject3 = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN (SELECT docid, aux_index, timestamp FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=?) as temp ON (%s.rowid = temp.docid) WHERE %s MATCH '%s' ORDER BY -timestamp;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).wUt.rawQuery((String)localObject3, new String[] { localObject2 });
      localObject2 = new HashSet();
      paramk.wXb = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).wVX = ((Cursor)localObject1).getString(0);
        if (((HashSet)localObject2).add(((com.tencent.mm.plugin.fts.a.a.m)localObject3).wVX)) {
          paramk.wXb.add(localObject3);
        }
      }
      ((Cursor)localObject1).close();
      paramk.resultCode = 0;
      AppMethodBeat.o(52664);
    }
    
    public final String getName()
    {
      return "SearchChatroomInMemberTask";
    }
  }
  
  public final class n
    extends i
  {
    public n(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(187308);
      paramk.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
      paramk.wXb = new ArrayList();
      Object localObject1 = a.a(a.this);
      Object localObject2 = this.wWO.wWS;
      String str = paramk.wWd.dOz();
      str = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, entity_id, type, subtype) AS Offsets FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 AND subtype = 38 AND aux_index = ? ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), str });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).wUt.rawQuery(str, new String[] { localObject2 });
      if (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject1);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).dOC();
        paramk.wXb.add(localObject2);
      }
      ((Cursor)localObject1).close();
      AppMethodBeat.o(187308);
    }
    
    public final String getName()
    {
      return "SearchChatroomMemberTask";
    }
  }
  
  final class o
    extends i
  {
    public o(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52665);
      paramk.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
      Object localObject2 = a.a(a.this).a(paramk.wWd, new int[] { 131075 }, null, true, true);
      Object localObject1 = new HashMap();
      Object localObject4;
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject2);
        if (!this.wWO.wWX.contains(((com.tencent.mm.plugin.fts.a.a.n)localObject3).wVX))
        {
          localObject4 = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject1).get(((com.tencent.mm.plugin.fts.a.a.n)localObject3).wVX);
          if ((localObject4 == null) || (d.f(com.tencent.mm.plugin.fts.a.c.wUV, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).wVW, ((com.tencent.mm.plugin.fts.a.a.m)localObject4).wVW) < 0)) {
            ((HashMap)localObject1).put(((com.tencent.mm.plugin.fts.a.a.n)localObject3).wVX, localObject3);
          }
          if (Thread.interrupted())
          {
            ((Cursor)localObject2).close();
            paramk = new InterruptedException();
            AppMethodBeat.o(52665);
            throw paramk;
          }
        }
      }
      ((Cursor)localObject2).close();
      localObject2 = new ArrayList(((HashMap)localObject1).size());
      Object localObject3 = ((HashMap)localObject1).values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject3).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).dOC();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).a(paramk.wWd);
        ((ArrayList)localObject2).add(localObject4);
        if (Thread.interrupted())
        {
          paramk = new InterruptedException();
          AppMethodBeat.o(52665);
          throw paramk;
        }
      }
      if (this.wWO.wWY != null) {
        Collections.sort((List)localObject2, this.wWO.wWY);
      }
      paramk.wXb = new ArrayList(((HashMap)localObject1).size());
      localObject1 = new StringBuffer();
      int i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        localObject3 = (com.tencent.mm.plugin.fts.a.a.m)((ArrayList)localObject2).get(i);
        ((StringBuffer)localObject1).append(((com.tencent.mm.plugin.fts.a.a.m)localObject3).wWz);
        ((StringBuffer)localObject1).append("|");
        ((StringBuffer)localObject1).append(((com.tencent.mm.plugin.fts.a.a.m)localObject3).timestamp);
        ((StringBuffer)localObject1).append(" ");
        paramk.wXb.add(localObject3);
        if (i >= this.wWO.wWW) {
          break;
        }
        i += 1;
      }
      if ((paramk.wWd.wWF.size() > 1) && (a.a(a.this).b(paramk.wWd)))
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).wVX = "create_chatroom​";
        paramk.wXb.add(0, localObject2);
        ((StringBuffer)localObject1).append(" needCreateChatroom");
      }
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "rank score: %s", new Object[] { ((StringBuffer)localObject1).toString() });
      AppMethodBeat.o(52665);
    }
    
    public final int getId()
    {
      return 19;
    }
    
    public final String getName()
    {
      return "SearchChatroomTask";
    }
  }
  
  public final class p
    extends i
  {
    public p(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52666);
      Object localObject2 = Util.stringsToList(this.wWO.query.split(","));
      Object localObject1 = a.a(a.this);
      Object localObject3 = new StringBuffer();
      ((StringBuffer)localObject3).append("member IN (");
      int i = 0;
      while (i < ((List)localObject2).size())
      {
        ((StringBuffer)localObject3).append("'");
        ((StringBuffer)localObject3).append((String)((List)localObject2).get(i));
        ((StringBuffer)localObject3).append("'");
        if (i != ((List)localObject2).size() - 1) {
          ((StringBuffer)localObject3).append(",");
        }
        i += 1;
      }
      ((StringBuffer)localObject3).append(")");
      localObject2 = String.format("SELECT member, chatroom, entity_id FROM FTS5ChatRoomMembers, %s WHERE %s AND chatroom = aux_index", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), ((StringBuffer)localObject3).toString() });
      localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject1).wUt.rawQuery((String)localObject2, null);
      localObject2 = new HashMap();
      if (((Cursor)localObject3).moveToNext())
      {
        String str = ((Cursor)localObject3).getString(0);
        if (((HashMap)localObject2).containsKey(str)) {}
        for (localObject1 = (List)((HashMap)localObject2).get(str);; localObject1 = new ArrayList())
        {
          com.tencent.mm.plugin.fts.a.a.m localm = new com.tencent.mm.plugin.fts.a.a.m();
          localm.wVX = ((Cursor)localObject3).getString(1);
          localm.wXe = ((Cursor)localObject3).getLong(2);
          ((List)localObject1).add(localm);
          ((HashMap)localObject2).put(str, localObject1);
          break;
        }
      }
      ((Cursor)localObject3).close();
      paramk.wXb = new ArrayList();
      localObject1 = new com.tencent.mm.plugin.fts.a.a.m();
      ((com.tencent.mm.plugin.fts.a.a.m)localObject1).userData = localObject2;
      paramk.wXb.add(localObject1);
      AppMethodBeat.o(52666);
    }
    
    public final String getName()
    {
      return "SearchCommonChatroomTask";
    }
  }
  
  public final class q
    extends i
  {
    public q(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52667);
      long l = Long.valueOf(this.wWO.query).longValue();
      Object localObject1 = a.a(a.this);
      Object localObject2 = String.format("SELECT distinct(aux_index) FROM %s WHERE timestamp < %d AND type = %d", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), Long.valueOf(l), Integer.valueOf(131072) });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).wUt.rawQuery((String)localObject2, null);
      paramk.wXb = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).wVX = ((Cursor)localObject1).getString(0);
        paramk.wXb.add(localObject2);
      }
      ((Cursor)localObject1).close();
      AppMethodBeat.o(52667);
    }
    
    public final String getName()
    {
      return "SearchContactSmallerTimestampTask";
    }
  }
  
  final class r
    extends i
  {
    public r(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52668);
      paramk.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
      Object localObject2 = a.a(a.this);
      Object localObject3 = paramk.wWd;
      Object localObject1 = this.wWO.wWU;
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).dOz();
      int i;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject1 = " AND type IN " + d.C((int[])localObject1);
        long l = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).wWF.size();
        localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject1 + " AND status >= 0 ORDER BY subtype;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject2).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject2).dOu(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.a)localObject2).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject2).dOu(), ((com.tencent.mm.plugin.fts.c.a)localObject2).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject2).dOu(), ((com.tencent.mm.plugin.fts.c.a)localObject2).dOu(), localObject4 });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).wUt.rawQuery((String)localObject1, null);
        localObject2 = new ArrayList();
        localObject3 = new HashSet();
        ((HashSet)localObject3).addAll(this.wWO.wWX);
        i = 0;
      }
      label397:
      for (;;)
      {
        if (!((Cursor)localObject1).moveToNext()) {
          break label399;
        }
        if (((HashSet)localObject3).add(((Cursor)localObject1).getString(3)))
        {
          localObject4 = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject1);
          if (i >= ((com.tencent.mm.plugin.fts.a.a.n)localObject4).wVW) {
            ((List)localObject2).add(localObject4);
          }
          for (;;)
          {
            if (!Thread.interrupted()) {
              break label397;
            }
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.wWO.query);
            AppMethodBeat.o(52668);
            throw paramk;
            localObject1 = "";
            break;
            if (((List)localObject2).size() > this.wWO.wWW) {
              break label399;
            }
            i = ((com.tencent.mm.plugin.fts.a.a.n)localObject4).wVW;
            ((List)localObject2).add(localObject4);
          }
        }
      }
      label399:
      ((Cursor)localObject1).close();
      paramk.wXb = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).dOC();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.wWd);
        paramk.wXb.add(localObject2);
      }
      if (this.wWO.wWY != null) {
        Collections.sort(paramk.wXb, this.wWO.wWY);
      }
      AppMethodBeat.o(52668);
    }
    
    public final int getId()
    {
      return 20;
    }
    
    public final String getName()
    {
      return "SearchContactTask";
    }
  }
  
  final class s
    extends i
  {
    public s(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52669);
      ayx("start");
      paramk.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.wWd;
      Object localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).dOz();
      long l1 = System.currentTimeMillis();
      long l2 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).wWF.size();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) AS Offsets, MMChatroomRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, entity_id, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 ORDER BY Rank, timestamp desc ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), Long.valueOf(l1 - 1209600000L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).wUt.rawQuery((String)localObject3, new String[] { ((com.tencent.mm.plugin.fts.a.a.h)localObject2).wWC });
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.wWO.wWX);
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().h((Cursor)localObject1);
        if (((HashSet)localObject3).add(localn.wVX)) {
          if (((List)localObject2).size() <= this.wWO.wWW)
          {
            ((List)localObject2).add(localn);
            if (Thread.interrupted())
            {
              ((Cursor)localObject1).close();
              paramk = new InterruptedException("Task is Cancel: " + this.wWO.query);
              AppMethodBeat.o(52669);
              throw paramk;
            }
          }
        }
      }
      ((Cursor)localObject1).close();
      if (Thread.interrupted())
      {
        paramk = new InterruptedException();
        AppMethodBeat.o(52669);
        throw paramk;
      }
      ayx("orm");
      paramk.wXb = new ArrayList(((List)localObject2).size());
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).dOC();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.wWd);
        paramk.wXb.add(localObject2);
      }
      if (Thread.interrupted())
      {
        paramk = new InterruptedException();
        AppMethodBeat.o(52669);
        throw paramk;
      }
      if (this.wWO.wWY != null) {
        Collections.sort(paramk.wXb, this.wWO.wWY);
      }
      ayx("calOffsets");
      if ((paramk.wWd.wWF.size() > 1) && (a.a(a.this).b(paramk.wWd)))
      {
        localObject1 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject1).wVX = "create_chatroom​";
        if (paramk.wXb.size() <= 3) {
          break label599;
        }
        paramk.wXb.add(3, localObject1);
      }
      for (;;)
      {
        ayx("checkChatroom");
        AppMethodBeat.o(52669);
        return;
        label599:
        paramk.wXb.add(localObject1);
      }
    }
    
    public final int getId()
    {
      return 25;
    }
    
    public final String getName()
    {
      return "SearchTopChatroomInnerRankTask";
    }
  }
  
  final class t
    extends i
  {
    public t(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52670);
      paramk.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.wWd;
      Object localObject3 = this.wWO.wWU;
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).dOz();
      long l1 = System.currentTimeMillis();
      long l2 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).wWF.size();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), MMContactRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type IN " + d.C((int[])localObject3) + " ORDER BY Rank ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), Long.valueOf(l1 - 1105032704L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), localObject4 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).wUt.rawQuery((String)localObject3, new String[] { ((com.tencent.mm.plugin.fts.a.a.h)localObject2).wWC });
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.wWO.wWX);
      l1 = 0L;
      while (((Cursor)localObject1).moveToNext())
      {
        localObject4 = new com.tencent.mm.plugin.fts.a.a.n().h((Cursor)localObject1);
        if (((HashSet)localObject3).add(((com.tencent.mm.plugin.fts.a.a.n)localObject4).wVX))
        {
          if (l1 >= ((com.tencent.mm.plugin.fts.a.a.n)localObject4).wXm) {
            ((List)localObject2).add(localObject4);
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.wWO.query);
            AppMethodBeat.o(52670);
            throw paramk;
            if (((List)localObject2).size() > this.wWO.wWW) {
              break label407;
            }
            l1 = ((com.tencent.mm.plugin.fts.a.a.n)localObject4).wXm;
            ((List)localObject2).add(localObject4);
          }
        }
      }
      label407:
      ((Cursor)localObject1).close();
      paramk.wXb = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).dOC();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.wWd);
        paramk.wXb.add(localObject2);
      }
      if (this.wWO.wWY != null) {
        Collections.sort(paramk.wXb, this.wWO.wWY);
      }
      AppMethodBeat.o(52670);
    }
    
    public final int getId()
    {
      return 26;
    }
    
    public final String getName()
    {
      return "SearchTopContactInnerRankTask";
    }
  }
  
  final class u
    extends i
  {
    public u(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      int i = 0;
      AppMethodBeat.i(52671);
      paramk.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.wWd;
      Object localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).dOz();
      long l1 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).wWF.size();
      long l2 = System.currentTimeMillis();
      localObject2 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), Long.valueOf(l1), Long.valueOf(l2 - 1105032704L), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.a)localObject1).dOu(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).wUt.rawQuery((String)localObject2, null);
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.wWO.wWX);
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject1);
        if (((HashSet)localObject3).add(localn.wVX))
        {
          if (i >= localn.wVW) {
            ((List)localObject2).add(localn);
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.wWO.query);
            AppMethodBeat.o(52671);
            throw paramk;
            if (((List)localObject2).size() > this.wWO.wWW) {
              break label345;
            }
            i = localn.wVW;
            ((List)localObject2).add(localn);
          }
        }
      }
      label345:
      ((Cursor)localObject1).close();
      paramk.wXb = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).dOC();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.wWd);
        paramk.wXb.add(localObject2);
      }
      if (this.wWO.wWY != null) {
        Collections.sort(paramk.wXb, this.wWO.wWY);
      }
      AppMethodBeat.o(52671);
    }
    
    public final int getId()
    {
      return 22;
    }
    
    public final String getName()
    {
      return "SearchTopContactTask";
    }
  }
  
  final class v
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int wYG = 0;
    private int wYH = 0;
    private int wYI = 0;
    
    private v() {}
    
    public final String bCQ()
    {
      AppMethodBeat.i(52673);
      String str = String.format("{Dirty: %d Timestamp: %d tophitsCount: %d}", new Object[] { Integer.valueOf(this.wYG), Integer.valueOf(this.wYH), Integer.valueOf(this.wYI) });
      AppMethodBeat.o(52673);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52672);
      ayx("start");
      Object localObject1 = a.b(a.this).entrySet().iterator();
      int i = 50;
      if (((Iterator)localObject1).hasNext())
      {
        if (Thread.interrupted())
        {
          a.a(a.this).commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52672);
          throw ((Throwable)localObject1);
        }
        if (i < 50) {
          break label542;
        }
        a.a(a.this).commit();
        a.a(a.this).beginTransaction();
        i = 0;
      }
      label533:
      label536:
      label542:
      for (;;)
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        Object localObject3 = ((List)((Map.Entry)localObject2).getValue()).iterator();
        long l;
        while (((Iterator)localObject3).hasNext())
        {
          l = ((Long)((Iterator)localObject3).next()).longValue();
          a.a(a.this).GC(l);
          i += 1;
        }
        localObject2 = (String)((Map.Entry)localObject2).getKey();
        localObject3 = a.d(a.this).ayj((String)localObject2);
        if ((localObject3 != null) && (((ax)localObject3).field_username.length() > 0) && (a.this.V((as)localObject3))) {
          i += a.this.W((as)localObject3);
        }
        for (;;)
        {
          ((Iterator)localObject1).remove();
          a.c(a.this).remove(localObject2);
          this.wYG += 1;
          break;
          ayx("dirtyContact");
          localObject1 = a.c(a.this).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            if (Thread.interrupted())
            {
              a.a(a.this).commit();
              localObject1 = new InterruptedException();
              AppMethodBeat.o(52672);
              throw ((Throwable)localObject1);
            }
            if (i < 50) {
              break label533;
            }
            a.a(a.this).commit();
            a.a(a.this).beginTransaction();
            i = 0;
            label363:
            localObject2 = (String)((Iterator)localObject1).next();
            l = a.d(a.this).ayl((String)localObject2);
            localObject3 = a.d(a.this).ayj((String)localObject2);
            if ((localObject3 == null) || (((ax)localObject3).field_username.length() <= 0) || (!a.this.V((as)localObject3))) {
              break label536;
            }
            a.a(a.this).av((String)localObject2, l);
            i += 1;
          }
          for (;;)
          {
            ((Iterator)localObject1).remove();
            this.wYH += 1;
            break;
            a.a(a.this).commit();
            ayx("timestampContact");
            localObject1 = ((PluginFTS)g.ah(PluginFTS.class)).getTopHitsLogic();
            ((e)localObject1).wZo.clear();
            this.wYI = ((e)localObject1).wZn.dOZ();
            ayx("topHits");
            AppMethodBeat.o(52672);
            return true;
            break label363;
          }
        }
      }
    }
    
    public final int getId()
    {
      return 16;
    }
    
    public final String getName()
    {
      return "UpdateDirtyAndTimestampContactTask";
    }
  }
  
  final class w
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private long wYJ;
    private int wYK = 0;
    
    public w(long paramLong)
    {
      this.wYJ = paramLong;
    }
    
    public final String bCQ()
    {
      AppMethodBeat.i(52675);
      String str = String.format("{mLabelId: %d mContactCount: %d}", new Object[] { Long.valueOf(this.wYJ), Integer.valueOf(this.wYK) });
      AppMethodBeat.o(52675);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52674);
      Object localObject1 = new ArrayList(32);
      Object localObject2 = a.a(a.this);
      long l = this.wYJ;
      localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject2).wUt.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[] { Long.toString(l) });
      while (((Cursor)localObject2).moveToNext()) {
        ((ArrayList)localObject1).add(((Cursor)localObject2).getString(0));
      }
      ((Cursor)localObject2).close();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!a.b(a.this).containsKey(localObject2))
        {
          List localList = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.wUL, (String)localObject2);
          a.b(a.this).put(localObject2, localList);
        }
      }
      AppMethodBeat.o(52674);
      return true;
    }
    
    public final String getName()
    {
      return "UpdateLabelTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a
 * JD-Core Version:    0.7.0.1
 */