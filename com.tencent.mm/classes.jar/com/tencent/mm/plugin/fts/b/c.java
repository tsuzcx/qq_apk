package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.b;
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
  extends com.tencent.mm.plugin.fts.a.b
  implements com.tencent.mm.plugin.messenger.foundation.a.a.h.a
{
  com.tencent.mm.plugin.fts.a.m fUc;
  private com.tencent.mm.sdk.b.c fpB;
  private com.tencent.mm.sdk.b.c fpC;
  com.tencent.mm.plugin.fts.a.j qbp;
  com.tencent.mm.plugin.fts.c.c rrF;
  boolean rrG;
  private com.tencent.mm.sdk.b.c rrH;
  com.tencent.mm.sdk.b.c rrI;
  av rrJ;
  com.tencent.mm.plugin.fts.a.a.h.a rrK;
  
  public c()
  {
    AppMethodBeat.i(52735);
    this.rrG = false;
    this.fpB = new c.1(this);
    this.fpC = new c.2(this);
    this.rrH = new com.tencent.mm.sdk.b.c() {};
    this.rrI = new c.4(this);
    this.rrJ = new av(g.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52716);
        if (!c.this.rrG)
        {
          c.this.rrG = true;
          if (c.this.fUc != null) {
            c.this.fUc.a(131112, new c.a(c.this, (byte)0));
          }
        }
        com.tencent.mm.sdk.b.a.ESL.d(c.this.rrI);
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
    this.rrK = new com.tencent.mm.plugin.fts.a.a.h.a()
    {
      public final String[] abg(String paramAnonymousString)
      {
        AppMethodBeat.i(52719);
        paramAnonymousString = com.tencent.mm.plugin.fts.a.c.a.rnT.split(paramAnonymousString, 2);
        AppMethodBeat.o(52719);
        return paramAnonymousString;
      }
      
      public final String[] split(String paramAnonymousString)
      {
        AppMethodBeat.i(52718);
        if (((PluginFTS)g.ad(PluginFTS.class)).getFTSIndexDB().rms)
        {
          paramAnonymousString = bt.gK(c.abm(paramAnonymousString));
          AppMethodBeat.o(52718);
          return paramAnonymousString;
        }
        paramAnonymousString = com.tencent.mm.plugin.fts.a.c.a.rnT.split(paramAnonymousString);
        AppMethodBeat.o(52718);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(52735);
  }
  
  public static List<String> abm(String paramString)
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
      ad.i("MicroMsg.FTS.FTS5SearchMessageLogic", "mmICUTokenize Query-tokenList: %s indexes: %s", new Object[] { localArrayList, str2 });
      AppMethodBeat.o(52740);
      return localArrayList;
      i += 3;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(52736);
    switch (paramj.iWB)
    {
    default: 
      paramj = new i(paramj);
    }
    for (;;)
    {
      paramj = this.fUc.a(-65536, paramj);
      AppMethodBeat.o(52736);
      return paramj;
      paramj = new f(paramj);
      continue;
      ad.i("MicroMsg.FTS.FTS5SearchMessageLogic", "total message count %d", new Object[] { Long.valueOf(e.roa.rog) });
      if (e.roa.rog >= 1000000L)
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
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh, h.c paramc)
  {
    AppMethodBeat.i(52739);
    if (paramc.tyD.equals("insert"))
    {
      paramh = new ArrayList();
      int j = 0;
      if (j < paramc.tyE.size())
      {
        bl localbl = (bl)paramc.tyE.get(j);
        int i;
        if ((localbl == null) || (bt.isNullOrNil(localbl.field_talker)) || (bt.isNullOrNil(localbl.field_content))) {
          i = 0;
        }
        for (;;)
        {
          if (i != 0) {
            paramh.add(localbl);
          }
          j += 1;
          break;
          if (localbl.field_talker.endsWith("@app")) {
            i = 0;
          } else if (localbl.field_talker.contains("@bottle")) {
            i = 0;
          } else if ((localbl.getType() != 1) && (!localbl.cxB()) && (!localbl.cxD())) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (paramh.size() > 0) {
        this.fUc.a(65576, new c(paramh));
      }
    }
    AppMethodBeat.o(52739);
  }
  
  public final boolean acO()
  {
    AppMethodBeat.i(52738);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(this);
    this.rrI.dead();
    this.rrH.dead();
    this.fpC.dead();
    this.fpB.dead();
    this.rrF = null;
    this.fUc = null;
    this.rrJ.stopTimer();
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
    if (!((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      ad.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Fail!");
      AppMethodBeat.o(52737);
      return false;
    }
    ad.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Success!");
    this.rrF = ((com.tencent.mm.plugin.fts.c.c)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(4));
    this.fUc = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.qbp = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
    this.rrI.alive();
    this.rrH.alive();
    this.fpC.alive();
    this.fpB.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(this, null);
    AppMethodBeat.o(52737);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private long jgw = 9223372036854775807L;
    private int mFailedCount = 0;
    private int qbw = 0;
    private int qbx = 0;
    private HashSet<Pair<Long, Long>> rrN = null;
    private ArrayList<Long> rrO = null;
    private long rrP = -1L;
    private int rrQ = 0;
    
    private a() {}
    
    public final String aWs()
    {
      AppMethodBeat.i(52721);
      String str = String.format("{new: %d removed: %d failed: %d}", new Object[] { Integer.valueOf(this.qbw), Integer.valueOf(this.qbx), Integer.valueOf(this.mFailedCount) });
      AppMethodBeat.o(52721);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52720);
      this.jgw = c.this.rrF.rni.T(-200L, 9223372036854775807L);
      this.rrP = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).aqo().age("");
      if (this.jgw > this.rrP)
      {
        c.this.rrF.U(-310L, System.currentTimeMillis());
        c.this.rrF.U(-311L, com.tencent.mm.protocal.d.CpK);
      }
      ad.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: %s last from createTime: %s", new Object[] { Long.valueOf(this.jgw), Long.valueOf(this.rrP) });
      long l1;
      long l2;
      if (this.rrN == null)
      {
        this.rrN = new HashSet();
        this.rrO = new ArrayList();
        localObject1 = c.this.rrF.a(com.tencent.mm.plugin.fts.a.c.rnr, true, true, false, true, true);
        while (((Cursor)localObject1).moveToNext())
        {
          l1 = ((Cursor)localObject1).getLong(0);
          l2 = ((Cursor)localObject1).getLong(1);
          long l3 = ((Cursor)localObject1).getLong(2);
          if (((Cursor)localObject1).getInt(3) == -1) {
            this.rrO.add(Long.valueOf(l1));
          } else if (l3 <= this.jgw) {
            this.rrN.add(new Pair(Long.valueOf(l2), Long.valueOf(l3)));
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
        localObject1[0] = Long.toString(this.jgw);
        localObject1[1] = Integer.toString(this.rrQ);
        localObject1[2] = Long.toString(this.rrP);
        Object localObject3 = c.this.qbp.rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime>? AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", (String[])localObject1);
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
          locald.rrU = ((Cursor)localObject3).getInt(5);
          locald.rrT = 41;
          if (c.a(locald))
          {
            locald.cxE();
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
          ad.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d", new Object[] { Integer.valueOf(j) });
          if (j <= 0) {
            break label988;
          }
          c.this.rrF.beginTransaction();
          localObject3 = ((List)localObject2).iterator();
          label629:
          if (!((Iterator)localObject3).hasNext()) {
            break label931;
          }
          locald = (c.d)((Iterator)localObject3).next();
          l1 = locald.msgId;
          l2 = locald.createTime;
          if (l2 != this.jgw) {
            break label917;
          }
        }
        for (this.rrQ += 1;; this.rrQ = 0)
        {
          for (;;)
          {
            Pair localPair = new Pair(Long.valueOf(l1), Long.valueOf(l2));
            if (this.rrN.remove(localPair)) {
              break;
            }
            try
            {
              c.this.rrF.a(locald.rrT, l1, locald.talker, l2, locald.rrV, locald.rrW);
              this.qbw += 1;
            }
            catch (Exception localException)
            {
              ad.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", localException, "Build message index failed with exception. \n%s", new Object[] { locald.rrV });
              this.mFailedCount += 1;
            }
          }
          break label629;
          ad.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d Id FROM %d to %d Time FROM %s to %s", new Object[] { Integer.valueOf(j), Long.valueOf(((c.d)((List)localObject2).get(0)).msgId), Long.valueOf(((c.d)((List)localObject2).get(j - 1)).msgId), com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", ((c.d)((List)localObject2).get(0)).createTime / 1000L), com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", ((c.d)((List)localObject2).get(j - 1)).createTime / 1000L) });
          break;
          label917:
          this.jgw = l2;
        }
        label931:
        c.this.rrF.commit();
        c.this.rrF.U(-200L, this.jgw);
        for (;;)
        {
          ((List)localObject2).clear();
          if (!Thread.interrupted()) {
            break;
          }
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52720);
          throw ((Throwable)localObject1);
          label988:
          this.jgw = l1;
          this.rrQ = 0;
        }
      }
      i = 50;
      localObject1 = this.rrN.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        if (Thread.interrupted())
        {
          c.this.rrF.commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52720);
          throw ((Throwable)localObject1);
        }
        if (i < 50) {
          break label1351;
        }
        c.this.rrF.commit();
        c.this.rrF.beginTransaction();
        i = 0;
      }
      label1348:
      label1351:
      for (;;)
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        c.this.rrF.a(com.tencent.mm.plugin.fts.a.c.rnr, ((Long)((Pair)localObject2).first).longValue(), ((Long)((Pair)localObject2).second).longValue());
        i += 1;
        this.qbx += 1;
        ((Iterator)localObject1).remove();
        break;
        c.this.rrF.commit();
        i = 50;
        localObject1 = this.rrO.listIterator(this.rrO.size());
        if (((ListIterator)localObject1).hasPrevious())
        {
          if (Thread.interrupted())
          {
            c.this.rrF.commit();
            localObject1 = new InterruptedException();
            AppMethodBeat.o(52720);
            throw ((Throwable)localObject1);
          }
          if (i < 50) {
            break label1348;
          }
          c.this.rrF.commit();
          c.this.rrF.beginTransaction();
          i = 0;
        }
        for (;;)
        {
          l1 = ((Long)((ListIterator)localObject1).previous()).longValue();
          c.this.rrF.qQ(l1);
          i += 1;
          this.qbx += 1;
          ((ListIterator)localObject1).remove();
          break;
          c.this.rrF.U(-200L, this.jgw - 1L);
          c.this.rrF.commit();
          c.this.rrG = false;
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
  
  final class c
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private List<bl> rrR;
    private StringBuffer rrS;
    
    public c()
    {
      AppMethodBeat.i(52724);
      this.rrR = new ArrayList();
      Collection localCollection;
      this.rrR.addAll(localCollection);
      this.rrS = new StringBuffer();
      AppMethodBeat.o(52724);
    }
    
    public final String aWs()
    {
      AppMethodBeat.i(52726);
      String str = this.rrS.toString();
      AppMethodBeat.o(52726);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52725);
      Object localObject1 = new ArrayList();
      Object localObject2 = this.rrR.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bl)((Iterator)localObject2).next();
        c.d locald = new c.d(c.this, (byte)0);
        locald.msgId = ((du)localObject3).field_msgId;
        locald.talker = ((du)localObject3).field_talker;
        locald.createTime = ((du)localObject3).field_createTime;
        locald.content = ((du)localObject3).field_content;
        locald.msgType = ((bl)localObject3).getType();
        locald.rrU = ((du)localObject3).field_isSend;
        if (c.a(locald))
        {
          locald.cxE();
          if (locald.isAvailable()) {
            ((List)localObject1).add(locald);
          }
        }
      }
      this.rrS.append("{MsgId: ");
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (c.d)((Iterator)localObject2).next();
        this.rrS.append(((c.d)localObject3).msgId);
        this.rrS.append(",");
        this.rrS.append(((c.d)localObject3).talker);
        this.rrS.append(",");
        this.rrS.append(((c.d)localObject3).createTime);
        this.rrS.append(" ");
      }
      this.rrS.append("count: ");
      this.rrS.append(((List)localObject1).size());
      this.rrS.append("}");
      if (((List)localObject1).size() > 0)
      {
        c.this.rrF.beginTransaction();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c.d)((Iterator)localObject1).next();
          c.this.rrF.a(((c.d)localObject2).rrT, ((c.d)localObject2).msgId, ((c.d)localObject2).talker, ((c.d)localObject2).createTime, ((c.d)localObject2).rrV, ((c.d)localObject2).rrW);
        }
        c.this.rrF.commit();
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
    int rrT;
    int rrU;
    String rrV;
    String rrW;
    String talker;
    
    private d() {}
    
    public final boolean cxB()
    {
      return (this.msgType & 0xFFFF) == 49;
    }
    
    public final boolean cxC()
    {
      return this.msgType == 1;
    }
    
    public final boolean cxD()
    {
      return this.msgType == 48;
    }
    
    public final void cxE()
    {
      AppMethodBeat.i(52727);
      if (cxC())
      {
        this.rrT = 41;
        if ((w.pF(this.talker)) && (this.rrU == 0)) {
          this.rrV = bi.ug(this.content);
        }
      }
      for (;;)
      {
        if (!bt.isNullOrNil(this.rrV)) {
          this.rrV = com.tencent.mm.plugin.fts.a.d.aaX(this.rrV);
        }
        if (this.rrU != 1) {
          break;
        }
        this.rrW = u.aqG();
        AppMethodBeat.o(52727);
        return;
        this.rrV = this.content;
        continue;
        Object localObject;
        if (cxB())
        {
          localObject = k.b.rx(this.content);
          if (localObject != null) {
            switch (((k.b)localObject).type)
            {
            default: 
              break;
            case 1: 
            case 53: 
            case 57: 
              this.rrV = bt.by(((k.b)localObject).getTitle(), "");
              this.rrT = 52;
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
              this.rrV = bt.by(((k.b)localObject).getTitle(), "");
              this.rrT = 43;
              break;
            case 6: 
              this.rrV = bt.by(((k.b)localObject).getTitle(), "");
              this.rrT = 42;
              break;
            case 19: 
              this.rrV = bt.by(((k.b)localObject).getDescription(), "");
              if (this.rrV != null) {
                this.rrV = this.rrV.replace(":", "​");
              }
              this.rrT = 44;
              break;
            case 24: 
              this.rrV = bt.by(((k.b)localObject).getDescription(), "");
              if (this.rrV != null) {
                this.rrV = this.rrV.replace(":", "​");
              }
              this.rrT = 49;
              break;
            case 33: 
              this.rrV = bt.by(((k.b)localObject).getTitle(), "");
              this.rrT = 48;
              break;
            case 2000: 
              this.rrV = (bt.by(((k.b)localObject).title, "") + "​" + bt.by(((k.b)localObject).description, ""));
              this.rrT = 45;
              break;
            case 2001: 
              if ("1001".equals(((k.b)localObject).gIN))
              {
                this.rrT = 47;
                if (this.rrU == 1)
                {
                  this.rrV = (bt.by(((k.b)localObject).gIL, "") + "​" + bt.by(((k.b)localObject).gII, ""));
                  continue;
                }
                this.rrV = (bt.by(((k.b)localObject).gIL, "") + "​" + bt.by(((k.b)localObject).gIH, ""));
                continue;
              }
              if (!"1002".equals(((k.b)localObject).gIN)) {
                continue;
              }
              this.rrT = 46;
              if (this.rrU == 1)
              {
                this.rrV = (bt.by(((k.b)localObject).gIL, "") + "​" + bt.by(((k.b)localObject).gII, ""));
                continue;
              }
              this.rrV = (bt.by(((k.b)localObject).gIL, "") + "​" + bt.by(((k.b)localObject).gIH, ""));
              break;
            case 51: 
              this.rrV = bt.by(((com.tencent.mm.plugin.i.a.b)((k.b)localObject).ao(com.tencent.mm.plugin.i.a.b.class)).htg.nickname, "");
              this.rrT = 53;
              break;
            }
          }
        }
        else if (cxD())
        {
          this.rrT = 50;
          if (w.pF(this.talker)) {}
          for (localObject = bi.ug(this.content);; localObject = this.content)
          {
            localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agD((String)localObject);
            if (!((bl.b)localObject).eMH()) {
              break label894;
            }
            this.rrV = (((bl.b)localObject).goQ + "​" + ((bl.b)localObject).label);
            break;
          }
          label894:
          this.rrV = ((bl.b)localObject).label;
        }
      }
      if (w.pF(this.talker))
      {
        this.rrW = bt.by(bi.uf(this.content), this.talker);
        AppMethodBeat.o(52727);
        return;
      }
      this.rrW = this.talker;
      AppMethodBeat.o(52727);
    }
    
    public final boolean isAvailable()
    {
      AppMethodBeat.i(52728);
      if (!bt.isNullOrNil(this.rrV))
      {
        AppMethodBeat.o(52728);
        return true;
      }
      AppMethodBeat.o(52728);
      return false;
    }
  }
  
  final class e
    extends i
  {
    public e(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52729);
      abf("start");
      paramk.roS = com.tencent.mm.plugin.fts.a.a.h.a(this.rpD.query, false, c.this.rrK);
      Object localObject1 = com.tencent.mm.plugin.fts.a.a.h.bc(this.rpD.rpI, true);
      HashMap localHashMap = new HashMap();
      Object localObject2 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, this.rpD.talker, com.tencent.mm.plugin.fts.a.c.rnA, com.tencent.mm.plugin.fts.a.c.rnE);
      do
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break;
        }
        localObject3 = new com.tencent.mm.plugin.fts.a.a.n();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).roN = ((Cursor)localObject2).getString(0);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).type = ((Cursor)localObject2).getInt(1);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).roM = ((Cursor)localObject2).getInt(2);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).roS = ((com.tencent.mm.plugin.fts.a.a.h)localObject1);
        if (!localHashMap.containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject3).roN)) {
          localHashMap.put(((com.tencent.mm.plugin.fts.a.a.m)localObject3).roN, localObject3);
        }
      } while (localHashMap.size() <= 100);
      ((Cursor)localObject2).close();
      abf("findHitContact");
      localObject2 = c.this.rrF.a(paramk.roS, this.rpD.rpH, localHashMap.keySet());
      Object localObject3 = new HashMap();
      if (((Cursor)localObject2).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().h((Cursor)localObject2);
        localn.roS = paramk.roS;
        if (((HashMap)localObject3).containsKey(localn.talker)) {}
        for (localObject1 = (List)((HashMap)localObject3).get(localn.talker);; localObject1 = new ArrayList())
        {
          ((List)localObject1).add(localn);
          ((HashMap)localObject3).put(localn.talker, localObject1);
          break;
        }
      }
      ((Cursor)localObject2).close();
      paramk.rpQ = new ArrayList();
      localObject1 = ((HashMap)localObject3).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = (com.tencent.mm.plugin.fts.a.a.m)localHashMap.get(((Map.Entry)localObject2).getKey());
        if (localObject3 != null)
        {
          Collections.sort((List)((Map.Entry)localObject2).getValue(), this.rpD.rpN);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject3).userData = ((Map.Entry)localObject2).getValue();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject3).timestamp = ((com.tencent.mm.plugin.fts.a.a.m)((List)((Map.Entry)localObject2).getValue()).get(0)).timestamp;
          paramk.rpQ.add(localObject3);
        }
      }
      Collections.sort(paramk.rpQ, this.rpD.rpN);
      abf("findHitMessage");
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
    extends i
  {
    f(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52730);
      abf("start");
      paramk.roS = com.tencent.mm.plugin.fts.a.a.h.a(this.rpD.query, false, c.this.rrK);
      Object localObject1 = c.this.rrF;
      Object localObject3 = paramk.roS;
      Object localObject2 = this.rpD.rpH;
      localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).cxk();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).cxe(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cxe(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cxf(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cxe(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cxf(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cxf(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).rni.rawQuery((String)localObject3, new String[] { localObject2 });
      paramk.rpQ = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.n().h((Cursor)localObject1);
        paramk.rpQ.add(localObject2);
      }
      ((Cursor)localObject1).close();
      abf("findConversationMessage");
      if ((paramk.roS.rpt.length > 1) && (!this.rpD.rpM.contains("create_talker_message​")))
      {
        localObject1 = com.tencent.mm.plugin.fts.a.a.h.bc(paramk.roS.rpt[0], true);
        localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.rnA, com.tencent.mm.plugin.fts.a.c.rnE);
        if (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).roN = "create_talker_message​";
          paramk.rpQ.add(0, localObject2);
        }
        ((Cursor)localObject1).close();
        abf("findTalkerConversation");
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
    extends i
  {
    public g(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52731);
      abf("start");
      paramk.roS = com.tencent.mm.plugin.fts.a.a.h.a(this.rpD.query, false, c.this.rrK);
      Object localObject1 = c.this.rrF;
      Object localObject2 = paramk.roS.cxk();
      localObject2 = String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).cxe(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cxf(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cxe(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cxf(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cxf(), localObject2 });
      localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject1).rni.rawQuery((String)localObject2, null);
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
          locala.roM = ((Cursor)localObject2).getInt(1);
          locala.rpT = ((Cursor)localObject2).getLong(2);
          locala.roN = ((Cursor)localObject2).getString(3);
          locala.timestamp = ((Cursor)localObject2).getLong(4);
          ((List)localObject1).add(locala);
          ((List)localObject4).add(str);
        }
      } while (((List)localObject1).size() <= this.rpD.rpL);
      ((Cursor)localObject2).close();
      paramk.rpQ = new LinkedList();
      abf("findUsername");
      if (((List)localObject4).size() > 0)
      {
        localObject3 = c.this.rrF.a(paramk.roS, (List)localObject4);
        localObject2 = new HashMap();
        if (((Cursor)localObject3).moveToNext())
        {
          localObject4 = ((Cursor)localObject3).getString(0).split(" ");
          int i = 0;
          while (i < localObject4.length)
          {
            ((HashMap)localObject2).put(localObject4[i], Integer.valueOf(bt.getInt(localObject4[(i + 1)], 0)));
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
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).roM = ((a)localObject3).roM;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).rpT = ((a)localObject3).rpT;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).roN = ((a)localObject3).roN;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).timestamp = ((a)localObject3).timestamp;
          if (((HashMap)localObject2).containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject4).roN)) {}
          for (((com.tencent.mm.plugin.fts.a.a.m)localObject4).userData = ((HashMap)localObject2).get(((com.tencent.mm.plugin.fts.a.a.m)localObject4).roN);; ((com.tencent.mm.plugin.fts.a.a.m)localObject4).userData = Integer.valueOf(1))
          {
            paramk.rpQ.add(localObject4);
            break;
          }
        }
        abf("findCount");
      }
      if ((paramk.roS.rpt.length > 1) && (paramk.rpQ.size() <= 3))
      {
        localObject1 = com.tencent.mm.plugin.fts.a.a.h.bc(paramk.roS.rpt[0], true);
        localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.rnA, com.tencent.mm.plugin.fts.a.c.rnE);
        if (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).roN = "create_talker_message​";
          paramk.rpQ.add(localObject2);
        }
        ((Cursor)localObject1).close();
        abf("findTalkerConversation");
      }
      AppMethodBeat.o(52731);
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
      int roM;
      String roN;
      long rpT;
      long timestamp;
      int type;
      
      private a() {}
    }
  }
  
  final class h
    extends i
  {
    public h(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52732);
      abf("start");
      paramk.roS = com.tencent.mm.plugin.fts.a.a.h.a(this.rpD.query, false, c.this.rrK);
      Object localObject1 = com.tencent.mm.plugin.fts.a.a.h.bc(this.rpD.rpI, true);
      Object localObject2 = new HashMap();
      Object localObject3 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.rnA, com.tencent.mm.plugin.fts.a.c.rnE);
      do
      {
        if (!((Cursor)localObject3).moveToNext()) {
          break;
        }
        localObject4 = new com.tencent.mm.plugin.fts.a.a.n();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).roN = ((Cursor)localObject3).getString(0);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).type = ((Cursor)localObject3).getInt(1);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).roM = ((Cursor)localObject3).getInt(2);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).roS = ((com.tencent.mm.plugin.fts.a.a.h)localObject1);
        if (!((HashMap)localObject2).containsKey(((com.tencent.mm.plugin.fts.a.a.n)localObject4).roN)) {
          ((HashMap)localObject2).put(((com.tencent.mm.plugin.fts.a.a.n)localObject4).roN, localObject4);
        }
      } while (((HashMap)localObject2).size() <= 100);
      ((Cursor)localObject3).close();
      abf("findHitContact");
      Object localObject4 = c.this.rrF.a(paramk.roS, null, ((HashMap)localObject2).keySet());
      localObject3 = new HashMap();
      if (((Cursor)localObject4).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().h((Cursor)localObject4);
        localn.roS = paramk.roS;
        localn.userData = Integer.valueOf(1);
        label297:
        com.tencent.mm.plugin.fts.a.a.m localm;
        int i;
        if (((HashMap)localObject3).containsKey(localn.talker))
        {
          localObject1 = (HashMap)((HashMap)localObject3).get(localn.talker);
          if (!((HashMap)localObject1).containsKey(localn.roN)) {
            break label422;
          }
          localm = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject1).get(localn.roN);
          i = ((Integer)localm.userData).intValue() + 1;
          if (localm.timestamp >= localn.timestamp) {
            break label398;
          }
          localn.userData = Integer.valueOf(i);
          ((HashMap)localObject1).put(localn.roN, localn);
        }
        for (;;)
        {
          ((HashMap)localObject3).put(localn.talker, localObject1);
          break;
          localObject1 = new HashMap();
          break label297;
          label398:
          localm.userData = Integer.valueOf(i);
          ((HashMap)localObject1).put(localm.roN, localm);
          continue;
          label422:
          ((HashMap)localObject1).put(localn.roN, localn);
        }
      }
      ((Cursor)localObject4).close();
      paramk.rpQ = new ArrayList();
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.m)((Iterator)localObject1).next();
        if (((HashMap)localObject3).containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject2).roN))
        {
          localObject4 = new ArrayList();
          ((List)localObject4).addAll(((HashMap)((HashMap)localObject3).get(((com.tencent.mm.plugin.fts.a.a.m)localObject2).roN)).values());
          Collections.sort((List)localObject4, this.rpD.rpN);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).userData = localObject4;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).timestamp = ((com.tencent.mm.plugin.fts.a.a.m)((List)localObject4).get(0)).timestamp;
          paramk.rpQ.add(localObject2);
        }
      }
      Collections.sort(paramk.rpQ, this.rpD.rpN);
      abf("findHitMessage");
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
    extends i
  {
    private int rrY = 0;
    private int rrZ = 0;
    
    public i(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52733);
      abf("start");
      paramk.roS = com.tencent.mm.plugin.fts.a.a.h.a(this.rpD.query, false, c.this.rrK);
      Object localObject2 = c.this.rrF;
      Object localObject1 = paramk.roS;
      int i = this.rpD.rpL;
      String str = ((com.tencent.mm.plugin.fts.a.a.h)localObject1).cxk();
      if (i != 2147483647) {}
      for (localObject1 = " LIMIT " + (i + 1);; localObject1 = "")
      {
        localObject1 = String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (String)localObject1 + ";", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject2).cxe(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cxf(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cxe(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cxf(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cxf(), str });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).rni.rawQuery((String)localObject1, null);
        paramk.rpQ = new LinkedList();
        while (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).type = ((Cursor)localObject1).getInt(0);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).roM = ((Cursor)localObject1).getInt(1);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).rpT = ((Cursor)localObject1).getLong(2);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).roN = ((Cursor)localObject1).getString(3);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).timestamp = ((Cursor)localObject1).getLong(4);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).userData = Integer.valueOf(((Cursor)localObject1).getInt(5));
          paramk.rpQ.add(localObject2);
          i = this.rrY;
          this.rrY = (((Integer)((com.tencent.mm.plugin.fts.a.a.m)localObject2).userData).intValue() + i);
          this.rrZ += 1;
        }
      }
      ((Cursor)localObject1).close();
      abf("groupMessage");
      if (paramk.roS.rpt.length > 1)
      {
        localObject1 = com.tencent.mm.plugin.fts.a.a.h.bc(paramk.roS.rpt[0], true);
        localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.rnA, com.tencent.mm.plugin.fts.a.c.rnE);
        if (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).roN = "create_talker_message​";
          paramk.rpQ.add(0, localObject2);
        }
        ((Cursor)localObject1).close();
        abf("findTalkerConversation");
      }
      AppMethodBeat.o(52733);
    }
    
    public final String aWs()
    {
      AppMethodBeat.i(52734);
      String str = String.format("{totalMsgCount: %d conversationCount: %d}", new Object[] { Integer.valueOf(this.rrY), Integer.valueOf(this.rrZ) });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c
 * JD-Core Version:    0.7.0.1
 */