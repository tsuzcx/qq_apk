package com.tencent.mm.plugin.fts.b;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.zu;
import com.tencent.mm.f.a.zy;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c;
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
  private static Set<String> BKf;
  private com.tencent.mm.plugin.fts.c.a BJR;
  private HashSet<String> BJS;
  private HashMap<String, List<Long>> BJT;
  private HashMap<String, String[]> BJU;
  private HashMap<String, List<Long>> BJV;
  private Method BJW;
  private MStorageEx.IOnStorageChange BJX;
  private MStorageEx.IOnStorageChange BJY;
  private MStorage.IOnStorageChange BJZ;
  private MStorage.IOnStorageChange BKa;
  private IListener BKb;
  private IListener BKc;
  private MTimerHandler BKd;
  private MTimerHandler BKe;
  private com.tencent.mm.plugin.fts.a.m jSC;
  private com.tencent.mm.plugin.fts.a.j wHT;
  
  static
  {
    AppMethodBeat.i(52693);
    BKf = new HashSet();
    String[] arrayOfString = MMApplicationContext.getContext().getString(h.a.country_others).split(";");
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        BKf.add(str);
        i += 1;
      }
    }
    AppMethodBeat.o(52693);
  }
  
  public a()
  {
    AppMethodBeat.i(52681);
    this.BJX = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(52631);
        paramAnonymousMStorageEx = (String)paramAnonymousObject;
        if (!a.aHW(paramAnonymousMStorageEx))
        {
          Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "onConversationChangeListener filterByUsername %s", new Object[] { paramAnonymousMStorageEx });
          AppMethodBeat.o(52631);
          return;
        }
        paramAnonymousObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwc(paramAnonymousMStorageEx);
        if ((paramAnonymousObject != null) && ((!a.ab(paramAnonymousObject)) || (paramAnonymousObject.hxX())))
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
          if (!a.c(a.this).containsKey(paramAnonymousMStorageEx))
          {
            a.e(a.this).a(65556, new a.h(a.this, paramAnonymousMStorageEx));
            AppMethodBeat.o(52631);
            return;
            if ((!a.d(a.this).contains(paramAnonymousMStorageEx)) && (!a.c(a.this).containsKey(paramAnonymousMStorageEx))) {
              a.e(a.this).a(65556, new a.i(a.this, paramAnonymousMStorageEx));
            }
          }
        }
      }
    };
    this.BJY = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(52632);
        paramAnonymousMStorageEx = (String)paramAnonymousObject;
        if (!a.aHW(paramAnonymousMStorageEx))
        {
          Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", new Object[] { paramAnonymousMStorageEx });
          AppMethodBeat.o(52632);
          return;
        }
        paramAnonymousObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwc(paramAnonymousMStorageEx);
        if ((paramAnonymousObject != null) && (!a.ab(paramAnonymousObject)))
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
          if (!a.c(a.this).containsKey(paramAnonymousMStorageEx))
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
    this.BJZ = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(52633);
        if ((paramAnonymousString.equals("*")) || (paramAnonymousString.equals("chatroomname")))
        {
          AppMethodBeat.o(52633);
          return;
        }
        if (!a.c(a.this).containsKey(paramAnonymousString)) {
          a.e(a.this).a(65556, new a.h(a.this, paramAnonymousString));
        }
        AppMethodBeat.o(52633);
      }
    };
    this.BKa = new MStorage.IOnStorageChange()
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
    this.BKb = new IListener() {};
    this.BKc = new IListener() {};
    this.BKd = new MTimerHandler(com.tencent.mm.kernel.h.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      private int BKh = 0;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52637);
        PluginFTS localPluginFTS = (PluginFTS)com.tencent.mm.kernel.h.ag(PluginFTS.class);
        if ((localPluginFTS.isCharging()) || (!localPluginFTS.isInBackground())) {}
        for (int i = 1; i == 0; i = 0)
        {
          i = this.BKh + 1;
          this.BKh = i;
          if (i >= 6) {
            break;
          }
          AppMethodBeat.o(52637);
          return true;
        }
        a.e(a.this).a(131093, new a.v(a.this, (byte)0));
        this.BKh = 0;
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
    this.BKe = new MTimerHandler(com.tencent.mm.kernel.h.aHJ().getLooper(), new MTimerHandler.CallBack()
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
  
  private static String PL(String paramString)
  {
    AppMethodBeat.i(52691);
    if (BKf.contains(paramString))
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
    hE(paramString1, str);
    paramString2 = this.wHT.aHF(str);
    if (paramString2.size() == 0)
    {
      AppMethodBeat.o(52690);
      return 0;
    }
    paramString2 = Util.listToString(paramString2, "​");
    this.BJR.a(131072, 11, paramLong1, paramString1, paramLong2, paramString2);
    AppMethodBeat.o(52690);
    return 1;
  }
  
  private int a(as paramas, long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(52688);
    Object localObject = paramas.hDA;
    int i = j;
    if (!Util.isNullOrNil((String)localObject))
    {
      com.tencent.mm.openim.a.b localb = new com.tencent.mm.openim.a.b();
      localb.ZC((String)localObject);
      localObject = new StringBuffer();
      i = 0;
      while (i < localb.mxJ.size())
      {
        Iterator localIterator = ((b.a)localb.mxJ.get(i)).mya.iterator();
        while (localIterator.hasNext())
        {
          String str = ((b.b)localIterator.next()).ZD(paramas.field_openImAppid);
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
        this.BJR.a(131081, 51, paramas.jxt, paramas.field_username, paramLong, ((StringBuffer)localObject).toString());
        i = 1;
      }
    }
    AppMethodBeat.o(52688);
    return i;
  }
  
  static boolean aHW(String paramString)
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
    if ((paramString.endsWith("@gamelifesess")) || (paramString.endsWith("@gamelife")) || (paramString.endsWith("@gamelifehistory")))
    {
      AppMethodBeat.o(52683);
      return false;
    }
    AppMethodBeat.o(52683);
    return true;
  }
  
  public static boolean aHX(String paramString)
  {
    AppMethodBeat.i(52692);
    boolean bool = Util.nullAs(paramString, "").contains(z.bcZ());
    AppMethodBeat.o(52692);
    return bool;
  }
  
  static boolean ab(as paramas)
  {
    AppMethodBeat.i(52684);
    if ((paramas.isHidden()) && (!"notifymessage".equals(paramas.field_username)))
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (paramas.ayc())
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (paramas.field_deleteFlag != 0)
    {
      AppMethodBeat.o(52684);
      return false;
    }
    if (!com.tencent.mm.contact.d.rk(paramas.field_type))
    {
      if (paramas.ayb())
      {
        AppMethodBeat.o(52684);
        return false;
      }
      if (paramas.hxX())
      {
        AppMethodBeat.o(52684);
        return false;
      }
    }
    AppMethodBeat.o(52684);
    return true;
  }
  
  private void hE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52689);
    Object localObject1 = c.a.BHb.split(paramString2);
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
      localObject1 = (List)this.BJV.get(paramString1);
      if (localObject1 == null)
      {
        this.BJR.aIb(paramString1);
        if ((paramString2 != null) && (!paramString2.isEmpty()))
        {
          this.BJR.v(paramString1, paramString2);
          this.BJV.put(paramString1, paramString2);
          AppMethodBeat.o(52689);
        }
      }
      else
      {
        if ((paramString2 == null) || (paramString2.isEmpty()))
        {
          this.BJR.aIb(paramString1);
          this.BJV.remove(paramString1);
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
            com.tencent.mm.plugin.fts.c.a locala = this.BJR;
            locala.BLC.bindString(1, paramString1);
            locala.BLC.bindLong(2, l);
            locala.BLC.execute();
          }
        }
        localObject1 = ((HashSet)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          l = ((Long)((Iterator)localObject1).next()).longValue();
          localObject2 = this.BJR;
          ((com.tencent.mm.plugin.fts.c.a)localObject2).BLD.bindString(1, paramString1);
          ((com.tencent.mm.plugin.fts.c.a)localObject2).BLD.bindLong(2, l);
          ((com.tencent.mm.plugin.fts.c.a)localObject2).BLD.execute();
        }
        this.BJV.put(paramString1, paramString2);
      }
      AppMethodBeat.o(52689);
      return;
      paramString2 = null;
    }
  }
  
  final int a(String paramString, as paramas, String[] paramArrayOfString, byte[] paramArrayOfByte, HashMap<String, as> paramHashMap)
  {
    AppMethodBeat.i(52679);
    String str1 = paramas.field_nickname;
    String str2 = paramas.field_conRemark;
    String str3 = com.tencent.mm.plugin.fts.a.d.bG(str2, false);
    String str4 = com.tencent.mm.plugin.fts.a.d.bG(str2, true);
    String str5 = com.tencent.mm.plugin.fts.a.d.bG(str1, false);
    String str6 = com.tencent.mm.plugin.fts.a.d.bG(str1, true);
    long l1 = 0L;
    long l2 = this.wHT.aHE(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    int i;
    int j;
    if (paramArrayOfString != null)
    {
      l1 = paramArrayOfString.length;
      HashMap localHashMap = new HashMap();
      paramas = new com.tencent.mm.k.a.a.a();
      try
      {
        paramas.parseFrom(paramArrayOfByte);
        paramas = paramas.jmy.iterator();
        while (paramas.hasNext())
        {
          paramArrayOfByte = (com.tencent.mm.k.a.a.b)paramas.next();
          if (!Util.isNullOrNil(paramArrayOfByte.jmB)) {
            localHashMap.put(paramArrayOfByte.userName, paramArrayOfByte.jmB);
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
        paramas = new StringBuffer();
        paramArrayOfByte = paramArrayOfString[j];
        as localas = (as)paramHashMap.get(paramArrayOfByte);
        if (localas == null)
        {
          Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "can not get chatroomMemberContact data memberUsername:%s i:%s", new Object[] { paramArrayOfByte, Integer.valueOf(j) });
          paramas.append("​");
        }
        for (;;)
        {
          j += 1;
          break;
          String str8 = localas.field_conRemark;
          String str7 = localas.field_nickname;
          String str9 = com.tencent.mm.plugin.fts.a.d.bG(str8, false);
          String str10 = com.tencent.mm.plugin.fts.a.d.bG(str8, true);
          paramas.append(Util.nullAs(str8, " ")).append("‌");
          paramas.append(Util.nullAs(str9, " ")).append("‌");
          paramas.append(Util.nullAs(str10, " ")).append("‌");
          str8 = com.tencent.mm.plugin.fts.a.d.bG(str7, false);
          str9 = com.tencent.mm.plugin.fts.a.d.bG(str7, true);
          paramas.append(Util.nullAs(str7, " ")).append("‌");
          paramas.append(Util.nullAs(str8, " ")).append("‌");
          paramas.append(Util.nullAs(str9, " ")).append("‌");
          paramas.append(Util.nullAs((String)localHashMap.get(paramArrayOfByte), " ")).append("‌");
          aa(localas);
          paramas.append(Util.nullAs(localas.hDq, " ")).append("‌");
          paramas.append(Util.nullAs(com.tencent.mm.plugin.fts.a.d.hD(paramArrayOfByte, localas.apf()), " ")).append("‌");
          if (paramas.indexOf("​") < 0) {
            break label863;
          }
          paramas = new StringBuffer(paramas.toString().replace("​", " "));
          i = 1;
          paramas.append("​");
          localStringBuffer.append(paramas);
        }
      }
    }
    for (int k = i;; k = 0)
    {
      if (!Util.isNullOrNil(str1))
      {
        this.BJR.a(131075, 5, l1, paramString, l2, str1);
        if (!Util.isNullOrNil(str5))
        {
          this.BJR.a(131075, 6, l1, paramString, l2, str5);
          i = 2;
          j = i;
          if (!Util.isNullOrNil(str6)) {
            this.BJR.a(131075, 7, l1, paramString, l2, str6);
          }
        }
      }
      for (j = i + 1;; j = 0)
      {
        i = j;
        if (!Util.isNullOrNil(str2))
        {
          this.BJR.a(131075, 1, l1, paramString, l2, str2);
          i = j + 1;
          j = i;
          if (!Util.isNullOrNil(str5))
          {
            this.BJR.a(131075, 2, l1, paramString, l2, str3);
            j = i + 1;
          }
          i = j;
          if (!Util.isNullOrNil(str6))
          {
            this.BJR.a(131075, 3, l1, paramString, l2, str4);
            i = j + 1;
          }
        }
        j = i;
        if (localStringBuffer.length() > 0)
        {
          localStringBuffer.setLength(localStringBuffer.length() - 1);
          this.BJR.a(131075, 38, l1, paramString, l2, localStringBuffer.toString());
          j = i + 1;
        }
        if (k != 0) {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(146L, 29L, 1L, false);
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
  
  public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(52676);
    switch (paramj.nRn)
    {
    default: 
      paramj = new j(paramj);
    }
    for (;;)
    {
      paramj = this.jSC.a(-65536, paramj);
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
  
  public final boolean aEt()
  {
    AppMethodBeat.i(52678);
    this.BKb.dead();
    this.BKc.dead();
    this.BKe.stopTimer();
    this.BKd.stopTimer();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().remove(this.BJY);
    ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().remove(this.BJZ);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().remove(this.BJX);
    MStorage.IOnStorageChange localIOnStorageChange = this.BKa;
    if (com.tencent.mm.ba.b.lSC != null) {
      com.tencent.mm.ba.b.lSC.b(localIOnStorageChange);
    }
    if (this.BJT != null) {
      this.BJT.clear();
    }
    if (this.BJS != null) {
      this.BJS.clear();
    }
    this.BJR = null;
    this.jSC = null;
    AppMethodBeat.o(52678);
    return true;
  }
  
  final void aa(as paramas)
  {
    AppMethodBeat.i(52682);
    try
    {
      this.BJW.invoke(paramas, new Object[0]);
      AppMethodBeat.o(52682);
      return;
    }
    catch (Exception paramas)
    {
      Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paramas, "Failed parsing RContact LVBuffer.", new Object[0]);
      AppMethodBeat.o(52682);
    }
  }
  
  final boolean ac(as paramas)
  {
    AppMethodBeat.i(52685);
    String str = paramas.field_username;
    if (!ab(paramas))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if (!aHW(str))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if ((as.bvP(str)) || (as.bvN(str)))
    {
      AppMethodBeat.o(52685);
      return false;
    }
    if (!com.tencent.mm.contact.d.rk(paramas.field_type))
    {
      if ((!paramas.ayb()) && (!paramas.hxX()))
      {
        if (this.wHT.aHD(str))
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
  
  final int ad(as paramas)
  {
    AppMethodBeat.i(52686);
    Object localObject1;
    Object localObject3;
    if (ab.Lj(paramas.field_username))
    {
      localObject1 = String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", new Object[] { "chatroom" });
      localObject3 = this.wHT.h((String)localObject1, new String[] { paramas.field_username });
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
        if ((Util.isNullOrNil((String)localObject2)) || (localObject1 == null) || (!aHX((String)localObject2)))
        {
          Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", new Object[] { paramas.field_username });
          i = i(paramas.field_username, null);
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
      Object localObject2 = c.a.BGU.split((CharSequence)localObject2);
      Arrays.sort((Object[])localObject2, new Comparator() {});
      int i = i(paramas.field_username, (String[])localObject2);
      if (i > 0) {
        Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paramas.field_username, Integer.valueOf(i) });
      }
      localObject3 = new HashMap();
      Object localObject4 = "SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + com.tencent.mm.plugin.fts.a.d.I((String[])localObject2) + ";";
      localObject4 = this.wHT.h((String)localObject4, null);
      try
      {
        while (((Cursor)localObject4).moveToNext())
        {
          as localas = new as();
          localas.jxt = ((Cursor)localObject4).getLong(0);
          localas.setUsername(((Cursor)localObject4).getString(1));
          localas.Iq(((Cursor)localObject4).getString(2));
          localas.Ir(((Cursor)localObject4).getString(3));
          localas.setNickname(((Cursor)localObject4).getString(4));
          localas.ag(((Cursor)localObject4).getBlob(5));
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
      i = ae(paramas);
      AppMethodBeat.o(52686);
      return i;
      label506:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  final int ae(as paramas)
  {
    AppMethodBeat.i(52687);
    long l2 = paramas.jxt;
    String str2 = paramas.field_username;
    Object localObject7 = paramas.apf();
    Object localObject1 = paramas.field_nickname;
    Object localObject2 = com.tencent.mm.plugin.fts.a.d.bG((String)localObject1, false);
    Object localObject3 = com.tencent.mm.plugin.fts.a.d.bG((String)localObject1, true);
    Object localObject6 = paramas.field_conRemark;
    Object localObject4 = com.tencent.mm.plugin.fts.a.d.bG((String)localObject6, false);
    Object localObject5 = com.tencent.mm.plugin.fts.a.d.bG((String)localObject6, true);
    String str3 = paramas.hDq;
    String str1 = paramas.field_contactLabelIds;
    String str4 = paramas.hDw;
    int i = paramas.field_verifyFlag;
    long l1 = System.currentTimeMillis();
    int j;
    if ((i & as.hya()) != 0)
    {
      str1 = Util.listToString(((com.tencent.mm.api.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.api.n.class)).gp(str2), "​");
      i = 0;
      j = 131076;
    }
    for (;;)
    {
      localObject7 = com.tencent.mm.plugin.fts.a.d.hD(str2, (String)localObject7);
      if ((localObject7 != null) && (((String)localObject7).length() != 0))
      {
        this.BJR.a(j, 15, l2, str2, l1, (String)localObject7);
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
            this.BJR.a(j, 1, l2, str2, l1, (String)localObject6);
            if ((localObject4 != null) && (((String)localObject4).length() != 0)) {
              this.BJR.a(j, 2, l2, str2, l1, (String)localObject4);
            }
            if ((localObject7 != null) && (((String)localObject7).length() != 0)) {
              this.BJR.a(j, 3, l2, str2, l1, (String)localObject7);
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
                this.BJR.a(j, 5, l2, str2, l1, (String)localObject5);
                if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
                  this.BJR.a(j, 6, l2, str2, l1, (String)localObject3);
                }
                if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
                  this.BJR.a(j, 7, l2, str2, l1, (String)localObject1);
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
                  this.BJR.a(j, 4, l2, str2, l1, str3);
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
                this.BJR.a(j, 16, l2, str2, l1, (String)localObject1);
                k = i + 1;
              }
              for (;;)
              {
                localObject1 = PL(paramas.getProvince());
                i = k;
                if (localObject1 != null)
                {
                  i = k;
                  if (((String)localObject1).length() != 0)
                  {
                    this.BJR.a(j, 18, l2, str2, l1, (String)localObject1);
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
                    this.BJR.a(j, 17, l2, str2, l1, (String)localObject1);
                    k = i + 1;
                  }
                }
                i = k;
                if (j == 131076)
                {
                  i = k;
                  if (!Util.isNullOrNil(str1))
                  {
                    this.BJR.a(j, 19, l2, str2, l1, str1);
                    i = k + 1;
                    localObject1 = com.tencent.mm.plugin.fts.a.d.bG(str1, false);
                    k = i;
                    if (!Util.isNullOrNil((String)localObject1))
                    {
                      this.BJR.a(j, 20, l2, str2, l1, (String)localObject1);
                      k = i + 1;
                    }
                    str1 = com.tencent.mm.plugin.fts.a.d.bG(str1, true);
                    i = k;
                    if (!Util.isNullOrNil(str1))
                    {
                      this.BJR.a(j, 21, l2, str2, l1, str1);
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
                if (as.bvK(str2))
                {
                  i = 0;
                  str1 = "";
                  j = 131081;
                  break;
                }
                l1 = this.wHT.aHE(str2);
                if ((str1 == null) || (str1.length() <= 0)) {
                  break label1041;
                }
                i = a(l2, str2, str1, l1) + 0;
                str1 = "";
                j = 131072;
                break;
                localObject1 = this.wHT.h("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[] { str2 });
                k = i;
                if (((Cursor)localObject1).moveToFirst())
                {
                  localObject2 = ((Cursor)localObject1).getString(0);
                  this.BJR.a(j, 16, l2, str2, l1, (String)localObject2);
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
    Object localObject = (String[])this.BJU.get(paramString);
    this.BJR.beginTransaction();
    int j;
    int i;
    if (localObject == null)
    {
      this.BJR.aId(paramString);
      j = (int)this.BJR.BLF.simpleQueryForLong() + 0;
      i = j;
      if (paramArrayOfString != null)
      {
        this.BJR.j(paramString, paramArrayOfString);
        this.BJU.put(paramString, paramArrayOfString);
        i = j + paramArrayOfString.length;
      }
    }
    for (;;)
    {
      this.BJR.commit();
      AppMethodBeat.o(52680);
      return i;
      if (paramArrayOfString == null)
      {
        this.BJR.aId(paramString);
        i = (int)this.BJR.BLF.simpleQueryForLong() + 0;
        this.BJU.remove(paramString);
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
            locala = this.BJR;
            locala.BLz.bindString(1, paramString);
            locala.BLz.bindString(2, str);
            locala.BLz.execute();
            k = i + 1;
          }
          j += 1;
        }
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          locala = this.BJR;
          locala.BLA.bindString(1, paramString);
          locala.BLA.bindString(2, str);
          locala.BLA.execute();
          i += 1;
        }
        this.BJU.put(paramString, paramArrayOfString);
      }
    }
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(52677);
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
      AppMethodBeat.o(52677);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
    this.BJR = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3));
    this.jSC = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.wHT = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
    this.BJS = new HashSet();
    this.BJT = new HashMap();
    this.BJU = new HashMap();
    this.BJV = new HashMap();
    try
    {
      this.BJW = ax.class.getDeclaredMethod("parseBuff", new Class[0]);
      this.BJW.setAccessible(true);
      this.jSC.a(131072, new f((byte)0));
      this.jSC.a(131082, new a((byte)0));
      this.jSC.a(131092, new b((byte)0));
      this.jSC.a(2147483647, new c((byte)0));
      ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().add(this.BJZ);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().add(this.BJY);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().add(this.BJX);
      MStorage.IOnStorageChange localIOnStorageChange = this.BKa;
      if (com.tencent.mm.ba.b.lSC != null) {
        com.tencent.mm.ba.b.lSC.a(localIOnStorageChange);
      }
      this.BKd.startTimer(600000L);
      this.BKb.alive();
      this.BKc.alive();
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
    private int wIa = 0;
    private int wIb = 0;
    
    private a() {}
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52642);
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
      Object localObject1 = new HashSet();
      Object localObject2 = a.a(a.this).BGp.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
      while (((Cursor)localObject2).moveToNext()) {
        ((HashSet)localObject1).add(((Cursor)localObject2).getString(0));
      }
      ((Cursor)localObject2).close();
      localObject2 = a.b(a.this).h("SELECT chatroomname, memberlist FROM chatroom;", null);
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
        if ((!Util.isNullOrNil((String)localObject3)) && (!Util.isNullOrNil(str)) && (a.aHX((String)localObject3)))
        {
          localObject3 = c.a.BGU.split((CharSequence)localObject3);
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
            a.a(a.this).j(str, (String[])localObject3);
            i = j + 1;
            this.wIa += 1;
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
        a.a(a.this).aId((String)localObject2);
        this.wIb += 1;
      }
      a.a(a.this).commit();
      AppMethodBeat.o(52642);
      return true;
    }
    
    public final String bOl()
    {
      AppMethodBeat.i(52643);
      String str = String.format("{new: %d removed: %d}", new Object[] { Integer.valueOf(this.wIa), Integer.valueOf(this.wIb) });
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
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private HashMap<String, List<Long>> BKi;
    private HashSet<String> BKj;
    private HashSet<String> BKk;
    private HashMap<String, as> BKl;
    private long BKm;
    private long BKn;
    private int BKo;
    private int BKp;
    private int BKq;
    private int BKr;
    private int BKs;
    private int BKt;
    private int BKu;
    private int BKv;
    
    private b()
    {
      AppMethodBeat.i(52645);
      this.BKi = new HashMap();
      this.BKj = new HashSet();
      this.BKl = new HashMap();
      this.BKm = -1L;
      this.BKn = -1L;
      this.BKo = 0;
      this.BKp = 0;
      this.BKq = 0;
      this.BKr = 0;
      this.BKs = 0;
      AppMethodBeat.o(52645);
    }
    
    /* Error */
    public final boolean aEv()
    {
      // Byte code:
      //   0: ldc 86
      //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: ldc 88
      //   7: ldc 90
      //   9: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   12: aload_0
      //   13: ldc 97
      //   15: invokevirtual 101	com/tencent/mm/plugin/fts/b/a$b:aHR	(Ljava/lang/String;)V
      //   18: aload_0
      //   19: getfield 103	com/tencent/mm/plugin/fts/b/a$b:BKk	Ljava/util/HashSet;
      //   22: ifnonnull +224 -> 246
      //   25: aload_0
      //   26: new 53	java/util/HashSet
      //   29: dup
      //   30: invokespecial 54	java/util/HashSet:<init>	()V
      //   33: putfield 103	com/tencent/mm/plugin/fts/b/a$b:BKk	Ljava/util/HashSet;
      //   36: aload_0
      //   37: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   40: invokestatic 107	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   43: getstatic 113	com/tencent/mm/plugin/fts/a/c:BGG	[I
      //   46: iconst_1
      //   47: iconst_0
      //   48: iconst_1
      //   49: iconst_0
      //   50: iconst_1
      //   51: invokevirtual 118	com/tencent/mm/plugin/fts/c/a:a	([IZZZZZ)Landroid/database/Cursor;
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
      //   100: getfield 51	com/tencent/mm/plugin/fts/b/a$b:BKi	Ljava/util/HashMap;
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
      //   134: getfield 51	com/tencent/mm/plugin/fts/b/a$b:BKi	Ljava/util/HashMap;
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
      //   161: getfield 103	com/tencent/mm/plugin/fts/b/a$b:BKk	Ljava/util/HashSet;
      //   164: aload 8
      //   166: invokevirtual 160	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   169: pop
      //   170: iload_1
      //   171: iconst_2
      //   172: if_icmpne -116 -> 56
      //   175: aload_0
      //   176: getfield 56	com/tencent/mm/plugin/fts/b/a$b:BKj	Ljava/util/HashSet;
      //   179: aload 8
      //   181: invokevirtual 160	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   184: pop
      //   185: goto -129 -> 56
      //   188: aload 7
      //   190: invokeinterface 163 1 0
      //   195: aload_0
      //   196: aload_0
      //   197: getfield 51	com/tencent/mm/plugin/fts/b/a$b:BKi	Ljava/util/HashMap;
      //   200: invokevirtual 167	java/util/HashMap:size	()I
      //   203: putfield 169	com/tencent/mm/plugin/fts/b/a$b:BKt	I
      //   206: aload_0
      //   207: aload_0
      //   208: getfield 56	com/tencent/mm/plugin/fts/b/a$b:BKj	Ljava/util/HashSet;
      //   211: invokevirtual 170	java/util/HashSet:size	()I
      //   214: putfield 172	com/tencent/mm/plugin/fts/b/a$b:BKu	I
      //   217: aload_0
      //   218: aload_0
      //   219: getfield 103	com/tencent/mm/plugin/fts/b/a$b:BKk	Ljava/util/HashSet;
      //   222: invokevirtual 170	java/util/HashSet:size	()I
      //   225: putfield 174	com/tencent/mm/plugin/fts/b/a$b:BKv	I
      //   228: aload_0
      //   229: getfield 174	com/tencent/mm/plugin/fts/b/a$b:BKv	I
      //   232: iconst_5
      //   233: if_icmpge +13 -> 246
      //   236: aload_0
      //   237: aload_0
      //   238: getfield 177	com/tencent/mm/plugin/fts/a/a/a:BHL	J
      //   241: lconst_1
      //   242: lor
      //   243: putfield 177	com/tencent/mm/plugin/fts/a/a/a:BHL	J
      //   246: aload_0
      //   247: ldc 179
      //   249: invokevirtual 101	com/tencent/mm/plugin/fts/b/a$b:aHR	(Ljava/lang/String;)V
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
      //   276: getfield 51	com/tencent/mm/plugin/fts/b/a$b:BKi	Ljava/util/HashMap;
      //   279: invokevirtual 167	java/util/HashMap:size	()I
      //   282: ifle +76 -> 358
      //   285: new 143	java/util/ArrayList
      //   288: dup
      //   289: invokespecial 188	java/util/ArrayList:<init>	()V
      //   292: astore 5
      //   294: aload_0
      //   295: getfield 51	com/tencent/mm/plugin/fts/b/a$b:BKi	Ljava/util/HashMap;
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
      //   340: getfield 51	com/tencent/mm/plugin/fts/b/a$b:BKi	Ljava/util/HashMap;
      //   343: invokevirtual 214	java/util/HashMap:clear	()V
      //   346: aload_0
      //   347: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   350: invokestatic 107	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   353: aload 5
      //   355: invokevirtual 218	com/tencent/mm/plugin/fts/c/a:fd	(Ljava/util/List;)V
      //   358: aload_0
      //   359: ldc 220
      //   361: invokevirtual 101	com/tencent/mm/plugin/fts/b/a$b:aHR	(Ljava/lang/String;)V
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
      //   388: getfield 56	com/tencent/mm/plugin/fts/b/a$b:BKj	Ljava/util/HashSet;
      //   391: invokevirtual 170	java/util/HashSet:size	()I
      //   394: ifle +72 -> 466
      //   397: aload_0
      //   398: getfield 56	com/tencent/mm/plugin/fts/b/a$b:BKj	Ljava/util/HashSet;
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
      //   429: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   432: invokestatic 226	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/a/j;
      //   435: aload 6
      //   437: invokeinterface 232 2 0
      //   442: lstore_3
      //   443: aload_0
      //   444: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   447: invokestatic 107	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   450: aload 6
      //   452: lload_3
      //   453: invokevirtual 236	com/tencent/mm/plugin/fts/c/a:av	(Ljava/lang/String;J)V
      //   456: goto -50 -> 406
      //   459: aload_0
      //   460: getfield 56	com/tencent/mm/plugin/fts/b/a$b:BKj	Ljava/util/HashSet;
      //   463: invokevirtual 237	java/util/HashSet:clear	()V
      //   466: aload_0
      //   467: ldc 239
      //   469: invokevirtual 101	com/tencent/mm/plugin/fts/b/a$b:aHR	(Ljava/lang/String;)V
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
      //   496: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   499: invokestatic 226	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/a/j;
      //   502: ldc 241
      //   504: iconst_1
      //   505: anewarray 223	java/lang/String
      //   508: dup
      //   509: iconst_0
      //   510: aload_0
      //   511: getfield 62	com/tencent/mm/plugin/fts/b/a$b:BKm	J
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
      //   552: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   555: invokestatic 107	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   558: invokevirtual 252	com/tencent/mm/plugin/fts/c/a:commit	()V
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
      //   589: putfield 62	com/tencent/mm/plugin/fts/b/a$b:BKm	J
      //   592: new 254	com/tencent/mm/storage/as
      //   595: dup
      //   596: invokespecial 255	com/tencent/mm/storage/as:<init>	()V
      //   599: astore 6
      //   601: aload 6
      //   603: lload_3
      //   604: putfield 258	com/tencent/mm/storage/as:jxt	J
      //   607: aload 6
      //   609: aload 5
      //   611: iconst_1
      //   612: invokeinterface 127 2 0
      //   617: invokevirtual 261	com/tencent/mm/storage/as:setUsername	(Ljava/lang/String;)V
      //   620: aload 6
      //   622: aload 5
      //   624: iconst_2
      //   625: invokeinterface 127 2 0
      //   630: invokevirtual 264	com/tencent/mm/storage/as:Iq	(Ljava/lang/String;)V
      //   633: aload 6
      //   635: aload 5
      //   637: iconst_3
      //   638: invokeinterface 127 2 0
      //   643: invokevirtual 267	com/tencent/mm/storage/as:Ir	(Ljava/lang/String;)V
      //   646: aload 6
      //   648: aload 5
      //   650: iconst_4
      //   651: invokeinterface 127 2 0
      //   656: invokevirtual 270	com/tencent/mm/storage/as:setNickname	(Ljava/lang/String;)V
      //   659: aload 6
      //   661: aload 5
      //   663: iconst_5
      //   664: invokeinterface 131 2 0
      //   669: invokevirtual 273	com/tencent/mm/storage/as:ps	(I)V
      //   672: aload 6
      //   674: aload 5
      //   676: bipush 6
      //   678: invokeinterface 131 2 0
      //   683: invokevirtual 276	com/tencent/mm/storage/as:rm	(I)V
      //   686: aload 6
      //   688: aload 5
      //   690: bipush 7
      //   692: invokeinterface 280 2 0
      //   697: invokevirtual 284	com/tencent/mm/storage/as:ag	([B)V
      //   700: aload 6
      //   702: aload 5
      //   704: bipush 8
      //   706: invokeinterface 127 2 0
      //   711: invokevirtual 287	com/tencent/mm/storage/as:Iz	(Ljava/lang/String;)V
      //   714: aload 6
      //   716: iconst_0
      //   717: invokevirtual 290	com/tencent/mm/storage/as:pu	(I)V
      //   720: aload_0
      //   721: getfield 58	com/tencent/mm/plugin/fts/b/a$b:BKl	Ljava/util/HashMap;
      //   724: aload 6
      //   726: getfield 296	com/tencent/mm/f/c/ax:field_username	Ljava/lang/String;
      //   729: aload 6
      //   731: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   734: pop
      //   735: aload 6
      //   737: getfield 296	com/tencent/mm/f/c/ax:field_username	Ljava/lang/String;
      //   740: invokestatic 302	com/tencent/mm/model/ab:Lj	(Ljava/lang/String;)Z
      //   743: ifne -215 -> 528
      //   746: aload_0
      //   747: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   750: aload 6
      //   752: invokevirtual 306	com/tencent/mm/plugin/fts/b/a:ac	(Lcom/tencent/mm/storage/as;)Z
      //   755: ifeq -227 -> 528
      //   758: aload_0
      //   759: getfield 103	com/tencent/mm/plugin/fts/b/a$b:BKk	Ljava/util/HashSet;
      //   762: aload 6
      //   764: getfield 296	com/tencent/mm/f/c/ax:field_username	Ljava/lang/String;
      //   767: invokevirtual 309	java/util/HashSet:remove	(Ljava/lang/Object;)Z
      //   770: ifne -242 -> 528
      //   773: iload_1
      //   774: istore_2
      //   775: iload_1
      //   776: bipush 50
      //   778: if_icmplt +25 -> 803
      //   781: aload_0
      //   782: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   785: invokestatic 107	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   788: invokevirtual 252	com/tencent/mm/plugin/fts/c/a:commit	()V
      //   791: aload_0
      //   792: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   795: invokestatic 107	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   798: invokevirtual 312	com/tencent/mm/plugin/fts/c/a:beginTransaction	()V
      //   801: iconst_0
      //   802: istore_2
      //   803: iload_2
      //   804: istore_1
      //   805: aload 6
      //   807: getfield 296	com/tencent/mm/f/c/ax:field_username	Ljava/lang/String;
      //   810: ldc_w 314
      //   813: invokevirtual 317	java/lang/String:endsWith	(Ljava/lang/String;)Z
      //   816: ifne +35 -> 851
      //   819: iload_2
      //   820: istore_1
      //   821: aload 6
      //   823: getfield 320	com/tencent/mm/f/c/ax:field_verifyFlag	I
      //   826: invokestatic 323	com/tencent/mm/storage/as:hya	()I
      //   829: iand
      //   830: ifne +21 -> 851
      //   833: iload_2
      //   834: istore_1
      //   835: aload_0
      //   836: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   839: aload 6
      //   841: invokevirtual 327	com/tencent/mm/plugin/fts/b/a:aa	(Lcom/tencent/mm/storage/as;)V
      //   844: iload_2
      //   845: istore_1
      //   846: aload 6
      //   848: invokevirtual 330	com/tencent/mm/storage/as:hyd	()V
      //   851: iload_2
      //   852: istore_1
      //   853: iload_2
      //   854: aload_0
      //   855: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   858: aload 6
      //   860: invokevirtual 334	com/tencent/mm/plugin/fts/b/a:ae	(Lcom/tencent/mm/storage/as;)I
      //   863: iadd
      //   864: istore_2
      //   865: iload_2
      //   866: istore_1
      //   867: aload_0
      //   868: aload_0
      //   869: getfield 68	com/tencent/mm/plugin/fts/b/a$b:BKp	I
      //   872: iconst_1
      //   873: iadd
      //   874: putfield 68	com/tencent/mm/plugin/fts/b/a$b:BKp	I
      //   877: iload_2
      //   878: istore_1
      //   879: goto -351 -> 528
      //   882: astore 6
      //   884: ldc 88
      //   886: aload 6
      //   888: ldc_w 336
      //   891: iconst_0
      //   892: anewarray 338	java/lang/Object
      //   895: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   898: aload_0
      //   899: aload_0
      //   900: getfield 72	com/tencent/mm/plugin/fts/b/a$b:BKr	I
      //   903: iconst_1
      //   904: iadd
      //   905: putfield 72	com/tencent/mm/plugin/fts/b/a$b:BKr	I
      //   908: goto -380 -> 528
      //   911: aload 5
      //   913: invokeinterface 163 1 0
      //   918: aload_0
      //   919: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   922: invokestatic 107	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   925: invokevirtual 252	com/tencent/mm/plugin/fts/c/a:commit	()V
      //   928: aload_0
      //   929: ldc_w 344
      //   932: invokevirtual 101	com/tencent/mm/plugin/fts/b/a$b:aHR	(Ljava/lang/String;)V
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
      //   959: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   962: invokestatic 226	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/a/j;
      //   965: ldc_w 346
      //   968: iconst_1
      //   969: anewarray 223	java/lang/String
      //   972: dup
      //   973: iconst_0
      //   974: aload_0
      //   975: getfield 64	com/tencent/mm/plugin/fts/b/a$b:BKn	J
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
      //   1016: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   1019: invokestatic 107	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   1022: invokevirtual 252	com/tencent/mm/plugin/fts/c/a:commit	()V
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
      //   1051: putfield 64	com/tencent/mm/plugin/fts/b/a$b:BKn	J
      //   1054: aload 6
      //   1056: iconst_1
      //   1057: invokeinterface 127 2 0
      //   1062: astore 5
      //   1064: aload_0
      //   1065: getfield 103	com/tencent/mm/plugin/fts/b/a$b:BKk	Ljava/util/HashSet;
      //   1068: aload 5
      //   1070: invokevirtual 309	java/util/HashSet:remove	(Ljava/lang/Object;)Z
      //   1073: ifne -81 -> 992
      //   1076: aload_0
      //   1077: getfield 58	com/tencent/mm/plugin/fts/b/a$b:BKl	Ljava/util/HashMap;
      //   1080: aload 5
      //   1082: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1085: checkcast 254	com/tencent/mm/storage/as
      //   1088: astore 7
      //   1090: aload 7
      //   1092: ifnonnull +16 -> 1108
      //   1095: aload_0
      //   1096: aload_0
      //   1097: getfield 74	com/tencent/mm/plugin/fts/b/a$b:BKs	I
      //   1100: iconst_1
      //   1101: iadd
      //   1102: putfield 74	com/tencent/mm/plugin/fts/b/a$b:BKs	I
      //   1105: goto -113 -> 992
      //   1108: aload 6
      //   1110: iconst_2
      //   1111: invokeinterface 127 2 0
      //   1116: astore 9
      //   1118: aload 9
      //   1120: invokestatic 349	com/tencent/mm/plugin/fts/b/a:aHX	(Ljava/lang/String;)Z
      //   1123: ifne +16 -> 1139
      //   1126: aload_0
      //   1127: aload_0
      //   1128: getfield 74	com/tencent/mm/plugin/fts/b/a$b:BKs	I
      //   1131: iconst_1
      //   1132: iadd
      //   1133: putfield 74	com/tencent/mm/plugin/fts/b/a$b:BKs	I
      //   1136: goto -144 -> 992
      //   1139: aload 6
      //   1141: iconst_3
      //   1142: invokeinterface 280 2 0
      //   1147: astore 8
      //   1149: getstatic 355	com/tencent/mm/plugin/fts/a/c$a:BGU	Ljava/util/regex/Pattern;
      //   1152: aload 9
      //   1154: invokevirtual 361	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;)[Ljava/lang/String;
      //   1157: astore 9
      //   1159: aload 9
      //   1161: new 9	com/tencent/mm/plugin/fts/b/a$b$1
      //   1164: dup
      //   1165: aload_0
      //   1166: invokespecial 364	com/tencent/mm/plugin/fts/b/a$b$1:<init>	(Lcom/tencent/mm/plugin/fts/b/a$b;)V
      //   1169: invokestatic 370	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
      //   1172: aload_0
      //   1173: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   1176: aload 5
      //   1178: aload 9
      //   1180: invokevirtual 373	com/tencent/mm/plugin/fts/b/a:i	(Ljava/lang/String;[Ljava/lang/String;)I
      //   1183: istore_2
      //   1184: iload_1
      //   1185: iload_2
      //   1186: iadd
      //   1187: istore_1
      //   1188: aload_0
      //   1189: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   1192: aload 5
      //   1194: aload 7
      //   1196: aload 9
      //   1198: aload 8
      //   1200: aload_0
      //   1201: getfield 58	com/tencent/mm/plugin/fts/b/a$b:BKl	Ljava/util/HashMap;
      //   1204: invokevirtual 376	com/tencent/mm/plugin/fts/b/a:a	(Ljava/lang/String;Lcom/tencent/mm/storage/as;[Ljava/lang/String;[BLjava/util/HashMap;)I
      //   1207: istore_2
      //   1208: iload_1
      //   1209: iload_2
      //   1210: iadd
      //   1211: istore_1
      //   1212: aload_0
      //   1213: aload_0
      //   1214: getfield 66	com/tencent/mm/plugin/fts/b/a$b:BKo	I
      //   1217: iconst_1
      //   1218: iadd
      //   1219: putfield 66	com/tencent/mm/plugin/fts/b/a$b:BKo	I
      //   1222: iload_1
      //   1223: istore_2
      //   1224: iload_2
      //   1225: istore_1
      //   1226: iload_2
      //   1227: bipush 50
      //   1229: if_icmplt -237 -> 992
      //   1232: aload_0
      //   1233: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   1236: invokestatic 107	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   1239: invokevirtual 252	com/tencent/mm/plugin/fts/c/a:commit	()V
      //   1242: aload_0
      //   1243: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   1246: invokestatic 107	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   1249: invokevirtual 312	com/tencent/mm/plugin/fts/c/a:beginTransaction	()V
      //   1252: iconst_0
      //   1253: istore_1
      //   1254: goto -262 -> 992
      //   1257: astore 5
      //   1259: ldc 88
      //   1261: aload 5
      //   1263: ldc_w 336
      //   1266: iconst_0
      //   1267: anewarray 338	java/lang/Object
      //   1270: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1273: aload_0
      //   1274: aload_0
      //   1275: getfield 74	com/tencent/mm/plugin/fts/b/a$b:BKs	I
      //   1278: iconst_1
      //   1279: iadd
      //   1280: putfield 74	com/tencent/mm/plugin/fts/b/a$b:BKs	I
      //   1283: iload_1
      //   1284: istore_2
      //   1285: goto -61 -> 1224
      //   1288: aload 6
      //   1290: invokeinterface 163 1 0
      //   1295: aload_0
      //   1296: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   1299: invokestatic 107	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   1302: invokevirtual 252	com/tencent/mm/plugin/fts/c/a:commit	()V
      //   1305: aload_0
      //   1306: ldc_w 378
      //   1309: invokevirtual 101	com/tencent/mm/plugin/fts/b/a$b:aHR	(Ljava/lang/String;)V
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
      //   1337: getfield 103	com/tencent/mm/plugin/fts/b/a$b:BKk	Ljava/util/HashSet;
      //   1340: invokevirtual 170	java/util/HashSet:size	()I
      //   1343: putfield 70	com/tencent/mm/plugin/fts/b/a$b:BKq	I
      //   1346: aload_0
      //   1347: getfield 103	com/tencent/mm/plugin/fts/b/a$b:BKk	Ljava/util/HashSet;
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
      //   1378: getfield 36	com/tencent/mm/plugin/fts/b/a$b:BKg	Lcom/tencent/mm/plugin/fts/b/a;
      //   1381: invokestatic 107	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
      //   1384: getstatic 113	com/tencent/mm/plugin/fts/a/c:BGG	[I
      //   1387: aload 6
      //   1389: invokevirtual 381	com/tencent/mm/plugin/fts/c/a:a	([ILjava/lang/String;)V
      //   1392: ldc_w 383
      //   1395: invokestatic 388	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   1398: checkcast 383	com/tencent/mm/plugin/fts/PluginFTS
      //   1401: invokevirtual 392	com/tencent/mm/plugin/fts/PluginFTS:getTopHitsLogic	()Lcom/tencent/mm/plugin/fts/b/e;
      //   1404: getstatic 113	com/tencent/mm/plugin/fts/a/c:BGG	[I
      //   1407: aload 6
      //   1409: invokevirtual 397	com/tencent/mm/plugin/fts/b/e:c	([ILjava/lang/String;)V
      //   1412: goto -57 -> 1355
      //   1415: aload_0
      //   1416: getfield 103	com/tencent/mm/plugin/fts/b/a$b:BKk	Ljava/util/HashSet;
      //   1419: invokevirtual 237	java/util/HashSet:clear	()V
      //   1422: aload_0
      //   1423: getfield 58	com/tencent/mm/plugin/fts/b/a$b:BKl	Ljava/util/HashMap;
      //   1426: invokevirtual 214	java/util/HashMap:clear	()V
      //   1429: aload_0
      //   1430: ldc_w 399
      //   1433: invokevirtual 101	com/tencent/mm/plugin/fts/b/a$b:aHR	(Ljava/lang/String;)V
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
    
    public final String bOl()
    {
      AppMethodBeat.i(52647);
      String str = String.format("{build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, failContact: %d, failChatroom}", new Object[] { Integer.valueOf(this.BKv), Integer.valueOf(this.BKp), Integer.valueOf(this.BKo), Integer.valueOf(this.BKq), Integer.valueOf(this.BKt), Integer.valueOf(this.BKu), Integer.valueOf(this.BKr), Integer.valueOf(this.BKs) });
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
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private c() {}
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52648);
      a.a(a.this).B(c.BGE);
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
    private int BKx = 0;
    private String iSn;
    
    public d(String paramString)
    {
      this.iSn = paramString;
    }
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52649);
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", new Object[] { this.iSn });
      a.a(a.this).a(c.BGG, this.iSn);
      ((PluginFTS)com.tencent.mm.kernel.h.ag(PluginFTS.class)).getTopHitsLogic().c(c.BGG, this.iSn);
      Object localObject1 = a.a(a.this).aIc(this.iSn);
      Object localObject2 = new HashSet();
      while (((Cursor)localObject1).moveToNext()) {
        ((HashSet)localObject2).add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
      localObject1 = ((HashSet)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!a.c(a.this).containsKey(localObject2))
        {
          List localList = a.a(a.this).b(c.BGG, (String)localObject2);
          a.c(a.this).put(localObject2, localList);
          ((PluginFTS)com.tencent.mm.kernel.h.ag(PluginFTS.class)).getTopHitsLogic().aIa((String)localObject2);
          this.BKx += 1;
        }
      }
      AppMethodBeat.o(52649);
      return true;
    }
    
    public final String bOl()
    {
      AppMethodBeat.i(52650);
      String str = String.format("{username: %s mDirtyCount: %d}", new Object[] { this.iSn, Integer.valueOf(this.BKx) });
      AppMethodBeat.o(52650);
      return str;
    }
    
    public final String getName()
    {
      return "DeleteContactTask";
    }
  }
  
  final class e
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private String iSn;
    private boolean jST = false;
    
    public e(String paramString)
    {
      this.iSn = paramString;
    }
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52651);
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", new Object[] { this.iSn });
      as localas = a.b(a.this).aHC(this.iSn);
      if ((localas != null) && (localas.field_username.length() > 0) && (a.this.ac(localas))) {
        a.this.ad(localas);
      }
      for (;;)
      {
        a.c(a.this).remove(this.iSn);
        a.d(a.this).remove(this.iSn);
        AppMethodBeat.o(52651);
        return true;
        this.jST = true;
      }
    }
    
    public final String bOl()
    {
      AppMethodBeat.i(52652);
      String str = String.format("{username: %s isSkipped: %b}", new Object[] { this.iSn, Boolean.valueOf(this.jST) });
      AppMethodBeat.o(52652);
      return str;
    }
    
    public final String getName()
    {
      return "InsertContactTask";
    }
  }
  
  final class f
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int BKy = 0;
    private int BKz = 0;
    
    private f() {}
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52653);
      Cursor localCursor = a.a(a.this).BGp.rawQuery("SELECT user, label_id FROM FTS5ContactLabels;", null);
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
          this.BKy += 1;
        }
        ((List)localObject).add(Long.valueOf(l));
        this.BKz += 1;
      }
      localCursor.close();
      AppMethodBeat.o(52653);
      return true;
    }
    
    public final String bOl()
    {
      AppMethodBeat.i(52654);
      String str = String.format("{users: %d labels: %d}", new Object[] { Integer.valueOf(this.BKy), Integer.valueOf(this.BKz) });
      AppMethodBeat.o(52654);
      return str;
    }
    
    public final String getName()
    {
      return "LoadLabelCacheTask";
    }
  }
  
  final class g
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int[] BKA;
    private int BKB = 0;
    private int wRv = 0;
    
    public g(int[] paramArrayOfInt)
    {
      this.BKA = paramArrayOfInt;
    }
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52655);
      Object localObject = a.a(a.this).j(this.BKA, 1);
      this.wRv = ((List)localObject).size();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.fts.a.a.b localb = (com.tencent.mm.plugin.fts.a.a.b)localIterator.next();
        String str = localb.BHS;
        if (!a.c(a.this).containsKey(str))
        {
          List localList = (List)localHashMap.get(str);
          localObject = localList;
          if (localList == null)
          {
            localObject = new ArrayList(16);
            localHashMap.put(str, localObject);
          }
          ((List)localObject).add(Long.valueOf(localb.BHQ));
        }
      }
      a.c(a.this).putAll(localHashMap);
      this.BKB = localHashMap.size();
      AppMethodBeat.o(52655);
      return true;
    }
    
    public final String bOl()
    {
      AppMethodBeat.i(52656);
      String str = String.format("{touched: %d users: %d}", new Object[] { Integer.valueOf(this.wRv), Integer.valueOf(this.BKB) });
      AppMethodBeat.o(52656);
      return str;
    }
    
    public final String getName()
    {
      return "MarkAllContactDirtyTask";
    }
  }
  
  final class h
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private boolean BKC = false;
    private String iSn;
    private boolean jST = false;
    
    public h(String paramString)
    {
      this.iSn = paramString;
    }
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52657);
      Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", new Object[] { this.iSn });
      if (a.c(a.this).containsKey(this.iSn))
      {
        this.BKC = true;
        AppMethodBeat.o(52657);
        return true;
      }
      a.a(a.this).aHG(this.iSn);
      Object localObject1 = a.a(a.this).b(c.BGG, this.iSn);
      a.c(a.this).put(this.iSn, localObject1);
      if (((List)localObject1).isEmpty())
      {
        this.jST = true;
        a.e(a.this).a(65556, new a.e(a.this, this.iSn));
        AppMethodBeat.o(52657);
        return true;
      }
      localObject1 = a.a(a.this).aIc(this.iSn);
      Object localObject2 = new HashSet();
      while (((Cursor)localObject1).moveToNext()) {
        ((HashSet)localObject2).add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
      localObject1 = ((HashSet)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        a.a(a.this).aHG((String)localObject2);
        if (!a.c(a.this).containsKey(localObject2))
        {
          List localList = a.a(a.this).b(c.BGG, (String)localObject2);
          a.c(a.this).put(localObject2, localList);
        }
      }
      a.d(a.this).remove(this.iSn);
      ((PluginFTS)com.tencent.mm.kernel.h.ag(PluginFTS.class)).getTopHitsLogic().aIa(this.iSn);
      AppMethodBeat.o(52657);
      return true;
    }
    
    public final String bOl()
    {
      AppMethodBeat.i(52658);
      String str = String.format("{username: %s cached: %b isSkipped: %b}", new Object[] { this.iSn, Boolean.valueOf(this.BKC), Boolean.valueOf(this.jST) });
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
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private boolean BKD;
    private String username;
    
    public i(String paramString)
    {
      this.username = paramString;
    }
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52659);
      if (a.c(a.this).containsKey(this.username))
      {
        this.BKD = true;
        AppMethodBeat.o(52659);
        return true;
      }
      if (!a.d(a.this).add(this.username))
      {
        this.BKD = true;
        AppMethodBeat.o(52659);
        return true;
      }
      Object localObject = a.b(a.this).aHC(this.username);
      if ((localObject != null) && (!a.this.ac((as)localObject)))
      {
        this.BKD = true;
        AppMethodBeat.o(52659);
        return true;
      }
      localObject = a.a(a.this);
      String str = this.username;
      ((com.tencent.mm.plugin.fts.a.a)localObject).BGv.bindLong(1, 2L);
      ((com.tencent.mm.plugin.fts.a.a)localObject).BGv.bindString(2, str);
      ((com.tencent.mm.plugin.fts.a.a)localObject).BGv.bindLong(3, 0L);
      ((com.tencent.mm.plugin.fts.a.a)localObject).BGv.execute();
      AppMethodBeat.o(52659);
      return true;
    }
    
    public final String bOl()
    {
      AppMethodBeat.i(52660);
      String str = String.format("{username: %s isSkipped: %b}", new Object[] { this.username, Boolean.valueOf(this.BKD) });
      AppMethodBeat.o(52660);
      return str;
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
      paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.bJ(this.BIJ.query, true);
      Object localObject1 = a.a(a.this).a(paramk.BHY, this.BIJ.BIP, this.BIJ.BIQ, true, true);
      Object localObject2 = new HashMap();
      HashMap localHashMap = new HashMap();
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().k((Cursor)localObject1);
        if (!this.BIJ.BIS.contains(localn.BHS))
        {
          com.tencent.mm.plugin.fts.a.a.m localm;
          if (com.tencent.mm.plugin.fts.a.d.k(c.BGG, localn.type))
          {
            localm = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject2).get(localn.BHS);
            if ((localm == null) || (com.tencent.mm.plugin.fts.a.d.e(c.BGR, localn.BHR, localm.BHR) < 0)) {
              ((HashMap)localObject2).put(localn.BHS, localn);
            }
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException();
            AppMethodBeat.o(52661);
            throw paramk;
            if (com.tencent.mm.plugin.fts.a.d.k(c.BGI, localn.type))
            {
              localm = (com.tencent.mm.plugin.fts.a.a.m)localHashMap.get(Long.valueOf(localn.BIZ));
              if ((localm == null) || (com.tencent.mm.plugin.fts.a.d.e(c.BGR, localn.BHR, localm.BHR) < 0)) {
                localHashMap.put(Long.valueOf(localn.BIZ), localn);
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
      paramk.BIW = new ArrayList(((HashMap)localObject2).size());
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).eqT();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.BHY);
        paramk.BIW.add(localObject2);
      }
      paramk.BIW.addAll(localHashMap.values());
      if (Thread.interrupted())
      {
        paramk = new InterruptedException();
        AppMethodBeat.o(52661);
        throw paramk;
      }
      if (this.BIJ.BIT != null) {
        Collections.sort(paramk.BIW, this.BIJ.BIT);
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
      Object localObject2 = this.BIJ.query;
      String str = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075 ORDER BY timestamp desc", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).eqI() });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).BGp.rawQuery(str, new String[] { localObject2 });
      paramk.BIW = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).BHS = ((Cursor)localObject1).getString(0);
        paramk.BIW.add(localObject2);
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
      String str1 = this.BIJ.query;
      String str2 = String.format("SELECT count(aux_index) FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject).eqI() });
      localObject = ((com.tencent.mm.plugin.fts.a.a)localObject).BGp.rawQuery(str2, new String[] { str1 });
      if (((Cursor)localObject).moveToNext()) {
        i = ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
      localObject = new com.tencent.mm.plugin.fts.a.a.m();
      ((com.tencent.mm.plugin.fts.a.a.m)localObject).BJh = Integer.valueOf(i);
      paramk.BIW = new ArrayList();
      paramk.BIW.add(localObject);
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
      Object localObject2 = this.BIJ.BIN;
      Object localObject3 = paramk.BHY.eqQ();
      localObject3 = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN (SELECT docid, aux_index, timestamp FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=?) as temp ON (%s.rowid = temp.docid) WHERE %s MATCH '%s' ORDER BY -timestamp;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).BGp.rawQuery((String)localObject3, new String[] { localObject2 });
      localObject2 = new HashSet();
      paramk.BIW = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).BHS = ((Cursor)localObject1).getString(0);
        if (((HashSet)localObject2).add(((com.tencent.mm.plugin.fts.a.a.m)localObject3).BHS)) {
          paramk.BIW.add(localObject3);
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
      Object localObject1 = null;
      AppMethodBeat.i(254488);
      paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.bJ(this.BIJ.query, true);
      paramk.BIW = new ArrayList();
      Object localObject2 = a.a(a.this);
      Object localObject3 = this.BIJ.BIN;
      Object localObject4 = paramk.BHY.eqQ();
      localObject4 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMChatroomMember(%s) AS Offsets FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 AND subtype = 38 AND aux_index = ? ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject2).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqJ(), localObject4 });
      localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject2).BGp.rawQuery((String)localObject4, new String[] { localObject3 });
      if (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.fts.a.a.n().k((Cursor)localObject2);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject3).eqT();
        paramk.BIW.add(localObject3);
      }
      ((Cursor)localObject2).close();
      localObject2 = com.tencent.mm.kernel.h.aHG().kcF.rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { this.BIJ.BIN }, 2);
      if (((Cursor)localObject2).moveToFirst())
      {
        localObject3 = ((Cursor)localObject2).getString(0);
        if (localObject3 != null) {}
      }
      for (;;)
      {
        ((Cursor)localObject2).close();
        localObject3 = new HashSet(this.BIJ.BIS);
        localObject4 = new ArrayList();
        Arrays.sort((Object[])localObject1, new Comparator() {});
        Iterator localIterator;
        if ((localObject1 != null) && (!paramk.BIW.isEmpty()) && (((com.tencent.mm.plugin.fts.a.a.m)paramk.BIW.get(0)).BJg != null)) {
          localIterator = ((com.tencent.mm.plugin.fts.a.a.m)paramk.BIW.get(0)).BJg.iterator();
        }
        label774:
        label775:
        for (;;)
        {
          label352:
          g localg;
          String str1;
          if (localIterator.hasNext())
          {
            localg = (g)localIterator.next();
            if (localg.BIq >= localObject1.length) {
              continue;
            }
            str1 = localObject1[localg.BIq];
            if (Util.isNullOrNil(str1)) {
              continue;
            }
            localg.username = str1;
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwj(str1);
            if (localObject2 != null) {
              break label774;
            }
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwh(str1);
          }
          for (;;)
          {
            if (localObject2 == null) {
              break label775;
            }
            String str2 = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).b((as)localObject2, str1);
            switch (localg.BHR)
            {
            }
            for (;;)
            {
              if (Util.isNullOrNil(localg.BIs)) {
                break label735;
              }
              if (localg.BIs.contains(paramk.BHY.BIw)) {
                localg.BIu += 10;
              }
              if (!((HashSet)localObject3).add(str1)) {
                break label352;
              }
              ((List)localObject4).add(localg);
              break label352;
              localObject1 = c.a.BGU.split((CharSequence)localObject3);
              break;
              localg.BIs = com.tencent.mm.plugin.fts.a.d.hD(str1, ((as)localObject2).apf());
              localg.BIt = str2;
              continue;
              localg.BIv = true;
              localg.BHZ = true;
              localg.BIs = ((ax)localObject2).field_nickname;
              if (!((ax)localObject2).field_nickname.equals(str2))
              {
                localg.BIt = str2;
                continue;
                localg.BIv = true;
                localg.BHZ = true;
                localg.BIs = str2;
                continue;
                localg.BIs = localg.content;
                localg.BIt = str2;
                continue;
                localg.BIs = ((ax)localObject2).hDq;
                localg.BIt = str2;
              }
            }
            label735:
            break label352;
            Collections.sort((List)localObject4, new Comparator() {});
            ((com.tencent.mm.plugin.fts.a.a.m)paramk.BIW.get(0)).BJg = ((List)localObject4);
            AppMethodBeat.o(254488);
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
    extends i
  {
    public o(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52665);
      paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.bJ(this.BIJ.query, true);
      Object localObject2 = a.a(a.this).a(paramk.BHY, new int[] { 131075 }, null, true, true);
      Object localObject1 = new HashMap();
      Object localObject4;
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.fts.a.a.n().k((Cursor)localObject2);
        if (!this.BIJ.BIS.contains(((com.tencent.mm.plugin.fts.a.a.n)localObject3).BHS))
        {
          localObject4 = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject1).get(((com.tencent.mm.plugin.fts.a.a.n)localObject3).BHS);
          if ((localObject4 == null) || (com.tencent.mm.plugin.fts.a.d.e(c.BGR, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).BHR, ((com.tencent.mm.plugin.fts.a.a.m)localObject4).BHR) < 0)) {
            ((HashMap)localObject1).put(((com.tencent.mm.plugin.fts.a.a.n)localObject3).BHS, localObject3);
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
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).eqT();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).a(paramk.BHY);
        ((ArrayList)localObject2).add(localObject4);
        if (Thread.interrupted())
        {
          paramk = new InterruptedException();
          AppMethodBeat.o(52665);
          throw paramk;
        }
      }
      if (this.BIJ.BIT != null) {
        Collections.sort((List)localObject2, this.BIJ.BIT);
      }
      paramk.BIW = new ArrayList(((HashMap)localObject1).size());
      localObject1 = new StringBuffer();
      int i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        localObject3 = (com.tencent.mm.plugin.fts.a.a.m)((ArrayList)localObject2).get(i);
        ((StringBuffer)localObject1).append(((com.tencent.mm.plugin.fts.a.a.m)localObject3).BIu);
        ((StringBuffer)localObject1).append("|");
        ((StringBuffer)localObject1).append(((com.tencent.mm.plugin.fts.a.a.m)localObject3).timestamp);
        ((StringBuffer)localObject1).append(" ");
        paramk.BIW.add(localObject3);
        if (i >= this.BIJ.BIR) {
          break;
        }
        i += 1;
      }
      if ((paramk.BHY.BIA.size() > 1) && (a.a(a.this).b(paramk.BHY)))
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).BHS = "create_chatroom​";
        paramk.BIW.add(0, localObject2);
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
      Object localObject2 = Util.stringsToList(this.BIJ.query.split(","));
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
      localObject2 = String.format("SELECT member, chatroom, entity_id FROM FTS5ChatRoomMembers, %s WHERE %s AND chatroom = aux_index", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).eqI(), ((StringBuffer)localObject3).toString() });
      localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject1).BGp.rawQuery((String)localObject2, null);
      localObject2 = new HashMap();
      if (((Cursor)localObject3).moveToNext())
      {
        String str = ((Cursor)localObject3).getString(0);
        if (((HashMap)localObject2).containsKey(str)) {}
        for (localObject1 = (List)((HashMap)localObject2).get(str);; localObject1 = new ArrayList())
        {
          com.tencent.mm.plugin.fts.a.a.m localm = new com.tencent.mm.plugin.fts.a.a.m();
          localm.BHS = ((Cursor)localObject3).getString(1);
          localm.BIZ = ((Cursor)localObject3).getLong(2);
          ((List)localObject1).add(localm);
          ((HashMap)localObject2).put(str, localObject1);
          break;
        }
      }
      ((Cursor)localObject3).close();
      paramk.BIW = new ArrayList();
      localObject1 = new com.tencent.mm.plugin.fts.a.a.m();
      ((com.tencent.mm.plugin.fts.a.a.m)localObject1).BJh = localObject2;
      paramk.BIW.add(localObject1);
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
      long l = Long.valueOf(this.BIJ.query).longValue();
      Object localObject1 = a.a(a.this);
      Object localObject2 = String.format("SELECT distinct(aux_index) FROM %s WHERE timestamp < %d AND type = %d", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).eqI(), Long.valueOf(l), Integer.valueOf(131072) });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).BGp.rawQuery((String)localObject2, null);
      paramk.BIW = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).BHS = ((Cursor)localObject1).getString(0);
        paramk.BIW.add(localObject2);
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
      paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.bJ(this.BIJ.query, true);
      Object localObject2 = a.a(a.this);
      Object localObject3 = paramk.BHY;
      Object localObject1 = this.BIJ.BIP;
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).eqQ();
      int i;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject1 = " AND type IN " + com.tencent.mm.plugin.fts.a.d.C((int[])localObject1);
        long l = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).BIA.size();
        localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject1 + " AND status >= 0 ORDER BY subtype;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject2).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqJ(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqJ(), localObject4 });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).BGp.rawQuery((String)localObject1, null);
        localObject2 = new ArrayList();
        localObject3 = new HashSet();
        ((HashSet)localObject3).addAll(this.BIJ.BIS);
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
          localObject4 = new com.tencent.mm.plugin.fts.a.a.n().k((Cursor)localObject1);
          if (i >= ((com.tencent.mm.plugin.fts.a.a.n)localObject4).BHR) {
            ((List)localObject2).add(localObject4);
          }
          for (;;)
          {
            if (!Thread.interrupted()) {
              break label397;
            }
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.BIJ.query);
            AppMethodBeat.o(52668);
            throw paramk;
            localObject1 = "";
            break;
            if (((List)localObject2).size() > this.BIJ.BIR) {
              break label399;
            }
            i = ((com.tencent.mm.plugin.fts.a.a.n)localObject4).BHR;
            ((List)localObject2).add(localObject4);
          }
        }
      }
      label399:
      ((Cursor)localObject1).close();
      paramk.BIW = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).eqT();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.BHY);
        paramk.BIW.add(localObject2);
      }
      if (this.BIJ.BIT != null) {
        Collections.sort(paramk.BIW, this.BIJ.BIT);
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
      aHR("start");
      paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.bJ(this.BIJ.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.BHY;
      Object localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).eqQ();
      long l1 = System.currentTimeMillis();
      long l2 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).BIA.size();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) AS Offsets, MMChatroomRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, entity_id, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 ORDER BY Rank, timestamp desc ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), Long.valueOf(l1 - 1209600000L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).BGp.rawQuery((String)localObject3, new String[] { ((com.tencent.mm.plugin.fts.a.a.h)localObject2).BIx });
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.BIJ.BIS);
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().j((Cursor)localObject1);
        if (((HashSet)localObject3).add(localn.BHS)) {
          if (((List)localObject2).size() <= this.BIJ.BIR)
          {
            ((List)localObject2).add(localn);
            if (Thread.interrupted())
            {
              ((Cursor)localObject1).close();
              paramk = new InterruptedException("Task is Cancel: " + this.BIJ.query);
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
      aHR("orm");
      paramk.BIW = new ArrayList(((List)localObject2).size());
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).eqT();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.BHY);
        paramk.BIW.add(localObject2);
      }
      if (Thread.interrupted())
      {
        paramk = new InterruptedException();
        AppMethodBeat.o(52669);
        throw paramk;
      }
      if (this.BIJ.BIT != null) {
        Collections.sort(paramk.BIW, this.BIJ.BIT);
      }
      aHR("calOffsets");
      if ((paramk.BHY.BIA.size() > 1) && (a.a(a.this).b(paramk.BHY)))
      {
        localObject1 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject1).BHS = "create_chatroom​";
        if (paramk.BIW.size() <= 3) {
          break label599;
        }
        paramk.BIW.add(3, localObject1);
      }
      for (;;)
      {
        aHR("checkChatroom");
        AppMethodBeat.o(52669);
        return;
        label599:
        paramk.BIW.add(localObject1);
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
      paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.bJ(this.BIJ.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.BHY;
      Object localObject3 = this.BIJ.BIP;
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).eqQ();
      long l1 = System.currentTimeMillis();
      long l2 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).BIA.size();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), MMContactRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type IN " + com.tencent.mm.plugin.fts.a.d.C((int[])localObject3) + " ORDER BY Rank ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), Long.valueOf(l1 - 1105032704L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), localObject4 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).BGp.rawQuery((String)localObject3, new String[] { ((com.tencent.mm.plugin.fts.a.a.h)localObject2).BIx });
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.BIJ.BIS);
      l1 = 0L;
      while (((Cursor)localObject1).moveToNext())
      {
        localObject4 = new com.tencent.mm.plugin.fts.a.a.n().j((Cursor)localObject1);
        if (((HashSet)localObject3).add(((com.tencent.mm.plugin.fts.a.a.n)localObject4).BHS))
        {
          if (l1 >= ((com.tencent.mm.plugin.fts.a.a.n)localObject4).BJi) {
            ((List)localObject2).add(localObject4);
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.BIJ.query);
            AppMethodBeat.o(52670);
            throw paramk;
            if (((List)localObject2).size() > this.BIJ.BIR) {
              break label407;
            }
            l1 = ((com.tencent.mm.plugin.fts.a.a.n)localObject4).BJi;
            ((List)localObject2).add(localObject4);
          }
        }
      }
      label407:
      ((Cursor)localObject1).close();
      paramk.BIW = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).eqT();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.BHY);
        paramk.BIW.add(localObject2);
      }
      if (this.BIJ.BIT != null) {
        Collections.sort(paramk.BIW, this.BIJ.BIT);
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
      paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.bJ(this.BIJ.query, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramk.BHY;
      Object localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).eqQ();
      long l1 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).BIA.size();
      long l2 = System.currentTimeMillis();
      localObject2 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), Long.valueOf(l1), Long.valueOf(l2 - 1105032704L), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject1).eqJ(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).BGp.rawQuery((String)localObject2, null);
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.BIJ.BIS);
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().k((Cursor)localObject1);
        if (((HashSet)localObject3).add(localn.BHS))
        {
          if (i >= localn.BHR) {
            ((List)localObject2).add(localn);
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException("Task is Cancel: " + this.BIJ.query);
            AppMethodBeat.o(52671);
            throw paramk;
            if (((List)localObject2).size() > this.BIJ.BIR) {
              break label345;
            }
            i = localn.BHR;
            ((List)localObject2).add(localn);
          }
        }
      }
      label345:
      ((Cursor)localObject1).close();
      paramk.BIW = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).eqT();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).a(paramk.BHY);
        paramk.BIW.add(localObject2);
      }
      if (this.BIJ.BIT != null) {
        Collections.sort(paramk.BIW, this.BIJ.BIT);
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
    private int BKG = 0;
    private int BKH = 0;
    private int BKI = 0;
    
    private v() {}
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52672);
      aHR("start");
      Object localObject1 = a.c(a.this).entrySet().iterator();
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
          a.a(a.this).NE(l);
          i += 1;
        }
        localObject2 = (String)((Map.Entry)localObject2).getKey();
        localObject3 = a.b(a.this).aHC((String)localObject2);
        if ((localObject3 != null) && (((ax)localObject3).field_username.length() > 0) && (a.this.ac((as)localObject3))) {
          i += a.this.ad((as)localObject3);
        }
        for (;;)
        {
          ((Iterator)localObject1).remove();
          a.d(a.this).remove(localObject2);
          this.BKG += 1;
          break;
          aHR("dirtyContact");
          localObject1 = a.d(a.this).iterator();
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
            l = a.b(a.this).aHE((String)localObject2);
            localObject3 = a.b(a.this).aHC((String)localObject2);
            if ((localObject3 == null) || (((ax)localObject3).field_username.length() <= 0) || (!a.this.ac((as)localObject3))) {
              break label536;
            }
            a.a(a.this).av((String)localObject2, l);
            i += 1;
          }
          for (;;)
          {
            ((Iterator)localObject1).remove();
            this.BKH += 1;
            break;
            a.a(a.this).commit();
            aHR("timestampContact");
            localObject1 = ((PluginFTS)com.tencent.mm.kernel.h.ag(PluginFTS.class)).getTopHitsLogic();
            ((e)localObject1).BLn.clear();
            this.BKI = ((e)localObject1).BLm.ert();
            aHR("topHits");
            AppMethodBeat.o(52672);
            return true;
            break label363;
          }
        }
      }
    }
    
    public final String bOl()
    {
      AppMethodBeat.i(52673);
      String str = String.format("{Dirty: %d Timestamp: %d tophitsCount: %d}", new Object[] { Integer.valueOf(this.BKG), Integer.valueOf(this.BKH), Integer.valueOf(this.BKI) });
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
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private long BKJ;
    private int BKK = 0;
    
    public w(long paramLong)
    {
      this.BKJ = paramLong;
    }
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52674);
      Object localObject1 = new ArrayList(32);
      Object localObject2 = a.a(a.this);
      long l = this.BKJ;
      localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject2).BGp.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[] { Long.toString(l) });
      while (((Cursor)localObject2).moveToNext()) {
        ((ArrayList)localObject1).add(((Cursor)localObject2).getString(0));
      }
      ((Cursor)localObject2).close();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!a.c(a.this).containsKey(localObject2))
        {
          List localList = a.a(a.this).b(c.BGH, (String)localObject2);
          a.c(a.this).put(localObject2, localList);
        }
      }
      AppMethodBeat.o(52674);
      return true;
    }
    
    public final String bOl()
    {
      AppMethodBeat.i(52675);
      String str = String.format("{mLabelId: %d mContactCount: %d}", new Object[] { Long.valueOf(this.BKJ), Integer.valueOf(this.BKK) });
      AppMethodBeat.o(52675);
      return str;
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