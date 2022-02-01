package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.a;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.g.l;
import com.tencent.mm.plugin.backup.g.l.a;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
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
  public boolean nyP = false;
  b.b nyQ;
  com.tencent.mm.plugin.backup.b.d nyR;
  long nyS = 0L;
  public long nyT = 0L;
  private int nya;
  
  public c(com.tencent.mm.plugin.backup.b.d paramd, int paramInt, b.b paramb)
  {
    this.nyR = paramd;
    this.nya = paramInt;
    this.nyQ = paramb;
    this.nyP = false;
  }
  
  public final void a(final LinkedList<f.a> paramLinkedList, final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(21254);
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      ae.i("MicroMsg.BackupPackAndSend", "startBackup, backupSessionList size[%d], bigFileSize[%d], isOnlyText[%b]", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
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
            ae.e("MicroMsg.BackupPackAndSend", "backupChatRunnable backupSessionList is null.");
            if (c.this.nyQ != null)
            {
              c.this.nyQ.bHS();
              c.this.nyR.bHV().nye = -21;
              c.this.nyQ.xu(-21);
            }
            AppMethodBeat.o(21232);
            return;
          }
          com.tencent.mm.plugin.backup.g.b.bJB();
          Object localObject2 = paramLinkedList;
          Object localObject1 = new HashSet();
          if (localObject2 == null) {}
          for (int i = 0;; i = ((HashSet)localObject1).size())
          {
            c.this.nyR.bHV().R(14, 1, i);
            c.this.nyQ.xu(14);
            localObject1 = (String)com.tencent.mm.plugin.backup.h.d.bJW().bJX().ajA().get(2, null);
            c.this.nyT = bu.fpO();
            localObject2 = new c.c(c.this);
            Iterator localIterator = paramLinkedList.iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              f.a locala = (f.a)localIterator.next();
              c.this.a(locala, (c.c)localObject2, (String)localObject1, paramLong, this.nyW);
            } while (!c.this.nyP);
            if (!c.this.nyP) {
              break;
            }
            ae.e("MicroMsg.BackupPackAndSend", "backupChatRunnable cancel!");
            AppMethodBeat.o(21232);
            return;
            localObject2 = ((LinkedList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((HashSet)localObject1).add(((f.a)((Iterator)localObject2).next()).nyq);
            }
          }
          long l1 = bu.fpO();
          long l2 = bu.fpO();
          ((c.c)localObject2).nzw.offer(((c.c)localObject2).nzx);
          ((c.c)localObject2).nzx.block();
          ae.i("MicroMsg.BackupPackAndSend.TagQueueSucker", "waitFinish Finish Now:%d", new Object[] { Long.valueOf(bu.DD(l2)) });
          Assert.assertTrue(((c.c)localObject2).nzw.isEmpty());
          ae.i("MicroMsg.BackupPackAndSend", "backupChatRunnable finish, Session[%d], loopTime[%d], waitSendTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(bu.DD(c.this.nyT)), Long.valueOf(bu.DD(l1)) });
          c.this.bIo();
          c.this.nyR.bHV().R(15, i, i);
          c.this.nyQ.xu(15);
          c.this.ix(true);
          com.tencent.mm.plugin.backup.g.b.bJA();
          com.tencent.mm.plugin.backup.g.b.bJC();
          c.this.nyQ.bHR();
          ae.i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupfinish, backupDataSize[%d], backupCostTime[%d], backupStartTime[%d]", new Object[] { Long.valueOf(c.this.nyS), Long.valueOf(bu.DD(c.this.nyT)), Long.valueOf(c.this.nyT) });
          AppMethodBeat.o(21232);
        }
      };
      com.tencent.e.h.MqF.aR(paramLinkedList);
      AppMethodBeat.o(21254);
      return;
    }
  }
  
  final boolean a(f.a parama, c paramc, String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(21255);
    Object localObject1 = com.tencent.mm.plugin.backup.h.d.bJW().bJX().azL().aVa(parama.nyq);
    int i;
    long l5;
    int k;
    long l1;
    long l2;
    int j;
    if (localObject1 != null)
    {
      i = ((ba)localObject1).field_unReadCount;
      ae.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg index[%d], sessionName[%s], startTime[%d], endTime[%d], unReadCount[%d]", new Object[] { Integer.valueOf(parama.nyr), parama.nyq, Long.valueOf(parama.startTime), Long.valueOf(parama.endTime), Integer.valueOf(i) });
      l5 = bu.fpO();
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
      l4 = bu.fpO();
      Object localObject2 = com.tencent.mm.plugin.backup.h.d.bJW().bJX().azI().c(parama.nyq, parama.startTime, parama.endTime, i);
      Object localObject3;
      for (;;)
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break label334;
        }
        k = i + 1;
        if (this.nyP)
        {
          ae.e("MicroMsg.BackupPackAndSend", "backupPackSessionMsg add msgInfoLinkedList is CANCELED!");
          ((Cursor)localObject2).close();
          AppMethodBeat.o(21255);
          return false;
          i = 0;
          break;
        }
        localObject3 = new bv();
        ((bv)localObject3).convertFrom((Cursor)localObject2);
        if (paramBoolean)
        {
          i = k;
          if (((bv)localObject3).getType() != 1) {}
        }
        else
        {
          if (((bv)localObject3).getType() == 922746929)
          {
            localObject1 = ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).yM(((ei)localObject3).field_msgId);
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
      l4 = l3 - l4 + bu.fpO();
      if (localLinkedList.size() == 0) {
        break label776;
      }
      k = 0;
      if (k < localLinkedList.size())
      {
        if (this.nyP)
        {
          ae.e("MicroMsg.BackupPackAndSend", "backupPackSessionMsg packMsg is CANCELED!");
          AppMethodBeat.o(21255);
          return false;
        }
        Object localObject4 = (bv)localLinkedList.get(k);
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
              l2 -= bu.fpO();
              if (j > 0)
              {
                bool = true;
                l3 = l2;
                localObject1 = com.tencent.mm.plugin.backup.f.h.a((bv)localObject4, false, paramString, localPLong, (LinkedList)localObject3, localHashMap, bool, false, paramLong);
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
              l3 = bu.fpO();
              l2 = l3 + l2;
              if (localObject1 != null) {
                break label763;
              }
              bool = true;
              ae.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((LinkedList)localObject3).size()), Long.valueOf(localPLong.value), Integer.valueOf(localHashMap.size()), Long.valueOf(((ei)localObject4).field_msgSvrId), Integer.valueOf(((bv)localObject4).getType()), Long.valueOf(((ei)localObject4).field_createTime), ((ei)localObject4).field_talker });
              l3 = l1;
              m = j;
              if (localObject1 != null)
              {
                m = j - 1;
                l3 = bu.fpO();
                long l6 = localPLong.value;
                long l7 = ((ei)localObject4).field_createTime;
                if (paramc.nzy == null)
                {
                  localObject2 = paramc.nzw;
                  localObject4 = new b(paramc.nyX, paramc.nzc, parama);
                  paramc.nzy = ((b)localObject4);
                  ((LinkedBlockingQueue)localObject2).offer(localObject4);
                }
                if (paramc.nzy.a((if)localObject1, l6, l7, (LinkedList)localObject3, localHashMap)) {
                  paramc.nzy = null;
                }
                l3 = l1 - l3 + bu.fpO();
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
          ae.printErrStackTrace("MicroMsg.BackupPackAndSend", localException1, "backupPackSessionMsg packedMsg", new Object[0]);
          continue;
          bool = false;
        }
      }
      l3 = l4;
    }
    label776:
    paramLong = bu.fpO();
    if (paramc.nzy == null)
    {
      paramString = paramc.nzw;
      localObject1 = new b(paramc.nyX, paramc.nzc, parama);
      paramc.nzy = ((b)localObject1);
      paramString.offer(localObject1);
    }
    paramc.nzy.bIp();
    paramc.nzy = null;
    long l3 = bu.fpO();
    ae.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg finish Cursor Session[%d], convName[%s], msgCnt[%d], time[%d], [%d,%d,%d]", new Object[] { Integer.valueOf(parama.nyr), parama.nyq, Integer.valueOf(i), Long.valueOf(bu.DD(l5)), Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l1 - paramLong + l3) });
    AppMethodBeat.o(21255);
    return true;
  }
  
  public final long bIn()
  {
    return this.nyS / 1024L;
  }
  
  public final void bIo()
  {
    AppMethodBeat.i(21253);
    ae.i("MicroMsg.BackupPackAndSend", "backupSendFinishRequest.");
    com.tencent.mm.plugin.backup.i.d locald = new com.tencent.mm.plugin.backup.i.d();
    locald.ID = this.nyR.nxW;
    try
    {
      com.tencent.mm.plugin.backup.g.b.L(locald.toByteArray(), 8);
      AppMethodBeat.o(21253);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.BackupPackAndSend", localException, "BackupFinishRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21253);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21251);
    ae.e("MicroMsg.BackupPackAndSend", "cancel, caller:%s", new Object[] { au.foQ() });
    this.nyP = true;
    AppMethodBeat.o(21251);
  }
  
  public final void ix(boolean paramBoolean)
  {
    AppMethodBeat.i(21252);
    ae.i("MicroMsg.BackupPackAndSend", "clearContinueBackupData.");
    SharedPreferences.Editor localEditor;
    if (this.nya == 1)
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IRA, Boolean.FALSE);
      localEditor = com.tencent.mm.plugin.backup.b.d.bIa().edit();
      localEditor.putString("BACKUP_PC_CHOOSE_SESSION", null);
      if (paramBoolean)
      {
        if (this.nya != 1) {
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
      if (this.nya != 2) {
        break;
      }
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IRD, Boolean.FALSE);
      break;
      label155:
      if (this.nya == 2)
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
    volatile AtomicLong nyY;
    an nyZ;
    an nza;
    
    private a()
    {
      AppMethodBeat.i(21233);
      this.nyY = new AtomicLong(0L);
      this.nyZ = new an(true);
      this.nza = new an(true);
      AppMethodBeat.o(21233);
    }
  }
  
  final class b
  {
    String TAG;
    String bVF;
    boolean kfa;
    int nyr;
    long nyt;
    long nyu;
    LinkedBlockingQueue<Runnable> nzb;
    c.a nzc;
    private long nzd;
    String nze;
    Vector<String> nzf;
    private Vector<if> nzg;
    HashMap<Long, h.a> nzh;
    long nzi;
    private final com.tencent.mm.plugin.backup.g.c.b nzj;
    private final Runnable nzk;
    final Runnable nzl;
    String talker;
    
    public b(c.a parama, f.a parama1)
    {
      AppMethodBeat.i(21245);
      this.TAG = "";
      this.nzb = new LinkedBlockingQueue();
      this.nyt = 0L;
      this.nyu = 0L;
      this.nzd = 0L;
      this.nze = "";
      this.nzf = new Vector();
      this.nzg = new Vector();
      this.nzh = new HashMap();
      this.nzi = 0L;
      this.kfa = false;
      this.nzj = new com.tencent.mm.plugin.backup.g.c.b()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(21234);
          c.a locala = c.b.this.nzc;
          long l1 = paramAnonymousInt;
          locala.nyY.addAndGet(0L - l1);
          if (locala.nyY.get() < 8388608L) {
            locala.nyZ.open();
          }
          if (locala.nyY.get() < 16777216L) {
            locala.nza.open();
          }
          long l2 = locala.nyY.get();
          boolean bool1;
          if (locala.nyY.get() >= 8388608L)
          {
            bool1 = true;
            if (locala.nyY.get() < 16777216L) {
              break label266;
            }
          }
          label266:
          for (boolean bool2 = true;; bool2 = false)
          {
            ae.v("MicroMsg.BackupPackAndSend", "MemoryChecker.release size:%d sum:%d [%b,%b] [%b,%b]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(locala.nyZ.IxQ), Boolean.valueOf(locala.nza.IxQ) });
            c.this.nyS += paramAnonymousInt;
            ae.i(c.b.this.TAG, "OnfinishIdCallback size[%d], isIdFinish[%b], id[%s] ", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
            AppMethodBeat.o(21234);
            return;
            bool1 = false;
            break;
          }
        }
      };
      this.nzk = new Runnable()
      {
        public final void run()
        {
          boolean bool = true;
          AppMethodBeat.i(21241);
          Assert.assertTrue(toString() + ", check running. ", c.b.this.kfa);
          ae.i(c.b.this.TAG, "requestBigFileList svrIdCnt:%d timeDiff:%d caller:%s", new Object[] { Integer.valueOf(c.b.this.nzh.size()), Long.valueOf(bu.DD(c.b.this.nzi)), au.foQ() });
          if (!c.b.this.nzh.isEmpty()) {}
          for (;;)
          {
            Assert.assertTrue("BigFileMap should not Empty", bool);
            l.a local1 = new l.a()
            {
              public final void E(final LinkedList<Long> paramAnonymous2LinkedList)
              {
                AppMethodBeat.i(21239);
                com.tencent.e.h.MqF.aR(new com.tencent.e.i.h()
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
                      h.a locala = (h.a)c.b.this.nzh.get(localLong);
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
                      for (String str2 = "null";; str2 = locala.nCL.path)
                      {
                        ae.i(str3, "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d media:%s item:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localLong, str1, str2 });
                        if (locala != null)
                        {
                          c.b.this.nzf.add(locala.nCL.mediaId);
                          c.b.this.l(locala.nCL.mediaId, locala.nCL.path, true);
                        }
                        i += 1;
                        break;
                        str1 = locala.nCL.mediaId;
                        break label93;
                      }
                    }
                    c.b.this.nzb.offer(c.b.this.nzl);
                    AppMethodBeat.o(21238);
                  }
                });
                AppMethodBeat.o(21239);
              }
            };
            new l(c.b.this.talker, c.b.this.nzh, local1).bJH();
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
      this.nzl = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21244);
          Assert.assertTrue(toString() + ", check running. ", c.b.this.kfa);
          final boolean bool1;
          switch (com.tencent.mm.plugin.backup.b.d.bHY())
          {
          default: 
            if (c.b.this.nyr == c.this.nyR.bHV().nyg - 1)
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
            Object localObject = new an(bool2);
            f local1 = new f()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(21242);
                paramAnonymous2n = ((aa)((com.tencent.mm.plugin.backup.g.d)paramAnonymous2n).nEL).nJN;
                ae.i(c.b.this.TAG, "Send Tag finish last:%b  cv:%s [%d,%d,%s] tag[%s,%s]", new Object[] { Boolean.valueOf(bool1), this.nzu, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, c.b.this.nze, paramAnonymous2n });
                if ((bool1) && (c.b.this.nze.equals(paramAnonymous2n))) {
                  this.nzu.open();
                }
                AppMethodBeat.o(21242);
              }
            };
            new com.tencent.mm.plugin.backup.g.d(c.b.this.talker, c.b.this.nyt, c.b.this.nyu, c.b.this.nze, c.b.this.bVF, new LinkedList(c.b.this.nzf), local1).bJH();
            if (bool1)
            {
              ae.w(c.b.this.TAG, "sendTag last Session :[%d/%d] wait tag resp callback .", new Object[] { Integer.valueOf(c.b.this.nyr), Integer.valueOf(c.this.nyR.bHV().nyg - 1) });
              ((an)localObject).block();
            }
            c.b.this.kfa = false;
            AppMethodBeat.o(21244);
            return;
            ae.i(c.b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[] { Integer.valueOf(c.this.nyR.bHV().nyf), Long.valueOf(c.b.this.nyt), Long.valueOf(c.b.this.nyu), Integer.valueOf(c.b.this.nzf.size()), c.b.this.bVF, c.b.this.nze, Long.valueOf(bu.DD(c.b.this.nzi)) });
            if (c.this.nyR.bHV().nyf >= c.b.this.nyr + 1) {
              break;
            }
            int i = c.this.nyR.bHV().nyg;
            localObject = c.this.nyR.bHV();
            if (c.b.this.nyr + 1 > i) {}
            for (;;)
            {
              ((e)localObject).nyf = i;
              c.this.nyQ.xu(c.this.nyR.bHV().nye);
              break;
              i = c.b.this.nyr + 1;
            }
            ae.i(c.b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[] { Integer.valueOf(c.this.nyR.bHV().nyf), Long.valueOf(c.b.this.nyt), Long.valueOf(c.b.this.nyu), Integer.valueOf(c.b.this.nzf.size()), c.b.this.bVF, c.b.this.nze, Long.valueOf(bu.DD(c.b.this.nzi)) });
            if (c.this.nyR.bHV().nyf >= c.b.this.nyr + 1) {
              break;
            }
            i = c.this.nyR.bHV().nyg;
            localObject = c.this.nyR.bHV();
            if (c.b.this.nyr + 1 > i) {}
            for (;;)
            {
              ((e)localObject).nyf = i;
              c.this.nyQ.xu(c.this.nyR.bHV().nye);
              break;
              i = c.b.this.nyr + 1;
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
      this.nzi = bu.fpO();
      this.nzc = parama;
      this.talker = parama1.nyq;
      this.nyr = parama1.nyr;
      if (com.tencent.mm.model.x.wb(this.talker))
      {
        this$1 = w.getDisplayName(this.talker, this.talker);
        this.bVF = c.this;
        parama = new StringBuilder("MicroMsg.BackupPackAndSend.tag.");
        if (!this.kfa) {
          break label299;
        }
      }
      label299:
      for (this$1 = "S.";; this$1 = "W.")
      {
        this.TAG = (c.this + this.nyr + "." + this.bVF);
        ae.i(this.TAG, "initTagNow [%d,%s,%s] [%s]", new Object[] { Integer.valueOf(this.nyr), this.bVF, this.talker, au.foQ() });
        AppMethodBeat.o(21245);
        return;
        this$1 = w.zP(this.talker);
        break;
      }
    }
    
    public final boolean a(if paramif, long paramLong1, long paramLong2, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap)
    {
      AppMethodBeat.i(21246);
      this.nzg.add(paramif);
      long l2 = this.nzd;
      if (paramLong1 > 0L) {}
      for (long l1 = paramLong1;; l1 = 0L)
      {
        this.nzd = (l1 + l2);
        if (this.nyt == 0L) {
          this.nyt = paramLong2;
        }
        this.nyu = paramLong2;
        this.nzh.putAll(paramHashMap);
        paramif = paramLinkedList.iterator();
        while (paramif.hasNext())
        {
          paramHashMap = (u)paramif.next();
          l(paramHashMap.mediaId, paramHashMap.path, false);
        }
      }
      ae.i(this.TAG, "addToTag msgtime[%d,%d] size[%d,%d] baklist:%d media:%d timeDiff:%d", new Object[] { Long.valueOf(this.nyt), Long.valueOf(this.nyu), Long.valueOf(paramLong1), Long.valueOf(this.nzd), Integer.valueOf(this.nzg.size()), Integer.valueOf(paramLinkedList.size()), Long.valueOf(bu.DD(this.nzi)) });
      if ((this.nzd > 83886080L) || (this.nzg.size() > 80))
      {
        bIp();
        AppMethodBeat.o(21246);
        return true;
      }
      AppMethodBeat.o(21246);
      return false;
    }
    
    public final void bIp()
    {
      AppMethodBeat.i(21247);
      this.nze = ("MSG_" + this.nzg.size() + "_" + this.talker + "_" + bu.fpO());
      ae.i(this.TAG, "setTagEnd msgtime[%d,%d], size:%d baklist:%d bigfile:%d id:%s timeDiff:%d", new Object[] { Long.valueOf(this.nyt), Long.valueOf(this.nyu), Long.valueOf(this.nzd), Integer.valueOf(this.nzg.size()), Integer.valueOf(this.nzh.size()), this.nze, Long.valueOf(bu.DD(this.nzi)) });
      if (this.nzg.size() > 0)
      {
        l(this.nze, null, false);
        if (this.nzh.isEmpty())
        {
          this.nzb.offer(this.nzl);
          AppMethodBeat.o(21247);
          return;
        }
        this.nzb.offer(this.nzk);
        AppMethodBeat.o(21247);
        return;
      }
      ae.w(this.TAG, "setTagEnd NoFileSend, Go Send Tag: Direct. baklist:%d media:%d bigFileMap:%d ", new Object[] { Integer.valueOf(this.nzg.size()), Integer.valueOf(this.nzf.size()), Integer.valueOf(this.nzh.size()) });
      Assert.assertTrue("cursorEnd NOMsg, chatMsgList should empty", this.nzg.isEmpty());
      Assert.assertTrue("cursorEnd NOMsg, MediaList should empty", this.nzf.isEmpty());
      Assert.assertTrue("cursorEnd NOMsg, BigFileList should empty", this.nzh.isEmpty());
      this.nzb.offer(this.nzl);
      AppMethodBeat.o(21247);
    }
    
    final void l(String paramString1, String paramString2, boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(21248);
      com.tencent.mm.plugin.backup.g.c.c local2 = new com.tencent.mm.plugin.backup.g.c.c()
      {
        public final void a(final com.tencent.mm.plugin.backup.g.c paramAnonymousc)
        {
          AppMethodBeat.i(21237);
          final long l2 = bu.fpO();
          c.a locala = c.b.this.nzc;
          long l3 = paramAnonymousc.bJO();
          boolean bool3 = c.b.this.kfa;
          long l1 = locala.nyY.get();
          boolean bool1;
          label81:
          long l4;
          if (locala.nyY.get() >= 8388608L)
          {
            bool1 = true;
            if (locala.nyY.get() < 16777216L) {
              break label379;
            }
            bool2 = true;
            ae.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid %b inSize:%d sum:%d  [%b,%b]", new Object[] { Boolean.valueOf(bool3), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if (locala.nyY.get() + l3 >= 8388608L) {
              locala.nyZ.close();
            }
            if (locala.nyY.get() >= 16777216L) {
              locala.nza.close();
            }
            l4 = bu.fpO();
            if (!locala.nyX.nyP)
            {
              long l5 = locala.nyY.get();
              if (!bool3) {
                break label385;
              }
              l1 = 16777216L;
              label215:
              if (l5 >= l1) {
                break label404;
              }
              locala.nyY.addAndGet(l3);
              l1 = bu.DD(l4);
              l4 = locala.nyY.get();
              if (locala.nyY.get() < 8388608L) {
                break label392;
              }
              bool1 = true;
              label267:
              if (locala.nyY.get() < 16777216L) {
                break label398;
              }
            }
          }
          label385:
          label392:
          label398:
          for (boolean bool2 = true;; bool2 = false)
          {
            ae.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid Out:%d %b inSize:%d sum:%d  [%b,%b]", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool3), Long.valueOf(l3), Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            c.b.this.nzb.offer(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(21236);
                Assert.assertTrue(toString() + ", check running. ", c.b.this.kfa);
                long l1 = bu.fpO();
                paramAnonymousc.bJH();
                long l2 = bu.fpO();
                ae.i(c.b.this.TAG, "SendFileScene size:%d waitTime:%d netTime:%d [%s]", new Object[] { Integer.valueOf(paramAnonymousc.bJO()), Long.valueOf(l2 - l2), Long.valueOf(l2 - l1), paramAnonymousc.nEC.nJE });
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
          for (an localan = locala.nza;; localan = locala.nyZ)
          {
            localan.foL();
            break;
          }
        }
      };
      ae.i(this.TAG, "postSendFile isBigFile[%b], baklst:%d Id:%s path:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.nzg.size()), paramString1, paramString2 });
      if (!TextUtils.isEmpty(paramString2))
      {
        this.nzf.add(paramString1);
        if (paramString1 != null)
        {
          com.tencent.mm.plugin.backup.g.c.a(this.nzj, local2, paramString1, paramString2, c.this.nyR.nyc);
          AppMethodBeat.o(21248);
        }
      }
      else
      {
        if (this.nzg.isEmpty()) {
          break label171;
        }
      }
      label171:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        Assert.assertTrue("chatMsgList should not empty", paramBoolean);
        if (paramString1 != null) {
          com.tencent.mm.plugin.backup.g.c.a(this.nzj, local2, paramString1, new LinkedList(this.nzg), c.this.nyR.nyc);
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
    c.a nzc;
    LinkedBlockingQueue<Object> nzw;
    an nzx;
    c.b nzy;
    private Runnable nzz;
    
    public c()
    {
      AppMethodBeat.i(21250);
      this.nzw = new LinkedBlockingQueue();
      this.nzc = new c.a(c.this, (byte)0);
      this.nzx = new an();
      this.nzy = null;
      this.nzz = new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "tagRunnable";
        }
        
        public final void run()
        {
          AppMethodBeat.i(21249);
          while (!c.this.nyP)
          {
            Object localObject1 = null;
            label273:
            try
            {
              localObject2 = c.c.this.nzw.poll(500L, TimeUnit.MILLISECONDS);
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
            ae.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "TagQueue(%d)startNext obj:%s", new Object[] { Integer.valueOf(c.c.this.nzw.size()), localObject1 });
            if (localObject1 != null)
            {
              if (localObject1 == c.c.this.nzx)
              {
                c.c.this.nzx.open();
                AppMethodBeat.o(21249);
                return;
              }
              localb = (c.b)localObject1;
              localb.kfa = true;
              localObject2 = new StringBuilder("MicroMsg.BackupPackAndSend.tag");
              if (localb.kfa)
              {
                localObject1 = "S.";
                localb.TAG = ((String)localObject1 + localb.nyr + "." + localb.bVF);
                while (!c.this.nyP)
                {
                  localObject1 = null;
                  try
                  {
                    localObject2 = (Runnable)localb.nzb.poll(500L, TimeUnit.MILLISECONDS);
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
                    l1 = bu.fpO();
                    ((Runnable)localObject1).run();
                    k = localb.nzb.size();
                    l2 = c.c.this.nzc.nyY.get();
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
                ae.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "workerQueue poll q:%d mem:%s rt:%d [%s,%s,%s]", new Object[] { Integer.valueOf(k), String.format("[%s,%s,%s]", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j) }), Long.valueOf(bu.DD(l1)), localObject1, localb, c.c.this.nzy });
                if (localb.kfa) {
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
      com.tencent.e.h.MqF.aR(this.nzz);
      AppMethodBeat.o(21250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c
 * JD-Core Version:    0.7.0.1
 */