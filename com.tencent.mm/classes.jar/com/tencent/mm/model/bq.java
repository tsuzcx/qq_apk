package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.an.h.d;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.a.cz;
import com.tencent.mm.f.a.nh;
import com.tencent.mm.f.c.et;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class bq
{
  private static volatile boolean lug = false;
  
  public static int A(String paramString, long paramLong)
  {
    AppMethodBeat.i(42965);
    ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL(paramString, paramLong);
    if (localca.field_msgSvrId != paramLong)
    {
      AppMethodBeat.o(42965);
      return 0;
    }
    B(localca);
    int i = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aV(paramString, paramLong);
    AppMethodBeat.o(42965);
    return i;
  }
  
  public static void A(ca paramca)
  {
    AppMethodBeat.i(241062);
    as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca.field_talker);
    if ((localas == null) || ((int)localas.jxt == 0))
    {
      localas = new as(paramca.field_talker);
      localas.setType(2);
      nh localnh = new nh();
      localnh.fLD.fLE = localas;
      EventCenter.instance.publish(localnh);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().av(localas);
    }
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramca.field_msgId, paramca);
    AppMethodBeat.o(241062);
  }
  
  public static void B(ca paramca)
  {
    AppMethodBeat.i(42962);
    if (paramca == null)
    {
      AppMethodBeat.o(42962);
      return;
    }
    Object localObject = h.d.cj(Integer.valueOf(uZ(paramca.getType())));
    if (localObject != null) {
      ((com.tencent.mm.an.h)localObject).b(new h.c(paramca));
    }
    localObject = new cz();
    ((cz)localObject).fyF.msgId = paramca.field_msgId;
    ((cz)localObject).fyF.talker = paramca.field_talker;
    ((cz)localObject).fyF.msgType = paramca.getType();
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(42962);
  }
  
  public static int Gk(long paramLong)
  {
    AppMethodBeat.i(42964);
    ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramLong);
    if (localca.field_msgId != paramLong)
    {
      AppMethodBeat.o(42964);
      return 0;
    }
    B(localca);
    int i = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Or(paramLong);
    AppMethodBeat.o(42964);
    return i;
  }
  
  @Deprecated
  public static int RI(String paramString)
  {
    AppMethodBeat.i(163509);
    int i = RK(paramString);
    AppMethodBeat.o(163509);
    return i;
  }
  
  public static String RJ(String paramString)
  {
    AppMethodBeat.i(42950);
    int i = RK(paramString);
    if (i != -1)
    {
      paramString = paramString.substring(i + 1).trim();
      AppMethodBeat.o(42950);
      return paramString;
    }
    AppMethodBeat.o(42950);
    return paramString;
  }
  
  private static int RK(String paramString)
  {
    AppMethodBeat.i(42952);
    if (paramString == null)
    {
      Log.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos text is null]");
      AppMethodBeat.o(42952);
      return -1;
    }
    if (paramString.length() <= 0)
    {
      Log.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos length < 0]");
      AppMethodBeat.o(42952);
      return -1;
    }
    if (paramString.startsWith("~SEMI_XML~"))
    {
      Log.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos startsWith(SemiXml.MAGIC_HEAD)]");
      AppMethodBeat.o(42952);
      return -1;
    }
    int i = paramString.indexOf(':');
    if ((i != -1) && (paramString.substring(0, i).contains("<")))
    {
      Log.e("MicroMsg.MsgInfoStorageLogic", "dz[reject illegal character]");
      AppMethodBeat.o(42952);
      return -1;
    }
    AppMethodBeat.o(42952);
    return i;
  }
  
  public static String RL(String paramString)
  {
    AppMethodBeat.i(42953);
    int i = RK(paramString);
    if (i == -1)
    {
      AppMethodBeat.o(42953);
      return null;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(42953);
    return paramString;
  }
  
  public static String RM(String paramString)
  {
    AppMethodBeat.i(42954);
    int i = RK(paramString);
    if (i == -1)
    {
      AppMethodBeat.o(42954);
      return paramString;
    }
    if (i + 2 >= paramString.length())
    {
      AppMethodBeat.o(42954);
      return paramString;
    }
    paramString = paramString.substring(i + 2);
    AppMethodBeat.o(42954);
    return paramString;
  }
  
  public static int RN(String paramString)
  {
    AppMethodBeat.i(42957);
    int i = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().RN(paramString);
    AppMethodBeat.o(42957);
    return i;
  }
  
  public static boolean RO(String paramString)
  {
    AppMethodBeat.i(42958);
    boolean bool = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().RO(paramString);
    AppMethodBeat.o(42958);
    return bool;
  }
  
  public static long RP(String paramString)
  {
    AppMethodBeat.i(42960);
    long l = beS();
    Log.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, after fix, now is :%s", new Object[] { Long.valueOf(l) });
    if (paramString != null)
    {
      paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH(paramString);
      if (paramString != null)
      {
        Log.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before return, msg id:%s, now is :%s", new Object[] { Long.valueOf(paramString.field_msgId), Long.valueOf(l) });
        if (paramString.field_createTime + 1L > l)
        {
          l = paramString.field_createTime;
          AppMethodBeat.o(42960);
          return l + 1L;
        }
      }
    }
    AppMethodBeat.o(42960);
    return l;
  }
  
  public static int RQ(String paramString)
  {
    AppMethodBeat.i(42966);
    int i = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOO(paramString);
    AppMethodBeat.o(42966);
    return i;
  }
  
  public static b RR(String paramString)
  {
    AppMethodBeat.i(42971);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42971);
      return null;
    }
    try
    {
      paramString = XmlParser.parseXml(paramString, "msgsource", null);
      if (paramString != null)
      {
        boolean bool = paramString.isEmpty();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(42971);
        return null;
      }
      b localb = new b();
      localb.lup = ((String)paramString.get(".msgsource.bizmsg.msgcluster"));
      localb.lut = ((String)paramString.get(".msgsource.kf.kf_worker"));
      localb.luu = Util.getInt((String)paramString.get(".msgsource.kf.kf_type_new"), 0);
      localb.lus = Util.nullAsNil((String)paramString.get(".msgsource.bizmsg.bizclientmsgid"));
      if (Util.isNullOrNil(localb.lus)) {
        localb.lus = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.climsgid"));
      }
      localb.luz = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.qy_msg_type"));
      localb.luA = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.chat_type"));
      localb.luB = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.bizchat_id"));
      localb.luC = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.bizchat_ver"));
      localb.userId = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.user_id"));
      localb.luD = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.user_nickname"));
      localb.luE = Util.nullAsNil((String)paramString.get(".msgsource.enterprise_info.sync_from_qy_im"));
      localb.luy = ((String)paramString.get(".msgsource.strangerantispamticket.$ticket"));
      localb.scene = Util.getInt((String)paramString.get(".msgsource.strangerantispamticket.$scene"), 0);
      localb.luF = ((String)paramString.get(".msgsource.NotAutoDownloadRange"));
      localb.luG = Util.getInt((String)paramString.get(".msgsource.DownloadLimitKbps"), 0);
      localb.luH = Util.getInt((String)paramString.get(".msgsource.videopreloadlen"), 0);
      localb.luI = Util.getInt((String)paramString.get(".msgsource.PreDownload"), 0);
      localb.luJ = Util.getInt((String)paramString.get(".msgsource.PreDownloadNetType"), 0);
      localb.luK = ((String)paramString.get(".msgsource.NoPreDownloadRange"));
      localb.luq = Util.getInt((String)paramString.get(".msgsource.msg_cluster_type"), -1);
      localb.serviceType = Util.getInt((String)paramString.get(".msgsource.service_type"), -1);
      localb.lur = Util.getInt((String)paramString.get(".msgsource.scene"), -1);
      localb.luv = Util.getInt((String)paramString.get(".msgsource.bizmsg.msg_predict"), 0);
      localb.luw = Util.getLong((String)paramString.get(".msgsource.bizflag"), 0L);
      AppMethodBeat.o(42971);
      return localb;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.MsgInfoStorageLogic", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      Log.e("MicroMsg.MsgInfoStorageLogic", "Exception in getMsgSourceValue, %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(42971);
    }
    return null;
  }
  
  public static String RS(String paramString)
  {
    AppMethodBeat.i(42972);
    paramString = RR(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(42972);
      return null;
    }
    paramString = paramString.lut;
    AppMethodBeat.o(42972);
    return paramString;
  }
  
  public static int a(String paramString, a parama)
  {
    AppMethodBeat.i(42967);
    Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] stack[%s]", new Object[] { paramString, Util.getStack() });
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] is null", new Object[] { paramString });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(42942);
          if (this.lrx != null) {
            this.lrx.asI();
          }
          AppMethodBeat.o(42942);
        }
      });
      AppMethodBeat.o(42967);
      return 0;
    }
    ThreadPool.post(new Runnable()
    {
      final int luh = 200;
      final int lui = 30;
      final int luj = 5;
      int luk = 100;
      
      public final void run()
      {
        AppMethodBeat.i(42943);
        label497:
        for (;;)
        {
          try
          {
            Object localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH(this.jwL);
            long l2;
            long l5;
            long l6;
            long l3;
            if (localObject == null)
            {
              l2 = 9223372036854775807L;
              ((n)com.tencent.mm.kernel.h.ae(n.class)).bco().aJ(this.jwL, l2);
              Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] lastMsg[%s] lastMsgCreateTime[%s]", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), localObject, Long.valueOf(l2) });
              l5 = Util.nowMilliSecond();
              l1 = 0L;
              i = 0;
              if ((this.luk < 200) && (this.luk > 30))
              {
                if (l1 > 500L)
                {
                  j = this.luk - 5;
                  this.luk = j;
                }
              }
              else
              {
                l6 = Util.nowMilliSecond();
                localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().H(this.jwL, this.luk, l2);
                l1 = 0L;
                l3 = 0L;
                if (!((Cursor)localObject).moveToNext()) {
                  continue;
                }
                ca localca = new ca();
                localca.convertFrom((Cursor)localObject);
                if (l1 >= localca.field_createTime) {
                  break label497;
                }
                l1 = localca.field_createTime;
                l3 += 1L;
                bq.B(localca);
                continue;
              }
            }
            else
            {
              l2 = ((et)localObject).field_createTime;
              continue;
            }
            int j = this.luk + 5;
            continue;
            ((Cursor)localObject).close();
            long l7 = Util.nowMilliSecond();
            if ((l1 > 0L) && (l3 > 0L))
            {
              ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aW(this.jwL, l1);
              ((av)com.tencent.mm.kernel.h.ae(av.class)).x(this.jwL, l1);
            }
            int i = (int)(i + l3);
            long l8 = Util.nowMilliSecond();
            long l4 = l8 - l6;
            Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", new Object[] { Util.secPrint(this.jwL), Integer.valueOf(i), Long.valueOf(l3), Long.valueOf(l2 - l1), Long.valueOf(l2), Long.valueOf(l8 - l7), Long.valueOf(l8 - l6), Long.valueOf(l8 - l5), Integer.valueOf(this.luk) });
            long l1 = l4;
            if (l3 <= 0L)
            {
              AppMethodBeat.o(42943);
              return;
            }
          }
          catch (b localb)
          {
            Log.printErrStackTrace("MicroMsg.MsgInfoStorageLogic", localb, "", new Object[0]);
            AppMethodBeat.o(42943);
            return;
          }
        }
      }
    }, "deleteMsgByTalker");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42944);
        if (this.lrx != null) {
          this.lrx.asI();
        }
        AppMethodBeat.o(42944);
      }
    });
    AppMethodBeat.o(42967);
    return 0;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(42968);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42946);
        f.Iyx.idkeyStat(1333L, 0L, 1L, true);
        long l1 = System.currentTimeMillis();
        ((av)com.tencent.mm.kernel.h.ae(av.class)).beq();
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bco().aJ("", this.lum);
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().hyF();
        if (this.lrx != null) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42945);
              bq.5.this.lrx.asI();
              AppMethodBeat.o(42945);
            }
          });
        }
        long l2 = System.currentTimeMillis() - l1;
        Log.i("MicroMsg.MsgInfoStorageLogic", "Delete all messages, synchronized part, time: %d ms", new Object[] { Long.valueOf(l2) });
        f.Iyx.idkeyStat(1333L, 6L, l2 / 1000L, true);
        if ((this.lrx != null) && (this.lrx.asH()))
        {
          AppMethodBeat.o(42946);
          return;
        }
        bq.beV();
        if ((this.lrx != null) && (this.lrx.asH()))
        {
          AppMethodBeat.o(42946);
          return;
        }
        bq.beW();
        if ((this.lrx != null) && (this.lrx.asH()))
        {
          AppMethodBeat.o(42946);
          return;
        }
        bq.beU();
        if ((this.lrx != null) && (this.lrx.asH()))
        {
          AppMethodBeat.o(42946);
          return;
        }
        bq.e(this.lum, 1);
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bco().aJ("", 0L);
        Log.i("MicroMsg.MsgInfoStorageLogic", "Delete all messages, asynchronous part, time: %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1 - l2) });
        AppMethodBeat.o(42946);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(42947);
        String str = super.toString() + "|deleteAllMsg";
        AppMethodBeat.o(42947);
        return str;
      }
    }, "deleteAllMsg");
    AppMethodBeat.o(42968);
  }
  
  public static void a(ca paramca, h.a parama)
  {
    AppMethodBeat.i(42973);
    if ((paramca == null) || (parama == null) || (parama.jQG == null))
    {
      Log.e("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgWithAddMsgInfo error input is null, stack[%s]", new Object[] { Util.getStack() });
      AppMethodBeat.o(42973);
      return;
    }
    if (paramca.field_msgSvrId != parama.jQG.HlH)
    {
      AppMethodBeat.o(42973);
      return;
    }
    db localdb = parama.jQG;
    if ((paramca.field_isSend != 0) && (localdb.RIK == 0))
    {
      AppMethodBeat.o(42973);
      return;
    }
    if ((paramca.field_msgSeq == 0L) && (localdb.RIK != 0)) {
      paramca.EI(localdb.RIK);
    }
    int i = paramca.field_flag;
    if (parama.lCc)
    {
      i |= 0x2;
      if (!parama.lCd) {
        break label201;
      }
      i |= 0x1;
      label146:
      if (!parama.lCe) {
        break label209;
      }
      i |= 0x4;
    }
    for (;;)
    {
      paramca.setFlag(i);
      if ((paramca.field_msgId == 0L) && (parama.lCc)) {
        paramca.setCreateTime(parama.lCf);
      }
      AppMethodBeat.o(42973);
      return;
      i &= 0xFFFFFFFD;
      break;
      label201:
      i &= 0xFFFFFFFE;
      break label146;
      label209:
      i &= 0xFFFFFFFB;
    }
  }
  
  public static int aC(String paramString, int paramInt)
  {
    AppMethodBeat.i(174544);
    Cursor localCursor = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().fe(paramString, paramInt);
    if (localCursor.moveToFirst()) {
      while (!localCursor.isAfterLast())
      {
        ca localca = new ca();
        localca.convertFrom(localCursor);
        B(localca);
        localCursor.moveToNext();
      }
    }
    localCursor.close();
    paramInt = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().fd(paramString, paramInt);
    AppMethodBeat.o(174544);
    return paramInt;
  }
  
  public static String aT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42951);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(42951);
      return null;
    }
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(42951);
      return paramString1;
    }
    paramString1 = paramString2 + ": " + paramString1;
    AppMethodBeat.o(42951);
    return paramString1;
  }
  
  public static void ap(List<Long> paramList)
  {
    AppMethodBeat.i(42963);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(42963);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      Gk(((Long)paramList.next()).longValue());
    }
    AppMethodBeat.o(42963);
  }
  
  public static void aq(List<String> paramList)
  {
    AppMethodBeat.i(174547);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      Log.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers, empty talkers");
      AppMethodBeat.o(174547);
      return;
    }
    Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalkers stack[%s]", new Object[] { Util.getStack() });
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(42948);
        Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] talkers size:%s", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.luo.size()) });
        Iterator localIterator = this.luo.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH(str);
          if (localObject == null) {}
          for (long l1 = 9223372036854775807L;; l1 = ((et)localObject).field_createTime)
          {
            long l3 = cm.bfC();
            long l2 = l1;
            if (l1 > l3)
            {
              Log.w("MicroMsg.MsgInfoStorageLogic", "last message time[%s] is over serverTime[%s]!", new Object[] { Long.valueOf(l1), Long.valueOf(l3) });
              l2 = l3;
            }
            if ((localObject != null) && (((et)localObject).field_createTime > 0L)) {
              ((n)com.tencent.mm.kernel.h.ae(n.class)).bco().aJ(str, l2);
            }
            Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker talker[%s] lastMsg[%s] lastMsgCreateTime[%s]", new Object[] { str, localObject, Long.valueOf(l2) });
            localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOQ(str);
            if (localObject == null) {
              break;
            }
            if (!((Cursor)localObject).moveToFirst()) {
              break label312;
            }
            while (!((Cursor)localObject).isAfterLast())
            {
              ca localca = new ca();
              localca.convertFrom((Cursor)localObject);
              bq.B(localca);
              ((Cursor)localObject).moveToNext();
            }
          }
          label312:
          ((Cursor)localObject).close();
          Log.i("MicroMsg.MsgInfoStorageLogic", "delete msgs %s, %d", new Object[] { str, Integer.valueOf(((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOO(str)) });
          ((n)com.tencent.mm.kernel.h.ae(n.class)).bco().aJ(str, 0L);
        }
        AppMethodBeat.o(42948);
      }
    }, "deleteMsgByTalkers");
    AppMethodBeat.o(174547);
  }
  
  public static String b(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(42975);
    String str = paramString;
    if (paramBoolean)
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = RM(paramString);
        }
      }
    }
    AppMethodBeat.o(42975);
    return str;
  }
  
  public static void beR()
  {
    AppMethodBeat.i(42955);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().beR();
    AppMethodBeat.o(42955);
  }
  
  public static long beS()
  {
    AppMethodBeat.i(42959);
    long l1 = System.currentTimeMillis();
    long l2 = cm.bfD();
    if (Math.abs(l1 - l2) > 300000L) {
      Log.w("MicroMsg.MsgInfoStorageLogic", "[getFixTime] nowServer:" + l2 + " now:" + l1);
    }
    AppMethodBeat.o(42959);
    return l2;
  }
  
  public static int beT()
  {
    AppMethodBeat.i(174543);
    if (lug)
    {
      Log.i("MicroMsg.MsgInfoStorageLogic", "checkUnfinishedDeleteMsgTask already started.");
      AppMethodBeat.o(174543);
      return -1;
    }
    Map localMap = ((n)com.tencent.mm.kernel.h.ae(n.class)).bco().eSh();
    if (localMap.isEmpty())
    {
      Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask all finished!");
      AppMethodBeat.o(174543);
      return 0;
    }
    ThreadPool.post(new Runnable()
    {
      final int luh = 200;
      final int lui = 30;
      final int luj = 5;
      int luk = 100;
      
      public final void run()
      {
        AppMethodBeat.i(42941);
        bq.access$002(true);
        Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask run currentThread[%s, %d] talkers size:%s", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.lul.size()) });
        if (this.lul.containsKey(""))
        {
          bq.e(((Long)this.lul.get("")).longValue(), 2);
          this.lul.remove("");
          ((n)com.tencent.mm.kernel.h.ae(n.class)).bco().aJ("", 0L);
        }
        Iterator localIterator = this.lul.entrySet().iterator();
        Object localObject;
        String str;
        long l4;
        long l5;
        long l1;
        int i;
        while (localIterator.hasNext())
        {
          localObject = (Map.Entry)localIterator.next();
          str = (String)((Map.Entry)localObject).getKey();
          l4 = ((Long)((Map.Entry)localObject).getValue()).longValue();
          if (l4 > 0L)
          {
            l5 = Util.nowMilliSecond();
            l1 = 0L;
            i = 0;
          }
        }
        for (;;)
        {
          if ((this.luk < 200) && (this.luk > 30)) {
            if (l1 <= 500L) {
              break label348;
            }
          }
          long l6;
          long l2;
          label348:
          for (int j = this.luk - 5;; j = this.luk + 5)
          {
            this.luk = j;
            l6 = Util.nowMilliSecond();
            localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().H(str, this.luk, l4);
            l2 = 0L;
            l1 = 0L;
            while (((Cursor)localObject).moveToNext())
            {
              ca localca = new ca();
              localca.convertFrom((Cursor)localObject);
              l3 = l2;
              if (l2 < localca.field_createTime) {
                l3 = localca.field_createTime;
              }
              bq.B(localca);
              l1 = 1L + l1;
              l2 = l3;
            }
          }
          ((Cursor)localObject).close();
          long l7 = Util.nowMilliSecond();
          if ((l2 > 0L) && (l1 > 0L))
          {
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aW(str, l2);
            ((av)com.tencent.mm.kernel.h.ae(av.class)).x(str, l2);
          }
          i = (int)(i + l1);
          long l8 = Util.nowMilliSecond();
          long l3 = l8 - l6;
          Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", new Object[] { Util.secPrint(str), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l4 - l2), Long.valueOf(l4), Long.valueOf(l8 - l7), Long.valueOf(l8 - l6), Long.valueOf(l8 - l5), Integer.valueOf(this.luk) });
          if (l1 <= 0L)
          {
            ((n)com.tencent.mm.kernel.h.ae(n.class)).bco().aJ(str, 0L);
            break;
            Log.i("MicroMsg.MsgInfoStorageLogic", "Done checkUnfinishedDeleteMsgTask");
            bq.access$002(false);
            AppMethodBeat.o(42941);
            return;
          }
          l1 = l3;
        }
      }
    }, "checkUnfinishedDeleteMsgTask");
    int i = localMap.size();
    AppMethodBeat.o(174543);
    return i;
  }
  
  public static void beU()
  {
    AppMethodBeat.i(174545);
    List localList = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOL("bottlemessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        B((ca)localList.get(i));
        i += 1;
      }
    }
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aON("bottlemessage");
    AppMethodBeat.o(174545);
  }
  
  public static void beV()
  {
    AppMethodBeat.i(42969);
    List localList = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOL("qmessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        B((ca)localList.get(i));
        i += 1;
      }
    }
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aON("qmessage");
    AppMethodBeat.o(42969);
  }
  
  public static void beW()
  {
    AppMethodBeat.i(42970);
    List localList = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOL("tmessage");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        B((ca)localList.get(i));
        i += 1;
      }
    }
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aON("tmessage");
    AppMethodBeat.o(42970);
  }
  
  public static boolean c(h.a parama)
  {
    AppMethodBeat.i(42974);
    if ((parama == null) || (parama.jQG == null))
    {
      AppMethodBeat.o(42974);
      return false;
    }
    db localdb = parama.jQG;
    Object localObject = z.a(localdb.RID);
    localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL((String)localObject, localdb.HlH);
    if (((et)localObject).field_msgId == 0L)
    {
      AppMethodBeat.o(42974);
      return false;
    }
    if ((((et)localObject).field_isSend != 0) && (localdb.RIK == 0))
    {
      AppMethodBeat.o(42974);
      return false;
    }
    int i = ((et)localObject).field_flag;
    if (parama.lCc)
    {
      i |= 0x2;
      if (!parama.lCd) {
        break label230;
      }
      i |= 0x1;
      label128:
      if (!parama.lCe) {
        break label238;
      }
      i |= 0x4;
    }
    for (;;)
    {
      if (i == ((et)localObject).field_flag) {
        break label246;
      }
      Log.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr updateMsgFlagByAddMsgInfo msgType[%d], flag new[%d], old[%d]", new Object[] { Integer.valueOf(localdb.COi), Integer.valueOf(i), Integer.valueOf(((et)localObject).field_flag) });
      ((ca)localObject).setFlag(i);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().b(((et)localObject).field_msgSvrId, (ca)localObject);
      AppMethodBeat.o(42974);
      return true;
      i &= 0xFFFFFFFD;
      break;
      label230:
      i &= 0xFFFFFFFE;
      break label128;
      label238:
      i &= 0xFFFFFFFB;
    }
    label246:
    AppMethodBeat.o(42974);
    return false;
  }
  
  public static int d(h.a parama)
  {
    int j = 0;
    if (parama.lCc) {
      j = 2;
    }
    int i = j;
    if (parama.lCd) {
      i = j | 0x1;
    }
    j = i;
    if (parama.lCe) {
      j = i | 0x4;
    }
    return j;
  }
  
  /* Error */
  public static void e(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 762
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 671	java/lang/System:currentTimeMillis	()J
    //   9: pop2
    //   10: iconst_0
    //   11: istore_3
    //   12: iconst_0
    //   13: istore 4
    //   15: iconst_0
    //   16: istore 5
    //   18: iconst_0
    //   19: istore 6
    //   21: iload_2
    //   22: iconst_1
    //   23: if_icmpne +6 -> 29
    //   26: invokestatic 765	com/tencent/mm/model/bq$c:reset	()V
    //   29: new 26	com/tencent/mm/model/bq$c
    //   32: dup
    //   33: invokespecial 766	com/tencent/mm/model/bq$c:<init>	()V
    //   36: astore 13
    //   38: ldc 44
    //   40: invokestatic 50	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   43: checkcast 44	com/tencent/mm/plugin/messenger/foundation/a/n
    //   46: invokeinterface 54 1 0
    //   51: ldc_w 768
    //   54: lload_0
    //   55: invokeinterface 772 4 0
    //   60: astore 14
    //   62: aconst_null
    //   63: astore 12
    //   65: aload 13
    //   67: invokestatic 671	java/lang/System:currentTimeMillis	()J
    //   70: putfield 775	com/tencent/mm/model/bq$c:luO	J
    //   73: iconst_0
    //   74: istore 7
    //   76: iconst_0
    //   77: istore 8
    //   79: aload 14
    //   81: invokeinterface 592 1 0
    //   86: ifeq +283 -> 369
    //   89: new 142	com/tencent/mm/storage/ca
    //   92: dup
    //   93: invokespecial 585	com/tencent/mm/storage/ca:<init>	()V
    //   96: astore 11
    //   98: aload 11
    //   100: aload 14
    //   102: invokevirtual 589	com/tencent/mm/storage/ca:convertFrom	(Landroid/database/Cursor;)V
    //   105: aload 11
    //   107: invokevirtual 146	com/tencent/mm/storage/ca:getType	()I
    //   110: invokestatic 150	com/tencent/mm/model/bq:uZ	(I)I
    //   113: lookupswitch	default:+853->966, 3:+171->284, 23:+171->284, 34:+225->338, 43:+198->311, 44:+198->311, 49:+144->257, 62:+198->311, 486539313:+198->311
    //   189: fconst_0
    //   190: invokestatic 73	com/tencent/mm/model/bq:B	(Lcom/tencent/mm/storage/ca;)V
    //   193: iload 7
    //   195: iconst_1
    //   196: iadd
    //   197: istore 9
    //   199: iload 9
    //   201: istore 7
    //   203: iload 9
    //   205: bipush 100
    //   207: if_icmplt +19 -> 226
    //   210: aload 13
    //   212: invokevirtual 778	com/tencent/mm/model/bq$c:end	()V
    //   215: aload 13
    //   217: invokestatic 671	java/lang/System:currentTimeMillis	()J
    //   220: putfield 775	com/tencent/mm/model/bq$c:luO	J
    //   223: iconst_0
    //   224: istore 7
    //   226: iload 5
    //   228: istore 9
    //   230: iload 6
    //   232: istore 10
    //   234: iload 8
    //   236: iconst_1
    //   237: iadd
    //   238: istore 8
    //   240: iload_3
    //   241: istore 6
    //   243: iload 4
    //   245: istore 5
    //   247: iload 9
    //   249: istore 4
    //   251: iload 10
    //   253: istore_3
    //   254: goto -175 -> 79
    //   257: iload 4
    //   259: istore 9
    //   261: iload_3
    //   262: iconst_1
    //   263: iadd
    //   264: istore 10
    //   266: iload 6
    //   268: istore_3
    //   269: iload 5
    //   271: istore 4
    //   273: iload 9
    //   275: istore 5
    //   277: iload 10
    //   279: istore 6
    //   281: goto -93 -> 188
    //   284: iload 4
    //   286: iconst_1
    //   287: iadd
    //   288: istore 10
    //   290: iload_3
    //   291: istore 9
    //   293: iload 6
    //   295: istore_3
    //   296: iload 5
    //   298: istore 4
    //   300: iload 10
    //   302: istore 5
    //   304: iload 9
    //   306: istore 6
    //   308: goto -120 -> 188
    //   311: iload 5
    //   313: iconst_1
    //   314: iadd
    //   315: istore 10
    //   317: iload 4
    //   319: istore 5
    //   321: iload_3
    //   322: istore 9
    //   324: iload 6
    //   326: istore_3
    //   327: iload 10
    //   329: istore 4
    //   331: iload 9
    //   333: istore 6
    //   335: goto -147 -> 188
    //   338: iload 6
    //   340: iconst_1
    //   341: iadd
    //   342: istore 10
    //   344: iload 4
    //   346: istore 6
    //   348: iload_3
    //   349: istore 9
    //   351: iload 10
    //   353: istore_3
    //   354: iload 5
    //   356: istore 4
    //   358: iload 6
    //   360: istore 5
    //   362: iload 9
    //   364: istore 6
    //   366: goto -178 -> 188
    //   369: aload 14
    //   371: ifnull +10 -> 381
    //   374: aload 14
    //   376: invokeinterface 595 1 0
    //   381: aload 13
    //   383: invokevirtual 778	com/tencent/mm/model/bq$c:end	()V
    //   386: aload 13
    //   388: invokestatic 671	java/lang/System:currentTimeMillis	()J
    //   391: putfield 775	com/tencent/mm/model/bq$c:luO	J
    //   394: ldc 44
    //   396: invokestatic 50	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   399: checkcast 44	com/tencent/mm/plugin/messenger/foundation/a/n
    //   402: invokeinterface 54 1 0
    //   407: ldc_w 768
    //   410: lload_0
    //   411: invokeinterface 781 4 0
    //   416: istore 9
    //   418: aload 13
    //   420: invokevirtual 778	com/tencent/mm/model/bq$c:end	()V
    //   423: getstatic 787	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   426: sipush 1333
    //   429: bipush 10
    //   431: iconst_3
    //   432: iload 9
    //   434: iconst_1
    //   435: invokevirtual 790	com/tencent/mm/plugin/report/f:c	(IIIIZ)V
    //   438: aload 13
    //   440: getfield 793	com/tencent/mm/model/bq$c:luN	J
    //   443: lstore_0
    //   444: getstatic 787	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   447: ldc2_w 794
    //   450: ldc2_w 796
    //   453: lload_0
    //   454: ldc2_w 798
    //   457: ldiv
    //   458: iconst_1
    //   459: invokevirtual 803	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   462: iload_2
    //   463: iconst_1
    //   464: if_icmpne +527 -> 991
    //   467: getstatic 787	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   470: ldc2_w 794
    //   473: lconst_1
    //   474: lconst_1
    //   475: iconst_1
    //   476: invokevirtual 803	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   479: goto +512 -> 991
    //   482: getstatic 787	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   485: ldc2_w 794
    //   488: iload 7
    //   490: i2l
    //   491: lconst_1
    //   492: iconst_1
    //   493: invokevirtual 803	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   496: lload_0
    //   497: ldc2_w 804
    //   500: lcmp
    //   501: iflt +373 -> 874
    //   504: bipush 36
    //   506: istore 7
    //   508: getstatic 787	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   511: ldc2_w 794
    //   514: iload 7
    //   516: i2l
    //   517: lconst_1
    //   518: iconst_1
    //   519: invokevirtual 803	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   522: iload 9
    //   524: ifle +21 -> 545
    //   527: getstatic 787	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   530: ldc2_w 794
    //   533: ldc2_w 806
    //   536: lload_0
    //   537: iload 9
    //   539: i2l
    //   540: ldiv
    //   541: iconst_1
    //   542: invokevirtual 803	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   545: getstatic 787	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   548: sipush 18923
    //   551: bipush 8
    //   553: anewarray 4	java/lang/Object
    //   556: dup
    //   557: iconst_0
    //   558: lload_0
    //   559: invokestatic 285	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   562: aastore
    //   563: dup
    //   564: iconst_1
    //   565: iload_2
    //   566: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   569: aastore
    //   570: dup
    //   571: iconst_2
    //   572: iconst_0
    //   573: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   576: aastore
    //   577: dup
    //   578: iconst_3
    //   579: iload 8
    //   581: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   584: aastore
    //   585: dup
    //   586: iconst_4
    //   587: iload_3
    //   588: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   591: aastore
    //   592: dup
    //   593: iconst_5
    //   594: iload 4
    //   596: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   599: aastore
    //   600: dup
    //   601: bipush 6
    //   603: iload 5
    //   605: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   608: aastore
    //   609: dup
    //   610: bipush 7
    //   612: iload 6
    //   614: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   617: aastore
    //   618: invokevirtual 810	com/tencent/mm/plugin/report/f:a	(I[Ljava/lang/Object;)V
    //   621: ldc 224
    //   623: ldc_w 812
    //   626: bipush 6
    //   628: anewarray 4	java/lang/Object
    //   631: dup
    //   632: iconst_0
    //   633: lload_0
    //   634: invokestatic 285	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   637: aastore
    //   638: dup
    //   639: iconst_1
    //   640: iload 8
    //   642: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   645: aastore
    //   646: dup
    //   647: iconst_2
    //   648: iload_3
    //   649: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   652: aastore
    //   653: dup
    //   654: iconst_3
    //   655: iload 4
    //   657: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   660: aastore
    //   661: dup
    //   662: iconst_4
    //   663: iload 5
    //   665: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   668: aastore
    //   669: dup
    //   670: iconst_5
    //   671: iload 6
    //   673: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   676: aastore
    //   677: invokestatic 288	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   680: aload 13
    //   682: invokevirtual 813	com/tencent/mm/model/bq$c:close	()V
    //   685: invokestatic 765	com/tencent/mm/model/bq$c:reset	()V
    //   688: ldc_w 762
    //   691: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   694: return
    //   695: astore 12
    //   697: ldc_w 762
    //   700: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   703: aload 12
    //   705: athrow
    //   706: astore 11
    //   708: aload 14
    //   710: ifnull +15 -> 725
    //   713: aload 12
    //   715: ifnull +82 -> 797
    //   718: aload 14
    //   720: invokeinterface 595 1 0
    //   725: ldc_w 762
    //   728: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   731: aload 11
    //   733: athrow
    //   734: astore 12
    //   736: ldc_w 762
    //   739: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   742: aload 12
    //   744: athrow
    //   745: astore 11
    //   747: aload 12
    //   749: ifnull +204 -> 953
    //   752: aload 13
    //   754: invokevirtual 813	com/tencent/mm/model/bq$c:close	()V
    //   757: ldc_w 762
    //   760: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   763: aload 11
    //   765: athrow
    //   766: astore 11
    //   768: ldc 224
    //   770: aload 11
    //   772: ldc_w 815
    //   775: iconst_0
    //   776: anewarray 4	java/lang/Object
    //   779: invokestatic 819	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   782: goto -97 -> 685
    //   785: astore 14
    //   787: aload 12
    //   789: aload 14
    //   791: invokevirtual 823	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   794: goto -69 -> 725
    //   797: aload 14
    //   799: invokeinterface 595 1 0
    //   804: goto -79 -> 725
    //   807: iload 9
    //   809: ldc_w 824
    //   812: if_icmplt +10 -> 822
    //   815: bipush 25
    //   817: istore 7
    //   819: goto -337 -> 482
    //   822: iload 9
    //   824: ldc_w 825
    //   827: if_icmplt +10 -> 837
    //   830: bipush 24
    //   832: istore 7
    //   834: goto -352 -> 482
    //   837: iload 9
    //   839: sipush 10000
    //   842: if_icmplt +10 -> 852
    //   845: bipush 23
    //   847: istore 7
    //   849: goto -367 -> 482
    //   852: iload 9
    //   854: sipush 1000
    //   857: if_icmplt +10 -> 867
    //   860: bipush 22
    //   862: istore 7
    //   864: goto -382 -> 482
    //   867: bipush 21
    //   869: istore 7
    //   871: goto -389 -> 482
    //   874: lload_0
    //   875: ldc2_w 826
    //   878: lcmp
    //   879: iflt +10 -> 889
    //   882: bipush 35
    //   884: istore 7
    //   886: goto -378 -> 508
    //   889: lload_0
    //   890: ldc2_w 828
    //   893: lcmp
    //   894: iflt +10 -> 904
    //   897: bipush 34
    //   899: istore 7
    //   901: goto -393 -> 508
    //   904: lload_0
    //   905: ldc2_w 830
    //   908: lcmp
    //   909: iflt +10 -> 919
    //   912: bipush 33
    //   914: istore 7
    //   916: goto -408 -> 508
    //   919: lload_0
    //   920: ldc2_w 832
    //   923: lcmp
    //   924: iflt +10 -> 934
    //   927: bipush 32
    //   929: istore 7
    //   931: goto -423 -> 508
    //   934: bipush 31
    //   936: istore 7
    //   938: goto -430 -> 508
    //   941: astore 13
    //   943: aload 12
    //   945: aload 13
    //   947: invokevirtual 823	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   950: goto -193 -> 757
    //   953: aload 13
    //   955: invokevirtual 813	com/tencent/mm/model/bq$c:close	()V
    //   958: goto -201 -> 757
    //   961: astore 11
    //   963: goto -255 -> 708
    //   966: iload 4
    //   968: istore 9
    //   970: iload_3
    //   971: istore 10
    //   973: iload 6
    //   975: istore_3
    //   976: iload 5
    //   978: istore 4
    //   980: iload 9
    //   982: istore 5
    //   984: iload 10
    //   986: istore 6
    //   988: goto -800 -> 188
    //   991: iload 9
    //   993: ldc_w 834
    //   996: if_icmplt -189 -> 807
    //   999: bipush 26
    //   1001: istore 7
    //   1003: goto -521 -> 482
    //   1006: astore 11
    //   1008: aconst_null
    //   1009: astore 12
    //   1011: goto -264 -> 747
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1014	0	paramLong	long
    //   0	1014	2	paramInt	int
    //   11	965	3	i	int
    //   13	966	4	j	int
    //   16	967	5	k	int
    //   19	968	6	m	int
    //   74	928	7	n	int
    //   77	564	8	i1	int
    //   197	800	9	i2	int
    //   232	753	10	i3	int
    //   96	93	11	localca	ca
    //   706	26	11	localObject1	Object
    //   745	19	11	localObject2	Object
    //   766	5	11	localIOException	java.io.IOException
    //   961	1	11	localObject3	Object
    //   1006	1	11	localObject4	Object
    //   63	1	12	localObject5	Object
    //   695	19	12	localThrowable1	java.lang.Throwable
    //   734	210	12	localThrowable2	java.lang.Throwable
    //   1009	1	12	localObject6	Object
    //   36	717	13	localc	bq.c
    //   941	13	13	localThrowable3	java.lang.Throwable
    //   60	659	14	localCursor	Cursor
    //   785	13	14	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   65	73	695	java/lang/Throwable
    //   79	188	695	java/lang/Throwable
    //   188	193	695	java/lang/Throwable
    //   210	223	695	java/lang/Throwable
    //   697	706	706	finally
    //   38	62	734	java/lang/Throwable
    //   374	381	734	java/lang/Throwable
    //   381	462	734	java/lang/Throwable
    //   467	479	734	java/lang/Throwable
    //   482	496	734	java/lang/Throwable
    //   508	522	734	java/lang/Throwable
    //   527	545	734	java/lang/Throwable
    //   545	680	734	java/lang/Throwable
    //   725	734	734	java/lang/Throwable
    //   787	794	734	java/lang/Throwable
    //   797	804	734	java/lang/Throwable
    //   736	745	745	finally
    //   29	38	766	java/io/IOException
    //   680	685	766	java/io/IOException
    //   752	757	766	java/io/IOException
    //   757	766	766	java/io/IOException
    //   943	950	766	java/io/IOException
    //   953	958	766	java/io/IOException
    //   718	725	785	java/lang/Throwable
    //   752	757	941	java/lang/Throwable
    //   65	73	961	finally
    //   79	188	961	finally
    //   188	193	961	finally
    //   210	223	961	finally
    //   38	62	1006	finally
    //   374	381	1006	finally
    //   381	462	1006	finally
    //   467	479	1006	finally
    //   482	496	1006	finally
    //   508	522	1006	finally
    //   527	545	1006	finally
    //   545	680	1006	finally
    //   718	725	1006	finally
    //   725	734	1006	finally
    //   787	794	1006	finally
    //   797	804	1006	finally
  }
  
  public static long k(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(42976);
    long l3 = paramLong1 * 1000L;
    paramLong1 = 0L;
    long l2 = -1L;
    long l1 = paramLong1;
    ca localca;
    if (paramString != null)
    {
      localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH(paramString);
      if (localca != null) {
        paramLong1 = localca.field_createTime;
      }
      l2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOZ(paramString);
      l1 = paramLong1;
    }
    if (l2 == l1)
    {
      if (l3 == l1)
      {
        AppMethodBeat.o(42976);
        return l3 + 1L;
      }
      AppMethodBeat.o(42976);
      return l3;
    }
    if (l2 < l1)
    {
      if (l3 == l2)
      {
        AppMethodBeat.o(42976);
        return l3 - 1L;
      }
      if (l3 == l1)
      {
        AppMethodBeat.o(42976);
        return l3 + 1L;
      }
      if ((paramLong2 == 0L) || (l3 > l1))
      {
        AppMethodBeat.o(42976);
        return l3;
      }
      localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aN(paramString, l3);
      if ((localca.field_msgSeq != 0L) && (localca.field_msgSeq != paramLong2))
      {
        Log.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] need fix serverMillTime[%d, %d]", new Object[] { Long.valueOf(localca.field_msgSeq), Long.valueOf(paramLong2), Long.valueOf(localca.field_createTime), Long.valueOf(l3) });
        if (paramLong2 < localca.field_msgSeq)
        {
          paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aP(paramString, l3 - 1000L);
          if ((paramString.field_msgSeq == 0L) || (paramString.field_msgSeq == paramLong2)) {
            break label466;
          }
          if (paramString.field_msgSeq >= paramLong2) {
            break label456;
          }
          paramLong1 = paramString.field_createTime + 1L;
          label350:
          Log.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d, %d] need fix serverMillTime[%d, %d, %d] done", new Object[] { Long.valueOf(localca.field_msgSeq), Long.valueOf(paramString.field_msgSeq), Long.valueOf(paramLong2), Long.valueOf(localca.field_createTime), Long.valueOf(paramString.field_createTime), Long.valueOf(paramLong1) });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(42976);
        return paramLong1;
        paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aO(paramString, 1000L + l3);
        break;
        label456:
        paramLong1 = paramString.field_createTime - 1L;
        break label350;
        label466:
        Log.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] no need fix serverMillTime[%d, %d]", new Object[] { Long.valueOf(localca.field_msgSeq), Long.valueOf(paramLong2), Long.valueOf(localca.field_createTime), Long.valueOf(l3) });
        paramLong1 = l3;
      }
    }
    Log.w("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgCreateTime first > last [%d > %d], ret serverMillTime:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3) });
    AppMethodBeat.o(42976);
    return l3;
  }
  
  public static boolean uY(int paramInt)
  {
    switch (paramInt)
    {
    case 25: 
    default: 
      return false;
    }
    return true;
  }
  
  private static int uZ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    }
    return 49;
  }
  
  public static long z(ca paramca)
  {
    AppMethodBeat.i(42956);
    as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca.field_talker);
    if ((localas == null) || ((int)localas.jxt == 0))
    {
      localas = new as(paramca.field_talker);
      localas.setType(2);
      nh localnh = new nh();
      localnh.fLD.fLE = localas;
      EventCenter.instance.publish(localnh);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().av(localas);
    }
    long l = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM(paramca);
    AppMethodBeat.o(42956);
    return l;
  }
  
  public static long z(String paramString, long paramLong)
  {
    AppMethodBeat.i(42961);
    if (paramString != null)
    {
      paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH(paramString);
      if (paramString == null) {}
    }
    for (long l = paramString.field_createTime + 1L;; l = 0L)
    {
      if (l > paramLong * 1000L)
      {
        AppMethodBeat.o(42961);
        return l;
      }
      AppMethodBeat.o(42961);
      return paramLong * 1000L;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean asH();
    
    public abstract void asI();
  }
  
  public static final class b
  {
    public String luA;
    public String luB;
    public String luC;
    public String luD;
    public String luE;
    public String luF;
    public int luG;
    public int luH;
    public int luI;
    public int luJ;
    public String luK;
    public String lup;
    public int luq;
    public int lur;
    public String lus;
    public String lut;
    public int luu;
    public int luv;
    public long luw;
    public String luy;
    @Deprecated
    public String luz;
    public int scene = 0;
    public int serviceType;
    public String userId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bq
 * JD-Core Version:    0.7.0.1
 */