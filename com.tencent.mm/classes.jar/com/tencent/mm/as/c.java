package com.tencent.mm.as;

import android.os.HandlerThread;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.g.a.iv.a;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.g.a.tz.a;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.b;
import com.tencent.mm.storage.bv;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  extends com.tencent.mm.sdk.b.c<tz>
  implements b.a, k.a, n.b
{
  public final com.tencent.mm.sdk.b.c ibf;
  private Map<Long, bo> ibg;
  
  public c()
  {
    AppMethodBeat.i(20506);
    this.ibf = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(iv paramAnonymousiv)
      {
        AppMethodBeat.i(186360);
        long l2 = System.currentTimeMillis();
        for (;;)
        {
          bv localbv;
          try
          {
            Object localObject1 = ((l)g.ab(l.class)).doE();
            if (!((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aqK(paramAnonymousiv.dwy.username))
            {
              localObject2 = new com.tencent.mm.storage.ae();
              ((com.tencent.mm.storage.ae)localObject2).field_username = paramAnonymousiv.dwy.username;
              if (paramAnonymousiv.dwy.dwz <= paramAnonymousiv.dwy.dwB)
              {
                l1 = paramAnonymousiv.dwy.dwB;
                ((com.tencent.mm.storage.ae)localObject2).field_lastPushSeq = l1;
                ((com.tencent.mm.storage.ae)localObject2).field_lastLocalSeq = paramAnonymousiv.dwy.dwB;
                ((com.tencent.mm.storage.ae)localObject2).field_lastPushCreateTime = paramAnonymousiv.dwy.dwA;
                ((com.tencent.mm.storage.ae)localObject2).field_lastLocalCreateTime = paramAnonymousiv.dwy.dwC;
                l1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).a((com.tencent.mm.storage.ae)localObject2, true);
                localObject1 = com.tencent.mm.ui.chatting.l.b.KsK;
                com.tencent.mm.ui.chatting.l.b.fLm();
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] ret:%s,chatRoomId:%s lastPushSeq:%s lastPushCreateTime:%s lastLocalSeq:%s lastLocalCreateTime:%s", new Object[] { Long.valueOf(l1), paramAnonymousiv.dwy.username, Long.valueOf(paramAnonymousiv.dwy.dwz), Long.valueOf(paramAnonymousiv.dwy.dwA), Long.valueOf(paramAnonymousiv.dwy.dwB), Long.valueOf(paramAnonymousiv.dwy.dwC) });
                return true;
              }
              l1 = paramAnonymousiv.dwy.dwz;
              continue;
            }
            Object localObject2 = paramAnonymousiv.dwy.username;
            localbv = ((l)g.ab(l.class)).doJ().are((String)localObject2);
            l1 = paramAnonymousiv.dwy.dwz;
            long l3 = paramAnonymousiv.dwy.dwA;
            paramAnonymousiv = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aqM((String)localObject2);
            long l4 = paramAnonymousiv.field_lastLocalSeq;
            long l5 = paramAnonymousiv.field_lastLocalCreateTime;
            long l6 = paramAnonymousiv.field_lastPushSeq;
            long l7 = paramAnonymousiv.field_lastPushCreateTime;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] isGetChatroom! %s conPushSeq:%s conPushCreateTime:%s localSeq:%s localCreateTime:%s pushSeq:%s pushCreateTime:%s", new Object[] { localObject2, Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7) });
            if ((localbv != null) && (localbv.field_msgId != 0L))
            {
              long l8 = localbv.field_msgSeq;
              if (l8 > l4)
              {
                paramAnonymousiv.field_lastLocalSeq = l8;
                paramAnonymousiv.field_lastLocalCreateTime = localbv.field_createTime;
                com.tencent.mm.k.a.a.c localc = new com.tencent.mm.k.a.a.c();
                localc.fXs = (1L + l4);
                localc.fXu = (l5 + 1L);
                localc.fXt = (l8 - 1L);
                localc.fXv = (l7 - 1L);
                if (paramAnonymousiv.field_seqBlockInfo == null) {
                  paramAnonymousiv.field_seqBlockInfo = new d();
                }
                paramAnonymousiv.field_seqBlockInfo.fXw.addLast(localc);
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage local seq is smaller than MsgInfoStg local seq! ret:[%s]", new Object[] { Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).b(paramAnonymousiv)) });
              }
              if (l6 < l1) {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage push seq is smaller than conversation seq! ret:[%s,%s] [%s,%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aB((String)localObject2, l1)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aD((String)localObject2, l3)), Long.valueOf(localbv.field_msgSeq), Long.valueOf(l4) });
              }
              return true;
            }
            if (localbv == null)
            {
              bool = true;
              if (localbv != null) {
                break label743;
              }
              l1 = -1L;
              com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetChatroomMsgReceiver", "lastMsgInfo is null? %s lastMsgInfo id:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
              continue;
            }
            boolean bool = false;
          }
          finally
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
            AppMethodBeat.o(186360);
          }
          continue;
          label743:
          long l1 = localbv.field_msgId;
        }
      }
    };
    this.ibg = new HashMap();
    a.IvT.c(this.ibf);
    b.aIn().iaY = this;
    ((l)g.ab(l.class)).azL().a(this, g.ajU().IxZ.getLooper());
    p.aJR();
    p.aJP().add(this, bc.ajU().IxZ.getLooper());
    this.__eventId = tz.class.getName().hashCode();
    AppMethodBeat.o(20506);
  }
  
  private static List<com.tencent.mm.k.a.a.c> a(String paramString, LinkedList<bv> paramLinkedList)
  {
    AppMethodBeat.i(20509);
    Object localObject2 = ((l)g.ab(l.class)).doE();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aqJ(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nchatroomId:").append(paramString);
    long l1 = ((bv)paramLinkedList.getFirst()).field_msgSeq;
    long l2 = ((bv)paramLinkedList.getLast()).field_msgSeq;
    long l3 = ((bv)paramLinkedList.getFirst()).field_createTime;
    long l4 = ((bv)paramLinkedList.getLast()).field_createTime;
    localStringBuilder.append("\ngetFirst:").append(l1);
    localStringBuilder.append(" getLast:").append(l2);
    localStringBuilder.append(" getFirstCreateTime:").append(l3);
    localStringBuilder.append(" getLastCreateTime:").append(l4);
    localStringBuilder.append("\nblock ");
    paramLinkedList = new com.tencent.mm.k.a.a.c();
    paramLinkedList.fXs = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aqG(paramString) + 1L);
    paramLinkedList.fXu = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aqI(paramString) + 1L);
    paramLinkedList.fXt = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aqF(paramString);
    paramLinkedList.fXv = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aqH(paramString);
    if (paramLinkedList.fXt - paramLinkedList.fXs >= 0L) {
      ((d)localObject1).fXw.add(paramLinkedList);
    }
    for (;;)
    {
      paramString = new LinkedList();
      paramLinkedList = ((d)localObject1).fXw.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject1 = (com.tencent.mm.k.a.a.c)paramLinkedList.next();
        int j = 0;
        long l5 = ((com.tencent.mm.k.a.a.c)localObject1).fXs;
        long l6 = ((com.tencent.mm.k.a.a.c)localObject1).fXt;
        long l7 = ((com.tencent.mm.k.a.a.c)localObject1).fXu;
        long l8 = ((com.tencent.mm.k.a.a.c)localObject1).fXv;
        localStringBuilder.append("[").append(l5).append(":").append(l6).append("][").append(l7).append(":").append(l8).append("] | ");
        int i = j;
        if (l5 <= l1)
        {
          i = j;
          if (l1 <= l6)
          {
            localObject2 = new com.tencent.mm.k.a.a.c();
            ((com.tencent.mm.k.a.a.c)localObject2).fXs = ((com.tencent.mm.k.a.a.c)localObject1).fXs;
            ((com.tencent.mm.k.a.a.c)localObject2).fXt = (l1 - 1L);
            ((com.tencent.mm.k.a.a.c)localObject2).fXu = l7;
            ((com.tencent.mm.k.a.a.c)localObject2).fXv = (l3 - 1L);
            i = j;
            if (((com.tencent.mm.k.a.a.c)localObject2).fXt - ((com.tencent.mm.k.a.a.c)localObject2).fXs >= 0L)
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
            ((com.tencent.mm.k.a.a.c)localObject2).fXs = (1L + l2);
            ((com.tencent.mm.k.a.a.c)localObject2).fXt = l6;
            ((com.tencent.mm.k.a.a.c)localObject2).fXu = (1L + l4);
            ((com.tencent.mm.k.a.a.c)localObject2).fXv = l8;
            j = i;
            if (((com.tencent.mm.k.a.a.c)localObject2).fXt - ((com.tencent.mm.k.a.a.c)localObject2).fXs >= 0L)
            {
              paramString.add(localObject2);
              j = 1;
            }
          }
        }
        if ((j == 0) && ((l1 > l6) || (l2 < l5)))
        {
          paramString.add(localObject1);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] add raw block!");
        }
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] lastSeq[%s]<firstSeq[%s]", new Object[] { Long.valueOf(paramLinkedList.fXt), Long.valueOf(paramLinkedList.fXs) });
    }
    paramLinkedList = new StringBuilder();
    localObject1 = paramString.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.k.a.a.c)((Iterator)localObject1).next();
      paramLinkedList.append("[").append(((com.tencent.mm.k.a.a.c)localObject2).fXs).append(":").append(((com.tencent.mm.k.a.a.c)localObject2).fXt).append("][").append(((com.tencent.mm.k.a.a.c)localObject2).fXu).append(":").append(((com.tencent.mm.k.a.a.c)localObject2).fXv).append("] | ");
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] " + localStringBuilder.toString() + "\nnew blockList:" + paramLinkedList.toString());
    AppMethodBeat.o(20509);
    return paramString;
  }
  
  private static void d(Map<Long, bo> paramMap, String paramString)
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
        Object localObject1 = (bo)paramMap.next();
        if ((localObject1 != null) && (paramString.equals(((bo)localObject1).field_fromUserName)))
        {
          bc.aCg();
          Object localObject2 = com.tencent.mm.model.c.azI().aJ(paramString, ((bo)localObject1).field_originSvrId);
          if (((ei)localObject2).field_msgId != 0L)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", new Object[] { Long.valueOf(((ei)localObject2).field_msgId), Long.valueOf(((ei)localObject2).field_msgSvrId) });
            localObject2 = new cv();
            ((cv)localObject2).xrk = ((bo)localObject1).field_newMsgId;
            ((cv)localObject2).FNG = z.Jw(((bo)localObject1).field_fromUserName);
            ((cv)localObject2).FNH = z.Jw(((bo)localObject1).field_toUserName);
            ((cv)localObject2).CreateTime = ((int)((bo)localObject1).field_createTime);
            ((cv)localObject2).FNI = z.Jw(((bo)localObject1).field_content);
            ((cv)localObject2).FNL = ((bo)localObject1).field_msgSource;
            ((cv)localObject2).FNN = ((bo)localObject1).field_msgSeq;
            int i = ((bo)localObject1).field_flag;
            ((cv)localObject2).urJ = 10002;
            localObject1 = bc.getSysCmdMsgExtension();
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
              ((cf)localObject1).b(new e.a((cv)localObject2, bool1, bool2, bool3));
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
  
  public final void a(int paramInt, n paramn, final Object paramObject)
  {
    AppMethodBeat.i(20508);
    if ((paramn == ((l)g.ab(l.class)).azL()) && ((paramObject instanceof String)) && (5 == paramInt)) {
      h.MqF.aO(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186358);
          com.tencent.mm.plugin.messenger.foundation.a.a.b localb = ((l)g.ab(l.class)).doE();
          String str = (String)paramObject;
          if (localb.aqK(str))
          {
            com.tencent.mm.storage.ae localae = localb.aqM(str);
            if (localae.field_seqBlockInfo != null) {
              localae.field_seqBlockInfo.fXw.clear();
            }
            localae.field_lastLocalSeq = localae.field_lastPushSeq;
            localae.field_lastLocalCreateTime = localae.field_lastPushCreateTime;
            long l = localb.b(localae);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "[onNotifyChange] username:" + str + " ret:" + l + " chatroomMsgSeq:" + localae.toString());
          }
          AppMethodBeat.o(186358);
        }
      });
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
        paramString = new bo();
        paramString.field_originSvrId = l;
        p.aJR();
        if (p.aJP().get(paramString, new String[0]))
        {
          this.ibg.put(Long.valueOf(l), paramString);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange put info systemRowid[%d], svrId[%d]", new Object[] { Long.valueOf(paramString.systemRowid), Long.valueOf(l) });
          AppMethodBeat.o(20510);
          return;
        }
        this.ibg.remove(Long.valueOf(l));
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange remove info svrId[%d]", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(20510);
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", paramString, "summerbadcr dealSysCmdMsg onNotifyChange:", new Object[0]);
      }
    }
    AppMethodBeat.o(20510);
  }
  
  public final void a(String paramString, boolean paramBoolean1, LinkedList<bv> paramLinkedList, com.tencent.mm.k.a.a.c paramc, boolean paramBoolean2)
  {
    AppMethodBeat.i(20507);
    if ((paramLinkedList.size() <= 0) || (paramBoolean2))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetChatroomMsgReceiver", "[onFetched] fetchList.size() == 0! removeBlock! isBlockAll:".concat(String.valueOf(paramBoolean2)));
      l1 = paramc.fXs;
      l2 = paramc.fXt;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString);
      paramLinkedList = ((l)g.ab(l.class)).doE();
      paramc = paramLinkedList.aqM(paramString);
      if (paramc.field_seqBlockInfo != null)
      {
        localObject1 = new LinkedList();
        localObject2 = paramc.field_seqBlockInfo.fXw.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.k.a.a.c localc = (com.tencent.mm.k.a.a.c)((Iterator)localObject2).next();
          if ((localc.fXs == l1) && (localc.fXt == l2)) {
            ((List)localObject1).add(localc);
          }
        }
        paramc.field_seqBlockInfo.fXw.removeAll((Collection)localObject1);
        l3 = paramLinkedList.b(paramc);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString + " ret:" + l3 + " remove list:" + ((List)localObject1).size());
        if (((List)localObject1).size() > 0)
        {
          localObject1 = com.tencent.mm.ui.chatting.l.b.KsK;
          com.tencent.mm.ui.chatting.l.b.fLo();
        }
      }
      paramc.field_lastLocalSeq = paramc.field_lastPushSeq;
      paramc.field_lastLocalCreateTime = paramc.field_lastPushCreateTime;
      l3 = paramLinkedList.b(paramc);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString + " ret:" + l3 + " lastPushSeq:" + paramc.field_lastPushSeq + " field_lastPushCreateTime:" + paramc.field_lastPushCreateTime);
      AppMethodBeat.o(20507);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] insert msg count[%s] isFetchUp:%s", new Object[] { Integer.valueOf(paramLinkedList.size()), Boolean.valueOf(paramBoolean1) });
    paramc = ((l)g.ab(l.class)).doE();
    Object localObject1 = a(paramString, paramLinkedList);
    Object localObject2 = paramc.aqJ(paramString);
    ((d)localObject2).fXw.clear();
    ((d)localObject2).fXw.addAll((Collection)localObject1);
    paramBoolean1 = paramc.a(paramString, (d)localObject2);
    long l1 = ((bv)paramLinkedList.getLast()).field_msgSeq;
    long l2 = ((bv)paramLinkedList.getLast()).field_createTime;
    long l3 = paramc.aqG(paramString);
    long l4 = paramc.aqI(paramString);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] blockList size:%s ret:%s GetSeq:[last %s:old %s] GetLocalCreateTime:[last %s:old %s]", new Object[] { Integer.valueOf(((d)localObject2).fXw.size()), Boolean.valueOf(paramBoolean1), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4) });
    if (l3 < l1)
    {
      paramc.aE(paramString, l1);
      paramc.aC(paramString, l2);
    }
    for (;;)
    {
      d(new HashMap(this.ibg), paramString);
      AppMethodBeat.o(20507);
      return;
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetChatroomMsgReceiver", "oldGetSeq>=lastGetSeq [%s:%s]", new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
    }
  }
  
  static final class a
    implements Runnable
  {
    tz ibi;
    
    private a(tz paramtz)
    {
      this.ibi = paramtz;
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
        bv localbv;
        label617:
        label624:
        Object localObject2;
        try
        {
          if (!g.ajM())
          {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] accHasReady no!");
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.GetChatroomMsgReceiver", "[HandlePushTask$run] cost:" + (System.currentTimeMillis() - l3));
            AppMethodBeat.o(20505);
            return;
          }
          localObject1 = this.ibi.dJz.data;
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
            localObject4 = z.a(((cw)localObject3).FNO);
            i = ((cw)localObject3).FNN;
            l5 = 1000L * ((cw)localObject3).CreateTime;
            localObject5 = ((l)g.ab(l.class)).doE();
            if (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).aqK((String)localObject4))
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#update] chatRoomId:%s updatePushSeqRet[%s]:%s updatePushCreateTimeRet[%s]:%s", new Object[] { localObject4, Integer.valueOf(i), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).aB((String)localObject4, i)), Long.valueOf(l5), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).aD((String)localObject4, l5)) });
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.GetChatroomMsgReceiver", "[updateChatroomMsgSeq] cost:" + (System.currentTimeMillis() - l4));
              l2 = System.currentTimeMillis();
              localObject6 = z.a(((cw)localObject3).FNO);
              n = ((cw)localObject3).FNN;
              l1 = ((cw)localObject3).xrk;
              j = ((cw)localObject3).CreateTime;
              int k = ((cw)localObject3).FNR;
              m = ((cw)localObject3).urJ;
              i = ((cw)localObject3).FNP;
              localObject3 = z.a(((cw)localObject3).FNQ);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", new Object[] { localObject6, Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), bu.aSM((String)localObject3) });
              localObject1 = ((l)g.ab(l.class)).azL().aVa((String)localObject6);
              if (localObject1 != null) {
                break label1237;
              }
              localObject1 = new au((String)localObject6);
              ((au)localObject1).qH(j * 1000L);
              ((au)localObject1).qJ(n);
              ((au)localObject1).kr(1);
              ((au)localObject1).ky(1);
              b.aIn();
              b.FB((String)localObject6);
              l1 = ((l)g.ab(l.class)).aAi().aqO((String)localObject6);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", new Object[] { Long.valueOf(l1), Integer.valueOf(n) });
              if (l1 <= 0L) {
                break label2057;
              }
              ((au)localObject1).qK(l1);
              i = 1;
              if (k > 0) {
                ((au)localObject1).kw(((ba)localObject1).field_atCount + k);
              }
              localbv = new bv();
              localbv.kt(0);
              localbv.ui((String)localObject6);
              localbv.setType(m);
              localbv.setContent((String)localObject3);
              if (m != 49) {
                break label1566;
              }
              localObject4 = k.b.zb(k.lz((String)localObject6, (String)localObject3));
              localbv.setType(com.tencent.mm.pluginsdk.model.app.m.g((k.b)localObject4));
              if (!localbv.fta()) {
                break label2080;
              }
              localObject3 = ((k.b)localObject4).content;
              localbv.setContent((String)localObject3);
              ((au)localObject1).kt(0);
              ((au)localObject1).setContent(localbv.field_content);
              ((au)localObject1).tV(Integer.toString(localbv.getType()));
              localObject3 = ((l)g.ab(l.class)).azL().MV();
              if (localObject3 == null) {
                break label1897;
              }
              localObject4 = new PString();
              localObject5 = new PString();
              PInt localPInt = new PInt();
              ((br.b)localObject3).a(localbv, (PString)localObject4, (PString)localObject5, localPInt, false);
              ((au)localObject1).tW(((PString)localObject4).value);
              ((au)localObject1).tX(((PString)localObject5).value);
              ((au)localObject1).ku(localPInt.value);
              if (localbv.getType() == 49)
              {
                localObject3 = (String)bx.M(((ba)localObject1).field_content, "msg").get(".msg.appmsg.title");
                localObject4 = bu.nullAsNil(((ba)localObject1).field_digest);
                if (!bu.isNullOrNil((String)localObject3)) {
                  break label1871;
                }
                localObject3 = "";
                ((au)localObject1).tW(((String)localObject4).concat((String)localObject3));
              }
              label820:
              if (i == 0) {
                break label1910;
              }
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { localObject6, Long.valueOf(((l)g.ab(l.class)).azL().e((au)localObject1)), Long.valueOf(((ba)localObject1).field_firstUnDeliverSeq), Long.valueOf(((ba)localObject1).field_lastSeq), Integer.valueOf(((ba)localObject1).field_UnDeliverCount) });
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.GetChatroomMsgReceiver", "[updateConv] cost:" + (System.currentTimeMillis() - l2));
              continue;
              localException1 = localException1;
              com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", localException1, "", new Object[0]);
            }
          }
          catch (Exception localException2)
          {
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", localException2, "", new Object[0]);
            continue;
            localObject2 = ((l)g.ab(l.class)).doJ().are((String)localObject4);
            if (localObject2 == null) {
              break label2018;
            }
          }
        }
        if (((ei)localObject2).field_msgId == 0L)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] has not any ReceivedMsg!");
          localObject2 = null;
          label1016:
          if (localObject2 != null)
          {
            localObject6 = com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", ((ei)localObject2).field_createTime / 1000L);
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetChatroomMsgReceiver", "[lastFaultMsgInfo] lastFaultMsgInfo:%s timeFormat:%s", new Object[] { bu.aSM(((ei)localObject2).field_content), localObject6 });
          }
          localObject6 = new com.tencent.mm.storage.ae();
          ((com.tencent.mm.storage.ae)localObject6).field_username = ((String)localObject4);
          ((com.tencent.mm.storage.ae)localObject6).field_lastPushSeq = i;
          if (localObject2 == null) {
            break label2021;
          }
          l1 = ((ei)localObject2).field_msgSeq;
          label1101:
          ((com.tencent.mm.storage.ae)localObject6).field_lastLocalSeq = l1;
          ((com.tencent.mm.storage.ae)localObject6).field_lastPushCreateTime = l5;
          if (localObject2 == null) {
            break label2030;
          }
          l1 = ((ei)localObject2).field_createTime;
          label1127:
          ((com.tencent.mm.storage.ae)localObject6).field_lastLocalCreateTime = l1;
          long l6 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).a((com.tencent.mm.storage.ae)localObject6);
          if (localObject2 == null) {
            break label2039;
          }
          l1 = ((ei)localObject2).field_msgSeq;
          if (localObject2 == null) {
            break label2048;
          }
          l2 = ((ei)localObject2).field_createTime;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#insert] ret:%s,chatRoomId:%s updatePushSeq:%s updatePushCreateTime:%s field_lastLocalSeq:%s field_lastLocalCreateTime:%s", new Object[] { Long.valueOf(l6), localObject4, Integer.valueOf(i), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l2) });
          localObject2 = com.tencent.mm.ui.chatting.l.b.KsK;
          com.tencent.mm.ui.chatting.l.b.fLm();
          continue;
          label1237:
          int i1 = (int)((ba)localObject2).field_lastSeq;
          if (n > i1)
          {
            ((au)localObject2).qJ(n);
            int i2 = ((ba)localObject2).field_UnDeliverCount;
            ((au)localObject2).ky(i);
            ((au)localObject2).qH(j * 1000L);
            if (i > ((ba)localObject2).field_unReadCount) {}
            for (;;)
            {
              j = i;
              if (i < 0)
              {
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GetChatroomMsgReceiver", "why???, unreadCount %d", new Object[] { Integer.valueOf(i) });
                j = 0;
              }
              ((au)localObject2).kr(j);
              l1 = ((ba)localObject2).field_firstUnDeliverSeq;
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv  msgSeq[%d], firstSeq[%d], lastseq[%d]", new Object[] { Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1) });
              if (l1 <= 0L) {
                break;
              }
              localObject4 = ((l)g.ab(l.class)).doJ().aK((String)localObject6, i1);
              if (((ei)localObject4).field_msgId <= 0L) {
                break label2065;
              }
              ((au)localObject2).qK(((ei)localObject4).field_msgSeq);
              break label2065;
              i = i - i2 + ((ba)localObject2).field_unReadCount;
            }
            l1 = ((l)g.ab(l.class)).aAi().aqO((String)localObject6);
            if (l1 > 0L)
            {
              ((au)localObject2).qK(l1);
              i = 0;
              continue;
            }
            l1 = ((l)g.ab(l.class)).doJ().arw((String)localObject6);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv lastMsgSeq[%s]", new Object[] { Long.valueOf(l1) });
            if (l1 <= 0L) {
              break label2070;
            }
            ((au)localObject2).qK(l1);
            break label2070;
          }
          if ((n != i1) || (i != 0) || (((ba)localObject2).field_unReadCount <= 0)) {
            break label2075;
          }
          ((au)localObject2).kr(0);
          break label2075;
          if (m != 10002) {
            continue;
          }
          ((s)g.ad(s.class)).getSysCmdMsgExtension();
          if ((localbv.getType() != 10002) || (bu.isNullOrNil((String)localObject3))) {
            continue;
          }
          if (bu.isNullOrNil((String)localObject3))
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SysCmdMsgExtension", "null msg content");
            continue;
          }
          if (((String)localObject3).startsWith("~SEMI_XML~"))
          {
            localObject5 = bk.aSj((String)localObject3);
            if (localObject5 != null) {
              break label2083;
            }
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[] { localObject3 });
            continue;
          }
        }
        for (;;)
        {
          if ((localObject4 == null) || (!((String)localObject4).equals("revokemsg"))) {
            break label2093;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
          ((Map)localObject3).get(".sysmsg.revokemsg.session");
          localObject4 = (String)((Map)localObject3).get(".sysmsg.revokemsg.newmsgid");
          localObject3 = (String)((Map)localObject3).get(".sysmsg.revokemsg.replacemsg");
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject4, localObject3 });
          localbv.setContent((String)localObject3);
          localbv.setType(10000);
          break label624;
          j = ((String)localObject3).indexOf("<sysmsg");
          if (j == -1)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
            break label624;
          }
          localObject4 = bx.M(((String)localObject3).substring(j), "sysmsg");
          if (localObject4 == null)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject3 });
            break label624;
          }
          localObject5 = (String)((Map)localObject4).get(".sysmsg.$type");
          localObject3 = localObject4;
          localObject4 = localObject5;
          continue;
          label1871:
          localObject3 = " " + bu.nullAsNil((String)localObject3);
          break label808;
          label1897:
          ((au)localObject2).tW(((ba)localObject2).field_content);
          break label820;
          label1910:
          ((au)localObject2).kv(((ba)localObject2).field_attrflag & 0xFFEFFFFF);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { localObject6, Long.valueOf(((l)g.ab(l.class)).azL().a((au)localObject2, (String)localObject6, true)), Long.valueOf(((ba)localObject2).field_firstUnDeliverSeq), Long.valueOf(((ba)localObject2).field_lastSeq), Integer.valueOf(((ba)localObject2).field_UnDeliverCount) });
          break label900;
          label2007:
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] data is null");
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