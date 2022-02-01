package com.tencent.mm.as;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.g.a.im;
import com.tencent.mm.g.a.im.a;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.g.a.tg.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.j.a.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bk.b;
import com.tencent.mm.storage.bo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  extends com.tencent.mm.sdk.b.c<tg>
  implements b.a, k.a, n.b
{
  public final com.tencent.mm.sdk.b.c hFI;
  private Map<Long, bh> hFJ;
  
  public c()
  {
    AppMethodBeat.i(20506);
    this.hFI = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(im paramAnonymousim)
      {
        AppMethodBeat.i(20503);
        long l2 = System.currentTimeMillis();
        for (;;)
        {
          bo localbo;
          try
          {
            Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcm();
            if (!((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).akT(paramAnonymousim.djG.username))
            {
              localObject2 = new com.tencent.mm.storage.z();
              ((com.tencent.mm.storage.z)localObject2).field_username = paramAnonymousim.djG.username;
              if (paramAnonymousim.djG.djH <= paramAnonymousim.djG.djJ)
              {
                l1 = paramAnonymousim.djG.djJ;
                ((com.tencent.mm.storage.z)localObject2).field_lastPushSeq = l1;
                ((com.tencent.mm.storage.z)localObject2).field_lastLocalSeq = paramAnonymousim.djG.djJ;
                ((com.tencent.mm.storage.z)localObject2).field_lastPushCreateTime = paramAnonymousim.djG.djI;
                ((com.tencent.mm.storage.z)localObject2).field_lastLocalCreateTime = paramAnonymousim.djG.djK;
                l1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).a((com.tencent.mm.storage.z)localObject2, true);
                localObject1 = com.tencent.mm.ui.chatting.k.b.Igg;
                com.tencent.mm.ui.chatting.k.b.fqg();
                ac.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] ret:%s,chatRoomId:%s lastPushSeq:%s lastPushCreateTime:%s lastLocalSeq:%s lastLocalCreateTime:%s", new Object[] { Long.valueOf(l1), paramAnonymousim.djG.username, Long.valueOf(paramAnonymousim.djG.djH), Long.valueOf(paramAnonymousim.djG.djI), Long.valueOf(paramAnonymousim.djG.djJ), Long.valueOf(paramAnonymousim.djG.djK) });
                return true;
              }
              l1 = paramAnonymousim.djG.djH;
              continue;
            }
            Object localObject2 = paramAnonymousim.djG.username;
            localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().all((String)localObject2);
            l1 = paramAnonymousim.djG.djH;
            long l3 = paramAnonymousim.djG.djI;
            paramAnonymousim = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).akV((String)localObject2);
            long l4 = paramAnonymousim.field_lastLocalSeq;
            long l5 = paramAnonymousim.field_lastLocalCreateTime;
            long l6 = paramAnonymousim.field_lastPushSeq;
            long l7 = paramAnonymousim.field_lastPushCreateTime;
            ac.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] isGetChatroom! %s conPushSeq:%s conPushCreateTime:%s localSeq:%s localCreateTime:%s pushSeq:%s pushCreateTime:%s", new Object[] { localObject2, Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7) });
            if ((localbo != null) && (localbo.field_msgId != 0L))
            {
              long l8 = localbo.field_msgSeq;
              if (l8 > l4)
              {
                paramAnonymousim.field_lastLocalSeq = l8;
                paramAnonymousim.field_lastLocalCreateTime = localbo.field_createTime;
                com.tencent.mm.j.a.a.c localc = new com.tencent.mm.j.a.a.c();
                localc.fBY = (1L + l4);
                localc.fCa = (l5 + 1L);
                localc.fBZ = (l8 - 1L);
                localc.fCb = (l7 - 1L);
                if (paramAnonymousim.field_seqBlockInfo == null) {
                  paramAnonymousim.field_seqBlockInfo = new d();
                }
                paramAnonymousim.field_seqBlockInfo.fCc.addLast(localc);
                ac.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage local seq is smaller than MsgInfoStg local seq! ret:[%s]", new Object[] { Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).b(paramAnonymousim)) });
              }
              if (l6 < l1) {
                ac.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage push seq is smaller than conversation seq! ret:[%s,%s] [%s,%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).ax((String)localObject2, l1)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).az((String)localObject2, l3)), Long.valueOf(localbo.field_msgSeq), Long.valueOf(l4) });
              }
              return true;
            }
            if (localbo == null)
            {
              bool = true;
              if (localbo != null) {
                break label747;
              }
              l1 = -1L;
              ac.w("MicroMsg.GetChatroomMsgReceiver", "lastMsgInfo is null? %s lastMsgInfo id:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
              continue;
            }
            boolean bool = false;
          }
          finally
          {
            ac.i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
            AppMethodBeat.o(20503);
          }
          continue;
          label747:
          long l1 = localbo.field_msgId;
        }
      }
    };
    this.hFJ = new HashMap();
    a.GpY.c(this.hFI);
    b.aER().hFB = this;
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().a(this, g.agU().GrZ.getLooper());
    o.aGn();
    o.aGl().add(this, com.tencent.mm.model.az.agU().GrZ.getLooper());
    this.__eventId = tg.class.getName().hashCode();
    AppMethodBeat.o(20506);
  }
  
  private static List<com.tencent.mm.j.a.a.c> a(String paramString, LinkedList<bo> paramLinkedList)
  {
    AppMethodBeat.i(20509);
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcm();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).akS(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nchatroomId:").append(paramString);
    long l1 = ((bo)paramLinkedList.getFirst()).field_msgSeq;
    long l2 = ((bo)paramLinkedList.getLast()).field_msgSeq;
    long l3 = ((bo)paramLinkedList.getFirst()).field_createTime;
    long l4 = ((bo)paramLinkedList.getLast()).field_createTime;
    localStringBuilder.append("\ngetFirst:").append(l1);
    localStringBuilder.append(" getLast:").append(l2);
    localStringBuilder.append(" getFirstCreateTime:").append(l3);
    localStringBuilder.append(" getLastCreateTime:").append(l4);
    localStringBuilder.append("\nblock ");
    paramLinkedList = new com.tencent.mm.j.a.a.c();
    paramLinkedList.fBY = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).akP(paramString) + 1L);
    paramLinkedList.fCa = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).akR(paramString) + 1L);
    paramLinkedList.fBZ = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).akO(paramString);
    paramLinkedList.fCb = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).akQ(paramString);
    if (paramLinkedList.fBZ - paramLinkedList.fBY >= 0L) {
      ((d)localObject1).fCc.add(paramLinkedList);
    }
    for (;;)
    {
      paramString = new LinkedList();
      paramLinkedList = ((d)localObject1).fCc.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject1 = (com.tencent.mm.j.a.a.c)paramLinkedList.next();
        int j = 0;
        long l5 = ((com.tencent.mm.j.a.a.c)localObject1).fBY;
        long l6 = ((com.tencent.mm.j.a.a.c)localObject1).fBZ;
        long l7 = ((com.tencent.mm.j.a.a.c)localObject1).fCa;
        long l8 = ((com.tencent.mm.j.a.a.c)localObject1).fCb;
        localStringBuilder.append("[").append(l5).append(":").append(l6).append("][").append(l7).append(":").append(l8).append("] | ");
        int i = j;
        if (l5 <= l1)
        {
          i = j;
          if (l1 <= l6)
          {
            localObject2 = new com.tencent.mm.j.a.a.c();
            ((com.tencent.mm.j.a.a.c)localObject2).fBY = ((com.tencent.mm.j.a.a.c)localObject1).fBY;
            ((com.tencent.mm.j.a.a.c)localObject2).fBZ = (l1 - 1L);
            ((com.tencent.mm.j.a.a.c)localObject2).fCa = l7;
            ((com.tencent.mm.j.a.a.c)localObject2).fCb = (l3 - 1L);
            i = j;
            if (((com.tencent.mm.j.a.a.c)localObject2).fBZ - ((com.tencent.mm.j.a.a.c)localObject2).fBY >= 0L)
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
            localObject2 = new com.tencent.mm.j.a.a.c();
            ((com.tencent.mm.j.a.a.c)localObject2).fBY = (1L + l2);
            ((com.tencent.mm.j.a.a.c)localObject2).fBZ = l6;
            ((com.tencent.mm.j.a.a.c)localObject2).fCa = (1L + l4);
            ((com.tencent.mm.j.a.a.c)localObject2).fCb = l8;
            j = i;
            if (((com.tencent.mm.j.a.a.c)localObject2).fBZ - ((com.tencent.mm.j.a.a.c)localObject2).fBY >= 0L)
            {
              paramString.add(localObject2);
              j = 1;
            }
          }
        }
        if ((j == 0) && ((l1 > l6) || (l2 < l5)))
        {
          paramString.add(localObject1);
          ac.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] add raw block!");
        }
      }
      ac.w("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] lastSeq[%s]<firstSeq[%s]", new Object[] { Long.valueOf(paramLinkedList.fBZ), Long.valueOf(paramLinkedList.fBY) });
    }
    paramLinkedList = new StringBuilder();
    localObject1 = paramString.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.j.a.a.c)((Iterator)localObject1).next();
      paramLinkedList.append("[").append(((com.tencent.mm.j.a.a.c)localObject2).fBY).append(":").append(((com.tencent.mm.j.a.a.c)localObject2).fBZ).append("][").append(((com.tencent.mm.j.a.a.c)localObject2).fCa).append(":").append(((com.tencent.mm.j.a.a.c)localObject2).fCb).append("] | ");
    }
    ac.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] " + localStringBuilder.toString() + "\nnew blockList:" + paramLinkedList.toString());
    AppMethodBeat.o(20509);
    return paramString;
  }
  
  private static void d(Map<Long, bh> paramMap, String paramString)
  {
    AppMethodBeat.i(20511);
    if ((paramMap.size() == 0) || (ae.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(20511);
      return;
    }
    paramMap = paramMap.values().iterator();
    if (paramMap != null) {
      while (paramMap.hasNext())
      {
        Object localObject1 = (bh)paramMap.next();
        if ((localObject1 != null) && (paramString.equals(((bh)localObject1).field_fromUserName)))
        {
          com.tencent.mm.model.az.ayM();
          Object localObject2 = com.tencent.mm.model.c.awD().aF(paramString, ((bh)localObject1).field_originSvrId);
          if (((dy)localObject2).field_msgId != 0L)
          {
            ac.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", new Object[] { Long.valueOf(((dy)localObject2).field_msgId), Long.valueOf(((dy)localObject2).field_msgSvrId) });
            localObject2 = new cu();
            ((cu)localObject2).vTQ = ((bh)localObject1).field_newMsgId;
            ((cu)localObject2).DPT = com.tencent.mm.platformtools.z.FI(((bh)localObject1).field_fromUserName);
            ((cu)localObject2).DPU = com.tencent.mm.platformtools.z.FI(((bh)localObject1).field_toUserName);
            ((cu)localObject2).CreateTime = ((int)((bh)localObject1).field_createTime);
            ((cu)localObject2).DPV = com.tencent.mm.platformtools.z.FI(((bh)localObject1).field_content);
            ((cu)localObject2).DPY = ((bh)localObject1).field_msgSource;
            ((cu)localObject2).DQa = ((bh)localObject1).field_msgSeq;
            int i = ((bh)localObject1).field_flag;
            ((cu)localObject2).tit = 10002;
            localObject1 = com.tencent.mm.model.az.getSysCmdMsgExtension();
            boolean bool1;
            label262:
            boolean bool2;
            if ((i & 0x2) != 0)
            {
              bool1 = true;
              if ((i & 0x1) == 0) {
                break label308;
              }
              bool2 = true;
              label271:
              if ((i & 0x4) == 0) {
                break label314;
              }
            }
            label308:
            label314:
            for (boolean bool3 = true;; bool3 = false)
            {
              ((cc)localObject1).b(new f.a((cu)localObject2, bool1, bool2, bool3));
              break;
              bool1 = false;
              break label262;
              bool2 = false;
              break label271;
            }
          }
        }
      }
    }
    AppMethodBeat.o(20511);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(20508);
    if ((paramn == ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG()) && ((paramObject instanceof String)) && (5 == paramInt))
    {
      paramn = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcm();
      paramObject = (String)paramObject;
      if (paramn.akT(paramObject))
      {
        com.tencent.mm.storage.z localz = paramn.akV(paramObject);
        if (localz.field_seqBlockInfo != null) {
          localz.field_seqBlockInfo.fCc.clear();
        }
        localz.field_lastLocalSeq = localz.field_lastPushSeq;
        localz.field_lastLocalCreateTime = localz.field_lastPushCreateTime;
        long l = paramn.b(localz);
        ac.i("MicroMsg.GetChatroomMsgReceiver", "[onNotifyChange] username:" + paramObject + " ret:" + l + " chatroomMsgSeq:" + localz.toString());
      }
    }
    AppMethodBeat.o(20508);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(20510);
    if (!ae.isNullOrNil(paramString)) {
      try
      {
        long l = Long.valueOf(paramString).longValue();
        paramString = new bh();
        paramString.field_originSvrId = l;
        o.aGn();
        if (o.aGl().get(paramString, new String[0]))
        {
          this.hFJ.put(Long.valueOf(l), paramString);
          ac.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange put info systemRowid[%d], svrId[%d]", new Object[] { Long.valueOf(paramString.systemRowid), Long.valueOf(l) });
          AppMethodBeat.o(20510);
          return;
        }
        this.hFJ.remove(Long.valueOf(l));
        ac.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange remove info svrId[%d]", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(20510);
        return;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", paramString, "summerbadcr dealSysCmdMsg onNotifyChange:", new Object[0]);
      }
    }
    AppMethodBeat.o(20510);
  }
  
  public final void a(String paramString, boolean paramBoolean1, LinkedList<bo> paramLinkedList, com.tencent.mm.j.a.a.c paramc, boolean paramBoolean2)
  {
    AppMethodBeat.i(20507);
    if ((paramLinkedList.size() <= 0) || (paramBoolean2))
    {
      ac.w("MicroMsg.GetChatroomMsgReceiver", "[onFetched] fetchList.size() == 0! removeBlock! isBlockAll:".concat(String.valueOf(paramBoolean2)));
      l1 = paramc.fBY;
      l2 = paramc.fBZ;
      ac.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString);
      paramLinkedList = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcm();
      paramc = paramLinkedList.akV(paramString);
      if (paramc.field_seqBlockInfo != null)
      {
        localObject1 = new LinkedList();
        localObject2 = paramc.field_seqBlockInfo.fCc.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.j.a.a.c localc = (com.tencent.mm.j.a.a.c)((Iterator)localObject2).next();
          if ((localc.fBY == l1) && (localc.fBZ == l2)) {
            ((List)localObject1).add(localc);
          }
        }
        paramc.field_seqBlockInfo.fCc.removeAll((Collection)localObject1);
        l3 = paramLinkedList.b(paramc);
        ac.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString + " ret:" + l3 + " remove list:" + ((List)localObject1).size());
        if (((List)localObject1).size() > 0)
        {
          localObject1 = com.tencent.mm.ui.chatting.k.b.Igg;
          com.tencent.mm.ui.chatting.k.b.fqi();
        }
      }
      paramc.field_lastLocalSeq = paramc.field_lastPushSeq;
      paramc.field_lastLocalCreateTime = paramc.field_lastPushCreateTime;
      l3 = paramLinkedList.b(paramc);
      ac.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString + " ret:" + l3 + " lastPushSeq:" + paramc.field_lastPushSeq + " field_lastPushCreateTime:" + paramc.field_lastPushCreateTime);
      AppMethodBeat.o(20507);
      return;
    }
    ac.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] insert msg count[%s] isFetchUp:%s", new Object[] { Integer.valueOf(paramLinkedList.size()), Boolean.valueOf(paramBoolean1) });
    paramc = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcm();
    Object localObject1 = a(paramString, paramLinkedList);
    Object localObject2 = paramc.akS(paramString);
    ((d)localObject2).fCc.clear();
    ((d)localObject2).fCc.addAll((Collection)localObject1);
    paramBoolean1 = paramc.a(paramString, (d)localObject2);
    long l1 = ((bo)paramLinkedList.getLast()).field_msgSeq;
    long l2 = ((bo)paramLinkedList.getLast()).field_createTime;
    long l3 = paramc.akP(paramString);
    long l4 = paramc.akR(paramString);
    ac.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] blockList size:%s ret:%s GetSeq:[last %s:old %s] GetLocalCreateTime:[last %s:old %s]", new Object[] { Integer.valueOf(((d)localObject2).fCc.size()), Boolean.valueOf(paramBoolean1), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4) });
    if (l3 < l1)
    {
      paramc.aA(paramString, l1);
      paramc.ay(paramString, l2);
    }
    for (;;)
    {
      d(new HashMap(this.hFJ), paramString);
      AppMethodBeat.o(20507);
      return;
      ac.w("MicroMsg.GetChatroomMsgReceiver", "oldGetSeq>=lastGetSeq [%s:%s]", new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
    }
  }
  
  static final class a
    implements Runnable
  {
    tg hFL;
    
    private a(tg paramtg)
    {
      this.hFL = paramtg;
    }
    
    public final void run()
    {
      AppMethodBeat.i(20505);
      long l3 = System.currentTimeMillis();
      label512:
      label521:
      label808:
      label2093:
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        int i;
        long l5;
        Object localObject5;
        long l2;
        Object localObject6;
        int n;
        long l1;
        int j;
        int m;
        bo localbo;
        label617:
        label624:
        Object localObject2;
        try
        {
          if (!g.agM())
          {
            ac.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] accHasReady no!");
            ac.d("MicroMsg.GetChatroomMsgReceiver", "[HandlePushTask$run] cost:" + (System.currentTimeMillis() - l3));
            AppMethodBeat.o(20505);
            return;
          }
          localObject1 = this.hFL.dwl.data;
          if (localObject1 == null) {
            break label2007;
          }
          localObject3 = new cv();
        }
        catch (Exception localException1)
        {
          try
          {
            Object localObject1;
            ((cv)localObject3).parseFrom((byte[])localObject1);
            long l4 = System.currentTimeMillis();
            localObject4 = com.tencent.mm.platformtools.z.a(((cv)localObject3).DQb);
            i = ((cv)localObject3).DQa;
            l5 = 1000L * ((cv)localObject3).CreateTime;
            localObject5 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcm();
            if (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).akT((String)localObject4))
            {
              ac.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#update] chatRoomId:%s updatePushSeqRet[%s]:%s updatePushCreateTimeRet[%s]:%s", new Object[] { localObject4, Integer.valueOf(i), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).ax((String)localObject4, i)), Long.valueOf(l5), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).az((String)localObject4, l5)) });
              ac.d("MicroMsg.GetChatroomMsgReceiver", "[updateChatroomMsgSeq] cost:" + (System.currentTimeMillis() - l4));
              l2 = System.currentTimeMillis();
              localObject6 = com.tencent.mm.platformtools.z.a(((cv)localObject3).DQb);
              n = ((cv)localObject3).DQa;
              l1 = ((cv)localObject3).vTQ;
              j = ((cv)localObject3).CreateTime;
              int k = ((cv)localObject3).DQe;
              m = ((cv)localObject3).tit;
              i = ((cv)localObject3).DQc;
              localObject3 = com.tencent.mm.platformtools.z.a(((cv)localObject3).DQd);
              ac.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", new Object[] { localObject6, Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), bs.aLJ((String)localObject3) });
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNI((String)localObject6);
              if (localObject1 != null) {
                break label1237;
              }
              localObject1 = new com.tencent.mm.storage.ap((String)localObject6);
              ((com.tencent.mm.storage.ap)localObject1).ou(j * 1000L);
              ((com.tencent.mm.storage.ap)localObject1).ow(n);
              ((com.tencent.mm.storage.ap)localObject1).jR(1);
              ((com.tencent.mm.storage.ap)localObject1).jY(1);
              b.aER();
              b.Ca((String)localObject6);
              l1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).axd().akX((String)localObject6);
              ac.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", new Object[] { Long.valueOf(l1), Integer.valueOf(n) });
              if (l1 <= 0L) {
                break label2057;
              }
              ((com.tencent.mm.storage.ap)localObject1).ox(l1);
              i = 1;
              if (k > 0) {
                ((com.tencent.mm.storage.ap)localObject1).jW(((com.tencent.mm.g.c.az)localObject1).field_atCount + k);
              }
              localbo = new bo();
              localbo.jT(0);
              localbo.re((String)localObject6);
              localbo.setType(m);
              localbo.setContent((String)localObject3);
              if (m != 49) {
                break label1566;
              }
              localObject4 = k.b.vA(com.tencent.mm.pluginsdk.model.app.k.kV((String)localObject6, (String)localObject3));
              localbo.setType(com.tencent.mm.pluginsdk.model.app.m.f((k.b)localObject4));
              if (!localbo.eZj()) {
                break label2080;
              }
              localObject3 = ((k.b)localObject4).content;
              localbo.setContent((String)localObject3);
              ((com.tencent.mm.storage.ap)localObject1).jT(0);
              ((com.tencent.mm.storage.ap)localObject1).setContent(localbo.field_content);
              ((com.tencent.mm.storage.ap)localObject1).qQ(Integer.toString(localbo.getType()));
              localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().Ls();
              if (localObject3 == null) {
                break label1897;
              }
              localObject4 = new PString();
              localObject5 = new PString();
              PInt localPInt = new PInt();
              ((bk.b)localObject3).a(localbo, (PString)localObject4, (PString)localObject5, localPInt, false);
              ((com.tencent.mm.storage.ap)localObject1).qR(((PString)localObject4).value);
              ((com.tencent.mm.storage.ap)localObject1).qS(((PString)localObject5).value);
              ((com.tencent.mm.storage.ap)localObject1).jU(localPInt.value);
              if (localbo.getType() == 49)
              {
                localObject3 = (String)bv.L(((com.tencent.mm.g.c.az)localObject1).field_content, "msg").get(".msg.appmsg.title");
                localObject4 = bs.nullAsNil(((com.tencent.mm.g.c.az)localObject1).field_digest);
                if (!bs.isNullOrNil((String)localObject3)) {
                  break label1871;
                }
                localObject3 = "";
                ((com.tencent.mm.storage.ap)localObject1).qR(((String)localObject4).concat((String)localObject3));
              }
              label820:
              if (i == 0) {
                break label1910;
              }
              ac.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { localObject6, Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().e((com.tencent.mm.storage.ap)localObject1)), Long.valueOf(((com.tencent.mm.g.c.az)localObject1).field_firstUnDeliverSeq), Long.valueOf(((com.tencent.mm.g.c.az)localObject1).field_lastSeq), Integer.valueOf(((com.tencent.mm.g.c.az)localObject1).field_UnDeliverCount) });
              ac.d("MicroMsg.GetChatroomMsgReceiver", "[updateConv] cost:" + (System.currentTimeMillis() - l2));
              continue;
              localException1 = localException1;
              ac.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", localException1, "", new Object[0]);
            }
          }
          catch (Exception localException2)
          {
            ac.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", localException2, "", new Object[0]);
            continue;
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().all((String)localObject4);
            if (localObject2 == null) {
              break label2018;
            }
          }
        }
        if (((dy)localObject2).field_msgId == 0L)
        {
          ac.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] has not any ReceivedMsg!");
          localObject2 = null;
          label1016:
          if (localObject2 != null)
          {
            localObject6 = com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", ((dy)localObject2).field_createTime / 1000L);
            ac.w("MicroMsg.GetChatroomMsgReceiver", "[lastFaultMsgInfo] lastFaultMsgInfo:%s timeFormat:%s", new Object[] { bs.aLJ(((dy)localObject2).field_content), localObject6 });
          }
          localObject6 = new com.tencent.mm.storage.z();
          ((com.tencent.mm.storage.z)localObject6).field_username = ((String)localObject4);
          ((com.tencent.mm.storage.z)localObject6).field_lastPushSeq = i;
          if (localObject2 == null) {
            break label2021;
          }
          l1 = ((dy)localObject2).field_msgSeq;
          label1101:
          ((com.tencent.mm.storage.z)localObject6).field_lastLocalSeq = l1;
          ((com.tencent.mm.storage.z)localObject6).field_lastPushCreateTime = l5;
          if (localObject2 == null) {
            break label2030;
          }
          l1 = ((dy)localObject2).field_createTime;
          label1127:
          ((com.tencent.mm.storage.z)localObject6).field_lastLocalCreateTime = l1;
          long l6 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).a((com.tencent.mm.storage.z)localObject6);
          if (localObject2 == null) {
            break label2039;
          }
          l1 = ((dy)localObject2).field_msgSeq;
          if (localObject2 == null) {
            break label2048;
          }
          l2 = ((dy)localObject2).field_createTime;
          ac.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#insert] ret:%s,chatRoomId:%s updatePushSeq:%s updatePushCreateTime:%s field_lastLocalSeq:%s field_lastLocalCreateTime:%s", new Object[] { Long.valueOf(l6), localObject4, Integer.valueOf(i), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l2) });
          localObject2 = com.tencent.mm.ui.chatting.k.b.Igg;
          com.tencent.mm.ui.chatting.k.b.fqg();
          continue;
          label1237:
          int i1 = (int)((com.tencent.mm.g.c.az)localObject2).field_lastSeq;
          if (n > i1)
          {
            ((com.tencent.mm.storage.ap)localObject2).ow(n);
            int i2 = ((com.tencent.mm.g.c.az)localObject2).field_UnDeliverCount;
            ((com.tencent.mm.storage.ap)localObject2).jY(i);
            ((com.tencent.mm.storage.ap)localObject2).ou(j * 1000L);
            if (i > ((com.tencent.mm.g.c.az)localObject2).field_unReadCount) {}
            for (;;)
            {
              j = i;
              if (i < 0)
              {
                ac.e("MicroMsg.GetChatroomMsgReceiver", "why???, unreadCount %d", new Object[] { Integer.valueOf(i) });
                j = 0;
              }
              ((com.tencent.mm.storage.ap)localObject2).jR(j);
              l1 = ((com.tencent.mm.g.c.az)localObject2).field_firstUnDeliverSeq;
              ac.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv  msgSeq[%d], firstSeq[%d], lastseq[%d]", new Object[] { Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1) });
              if (l1 <= 0L) {
                break;
              }
              localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().aG((String)localObject6, i1);
              if (((dy)localObject4).field_msgId <= 0L) {
                break label2065;
              }
              ((com.tencent.mm.storage.ap)localObject2).ox(((dy)localObject4).field_msgSeq);
              break label2065;
              i = i - i2 + ((com.tencent.mm.g.c.az)localObject2).field_unReadCount;
            }
            l1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).axd().akX((String)localObject6);
            if (l1 > 0L)
            {
              ((com.tencent.mm.storage.ap)localObject2).ox(l1);
              i = 0;
              continue;
            }
            l1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alD((String)localObject6);
            ac.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv lastMsgSeq[%s]", new Object[] { Long.valueOf(l1) });
            if (l1 <= 0L) {
              break label2070;
            }
            ((com.tencent.mm.storage.ap)localObject2).ox(l1);
            break label2070;
          }
          if ((n != i1) || (i != 0) || (((com.tencent.mm.g.c.az)localObject2).field_unReadCount <= 0)) {
            break label2075;
          }
          ((com.tencent.mm.storage.ap)localObject2).jR(0);
          break label2075;
          if (m != 10002) {
            continue;
          }
          ((q)g.ad(q.class)).getSysCmdMsgExtension();
          if ((localbo.getType() != 10002) || (bs.isNullOrNil((String)localObject3))) {
            continue;
          }
          if (bs.isNullOrNil((String)localObject3))
          {
            ac.e("MicroMsg.SysCmdMsgExtension", "null msg content");
            continue;
          }
          if (((String)localObject3).startsWith("~SEMI_XML~"))
          {
            localObject5 = bi.aLg((String)localObject3);
            if (localObject5 != null) {
              break label2083;
            }
            ac.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[] { localObject3 });
            continue;
          }
        }
        for (;;)
        {
          if ((localObject4 == null) || (!((String)localObject4).equals("revokemsg"))) {
            break label2093;
          }
          ac.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
          ((Map)localObject3).get(".sysmsg.revokemsg.session");
          localObject4 = (String)((Map)localObject3).get(".sysmsg.revokemsg.newmsgid");
          localObject3 = (String)((Map)localObject3).get(".sysmsg.revokemsg.replacemsg");
          ac.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject4, localObject3 });
          localbo.setContent((String)localObject3);
          localbo.setType(10000);
          break label624;
          j = ((String)localObject3).indexOf("<sysmsg");
          if (j == -1)
          {
            ac.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
            break label624;
          }
          localObject4 = bv.L(((String)localObject3).substring(j), "sysmsg");
          if (localObject4 == null)
          {
            ac.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject3 });
            break label624;
          }
          localObject5 = (String)((Map)localObject4).get(".sysmsg.$type");
          localObject3 = localObject4;
          localObject4 = localObject5;
          continue;
          label1871:
          localObject3 = " " + bs.nullAsNil((String)localObject3);
          break label808;
          label1897:
          ((com.tencent.mm.storage.ap)localObject2).qR(((com.tencent.mm.g.c.az)localObject2).field_content);
          break label820;
          label1910:
          ((com.tencent.mm.storage.ap)localObject2).jV(((com.tencent.mm.g.c.az)localObject2).field_attrflag & 0xFFEFFFFF);
          ac.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { localObject6, Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().a((com.tencent.mm.storage.ap)localObject2, (String)localObject6, true)), Long.valueOf(((com.tencent.mm.g.c.az)localObject2).field_firstUnDeliverSeq), Long.valueOf(((com.tencent.mm.g.c.az)localObject2).field_lastSeq), Integer.valueOf(((com.tencent.mm.g.c.az)localObject2).field_UnDeliverCount) });
          break label900;
          label2007:
          ac.e("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] data is null");
          break;
          label2018:
          break label1016;
          label2021:
          l1 = i - 1;
          break label1101;
          label2030:
          l1 = l5 - 1L;
          break label1127;
          label2039:
          l1 = i - 1;
          break label1157;
          l2 = l5 - 1L;
          break label1169;
          l1 = n;
          break label512;
          i = 0;
          break label521;
          i = 0;
          break label521;
          i = 0;
          break label521;
          break label617;
          localObject4 = "brand_service";
          localObject3 = localObject5;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.as.c
 * JD-Core Version:    0.7.0.1
 */