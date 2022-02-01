package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
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
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bcj;
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
  private IListener gsS;
  private IListener gsT;
  com.tencent.mm.plugin.fts.a.m hgI;
  com.tencent.mm.plugin.fts.a.j tbO;
  com.tencent.mm.plugin.fts.c.c wYQ;
  boolean wYR;
  private IListener wYS;
  IListener wYT;
  MTimerHandler wYU;
  h.a wYV;
  
  public c()
  {
    AppMethodBeat.i(52735);
    this.wYR = false;
    this.gsS = new IListener() {};
    this.gsT = new IListener() {};
    this.wYS = new IListener() {};
    this.wYT = new IListener() {};
    this.wYU = new MTimerHandler(g.aAk().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52716);
        if (!c.this.wYR)
        {
          c.this.wYR = true;
          if (c.this.hgI != null) {
            c.this.hgI.a(131112, new c.a(c.this, (byte)0));
          }
        }
        EventCenter.instance.removeListener(c.this.wYT);
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
    this.wYV = new h.a()
    {
      public final String[] ayy(String paramAnonymousString)
      {
        AppMethodBeat.i(52719);
        paramAnonymousString = com.tencent.mm.plugin.fts.a.c.a.wVe.split(paramAnonymousString, 2);
        AppMethodBeat.o(52719);
        return paramAnonymousString;
      }
      
      public final String[] split(String paramAnonymousString)
      {
        AppMethodBeat.i(52718);
        if (((PluginFTS)g.ah(PluginFTS.class)).getFTSIndexDB().wTE)
        {
          paramAnonymousString = Util.listToStrings(c.ayE(paramAnonymousString));
          AppMethodBeat.o(52718);
          return paramAnonymousString;
        }
        paramAnonymousString = com.tencent.mm.plugin.fts.a.c.a.wVe.split(paramAnonymousString);
        AppMethodBeat.o(52718);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(52735);
  }
  
  public static List<String> ayE(String paramString)
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
    switch (paramj.kXb)
    {
    default: 
      paramj = new i(paramj);
    }
    for (;;)
    {
      paramj = this.hgI.a(-65536, paramj);
      AppMethodBeat.o(52736);
      return paramj;
      paramj = new f(paramj);
      continue;
      Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "total message count %d", new Object[] { Long.valueOf(e.wVl.wVr) });
      if (e.wVl.wVr >= 1000000L)
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
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(52739);
    if (paramc.zqn.equals("insert"))
    {
      parami = new ArrayList();
      int j = 0;
      if (j < paramc.hIs.size())
      {
        ca localca = (ca)paramc.hIs.get(j);
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
          } else if (as.bjw(localca.field_talker)) {
            i = 0;
          } else if ((localca.getType() != 1) && (!localca.dOQ()) && (!localca.dOS())) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (parami.size() > 0) {
        this.hgI.a(65576, new c(parami));
      }
    }
    AppMethodBeat.o(52739);
  }
  
  public final boolean axa()
  {
    AppMethodBeat.i(52738);
    ((l)g.af(l.class)).eiy().a(this);
    this.wYT.dead();
    this.wYS.dead();
    this.gsT.dead();
    this.gsS.dead();
    this.wYQ = null;
    this.hgI = null;
    this.wYU.stopTimer();
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
    if (!((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Fail!");
      AppMethodBeat.o(52737);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Success!");
    this.wYQ = ((com.tencent.mm.plugin.fts.c.c)((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(4));
    this.hgI = ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.tbO = ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
    this.wYT.alive();
    this.wYS.alive();
    this.gsT.alive();
    this.gsS.alive();
    ((l)g.af(l.class)).eiy().a(this, null);
    AppMethodBeat.o(52737);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private long lhY = 9223372036854775807L;
    private int mFailedCount = 0;
    private int tbV = 0;
    private int tbW = 0;
    private HashSet<Pair<Long, Long>> wYY = null;
    private ArrayList<Long> wYZ = null;
    private long wZa = -1L;
    private int wZb = 0;
    
    private a() {}
    
    public final String bCQ()
    {
      AppMethodBeat.i(52721);
      String str = String.format("{new: %d removed: %d failed: %d}", new Object[] { Integer.valueOf(this.tbV), Integer.valueOf(this.tbW), Integer.valueOf(this.mFailedCount) });
      AppMethodBeat.o(52721);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52720);
      this.lhY = c.this.wYQ.wUt.V(-200L, 9223372036854775807L);
      this.wZa = ((l)g.af(l.class)).aTq().aEk("");
      if (this.lhY > this.wZa)
      {
        c.this.wYQ.W(-310L, System.currentTimeMillis());
        c.this.wYQ.W(-311L, com.tencent.mm.protocal.d.KyO);
      }
      Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: %s last from createTime: %s", new Object[] { Long.valueOf(this.lhY), Long.valueOf(this.wZa) });
      long l1;
      long l2;
      if (this.wYY == null)
      {
        this.wYY = new HashSet();
        this.wYZ = new ArrayList();
        localObject1 = c.this.wYQ.a(com.tencent.mm.plugin.fts.a.c.wUC, true, true, false, true, true);
        while (((Cursor)localObject1).moveToNext())
        {
          l1 = ((Cursor)localObject1).getLong(0);
          l2 = ((Cursor)localObject1).getLong(1);
          long l3 = ((Cursor)localObject1).getLong(2);
          if (((Cursor)localObject1).getInt(3) == -1) {
            this.wYZ.add(Long.valueOf(l1));
          } else if (l3 <= this.lhY) {
            this.wYY.add(new Pair(Long.valueOf(l2), Long.valueOf(l3)));
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
        localObject1[0] = Long.toString(this.lhY);
        localObject1[1] = Long.toString(this.wZa);
        localObject1[2] = Integer.toString(this.wZb);
        Object localObject3 = c.this.tbO.rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime>? AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", (String[])localObject1);
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
          locald.wZf = ((Cursor)localObject3).getInt(5);
          locald.wZe = 41;
          if (c.a(locald))
          {
            locald.dOT();
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
          Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d offset %s", new Object[] { Integer.valueOf(j), Integer.valueOf(this.wZb) });
          if (j <= 0) {
            break label1009;
          }
          c.this.wYQ.beginTransaction();
          localObject3 = ((List)localObject2).iterator();
          label639:
          if (!((Iterator)localObject3).hasNext()) {
            break label952;
          }
          locald = (c.d)((Iterator)localObject3).next();
          l1 = locald.msgId;
          l2 = locald.createTime;
          if (l2 != this.lhY) {
            break label938;
          }
        }
        for (this.wZb += 1;; this.wZb = 0)
        {
          for (;;)
          {
            Pair localPair = new Pair(Long.valueOf(l1), Long.valueOf(l2));
            if (this.wYY.remove(localPair)) {
              break;
            }
            try
            {
              c.this.wYQ.a(locald.wZe, l1, locald.talker, l2, locald.wZg, locald.wZh);
              this.tbV += 1;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", localException, "Build message index failed with exception. \n%s", new Object[] { locald.wZg });
              this.mFailedCount += 1;
            }
          }
          break label639;
          Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d Id FROM %d to %d Time FROM %s to %s offset %s", new Object[] { Integer.valueOf(j), Long.valueOf(((c.d)((List)localObject2).get(0)).msgId), Long.valueOf(((c.d)((List)localObject2).get(j - 1)).msgId), com.tencent.mm.pluginsdk.i.f.formatTime("yyyy-MM-dd HH:mm:ss", ((c.d)((List)localObject2).get(0)).createTime / 1000L), com.tencent.mm.pluginsdk.i.f.formatTime("yyyy-MM-dd HH:mm:ss", ((c.d)((List)localObject2).get(j - 1)).createTime / 1000L), Integer.valueOf(this.wZb) });
          break;
          label938:
          this.lhY = l2;
        }
        label952:
        c.this.wYQ.commit();
        c.this.wYQ.W(-200L, this.lhY);
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
          this.lhY = l1;
          this.wZb = 0;
        }
      }
      i = 50;
      localObject1 = this.wYY.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        if (Thread.interrupted())
        {
          c.this.wYQ.commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52720);
          throw ((Throwable)localObject1);
        }
        if (i < 50) {
          break label1372;
        }
        c.this.wYQ.commit();
        c.this.wYQ.beginTransaction();
        i = 0;
      }
      label1369:
      label1372:
      for (;;)
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        c.this.wYQ.a(com.tencent.mm.plugin.fts.a.c.wUC, ((Long)((Pair)localObject2).first).longValue(), ((Long)((Pair)localObject2).second).longValue());
        i += 1;
        this.tbW += 1;
        ((Iterator)localObject1).remove();
        break;
        c.this.wYQ.commit();
        i = 50;
        localObject1 = this.wYZ.listIterator(this.wYZ.size());
        if (((ListIterator)localObject1).hasPrevious())
        {
          if (Thread.interrupted())
          {
            c.this.wYQ.commit();
            localObject1 = new InterruptedException();
            AppMethodBeat.o(52720);
            throw ((Throwable)localObject1);
          }
          if (i < 50) {
            break label1369;
          }
          c.this.wYQ.commit();
          c.this.wYQ.beginTransaction();
          i = 0;
        }
        for (;;)
        {
          l1 = ((Long)((ListIterator)localObject1).previous()).longValue();
          c.this.wYQ.GC(l1);
          i += 1;
          this.tbW += 1;
          ((ListIterator)localObject1).remove();
          break;
          c.this.wYQ.W(-200L, this.lhY - 1L);
          c.this.wYQ.commit();
          c.this.wYR = false;
          AppMethodBeat.o(52720);
          return true;
        }
      }
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
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private long gof;
    
    public b(long paramLong)
    {
      this.gof = paramLong;
    }
    
    public final String bCQ()
    {
      AppMethodBeat.i(52723);
      String str = String.format("{MsgId: %d}", new Object[] { Long.valueOf(this.gof) });
      AppMethodBeat.o(52723);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52722);
      c.this.wYQ.c(com.tencent.mm.plugin.fts.a.c.wUC, this.gof);
      AppMethodBeat.o(52722);
      return true;
    }
    
    public final String getName()
    {
      return "DeleteMessageTask";
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private List<ca> wZc;
    private StringBuffer wZd;
    
    public c()
    {
      AppMethodBeat.i(52724);
      this.wZc = new ArrayList();
      Collection localCollection;
      this.wZc.addAll(localCollection);
      this.wZd = new StringBuffer();
      AppMethodBeat.o(52724);
    }
    
    public final String bCQ()
    {
      AppMethodBeat.i(52726);
      String str = this.wZd.toString();
      AppMethodBeat.o(52726);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52725);
      Object localObject1 = new ArrayList();
      Object localObject2 = this.wZc.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ca)((Iterator)localObject2).next();
        c.d locald = new c.d(c.this, (byte)0);
        locald.msgId = ((eo)localObject3).field_msgId;
        locald.talker = ((eo)localObject3).field_talker;
        locald.createTime = ((eo)localObject3).field_createTime;
        locald.content = ((eo)localObject3).field_content;
        locald.msgType = ((ca)localObject3).getType();
        locald.wZf = ((eo)localObject3).field_isSend;
        if (c.a(locald))
        {
          locald.dOT();
          if (locald.isAvailable()) {
            ((List)localObject1).add(locald);
          }
        }
      }
      this.wZd.append("{MsgId: ");
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (c.d)((Iterator)localObject2).next();
        this.wZd.append(((c.d)localObject3).msgId);
        this.wZd.append(",");
        this.wZd.append(((c.d)localObject3).talker);
        this.wZd.append(",");
        this.wZd.append(((c.d)localObject3).createTime);
        this.wZd.append(" ");
      }
      this.wZd.append("count: ");
      this.wZd.append(((List)localObject1).size());
      this.wZd.append("}");
      if (((List)localObject1).size() > 0)
      {
        c.this.wYQ.beginTransaction();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c.d)((Iterator)localObject1).next();
          c.this.wYQ.a(((c.d)localObject2).wZe, ((c.d)localObject2).msgId, ((c.d)localObject2).talker, ((c.d)localObject2).createTime, ((c.d)localObject2).wZg, ((c.d)localObject2).wZh);
        }
        c.this.wYQ.commit();
      }
      AppMethodBeat.o(52725);
      return true;
    }
    
    public final String getName()
    {
      return "InsertMessageTask";
    }
  }
  
  final class d
  {
    String content;
    long createTime;
    long msgId;
    int msgType;
    String talker;
    int wZe;
    int wZf;
    String wZg;
    String wZh;
    
    private d() {}
    
    public final boolean dOQ()
    {
      return (this.msgType & 0xFFFF) == 49;
    }
    
    public final boolean dOR()
    {
      return this.msgType == 1;
    }
    
    public final boolean dOS()
    {
      return this.msgType == 48;
    }
    
    public final void dOT()
    {
      AppMethodBeat.i(52727);
      if (dOR())
      {
        this.wZe = 41;
        if ((ab.Eq(this.talker)) && (this.wZf == 0)) {
          this.wZg = bp.Kt(this.content);
        }
      }
      for (;;)
      {
        if (!Util.isNullOrNil(this.wZg)) {
          this.wZg = com.tencent.mm.plugin.fts.a.d.ayp(this.wZg);
        }
        if (!as.HF(this.talker)) {
          break;
        }
        this.wZh = this.talker;
        this.talker = "appbrandcustomerservicemsg";
        AppMethodBeat.o(52727);
        return;
        this.wZg = this.content;
        continue;
        Object localObject;
        if (dOQ())
        {
          localObject = k.b.HD(this.content);
          if (localObject != null) {
            switch (((k.b)localObject).type)
            {
            default: 
              break;
            case 1: 
            case 53: 
            case 57: 
              this.wZg = Util.nullAs(((k.b)localObject).getTitle(), "");
              this.wZe = 52;
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
              this.wZg = Util.nullAs(((k.b)localObject).getTitle(), "");
              this.wZe = 43;
              break;
            case 6: 
              this.wZg = Util.nullAs(((k.b)localObject).getTitle(), "");
              this.wZe = 42;
              break;
            case 19: 
              this.wZg = Util.nullAs(((k.b)localObject).getDescription(), "");
              if (this.wZg != null) {
                this.wZg = this.wZg.replace(":", "​");
              }
              this.wZe = 44;
              break;
            case 24: 
              this.wZg = Util.nullAs(((k.b)localObject).getDescription(), "");
              if (this.wZg != null) {
                this.wZg = this.wZg.replace(":", "​");
              }
              this.wZe = 49;
              break;
            case 33: 
              this.wZg = Util.nullAs(((k.b)localObject).getTitle(), "");
              this.wZe = 48;
              break;
            case 2000: 
              this.wZg = (Util.nullAs(((k.b)localObject).title, "") + "​" + Util.nullAs(((k.b)localObject).description, ""));
              this.wZe = 45;
              break;
            case 2001: 
              if ("1001".equals(((k.b)localObject).iyq))
              {
                this.wZe = 47;
                if (this.wZf == 1)
                {
                  this.wZg = (Util.nullAs(((k.b)localObject).iyo, "") + "​" + Util.nullAs(((k.b)localObject).iyl, ""));
                  continue;
                }
                this.wZg = (Util.nullAs(((k.b)localObject).iyo, "") + "​" + Util.nullAs(((k.b)localObject).iyk, ""));
                continue;
              }
              if (!"1002".equals(((k.b)localObject).iyq)) {
                continue;
              }
              this.wZe = 46;
              if (this.wZf == 1)
              {
                this.wZg = (Util.nullAs(((k.b)localObject).iyo, "") + "​" + Util.nullAs(((k.b)localObject).iyl, ""));
                continue;
              }
              this.wZg = (Util.nullAs(((k.b)localObject).iyo, "") + "​" + Util.nullAs(((k.b)localObject).iyk, ""));
              break;
            case 51: 
              this.wZg = Util.nullAs(((com.tencent.mm.plugin.i.a.f)((k.b)localObject).as(com.tencent.mm.plugin.i.a.f.class)).jlg.nickname, "");
              this.wZe = 53;
              break;
            }
          }
        }
        else if (dOS())
        {
          this.wZe = 50;
          if (ab.Eq(this.talker)) {}
          for (localObject = bp.Kt(this.content);; localObject = this.content)
          {
            localObject = ((l)g.af(l.class)).eiy().aEL((String)localObject);
            if (!((ca.b)localObject).gEa()) {
              break label902;
            }
            this.wZg = (((ca.b)localObject).kHV + "​" + ((ca.b)localObject).label);
            break;
          }
          label902:
          this.wZg = ((ca.b)localObject).label;
        }
      }
      if (this.wZf == 1)
      {
        this.wZh = z.aTY();
        AppMethodBeat.o(52727);
        return;
      }
      if (ab.Eq(this.talker))
      {
        this.wZh = Util.nullAs(bp.Ks(this.content), this.talker);
        AppMethodBeat.o(52727);
        return;
      }
      this.wZh = this.talker;
      AppMethodBeat.o(52727);
    }
    
    public final boolean isAvailable()
    {
      AppMethodBeat.i(52728);
      if (!Util.isNullOrNil(this.wZg))
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
      ayx("start");
      paramk.wWd = com.tencent.mm.plugin.fts.a.a.h.a(this.wWO.query, false, c.this.wYV);
      Object localObject1 = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.wWT, true);
      HashMap localHashMap = new HashMap();
      Object localObject2 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, this.wWO.talker, com.tencent.mm.plugin.fts.a.c.wUL, com.tencent.mm.plugin.fts.a.c.wUP);
      do
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break;
        }
        localObject3 = new com.tencent.mm.plugin.fts.a.a.n();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).wVX = ((Cursor)localObject2).getString(0);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).type = ((Cursor)localObject2).getInt(1);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).wVW = ((Cursor)localObject2).getInt(2);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).wWd = ((com.tencent.mm.plugin.fts.a.a.h)localObject1);
        if (!localHashMap.containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject3).wVX)) {
          localHashMap.put(((com.tencent.mm.plugin.fts.a.a.m)localObject3).wVX, localObject3);
        }
      } while (localHashMap.size() <= 100);
      ((Cursor)localObject2).close();
      ayx("findHitContact");
      localObject2 = c.this.wYQ.a(paramk.wWd, this.wWO.wWS, localHashMap.keySet());
      Object localObject3 = new HashMap();
      if (((Cursor)localObject2).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().g((Cursor)localObject2);
        localn.wWd = paramk.wWd;
        localn.userData = Integer.valueOf(1);
        if (((HashMap)localObject3).containsKey(localn.talker)) {}
        for (localObject1 = (List)((HashMap)localObject3).get(localn.talker);; localObject1 = new ArrayList())
        {
          ((List)localObject1).add(localn);
          ((HashMap)localObject3).put(localn.talker, localObject1);
          break;
        }
      }
      ((Cursor)localObject2).close();
      paramk.wXb = new ArrayList();
      localObject1 = ((HashMap)localObject3).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = (com.tencent.mm.plugin.fts.a.a.m)localHashMap.get(((Map.Entry)localObject2).getKey());
        if (localObject3 != null)
        {
          Collections.sort((List)((Map.Entry)localObject2).getValue(), this.wWO.wWY);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject3).userData = ((Map.Entry)localObject2).getValue();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject3).timestamp = ((com.tencent.mm.plugin.fts.a.a.m)((List)((Map.Entry)localObject2).getValue()).get(0)).timestamp;
          paramk.wXb.add(localObject3);
        }
      }
      Collections.sort(paramk.wXb, this.wWO.wWY);
      ayx("findHitMessage");
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
      ayx("start");
      paramk.wWd = com.tencent.mm.plugin.fts.a.a.h.a(this.wWO.query, false, c.this.wYV);
      Object localObject1 = c.this.wYQ;
      Object localObject3 = paramk.wWd;
      Object localObject2 = this.wWO.wWS;
      localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).dOz();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.c)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.c)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.c)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.c)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.c)localObject1).dOu(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).wUt.rawQuery((String)localObject3, new String[] { localObject2 });
      paramk.wXb = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.n().g((Cursor)localObject1);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).userData = Integer.valueOf(1);
        paramk.wXb.add(localObject2);
      }
      ((Cursor)localObject1).close();
      ayx("findConversationMessage");
      if ((paramk.wWd.wWE.length > 1) && (!this.wWO.wWX.contains("create_talker_message​")))
      {
        localObject1 = com.tencent.mm.plugin.fts.a.a.h.bE(paramk.wWd.wWE[0], true);
        localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.wUL, com.tencent.mm.plugin.fts.a.c.wUP);
        if (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).wVX = "create_talker_message​";
          paramk.wXb.add(0, localObject2);
        }
        ((Cursor)localObject1).close();
        ayx("findTalkerConversation");
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
      ayx("start");
      paramk.wWd = com.tencent.mm.plugin.fts.a.a.h.a(this.wWO.query, false, c.this.wYV);
      Object localObject1 = c.this.wYQ;
      Object localObject2 = paramk.wWd.dOz();
      localObject2 = String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.c)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.c)localObject1).dOt(), ((com.tencent.mm.plugin.fts.c.c)localObject1).dOu(), ((com.tencent.mm.plugin.fts.c.c)localObject1).dOu(), localObject2 });
      localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject1).wUt.rawQuery((String)localObject2, null);
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
          locala.wVW = ((Cursor)localObject2).getInt(1);
          locala.wXe = ((Cursor)localObject2).getLong(2);
          locala.wVX = ((Cursor)localObject2).getString(3);
          locala.timestamp = ((Cursor)localObject2).getLong(4);
          ((List)localObject1).add(locala);
          ((List)localObject4).add(str);
        }
      } while (((List)localObject1).size() <= this.wWO.wWW);
      ((Cursor)localObject2).close();
      paramk.wXb = new LinkedList();
      ayx("findUsername");
      if (((List)localObject4).size() > 0)
      {
        localObject3 = c.this.wYQ.a(paramk.wWd, (List)localObject4);
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
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).wVW = ((a)localObject3).wVW;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).wXe = ((a)localObject3).wXe;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).wVX = ((a)localObject3).wVX;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).timestamp = ((a)localObject3).timestamp;
          if (!((HashMap)localObject2).containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject4).wVX)) {
            break label699;
          }
        }
      }
      label699:
      for (int i = ((Integer)((HashMap)localObject2).get(((com.tencent.mm.plugin.fts.a.a.m)localObject4).wVX)).intValue();; i = 1)
      {
        if (ab.JB(((com.tencent.mm.plugin.fts.a.a.m)localObject4).wVX)) {
          i = 0;
        }
        ((com.tencent.mm.plugin.fts.a.a.m)localObject4).userData = Integer.valueOf(i);
        paramk.wXb.add(localObject4);
        break;
        ayx("findCount");
        if ((paramk.wWd.wWE.length > 1) && (paramk.wXb.size() <= 3))
        {
          localObject1 = com.tencent.mm.plugin.fts.a.a.h.bE(paramk.wWd.wWE[0], true);
          localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.wUL, com.tencent.mm.plugin.fts.a.c.wUP);
          if (((Cursor)localObject1).moveToNext())
          {
            localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
            ((com.tencent.mm.plugin.fts.a.a.m)localObject2).wVX = "create_talker_message​";
            paramk.wXb.add(localObject2);
          }
          ((Cursor)localObject1).close();
          ayx("findTalkerConversation");
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
      long timestamp;
      int type;
      int wVW;
      String wVX;
      long wXe;
      
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
      ayx("start");
      paramk.wWd = com.tencent.mm.plugin.fts.a.a.h.a(this.wWO.query, false, c.this.wYV);
      Object localObject1 = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.wWT, true);
      Object localObject2 = new HashMap();
      Object localObject3 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.wUL, com.tencent.mm.plugin.fts.a.c.wUP);
      do
      {
        if (!((Cursor)localObject3).moveToNext()) {
          break;
        }
        localObject4 = new com.tencent.mm.plugin.fts.a.a.n();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).wVX = ((Cursor)localObject3).getString(0);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).type = ((Cursor)localObject3).getInt(1);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).wVW = ((Cursor)localObject3).getInt(2);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).wWd = ((com.tencent.mm.plugin.fts.a.a.h)localObject1);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).userData = Integer.valueOf(1);
        if (!((HashMap)localObject2).containsKey(((com.tencent.mm.plugin.fts.a.a.n)localObject4).wVX)) {
          ((HashMap)localObject2).put(((com.tencent.mm.plugin.fts.a.a.n)localObject4).wVX, localObject4);
        }
      } while (((HashMap)localObject2).size() <= 100);
      ((Cursor)localObject3).close();
      ayx("findHitContact");
      Object localObject4 = c.this.wYQ.a(paramk.wWd, null, ((HashMap)localObject2).keySet());
      localObject3 = new HashMap();
      if (((Cursor)localObject4).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().g((Cursor)localObject4);
        localn.wWd = paramk.wWd;
        localn.userData = Integer.valueOf(1);
        label306:
        com.tencent.mm.plugin.fts.a.a.m localm;
        int i;
        if (((HashMap)localObject3).containsKey(localn.talker))
        {
          localObject1 = (HashMap)((HashMap)localObject3).get(localn.talker);
          if (!((HashMap)localObject1).containsKey(localn.wVX)) {
            break label431;
          }
          localm = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject1).get(localn.wVX);
          i = ((Integer)localm.userData).intValue() + 1;
          if (localm.timestamp >= localn.timestamp) {
            break label407;
          }
          localn.userData = Integer.valueOf(i);
          ((HashMap)localObject1).put(localn.wVX, localn);
        }
        for (;;)
        {
          ((HashMap)localObject3).put(localn.talker, localObject1);
          break;
          localObject1 = new HashMap();
          break label306;
          label407:
          localm.userData = Integer.valueOf(i);
          ((HashMap)localObject1).put(localm.wVX, localm);
          continue;
          label431:
          ((HashMap)localObject1).put(localn.wVX, localn);
        }
      }
      ((Cursor)localObject4).close();
      paramk.wXb = new ArrayList();
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.m)((Iterator)localObject1).next();
        if (((HashMap)localObject3).containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject2).wVX))
        {
          localObject4 = new ArrayList();
          ((List)localObject4).addAll(((HashMap)((HashMap)localObject3).get(((com.tencent.mm.plugin.fts.a.a.m)localObject2).wVX)).values());
          Collections.sort((List)localObject4, this.wWO.wWY);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).userData = localObject4;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).timestamp = ((com.tencent.mm.plugin.fts.a.a.m)((List)localObject4).get(0)).timestamp;
          paramk.wXb.add(localObject2);
        }
      }
      Collections.sort(paramk.wXb, this.wWO.wWY);
      ayx("findHitMessage");
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
    private int wZj = 0;
    private int wZk = 0;
    
    public i(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52733);
      ayx("start");
      paramk.wWd = com.tencent.mm.plugin.fts.a.a.h.a(this.wWO.query, false, c.this.wYV);
      Object localObject2 = c.this.wYQ;
      Object localObject1 = paramk.wWd;
      int i = this.wWO.wWW;
      String str = ((com.tencent.mm.plugin.fts.a.a.h)localObject1).dOz();
      if (i != 2147483647) {}
      for (localObject1 = " LIMIT " + (i + 1);; localObject1 = "")
      {
        localObject1 = String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (String)localObject1 + ";", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject2).dOt(), ((com.tencent.mm.plugin.fts.c.c)localObject2).dOu(), ((com.tencent.mm.plugin.fts.c.c)localObject2).dOt(), ((com.tencent.mm.plugin.fts.c.c)localObject2).dOu(), ((com.tencent.mm.plugin.fts.c.c)localObject2).dOu(), str });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).wUt.rawQuery((String)localObject1, null);
        paramk.wXb = new LinkedList();
        while (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).type = ((Cursor)localObject1).getInt(0);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).wVW = ((Cursor)localObject1).getInt(1);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).wXe = ((Cursor)localObject1).getLong(2);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).wVX = ((Cursor)localObject1).getString(3);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).timestamp = ((Cursor)localObject1).getLong(4);
          int j = ((Cursor)localObject1).getInt(5);
          i = j;
          if (j == 1)
          {
            i = j;
            if (ab.JB(((com.tencent.mm.plugin.fts.a.a.m)localObject2).wVX)) {
              i = 0;
            }
          }
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).userData = Integer.valueOf(i);
          paramk.wXb.add(localObject2);
          i = this.wZj;
          this.wZj = (((Integer)((com.tencent.mm.plugin.fts.a.a.m)localObject2).userData).intValue() + i);
          this.wZk += 1;
        }
      }
      ((Cursor)localObject1).close();
      ayx("groupMessage");
      if (paramk.wWd.wWE.length > 1)
      {
        localObject1 = com.tencent.mm.plugin.fts.a.a.h.bE(paramk.wWd.wWE[0], true);
        localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.wUL, com.tencent.mm.plugin.fts.a.c.wUP);
        if (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).wVX = "create_talker_message​";
          paramk.wXb.add(0, localObject2);
        }
        ((Cursor)localObject1).close();
        ayx("findTalkerConversation");
      }
      AppMethodBeat.o(52733);
    }
    
    public final String bCQ()
    {
      AppMethodBeat.i(52734);
      String str = String.format("{totalMsgCount: %d conversationCount: %d}", new Object[] { Integer.valueOf(this.wZj), Integer.valueOf(this.wZk) });
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
      AppMethodBeat.i(187310);
      ayx("start");
      paramk.wXb = new LinkedList();
      Cursor localCursor = c.this.wYQ.d(this.wWO.wWV, this.wWO.wWS);
      while (localCursor.moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.m localm = new com.tencent.mm.plugin.fts.a.a.m();
        localm.type = localCursor.getInt(0);
        localm.wVW = localCursor.getInt(1);
        localm.wXe = localCursor.getLong(2);
        localm.wVX = localCursor.getString(3);
        localm.timestamp = localCursor.getLong(4);
        localm.talker = localCursor.getString(5);
        paramk.wXb.add(localm);
      }
      localCursor.close();
      AppMethodBeat.o(187310);
    }
    
    public final String getName()
    {
      return "SearchTypeMessage";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c
 * JD-Core Version:    0.7.0.1
 */