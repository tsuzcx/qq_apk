package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.h.a;
import com.tencent.mm.f.a.ka;
import com.tencent.mm.f.a.ka.a;
import com.tencent.mm.f.a.wb;
import com.tencent.mm.f.a.wb.a;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ck;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.dc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.b;
import com.tencent.mm.storage.ca;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  extends IListener<wb>
  implements b.a, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  public final IListener lMy;
  private Map<Long, bt> lMz;
  
  public c()
  {
    AppMethodBeat.i(20506);
    this.lMy = new IListener()
    {
      private static boolean a(ka paramAnonymouska)
      {
        AppMethodBeat.i(285272);
        long l2 = System.currentTimeMillis();
        for (;;)
        {
          ca localca;
          try
          {
            Object localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eRZ();
            if (!((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aOp(paramAnonymouska.fHq.username))
            {
              localObject2 = new aj();
              ((aj)localObject2).field_username = paramAnonymouska.fHq.username;
              if (paramAnonymouska.fHq.fHr <= paramAnonymouska.fHq.fHt)
              {
                l1 = paramAnonymouska.fHq.fHt;
                ((aj)localObject2).field_lastPushSeq = l1;
                ((aj)localObject2).field_lastLocalSeq = paramAnonymouska.fHq.fHt;
                ((aj)localObject2).field_lastPushCreateTime = paramAnonymouska.fHq.fHs;
                ((aj)localObject2).field_lastLocalCreateTime = paramAnonymouska.fHq.fHu;
                l1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).a((aj)localObject2, true);
                localObject1 = com.tencent.mm.ui.chatting.m.c.WZL;
                com.tencent.mm.ui.chatting.m.c.hTn();
                Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] ret:%s,chatRoomId:%s lastPushSeq:%s lastPushCreateTime:%s lastLocalSeq:%s lastLocalCreateTime:%s", new Object[] { Long.valueOf(l1), paramAnonymouska.fHq.username, Long.valueOf(paramAnonymouska.fHq.fHr), Long.valueOf(paramAnonymouska.fHq.fHs), Long.valueOf(paramAnonymouska.fHq.fHt), Long.valueOf(paramAnonymouska.fHq.fHu) });
                return true;
              }
              l1 = paramAnonymouska.fHq.fHr;
              continue;
            }
            Object localObject2 = paramAnonymouska.fHq.username;
            localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOJ((String)localObject2);
            l1 = paramAnonymouska.fHq.fHr;
            long l3 = paramAnonymouska.fHq.fHs;
            paramAnonymouska = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aOr((String)localObject2);
            long l4 = paramAnonymouska.field_lastLocalSeq;
            long l5 = paramAnonymouska.field_lastLocalCreateTime;
            long l6 = paramAnonymouska.field_lastPushSeq;
            long l7 = paramAnonymouska.field_lastPushCreateTime;
            Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] isGetChatroom! %s conPushSeq:%s conPushCreateTime:%s localSeq:%s localCreateTime:%s pushSeq:%s pushCreateTime:%s", new Object[] { localObject2, Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7) });
            if ((localca != null) && (localca.field_msgId != 0L))
            {
              long l8 = localca.field_msgSeq;
              if (l8 > l4)
              {
                paramAnonymouska.field_lastLocalSeq = l8;
                paramAnonymouska.field_lastLocalCreateTime = localca.field_createTime;
                com.tencent.mm.k.a.a.c localc = new com.tencent.mm.k.a.a.c();
                localc.jmE = (1L + l4);
                localc.jmG = (l5 + 1L);
                localc.jmF = (l8 - 1L);
                localc.jmH = (l7 - 1L);
                if (paramAnonymouska.field_seqBlockInfo == null) {
                  paramAnonymouska.field_seqBlockInfo = new d();
                }
                paramAnonymouska.field_seqBlockInfo.jmI.addLast(localc);
                Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage local seq is smaller than MsgInfoStg local seq! ret:[%s]", new Object[] { Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).b(paramAnonymouska)) });
              }
              if (l6 < l1) {
                Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage push seq is smaller than conversation seq! ret:[%s,%s] [%s,%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aD((String)localObject2, l1)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aF((String)localObject2, l3)), Long.valueOf(localca.field_msgSeq), Long.valueOf(l4) });
              }
              return true;
            }
            if (localca == null)
            {
              bool = true;
              if (localca != null) {
                break label743;
              }
              l1 = -1L;
              Log.w("MicroMsg.GetChatroomMsgReceiver", "lastMsgInfo is null? %s lastMsgInfo id:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
              continue;
            }
            boolean bool = false;
          }
          finally
          {
            Log.i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
            AppMethodBeat.o(285272);
          }
          continue;
          label743:
          long l1 = localca.field_msgId;
        }
      }
    };
    this.lMz = new HashMap();
    EventCenter.instance.addListener(this.lMy);
    b.blw().lMr = this;
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().add(this, com.tencent.mm.kernel.h.aHJ().getLooper());
    p.bno();
    p.bnm().add(this, bh.aHJ().getLooper());
    this.__eventId = wb.class.getName().hashCode();
    AppMethodBeat.o(20506);
  }
  
  private static List<com.tencent.mm.k.a.a.c> a(String paramString, LinkedList<ca> paramLinkedList)
  {
    AppMethodBeat.i(20509);
    Object localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eRZ();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aOo(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nchatroomId:").append(paramString);
    long l1 = ((ca)paramLinkedList.getFirst()).field_msgSeq;
    long l2 = ((ca)paramLinkedList.getLast()).field_msgSeq;
    long l3 = ((ca)paramLinkedList.getFirst()).field_createTime;
    long l4 = ((ca)paramLinkedList.getLast()).field_createTime;
    localStringBuilder.append("\ngetFirst:").append(l1);
    localStringBuilder.append(" getLast:").append(l2);
    localStringBuilder.append(" getFirstCreateTime:").append(l3);
    localStringBuilder.append(" getLastCreateTime:").append(l4);
    localStringBuilder.append("\nblock ");
    paramLinkedList = new com.tencent.mm.k.a.a.c();
    paramLinkedList.jmE = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aOl(paramString) + 1L);
    paramLinkedList.jmG = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aOn(paramString) + 1L);
    paramLinkedList.jmF = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aOk(paramString);
    paramLinkedList.jmH = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aOm(paramString);
    if (paramLinkedList.jmF - paramLinkedList.jmE >= 0L) {
      ((d)localObject1).jmI.add(paramLinkedList);
    }
    for (;;)
    {
      paramString = new LinkedList();
      paramLinkedList = ((d)localObject1).jmI.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject1 = (com.tencent.mm.k.a.a.c)paramLinkedList.next();
        int j = 0;
        long l5 = ((com.tencent.mm.k.a.a.c)localObject1).jmE;
        long l6 = ((com.tencent.mm.k.a.a.c)localObject1).jmF;
        long l7 = ((com.tencent.mm.k.a.a.c)localObject1).jmG;
        long l8 = ((com.tencent.mm.k.a.a.c)localObject1).jmH;
        localStringBuilder.append("[").append(l5).append(":").append(l6).append("][").append(l7).append(":").append(l8).append("] | ");
        int i = j;
        if (l5 <= l1)
        {
          i = j;
          if (l1 <= l6)
          {
            localObject2 = new com.tencent.mm.k.a.a.c();
            ((com.tencent.mm.k.a.a.c)localObject2).jmE = ((com.tencent.mm.k.a.a.c)localObject1).jmE;
            ((com.tencent.mm.k.a.a.c)localObject2).jmF = (l1 - 1L);
            ((com.tencent.mm.k.a.a.c)localObject2).jmG = l7;
            ((com.tencent.mm.k.a.a.c)localObject2).jmH = (l3 - 1L);
            i = j;
            if (((com.tencent.mm.k.a.a.c)localObject2).jmF - ((com.tencent.mm.k.a.a.c)localObject2).jmE >= 0L)
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
            ((com.tencent.mm.k.a.a.c)localObject2).jmE = (1L + l2);
            ((com.tencent.mm.k.a.a.c)localObject2).jmF = l6;
            ((com.tencent.mm.k.a.a.c)localObject2).jmG = (1L + l4);
            ((com.tencent.mm.k.a.a.c)localObject2).jmH = l8;
            j = i;
            if (((com.tencent.mm.k.a.a.c)localObject2).jmF - ((com.tencent.mm.k.a.a.c)localObject2).jmE >= 0L)
            {
              paramString.add(localObject2);
              j = 1;
            }
          }
        }
        if ((j == 0) && ((l1 > l6) || (l2 < l5)))
        {
          paramString.add(localObject1);
          Log.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] add raw block!");
        }
      }
      Log.w("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] lastSeq[%s]<firstSeq[%s]", new Object[] { Long.valueOf(paramLinkedList.jmF), Long.valueOf(paramLinkedList.jmE) });
    }
    paramLinkedList = new StringBuilder();
    localObject1 = paramString.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.k.a.a.c)((Iterator)localObject1).next();
      paramLinkedList.append("[").append(((com.tencent.mm.k.a.a.c)localObject2).jmE).append(":").append(((com.tencent.mm.k.a.a.c)localObject2).jmF).append("][").append(((com.tencent.mm.k.a.a.c)localObject2).jmG).append(":").append(((com.tencent.mm.k.a.a.c)localObject2).jmH).append("] | ");
    }
    Log.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] " + localStringBuilder.toString() + "\nnew blockList:" + paramLinkedList.toString());
    AppMethodBeat.o(20509);
    return paramString;
  }
  
  private static void d(Map<Long, bt> paramMap, String paramString)
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
        Object localObject1 = (bt)paramMap.next();
        if ((localObject1 != null) && (paramString.equals(((bt)localObject1).field_fromUserName)))
        {
          bh.beI();
          Object localObject2 = com.tencent.mm.model.c.bbO().aL(paramString, ((bt)localObject1).field_originSvrId);
          if (((et)localObject2).field_msgId != 0L)
          {
            Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", new Object[] { Long.valueOf(((et)localObject2).field_msgId), Long.valueOf(((et)localObject2).field_msgSvrId) });
            localObject2 = new db();
            ((db)localObject2).HlH = ((bt)localObject1).field_newMsgId;
            ((db)localObject2).RID = z.ZW(((bt)localObject1).field_fromUserName);
            ((db)localObject2).RIE = z.ZW(((bt)localObject1).field_toUserName);
            ((db)localObject2).CreateTime = ((int)((bt)localObject1).field_createTime);
            ((db)localObject2).RIF = z.ZW(((bt)localObject1).field_content);
            ((db)localObject2).RII = ((bt)localObject1).field_msgSource;
            ((db)localObject2).RIK = ((bt)localObject1).field_msgSeq;
            int i = ((bt)localObject1).field_flag;
            ((db)localObject2).COi = 10002;
            localObject1 = bh.getSysCmdMsgExtension();
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
              ((ck)localObject1).b(new h.a((db)localObject2, bool1, bool2, bool3));
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
  
  public final void a(String paramString, boolean paramBoolean1, LinkedList<ca> paramLinkedList, com.tencent.mm.k.a.a.c paramc, boolean paramBoolean2)
  {
    AppMethodBeat.i(20507);
    if ((paramLinkedList.size() <= 0) || (paramBoolean2))
    {
      Log.w("MicroMsg.GetChatroomMsgReceiver", "[onFetched] fetchList.size() == 0! removeBlock! isBlockAll:".concat(String.valueOf(paramBoolean2)));
      l1 = paramc.jmE;
      l2 = paramc.jmF;
      Log.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString);
      paramLinkedList = ((n)com.tencent.mm.kernel.h.ae(n.class)).eRZ();
      paramc = paramLinkedList.aOr(paramString);
      if (paramc.field_seqBlockInfo != null)
      {
        localObject1 = new LinkedList();
        localObject2 = paramc.field_seqBlockInfo.jmI.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.k.a.a.c localc = (com.tencent.mm.k.a.a.c)((Iterator)localObject2).next();
          if ((localc.jmE == l1) && (localc.jmF == l2)) {
            ((List)localObject1).add(localc);
          }
        }
        paramc.field_seqBlockInfo.jmI.removeAll((Collection)localObject1);
        l3 = paramLinkedList.b(paramc);
        Log.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString + " ret:" + l3 + " remove list:" + ((List)localObject1).size());
        if (((List)localObject1).size() > 0)
        {
          localObject1 = com.tencent.mm.ui.chatting.m.c.WZL;
          com.tencent.mm.ui.chatting.m.c.hTp();
        }
      }
      paramc.field_lastLocalSeq = paramc.field_lastPushSeq;
      paramc.field_lastLocalCreateTime = paramc.field_lastPushCreateTime;
      l3 = paramLinkedList.b(paramc);
      Log.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString + " ret:" + l3 + " lastPushSeq:" + paramc.field_lastPushSeq + " field_lastPushCreateTime:" + paramc.field_lastPushCreateTime);
      AppMethodBeat.o(20507);
      return;
    }
    Log.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] insert msg count[%s] isFetchUp:%s", new Object[] { Integer.valueOf(paramLinkedList.size()), Boolean.valueOf(paramBoolean1) });
    paramc = ((n)com.tencent.mm.kernel.h.ae(n.class)).eRZ();
    Object localObject1 = a(paramString, paramLinkedList);
    Object localObject2 = paramc.aOo(paramString);
    ((d)localObject2).jmI.clear();
    ((d)localObject2).jmI.addAll((Collection)localObject1);
    paramBoolean1 = paramc.a(paramString, (d)localObject2);
    long l1 = ((ca)paramLinkedList.getLast()).field_msgSeq;
    long l2 = ((ca)paramLinkedList.getLast()).field_createTime;
    long l3 = paramc.aOl(paramString);
    long l4 = paramc.aOn(paramString);
    Log.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] blockList size:%s ret:%s GetSeq:[last %s:old %s] GetLocalCreateTime:[last %s:old %s]", new Object[] { Integer.valueOf(((d)localObject2).jmI.size()), Boolean.valueOf(paramBoolean1), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4) });
    if (l3 < l1)
    {
      paramc.aG(paramString, l1);
      paramc.aE(paramString, l2);
    }
    for (;;)
    {
      d(new HashMap(this.lMz), paramString);
      AppMethodBeat.o(20507);
      return;
      Log.w("MicroMsg.GetChatroomMsgReceiver", "oldGetSeq>=lastGetSeq [%s:%s]", new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
    }
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, final Object paramObject)
  {
    AppMethodBeat.i(20508);
    if ((paramMStorageEx == ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR()) && ((paramObject instanceof String)) && (5 == paramInt)) {
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(271170);
          com.tencent.mm.plugin.messenger.foundation.a.a.b localb = ((n)com.tencent.mm.kernel.h.ae(n.class)).eRZ();
          String str = (String)paramObject;
          if (localb.aOp(str))
          {
            aj localaj = localb.aOr(str);
            if (localaj.field_seqBlockInfo != null) {
              localaj.field_seqBlockInfo.jmI.clear();
            }
            localaj.field_lastLocalSeq = localaj.field_lastPushSeq;
            localaj.field_lastLocalCreateTime = localaj.field_lastPushCreateTime;
            long l = localb.b(localaj);
            Log.i("MicroMsg.GetChatroomMsgReceiver", "[onNotifyChange] username:" + str + " ret:" + l + " chatroomMsgSeq:" + localaj.toString());
          }
          AppMethodBeat.o(271170);
        }
      });
    }
    AppMethodBeat.o(20508);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(20510);
    if (!ae.isNullOrNil(paramString)) {
      try
      {
        long l = Long.valueOf(paramString).longValue();
        paramString = new bt();
        paramString.field_originSvrId = l;
        p.bno();
        if (p.bnm().get(paramString, new String[0]))
        {
          this.lMz.put(Long.valueOf(l), paramString);
          Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange put info systemRowid[%d], svrId[%d]", new Object[] { Long.valueOf(paramString.systemRowid), Long.valueOf(l) });
          AppMethodBeat.o(20510);
          return;
        }
        this.lMz.remove(Long.valueOf(l));
        Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange remove info svrId[%d]", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(20510);
        return;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", paramString, "summerbadcr dealSysCmdMsg onNotifyChange:", new Object[0]);
      }
    }
    AppMethodBeat.o(20510);
  }
  
  static final class a
    implements Runnable
  {
    wb lMB;
    
    private a(wb paramwb)
    {
      this.lMB = paramwb;
    }
    
    public final void run()
    {
      AppMethodBeat.i(20505);
      long l3 = System.currentTimeMillis();
      label901:
      label1158:
      label1800:
      try
      {
        if (!com.tencent.mm.kernel.h.aHB())
        {
          Log.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] accHasReady no!");
          Log.d("MicroMsg.GetChatroomMsgReceiver", "[HandlePushTask$run] cost:" + (System.currentTimeMillis() - l3));
          AppMethodBeat.o(20505);
          return;
        }
        localObject1 = this.lMB.fVj.data;
        if (localObject1 != null) {
          localObject3 = new dc();
        }
      }
      catch (Exception localException1)
      {
        label521:
        label1805:
        label1810:
        for (;;)
        {
          Object localObject3;
          String str;
          long l5;
          Object localObject4;
          label216:
          int n;
          int j;
          int m;
          Object localObject5;
          label624:
          Object localObject2;
          try
          {
            Object localObject1;
            ((dc)localObject3).parseFrom((byte[])localObject1);
            long l4 = System.currentTimeMillis();
            str = z.a(((dc)localObject3).RIL);
            i = ((dc)localObject3).RIK;
            l5 = 1000L * ((dc)localObject3).CreateTime;
            localObject4 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eRZ();
            if (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject4).aOp(str))
            {
              Log.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#update] chatRoomId:%s updatePushSeqRet[%s]:%s updatePushCreateTimeRet[%s]:%s", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject4).aD(str, i)), Long.valueOf(l5), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject4).aF(str, l5)) });
              Log.d("MicroMsg.GetChatroomMsgReceiver", "[updateChatroomMsgSeq] cost:" + (System.currentTimeMillis() - l4));
              l2 = System.currentTimeMillis();
              str = z.a(((dc)localObject3).RIL);
              n = ((dc)localObject3).RIK;
              l1 = ((dc)localObject3).HlH;
              j = ((dc)localObject3).CreateTime;
              int k = ((dc)localObject3).RIO;
              m = ((dc)localObject3).COi;
              i = ((dc)localObject3).RIM;
              localObject3 = z.a(((dc)localObject3).RIN);
              Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", new Object[] { str, Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Util.secPrint((String)localObject3) });
              localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx(str);
              if (localObject1 != null) {
                break label1238;
              }
              localObject1 = new az(str);
              ((az)localObject1).EB(j * 1000L);
              ((az)localObject1).ED(n);
              ((az)localObject1).pH(1);
              ((az)localObject1).pO(1);
              b.blw();
              b.VJ(str);
              l1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bco().aOt(str);
              Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", new Object[] { Long.valueOf(l1), Integer.valueOf(n) });
              if (l1 <= 0L) {
                break label1787;
              }
              ((az)localObject1).EE(l1);
              i = 1;
              if (k > 0) {
                ((az)localObject1).pM(((bb)localObject1).field_atCount + k);
              }
              localObject4 = new ca();
              ((ca)localObject4).pJ(0);
              ((ca)localObject4).Jm(str);
              ((ca)localObject4).setType(m);
              ((ca)localObject4).setContent((String)localObject3);
              if (m != 49) {
                break label1567;
              }
              localObject5 = k.b.OQ(k.nm(str, (String)localObject3));
              ((ca)localObject4).setType(m.g((k.b)localObject5));
              if (!((ca)localObject4).hwA()) {
                break label1810;
              }
              localObject3 = ((k.b)localObject5).content;
              ((ca)localObject4).setContent((String)localObject3);
              ((az)localObject1).pJ(0);
              ((az)localObject1).setContent(((et)localObject4).field_content);
              ((az)localObject1).IZ(Integer.toString(((ca)localObject4).getType()));
              localObject3 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().abK();
              if (localObject3 == null) {
                break label1627;
              }
              localObject5 = new PString();
              PString localPString = new PString();
              PInt localPInt = new PInt();
              ((bw.b)localObject3).a((ca)localObject4, (PString)localObject5, localPString, localPInt, false);
              ((az)localObject1).Ja(((PString)localObject5).value);
              ((az)localObject1).Jb(localPString.value);
              ((az)localObject1).pK(localPInt.value);
              if (((ca)localObject4).getType() == 49)
              {
                localObject3 = (String)XmlParser.parseXml(((bb)localObject1).field_content, "msg", null).get(".msg.appmsg.title");
                localObject4 = Util.nullAsNil(((bb)localObject1).field_digest);
                if (!Util.isNullOrNil((String)localObject3)) {
                  break label1601;
                }
                localObject3 = "";
                label809:
                ((az)localObject1).Ja(((String)localObject4).concat((String)localObject3));
              }
              label821:
              if (i == 0) {
                break label1640;
              }
              Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { str, Long.valueOf(((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().e((az)localObject1)), Long.valueOf(((bb)localObject1).field_firstUnDeliverSeq), Long.valueOf(((bb)localObject1).field_lastSeq), Integer.valueOf(((bb)localObject1).field_UnDeliverCount) });
              Log.d("MicroMsg.GetChatroomMsgReceiver", "[updateConv] cost:" + (System.currentTimeMillis() - l2));
              continue;
              localException1 = localException1;
              Log.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", localException1, "", new Object[0]);
            }
          }
          catch (Exception localException2)
          {
            Log.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", localException2, "", new Object[0]);
            continue;
            localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOJ(str);
            if (localObject2 == null) {
              break label1748;
            }
          }
          label1017:
          long l6;
          if (((et)localObject2).field_msgId == 0L)
          {
            Log.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] has not any ReceivedMsg!");
            localObject2 = null;
            if (localObject2 != null)
            {
              localObject5 = f.formatTime("yyyy-MM-dd HH:mm:ss", ((et)localObject2).field_createTime / 1000L);
              Log.w("MicroMsg.GetChatroomMsgReceiver", "[lastFaultMsgInfo] lastFaultMsgInfo:%s timeFormat:%s", new Object[] { Util.secPrint(((et)localObject2).field_content), localObject5 });
            }
            localObject5 = new aj();
            ((aj)localObject5).field_username = str;
            ((aj)localObject5).field_lastPushSeq = i;
            if (localObject2 == null) {
              break label1751;
            }
            l1 = ((et)localObject2).field_msgSeq;
            label1102:
            ((aj)localObject5).field_lastLocalSeq = l1;
            ((aj)localObject5).field_lastPushCreateTime = l5;
            if (localObject2 == null) {
              break label1760;
            }
            l1 = ((et)localObject2).field_createTime;
            label1128:
            ((aj)localObject5).field_lastLocalCreateTime = l1;
            l6 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject4).a((aj)localObject5);
            if (localObject2 == null) {
              break label1769;
            }
            l1 = ((et)localObject2).field_msgSeq;
            if (localObject2 == null) {
              break label1778;
            }
          }
          label1238:
          label1627:
          label1640:
          label1769:
          label1778:
          for (long l2 = ((et)localObject2).field_createTime;; l2 = l5 - 1L)
          {
            Log.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#insert] ret:%s,chatRoomId:%s updatePushSeq:%s updatePushCreateTime:%s field_lastLocalSeq:%s field_lastLocalCreateTime:%s", new Object[] { Long.valueOf(l6), str, Integer.valueOf(i), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l2) });
            localObject2 = com.tencent.mm.ui.chatting.m.c.WZL;
            com.tencent.mm.ui.chatting.m.c.hTn();
            break label216;
            int i1 = (int)((bb)localObject2).field_lastSeq;
            if (n > i1)
            {
              ((az)localObject2).ED(n);
              int i2 = ((bb)localObject2).field_UnDeliverCount;
              ((az)localObject2).pO(i);
              ((az)localObject2).EB(j * 1000L);
              if (i > ((bb)localObject2).field_unReadCount) {}
              for (;;)
              {
                j = i;
                if (i < 0)
                {
                  Log.e("MicroMsg.GetChatroomMsgReceiver", "why???, unreadCount %d", new Object[] { Integer.valueOf(i) });
                  j = 0;
                }
                ((az)localObject2).pH(j);
                l1 = ((bb)localObject2).field_firstUnDeliverSeq;
                Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv  msgSeq[%d], firstSeq[%d], lastseq[%d]", new Object[] { Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1) });
                if (l1 <= 0L) {
                  break;
                }
                localObject4 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM(str, i1);
                if (((et)localObject4).field_msgId <= 0L) {
                  break label1795;
                }
                ((az)localObject2).EE(((et)localObject4).field_msgSeq);
                break label1795;
                i = i - i2 + ((bb)localObject2).field_unReadCount;
              }
              l1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bco().aOt(str);
              if (l1 > 0L)
              {
                ((az)localObject2).EE(l1);
                i = 0;
                break label521;
              }
              l1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aPb(str);
              Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv lastMsgSeq[%s]", new Object[] { Long.valueOf(l1) });
              if (l1 <= 0L) {
                break label1800;
              }
              ((az)localObject2).EE(l1);
              break label1800;
            }
            if ((n != i1) || (i != 0) || (((bb)localObject2).field_unReadCount <= 0)) {
              break label1805;
            }
            ((az)localObject2).pH(0);
            break label1805;
            if (m != 10002) {
              break label624;
            }
            ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension();
            ck.c((ca)localObject4, (String)localObject3);
            break label624;
            localObject3 = " " + Util.nullAsNil((String)localObject3);
            break label809;
            ((az)localObject2).Ja(((bb)localObject2).field_content);
            break label821;
            ((az)localObject2).pL(((bb)localObject2).field_attrflag & 0xFFEFFFFF);
            Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { str, Long.valueOf(((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a((az)localObject2, str, true)), Long.valueOf(((bb)localObject2).field_firstUnDeliverSeq), Long.valueOf(((bb)localObject2).field_lastSeq), Integer.valueOf(((bb)localObject2).field_UnDeliverCount) });
            break label901;
            Log.e("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] data is null");
            break;
            break label1017;
            l1 = i - 1;
            break label1102;
            l1 = l5 - 1L;
            break label1128;
            l1 = i - 1;
            break label1158;
          }
          label1567:
          label1601:
          label1748:
          label1751:
          label1760:
          label1787:
          long l1 = n;
          continue;
          int i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.av.c
 * JD-Core Version:    0.7.0.1
 */