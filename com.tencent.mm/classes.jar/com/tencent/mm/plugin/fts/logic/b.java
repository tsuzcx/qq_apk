package com.tencent.mm.plugin.fts.logic;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.api.g.a;
import com.tencent.mm.openim.api.g.b;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.p;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.h.a;
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
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
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

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  private static Set<String> HuZ;
  private com.tencent.mm.plugin.fts.a.j Aeh;
  private MStorage.IOnStorageChange HuE;
  private com.tencent.mm.plugin.fts.b.b HuM;
  private HashSet<String> HuN;
  private HashMap<String, List<Long>> HuO;
  private HashMap<String, String[]> HuP;
  private HashMap<String, List<Long>> HuQ;
  private Method HuR;
  private MStorageEx.IOnStorageChange HuS;
  private MStorageEx.IOnStorageChange HuT;
  private MStorage.IOnStorageChange HuU;
  private IListener HuV;
  private IListener HuW;
  private MTimerHandler HuX;
  private MTimerHandler HuY;
  private com.tencent.mm.plugin.fts.a.m msU;
  
  static
  {
    AppMethodBeat.i(52693);
    HuZ = new HashSet();
    String[] arrayOfString = MMApplicationContext.getContext().getString(h.a.country_others).split(";");
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        HuZ.add(str);
        i += 1;
      }
    }
    AppMethodBeat.o(52693);
  }
  
  public b()
  {
    AppMethodBeat.i(52681);
    this.HuS = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(52631);
        if (!b.this.feX)
        {
          AppMethodBeat.o(52631);
          return;
        }
        paramAnonymousMStorageEx = (String)paramAnonymousObject;
        if (!b.aEu(paramAnonymousMStorageEx))
        {
          Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "onConversationChangeListener filterByUsername %s", new Object[] { paramAnonymousMStorageEx });
          AppMethodBeat.o(52631);
          return;
        }
        paramAnonymousObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxq(paramAnonymousMStorageEx);
        if ((paramAnonymousObject != null) && ((!b.ag(paramAnonymousObject)) || (paramAnonymousObject.iZC())))
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
          if (!b.c(b.this).containsKey(paramAnonymousMStorageEx))
          {
            b.e(b.this).a(65556, new b.h(b.this, paramAnonymousMStorageEx));
            AppMethodBeat.o(52631);
            return;
            if ((!b.d(b.this).contains(paramAnonymousMStorageEx)) && (!b.c(b.this).containsKey(paramAnonymousMStorageEx))) {
              b.e(b.this).a(65556, new b.i(b.this, paramAnonymousMStorageEx));
            }
          }
        }
      }
    };
    this.HuT = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(52632);
        if (!b.this.feX)
        {
          AppMethodBeat.o(52632);
          return;
        }
        paramAnonymousMStorageEx = (String)paramAnonymousObject;
        if (!b.aEu(paramAnonymousMStorageEx))
        {
          Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", new Object[] { paramAnonymousMStorageEx });
          AppMethodBeat.o(52632);
          return;
        }
        paramAnonymousObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxq(paramAnonymousMStorageEx);
        if ((paramAnonymousObject != null) && (!b.ag(paramAnonymousObject)))
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
          if (!b.c(b.this).containsKey(paramAnonymousMStorageEx))
          {
            b.e(b.this).a(65556, new b.h(b.this, paramAnonymousMStorageEx));
            AppMethodBeat.o(52632);
            return;
            b.e(b.this).a(65556, new b.e(b.this, paramAnonymousMStorageEx));
            AppMethodBeat.o(52632);
            return;
            b.e(b.this).a(65556, new b.d(b.this, paramAnonymousMStorageEx));
          }
        }
      }
    };
    this.HuE = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(52633);
        if (!b.this.feX)
        {
          AppMethodBeat.o(52633);
          return;
        }
        if ((paramAnonymousString.equals("*")) || (paramAnonymousString.equals("chatroomname")))
        {
          AppMethodBeat.o(52633);
          return;
        }
        if (!b.c(b.this).containsKey(paramAnonymousString)) {
          b.e(b.this).a(65556, new b.h(b.this, paramAnonymousString));
        }
        AppMethodBeat.o(52633);
      }
    };
    this.HuU = new MStorage.IOnStorageChange()
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
            b.e(b.this).a(65554, new b.w(b.this, l));
            i += 1;
          }
          b.e(b.this).a(65556, new b.v(b.this, (byte)0));
        }
        AppMethodBeat.o(52634);
      }
    };
    this.HuV = new FTS5SearchContactLogic.5(this, com.tencent.mm.app.f.hfK);
    this.HuW = new FTS5SearchContactLogic.6(this, com.tencent.mm.app.f.hfK);
    this.HuX = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
    {
      private int Hvb = 0;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52637);
        PluginFTS localPluginFTS = (PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class);
        if ((localPluginFTS.isCharging()) || (!localPluginFTS.isInBackground())) {}
        for (int i = 1; i == 0; i = 0)
        {
          i = this.Hvb + 1;
          this.Hvb = i;
          if (i >= 6) {
            break;
          }
          AppMethodBeat.o(52637);
          return true;
        }
        b.e(b.this).a(131093, new b.v(b.this, (byte)0));
        this.Hvb = 0;
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
    this.HuY = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52639);
        b.e(b.this).a(131093, new b.v(b.this, (byte)0));
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
  
  private static String IF(String paramString)
  {
    AppMethodBeat.i(52691);
    if (HuZ.contains(paramString))
    {
      AppMethodBeat.o(52691);
      return "";
    }
    AppMethodBeat.o(52691);
    return paramString;
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
    iD(paramString1, str);
    paramString2 = this.Aeh.aEd(str);
    if (paramString2.size() == 0)
    {
      AppMethodBeat.o(52690);
      return 0;
    }
    paramString2 = Util.listToString(paramString2, "​");
    this.HuM.a(131072, 11, paramLong1, paramString1, paramLong2, paramString2);
    AppMethodBeat.o(52690);
    return 1;
  }
  
  private int a(au paramau, long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(52688);
    Object localObject = paramau.kav;
    int i = j;
    if (!Util.isNullOrNil((String)localObject))
    {
      com.tencent.mm.openim.api.g localg = new com.tencent.mm.openim.api.g();
      localg.RH((String)localObject);
      localObject = new StringBuffer();
      i = 0;
      while (i < localg.aYV.size())
      {
        Iterator localIterator = ((g.a)localg.aYV.get(i)).pre.iterator();
        while (localIterator.hasNext())
        {
          String str = ((g.b)localIterator.next()).RI(paramau.field_openImAppid);
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
        this.HuM.a(131081, 51, paramau.maN, paramau.field_username, paramLong, ((StringBuffer)localObject).toString());
        i = 1;
      }
    }
    AppMethodBeat.o(52688);
    return i;
  }
  
  static boolean aEu(String paramString)
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
    if (au.bwQ(paramString))
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
  
  public static boolean aEv(String paramString)
  {
    AppMethodBeat.i(52692);
    boolean bool = Util.nullAs(paramString, "").contains(z.bAM());
    AppMethodBeat.o(52692);
    return bool;
  }
  
  static boolean ag(au paramau)
  {
    AppMethodBeat.i(52684);
    if ((paramau.isHidden()) && (!"notifymessage".equals(paramau.field_username)))
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (paramau.aSF())
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (paramau.field_deleteFlag != 0)
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (!com.tencent.mm.contact.d.rs(paramau.field_type))
    {
      if (paramau.aSE())
      {
        AppMethodBeat.o(52684);
        return false;
      }
      if (paramau.iZC())
      {
        AppMethodBeat.o(52684);
        return false;
      }
    }
    AppMethodBeat.o(52684);
    return true;
  }
  
  private void iD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52689);
    Object localObject1 = c.a.HrF.split(paramString2);
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
      localObject1 = (List)this.HuQ.get(paramString1);
      if (localObject1 == null)
      {
        this.HuM.aEA(paramString1);
        if ((paramString2 != null) && (!paramString2.isEmpty()))
        {
          this.HuM.A(paramString1, paramString2);
          this.HuQ.put(paramString1, paramString2);
          AppMethodBeat.o(52689);
        }
      }
      else
      {
        if ((paramString2 == null) || (paramString2.isEmpty()))
        {
          this.HuM.aEA(paramString1);
          this.HuQ.remove(paramString1);
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
            com.tencent.mm.plugin.fts.b.b localb = this.HuM;
            localb.Hwy.bindString(1, paramString1);
            localb.Hwy.bindLong(2, l);
            localb.Hwy.execute();
          }
        }
        localObject1 = ((HashSet)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          l = ((Long)((Iterator)localObject1).next()).longValue();
          localObject2 = this.HuM;
          ((com.tencent.mm.plugin.fts.b.b)localObject2).Hwz.bindString(1, paramString1);
          ((com.tencent.mm.plugin.fts.b.b)localObject2).Hwz.bindLong(2, l);
          ((com.tencent.mm.plugin.fts.b.b)localObject2).Hwz.execute();
        }
        this.HuQ.put(paramString1, paramString2);
      }
      AppMethodBeat.o(52689);
      return;
      paramString2 = null;
    }
  }
  
  final int a(String paramString, au paramau, String[] paramArrayOfString, byte[] paramArrayOfByte, HashMap<String, au> paramHashMap)
  {
    AppMethodBeat.i(52679);
    String str1 = paramau.field_nickname;
    String str2 = paramau.field_conRemark;
    String str3 = com.tencent.mm.plugin.fts.a.d.bZ(str2, false);
    String str4 = com.tencent.mm.plugin.fts.a.d.bZ(str2, true);
    String str5 = com.tencent.mm.plugin.fts.a.d.bZ(str1, false);
    String str6 = com.tencent.mm.plugin.fts.a.d.bZ(str1, true);
    long l1 = 0L;
    long l2 = this.Aeh.aEc(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    int i;
    int j;
    if (paramArrayOfString != null)
    {
      l1 = paramArrayOfString.length;
      HashMap localHashMap = new HashMap();
      paramau = new com.tencent.mm.h.a.a.a();
      try
      {
        paramau.parseFrom(paramArrayOfByte);
        paramau = paramau.lPK.iterator();
        while (paramau.hasNext())
        {
          paramArrayOfByte = (com.tencent.mm.h.a.a.b)paramau.next();
          if (!Util.isNullOrNil(paramArrayOfByte.displayName)) {
            localHashMap.put(paramArrayOfByte.userName, paramArrayOfByte.displayName);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paramArrayOfByte, "parse chatroom data", new Object[0]);
        }
        i = 0;
        j = 0;
      }
      if (j < paramArrayOfString.length)
      {
        paramau = new StringBuffer();
        paramArrayOfByte = paramArrayOfString[j];
        au localau = (au)paramHashMap.get(paramArrayOfByte);
        if (localau == null)
        {
          Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "can not get chatroomMemberContact data memberUsername:%s i:%s", new Object[] { paramArrayOfByte, Integer.valueOf(j) });
          paramau.append("​");
        }
        for (;;)
        {
          j += 1;
          break;
          String str8 = localau.field_conRemark;
          String str7 = localau.field_nickname;
          String str9 = com.tencent.mm.plugin.fts.a.d.bZ(str8, false);
          String str10 = com.tencent.mm.plugin.fts.a.d.bZ(str8, true);
          paramau.append(Util.nullAs(str8, " ")).append("‌");
          paramau.append(Util.nullAs(str9, " ")).append("‌");
          paramau.append(Util.nullAs(str10, " ")).append("‌");
          str8 = com.tencent.mm.plugin.fts.a.d.bZ(str7, false);
          str9 = com.tencent.mm.plugin.fts.a.d.bZ(str7, true);
          paramau.append(Util.nullAs(str7, " ")).append("‌");
          paramau.append(Util.nullAs(str8, " ")).append("‌");
          paramau.append(Util.nullAs(str9, " ")).append("‌");
          paramau.append(Util.nullAs((String)localHashMap.get(paramArrayOfByte), " ")).append("‌");
          af(localau);
          paramau.append(Util.nullAs(localau.kal, " ")).append("‌");
          paramau.append(Util.nullAs(com.tencent.mm.plugin.fts.a.d.iC(paramArrayOfByte, localau.aJs()), " ")).append("‌");
          if (paramau.indexOf("​") < 0) {
            break label863;
          }
          paramau = new StringBuffer(paramau.toString().replace("​", " "));
          i = 1;
          paramau.append("​");
          localStringBuffer.append(paramau);
        }
      }
    }
    for (int k = i;; k = 0)
    {
      if (!Util.isNullOrNil(str1))
      {
        this.HuM.a(131075, 5, l1, paramString, l2, str1);
        if (!Util.isNullOrNil(str5))
        {
          this.HuM.a(131075, 6, l1, paramString, l2, str5);
          i = 2;
          j = i;
          if (!Util.isNullOrNil(str6)) {
            this.HuM.a(131075, 7, l1, paramString, l2, str6);
          }
        }
      }
      for (j = i + 1;; j = 0)
      {
        i = j;
        if (!Util.isNullOrNil(str2))
        {
          this.HuM.a(131075, 1, l1, paramString, l2, str2);
          i = j + 1;
          j = i;
          if (!Util.isNullOrNil(str5))
          {
            this.HuM.a(131075, 2, l1, paramString, l2, str3);
            j = i + 1;
          }
          i = j;
          if (!Util.isNullOrNil(str6))
          {
            this.HuM.a(131075, 3, l1, paramString, l2, str4);
            i = j + 1;
          }
        }
        j = i;
        if (localStringBuffer.length() > 0)
        {
          localStringBuffer.setLength(localStringBuffer.length() - 1);
          this.HuM.a(131075, 38, l1, paramString, l2, localStringBuffer.toString());
          j = i + 1;
        }
        if (k != 0) {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(146L, 29L, 1L, false);
        }
        AppMethodBeat.o(52679);
        return j;
        i = 1;
        break;
      }
      label863:
      break;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c a(l paraml)
  {
    AppMethodBeat.i(52676);
    switch (paraml.qRb)
    {
    default: 
      paraml = new j(paraml);
    }
    for (;;)
    {
      paraml = this.msU.a(-65536, paraml);
      AppMethodBeat.o(52676);
      return paraml;
      paraml = new r(paraml);
      continue;
      paraml = new o(paraml);
      continue;
      paraml = new u(paraml);
      continue;
      paraml = new t(paraml);
      continue;
      paraml = new l(paraml);
      continue;
      paraml = new k(paraml);
      continue;
      paraml = new m(paraml);
      continue;
      paraml = new s(paraml);
      continue;
      paraml = new p(paraml);
      continue;
      paraml = new q(paraml);
      continue;
      paraml = new n(paraml);
    }
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(52678);
    this.HuV.dead();
    this.HuW.dead();
    this.HuY.stopTimer();
    this.HuX.stopTimer();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().remove(this.HuT);
    ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().remove(this.HuE);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().remove(this.HuS);
    MStorage.IOnStorageChange localIOnStorageChange = this.HuU;
    if (com.tencent.mm.av.b.oLo != null) {
      com.tencent.mm.av.b.oLo.b(localIOnStorageChange);
    }
    if (this.HuO != null) {
      this.HuO.clear();
    }
    if (this.HuN != null) {
      this.HuN.clear();
    }
    this.HuM = null;
    this.msU = null;
    AppMethodBeat.o(52678);
    return true;
  }
  
  final void af(au paramau)
  {
    AppMethodBeat.i(52682);
    try
    {
      this.HuR.invoke(paramau, new Object[0]);
      AppMethodBeat.o(52682);
      return;
    }
    catch (Exception paramau)
    {
      Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paramau, "Failed parsing RContact LVBuffer.", new Object[0]);
      AppMethodBeat.o(52682);
    }
  }
  
  final boolean ah(au paramau)
  {
    AppMethodBeat.i(52685);
    String str = paramau.field_username;
    if (!ag(paramau))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if (!aEu(str))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if ((au.bwV(str)) || (au.bwT(str)))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if (!com.tencent.mm.contact.d.rs(paramau.field_type))
    {
      if ((!paramau.aSE()) && (!paramau.iZC()))
      {
        if (this.Aeh.aEb(str))
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
  
  final int ai(au paramau)
  {
    AppMethodBeat.i(52686);
    Object localObject1;
    Object localObject3;
    if (au.bwE(paramau.field_username))
    {
      localObject1 = String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", new Object[] { "chatroom" });
      localObject3 = this.Aeh.h((String)localObject1, new String[] { paramau.field_username });
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
        if ((Util.isNullOrNil((String)localObject2)) || (localObject1 == null) || (!aEv((String)localObject2)))
        {
          Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", new Object[] { paramau.field_username });
          i = i(paramau.field_username, null);
          if (i > 0) {
            Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paramau.field_username, Integer.valueOf(i) });
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
      Object localObject2 = c.a.Hry.split((CharSequence)localObject2);
      Arrays.sort((Object[])localObject2, new Comparator() {});
      int i = i(paramau.field_username, (String[])localObject2);
      if (i > 0) {
        Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paramau.field_username, Integer.valueOf(i) });
      }
      localObject3 = new HashMap();
      Object localObject4 = "SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + com.tencent.mm.plugin.fts.a.d.J((String[])localObject2) + ";";
      localObject4 = this.Aeh.h((String)localObject4, null);
      try
      {
        while (((Cursor)localObject4).moveToNext())
        {
          au localau = new au();
          localau.maN = ((Cursor)localObject4).getLong(0);
          localau.setUsername(((Cursor)localObject4).getString(1));
          localau.AV(((Cursor)localObject4).getString(2));
          localau.AW(((Cursor)localObject4).getString(3));
          localau.setNickname(((Cursor)localObject4).getString(4));
          localau.ag(((Cursor)localObject4).getBlob(5));
          ((HashMap)localObject3).put(localau.field_username, localau);
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
      i = aj(paramau);
      AppMethodBeat.o(52686);
      return i;
      label506:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  final int aj(au paramau)
  {
    AppMethodBeat.i(52687);
    long l2 = paramau.maN;
    String str2 = paramau.field_username;
    Object localObject7 = paramau.aJs();
    Object localObject1 = paramau.field_nickname;
    Object localObject2 = com.tencent.mm.plugin.fts.a.d.bZ((String)localObject1, false);
    Object localObject3 = com.tencent.mm.plugin.fts.a.d.bZ((String)localObject1, true);
    Object localObject6 = paramau.field_conRemark;
    Object localObject4 = com.tencent.mm.plugin.fts.a.d.bZ((String)localObject6, false);
    Object localObject5 = com.tencent.mm.plugin.fts.a.d.bZ((String)localObject6, true);
    String str3 = paramau.kal;
    String str1 = paramau.field_contactLabelIds;
    String str4 = paramau.kar;
    int i = paramau.field_verifyFlag;
    long l1 = System.currentTimeMillis();
    int j;
    if ((i & au.iZH()) != 0)
    {
      str1 = Util.listToString(((com.tencent.mm.api.o)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.o.class)).hP(str2), "​");
      i = 0;
      j = 131076;
    }
    for (;;)
    {
      localObject7 = com.tencent.mm.plugin.fts.a.d.iC(str2, (String)localObject7);
      if ((localObject7 != null) && (((String)localObject7).length() != 0))
      {
        this.HuM.a(j, 15, l2, str2, l1, (String)localObject7);
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
            this.HuM.a(j, 1, l2, str2, l1, (String)localObject6);
            if ((localObject4 != null) && (((String)localObject4).length() != 0)) {
              this.HuM.a(j, 2, l2, str2, l1, (String)localObject4);
            }
            if ((localObject7 != null) && (((String)localObject7).length() != 0)) {
              this.HuM.a(j, 3, l2, str2, l1, (String)localObject7);
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
                this.HuM.a(j, 5, l2, str2, l1, (String)localObject5);
                if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
                  this.HuM.a(j, 6, l2, str2, l1, (String)localObject3);
                }
                if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
                  this.HuM.a(j, 7, l2, str2, l1, (String)localObject1);
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
                  this.HuM.a(j, 4, l2, str2, l1, str3);
                  i = k + 1;
                }
              }
              k = i;
              if (j == 131072)
              {
                if (Util.isNullOrNil(str4)) {
                  break label927;
                }
                localObject1 = str4.replace(com.tencent.mm.contact.a.e(paramau), "​");
                this.HuM.a(j, 16, l2, str2, l1, (String)localObject1);
                k = i + 1;
              }
              for (;;)
              {
                localObject1 = IF(paramau.getProvince());
                i = k;
                if (localObject1 != null)
                {
                  i = k;
                  if (((String)localObject1).length() != 0)
                  {
                    this.HuM.a(j, 18, l2, str2, l1, (String)localObject1);
                    i = k + 1;
                  }
                }
                localObject1 = paramau.getCity();
                k = i;
                if (localObject1 != null)
                {
                  k = i;
                  if (((String)localObject1).length() != 0)
                  {
                    this.HuM.a(j, 17, l2, str2, l1, (String)localObject1);
                    k = i + 1;
                  }
                }
                i = k;
                if (j == 131076)
                {
                  i = k;
                  if (!Util.isNullOrNil(str1))
                  {
                    this.HuM.a(j, 19, l2, str2, l1, str1);
                    i = k + 1;
                    localObject1 = com.tencent.mm.plugin.fts.a.d.bZ(str1, false);
                    k = i;
                    if (!Util.isNullOrNil((String)localObject1))
                    {
                      this.HuM.a(j, 20, l2, str2, l1, (String)localObject1);
                      k = i + 1;
                    }
                    str1 = com.tencent.mm.plugin.fts.a.d.bZ(str1, true);
                    i = k;
                    if (!Util.isNullOrNil(str1))
                    {
                      this.HuM.a(j, 21, l2, str2, l1, str1);
                      i = k + 1;
                    }
                  }
                }
                k = i;
                if (j == 131081) {
                  k = i + a(paramau, l1);
                }
                AppMethodBeat.o(52687);
                return k;
                if (au.bwO(str2))
                {
                  i = 0;
                  str1 = "";
                  j = 131081;
                  break;
                }
                l1 = this.Aeh.aEc(str2);
                if ((str1 == null) || (str1.length() <= 0)) {
                  break label1041;
                }
                i = a(l2, str2, str1, l1) + 0;
                str1 = "";
                j = 131072;
                break;
                localObject1 = this.Aeh.h("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[] { str2 });
                k = i;
                if (((Cursor)localObject1).moveToFirst())
                {
                  localObject2 = ((Cursor)localObject1).getString(0);
                  this.HuM.a(j, 16, l2, str2, l1, (String)localObject2);
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
  
  public final String getName()
  {
    return "FTS5SearchContactLogic";
  }
  
  public final int i(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(52680);
    Object localObject = (String[])this.HuP.get(paramString);
    this.HuM.beginTransaction();
    int j;
    int i;
    if (localObject == null)
    {
      this.HuM.aEC(paramString);
      j = (int)this.HuM.HwB.simpleQueryForLong() + 0;
      i = j;
      if (paramArrayOfString != null)
      {
        this.HuM.j(paramString, paramArrayOfString);
        this.HuP.put(paramString, paramArrayOfString);
        i = j + paramArrayOfString.length;
      }
    }
    for (;;)
    {
      this.HuM.commit();
      AppMethodBeat.o(52680);
      return i;
      if (paramArrayOfString == null)
      {
        this.HuM.aEC(paramString);
        i = (int)this.HuM.HwB.simpleQueryForLong() + 0;
        this.HuP.remove(paramString);
      }
      else
      {
        localObject = new HashSet(Arrays.asList((Object[])localObject));
        int m = paramArrayOfString.length;
        j = 0;
        String str;
        int k;
        com.tencent.mm.plugin.fts.b.b localb;
        for (i = 0; j < m; i = k)
        {
          str = paramArrayOfString[j];
          k = i;
          if (!((HashSet)localObject).remove(str))
          {
            localb = this.HuM;
            localb.Hwv.bindString(1, paramString);
            localb.Hwv.bindString(2, str);
            localb.Hwv.execute();
            k = i + 1;
          }
          j += 1;
        }
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          localb = this.HuM;
          localb.Hww.bindString(1, paramString);
          localb.Hww.bindString(2, str);
          localb.Hww.execute();
          i += 1;
        }
        this.HuP.put(paramString, paramArrayOfString);
      }
    }
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(52677);
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
      AppMethodBeat.o(52677);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
    this.HuM = ((com.tencent.mm.plugin.fts.b.b)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3));
    this.msU = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.Aeh = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
    this.HuN = new HashSet();
    this.HuO = new HashMap();
    this.HuP = new HashMap();
    this.HuQ = new HashMap();
    try
    {
      this.HuR = az.class.getDeclaredMethod("parseBuff", new Class[0]);
      this.HuR.setAccessible(true);
      this.msU.a(131072, new f((byte)0));
      this.msU.a(131082, new a((byte)0));
      this.msU.a(131092, new b((byte)0));
      this.msU.a(2147483647, new c((byte)0));
      ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().add(this.HuE);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().add(this.HuT);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().add(this.HuS);
      MStorage.IOnStorageChange localIOnStorageChange = this.HuU;
      if (com.tencent.mm.av.b.oLo != null) {
        com.tencent.mm.av.b.oLo.a(localIOnStorageChange);
      }
      this.HuX.startTimer(600000L);
      this.HuV.alive();
      this.HuW.alive();
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
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private int Aeo = 0;
    private int Aep = 0;
    
    private a() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52642);
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
      Object localObject1 = new HashSet();
      Object localObject2 = b.a(b.this).HqR.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
      while (((Cursor)localObject2).moveToNext()) {
        ((HashSet)localObject1).add(((Cursor)localObject2).getString(0));
      }
      ((Cursor)localObject2).close();
      localObject2 = b.b(b.this).h("SELECT chatroomname, memberlist FROM chatroom;", null);
      int i = 5;
      int j;
      while (((Cursor)localObject2).moveToNext())
      {
        if (Thread.interrupted())
        {
          ((Cursor)localObject2).close();
          b.a(b.this).commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52642);
          throw ((Throwable)localObject1);
        }
        String str = ((Cursor)localObject2).getString(0);
        Object localObject3 = ((Cursor)localObject2).getString(1);
        if ((!Util.isNullOrNil((String)localObject3)) && (!Util.isNullOrNil(str)) && (b.aEv((String)localObject3)))
        {
          localObject3 = c.a.Hry.split((CharSequence)localObject3);
          b.f(b.this).put(str, localObject3);
          if (!((HashSet)localObject1).remove(str))
          {
            j = i;
            if (i >= 5)
            {
              b.a(b.this).commit();
              b.a(b.this).beginTransaction();
              j = 0;
            }
            b.a(b.this).j(str, (String[])localObject3);
            i = j + 1;
            this.Aeo += 1;
          }
        }
      }
      ((Cursor)localObject2).close();
      b.a(b.this).commit();
      localObject1 = ((HashSet)localObject1).iterator();
      for (i = 5; ((Iterator)localObject1).hasNext(); i = j + 1)
      {
        localObject2 = (String)((Iterator)localObject1).next();
        j = i;
        if (i >= 5)
        {
          b.a(b.this).commit();
          b.a(b.this).beginTransaction();
          j = 0;
        }
        b.a(b.this).aEC((String)localObject2);
        this.Aep += 1;
      }
      b.a(b.this).commit();
      AppMethodBeat.o(52642);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52643);
      String str = String.format("{new: %d removed: %d}", new Object[] { Integer.valueOf(this.Aeo), Integer.valueOf(this.Aep) });
      AppMethodBeat.o(52643);
      return str;
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
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private int HuH;
    private HashMap<String, List<Long>> Hvc;
    private HashSet<String> Hvd;
    private HashSet<String> Hve;
    private HashMap<String, au> Hvf;
    private long Hvg;
    private long Hvh;
    private int Hvi;
    private int Hvj;
    private int Hvk;
    private int Hvl;
    private int Hvm;
    private int Hvn;
    private int Hvo;
    
    private b()
    {
      AppMethodBeat.i(52645);
      this.Hvc = new HashMap();
      this.Hvd = new HashSet();
      this.Hvf = new HashMap();
      this.Hvg = -1L;
      this.Hvh = -1L;
      this.HuH = 0;
      this.Hvi = 0;
      this.Hvj = 0;
      this.Hvk = 0;
      this.Hvl = 0;
      AppMethodBeat.o(52645);
    }
    
    /* Error */
    public final boolean aXz()
    {
      // Byte code:
      //   0: ldc 86
      //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: ldc 88
      //   7: ldc 90
      //   9: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   12: aload_0
      //   13: ldc 97
      //   15: invokevirtual 101	com/tencent/mm/plugin/fts/logic/b$b:aEp	(Ljava/lang/String;)V
      //   18: aload_0
      //   19: getfield 103	com/tencent/mm/plugin/fts/logic/b$b:Hve	Ljava/util/HashSet;
      //   22: ifnonnull +224 -> 246
      //   25: aload_0
      //   26: new 53	java/util/HashSet
      //   29: dup
      //   30: invokespecial 54	java/util/HashSet:<init>	()V
      //   33: putfield 103	com/tencent/mm/plugin/fts/logic/b$b:Hve	Ljava/util/HashSet;
      //   36: aload_0
      //   37: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   40: invokestatic 107	com/tencent/mm/plugin/fts/logic/b:a	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/b/b;
      //   43: getstatic 113	com/tencent/mm/plugin/fts/a/c:Hrk	[I
      //   46: iconst_1
      //   47: iconst_0
      //   48: iconst_1
      //   49: iconst_0
      //   50: iconst_1
      //   51: invokevirtual 118	com/tencent/mm/plugin/fts/b/b:a	([IZZZZZ)Landroid/database/Cursor;
      //   54: astore 7
      //   56: aload 7
      //   58: invokeinterface 123 1 0
      //   63: ifeq +125 -> 188
      //   66: aload 7
      //   68: iconst_1
      //   69: invokeinterface 127 2 0
      //   74: astore 8
      //   76: aload 7
      //   78: iconst_2
      //   79: invokeinterface 131 2 0
      //   84: istore_1
      //   85: aload 7
      //   87: iconst_0
      //   88: invokeinterface 135 2 0
      //   93: lstore_3
      //   94: iload_1
      //   95: iconst_1
      //   96: if_icmpne +64 -> 160
      //   99: aload_0
      //   100: getfield 51	com/tencent/mm/plugin/fts/logic/b$b:Hvc	Ljava/util/HashMap;
      //   103: aload 8
      //   105: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   108: checkcast 141	java/util/List
      //   111: astore 6
      //   113: aload 6
      //   115: astore 5
      //   117: aload 6
      //   119: ifnonnull +26 -> 145
      //   122: new 143	java/util/ArrayList
      //   125: dup
      //   126: bipush 16
      //   128: invokespecial 145	java/util/ArrayList:<init>	(I)V
      //   131: astore 5
      //   133: aload_0
      //   134: getfield 51	com/tencent/mm/plugin/fts/logic/b$b:Hvc	Ljava/util/HashMap;
      //   137: aload 8
      //   139: aload 5
      //   141: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   144: pop
      //   145: aload 5
      //   147: lload_3
      //   148: invokestatic 155	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   151: invokeinterface 159 2 0
      //   156: pop
      //   157: goto -101 -> 56
      //   160: aload_0
      //   161: getfield 103	com/tencent/mm/plugin/fts/logic/b$b:Hve	Ljava/util/HashSet;
      //   164: aload 8
      //   166: invokevirtual 160	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   169: pop
      //   170: iload_1
      //   171: iconst_2
      //   172: if_icmpne -116 -> 56
      //   175: aload_0
      //   176: getfield 56	com/tencent/mm/plugin/fts/logic/b$b:Hvd	Ljava/util/HashSet;
      //   179: aload 8
      //   181: invokevirtual 160	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   184: pop
      //   185: goto -129 -> 56
      //   188: aload 7
      //   190: invokeinterface 163 1 0
      //   195: aload_0
      //   196: aload_0
      //   197: getfield 51	com/tencent/mm/plugin/fts/logic/b$b:Hvc	Ljava/util/HashMap;
      //   200: invokevirtual 167	java/util/HashMap:size	()I
      //   203: putfield 169	com/tencent/mm/plugin/fts/logic/b$b:Hvm	I
      //   206: aload_0
      //   207: aload_0
      //   208: getfield 56	com/tencent/mm/plugin/fts/logic/b$b:Hvd	Ljava/util/HashSet;
      //   211: invokevirtual 170	java/util/HashSet:size	()I
      //   214: putfield 172	com/tencent/mm/plugin/fts/logic/b$b:Hvn	I
      //   217: aload_0
      //   218: aload_0
      //   219: getfield 103	com/tencent/mm/plugin/fts/logic/b$b:Hve	Ljava/util/HashSet;
      //   222: invokevirtual 170	java/util/HashSet:size	()I
      //   225: putfield 174	com/tencent/mm/plugin/fts/logic/b$b:Hvo	I
      //   228: aload_0
      //   229: getfield 174	com/tencent/mm/plugin/fts/logic/b$b:Hvo	I
      //   232: iconst_5
      //   233: if_icmpge +13 -> 246
      //   236: aload_0
      //   237: aload_0
      //   238: getfield 177	com/tencent/mm/plugin/fts/a/a/c:Hst	J
      //   241: lconst_1
      //   242: lor
      //   243: putfield 177	com/tencent/mm/plugin/fts/a/a/c:Hst	J
      //   246: aload_0
      //   247: ldc 179
      //   249: invokevirtual 101	com/tencent/mm/plugin/fts/logic/b$b:aEp	(Ljava/lang/String;)V
      //   252: invokestatic 184	java/lang/Thread:interrupted	()Z
      //   255: ifeq +20 -> 275
      //   258: new 186	java/lang/InterruptedException
      //   261: dup
      //   262: invokespecial 187	java/lang/InterruptedException:<init>	()V
      //   265: astore 5
      //   267: ldc 86
      //   269: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   272: aload 5
      //   274: athrow
      //   275: aload_0
      //   276: getfield 51	com/tencent/mm/plugin/fts/logic/b$b:Hvc	Ljava/util/HashMap;
      //   279: invokevirtual 167	java/util/HashMap:size	()I
      //   282: ifle +76 -> 358
      //   285: new 143	java/util/ArrayList
      //   288: dup
      //   289: invokespecial 188	java/util/ArrayList:<init>	()V
      //   292: astore 5
      //   294: aload_0
      //   295: getfield 51	com/tencent/mm/plugin/fts/logic/b$b:Hvc	Ljava/util/HashMap;
      //   298: invokevirtual 192	java/util/HashMap:values	()Ljava/util/Collection;
      //   301: invokeinterface 198 1 0
      //   306: astore 6
      //   308: aload 6
      //   310: invokeinterface 203 1 0
      //   315: ifeq +24 -> 339
      //   318: aload 5
      //   320: aload 6
      //   322: invokeinterface 207 1 0
      //   327: checkcast 141	java/util/List
      //   330: invokeinterface 211 2 0
      //   335: pop
      //   336: goto -28 -> 308
      //   339: aload_0
      //   340: getfield 51	com/tencent/mm/plugin/fts/logic/b$b:Hvc	Ljava/util/HashMap;
      //   343: invokevirtual 214	java/util/HashMap:clear	()V
      //   346: aload_0
      //   347: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   350: invokestatic 107	com/tencent/mm/plugin/fts/logic/b:a	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/b/b;
      //   353: aload 5
      //   355: invokevirtual 218	com/tencent/mm/plugin/fts/b/b:hP	(Ljava/util/List;)V
      //   358: aload_0
      //   359: ldc 220
      //   361: invokevirtual 101	com/tencent/mm/plugin/fts/logic/b$b:aEp	(Ljava/lang/String;)V
      //   364: invokestatic 184	java/lang/Thread:interrupted	()Z
      //   367: ifeq +20 -> 387
      //   370: new 186	java/lang/InterruptedException
      //   373: dup
      //   374: invokespecial 187	java/lang/InterruptedException:<init>	()V
      //   377: astore 5
      //   379: ldc 86
      //   381: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   384: aload 5
      //   386: athrow
      //   387: aload_0
      //   388: getfield 56	com/tencent/mm/plugin/fts/logic/b$b:Hvd	Ljava/util/HashSet;
      //   391: invokevirtual 170	java/util/HashSet:size	()I
      //   394: ifle +72 -> 466
      //   397: aload_0
      //   398: getfield 56	com/tencent/mm/plugin/fts/logic/b$b:Hvd	Ljava/util/HashSet;
      //   401: invokevirtual 221	java/util/HashSet:iterator	()Ljava/util/Iterator;
      //   404: astore 5
      //   406: aload 5
      //   408: invokeinterface 203 1 0
      //   413: ifeq +46 -> 459
      //   416: aload 5
      //   418: invokeinterface 207 1 0
      //   423: checkcast 223	java/lang/String
      //   426: astore 6
      //   428: aload_0
      //   429: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   432: invokestatic 226	com/tencent/mm/plugin/fts/logic/b:b	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/a/j;
      //   435: aload 6
      //   437: invokeinterface 232 2 0
      //   442: lstore_3
      //   443: aload_0
      //   444: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   447: invokestatic 107	com/tencent/mm/plugin/fts/logic/b:a	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/b/b;
      //   450: aload 6
      //   452: lload_3
      //   453: invokevirtual 236	com/tencent/mm/plugin/fts/b/b:aG	(Ljava/lang/String;J)V
      //   456: goto -50 -> 406
      //   459: aload_0
      //   460: getfield 56	com/tencent/mm/plugin/fts/logic/b$b:Hvd	Ljava/util/HashSet;
      //   463: invokevirtual 237	java/util/HashSet:clear	()V
      //   466: aload_0
      //   467: ldc 239
      //   469: invokevirtual 101	com/tencent/mm/plugin/fts/logic/b$b:aEp	(Ljava/lang/String;)V
      //   472: invokestatic 184	java/lang/Thread:interrupted	()Z
      //   475: ifeq +20 -> 495
      //   478: new 186	java/lang/InterruptedException
      //   481: dup
      //   482: invokespecial 187	java/lang/InterruptedException:<init>	()V
      //   485: astore 5
      //   487: ldc 86
      //   489: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   492: aload 5
      //   494: athrow
      //   495: aload_0
      //   496: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   499: invokestatic 226	com/tencent/mm/plugin/fts/logic/b:b	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/a/j;
      //   502: ldc 241
      //   504: iconst_1
      //   505: anewarray 223	java/lang/String
      //   508: dup
      //   509: iconst_0
      //   510: aload_0
      //   511: getfield 62	com/tencent/mm/plugin/fts/logic/b$b:Hvg	J
      //   514: invokestatic 245	java/lang/Long:toString	(J)Ljava/lang/String;
      //   517: aastore
      //   518: invokeinterface 249 3 0
      //   523: astore 5
      //   525: bipush 50
      //   527: istore_1
      //   528: aload 5
      //   530: invokeinterface 123 1 0
      //   535: ifeq +376 -> 911
      //   538: invokestatic 184	java/lang/Thread:interrupted	()Z
      //   541: ifeq +37 -> 578
      //   544: aload 5
      //   546: invokeinterface 163 1 0
      //   551: aload_0
      //   552: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   555: invokestatic 107	com/tencent/mm/plugin/fts/logic/b:a	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/b/b;
      //   558: invokevirtual 252	com/tencent/mm/plugin/fts/b/b:commit	()V
      //   561: new 186	java/lang/InterruptedException
      //   564: dup
      //   565: invokespecial 187	java/lang/InterruptedException:<init>	()V
      //   568: astore 5
      //   570: ldc 86
      //   572: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   575: aload 5
      //   577: athrow
      //   578: aload 5
      //   580: iconst_0
      //   581: invokeinterface 135 2 0
      //   586: lstore_3
      //   587: aload_0
      //   588: lload_3
      //   589: putfield 62	com/tencent/mm/plugin/fts/logic/b$b:Hvg	J
      //   592: new 254	com/tencent/mm/storage/au
      //   595: dup
      //   596: invokespecial 255	com/tencent/mm/storage/au:<init>	()V
      //   599: astore 6
      //   601: aload 6
      //   603: lload_3
      //   604: putfield 258	com/tencent/mm/storage/au:maN	J
      //   607: aload 6
      //   609: aload 5
      //   611: iconst_1
      //   612: invokeinterface 127 2 0
      //   617: invokevirtual 261	com/tencent/mm/storage/au:setUsername	(Ljava/lang/String;)V
      //   620: aload 6
      //   622: aload 5
      //   624: iconst_2
      //   625: invokeinterface 127 2 0
      //   630: invokevirtual 264	com/tencent/mm/storage/au:AV	(Ljava/lang/String;)V
      //   633: aload 6
      //   635: aload 5
      //   637: iconst_3
      //   638: invokeinterface 127 2 0
      //   643: invokevirtual 267	com/tencent/mm/storage/au:AW	(Ljava/lang/String;)V
      //   646: aload 6
      //   648: aload 5
      //   650: iconst_4
      //   651: invokeinterface 127 2 0
      //   656: invokevirtual 270	com/tencent/mm/storage/au:setNickname	(Ljava/lang/String;)V
      //   659: aload 6
      //   661: aload 5
      //   663: iconst_5
      //   664: invokeinterface 131 2 0
      //   669: invokevirtual 273	com/tencent/mm/storage/au:pr	(I)V
      //   672: aload 6
      //   674: aload 5
      //   676: bipush 6
      //   678: invokeinterface 131 2 0
      //   683: invokevirtual 276	com/tencent/mm/storage/au:ru	(I)V
      //   686: aload 6
      //   688: aload 5
      //   690: bipush 7
      //   692: invokeinterface 280 2 0
      //   697: invokevirtual 284	com/tencent/mm/storage/au:ag	([B)V
      //   700: aload 6
      //   702: aload 5
      //   704: bipush 8
      //   706: invokeinterface 127 2 0
      //   711: invokevirtual 287	com/tencent/mm/storage/au:Be	(Ljava/lang/String;)V
      //   714: aload 6
      //   716: iconst_0
      //   717: invokevirtual 290	com/tencent/mm/storage/au:pt	(I)V
      //   720: aload_0
      //   721: getfield 58	com/tencent/mm/plugin/fts/logic/b$b:Hvf	Ljava/util/HashMap;
      //   724: aload 6
      //   726: getfield 296	com/tencent/mm/autogen/b/az:field_username	Ljava/lang/String;
      //   729: aload 6
      //   731: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   734: pop
      //   735: aload 6
      //   737: getfield 296	com/tencent/mm/autogen/b/az:field_username	Ljava/lang/String;
      //   740: invokestatic 300	com/tencent/mm/storage/au:bwE	(Ljava/lang/String;)Z
      //   743: ifne -215 -> 528
      //   746: aload_0
      //   747: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   750: aload 6
      //   752: invokevirtual 304	com/tencent/mm/plugin/fts/logic/b:ah	(Lcom/tencent/mm/storage/au;)Z
      //   755: ifeq -227 -> 528
      //   758: aload_0
      //   759: getfield 103	com/tencent/mm/plugin/fts/logic/b$b:Hve	Ljava/util/HashSet;
      //   762: aload 6
      //   764: getfield 296	com/tencent/mm/autogen/b/az:field_username	Ljava/lang/String;
      //   767: invokevirtual 307	java/util/HashSet:remove	(Ljava/lang/Object;)Z
      //   770: ifne -242 -> 528
      //   773: iload_1
      //   774: istore_2
      //   775: iload_1
      //   776: bipush 50
      //   778: if_icmplt +25 -> 803
      //   781: aload_0
      //   782: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   785: invokestatic 107	com/tencent/mm/plugin/fts/logic/b:a	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/b/b;
      //   788: invokevirtual 252	com/tencent/mm/plugin/fts/b/b:commit	()V
      //   791: aload_0
      //   792: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   795: invokestatic 107	com/tencent/mm/plugin/fts/logic/b:a	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/b/b;
      //   798: invokevirtual 310	com/tencent/mm/plugin/fts/b/b:beginTransaction	()V
      //   801: iconst_0
      //   802: istore_2
      //   803: iload_2
      //   804: istore_1
      //   805: aload 6
      //   807: getfield 296	com/tencent/mm/autogen/b/az:field_username	Ljava/lang/String;
      //   810: ldc_w 312
      //   813: invokevirtual 315	java/lang/String:endsWith	(Ljava/lang/String;)Z
      //   816: ifne +35 -> 851
      //   819: iload_2
      //   820: istore_1
      //   821: aload 6
      //   823: getfield 318	com/tencent/mm/autogen/b/az:field_verifyFlag	I
      //   826: invokestatic 321	com/tencent/mm/storage/au:iZH	()I
      //   829: iand
      //   830: ifne +21 -> 851
      //   833: iload_2
      //   834: istore_1
      //   835: aload_0
      //   836: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   839: aload 6
      //   841: invokevirtual 325	com/tencent/mm/plugin/fts/logic/b:af	(Lcom/tencent/mm/storage/au;)V
      //   844: iload_2
      //   845: istore_1
      //   846: aload 6
      //   848: invokevirtual 328	com/tencent/mm/storage/au:iZK	()V
      //   851: iload_2
      //   852: istore_1
      //   853: iload_2
      //   854: aload_0
      //   855: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   858: aload 6
      //   860: invokevirtual 332	com/tencent/mm/plugin/fts/logic/b:aj	(Lcom/tencent/mm/storage/au;)I
      //   863: iadd
      //   864: istore_2
      //   865: iload_2
      //   866: istore_1
      //   867: aload_0
      //   868: aload_0
      //   869: getfield 68	com/tencent/mm/plugin/fts/logic/b$b:Hvi	I
      //   872: iconst_1
      //   873: iadd
      //   874: putfield 68	com/tencent/mm/plugin/fts/logic/b$b:Hvi	I
      //   877: iload_2
      //   878: istore_1
      //   879: goto -351 -> 528
      //   882: astore 6
      //   884: ldc 88
      //   886: aload 6
      //   888: ldc_w 334
      //   891: iconst_0
      //   892: anewarray 336	java/lang/Object
      //   895: invokestatic 340	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   898: aload_0
      //   899: aload_0
      //   900: getfield 72	com/tencent/mm/plugin/fts/logic/b$b:Hvk	I
      //   903: iconst_1
      //   904: iadd
      //   905: putfield 72	com/tencent/mm/plugin/fts/logic/b$b:Hvk	I
      //   908: goto -380 -> 528
      //   911: aload 5
      //   913: invokeinterface 163 1 0
      //   918: aload_0
      //   919: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   922: invokestatic 107	com/tencent/mm/plugin/fts/logic/b:a	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/b/b;
      //   925: invokevirtual 252	com/tencent/mm/plugin/fts/b/b:commit	()V
      //   928: aload_0
      //   929: ldc_w 342
      //   932: invokevirtual 101	com/tencent/mm/plugin/fts/logic/b$b:aEp	(Ljava/lang/String;)V
      //   935: invokestatic 184	java/lang/Thread:interrupted	()Z
      //   938: ifeq +20 -> 958
      //   941: new 186	java/lang/InterruptedException
      //   944: dup
      //   945: invokespecial 187	java/lang/InterruptedException:<init>	()V
      //   948: astore 5
      //   950: ldc 86
      //   952: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   955: aload 5
      //   957: athrow
      //   958: aload_0
      //   959: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   962: invokestatic 226	com/tencent/mm/plugin/fts/logic/b:b	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/a/j;
      //   965: ldc_w 344
      //   968: iconst_1
      //   969: anewarray 223	java/lang/String
      //   972: dup
      //   973: iconst_0
      //   974: aload_0
      //   975: getfield 64	com/tencent/mm/plugin/fts/logic/b$b:Hvh	J
      //   978: invokestatic 245	java/lang/Long:toString	(J)Ljava/lang/String;
      //   981: aastore
      //   982: invokeinterface 249 3 0
      //   987: astore 6
      //   989: bipush 50
      //   991: istore_1
      //   992: aload 6
      //   994: invokeinterface 123 1 0
      //   999: ifeq +289 -> 1288
      //   1002: invokestatic 184	java/lang/Thread:interrupted	()Z
      //   1005: ifeq +37 -> 1042
      //   1008: aload 6
      //   1010: invokeinterface 163 1 0
      //   1015: aload_0
      //   1016: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   1019: invokestatic 107	com/tencent/mm/plugin/fts/logic/b:a	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/b/b;
      //   1022: invokevirtual 252	com/tencent/mm/plugin/fts/b/b:commit	()V
      //   1025: new 186	java/lang/InterruptedException
      //   1028: dup
      //   1029: invokespecial 187	java/lang/InterruptedException:<init>	()V
      //   1032: astore 5
      //   1034: ldc 86
      //   1036: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1039: aload 5
      //   1041: athrow
      //   1042: aload_0
      //   1043: aload 6
      //   1045: iconst_0
      //   1046: invokeinterface 135 2 0
      //   1051: putfield 64	com/tencent/mm/plugin/fts/logic/b$b:Hvh	J
      //   1054: aload 6
      //   1056: iconst_1
      //   1057: invokeinterface 127 2 0
      //   1062: astore 5
      //   1064: aload_0
      //   1065: getfield 103	com/tencent/mm/plugin/fts/logic/b$b:Hve	Ljava/util/HashSet;
      //   1068: aload 5
      //   1070: invokevirtual 307	java/util/HashSet:remove	(Ljava/lang/Object;)Z
      //   1073: ifne -81 -> 992
      //   1076: aload_0
      //   1077: getfield 58	com/tencent/mm/plugin/fts/logic/b$b:Hvf	Ljava/util/HashMap;
      //   1080: aload 5
      //   1082: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1085: checkcast 254	com/tencent/mm/storage/au
      //   1088: astore 7
      //   1090: aload 7
      //   1092: ifnonnull +16 -> 1108
      //   1095: aload_0
      //   1096: aload_0
      //   1097: getfield 74	com/tencent/mm/plugin/fts/logic/b$b:Hvl	I
      //   1100: iconst_1
      //   1101: iadd
      //   1102: putfield 74	com/tencent/mm/plugin/fts/logic/b$b:Hvl	I
      //   1105: goto -113 -> 992
      //   1108: aload 6
      //   1110: iconst_2
      //   1111: invokeinterface 127 2 0
      //   1116: astore 9
      //   1118: aload 9
      //   1120: invokestatic 347	com/tencent/mm/plugin/fts/logic/b:aEv	(Ljava/lang/String;)Z
      //   1123: ifne +16 -> 1139
      //   1126: aload_0
      //   1127: aload_0
      //   1128: getfield 74	com/tencent/mm/plugin/fts/logic/b$b:Hvl	I
      //   1131: iconst_1
      //   1132: iadd
      //   1133: putfield 74	com/tencent/mm/plugin/fts/logic/b$b:Hvl	I
      //   1136: goto -144 -> 992
      //   1139: aload 6
      //   1141: iconst_3
      //   1142: invokeinterface 280 2 0
      //   1147: astore 8
      //   1149: getstatic 353	com/tencent/mm/plugin/fts/a/c$a:Hry	Ljava/util/regex/Pattern;
      //   1152: aload 9
      //   1154: invokevirtual 359	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;)[Ljava/lang/String;
      //   1157: astore 9
      //   1159: aload 9
      //   1161: new 9	com/tencent/mm/plugin/fts/logic/b$b$1
      //   1164: dup
      //   1165: aload_0
      //   1166: invokespecial 362	com/tencent/mm/plugin/fts/logic/b$b$1:<init>	(Lcom/tencent/mm/plugin/fts/logic/b$b;)V
      //   1169: invokestatic 368	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
      //   1172: aload_0
      //   1173: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   1176: aload 5
      //   1178: aload 9
      //   1180: invokevirtual 371	com/tencent/mm/plugin/fts/logic/b:i	(Ljava/lang/String;[Ljava/lang/String;)I
      //   1183: istore_2
      //   1184: iload_1
      //   1185: iload_2
      //   1186: iadd
      //   1187: istore_1
      //   1188: aload_0
      //   1189: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   1192: aload 5
      //   1194: aload 7
      //   1196: aload 9
      //   1198: aload 8
      //   1200: aload_0
      //   1201: getfield 58	com/tencent/mm/plugin/fts/logic/b$b:Hvf	Ljava/util/HashMap;
      //   1204: invokevirtual 374	com/tencent/mm/plugin/fts/logic/b:a	(Ljava/lang/String;Lcom/tencent/mm/storage/au;[Ljava/lang/String;[BLjava/util/HashMap;)I
      //   1207: istore_2
      //   1208: iload_1
      //   1209: iload_2
      //   1210: iadd
      //   1211: istore_1
      //   1212: aload_0
      //   1213: aload_0
      //   1214: getfield 66	com/tencent/mm/plugin/fts/logic/b$b:HuH	I
      //   1217: iconst_1
      //   1218: iadd
      //   1219: putfield 66	com/tencent/mm/plugin/fts/logic/b$b:HuH	I
      //   1222: iload_1
      //   1223: istore_2
      //   1224: iload_2
      //   1225: istore_1
      //   1226: iload_2
      //   1227: bipush 50
      //   1229: if_icmplt -237 -> 992
      //   1232: aload_0
      //   1233: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   1236: invokestatic 107	com/tencent/mm/plugin/fts/logic/b:a	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/b/b;
      //   1239: invokevirtual 252	com/tencent/mm/plugin/fts/b/b:commit	()V
      //   1242: aload_0
      //   1243: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   1246: invokestatic 107	com/tencent/mm/plugin/fts/logic/b:a	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/b/b;
      //   1249: invokevirtual 310	com/tencent/mm/plugin/fts/b/b:beginTransaction	()V
      //   1252: iconst_0
      //   1253: istore_1
      //   1254: goto -262 -> 992
      //   1257: astore 5
      //   1259: ldc 88
      //   1261: aload 5
      //   1263: ldc_w 334
      //   1266: iconst_0
      //   1267: anewarray 336	java/lang/Object
      //   1270: invokestatic 340	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1273: aload_0
      //   1274: aload_0
      //   1275: getfield 74	com/tencent/mm/plugin/fts/logic/b$b:Hvl	I
      //   1278: iconst_1
      //   1279: iadd
      //   1280: putfield 74	com/tencent/mm/plugin/fts/logic/b$b:Hvl	I
      //   1283: iload_1
      //   1284: istore_2
      //   1285: goto -61 -> 1224
      //   1288: aload 6
      //   1290: invokeinterface 163 1 0
      //   1295: aload_0
      //   1296: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   1299: invokestatic 107	com/tencent/mm/plugin/fts/logic/b:a	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/b/b;
      //   1302: invokevirtual 252	com/tencent/mm/plugin/fts/b/b:commit	()V
      //   1305: aload_0
      //   1306: ldc_w 376
      //   1309: invokevirtual 101	com/tencent/mm/plugin/fts/logic/b$b:aEp	(Ljava/lang/String;)V
      //   1312: invokestatic 184	java/lang/Thread:interrupted	()Z
      //   1315: ifeq +20 -> 1335
      //   1318: new 186	java/lang/InterruptedException
      //   1321: dup
      //   1322: invokespecial 187	java/lang/InterruptedException:<init>	()V
      //   1325: astore 5
      //   1327: ldc 86
      //   1329: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1332: aload 5
      //   1334: athrow
      //   1335: aload_0
      //   1336: aload_0
      //   1337: getfield 103	com/tencent/mm/plugin/fts/logic/b$b:Hve	Ljava/util/HashSet;
      //   1340: invokevirtual 170	java/util/HashSet:size	()I
      //   1343: putfield 70	com/tencent/mm/plugin/fts/logic/b$b:Hvj	I
      //   1346: aload_0
      //   1347: getfield 103	com/tencent/mm/plugin/fts/logic/b$b:Hve	Ljava/util/HashSet;
      //   1350: invokevirtual 221	java/util/HashSet:iterator	()Ljava/util/Iterator;
      //   1353: astore 5
      //   1355: aload 5
      //   1357: invokeinterface 203 1 0
      //   1362: ifeq +53 -> 1415
      //   1365: aload 5
      //   1367: invokeinterface 207 1 0
      //   1372: checkcast 223	java/lang/String
      //   1375: astore 6
      //   1377: aload_0
      //   1378: getfield 36	com/tencent/mm/plugin/fts/logic/b$b:Hva	Lcom/tencent/mm/plugin/fts/logic/b;
      //   1381: invokestatic 107	com/tencent/mm/plugin/fts/logic/b:a	(Lcom/tencent/mm/plugin/fts/logic/b;)Lcom/tencent/mm/plugin/fts/b/b;
      //   1384: getstatic 113	com/tencent/mm/plugin/fts/a/c:Hrk	[I
      //   1387: aload 6
      //   1389: invokevirtual 379	com/tencent/mm/plugin/fts/b/b:b	([ILjava/lang/String;)V
      //   1392: ldc_w 381
      //   1395: invokestatic 387	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   1398: checkcast 381	com/tencent/mm/plugin/fts/PluginFTS
      //   1401: invokevirtual 391	com/tencent/mm/plugin/fts/PluginFTS:getTopHitsLogic	()Lcom/tencent/mm/plugin/fts/logic/g;
      //   1404: getstatic 113	com/tencent/mm/plugin/fts/a/c:Hrk	[I
      //   1407: aload 6
      //   1409: invokevirtual 396	com/tencent/mm/plugin/fts/logic/g:d	([ILjava/lang/String;)V
      //   1412: goto -57 -> 1355
      //   1415: aload_0
      //   1416: getfield 103	com/tencent/mm/plugin/fts/logic/b$b:Hve	Ljava/util/HashSet;
      //   1419: invokevirtual 237	java/util/HashSet:clear	()V
      //   1422: aload_0
      //   1423: getfield 58	com/tencent/mm/plugin/fts/logic/b$b:Hvf	Ljava/util/HashMap;
      //   1426: invokevirtual 214	java/util/HashMap:clear	()V
      //   1429: aload_0
      //   1430: ldc_w 398
      //   1433: invokevirtual 101	com/tencent/mm/plugin/fts/logic/b$b:aEp	(Ljava/lang/String;)V
      //   1436: ldc 86
      //   1438: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1441: iconst_1
      //   1442: ireturn
      //   1443: astore 5
      //   1445: goto -186 -> 1259
      //   1448: astore 5
      //   1450: goto -191 -> 1259
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1453	0	this	b
      //   84	1200	1	i	int
      //   774	511	2	j	int
      //   93	511	3	l	long
      //   115	1078	5	localObject1	Object
      //   1257	5	5	localException1	Exception
      //   1325	41	5	localObject2	Object
      //   1443	1	5	localException2	Exception
      //   1448	1	5	localException3	Exception
      //   111	748	6	localObject3	Object
      //   882	5	6	localException4	Exception
      //   987	421	6	localObject4	Object
      //   54	1141	7	localObject5	Object
      //   74	1125	8	localObject6	Object
      //   1116	81	9	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   805	819	882	java/lang/Exception
      //   821	833	882	java/lang/Exception
      //   835	844	882	java/lang/Exception
      //   846	851	882	java/lang/Exception
      //   853	865	882	java/lang/Exception
      //   867	877	882	java/lang/Exception
      //   1149	1184	1257	java/lang/Exception
      //   1188	1208	1443	java/lang/Exception
      //   1212	1222	1448	java/lang/Exception
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52647);
      String str = String.format("{build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, failContact: %d, failChatroom}", new Object[] { Integer.valueOf(this.Hvo), Integer.valueOf(this.Hvi), Integer.valueOf(this.HuH), Integer.valueOf(this.Hvj), Integer.valueOf(this.Hvm), Integer.valueOf(this.Hvn), Integer.valueOf(this.Hvk), Integer.valueOf(this.Hvl) });
      AppMethodBeat.o(52647);
      return str;
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
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private c() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52648);
      b.a(b.this).F(com.tencent.mm.plugin.fts.a.c.Hri);
      AppMethodBeat.o(52648);
      return true;
    }
    
    public final String getName()
    {
      return "DeleteAllFriendTask";
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private int Hvq = 0;
    private String luk;
    
    public d(String paramString)
    {
      this.luk = paramString;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52649);
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", new Object[] { this.luk });
      b.a(b.this).b(com.tencent.mm.plugin.fts.a.c.Hrk, this.luk);
      ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getTopHitsLogic().d(com.tencent.mm.plugin.fts.a.c.Hrk, this.luk);
      Object localObject1 = b.a(b.this).aEB(this.luk);
      Object localObject2 = new HashSet();
      while (((Cursor)localObject1).moveToNext()) {
        ((HashSet)localObject2).add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
      localObject1 = ((HashSet)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!b.c(b.this).containsKey(localObject2))
        {
          List localList = b.a(b.this).c(com.tencent.mm.plugin.fts.a.c.Hrk, (String)localObject2);
          b.c(b.this).put(localObject2, localList);
          ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getTopHitsLogic().aEz((String)localObject2);
          this.Hvq += 1;
        }
      }
      AppMethodBeat.o(52649);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52650);
      String str = String.format("{username: %s mDirtyCount: %d}", new Object[] { this.luk, Integer.valueOf(this.Hvq) });
      AppMethodBeat.o(52650);
      return str;
    }
    
    public final String getName()
    {
      return "DeleteContactTask";
    }
  }
  
  final class e
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private String luk;
    private boolean mtl = false;
    
    public e(String paramString)
    {
      this.luk = paramString;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52651);
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", new Object[] { this.luk });
      au localau = b.b(b.this).aEa(this.luk);
      if ((localau != null) && (localau.field_username.length() > 0) && (b.this.ah(localau))) {
        b.this.ai(localau);
      }
      for (;;)
      {
        b.c(b.this).remove(this.luk);
        b.d(b.this).remove(this.luk);
        AppMethodBeat.o(52651);
        return true;
        this.mtl = true;
      }
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52652);
      String str = String.format("{username: %s isSkipped: %b}", new Object[] { this.luk, Boolean.valueOf(this.mtl) });
      AppMethodBeat.o(52652);
      return str;
    }
    
    public final String getName()
    {
      return "InsertContactTask";
    }
  }
  
  final class f
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private int Hvr = 0;
    private int Hvs = 0;
    
    private f() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52653);
      Cursor localCursor = b.a(b.this).HqR.rawQuery("SELECT user, label_id FROM FTS5ContactLabels;", null);
      while (localCursor.moveToNext())
      {
        String str = localCursor.getString(0);
        long l = localCursor.getLong(1);
        List localList = (List)b.g(b.this).get(str);
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new ArrayList(16);
          b.g(b.this).put(str, localObject);
          this.Hvr += 1;
        }
        ((List)localObject).add(Long.valueOf(l));
        this.Hvs += 1;
      }
      localCursor.close();
      AppMethodBeat.o(52653);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52654);
      String str = String.format("{users: %d labels: %d}", new Object[] { Integer.valueOf(this.Hvr), Integer.valueOf(this.Hvs) });
      AppMethodBeat.o(52654);
      return str;
    }
    
    public final String getName()
    {
      return "LoadLabelCacheTask";
    }
  }
  
  final class g
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private int AnY = 0;
    private int[] Hvt;
    private int Hvu = 0;
    
    public g(int[] paramArrayOfInt)
    {
      this.Hvt = paramArrayOfInt;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52655);
      Object localObject = b.a(b.this).w(this.Hvt, 1);
      this.AnY = ((List)localObject).size();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.fts.a.a.d locald = (com.tencent.mm.plugin.fts.a.a.d)localIterator.next();
        String str = locald.Hsz;
        if (!b.c(b.this).containsKey(str))
        {
          List localList = (List)localHashMap.get(str);
          localObject = localList;
          if (localList == null)
          {
            localObject = new ArrayList(16);
            localHashMap.put(str, localObject);
          }
          ((List)localObject).add(Long.valueOf(locald.Hsy));
        }
      }
      b.c(b.this).putAll(localHashMap);
      this.Hvu = localHashMap.size();
      AppMethodBeat.o(52655);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52656);
      String str = String.format("{touched: %d users: %d}", new Object[] { Integer.valueOf(this.AnY), Integer.valueOf(this.Hvu) });
      AppMethodBeat.o(52656);
      return str;
    }
    
    public final String getName()
    {
      return "MarkAllContactDirtyTask";
    }
  }
  
  final class h
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private boolean Hvv = false;
    private String luk;
    private boolean mtl = false;
    
    public h(String paramString)
    {
      this.luk = paramString;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52657);
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", new Object[] { this.luk });
      if (b.c(b.this).containsKey(this.luk))
      {
        this.Hvv = true;
        AppMethodBeat.o(52657);
        return true;
      }
      b.a(b.this).aEe(this.luk);
      Object localObject1 = b.a(b.this).c(com.tencent.mm.plugin.fts.a.c.Hrk, this.luk);
      b.c(b.this).put(this.luk, localObject1);
      if (((List)localObject1).isEmpty())
      {
        this.mtl = true;
        b.e(b.this).a(65556, new b.e(b.this, this.luk));
        AppMethodBeat.o(52657);
        return true;
      }
      localObject1 = b.a(b.this).aEB(this.luk);
      Object localObject2 = new HashSet();
      while (((Cursor)localObject1).moveToNext()) {
        ((HashSet)localObject2).add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
      localObject1 = ((HashSet)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        b.a(b.this).aEe((String)localObject2);
        if (!b.c(b.this).containsKey(localObject2))
        {
          List localList = b.a(b.this).c(com.tencent.mm.plugin.fts.a.c.Hrk, (String)localObject2);
          b.c(b.this).put(localObject2, localList);
        }
      }
      b.d(b.this).remove(this.luk);
      ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getTopHitsLogic().aEz(this.luk);
      AppMethodBeat.o(52657);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52658);
      String str = String.format("{username: %s cached: %b isSkipped: %b}", new Object[] { this.luk, Boolean.valueOf(this.Hvv), Boolean.valueOf(this.mtl) });
      AppMethodBeat.o(52658);
      return str;
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
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private boolean Hvw;
    private String username;
    
    public i(String paramString)
    {
      this.username = paramString;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52659);
      if (b.c(b.this).containsKey(this.username))
      {
        this.Hvw = true;
        AppMethodBeat.o(52659);
        return true;
      }
      if (!b.d(b.this).add(this.username))
      {
        this.Hvw = true;
        AppMethodBeat.o(52659);
        return true;
      }
      Object localObject = b.b(b.this).aEa(this.username);
      if ((localObject != null) && (!b.this.ah((au)localObject)))
      {
        this.Hvw = true;
        AppMethodBeat.o(52659);
        return true;
      }
      localObject = b.a(b.this);
      String str = this.username;
      ((com.tencent.mm.plugin.fts.a.a)localObject).HqX.bindLong(1, 2L);
      ((com.tencent.mm.plugin.fts.a.a)localObject).HqX.bindString(2, str);
      ((com.tencent.mm.plugin.fts.a.a)localObject).HqX.bindLong(3, 0L);
      ((com.tencent.mm.plugin.fts.a.a)localObject).HqX.execute();
      AppMethodBeat.o(52659);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52660);
      String str = String.format("{username: %s isSkipped: %b}", new Object[] { this.username, Boolean.valueOf(this.Hvw) });
      AppMethodBeat.o(52660);
      return str;
    }
    
    public final String getName()
    {
      return "MarkContactTimestampTask";
    }
  }
  
  final class j
    extends k
  {
    public j(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52661);
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.cc(this.Htr.query, true);
      Object localObject1 = b.a(b.this).a(paramm.FWt, this.Htr.Htx, this.Htr.Hty, true, true);
      Object localObject2 = new HashMap();
      HashMap localHashMap = new HashMap();
      while (((Cursor)localObject1).moveToNext())
      {
        p localp = new p().l((Cursor)localObject1);
        if (!this.Htr.HtA.contains(localp.Hsz))
        {
          com.tencent.mm.plugin.fts.a.a.o localo;
          if (com.tencent.mm.plugin.fts.a.d.x(com.tencent.mm.plugin.fts.a.c.Hrk, localp.type))
          {
            localo = (com.tencent.mm.plugin.fts.a.a.o)((HashMap)localObject2).get(localp.Hsz);
            if ((localo == null) || (com.tencent.mm.plugin.fts.a.d.j(com.tencent.mm.plugin.fts.a.c.Hrv, localp.subtype, localo.subtype) < 0)) {
              ((HashMap)localObject2).put(localp.Hsz, localp);
            }
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramm = new InterruptedException();
            AppMethodBeat.o(52661);
            throw paramm;
            if (com.tencent.mm.plugin.fts.a.d.x(com.tencent.mm.plugin.fts.a.c.Hrm, localp.type))
            {
              localo = (com.tencent.mm.plugin.fts.a.a.o)localHashMap.get(Long.valueOf(localp.HtI));
              if ((localo == null) || (com.tencent.mm.plugin.fts.a.d.j(com.tencent.mm.plugin.fts.a.c.Hrv, localp.subtype, localo.subtype) < 0)) {
                localHashMap.put(Long.valueOf(localp.HtI), localp);
              }
            }
          }
        }
      }
      ((Cursor)localObject1).close();
      if (Thread.interrupted())
      {
        paramm = new InterruptedException();
        AppMethodBeat.o(52661);
        throw paramm;
      }
      paramm.HtF = new ArrayList(((HashMap)localObject2).size());
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (p)((Iterator)localObject1).next();
        ((p)localObject2).fxB();
        ((p)localObject2).a(paramm.FWt);
        paramm.HtF.add(localObject2);
      }
      paramm.HtF.addAll(localHashMap.values());
      if (Thread.interrupted())
      {
        paramm = new InterruptedException();
        AppMethodBeat.o(52661);
        throw paramm;
      }
      if (this.Htr.HtB != null) {
        Collections.sort(paramm.HtF, this.Htr.HtB);
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
    extends k
  {
    public k(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52662);
      super.a(paramm);
      Object localObject1 = b.a(b.this);
      Object localObject2 = this.Htr.query;
      String str = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075 ORDER BY timestamp desc", new Object[] { ((com.tencent.mm.plugin.fts.b.b)localObject1).fxn() });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).HqR.rawQuery(str, new String[] { localObject2 });
      paramm.HtF = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.o();
        ((com.tencent.mm.plugin.fts.a.a.o)localObject2).Hsz = ((Cursor)localObject1).getString(0);
        paramm.HtF.add(localObject2);
      }
      ((Cursor)localObject1).close();
      paramm.resultCode = 0;
      AppMethodBeat.o(52662);
    }
    
    public final String getName()
    {
      return "SearchChatroomByMemberTask";
    }
  }
  
  final class l
    extends k
  {
    public l(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      int i = 0;
      AppMethodBeat.i(52663);
      super.a(paramm);
      Object localObject = b.a(b.this);
      String str1 = this.Htr.query;
      String str2 = String.format("SELECT count(aux_index) FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075", new Object[] { ((com.tencent.mm.plugin.fts.b.b)localObject).fxn() });
      localObject = ((com.tencent.mm.plugin.fts.a.a)localObject).HqR.rawQuery(str2, new String[] { str1 });
      if (((Cursor)localObject).moveToNext()) {
        i = ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
      localObject = new com.tencent.mm.plugin.fts.a.a.o();
      ((com.tencent.mm.plugin.fts.a.a.o)localObject).HtQ = Integer.valueOf(i);
      paramm.HtF = new ArrayList();
      paramm.HtF.add(localObject);
      AppMethodBeat.o(52663);
    }
    
    public final String getName()
    {
      return "SearchChatroomCountTask";
    }
  }
  
  final class m
    extends k
  {
    public m(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52664);
      super.a(paramm);
      Object localObject1 = b.a(b.this);
      Object localObject2 = this.Htr.Htv;
      Object localObject3 = paramm.FWt.fxx();
      localObject3 = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN (SELECT docid, aux_index, timestamp FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=?) as temp ON (%s.rowid = temp.docid) WHERE %s MATCH '%s' ORDER BY -timestamp;", new Object[] { ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).HqR.rawQuery((String)localObject3, new String[] { localObject2 });
      localObject2 = new HashSet();
      paramm.HtF = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.fts.a.a.o();
        ((com.tencent.mm.plugin.fts.a.a.o)localObject3).Hsz = ((Cursor)localObject1).getString(0);
        if (((HashSet)localObject2).add(((com.tencent.mm.plugin.fts.a.a.o)localObject3).Hsz)) {
          paramm.HtF.add(localObject3);
        }
      }
      ((Cursor)localObject1).close();
      paramm.resultCode = 0;
      AppMethodBeat.o(52664);
    }
    
    public final String getName()
    {
      return "SearchChatroomInMemberTask";
    }
  }
  
  public final class n
    extends k
  {
    public n(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      Object localObject1 = null;
      AppMethodBeat.i(265462);
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.cc(this.Htr.query, true);
      paramm.HtF = new ArrayList();
      Object localObject2 = b.a(b.this);
      Object localObject3 = this.Htr.Htv;
      Object localObject4 = paramm.FWt.fxx();
      localObject4 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMChatroomMember(%s) AS Offsets FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 AND subtype = 38 AND aux_index = ? ;", new Object[] { ((com.tencent.mm.plugin.fts.b.b)localObject2).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxo(), localObject4 });
      localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject2).HqR.rawQuery((String)localObject4, new String[] { localObject3 });
      if (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new p().l((Cursor)localObject2);
        ((p)localObject3).fxB();
        paramm.HtF.add(localObject3);
      }
      ((Cursor)localObject2).close();
      localObject2 = com.tencent.mm.kernel.h.baE().mCN.rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { this.Htr.Htv }, 2);
      if (((Cursor)localObject2).moveToFirst())
      {
        localObject3 = ((Cursor)localObject2).getString(0);
        if (localObject3 != null) {}
      }
      for (;;)
      {
        ((Cursor)localObject2).close();
        localObject3 = new HashSet(this.Htr.HtA);
        localObject4 = new ArrayList();
        Arrays.sort((Object[])localObject1, new Comparator() {});
        Iterator localIterator;
        if ((localObject1 != null) && (!paramm.HtF.isEmpty()) && (((com.tencent.mm.plugin.fts.a.a.o)paramm.HtF.get(0)).HtP != null)) {
          localIterator = ((com.tencent.mm.plugin.fts.a.a.o)paramm.HtF.get(0)).HtP.iterator();
        }
        label774:
        label775:
        for (;;)
        {
          label352:
          i locali;
          String str1;
          if (localIterator.hasNext())
          {
            locali = (i)localIterator.next();
            if (locali.HsY >= localObject1.length) {
              continue;
            }
            str1 = localObject1[locali.HsY];
            if (Util.isNullOrNil(str1)) {
              continue;
            }
            locali.username = str1;
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxw(str1);
            if (localObject2 != null) {
              break label774;
            }
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxv(str1);
          }
          for (;;)
          {
            if (localObject2 == null) {
              break label775;
            }
            String str2 = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).b((au)localObject2, str1);
            switch (locali.subtype)
            {
            }
            for (;;)
            {
              if (Util.isNullOrNil(locali.Hta)) {
                break label735;
              }
              if (locali.Hta.contains(paramm.FWt.Hte)) {
                locali.Htc += 10;
              }
              if (!((HashSet)localObject3).add(str1)) {
                break label352;
              }
              ((List)localObject4).add(locali);
              break label352;
              localObject1 = c.a.Hry.split((CharSequence)localObject3);
              break;
              locali.Hta = com.tencent.mm.plugin.fts.a.d.iC(str1, ((au)localObject2).aJs());
              locali.Htb = str2;
              continue;
              locali.Htd = true;
              locali.HsH = true;
              locali.Hta = ((az)localObject2).field_nickname;
              if (!((az)localObject2).field_nickname.equals(str2))
              {
                locali.Htb = str2;
                continue;
                locali.Htd = true;
                locali.HsH = true;
                locali.Hta = str2;
                continue;
                locali.Hta = locali.content;
                locali.Htb = str2;
                continue;
                locali.Hta = ((az)localObject2).kal;
                locali.Htb = str2;
              }
            }
            label735:
            break label352;
            Collections.sort((List)localObject4, new Comparator() {});
            ((com.tencent.mm.plugin.fts.a.a.o)paramm.HtF.get(0)).HtP = ((List)localObject4);
            AppMethodBeat.o(265462);
            return;
          }
        }
        localObject1 = null;
      }
    }
    
    public final String getName()
    {
      return "SearchChatroomMemberTask";
    }
  }
  
  final class o
    extends k
  {
    public o(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52665);
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.cc(this.Htr.query, true);
      Object localObject2 = b.a(b.this).a(paramm.FWt, new int[] { 131075 }, null, true, true);
      Object localObject1 = new HashMap();
      Object localObject4;
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new p().l((Cursor)localObject2);
        if (!this.Htr.HtA.contains(((p)localObject3).Hsz))
        {
          localObject4 = (com.tencent.mm.plugin.fts.a.a.o)((HashMap)localObject1).get(((p)localObject3).Hsz);
          if ((localObject4 == null) || (com.tencent.mm.plugin.fts.a.d.j(com.tencent.mm.plugin.fts.a.c.Hrv, ((p)localObject3).subtype, ((com.tencent.mm.plugin.fts.a.a.o)localObject4).subtype) < 0)) {
            ((HashMap)localObject1).put(((p)localObject3).Hsz, localObject3);
          }
          if (Thread.interrupted())
          {
            ((Cursor)localObject2).close();
            paramm = new InterruptedException();
            AppMethodBeat.o(52665);
            throw paramm;
          }
        }
      }
      ((Cursor)localObject2).close();
      localObject2 = new ArrayList(((HashMap)localObject1).size());
      Object localObject3 = ((HashMap)localObject1).values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (p)((Iterator)localObject3).next();
        ((p)localObject4).fxB();
        ((p)localObject4).a(paramm.FWt);
        ((ArrayList)localObject2).add(localObject4);
        if (Thread.interrupted())
        {
          paramm = new InterruptedException();
          AppMethodBeat.o(52665);
          throw paramm;
        }
      }
      if (this.Htr.HtB != null) {
        Collections.sort((List)localObject2, this.Htr.HtB);
      }
      paramm.HtF = new ArrayList(((HashMap)localObject1).size());
      localObject1 = new StringBuffer();
      int i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        localObject3 = (com.tencent.mm.plugin.fts.a.a.o)((ArrayList)localObject2).get(i);
        ((StringBuffer)localObject1).append(((com.tencent.mm.plugin.fts.a.a.o)localObject3).Htc);
        ((StringBuffer)localObject1).append("|");
        ((StringBuffer)localObject1).append(((com.tencent.mm.plugin.fts.a.a.o)localObject3).timestamp);
        ((StringBuffer)localObject1).append(" ");
        paramm.HtF.add(localObject3);
        if (i >= this.Htr.Htz) {
          break;
        }
        i += 1;
      }
      if ((paramm.FWt.Hti.size() > 1) && (b.a(b.this).b(paramm.FWt)))
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.o();
        ((com.tencent.mm.plugin.fts.a.a.o)localObject2).Hsz = "create_chatroom​";
        paramm.HtF.add(0, localObject2);
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
    extends k
  {
    public p(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52666);
      Object localObject2 = Util.stringsToList(this.Htr.query.split(","));
      Object localObject1 = b.a(b.this);
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
      localObject2 = String.format("SELECT member, chatroom, entity_id FROM FTS5ChatRoomMembers, %s WHERE %s AND chatroom = aux_index", new Object[] { ((com.tencent.mm.plugin.fts.b.b)localObject1).fxn(), ((StringBuffer)localObject3).toString() });
      localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject1).HqR.rawQuery((String)localObject2, null);
      localObject2 = new HashMap();
      if (((Cursor)localObject3).moveToNext())
      {
        String str = ((Cursor)localObject3).getString(0);
        if (((HashMap)localObject2).containsKey(str)) {}
        for (localObject1 = (List)((HashMap)localObject2).get(str);; localObject1 = new ArrayList())
        {
          com.tencent.mm.plugin.fts.a.a.o localo = new com.tencent.mm.plugin.fts.a.a.o();
          localo.Hsz = ((Cursor)localObject3).getString(1);
          localo.HtI = ((Cursor)localObject3).getLong(2);
          ((List)localObject1).add(localo);
          ((HashMap)localObject2).put(str, localObject1);
          break;
        }
      }
      ((Cursor)localObject3).close();
      paramm.HtF = new ArrayList();
      localObject1 = new com.tencent.mm.plugin.fts.a.a.o();
      ((com.tencent.mm.plugin.fts.a.a.o)localObject1).HtQ = localObject2;
      paramm.HtF.add(localObject1);
      AppMethodBeat.o(52666);
    }
    
    public final String getName()
    {
      return "SearchCommonChatroomTask";
    }
  }
  
  public final class q
    extends k
  {
    public q(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52667);
      long l = Long.valueOf(this.Htr.query).longValue();
      Object localObject1 = b.a(b.this);
      Object localObject2 = String.format("SELECT distinct(aux_index) FROM %s WHERE timestamp < %d AND type = %d", new Object[] { ((com.tencent.mm.plugin.fts.b.b)localObject1).fxn(), Long.valueOf(l), Integer.valueOf(131072) });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).HqR.rawQuery((String)localObject2, null);
      paramm.HtF = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.o();
        ((com.tencent.mm.plugin.fts.a.a.o)localObject2).Hsz = ((Cursor)localObject1).getString(0);
        paramm.HtF.add(localObject2);
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
    extends k
  {
    public r(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52668);
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.cc(this.Htr.query, true);
      Object localObject2 = b.a(b.this);
      Object localObject3 = paramm.FWt;
      Object localObject1 = this.Htr.Htx;
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.j)localObject3).fxx();
      int i;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject1 = " AND type IN " + com.tencent.mm.plugin.fts.a.d.G((int[])localObject1);
        long l = ((com.tencent.mm.plugin.fts.a.a.j)localObject3).Hti.size();
        localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject1 + " AND status >= 0 ORDER BY subtype;", new Object[] { ((com.tencent.mm.plugin.fts.b.b)localObject2).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxo(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxo(), localObject4 });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).HqR.rawQuery((String)localObject1, null);
        localObject2 = new ArrayList();
        localObject3 = new HashSet();
        ((HashSet)localObject3).addAll(this.Htr.HtA);
        i = 0;
      }
      label397:
      for (;;)
      {
        if (!((Cursor)localObject1).moveToNext()) {
          break label399;
        }
        if (((HashSet)localObject3).add(((Cursor)localObject1).getString(4)))
        {
          localObject4 = new p().l((Cursor)localObject1);
          if (i >= ((p)localObject4).subtype) {
            ((List)localObject2).add(localObject4);
          }
          for (;;)
          {
            if (!Thread.interrupted()) {
              break label397;
            }
            ((Cursor)localObject1).close();
            paramm = new InterruptedException("Task is Cancel: " + this.Htr.query);
            AppMethodBeat.o(52668);
            throw paramm;
            localObject1 = "";
            break;
            if (((List)localObject2).size() > this.Htr.Htz) {
              break label399;
            }
            i = ((p)localObject4).subtype;
            ((List)localObject2).add(localObject4);
          }
        }
      }
      label399:
      ((Cursor)localObject1).close();
      paramm.HtF = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (p)((Iterator)localObject1).next();
        ((p)localObject2).fxB();
        ((p)localObject2).a(paramm.FWt);
        paramm.HtF.add(localObject2);
      }
      if (this.Htr.HtB != null) {
        Collections.sort(paramm.HtF, this.Htr.HtB);
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
    extends k
  {
    public s(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52669);
      aEp("start");
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.cc(this.Htr.query, true);
      Object localObject1 = b.a(b.this);
      Object localObject2 = paramm.FWt;
      Object localObject3 = ((com.tencent.mm.plugin.fts.a.a.j)localObject2).fxx();
      long l1 = System.currentTimeMillis();
      long l2 = ((com.tencent.mm.plugin.fts.a.a.j)localObject2).Hti.size();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) AS Offsets, MMChatroomRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, entity_id, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 ORDER BY Rank, timestamp desc ;", new Object[] { ((com.tencent.mm.plugin.fts.b.b)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), Long.valueOf(l1 - 1209600000L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).HqR.rawQuery((String)localObject3, new String[] { ((com.tencent.mm.plugin.fts.a.a.j)localObject2).Htf });
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.Htr.HtA);
      while (((Cursor)localObject1).moveToNext())
      {
        p localp = new p().k((Cursor)localObject1);
        if (((HashSet)localObject3).add(localp.Hsz)) {
          if (((List)localObject2).size() <= this.Htr.Htz)
          {
            ((List)localObject2).add(localp);
            if (Thread.interrupted())
            {
              ((Cursor)localObject1).close();
              paramm = new InterruptedException("Task is Cancel: " + this.Htr.query);
              AppMethodBeat.o(52669);
              throw paramm;
            }
          }
        }
      }
      ((Cursor)localObject1).close();
      if (Thread.interrupted())
      {
        paramm = new InterruptedException();
        AppMethodBeat.o(52669);
        throw paramm;
      }
      aEp("orm");
      paramm.HtF = new ArrayList(((List)localObject2).size());
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (p)((Iterator)localObject1).next();
        ((p)localObject2).fxB();
        ((p)localObject2).a(paramm.FWt);
        paramm.HtF.add(localObject2);
      }
      if (Thread.interrupted())
      {
        paramm = new InterruptedException();
        AppMethodBeat.o(52669);
        throw paramm;
      }
      if (this.Htr.HtB != null) {
        Collections.sort(paramm.HtF, this.Htr.HtB);
      }
      aEp("calOffsets");
      if ((paramm.FWt.Hti.size() > 1) && (b.a(b.this).b(paramm.FWt)))
      {
        localObject1 = new com.tencent.mm.plugin.fts.a.a.o();
        ((com.tencent.mm.plugin.fts.a.a.o)localObject1).Hsz = "create_chatroom​";
        if (paramm.HtF.size() <= 3) {
          break label599;
        }
        paramm.HtF.add(3, localObject1);
      }
      for (;;)
      {
        aEp("checkChatroom");
        AppMethodBeat.o(52669);
        return;
        label599:
        paramm.HtF.add(localObject1);
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
    extends k
  {
    public t(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52670);
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.cc(this.Htr.query, true);
      Object localObject1 = b.a(b.this);
      Object localObject2 = paramm.FWt;
      Object localObject3 = this.Htr.Htx;
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.j)localObject2).fxx();
      long l1 = System.currentTimeMillis();
      long l2 = ((com.tencent.mm.plugin.fts.a.a.j)localObject2).Hti.size();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), MMContactRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type IN " + com.tencent.mm.plugin.fts.a.d.G((int[])localObject3) + " ORDER BY Rank ;", new Object[] { ((com.tencent.mm.plugin.fts.b.b)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), Long.valueOf(l1 - 1105032704L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), localObject4 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).HqR.rawQuery((String)localObject3, new String[] { ((com.tencent.mm.plugin.fts.a.a.j)localObject2).Htf });
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.Htr.HtA);
      l1 = 0L;
      while (((Cursor)localObject1).moveToNext())
      {
        localObject4 = new p().k((Cursor)localObject1);
        if (((HashSet)localObject3).add(((p)localObject4).Hsz))
        {
          if (l1 >= ((p)localObject4).HtR) {
            ((List)localObject2).add(localObject4);
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramm = new InterruptedException("Task is Cancel: " + this.Htr.query);
            AppMethodBeat.o(52670);
            throw paramm;
            if (((List)localObject2).size() > this.Htr.Htz) {
              break label407;
            }
            l1 = ((p)localObject4).HtR;
            ((List)localObject2).add(localObject4);
          }
        }
      }
      label407:
      ((Cursor)localObject1).close();
      paramm.HtF = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (p)((Iterator)localObject1).next();
        ((p)localObject2).fxB();
        ((p)localObject2).a(paramm.FWt);
        paramm.HtF.add(localObject2);
      }
      if (this.Htr.HtB != null) {
        Collections.sort(paramm.HtF, this.Htr.HtB);
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
    extends k
  {
    public u(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      int i = 0;
      AppMethodBeat.i(52671);
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.cc(this.Htr.query, true);
      Object localObject1 = b.a(b.this);
      Object localObject2 = paramm.FWt;
      Object localObject3 = ((com.tencent.mm.plugin.fts.a.a.j)localObject2).fxx();
      long l1 = ((com.tencent.mm.plugin.fts.a.a.j)localObject2).Hti.size();
      long l2 = System.currentTimeMillis();
      localObject2 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", new Object[] { ((com.tencent.mm.plugin.fts.b.b)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), Long.valueOf(l1), Long.valueOf(l2 - 1105032704L), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject1).fxo(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).HqR.rawQuery((String)localObject2, null);
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.Htr.HtA);
      while (((Cursor)localObject1).moveToNext())
      {
        p localp = new p().l((Cursor)localObject1);
        if (((HashSet)localObject3).add(localp.Hsz))
        {
          if (i >= localp.subtype) {
            ((List)localObject2).add(localp);
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramm = new InterruptedException("Task is Cancel: " + this.Htr.query);
            AppMethodBeat.o(52671);
            throw paramm;
            if (((List)localObject2).size() > this.Htr.Htz) {
              break label345;
            }
            i = localp.subtype;
            ((List)localObject2).add(localp);
          }
        }
      }
      label345:
      ((Cursor)localObject1).close();
      paramm.HtF = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (p)((Iterator)localObject1).next();
        ((p)localObject2).fxB();
        ((p)localObject2).a(paramm.FWt);
        paramm.HtF.add(localObject2);
      }
      if (this.Htr.HtB != null) {
        Collections.sort(paramm.HtF, this.Htr.HtB);
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
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private int HvA = 0;
    private int HvB = 0;
    private int Hvz = 0;
    
    private v() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52672);
      aEp("start");
      Object localObject1 = b.c(b.this).entrySet().iterator();
      int i = 50;
      if (((Iterator)localObject1).hasNext())
      {
        if (Thread.interrupted())
        {
          b.a(b.this).commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52672);
          throw ((Throwable)localObject1);
        }
        if (i < 50) {
          break label542;
        }
        b.a(b.this).commit();
        b.a(b.this).beginTransaction();
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
          b.a(b.this).rp(l);
          i += 1;
        }
        localObject2 = (String)((Map.Entry)localObject2).getKey();
        localObject3 = b.b(b.this).aEa((String)localObject2);
        if ((localObject3 != null) && (((az)localObject3).field_username.length() > 0) && (b.this.ah((au)localObject3))) {
          i += b.this.ai((au)localObject3);
        }
        for (;;)
        {
          ((Iterator)localObject1).remove();
          b.d(b.this).remove(localObject2);
          this.Hvz += 1;
          break;
          aEp("dirtyContact");
          localObject1 = b.d(b.this).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            if (Thread.interrupted())
            {
              b.a(b.this).commit();
              localObject1 = new InterruptedException();
              AppMethodBeat.o(52672);
              throw ((Throwable)localObject1);
            }
            if (i < 50) {
              break label533;
            }
            b.a(b.this).commit();
            b.a(b.this).beginTransaction();
            i = 0;
            label363:
            localObject2 = (String)((Iterator)localObject1).next();
            l = b.b(b.this).aEc((String)localObject2);
            localObject3 = b.b(b.this).aEa((String)localObject2);
            if ((localObject3 == null) || (((az)localObject3).field_username.length() <= 0) || (!b.this.ah((au)localObject3))) {
              break label536;
            }
            b.a(b.this).aG((String)localObject2, l);
            i += 1;
          }
          for (;;)
          {
            ((Iterator)localObject1).remove();
            this.HvA += 1;
            break;
            b.a(b.this).commit();
            aEp("timestampContact");
            localObject1 = ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getTopHitsLogic();
            ((g)localObject1).Hwj.clear();
            this.HvB = ((g)localObject1).Hwi.fyb();
            aEp("topHits");
            AppMethodBeat.o(52672);
            return true;
            break label363;
          }
        }
      }
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52673);
      String str = String.format("{Dirty: %d Timestamp: %d tophitsCount: %d}", new Object[] { Integer.valueOf(this.Hvz), Integer.valueOf(this.HvA), Integer.valueOf(this.HvB) });
      AppMethodBeat.o(52673);
      return str;
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
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private long HvC;
    private int HvD = 0;
    
    public w(long paramLong)
    {
      this.HvC = paramLong;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52674);
      Object localObject1 = new ArrayList(32);
      Object localObject2 = b.a(b.this);
      long l = this.HvC;
      localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject2).HqR.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[] { Long.toString(l) });
      while (((Cursor)localObject2).moveToNext()) {
        ((ArrayList)localObject1).add(((Cursor)localObject2).getString(0));
      }
      ((Cursor)localObject2).close();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!b.c(b.this).containsKey(localObject2))
        {
          List localList = b.a(b.this).c(com.tencent.mm.plugin.fts.a.c.Hrl, (String)localObject2);
          b.c(b.this).put(localObject2, localList);
        }
      }
      AppMethodBeat.o(52674);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52675);
      String str = String.format("{mLabelId: %d mContactCount: %d}", new Object[] { Long.valueOf(this.HvC), Integer.valueOf(this.HvD) });
      AppMethodBeat.o(52675);
      return str;
    }
    
    public final String getName()
    {
      return "UpdateLabelTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.logic.b
 * JD-Core Version:    0.7.0.1
 */