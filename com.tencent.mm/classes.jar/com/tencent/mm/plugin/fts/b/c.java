package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.h.a;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.b;
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
  private com.tencent.mm.sdk.b.c fLD;
  private com.tencent.mm.sdk.b.c fLE;
  com.tencent.mm.plugin.fts.a.m grs;
  com.tencent.mm.plugin.fts.a.j rtX;
  com.tencent.mm.plugin.fts.c.c txa;
  boolean txb;
  private com.tencent.mm.sdk.b.c txc;
  com.tencent.mm.sdk.b.c txd;
  av txe;
  h.a txf;
  
  public c()
  {
    AppMethodBeat.i(52735);
    this.txb = false;
    this.fLD = new c.1(this);
    this.fLE = new c.2(this);
    this.txc = new com.tencent.mm.sdk.b.c() {};
    this.txd = new c.4(this);
    this.txe = new av(g.ajF().IdO.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52716);
        if (!c.this.txb)
        {
          c.this.txb = true;
          if (c.this.grs != null) {
            c.this.grs.a(131112, new c.a(c.this, (byte)0));
          }
        }
        com.tencent.mm.sdk.b.a.IbL.d(c.this.txd);
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
    this.txf = new h.a()
    {
      public final String[] akw(String paramAnonymousString)
      {
        AppMethodBeat.i(52719);
        paramAnonymousString = com.tencent.mm.plugin.fts.a.c.a.tto.split(paramAnonymousString, 2);
        AppMethodBeat.o(52719);
        return paramAnonymousString;
      }
      
      public final String[] split(String paramAnonymousString)
      {
        AppMethodBeat.i(52718);
        if (((PluginFTS)g.ad(PluginFTS.class)).getFTSIndexDB().trN)
        {
          paramAnonymousString = bt.hi(c.akC(paramAnonymousString));
          AppMethodBeat.o(52718);
          return paramAnonymousString;
        }
        paramAnonymousString = com.tencent.mm.plugin.fts.a.c.a.tto.split(paramAnonymousString);
        AppMethodBeat.o(52718);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(52735);
  }
  
  public static List<String> akC(String paramString)
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
    switch (paramj.jQN)
    {
    default: 
      paramj = new i(paramj);
    }
    for (;;)
    {
      paramj = this.grs.a(-65536, paramj);
      AppMethodBeat.o(52736);
      return paramj;
      paramj = new f(paramj);
      continue;
      ad.i("MicroMsg.FTS.FTS5SearchMessageLogic", "total message count %d", new Object[] { Long.valueOf(e.ttv.ttB) });
      if (e.ttv.ttB >= 1000000L)
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
    if (paramc.vKe.equals("insert"))
    {
      parami = new ArrayList();
      int j = 0;
      if (j < paramc.gNE.size())
      {
        bu localbu = (bu)paramc.gNE.get(j);
        int i;
        if ((localbu == null) || (bt.isNullOrNil(localbu.field_talker)) || (bt.isNullOrNil(localbu.field_content))) {
          i = 0;
        }
        for (;;)
        {
          if (i != 0) {
            parami.add(localbu);
          }
          j += 1;
          break;
          if (localbu.field_talker.contains("@bottle")) {
            i = 0;
          } else if (am.ail(localbu.field_talker)) {
            i = 0;
          } else if ((localbu.getType() != 1) && (!localbu.cTc()) && (!localbu.cTe())) {
            i = 0;
          } else if (am.aSV(localbu.field_talker)) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (parami.size() > 0) {
        this.grs.a(65576, new c(parami));
      }
    }
    AppMethodBeat.o(52739);
  }
  
  public final boolean agA()
  {
    AppMethodBeat.i(52738);
    ((l)g.ab(l.class)).dlK().a(this);
    this.txd.dead();
    this.txc.dead();
    this.fLE.dead();
    this.fLD.dead();
    this.txa = null;
    this.grs = null;
    this.txe.stopTimer();
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
    this.txa = ((com.tencent.mm.plugin.fts.c.c)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(4));
    this.grs = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.rtX = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
    this.txd.alive();
    this.txc.alive();
    this.fLE.alive();
    this.fLD.alive();
    ((l)g.ab(l.class)).dlK().a(this, null);
    AppMethodBeat.o(52737);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private long kaX = 9223372036854775807L;
    private int mFailedCount = 0;
    private int rue = 0;
    private int ruf = 0;
    private HashSet<Pair<Long, Long>> txi = null;
    private ArrayList<Long> txj = null;
    private long txk = -1L;
    private int txl = 0;
    
    private a() {}
    
    public final String bgU()
    {
      AppMethodBeat.i(52721);
      String str = String.format("{new: %d removed: %d failed: %d}", new Object[] { Integer.valueOf(this.rue), Integer.valueOf(this.ruf), Integer.valueOf(this.mFailedCount) });
      AppMethodBeat.o(52721);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52720);
      this.kaX = c.this.txa.tsD.R(-200L, 9223372036854775807L);
      this.txk = ((l)g.ab(l.class)).azS().apK("");
      if (this.kaX > this.txk)
      {
        c.this.txa.S(-310L, System.currentTimeMillis());
        c.this.txa.S(-311L, com.tencent.mm.protocal.d.Fnj);
      }
      ad.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: %s last from createTime: %s", new Object[] { Long.valueOf(this.kaX), Long.valueOf(this.txk) });
      long l1;
      long l2;
      if (this.txi == null)
      {
        this.txi = new HashSet();
        this.txj = new ArrayList();
        localObject1 = c.this.txa.a(com.tencent.mm.plugin.fts.a.c.tsM, true, true, false, true, true);
        while (((Cursor)localObject1).moveToNext())
        {
          l1 = ((Cursor)localObject1).getLong(0);
          l2 = ((Cursor)localObject1).getLong(1);
          long l3 = ((Cursor)localObject1).getLong(2);
          if (((Cursor)localObject1).getInt(3) == -1) {
            this.txj.add(Long.valueOf(l1));
          } else if (l3 <= this.kaX) {
            this.txi.add(new Pair(Long.valueOf(l2), Long.valueOf(l3)));
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
        localObject1[0] = Long.toString(this.kaX);
        localObject1[1] = Long.toString(this.txk);
        localObject1[2] = Integer.toString(this.txl);
        Object localObject3 = c.this.rtX.rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime>? AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", (String[])localObject1);
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
          locald.txp = ((Cursor)localObject3).getInt(5);
          locald.txo = 41;
          if (c.a(locald))
          {
            locald.cTf();
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
          ad.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d offset %s", new Object[] { Integer.valueOf(j), Integer.valueOf(this.txl) });
          if (j <= 0) {
            break label1009;
          }
          c.this.txa.beginTransaction();
          localObject3 = ((List)localObject2).iterator();
          label639:
          if (!((Iterator)localObject3).hasNext()) {
            break label952;
          }
          locald = (c.d)((Iterator)localObject3).next();
          l1 = locald.msgId;
          l2 = locald.createTime;
          if (l2 != this.kaX) {
            break label938;
          }
        }
        for (this.txl += 1;; this.txl = 0)
        {
          for (;;)
          {
            Pair localPair = new Pair(Long.valueOf(l1), Long.valueOf(l2));
            if (this.txi.remove(localPair)) {
              break;
            }
            try
            {
              c.this.txa.a(locald.txo, l1, locald.talker, l2, locald.txq, locald.txr);
              this.rue += 1;
            }
            catch (Exception localException)
            {
              ad.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", localException, "Build message index failed with exception. \n%s", new Object[] { locald.txq });
              this.mFailedCount += 1;
            }
          }
          break label639;
          ad.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d Id FROM %d to %d Time FROM %s to %s offset %s", new Object[] { Integer.valueOf(j), Long.valueOf(((c.d)((List)localObject2).get(0)).msgId), Long.valueOf(((c.d)((List)localObject2).get(j - 1)).msgId), com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", ((c.d)((List)localObject2).get(0)).createTime / 1000L), com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", ((c.d)((List)localObject2).get(j - 1)).createTime / 1000L), Integer.valueOf(this.txl) });
          break;
          label938:
          this.kaX = l2;
        }
        label952:
        c.this.txa.commit();
        c.this.txa.S(-200L, this.kaX);
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
          this.kaX = l1;
          this.txl = 0;
        }
      }
      i = 50;
      localObject1 = this.txi.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        if (Thread.interrupted())
        {
          c.this.txa.commit();
          localObject1 = new InterruptedException();
          AppMethodBeat.o(52720);
          throw ((Throwable)localObject1);
        }
        if (i < 50) {
          break label1372;
        }
        c.this.txa.commit();
        c.this.txa.beginTransaction();
        i = 0;
      }
      label1369:
      label1372:
      for (;;)
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        c.this.txa.a(com.tencent.mm.plugin.fts.a.c.tsM, ((Long)((Pair)localObject2).first).longValue(), ((Long)((Pair)localObject2).second).longValue());
        i += 1;
        this.ruf += 1;
        ((Iterator)localObject1).remove();
        break;
        c.this.txa.commit();
        i = 50;
        localObject1 = this.txj.listIterator(this.txj.size());
        if (((ListIterator)localObject1).hasPrevious())
        {
          if (Thread.interrupted())
          {
            c.this.txa.commit();
            localObject1 = new InterruptedException();
            AppMethodBeat.o(52720);
            throw ((Throwable)localObject1);
          }
          if (i < 50) {
            break label1369;
          }
          c.this.txa.commit();
          c.this.txa.beginTransaction();
          i = 0;
        }
        for (;;)
        {
          l1 = ((Long)((ListIterator)localObject1).previous()).longValue();
          c.this.txa.xz(l1);
          i += 1;
          this.ruf += 1;
          ((ListIterator)localObject1).remove();
          break;
          c.this.txa.S(-200L, this.kaX - 1L);
          c.this.txa.commit();
          c.this.txb = false;
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
    private List<bu> txm;
    private StringBuffer txn;
    
    public c()
    {
      AppMethodBeat.i(52724);
      this.txm = new ArrayList();
      Collection localCollection;
      this.txm.addAll(localCollection);
      this.txn = new StringBuffer();
      AppMethodBeat.o(52724);
    }
    
    public final String bgU()
    {
      AppMethodBeat.i(52726);
      String str = this.txn.toString();
      AppMethodBeat.o(52726);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52725);
      Object localObject1 = new ArrayList();
      Object localObject2 = this.txm.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bu)((Iterator)localObject2).next();
        c.d locald = new c.d(c.this, (byte)0);
        locald.msgId = ((ei)localObject3).field_msgId;
        locald.talker = ((ei)localObject3).field_talker;
        locald.createTime = ((ei)localObject3).field_createTime;
        locald.content = ((ei)localObject3).field_content;
        locald.msgType = ((bu)localObject3).getType();
        locald.txp = ((ei)localObject3).field_isSend;
        if (c.a(locald))
        {
          locald.cTf();
          if (locald.isAvailable()) {
            ((List)localObject1).add(locald);
          }
        }
      }
      this.txn.append("{MsgId: ");
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (c.d)((Iterator)localObject2).next();
        this.txn.append(((c.d)localObject3).msgId);
        this.txn.append(",");
        this.txn.append(((c.d)localObject3).talker);
        this.txn.append(",");
        this.txn.append(((c.d)localObject3).createTime);
        this.txn.append(" ");
      }
      this.txn.append("count: ");
      this.txn.append(((List)localObject1).size());
      this.txn.append("}");
      if (((List)localObject1).size() > 0)
      {
        c.this.txa.beginTransaction();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c.d)((Iterator)localObject1).next();
          c.this.txa.a(((c.d)localObject2).txo, ((c.d)localObject2).msgId, ((c.d)localObject2).talker, ((c.d)localObject2).createTime, ((c.d)localObject2).txq, ((c.d)localObject2).txr);
        }
        c.this.txa.commit();
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
    int txo;
    int txp;
    String txq;
    String txr;
    
    private d() {}
    
    public final boolean cTc()
    {
      return (this.msgType & 0xFFFF) == 49;
    }
    
    public final boolean cTd()
    {
      return this.msgType == 1;
    }
    
    public final boolean cTe()
    {
      return this.msgType == 48;
    }
    
    public final void cTf()
    {
      AppMethodBeat.i(52727);
      if (cTd())
      {
        this.txo = 41;
        if ((w.vF(this.talker)) && (this.txp == 0)) {
          this.txq = bj.Bl(this.content);
        }
      }
      for (;;)
      {
        if (!bt.isNullOrNil(this.txq)) {
          this.txq = com.tencent.mm.plugin.fts.a.d.akn(this.txq);
        }
        if (!am.yt(this.talker)) {
          break;
        }
        this.txr = this.talker;
        this.talker = "appbrandcustomerservicemsg";
        AppMethodBeat.o(52727);
        return;
        this.txq = this.content;
        continue;
        Object localObject;
        if (cTc())
        {
          localObject = k.b.yr(this.content);
          if (localObject != null) {
            switch (((k.b)localObject).type)
            {
            default: 
              break;
            case 1: 
            case 53: 
            case 57: 
              this.txq = bt.bI(((k.b)localObject).getTitle(), "");
              this.txo = 52;
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
              this.txq = bt.bI(((k.b)localObject).getTitle(), "");
              this.txo = 43;
              break;
            case 6: 
              this.txq = bt.bI(((k.b)localObject).getTitle(), "");
              this.txo = 42;
              break;
            case 19: 
              this.txq = bt.bI(((k.b)localObject).getDescription(), "");
              if (this.txq != null) {
                this.txq = this.txq.replace(":", "​");
              }
              this.txo = 44;
              break;
            case 24: 
              this.txq = bt.bI(((k.b)localObject).getDescription(), "");
              if (this.txq != null) {
                this.txq = this.txq.replace(":", "​");
              }
              this.txo = 49;
              break;
            case 33: 
              this.txq = bt.bI(((k.b)localObject).getTitle(), "");
              this.txo = 48;
              break;
            case 2000: 
              this.txq = (bt.bI(((k.b)localObject).title, "") + "​" + bt.bI(((k.b)localObject).description, ""));
              this.txo = 45;
              break;
            case 2001: 
              if ("1001".equals(((k.b)localObject).hBw))
              {
                this.txo = 47;
                if (this.txp == 1)
                {
                  this.txq = (bt.bI(((k.b)localObject).hBu, "") + "​" + bt.bI(((k.b)localObject).hBr, ""));
                  continue;
                }
                this.txq = (bt.bI(((k.b)localObject).hBu, "") + "​" + bt.bI(((k.b)localObject).hBq, ""));
                continue;
              }
              if (!"1002".equals(((k.b)localObject).hBw)) {
                continue;
              }
              this.txo = 46;
              if (this.txp == 1)
              {
                this.txq = (bt.bI(((k.b)localObject).hBu, "") + "​" + bt.bI(((k.b)localObject).hBr, ""));
                continue;
              }
              this.txq = (bt.bI(((k.b)localObject).hBu, "") + "​" + bt.bI(((k.b)localObject).hBq, ""));
              break;
            case 51: 
              this.txq = bt.bI(((com.tencent.mm.plugin.i.a.b)((k.b)localObject).ao(com.tencent.mm.plugin.i.a.b.class)).inc.nickname, "");
              this.txo = 53;
              break;
            }
          }
        }
        else if (cTe())
        {
          this.txo = 50;
          if (w.vF(this.talker)) {}
          for (localObject = bj.Bl(this.content);; localObject = this.content)
          {
            localObject = ((l)g.ab(l.class)).dlK().aql((String)localObject);
            if (!((bu.b)localObject).fst()) {
              break label902;
            }
            this.txq = (((bu.b)localObject).jDf + "​" + ((bu.b)localObject).label);
            break;
          }
          label902:
          this.txq = ((bu.b)localObject).label;
        }
      }
      if (this.txp == 1)
      {
        this.txr = u.aAm();
        AppMethodBeat.o(52727);
        return;
      }
      if (w.vF(this.talker))
      {
        this.txr = bt.bI(bj.Bk(this.content), this.talker);
        AppMethodBeat.o(52727);
        return;
      }
      this.txr = this.talker;
      AppMethodBeat.o(52727);
    }
    
    public final boolean isAvailable()
    {
      AppMethodBeat.i(52728);
      if (!bt.isNullOrNil(this.txq))
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
      akv("start");
      paramk.tun = com.tencent.mm.plugin.fts.a.a.h.a(this.tuY.query, false, c.this.txf);
      Object localObject1 = com.tencent.mm.plugin.fts.a.a.h.bn(this.tuY.tvd, true);
      HashMap localHashMap = new HashMap();
      Object localObject2 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, this.tuY.talker, com.tencent.mm.plugin.fts.a.c.tsV, com.tencent.mm.plugin.fts.a.c.tsZ);
      do
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break;
        }
        localObject3 = new com.tencent.mm.plugin.fts.a.a.n();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).tuh = ((Cursor)localObject2).getString(0);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).type = ((Cursor)localObject2).getInt(1);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).tug = ((Cursor)localObject2).getInt(2);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject3).tun = ((com.tencent.mm.plugin.fts.a.a.h)localObject1);
        if (!localHashMap.containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject3).tuh)) {
          localHashMap.put(((com.tencent.mm.plugin.fts.a.a.m)localObject3).tuh, localObject3);
        }
      } while (localHashMap.size() <= 100);
      ((Cursor)localObject2).close();
      akv("findHitContact");
      localObject2 = c.this.txa.a(paramk.tun, this.tuY.tvc, localHashMap.keySet());
      Object localObject3 = new HashMap();
      if (((Cursor)localObject2).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().g((Cursor)localObject2);
        localn.tun = paramk.tun;
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
      paramk.tvl = new ArrayList();
      localObject1 = ((HashMap)localObject3).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = (com.tencent.mm.plugin.fts.a.a.m)localHashMap.get(((Map.Entry)localObject2).getKey());
        if (localObject3 != null)
        {
          Collections.sort((List)((Map.Entry)localObject2).getValue(), this.tuY.tvi);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject3).userData = ((Map.Entry)localObject2).getValue();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject3).timestamp = ((com.tencent.mm.plugin.fts.a.a.m)((List)((Map.Entry)localObject2).getValue()).get(0)).timestamp;
          paramk.tvl.add(localObject3);
        }
      }
      Collections.sort(paramk.tvl, this.tuY.tvi);
      akv("findHitMessage");
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
      akv("start");
      paramk.tun = com.tencent.mm.plugin.fts.a.a.h.a(this.tuY.query, false, c.this.txf);
      Object localObject1 = c.this.txa;
      Object localObject3 = paramk.tun;
      Object localObject2 = this.tuY.tvc;
      localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).cSL();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cSG(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cSG(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cSG(), localObject3 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tsD.rawQuery((String)localObject3, new String[] { localObject2 });
      paramk.tvl = new ArrayList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new com.tencent.mm.plugin.fts.a.a.n().g((Cursor)localObject1);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject2).userData = Integer.valueOf(1);
        paramk.tvl.add(localObject2);
      }
      ((Cursor)localObject1).close();
      akv("findConversationMessage");
      if ((paramk.tun.tuO.length > 1) && (!this.tuY.tvh.contains("create_talker_message​")))
      {
        localObject1 = com.tencent.mm.plugin.fts.a.a.h.bn(paramk.tun.tuO[0], true);
        localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.tsV, com.tencent.mm.plugin.fts.a.c.tsZ);
        if (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tuh = "create_talker_message​";
          paramk.tvl.add(0, localObject2);
        }
        ((Cursor)localObject1).close();
        akv("findTalkerConversation");
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
      akv("start");
      paramk.tun = com.tencent.mm.plugin.fts.a.a.h.a(this.tuY.query, false, c.this.txf);
      Object localObject1 = c.this.txa;
      Object localObject2 = paramk.tun.cSL();
      localObject2 = String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cSG(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cSF(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cSG(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cSG(), localObject2 });
      localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tsD.rawQuery((String)localObject2, null);
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
          locala.tug = ((Cursor)localObject2).getInt(1);
          locala.tvo = ((Cursor)localObject2).getLong(2);
          locala.tuh = ((Cursor)localObject2).getString(3);
          locala.timestamp = ((Cursor)localObject2).getLong(4);
          ((List)localObject1).add(locala);
          ((List)localObject4).add(str);
        }
      } while (((List)localObject1).size() <= this.tuY.tvg);
      ((Cursor)localObject2).close();
      paramk.tvl = new LinkedList();
      akv("findUsername");
      if (((List)localObject4).size() > 0)
      {
        localObject3 = c.this.txa.a(paramk.tun, (List)localObject4);
        localObject2 = new HashMap();
        if (((Cursor)localObject3).moveToNext())
        {
          localObject4 = ((Cursor)localObject3).getString(0).split(" ");
          i = 0;
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
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).tug = ((a)localObject3).tug;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).tvo = ((a)localObject3).tvo;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).tuh = ((a)localObject3).tuh;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject4).timestamp = ((a)localObject3).timestamp;
          if (!((HashMap)localObject2).containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject4).tuh)) {
            break label699;
          }
        }
      }
      label699:
      for (int i = ((Integer)((HashMap)localObject2).get(((com.tencent.mm.plugin.fts.a.a.m)localObject4).tuh)).intValue();; i = 1)
      {
        if (w.Am(((com.tencent.mm.plugin.fts.a.a.m)localObject4).tuh)) {
          i = 0;
        }
        ((com.tencent.mm.plugin.fts.a.a.m)localObject4).userData = Integer.valueOf(i);
        paramk.tvl.add(localObject4);
        break;
        akv("findCount");
        if ((paramk.tun.tuO.length > 1) && (paramk.tvl.size() <= 3))
        {
          localObject1 = com.tencent.mm.plugin.fts.a.a.h.bn(paramk.tun.tuO[0], true);
          localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.tsV, com.tencent.mm.plugin.fts.a.c.tsZ);
          if (((Cursor)localObject1).moveToNext())
          {
            localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
            ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tuh = "create_talker_message​";
            paramk.tvl.add(localObject2);
          }
          ((Cursor)localObject1).close();
          akv("findTalkerConversation");
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
      int tug;
      String tuh;
      long tvo;
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
      akv("start");
      paramk.tun = com.tencent.mm.plugin.fts.a.a.h.a(this.tuY.query, false, c.this.txf);
      Object localObject1 = com.tencent.mm.plugin.fts.a.a.h.bn(this.tuY.tvd, true);
      Object localObject2 = new HashMap();
      Object localObject3 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.tsV, com.tencent.mm.plugin.fts.a.c.tsZ);
      do
      {
        if (!((Cursor)localObject3).moveToNext()) {
          break;
        }
        localObject4 = new com.tencent.mm.plugin.fts.a.a.n();
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).tuh = ((Cursor)localObject3).getString(0);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).type = ((Cursor)localObject3).getInt(1);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).tug = ((Cursor)localObject3).getInt(2);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).tun = ((com.tencent.mm.plugin.fts.a.a.h)localObject1);
        ((com.tencent.mm.plugin.fts.a.a.n)localObject4).userData = Integer.valueOf(1);
        if (!((HashMap)localObject2).containsKey(((com.tencent.mm.plugin.fts.a.a.n)localObject4).tuh)) {
          ((HashMap)localObject2).put(((com.tencent.mm.plugin.fts.a.a.n)localObject4).tuh, localObject4);
        }
      } while (((HashMap)localObject2).size() <= 100);
      ((Cursor)localObject3).close();
      akv("findHitContact");
      Object localObject4 = c.this.txa.a(paramk.tun, null, ((HashMap)localObject2).keySet());
      localObject3 = new HashMap();
      if (((Cursor)localObject4).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().g((Cursor)localObject4);
        localn.tun = paramk.tun;
        localn.userData = Integer.valueOf(1);
        label306:
        com.tencent.mm.plugin.fts.a.a.m localm;
        int i;
        if (((HashMap)localObject3).containsKey(localn.talker))
        {
          localObject1 = (HashMap)((HashMap)localObject3).get(localn.talker);
          if (!((HashMap)localObject1).containsKey(localn.tuh)) {
            break label431;
          }
          localm = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject1).get(localn.tuh);
          i = ((Integer)localm.userData).intValue() + 1;
          if (localm.timestamp >= localn.timestamp) {
            break label407;
          }
          localn.userData = Integer.valueOf(i);
          ((HashMap)localObject1).put(localn.tuh, localn);
        }
        for (;;)
        {
          ((HashMap)localObject3).put(localn.talker, localObject1);
          break;
          localObject1 = new HashMap();
          break label306;
          label407:
          localm.userData = Integer.valueOf(i);
          ((HashMap)localObject1).put(localm.tuh, localm);
          continue;
          label431:
          ((HashMap)localObject1).put(localn.tuh, localn);
        }
      }
      ((Cursor)localObject4).close();
      paramk.tvl = new ArrayList();
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.m)((Iterator)localObject1).next();
        if (((HashMap)localObject3).containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject2).tuh))
        {
          localObject4 = new ArrayList();
          ((List)localObject4).addAll(((HashMap)((HashMap)localObject3).get(((com.tencent.mm.plugin.fts.a.a.m)localObject2).tuh)).values());
          Collections.sort((List)localObject4, this.tuY.tvi);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).userData = localObject4;
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).timestamp = ((com.tencent.mm.plugin.fts.a.a.m)((List)localObject4).get(0)).timestamp;
          paramk.tvl.add(localObject2);
        }
      }
      Collections.sort(paramk.tvl, this.tuY.tvi);
      akv("findHitMessage");
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
    private int txt = 0;
    private int txu = 0;
    
    public i(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52733);
      akv("start");
      paramk.tun = com.tencent.mm.plugin.fts.a.a.h.a(this.tuY.query, false, c.this.txf);
      Object localObject2 = c.this.txa;
      Object localObject1 = paramk.tun;
      int i = this.tuY.tvg;
      String str = ((com.tencent.mm.plugin.fts.a.a.h)localObject1).cSL();
      if (i != 2147483647) {}
      for (localObject1 = " LIMIT " + (i + 1);; localObject1 = "")
      {
        localObject1 = String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (String)localObject1 + ";", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject2).cSF(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cSG(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cSF(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cSG(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cSG(), str });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).tsD.rawQuery((String)localObject1, null);
        paramk.tvl = new LinkedList();
        while (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).type = ((Cursor)localObject1).getInt(0);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tug = ((Cursor)localObject1).getInt(1);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tvo = ((Cursor)localObject1).getLong(2);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tuh = ((Cursor)localObject1).getString(3);
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).timestamp = ((Cursor)localObject1).getLong(4);
          int j = ((Cursor)localObject1).getInt(5);
          i = j;
          if (j == 1)
          {
            i = j;
            if (w.Am(((com.tencent.mm.plugin.fts.a.a.m)localObject2).tuh)) {
              i = 0;
            }
          }
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).userData = Integer.valueOf(i);
          paramk.tvl.add(localObject2);
          i = this.txt;
          this.txt = (((Integer)((com.tencent.mm.plugin.fts.a.a.m)localObject2).userData).intValue() + i);
          this.txu += 1;
        }
      }
      ((Cursor)localObject1).close();
      akv("groupMessage");
      if (paramk.tun.tuO.length > 1)
      {
        localObject1 = com.tencent.mm.plugin.fts.a.a.h.bn(paramk.tun.tuO[0], true);
        localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.tsV, com.tencent.mm.plugin.fts.a.c.tsZ);
        if (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new com.tencent.mm.plugin.fts.a.a.m();
          ((com.tencent.mm.plugin.fts.a.a.m)localObject2).tuh = "create_talker_message​";
          paramk.tvl.add(0, localObject2);
        }
        ((Cursor)localObject1).close();
        akv("findTalkerConversation");
      }
      AppMethodBeat.o(52733);
    }
    
    public final String bgU()
    {
      AppMethodBeat.i(52734);
      String str = String.format("{totalMsgCount: %d conversationCount: %d}", new Object[] { Integer.valueOf(this.txt), Integer.valueOf(this.txu) });
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