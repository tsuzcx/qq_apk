package com.tencent.mm.plugin.fts.b;

import android.content.Context;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xm;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
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
  private static Set<String> tHk;
  private com.tencent.mm.plugin.fts.a.m gtT;
  private com.tencent.mm.plugin.fts.a.j rCj;
  private com.tencent.mm.plugin.fts.c.a tGW;
  private HashSet<String> tGX;
  private HashMap<String, List<Long>> tGY;
  private HashMap<String, String[]> tGZ;
  private HashMap<String, List<Long>> tHa;
  private Method tHb;
  private n.b tHc;
  private n.b tHd;
  private k.a tHe;
  private k.a tHf;
  private com.tencent.mm.sdk.b.c tHg;
  private com.tencent.mm.sdk.b.c tHh;
  private com.tencent.mm.sdk.platformtools.aw tHi;
  private com.tencent.mm.sdk.platformtools.aw tHj;
  
  static
  {
    AppMethodBeat.i(52693);
    tHk = new HashSet();
    String[] arrayOfString = ak.getContext().getString(2131757953).split(";");
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        tHk.add(str);
        i += 1;
      }
    }
    AppMethodBeat.o(52693);
  }
  
  public a()
  {
    AppMethodBeat.i(52681);
    this.tHc = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(52631);
        paramAnonymousn = (String)paramAnonymousObject;
        if (!a.alx(paramAnonymousn))
        {
          ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "onConversationChangeListener filterByUsername %s", new Object[] { paramAnonymousn });
          AppMethodBeat.o(52631);
          return;
        }
        paramAnonymousObject = ((l)g.ab(l.class)).azF().aUG(paramAnonymousn);
        if ((paramAnonymousObject != null) && ((!a.U(paramAnonymousObject)) || (paramAnonymousObject.fug())))
        {
          ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[] { paramAnonymousn });
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
          if (!a.b(a.this).containsKey(paramAnonymousn))
          {
            a.e(a.this).a(65556, new a.h(a.this, paramAnonymousn));
            AppMethodBeat.o(52631);
            return;
            if ((!a.c(a.this).contains(paramAnonymousn)) && (!a.b(a.this).containsKey(paramAnonymousn))) {
              a.e(a.this).a(65556, new a.i(a.this, paramAnonymousn));
            }
          }
        }
      }
    };
    this.tHd = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(52632);
        paramAnonymousn = (String)paramAnonymousObject;
        if (!a.alx(paramAnonymousn))
        {
          ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", new Object[] { paramAnonymousn });
          AppMethodBeat.o(52632);
          return;
        }
        paramAnonymousObject = ((l)g.ab(l.class)).azF().aUG(paramAnonymousn);
        if ((paramAnonymousObject != null) && (!a.U(paramAnonymousObject)))
        {
          ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[] { paramAnonymousn });
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
          if (!a.b(a.this).containsKey(paramAnonymousn))
          {
            a.e(a.this).a(65556, new a.h(a.this, paramAnonymousn));
            AppMethodBeat.o(52632);
            return;
            a.e(a.this).a(65556, new a.e(a.this, paramAnonymousn));
            AppMethodBeat.o(52632);
            return;
            a.e(a.this).a(65556, new a.d(a.this, paramAnonymousn));
          }
        }
      }
    };
    this.tHe = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
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
    this.tHf = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
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
            long l = bu.getLong(paramAnonymousString[i], 0L);
            a.e(a.this).a(65554, new a.v(a.this, l));
            i += 1;
          }
          a.e(a.this).a(65556, new a.u(a.this, (byte)0));
        }
        AppMethodBeat.o(52634);
      }
    };
    this.tHg = new com.tencent.mm.sdk.b.c() {};
    this.tHh = new com.tencent.mm.sdk.b.c() {};
    this.tHi = new com.tencent.mm.sdk.platformtools.aw(g.ajU().IxZ.getLooper(), new aw.a()
    {
      private int tHm = 0;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52637);
        PluginFTS localPluginFTS = (PluginFTS)g.ad(PluginFTS.class);
        if ((localPluginFTS.isCharging()) || (!localPluginFTS.isInBackground())) {}
        for (int i = 1; i == 0; i = 0)
        {
          i = this.tHm + 1;
          this.tHm = i;
          if (i >= 6) {
            break;
          }
          AppMethodBeat.o(52637);
          return true;
        }
        a.e(a.this).a(131093, new a.u(a.this, (byte)0));
        this.tHm = 0;
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
    this.tHj = new com.tencent.mm.sdk.platformtools.aw(g.ajU().IxZ.getLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52639);
        a.e(a.this).a(131093, new a.u(a.this, (byte)0));
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
  
  static boolean U(an paraman)
  {
    AppMethodBeat.i(52684);
    if ((paraman.isHidden()) && (!"notifymessage".equals(paraman.field_username)))
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (paraman.adv())
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (paraman.field_deleteFlag != 0)
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (!com.tencent.mm.contact.c.lO(paraman.field_type))
    {
      if (paraman.adu())
      {
        AppMethodBeat.o(52684);
        return false;
      }
      if (paraman.fug())
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
    gR(paramString1, str);
    paramString2 = this.rCj.ali(str);
    if (paramString2.size() == 0)
    {
      AppMethodBeat.o(52690);
      return 0;
    }
    paramString2 = bu.m(paramString2, "​");
    this.tGW.a(131072, 11, paramLong1, paramString1, paramLong2, paramString2);
    AppMethodBeat.o(52690);
    return 1;
  }
  
  private int a(an paraman, long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(52688);
    Object localObject = paraman.eRy;
    int i = j;
    if (!bu.isNullOrNil((String)localObject))
    {
      com.tencent.mm.openim.a.b localb = new com.tencent.mm.openim.a.b();
      localb.Jd((String)localObject);
      localObject = new StringBuffer();
      i = 0;
      while (i < localb.iKp.size())
      {
        Iterator localIterator = ((b.a)localb.iKp.get(i)).iKq.iterator();
        while (localIterator.hasNext())
        {
          String str = ((b.b)localIterator.next()).Je(paraman.field_openImAppid);
          if (!bu.isNullOrNil(str))
          {
            ((StringBuffer)localObject).append(str);
            ((StringBuffer)localObject).append("‌");
          }
        }
        ((StringBuffer)localObject).append("​");
        i += 1;
      }
      i = j;
      if (!bu.isNullOrNil(((StringBuffer)localObject).toString()))
      {
        this.tGW.a(131081, 51, paraman.ght, paraman.field_username, paramLong, ((StringBuffer)localObject).toString());
        i = 1;
      }
    }
    AppMethodBeat.o(52688);
    return i;
  }
  
  static boolean alx(String paramString)
  {
    AppMethodBeat.i(52683);
    if (bu.isNullOrNil(paramString))
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
  
  public static boolean aly(String paramString)
  {
    AppMethodBeat.i(52692);
    boolean bool = bu.bI(paramString, "").contains(v.aAC());
    AppMethodBeat.o(52692);
    return bool;
  }
  
  private void gR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52689);
    Object localObject1 = c.a.tEg.split(paramString2);
    if (localObject1.length != 0)
    {
      paramString2 = new ArrayList(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        paramString2.add(Long.valueOf(bu.getLong(localObject1[i], 0L)));
        i += 1;
      }
    }
    for (;;)
    {
      localObject1 = (List)this.tHa.get(paramString1);
      if (localObject1 == null)
      {
        this.tGW.alC(paramString1);
        if ((paramString2 != null) && (!paramString2.isEmpty()))
        {
          this.tGW.t(paramString1, paramString2);
          this.tHa.put(paramString1, paramString2);
          AppMethodBeat.o(52689);
        }
      }
      else
      {
        if ((paramString2 == null) || (paramString2.isEmpty()))
        {
          this.tGW.alC(paramString1);
          this.tHa.remove(paramString1);
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
            com.tencent.mm.plugin.fts.c.a locala = this.tGW;
            locala.tIE.bindString(1, paramString1);
            locala.tIE.bindLong(2, l);
            locala.tIE.execute();
          }
        }
        localObject1 = ((HashSet)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          l = ((Long)((Iterator)localObject1).next()).longValue();
          localObject2 = this.tGW;
          ((com.tencent.mm.plugin.fts.c.a)localObject2).tIF.bindString(1, paramString1);
          ((com.tencent.mm.plugin.fts.c.a)localObject2).tIF.bindLong(2, l);
          ((com.tencent.mm.plugin.fts.c.a)localObject2).tIF.execute();
        }
        this.tHa.put(paramString1, paramString2);
      }
      AppMethodBeat.o(52689);
      return;
      paramString2 = null;
    }
  }
  
  private static String zR(String paramString)
  {
    AppMethodBeat.i(52691);
    if (tHk.contains(paramString))
    {
      AppMethodBeat.o(52691);
      return "";
    }
    AppMethodBeat.o(52691);
    return paramString;
  }
  
  final void T(an paraman)
  {
    AppMethodBeat.i(52682);
    try
    {
      this.tHb.invoke(paraman, new Object[0]);
      AppMethodBeat.o(52682);
      return;
    }
    catch (Exception paraman)
    {
      ae.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paraman, "Failed parsing RContact LVBuffer.", new Object[0]);
      AppMethodBeat.o(52682);
    }
  }
  
  final boolean V(an paraman)
  {
    AppMethodBeat.i(52685);
    String str = paraman.field_username;
    if (!U(paraman))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if (!alx(str))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if ((an.aUu(str)) || (an.aUt(str)))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if (!com.tencent.mm.contact.c.lO(paraman.field_type))
    {
      if ((!paraman.adu()) && (!paraman.fug()))
      {
        if (this.rCj.alg(str))
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
  
  final int W(an paraman)
  {
    AppMethodBeat.i(52686);
    Object localObject1;
    Object localObject3;
    if (x.wb(paraman.field_username))
    {
      localObject1 = String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", new Object[] { "chatroom" });
      localObject3 = this.rCj.i((String)localObject1, new String[] { paraman.field_username });
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
        if ((bu.isNullOrNil((String)localObject2)) || (localObject1 == null) || (!aly((String)localObject2)))
        {
          ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", new Object[] { paraman.field_username });
          i = j(paraman.field_username, null);
          if (i > 0) {
            ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paraman.field_username, Integer.valueOf(i) });
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
      Object localObject2 = c.a.tDZ.split((CharSequence)localObject2);
      Arrays.sort((Object[])localObject2, new Comparator() {});
      int i = j(paraman.field_username, (String[])localObject2);
      if (i > 0) {
        ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paraman.field_username, Integer.valueOf(i) });
      }
      localObject3 = new HashMap();
      Object localObject4 = "SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + d.H((String[])localObject2) + ";";
      localObject4 = this.rCj.i((String)localObject4, null);
      try
      {
        while (((Cursor)localObject4).moveToNext())
        {
          an localan = new an();
          localan.ght = ((Cursor)localObject4).getLong(0);
          localan.setUsername(((Cursor)localObject4).getString(1));
          localan.tl(((Cursor)localObject4).getString(2));
          localan.tm(((Cursor)localObject4).getString(3));
          localan.to(((Cursor)localObject4).getString(4));
          localan.L(((Cursor)localObject4).getBlob(5));
          ((HashMap)localObject3).put(localan.field_username, localan);
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
      i = X(paraman);
      AppMethodBeat.o(52686);
      return i;
      label506:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  final int X(an paraman)
  {
    AppMethodBeat.i(52687);
    long l2 = paraman.ght;
    String str2 = paraman.field_username;
    Object localObject7 = paraman.VI();
    Object localObject1 = paraman.field_nickname;
    Object localObject2 = d.bn((String)localObject1, false);
    Object localObject3 = d.bn((String)localObject1, true);
    Object localObject6 = paraman.field_conRemark;
    Object localObject4 = d.bn((String)localObject6, false);
    Object localObject5 = d.bn((String)localObject6, true);
    String str3 = paraman.eRo;
    String str1 = paraman.field_contactLabelIds;
    String str4 = paraman.eRu;
    int i = paraman.field_verifyFlag;
    long l1 = System.currentTimeMillis();
    int j;
    if ((i & an.fuj()) != 0)
    {
      str1 = bu.m(((com.tencent.mm.api.m)g.ab(com.tencent.mm.api.m.class)).eS(str2), "​");
      i = 0;
      j = 131076;
    }
    for (;;)
    {
      localObject7 = d.gQ(str2, (String)localObject7);
      if ((localObject7 != null) && (((String)localObject7).length() != 0))
      {
        this.tGW.a(j, 15, l2, str2, l1, (String)localObject7);
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
                break label1014;
              }
              localObject4 = null;
            }
          }
          label416:
          label929:
          label1014:
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
            this.tGW.a(j, 1, l2, str2, l1, (String)localObject6);
            if ((localObject4 != null) && (((String)localObject4).length() != 0)) {
              this.tGW.a(j, 2, l2, str2, l1, (String)localObject4);
            }
            if ((localObject7 != null) && (((String)localObject7).length() != 0)) {
              this.tGW.a(j, 3, l2, str2, l1, (String)localObject7);
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
                this.tGW.a(j, 5, l2, str2, l1, (String)localObject5);
                if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
                  this.tGW.a(j, 6, l2, str2, l1, (String)localObject3);
                }
                if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
                  this.tGW.a(j, 7, l2, str2, l1, (String)localObject1);
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
                  this.tGW.a(j, 4, l2, str2, l1, str3);
                  i = k + 1;
                }
              }
              k = i;
              if (j == 131072)
              {
                if (bu.isNullOrNil(str4)) {
                  break label929;
                }
                localObject1 = str4.replace(com.tencent.mm.contact.a.d(paraman), "​");
                this.tGW.a(j, 16, l2, str2, l1, (String)localObject1);
                k = i + 1;
              }
              for (;;)
              {
                localObject1 = zR(paraman.getProvince());
                i = k;
                if (localObject1 != null)
                {
                  i = k;
                  if (((String)localObject1).length() != 0)
                  {
                    this.tGW.a(j, 18, l2, str2, l1, (String)localObject1);
                    i = k + 1;
                  }
                }
                localObject1 = paraman.getCity();
                k = i;
                if (localObject1 != null)
                {
                  k = i;
                  if (((String)localObject1).length() != 0)
                  {
                    this.tGW.a(j, 17, l2, str2, l1, (String)localObject1);
                    k = i + 1;
                  }
                }
                i = k;
                if (j == 131076)
                {
                  i = k;
                  if (!bu.isNullOrNil(str1))
                  {
                    this.tGW.a(j, 19, l2, str2, l1, str1);
                    i = k + 1;
                    localObject1 = d.bn(str1, false);
                    k = i;
                    if (!bu.isNullOrNil((String)localObject1))
                    {
                      this.tGW.a(j, 20, l2, str2, l1, (String)localObject1);
                      k = i + 1;
                    }
                    str1 = d.bn(str1, true);
                    i = k;
                    if (!bu.isNullOrNil(str1))
                    {
                      this.tGW.a(j, 21, l2, str2, l1, str1);
                      i = k + 1;
                    }
                  }
                }
                k = i;
                if (j == 131081) {
                  k = i + a(paraman, l1);
                }
                AppMethodBeat.o(52687);
                return k;
                if (an.aUq(str2))
                {
                  i = 0;
                  str1 = "";
                  j = 131081;
                  break;
                }
                l1 = this.rCj.alh(str2);
                if ((str1 == null) || (str1.length() <= 0)) {
                  break label1043;
                }
                i = a(l2, str2, str1, l1) + 0;
                str1 = "";
                j = 131072;
                break;
                localObject1 = this.rCj.i("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[] { str2 });
                k = i;
                if (((Cursor)localObject1).moveToFirst())
                {
                  localObject2 = ((Cursor)localObject1).getString(0);
                  this.tGW.a(j, 16, l2, str2, l1, (String)localObject2);
                  k = i + 1;
                }
                ((Cursor)localObject1).close();
              }
              break label416;
            }
          }
          Object localObject8 = localObject3;
          localObject7 = localObject1;
          localObject3 = localObject5;
          localObject1 = localObject8;
          localObject5 = localObject7;
        }
      }
      label1043:
      i = 0;
      str1 = "";
      j = 131072;
    }
  }
  
  final int a(String paramString, an paraman, String[] paramArrayOfString, byte[] paramArrayOfByte, HashMap<String, an> paramHashMap)
  {
    AppMethodBeat.i(52679);
    int j = 0;
    String str1 = paraman.field_nickname;
    paraman = paraman.field_conRemark;
    String str2 = d.bn(paraman, false);
    String str3 = d.bn(paraman, true);
    String str4 = d.bn(str1, false);
    String str5 = d.bn(str1, true);
    long l1 = 0L;
    long l3 = this.rCj.alh(paramString);
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
        paramArrayOfByte = ((com.tencent.mm.k.a.a.a)localObject).fXm.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject = (com.tencent.mm.k.a.a.b)paramArrayOfByte.next();
          if (!bu.isNullOrNil(((com.tencent.mm.k.a.a.b)localObject).fXp)) {
            localHashMap.put(((com.tencent.mm.k.a.a.b)localObject).userName, ((com.tencent.mm.k.a.a.b)localObject).fXp);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paramArrayOfByte, "parse chatroom data", new Object[0]);
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
        localObject = (an)paramHashMap.get(paramArrayOfByte);
        if (localObject != null)
        {
          String str7 = ((com.tencent.mm.g.c.aw)localObject).field_conRemark;
          String str6 = ((com.tencent.mm.g.c.aw)localObject).field_nickname;
          String str8 = d.bn(str7, false);
          String str9 = d.bn(str7, true);
          localStringBuffer.append(bu.bI(str7, " ")).append("‌");
          localStringBuffer.append(bu.bI(str8, " ")).append("‌");
          localStringBuffer.append(bu.bI(str9, " ")).append("‌");
          str7 = d.bn(str6, false);
          str8 = d.bn(str6, true);
          localStringBuffer.append(bu.bI(str6, " ")).append("‌");
          localStringBuffer.append(bu.bI(str7, " ")).append("‌");
          localStringBuffer.append(bu.bI(str8, " ")).append("‌");
          localStringBuffer.append(bu.bI((String)localHashMap.get(paramArrayOfByte), " ")).append("‌");
          T((an)localObject);
          localStringBuffer.append(bu.bI(((com.tencent.mm.g.c.aw)localObject).eRo, " ")).append("‌");
          localStringBuffer.append(bu.bI(d.gQ(paramArrayOfByte, ((an)localObject).VI()), " ")).append("‌");
          localStringBuffer.append("​");
        }
        i += 1;
      }
    }
    if (!bu.isNullOrNil(str1))
    {
      this.tGW.a(131075, 5, l1, paramString, l3, str1);
      if (bu.isNullOrNil(str4)) {
        break label761;
      }
      this.tGW.a(131075, 6, l1, paramString, l3, str4);
    }
    label761:
    for (int i = 2;; i = 1)
    {
      j = i;
      if (!bu.isNullOrNil(str5))
      {
        this.tGW.a(131075, 7, l1, paramString, l3, str5);
        j = i + 1;
      }
      i = j;
      if (!bu.isNullOrNil(paraman))
      {
        this.tGW.a(131075, 1, l1, paramString, l3, paraman);
        i = j + 1;
        j = i;
        if (!bu.isNullOrNil(str4))
        {
          this.tGW.a(131075, 2, l1, paramString, l3, str2);
          j = i + 1;
        }
        i = j;
        if (!bu.isNullOrNil(str5))
        {
          this.tGW.a(131075, 3, l1, paramString, l3, str3);
          i = j + 1;
        }
      }
      j = i;
      if (localStringBuffer.length() > 0)
      {
        localStringBuffer.setLength(localStringBuffer.length() - 1);
        this.tGW.a(131075, 38, l1, paramString, l3, localStringBuffer.toString());
        j = i + 1;
      }
      AppMethodBeat.o(52679);
      return j;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(52676);
    switch (paramj.jUf)
    {
    default: 
      paramj = new j(paramj);
    }
    for (;;)
    {
      paramj = this.gtT.a(-65536, paramj);
      AppMethodBeat.o(52676);
      return paramj;
      paramj = new q(paramj);
      continue;
      paramj = new n(paramj);
      continue;
      paramj = new t(paramj);
      continue;
      paramj = new s(paramj);
      continue;
      paramj = new l(paramj);
      continue;
      paramj = new k(paramj);
      continue;
      paramj = new m(paramj);
      continue;
      paramj = new r(paramj);
      continue;
      paramj = new o(paramj);
      continue;
      paramj = new p(paramj);
    }
  }
  
  public final boolean agO()
  {
    AppMethodBeat.i(52678);
    this.tHg.dead();
    this.tHh.dead();
    this.tHj.stopTimer();
    this.tHi.stopTimer();
    ((l)g.ab(l.class)).azF().b(this.tHd);
    ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().remove(this.tHe);
    ((l)g.ab(l.class)).azL().b(this.tHc);
    k.a locala = this.tHf;
    if (com.tencent.mm.ax.b.ihh != null) {
      com.tencent.mm.ax.b.ihh.b(locala);
    }
    if (this.tGY != null) {
      this.tGY.clear();
    }
    if (this.tGX != null) {
      this.tGX.clear();
    }
    this.tGW = null;
    this.gtT = null;
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
    Object localObject = (String[])this.tGZ.get(paramString);
    this.tGW.beginTransaction();
    int j;
    int i;
    if (localObject == null)
    {
      this.tGW.alE(paramString);
      j = (int)this.tGW.tIH.simpleQueryForLong() + 0;
      i = j;
      if (paramArrayOfString != null)
      {
        this.tGW.k(paramString, paramArrayOfString);
        this.tGZ.put(paramString, paramArrayOfString);
        i = j + paramArrayOfString.length;
      }
    }
    for (;;)
    {
      this.tGW.commit();
      AppMethodBeat.o(52680);
      return i;
      if (paramArrayOfString == null)
      {
        this.tGW.alE(paramString);
        i = (int)this.tGW.tIH.simpleQueryForLong() + 0;
        this.tGZ.remove(paramString);
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
            locala = this.tGW;
            locala.tIB.bindString(1, paramString);
            locala.tIB.bindString(2, str);
            locala.tIB.execute();
            k = i + 1;
          }
          j += 1;
        }
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          locala = this.tGW;
          locala.tIC.bindString(1, paramString);
          locala.tIC.bindString(2, str);
          locala.tIC.execute();
          i += 1;
        }
        this.tGZ.put(paramString, paramArrayOfString);
      }
    }
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(52677);
    if (!((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
      AppMethodBeat.o(52677);
      return false;
    }
    ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
    this.tGW = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3));
    this.gtT = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.rCj = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
    this.tGX = new HashSet();
    this.tGY = new HashMap();
    this.tGZ = new HashMap();
    this.tHa = new HashMap();
    try
    {
      this.tHb = com.tencent.mm.g.c.aw.class.getDeclaredMethod("parseBuff", new Class[0]);
      this.tHb.setAccessible(true);
      this.gtT.a(131072, new f((byte)0));
      this.gtT.a(131082, new a((byte)0));
      this.gtT.a(131092, new b((byte)0));
      this.gtT.a(2147483647, new c((byte)0));
      ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().add(this.tHe);
      ((l)g.ab(l.class)).azF().a(this.tHd);
      ((l)g.ab(l.class)).azL().a(this.tHc);
      k.a locala = this.tHf;
      if (com.tencent.mm.ax.b.ihh != null) {
        com.tencent.mm.ax.b.ihh.a(locala);
      }
      this.tHi.ay(600000L, 600000L);
      this.tHg.alive();
      this.tHh.alive();
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
    private int rCq = 0;
    private int rCr = 0;
    
    private a() {}
    
    public final String bhC()
    {
      AppMethodBeat.i(52643);
      String str = String.format("{new: %d removed: %d}", new Object[] { Integer.valueOf(this.rCq), Integer.valueOf(this.rCr) });
      AppMethodBeat.o(52643);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52642);
      ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
      Object localObject1 = new HashSet();
      Object localObject2 = a.a(a.this).tDu.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
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
        if ((!bu.isNullOrNil((String)localObject3)) && (!bu.isNullOrNil(str)) && (a.aly((String)localObject3)))
        {
          localObject3 = c.a.tDZ.split((CharSequence)localObject3);
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
            this.rCq += 1;
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
        a.a(a.this).alE((String)localObject2);
        this.rCr += 1;
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
    private HashSet<String> tHn;
    private HashMap<String, an> tHo;
    private long tHp;
    private long tHq;
    private int tHr;
    private int tHs;
    private int tHt;
    private int tHu;
    private int tHv;
    private int tHw;
    private int tHx;
    private int tHy;
    
    private b()
    {
      AppMethodBeat.i(52645);
      this.tHo = new HashMap();
      this.tHp = -1L;
      this.tHq = -1L;
      this.tHr = 0;
      this.tHs = 0;
      this.tHt = 0;
      this.tHu = 0;
      this.tHv = 0;
      AppMethodBeat.o(52645);
    }
    
    public final String bhC()
    {
      AppMethodBeat.i(52647);
      String str = String.format("{build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, failContact: %d, failChatroom}", new Object[] { Integer.valueOf(this.tHy), Integer.valueOf(this.tHs), Integer.valueOf(this.tHr), Integer.valueOf(this.tHt), Integer.valueOf(this.tHw), Integer.valueOf(this.tHx), Integer.valueOf(this.tHu), Integer.valueOf(this.tHv) });
      AppMethodBeat.o(52647);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52646);
      ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building contact index.");
      alt("start");
      Object localObject5;
      Object localObject6;
      long l;
      Object localObject3;
      if (this.tHn == null)
      {
        this.tHn = new HashSet();
        localObject5 = a.a(a.this).a(com.tencent.mm.plugin.fts.a.c.tDL, true, false, true, false, true);
        while (((Cursor)localObject5).moveToNext())
        {
          localObject6 = ((Cursor)localObject5).getString(1);
          i = ((Cursor)localObject5).getInt(2);
          l = ((Cursor)localObject5).getLong(0);
          if (i == 1)
          {
            localObject3 = (List)a.b(a.this).get(localObject6);
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              localObject1 = new ArrayList(16);
              a.b(a.this).put(localObject6, localObject1);
            }
            ((List)localObject1).add(Long.valueOf(l));
          }
          else
          {
            this.tHn.add(localObject6);
            if (i == 2) {
              a.c(a.this).add(localObject6);
            }
          }
        }
        ((Cursor)localObject5).close();
        this.tHw = a.b(a.this).size();
        this.tHx = a.c(a.this).size();
        this.tHy = this.tHn.size();
        if (this.tHy < 5) {
          this.tER |= 1L;
        }
      }
      alt("getBuildContact");
      if (Thread.interrupted())
      {
        localObject1 = new InterruptedException();
        AppMethodBeat.o(52646);
        throw ((Throwable)localObject1);
      }
      if (a.b(a.this).size() > 0)
      {
        localObject1 = new ArrayList();
        localObject3 = a.b(a.this).values().iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject1).addAll((List)((Iterator)localObject3).next());
        }
        a.b(a.this).clear();
        a.a(a.this).dV((List)localObject1);
      }
      alt("deleteDirtyContact");
      if (Thread.interrupted())
      {
        localObject1 = new InterruptedException();
        AppMethodBeat.o(52646);
        throw ((Throwable)localObject1);
      }
      if (a.c(a.this).size() > 0)
      {
        localObject1 = a.c(a.this).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          l = a.d(a.this).alh((String)localObject3);
          a.a(a.this).av((String)localObject3, l);
        }
        a.c(a.this).clear();
      }
      alt("updateTimestampContact");
      if (Thread.interrupted())
      {
        localObject1 = new InterruptedException();
        AppMethodBeat.o(52646);
        throw ((Throwable)localObject1);
      }
      Object localObject1 = a.d(a.this).i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE ROWID > ? AND deleteFlag=0 ORDER BY ROWID;", new String[] { Long.toString(this.tHp) });
      int i = 50;
      int j;
      while (((Cursor)localObject1).moveToNext())
      {
        if (Thread.interrupted())
        {
          ((Cursor)localObject1).close();
          a.a(a.this).commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52646);
          throw ((Throwable)localObject1);
        }
        l = ((Cursor)localObject1).getLong(0);
        this.tHp = l;
        localObject3 = new an();
        ((an)localObject3).ght = l;
        ((an)localObject3).setUsername(((Cursor)localObject1).getString(1));
        ((an)localObject3).tl(((Cursor)localObject1).getString(2));
        ((an)localObject3).tm(((Cursor)localObject1).getString(3));
        ((an)localObject3).to(((Cursor)localObject1).getString(4));
        ((an)localObject3).kd(((Cursor)localObject1).getInt(5));
        ((an)localObject3).setType(((Cursor)localObject1).getInt(6));
        ((an)localObject3).L(((Cursor)localObject1).getBlob(7));
        ((an)localObject3).tv(((Cursor)localObject1).getString(8));
        ((an)localObject3).kf(0);
        this.tHo.put(((com.tencent.mm.g.c.aw)localObject3).field_username, localObject3);
        if ((!x.wb(((com.tencent.mm.g.c.aw)localObject3).field_username)) && (a.this.V((an)localObject3)) && (!this.tHn.remove(((com.tencent.mm.g.c.aw)localObject3).field_username)))
        {
          j = i;
          if (i >= 50)
          {
            a.a(a.this).commit();
            a.a(a.this).beginTransaction();
            j = 0;
          }
          i = j;
          try
          {
            if (!((com.tencent.mm.g.c.aw)localObject3).field_username.endsWith("@chatroom"))
            {
              i = j;
              if ((((com.tencent.mm.g.c.aw)localObject3).field_verifyFlag & an.fuj()) == 0)
              {
                i = j;
                a.this.T((an)localObject3);
                i = j;
                ((an)localObject3).fum();
              }
            }
            i = j;
            j += a.this.X((an)localObject3);
            i = j;
            this.tHs += 1;
            i = j;
          }
          catch (Exception localException4)
          {
            ae.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", localException4, "Build contact index failed with exception.\n", new Object[0]);
            this.tHu += 1;
          }
        }
      }
      ((Cursor)localObject1).close();
      a.a(a.this).commit();
      alt("buildWXContact");
      if (Thread.interrupted())
      {
        localObject1 = new InterruptedException();
        AppMethodBeat.o(52646);
        throw ((Throwable)localObject1);
      }
      Object localObject4 = a.d(a.this).i("SELECT rowid, chatroomname, memberlist, roomdata FROM chatroom WHERE ROWID > ? ORDER BY ROWID;", new String[] { Long.toString(this.tHq) });
      i = 50;
      while (((Cursor)localObject4).moveToNext())
      {
        if (Thread.interrupted())
        {
          ((Cursor)localObject4).close();
          a.a(a.this).commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52646);
          throw ((Throwable)localObject1);
        }
        this.tHq = ((Cursor)localObject4).getLong(0);
        localObject1 = ((Cursor)localObject4).getString(1);
        if (!this.tHn.remove(localObject1))
        {
          localObject5 = (an)this.tHo.get(localObject1);
          if (localObject5 == null)
          {
            this.tHv += 1;
          }
          else
          {
            Object localObject7 = ((Cursor)localObject4).getString(2);
            if (!a.aly((String)localObject7))
            {
              this.tHv += 1;
            }
            else
            {
              localObject6 = ((Cursor)localObject4).getBlob(3);
              for (;;)
              {
                try
                {
                  localObject7 = c.a.tDZ.split((CharSequence)localObject7);
                  Arrays.sort((Object[])localObject7, new Comparator() {});
                  j = a.this.j((String)localObject1, (String[])localObject7);
                  i += j;
                }
                catch (Exception localException1)
                {
                  for (;;)
                  {
                    try
                    {
                      j = a.this.a((String)localObject1, (an)localObject5, (String[])localObject7, (byte[])localObject6, this.tHo);
                      i += j;
                    }
                    catch (Exception localException2)
                    {
                      Object localObject2;
                      continue;
                    }
                    try
                    {
                      this.tHr += 1;
                      j = i;
                      i = j;
                      if (j < 50) {
                        break;
                      }
                      a.a(a.this).commit();
                      a.a(a.this).beginTransaction();
                      i = 0;
                    }
                    catch (Exception localException3) {}
                  }
                  localException1 = localException1;
                }
                ae.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", localException1, "Build contact index failed with exception.\n", new Object[0]);
                this.tHv += 1;
                j = i;
              }
            }
          }
        }
      }
      ((Cursor)localObject4).close();
      a.a(a.this).commit();
      alt("buildChatroomContact");
      if (Thread.interrupted())
      {
        localObject2 = new InterruptedException();
        AppMethodBeat.o(52646);
        throw ((Throwable)localObject2);
      }
      this.tHt = this.tHn.size();
      localObject2 = this.tHn.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        a.a(a.this).a(com.tencent.mm.plugin.fts.a.c.tDL, (String)localObject4);
        ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.tDL, (String)localObject4);
      }
      this.tHn.clear();
      this.tHo.clear();
      alt("deleteUnusedContact");
      ((PluginFTS)g.ad(PluginFTS.class)).setFTSIndexReady(true);
      AppMethodBeat.o(52646);
      return true;
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
      a.a(a.this).z(com.tencent.mm.plugin.fts.a.c.tDJ);
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
    private String fIQ;
    private int tHA = 0;
    
    public d(String paramString)
    {
      this.fIQ = paramString;
    }
    
    public final String bhC()
    {
      AppMethodBeat.i(52650);
      String str = String.format("{username: %s mDirtyCount: %d}", new Object[] { this.fIQ, Integer.valueOf(this.tHA) });
      AppMethodBeat.o(52650);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52649);
      ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", new Object[] { this.fIQ });
      a.a(a.this).a(com.tencent.mm.plugin.fts.a.c.tDL, this.fIQ);
      ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.tDL, this.fIQ);
      Object localObject1 = a.a(a.this).alD(this.fIQ);
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
          List localList = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.tDL, (String)localObject2);
          a.b(a.this).put(localObject2, localList);
          ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().alB((String)localObject2);
          this.tHA += 1;
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
    private String fIQ;
    private boolean guk = false;
    
    public e(String paramString)
    {
      this.fIQ = paramString;
    }
    
    public final String bhC()
    {
      AppMethodBeat.i(52652);
      String str = String.format("{username: %s isSkipped: %b}", new Object[] { this.fIQ, Boolean.valueOf(this.guk) });
      AppMethodBeat.o(52652);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52651);
      ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", new Object[] { this.fIQ });
      an localan = a.d(a.this).alf(this.fIQ);
      if ((localan != null) && (localan.field_username.length() > 0) && (a.this.V(localan))) {
        a.this.W(localan);
      }
      for (;;)
      {
        a.b(a.this).remove(this.fIQ);
        a.c(a.this).remove(this.fIQ);
        AppMethodBeat.o(52651);
        return true;
        this.guk = true;
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
    private int tHB = 0;
    private int tHC = 0;
    
    private f() {}
    
    public final String bhC()
    {
      AppMethodBeat.i(52654);
      String str = String.format("{users: %d labels: %d}", new Object[] { Integer.valueOf(this.tHB), Integer.valueOf(this.tHC) });
      AppMethodBeat.o(52654);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52653);
      Cursor localCursor = a.a(a.this).tDu.rawQuery("SELECT user, label_id FROM FTS5ContactLabels;", null);
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
          this.tHB += 1;
        }
        ((List)localObject).add(Long.valueOf(l));
        this.tHC += 1;
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
    private int rLl = 0;
    private int[] tHD;
    private int tHE = 0;
    
    public g(int[] paramArrayOfInt)
    {
      this.tHD = paramArrayOfInt;
    }
    
    public final String bhC()
    {
      AppMethodBeat.i(52656);
      String str = String.format("{touched: %d users: %d}", new Object[] { Integer.valueOf(this.rLl), Integer.valueOf(this.tHE) });
      AppMethodBeat.o(52656);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52655);
      Object localObject = a.a(a.this).j(this.tHD, 1);
      this.rLl = ((List)localObject).size();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.fts.a.a.b localb = (com.tencent.mm.plugin.fts.a.a.b)localIterator.next();
        String str = localb.tEY;
        if (!a.b(a.this).containsKey(str))
        {
          List localList = (List)localHashMap.get(str);
          localObject = localList;
          if (localList == null)
          {
            localObject = new ArrayList(16);
            localHashMap.put(str, localObject);
          }
          ((List)localObject).add(Long.valueOf(localb.tEW));
        }
      }
      a.b(a.this).putAll(localHashMap);
      this.tHE = localHashMap.size();
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
    private String fIQ;
    private boolean guk = false;
    private boolean tHF = false;
    
    public h(String paramString)
    {
      this.fIQ = paramString;
    }
    
    public final String bhC()
    {
      AppMethodBeat.i(52658);
      String str = String.format("{username: %s cached: %b isSkipped: %b}", new Object[] { this.fIQ, Boolean.valueOf(this.tHF), Boolean.valueOf(this.guk) });
      AppMethodBeat.o(52658);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52657);
      ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", new Object[] { this.fIQ });
      if (a.b(a.this).containsKey(this.fIQ))
      {
        this.tHF = true;
        AppMethodBeat.o(52657);
        return true;
      }
      a.a(a.this).alj(this.fIQ);
      Object localObject1 = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.tDL, this.fIQ);
      a.b(a.this).put(this.fIQ, localObject1);
      if (((List)localObject1).isEmpty())
      {
        this.guk = true;
        a.e(a.this).a(65556, new a.e(a.this, this.fIQ));
        AppMethodBeat.o(52657);
        return true;
      }
      localObject1 = a.a(a.this).alD(this.fIQ);
      Object localObject2 = new HashSet();
      while (((Cursor)localObject1).moveToNext()) {
        ((HashSet)localObject2).add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
      localObject1 = ((HashSet)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        a.a(a.this).alj((String)localObject2);
        if (!a.b(a.this).containsKey(localObject2))
        {
          List localList = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.tDL, (String)localObject2);
          a.b(a.this).put(localObject2, localList);
        }
      }
      a.c(a.this).remove(this.fIQ);
      ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().alB(this.fIQ);
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
    private boolean tHG;
    private String username;
    
    public i(String paramString)
    {
      this.username = paramString;
    }
    
    public final String bhC()
    {
      AppMethodBeat.i(52660);
      String str = String.format("{username: %s isSkipped: %b}", new Object[] { this.username, Boolean.valueOf(this.tHG) });
      AppMethodBeat.o(52660);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52659);
      if (a.b(a.this).containsKey(this.username))
      {
        this.tHG = true;
        AppMethodBeat.o(52659);
        return true;
      }
      if (!a.c(a.this).add(this.username))
      {
        this.tHG = true;
        AppMethodBeat.o(52659);
        return true;
      }
      Object localObject = a.d(a.this).alf(this.username);
      if ((localObject != null) && (!a.this.V((an)localObject)))
      {
        this.tHG = true;
        AppMethodBeat.o(52659);
        return true;
      }
      localObject = a.a(a.this);
      String str = this.username;
      ((com.tencent.mm.plugin.fts.a.a)localObject).tDA.bindLong(1, 2L);
      ((com.tencent.mm.plugin.fts.a.a)localObject).tDA.bindString(2, str);
      ((com.tencent.mm.plugin.fts.a.a)localObject).tDA.bindLong(3, 0L);
      ((com.tencent.mm.plugin.fts.a.a)localObject).tDA.execute();
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
      paramk.tFe = com.tencent.mm.plugin.fts.a.a.h.bq(this.tFP.query, true);
      Object localObject1 = a.a(a.this).a(paramk.tFe, this.tFP.tFV, this.tFP.tFW, true, true);
      Object localObject2 = new HashMap();
      HashMap localHashMap = new HashMap();
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject1);
        if (!this.tFP.tFY.contains(localn.tEY))
        {
          com.tencent.mm.plugin.fts.a.a.m localm;
          if (d.k(com.tencent.mm.plugin.fts.a.c.tDL, localn.type))
          {
            localm = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject2).get(localn.tEY);
            if ((localm == null) || (d.f(com.tencent.mm.plugin.fts.a.c.tDW, localn.tEX, localm.tEX) < 0)) {
              ((HashMap)localObject2).put(localn.tEY, localn);
            }
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException();
            AppMethodBeat.o(52661);
            throw paramk;
            if (d.k(com.tencent.mm.plugin.fts.a.c.tDN, localn.type))
            {
              localm = (com.tencent.mm.plugin.fts.a.a.m)localHashMap.get(Long.valueOf(localn.tGf));
              if ((localm == null) || (d.f(com.tencent.mm.plugin.fts.a.c.tDW, localn.tEX, localm.tEX) < 0)) {
                localHashMap.put(Long.valueOf(localn.tGf), localn);
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
      paramk.tGc = new ArrayList(((HashMap)localObject2).size());
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cVt();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.tFe);
        paramk.tGc.add(localObject2);
      }
      paramk.tGc.addAll(localHashMap.values());
      if (Thread.interrupted())
      {
        paramk = new InterruptedException();
        AppMethodBeat.o(52661);
        throw paramk;
      }
      if (this.tFP.tFZ != null) {
        Collections.sort(paramk.tGc, this.tFP.tFZ);
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
      Object localObject2 = this.tFP.query;
      String str = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075 ORDER BY timestamp desc", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cVk() });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tDu.rawQuery(str, new String[] { localObject2 });
      paramk.tGc = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tEY = ((Cursor)localObject1).getString(0);
        paramk.tGc.add(localObject2);
      }
      ((Cursor)localObject1).close();
      paramk.bZU = 0;
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
      String str1 = this.tFP.query;
      String str2 = String.format("SELECT count(aux_index) FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject).cVk() });
      localObject = ((com.tencent.mm.plugin.fts.a.a)localObject).tDu.rawQuery(str2, new String[] { str1 });
      if (((Cursor)localObject).moveToNext()) {
        i = ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
      localObject = new com.tencent.mm.plugin.fts.a.a.m();
      ((com.tencent.mm.plugin.fts.a.a.m)localObject).userData = Integer.valueOf(i);
      paramk.tGc = new ArrayList();
      paramk.tGc.add(localObject);
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
      Object localObject2 = this.tFP.tFT;
      Object localObject3 = paramk.tFe.cVq();
      localObject3 = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN (SELECT docid, aux_index, timestamp FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=?) as temp ON (%s.rowid = temp.docid) WHERE %s MATCH '%s' ORDER BY -timestamp;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tDu.rawQuery((String)localObject3, new String[] { localObject2 });
      localObject2 = new HashSet();
      paramk.tGc = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).tEY = ((Cursor)localObject1).getString(0);
        if (((HashSet)localObject2).add(((com.tencent.mm.plugin.fts.a.a.m)localObject3).tEY)) {
          paramk.tGc.add(localObject3);
        }
      }
      ((Cursor)localObject1).close();
      paramk.bZU = 0;
      AppMethodBeat.o(52664);
    }
    
    public final String getName()
    {
      return "SearchChatroomInMemberTask";
    }
  }
  
  final class n
    extends i
  {
    public n(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52665);
      paramk.tFe = com.tencent.mm.plugin.fts.a.a.h.bq(this.tFP.query, true);
      Object localObject2 = a.a(a.this).a(paramk.tFe, new int[] { 131075 }, null, true, true);
      Object localObject1 = new HashMap();
      Object localObject4;
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject2);
        if (!this.tFP.tFY.contains(((com.tencent.mm.plugin.fts.a.a.n)localObject3).tEY))
        {
          localObject4 = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject1).get(((com.tencent.mm.plugin.fts.a.a.n)localObject3).tEY);
          if ((localObject4 == null) || (d.f(com.tencent.mm.plugin.fts.a.c.tDW, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).tEX, ((com.tencent.mm.plugin.fts.a.a.m)localObject4).tEX) < 0)) {
            ((HashMap)localObject1).put(((com.tencent.mm.plugin.fts.a.a.n)localObject3).tEY, localObject3);
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
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).cVt();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).a(paramk.tFe);
        ((ArrayList)localObject2).add(localObject4);
        if (Thread.interrupted())
        {
          paramk = new InterruptedException();
          AppMethodBeat.o(52665);
          throw paramk;
        }
      }
      if (this.tFP.tFZ != null) {
        Collections.sort((List)localObject2, this.tFP.tFZ);
      }
      paramk.tGc = new ArrayList(((HashMap)localObject1).size());
      localObject1 = new StringBuffer();
      int i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        localObject3 = (com.tencent.mm.plugin.fts.a.a.m)((ArrayList)localObject2).get(i);
        ((StringBuffer)localObject1).append(((com.tencent.mm.plugin.fts.a.a.m)localObject3).tFA);
        ((StringBuffer)localObject1).append("|");
        ((StringBuffer)localObject1).append(((com.tencent.mm.plugin.fts.a.a.m)localObject3).timestamp);
        ((StringBuffer)localObject1).append(" ");
        paramk.tGc.add(localObject3);
        if (i >= this.tFP.tFX) {
          break;
        }
        i += 1;
      }
      if ((paramk.tFe.tFG.size() > 1) && (a.a(a.this).b(paramk.tFe)))
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tEY = "create_chatroom​";
        paramk.tGc.add(0, localObject2);
        ((StringBuffer)localObject1).append(" needCreateChatroom");
      }
      ae.i("MicroMsg.FTS.FTS5SearchContactLogic", "rank score: %s", new Object[] { ((StringBuffer)localObject1).toString() });
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
  
  public final class o
    extends i
  {
    public o(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52666);
      Object localObject2 = bu.U(this.tFP.query.split(","));
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
      localObject2 = String.format("SELECT member, chatroom, entity_id FROM FTS5ChatRoomMembers, %s WHERE %s AND chatroom = aux_index", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cVk(), ((StringBuffer)localObject3).toString() });
      localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tDu.rawQuery((String)localObject2, null);
      localObject2 = new HashMap();
      if (((Cursor)localObject3).moveToNext())
      {
        String str = ((Cursor)localObject3).getString(0);
        if (((HashMap)localObject2).containsKey(str)) {}
        for (localObject1 = (List)((HashMap)localObject2).get(str);; localObject1 = new ArrayList())
        {
          com.tencent.mm.plugin.fts.a.a.m localm = new com.tencent.mm.plugin.fts.a.a.m();
          localm.tEY = ((Cursor)localObject3).getString(1);
          localm.tGf = ((Cursor)localObject3).getLong(2);
          ((List)localObject1).add(localm);
          ((HashMap)localObject2).put(str, localObject1);
          break;
        }
      }
      ((Cursor)localObject3).close();
      paramk.tGc = new ArrayList();
      localObject1 = new com.tencent.mm.plugin.fts.a.a.m();
      ((com.tencent.mm.plugin.fts.a.a.m)localObject1).userData = localObject2;
      paramk.tGc.add(localObject1);
      AppMethodBeat.o(52666);
    }
    
    public final String getName()
    {
      return "SearchCommonChatroomTask";
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
      AppMethodBeat.i(52667);
      long l = Long.valueOf(this.tFP.query).longValue();
      Object localObject1 = a.a(a.this);
      Object localObject2 = String.format("SELECT distinct(aux_index) FROM %s WHERE timestamp < %d AND type = %d", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cVk(), Long.valueOf(l), Integer.valueOf(131072) });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tDu.rawQuery((String)localObject2, null);
      paramk.tGc = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tEY = ((Cursor)localObject1).getString(0);
        paramk.tGc.add(localObject2);
      }
      ((Cursor)localObject1).close();
      AppMethodBeat.o(52667);
    }
    
    public final String getName()
    {
      return "SearchContactSmallerTimestampTask";
    }
  }
  
  final class q
    extends i
  {
    public q(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52668);
      paramk.tFe = com.tencent.mm.plugin.fts.a.a.h.bq(this.tFP.query, true);
      Object localObject2 = a.a(a.this);
      Object localObject3 = paramk.tFe;
      Object localObject1 = this.tFP.tFV;
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).cVq();
      int i;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject1 = " AND type IN " + d.A((int[])localObject1);
        long l = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).tFG.size();
        localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject1 + " AND status >= 0 ORDER BY subtype;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject2).cVk(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cVl(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.a)localObject2).cVk(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cVl(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cVk(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cVl(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cVl(), localObject4 });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).tDu.rawQuery((String)localObject1, null);
        localObject2 = new ArrayList();
        localObject3 = new HashSet();
        ((HashSet)localObject3).addAll(this.tFP.tFY);
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
          if (i >= ((com.tencent.mm.plugin.fts.a.a.n)localObject4).tEX) {
            ((List)localObject2).add(localObject4);
          }
          for (;;)
          {
            if (!Thread.interrupted()) {
              break label397;
            }
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.tFP.query);
            AppMethodBeat.o(52668);
            throw paramk;
            localObject1 = "";
            break;
            if (((List)localObject2).size() > this.tFP.tFX) {
              break label399;
            }
            i = ((com.tencent.mm.plugin.fts.a.a.n)localObject4).tEX;
            ((List)localObject2).add(localObject4);
          }
        }
      }
      label399:
      ((Cursor)localObject1).close();
      paramk.tGc = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cVt();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.tFe);
        paramk.tGc.add(localObject2);
      }
      if (this.tFP.tFZ != null) {
        Collections.sort(paramk.tGc, this.tFP.tFZ);
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
  
  final class r
    extends i
  {
    public r(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52669);
      alt("start");
      paramk.tFe = com.tencent.mm.plugin.fts.a.a.h.bq(this.tFP.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.tFe;
      Object localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).cVq();
      long l1 = System.currentTimeMillis();
      long l2 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).tFG.size();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) AS Offsets, MMChatroomRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, entity_id, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 ORDER BY Rank, timestamp desc ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), Long.valueOf(l1 - 1209600000L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tDu.rawQuery((String)localObject3, new String[] { ((com.tencent.mm.plugin.fts.a.a.h)localObject2).tFD });
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.tFP.tFY);
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().h((Cursor)localObject1);
        if (((HashSet)localObject3).add(localn.tEY)) {
          if (((List)localObject2).size() <= this.tFP.tFX)
          {
            ((List)localObject2).add(localn);
            if (Thread.interrupted())
            {
              ((Cursor)localObject1).close();
              paramk = new InterruptedException("Task is Cancel: " + this.tFP.query);
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
      alt("orm");
      paramk.tGc = new ArrayList(((List)localObject2).size());
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cVt();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.tFe);
        paramk.tGc.add(localObject2);
      }
      if (Thread.interrupted())
      {
        paramk = new InterruptedException();
        AppMethodBeat.o(52669);
        throw paramk;
      }
      if (this.tFP.tFZ != null) {
        Collections.sort(paramk.tGc, this.tFP.tFZ);
      }
      alt("calOffsets");
      if ((paramk.tFe.tFG.size() > 1) && (a.a(a.this).b(paramk.tFe)))
      {
        localObject1 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject1).tEY = "create_chatroom​";
        if (paramk.tGc.size() <= 3) {
          break label599;
        }
        paramk.tGc.add(3, localObject1);
      }
      for (;;)
      {
        alt("checkChatroom");
        AppMethodBeat.o(52669);
        return;
        label599:
        paramk.tGc.add(localObject1);
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
  
  final class s
    extends i
  {
    public s(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52670);
      paramk.tFe = com.tencent.mm.plugin.fts.a.a.h.bq(this.tFP.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.tFe;
      Object localObject3 = this.tFP.tFV;
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).cVq();
      long l1 = System.currentTimeMillis();
      long l2 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).tFG.size();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), MMContactRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type IN " + d.A((int[])localObject3) + " ORDER BY Rank ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), Long.valueOf(l1 - 1105032704L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), localObject4 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tDu.rawQuery((String)localObject3, new String[] { ((com.tencent.mm.plugin.fts.a.a.h)localObject2).tFD });
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.tFP.tFY);
      l1 = 0L;
      while (((Cursor)localObject1).moveToNext())
      {
        localObject4 = new com.tencent.mm.plugin.fts.a.a.n().h((Cursor)localObject1);
        if (((HashSet)localObject3).add(((com.tencent.mm.plugin.fts.a.a.n)localObject4).tEY))
        {
          if (l1 >= ((com.tencent.mm.plugin.fts.a.a.n)localObject4).tGn) {
            ((List)localObject2).add(localObject4);
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.tFP.query);
            AppMethodBeat.o(52670);
            throw paramk;
            if (((List)localObject2).size() > this.tFP.tFX) {
              break label407;
            }
            l1 = ((com.tencent.mm.plugin.fts.a.a.n)localObject4).tGn;
            ((List)localObject2).add(localObject4);
          }
        }
      }
      label407:
      ((Cursor)localObject1).close();
      paramk.tGc = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cVt();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.tFe);
        paramk.tGc.add(localObject2);
      }
      if (this.tFP.tFZ != null) {
        Collections.sort(paramk.tGc, this.tFP.tFZ);
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
  
  final class t
    extends i
  {
    public t(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      int i = 0;
      AppMethodBeat.i(52671);
      paramk.tFe = com.tencent.mm.plugin.fts.a.a.h.bq(this.tFP.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.tFe;
      Object localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).cVq();
      long l1 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).tFG.size();
      long l2 = System.currentTimeMillis();
      localObject2 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), Long.valueOf(l1), Long.valueOf(l2 - 1105032704L), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cVl(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tDu.rawQuery((String)localObject2, null);
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.tFP.tFY);
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject1);
        if (((HashSet)localObject3).add(localn.tEY))
        {
          if (i >= localn.tEX) {
            ((List)localObject2).add(localn);
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.tFP.query);
            AppMethodBeat.o(52671);
            throw paramk;
            if (((List)localObject2).size() > this.tFP.tFX) {
              break label345;
            }
            i = localn.tEX;
            ((List)localObject2).add(localn);
          }
        }
      }
      label345:
      ((Cursor)localObject1).close();
      paramk.tGc = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cVt();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.tFe);
        paramk.tGc.add(localObject2);
      }
      if (this.tFP.tFZ != null) {
        Collections.sort(paramk.tGc, this.tFP.tFZ);
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
  
  final class u
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int tHH = 0;
    private int tHI = 0;
    private int tHJ = 0;
    
    private u() {}
    
    public final String bhC()
    {
      AppMethodBeat.i(52673);
      String str = String.format("{Dirty: %d Timestamp: %d tophitsCount: %d}", new Object[] { Integer.valueOf(this.tHH), Integer.valueOf(this.tHI), Integer.valueOf(this.tHJ) });
      AppMethodBeat.o(52673);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52672);
      alt("start");
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
          a.a(a.this).xT(l);
          i += 1;
        }
        localObject2 = (String)((Map.Entry)localObject2).getKey();
        localObject3 = a.d(a.this).alf((String)localObject2);
        if ((localObject3 != null) && (((com.tencent.mm.g.c.aw)localObject3).field_username.length() > 0) && (a.this.V((an)localObject3))) {
          i += a.this.W((an)localObject3);
        }
        for (;;)
        {
          ((Iterator)localObject1).remove();
          a.c(a.this).remove(localObject2);
          this.tHH += 1;
          break;
          alt("dirtyContact");
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
            l = a.d(a.this).alh((String)localObject2);
            localObject3 = a.d(a.this).alf((String)localObject2);
            if ((localObject3 == null) || (((com.tencent.mm.g.c.aw)localObject3).field_username.length() <= 0) || (!a.this.V((an)localObject3))) {
              break label536;
            }
            a.a(a.this).av((String)localObject2, l);
            i += 1;
          }
          for (;;)
          {
            ((Iterator)localObject1).remove();
            this.tHI += 1;
            break;
            a.a(a.this).commit();
            alt("timestampContact");
            localObject1 = ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic();
            ((e)localObject1).tIp.clear();
            this.tHJ = ((e)localObject1).tIo.cVQ();
            alt("topHits");
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
  
  final class v
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private long tHK;
    private int tHL = 0;
    
    public v(long paramLong)
    {
      this.tHK = paramLong;
    }
    
    public final String bhC()
    {
      AppMethodBeat.i(52675);
      String str = String.format("{mLabelId: %d mContactCount: %d}", new Object[] { Long.valueOf(this.tHK), Integer.valueOf(this.tHL) });
      AppMethodBeat.o(52675);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52674);
      Object localObject1 = new ArrayList(32);
      Object localObject2 = a.a(a.this);
      long l = this.tHK;
      localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject2).tDu.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[] { Long.toString(l) });
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
          List localList = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.tDM, (String)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a
 * JD-Core Version:    0.7.0.1
 */