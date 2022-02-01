package com.tencent.mm.plugin.fts.b;

import android.content.Context;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xi;
import com.tencent.mm.g.a.xm;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
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
  private static Set<String> twt;
  private com.tencent.mm.plugin.fts.a.m grs;
  private com.tencent.mm.plugin.fts.a.j rtX;
  private com.tencent.mm.plugin.fts.c.a twf;
  private HashSet<String> twg;
  private HashMap<String, List<Long>> twh;
  private HashMap<String, String[]> twi;
  private HashMap<String, List<Long>> twj;
  private Method twk;
  private n.b twl;
  private n.b twm;
  private k.a twn;
  private k.a two;
  private com.tencent.mm.sdk.b.c twp;
  private com.tencent.mm.sdk.b.c twq;
  private av twr;
  private av tws;
  
  static
  {
    AppMethodBeat.i(52693);
    twt = new HashSet();
    String[] arrayOfString = aj.getContext().getString(2131757953).split(";");
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        twt.add(str);
        i += 1;
      }
    }
    AppMethodBeat.o(52693);
  }
  
  public a()
  {
    AppMethodBeat.i(52681);
    this.twl = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(52631);
        paramAnonymousn = (String)paramAnonymousObject;
        if (!a.akz(paramAnonymousn))
        {
          ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "onConversationChangeListener filterByUsername %s", new Object[] { paramAnonymousn });
          AppMethodBeat.o(52631);
          return;
        }
        paramAnonymousObject = ((l)g.ab(l.class)).azp().aTf(paramAnonymousn);
        if ((paramAnonymousObject != null) && ((!a.N(paramAnonymousObject)) || (paramAnonymousObject.fqg())))
        {
          ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[] { paramAnonymousn });
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
    this.twm = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(52632);
        paramAnonymousn = (String)paramAnonymousObject;
        if (!a.akz(paramAnonymousn))
        {
          ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", new Object[] { paramAnonymousn });
          AppMethodBeat.o(52632);
          return;
        }
        paramAnonymousObject = ((l)g.ab(l.class)).azp().aTf(paramAnonymousn);
        if ((paramAnonymousObject != null) && (!a.N(paramAnonymousObject)))
        {
          ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[] { paramAnonymousn });
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
    this.twn = new k.a()
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
    this.two = new k.a()
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
            long l = bt.getLong(paramAnonymousString[i], 0L);
            a.e(a.this).a(65554, new a.v(a.this, l));
            i += 1;
          }
          a.e(a.this).a(65556, new a.u(a.this, (byte)0));
        }
        AppMethodBeat.o(52634);
      }
    };
    this.twp = new com.tencent.mm.sdk.b.c() {};
    this.twq = new com.tencent.mm.sdk.b.c() {};
    this.twr = new av(g.ajF().IdO.getLooper(), new av.a()
    {
      private int twv = 0;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52637);
        PluginFTS localPluginFTS = (PluginFTS)g.ad(PluginFTS.class);
        if ((localPluginFTS.isCharging()) || (!localPluginFTS.isInBackground())) {}
        for (int i = 1; i == 0; i = 0)
        {
          i = this.twv + 1;
          this.twv = i;
          if (i >= 6) {
            break;
          }
          AppMethodBeat.o(52637);
          return true;
        }
        a.e(a.this).a(131093, new a.u(a.this, (byte)0));
        this.twv = 0;
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
    this.tws = new av(g.ajF().IdO.getLooper(), new av.a()
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
  
  static boolean N(am paramam)
  {
    AppMethodBeat.i(52684);
    if ((paramam.isHidden()) && (!"notifymessage".equals(paramam.field_username)))
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (paramam.adk())
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (paramam.field_deleteFlag != 0)
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (!com.tencent.mm.o.b.lM(paramam.field_type))
    {
      if (paramam.adj())
      {
        AppMethodBeat.o(52684);
        return false;
      }
      if (paramam.fqg())
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
    gM(paramString1, str);
    paramString2 = this.rtX.akk(str);
    if (paramString2.size() == 0)
    {
      AppMethodBeat.o(52690);
      return 0;
    }
    paramString2 = bt.m(paramString2, "​");
    this.twf.a(131072, 11, paramLong1, paramString1, paramLong2, paramString2);
    AppMethodBeat.o(52690);
    return 1;
  }
  
  private int a(am paramam, long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(52688);
    Object localObject = paramam.ePN;
    int i = j;
    if (!bt.isNullOrNil((String)localObject))
    {
      com.tencent.mm.openim.a.c localc = new com.tencent.mm.openim.a.c();
      localc.IE((String)localObject);
      localObject = new StringBuffer();
      i = 0;
      while (i < localc.iHw.size())
      {
        Iterator localIterator = ((com.tencent.mm.openim.a.c.a)localc.iHw.get(i)).iHx.iterator();
        while (localIterator.hasNext())
        {
          String str = ((c.b)localIterator.next()).IF(paramam.field_openImAppid);
          if (!bt.isNullOrNil(str))
          {
            ((StringBuffer)localObject).append(str);
            ((StringBuffer)localObject).append("‌");
          }
        }
        ((StringBuffer)localObject).append("​");
        i += 1;
      }
      i = j;
      if (!bt.isNullOrNil(((StringBuffer)localObject).toString()))
      {
        this.twf.a(131081, 51, paramam.gfj, paramam.field_username, paramLong, ((StringBuffer)localObject).toString());
        i = 1;
      }
    }
    AppMethodBeat.o(52688);
    return i;
  }
  
  public static boolean akA(String paramString)
  {
    AppMethodBeat.i(52692);
    boolean bool = bt.bI(paramString, "").contains(u.aAm());
    AppMethodBeat.o(52692);
    return bool;
  }
  
  static boolean akz(String paramString)
  {
    AppMethodBeat.i(52683);
    if (bt.isNullOrNil(paramString))
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
  
  private void gM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52689);
    Object localObject1 = com.tencent.mm.plugin.fts.a.c.a.ttp.split(paramString2);
    if (localObject1.length != 0)
    {
      paramString2 = new ArrayList(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        paramString2.add(Long.valueOf(bt.getLong(localObject1[i], 0L)));
        i += 1;
      }
    }
    for (;;)
    {
      localObject1 = (List)this.twj.get(paramString1);
      if (localObject1 == null)
      {
        this.twf.akE(paramString1);
        if ((paramString2 != null) && (!paramString2.isEmpty()))
        {
          this.twf.s(paramString1, paramString2);
          this.twj.put(paramString1, paramString2);
          AppMethodBeat.o(52689);
        }
      }
      else
      {
        if ((paramString2 == null) || (paramString2.isEmpty()))
        {
          this.twf.akE(paramString1);
          this.twj.remove(paramString1);
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
            com.tencent.mm.plugin.fts.c.a locala = this.twf;
            locala.txN.bindString(1, paramString1);
            locala.txN.bindLong(2, l);
            locala.txN.execute();
          }
        }
        localObject1 = ((HashSet)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          l = ((Long)((Iterator)localObject1).next()).longValue();
          localObject2 = this.twf;
          ((com.tencent.mm.plugin.fts.c.a)localObject2).txO.bindString(1, paramString1);
          ((com.tencent.mm.plugin.fts.c.a)localObject2).txO.bindLong(2, l);
          ((com.tencent.mm.plugin.fts.c.a)localObject2).txO.execute();
        }
        this.twj.put(paramString1, paramString2);
      }
      AppMethodBeat.o(52689);
      return;
      paramString2 = null;
    }
  }
  
  private static String zh(String paramString)
  {
    AppMethodBeat.i(52691);
    if (twt.contains(paramString))
    {
      AppMethodBeat.o(52691);
      return "";
    }
    AppMethodBeat.o(52691);
    return paramString;
  }
  
  final void M(am paramam)
  {
    AppMethodBeat.i(52682);
    try
    {
      this.twk.invoke(paramam, new Object[0]);
      AppMethodBeat.o(52682);
      return;
    }
    catch (Exception paramam)
    {
      ad.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paramam, "Failed parsing RContact LVBuffer.", new Object[0]);
      AppMethodBeat.o(52682);
    }
  }
  
  final boolean O(am paramam)
  {
    AppMethodBeat.i(52685);
    String str = paramam.field_username;
    if (!N(paramam))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if (!akz(str))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if ((am.aSU(str)) || (am.aST(str)))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if (!com.tencent.mm.o.b.lM(paramam.field_type))
    {
      if ((!paramam.adj()) && (!paramam.fqg()))
      {
        if (this.rtX.aki(str))
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
  
  final int P(am paramam)
  {
    AppMethodBeat.i(52686);
    Object localObject1;
    Object localObject3;
    if (w.vF(paramam.field_username))
    {
      localObject1 = String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", new Object[] { "chatroom" });
      localObject3 = this.rtX.i((String)localObject1, new String[] { paramam.field_username });
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
        if ((bt.isNullOrNil((String)localObject2)) || (localObject1 == null) || (!akA((String)localObject2)))
        {
          ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", new Object[] { paramam.field_username });
          i = j(paramam.field_username, null);
          if (i > 0) {
            ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paramam.field_username, Integer.valueOf(i) });
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
      Object localObject2 = com.tencent.mm.plugin.fts.a.c.a.tti.split((CharSequence)localObject2);
      Arrays.sort((Object[])localObject2, new Comparator() {});
      int i = j(paramam.field_username, (String[])localObject2);
      if (i > 0) {
        ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paramam.field_username, Integer.valueOf(i) });
      }
      localObject3 = new HashMap();
      Object localObject4 = "SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + d.H((String[])localObject2) + ";";
      localObject4 = this.rtX.i((String)localObject4, null);
      try
      {
        while (((Cursor)localObject4).moveToNext())
        {
          am localam = new am();
          localam.gfj = ((Cursor)localObject4).getLong(0);
          localam.setUsername(((Cursor)localObject4).getString(1));
          localam.sQ(((Cursor)localObject4).getString(2));
          localam.sR(((Cursor)localObject4).getString(3));
          localam.sT(((Cursor)localObject4).getString(4));
          localam.L(((Cursor)localObject4).getBlob(5));
          ((HashMap)localObject3).put(localam.field_username, localam);
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
      i = Q(paramam);
      AppMethodBeat.o(52686);
      return i;
      label506:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  final int Q(am paramam)
  {
    AppMethodBeat.i(52687);
    long l2 = paramam.gfj;
    String str2 = paramam.field_username;
    Object localObject7 = paramam.VA();
    Object localObject1 = paramam.field_nickname;
    Object localObject2 = d.bk((String)localObject1, false);
    Object localObject3 = d.bk((String)localObject1, true);
    Object localObject6 = paramam.field_conRemark;
    Object localObject4 = d.bk((String)localObject6, false);
    Object localObject5 = d.bk((String)localObject6, true);
    String str3 = paramam.ePD;
    String str1 = paramam.field_contactLabelIds;
    String str4 = paramam.ePJ;
    int i = paramam.field_verifyFlag;
    long l1 = System.currentTimeMillis();
    int j;
    if ((i & am.fqj()) != 0)
    {
      str1 = bt.m(((com.tencent.mm.api.m)g.ab(com.tencent.mm.api.m.class)).eN(str2), "​");
      i = 0;
      j = 131076;
    }
    for (;;)
    {
      localObject7 = d.gL(str2, (String)localObject7);
      if ((localObject7 != null) && (((String)localObject7).length() != 0))
      {
        this.twf.a(j, 15, l2, str2, l1, (String)localObject7);
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
            this.twf.a(j, 1, l2, str2, l1, (String)localObject6);
            if ((localObject4 != null) && (((String)localObject4).length() != 0)) {
              this.twf.a(j, 2, l2, str2, l1, (String)localObject4);
            }
            if ((localObject7 != null) && (((String)localObject7).length() != 0)) {
              this.twf.a(j, 3, l2, str2, l1, (String)localObject7);
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
                this.twf.a(j, 5, l2, str2, l1, (String)localObject5);
                if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
                  this.twf.a(j, 6, l2, str2, l1, (String)localObject3);
                }
                if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
                  this.twf.a(j, 7, l2, str2, l1, (String)localObject1);
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
                  this.twf.a(j, 4, l2, str2, l1, str3);
                  i = k + 1;
                }
              }
              k = i;
              if (j == 131072)
              {
                if (bt.isNullOrNil(str4)) {
                  break label929;
                }
                localObject1 = str4.replace(com.tencent.mm.o.a.d(paramam), "​");
                this.twf.a(j, 16, l2, str2, l1, (String)localObject1);
                k = i + 1;
              }
              for (;;)
              {
                localObject1 = zh(paramam.getProvince());
                i = k;
                if (localObject1 != null)
                {
                  i = k;
                  if (((String)localObject1).length() != 0)
                  {
                    this.twf.a(j, 18, l2, str2, l1, (String)localObject1);
                    i = k + 1;
                  }
                }
                localObject1 = paramam.getCity();
                k = i;
                if (localObject1 != null)
                {
                  k = i;
                  if (((String)localObject1).length() != 0)
                  {
                    this.twf.a(j, 17, l2, str2, l1, (String)localObject1);
                    k = i + 1;
                  }
                }
                i = k;
                if (j == 131076)
                {
                  i = k;
                  if (!bt.isNullOrNil(str1))
                  {
                    this.twf.a(j, 19, l2, str2, l1, str1);
                    i = k + 1;
                    localObject1 = d.bk(str1, false);
                    k = i;
                    if (!bt.isNullOrNil((String)localObject1))
                    {
                      this.twf.a(j, 20, l2, str2, l1, (String)localObject1);
                      k = i + 1;
                    }
                    str1 = d.bk(str1, true);
                    i = k;
                    if (!bt.isNullOrNil(str1))
                    {
                      this.twf.a(j, 21, l2, str2, l1, str1);
                      i = k + 1;
                    }
                  }
                }
                k = i;
                if (j == 131081) {
                  k = i + a(paramam, l1);
                }
                AppMethodBeat.o(52687);
                return k;
                if (am.aSQ(str2))
                {
                  i = 0;
                  str1 = "";
                  j = 131081;
                  break;
                }
                l1 = this.rtX.akj(str2);
                if ((str1 == null) || (str1.length() <= 0)) {
                  break label1043;
                }
                i = a(l2, str2, str1, l1) + 0;
                str1 = "";
                j = 131072;
                break;
                localObject1 = this.rtX.i("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[] { str2 });
                k = i;
                if (((Cursor)localObject1).moveToFirst())
                {
                  localObject2 = ((Cursor)localObject1).getString(0);
                  this.twf.a(j, 16, l2, str2, l1, (String)localObject2);
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
  
  final int a(String paramString, am paramam, String[] paramArrayOfString, byte[] paramArrayOfByte, HashMap<String, am> paramHashMap)
  {
    AppMethodBeat.i(52679);
    int j = 0;
    String str1 = paramam.field_nickname;
    paramam = paramam.field_conRemark;
    String str2 = d.bk(paramam, false);
    String str3 = d.bk(paramam, true);
    String str4 = d.bk(str1, false);
    String str5 = d.bk(str1, true);
    long l1 = 0L;
    long l3 = this.rtX.akj(paramString);
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
        paramArrayOfByte = ((com.tencent.mm.k.a.a.a)localObject).fVg.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject = (com.tencent.mm.k.a.a.b)paramArrayOfByte.next();
          if (!bt.isNullOrNil(((com.tencent.mm.k.a.a.b)localObject).fVj)) {
            localHashMap.put(((com.tencent.mm.k.a.a.b)localObject).userName, ((com.tencent.mm.k.a.a.b)localObject).fVj);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paramArrayOfByte, "parse chatroom data", new Object[0]);
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
        localObject = (am)paramHashMap.get(paramArrayOfByte);
        if (localObject != null)
        {
          String str7 = ((aw)localObject).field_conRemark;
          String str6 = ((aw)localObject).field_nickname;
          String str8 = d.bk(str7, false);
          String str9 = d.bk(str7, true);
          localStringBuffer.append(bt.bI(str7, " ")).append("‌");
          localStringBuffer.append(bt.bI(str8, " ")).append("‌");
          localStringBuffer.append(bt.bI(str9, " ")).append("‌");
          str7 = d.bk(str6, false);
          str8 = d.bk(str6, true);
          localStringBuffer.append(bt.bI(str6, " ")).append("‌");
          localStringBuffer.append(bt.bI(str7, " ")).append("‌");
          localStringBuffer.append(bt.bI(str8, " ")).append("‌");
          localStringBuffer.append(bt.bI((String)localHashMap.get(paramArrayOfByte), " ")).append("‌");
          M((am)localObject);
          localStringBuffer.append(bt.bI(((aw)localObject).ePD, " ")).append("‌");
          localStringBuffer.append(bt.bI(d.gL(paramArrayOfByte, ((am)localObject).VA()), " ")).append("‌");
          localStringBuffer.append("​");
        }
        i += 1;
      }
    }
    if (!bt.isNullOrNil(str1))
    {
      this.twf.a(131075, 5, l1, paramString, l3, str1);
      if (bt.isNullOrNil(str4)) {
        break label761;
      }
      this.twf.a(131075, 6, l1, paramString, l3, str4);
    }
    label761:
    for (int i = 2;; i = 1)
    {
      j = i;
      if (!bt.isNullOrNil(str5))
      {
        this.twf.a(131075, 7, l1, paramString, l3, str5);
        j = i + 1;
      }
      i = j;
      if (!bt.isNullOrNil(paramam))
      {
        this.twf.a(131075, 1, l1, paramString, l3, paramam);
        i = j + 1;
        j = i;
        if (!bt.isNullOrNil(str4))
        {
          this.twf.a(131075, 2, l1, paramString, l3, str2);
          j = i + 1;
        }
        i = j;
        if (!bt.isNullOrNil(str5))
        {
          this.twf.a(131075, 3, l1, paramString, l3, str3);
          i = j + 1;
        }
      }
      j = i;
      if (localStringBuffer.length() > 0)
      {
        localStringBuffer.setLength(localStringBuffer.length() - 1);
        this.twf.a(131075, 38, l1, paramString, l3, localStringBuffer.toString());
        j = i + 1;
      }
      AppMethodBeat.o(52679);
      return j;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(52676);
    switch (paramj.jQN)
    {
    default: 
      paramj = new j(paramj);
    }
    for (;;)
    {
      paramj = this.grs.a(-65536, paramj);
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
  
  public final boolean agA()
  {
    AppMethodBeat.i(52678);
    this.twp.dead();
    this.twq.dead();
    this.tws.stopTimer();
    this.twr.stopTimer();
    ((l)g.ab(l.class)).azp().b(this.twm);
    ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().remove(this.twn);
    ((l)g.ab(l.class)).azv().b(this.twl);
    k.a locala = this.two;
    if (com.tencent.mm.ay.b.iep != null) {
      com.tencent.mm.ay.b.iep.b(locala);
    }
    if (this.twh != null) {
      this.twh.clear();
    }
    if (this.twg != null) {
      this.twg.clear();
    }
    this.twf = null;
    this.grs = null;
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
    Object localObject = (String[])this.twi.get(paramString);
    this.twf.beginTransaction();
    int j;
    int i;
    if (localObject == null)
    {
      this.twf.akG(paramString);
      j = (int)this.twf.txQ.simpleQueryForLong() + 0;
      i = j;
      if (paramArrayOfString != null)
      {
        this.twf.k(paramString, paramArrayOfString);
        this.twi.put(paramString, paramArrayOfString);
        i = j + paramArrayOfString.length;
      }
    }
    for (;;)
    {
      this.twf.commit();
      AppMethodBeat.o(52680);
      return i;
      if (paramArrayOfString == null)
      {
        this.twf.akG(paramString);
        i = (int)this.twf.txQ.simpleQueryForLong() + 0;
        this.twi.remove(paramString);
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
            locala = this.twf;
            locala.txK.bindString(1, paramString);
            locala.txK.bindString(2, str);
            locala.txK.execute();
            k = i + 1;
          }
          j += 1;
        }
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          locala = this.twf;
          locala.txL.bindString(1, paramString);
          locala.txL.bindString(2, str);
          locala.txL.execute();
          i += 1;
        }
        this.twi.put(paramString, paramArrayOfString);
      }
    }
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(52677);
    if (!((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
      AppMethodBeat.o(52677);
      return false;
    }
    ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
    this.twf = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3));
    this.grs = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.rtX = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
    this.twg = new HashSet();
    this.twh = new HashMap();
    this.twi = new HashMap();
    this.twj = new HashMap();
    try
    {
      this.twk = aw.class.getDeclaredMethod("parseBuff", new Class[0]);
      this.twk.setAccessible(true);
      this.grs.a(131072, new f((byte)0));
      this.grs.a(131082, new a((byte)0));
      this.grs.a(131092, new b((byte)0));
      this.grs.a(2147483647, new c((byte)0));
      ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().add(this.twn);
      ((l)g.ab(l.class)).azp().a(this.twm);
      ((l)g.ab(l.class)).azv().a(this.twl);
      k.a locala = this.two;
      if (com.tencent.mm.ay.b.iep != null) {
        com.tencent.mm.ay.b.iep.a(locala);
      }
      this.twr.az(600000L, 600000L);
      this.twp.alive();
      this.twq.alive();
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
    private int rue = 0;
    private int ruf = 0;
    
    private a() {}
    
    public final String bgU()
    {
      AppMethodBeat.i(52643);
      String str = String.format("{new: %d removed: %d}", new Object[] { Integer.valueOf(this.rue), Integer.valueOf(this.ruf) });
      AppMethodBeat.o(52643);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52642);
      ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
      Object localObject1 = new HashSet();
      Object localObject2 = a.a(a.this).tsD.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
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
        if ((!bt.isNullOrNil((String)localObject3)) && (!bt.isNullOrNil(str)) && (a.akA((String)localObject3)))
        {
          localObject3 = com.tencent.mm.plugin.fts.a.c.a.tti.split((CharSequence)localObject3);
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
            this.rue += 1;
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
        a.a(a.this).akG((String)localObject2);
        this.ruf += 1;
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
    private int twA;
    private int twB;
    private int twC;
    private int twD;
    private int twE;
    private int twF;
    private int twG;
    private int twH;
    private HashSet<String> tww;
    private HashMap<String, am> twx;
    private long twy;
    private long twz;
    
    private b()
    {
      AppMethodBeat.i(52645);
      this.twx = new HashMap();
      this.twy = -1L;
      this.twz = -1L;
      this.twA = 0;
      this.twB = 0;
      this.twC = 0;
      this.twD = 0;
      this.twE = 0;
      AppMethodBeat.o(52645);
    }
    
    public final String bgU()
    {
      AppMethodBeat.i(52647);
      String str = String.format("{build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, failContact: %d, failChatroom}", new Object[] { Integer.valueOf(this.twH), Integer.valueOf(this.twB), Integer.valueOf(this.twA), Integer.valueOf(this.twC), Integer.valueOf(this.twF), Integer.valueOf(this.twG), Integer.valueOf(this.twD), Integer.valueOf(this.twE) });
      AppMethodBeat.o(52647);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52646);
      ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building contact index.");
      akv("start");
      Object localObject5;
      Object localObject6;
      long l;
      Object localObject3;
      if (this.tww == null)
      {
        this.tww = new HashSet();
        localObject5 = a.a(a.this).a(com.tencent.mm.plugin.fts.a.c.tsU, true, false, true, false, true);
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
            this.tww.add(localObject6);
            if (i == 2) {
              a.c(a.this).add(localObject6);
            }
          }
        }
        ((Cursor)localObject5).close();
        this.twF = a.b(a.this).size();
        this.twG = a.c(a.this).size();
        this.twH = this.tww.size();
        if (this.twH < 5) {
          this.tua |= 1L;
        }
      }
      akv("getBuildContact");
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
        a.a(a.this).dR((List)localObject1);
      }
      akv("deleteDirtyContact");
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
          l = a.d(a.this).akj((String)localObject3);
          a.a(a.this).av((String)localObject3, l);
        }
        a.c(a.this).clear();
      }
      akv("updateTimestampContact");
      if (Thread.interrupted())
      {
        localObject1 = new InterruptedException();
        AppMethodBeat.o(52646);
        throw ((Throwable)localObject1);
      }
      Object localObject1 = a.d(a.this).i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE ROWID > ? AND deleteFlag=0 ORDER BY ROWID;", new String[] { Long.toString(this.twy) });
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
        this.twy = l;
        localObject3 = new am();
        ((am)localObject3).gfj = l;
        ((am)localObject3).setUsername(((Cursor)localObject1).getString(1));
        ((am)localObject3).sQ(((Cursor)localObject1).getString(2));
        ((am)localObject3).sR(((Cursor)localObject1).getString(3));
        ((am)localObject3).sT(((Cursor)localObject1).getString(4));
        ((am)localObject3).kb(((Cursor)localObject1).getInt(5));
        ((am)localObject3).setType(((Cursor)localObject1).getInt(6));
        ((am)localObject3).L(((Cursor)localObject1).getBlob(7));
        ((am)localObject3).ta(((Cursor)localObject1).getString(8));
        ((am)localObject3).kd(0);
        this.twx.put(((aw)localObject3).field_username, localObject3);
        if ((!w.vF(((aw)localObject3).field_username)) && (a.this.O((am)localObject3)) && (!this.tww.remove(((aw)localObject3).field_username)))
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
            if (!((aw)localObject3).field_username.endsWith("@chatroom"))
            {
              i = j;
              if ((((aw)localObject3).field_verifyFlag & am.fqj()) == 0)
              {
                i = j;
                a.this.M((am)localObject3);
                i = j;
                ((am)localObject3).fqm();
              }
            }
            i = j;
            j += a.this.Q((am)localObject3);
            i = j;
            this.twB += 1;
            i = j;
          }
          catch (Exception localException4)
          {
            ad.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", localException4, "Build contact index failed with exception.\n", new Object[0]);
            this.twD += 1;
          }
        }
      }
      ((Cursor)localObject1).close();
      a.a(a.this).commit();
      akv("buildWXContact");
      if (Thread.interrupted())
      {
        localObject1 = new InterruptedException();
        AppMethodBeat.o(52646);
        throw ((Throwable)localObject1);
      }
      Object localObject4 = a.d(a.this).i("SELECT rowid, chatroomname, memberlist, roomdata FROM chatroom WHERE ROWID > ? ORDER BY ROWID;", new String[] { Long.toString(this.twz) });
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
        this.twz = ((Cursor)localObject4).getLong(0);
        localObject1 = ((Cursor)localObject4).getString(1);
        if (!this.tww.remove(localObject1))
        {
          localObject5 = (am)this.twx.get(localObject1);
          if (localObject5 == null)
          {
            this.twE += 1;
          }
          else
          {
            Object localObject7 = ((Cursor)localObject4).getString(2);
            if (!a.akA((String)localObject7))
            {
              this.twE += 1;
            }
            else
            {
              localObject6 = ((Cursor)localObject4).getBlob(3);
              for (;;)
              {
                try
                {
                  localObject7 = com.tencent.mm.plugin.fts.a.c.a.tti.split((CharSequence)localObject7);
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
                      j = a.this.a((String)localObject1, (am)localObject5, (String[])localObject7, (byte[])localObject6, this.twx);
                      i += j;
                    }
                    catch (Exception localException2)
                    {
                      Object localObject2;
                      continue;
                    }
                    try
                    {
                      this.twA += 1;
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
                ad.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", localException1, "Build contact index failed with exception.\n", new Object[0]);
                this.twE += 1;
                j = i;
              }
            }
          }
        }
      }
      ((Cursor)localObject4).close();
      a.a(a.this).commit();
      akv("buildChatroomContact");
      if (Thread.interrupted())
      {
        localObject2 = new InterruptedException();
        AppMethodBeat.o(52646);
        throw ((Throwable)localObject2);
      }
      this.twC = this.tww.size();
      localObject2 = this.tww.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        a.a(a.this).a(com.tencent.mm.plugin.fts.a.c.tsU, (String)localObject4);
        ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.tsU, (String)localObject4);
      }
      this.tww.clear();
      this.twx.clear();
      akv("deleteUnusedContact");
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
      a.a(a.this).y(com.tencent.mm.plugin.fts.a.c.tsS);
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
    private String fGM;
    private int twJ = 0;
    
    public d(String paramString)
    {
      this.fGM = paramString;
    }
    
    public final String bgU()
    {
      AppMethodBeat.i(52650);
      String str = String.format("{username: %s mDirtyCount: %d}", new Object[] { this.fGM, Integer.valueOf(this.twJ) });
      AppMethodBeat.o(52650);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52649);
      ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", new Object[] { this.fGM });
      a.a(a.this).a(com.tencent.mm.plugin.fts.a.c.tsU, this.fGM);
      ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.tsU, this.fGM);
      Object localObject1 = a.a(a.this).akF(this.fGM);
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
          List localList = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.tsU, (String)localObject2);
          a.b(a.this).put(localObject2, localList);
          ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().akD((String)localObject2);
          this.twJ += 1;
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
    private String fGM;
    private boolean grJ = false;
    
    public e(String paramString)
    {
      this.fGM = paramString;
    }
    
    public final String bgU()
    {
      AppMethodBeat.i(52652);
      String str = String.format("{username: %s isSkipped: %b}", new Object[] { this.fGM, Boolean.valueOf(this.grJ) });
      AppMethodBeat.o(52652);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52651);
      ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", new Object[] { this.fGM });
      am localam = a.d(a.this).akh(this.fGM);
      if ((localam != null) && (localam.field_username.length() > 0) && (a.this.O(localam))) {
        a.this.P(localam);
      }
      for (;;)
      {
        a.b(a.this).remove(this.fGM);
        a.c(a.this).remove(this.fGM);
        AppMethodBeat.o(52651);
        return true;
        this.grJ = true;
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
    private int twK = 0;
    private int twL = 0;
    
    private f() {}
    
    public final String bgU()
    {
      AppMethodBeat.i(52654);
      String str = String.format("{users: %d labels: %d}", new Object[] { Integer.valueOf(this.twK), Integer.valueOf(this.twL) });
      AppMethodBeat.o(52654);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52653);
      Cursor localCursor = a.a(a.this).tsD.rawQuery("SELECT user, label_id FROM FTS5ContactLabels;", null);
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
          this.twK += 1;
        }
        ((List)localObject).add(Long.valueOf(l));
        this.twL += 1;
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
    private int rDa = 0;
    private int[] twM;
    private int twN = 0;
    
    public g(int[] paramArrayOfInt)
    {
      this.twM = paramArrayOfInt;
    }
    
    public final String bgU()
    {
      AppMethodBeat.i(52656);
      String str = String.format("{touched: %d users: %d}", new Object[] { Integer.valueOf(this.rDa), Integer.valueOf(this.twN) });
      AppMethodBeat.o(52656);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52655);
      Object localObject = a.a(a.this).j(this.twM, 1);
      this.rDa = ((List)localObject).size();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.fts.a.a.b localb = (com.tencent.mm.plugin.fts.a.a.b)localIterator.next();
        String str = localb.tuh;
        if (!a.b(a.this).containsKey(str))
        {
          List localList = (List)localHashMap.get(str);
          localObject = localList;
          if (localList == null)
          {
            localObject = new ArrayList(16);
            localHashMap.put(str, localObject);
          }
          ((List)localObject).add(Long.valueOf(localb.tuf));
        }
      }
      a.b(a.this).putAll(localHashMap);
      this.twN = localHashMap.size();
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
    private String fGM;
    private boolean grJ = false;
    private boolean twO = false;
    
    public h(String paramString)
    {
      this.fGM = paramString;
    }
    
    public final String bgU()
    {
      AppMethodBeat.i(52658);
      String str = String.format("{username: %s cached: %b isSkipped: %b}", new Object[] { this.fGM, Boolean.valueOf(this.twO), Boolean.valueOf(this.grJ) });
      AppMethodBeat.o(52658);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52657);
      ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", new Object[] { this.fGM });
      if (a.b(a.this).containsKey(this.fGM))
      {
        this.twO = true;
        AppMethodBeat.o(52657);
        return true;
      }
      a.a(a.this).akl(this.fGM);
      Object localObject1 = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.tsU, this.fGM);
      a.b(a.this).put(this.fGM, localObject1);
      if (((List)localObject1).isEmpty())
      {
        this.grJ = true;
        a.e(a.this).a(65556, new a.e(a.this, this.fGM));
        AppMethodBeat.o(52657);
        return true;
      }
      localObject1 = a.a(a.this).akF(this.fGM);
      Object localObject2 = new HashSet();
      while (((Cursor)localObject1).moveToNext()) {
        ((HashSet)localObject2).add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
      localObject1 = ((HashSet)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        a.a(a.this).akl((String)localObject2);
        if (!a.b(a.this).containsKey(localObject2))
        {
          List localList = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.tsU, (String)localObject2);
          a.b(a.this).put(localObject2, localList);
        }
      }
      a.c(a.this).remove(this.fGM);
      ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().akD(this.fGM);
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
    private boolean twP;
    private String username;
    
    public i(String paramString)
    {
      this.username = paramString;
    }
    
    public final String bgU()
    {
      AppMethodBeat.i(52660);
      String str = String.format("{username: %s isSkipped: %b}", new Object[] { this.username, Boolean.valueOf(this.twP) });
      AppMethodBeat.o(52660);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52659);
      if (a.b(a.this).containsKey(this.username))
      {
        this.twP = true;
        AppMethodBeat.o(52659);
        return true;
      }
      if (!a.c(a.this).add(this.username))
      {
        this.twP = true;
        AppMethodBeat.o(52659);
        return true;
      }
      Object localObject = a.d(a.this).akh(this.username);
      if ((localObject != null) && (!a.this.O((am)localObject)))
      {
        this.twP = true;
        AppMethodBeat.o(52659);
        return true;
      }
      localObject = a.a(a.this);
      String str = this.username;
      ((com.tencent.mm.plugin.fts.a.a)localObject).tsJ.bindLong(1, 2L);
      ((com.tencent.mm.plugin.fts.a.a)localObject).tsJ.bindString(2, str);
      ((com.tencent.mm.plugin.fts.a.a)localObject).tsJ.bindLong(3, 0L);
      ((com.tencent.mm.plugin.fts.a.a)localObject).tsJ.execute();
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
      paramk.tun = com.tencent.mm.plugin.fts.a.a.h.bn(this.tuY.query, true);
      Object localObject1 = a.a(a.this).a(paramk.tun, this.tuY.tve, this.tuY.tvf, true, true);
      Object localObject2 = new HashMap();
      HashMap localHashMap = new HashMap();
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject1);
        if (!this.tuY.tvh.contains(localn.tuh))
        {
          com.tencent.mm.plugin.fts.a.a.m localm;
          if (d.k(com.tencent.mm.plugin.fts.a.c.tsU, localn.type))
          {
            localm = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject2).get(localn.tuh);
            if ((localm == null) || (d.f(com.tencent.mm.plugin.fts.a.c.ttf, localn.tug, localm.tug) < 0)) {
              ((HashMap)localObject2).put(localn.tuh, localn);
            }
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException();
            AppMethodBeat.o(52661);
            throw paramk;
            if (d.k(com.tencent.mm.plugin.fts.a.c.tsW, localn.type))
            {
              localm = (com.tencent.mm.plugin.fts.a.a.m)localHashMap.get(Long.valueOf(localn.tvo));
              if ((localm == null) || (d.f(com.tencent.mm.plugin.fts.a.c.ttf, localn.tug, localm.tug) < 0)) {
                localHashMap.put(Long.valueOf(localn.tvo), localn);
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
      paramk.tvl = new ArrayList(((HashMap)localObject2).size());
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cSO();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.tun);
        paramk.tvl.add(localObject2);
      }
      paramk.tvl.addAll(localHashMap.values());
      if (Thread.interrupted())
      {
        paramk = new InterruptedException();
        AppMethodBeat.o(52661);
        throw paramk;
      }
      if (this.tuY.tvi != null) {
        Collections.sort(paramk.tvl, this.tuY.tvi);
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
      Object localObject2 = this.tuY.query;
      String str = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075 ORDER BY timestamp desc", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cSF() });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tsD.rawQuery(str, new String[] { localObject2 });
      paramk.tvl = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tuh = ((Cursor)localObject1).getString(0);
        paramk.tvl.add(localObject2);
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
      String str1 = this.tuY.query;
      String str2 = String.format("SELECT count(aux_index) FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject).cSF() });
      localObject = ((com.tencent.mm.plugin.fts.a.a)localObject).tsD.rawQuery(str2, new String[] { str1 });
      if (((Cursor)localObject).moveToNext()) {
        i = ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
      localObject = new com.tencent.mm.plugin.fts.a.a.m();
      ((com.tencent.mm.plugin.fts.a.a.m)localObject).userData = Integer.valueOf(i);
      paramk.tvl = new ArrayList();
      paramk.tvl.add(localObject);
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
      Object localObject2 = this.tuY.tvc;
      Object localObject3 = paramk.tun.cSL();
      localObject3 = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN (SELECT docid, aux_index, timestamp FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=?) as temp ON (%s.rowid = temp.docid) WHERE %s MATCH '%s' ORDER BY -timestamp;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tsD.rawQuery((String)localObject3, new String[] { localObject2 });
      localObject2 = new HashSet();
      paramk.tvl = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).tuh = ((Cursor)localObject1).getString(0);
        if (((HashSet)localObject2).add(((com.tencent.mm.plugin.fts.a.a.m)localObject3).tuh)) {
          paramk.tvl.add(localObject3);
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
      paramk.tun = com.tencent.mm.plugin.fts.a.a.h.bn(this.tuY.query, true);
      Object localObject2 = a.a(a.this).a(paramk.tun, new int[] { 131075 }, null, true, true);
      Object localObject1 = new HashMap();
      Object localObject4;
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject2);
        if (!this.tuY.tvh.contains(((com.tencent.mm.plugin.fts.a.a.n)localObject3).tuh))
        {
          localObject4 = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject1).get(((com.tencent.mm.plugin.fts.a.a.n)localObject3).tuh);
          if ((localObject4 == null) || (d.f(com.tencent.mm.plugin.fts.a.c.ttf, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).tug, ((com.tencent.mm.plugin.fts.a.a.m)localObject4).tug) < 0)) {
            ((HashMap)localObject1).put(((com.tencent.mm.plugin.fts.a.a.n)localObject3).tuh, localObject3);
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
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).cSO();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).a(paramk.tun);
        ((ArrayList)localObject2).add(localObject4);
        if (Thread.interrupted())
        {
          paramk = new InterruptedException();
          AppMethodBeat.o(52665);
          throw paramk;
        }
      }
      if (this.tuY.tvi != null) {
        Collections.sort((List)localObject2, this.tuY.tvi);
      }
      paramk.tvl = new ArrayList(((HashMap)localObject1).size());
      localObject1 = new StringBuffer();
      int i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        localObject3 = (com.tencent.mm.plugin.fts.a.a.m)((ArrayList)localObject2).get(i);
        ((StringBuffer)localObject1).append(((com.tencent.mm.plugin.fts.a.a.m)localObject3).tuJ);
        ((StringBuffer)localObject1).append("|");
        ((StringBuffer)localObject1).append(((com.tencent.mm.plugin.fts.a.a.m)localObject3).timestamp);
        ((StringBuffer)localObject1).append(" ");
        paramk.tvl.add(localObject3);
        if (i >= this.tuY.tvg) {
          break;
        }
        i += 1;
      }
      if ((paramk.tun.tuP.size() > 1) && (a.a(a.this).b(paramk.tun)))
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tuh = "create_chatroom​";
        paramk.tvl.add(0, localObject2);
        ((StringBuffer)localObject1).append(" needCreateChatroom");
      }
      ad.i("MicroMsg.FTS.FTS5SearchContactLogic", "rank score: %s", new Object[] { ((StringBuffer)localObject1).toString() });
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
      Object localObject2 = bt.U(this.tuY.query.split(","));
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
      localObject2 = String.format("SELECT member, chatroom, entity_id FROM FTS5ChatRoomMembers, %s WHERE %s AND chatroom = aux_index", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cSF(), ((StringBuffer)localObject3).toString() });
      localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tsD.rawQuery((String)localObject2, null);
      localObject2 = new HashMap();
      if (((Cursor)localObject3).moveToNext())
      {
        String str = ((Cursor)localObject3).getString(0);
        if (((HashMap)localObject2).containsKey(str)) {}
        for (localObject1 = (List)((HashMap)localObject2).get(str);; localObject1 = new ArrayList())
        {
          com.tencent.mm.plugin.fts.a.a.m localm = new com.tencent.mm.plugin.fts.a.a.m();
          localm.tuh = ((Cursor)localObject3).getString(1);
          localm.tvo = ((Cursor)localObject3).getLong(2);
          ((List)localObject1).add(localm);
          ((HashMap)localObject2).put(str, localObject1);
          break;
        }
      }
      ((Cursor)localObject3).close();
      paramk.tvl = new ArrayList();
      localObject1 = new com.tencent.mm.plugin.fts.a.a.m();
      ((com.tencent.mm.plugin.fts.a.a.m)localObject1).userData = localObject2;
      paramk.tvl.add(localObject1);
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
      long l = Long.valueOf(this.tuY.query).longValue();
      Object localObject1 = a.a(a.this);
      Object localObject2 = String.format("SELECT distinct(aux_index) FROM %s WHERE timestamp < %d AND type = %d", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cSF(), Long.valueOf(l), Integer.valueOf(131072) });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tsD.rawQuery((String)localObject2, null);
      paramk.tvl = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tuh = ((Cursor)localObject1).getString(0);
        paramk.tvl.add(localObject2);
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
      paramk.tun = com.tencent.mm.plugin.fts.a.a.h.bn(this.tuY.query, true);
      Object localObject2 = a.a(a.this);
      Object localObject3 = paramk.tun;
      Object localObject1 = this.tuY.tve;
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).cSL();
      int i;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject1 = " AND type IN " + d.z((int[])localObject1);
        long l = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).tuP.size();
        localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject1 + " AND status >= 0 ORDER BY subtype;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject2).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cSG(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.a)localObject2).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cSG(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cSG(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cSG(), localObject4 });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).tsD.rawQuery((String)localObject1, null);
        localObject2 = new ArrayList();
        localObject3 = new HashSet();
        ((HashSet)localObject3).addAll(this.tuY.tvh);
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
          if (i >= ((com.tencent.mm.plugin.fts.a.a.n)localObject4).tug) {
            ((List)localObject2).add(localObject4);
          }
          for (;;)
          {
            if (!Thread.interrupted()) {
              break label397;
            }
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.tuY.query);
            AppMethodBeat.o(52668);
            throw paramk;
            localObject1 = "";
            break;
            if (((List)localObject2).size() > this.tuY.tvg) {
              break label399;
            }
            i = ((com.tencent.mm.plugin.fts.a.a.n)localObject4).tug;
            ((List)localObject2).add(localObject4);
          }
        }
      }
      label399:
      ((Cursor)localObject1).close();
      paramk.tvl = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cSO();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.tun);
        paramk.tvl.add(localObject2);
      }
      if (this.tuY.tvi != null) {
        Collections.sort(paramk.tvl, this.tuY.tvi);
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
      akv("start");
      paramk.tun = com.tencent.mm.plugin.fts.a.a.h.bn(this.tuY.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.tun;
      Object localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).cSL();
      long l1 = System.currentTimeMillis();
      long l2 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).tuP.size();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) AS Offsets, MMChatroomRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, entity_id, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 ORDER BY Rank, timestamp desc ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), Long.valueOf(l1 - 1209600000L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tsD.rawQuery((String)localObject3, new String[] { ((com.tencent.mm.plugin.fts.a.a.h)localObject2).tuM });
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.tuY.tvh);
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().h((Cursor)localObject1);
        if (((HashSet)localObject3).add(localn.tuh)) {
          if (((List)localObject2).size() <= this.tuY.tvg)
          {
            ((List)localObject2).add(localn);
            if (Thread.interrupted())
            {
              ((Cursor)localObject1).close();
              paramk = new InterruptedException("Task is Cancel: " + this.tuY.query);
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
      akv("orm");
      paramk.tvl = new ArrayList(((List)localObject2).size());
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cSO();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.tun);
        paramk.tvl.add(localObject2);
      }
      if (Thread.interrupted())
      {
        paramk = new InterruptedException();
        AppMethodBeat.o(52669);
        throw paramk;
      }
      if (this.tuY.tvi != null) {
        Collections.sort(paramk.tvl, this.tuY.tvi);
      }
      akv("calOffsets");
      if ((paramk.tun.tuP.size() > 1) && (a.a(a.this).b(paramk.tun)))
      {
        localObject1 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject1).tuh = "create_chatroom​";
        if (paramk.tvl.size() <= 3) {
          break label599;
        }
        paramk.tvl.add(3, localObject1);
      }
      for (;;)
      {
        akv("checkChatroom");
        AppMethodBeat.o(52669);
        return;
        label599:
        paramk.tvl.add(localObject1);
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
      paramk.tun = com.tencent.mm.plugin.fts.a.a.h.bn(this.tuY.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.tun;
      Object localObject3 = this.tuY.tve;
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).cSL();
      long l1 = System.currentTimeMillis();
      long l2 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).tuP.size();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), MMContactRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type IN " + d.z((int[])localObject3) + " ORDER BY Rank ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), Long.valueOf(l1 - 1105032704L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), localObject4 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tsD.rawQuery((String)localObject3, new String[] { ((com.tencent.mm.plugin.fts.a.a.h)localObject2).tuM });
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.tuY.tvh);
      l1 = 0L;
      while (((Cursor)localObject1).moveToNext())
      {
        localObject4 = new com.tencent.mm.plugin.fts.a.a.n().h((Cursor)localObject1);
        if (((HashSet)localObject3).add(((com.tencent.mm.plugin.fts.a.a.n)localObject4).tuh))
        {
          if (l1 >= ((com.tencent.mm.plugin.fts.a.a.n)localObject4).tvw) {
            ((List)localObject2).add(localObject4);
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.tuY.query);
            AppMethodBeat.o(52670);
            throw paramk;
            if (((List)localObject2).size() > this.tuY.tvg) {
              break label407;
            }
            l1 = ((com.tencent.mm.plugin.fts.a.a.n)localObject4).tvw;
            ((List)localObject2).add(localObject4);
          }
        }
      }
      label407:
      ((Cursor)localObject1).close();
      paramk.tvl = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cSO();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.tun);
        paramk.tvl.add(localObject2);
      }
      if (this.tuY.tvi != null) {
        Collections.sort(paramk.tvl, this.tuY.tvi);
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
      paramk.tun = com.tencent.mm.plugin.fts.a.a.h.bn(this.tuY.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.tun;
      Object localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).cSL();
      long l1 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).tuP.size();
      long l2 = System.currentTimeMillis();
      localObject2 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), Long.valueOf(l1), Long.valueOf(l2 - 1105032704L), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cSG(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tsD.rawQuery((String)localObject2, null);
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.tuY.tvh);
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject1);
        if (((HashSet)localObject3).add(localn.tuh))
        {
          if (i >= localn.tug) {
            ((List)localObject2).add(localn);
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.tuY.query);
            AppMethodBeat.o(52671);
            throw paramk;
            if (((List)localObject2).size() > this.tuY.tvg) {
              break label345;
            }
            i = localn.tug;
            ((List)localObject2).add(localn);
          }
        }
      }
      label345:
      ((Cursor)localObject1).close();
      paramk.tvl = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cSO();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.tun);
        paramk.tvl.add(localObject2);
      }
      if (this.tuY.tvi != null) {
        Collections.sort(paramk.tvl, this.tuY.tvi);
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
    private int twQ = 0;
    private int twR = 0;
    private int twS = 0;
    
    private u() {}
    
    public final String bgU()
    {
      AppMethodBeat.i(52673);
      String str = String.format("{Dirty: %d Timestamp: %d tophitsCount: %d}", new Object[] { Integer.valueOf(this.twQ), Integer.valueOf(this.twR), Integer.valueOf(this.twS) });
      AppMethodBeat.o(52673);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52672);
      akv("start");
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
          a.a(a.this).xz(l);
          i += 1;
        }
        localObject2 = (String)((Map.Entry)localObject2).getKey();
        localObject3 = a.d(a.this).akh((String)localObject2);
        if ((localObject3 != null) && (((aw)localObject3).field_username.length() > 0) && (a.this.O((am)localObject3))) {
          i += a.this.P((am)localObject3);
        }
        for (;;)
        {
          ((Iterator)localObject1).remove();
          a.c(a.this).remove(localObject2);
          this.twQ += 1;
          break;
          akv("dirtyContact");
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
            l = a.d(a.this).akj((String)localObject2);
            localObject3 = a.d(a.this).akh((String)localObject2);
            if ((localObject3 == null) || (((aw)localObject3).field_username.length() <= 0) || (!a.this.O((am)localObject3))) {
              break label536;
            }
            a.a(a.this).av((String)localObject2, l);
            i += 1;
          }
          for (;;)
          {
            ((Iterator)localObject1).remove();
            this.twR += 1;
            break;
            a.a(a.this).commit();
            akv("timestampContact");
            localObject1 = ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic();
            ((e)localObject1).txy.clear();
            this.twS = ((e)localObject1).txx.cTl();
            akv("topHits");
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
    private long twT;
    private int twU = 0;
    
    public v(long paramLong)
    {
      this.twT = paramLong;
    }
    
    public final String bgU()
    {
      AppMethodBeat.i(52675);
      String str = String.format("{mLabelId: %d mContactCount: %d}", new Object[] { Long.valueOf(this.twT), Integer.valueOf(this.twU) });
      AppMethodBeat.o(52675);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52674);
      Object localObject1 = new ArrayList(32);
      Object localObject2 = a.a(a.this);
      long l = this.twT;
      localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject2).tsD.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[] { Long.toString(l) });
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
          List localList = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.tsV, (String)localObject2);
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