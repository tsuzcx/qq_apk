package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.a;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.g.l;
import com.tencent.mm.plugin.backup.g.l.a;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
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
  private int nsF;
  public boolean ntu = false;
  b.b ntv;
  com.tencent.mm.plugin.backup.b.d ntw;
  long ntx = 0L;
  public long nty = 0L;
  
  public c(com.tencent.mm.plugin.backup.b.d paramd, int paramInt, b.b paramb)
  {
    this.ntw = paramd;
    this.nsF = paramInt;
    this.ntv = paramb;
    this.ntu = false;
  }
  
  public final void a(final LinkedList<f.a> paramLinkedList, final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(21254);
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      ad.i("MicroMsg.BackupPackAndSend", "startBackup, backupSessionList size[%d], bigFileSize[%d], isOnlyText[%b]", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
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
            ad.e("MicroMsg.BackupPackAndSend", "backupChatRunnable backupSessionList is null.");
            if (c.this.ntv != null)
            {
              c.this.ntv.bGU();
              c.this.ntw.bGX().nsJ = -21;
              c.this.ntv.xp(-21);
            }
            AppMethodBeat.o(21232);
            return;
          }
          com.tencent.mm.plugin.backup.g.b.bID();
          Object localObject2 = paramLinkedList;
          Object localObject1 = new HashSet();
          if (localObject2 == null) {}
          for (int i = 0;; i = ((HashSet)localObject1).size())
          {
            c.this.ntw.bGX().R(14, 1, i);
            c.this.ntv.xp(14);
            localObject1 = (String)com.tencent.mm.plugin.backup.h.d.bIY().bIZ().ajl().get(2, null);
            c.this.nty = bt.flT();
            localObject2 = new c.c(c.this);
            Iterator localIterator = paramLinkedList.iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              f.a locala = (f.a)localIterator.next();
              c.this.a(locala, (c.c)localObject2, (String)localObject1, paramLong, this.ntB);
            } while (!c.this.ntu);
            if (!c.this.ntu) {
              break;
            }
            ad.e("MicroMsg.BackupPackAndSend", "backupChatRunnable cancel!");
            AppMethodBeat.o(21232);
            return;
            localObject2 = ((LinkedList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((HashSet)localObject1).add(((f.a)((Iterator)localObject2).next()).nsV);
            }
          }
          long l1 = bt.flT();
          long l2 = bt.flT();
          ((c.c)localObject2).nub.offer(((c.c)localObject2).nuc);
          ((c.c)localObject2).nuc.block();
          ad.i("MicroMsg.BackupPackAndSend.TagQueueSucker", "waitFinish Finish Now:%d", new Object[] { Long.valueOf(bt.Df(l2)) });
          Assert.assertTrue(((c.c)localObject2).nub.isEmpty());
          ad.i("MicroMsg.BackupPackAndSend", "backupChatRunnable finish, Session[%d], loopTime[%d], waitSendTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(bt.Df(c.this.nty)), Long.valueOf(bt.Df(l1)) });
          c.this.bHq();
          c.this.ntw.bGX().R(15, i, i);
          c.this.ntv.xp(15);
          c.this.iz(true);
          com.tencent.mm.plugin.backup.g.b.bIC();
          com.tencent.mm.plugin.backup.g.b.bIE();
          c.this.ntv.bGT();
          ad.i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupfinish, backupDataSize[%d], backupCostTime[%d], backupStartTime[%d]", new Object[] { Long.valueOf(c.this.ntx), Long.valueOf(bt.Df(c.this.nty)), Long.valueOf(c.this.nty) });
          AppMethodBeat.o(21232);
        }
      };
      com.tencent.e.h.LTJ.aU(paramLinkedList);
      AppMethodBeat.o(21254);
      return;
    }
  }
  
  final boolean a(f.a parama, c paramc, String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(21255);
    Object localObject1 = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().azv().aTz(parama.nsV);
    int i;
    long l5;
    int k;
    long l1;
    long l2;
    int j;
    if (localObject1 != null)
    {
      i = ((com.tencent.mm.g.c.ba)localObject1).field_unReadCount;
      ad.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg index[%d], sessionName[%s], startTime[%d], endTime[%d], unReadCount[%d]", new Object[] { Integer.valueOf(parama.nsW), parama.nsV, Long.valueOf(parama.startTime), Long.valueOf(parama.endTime), Integer.valueOf(i) });
      l5 = bt.flT();
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
      l4 = bt.flT();
      Object localObject2 = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().azs().c(parama.nsV, parama.startTime, parama.endTime, i);
      Object localObject3;
      for (;;)
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break label334;
        }
        k = i + 1;
        if (this.ntu)
        {
          ad.e("MicroMsg.BackupPackAndSend", "backupPackSessionMsg add msgInfoLinkedList is CANCELED!");
          ((Cursor)localObject2).close();
          AppMethodBeat.o(21255);
          return false;
          i = 0;
          break;
        }
        localObject3 = new bu();
        ((bu)localObject3).convertFrom((Cursor)localObject2);
        if (paramBoolean)
        {
          i = k;
          if (((bu)localObject3).getType() != 1) {}
        }
        else
        {
          if (((bu)localObject3).getType() == 922746929)
          {
            localObject1 = ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).ys(((ei)localObject3).field_msgId);
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
      l4 = l3 - l4 + bt.flT();
      if (localLinkedList.size() == 0) {
        break label776;
      }
      k = 0;
      if (k < localLinkedList.size())
      {
        if (this.ntu)
        {
          ad.e("MicroMsg.BackupPackAndSend", "backupPackSessionMsg packMsg is CANCELED!");
          AppMethodBeat.o(21255);
          return false;
        }
        Object localObject4 = (bu)localLinkedList.get(k);
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
              l2 -= bt.flT();
              if (j > 0)
              {
                bool = true;
                l3 = l2;
                localObject1 = com.tencent.mm.plugin.backup.f.h.a((bu)localObject4, false, paramString, localPLong, (LinkedList)localObject3, localHashMap, bool, false, paramLong);
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
              l3 = bt.flT();
              l2 = l3 + l2;
              if (localObject1 != null) {
                break label763;
              }
              bool = true;
              ad.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((LinkedList)localObject3).size()), Long.valueOf(localPLong.value), Integer.valueOf(localHashMap.size()), Long.valueOf(((ei)localObject4).field_msgSvrId), Integer.valueOf(((bu)localObject4).getType()), Long.valueOf(((ei)localObject4).field_createTime), ((ei)localObject4).field_talker });
              l3 = l1;
              m = j;
              if (localObject1 != null)
              {
                m = j - 1;
                l3 = bt.flT();
                long l6 = localPLong.value;
                long l7 = ((ei)localObject4).field_createTime;
                if (paramc.nud == null)
                {
                  localObject2 = paramc.nub;
                  localObject4 = new b(paramc.ntC, paramc.ntH, parama);
                  paramc.nud = ((b)localObject4);
                  ((LinkedBlockingQueue)localObject2).offer(localObject4);
                }
                if (paramc.nud.a((if)localObject1, l6, l7, (LinkedList)localObject3, localHashMap)) {
                  paramc.nud = null;
                }
                l3 = l1 - l3 + bt.flT();
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
          ad.printErrStackTrace("MicroMsg.BackupPackAndSend", localException1, "backupPackSessionMsg packedMsg", new Object[0]);
          continue;
          bool = false;
        }
      }
      l3 = l4;
    }
    label776:
    paramLong = bt.flT();
    if (paramc.nud == null)
    {
      paramString = paramc.nub;
      localObject1 = new b(paramc.ntC, paramc.ntH, parama);
      paramc.nud = ((b)localObject1);
      paramString.offer(localObject1);
    }
    paramc.nud.bHr();
    paramc.nud = null;
    long l3 = bt.flT();
    ad.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg finish Cursor Session[%d], convName[%s], msgCnt[%d], time[%d], [%d,%d,%d]", new Object[] { Integer.valueOf(parama.nsW), parama.nsV, Integer.valueOf(i), Long.valueOf(bt.Df(l5)), Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l1 - paramLong + l3) });
    AppMethodBeat.o(21255);
    return true;
  }
  
  public final long bHp()
  {
    return this.ntx / 1024L;
  }
  
  public final void bHq()
  {
    AppMethodBeat.i(21253);
    ad.i("MicroMsg.BackupPackAndSend", "backupSendFinishRequest.");
    com.tencent.mm.plugin.backup.i.d locald = new com.tencent.mm.plugin.backup.i.d();
    locald.ID = this.ntw.nsB;
    try
    {
      com.tencent.mm.plugin.backup.g.b.L(locald.toByteArray(), 8);
      AppMethodBeat.o(21253);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupPackAndSend", localException, "BackupFinishRequest to buf err.", new Object[0]);
      AppMethodBeat.o(21253);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21251);
    ad.e("MicroMsg.BackupPackAndSend", "cancel, caller:%s", new Object[] { at.fkV() });
    this.ntu = true;
    AppMethodBeat.o(21251);
  }
  
  public final void iz(boolean paramBoolean)
  {
    AppMethodBeat.i(21252);
    ad.i("MicroMsg.BackupPackAndSend", "clearContinueBackupData.");
    SharedPreferences.Editor localEditor;
    if (this.nsF == 1)
    {
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Ixc, Boolean.FALSE);
      localEditor = com.tencent.mm.plugin.backup.b.d.bHc().edit();
      localEditor.putString("BACKUP_PC_CHOOSE_SESSION", null);
      if (paramBoolean)
      {
        if (this.nsF != 1) {
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
      if (this.nsF != 2) {
        break;
      }
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Ixf, Boolean.FALSE);
      break;
      label155:
      if (this.nsF == 2)
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
    volatile AtomicLong ntD;
    am ntE;
    am ntF;
    
    private a()
    {
      AppMethodBeat.i(21233);
      this.ntD = new AtomicLong(0L);
      this.ntE = new am(true);
      this.ntF = new am(true);
      AppMethodBeat.o(21233);
    }
  }
  
  final class b
  {
    String TAG;
    String bVF;
    boolean kbJ;
    int nsW;
    long nsY;
    long nsZ;
    LinkedBlockingQueue<Runnable> ntG;
    c.a ntH;
    private long ntI;
    String ntJ;
    Vector<String> ntK;
    private Vector<if> ntL;
    HashMap<Long, h.a> ntM;
    long ntN;
    private final com.tencent.mm.plugin.backup.g.c.b ntO;
    private final Runnable ntP;
    final Runnable ntQ;
    String talker;
    
    public b(c.a parama, f.a parama1)
    {
      AppMethodBeat.i(21245);
      this.TAG = "";
      this.ntG = new LinkedBlockingQueue();
      this.nsY = 0L;
      this.nsZ = 0L;
      this.ntI = 0L;
      this.ntJ = "";
      this.ntK = new Vector();
      this.ntL = new Vector();
      this.ntM = new HashMap();
      this.ntN = 0L;
      this.kbJ = false;
      this.ntO = new com.tencent.mm.plugin.backup.g.c.b()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(21234);
          c.a locala = c.b.this.ntH;
          long l1 = paramAnonymousInt;
          locala.ntD.addAndGet(0L - l1);
          if (locala.ntD.get() < 8388608L) {
            locala.ntE.open();
          }
          if (locala.ntD.get() < 16777216L) {
            locala.ntF.open();
          }
          long l2 = locala.ntD.get();
          boolean bool1;
          if (locala.ntD.get() >= 8388608L)
          {
            bool1 = true;
            if (locala.ntD.get() < 16777216L) {
              break label266;
            }
          }
          label266:
          for (boolean bool2 = true;; bool2 = false)
          {
            ad.v("MicroMsg.BackupPackAndSend", "MemoryChecker.release size:%d sum:%d [%b,%b] [%b,%b]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(locala.ntE.IdF), Boolean.valueOf(locala.ntF.IdF) });
            c.this.ntx += paramAnonymousInt;
            ad.i(c.b.this.TAG, "OnfinishIdCallback size[%d], isIdFinish[%b], id[%s] ", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
            AppMethodBeat.o(21234);
            return;
            bool1 = false;
            break;
          }
        }
      };
      this.ntP = new Runnable()
      {
        public final void run()
        {
          boolean bool = true;
          AppMethodBeat.i(21241);
          Assert.assertTrue(toString() + ", check running. ", c.b.this.kbJ);
          ad.i(c.b.this.TAG, "requestBigFileList svrIdCnt:%d timeDiff:%d caller:%s", new Object[] { Integer.valueOf(c.b.this.ntM.size()), Long.valueOf(bt.Df(c.b.this.ntN)), at.fkV() });
          if (!c.b.this.ntM.isEmpty()) {}
          for (;;)
          {
            Assert.assertTrue("BigFileMap should not Empty", bool);
            l.a local1 = new l.a()
            {
              public final void E(final LinkedList<Long> paramAnonymous2LinkedList)
              {
                AppMethodBeat.i(21239);
                com.tencent.e.h.LTJ.aU(new com.tencent.e.i.h()
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
                      h.a locala = (h.a)c.b.this.ntM.get(localLong);
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
                      for (String str2 = "null";; str2 = locala.nxq.path)
                      {
                        ad.i(str3, "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d media:%s item:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localLong, str1, str2 });
                        if (locala != null)
                        {
                          c.b.this.ntK.add(locala.nxq.mediaId);
                          c.b.this.l(locala.nxq.mediaId, locala.nxq.path, true);
                        }
                        i += 1;
                        break;
                        str1 = locala.nxq.mediaId;
                        break label93;
                      }
                    }
                    c.b.this.ntG.offer(c.b.this.ntQ);
                    AppMethodBeat.o(21238);
                  }
                });
                AppMethodBeat.o(21239);
              }
            };
            new l(c.b.this.talker, c.b.this.ntM, local1).bIJ();
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
      this.ntQ = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21244);
          Assert.assertTrue(toString() + ", check running. ", c.b.this.kbJ);
          final boolean bool1;
          switch (com.tencent.mm.plugin.backup.b.d.bHa())
          {
          default: 
            if (c.b.this.nsW == c.this.ntw.bGX().nsL - 1)
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
            Object localObject = new am(bool2);
            f local1 = new f()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(21242);
                paramAnonymous2n = ((aa)((com.tencent.mm.plugin.backup.g.d)paramAnonymous2n).nzq).nEs;
                ad.i(c.b.this.TAG, "Send Tag finish last:%b  cv:%s [%d,%d,%s] tag[%s,%s]", new Object[] { Boolean.valueOf(bool1), this.ntZ, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, c.b.this.ntJ, paramAnonymous2n });
                if ((bool1) && (c.b.this.ntJ.equals(paramAnonymous2n))) {
                  this.ntZ.open();
                }
                AppMethodBeat.o(21242);
              }
            };
            new com.tencent.mm.plugin.backup.g.d(c.b.this.talker, c.b.this.nsY, c.b.this.nsZ, c.b.this.ntJ, c.b.this.bVF, new LinkedList(c.b.this.ntK), local1).bIJ();
            if (bool1)
            {
              ad.w(c.b.this.TAG, "sendTag last Session :[%d/%d] wait tag resp callback .", new Object[] { Integer.valueOf(c.b.this.nsW), Integer.valueOf(c.this.ntw.bGX().nsL - 1) });
              ((am)localObject).block();
            }
            c.b.this.kbJ = false;
            AppMethodBeat.o(21244);
            return;
            ad.i(c.b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[] { Integer.valueOf(c.this.ntw.bGX().nsK), Long.valueOf(c.b.this.nsY), Long.valueOf(c.b.this.nsZ), Integer.valueOf(c.b.this.ntK.size()), c.b.this.bVF, c.b.this.ntJ, Long.valueOf(bt.Df(c.b.this.ntN)) });
            if (c.this.ntw.bGX().nsK >= c.b.this.nsW + 1) {
              break;
            }
            int i = c.this.ntw.bGX().nsL;
            localObject = c.this.ntw.bGX();
            if (c.b.this.nsW + 1 > i) {}
            for (;;)
            {
              ((e)localObject).nsK = i;
              c.this.ntv.xp(c.this.ntw.bGX().nsJ);
              break;
              i = c.b.this.nsW + 1;
            }
            ad.i(c.b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[] { Integer.valueOf(c.this.ntw.bGX().nsK), Long.valueOf(c.b.this.nsY), Long.valueOf(c.b.this.nsZ), Integer.valueOf(c.b.this.ntK.size()), c.b.this.bVF, c.b.this.ntJ, Long.valueOf(bt.Df(c.b.this.ntN)) });
            if (c.this.ntw.bGX().nsK >= c.b.this.nsW + 1) {
              break;
            }
            i = c.this.ntw.bGX().nsL;
            localObject = c.this.ntw.bGX();
            if (c.b.this.nsW + 1 > i) {}
            for (;;)
            {
              ((e)localObject).nsK = i;
              c.this.ntv.xp(c.this.ntw.bGX().nsJ);
              break;
              i = c.b.this.nsW + 1;
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
      this.ntN = bt.flT();
      this.ntH = parama;
      this.talker = parama1.nsV;
      this.nsW = parama1.nsW;
      if (w.vF(this.talker))
      {
        this$1 = v.getDisplayName(this.talker, this.talker);
        this.bVF = c.this;
        parama = new StringBuilder("MicroMsg.BackupPackAndSend.tag.");
        if (!this.kbJ) {
          break label299;
        }
      }
      label299:
      for (this$1 = "S.";; this$1 = "W.")
      {
        this.TAG = (c.this + this.nsW + "." + this.bVF);
        ad.i(this.TAG, "initTagNow [%d,%s,%s] [%s]", new Object[] { Integer.valueOf(this.nsW), this.bVF, this.talker, at.fkV() });
        AppMethodBeat.o(21245);
        return;
        this$1 = v.zf(this.talker);
        break;
      }
    }
    
    public final boolean a(if paramif, long paramLong1, long paramLong2, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap)
    {
      AppMethodBeat.i(21246);
      this.ntL.add(paramif);
      long l2 = this.ntI;
      if (paramLong1 > 0L) {}
      for (long l1 = paramLong1;; l1 = 0L)
      {
        this.ntI = (l1 + l2);
        if (this.nsY == 0L) {
          this.nsY = paramLong2;
        }
        this.nsZ = paramLong2;
        this.ntM.putAll(paramHashMap);
        paramif = paramLinkedList.iterator();
        while (paramif.hasNext())
        {
          paramHashMap = (u)paramif.next();
          l(paramHashMap.mediaId, paramHashMap.path, false);
        }
      }
      ad.i(this.TAG, "addToTag msgtime[%d,%d] size[%d,%d] baklist:%d media:%d timeDiff:%d", new Object[] { Long.valueOf(this.nsY), Long.valueOf(this.nsZ), Long.valueOf(paramLong1), Long.valueOf(this.ntI), Integer.valueOf(this.ntL.size()), Integer.valueOf(paramLinkedList.size()), Long.valueOf(bt.Df(this.ntN)) });
      if ((this.ntI > 83886080L) || (this.ntL.size() > 80))
      {
        bHr();
        AppMethodBeat.o(21246);
        return true;
      }
      AppMethodBeat.o(21246);
      return false;
    }
    
    public final void bHr()
    {
      AppMethodBeat.i(21247);
      this.ntJ = ("MSG_" + this.ntL.size() + "_" + this.talker + "_" + bt.flT());
      ad.i(this.TAG, "setTagEnd msgtime[%d,%d], size:%d baklist:%d bigfile:%d id:%s timeDiff:%d", new Object[] { Long.valueOf(this.nsY), Long.valueOf(this.nsZ), Long.valueOf(this.ntI), Integer.valueOf(this.ntL.size()), Integer.valueOf(this.ntM.size()), this.ntJ, Long.valueOf(bt.Df(this.ntN)) });
      if (this.ntL.size() > 0)
      {
        l(this.ntJ, null, false);
        if (this.ntM.isEmpty())
        {
          this.ntG.offer(this.ntQ);
          AppMethodBeat.o(21247);
          return;
        }
        this.ntG.offer(this.ntP);
        AppMethodBeat.o(21247);
        return;
      }
      ad.w(this.TAG, "setTagEnd NoFileSend, Go Send Tag: Direct. baklist:%d media:%d bigFileMap:%d ", new Object[] { Integer.valueOf(this.ntL.size()), Integer.valueOf(this.ntK.size()), Integer.valueOf(this.ntM.size()) });
      Assert.assertTrue("cursorEnd NOMsg, chatMsgList should empty", this.ntL.isEmpty());
      Assert.assertTrue("cursorEnd NOMsg, MediaList should empty", this.ntK.isEmpty());
      Assert.assertTrue("cursorEnd NOMsg, BigFileList should empty", this.ntM.isEmpty());
      this.ntG.offer(this.ntQ);
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
          final long l2 = bt.flT();
          c.a locala = c.b.this.ntH;
          long l3 = paramAnonymousc.bIQ();
          boolean bool3 = c.b.this.kbJ;
          long l1 = locala.ntD.get();
          boolean bool1;
          label81:
          long l4;
          if (locala.ntD.get() >= 8388608L)
          {
            bool1 = true;
            if (locala.ntD.get() < 16777216L) {
              break label379;
            }
            bool2 = true;
            ad.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid %b inSize:%d sum:%d  [%b,%b]", new Object[] { Boolean.valueOf(bool3), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if (locala.ntD.get() + l3 >= 8388608L) {
              locala.ntE.close();
            }
            if (locala.ntD.get() >= 16777216L) {
              locala.ntF.close();
            }
            l4 = bt.flT();
            if (!locala.ntC.ntu)
            {
              long l5 = locala.ntD.get();
              if (!bool3) {
                break label385;
              }
              l1 = 16777216L;
              label215:
              if (l5 >= l1) {
                break label404;
              }
              locala.ntD.addAndGet(l3);
              l1 = bt.Df(l4);
              l4 = locala.ntD.get();
              if (locala.ntD.get() < 8388608L) {
                break label392;
              }
              bool1 = true;
              label267:
              if (locala.ntD.get() < 16777216L) {
                break label398;
              }
            }
          }
          label385:
          label392:
          label398:
          for (boolean bool2 = true;; bool2 = false)
          {
            ad.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid Out:%d %b inSize:%d sum:%d  [%b,%b]", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool3), Long.valueOf(l3), Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            c.b.this.ntG.offer(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(21236);
                Assert.assertTrue(toString() + ", check running. ", c.b.this.kbJ);
                long l1 = bt.flT();
                paramAnonymousc.bIJ();
                long l2 = bt.flT();
                ad.i(c.b.this.TAG, "SendFileScene size:%d waitTime:%d netTime:%d [%s]", new Object[] { Integer.valueOf(paramAnonymousc.bIQ()), Long.valueOf(l2 - l2), Long.valueOf(l2 - l1), paramAnonymousc.nzh.nEj });
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
          for (am localam = locala.ntF;; localam = locala.ntE)
          {
            localam.fkQ();
            break;
          }
        }
      };
      ad.i(this.TAG, "postSendFile isBigFile[%b], baklst:%d Id:%s path:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.ntL.size()), paramString1, paramString2 });
      if (!TextUtils.isEmpty(paramString2))
      {
        this.ntK.add(paramString1);
        if (paramString1 != null)
        {
          com.tencent.mm.plugin.backup.g.c.a(this.ntO, local2, paramString1, paramString2, c.this.ntw.nsH);
          AppMethodBeat.o(21248);
        }
      }
      else
      {
        if (this.ntL.isEmpty()) {
          break label171;
        }
      }
      label171:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        Assert.assertTrue("chatMsgList should not empty", paramBoolean);
        if (paramString1 != null) {
          com.tencent.mm.plugin.backup.g.c.a(this.ntO, local2, paramString1, new LinkedList(this.ntL), c.this.ntw.nsH);
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
    c.a ntH;
    LinkedBlockingQueue<Object> nub;
    am nuc;
    c.b nud;
    private Runnable nue;
    
    public c()
    {
      AppMethodBeat.i(21250);
      this.nub = new LinkedBlockingQueue();
      this.ntH = new c.a(c.this, (byte)0);
      this.nuc = new am();
      this.nud = null;
      this.nue = new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "tagRunnable";
        }
        
        public final void run()
        {
          AppMethodBeat.i(21249);
          while (!c.this.ntu)
          {
            Object localObject1 = null;
            label273:
            try
            {
              localObject2 = c.c.this.nub.poll(500L, TimeUnit.MILLISECONDS);
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
            ad.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "TagQueue(%d)startNext obj:%s", new Object[] { Integer.valueOf(c.c.this.nub.size()), localObject1 });
            if (localObject1 != null)
            {
              if (localObject1 == c.c.this.nuc)
              {
                c.c.this.nuc.open();
                AppMethodBeat.o(21249);
                return;
              }
              localb = (c.b)localObject1;
              localb.kbJ = true;
              localObject2 = new StringBuilder("MicroMsg.BackupPackAndSend.tag");
              if (localb.kbJ)
              {
                localObject1 = "S.";
                localb.TAG = ((String)localObject1 + localb.nsW + "." + localb.bVF);
                while (!c.this.ntu)
                {
                  localObject1 = null;
                  try
                  {
                    localObject2 = (Runnable)localb.ntG.poll(500L, TimeUnit.MILLISECONDS);
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
                    l1 = bt.flT();
                    ((Runnable)localObject1).run();
                    k = localb.ntG.size();
                    l2 = c.c.this.ntH.ntD.get();
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
                ad.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "workerQueue poll q:%d mem:%s rt:%d [%s,%s,%s]", new Object[] { Integer.valueOf(k), String.format("[%s,%s,%s]", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j) }), Long.valueOf(bt.Df(l1)), localObject1, localb, c.c.this.nud });
                if (localb.kbJ) {
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
      com.tencent.e.h.LTJ.aU(this.nue);
      AppMethodBeat.o(21250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c
 * JD-Core Version:    0.7.0.1
 */