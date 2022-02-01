package com.tencent.mm.at;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.e.a;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.g.a.iu.a;
import com.tencent.mm.g.a.ty;
import com.tencent.mm.g.a.ty.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.b;
import com.tencent.mm.storage.bu;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  extends com.tencent.mm.sdk.b.c<ty>
  implements b.a, k.a, n.b
{
  public final com.tencent.mm.sdk.b.c hYn;
  private Map<Long, bn> hYo;
  
  public c()
  {
    AppMethodBeat.i(20506);
    this.hYn = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(iu paramAnonymousiu)
      {
        AppMethodBeat.i(20503);
        long l2 = System.currentTimeMillis();
        for (;;)
        {
          bu localbu;
          try
          {
            Object localObject1 = ((l)g.ab(l.class)).dlF();
            if (!((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).apF(paramAnonymousiu.dvt.username))
            {
              localObject2 = new com.tencent.mm.storage.ad();
              ((com.tencent.mm.storage.ad)localObject2).field_username = paramAnonymousiu.dvt.username;
              if (paramAnonymousiu.dvt.dvu <= paramAnonymousiu.dvt.dvw)
              {
                l1 = paramAnonymousiu.dvt.dvw;
                ((com.tencent.mm.storage.ad)localObject2).field_lastPushSeq = l1;
                ((com.tencent.mm.storage.ad)localObject2).field_lastLocalSeq = paramAnonymousiu.dvt.dvw;
                ((com.tencent.mm.storage.ad)localObject2).field_lastPushCreateTime = paramAnonymousiu.dvt.dvv;
                ((com.tencent.mm.storage.ad)localObject2).field_lastLocalCreateTime = paramAnonymousiu.dvt.dvx;
                l1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).a((com.tencent.mm.storage.ad)localObject2, true);
                localObject1 = com.tencent.mm.ui.chatting.l.b.JWt;
                com.tencent.mm.ui.chatting.l.b.fGU();
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] ret:%s,chatRoomId:%s lastPushSeq:%s lastPushCreateTime:%s lastLocalSeq:%s lastLocalCreateTime:%s", new Object[] { Long.valueOf(l1), paramAnonymousiu.dvt.username, Long.valueOf(paramAnonymousiu.dvt.dvu), Long.valueOf(paramAnonymousiu.dvt.dvv), Long.valueOf(paramAnonymousiu.dvt.dvw), Long.valueOf(paramAnonymousiu.dvt.dvx) });
                return true;
              }
              l1 = paramAnonymousiu.dvt.dvu;
              continue;
            }
            Object localObject2 = paramAnonymousiu.dvt.username;
            localbu = ((l)g.ab(l.class)).dlK().apZ((String)localObject2);
            l1 = paramAnonymousiu.dvt.dvu;
            long l3 = paramAnonymousiu.dvt.dvv;
            paramAnonymousiu = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).apH((String)localObject2);
            long l4 = paramAnonymousiu.field_lastLocalSeq;
            long l5 = paramAnonymousiu.field_lastLocalCreateTime;
            long l6 = paramAnonymousiu.field_lastPushSeq;
            long l7 = paramAnonymousiu.field_lastPushCreateTime;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] isGetChatroom! %s conPushSeq:%s conPushCreateTime:%s localSeq:%s localCreateTime:%s pushSeq:%s pushCreateTime:%s", new Object[] { localObject2, Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7) });
            if ((localbu != null) && (localbu.field_msgId != 0L))
            {
              long l8 = localbu.field_msgSeq;
              if (l8 > l4)
              {
                paramAnonymousiu.field_lastLocalSeq = l8;
                paramAnonymousiu.field_lastLocalCreateTime = localbu.field_createTime;
                com.tencent.mm.k.a.a.c localc = new com.tencent.mm.k.a.a.c();
                localc.fVm = (1L + l4);
                localc.fVo = (l5 + 1L);
                localc.fVn = (l8 - 1L);
                localc.fVp = (l7 - 1L);
                if (paramAnonymousiu.field_seqBlockInfo == null) {
                  paramAnonymousiu.field_seqBlockInfo = new d();
                }
                paramAnonymousiu.field_seqBlockInfo.fVq.addLast(localc);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage local seq is smaller than MsgInfoStg local seq! ret:[%s]", new Object[] { Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).b(paramAnonymousiu)) });
              }
              if (l6 < l1) {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage push seq is smaller than conversation seq! ret:[%s,%s] [%s,%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aA((String)localObject2, l1)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aC((String)localObject2, l3)), Long.valueOf(localbu.field_msgSeq), Long.valueOf(l4) });
              }
              return true;
            }
            if (localbu == null)
            {
              bool = true;
              if (localbu != null) {
                break label747;
              }
              l1 = -1L;
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.GetChatroomMsgReceiver", "lastMsgInfo is null? %s lastMsgInfo id:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
              continue;
            }
            boolean bool = false;
          }
          finally
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
            AppMethodBeat.o(20503);
          }
          continue;
          label747:
          long l1 = localbu.field_msgId;
        }
      }
    };
    this.hYo = new HashMap();
    a.IbL.c(this.hYn);
    b.aHW().hYg = this;
    ((l)g.ab(l.class)).azv().a(this, g.ajF().IdO.getLooper());
    p.aJy();
    p.aJw().add(this, com.tencent.mm.model.ba.ajF().IdO.getLooper());
    this.__eventId = ty.class.getName().hashCode();
    AppMethodBeat.o(20506);
  }
  
  private static List<com.tencent.mm.k.a.a.c> a(String paramString, LinkedList<bu> paramLinkedList)
  {
    AppMethodBeat.i(20509);
    Object localObject2 = ((l)g.ab(l.class)).dlF();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).apE(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nchatroomId:").append(paramString);
    long l1 = ((bu)paramLinkedList.getFirst()).field_msgSeq;
    long l2 = ((bu)paramLinkedList.getLast()).field_msgSeq;
    long l3 = ((bu)paramLinkedList.getFirst()).field_createTime;
    long l4 = ((bu)paramLinkedList.getLast()).field_createTime;
    localStringBuilder.append("\ngetFirst:").append(l1);
    localStringBuilder.append(" getLast:").append(l2);
    localStringBuilder.append(" getFirstCreateTime:").append(l3);
    localStringBuilder.append(" getLastCreateTime:").append(l4);
    localStringBuilder.append("\nblock ");
    paramLinkedList = new com.tencent.mm.k.a.a.c();
    paramLinkedList.fVm = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).apB(paramString) + 1L);
    paramLinkedList.fVo = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).apD(paramString) + 1L);
    paramLinkedList.fVn = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).apA(paramString);
    paramLinkedList.fVp = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).apC(paramString);
    if (paramLinkedList.fVn - paramLinkedList.fVm >= 0L) {
      ((d)localObject1).fVq.add(paramLinkedList);
    }
    for (;;)
    {
      paramString = new LinkedList();
      paramLinkedList = ((d)localObject1).fVq.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject1 = (com.tencent.mm.k.a.a.c)paramLinkedList.next();
        int j = 0;
        long l5 = ((com.tencent.mm.k.a.a.c)localObject1).fVm;
        long l6 = ((com.tencent.mm.k.a.a.c)localObject1).fVn;
        long l7 = ((com.tencent.mm.k.a.a.c)localObject1).fVo;
        long l8 = ((com.tencent.mm.k.a.a.c)localObject1).fVp;
        localStringBuilder.append("[").append(l5).append(":").append(l6).append("][").append(l7).append(":").append(l8).append("] | ");
        int i = j;
        if (l5 <= l1)
        {
          i = j;
          if (l1 <= l6)
          {
            localObject2 = new com.tencent.mm.k.a.a.c();
            ((com.tencent.mm.k.a.a.c)localObject2).fVm = ((com.tencent.mm.k.a.a.c)localObject1).fVm;
            ((com.tencent.mm.k.a.a.c)localObject2).fVn = (l1 - 1L);
            ((com.tencent.mm.k.a.a.c)localObject2).fVo = l7;
            ((com.tencent.mm.k.a.a.c)localObject2).fVp = (l3 - 1L);
            i = j;
            if (((com.tencent.mm.k.a.a.c)localObject2).fVn - ((com.tencent.mm.k.a.a.c)localObject2).fVm >= 0L)
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
            ((com.tencent.mm.k.a.a.c)localObject2).fVm = (1L + l2);
            ((com.tencent.mm.k.a.a.c)localObject2).fVn = l6;
            ((com.tencent.mm.k.a.a.c)localObject2).fVo = (1L + l4);
            ((com.tencent.mm.k.a.a.c)localObject2).fVp = l8;
            j = i;
            if (((com.tencent.mm.k.a.a.c)localObject2).fVn - ((com.tencent.mm.k.a.a.c)localObject2).fVm >= 0L)
            {
              paramString.add(localObject2);
              j = 1;
            }
          }
        }
        if ((j == 0) && ((l1 > l6) || (l2 < l5)))
        {
          paramString.add(localObject1);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] add raw block!");
        }
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] lastSeq[%s]<firstSeq[%s]", new Object[] { Long.valueOf(paramLinkedList.fVn), Long.valueOf(paramLinkedList.fVm) });
    }
    paramLinkedList = new StringBuilder();
    localObject1 = paramString.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.k.a.a.c)((Iterator)localObject1).next();
      paramLinkedList.append("[").append(((com.tencent.mm.k.a.a.c)localObject2).fVm).append(":").append(((com.tencent.mm.k.a.a.c)localObject2).fVn).append("][").append(((com.tencent.mm.k.a.a.c)localObject2).fVo).append(":").append(((com.tencent.mm.k.a.a.c)localObject2).fVp).append("] | ");
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] " + localStringBuilder.toString() + "\nnew blockList:" + paramLinkedList.toString());
    AppMethodBeat.o(20509);
    return paramString;
  }
  
  private static void d(Map<Long, bn> paramMap, String paramString)
  {
    AppMethodBeat.i(20511);
    if ((paramMap.size() == 0) || (af.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(20511);
      return;
    }
    paramMap = paramMap.values().iterator();
    if (paramMap != null) {
      while (paramMap.hasNext())
      {
        Object localObject1 = (bn)paramMap.next();
        if ((localObject1 != null) && (paramString.equals(((bn)localObject1).field_fromUserName)))
        {
          com.tencent.mm.model.ba.aBQ();
          Object localObject2 = com.tencent.mm.model.c.azs().aI(paramString, ((bn)localObject1).field_originSvrId);
          if (((ei)localObject2).field_msgId != 0L)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", new Object[] { Long.valueOf(((ei)localObject2).field_msgId), Long.valueOf(((ei)localObject2).field_msgSvrId) });
            localObject2 = new cv();
            ((cv)localObject2).xbt = ((bn)localObject1).field_newMsgId;
            ((cv)localObject2).Fvi = z.IX(((bn)localObject1).field_fromUserName);
            ((cv)localObject2).Fvj = z.IX(((bn)localObject1).field_toUserName);
            ((cv)localObject2).CreateTime = ((int)((bn)localObject1).field_createTime);
            ((cv)localObject2).Fvk = z.IX(((bn)localObject1).field_content);
            ((cv)localObject2).Fvn = ((bn)localObject1).field_msgSource;
            ((cv)localObject2).Fvp = ((bn)localObject1).field_msgSeq;
            int i = ((bn)localObject1).field_flag;
            ((cv)localObject2).ugm = 10002;
            localObject1 = com.tencent.mm.model.ba.getSysCmdMsgExtension();
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
              ((cd)localObject1).b(new e.a((cv)localObject2, bool1, bool2, bool3));
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
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(20508);
    if ((paramn == ((l)g.ab(l.class)).azv()) && ((paramObject instanceof String)) && (5 == paramInt))
    {
      paramn = ((l)g.ab(l.class)).dlF();
      paramObject = (String)paramObject;
      if (paramn.apF(paramObject))
      {
        com.tencent.mm.storage.ad localad = paramn.apH(paramObject);
        if (localad.field_seqBlockInfo != null) {
          localad.field_seqBlockInfo.fVq.clear();
        }
        localad.field_lastLocalSeq = localad.field_lastPushSeq;
        localad.field_lastLocalCreateTime = localad.field_lastPushCreateTime;
        long l = paramn.b(localad);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "[onNotifyChange] username:" + paramObject + " ret:" + l + " chatroomMsgSeq:" + localad.toString());
      }
    }
    AppMethodBeat.o(20508);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(20510);
    if (!af.isNullOrNil(paramString)) {
      try
      {
        long l = Long.valueOf(paramString).longValue();
        paramString = new bn();
        paramString.field_originSvrId = l;
        p.aJy();
        if (p.aJw().get(paramString, new String[0]))
        {
          this.hYo.put(Long.valueOf(l), paramString);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange put info systemRowid[%d], svrId[%d]", new Object[] { Long.valueOf(paramString.systemRowid), Long.valueOf(l) });
          AppMethodBeat.o(20510);
          return;
        }
        this.hYo.remove(Long.valueOf(l));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange remove info svrId[%d]", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(20510);
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", paramString, "summerbadcr dealSysCmdMsg onNotifyChange:", new Object[0]);
      }
    }
    AppMethodBeat.o(20510);
  }
  
  public final void a(String paramString, boolean paramBoolean1, LinkedList<bu> paramLinkedList, com.tencent.mm.k.a.a.c paramc, boolean paramBoolean2)
  {
    AppMethodBeat.i(20507);
    if ((paramLinkedList.size() <= 0) || (paramBoolean2))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.GetChatroomMsgReceiver", "[onFetched] fetchList.size() == 0! removeBlock! isBlockAll:".concat(String.valueOf(paramBoolean2)));
      l1 = paramc.fVm;
      l2 = paramc.fVn;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString);
      paramLinkedList = ((l)g.ab(l.class)).dlF();
      paramc = paramLinkedList.apH(paramString);
      if (paramc.field_seqBlockInfo != null)
      {
        localObject1 = new LinkedList();
        localObject2 = paramc.field_seqBlockInfo.fVq.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.k.a.a.c localc = (com.tencent.mm.k.a.a.c)((Iterator)localObject2).next();
          if ((localc.fVm == l1) && (localc.fVn == l2)) {
            ((List)localObject1).add(localc);
          }
        }
        paramc.field_seqBlockInfo.fVq.removeAll((Collection)localObject1);
        l3 = paramLinkedList.b(paramc);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString + " ret:" + l3 + " remove list:" + ((List)localObject1).size());
        if (((List)localObject1).size() > 0)
        {
          localObject1 = com.tencent.mm.ui.chatting.l.b.JWt;
          com.tencent.mm.ui.chatting.l.b.fGW();
        }
      }
      paramc.field_lastLocalSeq = paramc.field_lastPushSeq;
      paramc.field_lastLocalCreateTime = paramc.field_lastPushCreateTime;
      l3 = paramLinkedList.b(paramc);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString + " ret:" + l3 + " lastPushSeq:" + paramc.field_lastPushSeq + " field_lastPushCreateTime:" + paramc.field_lastPushCreateTime);
      AppMethodBeat.o(20507);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] insert msg count[%s] isFetchUp:%s", new Object[] { Integer.valueOf(paramLinkedList.size()), Boolean.valueOf(paramBoolean1) });
    paramc = ((l)g.ab(l.class)).dlF();
    Object localObject1 = a(paramString, paramLinkedList);
    Object localObject2 = paramc.apE(paramString);
    ((d)localObject2).fVq.clear();
    ((d)localObject2).fVq.addAll((Collection)localObject1);
    paramBoolean1 = paramc.a(paramString, (d)localObject2);
    long l1 = ((bu)paramLinkedList.getLast()).field_msgSeq;
    long l2 = ((bu)paramLinkedList.getLast()).field_createTime;
    long l3 = paramc.apB(paramString);
    long l4 = paramc.apD(paramString);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] blockList size:%s ret:%s GetSeq:[last %s:old %s] GetLocalCreateTime:[last %s:old %s]", new Object[] { Integer.valueOf(((d)localObject2).fVq.size()), Boolean.valueOf(paramBoolean1), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4) });
    if (l3 < l1)
    {
      paramc.aD(paramString, l1);
      paramc.aB(paramString, l2);
    }
    for (;;)
    {
      d(new HashMap(this.hYo), paramString);
      AppMethodBeat.o(20507);
      return;
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.GetChatroomMsgReceiver", "oldGetSeq>=lastGetSeq [%s:%s]", new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
    }
  }
  
  static final class a
    implements Runnable
  {
    ty hYq;
    
    private a(ty paramty)
    {
      this.hYq = paramty;
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
        bu localbu;
        label617:
        label624:
        Object localObject2;
        try
        {
          if (!g.ajx())
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] accHasReady no!");
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.GetChatroomMsgReceiver", "[HandlePushTask$run] cost:" + (System.currentTimeMillis() - l3));
            AppMethodBeat.o(20505);
            return;
          }
          localObject1 = this.hYq.dIv.data;
          if (localObject1 == null) {
            break label2007;
          }
          localObject3 = new cw();
        }
        catch (Exception localException1)
        {
          try
          {
            Object localObject1;
            ((cw)localObject3).parseFrom((byte[])localObject1);
            long l4 = System.currentTimeMillis();
            localObject4 = z.a(((cw)localObject3).Fvq);
            i = ((cw)localObject3).Fvp;
            l5 = 1000L * ((cw)localObject3).CreateTime;
            localObject5 = ((l)g.ab(l.class)).dlF();
            if (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).apF((String)localObject4))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#update] chatRoomId:%s updatePushSeqRet[%s]:%s updatePushCreateTimeRet[%s]:%s", new Object[] { localObject4, Integer.valueOf(i), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).aA((String)localObject4, i)), Long.valueOf(l5), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).aC((String)localObject4, l5)) });
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.GetChatroomMsgReceiver", "[updateChatroomMsgSeq] cost:" + (System.currentTimeMillis() - l4));
              l2 = System.currentTimeMillis();
              localObject6 = z.a(((cw)localObject3).Fvq);
              n = ((cw)localObject3).Fvp;
              l1 = ((cw)localObject3).xbt;
              j = ((cw)localObject3).CreateTime;
              int k = ((cw)localObject3).Fvt;
              m = ((cw)localObject3).ugm;
              i = ((cw)localObject3).Fvr;
              localObject3 = z.a(((cw)localObject3).Fvs);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", new Object[] { localObject6, Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), bt.aRp((String)localObject3) });
              localObject1 = ((l)g.ab(l.class)).azv().aTz((String)localObject6);
              if (localObject1 != null) {
                break label1237;
              }
              localObject1 = new at((String)localObject6);
              ((at)localObject1).qu(j * 1000L);
              ((at)localObject1).qw(n);
              ((at)localObject1).kp(1);
              ((at)localObject1).kw(1);
              b.aHW();
              b.EZ((String)localObject6);
              l1 = ((l)g.ab(l.class)).azS().apJ((String)localObject6);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", new Object[] { Long.valueOf(l1), Integer.valueOf(n) });
              if (l1 <= 0L) {
                break label2057;
              }
              ((at)localObject1).qx(l1);
              i = 1;
              if (k > 0) {
                ((at)localObject1).ku(((com.tencent.mm.g.c.ba)localObject1).field_atCount + k);
              }
              localbu = new bu();
              localbu.kr(0);
              localbu.tN((String)localObject6);
              localbu.setType(m);
              localbu.setContent((String)localObject3);
              if (m != 49) {
                break label1566;
              }
              localObject4 = k.b.yr(k.ls((String)localObject6, (String)localObject3));
              localbu.setType(com.tencent.mm.pluginsdk.model.app.m.g((k.b)localObject4));
              if (!localbu.fpd()) {
                break label2080;
              }
              localObject3 = ((k.b)localObject4).content;
              localbu.setContent((String)localObject3);
              ((at)localObject1).kr(0);
              ((at)localObject1).setContent(localbu.field_content);
              ((at)localObject1).tA(Integer.toString(localbu.getType()));
              localObject3 = ((l)g.ab(l.class)).azv().Na();
              if (localObject3 == null) {
                break label1897;
              }
              localObject4 = new PString();
              localObject5 = new PString();
              PInt localPInt = new PInt();
              ((bq.b)localObject3).a(localbu, (PString)localObject4, (PString)localObject5, localPInt, false);
              ((at)localObject1).tB(((PString)localObject4).value);
              ((at)localObject1).tC(((PString)localObject5).value);
              ((at)localObject1).ks(localPInt.value);
              if (localbu.getType() == 49)
              {
                localObject3 = (String)bw.M(((com.tencent.mm.g.c.ba)localObject1).field_content, "msg").get(".msg.appmsg.title");
                localObject4 = bt.nullAsNil(((com.tencent.mm.g.c.ba)localObject1).field_digest);
                if (!bt.isNullOrNil((String)localObject3)) {
                  break label1871;
                }
                localObject3 = "";
                ((at)localObject1).tB(((String)localObject4).concat((String)localObject3));
              }
              label820:
              if (i == 0) {
                break label1910;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { localObject6, Long.valueOf(((l)g.ab(l.class)).azv().e((at)localObject1)), Long.valueOf(((com.tencent.mm.g.c.ba)localObject1).field_firstUnDeliverSeq), Long.valueOf(((com.tencent.mm.g.c.ba)localObject1).field_lastSeq), Integer.valueOf(((com.tencent.mm.g.c.ba)localObject1).field_UnDeliverCount) });
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.GetChatroomMsgReceiver", "[updateConv] cost:" + (System.currentTimeMillis() - l2));
              continue;
              localException1 = localException1;
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", localException1, "", new Object[0]);
            }
          }
          catch (Exception localException2)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", localException2, "", new Object[0]);
            continue;
            localObject2 = ((l)g.ab(l.class)).dlK().apZ((String)localObject4);
            if (localObject2 == null) {
              break label2018;
            }
          }
        }
        if (((ei)localObject2).field_msgId == 0L)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] has not any ReceivedMsg!");
          localObject2 = null;
          label1016:
          if (localObject2 != null)
          {
            localObject6 = com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", ((ei)localObject2).field_createTime / 1000L);
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.GetChatroomMsgReceiver", "[lastFaultMsgInfo] lastFaultMsgInfo:%s timeFormat:%s", new Object[] { bt.aRp(((ei)localObject2).field_content), localObject6 });
          }
          localObject6 = new com.tencent.mm.storage.ad();
          ((com.tencent.mm.storage.ad)localObject6).field_username = ((String)localObject4);
          ((com.tencent.mm.storage.ad)localObject6).field_lastPushSeq = i;
          if (localObject2 == null) {
            break label2021;
          }
          l1 = ((ei)localObject2).field_msgSeq;
          label1101:
          ((com.tencent.mm.storage.ad)localObject6).field_lastLocalSeq = l1;
          ((com.tencent.mm.storage.ad)localObject6).field_lastPushCreateTime = l5;
          if (localObject2 == null) {
            break label2030;
          }
          l1 = ((ei)localObject2).field_createTime;
          label1127:
          ((com.tencent.mm.storage.ad)localObject6).field_lastLocalCreateTime = l1;
          long l6 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).a((com.tencent.mm.storage.ad)localObject6);
          if (localObject2 == null) {
            break label2039;
          }
          l1 = ((ei)localObject2).field_msgSeq;
          if (localObject2 == null) {
            break label2048;
          }
          l2 = ((ei)localObject2).field_createTime;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#insert] ret:%s,chatRoomId:%s updatePushSeq:%s updatePushCreateTime:%s field_lastLocalSeq:%s field_lastLocalCreateTime:%s", new Object[] { Long.valueOf(l6), localObject4, Integer.valueOf(i), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l2) });
          localObject2 = com.tencent.mm.ui.chatting.l.b.JWt;
          com.tencent.mm.ui.chatting.l.b.fGU();
          continue;
          label1237:
          int i1 = (int)((com.tencent.mm.g.c.ba)localObject2).field_lastSeq;
          if (n > i1)
          {
            ((at)localObject2).qw(n);
            int i2 = ((com.tencent.mm.g.c.ba)localObject2).field_UnDeliverCount;
            ((at)localObject2).kw(i);
            ((at)localObject2).qu(j * 1000L);
            if (i > ((com.tencent.mm.g.c.ba)localObject2).field_unReadCount) {}
            for (;;)
            {
              j = i;
              if (i < 0)
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.GetChatroomMsgReceiver", "why???, unreadCount %d", new Object[] { Integer.valueOf(i) });
                j = 0;
              }
              ((at)localObject2).kp(j);
              l1 = ((com.tencent.mm.g.c.ba)localObject2).field_firstUnDeliverSeq;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv  msgSeq[%d], firstSeq[%d], lastseq[%d]", new Object[] { Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1) });
              if (l1 <= 0L) {
                break;
              }
              localObject4 = ((l)g.ab(l.class)).dlK().aJ((String)localObject6, i1);
              if (((ei)localObject4).field_msgId <= 0L) {
                break label2065;
              }
              ((at)localObject2).qx(((ei)localObject4).field_msgSeq);
              break label2065;
              i = i - i2 + ((com.tencent.mm.g.c.ba)localObject2).field_unReadCount;
            }
            l1 = ((l)g.ab(l.class)).azS().apJ((String)localObject6);
            if (l1 > 0L)
            {
              ((at)localObject2).qx(l1);
              i = 0;
              continue;
            }
            l1 = ((l)g.ab(l.class)).dlK().aqr((String)localObject6);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv lastMsgSeq[%s]", new Object[] { Long.valueOf(l1) });
            if (l1 <= 0L) {
              break label2070;
            }
            ((at)localObject2).qx(l1);
            break label2070;
          }
          if ((n != i1) || (i != 0) || (((com.tencent.mm.g.c.ba)localObject2).field_unReadCount <= 0)) {
            break label2075;
          }
          ((at)localObject2).kp(0);
          break label2075;
          if (m != 10002) {
            continue;
          }
          ((r)g.ad(r.class)).getSysCmdMsgExtension();
          if ((localbu.getType() != 10002) || (bt.isNullOrNil((String)localObject3))) {
            continue;
          }
          if (bt.isNullOrNil((String)localObject3))
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SysCmdMsgExtension", "null msg content");
            continue;
          }
          if (((String)localObject3).startsWith("~SEMI_XML~"))
          {
            localObject5 = bj.aQM((String)localObject3);
            if (localObject5 != null) {
              break label2083;
            }
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[] { localObject3 });
            continue;
          }
        }
        for (;;)
        {
          if ((localObject4 == null) || (!((String)localObject4).equals("revokemsg"))) {
            break label2093;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
          ((Map)localObject3).get(".sysmsg.revokemsg.session");
          localObject4 = (String)((Map)localObject3).get(".sysmsg.revokemsg.newmsgid");
          localObject3 = (String)((Map)localObject3).get(".sysmsg.revokemsg.replacemsg");
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject4, localObject3 });
          localbu.setContent((String)localObject3);
          localbu.setType(10000);
          break label624;
          j = ((String)localObject3).indexOf("<sysmsg");
          if (j == -1)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
            break label624;
          }
          localObject4 = bw.M(((String)localObject3).substring(j), "sysmsg");
          if (localObject4 == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject3 });
            break label624;
          }
          localObject5 = (String)((Map)localObject4).get(".sysmsg.$type");
          localObject3 = localObject4;
          localObject4 = localObject5;
          continue;
          label1871:
          localObject3 = " " + bt.nullAsNil((String)localObject3);
          break label808;
          label1897:
          ((at)localObject2).tB(((com.tencent.mm.g.c.ba)localObject2).field_content);
          break label820;
          label1910:
          ((at)localObject2).kt(((com.tencent.mm.g.c.ba)localObject2).field_attrflag & 0xFFEFFFFF);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { localObject6, Long.valueOf(((l)g.ab(l.class)).azv().a((at)localObject2, (String)localObject6, true)), Long.valueOf(((com.tencent.mm.g.c.ba)localObject2).field_firstUnDeliverSeq), Long.valueOf(((com.tencent.mm.g.c.ba)localObject2).field_lastSeq), Integer.valueOf(((com.tencent.mm.g.c.ba)localObject2).field_UnDeliverCount) });
          break label900;
          label2007:
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] data is null");
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
 * Qualified Name:     com.tencent.mm.at.c
 * JD-Core Version:    0.7.0.1
 */