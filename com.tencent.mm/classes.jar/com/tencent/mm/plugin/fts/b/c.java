package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.h.a;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.b;
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
  implements i.a
{
  private com.tencent.mm.sdk.b.c fNH;
  private com.tencent.mm.sdk.b.c fNI;
  com.tencent.mm.plugin.fts.a.m gtT;
  com.tencent.mm.plugin.fts.a.j rCj;
  com.tencent.mm.plugin.fts.c.c tHR;
  boolean tHS;
  private com.tencent.mm.sdk.b.c tHT;
  com.tencent.mm.sdk.b.c tHU;
  aw tHV;
  h.a tHW;
  
  public c()
  {
    AppMethodBeat.i(52735);
    this.tHS = false;
    this.fNH = new c.1(this);
    this.fNI = new c.2(this);
    this.tHT = new com.tencent.mm.sdk.b.c() {};
    this.tHU = new c.4(this);
    this.tHV = new aw(g.ajU().IxZ.getLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52716);
        if (!c.this.tHS)
        {
          c.this.tHS = true;
          if (c.this.gtT != null) {
            c.this.gtT.a(131112, new c.a(c.this, (byte)0));
          }
        }
        com.tencent.mm.sdk.b.a.IvT.d(c.this.tHU);
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
    this.tHW = new h.a()
    {
      public final String[] alu(String paramAnonymousString)
      {
        AppMethodBeat.i(52719);
        paramAnonymousString = com.tencent.mm.plugin.fts.a.c.a.tEf.split(paramAnonymousString, 2);
        AppMethodBeat.o(52719);
        return paramAnonymousString;
      }
      
      public final String[] split(String paramAnonymousString)
      {
        AppMethodBeat.i(52718);
        if (((PluginFTS)g.ad(PluginFTS.class)).getFTSIndexDB().tCE)
        {
          paramAnonymousString = bu.hs(c.alA(paramAnonymousString));
          AppMethodBeat.o(52718);
          return paramAnonymousString;
        }
        paramAnonymousString = com.tencent.mm.plugin.fts.a.c.a.tEf.split(paramAnonymousString);
        AppMethodBeat.o(52718);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(52735);
  }
  
  public static List<String> alA(String paramString)
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
      ae.i("MicroMsg.FTS.FTS5SearchMessageLogic", "mmICUTokenize Query-tokenList: %s indexes: %s", new Object[] { localArrayList, str2 });
      AppMethodBeat.o(52740);
      return localArrayList;
      i += 3;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(52736);
    switch (paramj.jUf)
    {
    default: 
      paramj = new i(paramj);
    }
    for (;;)
    {
      paramj = this.gtT.a(-65536, paramj);
      AppMethodBeat.o(52736);
      return paramj;
      paramj = new f(paramj);
      continue;
      ae.i("MicroMsg.FTS.FTS5SearchMessageLogic", "total message count %d", new Object[] { Long.valueOf(e.tEm.tEs) });
      if (e.tEm.tEs >= 1000000L)
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
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(52739);
    if (paramc.vWi.equals("insert"))
    {
      parami = new ArrayList();
      int j = 0;
      if (j < paramc.gQn.size())
      {
        bv localbv = (bv)paramc.gQn.get(j);
        int i;
        if ((localbv == null) || (bu.isNullOrNil(localbv.field_talker)) || (bu.isNullOrNil(localbv.field_content))) {
          i = 0;
        }
        for (;;)
        {
          if (i != 0) {
            parami.add(localbv);
          }
          j += 1;
          break;
          if (localbv.field_talker.contains("@bottle")) {
            i = 0;
          } else if (an.aUx(localbv.field_talker)) {
            i = 0;
          } else if ((localbv.getType() != 1) && (!localbv.cVH()) && (!localbv.cVJ())) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (parami.size() > 0) {
        this.gtT.a(65576, new c(parami));
      }
    }
    AppMethodBeat.o(52739);
  }
  
  public final boolean agO()
  {
    AppMethodBeat.i(52738);
    ((l)g.ab(l.class)).doJ().a(this);
    this.tHU.dead();
    this.tHT.dead();
    this.fNI.dead();
    this.fNH.dead();
    this.tHR = null;
    this.gtT = null;
    this.tHV.stopTimer();
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
      ae.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Fail!");
      AppMethodBeat.o(52737);
      return false;
    }
    ae.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Success!");
    this.tHR = ((com.tencent.mm.plugin.fts.c.c)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(4));
    this.gtT = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.rCj = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
    this.tHU.alive();
    this.tHT.alive();
    this.fNI.alive();
    this.fNH.alive();
    ((l)g.ab(l.class)).doJ().a(this, null);
    AppMethodBeat.o(52737);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private long ken = 9223372036854775807L;
    private int mFailedCount = 0;
    private int rCq = 0;
    private int rCr = 0;
    private HashSet<Pair<Long, Long>> tHZ = null;
    private ArrayList<Long> tIa = null;
    private long tIb = -1L;
    private int tIc = 0;
    
    private a() {}
    
    public final String bhC()
    {
      AppMethodBeat.i(52721);
      String str = String.format("{new: %d removed: %d failed: %d}", new Object[] { Integer.valueOf(this.rCq), Integer.valueOf(this.rCr), Integer.valueOf(this.mFailedCount) });
      AppMethodBeat.o(52721);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52720);
      this.ken = c.this.tHR.tDu.Q(-200L, 9223372036854775807L);
      this.tIb = ((l)g.ab(l.class)).aAi().aqP("");
      if (this.ken > this.tIb)
      {
        c.this.tHR.R(-310L, System.currentTimeMillis());
        c.this.tHR.R(-311L, com.tencent.mm.protocal.d.FFH);
      }
      ae.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: %s last from createTime: %s", new Object[] { Long.valueOf(this.ken), Long.valueOf(this.tIb) });
      long l1;
      long l2;
      if (this.tHZ == null)
      {
        this.tHZ = new HashSet();
        this.tIa = new ArrayList();
        localObject1 = c.this.tHR.a(com.tencent.mm.plugin.fts.a.c.tDD, true, true, false, true, true);
        while (((Cursor)localObject1).moveToNext())
        {
          l1 = ((Cursor)localObject1).getLong(0);
          l2 = ((Cursor)localObject1).getLong(1);
          long l3 = ((Cursor)localObject1).getLong(2);
          if (((Cursor)localObject1).getInt(3) == -1) {
            this.tIa.add(Long.valueOf(l1));
          } else if (l3 <= this.ken) {
            this.tHZ.add(new Pair(Long.valueOf(l2), Long.valueOf(l3)));
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
        localObject1[0] = Long.toString(this.ken);
        localObject1[1] = Long.toString(this.tIb);
        localObject1[2] = Integer.toString(this.tIc);
        Object localObject3 = c.this.rCj.rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime>? AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", (String[])localObject1);
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
          locald.tIg = ((Cursor)localObject3).getInt(5);
          locald.tIf = 41;
          if (c.a(locald))
          {
            locald.cVK();
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
          ae.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d offset %s", new Object[] { Integer.valueOf(j), Integer.valueOf(this.tIc) });
          if (j <= 0) {
            break label1009;
          }
          c.this.tHR.beginTransaction();
          localObject3 = ((List)localObject2).iterator();
          label639:
          if (!((Iterator)localObject3).hasNext()) {
            break label952;
          }
          locald = (c.d)((Iterator)localObject3).next();
          l1 = locald.msgId;
          l2 = locald.createTime;
          if (l2 != this.ken) {
            break label938;
          }
        }
        for (this.tIc += 1;; this.tIc = 0)
        {
          for (;;)
          {
            Pair localPair = new Pair(Long.valueOf(l1), Long.valueOf(l2));
            if (this.tHZ.remove(localPair)) {
              break;
            }
            try
            {
              c.this.tHR.a(locald.tIf, l1, locald.talker, l2, locald.tIh, locald.tIi);
              this.rCq += 1;
            }
            catch (Exception localException)
            {
              ae.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", localException, "Build message index failed with exception. \n%s", new Object[] { locald.tIh });
              this.mFailedCount += 1;
            }
          }
          break label639;
          ae.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d Id FROM %d to %d Time FROM %s to %s offset %s", new Object[] { Integer.valueOf(j), Long.valueOf(((c.d)((List)localObject2).get(0)).msgId), Long.valueOf(((c.d)((List)localObject2).get(j - 1)).msgId), com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", ((c.d)((List)localObject2).get(0)).createTime / 1000L), com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", ((c.d)((List)localObject2).get(j - 1)).createTime / 1000L), Integer.valueOf(this.tIc) });
          break;
          label938:
          this.ken = l2;
        }
        label952:
        c.this.tHR.commit();
        c.this.tHR.R(-200L, this.ken);
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
          this.ken = l1;
          this.tIc = 0;
        }
      }
      i = 50;
      localObject1 = this.tHZ.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        if (Thread.interrupted())
        {
          c.this.tHR.commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52720);
          throw ((Throwable)localObject1);
        }
        if (i < 50) {
          break label1372;
        }
        c.this.tHR.commit();
        c.this.tHR.beginTransaction();
        i = 0;
      }
      label1369:
      label1372:
      for (;;)
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        c.this.tHR.a(com.tencent.mm.plugin.fts.a.c.tDD, ((Long)((Pair)localObject2).first).longValue(), ((Long)((Pair)localObject2).second).longValue());
        i += 1;
        this.rCr += 1;
        ((Iterator)localObject1).remove();
        break;
        c.this.tHR.commit();
        i = 50;
        localObject1 = this.tIa.listIterator(this.tIa.size());
        if (((ListIterator)localObject1).hasPrevious())
        {
          if (Thread.interrupted())
          {
            c.this.tHR.commit();
            localObject1 = new InterruptedException();
            AppMethodBeat.o(52720);
            throw ((Throwable)localObject1);
          }
          if (i < 50) {
            break label1369;
          }
          c.this.tHR.commit();
          c.this.tHR.beginTransaction();
          i = 0;
        }
        for (;;)
        {
          l1 = ((Long)((ListIterator)localObject1).previous()).longValue();
          c.this.tHR.xT(l1);
          i += 1;
          this.rCr += 1;
          ((ListIterator)localObject1).remove();
          break;
          c.this.tHR.R(-200L, this.ken - 1L);
          c.this.tHR.commit();
          c.this.tHS = false;
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
    private List<bv> tId;
    private StringBuffer tIe;
    
    public c()
    {
      AppMethodBeat.i(52724);
      this.tId = new ArrayList();
      Collection localCollection;
      this.tId.addAll(localCollection);
      this.tIe = new StringBuffer();
      AppMethodBeat.o(52724);
    }
    
    public final String bhC()
    {
      AppMethodBeat.i(52726);
      String str = this.tIe.toString();
      AppMethodBeat.o(52726);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52725);
      Object localObject1 = new ArrayList();
      Object localObject2 = this.tId.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bv)((Iterator)localObject2).next();
        c.d locald = new c.d(c.this, (byte)0);
        locald.msgId = ((ei)localObject3).field_msgId;
        locald.talker = ((ei)localObject3).field_talker;
        locald.createTime = ((ei)localObject3).field_createTime;
        locald.content = ((ei)localObject3).field_content;
        locald.msgType = ((bv)localObject3).getType();
        locald.tIg = ((ei)localObject3).field_isSend;
        if (c.a(locald))
        {
          locald.cVK();
          if (locald.isAvailable()) {
            ((List)localObject1).add(locald);
          }
        }
      }
      this.tIe.append("{MsgId: ");
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (c.d)((Iterator)localObject2).next();
        this.tIe.append(((c.d)localObject3).msgId);
        this.tIe.append(",");
        this.tIe.append(((c.d)localObject3).talker);
        this.tIe.append(",");
        this.tIe.append(((c.d)localObject3).createTime);
        this.tIe.append(" ");
      }
      this.tIe.append("count: ");
      this.tIe.append(((List)localObject1).size());
      this.tIe.append("}");
      if (((List)localObject1).size() > 0)
      {
        c.this.tHR.beginTransaction();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c.d)((Iterator)localObject1).next();
          c.this.tHR.a(((c.d)localObject2).tIf, ((c.d)localObject2).msgId, ((c.d)localObject2).talker, ((c.d)localObject2).createTime, ((c.d)localObject2).tIh, ((c.d)localObject2).tIi);
        }
        c.this.tHR.commit();
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
    int tIf;
    int tIg;
    String tIh;
    String tIi;
    String talker;
    
    private d() {}
    
    public final boolean cVH()
    {
      return (this.msgType & 0xFFFF) == 49;
    }
    
    public final boolean cVI()
    {
      return this.msgType == 1;
    }
    
    public final boolean cVJ()
    {
      return this.msgType == 48;
    }
    
    public final void cVK()
    {
      AppMethodBeat.i(52727);
      if (cVI())
      {
        this.tIf = 41;
        if ((x.wb(this.talker)) && (this.tIg == 0)) {
          this.tIh = bl.BN(this.content);
        }
      }
      for (;;)
      {
        if (!bu.isNullOrNil(this.tIh)) {
          this.tIh = com.tencent.mm.plugin.fts.a.d.all(this.tIh);
        }
        if (!an.zd(this.talker)) {
          break;
        }
        this.tIi = this.talker;
        this.talker = "appbrandcustomerservicemsg";
        AppMethodBeat.o(52727);
        return;
        this.tIh = this.content;
        continue;
        Object localObject;
        if (cVH())
        {
          localObject = k.b.zb(this.content);
          if (localObject != null) {
            switch (((k.b)localObject).type)
            {
            default: 
              break;
            case 1: 
            case 53: 
            case 57: 
              this.tIh = bu.bI(((k.b)localObject).getTitle(), "");
              this.tIf = 52;
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
              this.tIh = bu.bI(((k.b)localObject).getTitle(), "");
              this.tIf = 43;
              break;
            case 6: 
              this.tIh = bu.bI(((k.b)localObject).getTitle(), "");
              this.tIf = 42;
              break;
            case 19: 
              this.tIh = bu.bI(((k.b)localObject).getDescription(), "");
              if (this.tIh != null) {
                this.tIh = this.tIh.replace(":", "​");
              }
              this.tIf = 44;
              break;
            case 24: 
              this.tIh = bu.bI(((k.b)localObject).getDescription(), "");
              if (this.tIh != null) {
                this.tIh = this.tIh.replace(":", "​");
              }
              this.tIf = 49;
              break;
            case 33: 
              this.tIh = bu.bI(((k.b)localObject).getTitle(), "");
              this.tIf = 48;
              break;
            case 2000: 
              this.tIh = (bu.bI(((k.b)localObject).title, "") + "​" + bu.bI(((k.b)localObject).description, ""));
              this.tIf = 45;
              break;
            case 2001: 
              if ("1001".equals(((k.b)localObject).hEk))
              {
                this.tIf = 47;
                if (this.tIg == 1)
                {
                  this.tIh = (bu.bI(((k.b)localObject).hEi, "") + "​" + bu.bI(((k.b)localObject).hEf, ""));
                  continue;
                }
                this.tIh = (bu.bI(((k.b)localObject).hEi, "") + "​" + bu.bI(((k.b)localObject).hEe, ""));
                continue;
              }
              if (!"1002".equals(((k.b)localObject).hEk)) {
                continue;
              }
              this.tIf = 46;
              if (this.tIg == 1)
              {
                this.tIh = (bu.bI(((k.b)localObject).hEi, "") + "​" + bu.bI(((k.b)localObject).hEf, ""));
                continue;
              }
              this.tIh = (bu.bI(((k.b)localObject).hEi, "") + "​" + bu.bI(((k.b)localObject).hEe, ""));
              break;
            case 51: 
              this.tIh = bu.bI(((com.tencent.mm.plugin.i.a.b)((k.b)localObject).ao(com.tencent.mm.plugin.i.a.b.class)).ipW.nickname, "");
              this.tIf = 53;
              break;
            }
          }
        }
        else if (cVJ())
        {
          this.tIf = 50;
          if (x.wb(this.talker)) {}
          for (localObject = bl.BN(this.content);; localObject = this.content)
          {
            localObject = ((l)g.ab(l.class)).doJ().arq((String)localObject);
            if (!((bv.b)localObject).fwu()) {
              break label902;
            }
            this.tIh = (((bv.b)localObject).jGd + "​" + ((bv.b)localObject).label);
            break;
          }
          label902:
          this.tIh = ((bv.b)localObject).label;
        }
      }
      if (this.tIg == 1)
      {
        this.tIi = v.aAC();
        AppMethodBeat.o(52727);
        return;
      }
      if (x.wb(this.talker))
      {
        this.tIi = bu.bI(bl.BM(this.content), this.talker);
        AppMethodBeat.o(52727);
        return;
      }
      this.tIi = this.talker;
      AppMethodBeat.o(52727);
    }
    
    public final boolean isAvailable()
    {
      AppMethodBeat.i(52728);
      if (!bu.isNullOrNil(this.tIh))
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
      alt("start");
      paramk.tFe = com.tencent.mm.plugin.fts.a.a.h.a(this.tFP.query, false, c.this.tHW);
      Object localObject1 = com.tencent.mm.plugin.fts.a.a.h.bq(this.tFP.tFU, true);
      HashMap localHashMap = new HashMap();
      Object localObject2 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, this.tFP.talker, com.tencent.mm.plugin.fts.a.c.tDM, com.tencent.mm.plugin.fts.a.c.tDQ);
      do
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break;
        }
        localObject3 = new com.tencent.mm.plugin.fts.a.a.n();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).tEY = ((Cursor)localObject2).getString(0);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).type = ((Cursor)localObject2).getInt(1);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).tEX = ((Cursor)localObject2).getInt(2);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).tFe = ((com.tencent.mm.plugin.fts.a.a.h)localObject1);
        if (!localHashMap.containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject3).tEY)) {
          localHashMap.put(((com.tencent.mm.plugin.fts.a.a.m)localObject3).tEY, localObject3);
        }
      } while (localHashMap.size() <= 100);
      ((Cursor)localObject2).close();
      alt("findHitContact");
      localObject2 = c.this.tHR.a(paramk.tFe, this.tFP.tFT, localHashMap.keySet());
      Object localObject3 = new HashMap();
      if (((Cursor)localObject2).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().g((Cursor)localObject2);
        localn.tFe = paramk.tFe;
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
      paramk.tGc = new ArrayList();
      localObject1 = ((HashMap)localObject3).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = (com.tencent.mm.plugin.fts.a.a.m)localHashMap.get(((Map.Entry)localObject2).getKey());
        if (localObject3 != null)
        {
          Collections.sort((List)((Map.Entry)localObject2).getValue(), this.tFP.tFZ);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject3).userData = ((Map.Entry)localObject2).getValue();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject3).timestamp = ((com.tencent.mm.plugin.fts.a.a.m)((List)((Map.Entry)localObject2).getValue()).get(0)).timestamp;
          paramk.tGc.add(localObject3);
        }
      }
      Collections.sort(paramk.tGc, this.tFP.tFZ);
      alt("findHitMessage");
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
      alt("start");
      paramk.tFe = com.tencent.mm.plugin.fts.a.a.h.a(this.tFP.query, false, c.this.tHW);
      Object localObject1 = c.this.tHR;
      Object localObject3 = paramk.tFe;
      Object localObject2 = this.tFP.tFT;
      localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).cVq();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cVl(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cVl(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cVl(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tDu.rawQuery((String)localObject3, new String[] { localObject2 });
      paramk.tGc = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.n().g((Cursor)localObject1);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).userData = Integer.valueOf(1);
        paramk.tGc.add(localObject2);
      }
      ((Cursor)localObject1).close();
      alt("findConversationMessage");
      if ((paramk.tFe.tFF.length > 1) && (!this.tFP.tFY.contains("create_talker_message​")))
      {
        localObject1 = com.tencent.mm.plugin.fts.a.a.h.bq(paramk.tFe.tFF[0], true);
        localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.tDM, com.tencent.mm.plugin.fts.a.c.tDQ);
        if (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tEY = "create_talker_message​";
          paramk.tGc.add(0, localObject2);
        }
        ((Cursor)localObject1).close();
        alt("findTalkerConversation");
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
      alt("start");
      paramk.tFe = com.tencent.mm.plugin.fts.a.a.h.a(this.tFP.query, false, c.this.tHW);
      Object localObject1 = c.this.tHR;
      Object localObject2 = paramk.tFe.cVq();
      localObject2 = String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cVl(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cVk(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cVl(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cVl(), localObject2 });
      localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tDu.rawQuery((String)localObject2, null);
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
          locala.tEX = ((Cursor)localObject2).getInt(1);
          locala.tGf = ((Cursor)localObject2).getLong(2);
          locala.tEY = ((Cursor)localObject2).getString(3);
          locala.timestamp = ((Cursor)localObject2).getLong(4);
          ((List)localObject1).add(locala);
          ((List)localObject4).add(str);
        }
      } while (((List)localObject1).size() <= this.tFP.tFX);
      ((Cursor)localObject2).close();
      paramk.tGc = new LinkedList();
      alt("findUsername");
      if (((List)localObject4).size() > 0)
      {
        localObject3 = c.this.tHR.a(paramk.tFe, (List)localObject4);
        localObject2 = new HashMap();
        if (((Cursor)localObject3).moveToNext())
        {
          localObject4 = ((Cursor)localObject3).getString(0).split(" ");
          i = 0;
          while (i < localObject4.length)
          {
            ((HashMap)localObject2).put(localObject4[i], Integer.valueOf(bu.getInt(localObject4[(i + 1)], 0)));
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
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).tEX = ((a)localObject3).tEX;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).tGf = ((a)localObject3).tGf;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).tEY = ((a)localObject3).tEY;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).timestamp = ((a)localObject3).timestamp;
          if (!((HashMap)localObject2).containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject4).tEY)) {
            break label699;
          }
        }
      }
      label699:
      for (int i = ((Integer)((HashMap)localObject2).get(((com.tencent.mm.plugin.fts.a.a.m)localObject4).tEY)).intValue();; i = 1)
      {
        if (x.AW(((com.tencent.mm.plugin.fts.a.a.m)localObject4).tEY)) {
          i = 0;
        }
        ((com.tencent.mm.plugin.fts.a.a.m)localObject4).userData = Integer.valueOf(i);
        paramk.tGc.add(localObject4);
        break;
        alt("findCount");
        if ((paramk.tFe.tFF.length > 1) && (paramk.tGc.size() <= 3))
        {
          localObject1 = com.tencent.mm.plugin.fts.a.a.h.bq(paramk.tFe.tFF[0], true);
          localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.tDM, com.tencent.mm.plugin.fts.a.c.tDQ);
          if (((Cursor)localObject1).moveToNext())
          {
            localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
            ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tEY = "create_talker_message​";
            paramk.tGc.add(localObject2);
          }
          ((Cursor)localObject1).close();
          alt("findTalkerConversation");
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
      int tEX;
      String tEY;
      long tGf;
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
      alt("start");
      paramk.tFe = com.tencent.mm.plugin.fts.a.a.h.a(this.tFP.query, false, c.this.tHW);
      Object localObject1 = com.tencent.mm.plugin.fts.a.a.h.bq(this.tFP.tFU, true);
      Object localObject2 = new HashMap();
      Object localObject3 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.tDM, com.tencent.mm.plugin.fts.a.c.tDQ);
      do
      {
        if (!((Cursor)localObject3).moveToNext()) {
          break;
        }
        localObject4 = new com.tencent.mm.plugin.fts.a.a.n();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).tEY = ((Cursor)localObject3).getString(0);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).type = ((Cursor)localObject3).getInt(1);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).tEX = ((Cursor)localObject3).getInt(2);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).tFe = ((com.tencent.mm.plugin.fts.a.a.h)localObject1);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).userData = Integer.valueOf(1);
        if (!((HashMap)localObject2).containsKey(((com.tencent.mm.plugin.fts.a.a.n)localObject4).tEY)) {
          ((HashMap)localObject2).put(((com.tencent.mm.plugin.fts.a.a.n)localObject4).tEY, localObject4);
        }
      } while (((HashMap)localObject2).size() <= 100);
      ((Cursor)localObject3).close();
      alt("findHitContact");
      Object localObject4 = c.this.tHR.a(paramk.tFe, null, ((HashMap)localObject2).keySet());
      localObject3 = new HashMap();
      if (((Cursor)localObject4).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().g((Cursor)localObject4);
        localn.tFe = paramk.tFe;
        localn.userData = Integer.valueOf(1);
        label306:
        com.tencent.mm.plugin.fts.a.a.m localm;
        int i;
        if (((HashMap)localObject3).containsKey(localn.talker))
        {
          localObject1 = (HashMap)((HashMap)localObject3).get(localn.talker);
          if (!((HashMap)localObject1).containsKey(localn.tEY)) {
            break label431;
          }
          localm = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject1).get(localn.tEY);
          i = ((Integer)localm.userData).intValue() + 1;
          if (localm.timestamp >= localn.timestamp) {
            break label407;
          }
          localn.userData = Integer.valueOf(i);
          ((HashMap)localObject1).put(localn.tEY, localn);
        }
        for (;;)
        {
          ((HashMap)localObject3).put(localn.talker, localObject1);
          break;
          localObject1 = new HashMap();
          break label306;
          label407:
          localm.userData = Integer.valueOf(i);
          ((HashMap)localObject1).put(localm.tEY, localm);
          continue;
          label431:
          ((HashMap)localObject1).put(localn.tEY, localn);
        }
      }
      ((Cursor)localObject4).close();
      paramk.tGc = new ArrayList();
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.m)((Iterator)localObject1).next();
        if (((HashMap)localObject3).containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject2).tEY))
        {
          localObject4 = new ArrayList();
          ((List)localObject4).addAll(((HashMap)((HashMap)localObject3).get(((com.tencent.mm.plugin.fts.a.a.m)localObject2).tEY)).values());
          Collections.sort((List)localObject4, this.tFP.tFZ);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).userData = localObject4;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).timestamp = ((com.tencent.mm.plugin.fts.a.a.m)((List)localObject4).get(0)).timestamp;
          paramk.tGc.add(localObject2);
        }
      }
      Collections.sort(paramk.tGc, this.tFP.tFZ);
      alt("findHitMessage");
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
    private int tIk = 0;
    private int tIl = 0;
    
    public i(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52733);
      alt("start");
      paramk.tFe = com.tencent.mm.plugin.fts.a.a.h.a(this.tFP.query, false, c.this.tHW);
      Object localObject2 = c.this.tHR;
      Object localObject1 = paramk.tFe;
      int i = this.tFP.tFX;
      String str = ((com.tencent.mm.plugin.fts.a.a.h)localObject1).cVq();
      if (i != 2147483647) {}
      for (localObject1 = " LIMIT " + (i + 1);; localObject1 = "")
      {
        localObject1 = String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (String)localObject1 + ";", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject2).cVk(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cVl(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cVk(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cVl(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cVl(), str });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).tDu.rawQuery((String)localObject1, null);
        paramk.tGc = new LinkedList();
        while (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).type = ((Cursor)localObject1).getInt(0);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tEX = ((Cursor)localObject1).getInt(1);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tGf = ((Cursor)localObject1).getLong(2);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tEY = ((Cursor)localObject1).getString(3);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).timestamp = ((Cursor)localObject1).getLong(4);
          int j = ((Cursor)localObject1).getInt(5);
          i = j;
          if (j == 1)
          {
            i = j;
            if (x.AW(((com.tencent.mm.plugin.fts.a.a.m)localObject2).tEY)) {
              i = 0;
            }
          }
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).userData = Integer.valueOf(i);
          paramk.tGc.add(localObject2);
          i = this.tIk;
          this.tIk = (((Integer)((com.tencent.mm.plugin.fts.a.a.m)localObject2).userData).intValue() + i);
          this.tIl += 1;
        }
      }
      ((Cursor)localObject1).close();
      alt("groupMessage");
      if (paramk.tFe.tFF.length > 1)
      {
        localObject1 = com.tencent.mm.plugin.fts.a.a.h.bq(paramk.tFe.tFF[0], true);
        localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.tDM, com.tencent.mm.plugin.fts.a.c.tDQ);
        if (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tEY = "create_talker_message​";
          paramk.tGc.add(0, localObject2);
        }
        ((Cursor)localObject1).close();
        alt("findTalkerConversation");
      }
      AppMethodBeat.o(52733);
    }
    
    public final String bhC()
    {
      AppMethodBeat.i(52734);
      String str = String.format("{totalMsgCount: %d conversationCount: %d}", new Object[] { Integer.valueOf(this.tIk), Integer.valueOf(this.tIl) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c
 * JD-Core Version:    0.7.0.1
 */