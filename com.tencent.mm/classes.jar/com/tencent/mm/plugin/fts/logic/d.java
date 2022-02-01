package com.tencent.mm.plugin.fts.logic;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.j.a;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.a.p;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.c;
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

public final class d
  extends com.tencent.mm.plugin.fts.a.b
  implements i.a
{
  private com.tencent.mm.plugin.fts.a.j Aeh;
  private com.tencent.mm.plugin.fts.b.d HvI;
  private boolean HvJ;
  private IListener HvK;
  private IListener HvL;
  MTimerHandler HvM;
  private j.a HvN;
  private IListener lzh;
  private IListener lzi;
  private com.tencent.mm.plugin.fts.a.m msU;
  
  public d()
  {
    AppMethodBeat.i(52735);
    this.HvJ = false;
    this.lzh = new FTS5SearchMessageLogic.1(this, com.tencent.mm.app.f.hfK);
    this.lzi = new FTS5SearchMessageLogic.2(this, com.tencent.mm.app.f.hfK);
    this.HvK = new FTS5SearchMessageLogic.3(this, com.tencent.mm.app.f.hfK);
    this.HvL = new FTS5SearchMessageLogic.4(this, com.tencent.mm.app.f.hfK);
    this.HvM = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52716);
        if (!d.e(d.this))
        {
          d.a(d.this, true);
          if (d.d(d.this) != null) {
            d.d(d.this).a(131112, new d.a(d.this, (byte)0));
          }
        }
        d.f(d.this).dead();
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
    this.HvN = new j.a()
    {
      public final String[] aEq(String paramAnonymousString)
      {
        AppMethodBeat.i(52718);
        if (((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getFTSIndexDB().Hqd)
        {
          paramAnonymousString = Util.listToStrings(d.aEx(paramAnonymousString));
          AppMethodBeat.o(52718);
          return paramAnonymousString;
        }
        paramAnonymousString = c.a.HrE.split(paramAnonymousString);
        AppMethodBeat.o(52718);
        return paramAnonymousString;
      }
      
      public final String[] aEr(String paramAnonymousString)
      {
        AppMethodBeat.i(52719);
        paramAnonymousString = c.a.HrE.split(paramAnonymousString, 2);
        AppMethodBeat.o(52719);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(52735);
  }
  
  public static List<String> aEx(String paramString)
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
  
  public final com.tencent.mm.plugin.fts.a.a.c a(l paraml)
  {
    AppMethodBeat.i(52736);
    if (paraml.HtA == null) {
      paraml.HtA = new HashSet();
    }
    paraml.HtA.add("msginfo@fakeuser");
    switch (paraml.qRb)
    {
    default: 
      paraml = new i(paraml);
    }
    for (;;)
    {
      paraml = this.msU.a(-65536, paraml);
      AppMethodBeat.o(52736);
      return paraml;
      paraml = new f(paraml);
      continue;
      Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "total message count %d", new Object[] { Long.valueOf(e.HrL.HrS) });
      if (e.HrL.HrS >= 1000000L)
      {
        paraml = new g(paraml);
      }
      else
      {
        paraml = new i(paraml);
        continue;
        paraml = new h(paraml);
        continue;
        paraml = new e(paraml);
        continue;
        paraml = new j(paraml);
      }
    }
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(52738);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this);
    this.HvL.dead();
    this.HvK.dead();
    this.lzi.dead();
    this.lzh.dead();
    this.HvI = null;
    this.msU = null;
    this.HvM.stopTimer();
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
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Fail!");
      AppMethodBeat.o(52737);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Success!");
    this.HvI = ((com.tencent.mm.plugin.fts.b.d)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(4));
    this.msU = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.Aeh = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
    this.HvL.alive();
    this.HvK.alive();
    this.lzi.alive();
    this.lzh.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this, null);
    AppMethodBeat.o(52737);
    return true;
  }
  
  public final void onNotifyChange(i parami, i.c paramc)
  {
    AppMethodBeat.i(52739);
    if (CrashReportFactory.isBackupMerge())
    {
      AppMethodBeat.o(52739);
      return;
    }
    if (paramc.KRm.equals("insert"))
    {
      parami = new ArrayList();
      int j = 0;
      if (j < paramc.mZo.size())
      {
        cc localcc = (cc)paramc.mZo.get(j);
        int i;
        if ((localcc == null) || (Util.isNullOrNil(localcc.field_talker)) || (Util.isNullOrNil(localcc.field_content))) {
          i = 0;
        }
        for (;;)
        {
          if (i != 0) {
            parami.add(localcc);
          }
          j += 1;
          break;
          if (localcc.field_talker.contains("@bottle")) {
            i = 0;
          } else if (au.bwZ(localcc.field_talker)) {
            i = 0;
          } else if ((localcc.getType() != 1) && (!localcc.fxR()) && (!localcc.fxT())) {
            i = 0;
          } else if (localcc.field_talker.equals("msginfo@fakeuser")) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (parami.size() > 0) {
        this.msU.a(65576, new c(parami));
      }
    }
    AppMethodBeat.o(52739);
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private int Aeo = 0;
    private int Aep = 0;
    private HashSet<Pair<Long, Long>> HvQ = null;
    private ArrayList<Long> HvR = null;
    private long HvS = -1L;
    private int HvT = 0;
    private int mFailedCount = 0;
    private long rdw = 9223372036854775807L;
    
    private a() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52720);
      this.rdw = d.b(d.this).rq(-200L);
      this.HvS = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bAd().aLt("");
      if (this.rdw > this.HvS)
      {
        d.b(d.this).aG(-310L, System.currentTimeMillis());
        d.b(d.this).aG(-311L, com.tencent.mm.protocal.d.Yxh);
      }
      Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: %s last from createTime: %s", new Object[] { Long.valueOf(this.rdw), Long.valueOf(this.HvS) });
      long l1;
      long l2;
      if (this.HvQ == null)
      {
        this.HvQ = new HashSet();
        this.HvR = new ArrayList();
        localObject1 = d.b(d.this).a(com.tencent.mm.plugin.fts.a.c.Hra, true, true, false, true, true);
        while (((Cursor)localObject1).moveToNext())
        {
          l1 = ((Cursor)localObject1).getLong(0);
          l2 = ((Cursor)localObject1).getLong(1);
          long l3 = ((Cursor)localObject1).getLong(2);
          if (((Cursor)localObject1).getInt(3) == -1) {
            this.HvR.add(Long.valueOf(l1));
          } else if (l3 <= this.rdw) {
            this.HvQ.add(new Pair(Long.valueOf(l2), Long.valueOf(l3)));
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
        localObject1[0] = Long.toString(this.rdw);
        localObject1[1] = Long.toString(this.HvS);
        localObject1[2] = Integer.toString(this.HvT);
        Object localObject3 = d.c(d.this).rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime>? AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", (String[])localObject1);
        l1 = 0L;
        i = 0;
        d.d locald;
        while (((Cursor)localObject3).moveToNext())
        {
          locald = new d.d(d.this, (byte)0);
          locald.msgId = ((Cursor)localObject3).getLong(0);
          locald.talker = ((Cursor)localObject3).getString(1);
          locald.createTime = ((Cursor)localObject3).getLong(2);
          locald.content = ((Cursor)localObject3).getString(3);
          locald.msgType = ((Cursor)localObject3).getInt(4);
          locald.HvX = ((Cursor)localObject3).getInt(5);
          locald.HvW = 41;
          if (d.a(locald))
          {
            locald.fxU();
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
          Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d offset %s", new Object[] { Integer.valueOf(j), Integer.valueOf(this.HvT) });
          if (j <= 0) {
            break label1001;
          }
          d.b(d.this).beginTransaction();
          localObject3 = ((List)localObject2).iterator();
          label631:
          if (!((Iterator)localObject3).hasNext()) {
            break label944;
          }
          locald = (d.d)((Iterator)localObject3).next();
          l1 = locald.msgId;
          l2 = locald.createTime;
          if (l2 != this.rdw) {
            break label930;
          }
        }
        for (this.HvT += 1;; this.HvT = 0)
        {
          for (;;)
          {
            Pair localPair = new Pair(Long.valueOf(l1), Long.valueOf(l2));
            if (this.HvQ.remove(localPair)) {
              break;
            }
            try
            {
              d.b(d.this).a(locald.HvW, l1, locald.talker, l2, locald.HvY, locald.HvZ);
              this.Aeo += 1;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", localException, "Build message index failed with exception. \n%s", new Object[] { locald.HvY });
              this.mFailedCount += 1;
            }
          }
          break label631;
          Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d Id FROM %d to %d Time FROM %s to %s offset %s", new Object[] { Integer.valueOf(j), Long.valueOf(((d.d)((List)localObject2).get(0)).msgId), Long.valueOf(((d.d)((List)localObject2).get(j - 1)).msgId), com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd HH:mm:ss", ((d.d)((List)localObject2).get(0)).createTime / 1000L), com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd HH:mm:ss", ((d.d)((List)localObject2).get(j - 1)).createTime / 1000L), Integer.valueOf(this.HvT) });
          break;
          label930:
          this.rdw = l2;
        }
        label944:
        d.b(d.this).commit();
        d.b(d.this).aG(-200L, this.rdw);
        for (;;)
        {
          ((List)localObject2).clear();
          if (!Thread.interrupted()) {
            break;
          }
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52720);
          throw ((Throwable)localObject1);
          label1001:
          this.rdw = l1;
          this.HvT = 0;
        }
      }
      i = 50;
      localObject1 = this.HvQ.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        if (Thread.interrupted())
        {
          d.b(d.this).commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52720);
          throw ((Throwable)localObject1);
        }
        if (i < 50) {
          break label1365;
        }
        d.b(d.this).commit();
        d.b(d.this).beginTransaction();
        i = 0;
      }
      label1362:
      label1365:
      for (;;)
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        d.b(d.this).a(com.tencent.mm.plugin.fts.a.c.Hra, ((Long)((Pair)localObject2).first).longValue(), ((Long)((Pair)localObject2).second).longValue());
        i += 1;
        this.Aep += 1;
        ((Iterator)localObject1).remove();
        break;
        d.b(d.this).commit();
        i = 50;
        localObject1 = this.HvR.listIterator(this.HvR.size());
        if (((ListIterator)localObject1).hasPrevious())
        {
          if (Thread.interrupted())
          {
            d.b(d.this).commit();
            localObject1 = new InterruptedException();
            AppMethodBeat.o(52720);
            throw ((Throwable)localObject1);
          }
          if (i < 50) {
            break label1362;
          }
          d.b(d.this).commit();
          d.b(d.this).beginTransaction();
          i = 0;
        }
        for (;;)
        {
          l1 = ((Long)((ListIterator)localObject1).previous()).longValue();
          d.b(d.this).rp(l1);
          i += 1;
          this.Aep += 1;
          ((ListIterator)localObject1).remove();
          break;
          d.b(d.this).aG(-200L, this.rdw - 1L);
          d.b(d.this).commit();
          d.a(d.this, false);
          AppMethodBeat.o(52720);
          return true;
        }
      }
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52721);
      String str = String.format("{new: %d removed: %d failed: %d}", new Object[] { Integer.valueOf(this.Aeo), Integer.valueOf(this.Aep), Integer.valueOf(this.mFailedCount) });
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
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private List<cc> HvU;
    private StringBuffer HvV;
    
    public c()
    {
      AppMethodBeat.i(52724);
      this.HvU = new ArrayList();
      Collection localCollection;
      this.HvU.addAll(localCollection);
      this.HvV = new StringBuffer();
      AppMethodBeat.o(52724);
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52725);
      Object localObject1 = new ArrayList();
      Object localObject2 = this.HvU.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (cc)((Iterator)localObject2).next();
        d.d locald = new d.d(d.this, (byte)0);
        locald.msgId = ((fi)localObject3).field_msgId;
        locald.talker = ((fi)localObject3).field_talker;
        locald.createTime = ((cc)localObject3).getCreateTime();
        locald.content = ((fi)localObject3).field_content;
        locald.msgType = ((cc)localObject3).getType();
        locald.HvX = ((fi)localObject3).field_isSend;
        if (d.a(locald))
        {
          locald.fxU();
          if (locald.isAvailable()) {
            ((List)localObject1).add(locald);
          }
        }
      }
      this.HvV.append("{MsgId: ");
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (d.d)((Iterator)localObject2).next();
        this.HvV.append(((d.d)localObject3).msgId);
        this.HvV.append(",");
        this.HvV.append(((d.d)localObject3).talker);
        this.HvV.append(",");
        this.HvV.append(((d.d)localObject3).createTime);
        this.HvV.append(" ");
      }
      this.HvV.append("count: ");
      this.HvV.append(((List)localObject1).size());
      this.HvV.append("}");
      if (((List)localObject1).size() > 0)
      {
        d.b(d.this).beginTransaction();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (d.d)((Iterator)localObject1).next();
          d.b(d.this).a(((d.d)localObject2).HvW, ((d.d)localObject2).msgId, ((d.d)localObject2).talker, ((d.d)localObject2).createTime, ((d.d)localObject2).HvY, ((d.d)localObject2).HvZ);
        }
        d.b(d.this).commit();
      }
      AppMethodBeat.o(52725);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52726);
      String str = this.HvV.toString();
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
    int HvW;
    int HvX;
    String HvY;
    String HvZ;
    String content;
    long createTime;
    long msgId;
    int msgType;
    String talker;
    
    private d() {}
    
    public final boolean fxR()
    {
      return (this.msgType & 0xFFFF) == 49;
    }
    
    public final boolean fxS()
    {
      return this.msgType == 1;
    }
    
    public final boolean fxT()
    {
      return this.msgType == 48;
    }
    
    public final void fxU()
    {
      AppMethodBeat.i(52727);
      if (fxS())
      {
        this.HvW = 41;
        if ((au.bwE(this.talker)) && (this.HvX == 0)) {
          this.HvY = br.JK(this.content);
        }
      }
      for (;;)
      {
        if (!Util.isNullOrNil(this.HvY)) {
          this.HvY = com.tencent.mm.plugin.fts.a.d.aEg(this.HvY);
        }
        if (!au.Hh(this.talker)) {
          break;
        }
        this.HvZ = this.talker;
        this.talker = "appbrandcustomerservicemsg";
        AppMethodBeat.o(52727);
        return;
        this.HvY = this.content;
        continue;
        Object localObject;
        if (fxR())
        {
          localObject = k.b.Hf(this.content);
          if (localObject != null) {
            switch (((k.b)localObject).type)
            {
            default: 
              break;
            case 1: 
            case 53: 
            case 57: 
              this.HvY = Util.nullAs(((k.b)localObject).getTitle(), "");
              this.HvW = 52;
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
              this.HvY = Util.nullAs(((k.b)localObject).getTitle(), "");
              this.HvW = 43;
              break;
            case 6: 
            case 74: 
              this.HvY = Util.nullAs(((k.b)localObject).getTitle(), "");
              this.HvW = 42;
              break;
            case 19: 
              this.HvY = Util.nullAs(((k.b)localObject).getDescription(), "");
              if (this.HvY != null) {
                this.HvY = this.HvY.replace(":", "​");
              }
              this.HvW = 44;
              break;
            case 24: 
              this.HvY = Util.nullAs(((k.b)localObject).getDescription(), "");
              if (this.HvY != null) {
                this.HvY = this.HvY.replace(":", "​");
              }
              this.HvW = 49;
              break;
            case 33: 
              this.HvY = Util.nullAs(((k.b)localObject).getTitle(), "");
              this.HvW = 48;
              break;
            case 2000: 
              this.HvY = (Util.nullAs(((k.b)localObject).title, "") + "​" + Util.nullAs(((k.b)localObject).description, ""));
              this.HvW = 45;
              break;
            case 2001: 
              if ("1001".equals(((k.b)localObject).nSK))
              {
                this.HvW = 47;
                if (this.HvX == 1)
                {
                  this.HvY = (Util.nullAs(((k.b)localObject).nSI, "") + "​" + Util.nullAs(((k.b)localObject).nSF, ""));
                  continue;
                }
                this.HvY = (Util.nullAs(((k.b)localObject).nSI, "") + "​" + Util.nullAs(((k.b)localObject).nSE, ""));
                continue;
              }
              if (!"1002".equals(((k.b)localObject).nSK)) {
                continue;
              }
              this.HvW = 46;
              if (this.HvX == 1)
              {
                this.HvY = (Util.nullAs(((k.b)localObject).nSI, "") + "​" + Util.nullAs(((k.b)localObject).nSF, ""));
                continue;
              }
              this.HvY = (Util.nullAs(((k.b)localObject).nSI, "") + "​" + Util.nullAs(((k.b)localObject).nSE, ""));
              break;
            case 51: 
              this.HvY = Util.nullAs(((com.tencent.mm.plugin.findersdk.a.f)((k.b)localObject).aK(com.tencent.mm.plugin.findersdk.a.f.class)).getNickname(), "");
              this.HvW = 53;
              break;
            }
          }
        }
        else if (fxT())
        {
          this.HvW = 50;
          if (au.bwE(this.talker)) {}
          for (localObject = br.JK(this.content);; localObject = this.content)
          {
            localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLV((String)localObject);
            if (!((cc.c)localObject).jcw()) {
              break label907;
            }
            this.HvY = (((cc.c)localObject).poiName + "​" + ((cc.c)localObject).label);
            break;
          }
          label907:
          this.HvY = ((cc.c)localObject).label;
        }
      }
      if (this.HvX == 1)
      {
        this.HvZ = z.bAM();
        AppMethodBeat.o(52727);
        return;
      }
      if (au.bwE(this.talker))
      {
        this.HvZ = Util.nullAs(br.JJ(this.content), this.talker);
        AppMethodBeat.o(52727);
        return;
      }
      this.HvZ = this.talker;
      AppMethodBeat.o(52727);
    }
    
    public final boolean isAvailable()
    {
      AppMethodBeat.i(52728);
      if (!Util.isNullOrNil(this.HvY))
      {
        AppMethodBeat.o(52728);
        return true;
      }
      AppMethodBeat.o(52728);
      return false;
    }
  }
  
  final class e
    extends k
  {
    public e(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52729);
      aEp("start");
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.a(this.Htr.query, false, d.a(d.this));
      Object localObject1 = com.tencent.mm.plugin.fts.a.a.j.cc(this.Htr.Htw, true);
      HashMap localHashMap = new HashMap();
      Object localObject2 = ((com.tencent.mm.plugin.fts.b.b)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.j)localObject1, this.Htr.talker, com.tencent.mm.plugin.fts.a.c.Hrl, com.tencent.mm.plugin.fts.a.c.Hrp);
      do
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break;
        }
        localObject3 = new p();
        ((o)localObject3).Hsz = ((Cursor)localObject2).getString(0);
        ((o)localObject3).type = ((Cursor)localObject2).getInt(1);
        ((o)localObject3).subtype = ((Cursor)localObject2).getInt(2);
        ((o)localObject3).FWt = ((com.tencent.mm.plugin.fts.a.a.j)localObject1);
        if (!localHashMap.containsKey(((o)localObject3).Hsz)) {
          localHashMap.put(((o)localObject3).Hsz, localObject3);
        }
      } while (localHashMap.size() <= 100);
      ((Cursor)localObject2).close();
      aEp("findHitContact");
      localObject2 = d.b(d.this).a(paramm.FWt, this.Htr.Htv, localHashMap.keySet());
      Object localObject3 = new HashMap();
      if (((Cursor)localObject2).moveToNext())
      {
        p localp = new p().j((Cursor)localObject2);
        localp.FWt = paramm.FWt;
        localp.HtQ = Integer.valueOf(1);
        if (((HashMap)localObject3).containsKey(localp.talker)) {}
        for (localObject1 = (List)((HashMap)localObject3).get(localp.talker);; localObject1 = new ArrayList())
        {
          ((List)localObject1).add(localp);
          ((HashMap)localObject3).put(localp.talker, localObject1);
          break;
        }
      }
      ((Cursor)localObject2).close();
      paramm.HtF = new ArrayList();
      localObject1 = ((HashMap)localObject3).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = (o)localHashMap.get(((Map.Entry)localObject2).getKey());
        if (localObject3 != null)
        {
          Collections.sort((List)((Map.Entry)localObject2).getValue(), this.Htr.HtB);
          ((o)localObject3).HtQ = ((Map.Entry)localObject2).getValue();
          ((o)localObject3).timestamp = ((o)((List)((Map.Entry)localObject2).getValue()).get(0)).timestamp;
          paramm.HtF.add(localObject3);
        }
      }
      Collections.sort(paramm.HtF, this.Htr.HtB);
      aEp("findHitMessage");
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
    extends k
  {
    f(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52730);
      aEp("start");
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.a(this.Htr.query, false, d.a(d.this));
      Object localObject1 = d.b(d.this);
      Object localObject3 = paramm.FWt;
      Object localObject2 = this.Htr.Htv;
      localObject3 = ((com.tencent.mm.plugin.fts.a.a.j)localObject3).fxx();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.b.d)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.d)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.d)localObject1).fxo(), ((com.tencent.mm.plugin.fts.b.d)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.d)localObject1).fxo(), ((com.tencent.mm.plugin.fts.b.d)localObject1).fxo(), localObject3 });
      localObject1 = ((a)localObject1).HqR.rawQuery((String)localObject3, new String[] { localObject2 });
      paramm.HtF = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new p().j((Cursor)localObject1);
        ((p)localObject2).HtQ = Integer.valueOf(1);
        paramm.HtF.add(localObject2);
      }
      ((Cursor)localObject1).close();
      aEp("findConversationMessage");
      if ((paramm.FWt.Hth.length > 1) && (!this.Htr.HtA.contains("create_talker_message​")))
      {
        localObject1 = com.tencent.mm.plugin.fts.a.a.j.cc(paramm.FWt.Hth[0], true);
        localObject1 = ((com.tencent.mm.plugin.fts.b.b)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.j)localObject1, null, com.tencent.mm.plugin.fts.a.c.Hrl, com.tencent.mm.plugin.fts.a.c.Hrp);
        if (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new o();
          ((o)localObject2).Hsz = "create_talker_message​";
          paramm.HtF.add(0, localObject2);
        }
        ((Cursor)localObject1).close();
        aEp("findTalkerConversation");
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
    extends k
  {
    public g(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52731);
      aEp("start");
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.a(this.Htr.query, false, d.a(d.this));
      Object localObject1 = d.b(d.this);
      Object localObject2 = paramm.FWt.fxx();
      localObject2 = String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.b.d)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.d)localObject1).fxo(), ((com.tencent.mm.plugin.fts.b.d)localObject1).fxn(), ((com.tencent.mm.plugin.fts.b.d)localObject1).fxo(), ((com.tencent.mm.plugin.fts.b.d)localObject1).fxo(), localObject2 });
      localObject2 = ((a)localObject1).HqR.rawQuery((String)localObject2, null);
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
          locala.subtype = ((Cursor)localObject2).getInt(1);
          locala.HtI = ((Cursor)localObject2).getLong(2);
          locala.Hsz = ((Cursor)localObject2).getString(3);
          locala.timestamp = ((Cursor)localObject2).getLong(4);
          ((List)localObject1).add(locala);
          ((List)localObject4).add(str);
        }
      } while (((List)localObject1).size() <= this.Htr.Htz);
      ((Cursor)localObject2).close();
      paramm.HtF = new LinkedList();
      aEp("findUsername");
      if (((List)localObject4).size() > 0)
      {
        localObject3 = d.b(d.this).a(paramm.FWt, (List)localObject4);
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
          localObject4 = new o();
          ((o)localObject4).type = ((a)localObject3).type;
          ((o)localObject4).subtype = ((a)localObject3).subtype;
          ((o)localObject4).HtI = ((a)localObject3).HtI;
          ((o)localObject4).Hsz = ((a)localObject3).Hsz;
          ((o)localObject4).timestamp = ((a)localObject3).timestamp;
          if (!((HashMap)localObject2).containsKey(((o)localObject4).Hsz)) {
            break label699;
          }
        }
      }
      label699:
      for (int i = ((Integer)((HashMap)localObject2).get(((o)localObject4).Hsz)).intValue();; i = 1)
      {
        if (au.bwy(((o)localObject4).Hsz)) {
          i = 0;
        }
        ((o)localObject4).HtQ = Integer.valueOf(i);
        paramm.HtF.add(localObject4);
        break;
        aEp("findCount");
        if ((paramm.FWt.Hth.length > 1) && (paramm.HtF.size() <= 3))
        {
          localObject1 = com.tencent.mm.plugin.fts.a.a.j.cc(paramm.FWt.Hth[0], true);
          localObject1 = ((com.tencent.mm.plugin.fts.b.b)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.j)localObject1, null, com.tencent.mm.plugin.fts.a.c.Hrl, com.tencent.mm.plugin.fts.a.c.Hrp);
          if (((Cursor)localObject1).moveToNext())
          {
            localObject2 = new o();
            ((o)localObject2).Hsz = "create_talker_message​";
            paramm.HtF.add(localObject2);
          }
          ((Cursor)localObject1).close();
          aEp("findTalkerConversation");
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
      String Hsz;
      long HtI;
      int subtype;
      long timestamp;
      int type;
      
      private a() {}
    }
  }
  
  final class h
    extends k
  {
    public h(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52732);
      aEp("start");
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.a(this.Htr.query, false, d.a(d.this));
      Object localObject1 = com.tencent.mm.plugin.fts.a.a.j.cc(this.Htr.Htw, true);
      Object localObject2 = new HashMap();
      Object localObject3 = ((com.tencent.mm.plugin.fts.b.b)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.j)localObject1, null, com.tencent.mm.plugin.fts.a.c.Hrl, com.tencent.mm.plugin.fts.a.c.Hrp);
      do
      {
        if (!((Cursor)localObject3).moveToNext()) {
          break;
        }
        localObject4 = new p();
        ((p)localObject4).Hsz = ((Cursor)localObject3).getString(0);
        ((p)localObject4).type = ((Cursor)localObject3).getInt(1);
        ((p)localObject4).subtype = ((Cursor)localObject3).getInt(2);
        ((p)localObject4).FWt = ((com.tencent.mm.plugin.fts.a.a.j)localObject1);
        ((p)localObject4).HtQ = Integer.valueOf(1);
        if (!((HashMap)localObject2).containsKey(((p)localObject4).Hsz)) {
          ((HashMap)localObject2).put(((p)localObject4).Hsz, localObject4);
        }
      } while (((HashMap)localObject2).size() <= 100);
      ((Cursor)localObject3).close();
      aEp("findHitContact");
      Object localObject4 = d.b(d.this).a(paramm.FWt, null, ((HashMap)localObject2).keySet());
      localObject3 = new HashMap();
      if (((Cursor)localObject4).moveToNext())
      {
        p localp = new p().j((Cursor)localObject4);
        localp.FWt = paramm.FWt;
        localp.HtQ = Integer.valueOf(1);
        label306:
        o localo;
        int i;
        if (((HashMap)localObject3).containsKey(localp.talker))
        {
          localObject1 = (HashMap)((HashMap)localObject3).get(localp.talker);
          if (!((HashMap)localObject1).containsKey(localp.Hsz)) {
            break label431;
          }
          localo = (o)((HashMap)localObject1).get(localp.Hsz);
          i = ((Integer)localo.HtQ).intValue() + 1;
          if (localo.timestamp >= localp.timestamp) {
            break label407;
          }
          localp.HtQ = Integer.valueOf(i);
          ((HashMap)localObject1).put(localp.Hsz, localp);
        }
        for (;;)
        {
          ((HashMap)localObject3).put(localp.talker, localObject1);
          break;
          localObject1 = new HashMap();
          break label306;
          label407:
          localo.HtQ = Integer.valueOf(i);
          ((HashMap)localObject1).put(localo.Hsz, localo);
          continue;
          label431:
          ((HashMap)localObject1).put(localp.Hsz, localp);
        }
      }
      ((Cursor)localObject4).close();
      paramm.HtF = new ArrayList();
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (o)((Iterator)localObject1).next();
        if (((HashMap)localObject3).containsKey(((o)localObject2).Hsz))
        {
          localObject4 = new ArrayList();
          ((List)localObject4).addAll(((HashMap)((HashMap)localObject3).get(((o)localObject2).Hsz)).values());
          Collections.sort((List)localObject4, this.Htr.HtB);
          ((o)localObject2).HtQ = localObject4;
          ((o)localObject2).timestamp = ((o)((List)localObject4).get(0)).timestamp;
          paramm.HtF.add(localObject2);
        }
      }
      Collections.sort(paramm.HtF, this.Htr.HtB);
      aEp("findHitMessage");
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
    extends k
  {
    private int Hwb = 0;
    private int Hwc = 0;
    
    public i(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52733);
      aEp("start");
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.a(this.Htr.query, false, d.a(d.this));
      Object localObject2 = d.b(d.this);
      Object localObject1 = paramm.FWt;
      int i = this.Htr.Htz;
      String str = ((com.tencent.mm.plugin.fts.a.a.j)localObject1).fxx();
      if (i != 2147483647) {}
      for (localObject1 = " LIMIT " + (i + 1);; localObject1 = "")
      {
        localObject1 = String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (String)localObject1 + ";", new Object[] { ((com.tencent.mm.plugin.fts.b.d)localObject2).fxn(), ((com.tencent.mm.plugin.fts.b.d)localObject2).fxo(), ((com.tencent.mm.plugin.fts.b.d)localObject2).fxn(), ((com.tencent.mm.plugin.fts.b.d)localObject2).fxo(), ((com.tencent.mm.plugin.fts.b.d)localObject2).fxo(), str });
        localObject1 = ((a)localObject2).HqR.rawQuery((String)localObject1, null);
        paramm.HtF = new LinkedList();
        while (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new o();
          ((o)localObject2).type = ((Cursor)localObject1).getInt(0);
          ((o)localObject2).subtype = ((Cursor)localObject1).getInt(1);
          ((o)localObject2).HtI = ((Cursor)localObject1).getLong(2);
          ((o)localObject2).Hsz = ((Cursor)localObject1).getString(3);
          ((o)localObject2).timestamp = ((Cursor)localObject1).getLong(4);
          int j = ((Cursor)localObject1).getInt(5);
          i = j;
          if (j == 1)
          {
            i = j;
            if (au.bwy(((o)localObject2).Hsz)) {
              i = 0;
            }
          }
          ((o)localObject2).HtQ = Integer.valueOf(i);
          paramm.HtF.add(localObject2);
          i = this.Hwb;
          this.Hwb = (((Integer)((o)localObject2).HtQ).intValue() + i);
          this.Hwc += 1;
        }
      }
      ((Cursor)localObject1).close();
      aEp("groupMessage");
      if (paramm.FWt.Hth.length > 1)
      {
        localObject1 = com.tencent.mm.plugin.fts.a.a.j.cc(paramm.FWt.Hth[0], true);
        localObject1 = ((com.tencent.mm.plugin.fts.b.b)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.j)localObject1, null, com.tencent.mm.plugin.fts.a.c.Hrl, com.tencent.mm.plugin.fts.a.c.Hrp);
        if (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new o();
          ((o)localObject2).Hsz = "create_talker_message​";
          paramm.HtF.add(0, localObject2);
        }
        ((Cursor)localObject1).close();
        aEp("findTalkerConversation");
      }
      AppMethodBeat.o(52733);
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52734);
      String str = String.format("{totalMsgCount: %d conversationCount: %d}", new Object[] { Integer.valueOf(this.Hwb), Integer.valueOf(this.Hwc) });
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
    extends k
  {
    public j(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(265464);
      aEp("start");
      paramm.HtF = new LinkedList();
      Cursor localCursor = d.b(d.this).e(this.Htr.Hty, this.Htr.Htv);
      while (localCursor.moveToNext())
      {
        o localo = new o();
        localo.type = localCursor.getInt(0);
        localo.subtype = localCursor.getInt(1);
        localo.HtI = localCursor.getLong(2);
        localo.Hsz = localCursor.getString(3);
        localo.timestamp = localCursor.getLong(4);
        localo.talker = localCursor.getString(5);
        paramm.HtF.add(localo);
      }
      localCursor.close();
      AppMethodBeat.o(265464);
    }
    
    public final String getName()
    {
      return "SearchTypeMessage";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.logic.d
 * JD-Core Version:    0.7.0.1
 */