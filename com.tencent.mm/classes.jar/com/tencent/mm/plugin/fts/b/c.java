package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.vu;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.h.a;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public final class c
  extends b
  implements i.a
{
  private com.tencent.mm.plugin.fts.c.c BKP;
  private boolean BKQ;
  private IListener BKR;
  private IListener BKS;
  MTimerHandler BKT;
  private h.a BKU;
  private IListener iXe;
  private IListener iXf;
  private com.tencent.mm.plugin.fts.a.m jSC;
  private com.tencent.mm.plugin.fts.a.j wHT;
  
  public c()
  {
    AppMethodBeat.i(52735);
    this.BKQ = false;
    this.iXe = new c.1(this);
    this.iXf = new c.2(this);
    this.BKR = new IListener() {};
    this.BKS = new IListener() {};
    this.BKT = new MTimerHandler(com.tencent.mm.kernel.h.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52716);
        if (!c.e(c.this))
        {
          c.a(c.this, true);
          if (c.d(c.this) != null) {
            c.d(c.this).a(131112, new c.a(c.this, (byte)0));
          }
        }
        EventCenter.instance.removeListener(c.f(c.this));
        AppMethodBeat.o(52716);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(52717);
        String str = super.toString() + "|mBackgroundTimer";
        AppMethodBeat.o(52717);
        return str;
      }
    }, false);
    this.BKU = new h.a()
    {
      public final String[] aHS(String paramAnonymousString)
      {
        AppMethodBeat.i(52718);
        if (((PluginFTS)com.tencent.mm.kernel.h.ag(PluginFTS.class)).getFTSIndexDB().BFB)
        {
          paramAnonymousString = Util.listToStrings(c.aHZ(paramAnonymousString));
          AppMethodBeat.o(52718);
          return paramAnonymousString;
        }
        paramAnonymousString = com.tencent.mm.plugin.fts.a.c.a.BHa.split(paramAnonymousString);
        AppMethodBeat.o(52718);
        return paramAnonymousString;
      }
      
      public final String[] aHT(String paramAnonymousString)
      {
        AppMethodBeat.i(52719);
        paramAnonymousString = com.tencent.mm.plugin.fts.a.c.a.BHa.split(paramAnonymousString, 2);
        AppMethodBeat.o(52719);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(52735);
  }
  
  public static List<String> aHZ(String paramString)
  {
    AppMethodBeat.i(52740);
    String str1 = paramString;
    if (paramString.length() > 16) {
      str1 = paramString.substring(0, 16);
    }
    ArrayList localArrayList = new ArrayList();
    String str2 = FTSJNIUtils.icuTokenizer(str1);
    String[] arrayOfString = str2.split(" ");
    paramString = new StringBuffer();
    int i = 0;
    for (;;)
    {
      if (i < arrayOfString.length) {
        localObject1 = paramString;
      }
      try
      {
        int j = Integer.valueOf(arrayOfString[i]).intValue();
        localObject1 = paramString;
        int k = Integer.valueOf(arrayOfString[(i + 1)]).intValue();
        localObject1 = paramString;
        int m = Integer.valueOf(arrayOfString[(i + 2)]).intValue();
        localObject1 = paramString;
        String str3 = str1.substring(j, k);
        Object localObject2;
        if ((m >= 400) && (m < 500))
        {
          if (k - j == 1)
          {
            localObject1 = paramString;
            paramString.append(str3);
          }
          else
          {
            localObject2 = paramString;
            localObject1 = paramString;
            if (paramString.length() > 0)
            {
              localObject1 = paramString;
              localArrayList.add(paramString.toString());
              localObject1 = paramString;
              localObject2 = new StringBuffer();
            }
            localObject1 = localObject2;
            localArrayList.add(str3);
            paramString = (String)localObject2;
          }
        }
        else
        {
          localObject2 = paramString;
          localObject1 = paramString;
          if (paramString.length() > 0)
          {
            localObject1 = paramString;
            localArrayList.add(paramString.toString());
            localObject1 = paramString;
            localObject2 = new StringBuffer();
          }
          paramString = (String)localObject2;
          localObject1 = localObject2;
          if (!str3.equals("*"))
          {
            paramString = (String)localObject2;
            localObject1 = localObject2;
            if (!str3.equals(" "))
            {
              localObject1 = localObject2;
              localArrayList.add(str3);
              paramString = (String)localObject2;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = (String)localObject1;
        }
      }
      if (paramString.length() > 0) {
        localArrayList.add(paramString.toString());
      }
      Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "mmICUTokenize Query-tokenList: %s indexes: %s", new Object[] { localArrayList, str2 });
      AppMethodBeat.o(52740);
      return localArrayList;
      i += 3;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(52736);
    switch (paramj.nRn)
    {
    default: 
      paramj = new i(paramj);
    }
    for (;;)
    {
      paramj = this.jSC.a(-65536, paramj);
      AppMethodBeat.o(52736);
      return paramj;
      paramj = new f(paramj);
      continue;
      Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "total message count %d", new Object[] { Long.valueOf(e.BHh.BHn) });
      if (e.BHh.BHn >= 1000000L)
      {
        paramj = new g(paramj);
      }
      else
      {
        paramj = new i(paramj);
        continue;
        paramj = new h(paramj);
        continue;
        paramj = new e(paramj);
        continue;
        paramj = new j(paramj);
      }
    }
  }
  
  public final boolean aEt()
  {
    AppMethodBeat.i(52738);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(this);
    this.BKS.dead();
    this.BKR.dead();
    this.iXf.dead();
    this.iXe.dead();
    this.BKP = null;
    this.jSC = null;
    this.BKT.stopTimer();
    AppMethodBeat.o(52738);
    return true;
  }
  
  public final String getName()
  {
    return "FTS5SearchMessageLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(52737);
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Fail!");
      AppMethodBeat.o(52737);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Success!");
    this.BKP = ((com.tencent.mm.plugin.fts.c.c)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(4));
    this.jSC = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.wHT = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
    this.BKS.alive();
    this.BKR.alive();
    this.iXf.alive();
    this.iXe.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(this, null);
    AppMethodBeat.o(52737);
    return true;
  }
  
  public final void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(52739);
    if (CrashReportFactory.isBackupMerge())
    {
      AppMethodBeat.o(52739);
      return;
    }
    if (paramc.EVM.equals("insert"))
    {
      parami = new ArrayList();
      int j = 0;
      if (j < paramc.kvM.size())
      {
        ca localca = (ca)paramc.kvM.get(j);
        int i;
        if ((localca == null) || (Util.isNullOrNil(localca.field_talker)) || (Util.isNullOrNil(localca.field_content))) {
          i = 0;
        }
        for (;;)
        {
          if (i != 0) {
            parami.add(localca);
          }
          j += 1;
          break;
          if (localca.field_talker.contains("@bottle")) {
            i = 0;
          } else if (as.bvS(localca.field_talker)) {
            i = 0;
          } else if ((localca.getType() != 1) && (!localca.erk()) && (!localca.erm())) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (parami.size() > 0) {
        this.jSC.a(65576, new c(parami));
      }
    }
    AppMethodBeat.o(52739);
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private HashSet<Pair<Long, Long>> BKX = null;
    private ArrayList<Long> BKY = null;
    private long BKZ = -1L;
    private int BLa = 0;
    private int mFailedCount = 0;
    private long ocG = 9223372036854775807L;
    private int wIa = 0;
    private int wIb = 0;
    
    private a() {}
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52720);
      this.ocG = c.b(c.this).BGp.ac(-200L, 9223372036854775807L);
      this.BKZ = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bco().aOu("");
      if (this.ocG > this.BKZ)
      {
        c.b(c.this).ad(-310L, System.currentTimeMillis());
        c.b(c.this).ad(-311L, com.tencent.mm.protocal.d.RAD);
      }
      Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: %s last from createTime: %s", new Object[] { Long.valueOf(this.ocG), Long.valueOf(this.BKZ) });
      long l1;
      long l2;
      if (this.BKX == null)
      {
        this.BKX = new HashSet();
        this.BKY = new ArrayList();
        localObject1 = c.b(c.this).a(com.tencent.mm.plugin.fts.a.c.BGy, true, true, false, true, true);
        while (((Cursor)localObject1).moveToNext())
        {
          l1 = ((Cursor)localObject1).getLong(0);
          l2 = ((Cursor)localObject1).getLong(1);
          long l3 = ((Cursor)localObject1).getLong(2);
          if (((Cursor)localObject1).getInt(3) == -1) {
            this.BKY.add(Long.valueOf(l1));
          } else if (l3 <= this.ocG) {
            this.BKX.add(new Pair(Long.valueOf(l2), Long.valueOf(l3)));
          }
        }
        ((Cursor)localObject1).close();
      }
      if (Thread.interrupted())
      {
        localObject1 = new InterruptedException();
        AppMethodBeat.o(52720);
        throw ((Throwable)localObject1);
      }
      int i = 2147483647;
      Object localObject1 = new String[3];
      Object localObject2 = new ArrayList();
      if (i >= 50)
      {
        localObject1[0] = Long.toString(this.ocG);
        localObject1[1] = Long.toString(this.BKZ);
        localObject1[2] = Integer.toString(this.BLa);
        Object localObject3 = c.c(c.this).rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime>? AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", (String[])localObject1);
        l1 = 0L;
        i = 0;
        c.d locald;
        while (((Cursor)localObject3).moveToNext())
        {
          locald = new c.d(c.this, (byte)0);
          locald.msgId = ((Cursor)localObject3).getLong(0);
          locald.talker = ((Cursor)localObject3).getString(1);
          locald.createTime = ((Cursor)localObject3).getLong(2);
          locald.content = ((Cursor)localObject3).getString(3);
          locald.msgType = ((Cursor)localObject3).getInt(4);
          locald.BLe = ((Cursor)localObject3).getInt(5);
          locald.BLd = 41;
          if (c.a(locald))
          {
            locald.ern();
            if (locald.isAvailable()) {
              ((List)localObject2).add(locald);
            }
          }
          l1 = locald.createTime;
          i += 1;
        }
        ((Cursor)localObject3).close();
        if (Thread.interrupted())
        {
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52720);
          throw ((Throwable)localObject1);
        }
        int j = ((List)localObject2).size();
        if (j == 0)
        {
          Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d offset %s", new Object[] { Integer.valueOf(j), Integer.valueOf(this.BLa) });
          if (j <= 0) {
            break label1009;
          }
          c.b(c.this).beginTransaction();
          localObject3 = ((List)localObject2).iterator();
          label639:
          if (!((Iterator)localObject3).hasNext()) {
            break label952;
          }
          locald = (c.d)((Iterator)localObject3).next();
          l1 = locald.msgId;
          l2 = locald.createTime;
          if (l2 != this.ocG) {
            break label938;
          }
        }
        for (this.BLa += 1;; this.BLa = 0)
        {
          for (;;)
          {
            Pair localPair = new Pair(Long.valueOf(l1), Long.valueOf(l2));
            if (this.BKX.remove(localPair)) {
              break;
            }
            try
            {
              c.b(c.this).a(locald.BLd, l1, locald.talker, l2, locald.BLf, locald.BLg);
              this.wIa += 1;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", localException, "Build message index failed with exception. \n%s", new Object[] { locald.BLf });
              this.mFailedCount += 1;
            }
          }
          break label639;
          Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d Id FROM %d to %d Time FROM %s to %s offset %s", new Object[] { Integer.valueOf(j), Long.valueOf(((c.d)((List)localObject2).get(0)).msgId), Long.valueOf(((c.d)((List)localObject2).get(j - 1)).msgId), com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd HH:mm:ss", ((c.d)((List)localObject2).get(0)).createTime / 1000L), com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd HH:mm:ss", ((c.d)((List)localObject2).get(j - 1)).createTime / 1000L), Integer.valueOf(this.BLa) });
          break;
          label938:
          this.ocG = l2;
        }
        label952:
        c.b(c.this).commit();
        c.b(c.this).ad(-200L, this.ocG);
        for (;;)
        {
          ((List)localObject2).clear();
          if (!Thread.interrupted()) {
            break;
          }
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52720);
          throw ((Throwable)localObject1);
          label1009:
          this.ocG = l1;
          this.BLa = 0;
        }
      }
      i = 50;
      localObject1 = this.BKX.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        if (Thread.interrupted())
        {
          c.b(c.this).commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52720);
          throw ((Throwable)localObject1);
        }
        if (i < 50) {
          break label1373;
        }
        c.b(c.this).commit();
        c.b(c.this).beginTransaction();
        i = 0;
      }
      label1370:
      label1373:
      for (;;)
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        c.b(c.this).a(com.tencent.mm.plugin.fts.a.c.BGy, ((Long)((Pair)localObject2).first).longValue(), ((Long)((Pair)localObject2).second).longValue());
        i += 1;
        this.wIb += 1;
        ((Iterator)localObject1).remove();
        break;
        c.b(c.this).commit();
        i = 50;
        localObject1 = this.BKY.listIterator(this.BKY.size());
        if (((ListIterator)localObject1).hasPrevious())
        {
          if (Thread.interrupted())
          {
            c.b(c.this).commit();
            localObject1 = new InterruptedException();
            AppMethodBeat.o(52720);
            throw ((Throwable)localObject1);
          }
          if (i < 50) {
            break label1370;
          }
          c.b(c.this).commit();
          c.b(c.this).beginTransaction();
          i = 0;
        }
        for (;;)
        {
          l1 = ((Long)((ListIterator)localObject1).previous()).longValue();
          c.b(c.this).NE(l1);
          i += 1;
          this.wIb += 1;
          ((ListIterator)localObject1).remove();
          break;
          c.b(c.this).ad(-200L, this.ocG - 1L);
          c.b(c.this).commit();
          c.a(c.this, false);
          AppMethodBeat.o(52720);
          return true;
        }
      }
    }
    
    public final String bOl()
    {
      AppMethodBeat.i(52721);
      String str = String.format("{new: %d removed: %d failed: %d}", new Object[] { Integer.valueOf(this.wIa), Integer.valueOf(this.wIb), Integer.valueOf(this.mFailedCount) });
      AppMethodBeat.o(52721);
      return str;
    }
    
    public final int getId()
    {
      return 4;
    }
    
    public final String getName()
    {
      return "BuildMessageIndexTask";
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private List<ca> BLb;
    private StringBuffer BLc;
    
    public c()
    {
      AppMethodBeat.i(52724);
      this.BLb = new ArrayList();
      Collection localCollection;
      this.BLb.addAll(localCollection);
      this.BLc = new StringBuffer();
      AppMethodBeat.o(52724);
    }
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52725);
      Object localObject1 = new ArrayList();
      Object localObject2 = this.BLb.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ca)((Iterator)localObject2).next();
        c.d locald = new c.d(c.this, (byte)0);
        locald.msgId = ((et)localObject3).field_msgId;
        locald.talker = ((et)localObject3).field_talker;
        locald.createTime = ((et)localObject3).field_createTime;
        locald.content = ((et)localObject3).field_content;
        locald.msgType = ((ca)localObject3).getType();
        locald.BLe = ((et)localObject3).field_isSend;
        if (c.a(locald))
        {
          locald.ern();
          if (locald.isAvailable()) {
            ((List)localObject1).add(locald);
          }
        }
      }
      this.BLc.append("{MsgId: ");
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (c.d)((Iterator)localObject2).next();
        this.BLc.append(((c.d)localObject3).msgId);
        this.BLc.append(",");
        this.BLc.append(((c.d)localObject3).talker);
        this.BLc.append(",");
        this.BLc.append(((c.d)localObject3).createTime);
        this.BLc.append(" ");
      }
      this.BLc.append("count: ");
      this.BLc.append(((List)localObject1).size());
      this.BLc.append("}");
      if (((List)localObject1).size() > 0)
      {
        c.b(c.this).beginTransaction();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c.d)((Iterator)localObject1).next();
          c.b(c.this).a(((c.d)localObject2).BLd, ((c.d)localObject2).msgId, ((c.d)localObject2).talker, ((c.d)localObject2).createTime, ((c.d)localObject2).BLf, ((c.d)localObject2).BLg);
        }
        c.b(c.this).commit();
      }
      AppMethodBeat.o(52725);
      return true;
    }
    
    public final String bOl()
    {
      AppMethodBeat.i(52726);
      String str = this.BLc.toString();
      AppMethodBeat.o(52726);
      return str;
    }
    
    public final String getName()
    {
      return "InsertMessageTask";
    }
  }
  
  final class d
  {
    int BLd;
    int BLe;
    String BLf;
    String BLg;
    String content;
    long createTime;
    long msgId;
    int msgType;
    String talker;
    
    private d() {}
    
    public final boolean erk()
    {
      return (this.msgType & 0xFFFF) == 49;
    }
    
    public final boolean erl()
    {
      return this.msgType == 1;
    }
    
    public final boolean erm()
    {
      return this.msgType == 48;
    }
    
    public final void ern()
    {
      AppMethodBeat.i(52727);
      if (erl())
      {
        this.BLd = 41;
        if ((ab.Lj(this.talker)) && (this.BLe == 0)) {
          this.BLf = bq.RM(this.content);
        }
      }
      for (;;)
      {
        if (!Util.isNullOrNil(this.BLf)) {
          this.BLf = com.tencent.mm.plugin.fts.a.d.aHI(this.BLf);
        }
        if (!as.OS(this.talker)) {
          break;
        }
        this.BLg = this.talker;
        this.talker = "appbrandcustomerservicemsg";
        AppMethodBeat.o(52727);
        return;
        this.BLf = this.content;
        continue;
        Object localObject;
        if (erk())
        {
          localObject = k.b.OQ(this.content);
          if (localObject != null) {
            switch (((k.b)localObject).type)
            {
            default: 
              break;
            case 1: 
            case 53: 
            case 57: 
              this.BLf = Util.nullAs(((k.b)localObject).getTitle(), "");
              this.BLd = 52;
              break;
            case 3: 
            case 4: 
            case 5: 
            case 8: 
            case 10: 
            case 13: 
            case 15: 
            case 16: 
            case 20: 
            case 25: 
              this.BLf = Util.nullAs(((k.b)localObject).getTitle(), "");
              this.BLd = 43;
              break;
            case 6: 
            case 74: 
              this.BLf = Util.nullAs(((k.b)localObject).getTitle(), "");
              this.BLd = 42;
              break;
            case 19: 
              this.BLf = Util.nullAs(((k.b)localObject).getDescription(), "");
              if (this.BLf != null) {
                this.BLf = this.BLf.replace(":", "​");
              }
              this.BLd = 44;
              break;
            case 24: 
              this.BLf = Util.nullAs(((k.b)localObject).getDescription(), "");
              if (this.BLf != null) {
                this.BLf = this.BLf.replace(":", "​");
              }
              this.BLd = 49;
              break;
            case 33: 
              this.BLf = Util.nullAs(((k.b)localObject).getTitle(), "");
              this.BLd = 48;
              break;
            case 2000: 
              this.BLf = (Util.nullAs(((k.b)localObject).title, "") + "​" + Util.nullAs(((k.b)localObject).description, ""));
              this.BLd = 45;
              break;
            case 2001: 
              if ("1001".equals(((k.b)localObject).lnG))
              {
                this.BLd = 47;
                if (this.BLe == 1)
                {
                  this.BLf = (Util.nullAs(((k.b)localObject).lnE, "") + "​" + Util.nullAs(((k.b)localObject).lnB, ""));
                  continue;
                }
                this.BLf = (Util.nullAs(((k.b)localObject).lnE, "") + "​" + Util.nullAs(((k.b)localObject).lnA, ""));
                continue;
              }
              if (!"1002".equals(((k.b)localObject).lnG)) {
                continue;
              }
              this.BLd = 46;
              if (this.BLe == 1)
              {
                this.BLf = (Util.nullAs(((k.b)localObject).lnE, "") + "​" + Util.nullAs(((k.b)localObject).lnB, ""));
                continue;
              }
              this.BLf = (Util.nullAs(((k.b)localObject).lnE, "") + "​" + Util.nullAs(((k.b)localObject).lnA, ""));
              break;
            case 51: 
              this.BLf = Util.nullAs(((com.tencent.mm.plugin.findersdk.a.f)((k.b)localObject).ar(com.tencent.mm.plugin.findersdk.a.f.class)).mbi.nickname, "");
              this.BLd = 53;
              break;
            }
          }
        }
        else if (erm())
        {
          this.BLd = 50;
          if (ab.Lj(this.talker)) {}
          for (localObject = bq.RM(this.content);; localObject = this.content)
          {
            localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aOV((String)localObject);
            if (!((ca.b)localObject).hAq()) {
              break label910;
            }
            this.BLf = (((ca.b)localObject).poiName + "​" + ((ca.b)localObject).label);
            break;
          }
          label910:
          this.BLf = ((ca.b)localObject).label;
        }
      }
      if (this.BLe == 1)
      {
        this.BLg = z.bcZ();
        AppMethodBeat.o(52727);
        return;
      }
      if (ab.Lj(this.talker))
      {
        this.BLg = Util.nullAs(bq.RL(this.content), this.talker);
        AppMethodBeat.o(52727);
        return;
      }
      this.BLg = this.talker;
      AppMethodBeat.o(52727);
    }
    
    public final boolean isAvailable()
    {
      AppMethodBeat.i(52728);
      if (!Util.isNullOrNil(this.BLf))
      {
        AppMethodBeat.o(52728);
        return true;
      }
      AppMethodBeat.o(52728);
      return false;
    }
  }
  
  final class e
    extends com.tencent.mm.plugin.fts.a.a.i
  {
    public e(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52729);
      aHR("start");
      paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.a(this.BIJ.query, false, c.a(c.this));
      Object localObject1 = com.tencent.mm.plugin.fts.a.a.h.bJ(this.BIJ.BIO, true);
      HashMap localHashMap = new HashMap();
      Object localObject2 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, this.BIJ.talker, com.tencent.mm.plugin.fts.a.c.BGH, com.tencent.mm.plugin.fts.a.c.BGL);
      do
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break;
        }
        localObject3 = new com.tencent.mm.plugin.fts.a.a.n();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).BHS = ((Cursor)localObject2).getString(0);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).type = ((Cursor)localObject2).getInt(1);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).BHR = ((Cursor)localObject2).getInt(2);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).BHY = ((com.tencent.mm.plugin.fts.a.a.h)localObject1);
        if (!localHashMap.containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject3).BHS)) {
          localHashMap.put(((com.tencent.mm.plugin.fts.a.a.m)localObject3).BHS, localObject3);
        }
      } while (localHashMap.size() <= 100);
      ((Cursor)localObject2).close();
      aHR("findHitContact");
      localObject2 = c.b(c.this).a(paramk.BHY, this.BIJ.BIN, localHashMap.keySet());
      Object localObject3 = new HashMap();
      if (((Cursor)localObject2).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject2);
        localn.BHY = paramk.BHY;
        localn.BJh = Integer.valueOf(1);
        if (((HashMap)localObject3).containsKey(localn.talker)) {}
        for (localObject1 = (List)((HashMap)localObject3).get(localn.talker);; localObject1 = new ArrayList())
        {
          ((List)localObject1).add(localn);
          ((HashMap)localObject3).put(localn.talker, localObject1);
          break;
        }
      }
      ((Cursor)localObject2).close();
      paramk.BIW = new ArrayList();
      localObject1 = ((HashMap)localObject3).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = (com.tencent.mm.plugin.fts.a.a.m)localHashMap.get(((Map.Entry)localObject2).getKey());
        if (localObject3 != null)
        {
          Collections.sort((List)((Map.Entry)localObject2).getValue(), this.BIJ.BIT);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject3).BJh = ((Map.Entry)localObject2).getValue();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject3).timestamp = ((com.tencent.mm.plugin.fts.a.a.m)((List)((Map.Entry)localObject2).getValue()).get(0)).timestamp;
          paramk.BIW.add(localObject3);
        }
      }
      Collections.sort(paramk.BIW, this.BIJ.BIT);
      aHR("findHitMessage");
      AppMethodBeat.o(52729);
    }
    
    public final int getId()
    {
      return 29;
    }
    
    public final String getName()
    {
      return "SearchConvTalkerMessageTask";
    }
  }
  
  final class f
    extends com.tencent.mm.plugin.fts.a.a.i
  {
    f(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52730);
      aHR("start");
      paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.a(this.BIJ.query, false, c.a(c.this));
      Object localObject1 = c.b(c.this);
      Object localObject3 = paramk.BHY;
      Object localObject2 = this.BIJ.BIN;
      localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).eqQ();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.c)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.c)localObject1).eqJ(), ((com.tencent.mm.plugin.fts.c.c)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.c)localObject1).eqJ(), ((com.tencent.mm.plugin.fts.c.c)localObject1).eqJ(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).BGp.rawQuery((String)localObject3, new String[] { localObject2 });
      paramk.BIW = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject1);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).BJh = Integer.valueOf(1);
        paramk.BIW.add(localObject2);
      }
      ((Cursor)localObject1).close();
      aHR("findConversationMessage");
      if ((paramk.BHY.BIz.length > 1) && (!this.BIJ.BIS.contains("create_talker_message​")))
      {
        localObject1 = com.tencent.mm.plugin.fts.a.a.h.bJ(paramk.BHY.BIz[0], true);
        localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.BGH, com.tencent.mm.plugin.fts.a.c.BGL);
        if (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).BHS = "create_talker_message​";
          paramk.BIW.add(0, localObject2);
        }
        ((Cursor)localObject1).close();
        aHR("findTalkerConversation");
      }
      AppMethodBeat.o(52730);
    }
    
    public final int getId()
    {
      return 14;
    }
    
    public final String getName()
    {
      return "SearchConversationMessageTask";
    }
  }
  
  final class g
    extends com.tencent.mm.plugin.fts.a.a.i
  {
    public g(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52731);
      aHR("start");
      paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.a(this.BIJ.query, false, c.a(c.this));
      Object localObject1 = c.b(c.this);
      Object localObject2 = paramk.BHY.eqQ();
      localObject2 = String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.c)localObject1).eqJ(), ((com.tencent.mm.plugin.fts.c.c)localObject1).eqI(), ((com.tencent.mm.plugin.fts.c.c)localObject1).eqJ(), ((com.tencent.mm.plugin.fts.c.c)localObject1).eqJ(), localObject2 });
      localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject1).BGp.rawQuery((String)localObject2, null);
      localObject1 = new ArrayList();
      Object localObject3 = new HashSet();
      Object localObject4 = new ArrayList();
      do
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break;
        }
        String str = ((Cursor)localObject2).getString(3);
        if (((HashSet)localObject3).add(str))
        {
          a locala = new a((byte)0);
          locala.type = ((Cursor)localObject2).getInt(0);
          locala.BHR = ((Cursor)localObject2).getInt(1);
          locala.BIZ = ((Cursor)localObject2).getLong(2);
          locala.BHS = ((Cursor)localObject2).getString(3);
          locala.timestamp = ((Cursor)localObject2).getLong(4);
          ((List)localObject1).add(locala);
          ((List)localObject4).add(str);
        }
      } while (((List)localObject1).size() <= this.BIJ.BIR);
      ((Cursor)localObject2).close();
      paramk.BIW = new LinkedList();
      aHR("findUsername");
      if (((List)localObject4).size() > 0)
      {
        localObject3 = c.b(c.this).a(paramk.BHY, (List)localObject4);
        localObject2 = new HashMap();
        if (((Cursor)localObject3).moveToNext())
        {
          localObject4 = ((Cursor)localObject3).getString(0).split(" ");
          i = 0;
          while (i < localObject4.length)
          {
            ((HashMap)localObject2).put(localObject4[i], Integer.valueOf(Util.getInt(localObject4[(i + 1)], 0)));
            i += 2;
          }
        }
        ((Cursor)localObject3).close();
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (a)((Iterator)localObject1).next();
          localObject4 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).type = ((a)localObject3).type;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).BHR = ((a)localObject3).BHR;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).BIZ = ((a)localObject3).BIZ;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).BHS = ((a)localObject3).BHS;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).timestamp = ((a)localObject3).timestamp;
          if (!((HashMap)localObject2).containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject4).BHS)) {
            break label699;
          }
        }
      }
      label699:
      for (int i = ((Integer)((HashMap)localObject2).get(((com.tencent.mm.plugin.fts.a.a.m)localObject4).BHS)).intValue();; i = 1)
      {
        if (ab.QU(((com.tencent.mm.plugin.fts.a.a.m)localObject4).BHS)) {
          i = 0;
        }
        ((com.tencent.mm.plugin.fts.a.a.m)localObject4).BJh = Integer.valueOf(i);
        paramk.BIW.add(localObject4);
        break;
        aHR("findCount");
        if ((paramk.BHY.BIz.length > 1) && (paramk.BIW.size() <= 3))
        {
          localObject1 = com.tencent.mm.plugin.fts.a.a.h.bJ(paramk.BHY.BIz[0], true);
          localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.BGH, com.tencent.mm.plugin.fts.a.c.BGL);
          if (((Cursor)localObject1).moveToNext())
          {
            localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
            ((com.tencent.mm.plugin.fts.a.a.m)localObject2).BHS = "create_talker_message​";
            paramk.BIW.add(localObject2);
          }
          ((Cursor)localObject1).close();
          aHR("findTalkerConversation");
        }
        AppMethodBeat.o(52731);
        return;
      }
    }
    
    public final int getId()
    {
      return 24;
    }
    
    public final String getName()
    {
      return "SearchLimitGroupMessage";
    }
    
    final class a
    {
      int BHR;
      String BHS;
      long BIZ;
      long timestamp;
      int type;
      
      private a() {}
    }
  }
  
  final class h
    extends com.tencent.mm.plugin.fts.a.a.i
  {
    public h(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52732);
      aHR("start");
      paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.a(this.BIJ.query, false, c.a(c.this));
      Object localObject1 = com.tencent.mm.plugin.fts.a.a.h.bJ(this.BIJ.BIO, true);
      Object localObject2 = new HashMap();
      Object localObject3 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.BGH, com.tencent.mm.plugin.fts.a.c.BGL);
      do
      {
        if (!((Cursor)localObject3).moveToNext()) {
          break;
        }
        localObject4 = new com.tencent.mm.plugin.fts.a.a.n();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).BHS = ((Cursor)localObject3).getString(0);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).type = ((Cursor)localObject3).getInt(1);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).BHR = ((Cursor)localObject3).getInt(2);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).BHY = ((com.tencent.mm.plugin.fts.a.a.h)localObject1);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).BJh = Integer.valueOf(1);
        if (!((HashMap)localObject2).containsKey(((com.tencent.mm.plugin.fts.a.a.n)localObject4).BHS)) {
          ((HashMap)localObject2).put(((com.tencent.mm.plugin.fts.a.a.n)localObject4).BHS, localObject4);
        }
      } while (((HashMap)localObject2).size() <= 100);
      ((Cursor)localObject3).close();
      aHR("findHitContact");
      Object localObject4 = c.b(c.this).a(paramk.BHY, null, ((HashMap)localObject2).keySet());
      localObject3 = new HashMap();
      if (((Cursor)localObject4).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject4);
        localn.BHY = paramk.BHY;
        localn.BJh = Integer.valueOf(1);
        label306:
        com.tencent.mm.plugin.fts.a.a.m localm;
        int i;
        if (((HashMap)localObject3).containsKey(localn.talker))
        {
          localObject1 = (HashMap)((HashMap)localObject3).get(localn.talker);
          if (!((HashMap)localObject1).containsKey(localn.BHS)) {
            break label431;
          }
          localm = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject1).get(localn.BHS);
          i = ((Integer)localm.BJh).intValue() + 1;
          if (localm.timestamp >= localn.timestamp) {
            break label407;
          }
          localn.BJh = Integer.valueOf(i);
          ((HashMap)localObject1).put(localn.BHS, localn);
        }
        for (;;)
        {
          ((HashMap)localObject3).put(localn.talker, localObject1);
          break;
          localObject1 = new HashMap();
          break label306;
          label407:
          localm.BJh = Integer.valueOf(i);
          ((HashMap)localObject1).put(localm.BHS, localm);
          continue;
          label431:
          ((HashMap)localObject1).put(localn.BHS, localn);
        }
      }
      ((Cursor)localObject4).close();
      paramk.BIW = new ArrayList();
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.m)((Iterator)localObject1).next();
        if (((HashMap)localObject3).containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject2).BHS))
        {
          localObject4 = new ArrayList();
          ((List)localObject4).addAll(((HashMap)((HashMap)localObject3).get(((com.tencent.mm.plugin.fts.a.a.m)localObject2).BHS)).values());
          Collections.sort((List)localObject4, this.BIJ.BIT);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).BJh = localObject4;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).timestamp = ((com.tencent.mm.plugin.fts.a.a.m)((List)localObject4).get(0)).timestamp;
          paramk.BIW.add(localObject2);
        }
      }
      Collections.sort(paramk.BIW, this.BIJ.BIT);
      aHR("findHitMessage");
      AppMethodBeat.o(52732);
    }
    
    public final int getId()
    {
      return 28;
    }
    
    public final String getName()
    {
      return "SearchTalkerMessageTask";
    }
  }
  
  final class i
    extends com.tencent.mm.plugin.fts.a.a.i
  {
    private int BLi = 0;
    private int BLj = 0;
    
    public i(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52733);
      aHR("start");
      paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.a(this.BIJ.query, false, c.a(c.this));
      Object localObject2 = c.b(c.this);
      Object localObject1 = paramk.BHY;
      int i = this.BIJ.BIR;
      String str = ((com.tencent.mm.plugin.fts.a.a.h)localObject1).eqQ();
      if (i != 2147483647) {}
      for (localObject1 = " LIMIT " + (i + 1);; localObject1 = "")
      {
        localObject1 = String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (String)localObject1 + ";", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject2).eqI(), ((com.tencent.mm.plugin.fts.c.c)localObject2).eqJ(), ((com.tencent.mm.plugin.fts.c.c)localObject2).eqI(), ((com.tencent.mm.plugin.fts.c.c)localObject2).eqJ(), ((com.tencent.mm.plugin.fts.c.c)localObject2).eqJ(), str });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).BGp.rawQuery((String)localObject1, null);
        paramk.BIW = new LinkedList();
        while (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).type = ((Cursor)localObject1).getInt(0);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).BHR = ((Cursor)localObject1).getInt(1);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).BIZ = ((Cursor)localObject1).getLong(2);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).BHS = ((Cursor)localObject1).getString(3);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).timestamp = ((Cursor)localObject1).getLong(4);
          int j = ((Cursor)localObject1).getInt(5);
          i = j;
          if (j == 1)
          {
            i = j;
            if (ab.QU(((com.tencent.mm.plugin.fts.a.a.m)localObject2).BHS)) {
              i = 0;
            }
          }
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).BJh = Integer.valueOf(i);
          paramk.BIW.add(localObject2);
          i = this.BLi;
          this.BLi = (((Integer)((com.tencent.mm.plugin.fts.a.a.m)localObject2).BJh).intValue() + i);
          this.BLj += 1;
        }
      }
      ((Cursor)localObject1).close();
      aHR("groupMessage");
      if (paramk.BHY.BIz.length > 1)
      {
        localObject1 = com.tencent.mm.plugin.fts.a.a.h.bJ(paramk.BHY.BIz[0], true);
        localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.BGH, com.tencent.mm.plugin.fts.a.c.BGL);
        if (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).BHS = "create_talker_message​";
          paramk.BIW.add(0, localObject2);
        }
        ((Cursor)localObject1).close();
        aHR("findTalkerConversation");
      }
      AppMethodBeat.o(52733);
    }
    
    public final String bOl()
    {
      AppMethodBeat.i(52734);
      String str = String.format("{totalMsgCount: %d conversationCount: %d}", new Object[] { Integer.valueOf(this.BLi), Integer.valueOf(this.BLj) });
      AppMethodBeat.o(52734);
      return str;
    }
    
    public final int getId()
    {
      return 15;
    }
    
    public final String getName()
    {
      return "SearchTopGroupMessageTask";
    }
  }
  
  final class j
    extends com.tencent.mm.plugin.fts.a.a.i
  {
    public j(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(254260);
      aHR("start");
      paramk.BIW = new LinkedList();
      Cursor localCursor = c.b(c.this).d(this.BIJ.BIQ, this.BIJ.BIN);
      while (localCursor.moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.m localm = new com.tencent.mm.plugin.fts.a.a.m();
        localm.type = localCursor.getInt(0);
        localm.BHR = localCursor.getInt(1);
        localm.BIZ = localCursor.getLong(2);
        localm.BHS = localCursor.getString(3);
        localm.timestamp = localCursor.getLong(4);
        localm.talker = localCursor.getString(5);
        paramk.BIW.add(localm);
      }
      localCursor.close();
      AppMethodBeat.o(254260);
    }
    
    public final String getName()
    {
      return "SearchTypeMessage";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c
 * JD-Core Version:    0.7.0.1
 */