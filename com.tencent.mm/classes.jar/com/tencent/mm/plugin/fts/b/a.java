package com.tencent.mm.plugin.fts.b;

import android.content.Context;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.g.a.wt;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
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
  private static Set<String> szS;
  private com.tencent.mm.plugin.fts.a.m fXX;
  private com.tencent.mm.plugin.fts.a.j qJV;
  private com.tencent.mm.plugin.fts.c.a szE;
  private HashSet<String> szF;
  private HashMap<String, List<Long>> szG;
  private HashMap<String, String[]> szH;
  private HashMap<String, List<Long>> szI;
  private Method szJ;
  private n.b szK;
  private n.b szL;
  private k.a szM;
  private k.a szN;
  private com.tencent.mm.sdk.b.c szO;
  private com.tencent.mm.sdk.b.c szP;
  private au szQ;
  private au szR;
  
  static
  {
    AppMethodBeat.i(52693);
    szS = new HashSet();
    String[] arrayOfString = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131757953).split(";");
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        szS.add(str);
        i += 1;
      }
    }
    AppMethodBeat.o(52693);
  }
  
  public a()
  {
    AppMethodBeat.i(52681);
    this.szK = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(52631);
        paramAnonymousn = (String)paramAnonymousObject;
        if (!a.agb(paramAnonymousn))
        {
          ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "onConversationChangeListener filterByUsername %s", new Object[] { paramAnonymousn });
          AppMethodBeat.o(52631);
          return;
        }
        paramAnonymousObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNn(paramAnonymousn);
        if ((paramAnonymousObject != null) && ((!a.N(paramAnonymousObject)) || (paramAnonymousObject.fad())))
        {
          ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[] { paramAnonymousn });
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
    this.szL = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(52632);
        paramAnonymousn = (String)paramAnonymousObject;
        if (!a.agb(paramAnonymousn))
        {
          ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", new Object[] { paramAnonymousn });
          AppMethodBeat.o(52632);
          return;
        }
        paramAnonymousObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNn(paramAnonymousn);
        if ((paramAnonymousObject != null) && (!a.N(paramAnonymousObject)))
        {
          ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[] { paramAnonymousn });
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
    this.szM = new k.a()
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
    this.szN = new k.a()
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
            long l = bs.getLong(paramAnonymousString[i], 0L);
            a.e(a.this).a(65554, new a.v(a.this, l));
            i += 1;
          }
          a.e(a.this).a(65556, new a.u(a.this, (byte)0));
        }
        AppMethodBeat.o(52634);
      }
    };
    this.szO = new com.tencent.mm.sdk.b.c() {};
    this.szP = new com.tencent.mm.sdk.b.c() {};
    this.szQ = new au(g.agU().GrZ.getLooper(), new au.a()
    {
      private int szU = 0;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52637);
        PluginFTS localPluginFTS = (PluginFTS)g.ad(PluginFTS.class);
        if ((localPluginFTS.isCharging()) || (!localPluginFTS.isInBackground())) {}
        for (int i = 1; i == 0; i = 0)
        {
          i = this.szU + 1;
          this.szU = i;
          if (i >= 6) {
            break;
          }
          AppMethodBeat.o(52637);
          return true;
        }
        a.e(a.this).a(131093, new a.u(a.this, (byte)0));
        this.szU = 0;
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
    this.szR = new au(g.agU().GrZ.getLooper(), new au.a()
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
  
  static boolean N(com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(52684);
    if ((paramai.isHidden()) && (!"notifymessage".equals(paramai.field_username)))
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (paramai.aaH())
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (paramai.field_deleteFlag != 0)
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (!com.tencent.mm.n.b.ln(paramai.field_type))
    {
      if (paramai.aaG())
      {
        AppMethodBeat.o(52684);
        return false;
      }
      if (paramai.fad())
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
    gB(paramString1, str);
    paramString2 = this.qJV.afM(str);
    if (paramString2.size() == 0)
    {
      AppMethodBeat.o(52690);
      return 0;
    }
    paramString2 = bs.n(paramString2, "​");
    this.szE.a(131072, 11, paramLong1, paramString1, paramLong2, paramString2);
    AppMethodBeat.o(52690);
    return 1;
  }
  
  private int a(com.tencent.mm.storage.ai paramai, long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(52688);
    Object localObject = paramai.eyp;
    int i = j;
    if (!bs.isNullOrNil((String)localObject))
    {
      com.tencent.mm.openim.a.c localc = new com.tencent.mm.openim.a.c();
      localc.Fo((String)localObject);
      localObject = new StringBuffer();
      i = 0;
      while (i < localc.inZ.size())
      {
        Iterator localIterator = ((com.tencent.mm.openim.a.c.a)localc.inZ.get(i)).ioa.iterator();
        while (localIterator.hasNext())
        {
          String str = ((c.b)localIterator.next()).Fp(paramai.field_openImAppid);
          if (!bs.isNullOrNil(str))
          {
            ((StringBuffer)localObject).append(str);
            ((StringBuffer)localObject).append("‌");
          }
        }
        ((StringBuffer)localObject).append("​");
        i += 1;
      }
      i = j;
      if (!bs.isNullOrNil(((StringBuffer)localObject).toString()))
      {
        this.szE.a(131081, 51, paramai.fLJ, paramai.field_username, paramLong, ((StringBuffer)localObject).toString());
        i = 1;
      }
    }
    AppMethodBeat.o(52688);
    return i;
  }
  
  static boolean agb(String paramString)
  {
    AppMethodBeat.i(52683);
    if (bs.isNullOrNil(paramString))
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
    AppMethodBeat.o(52683);
    return true;
  }
  
  public static boolean agc(String paramString)
  {
    AppMethodBeat.i(52692);
    boolean bool = bs.bG(paramString, "").contains(u.axw());
    AppMethodBeat.o(52692);
    return bool;
  }
  
  private void gB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52689);
    Object localObject1 = com.tencent.mm.plugin.fts.a.c.a.swO.split(paramString2);
    if (localObject1.length != 0)
    {
      paramString2 = new ArrayList(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        paramString2.add(Long.valueOf(bs.getLong(localObject1[i], 0L)));
        i += 1;
      }
    }
    for (;;)
    {
      localObject1 = (List)this.szI.get(paramString1);
      if (localObject1 == null)
      {
        this.szE.agg(paramString1);
        if ((paramString2 != null) && (!paramString2.isEmpty()))
        {
          this.szE.q(paramString1, paramString2);
          this.szI.put(paramString1, paramString2);
          AppMethodBeat.o(52689);
        }
      }
      else
      {
        if ((paramString2 == null) || (paramString2.isEmpty()))
        {
          this.szE.agg(paramString1);
          this.szI.remove(paramString1);
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
            com.tencent.mm.plugin.fts.c.a locala = this.szE;
            locala.sBm.bindString(1, paramString1);
            locala.sBm.bindLong(2, l);
            locala.sBm.execute();
          }
        }
        localObject1 = ((HashSet)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          l = ((Long)((Iterator)localObject1).next()).longValue();
          localObject2 = this.szE;
          ((com.tencent.mm.plugin.fts.c.a)localObject2).sBn.bindString(1, paramString1);
          ((com.tencent.mm.plugin.fts.c.a)localObject2).sBn.bindLong(2, l);
          ((com.tencent.mm.plugin.fts.c.a)localObject2).sBn.execute();
        }
        this.szI.put(paramString1, paramString2);
      }
      AppMethodBeat.o(52689);
      return;
      paramString2 = null;
    }
  }
  
  private static String wm(String paramString)
  {
    AppMethodBeat.i(52691);
    if (szS.contains(paramString))
    {
      AppMethodBeat.o(52691);
      return "";
    }
    AppMethodBeat.o(52691);
    return paramString;
  }
  
  final void M(com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(52682);
    try
    {
      this.szJ.invoke(paramai, new Object[0]);
      AppMethodBeat.o(52682);
      return;
    }
    catch (Exception paramai)
    {
      ac.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paramai, "Failed parsing RContact LVBuffer.", new Object[0]);
      AppMethodBeat.o(52682);
    }
  }
  
  final boolean O(com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(52685);
    String str = paramai.field_username;
    if (!N(paramai))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if (!agb(str))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if (!com.tencent.mm.n.b.ln(paramai.field_type))
    {
      if ((!paramai.aaG()) && (!paramai.fad()))
      {
        if (this.qJV.afK(str))
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
  
  final int P(com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(52686);
    Object localObject1;
    Object localObject3;
    if (w.sQ(paramai.field_username))
    {
      localObject1 = String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", new Object[] { "chatroom" });
      localObject3 = this.qJV.i((String)localObject1, new String[] { paramai.field_username });
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
        if ((bs.isNullOrNil((String)localObject2)) || (localObject1 == null) || (!agc((String)localObject2)))
        {
          ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", new Object[] { paramai.field_username });
          i = j(paramai.field_username, null);
          if (i > 0) {
            ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paramai.field_username, Integer.valueOf(i) });
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
      Object localObject2 = com.tencent.mm.plugin.fts.a.c.a.swH.split((CharSequence)localObject2);
      Arrays.sort((Object[])localObject2, new Comparator() {});
      int i = j(paramai.field_username, (String[])localObject2);
      if (i > 0) {
        ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paramai.field_username, Integer.valueOf(i) });
      }
      localObject3 = new HashMap();
      Object localObject4 = "SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + d.G((String[])localObject2) + ";";
      localObject4 = this.qJV.i((String)localObject4, null);
      try
      {
        while (((Cursor)localObject4).moveToNext())
        {
          com.tencent.mm.storage.ai localai = new com.tencent.mm.storage.ai();
          localai.fLJ = ((Cursor)localObject4).getLong(0);
          localai.setUsername(((Cursor)localObject4).getString(1));
          localai.qg(((Cursor)localObject4).getString(2));
          localai.qh(((Cursor)localObject4).getString(3));
          localai.qj(((Cursor)localObject4).getString(4));
          localai.M(((Cursor)localObject4).getBlob(5));
          ((HashMap)localObject3).put(localai.field_username, localai);
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
      i = Q(paramai);
      AppMethodBeat.o(52686);
      return i;
      label506:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  final int Q(com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(52687);
    long l2 = paramai.fLJ;
    String str2 = paramai.field_username;
    Object localObject7 = paramai.Tl();
    Object localObject1 = paramai.field_nickname;
    Object localObject2 = d.bf((String)localObject1, false);
    Object localObject3 = d.bf((String)localObject1, true);
    Object localObject6 = paramai.field_conRemark;
    Object localObject4 = d.bf((String)localObject6, false);
    Object localObject5 = d.bf((String)localObject6, true);
    String str3 = paramai.eyf;
    String str1 = paramai.field_contactLabelIds;
    String str4 = paramai.eyl;
    int i = paramai.field_verifyFlag;
    long l1 = System.currentTimeMillis();
    int j;
    if ((i & com.tencent.mm.storage.ai.fag()) != 0)
    {
      str1 = bs.n(((com.tencent.mm.api.m)g.ab(com.tencent.mm.api.m.class)).dS(str2), "​");
      i = 0;
      j = 131076;
    }
    for (;;)
    {
      localObject7 = d.gA(str2, (String)localObject7);
      if ((localObject7 != null) && (((String)localObject7).length() != 0))
      {
        this.szE.a(j, 15, l2, str2, l1, (String)localObject7);
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
            this.szE.a(j, 1, l2, str2, l1, (String)localObject6);
            if ((localObject4 != null) && (((String)localObject4).length() != 0)) {
              this.szE.a(j, 2, l2, str2, l1, (String)localObject4);
            }
            if ((localObject7 != null) && (((String)localObject7).length() != 0)) {
              this.szE.a(j, 3, l2, str2, l1, (String)localObject7);
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
                this.szE.a(j, 5, l2, str2, l1, (String)localObject5);
                if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
                  this.szE.a(j, 6, l2, str2, l1, (String)localObject3);
                }
                if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
                  this.szE.a(j, 7, l2, str2, l1, (String)localObject1);
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
                  this.szE.a(j, 4, l2, str2, l1, str3);
                  i = k + 1;
                }
              }
              k = i;
              if (j == 131072)
              {
                if (bs.isNullOrNil(str4)) {
                  break label929;
                }
                localObject1 = str4.replace(com.tencent.mm.n.a.d(paramai), "​");
                this.szE.a(j, 16, l2, str2, l1, (String)localObject1);
                k = i + 1;
              }
              for (;;)
              {
                localObject1 = wm(paramai.getProvince());
                i = k;
                if (localObject1 != null)
                {
                  i = k;
                  if (((String)localObject1).length() != 0)
                  {
                    this.szE.a(j, 18, l2, str2, l1, (String)localObject1);
                    i = k + 1;
                  }
                }
                localObject1 = paramai.getCity();
                k = i;
                if (localObject1 != null)
                {
                  k = i;
                  if (((String)localObject1).length() != 0)
                  {
                    this.szE.a(j, 17, l2, str2, l1, (String)localObject1);
                    k = i + 1;
                  }
                }
                i = k;
                if (j == 131076)
                {
                  i = k;
                  if (!bs.isNullOrNil(str1))
                  {
                    this.szE.a(j, 19, l2, str2, l1, str1);
                    i = k + 1;
                    localObject1 = d.bf(str1, false);
                    k = i;
                    if (!bs.isNullOrNil((String)localObject1))
                    {
                      this.szE.a(j, 20, l2, str2, l1, (String)localObject1);
                      k = i + 1;
                    }
                    str1 = d.bf(str1, true);
                    i = k;
                    if (!bs.isNullOrNil(str1))
                    {
                      this.szE.a(j, 21, l2, str2, l1, str1);
                      i = k + 1;
                    }
                  }
                }
                k = i;
                if (j == 131081) {
                  k = i + a(paramai, l1);
                }
                AppMethodBeat.o(52687);
                return k;
                if (com.tencent.mm.storage.ai.aNc(str2))
                {
                  i = 0;
                  str1 = "";
                  j = 131081;
                  break;
                }
                l1 = this.qJV.afL(str2);
                if ((str1 == null) || (str1.length() <= 0)) {
                  break label1043;
                }
                i = a(l2, str2, str1, l1) + 0;
                str1 = "";
                j = 131072;
                break;
                localObject1 = this.qJV.i("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[] { str2 });
                k = i;
                if (((Cursor)localObject1).moveToFirst())
                {
                  localObject2 = ((Cursor)localObject1).getString(0);
                  this.szE.a(j, 16, l2, str2, l1, (String)localObject2);
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
  
  final int a(String paramString, com.tencent.mm.storage.ai paramai, String[] paramArrayOfString, byte[] paramArrayOfByte, HashMap<String, com.tencent.mm.storage.ai> paramHashMap)
  {
    AppMethodBeat.i(52679);
    int j = 0;
    String str1 = paramai.field_nickname;
    paramai = paramai.field_conRemark;
    String str2 = d.bf(paramai, false);
    String str3 = d.bf(paramai, true);
    String str4 = d.bf(str1, false);
    String str5 = d.bf(str1, true);
    long l1 = 0L;
    long l3 = this.qJV.afL(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayOfString != null)
    {
      long l2 = paramArrayOfString.length;
      HashMap localHashMap = new HashMap();
      Object localObject = new com.tencent.mm.j.a.a.a();
      int k;
      try
      {
        ((com.tencent.mm.j.a.a.a)localObject).parseFrom(paramArrayOfByte);
        paramArrayOfByte = ((com.tencent.mm.j.a.a.a)localObject).fBS.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject = (com.tencent.mm.j.a.a.b)paramArrayOfByte.next();
          if (!bs.isNullOrNil(((com.tencent.mm.j.a.a.b)localObject).fBV)) {
            localHashMap.put(((com.tencent.mm.j.a.a.b)localObject).userName, ((com.tencent.mm.j.a.a.b)localObject).fBV);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paramArrayOfByte, "parse chatroom data", new Object[0]);
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
        localObject = (com.tencent.mm.storage.ai)paramHashMap.get(paramArrayOfByte);
        if (localObject != null)
        {
          String str7 = ((av)localObject).field_conRemark;
          String str6 = ((av)localObject).field_nickname;
          String str8 = d.bf(str7, false);
          String str9 = d.bf(str7, true);
          localStringBuffer.append(bs.bG(str7, " ")).append("‌");
          localStringBuffer.append(bs.bG(str8, " ")).append("‌");
          localStringBuffer.append(bs.bG(str9, " ")).append("‌");
          str7 = d.bf(str6, false);
          str8 = d.bf(str6, true);
          localStringBuffer.append(bs.bG(str6, " ")).append("‌");
          localStringBuffer.append(bs.bG(str7, " ")).append("‌");
          localStringBuffer.append(bs.bG(str8, " ")).append("‌");
          localStringBuffer.append(bs.bG((String)localHashMap.get(paramArrayOfByte), " ")).append("‌");
          M((com.tencent.mm.storage.ai)localObject);
          localStringBuffer.append(bs.bG(((av)localObject).eyf, " ")).append("‌");
          localStringBuffer.append(bs.bG(d.gA(paramArrayOfByte, ((com.tencent.mm.storage.ai)localObject).Tl()), " ")).append("‌");
          localStringBuffer.append("​");
        }
        i += 1;
      }
    }
    if (!bs.isNullOrNil(str1))
    {
      this.szE.a(131075, 5, l1, paramString, l3, str1);
      if (bs.isNullOrNil(str4)) {
        break label761;
      }
      this.szE.a(131075, 6, l1, paramString, l3, str4);
    }
    label761:
    for (int i = 2;; i = 1)
    {
      j = i;
      if (!bs.isNullOrNil(str5))
      {
        this.szE.a(131075, 7, l1, paramString, l3, str5);
        j = i + 1;
      }
      i = j;
      if (!bs.isNullOrNil(paramai))
      {
        this.szE.a(131075, 1, l1, paramString, l3, paramai);
        i = j + 1;
        j = i;
        if (!bs.isNullOrNil(str4))
        {
          this.szE.a(131075, 2, l1, paramString, l3, str2);
          j = i + 1;
        }
        i = j;
        if (!bs.isNullOrNil(str5))
        {
          this.szE.a(131075, 3, l1, paramString, l3, str3);
          i = j + 1;
        }
      }
      j = i;
      if (localStringBuffer.length() > 0)
      {
        localStringBuffer.setLength(localStringBuffer.length() - 1);
        this.szE.a(131075, 38, l1, paramString, l3, localStringBuffer.toString());
        j = i + 1;
      }
      AppMethodBeat.o(52679);
      return j;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(52676);
    switch (paramj.jwR)
    {
    default: 
      paramj = new j(paramj);
    }
    for (;;)
    {
      paramj = this.fXX.a(-65536, paramj);
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
  
  public final boolean adU()
  {
    AppMethodBeat.i(52678);
    this.szO.dead();
    this.szP.dead();
    this.szR.stopTimer();
    this.szQ.stopTimer();
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().b(this.szL);
    ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().remove(this.szM);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().b(this.szK);
    k.a locala = this.szN;
    if (com.tencent.mm.ax.b.hLu != null) {
      com.tencent.mm.ax.b.hLu.b(locala);
    }
    if (this.szG != null) {
      this.szG.clear();
    }
    if (this.szF != null) {
      this.szF.clear();
    }
    this.szE = null;
    this.fXX = null;
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
    Object localObject = (String[])this.szH.get(paramString);
    this.szE.beginTransaction();
    int j;
    int i;
    if (localObject == null)
    {
      this.szE.agi(paramString);
      j = (int)this.szE.sBp.simpleQueryForLong() + 0;
      i = j;
      if (paramArrayOfString != null)
      {
        this.szE.k(paramString, paramArrayOfString);
        this.szH.put(paramString, paramArrayOfString);
        i = j + paramArrayOfString.length;
      }
    }
    for (;;)
    {
      this.szE.commit();
      AppMethodBeat.o(52680);
      return i;
      if (paramArrayOfString == null)
      {
        this.szE.agi(paramString);
        i = (int)this.szE.sBp.simpleQueryForLong() + 0;
        this.szH.remove(paramString);
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
            locala = this.szE;
            locala.sBj.bindString(1, paramString);
            locala.sBj.bindString(2, str);
            locala.sBj.execute();
            k = i + 1;
          }
          j += 1;
        }
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          locala = this.szE;
          locala.sBk.bindString(1, paramString);
          locala.sBk.bindString(2, str);
          locala.sBk.execute();
          i += 1;
        }
        this.szH.put(paramString, paramArrayOfString);
      }
    }
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(52677);
    if (!((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
      AppMethodBeat.o(52677);
      return false;
    }
    ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
    this.szE = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3));
    this.fXX = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.qJV = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
    this.szF = new HashSet();
    this.szG = new HashMap();
    this.szH = new HashMap();
    this.szI = new HashMap();
    try
    {
      this.szJ = av.class.getDeclaredMethod("parseBuff", new Class[0]);
      this.szJ.setAccessible(true);
      this.fXX.a(131072, new f((byte)0));
      this.fXX.a(131082, new a((byte)0));
      this.fXX.a(131092, new b((byte)0));
      this.fXX.a(2147483647, new c((byte)0));
      ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().add(this.szM);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().a(this.szL);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().a(this.szK);
      k.a locala = this.szN;
      if (com.tencent.mm.ax.b.hLu != null) {
        com.tencent.mm.ax.b.hLu.a(locala);
      }
      this.szQ.au(600000L, 600000L);
      this.szO.alive();
      this.szP.alive();
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
    private int qKc = 0;
    private int qKd = 0;
    
    private a() {}
    
    public final String bdq()
    {
      AppMethodBeat.i(52643);
      String str = String.format("{new: %d removed: %d}", new Object[] { Integer.valueOf(this.qKc), Integer.valueOf(this.qKd) });
      AppMethodBeat.o(52643);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52642);
      ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
      Object localObject1 = new HashSet();
      Object localObject2 = a.a(a.this).swc.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
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
        if ((!bs.isNullOrNil((String)localObject3)) && (!bs.isNullOrNil(str)) && (a.agc((String)localObject3)))
        {
          localObject3 = com.tencent.mm.plugin.fts.a.c.a.swH.split((CharSequence)localObject3);
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
            this.qKc += 1;
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
        a.a(a.this).agi((String)localObject2);
        this.qKd += 1;
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
    private int sAa;
    private int sAb;
    private int sAc;
    private int sAd;
    private int sAe;
    private int sAf;
    private int sAg;
    private HashSet<String> szV;
    private HashMap<String, com.tencent.mm.storage.ai> szW;
    private long szX;
    private long szY;
    private int szZ;
    
    private b()
    {
      AppMethodBeat.i(52645);
      this.szW = new HashMap();
      this.szX = -1L;
      this.szY = -1L;
      this.szZ = 0;
      this.sAa = 0;
      this.sAb = 0;
      this.sAc = 0;
      this.sAd = 0;
      AppMethodBeat.o(52645);
    }
    
    public final String bdq()
    {
      AppMethodBeat.i(52647);
      String str = String.format("{build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, failContact: %d, failChatroom}", new Object[] { Integer.valueOf(this.sAg), Integer.valueOf(this.sAa), Integer.valueOf(this.szZ), Integer.valueOf(this.sAb), Integer.valueOf(this.sAe), Integer.valueOf(this.sAf), Integer.valueOf(this.sAc), Integer.valueOf(this.sAd) });
      AppMethodBeat.o(52647);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52646);
      ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building contact index.");
      afX("start");
      Object localObject5;
      Object localObject6;
      long l;
      Object localObject3;
      if (this.szV == null)
      {
        this.szV = new HashSet();
        localObject5 = a.a(a.this).a(com.tencent.mm.plugin.fts.a.c.swt, true, false, true, false, true);
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
            this.szV.add(localObject6);
            if (i == 2) {
              a.c(a.this).add(localObject6);
            }
          }
        }
        ((Cursor)localObject5).close();
        this.sAe = a.b(a.this).size();
        this.sAf = a.c(a.this).size();
        this.sAg = this.szV.size();
        if (this.sAg < 5) {
          this.sxz |= 1L;
        }
      }
      afX("getBuildContact");
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
        a.a(a.this).dH((List)localObject1);
      }
      afX("deleteDirtyContact");
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
          l = a.d(a.this).afL((String)localObject3);
          a.a(a.this).as((String)localObject3, l);
        }
        a.c(a.this).clear();
      }
      afX("updateTimestampContact");
      if (Thread.interrupted())
      {
        localObject1 = new InterruptedException();
        AppMethodBeat.o(52646);
        throw ((Throwable)localObject1);
      }
      Object localObject1 = a.d(a.this).i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE ROWID > ? AND deleteFlag=0 ORDER BY ROWID;", new String[] { Long.toString(this.szX) });
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
        this.szX = l;
        localObject3 = new com.tencent.mm.storage.ai();
        ((com.tencent.mm.storage.ai)localObject3).fLJ = l;
        ((com.tencent.mm.storage.ai)localObject3).setUsername(((Cursor)localObject1).getString(1));
        ((com.tencent.mm.storage.ai)localObject3).qg(((Cursor)localObject1).getString(2));
        ((com.tencent.mm.storage.ai)localObject3).qh(((Cursor)localObject1).getString(3));
        ((com.tencent.mm.storage.ai)localObject3).qj(((Cursor)localObject1).getString(4));
        ((com.tencent.mm.storage.ai)localObject3).jD(((Cursor)localObject1).getInt(5));
        ((com.tencent.mm.storage.ai)localObject3).setType(((Cursor)localObject1).getInt(6));
        ((com.tencent.mm.storage.ai)localObject3).M(((Cursor)localObject1).getBlob(7));
        ((com.tencent.mm.storage.ai)localObject3).qq(((Cursor)localObject1).getString(8));
        ((com.tencent.mm.storage.ai)localObject3).jF(0);
        this.szW.put(((av)localObject3).field_username, localObject3);
        if ((!w.sQ(((av)localObject3).field_username)) && (a.this.O((com.tencent.mm.storage.ai)localObject3)) && (!this.szV.remove(((av)localObject3).field_username)))
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
            if (!((av)localObject3).field_username.endsWith("@chatroom"))
            {
              i = j;
              if ((((av)localObject3).field_verifyFlag & com.tencent.mm.storage.ai.fag()) == 0)
              {
                i = j;
                a.this.M((com.tencent.mm.storage.ai)localObject3);
                i = j;
                ((com.tencent.mm.storage.ai)localObject3).faj();
              }
            }
            i = j;
            j += a.this.Q((com.tencent.mm.storage.ai)localObject3);
            i = j;
            this.sAa += 1;
            i = j;
          }
          catch (Exception localException4)
          {
            ac.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", localException4, "Build contact index failed with exception.\n", new Object[0]);
            this.sAc += 1;
          }
        }
      }
      ((Cursor)localObject1).close();
      a.a(a.this).commit();
      afX("buildWXContact");
      if (Thread.interrupted())
      {
        localObject1 = new InterruptedException();
        AppMethodBeat.o(52646);
        throw ((Throwable)localObject1);
      }
      Object localObject4 = a.d(a.this).i("SELECT rowid, chatroomname, memberlist, roomdata FROM chatroom WHERE ROWID > ? ORDER BY ROWID;", new String[] { Long.toString(this.szY) });
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
        this.szY = ((Cursor)localObject4).getLong(0);
        localObject1 = ((Cursor)localObject4).getString(1);
        if (!this.szV.remove(localObject1))
        {
          localObject5 = (com.tencent.mm.storage.ai)this.szW.get(localObject1);
          if (localObject5 == null)
          {
            this.sAd += 1;
          }
          else
          {
            Object localObject7 = ((Cursor)localObject4).getString(2);
            if (!a.agc((String)localObject7))
            {
              this.sAd += 1;
            }
            else
            {
              localObject6 = ((Cursor)localObject4).getBlob(3);
              for (;;)
              {
                try
                {
                  localObject7 = com.tencent.mm.plugin.fts.a.c.a.swH.split((CharSequence)localObject7);
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
                      j = a.this.a((String)localObject1, (com.tencent.mm.storage.ai)localObject5, (String[])localObject7, (byte[])localObject6, this.szW);
                      i += j;
                    }
                    catch (Exception localException2)
                    {
                      Object localObject2;
                      continue;
                    }
                    try
                    {
                      this.szZ += 1;
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
                ac.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", localException1, "Build contact index failed with exception.\n", new Object[0]);
                this.sAd += 1;
                j = i;
              }
            }
          }
        }
      }
      ((Cursor)localObject4).close();
      a.a(a.this).commit();
      afX("buildChatroomContact");
      if (Thread.interrupted())
      {
        localObject2 = new InterruptedException();
        AppMethodBeat.o(52646);
        throw ((Throwable)localObject2);
      }
      this.sAb = this.szV.size();
      localObject2 = this.szV.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        a.a(a.this).a(com.tencent.mm.plugin.fts.a.c.swt, (String)localObject4);
        ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.swt, (String)localObject4);
      }
      this.szV.clear();
      this.szW.clear();
      afX("deleteUnusedContact");
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
      a.a(a.this).y(com.tencent.mm.plugin.fts.a.c.swr);
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
    private String foE;
    private int sAi = 0;
    
    public d(String paramString)
    {
      this.foE = paramString;
    }
    
    public final String bdq()
    {
      AppMethodBeat.i(52650);
      String str = String.format("{username: %s mDirtyCount: %d}", new Object[] { this.foE, Integer.valueOf(this.sAi) });
      AppMethodBeat.o(52650);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52649);
      ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", new Object[] { this.foE });
      a.a(a.this).a(com.tencent.mm.plugin.fts.a.c.swt, this.foE);
      ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.swt, this.foE);
      Object localObject1 = a.a(a.this).agh(this.foE);
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
          List localList = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.swt, (String)localObject2);
          a.b(a.this).put(localObject2, localList);
          ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().agf((String)localObject2);
          this.sAi += 1;
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
    private boolean fYo = false;
    private String foE;
    
    public e(String paramString)
    {
      this.foE = paramString;
    }
    
    public final String bdq()
    {
      AppMethodBeat.i(52652);
      String str = String.format("{username: %s isSkipped: %b}", new Object[] { this.foE, Boolean.valueOf(this.fYo) });
      AppMethodBeat.o(52652);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52651);
      ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", new Object[] { this.foE });
      com.tencent.mm.storage.ai localai = a.d(a.this).afJ(this.foE);
      if ((localai != null) && (localai.field_username.length() > 0) && (a.this.O(localai))) {
        a.this.P(localai);
      }
      for (;;)
      {
        a.b(a.this).remove(this.foE);
        a.c(a.this).remove(this.foE);
        AppMethodBeat.o(52651);
        return true;
        this.fYo = true;
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
    private int sAj = 0;
    private int sAk = 0;
    
    private f() {}
    
    public final String bdq()
    {
      AppMethodBeat.i(52654);
      String str = String.format("{users: %d labels: %d}", new Object[] { Integer.valueOf(this.sAj), Integer.valueOf(this.sAk) });
      AppMethodBeat.o(52654);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52653);
      Cursor localCursor = a.a(a.this).swc.rawQuery("SELECT user, label_id FROM FTS5ContactLabels;", null);
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
          this.sAj += 1;
        }
        ((List)localObject).add(Long.valueOf(l));
        this.sAk += 1;
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
    private int qSX = 0;
    private int[] sAl;
    private int sAm = 0;
    
    public g(int[] paramArrayOfInt)
    {
      this.sAl = paramArrayOfInt;
    }
    
    public final String bdq()
    {
      AppMethodBeat.i(52656);
      String str = String.format("{touched: %d users: %d}", new Object[] { Integer.valueOf(this.qSX), Integer.valueOf(this.sAm) });
      AppMethodBeat.o(52656);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52655);
      Object localObject = a.a(a.this).j(this.sAl, 1);
      this.qSX = ((List)localObject).size();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.fts.a.a.b localb = (com.tencent.mm.plugin.fts.a.a.b)localIterator.next();
        String str = localb.sxG;
        if (!a.b(a.this).containsKey(str))
        {
          List localList = (List)localHashMap.get(str);
          localObject = localList;
          if (localList == null)
          {
            localObject = new ArrayList(16);
            localHashMap.put(str, localObject);
          }
          ((List)localObject).add(Long.valueOf(localb.sxE));
        }
      }
      a.b(a.this).putAll(localHashMap);
      this.sAm = localHashMap.size();
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
    private boolean fYo = false;
    private String foE;
    private boolean sAn = false;
    
    public h(String paramString)
    {
      this.foE = paramString;
    }
    
    public final String bdq()
    {
      AppMethodBeat.i(52658);
      String str = String.format("{username: %s cached: %b isSkipped: %b}", new Object[] { this.foE, Boolean.valueOf(this.sAn), Boolean.valueOf(this.fYo) });
      AppMethodBeat.o(52658);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52657);
      ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", new Object[] { this.foE });
      if (a.b(a.this).containsKey(this.foE))
      {
        this.sAn = true;
        AppMethodBeat.o(52657);
        return true;
      }
      a.a(a.this).afN(this.foE);
      Object localObject1 = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.swt, this.foE);
      a.b(a.this).put(this.foE, localObject1);
      if (((List)localObject1).isEmpty())
      {
        this.fYo = true;
        a.e(a.this).a(65556, new a.e(a.this, this.foE));
        AppMethodBeat.o(52657);
        return true;
      }
      localObject1 = a.a(a.this).agh(this.foE);
      Object localObject2 = new HashSet();
      while (((Cursor)localObject1).moveToNext()) {
        ((HashSet)localObject2).add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
      localObject1 = ((HashSet)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        a.a(a.this).afN((String)localObject2);
        if (!a.b(a.this).containsKey(localObject2))
        {
          List localList = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.swt, (String)localObject2);
          a.b(a.this).put(localObject2, localList);
        }
      }
      a.c(a.this).remove(this.foE);
      ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().agf(this.foE);
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
    private boolean sAo;
    private String username;
    
    public i(String paramString)
    {
      this.username = paramString;
    }
    
    public final String bdq()
    {
      AppMethodBeat.i(52660);
      String str = String.format("{username: %s isSkipped: %b}", new Object[] { this.username, Boolean.valueOf(this.sAo) });
      AppMethodBeat.o(52660);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52659);
      if (a.b(a.this).containsKey(this.username))
      {
        this.sAo = true;
        AppMethodBeat.o(52659);
        return true;
      }
      if (!a.c(a.this).add(this.username))
      {
        this.sAo = true;
        AppMethodBeat.o(52659);
        return true;
      }
      Object localObject = a.d(a.this).afJ(this.username);
      if ((localObject != null) && (!a.this.O((com.tencent.mm.storage.ai)localObject)))
      {
        this.sAo = true;
        AppMethodBeat.o(52659);
        return true;
      }
      localObject = a.a(a.this);
      String str = this.username;
      ((com.tencent.mm.plugin.fts.a.a)localObject).swi.bindLong(1, 2L);
      ((com.tencent.mm.plugin.fts.a.a)localObject).swi.bindString(2, str);
      ((com.tencent.mm.plugin.fts.a.a)localObject).swi.bindLong(3, 0L);
      ((com.tencent.mm.plugin.fts.a.a)localObject).swi.execute();
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
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52661);
      paramk.sxM = com.tencent.mm.plugin.fts.a.a.h.bi(this.syx.query, true);
      Object localObject1 = a.a(a.this).a(paramk.sxM, this.syx.syD, this.syx.syE, true, true);
      Object localObject2 = new HashMap();
      HashMap localHashMap = new HashMap();
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject1);
        if (!this.syx.syG.contains(localn.sxG))
        {
          com.tencent.mm.plugin.fts.a.a.m localm;
          if (d.k(com.tencent.mm.plugin.fts.a.c.swt, localn.type))
          {
            localm = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject2).get(localn.sxG);
            if ((localm == null) || (d.f(com.tencent.mm.plugin.fts.a.c.swE, localn.sxF, localm.sxF) < 0)) {
              ((HashMap)localObject2).put(localn.sxG, localn);
            }
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException();
            AppMethodBeat.o(52661);
            throw paramk;
            if (d.k(com.tencent.mm.plugin.fts.a.c.swv, localn.type))
            {
              localm = (com.tencent.mm.plugin.fts.a.a.m)localHashMap.get(Long.valueOf(localn.syN));
              if ((localm == null) || (d.f(com.tencent.mm.plugin.fts.a.c.swE, localn.sxF, localm.sxF) < 0)) {
                localHashMap.put(Long.valueOf(localn.syN), localn);
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
      paramk.syK = new ArrayList(((HashMap)localObject2).size());
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cKz();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.sxM);
        paramk.syK.add(localObject2);
      }
      paramk.syK.addAll(localHashMap.values());
      if (Thread.interrupted())
      {
        paramk = new InterruptedException();
        AppMethodBeat.o(52661);
        throw paramk;
      }
      if (this.syx.syH != null) {
        Collections.sort(paramk.syK, this.syx.syH);
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
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52662);
      super.a(paramk);
      Object localObject1 = a.a(a.this);
      Object localObject2 = this.syx.query;
      String str = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075 ORDER BY timestamp desc", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cKq() });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).swc.rawQuery(str, new String[] { localObject2 });
      paramk.syK = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).sxG = ((Cursor)localObject1).getString(0);
        paramk.syK.add(localObject2);
      }
      ((Cursor)localObject1).close();
      paramk.bPH = 0;
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
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      int i = 0;
      AppMethodBeat.i(52663);
      super.a(paramk);
      Object localObject = a.a(a.this);
      String str1 = this.syx.query;
      String str2 = String.format("SELECT count(aux_index) FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject).cKq() });
      localObject = ((com.tencent.mm.plugin.fts.a.a)localObject).swc.rawQuery(str2, new String[] { str1 });
      if (((Cursor)localObject).moveToNext()) {
        i = ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
      localObject = new com.tencent.mm.plugin.fts.a.a.m();
      ((com.tencent.mm.plugin.fts.a.a.m)localObject).userData = Integer.valueOf(i);
      paramk.syK = new ArrayList();
      paramk.syK.add(localObject);
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
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52664);
      super.a(paramk);
      Object localObject1 = a.a(a.this);
      Object localObject2 = this.syx.syB;
      Object localObject3 = paramk.sxM.cKw();
      localObject3 = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN (SELECT docid, aux_index, timestamp FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=?) as temp ON (%s.rowid = temp.docid) WHERE %s MATCH '%s' ORDER BY -timestamp;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).swc.rawQuery((String)localObject3, new String[] { localObject2 });
      localObject2 = new HashSet();
      paramk.syK = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).sxG = ((Cursor)localObject1).getString(0);
        if (((HashSet)localObject2).add(((com.tencent.mm.plugin.fts.a.a.m)localObject3).sxG)) {
          paramk.syK.add(localObject3);
        }
      }
      ((Cursor)localObject1).close();
      paramk.bPH = 0;
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
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52665);
      paramk.sxM = com.tencent.mm.plugin.fts.a.a.h.bi(this.syx.query, true);
      Object localObject2 = a.a(a.this).a(paramk.sxM, new int[] { 131075 }, null, true, true);
      Object localObject1 = new HashMap();
      Object localObject4;
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject2);
        if (!this.syx.syG.contains(((com.tencent.mm.plugin.fts.a.a.n)localObject3).sxG))
        {
          localObject4 = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject1).get(((com.tencent.mm.plugin.fts.a.a.n)localObject3).sxG);
          if ((localObject4 == null) || (d.f(com.tencent.mm.plugin.fts.a.c.swE, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).sxF, ((com.tencent.mm.plugin.fts.a.a.m)localObject4).sxF) < 0)) {
            ((HashMap)localObject1).put(((com.tencent.mm.plugin.fts.a.a.n)localObject3).sxG, localObject3);
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
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).cKz();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).a(paramk.sxM);
        ((ArrayList)localObject2).add(localObject4);
        if (Thread.interrupted())
        {
          paramk = new InterruptedException();
          AppMethodBeat.o(52665);
          throw paramk;
        }
      }
      if (this.syx.syH != null) {
        Collections.sort((List)localObject2, this.syx.syH);
      }
      paramk.syK = new ArrayList(((HashMap)localObject1).size());
      localObject1 = new StringBuffer();
      int i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        localObject3 = (com.tencent.mm.plugin.fts.a.a.m)((ArrayList)localObject2).get(i);
        ((StringBuffer)localObject1).append(((com.tencent.mm.plugin.fts.a.a.m)localObject3).syi);
        ((StringBuffer)localObject1).append("|");
        ((StringBuffer)localObject1).append(((com.tencent.mm.plugin.fts.a.a.m)localObject3).timestamp);
        ((StringBuffer)localObject1).append(" ");
        paramk.syK.add(localObject3);
        if (i >= this.syx.syF) {
          break;
        }
        i += 1;
      }
      if ((paramk.sxM.syo.size() > 1) && (a.a(a.this).b(paramk.sxM)))
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).sxG = "create_chatroom​";
        paramk.syK.add(0, localObject2);
        ((StringBuffer)localObject1).append(" needCreateChatroom");
      }
      ac.i("MicroMsg.FTS.FTS5SearchContactLogic", "rank score: %s", new Object[] { ((StringBuffer)localObject1).toString() });
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
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52666);
      Object localObject2 = bs.S(this.syx.query.split(","));
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
      localObject2 = String.format("SELECT member, chatroom, entity_id FROM FTS5ChatRoomMembers, %s WHERE %s AND chatroom = aux_index", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cKq(), ((StringBuffer)localObject3).toString() });
      localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject1).swc.rawQuery((String)localObject2, null);
      localObject2 = new HashMap();
      if (((Cursor)localObject3).moveToNext())
      {
        String str = ((Cursor)localObject3).getString(0);
        if (((HashMap)localObject2).containsKey(str)) {}
        for (localObject1 = (List)((HashMap)localObject2).get(str);; localObject1 = new ArrayList())
        {
          com.tencent.mm.plugin.fts.a.a.m localm = new com.tencent.mm.plugin.fts.a.a.m();
          localm.sxG = ((Cursor)localObject3).getString(1);
          localm.syN = ((Cursor)localObject3).getLong(2);
          ((List)localObject1).add(localm);
          ((HashMap)localObject2).put(str, localObject1);
          break;
        }
      }
      ((Cursor)localObject3).close();
      paramk.syK = new ArrayList();
      localObject1 = new com.tencent.mm.plugin.fts.a.a.m();
      ((com.tencent.mm.plugin.fts.a.a.m)localObject1).userData = localObject2;
      paramk.syK.add(localObject1);
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
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52667);
      long l = Long.valueOf(this.syx.query).longValue();
      Object localObject1 = a.a(a.this);
      Object localObject2 = String.format("SELECT distinct(aux_index) FROM %s WHERE timestamp < %d AND type = %d", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cKq(), Long.valueOf(l), Integer.valueOf(131072) });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).swc.rawQuery((String)localObject2, null);
      paramk.syK = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).sxG = ((Cursor)localObject1).getString(0);
        paramk.syK.add(localObject2);
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
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52668);
      paramk.sxM = com.tencent.mm.plugin.fts.a.a.h.bi(this.syx.query, true);
      Object localObject2 = a.a(a.this);
      Object localObject3 = paramk.sxM;
      Object localObject1 = this.syx.syD;
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).cKw();
      int i;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject1 = " AND type IN " + d.z((int[])localObject1);
        long l = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).syo.size();
        localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject1 + " AND status >= 0 ORDER BY subtype;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject2).cKq(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cKr(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.a)localObject2).cKq(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cKr(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cKq(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cKr(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cKr(), localObject4 });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).swc.rawQuery((String)localObject1, null);
        localObject2 = new ArrayList();
        localObject3 = new HashSet();
        ((HashSet)localObject3).addAll(this.syx.syG);
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
          if (i >= ((com.tencent.mm.plugin.fts.a.a.n)localObject4).sxF) {
            ((List)localObject2).add(localObject4);
          }
          for (;;)
          {
            if (!Thread.interrupted()) {
              break label397;
            }
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.syx.query);
            AppMethodBeat.o(52668);
            throw paramk;
            localObject1 = "";
            break;
            if (((List)localObject2).size() > this.syx.syF) {
              break label399;
            }
            i = ((com.tencent.mm.plugin.fts.a.a.n)localObject4).sxF;
            ((List)localObject2).add(localObject4);
          }
        }
      }
      label399:
      ((Cursor)localObject1).close();
      paramk.syK = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cKz();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.sxM);
        paramk.syK.add(localObject2);
      }
      if (this.syx.syH != null) {
        Collections.sort(paramk.syK, this.syx.syH);
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
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52669);
      afX("start");
      paramk.sxM = com.tencent.mm.plugin.fts.a.a.h.bi(this.syx.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.sxM;
      Object localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).cKw();
      long l1 = System.currentTimeMillis();
      long l2 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).syo.size();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) AS Offsets, MMChatroomRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, entity_id, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 ORDER BY Rank, timestamp desc ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), Long.valueOf(l1 - 1209600000L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).swc.rawQuery((String)localObject3, new String[] { ((com.tencent.mm.plugin.fts.a.a.h)localObject2).syl });
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.syx.syG);
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().h((Cursor)localObject1);
        if (((HashSet)localObject3).add(localn.sxG)) {
          if (((List)localObject2).size() <= this.syx.syF)
          {
            ((List)localObject2).add(localn);
            if (Thread.interrupted())
            {
              ((Cursor)localObject1).close();
              paramk = new InterruptedException("Task is Cancel: " + this.syx.query);
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
      afX("orm");
      paramk.syK = new ArrayList(((List)localObject2).size());
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cKz();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.sxM);
        paramk.syK.add(localObject2);
      }
      if (Thread.interrupted())
      {
        paramk = new InterruptedException();
        AppMethodBeat.o(52669);
        throw paramk;
      }
      if (this.syx.syH != null) {
        Collections.sort(paramk.syK, this.syx.syH);
      }
      afX("calOffsets");
      if ((paramk.sxM.syo.size() > 1) && (a.a(a.this).b(paramk.sxM)))
      {
        localObject1 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject1).sxG = "create_chatroom​";
        if (paramk.syK.size() <= 3) {
          break label599;
        }
        paramk.syK.add(3, localObject1);
      }
      for (;;)
      {
        afX("checkChatroom");
        AppMethodBeat.o(52669);
        return;
        label599:
        paramk.syK.add(localObject1);
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
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52670);
      paramk.sxM = com.tencent.mm.plugin.fts.a.a.h.bi(this.syx.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.sxM;
      Object localObject3 = this.syx.syD;
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).cKw();
      long l1 = System.currentTimeMillis();
      long l2 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).syo.size();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), MMContactRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type IN " + d.z((int[])localObject3) + " ORDER BY Rank ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), Long.valueOf(l1 - 1105032704L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), localObject4 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).swc.rawQuery((String)localObject3, new String[] { ((com.tencent.mm.plugin.fts.a.a.h)localObject2).syl });
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.syx.syG);
      l1 = 0L;
      while (((Cursor)localObject1).moveToNext())
      {
        localObject4 = new com.tencent.mm.plugin.fts.a.a.n().h((Cursor)localObject1);
        if (((HashSet)localObject3).add(((com.tencent.mm.plugin.fts.a.a.n)localObject4).sxG))
        {
          if (l1 >= ((com.tencent.mm.plugin.fts.a.a.n)localObject4).syV) {
            ((List)localObject2).add(localObject4);
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.syx.query);
            AppMethodBeat.o(52670);
            throw paramk;
            if (((List)localObject2).size() > this.syx.syF) {
              break label407;
            }
            l1 = ((com.tencent.mm.plugin.fts.a.a.n)localObject4).syV;
            ((List)localObject2).add(localObject4);
          }
        }
      }
      label407:
      ((Cursor)localObject1).close();
      paramk.syK = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cKz();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.sxM);
        paramk.syK.add(localObject2);
      }
      if (this.syx.syH != null) {
        Collections.sort(paramk.syK, this.syx.syH);
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
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      int i = 0;
      AppMethodBeat.i(52671);
      paramk.sxM = com.tencent.mm.plugin.fts.a.a.h.bi(this.syx.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.sxM;
      Object localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).cKw();
      long l1 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).syo.size();
      long l2 = System.currentTimeMillis();
      localObject2 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), Long.valueOf(l1), Long.valueOf(l2 - 1105032704L), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), ((com.tencent.mm.plugin.fts.c.a)localObject1).cKr(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).swc.rawQuery((String)localObject2, null);
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.syx.syG);
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject1);
        if (((HashSet)localObject3).add(localn.sxG))
        {
          if (i >= localn.sxF) {
            ((List)localObject2).add(localn);
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.syx.query);
            AppMethodBeat.o(52671);
            throw paramk;
            if (((List)localObject2).size() > this.syx.syF) {
              break label345;
            }
            i = localn.sxF;
            ((List)localObject2).add(localn);
          }
        }
      }
      label345:
      ((Cursor)localObject1).close();
      paramk.syK = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).cKz();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.sxM);
        paramk.syK.add(localObject2);
      }
      if (this.syx.syH != null) {
        Collections.sort(paramk.syK, this.syx.syH);
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
    private int sAp = 0;
    private int sAq = 0;
    private int sAr = 0;
    
    private u() {}
    
    public final String bdq()
    {
      AppMethodBeat.i(52673);
      String str = String.format("{Dirty: %d Timestamp: %d tophitsCount: %d}", new Object[] { Integer.valueOf(this.sAp), Integer.valueOf(this.sAq), Integer.valueOf(this.sAr) });
      AppMethodBeat.o(52673);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52672);
      afX("start");
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
          a.a(a.this).vt(l);
          i += 1;
        }
        localObject2 = (String)((Map.Entry)localObject2).getKey();
        localObject3 = a.d(a.this).afJ((String)localObject2);
        if ((localObject3 != null) && (((av)localObject3).field_username.length() > 0) && (a.this.O((com.tencent.mm.storage.ai)localObject3))) {
          i += a.this.P((com.tencent.mm.storage.ai)localObject3);
        }
        for (;;)
        {
          ((Iterator)localObject1).remove();
          a.c(a.this).remove(localObject2);
          this.sAp += 1;
          break;
          afX("dirtyContact");
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
            l = a.d(a.this).afL((String)localObject2);
            localObject3 = a.d(a.this).afJ((String)localObject2);
            if ((localObject3 == null) || (((av)localObject3).field_username.length() <= 0) || (!a.this.O((com.tencent.mm.storage.ai)localObject3))) {
              break label536;
            }
            a.a(a.this).as((String)localObject2, l);
            i += 1;
          }
          for (;;)
          {
            ((Iterator)localObject1).remove();
            this.sAq += 1;
            break;
            a.a(a.this).commit();
            afX("timestampContact");
            localObject1 = ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic();
            ((e)localObject1).sAX.clear();
            this.sAr = ((e)localObject1).sAW.cKW();
            afX("topHits");
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
    private long sAs;
    private int sAt = 0;
    
    public v(long paramLong)
    {
      this.sAs = paramLong;
    }
    
    public final String bdq()
    {
      AppMethodBeat.i(52675);
      String str = String.format("{mLabelId: %d mContactCount: %d}", new Object[] { Long.valueOf(this.sAs), Integer.valueOf(this.sAt) });
      AppMethodBeat.o(52675);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52674);
      Object localObject1 = new ArrayList(32);
      Object localObject2 = a.a(a.this);
      long l = this.sAs;
      localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject2).swc.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[] { Long.toString(l) });
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
          List localList = a.a(a.this).b(com.tencent.mm.plugin.fts.a.c.swu, (String)localObject2);
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