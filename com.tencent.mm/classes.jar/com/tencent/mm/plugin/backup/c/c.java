package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.a;
import com.tencent.mm.plugin.backup.f.h.a;
import com.tencent.mm.plugin.backup.g.l;
import com.tencent.mm.plugin.backup.g.l.a;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.is;
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
  private int oIY;
  public boolean oJN = false;
  b.b oJO;
  com.tencent.mm.plugin.backup.b.d oJP;
  long oJQ = 0L;
  public long oJR = 0L;
  
  public c(com.tencent.mm.plugin.backup.b.d paramd, int paramInt, b.b paramb)
  {
    this.oJP = paramd;
    this.oIY = paramInt;
    this.oJO = paramb;
    this.oJN = false;
  }
  
  public final void a(final LinkedList<f.a> paramLinkedList, final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(21254);
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      Log.i("MicroMsg.BackupPackAndSend", "startBackup, backupSessionList size[%d], bigFileSize[%d], isOnlyText[%b]", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
      paramLinkedList = new com.tencent.f.i.h()
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
            if (c.this.oJO != null)
            {
              c.this.oJO.ceJ();
              c.this.oJP.ceM().oJc = -21;
              c.this.oJO.Ba(-21);
            }
            AppMethodBeat.o(21232);
            return;
          }
          com.tencent.mm.plugin.backup.g.b.cgu();
          Object localObject2 = paramLinkedList;
          Object localObject1 = new HashSet();
          if (localObject2 == null) {}
          for (int i = 0;; i = ((HashSet)localObject1).size())
          {
            c.this.oJP.ceM().S(14, 1, i);
            c.this.oJO.Ba(14);
            localObject1 = (String)com.tencent.mm.plugin.backup.h.d.cgP().cgQ().azQ().get(2, null);
            c.this.oJR = Util.nowMilliSecond();
            localObject2 = new c.c(c.this);
            Iterator localIterator = paramLinkedList.iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              f.a locala = (f.a)localIterator.next();
              c.this.a(locala, (c.c)localObject2, (String)localObject1, paramLong, this.oJU);
            } while (!c.this.oJN);
            if (!c.this.oJN) {
              break;
            }
            Log.e("MicroMsg.BackupPackAndSend", "backupChatRunnable cancel!");
            AppMethodBeat.o(21232);
            return;
            localObject2 = ((LinkedList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((HashSet)localObject1).add(((f.a)((Iterator)localObject2).next()).oJo);
            }
          }
          long l1 = Util.nowMilliSecond();
          long l2 = Util.nowMilliSecond();
          ((c.c)localObject2).oKu.offer(((c.c)localObject2).oKv);
          ((c.c)localObject2).oKv.block();
          Log.i("MicroMsg.BackupPackAndSend.TagQueueSucker", "waitFinish Finish Now:%d", new Object[] { Long.valueOf(Util.milliSecondsToNow(l2)) });
          Assert.assertTrue(((c.c)localObject2).oKu.isEmpty());
          Log.i("MicroMsg.BackupPackAndSend", "backupChatRunnable finish, Session[%d], loopTime[%d], waitSendTime[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(Util.milliSecondsToNow(c.this.oJR)), Long.valueOf(Util.milliSecondsToNow(l1)) });
          c.this.cff();
          c.this.oJP.ceM().S(15, i, i);
          c.this.oJO.Ba(15);
          c.this.jy(true);
          com.tencent.mm.plugin.backup.g.b.cgt();
          com.tencent.mm.plugin.backup.g.b.cgv();
          c.this.oJO.ceI();
          Log.i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupfinish, backupDataSize[%d], backupCostTime[%d], backupStartTime[%d]", new Object[] { Long.valueOf(c.this.oJQ), Long.valueOf(Util.milliSecondsToNow(c.this.oJR)), Long.valueOf(c.this.oJR) });
          AppMethodBeat.o(21232);
        }
      };
      com.tencent.f.h.RTc.ba(paramLinkedList);
      AppMethodBeat.o(21254);
      return;
    }
  }
  
  final boolean a(f.a parama, c paramc, String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(21255);
    Object localObject1 = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aST().bjY(parama.oJo);
    int i;
    long l5;
    int k;
    long l1;
    long l2;
    int j;
    if (localObject1 != null)
    {
      i = ((bb)localObject1).field_unReadCount;
      Log.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg index[%d], sessionName[%s], startTime[%d], endTime[%d], unReadCount[%d]", new Object[] { Integer.valueOf(parama.oJp), parama.oJo, Long.valueOf(parama.startTime), Long.valueOf(parama.endTime), Integer.valueOf(i) });
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
      Object localObject2 = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aSQ().c(parama.oJo, parama.startTime, parama.endTime, i);
      Object localObject3;
      for (;;)
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break label334;
        }
        k = i + 1;
        if (this.oJN)
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
            localObject1 = ((com.tencent.mm.plugin.patmsg.a.b)g.af(com.tencent.mm.plugin.patmsg.a.b.class)).HE(((eo)localObject3).field_msgId);
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
        if (this.oJN)
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
              Log.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((LinkedList)localObject3).size()), Long.valueOf(localPLong.value), Integer.valueOf(localHashMap.size()), Long.valueOf(((eo)localObject4).field_msgSvrId), Integer.valueOf(((ca)localObject4).getType()), Long.valueOf(((eo)localObject4).field_createTime), ((eo)localObject4).field_talker });
              l3 = l1;
              m = j;
              if (localObject1 != null)
              {
                m = j - 1;
                l3 = Util.nowMilliSecond();
                long l6 = localPLong.value;
                long l7 = ((eo)localObject4).field_createTime;
                if (paramc.oKw == null)
                {
                  localObject2 = paramc.oKu;
                  localObject4 = new b(paramc.oJV, paramc.oKa, parama);
                  paramc.oKw = ((b)localObject4);
                  ((LinkedBlockingQueue)localObject2).offer(localObject4);
                }
                if (paramc.oKw.a((is)localObject1, l6, l7, (LinkedList)localObject3, localHashMap)) {
                  paramc.oKw = null;
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
    if (paramc.oKw == null)
    {
      paramString = paramc.oKu;
      localObject1 = new b(paramc.oJV, paramc.oKa, parama);
      paramc.oKw = ((b)localObject1);
      paramString.offer(localObject1);
    }
    paramc.oKw.cfg();
    paramc.oKw = null;
    long l3 = Util.nowMilliSecond();
    Log.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg finish Cursor Session[%d], convName[%s], msgCnt[%d], time[%d], [%d,%d,%d]", new Object[] { Integer.valueOf(parama.oJp), parama.oJo, Integer.valueOf(i), Long.valueOf(Util.milliSecondsToNow(l5)), Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l1 - paramLong + l3) });
    AppMethodBeat.o(21255);
    return true;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21251);
    Log.e("MicroMsg.BackupPackAndSend", "cancel, caller:%s", new Object[] { MMStack.getCaller() });
    this.oJN = true;
    AppMethodBeat.o(21251);
  }
  
  public final long cfe()
  {
    return this.oJQ / 1024L;
  }
  
  public final void cff()
  {
    AppMethodBeat.i(21253);
    Log.i("MicroMsg.BackupPackAndSend", "backupSendFinishRequest.");
    com.tencent.mm.plugin.backup.i.d locald = new com.tencent.mm.plugin.backup.i.d();
    locald.ID = this.oJP.oIU;
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
  
  public final void jy(boolean paramBoolean)
  {
    AppMethodBeat.i(21252);
    Log.i("MicroMsg.BackupPackAndSend", "clearContinueBackupData.");
    SharedPreferences.Editor localEditor;
    if (this.oIY == 1)
    {
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NZC, Boolean.FALSE);
      localEditor = com.tencent.mm.plugin.backup.b.d.ceR().edit();
      localEditor.putString("BACKUP_PC_CHOOSE_SESSION", null);
      if (paramBoolean)
      {
        if (this.oIY != 1) {
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
      if (this.oIY != 2) {
        break;
      }
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NZF, Boolean.FALSE);
      break;
      label155:
      if (this.oIY == 2)
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
    volatile AtomicLong oJW;
    MMConditionVariable oJX;
    MMConditionVariable oJY;
    
    private a()
    {
      AppMethodBeat.i(21233);
      this.oJW = new AtomicLong(0L);
      this.oJX = new MMConditionVariable(true);
      this.oJY = new MMConditionVariable(true);
      AppMethodBeat.o(21233);
    }
  }
  
  final class b
  {
    String TAG;
    boolean liJ;
    String nickName;
    LinkedBlockingQueue<Runnable> oJZ;
    int oJp;
    long oJr;
    long oJs;
    c.a oKa;
    private long oKb;
    String oKc;
    Vector<String> oKd;
    private Vector<is> oKe;
    HashMap<Long, h.a> oKf;
    long oKg;
    private final com.tencent.mm.plugin.backup.g.c.b oKh;
    private final Runnable oKi;
    final Runnable oKj;
    String talker;
    
    public b(c.a parama, f.a parama1)
    {
      AppMethodBeat.i(21245);
      this.TAG = "";
      this.oJZ = new LinkedBlockingQueue();
      this.oJr = 0L;
      this.oJs = 0L;
      this.oKb = 0L;
      this.oKc = "";
      this.oKd = new Vector();
      this.oKe = new Vector();
      this.oKf = new HashMap();
      this.oKg = 0L;
      this.liJ = false;
      this.oKh = new com.tencent.mm.plugin.backup.g.c.b()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(21234);
          c.a locala = c.b.this.oKa;
          long l1 = paramAnonymousInt;
          locala.oJW.addAndGet(0L - l1);
          if (locala.oJW.get() < 8388608L) {
            locala.oJX.open();
          }
          if (locala.oJW.get() < 16777216L) {
            locala.oJY.open();
          }
          long l2 = locala.oJW.get();
          boolean bool1;
          if (locala.oJW.get() >= 8388608L)
          {
            bool1 = true;
            if (locala.oJW.get() < 16777216L) {
              break label266;
            }
          }
          label266:
          for (boolean bool2 = true;; bool2 = false)
          {
            Log.v("MicroMsg.BackupPackAndSend", "MemoryChecker.release size:%d sum:%d [%b,%b] [%b,%b]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(locala.oJX.isOpen()), Boolean.valueOf(locala.oJY.isOpen()) });
            c.this.oJQ += paramAnonymousInt;
            Log.i(c.b.this.TAG, "OnfinishIdCallback size[%d], isIdFinish[%b], id[%s] ", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
            AppMethodBeat.o(21234);
            return;
            bool1 = false;
            break;
          }
        }
      };
      this.oKi = new Runnable()
      {
        public final void run()
        {
          boolean bool = true;
          AppMethodBeat.i(21241);
          Assert.assertTrue(toString() + ", check running. ", c.b.this.liJ);
          Log.i(c.b.this.TAG, "requestBigFileList svrIdCnt:%d timeDiff:%d caller:%s", new Object[] { Integer.valueOf(c.b.this.oKf.size()), Long.valueOf(Util.milliSecondsToNow(c.b.this.oKg)), MMStack.getCaller() });
          if (!c.b.this.oKf.isEmpty()) {}
          for (;;)
          {
            Assert.assertTrue("BigFileMap should not Empty", bool);
            l.a local1 = new l.a()
            {
              public final void E(final LinkedList<Long> paramAnonymous2LinkedList)
              {
                AppMethodBeat.i(21239);
                com.tencent.f.h.RTc.ba(new com.tencent.f.i.h()
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
                      h.a locala = (h.a)c.b.this.oKf.get(localLong);
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
                      for (String str2 = "null";; str2 = locala.oNI.path)
                      {
                        Log.i(str3, "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d media:%s item:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localLong, str1, str2 });
                        if (locala != null)
                        {
                          c.b.this.oKd.add(locala.oNI.mediaId);
                          c.b.this.m(locala.oNI.mediaId, locala.oNI.path, true);
                        }
                        i += 1;
                        break;
                        str1 = locala.oNI.mediaId;
                        break label93;
                      }
                    }
                    c.b.this.oJZ.offer(c.b.this.oKj);
                    AppMethodBeat.o(21238);
                  }
                });
                AppMethodBeat.o(21239);
              }
            };
            new l(c.b.this.talker, c.b.this.oKf, local1).cgA();
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
      this.oKj = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21244);
          Assert.assertTrue(toString() + ", check running. ", c.b.this.liJ);
          final boolean bool1;
          switch (com.tencent.mm.plugin.backup.b.d.ceP())
          {
          default: 
            if (c.b.this.oJp == c.this.oJP.ceM().oJe - 1)
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
            com.tencent.mm.ak.i local1 = new com.tencent.mm.ak.i()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
              {
                AppMethodBeat.i(21242);
                paramAnonymous2q = ((com.tencent.mm.plugin.backup.i.aa)((com.tencent.mm.plugin.backup.g.d)paramAnonymous2q).oPI).oUI;
                Log.i(c.b.this.TAG, "Send Tag finish last:%b  cv:%s [%d,%d,%s] tag[%s,%s]", new Object[] { Boolean.valueOf(bool1), this.oKs, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, c.b.this.oKc, paramAnonymous2q });
                if ((bool1) && (c.b.this.oKc.equals(paramAnonymous2q))) {
                  this.oKs.open();
                }
                AppMethodBeat.o(21242);
              }
            };
            new com.tencent.mm.plugin.backup.g.d(c.b.this.talker, c.b.this.oJr, c.b.this.oJs, c.b.this.oKc, c.b.this.nickName, new LinkedList(c.b.this.oKd), local1).cgA();
            if (bool1)
            {
              Log.w(c.b.this.TAG, "sendTag last Session :[%d/%d] wait tag resp callback .", new Object[] { Integer.valueOf(c.b.this.oJp), Integer.valueOf(c.this.oJP.ceM().oJe - 1) });
              ((MMConditionVariable)localObject).block();
            }
            c.b.this.liJ = false;
            AppMethodBeat.o(21244);
            return;
            Log.i(c.b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[] { Integer.valueOf(c.this.oJP.ceM().oJd), Long.valueOf(c.b.this.oJr), Long.valueOf(c.b.this.oJs), Integer.valueOf(c.b.this.oKd.size()), c.b.this.nickName, c.b.this.oKc, Long.valueOf(Util.milliSecondsToNow(c.b.this.oKg)) });
            if (c.this.oJP.ceM().oJd >= c.b.this.oJp + 1) {
              break;
            }
            int i = c.this.oJP.ceM().oJe;
            localObject = c.this.oJP.ceM();
            if (c.b.this.oJp + 1 > i) {}
            for (;;)
            {
              ((e)localObject).oJd = i;
              c.this.oJO.Ba(c.this.oJP.ceM().oJc);
              break;
              i = c.b.this.oJp + 1;
            }
            Log.i(c.b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[] { Integer.valueOf(c.this.oJP.ceM().oJd), Long.valueOf(c.b.this.oJr), Long.valueOf(c.b.this.oJs), Integer.valueOf(c.b.this.oKd.size()), c.b.this.nickName, c.b.this.oKc, Long.valueOf(Util.milliSecondsToNow(c.b.this.oKg)) });
            if (c.this.oJP.ceM().oJd >= c.b.this.oJp + 1) {
              break;
            }
            i = c.this.oJP.ceM().oJe;
            localObject = c.this.oJP.ceM();
            if (c.b.this.oJp + 1 > i) {}
            for (;;)
            {
              ((e)localObject).oJd = i;
              c.this.oJO.Ba(c.this.oJP.ceM().oJc);
              break;
              i = c.b.this.oJp + 1;
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
      this.oKg = Util.nowMilliSecond();
      this.oKa = parama;
      this.talker = parama1.oJo;
      this.oJp = parama1.oJp;
      if (ab.Eq(this.talker))
      {
        this$1 = com.tencent.mm.model.aa.getDisplayName(this.talker, this.talker);
        this.nickName = c.this;
        parama = new StringBuilder("MicroMsg.BackupPackAndSend.tag.");
        if (!this.liJ) {
          break label299;
        }
      }
      label299:
      for (this$1 = "S.";; this$1 = "W.")
      {
        this.TAG = (c.this + this.oJp + "." + this.nickName);
        Log.i(this.TAG, "initTagNow [%d,%s,%s] [%s]", new Object[] { Integer.valueOf(this.oJp), this.nickName, this.talker, MMStack.getCaller() });
        AppMethodBeat.o(21245);
        return;
        this$1 = com.tencent.mm.model.aa.getDisplayName(this.talker);
        break;
      }
    }
    
    public final boolean a(is paramis, long paramLong1, long paramLong2, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap)
    {
      AppMethodBeat.i(21246);
      this.oKe.add(paramis);
      long l2 = this.oKb;
      if (paramLong1 > 0L) {}
      for (long l1 = paramLong1;; l1 = 0L)
      {
        this.oKb = (l1 + l2);
        if (this.oJr == 0L) {
          this.oJr = paramLong2;
        }
        this.oJs = paramLong2;
        this.oKf.putAll(paramHashMap);
        paramis = paramLinkedList.iterator();
        while (paramis.hasNext())
        {
          paramHashMap = (u)paramis.next();
          m(paramHashMap.mediaId, paramHashMap.path, false);
        }
      }
      Log.i(this.TAG, "addToTag msgtime[%d,%d] size[%d,%d] baklist:%d media:%d timeDiff:%d", new Object[] { Long.valueOf(this.oJr), Long.valueOf(this.oJs), Long.valueOf(paramLong1), Long.valueOf(this.oKb), Integer.valueOf(this.oKe.size()), Integer.valueOf(paramLinkedList.size()), Long.valueOf(Util.milliSecondsToNow(this.oKg)) });
      if ((this.oKb > 83886080L) || (this.oKe.size() > 80))
      {
        cfg();
        AppMethodBeat.o(21246);
        return true;
      }
      AppMethodBeat.o(21246);
      return false;
    }
    
    public final void cfg()
    {
      AppMethodBeat.i(21247);
      this.oKc = ("MSG_" + this.oKe.size() + "_" + this.talker + "_" + Util.nowMilliSecond());
      Log.i(this.TAG, "setTagEnd msgtime[%d,%d], size:%d baklist:%d bigfile:%d id:%s timeDiff:%d", new Object[] { Long.valueOf(this.oJr), Long.valueOf(this.oJs), Long.valueOf(this.oKb), Integer.valueOf(this.oKe.size()), Integer.valueOf(this.oKf.size()), this.oKc, Long.valueOf(Util.milliSecondsToNow(this.oKg)) });
      if (this.oKe.size() > 0)
      {
        m(this.oKc, null, false);
        if (this.oKf.isEmpty())
        {
          this.oJZ.offer(this.oKj);
          AppMethodBeat.o(21247);
          return;
        }
        this.oJZ.offer(this.oKi);
        AppMethodBeat.o(21247);
        return;
      }
      Log.w(this.TAG, "setTagEnd NoFileSend, Go Send Tag: Direct. baklist:%d media:%d bigFileMap:%d ", new Object[] { Integer.valueOf(this.oKe.size()), Integer.valueOf(this.oKd.size()), Integer.valueOf(this.oKf.size()) });
      Assert.assertTrue("cursorEnd NOMsg, chatMsgList should empty", this.oKe.isEmpty());
      Assert.assertTrue("cursorEnd NOMsg, MediaList should empty", this.oKd.isEmpty());
      Assert.assertTrue("cursorEnd NOMsg, BigFileList should empty", this.oKf.isEmpty());
      this.oJZ.offer(this.oKj);
      AppMethodBeat.o(21247);
    }
    
    final void m(String paramString1, String paramString2, boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(21248);
      com.tencent.mm.plugin.backup.g.c.c local2 = new com.tencent.mm.plugin.backup.g.c.c()
      {
        public final void a(final com.tencent.mm.plugin.backup.g.c paramAnonymousc)
        {
          AppMethodBeat.i(21237);
          final long l2 = Util.nowMilliSecond();
          c.a locala = c.b.this.oKa;
          long l3 = paramAnonymousc.cgH();
          boolean bool3 = c.b.this.liJ;
          long l1 = locala.oJW.get();
          boolean bool1;
          label81:
          long l4;
          if (locala.oJW.get() >= 8388608L)
          {
            bool1 = true;
            if (locala.oJW.get() < 16777216L) {
              break label379;
            }
            bool2 = true;
            Log.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid %b inSize:%d sum:%d  [%b,%b]", new Object[] { Boolean.valueOf(bool3), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if (locala.oJW.get() + l3 >= 8388608L) {
              locala.oJX.close();
            }
            if (locala.oJW.get() >= 16777216L) {
              locala.oJY.close();
            }
            l4 = Util.nowMilliSecond();
            if (!locala.oJV.oJN)
            {
              long l5 = locala.oJW.get();
              if (!bool3) {
                break label385;
              }
              l1 = 16777216L;
              label215:
              if (l5 >= l1) {
                break label404;
              }
              locala.oJW.addAndGet(l3);
              l1 = Util.milliSecondsToNow(l4);
              l4 = locala.oJW.get();
              if (locala.oJW.get() < 8388608L) {
                break label392;
              }
              bool1 = true;
              label267:
              if (locala.oJW.get() < 16777216L) {
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
            c.b.this.oJZ.offer(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(21236);
                Assert.assertTrue(toString() + ", check running. ", c.b.this.liJ);
                long l1 = Util.nowMilliSecond();
                paramAnonymousc.cgA();
                long l2 = Util.nowMilliSecond();
                Log.i(c.b.this.TAG, "SendFileScene size:%d waitTime:%d netTime:%d [%s]", new Object[] { Integer.valueOf(paramAnonymousc.cgH()), Long.valueOf(l2 - l2), Long.valueOf(l2 - l1), paramAnonymousc.oPz.oUz });
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
          for (MMConditionVariable localMMConditionVariable = locala.oJY;; localMMConditionVariable = locala.oJX)
          {
            localMMConditionVariable.block(500L);
            break;
          }
        }
      };
      Log.i(this.TAG, "postSendFile isBigFile[%b], baklst:%d Id:%s path:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.oKe.size()), paramString1, paramString2 });
      if (!TextUtils.isEmpty(paramString2))
      {
        this.oKd.add(paramString1);
        if (paramString1 != null)
        {
          com.tencent.mm.plugin.backup.g.c.a(this.oKh, local2, paramString1, paramString2, c.this.oJP.oJa);
          AppMethodBeat.o(21248);
        }
      }
      else
      {
        if (this.oKe.isEmpty()) {
          break label171;
        }
      }
      label171:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        Assert.assertTrue("chatMsgList should not empty", paramBoolean);
        if (paramString1 != null) {
          com.tencent.mm.plugin.backup.g.c.a(this.oKh, local2, paramString1, new LinkedList(this.oKe), c.this.oJP.oJa);
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
    c.a oKa;
    LinkedBlockingQueue<Object> oKu;
    MMConditionVariable oKv;
    c.b oKw;
    private Runnable oKx;
    
    public c()
    {
      AppMethodBeat.i(21250);
      this.oKu = new LinkedBlockingQueue();
      this.oKa = new c.a(c.this, (byte)0);
      this.oKv = new MMConditionVariable();
      this.oKw = null;
      this.oKx = new com.tencent.f.i.h()
      {
        public final String getKey()
        {
          return "tagRunnable";
        }
        
        public final void run()
        {
          AppMethodBeat.i(21249);
          while (!c.this.oJN)
          {
            Object localObject1 = null;
            label273:
            try
            {
              localObject2 = c.c.this.oKu.poll(500L, TimeUnit.MILLISECONDS);
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
            Log.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "TagQueue(%d)startNext obj:%s", new Object[] { Integer.valueOf(c.c.this.oKu.size()), localObject1 });
            if (localObject1 != null)
            {
              if (localObject1 == c.c.this.oKv)
              {
                c.c.this.oKv.open();
                AppMethodBeat.o(21249);
                return;
              }
              localb = (c.b)localObject1;
              localb.liJ = true;
              localObject2 = new StringBuilder("MicroMsg.BackupPackAndSend.tag");
              if (localb.liJ)
              {
                localObject1 = "S.";
                localb.TAG = ((String)localObject1 + localb.oJp + "." + localb.nickName);
                while (!c.this.oJN)
                {
                  localObject1 = null;
                  try
                  {
                    localObject2 = (Runnable)localb.oJZ.poll(500L, TimeUnit.MILLISECONDS);
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
                    k = localb.oJZ.size();
                    l2 = c.c.this.oKa.oJW.get();
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
                Log.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "workerQueue poll q:%d mem:%s rt:%d [%s,%s,%s]", new Object[] { Integer.valueOf(k), String.format("[%s,%s,%s]", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j) }), Long.valueOf(Util.milliSecondsToNow(l1)), localObject1, localb, c.c.this.oKw });
                if (localb.liJ) {
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
      com.tencent.f.h.RTc.ba(this.oKx);
      AppMethodBeat.o(21250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c
 * JD-Core Version:    0.7.0.1
 */