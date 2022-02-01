package com.tencent.mm.plugin.fts.logic;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.j.a;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.p;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.d;
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
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

public final class f
  extends b
  implements i.a
{
  private com.tencent.mm.plugin.fts.a.j Aeh;
  private boolean HvJ;
  private IListener HvK;
  private IListener HvL;
  MTimerHandler HvM;
  private j.a HvN;
  private com.tencent.mm.plugin.fts.b.f Hwf;
  private com.tencent.mm.plugin.fts.a.m msU;
  
  public f()
  {
    AppMethodBeat.i(265490);
    this.HvJ = false;
    this.HvK = new FTS5SearchServiceNotifyLogic.1(this, com.tencent.mm.app.f.hfK);
    this.HvL = new FTS5SearchServiceNotifyLogic.2(this, com.tencent.mm.app.f.hfK);
    this.HvM = new MTimerHandler(h.baH().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(265453);
        if (!f.e(f.this))
        {
          f.a(f.this, true);
          if (f.d(f.this) != null) {
            f.d(f.this).a(131112, new f.a(f.this, (byte)0));
          }
        }
        f.f(f.this).dead();
        AppMethodBeat.o(265453);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(265455);
        String str = super.toString() + "|mBackgroundTimer";
        AppMethodBeat.o(265455);
        return str;
      }
    }, false);
    this.HvN = new j.a()
    {
      public final String[] aEq(String paramAnonymousString)
      {
        AppMethodBeat.i(265446);
        if (((PluginFTS)h.az(PluginFTS.class)).getFTSIndexDB().Hqd)
        {
          paramAnonymousString = Util.listToStrings(f.aEx(paramAnonymousString));
          AppMethodBeat.o(265446);
          return paramAnonymousString;
        }
        paramAnonymousString = c.a.HrE.split(paramAnonymousString);
        AppMethodBeat.o(265446);
        return paramAnonymousString;
      }
      
      public final String[] aEr(String paramAnonymousString)
      {
        AppMethodBeat.i(265450);
        paramAnonymousString = c.a.HrE.split(paramAnonymousString, 2);
        AppMethodBeat.o(265450);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(265490);
  }
  
  public static List<String> aEx(String paramString)
  {
    AppMethodBeat.i(265491);
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
        int j = Integer.parseInt(arrayOfString[i]);
        localObject1 = paramString;
        int k = Integer.parseInt(arrayOfString[(i + 1)]);
        localObject1 = paramString;
        int m = Integer.parseInt(arrayOfString[(i + 2)]);
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
      Log.i("MicroMsg.FTS.FTS5SearchServiceNotifyLogic", "mmICUTokenize Query-tokenList: %s indexes: %s", new Object[] { localArrayList, str2 });
      AppMethodBeat.o(265491);
      return localArrayList;
      i += 3;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c a(l paraml)
  {
    AppMethodBeat.i(265509);
    switch (paraml.qRb)
    {
    case 11: 
    default: 
      paraml = new g(paraml);
    }
    for (;;)
    {
      paraml = this.msU.a(-65536, paraml);
      AppMethodBeat.o(265509);
      return paraml;
      paraml = new f(paraml);
      continue;
      paraml = new h(paraml);
    }
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(265520);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this);
    this.HvL.dead();
    this.HvK.dead();
    this.Hwf = null;
    this.msU = null;
    this.HvM.stopTimer();
    AppMethodBeat.o(265520);
    return true;
  }
  
  public final String getName()
  {
    return "FTS5SearchServiceNotifyLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(265513);
    if (!((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchServiceNotifyLogic", "Create Fail!");
      AppMethodBeat.o(265513);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchServiceNotifyLogic", "Create Success!");
    this.Hwf = ((com.tencent.mm.plugin.fts.b.f)((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(1536));
    this.msU = ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.Aeh = ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
    this.HvL.alive();
    this.HvK.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this, null);
    AppMethodBeat.o(265513);
    return true;
  }
  
  public final void onNotifyChange(i parami, i.c paramc)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(265525);
    if (CrashReportFactory.isBackupMerge())
    {
      AppMethodBeat.o(265525);
      return;
    }
    if (!"notifymessage".equals(paramc.talker))
    {
      AppMethodBeat.o(265525);
      return;
    }
    if (paramc.KRm.equals("insert"))
    {
      parami = new ArrayList();
      while (i < paramc.mZo.size())
      {
        parami.add((cc)paramc.mZo.get(i));
        i += 1;
      }
      if (parami.size() > 0) {
        this.msU.a(65576, new d(parami));
      }
      AppMethodBeat.o(265525);
      return;
    }
    if (paramc.KRm.equals("delete"))
    {
      if ((paramc.mZo != null) && (!paramc.mZo.isEmpty()))
      {
        i = j;
        while (i < paramc.mZo.size())
        {
          parami = (cc)paramc.mZo.get(i);
          this.msU.a(65576, new c(parami.field_msgId));
          i += 1;
        }
        AppMethodBeat.o(265525);
        return;
      }
      if (((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLW(paramc.talker) == 0)
      {
        Log.i("MicroMsg.FTS.FTS5SearchServiceNotifyLogic", "clear all record");
        this.msU.a(65576, new b((byte)0));
      }
    }
    AppMethodBeat.o(265525);
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
      AppMethodBeat.i(265479);
      this.rdw = f.b(f.this).rq(-201L);
      this.HvS = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bAd().aLt("");
      Log.i("MicroMsg.FTS.FTS5SearchServiceNotifyLogic", "Start building service notify index, last createTime: %s last from createTime: %s", new Object[] { Long.valueOf(this.rdw), Long.valueOf(this.HvS) });
      long l1;
      long l2;
      if (this.HvQ == null)
      {
        this.HvQ = new HashSet();
        this.HvR = new ArrayList();
        localObject1 = f.b(f.this).a(com.tencent.mm.plugin.fts.a.c.Hrg, true, true, false, true, true);
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
        AppMethodBeat.o(265479);
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
        Object localObject3 = f.c(f.this).rawQuery("SELECT msgId, createTime, content, type, isSend FROM message WHERE talker = 'notifymessage' AND createTime<=? AND createTime>? ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", (String[])localObject1);
        l1 = 0L;
        i = 0;
        f.e locale;
        while (((Cursor)localObject3).moveToNext())
        {
          locale = new f.e(f.this, (byte)0);
          locale.msgId = ((Cursor)localObject3).getLong(0);
          locale.createTime = ((Cursor)localObject3).getLong(1);
          locale.content = ((Cursor)localObject3).getString(2);
          locale.msgType = ((Cursor)localObject3).getInt(3);
          locale.HvX = ((Cursor)localObject3).getInt(4);
          locale.HvW = 56;
          locale.fxU();
          if (locale.isAvailable()) {
            ((List)localObject2).add(locale);
          }
          l1 = locale.createTime;
          i += 1;
        }
        ((Cursor)localObject3).close();
        if (Thread.interrupted())
        {
          localObject1 = new InterruptedException();
          AppMethodBeat.o(265479);
          throw ((Throwable)localObject1);
        }
        int j = ((List)localObject2).size();
        if (j == 0)
        {
          Log.i("MicroMsg.FTS.FTS5SearchServiceNotifyLogic", "build msgRecList size %d offset %s", new Object[] { Integer.valueOf(j), Integer.valueOf(this.HvT) });
          if (j <= 0) {
            break label934;
          }
          f.b(f.this).beginTransaction();
          localObject3 = ((List)localObject2).iterator();
          label564:
          if (!((Iterator)localObject3).hasNext()) {
            break label877;
          }
          locale = (f.e)((Iterator)localObject3).next();
          l1 = locale.msgId;
          l2 = locale.createTime;
          if (l2 != this.rdw) {
            break label863;
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
              f.b(f.this).a(locale.HvW, l1, locale.talker, l2, locale.HvY, locale.HvZ);
              this.Aeo += 1;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchServiceNotifyLogic", localException, "Build message index failed with exception. \n%s", new Object[] { locale.HvY });
              this.mFailedCount += 1;
            }
          }
          break label564;
          Log.i("MicroMsg.FTS.FTS5SearchServiceNotifyLogic", "build msgRecList size %d Id FROM %d to %d Time FROM %s to %s offset %s", new Object[] { Integer.valueOf(j), Long.valueOf(((f.e)((List)localObject2).get(0)).msgId), Long.valueOf(((f.e)((List)localObject2).get(j - 1)).msgId), com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd HH:mm:ss", ((f.e)((List)localObject2).get(0)).createTime / 1000L), com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd HH:mm:ss", ((f.e)((List)localObject2).get(j - 1)).createTime / 1000L), Integer.valueOf(this.HvT) });
          break;
          label863:
          this.rdw = l2;
        }
        label877:
        f.b(f.this).commit();
        f.b(f.this).aG(-201L, this.rdw);
        for (;;)
        {
          ((List)localObject2).clear();
          if (!Thread.interrupted()) {
            break;
          }
          localObject1 = new InterruptedException();
          AppMethodBeat.o(265479);
          throw ((Throwable)localObject1);
          label934:
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
          f.b(f.this).commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(265479);
          throw ((Throwable)localObject1);
        }
        if (i < 50) {
          break label1298;
        }
        f.b(f.this).commit();
        f.b(f.this).beginTransaction();
        i = 0;
      }
      label1295:
      label1298:
      for (;;)
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        f.b(f.this).a(com.tencent.mm.plugin.fts.a.c.Hrg, ((Long)((Pair)localObject2).first).longValue(), ((Long)((Pair)localObject2).second).longValue());
        i += 1;
        this.Aep += 1;
        ((Iterator)localObject1).remove();
        break;
        f.b(f.this).commit();
        i = 50;
        localObject1 = this.HvR.listIterator(this.HvR.size());
        if (((ListIterator)localObject1).hasPrevious())
        {
          if (Thread.interrupted())
          {
            f.b(f.this).commit();
            localObject1 = new InterruptedException();
            AppMethodBeat.o(265479);
            throw ((Throwable)localObject1);
          }
          if (i < 50) {
            break label1295;
          }
          f.b(f.this).commit();
          f.b(f.this).beginTransaction();
          i = 0;
        }
        for (;;)
        {
          l1 = ((Long)((ListIterator)localObject1).previous()).longValue();
          f.b(f.this).rp(l1);
          i += 1;
          this.Aep += 1;
          ((ListIterator)localObject1).remove();
          break;
          f.b(f.this).aG(-201L, this.rdw - 1L);
          f.b(f.this).commit();
          f.a(f.this, false);
          AppMethodBeat.o(265479);
          return true;
        }
      }
    }
    
    public final String coz()
    {
      AppMethodBeat.i(265483);
      String str = String.format("{new: %d removed: %d failed: %d}", new Object[] { Integer.valueOf(this.Aeo), Integer.valueOf(this.Aep), Integer.valueOf(this.mFailedCount) });
      AppMethodBeat.o(265483);
      return str;
    }
    
    public final int getId()
    {
      return 31;
    }
    
    public final String getName()
    {
      return "BuildServiceNotifyIndexTask";
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private int mCount = 0;
    
    private b() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(265467);
      f.b(f.this).F(com.tencent.mm.plugin.fts.a.c.Hrg);
      AppMethodBeat.o(265467);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(265469);
      String str = String.format("{mCount: %d}", new Object[] { Integer.valueOf(this.mCount) });
      AppMethodBeat.o(265469);
      return str;
    }
    
    public final String getName()
    {
      return "DeleteAllServiceNotifyMsgTask";
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private long lul;
    
    public c(long paramLong)
    {
      this.lul = paramLong;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(265472);
      f.b(f.this).c(com.tencent.mm.plugin.fts.a.c.Hrg, this.lul);
      AppMethodBeat.o(265472);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(265477);
      String str = String.format("{MsgId: %d}", new Object[] { Long.valueOf(this.lul) });
      AppMethodBeat.o(265477);
      return str;
    }
    
    public final String getName()
    {
      return "DeleteServiceNotifyMsgTask";
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private List<cc> HvU;
    private StringBuffer HvV;
    
    public d()
    {
      AppMethodBeat.i(265473);
      this.HvU = new ArrayList();
      Collection localCollection;
      this.HvU.addAll(localCollection);
      this.HvV = new StringBuffer();
      AppMethodBeat.o(265473);
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(265480);
      Object localObject1 = new ArrayList();
      Object localObject2 = this.HvU.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (cc)((Iterator)localObject2).next();
        f.e locale = new f.e(f.this, (byte)0);
        locale.msgId = ((fi)localObject3).field_msgId;
        locale.talker = ((fi)localObject3).field_talker;
        locale.createTime = ((cc)localObject3).getCreateTime();
        locale.content = ((fi)localObject3).field_content;
        locale.msgType = ((cc)localObject3).getType();
        locale.HvX = ((fi)localObject3).field_isSend;
        locale.fxU();
        if (locale.isAvailable()) {
          ((List)localObject1).add(locale);
        }
      }
      this.HvV.append("{MsgId: ");
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (f.e)((Iterator)localObject2).next();
        this.HvV.append(((f.e)localObject3).msgId);
        this.HvV.append(",");
        this.HvV.append(((f.e)localObject3).talker);
        this.HvV.append(",");
        this.HvV.append(((f.e)localObject3).createTime);
        this.HvV.append(" ");
      }
      this.HvV.append("count: ");
      this.HvV.append(((List)localObject1).size());
      this.HvV.append("}");
      if (((List)localObject1).size() > 0)
      {
        f.b(f.this).beginTransaction();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (f.e)((Iterator)localObject1).next();
          f.b(f.this).a(((f.e)localObject2).HvW, ((f.e)localObject2).msgId, ((f.e)localObject2).talker, ((f.e)localObject2).createTime, ((f.e)localObject2).HvY, ((f.e)localObject2).HvZ);
        }
        f.b(f.this).commit();
      }
      AppMethodBeat.o(265480);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(265485);
      String str = this.HvV.toString();
      AppMethodBeat.o(265485);
      return str;
    }
    
    public final String getName()
    {
      return "InsertServiceNotifyMsgTask";
    }
  }
  
  final class e
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
    
    private e() {}
    
    public final void fxU()
    {
      AppMethodBeat.i(265470);
      this.talker = "notifymessage";
      this.HvW = 56;
      this.HvY = this.content;
      this.HvZ = f.i.aEy(this.content).iaa;
      if (!Util.isNullOrNil(this.HvY)) {
        this.HvY = f.i.a(f.i.aEy(this.HvY));
      }
      this.content = null;
      AppMethodBeat.o(265470);
    }
    
    public final boolean isAvailable()
    {
      AppMethodBeat.i(265471);
      if (!Util.isNullOrNil(this.HvY))
      {
        AppMethodBeat.o(265471);
        return true;
      }
      AppMethodBeat.o(265471);
      return false;
    }
  }
  
  final class f
    extends k
  {
    public f(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(265468);
      aEp("start");
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.a(this.Htr.query, false, f.a(f.this));
      Cursor localCursor = f.b(f.this).a(paramm.FWt, this.Htr.Htv);
      do
      {
        if (!localCursor.moveToNext()) {
          break;
        }
        p localp = new p().j(localCursor);
        localp.HtQ = Integer.valueOf(1);
        paramm.HtF.add(localp);
      } while (paramm.HtF.size() <= 100);
      localCursor.close();
      Collections.sort(paramm.HtF, this.Htr.HtB);
      aEp("findMessage");
      AppMethodBeat.o(265468);
    }
    
    public final int getId()
    {
      return 34;
    }
    
    public final String getName()
    {
      return "SearchMessageTask";
    }
  }
  
  final class g
    extends k
  {
    g(l paraml)
    {
      super();
    }
    
    /* Error */
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      // Byte code:
      //   0: ldc 22
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: ldc 30
      //   8: invokevirtual 34	com/tencent/mm/plugin/fts/logic/f$g:aEp	(Ljava/lang/String;)V
      //   11: aload_1
      //   12: aload_0
      //   13: getfield 38	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   16: getfield 44	com/tencent/mm/plugin/fts/a/a/l:query	Ljava/lang/String;
      //   19: iconst_0
      //   20: aload_0
      //   21: getfield 13	com/tencent/mm/plugin/fts/logic/f$g:Hwg	Lcom/tencent/mm/plugin/fts/logic/f;
      //   24: invokestatic 47	com/tencent/mm/plugin/fts/logic/f:a	(Lcom/tencent/mm/plugin/fts/logic/f;)Lcom/tencent/mm/plugin/fts/a/a/j$a;
      //   27: invokestatic 52	com/tencent/mm/plugin/fts/a/a/j:a	(Ljava/lang/String;ZLcom/tencent/mm/plugin/fts/a/a/j$a;)Lcom/tencent/mm/plugin/fts/a/a/j;
      //   30: putfield 58	com/tencent/mm/plugin/fts/a/a/m:FWt	Lcom/tencent/mm/plugin/fts/a/a/j;
      //   33: aload_0
      //   34: getfield 13	com/tencent/mm/plugin/fts/logic/f$g:Hwg	Lcom/tencent/mm/plugin/fts/logic/f;
      //   37: invokestatic 62	com/tencent/mm/plugin/fts/logic/f:b	(Lcom/tencent/mm/plugin/fts/logic/f;)Lcom/tencent/mm/plugin/fts/b/f;
      //   40: pop
      //   41: aload_1
      //   42: getfield 58	com/tencent/mm/plugin/fts/a/a/m:FWt	Lcom/tencent/mm/plugin/fts/a/a/j;
      //   45: invokestatic 68	com/tencent/mm/plugin/fts/b/f:c	(Lcom/tencent/mm/plugin/fts/a/a/j;)Landroid/database/Cursor;
      //   48: astore_2
      //   49: aload_2
      //   50: ifnonnull +9 -> 59
      //   53: ldc 22
      //   55: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   58: return
      //   59: aload_2
      //   60: invokeinterface 77 1 0
      //   65: pop
      //   66: aload_2
      //   67: invokeinterface 80 1 0
      //   72: ifne +214 -> 286
      //   75: new 82	com/tencent/mm/plugin/fts/a/a/o
      //   78: dup
      //   79: invokespecial 85	com/tencent/mm/plugin/fts/a/a/o:<init>	()V
      //   82: astore_3
      //   83: aload_3
      //   84: aload_2
      //   85: iconst_0
      //   86: invokeinterface 89 2 0
      //   91: putfield 92	com/tencent/mm/plugin/fts/a/a/o:content	Ljava/lang/String;
      //   94: aload_3
      //   95: aload_2
      //   96: iconst_1
      //   97: invokeinterface 89 2 0
      //   102: putfield 95	com/tencent/mm/plugin/fts/a/a/o:Hsz	Ljava/lang/String;
      //   105: aload_3
      //   106: aload_2
      //   107: iconst_2
      //   108: invokeinterface 99 2 0
      //   113: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   116: putfield 109	com/tencent/mm/plugin/fts/a/a/o:HtQ	Ljava/lang/Object;
      //   119: aload_3
      //   120: bipush 55
      //   122: putfield 113	com/tencent/mm/plugin/fts/a/a/o:subtype	I
      //   125: aload_1
      //   126: getfield 117	com/tencent/mm/plugin/fts/a/a/m:HtF	Ljava/util/List;
      //   129: aload_3
      //   130: invokeinterface 123 2 0
      //   135: pop
      //   136: aload_2
      //   137: invokeinterface 126 1 0
      //   142: pop
      //   143: goto -77 -> 66
      //   146: astore_3
      //   147: ldc 128
      //   149: aload_3
      //   150: ldc 130
      //   152: iconst_0
      //   153: anewarray 132	java/lang/Object
      //   156: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   159: aload_2
      //   160: invokeinterface 141 1 0
      //   165: aload_0
      //   166: getfield 13	com/tencent/mm/plugin/fts/logic/f$g:Hwg	Lcom/tencent/mm/plugin/fts/logic/f;
      //   169: invokestatic 62	com/tencent/mm/plugin/fts/logic/f:b	(Lcom/tencent/mm/plugin/fts/logic/f;)Lcom/tencent/mm/plugin/fts/b/f;
      //   172: aload_1
      //   173: getfield 58	com/tencent/mm/plugin/fts/a/a/m:FWt	Lcom/tencent/mm/plugin/fts/a/a/j;
      //   176: aload_0
      //   177: getfield 38	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   180: getfield 144	com/tencent/mm/plugin/fts/a/a/l:Htv	Ljava/lang/String;
      //   183: invokevirtual 147	com/tencent/mm/plugin/fts/b/f:a	(Lcom/tencent/mm/plugin/fts/a/a/j;Ljava/lang/String;)Landroid/database/Cursor;
      //   186: astore_2
      //   187: new 149	java/util/ArrayList
      //   190: dup
      //   191: invokespecial 150	java/util/ArrayList:<init>	()V
      //   194: astore_3
      //   195: aload_2
      //   196: invokeinterface 126 1 0
      //   201: ifeq +45 -> 246
      //   204: new 152	com/tencent/mm/plugin/fts/a/a/p
      //   207: dup
      //   208: invokespecial 153	com/tencent/mm/plugin/fts/a/a/p:<init>	()V
      //   211: aload_2
      //   212: invokevirtual 157	com/tencent/mm/plugin/fts/a/a/p:j	(Landroid/database/Cursor;)Lcom/tencent/mm/plugin/fts/a/a/p;
      //   215: astore 4
      //   217: aload 4
      //   219: iconst_1
      //   220: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   223: putfield 158	com/tencent/mm/plugin/fts/a/a/p:HtQ	Ljava/lang/Object;
      //   226: aload_3
      //   227: aload 4
      //   229: invokeinterface 123 2 0
      //   234: pop
      //   235: aload_3
      //   236: invokeinterface 162 1 0
      //   241: bipush 100
      //   243: if_icmple -48 -> 195
      //   246: aload_2
      //   247: invokeinterface 141 1 0
      //   252: aload_3
      //   253: aload_0
      //   254: getfield 38	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   257: getfield 166	com/tencent/mm/plugin/fts/a/a/l:HtB	Ljava/util/Comparator;
      //   260: invokestatic 172	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
      //   263: aload_1
      //   264: getfield 117	com/tencent/mm/plugin/fts/a/a/m:HtF	Ljava/util/List;
      //   267: aload_3
      //   268: invokeinterface 176 2 0
      //   273: pop
      //   274: aload_0
      //   275: ldc 178
      //   277: invokevirtual 34	com/tencent/mm/plugin/fts/logic/f$g:aEp	(Ljava/lang/String;)V
      //   280: ldc 22
      //   282: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   285: return
      //   286: aload_2
      //   287: invokeinterface 141 1 0
      //   292: goto -127 -> 165
      //   295: astore_1
      //   296: aload_2
      //   297: invokeinterface 141 1 0
      //   302: ldc 22
      //   304: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   307: aload_1
      //   308: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	309	0	this	g
      //   0	309	1	paramm	com.tencent.mm.plugin.fts.a.a.m
      //   48	249	2	localCursor	Cursor
      //   82	48	3	localo	com.tencent.mm.plugin.fts.a.a.o
      //   146	4	3	localException	Exception
      //   194	74	3	localArrayList	ArrayList
      //   215	13	4	localp	p
      // Exception table:
      //   from	to	target	type
      //   59	66	146	java/lang/Exception
      //   66	143	146	java/lang/Exception
      //   59	66	295	finally
      //   66	143	295	finally
      //   147	159	295	finally
    }
    
    public final int getId()
    {
      return 32;
    }
    
    public final String getName()
    {
      return "SearchSenderAndMessageTask";
    }
  }
  
  final class h
    extends k
  {
    public h(l paraml)
    {
      super();
    }
    
    /* Error */
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      // Byte code:
      //   0: ldc 22
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: ldc 30
      //   8: invokevirtual 34	com/tencent/mm/plugin/fts/logic/f$h:aEp	(Ljava/lang/String;)V
      //   11: aload_1
      //   12: aload_0
      //   13: getfield 38	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   16: getfield 44	com/tencent/mm/plugin/fts/a/a/l:query	Ljava/lang/String;
      //   19: iconst_0
      //   20: aload_0
      //   21: getfield 13	com/tencent/mm/plugin/fts/logic/f$h:Hwg	Lcom/tencent/mm/plugin/fts/logic/f;
      //   24: invokestatic 47	com/tencent/mm/plugin/fts/logic/f:a	(Lcom/tencent/mm/plugin/fts/logic/f;)Lcom/tencent/mm/plugin/fts/a/a/j$a;
      //   27: invokestatic 52	com/tencent/mm/plugin/fts/a/a/j:a	(Ljava/lang/String;ZLcom/tencent/mm/plugin/fts/a/a/j$a;)Lcom/tencent/mm/plugin/fts/a/a/j;
      //   30: putfield 58	com/tencent/mm/plugin/fts/a/a/m:FWt	Lcom/tencent/mm/plugin/fts/a/a/j;
      //   33: aload_0
      //   34: getfield 13	com/tencent/mm/plugin/fts/logic/f$h:Hwg	Lcom/tencent/mm/plugin/fts/logic/f;
      //   37: invokestatic 62	com/tencent/mm/plugin/fts/logic/f:b	(Lcom/tencent/mm/plugin/fts/logic/f;)Lcom/tencent/mm/plugin/fts/b/f;
      //   40: pop
      //   41: aload_1
      //   42: getfield 58	com/tencent/mm/plugin/fts/a/a/m:FWt	Lcom/tencent/mm/plugin/fts/a/a/j;
      //   45: invokestatic 68	com/tencent/mm/plugin/fts/b/f:c	(Lcom/tencent/mm/plugin/fts/a/a/j;)Landroid/database/Cursor;
      //   48: astore_2
      //   49: aload_2
      //   50: ifnonnull +9 -> 59
      //   53: ldc 22
      //   55: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   58: return
      //   59: aload_2
      //   60: invokeinterface 77 1 0
      //   65: pop
      //   66: aload_2
      //   67: invokeinterface 80 1 0
      //   72: ifne +119 -> 191
      //   75: new 82	com/tencent/mm/plugin/fts/a/a/o
      //   78: dup
      //   79: invokespecial 85	com/tencent/mm/plugin/fts/a/a/o:<init>	()V
      //   82: astore_3
      //   83: aload_3
      //   84: aload_2
      //   85: iconst_0
      //   86: invokeinterface 89 2 0
      //   91: putfield 92	com/tencent/mm/plugin/fts/a/a/o:content	Ljava/lang/String;
      //   94: aload_3
      //   95: aload_2
      //   96: iconst_1
      //   97: invokeinterface 89 2 0
      //   102: putfield 95	com/tencent/mm/plugin/fts/a/a/o:Hsz	Ljava/lang/String;
      //   105: aload_3
      //   106: aload_2
      //   107: iconst_2
      //   108: invokeinterface 99 2 0
      //   113: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   116: putfield 109	com/tencent/mm/plugin/fts/a/a/o:HtQ	Ljava/lang/Object;
      //   119: aload_3
      //   120: bipush 55
      //   122: putfield 113	com/tencent/mm/plugin/fts/a/a/o:subtype	I
      //   125: aload_1
      //   126: getfield 117	com/tencent/mm/plugin/fts/a/a/m:HtF	Ljava/util/List;
      //   129: aload_3
      //   130: invokeinterface 123 2 0
      //   135: pop
      //   136: aload_2
      //   137: invokeinterface 126 1 0
      //   142: pop
      //   143: goto -77 -> 66
      //   146: astore_3
      //   147: ldc 128
      //   149: aload_3
      //   150: ldc 130
      //   152: iconst_0
      //   153: anewarray 132	java/lang/Object
      //   156: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   159: aload_2
      //   160: invokeinterface 141 1 0
      //   165: aload_1
      //   166: getfield 117	com/tencent/mm/plugin/fts/a/a/m:HtF	Ljava/util/List;
      //   169: aload_0
      //   170: getfield 38	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   173: getfield 145	com/tencent/mm/plugin/fts/a/a/l:HtB	Ljava/util/Comparator;
      //   176: invokestatic 151	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
      //   179: aload_0
      //   180: ldc 153
      //   182: invokevirtual 34	com/tencent/mm/plugin/fts/logic/f$h:aEp	(Ljava/lang/String;)V
      //   185: ldc 22
      //   187: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   190: return
      //   191: aload_2
      //   192: invokeinterface 141 1 0
      //   197: goto -32 -> 165
      //   200: astore_1
      //   201: aload_2
      //   202: invokeinterface 141 1 0
      //   207: ldc 22
      //   209: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   212: aload_1
      //   213: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	214	0	this	h
      //   0	214	1	paramm	com.tencent.mm.plugin.fts.a.a.m
      //   48	154	2	localCursor	Cursor
      //   82	48	3	localo	com.tencent.mm.plugin.fts.a.a.o
      //   146	4	3	localException	Exception
      // Exception table:
      //   from	to	target	type
      //   59	66	146	java/lang/Exception
      //   66	143	146	java/lang/Exception
      //   59	66	200	finally
      //   66	143	200	finally
      //   147	159	200	finally
    }
    
    public final int getId()
    {
      return 33;
    }
    
    public final String getName()
    {
      return "SearchSenderTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.logic.f
 * JD-Core Version:    0.7.0.1
 */