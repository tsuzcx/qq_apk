package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

public final class c
  extends com.tencent.mm.plugin.fts.a.b
  implements com.tencent.mm.plugin.messenger.foundation.a.a.h.a
{
  m fXX;
  private com.tencent.mm.sdk.b.c ftd;
  private com.tencent.mm.sdk.b.c fte;
  com.tencent.mm.plugin.fts.a.j qJV;
  boolean sAA;
  private com.tencent.mm.sdk.b.c sAB;
  com.tencent.mm.sdk.b.c sAC;
  au sAD;
  com.tencent.mm.plugin.fts.a.a.h.a sAE;
  com.tencent.mm.plugin.fts.c.c sAz;
  
  public c()
  {
    AppMethodBeat.i(52735);
    this.sAA = false;
    this.ftd = new com.tencent.mm.sdk.b.c() {};
    this.fte = new com.tencent.mm.sdk.b.c() {};
    this.sAB = new com.tencent.mm.sdk.b.c() {};
    this.sAC = new com.tencent.mm.sdk.b.c() {};
    this.sAD = new au(g.agU().GrZ.getLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52716);
        if (!c.this.sAA)
        {
          c.this.sAA = true;
          if (c.this.fXX != null) {
            c.this.fXX.a(131112, new c.a(c.this, (byte)0));
          }
        }
        com.tencent.mm.sdk.b.a.GpY.d(c.this.sAC);
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
    this.sAE = new com.tencent.mm.plugin.fts.a.a.h.a()
    {
      public final String[] afY(String paramAnonymousString)
      {
        AppMethodBeat.i(52719);
        paramAnonymousString = com.tencent.mm.plugin.fts.a.c.a.swN.split(paramAnonymousString, 2);
        AppMethodBeat.o(52719);
        return paramAnonymousString;
      }
      
      public final String[] split(String paramAnonymousString)
      {
        AppMethodBeat.i(52718);
        if (((PluginFTS)g.ad(PluginFTS.class)).getFTSIndexDB().svm)
        {
          paramAnonymousString = bs.gX(c.age(paramAnonymousString));
          AppMethodBeat.o(52718);
          return paramAnonymousString;
        }
        paramAnonymousString = com.tencent.mm.plugin.fts.a.c.a.swN.split(paramAnonymousString);
        AppMethodBeat.o(52718);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(52735);
  }
  
  public static List<String> age(String paramString)
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
      ac.i("MicroMsg.FTS.FTS5SearchMessageLogic", "mmICUTokenize Query-tokenList: %s indexes: %s", new Object[] { localArrayList, str2 });
      AppMethodBeat.o(52740);
      return localArrayList;
      i += 3;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(52736);
    switch (paramj.jwR)
    {
    default: 
      paramj = new c.i(this, paramj);
    }
    for (;;)
    {
      paramj = this.fXX.a(-65536, paramj);
      AppMethodBeat.o(52736);
      return paramj;
      paramj = new c.f(this, paramj);
      continue;
      ac.i("MicroMsg.FTS.FTS5SearchMessageLogic", "total message count %d", new Object[] { Long.valueOf(e.swU.sxa) });
      if (e.swU.sxa >= 1000000L)
      {
        paramj = new c.g(this, paramj);
      }
      else
      {
        paramj = new c.i(this, paramj);
        continue;
        paramj = new c.h(this, paramj);
        continue;
        paramj = new c.e(this, paramj);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh, h.c paramc)
  {
    AppMethodBeat.i(52739);
    if (paramc.uHb.equals("insert"))
    {
      paramh = new ArrayList();
      int j = 0;
      if (j < paramc.gtT.size())
      {
        bo localbo = (bo)paramc.gtT.get(j);
        int i;
        if ((localbo == null) || (bs.isNullOrNil(localbo.field_talker)) || (bs.isNullOrNil(localbo.field_content))) {
          i = 0;
        }
        for (;;)
        {
          if (i != 0) {
            paramh.add(localbo);
          }
          j += 1;
          break;
          if (localbo.field_talker.endsWith("@app")) {
            i = 0;
          } else if (localbo.field_talker.contains("@bottle")) {
            i = 0;
          } else if ((localbo.getType() != 1) && (!localbo.cKN()) && (!localbo.cKP())) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (paramh.size() > 0) {
        this.fXX.a(65576, new c(paramh));
      }
    }
    AppMethodBeat.o(52739);
  }
  
  public final boolean adU()
  {
    AppMethodBeat.i(52738);
    ((k)g.ab(k.class)).dcr().a(this);
    this.sAC.dead();
    this.sAB.dead();
    this.fte.dead();
    this.ftd.dead();
    this.sAz = null;
    this.fXX = null;
    this.sAD.stopTimer();
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
    if (!((n)g.ad(n.class)).isFTSContextReady())
    {
      ac.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Fail!");
      AppMethodBeat.o(52737);
      return false;
    }
    ac.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Success!");
    this.sAz = ((com.tencent.mm.plugin.fts.c.c)((n)g.ad(n.class)).getFTSIndexStorage(4));
    this.fXX = ((n)g.ad(n.class)).getFTSTaskDaemon();
    this.qJV = ((n)g.ad(n.class)).getFTSMainDB();
    this.sAC.alive();
    this.sAB.alive();
    this.fte.alive();
    this.ftd.alive();
    ((k)g.ab(k.class)).dcr().a(this, null);
    AppMethodBeat.o(52737);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private long jGL = 9223372036854775807L;
    private int mFailedCount = 0;
    private int qKc = 0;
    private int qKd = 0;
    private HashSet<Pair<Long, Long>> sAH = null;
    private ArrayList<Long> sAI = null;
    private long sAJ = -1L;
    private int sAK = 0;
    
    private a() {}
    
    public final String bdq()
    {
      AppMethodBeat.i(52721);
      String str = String.format("{new: %d removed: %d failed: %d}", new Object[] { Integer.valueOf(this.qKc), Integer.valueOf(this.qKd), Integer.valueOf(this.mFailedCount) });
      AppMethodBeat.o(52721);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52720);
      this.jGL = c.this.sAz.swc.Q(-200L, 9223372036854775807L);
      this.sAJ = ((k)g.ab(k.class)).axd().akY("");
      if (this.jGL > this.sAJ)
      {
        c.this.sAz.R(-310L, System.currentTimeMillis());
        c.this.sAz.R(-311L, com.tencent.mm.protocal.d.DIc);
      }
      ac.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: %s last from createTime: %s", new Object[] { Long.valueOf(this.jGL), Long.valueOf(this.sAJ) });
      long l1;
      long l2;
      if (this.sAH == null)
      {
        this.sAH = new HashSet();
        this.sAI = new ArrayList();
        localObject1 = c.this.sAz.a(com.tencent.mm.plugin.fts.a.c.swl, true, true, false, true, true);
        while (((Cursor)localObject1).moveToNext())
        {
          l1 = ((Cursor)localObject1).getLong(0);
          l2 = ((Cursor)localObject1).getLong(1);
          long l3 = ((Cursor)localObject1).getLong(2);
          if (((Cursor)localObject1).getInt(3) == -1) {
            this.sAI.add(Long.valueOf(l1));
          } else if (l3 <= this.jGL) {
            this.sAH.add(new Pair(Long.valueOf(l2), Long.valueOf(l3)));
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
        localObject1[0] = Long.toString(this.jGL);
        localObject1[1] = Integer.toString(this.sAK);
        localObject1[2] = Long.toString(this.sAJ);
        Object localObject3 = c.this.qJV.rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime>? AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", (String[])localObject1);
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
          locald.sAO = ((Cursor)localObject3).getInt(5);
          locald.sAN = 41;
          if (c.a(locald))
          {
            locald.cKQ();
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
          ac.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d", new Object[] { Integer.valueOf(j) });
          if (j <= 0) {
            break label988;
          }
          c.this.sAz.beginTransaction();
          localObject3 = ((List)localObject2).iterator();
          label629:
          if (!((Iterator)localObject3).hasNext()) {
            break label931;
          }
          locald = (c.d)((Iterator)localObject3).next();
          l1 = locald.msgId;
          l2 = locald.createTime;
          if (l2 != this.jGL) {
            break label917;
          }
        }
        for (this.sAK += 1;; this.sAK = 0)
        {
          for (;;)
          {
            Pair localPair = new Pair(Long.valueOf(l1), Long.valueOf(l2));
            if (this.sAH.remove(localPair)) {
              break;
            }
            try
            {
              c.this.sAz.a(locald.sAN, l1, locald.talker, l2, locald.sAP, locald.sAQ);
              this.qKc += 1;
            }
            catch (Exception localException)
            {
              ac.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", localException, "Build message index failed with exception. \n%s", new Object[] { locald.sAP });
              this.mFailedCount += 1;
            }
          }
          break label629;
          ac.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d Id FROM %d to %d Time FROM %s to %s", new Object[] { Integer.valueOf(j), Long.valueOf(((c.d)((List)localObject2).get(0)).msgId), Long.valueOf(((c.d)((List)localObject2).get(j - 1)).msgId), com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", ((c.d)((List)localObject2).get(0)).createTime / 1000L), com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", ((c.d)((List)localObject2).get(j - 1)).createTime / 1000L) });
          break;
          label917:
          this.jGL = l2;
        }
        label931:
        c.this.sAz.commit();
        c.this.sAz.R(-200L, this.jGL);
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
          this.jGL = l1;
          this.sAK = 0;
        }
      }
      i = 50;
      localObject1 = this.sAH.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        if (Thread.interrupted())
        {
          c.this.sAz.commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52720);
          throw ((Throwable)localObject1);
        }
        if (i < 50) {
          break label1351;
        }
        c.this.sAz.commit();
        c.this.sAz.beginTransaction();
        i = 0;
      }
      label1348:
      label1351:
      for (;;)
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        c.this.sAz.a(com.tencent.mm.plugin.fts.a.c.swl, ((Long)((Pair)localObject2).first).longValue(), ((Long)((Pair)localObject2).second).longValue());
        i += 1;
        this.qKd += 1;
        ((Iterator)localObject1).remove();
        break;
        c.this.sAz.commit();
        i = 50;
        localObject1 = this.sAI.listIterator(this.sAI.size());
        if (((ListIterator)localObject1).hasPrevious())
        {
          if (Thread.interrupted())
          {
            c.this.sAz.commit();
            localObject1 = new InterruptedException();
            AppMethodBeat.o(52720);
            throw ((Throwable)localObject1);
          }
          if (i < 50) {
            break label1348;
          }
          c.this.sAz.commit();
          c.this.sAz.beginTransaction();
          i = 0;
        }
        for (;;)
        {
          l1 = ((Long)((ListIterator)localObject1).previous()).longValue();
          c.this.sAz.vt(l1);
          i += 1;
          this.qKd += 1;
          ((ListIterator)localObject1).remove();
          break;
          c.this.sAz.R(-200L, this.jGL - 1L);
          c.this.sAz.commit();
          c.this.sAA = false;
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
    private long foF;
    
    public b(long paramLong)
    {
      this.foF = paramLong;
    }
    
    public final String bdq()
    {
      AppMethodBeat.i(52723);
      String str = String.format("{MsgId: %d}", new Object[] { Long.valueOf(this.foF) });
      AppMethodBeat.o(52723);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52722);
      c.this.sAz.c(com.tencent.mm.plugin.fts.a.c.swl, this.foF);
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
    private List<bo> sAL;
    private StringBuffer sAM;
    
    public c()
    {
      AppMethodBeat.i(52724);
      this.sAL = new ArrayList();
      Collection localCollection;
      this.sAL.addAll(localCollection);
      this.sAM = new StringBuffer();
      AppMethodBeat.o(52724);
    }
    
    public final String bdq()
    {
      AppMethodBeat.i(52726);
      String str = this.sAM.toString();
      AppMethodBeat.o(52726);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52725);
      Object localObject1 = new ArrayList();
      Object localObject2 = this.sAL.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bo)((Iterator)localObject2).next();
        c.d locald = new c.d(c.this, (byte)0);
        locald.msgId = ((dy)localObject3).field_msgId;
        locald.talker = ((dy)localObject3).field_talker;
        locald.createTime = ((dy)localObject3).field_createTime;
        locald.content = ((dy)localObject3).field_content;
        locald.msgType = ((bo)localObject3).getType();
        locald.sAO = ((dy)localObject3).field_isSend;
        if (c.a(locald))
        {
          locald.cKQ();
          if (locald.isAvailable()) {
            ((List)localObject1).add(locald);
          }
        }
      }
      this.sAM.append("{MsgId: ");
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (c.d)((Iterator)localObject2).next();
        this.sAM.append(((c.d)localObject3).msgId);
        this.sAM.append(",");
        this.sAM.append(((c.d)localObject3).talker);
        this.sAM.append(",");
        this.sAM.append(((c.d)localObject3).createTime);
        this.sAM.append(" ");
      }
      this.sAM.append("count: ");
      this.sAM.append(((List)localObject1).size());
      this.sAM.append("}");
      if (((List)localObject1).size() > 0)
      {
        c.this.sAz.beginTransaction();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c.d)((Iterator)localObject1).next();
          c.this.sAz.a(((c.d)localObject2).sAN, ((c.d)localObject2).msgId, ((c.d)localObject2).talker, ((c.d)localObject2).createTime, ((c.d)localObject2).sAP, ((c.d)localObject2).sAQ);
        }
        c.this.sAz.commit();
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
    int sAN;
    int sAO;
    String sAP;
    String sAQ;
    String talker;
    
    private d() {}
    
    public final boolean cKN()
    {
      return (this.msgType & 0xFFFF) == 49;
    }
    
    public final boolean cKO()
    {
      return this.msgType == 1;
    }
    
    public final boolean cKP()
    {
      return this.msgType == 48;
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(52727);
      if (cKO())
      {
        this.sAN = 41;
        if ((w.sQ(this.talker)) && (this.sAO == 0)) {
          this.sAP = bi.ym(this.content);
        }
      }
      for (;;)
      {
        if (!bs.isNullOrNil(this.sAP)) {
          this.sAP = com.tencent.mm.plugin.fts.a.d.afP(this.sAP);
        }
        if (this.sAO != 1) {
          break;
        }
        this.sAQ = u.axw();
        AppMethodBeat.o(52727);
        return;
        this.sAP = this.content;
        continue;
        Object localObject;
        if (cKN())
        {
          localObject = k.b.vA(this.content);
          if (localObject != null) {
            switch (((k.b)localObject).type)
            {
            default: 
              break;
            case 1: 
            case 53: 
            case 57: 
              this.sAP = bs.bG(((k.b)localObject).getTitle(), "");
              this.sAN = 52;
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
              this.sAP = bs.bG(((k.b)localObject).getTitle(), "");
              this.sAN = 43;
              break;
            case 6: 
              this.sAP = bs.bG(((k.b)localObject).getTitle(), "");
              this.sAN = 42;
              break;
            case 19: 
              this.sAP = bs.bG(((k.b)localObject).getDescription(), "");
              if (this.sAP != null) {
                this.sAP = this.sAP.replace(":", "​");
              }
              this.sAN = 44;
              break;
            case 24: 
              this.sAP = bs.bG(((k.b)localObject).getDescription(), "");
              if (this.sAP != null) {
                this.sAP = this.sAP.replace(":", "​");
              }
              this.sAN = 49;
              break;
            case 33: 
              this.sAP = bs.bG(((k.b)localObject).getTitle(), "");
              this.sAN = 48;
              break;
            case 2000: 
              this.sAP = (bs.bG(((k.b)localObject).title, "") + "​" + bs.bG(((k.b)localObject).description, ""));
              this.sAN = 45;
              break;
            case 2001: 
              if ("1001".equals(((k.b)localObject).hjn))
              {
                this.sAN = 47;
                if (this.sAO == 1)
                {
                  this.sAP = (bs.bG(((k.b)localObject).hjl, "") + "​" + bs.bG(((k.b)localObject).hji, ""));
                  continue;
                }
                this.sAP = (bs.bG(((k.b)localObject).hjl, "") + "​" + bs.bG(((k.b)localObject).hjh, ""));
                continue;
              }
              if (!"1002".equals(((k.b)localObject).hjn)) {
                continue;
              }
              this.sAN = 46;
              if (this.sAO == 1)
              {
                this.sAP = (bs.bG(((k.b)localObject).hjl, "") + "​" + bs.bG(((k.b)localObject).hji, ""));
                continue;
              }
              this.sAP = (bs.bG(((k.b)localObject).hjl, "") + "​" + bs.bG(((k.b)localObject).hjh, ""));
              break;
            case 51: 
              this.sAP = bs.bG(((com.tencent.mm.plugin.i.a.b)((k.b)localObject).ao(com.tencent.mm.plugin.i.a.b.class)).hTI.nickname, "");
              this.sAN = 53;
              break;
            }
          }
        }
        else if (cKP())
        {
          this.sAN = 50;
          if (w.sQ(this.talker)) {}
          for (localObject = bi.ym(this.content);; localObject = this.content)
          {
            localObject = ((k)g.ab(k.class)).dcr().alx((String)localObject);
            if (!((bo.b)localObject).fcm()) {
              break label894;
            }
            this.sAP = (((bo.b)localObject).gPy + "​" + ((bo.b)localObject).label);
            break;
          }
          label894:
          this.sAP = ((bo.b)localObject).label;
        }
      }
      if (w.sQ(this.talker))
      {
        this.sAQ = bs.bG(bi.yl(this.content), this.talker);
        AppMethodBeat.o(52727);
        return;
      }
      this.sAQ = this.talker;
      AppMethodBeat.o(52727);
    }
    
    public final boolean isAvailable()
    {
      AppMethodBeat.i(52728);
      if (!bs.isNullOrNil(this.sAP))
      {
        AppMethodBeat.o(52728);
        return true;
      }
      AppMethodBeat.o(52728);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c
 * JD-Core Version:    0.7.0.1
 */