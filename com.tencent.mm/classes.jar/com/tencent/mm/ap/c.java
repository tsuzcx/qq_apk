package com.tencent.mm.ap;

import android.os.HandlerThread;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.h.a.hh;
import com.tencent.mm.h.a.hh.a;
import com.tencent.mm.h.a.pw;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bx;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.w;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  extends com.tencent.mm.sdk.b.c<pw>
  implements b.a, j.a, m.b
{
  public final com.tencent.mm.sdk.b.c emh = new com.tencent.mm.sdk.b.c()
  {
    private static boolean a(hh paramAnonymoushh)
    {
      long l2 = System.currentTimeMillis();
      for (;;)
      {
        bi localbi;
        try
        {
          Object localObject1 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ();
          if (!((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).Hk(paramAnonymoushh.bPe.username))
          {
            localObject2 = new w();
            ((w)localObject2).field_username = paramAnonymoushh.bPe.username;
            if (paramAnonymoushh.bPe.bPf <= paramAnonymoushh.bPe.bPh)
            {
              l1 = paramAnonymoushh.bPe.bPh;
              ((w)localObject2).field_lastPushSeq = l1;
              ((w)localObject2).field_lastLocalSeq = paramAnonymoushh.bPe.bPh;
              ((w)localObject2).field_lastPushCreateTime = paramAnonymoushh.bPe.bPg;
              ((w)localObject2).field_lastLocalCreateTime = paramAnonymoushh.bPe.bPi;
              l1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).a((w)localObject2, true);
              localObject1 = com.tencent.mm.ui.chatting.i.b.vzo;
              com.tencent.mm.ui.chatting.i.b.cGQ();
              y.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] ret:%s,chatRoomId:%s lastPushSeq:%s lastPushCreateTime:%s lastLocalSeq:%s lastLocalCreateTime:%s", new Object[] { Long.valueOf(l1), paramAnonymoushh.bPe.username, Long.valueOf(paramAnonymoushh.bPe.bPf), Long.valueOf(paramAnonymoushh.bPe.bPg), Long.valueOf(paramAnonymoushh.bPe.bPh), Long.valueOf(paramAnonymoushh.bPe.bPi) });
              return true;
            }
            l1 = paramAnonymoushh.bPe.bPf;
            continue;
          }
          Object localObject2 = paramAnonymoushh.bPe.username;
          localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HB((String)localObject2);
          l1 = paramAnonymoushh.bPe.bPf;
          long l3 = paramAnonymoushh.bPe.bPg;
          paramAnonymoushh = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).Hm((String)localObject2);
          long l4 = paramAnonymoushh.field_lastLocalSeq;
          long l5 = paramAnonymoushh.field_lastLocalCreateTime;
          long l6 = paramAnonymoushh.field_lastPushSeq;
          long l7 = paramAnonymoushh.field_lastPushCreateTime;
          y.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] isGetChatroom! %s conPushSeq:%s conPushCreateTime:%s localSeq:%s localCreateTime:%s pushSeq:%s pushCreateTime:%s", new Object[] { localObject2, Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7) });
          if ((localbi != null) && (localbi.field_msgId != 0L))
          {
            long l8 = localbi.field_msgSeq;
            if (l8 > l4)
            {
              paramAnonymoushh.field_lastLocalSeq = l8;
              paramAnonymoushh.field_lastLocalCreateTime = localbi.field_createTime;
              com.tencent.mm.k.a.a.c localc = new com.tencent.mm.k.a.a.c();
              localc.dtN = (1L + l4);
              localc.dtP = (l5 + 1L);
              localc.dtO = (l8 - 1L);
              localc.dtQ = (l7 - 1L);
              if (paramAnonymoushh.field_seqBlockInfo == null) {
                paramAnonymoushh.field_seqBlockInfo = new d();
              }
              paramAnonymoushh.field_seqBlockInfo.dtR.addLast(localc);
              y.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage local seq is smaller than MsgInfoStg local seq! ret:[%s]", new Object[] { Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).b(paramAnonymoushh)) });
            }
            if (l6 < l1) {
              y.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage push seq is smaller than conversation seq! ret:[%s,%s] [%s,%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).G((String)localObject2, l1)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).I((String)localObject2, l3)), Long.valueOf(localbi.field_msgSeq), Long.valueOf(l4) });
            }
            return true;
          }
          if (localbi == null)
          {
            bool = true;
            if (localbi != null) {
              break label723;
            }
            l1 = -1L;
            y.w("MicroMsg.GetChatroomMsgReceiver", "lastMsgInfo is null? %s lastMsgInfo id:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
            continue;
          }
          boolean bool = false;
        }
        finally
        {
          y.i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
        }
        continue;
        label723:
        long l1 = localbi.field_msgId;
      }
    }
  };
  private Map<Long, bb> emi = new HashMap();
  
  public c()
  {
    a.udP.c(this.emh);
    b.Oi().emb = this;
    ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a(this, com.tencent.mm.kernel.g.DS().mnU.getLooper());
    n.Pn();
    n.Pl().a(this, au.DS().mnU.getLooper());
    this.udX = pw.class.getName().hashCode();
  }
  
  private static List<com.tencent.mm.k.a.a.c> a(String paramString, LinkedList<bi> paramLinkedList)
  {
    Object localObject2 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).Hj(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nchatroomId:").append(paramString);
    long l1 = ((bi)paramLinkedList.getFirst()).field_msgSeq;
    long l2 = ((bi)paramLinkedList.getLast()).field_msgSeq;
    long l3 = ((bi)paramLinkedList.getFirst()).field_createTime;
    long l4 = ((bi)paramLinkedList.getLast()).field_createTime;
    localStringBuilder.append("\ngetFirst:").append(l1);
    localStringBuilder.append(" getLast:").append(l2);
    localStringBuilder.append(" getFirstCreateTime:").append(l3);
    localStringBuilder.append(" getLastCreateTime:").append(l4);
    localStringBuilder.append("\nblock ");
    paramLinkedList = new com.tencent.mm.k.a.a.c();
    paramLinkedList.dtN = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).Hg(paramString) + 1L);
    paramLinkedList.dtP = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).Hi(paramString) + 1L);
    paramLinkedList.dtO = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).Hf(paramString);
    paramLinkedList.dtQ = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).Hh(paramString);
    if (paramLinkedList.dtO - paramLinkedList.dtN >= 0L) {
      ((d)localObject1).dtR.add(paramLinkedList);
    }
    for (;;)
    {
      paramString = new LinkedList();
      paramLinkedList = ((d)localObject1).dtR.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject1 = (com.tencent.mm.k.a.a.c)paramLinkedList.next();
        int j = 0;
        long l5 = ((com.tencent.mm.k.a.a.c)localObject1).dtN;
        long l6 = ((com.tencent.mm.k.a.a.c)localObject1).dtO;
        long l7 = ((com.tencent.mm.k.a.a.c)localObject1).dtP;
        long l8 = ((com.tencent.mm.k.a.a.c)localObject1).dtQ;
        localStringBuilder.append("[").append(l5).append(":").append(l6).append("][").append(l7).append(":").append(l8).append("] | ");
        int i = j;
        if (l5 <= l1)
        {
          i = j;
          if (l1 <= l6)
          {
            localObject2 = new com.tencent.mm.k.a.a.c();
            ((com.tencent.mm.k.a.a.c)localObject2).dtN = ((com.tencent.mm.k.a.a.c)localObject1).dtN;
            ((com.tencent.mm.k.a.a.c)localObject2).dtO = (l1 - 1L);
            ((com.tencent.mm.k.a.a.c)localObject2).dtP = l7;
            ((com.tencent.mm.k.a.a.c)localObject2).dtQ = (l3 - 1L);
            i = j;
            if (((com.tencent.mm.k.a.a.c)localObject2).dtO - ((com.tencent.mm.k.a.a.c)localObject2).dtN >= 0L)
            {
              paramString.add(localObject2);
              i = 1;
            }
          }
        }
        j = i;
        if (l5 <= l2)
        {
          j = i;
          if (l2 <= l6)
          {
            localObject2 = new com.tencent.mm.k.a.a.c();
            ((com.tencent.mm.k.a.a.c)localObject2).dtN = (1L + l2);
            ((com.tencent.mm.k.a.a.c)localObject2).dtO = l6;
            ((com.tencent.mm.k.a.a.c)localObject2).dtP = (1L + l4);
            ((com.tencent.mm.k.a.a.c)localObject2).dtQ = l8;
            j = i;
            if (((com.tencent.mm.k.a.a.c)localObject2).dtO - ((com.tencent.mm.k.a.a.c)localObject2).dtN >= 0L)
            {
              paramString.add(localObject2);
              j = 1;
            }
          }
        }
        if ((j == 0) && ((l1 > l6) || (l2 < l5)))
        {
          paramString.add(localObject1);
          y.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] add raw block!");
        }
      }
      y.w("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] lastSeq[%s]<firstSeq[%s]", new Object[] { Long.valueOf(paramLinkedList.dtO), Long.valueOf(paramLinkedList.dtN) });
    }
    paramLinkedList = new StringBuilder();
    localObject1 = paramString.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.k.a.a.c)((Iterator)localObject1).next();
      paramLinkedList.append("[").append(((com.tencent.mm.k.a.a.c)localObject2).dtN).append(":").append(((com.tencent.mm.k.a.a.c)localObject2).dtO).append("][").append(((com.tencent.mm.k.a.a.c)localObject2).dtP).append(":").append(((com.tencent.mm.k.a.a.c)localObject2).dtQ).append("] | ");
    }
    y.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] " + localStringBuilder.toString() + "\nnew blockList:" + paramLinkedList.toString());
    return paramString;
  }
  
  private static void e(Map<Long, bb> paramMap, String paramString)
  {
    if ((paramMap.size() == 0) || (ah.bl(paramString))) {}
    do
    {
      return;
      paramMap = paramMap.values().iterator();
    } while (paramMap == null);
    label33:
    Object localObject1;
    Object localObject2;
    boolean bool1;
    label250:
    boolean bool2;
    while (paramMap.hasNext())
    {
      localObject1 = (bb)paramMap.next();
      if ((localObject1 != null) && (paramString.equals(((bb)localObject1).field_fromUserName)))
      {
        au.Hx();
        localObject2 = com.tencent.mm.model.c.Fy().O(paramString, ((bb)localObject1).field_originSvrId);
        if (((cs)localObject2).field_msgId != 0L)
        {
          y.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", new Object[] { Long.valueOf(((cs)localObject2).field_msgId), Long.valueOf(((cs)localObject2).field_msgSvrId) });
          localObject2 = new cd();
          ((cd)localObject2).ndp = ((bb)localObject1).field_newMsgId;
          ((cd)localObject2).svF = aa.pj(((bb)localObject1).field_fromUserName);
          ((cd)localObject2).svG = aa.pj(((bb)localObject1).field_toUserName);
          ((cd)localObject2).mPL = ((int)((bb)localObject1).field_createTime);
          ((cd)localObject2).svH = aa.pj(((bb)localObject1).field_content);
          ((cd)localObject2).svK = ((bb)localObject1).field_msgSource;
          ((cd)localObject2).svM = ((bb)localObject1).field_msgSeq;
          int i = ((bb)localObject1).field_flag;
          ((cd)localObject2).kSW = 10002;
          localObject1 = au.getSysCmdMsgExtension();
          if ((i & 0x2) == 0) {
            break label291;
          }
          bool1 = true;
          if ((i & 0x1) == 0) {
            break label296;
          }
          bool2 = true;
          label259:
          if ((i & 0x4) == 0) {
            break label302;
          }
        }
      }
    }
    label291:
    label296:
    label302:
    for (boolean bool3 = true;; bool3 = false)
    {
      ((bx)localObject1).b(new e.a((cd)localObject2, bool1, bool2, bool3));
      break label33;
      break;
      bool1 = false;
      break label250;
      bool2 = false;
      break label259;
    }
  }
  
  private static void g(String paramString, long paramLong1, long paramLong2)
  {
    y.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + paramLong1 + " lastMsgSeq:" + paramLong2 + " chatroomId:" + paramString);
    com.tencent.mm.plugin.messenger.foundation.a.a.b localb = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ();
    w localw = localb.Hm(paramString);
    if (localw.field_seqBlockInfo != null)
    {
      Object localObject = new LinkedList();
      Iterator localIterator = localw.field_seqBlockInfo.dtR.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.k.a.a.c localc = (com.tencent.mm.k.a.a.c)localIterator.next();
        if ((localc.dtN == paramLong1) && (localc.dtO == paramLong2)) {
          ((List)localObject).add(localc);
        }
      }
      localw.field_seqBlockInfo.dtR.removeAll((Collection)localObject);
      l = localb.b(localw);
      y.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + paramLong1 + " lastMsgSeq:" + paramLong2 + " chatroomId:" + paramString + " ret:" + l + " remove list:" + ((List)localObject).size());
      if (((List)localObject).size() > 0)
      {
        localObject = com.tencent.mm.ui.chatting.i.b.vzo;
        com.tencent.mm.ui.chatting.i.b.cGS();
      }
    }
    localw.field_lastLocalSeq = localw.field_lastPushSeq;
    localw.field_lastLocalCreateTime = localw.field_lastPushCreateTime;
    long l = localb.b(localw);
    y.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + paramLong1 + " lastMsgSeq:" + paramLong2 + " chatroomId:" + paramString + " ret:" + l + " lastPushSeq:" + localw.field_lastPushSeq + " field_lastPushCreateTime:" + localw.field_lastPushCreateTime);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    if ((paramm == ((j)com.tencent.mm.kernel.g.r(j.class)).FB()) && ((paramObject instanceof String)) && (5 == paramInt))
    {
      paramm = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ();
      paramObject = (String)paramObject;
      if (paramm.Hk(paramObject))
      {
        w localw = paramm.Hm(paramObject);
        if (localw.field_seqBlockInfo != null) {
          localw.field_seqBlockInfo.dtR.clear();
        }
        localw.field_lastLocalSeq = localw.field_lastPushSeq;
        localw.field_lastLocalCreateTime = localw.field_lastPushCreateTime;
        long l = paramm.b(localw);
        y.i("MicroMsg.GetChatroomMsgReceiver", "[onNotifyChange] username:" + paramObject + " ret:" + l + " chatroomMsgSeq:" + localw.toString());
      }
    }
  }
  
  public final void a(String paramString, l paraml)
  {
    if (!ah.bl(paramString)) {
      try
      {
        long l = Long.valueOf(paramString).longValue();
        paramString = new bb();
        paramString.field_originSvrId = l;
        n.Pn();
        if (n.Pl().b(paramString, new String[0]))
        {
          this.emi.put(Long.valueOf(l), paramString);
          y.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange put info systemRowid[%d], svrId[%d]", new Object[] { Long.valueOf(paramString.ujK), Long.valueOf(l) });
          return;
        }
        this.emi.remove(Long.valueOf(l));
        y.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange remove info svrId[%d]", new Object[] { Long.valueOf(l) });
        return;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", paramString, "summerbadcr dealSysCmdMsg onNotifyChange:", new Object[0]);
      }
    }
  }
  
  public final void a(String paramString, boolean paramBoolean1, LinkedList<bi> paramLinkedList, com.tencent.mm.k.a.a.c paramc, boolean paramBoolean2)
  {
    if ((paramLinkedList.size() <= 0) || (paramBoolean2))
    {
      y.w("MicroMsg.GetChatroomMsgReceiver", "[onFetched] fetchList.size() == 0! removeBlock! isBlockAll:" + paramBoolean2);
      g(paramString, paramc.dtN, paramc.dtO);
      return;
    }
    y.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] insert msg count[%s] isFetchUp:%s", new Object[] { Integer.valueOf(paramLinkedList.size()), Boolean.valueOf(paramBoolean1) });
    paramc = ((j)com.tencent.mm.kernel.g.r(j.class)).bhJ();
    List localList = a(paramString, paramLinkedList);
    d locald = paramc.Hj(paramString);
    locald.dtR.clear();
    locald.dtR.addAll(localList);
    paramBoolean1 = paramc.a(paramString, locald);
    long l1 = ((bi)paramLinkedList.getLast()).field_msgSeq;
    long l2 = ((bi)paramLinkedList.getLast()).field_createTime;
    long l3 = paramc.Hg(paramString);
    long l4 = paramc.Hi(paramString);
    y.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] blockList size:%s ret:%s GetSeq:[last %s:old %s] GetLocalCreateTime:[last %s:old %s]", new Object[] { Integer.valueOf(locald.dtR.size()), Boolean.valueOf(paramBoolean1), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4) });
    if (l3 < l1)
    {
      paramc.J(paramString, l1);
      paramc.H(paramString, l2);
    }
    for (;;)
    {
      e(new HashMap(this.emi), paramString);
      return;
      y.w("MicroMsg.GetChatroomMsgReceiver", "oldGetSeq>=lastGetSeq [%s:%s]", new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ap.c
 * JD-Core Version:    0.7.0.1
 */