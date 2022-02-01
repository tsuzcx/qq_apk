package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
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
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMConditionVariable;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
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
  private int rKO;
  public boolean rLD = false;
  b.b rLE;
  com.tencent.mm.plugin.backup.b.d rLF;
  long rLG = 0L;
  public long rLH = 0L;
  
  public c(com.tencent.mm.plugin.backup.b.d paramd, int paramInt, b.b paramb)
  {
    this.rLF = paramd;
    this.rKO = paramInt;
    this.rLE = paramb;
    this.rLD = false;
  }
  
  public final void a(final LinkedList<f.a> paramLinkedList, final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(21254);
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      Log.i("MicroMsg.BackupPackAndSend", "startBackup, backupSessionList size[%d], bigFileSize[%d], isOnlyText[%b]", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
      paramLinkedList = new com.tencent.e.i.h()
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
            if (c.this.rLE != null)
            {
              c.this.rLE.crW();
              c.this.rLF.crZ().rKS = -21;
              c.this.rLE.EB(-21);
            }
            AppMethodBeat.o(21232);
            return;
          }
          com.tencent.mm.plugin.backup.g.b.ctG();
          Object localObject2 = paramLinkedList;
          Object localObject1 = new HashSet();
          if (localObject2 == null) {}
          for (int i = 0;; i = ((HashSet)localObject1).size())
          {
            c.this.rLF.crZ().T(14, 1, i);
            c.this.rLE.EB(14);
            localObject1 = (String)com.tencent.mm.plugin.backup.h.d.cua().cub().aHp().b(2, null);
            c.this.rLH = Util.nowMilliSecond();
            localObject2 = new c.c(c.this);
            Iterator localIterator = paramLinkedList.iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              f.a locala = (f.a)localIterator.next();
              c.this.a(locala, (c.c)localObject2, (String)localObject1, paramLong, this.rLK);
            } while (!c.this.rLD);
            if (!c.this.rLD) {
              break;
            }
            Log.e("MicroMsg.BackupPackAndSend", "backupChatRunnable cancel!");
            AppMethodBeat.o(21232);
            return;
            localObject2 = ((LinkedList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((HashSet)localObject1).add(((f.a)((Iterator)localObject2).next()).rLe);
            }
          }
          Log.i("MicroMsg.BackupPackAndSend", "backupChatRunnable send finish now, wait finish.");
          long l1 = Util.nowMilliSecond();
          long l2 = Util.nowMilliSecond();
          Log.i("MicroMsg.BackupPackAndSend.TagQueueSucker", "start waitFinish Now:%d", new Object[] { Long.valueOf(l2) });
          ((c.c)localObject2).rMk.offer(((c.c)localObject2).rMl);
          ((c.c)localObject2).rMl.block();
          Log.i("MicroMsg.BackupPackAndSend.TagQueueSucker", "waitFinish Finish Now:%d", new Object[] { Long.valueOf(Util.milliSecondsToNow(l2)) });
          Assert.assertTrue(((c.c)localObject2).rMk.isEmpty());
          Log.i("MicroMsg.BackupPackAndSend", "backupChatRunnable finish, Session[%d], loopTime[%d], waitSendTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(Util.milliSecondsToNow(c.this.rLH)), Long.valueOf(Util.milliSecondsToNow(l1)) });
          c.this.css();
          c.this.rLF.crZ().T(15, i, i);
          c.this.rLE.EB(15);
          c.this.kJ(true);
          com.tencent.mm.plugin.backup.g.b.ctF();
          com.tencent.mm.plugin.backup.g.b.ctH();
          c.this.rLE.crV();
          Log.i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupfinish, backupDataSize[%d], backupCostTime[%d], backupStartTime[%d]", new Object[] { Long.valueOf(c.this.rLG), Long.valueOf(Util.milliSecondsToNow(c.this.rLH)), Long.valueOf(c.this.rLH) });
          AppMethodBeat.o(21232);
        }
      };
      com.tencent.e.h.ZvG.bh(paramLinkedList);
      AppMethodBeat.o(21254);
      return;
    }
  }
  
  final boolean a(f.a parama, c paramc, String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(21255);
    Object localObject1 = com.tencent.mm.plugin.backup.h.d.cua().cub().bbR().bwx(parama.rLe);
    int i;
    long l5;
    int k;
    long l1;
    long l2;
    int j;
    if (localObject1 != null)
    {
      i = ((bb)localObject1).field_unReadCount;
      Log.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg index[%d], sessionName[%s], startTime[%d], endTime[%d], unReadCount[%d]", new Object[] { Integer.valueOf(parama.rLf), parama.rLe, Long.valueOf(parama.startTime), Long.valueOf(parama.endTime), Integer.valueOf(i) });
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
      Object localObject2 = com.tencent.mm.plugin.backup.h.d.cua().cub().bbO().c(parama.rLe, parama.startTime, parama.endTime, i);
      Object localObject3;
      for (;;)
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break label334;
        }
        k = i + 1;
        if (this.rLD)
        {
          Log.e("MicroMsg.BackupPackAndSend", "backupPackSessionMsg add msgInfoLinkedList is CANCELED!");
          ((Cursor)localObject2).close();
          AppMethodBeat.o(21255);
          return false;
          i = 0;
          break;
        }
        localObject3 = new ca();
        ((ca)localObject3).convertFrom((Cursor)localObject2);
        if (paramBoolean)
        {
          i = k;
          if (((ca)localObject3).getType() != 1) {}
        }
        else
        {
          if (((ca)localObject3).getType() == 922746929)
          {
            localObject1 = ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.patmsg.a.b.class)).OY(((et)localObject3).field_msgId);
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
        if (this.rLD)
        {
          Log.e("MicroMsg.BackupPackAndSend", "backupPackSessionMsg packMsg is CANCELED!");
          AppMethodBeat.o(21255);
          return false;
        }
        Object localObject4 = (ca)localLinkedList.get(k);
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
                localObject1 = com.tencent.mm.plugin.backup.f.h.a((ca)localObject4, false, paramString, localPLong, (LinkedList)localObject3, localHashMap, bool, false, paramLong);
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
              Log.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((LinkedList)localObject3).size()), Long.valueOf(localPLong.value), Integer.valueOf(localHashMap.size()), Long.valueOf(((et)localObject4).field_msgSvrId), Integer.valueOf(((ca)localObject4).getType()), Long.valueOf(((et)localObject4).field_createTime), ((et)localObject4).field_talker });
              l3 = l1;
              m = j;
              if (localObject1 != null)
              {
                m = j - 1;
                l3 = Util.nowMilliSecond();
                long l6 = localPLong.value;
                long l7 = ((et)localObject4).field_createTime;
                if (paramc.rMm == null)
                {
                  localObject2 = paramc.rMk;
                  localObject4 = new b(paramc.rLL, paramc.rLQ, parama);
                  paramc.rMm = ((b)localObject4);
                  ((LinkedBlockingQueue)localObject2).offer(localObject4);
                }
                if (paramc.rMm.a((ih)localObject1, l6, l7, (LinkedList)localObject3, localHashMap)) {
                  paramc.rMm = null;
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
    if (paramc.rMm == null)
    {
      paramString = paramc.rMk;
      localObject1 = new b(paramc.rLL, paramc.rLQ, parama);
      paramc.rMm = ((b)localObject1);
      paramString.offer(localObject1);
    }
    paramc.rMm.cst();
    paramc.rMm = null;
    long l3 = Util.nowMilliSecond();
    Log.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg finish Cursor Session[%d], convName[%s], msgCnt[%d], time[%d], [%d,%d,%d]", new Object[] { Integer.valueOf(parama.rLf), parama.rLe, Integer.valueOf(i), Long.valueOf(Util.milliSecondsToNow(l5)), Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l1 - paramLong + l3) });
    AppMethodBeat.o(21255);
    return true;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21251);
    Log.e("MicroMsg.BackupPackAndSend", "cancel, caller:%s", new Object[] { MMStack.getCaller() });
    this.rLD = true;
    AppMethodBeat.o(21251);
  }
  
  public final long csr()
  {
    return this.rLG / 1024L;
  }
  
  public final void css()
  {
    AppMethodBeat.i(21253);
    Log.i("MicroMsg.BackupPackAndSend", "backupSendFinishRequest.");
    com.tencent.mm.plugin.backup.i.d locald = new com.tencent.mm.plugin.backup.i.d();
    locald.ID = this.rLF.rKK;
    try
    {
      com.tencent.mm.plugin.backup.g.b.O(locald.toByteArray(), 8);
      AppMethodBeat.o(21253);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupPackAndSend", localException, "BackupFinishRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21253);
    }
  }
  
  public final void kJ(boolean paramBoolean)
  {
    AppMethodBeat.i(21252);
    Log.i("MicroMsg.BackupPackAndSend", "clearContinueBackupData.");
    SharedPreferences.Editor localEditor;
    if (this.rKO == 1)
    {
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.VnC, Boolean.FALSE);
      localEditor = com.tencent.mm.plugin.backup.b.d.cse().edit();
      localEditor.putString("BACKUP_PC_CHOOSE_SESSION", null);
      if (paramBoolean)
      {
        if (this.rKO != 1) {
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
      if (this.rKO != 2) {
        break;
      }
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.VnF, Boolean.FALSE);
      break;
      label155:
      if (this.rKO == 2)
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
    volatile AtomicLong rLM;
    MMConditionVariable rLN;
    MMConditionVariable rLO;
    
    private a()
    {
      AppMethodBeat.i(21233);
      this.rLM = new AtomicLong(0L);
      this.rLN = new MMConditionVariable(true);
      this.rLO = new MMConditionVariable(true);
      AppMethodBeat.o(21233);
    }
  }
  
  final class b
  {
    String TAG;
    String nickName;
    boolean odr;
    LinkedBlockingQueue<Runnable> rLP;
    c.a rLQ;
    private long rLR;
    String rLS;
    Vector<String> rLT;
    private Vector<ih> rLU;
    HashMap<Long, h.a> rLV;
    long rLW;
    private final com.tencent.mm.plugin.backup.g.c.b rLX;
    private final Runnable rLY;
    final Runnable rLZ;
    int rLf;
    long rLh;
    long rLi;
    String talker;
    
    public b(c.a parama, f.a parama1)
    {
      AppMethodBeat.i(21245);
      this.TAG = "";
      this.rLP = new LinkedBlockingQueue();
      this.rLh = 0L;
      this.rLi = 0L;
      this.rLR = 0L;
      this.rLS = "";
      this.rLT = new Vector();
      this.rLU = new Vector();
      this.rLV = new HashMap();
      this.rLW = 0L;
      this.odr = false;
      this.rLX = new com.tencent.mm.plugin.backup.g.c.b()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(21234);
          c.a locala = c.b.this.rLQ;
          long l1 = paramAnonymousInt;
          locala.rLM.addAndGet(0L - l1);
          if (locala.rLM.get() < 8388608L) {
            locala.rLN.open();
          }
          if (locala.rLM.get() < 16777216L) {
            locala.rLO.open();
          }
          long l2 = locala.rLM.get();
          boolean bool1;
          if (locala.rLM.get() >= 8388608L)
          {
            bool1 = true;
            if (locala.rLM.get() < 16777216L) {
              break label266;
            }
          }
          label266:
          for (boolean bool2 = true;; bool2 = false)
          {
            Log.v("MicroMsg.BackupPackAndSend", "MemoryChecker.release size:%d sum:%d [%b,%b] [%b,%b]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(locala.rLN.isOpen()), Boolean.valueOf(locala.rLO.isOpen()) });
            c.this.rLG += paramAnonymousInt;
            Log.i(c.b.this.TAG, "OnfinishIdCallback size[%d], isIdFinish[%b], id[%s] ", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
            AppMethodBeat.o(21234);
            return;
            bool1 = false;
            break;
          }
        }
      };
      this.rLY = new Runnable()
      {
        public final void run()
        {
          boolean bool = true;
          AppMethodBeat.i(21241);
          Assert.assertTrue(toString() + ", check running. ", c.b.this.odr);
          Log.i(c.b.this.TAG, "requestBigFileList svrIdCnt:%d timeDiff:%d caller:%s", new Object[] { Integer.valueOf(c.b.this.rLV.size()), Long.valueOf(Util.milliSecondsToNow(c.b.this.rLW)), MMStack.getCaller() });
          if (!c.b.this.rLV.isEmpty()) {}
          for (;;)
          {
            Assert.assertTrue("BigFileMap should not Empty", bool);
            l.a local1 = new l.a()
            {
              public final void F(final LinkedList<Long> paramAnonymous2LinkedList)
              {
                AppMethodBeat.i(21239);
                com.tencent.e.h.ZvG.bh(new com.tencent.e.i.h()
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
                      h.a locala = (h.a)c.b.this.rLV.get(localLong);
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
                      for (String str2 = "null";; str2 = locala.rPE.path)
                      {
                        Log.i(str3, "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d media:%s item:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localLong, str1, str2 });
                        if (locala != null)
                        {
                          c.b.this.rLT.add(locala.rPE.mediaId);
                          c.b.this.n(locala.rPE.mediaId, locala.rPE.path, true);
                        }
                        i += 1;
                        break;
                        str1 = locala.rPE.mediaId;
                        break label93;
                      }
                    }
                    c.b.this.rLP.offer(c.b.this.rLZ);
                    AppMethodBeat.o(21238);
                  }
                });
                AppMethodBeat.o(21239);
              }
            };
            new l(c.b.this.talker, c.b.this.rLV, local1).ctM();
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
      this.rLZ = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21244);
          Assert.assertTrue(toString() + ", check running. ", c.b.this.odr);
          final boolean bool1;
          switch (com.tencent.mm.plugin.backup.b.d.csc())
          {
          default: 
            if (c.b.this.rLf == c.this.rLF.crZ().rKU - 1)
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
            com.tencent.mm.an.i local1 = new com.tencent.mm.an.i()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
              {
                AppMethodBeat.i(21242);
                paramAnonymous2q = ((com.tencent.mm.plugin.backup.i.aa)((com.tencent.mm.plugin.backup.g.d)paramAnonymous2q).rRF).rWH;
                Log.i(c.b.this.TAG, "Send Tag finish last:%b  cv:%s [%d,%d,%s] tag[%s,%s]", new Object[] { Boolean.valueOf(bool1), this.rMi, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, c.b.this.rLS, paramAnonymous2q });
                if ((bool1) && (c.b.this.rLS.equals(paramAnonymous2q))) {
                  this.rMi.open();
                }
                AppMethodBeat.o(21242);
              }
            };
            new com.tencent.mm.plugin.backup.g.d(c.b.this.talker, c.b.this.rLh, c.b.this.rLi, c.b.this.rLS, c.b.this.nickName, new LinkedList(c.b.this.rLT), local1).ctM();
            if (bool1)
            {
              Log.w(c.b.this.TAG, "sendTag last Session :[%d/%d] wait tag resp callback .", new Object[] { Integer.valueOf(c.b.this.rLf), Integer.valueOf(c.this.rLF.crZ().rKU - 1) });
              ((MMConditionVariable)localObject).block();
            }
            c.b.this.odr = false;
            AppMethodBeat.o(21244);
            return;
            Log.i(c.b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[] { Integer.valueOf(c.this.rLF.crZ().rKT), Long.valueOf(c.b.this.rLh), Long.valueOf(c.b.this.rLi), Integer.valueOf(c.b.this.rLT.size()), c.b.this.nickName, c.b.this.rLS, Long.valueOf(Util.milliSecondsToNow(c.b.this.rLW)) });
            if (c.this.rLF.crZ().rKT >= c.b.this.rLf + 1) {
              break;
            }
            int i = c.this.rLF.crZ().rKU;
            localObject = c.this.rLF.crZ();
            if (c.b.this.rLf + 1 > i) {}
            for (;;)
            {
              ((e)localObject).rKT = i;
              c.this.rLE.EB(c.this.rLF.crZ().rKS);
              break;
              i = c.b.this.rLf + 1;
            }
            Log.i(c.b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[] { Integer.valueOf(c.this.rLF.crZ().rKT), Long.valueOf(c.b.this.rLh), Long.valueOf(c.b.this.rLi), Integer.valueOf(c.b.this.rLT.size()), c.b.this.nickName, c.b.this.rLS, Long.valueOf(Util.milliSecondsToNow(c.b.this.rLW)) });
            if (c.this.rLF.crZ().rKT >= c.b.this.rLf + 1) {
              break;
            }
            i = c.this.rLF.crZ().rKU;
            localObject = c.this.rLF.crZ();
            if (c.b.this.rLf + 1 > i) {}
            for (;;)
            {
              ((e)localObject).rKT = i;
              c.this.rLE.EB(c.this.rLF.crZ().rKS);
              break;
              i = c.b.this.rLf + 1;
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
      this.rLW = Util.nowMilliSecond();
      this.rLQ = parama;
      this.talker = parama1.rLe;
      this.rLf = parama1.rLf;
      if (ab.Lj(this.talker))
      {
        this$1 = com.tencent.mm.model.aa.aL(this.talker, this.talker);
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
        if (!this.odr) {
          break label361;
        }
      }
      label353:
      label361:
      for (this$1 = "S.";; this$1 = "W.")
      {
        this.TAG = (c.this + this.rLf + "." + this.nickName);
        Log.i(this.TAG, "initTagNow [%d,%s,%s] [%s]", new Object[] { Integer.valueOf(this.rLf), this.nickName, this.talker, MMStack.getCaller() });
        AppMethodBeat.o(21245);
        return;
        this$1 = com.tencent.mm.model.aa.PJ(this.talker);
        break;
        this$1 = this.nickName;
        break label212;
      }
    }
    
    public final boolean a(ih paramih, long paramLong1, long paramLong2, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap)
    {
      AppMethodBeat.i(21246);
      this.rLU.add(paramih);
      long l2 = this.rLR;
      if (paramLong1 > 0L) {}
      for (long l1 = paramLong1;; l1 = 0L)
      {
        this.rLR = (l1 + l2);
        if (this.rLh == 0L) {
          this.rLh = paramLong2;
        }
        this.rLi = paramLong2;
        this.rLV.putAll(paramHashMap);
        paramih = paramLinkedList.iterator();
        while (paramih.hasNext())
        {
          paramHashMap = (u)paramih.next();
          n(paramHashMap.mediaId, paramHashMap.path, false);
        }
      }
      Log.i(this.TAG, "addToTag msgtime[%d,%d] size[%d,%d] baklist:%d media:%d timeDiff:%d", new Object[] { Long.valueOf(this.rLh), Long.valueOf(this.rLi), Long.valueOf(paramLong1), Long.valueOf(this.rLR), Integer.valueOf(this.rLU.size()), Integer.valueOf(paramLinkedList.size()), Long.valueOf(Util.milliSecondsToNow(this.rLW)) });
      if ((this.rLR > 83886080L) || (this.rLU.size() > 80))
      {
        cst();
        AppMethodBeat.o(21246);
        return true;
      }
      AppMethodBeat.o(21246);
      return false;
    }
    
    public final void cst()
    {
      AppMethodBeat.i(21247);
      this.rLS = ("MSG_" + this.rLU.size() + "_" + this.talker + "_" + Util.nowMilliSecond());
      Log.i(this.TAG, "setTagEnd msgtime[%d,%d], size:%d baklist:%d bigfile:%d id:%s timeDiff:%d", new Object[] { Long.valueOf(this.rLh), Long.valueOf(this.rLi), Long.valueOf(this.rLR), Integer.valueOf(this.rLU.size()), Integer.valueOf(this.rLV.size()), this.rLS, Long.valueOf(Util.milliSecondsToNow(this.rLW)) });
      if (this.rLU.size() > 0)
      {
        n(this.rLS, null, false);
        if (this.rLV.isEmpty())
        {
          this.rLP.offer(this.rLZ);
          AppMethodBeat.o(21247);
          return;
        }
        this.rLP.offer(this.rLY);
        AppMethodBeat.o(21247);
        return;
      }
      Log.w(this.TAG, "setTagEnd NoFileSend, Go Send Tag: Direct. baklist:%d media:%d bigFileMap:%d ", new Object[] { Integer.valueOf(this.rLU.size()), Integer.valueOf(this.rLT.size()), Integer.valueOf(this.rLV.size()) });
      Assert.assertTrue("cursorEnd NOMsg, chatMsgList should empty", this.rLU.isEmpty());
      Assert.assertTrue("cursorEnd NOMsg, MediaList should empty", this.rLT.isEmpty());
      Assert.assertTrue("cursorEnd NOMsg, BigFileList should empty", this.rLV.isEmpty());
      this.rLP.offer(this.rLZ);
      AppMethodBeat.o(21247);
    }
    
    final void n(String paramString1, String paramString2, boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(21248);
      com.tencent.mm.plugin.backup.g.c.c local2 = new com.tencent.mm.plugin.backup.g.c.c()
      {
        public final void a(final com.tencent.mm.plugin.backup.g.c paramAnonymousc)
        {
          AppMethodBeat.i(21237);
          final long l2 = Util.nowMilliSecond();
          c.a locala = c.b.this.rLQ;
          long l3 = paramAnonymousc.ctT();
          boolean bool3 = c.b.this.odr;
          long l1 = locala.rLM.get();
          boolean bool1;
          label81:
          long l4;
          if (locala.rLM.get() >= 8388608L)
          {
            bool1 = true;
            if (locala.rLM.get() < 16777216L) {
              break label379;
            }
            bool2 = true;
            Log.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid %b inSize:%d sum:%d  [%b,%b]", new Object[] { Boolean.valueOf(bool3), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if (locala.rLM.get() + l3 >= 8388608L) {
              locala.rLN.close();
            }
            if (locala.rLM.get() >= 16777216L) {
              locala.rLO.close();
            }
            l4 = Util.nowMilliSecond();
            if (!locala.rLL.rLD)
            {
              long l5 = locala.rLM.get();
              if (!bool3) {
                break label385;
              }
              l1 = 16777216L;
              label215:
              if (l5 >= l1) {
                break label404;
              }
              locala.rLM.addAndGet(l3);
              l1 = Util.milliSecondsToNow(l4);
              l4 = locala.rLM.get();
              if (locala.rLM.get() < 8388608L) {
                break label392;
              }
              bool1 = true;
              label267:
              if (locala.rLM.get() < 16777216L) {
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
            c.b.this.rLP.offer(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(21236);
                Assert.assertTrue(toString() + ", check running. ", c.b.this.odr);
                long l1 = Util.nowMilliSecond();
                paramAnonymousc.ctM();
                long l2 = Util.nowMilliSecond();
                Log.i(c.b.this.TAG, "SendFileScene size:%d waitTime:%d netTime:%d [%s]", new Object[] { Integer.valueOf(paramAnonymousc.ctT()), Long.valueOf(l2 - l2), Long.valueOf(l2 - l1), paramAnonymousc.rRw.rWy });
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
          for (MMConditionVariable localMMConditionVariable = locala.rLO;; localMMConditionVariable = locala.rLN)
          {
            localMMConditionVariable.block(500L);
            break;
          }
        }
      };
      Log.i(this.TAG, "postSendFile isBigFile[%b], baklst:%d Id:%s path:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.rLU.size()), paramString1, paramString2 });
      if (!TextUtils.isEmpty(paramString2))
      {
        this.rLT.add(paramString1);
        if (paramString1 != null)
        {
          com.tencent.mm.plugin.backup.g.c.a(this.rLX, local2, paramString1, paramString2, c.this.rLF.rKQ);
          AppMethodBeat.o(21248);
        }
      }
      else
      {
        if (this.rLU.isEmpty()) {
          break label171;
        }
      }
      label171:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        Assert.assertTrue("chatMsgList should not empty", paramBoolean);
        if (paramString1 != null) {
          com.tencent.mm.plugin.backup.g.c.a(this.rLX, local2, paramString1, new LinkedList(this.rLU), c.this.rLF.rKQ);
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
    c.a rLQ;
    LinkedBlockingQueue<Object> rMk;
    MMConditionVariable rMl;
    c.b rMm;
    private Runnable rMn;
    
    public c()
    {
      AppMethodBeat.i(21250);
      this.rMk = new LinkedBlockingQueue();
      this.rLQ = new c.a(c.this, (byte)0);
      this.rMl = new MMConditionVariable();
      this.rMm = null;
      this.rMn = new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "tagRunnable";
        }
        
        public final void run()
        {
          AppMethodBeat.i(21249);
          while (!c.this.rLD)
          {
            Object localObject1 = null;
            label273:
            try
            {
              localObject2 = c.c.this.rMk.poll(500L, TimeUnit.MILLISECONDS);
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
            Log.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "TagQueue(%d)startNext obj:%s", new Object[] { Integer.valueOf(c.c.this.rMk.size()), localObject1 });
            if (localObject1 != null)
            {
              if (localObject1 == c.c.this.rMl)
              {
                c.c.this.rMl.open();
                AppMethodBeat.o(21249);
                return;
              }
              localb = (c.b)localObject1;
              localb.odr = true;
              localObject2 = new StringBuilder("MicroMsg.BackupPackAndSend.tag");
              if (localb.odr)
              {
                localObject1 = "S.";
                localb.TAG = ((String)localObject1 + localb.rLf + "." + localb.nickName);
                while (!c.this.rLD)
                {
                  localObject1 = null;
                  try
                  {
                    localObject2 = (Runnable)localb.rLP.poll(500L, TimeUnit.MILLISECONDS);
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
                    k = localb.rLP.size();
                    l2 = c.c.this.rLQ.rLM.get();
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
                Log.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "workerQueue poll q:%d mem:%s rt:%d [%s,%s,%s]", new Object[] { Integer.valueOf(k), String.format("[%s,%s,%s]", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j) }), Long.valueOf(Util.milliSecondsToNow(l1)), localObject1, localb, c.c.this.rMm });
                if (localb.odr) {
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
      com.tencent.e.h.ZvG.bh(this.rMn);
      AppMethodBeat.o(21250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c
 * JD-Core Version:    0.7.0.1
 */