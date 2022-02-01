package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.a;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.g.l;
import com.tencent.mm.plugin.backup.g.l.a;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMConditionVariable;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import junit.framework.Assert;

public final class c
{
  public boolean uWQ = false;
  b.b uWR;
  com.tencent.mm.plugin.backup.b.d uWS;
  long uWT = 0L;
  public long uWU = 0L;
  private int uWc;
  
  public c(com.tencent.mm.plugin.backup.b.d paramd, int paramInt, b.b paramb)
  {
    this.uWS = paramd;
    this.uWc = paramInt;
    this.uWR = paramb;
    this.uWQ = false;
  }
  
  public final void a(final LinkedList<f.a> paramLinkedList, final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(21254);
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      Log.i("MicroMsg.BackupPackAndSend", "startBackup, backupSessionList size[%d], bigFileSize[%d], isOnlyText[%b]", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
      paramLinkedList = new com.tencent.threadpool.i.h()
      {
        public final String getKey()
        {
          return "backupPackThread";
        }
        
        public final void run()
        {
          AppMethodBeat.i(21232);
          if (paramLinkedList == null)
          {
            Log.e("MicroMsg.BackupPackAndSend", "backupChatRunnable backupSessionList is null.");
            if (c.this.uWR != null)
            {
              c.this.uWR.cUG();
              c.this.uWS.cUJ().uWg = -21;
              c.this.uWR.Fc(-21);
            }
            AppMethodBeat.o(21232);
            return;
          }
          com.tencent.mm.plugin.backup.g.b.cWq();
          Object localObject2 = paramLinkedList;
          Object localObject1 = new HashSet();
          if (localObject2 == null) {}
          for (int i = 0;; i = ((HashSet)localObject1).size())
          {
            c.this.uWS.cUJ().ak(14, 1, i);
            c.this.uWR.Fc(14);
            localObject1 = (String)com.tencent.mm.plugin.backup.h.d.cWK().cWL().ban().d(2, null);
            c.this.uWU = Util.nowMilliSecond();
            localObject2 = new c.c(c.this);
            Iterator localIterator = paramLinkedList.iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              f.a locala = (f.a)localIterator.next();
              c.this.a(locala, (c.c)localObject2, (String)localObject1, paramLong, this.uWX);
            } while (!c.this.uWQ);
            if (!c.this.uWQ) {
              break;
            }
            Log.e("MicroMsg.BackupPackAndSend", "backupChatRunnable cancel!");
            AppMethodBeat.o(21232);
            return;
            localObject2 = ((LinkedList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((HashSet)localObject1).add(((f.a)((Iterator)localObject2).next()).uWs);
            }
          }
          Log.i("MicroMsg.BackupPackAndSend", "backupChatRunnable send finish now, wait finish.");
          long l1 = Util.nowMilliSecond();
          long l2 = Util.nowMilliSecond();
          Log.i("MicroMsg.BackupPackAndSend.TagQueueSucker", "start waitFinish Now:%d", new Object[] { Long.valueOf(l2) });
          ((c.c)localObject2).uXx.offer(((c.c)localObject2).uXy);
          ((c.c)localObject2).uXy.block();
          Log.i("MicroMsg.BackupPackAndSend.TagQueueSucker", "waitFinish Finish Now:%d", new Object[] { Long.valueOf(Util.milliSecondsToNow(l2)) });
          Assert.assertTrue(((c.c)localObject2).uXx.isEmpty());
          Log.i("MicroMsg.BackupPackAndSend", "backupChatRunnable finish, Session[%d], loopTime[%d], waitSendTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(Util.milliSecondsToNow(c.this.uWU)), Long.valueOf(Util.milliSecondsToNow(l1)) });
          c.this.cVc();
          c.this.uWS.cUJ().ak(15, i, i);
          c.this.uWR.Fc(15);
          c.this.lW(true);
          com.tencent.mm.plugin.backup.g.b.cWp();
          com.tencent.mm.plugin.backup.g.b.cWr();
          c.this.uWR.cUF();
          Log.i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupfinish, backupDataSize[%d], backupCostTime[%d], backupStartTime[%d]", new Object[] { Long.valueOf(c.this.uWT), Long.valueOf(Util.milliSecondsToNow(c.this.uWU)), Long.valueOf(c.this.uWU) });
          AppMethodBeat.o(21232);
        }
      };
      com.tencent.threadpool.h.ahAA.bp(paramLinkedList);
      AppMethodBeat.o(21254);
      return;
    }
  }
  
  final boolean a(f.a parama, c paramc, String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(21255);
    Object localObject1 = com.tencent.mm.plugin.backup.h.d.cWK().cWL().bzG().bxM(parama.uWs);
    int i;
    long l5;
    int k;
    long l1;
    long l2;
    int j;
    if (localObject1 != null)
    {
      i = ((bd)localObject1).field_unReadCount;
      Log.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg index[%d], sessionName[%s], startTime[%d], endTime[%d], unReadCount[%d]", new Object[] { Integer.valueOf(parama.uWt), parama.uWs, Long.valueOf(parama.startTime), Long.valueOf(parama.endTime), Integer.valueOf(i) });
      l5 = Util.nowMilliSecond();
      k = 0;
      l1 = 0L;
      l2 = 0L;
      l3 = 0L;
      j = i;
      i = k;
    }
    long l4;
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      l4 = Util.nowMilliSecond();
      Object localObject2 = com.tencent.mm.plugin.backup.h.d.cWK().cWL().bzD().c(parama.uWs, parama.startTime, parama.endTime, i);
      Object localObject3;
      for (;;)
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break label334;
        }
        k = i + 1;
        if (this.uWQ)
        {
          Log.e("MicroMsg.BackupPackAndSend", "backupPackSessionMsg add msgInfoLinkedList is CANCELED!");
          ((Cursor)localObject2).close();
          AppMethodBeat.o(21255);
          return false;
          i = 0;
          break;
        }
        localObject3 = new cc();
        ((cc)localObject3).convertFrom((Cursor)localObject2);
        if (paramBoolean)
        {
          i = k;
          if (((cc)localObject3).getType() != 1) {}
        }
        else
        {
          if (((cc)localObject3).getType() == 922746929)
          {
            localObject1 = ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).tb(((fi)localObject3).field_msgId);
            if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {}
          }
          for (;;)
          {
            if (localObject1 != null) {
              break label319;
            }
            localLinkedList.add(localObject3);
            i = k;
            break;
            localObject1 = null;
          }
          label319:
          localLinkedList.addAll((Collection)localObject1);
          i = k;
        }
      }
      label334:
      ((Cursor)localObject2).close();
      l4 = l3 - l4 + Util.nowMilliSecond();
      if (localLinkedList.size() == 0) {
        break label776;
      }
      k = 0;
      if (k < localLinkedList.size())
      {
        if (this.uWQ)
        {
          Log.e("MicroMsg.BackupPackAndSend", "backupPackSessionMsg packMsg is CANCELED!");
          AppMethodBeat.o(21255);
          return false;
        }
        Object localObject4 = (cc)localLinkedList.get(k);
        PLong localPLong = new PLong();
        localObject3 = new LinkedList();
        HashMap localHashMap = new HashMap();
        l3 = l2;
        for (;;)
        {
          for (;;)
          {
            boolean bool;
            try
            {
              l2 -= Util.nowMilliSecond();
              if (j > 0)
              {
                bool = true;
                l3 = l2;
                localObject1 = com.tencent.mm.plugin.backup.f.h.a((cc)localObject4, false, paramString, localPLong, (LinkedList)localObject3, localHashMap, bool, false, paramLong);
              }
            }
            catch (Exception localException1)
            {
              int m;
              localObject1 = null;
              l2 = l3;
            }
            try
            {
              l3 = Util.nowMilliSecond();
              l2 = l3 + l2;
              if (localObject1 != null) {
                break label763;
              }
              bool = true;
              Log.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((LinkedList)localObject3).size()), Long.valueOf(localPLong.value), Integer.valueOf(localHashMap.size()), Long.valueOf(((fi)localObject4).field_msgSvrId), Integer.valueOf(((cc)localObject4).getType()), Long.valueOf(((cc)localObject4).getCreateTime()), ((fi)localObject4).field_talker });
              l3 = l1;
              m = j;
              if (localObject1 != null)
              {
                m = j - 1;
                l3 = Util.nowMilliSecond();
                long l6 = localPLong.value;
                long l7 = ((cc)localObject4).getCreateTime();
                if (paramc.uXz == null)
                {
                  localObject2 = paramc.uXx;
                  localObject4 = new b(paramc.uWY, paramc.uXd, parama);
                  paramc.uXz = ((b)localObject4);
                  ((LinkedBlockingQueue)localObject2).offer(localObject4);
                }
                if (paramc.uXz.a((jd)localObject1, l6, l7, (LinkedList)localObject3, localHashMap)) {
                  paramc.uXz = null;
                }
                l3 = l1 - l3 + Util.nowMilliSecond();
              }
              k += 1;
              l1 = l3;
              j = m;
            }
            catch (Exception localException2)
            {
              label746:
              label763:
              break label746;
            }
          }
          bool = false;
          continue;
          Log.printErrStackTrace("MicroMsg.BackupPackAndSend", localException1, "backupPackSessionMsg packedMsg", new Object[0]);
          continue;
          bool = false;
        }
      }
      l3 = l4;
    }
    label776:
    paramLong = Util.nowMilliSecond();
    if (paramc.uXz == null)
    {
      paramString = paramc.uXx;
      localObject1 = new b(paramc.uWY, paramc.uXd, parama);
      paramc.uXz = ((b)localObject1);
      paramString.offer(localObject1);
    }
    paramc.uXz.cVd();
    paramc.uXz = null;
    long l3 = Util.nowMilliSecond();
    Log.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg finish Cursor Session[%d], convName[%s], msgCnt[%d], time[%d], [%d,%d,%d]", new Object[] { Integer.valueOf(parama.uWt), parama.uWs, Integer.valueOf(i), Long.valueOf(Util.milliSecondsToNow(l5)), Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l1 - paramLong + l3) });
    AppMethodBeat.o(21255);
    return true;
  }
  
  public final long cVb()
  {
    return this.uWT / 1024L;
  }
  
  public final void cVc()
  {
    AppMethodBeat.i(21253);
    Log.i("MicroMsg.BackupPackAndSend", "backupSendFinishRequest.");
    com.tencent.mm.plugin.backup.i.d locald = new com.tencent.mm.plugin.backup.i.d();
    locald.vgy = this.uWS.uVY;
    try
    {
      com.tencent.mm.plugin.backup.g.b.N(locald.toByteArray(), 8);
      AppMethodBeat.o(21253);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupPackAndSend", localException, "BackupFinishRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21253);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21251);
    Log.e("MicroMsg.BackupPackAndSend", "cancel, caller:%s", new Object[] { MMStack.getCaller() });
    this.uWQ = true;
    AppMethodBeat.o(21251);
  }
  
  public final void lW(boolean paramBoolean)
  {
    AppMethodBeat.i(21252);
    Log.i("MicroMsg.BackupPackAndSend", "clearContinueBackupData.");
    SharedPreferences.Editor localEditor;
    if (this.uWc == 1)
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acOX, Boolean.FALSE);
      localEditor = com.tencent.mm.plugin.backup.b.d.cUO().edit();
      localEditor.putString("BACKUP_PC_CHOOSE_SESSION", null);
      if (paramBoolean)
      {
        if (this.uWc != 1) {
          break label155;
        }
        localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
        localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
        localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
        localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
      }
    }
    for (;;)
    {
      localEditor.commit();
      AppMethodBeat.o(21252);
      return;
      if (this.uWc != 2) {
        break;
      }
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acPa, Boolean.FALSE);
      break;
      label155:
      if (this.uWc == 2)
      {
        localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
        localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
        localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
        localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
      }
    }
  }
  
  final class a
  {
    volatile AtomicLong uWZ;
    MMConditionVariable uXa;
    MMConditionVariable uXb;
    
    private a()
    {
      AppMethodBeat.i(21233);
      this.uWZ = new AtomicLong(0L);
      this.uXa = new MMConditionVariable(true);
      this.uXb = new MMConditionVariable(true);
      AppMethodBeat.o(21233);
    }
  }
  
  final class b
  {
    String TAG;
    String nickName;
    boolean rej;
    String talker;
    int uWt;
    long uWv;
    long uWw;
    LinkedBlockingQueue<Runnable> uXc;
    c.a uXd;
    private long uXe;
    String uXf;
    Vector<String> uXg;
    private Vector<jd> uXh;
    HashMap<Long, h.a> uXi;
    long uXj;
    private final com.tencent.mm.plugin.backup.g.c.b uXk;
    private final Runnable uXl;
    final Runnable uXm;
    
    public b(c.a parama, f.a parama1)
    {
      AppMethodBeat.i(21245);
      this.TAG = "";
      this.uXc = new LinkedBlockingQueue();
      this.uWv = 0L;
      this.uWw = 0L;
      this.uXe = 0L;
      this.uXf = "";
      this.uXg = new Vector();
      this.uXh = new Vector();
      this.uXi = new HashMap();
      this.uXj = 0L;
      this.rej = false;
      this.uXk = new com.tencent.mm.plugin.backup.g.c.b()
      {
        public final void f(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(21234);
          Object localObject = c.b.this.uXd;
          long l1 = paramAnonymousInt;
          ((c.a)localObject).uWZ.addAndGet(0L - l1);
          if (((c.a)localObject).uWZ.get() < 8388608L) {
            ((c.a)localObject).uXa.open();
          }
          if (((c.a)localObject).uWZ.get() < 16777216L) {
            ((c.a)localObject).uXb.open();
          }
          long l2 = ((c.a)localObject).uWZ.get();
          boolean bool1;
          if (((c.a)localObject).uWZ.get() >= 8388608L)
          {
            bool1 = true;
            if (((c.a)localObject).uWZ.get() < 16777216L) {
              break label265;
            }
          }
          label265:
          for (boolean bool2 = true;; bool2 = false)
          {
            Log.v("MicroMsg.BackupPackAndSend", "MemoryChecker.release size:%d sum:%d [%b,%b] [%b,%b]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(((c.a)localObject).uXa.isOpen()), Boolean.valueOf(((c.a)localObject).uXb.isOpen()) });
            localObject = c.this;
            ((c)localObject).uWT = (paramAnonymousInt + ((c)localObject).uWT);
            Log.i(c.b.this.TAG, "OnfinishIdCallback size[%d], isIdFinish[%b], id[%s] ", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
            AppMethodBeat.o(21234);
            return;
            bool1 = false;
            break;
          }
        }
      };
      this.uXl = new Runnable()
      {
        public final void run()
        {
          boolean bool = true;
          AppMethodBeat.i(21241);
          Assert.assertTrue(toString() + ", check running. ", c.b.this.rej);
          Log.i(c.b.this.TAG, "requestBigFileList svrIdCnt:%d timeDiff:%d caller:%s", new Object[] { Integer.valueOf(c.b.this.uXi.size()), Long.valueOf(Util.milliSecondsToNow(c.b.this.uXj)), MMStack.getCaller() });
          if (!c.b.this.uXi.isEmpty()) {}
          for (;;)
          {
            Assert.assertTrue("BigFileMap should not Empty", bool);
            l.a local1 = new l.a()
            {
              public final void I(final LinkedList<Long> paramAnonymous2LinkedList)
              {
                AppMethodBeat.i(21239);
                com.tencent.threadpool.h.ahAA.bp(new com.tencent.threadpool.i.h()
                {
                  public final String getKey()
                  {
                    return "AddBigFileToQueue";
                  }
                  
                  public final void run()
                  {
                    AppMethodBeat.i(21238);
                    int i = 0;
                    if ((paramAnonymous2LinkedList != null) && (i < paramAnonymous2LinkedList.size()))
                    {
                      Long localLong = (Long)paramAnonymous2LinkedList.get(i);
                      h.a locala = (h.a)c.b.this.uXi.get(localLong);
                      String str3 = c.b.this.TAG;
                      int j = paramAnonymous2LinkedList.size();
                      String str1;
                      if (locala == null)
                      {
                        str1 = "null";
                        label93:
                        if (locala != null) {
                          break label220;
                        }
                      }
                      label220:
                      for (String str2 = "null";; str2 = locala.vaT.path)
                      {
                        Log.i(str3, "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d media:%s item:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localLong, str1, str2 });
                        if (locala != null)
                        {
                          c.b.this.uXg.add(locala.vaT.mediaId);
                          c.b.this.q(locala.vaT.mediaId, locala.vaT.path, true);
                        }
                        i += 1;
                        break;
                        str1 = locala.vaT.mediaId;
                        break label93;
                      }
                    }
                    c.b.this.uXc.offer(c.b.this.uXm);
                    AppMethodBeat.o(21238);
                  }
                });
                AppMethodBeat.o(21239);
              }
            };
            new l(c.b.this.talker, c.b.this.uXi, local1).cWw();
            AppMethodBeat.o(21241);
            return;
            bool = false;
          }
        }
        
        public final String toString()
        {
          AppMethodBeat.i(21240);
          String str = c.b.this.TAG + ".reqBigFile";
          AppMethodBeat.o(21240);
          return str;
        }
      };
      this.uXm = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21244);
          Assert.assertTrue(toString() + ", check running. ", c.b.this.rej);
          final boolean bool1;
          switch (com.tencent.mm.plugin.backup.b.d.cUM())
          {
          default: 
            if (c.b.this.uWt == c.this.uWS.cUJ().uWi - 1)
            {
              bool1 = true;
              label106:
              if (bool1) {
                break label767;
              }
            }
            break;
          }
          label767:
          for (boolean bool2 = true;; bool2 = false)
          {
            Object localObject = new MMConditionVariable(bool2);
            com.tencent.mm.am.h local1 = new com.tencent.mm.am.h()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
              {
                AppMethodBeat.i(21242);
                paramAnonymous2p = ((com.tencent.mm.plugin.backup.i.aa)((com.tencent.mm.plugin.backup.g.d)paramAnonymous2p).vcV).vhW;
                Log.i(c.b.this.TAG, "Send Tag finish last:%b  cv:%s [%d,%d,%s] tag[%s,%s]", new Object[] { Boolean.valueOf(bool1), this.uXv, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, c.b.this.uXf, paramAnonymous2p });
                if ((bool1) && (c.b.this.uXf.equals(paramAnonymous2p))) {
                  this.uXv.open();
                }
                AppMethodBeat.o(21242);
              }
            };
            new com.tencent.mm.plugin.backup.g.d(c.b.this.talker, c.b.this.uWv, c.b.this.uWw, c.b.this.uXf, c.b.this.nickName, new LinkedList(c.b.this.uXg), local1).cWw();
            if (bool1)
            {
              Log.w(c.b.this.TAG, "sendTag last Session :[%d/%d] wait tag resp callback .", new Object[] { Integer.valueOf(c.b.this.uWt), Integer.valueOf(c.this.uWS.cUJ().uWi - 1) });
              ((MMConditionVariable)localObject).block();
            }
            c.b.this.rej = false;
            AppMethodBeat.o(21244);
            return;
            Log.i(c.b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[] { Integer.valueOf(c.this.uWS.cUJ().uWh), Long.valueOf(c.b.this.uWv), Long.valueOf(c.b.this.uWw), Integer.valueOf(c.b.this.uXg.size()), c.b.this.nickName, c.b.this.uXf, Long.valueOf(Util.milliSecondsToNow(c.b.this.uXj)) });
            if (c.this.uWS.cUJ().uWh >= c.b.this.uWt + 1) {
              break;
            }
            int i = c.this.uWS.cUJ().uWi;
            localObject = c.this.uWS.cUJ();
            if (c.b.this.uWt + 1 > i) {}
            for (;;)
            {
              ((e)localObject).uWh = i;
              c.this.uWR.Fc(c.this.uWS.cUJ().uWg);
              break;
              i = c.b.this.uWt + 1;
            }
            Log.i(c.b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[] { Integer.valueOf(c.this.uWS.cUJ().uWh), Long.valueOf(c.b.this.uWv), Long.valueOf(c.b.this.uWw), Integer.valueOf(c.b.this.uXg.size()), c.b.this.nickName, c.b.this.uXf, Long.valueOf(Util.milliSecondsToNow(c.b.this.uXj)) });
            if (c.this.uWS.cUJ().uWh >= c.b.this.uWt + 1) {
              break;
            }
            i = c.this.uWS.cUJ().uWi;
            localObject = c.this.uWS.cUJ();
            if (c.b.this.uWt + 1 > i) {}
            for (;;)
            {
              ((e)localObject).uWh = i;
              c.this.uWR.Fc(c.this.uWS.cUJ().uWg);
              break;
              i = c.b.this.uWt + 1;
            }
            bool1 = false;
            break label106;
          }
        }
        
        public final String toString()
        {
          AppMethodBeat.i(21243);
          String str = c.b.this.TAG + ".sendTag";
          AppMethodBeat.o(21243);
          return str;
        }
      };
      this.uXj = Util.nowMilliSecond();
      this.uXd = parama;
      this.talker = parama1.uWs;
      this.uWt = parama1.uWt;
      if (au.bwE(this.talker))
      {
        this$1 = com.tencent.mm.model.aa.aV(this.talker, this.talker);
        this.nickName = c.this;
        if (Util.isNullOrNil(this.nickName))
        {
          parama = this.TAG;
          if (this.nickName != null) {
            break label353;
          }
          this$1 = "";
          label212:
          Log.e(parama, "TagProcessor nickName is NullOrNil! nickName:%s, talker:%s", new Object[] { c.this, this.talker });
          this.nickName = this.talker;
        }
        parama = new StringBuilder("MicroMsg.BackupPackAndSend.tag.");
        if (!this.rej) {
          break label361;
        }
      }
      label353:
      label361:
      for (this$1 = "S.";; this$1 = "W.")
      {
        this.TAG = (c.this + this.uWt + "." + this.nickName);
        Log.i(this.TAG, "initTagNow [%d,%s,%s] [%s]", new Object[] { Integer.valueOf(this.uWt), this.nickName, this.talker, MMStack.getCaller() });
        AppMethodBeat.o(21245);
        return;
        this$1 = com.tencent.mm.model.aa.getDisplayName(this.talker);
        break;
        this$1 = this.nickName;
        break label212;
      }
    }
    
    public final boolean a(jd paramjd, long paramLong1, long paramLong2, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap)
    {
      AppMethodBeat.i(21246);
      this.uXh.add(paramjd);
      long l2 = this.uXe;
      if (paramLong1 > 0L) {}
      for (long l1 = paramLong1;; l1 = 0L)
      {
        this.uXe = (l1 + l2);
        if (this.uWv == 0L) {
          this.uWv = paramLong2;
        }
        this.uWw = paramLong2;
        this.uXi.putAll(paramHashMap);
        paramjd = paramLinkedList.iterator();
        while (paramjd.hasNext())
        {
          paramHashMap = (u)paramjd.next();
          q(paramHashMap.mediaId, paramHashMap.path, false);
        }
      }
      Log.i(this.TAG, "addToTag msgtime[%d,%d] size[%d,%d] baklist:%d media:%d timeDiff:%d", new Object[] { Long.valueOf(this.uWv), Long.valueOf(this.uWw), Long.valueOf(paramLong1), Long.valueOf(this.uXe), Integer.valueOf(this.uXh.size()), Integer.valueOf(paramLinkedList.size()), Long.valueOf(Util.milliSecondsToNow(this.uXj)) });
      if ((this.uXe > 83886080L) || (this.uXh.size() > 80))
      {
        cVd();
        AppMethodBeat.o(21246);
        return true;
      }
      AppMethodBeat.o(21246);
      return false;
    }
    
    public final void cVd()
    {
      AppMethodBeat.i(21247);
      this.uXf = ("MSG_" + this.uXh.size() + "_" + this.talker + "_" + Util.nowMilliSecond());
      Log.i(this.TAG, "setTagEnd msgtime[%d,%d], size:%d baklist:%d bigfile:%d id:%s timeDiff:%d", new Object[] { Long.valueOf(this.uWv), Long.valueOf(this.uWw), Long.valueOf(this.uXe), Integer.valueOf(this.uXh.size()), Integer.valueOf(this.uXi.size()), this.uXf, Long.valueOf(Util.milliSecondsToNow(this.uXj)) });
      if (this.uXh.size() > 0)
      {
        q(this.uXf, null, false);
        if (this.uXi.isEmpty())
        {
          this.uXc.offer(this.uXm);
          AppMethodBeat.o(21247);
          return;
        }
        this.uXc.offer(this.uXl);
        AppMethodBeat.o(21247);
        return;
      }
      Log.w(this.TAG, "setTagEnd NoFileSend, Go Send Tag: Direct. baklist:%d media:%d bigFileMap:%d ", new Object[] { Integer.valueOf(this.uXh.size()), Integer.valueOf(this.uXg.size()), Integer.valueOf(this.uXi.size()) });
      Assert.assertTrue("cursorEnd NOMsg, chatMsgList should empty", this.uXh.isEmpty());
      Assert.assertTrue("cursorEnd NOMsg, MediaList should empty", this.uXg.isEmpty());
      Assert.assertTrue("cursorEnd NOMsg, BigFileList should empty", this.uXi.isEmpty());
      this.uXc.offer(this.uXm);
      AppMethodBeat.o(21247);
    }
    
    final void q(String paramString1, String paramString2, boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(21248);
      com.tencent.mm.plugin.backup.g.c.c local2 = new com.tencent.mm.plugin.backup.g.c.c()
      {
        public final void a(final com.tencent.mm.plugin.backup.g.c paramAnonymousc)
        {
          AppMethodBeat.i(21237);
          final long l2 = Util.nowMilliSecond();
          c.a locala = c.b.this.uXd;
          long l3 = paramAnonymousc.cWD();
          boolean bool3 = c.b.this.rej;
          long l1 = locala.uWZ.get();
          boolean bool1;
          label81:
          long l4;
          if (locala.uWZ.get() >= 8388608L)
          {
            bool1 = true;
            if (locala.uWZ.get() < 16777216L) {
              break label379;
            }
            bool2 = true;
            Log.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid %b inSize:%d sum:%d  [%b,%b]", new Object[] { Boolean.valueOf(bool3), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if (locala.uWZ.get() + l3 >= 8388608L) {
              locala.uXa.close();
            }
            if (locala.uWZ.get() >= 16777216L) {
              locala.uXb.close();
            }
            l4 = Util.nowMilliSecond();
            if (!locala.uWY.uWQ)
            {
              long l5 = locala.uWZ.get();
              if (!bool3) {
                break label385;
              }
              l1 = 16777216L;
              label215:
              if (l5 >= l1) {
                break label404;
              }
              locala.uWZ.addAndGet(l3);
              l1 = Util.milliSecondsToNow(l4);
              l4 = locala.uWZ.get();
              if (locala.uWZ.get() < 8388608L) {
                break label392;
              }
              bool1 = true;
              label267:
              if (locala.uWZ.get() < 16777216L) {
                break label398;
              }
            }
          }
          label385:
          label392:
          label398:
          for (boolean bool2 = true;; bool2 = false)
          {
            Log.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid Out:%d %b inSize:%d sum:%d  [%b,%b]", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool3), Long.valueOf(l3), Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            c.b.this.uXc.offer(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(21236);
                Assert.assertTrue(toString() + ", check running. ", c.b.this.rej);
                long l1 = Util.nowMilliSecond();
                paramAnonymousc.cWw();
                long l2 = Util.nowMilliSecond();
                Log.i(c.b.this.TAG, "SendFileScene size:%d waitTime:%d netTime:%d [%s]", new Object[] { Integer.valueOf(paramAnonymousc.cWD()), Long.valueOf(l2 - l2), Long.valueOf(l2 - l1), paramAnonymousc.vcM.vhN });
                AppMethodBeat.o(21236);
              }
              
              public final String toString()
              {
                AppMethodBeat.i(21235);
                String str = c.b.this.TAG + ".sendFile";
                AppMethodBeat.o(21235);
                return str;
              }
            });
            AppMethodBeat.o(21237);
            return;
            bool1 = false;
            break;
            label379:
            bool2 = false;
            break label81;
            l1 = 8388608L;
            break label215;
            bool1 = false;
            break label267;
          }
          label404:
          if (bool3) {}
          for (MMConditionVariable localMMConditionVariable = locala.uXb;; localMMConditionVariable = locala.uXa)
          {
            localMMConditionVariable.block(500L);
            break;
          }
        }
      };
      Log.i(this.TAG, "postSendFile isBigFile[%b], baklst:%d Id:%s path:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.uXh.size()), paramString1, paramString2 });
      if (!TextUtils.isEmpty(paramString2))
      {
        this.uXg.add(paramString1);
        if (paramString1 != null)
        {
          com.tencent.mm.plugin.backup.g.c.a(this.uXk, local2, paramString1, paramString2, c.this.uWS.uWe);
          AppMethodBeat.o(21248);
        }
      }
      else
      {
        if (this.uXh.isEmpty()) {
          break label171;
        }
      }
      label171:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        Assert.assertTrue("chatMsgList should not empty", paramBoolean);
        if (paramString1 != null) {
          com.tencent.mm.plugin.backup.g.c.a(this.uXk, local2, paramString1, new LinkedList(this.uXh), c.this.uWS.uWe);
        }
        AppMethodBeat.o(21248);
        return;
      }
    }
    
    public final String toString()
    {
      return this.TAG;
    }
  }
  
  final class c
  {
    private Runnable uXA;
    c.a uXd;
    LinkedBlockingQueue<Object> uXx;
    MMConditionVariable uXy;
    c.b uXz;
    
    public c()
    {
      AppMethodBeat.i(21250);
      this.uXx = new LinkedBlockingQueue();
      this.uXd = new c.a(c.this, (byte)0);
      this.uXy = new MMConditionVariable();
      this.uXz = null;
      this.uXA = new com.tencent.threadpool.i.h()
      {
        public final String getKey()
        {
          return "tagRunnable";
        }
        
        public final void run()
        {
          AppMethodBeat.i(21249);
          while (!c.this.uWQ)
          {
            Object localObject1 = null;
            label273:
            try
            {
              localObject2 = c.c.this.uXx.poll(500L, TimeUnit.MILLISECONDS);
              localObject1 = localObject2;
            }
            catch (Exception localException2)
            {
              Object localObject2;
              label44:
              c.b localb;
              label146:
              label182:
              label221:
              break label44;
            }
            Log.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "TagQueue(%d)startNext obj:%s", new Object[] { Integer.valueOf(c.c.this.uXx.size()), localObject1 });
            if (localObject1 != null)
            {
              if (localObject1 == c.c.this.uXy)
              {
                c.c.this.uXy.open();
                AppMethodBeat.o(21249);
                return;
              }
              localb = (c.b)localObject1;
              localb.rej = true;
              localObject2 = new StringBuilder("MicroMsg.BackupPackAndSend.tag");
              if (localb.rej)
              {
                localObject1 = "S.";
                localb.TAG = ((String)localObject1 + localb.uWt + "." + localb.nickName);
                while (!c.this.uWQ)
                {
                  localObject1 = null;
                  try
                  {
                    localObject2 = (Runnable)localb.uXc.poll(500L, TimeUnit.MILLISECONDS);
                    localObject1 = localObject2;
                  }
                  catch (Exception localException1)
                  {
                    long l1;
                    int k;
                    long l2;
                    int i;
                    int j;
                    break label221;
                  }
                  if (localObject1 != null)
                  {
                    l1 = Util.nowMilliSecond();
                    ((Runnable)localObject1).run();
                    k = localb.uXc.size();
                    l2 = c.c.this.uXd.uWZ.get();
                    if (l2 < 8388608L) {
                      break label389;
                    }
                    i = 1;
                    if (l2 < 16777216L) {
                      break label394;
                    }
                  }
                }
              }
              label389:
              label394:
              for (j = 1;; j = 0)
              {
                Log.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "workerQueue poll q:%d mem:%s rt:%d [%s,%s,%s]", new Object[] { Integer.valueOf(k), String.format("[%s,%s,%s]", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j) }), Long.valueOf(Util.milliSecondsToNow(l1)), localObject1, localb, c.c.this.uXz });
                if (localb.rej) {
                  break label182;
                }
                System.gc();
                break;
                localObject1 = "W.";
                break label146;
                i = 0;
                break label273;
              }
            }
          }
          AppMethodBeat.o(21249);
        }
      };
      com.tencent.threadpool.h.ahAA.bp(this.uXA);
      AppMethodBeat.o(21250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c
 * JD-Core Version:    0.7.0.1
 */