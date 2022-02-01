package com.tencent.mm.modelgetchatroommsg;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.a.ld;
import com.tencent.mm.autogen.a.ld.a;
import com.tencent.mm.autogen.a.xs;
import com.tencent.mm.autogen.a.xs.a;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.h.a.a.d;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelmulti.u;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.b;
import com.tencent.mm.storage.cc;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GetChatroomMsgReceiver
  extends IListener<xs>
  implements b.a, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  public final IListener oFf;
  private Map<Long, bv> oFg;
  
  public GetChatroomMsgReceiver()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(20506);
    this.oFf = new IListener(com.tencent.mm.app.f.hfK)
    {
      private static boolean a(ld paramAnonymousld)
      {
        AppMethodBeat.i(231770);
        long l2 = System.currentTimeMillis();
        for (;;)
        {
          cc localcc;
          try
          {
            Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaU();
            if (!((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aLo(paramAnonymousld.hMP.username))
            {
              localObject2 = new al();
              ((al)localObject2).field_username = paramAnonymousld.hMP.username;
              if (paramAnonymousld.hMP.hMQ <= paramAnonymousld.hMP.hMS)
              {
                l1 = paramAnonymousld.hMP.hMS;
                ((al)localObject2).field_lastPushSeq = l1;
                ((al)localObject2).field_lastLocalSeq = paramAnonymousld.hMP.hMS;
                ((al)localObject2).field_lastPushCreateTime = paramAnonymousld.hMP.hMR;
                ((al)localObject2).field_lastLocalCreateTime = paramAnonymousld.hMP.hMT;
                l1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).a((al)localObject2, true);
                localObject1 = com.tencent.mm.ui.chatting.i.c.aeJl;
                com.tencent.mm.ui.chatting.i.c.jwO();
                Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] ret:%s,chatRoomId:%s lastPushSeq:%s lastPushCreateTime:%s lastLocalSeq:%s lastLocalCreateTime:%s", new Object[] { Long.valueOf(l1), paramAnonymousld.hMP.username, Long.valueOf(paramAnonymousld.hMP.hMQ), Long.valueOf(paramAnonymousld.hMP.hMR), Long.valueOf(paramAnonymousld.hMP.hMS), Long.valueOf(paramAnonymousld.hMP.hMT) });
                return true;
              }
              l1 = paramAnonymousld.hMP.hMQ;
              continue;
            }
            Object localObject2 = paramAnonymousld.hMP.username;
            localcc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLI((String)localObject2);
            l1 = paramAnonymousld.hMP.hMQ;
            long l3 = paramAnonymousld.hMP.hMR;
            paramAnonymousld = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aLq((String)localObject2);
            long l4 = paramAnonymousld.field_lastLocalSeq;
            long l5 = paramAnonymousld.field_lastLocalCreateTime;
            long l6 = paramAnonymousld.field_lastPushSeq;
            long l7 = paramAnonymousld.field_lastPushCreateTime;
            Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] isGetChatroom! %s conPushSeq:%s conPushCreateTime:%s localSeq:%s localCreateTime:%s pushSeq:%s pushCreateTime:%s", new Object[] { localObject2, Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7) });
            if ((localcc != null) && (localcc.field_msgId != 0L))
            {
              long l8 = localcc.field_msgSeq;
              if (l8 > l4)
              {
                paramAnonymousld.field_lastLocalSeq = l8;
                paramAnonymousld.field_lastLocalCreateTime = localcc.getCreateTime();
                com.tencent.mm.h.a.a.c localc = new com.tencent.mm.h.a.a.c();
                localc.lPP = (1L + l4);
                localc.lPR = (l5 + 1L);
                localc.lPQ = (l8 - 1L);
                localc.lPS = (l7 - 1L);
                if (paramAnonymousld.field_seqBlockInfo == null) {
                  paramAnonymousld.field_seqBlockInfo = new d();
                }
                paramAnonymousld.field_seqBlockInfo.lPT.addLast(localc);
                Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage local seq is smaller than MsgInfoStg local seq! ret:[%s]", new Object[] { Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).b(paramAnonymousld)) });
              }
              if (l6 < l1) {
                Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage push seq is smaller than conversation seq! ret:[%s,%s] [%s,%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aM((String)localObject2, l1)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aO((String)localObject2, l3)), Long.valueOf(localcc.field_msgSeq), Long.valueOf(l4) });
              }
              return true;
            }
            if (localcc == null)
            {
              bool = true;
              if (localcc != null) {
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
            AppMethodBeat.o(231770);
          }
          continue;
          label743:
          long l1 = localcc.field_msgId;
        }
      }
    };
    this.oFg = new HashMap();
    this.oFf.alive();
    b.bJr().oEY = this;
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().add(this, com.tencent.mm.kernel.h.baH().getLooper());
    u.bKZ();
    u.bKX().add(this, bh.baH().getLooper());
    this.__eventId = xs.class.getName().hashCode();
    AppMethodBeat.o(20506);
  }
  
  private static List<com.tencent.mm.h.a.a.c> a(String paramString, LinkedList<cc> paramLinkedList)
  {
    AppMethodBeat.i(20509);
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaU();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aLn(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nchatroomId:").append(paramString);
    long l1 = ((cc)paramLinkedList.getFirst()).field_msgSeq;
    long l2 = ((cc)paramLinkedList.getLast()).field_msgSeq;
    long l3 = ((cc)paramLinkedList.getFirst()).getCreateTime();
    long l4 = ((cc)paramLinkedList.getLast()).getCreateTime();
    localStringBuilder.append("\ngetFirst:").append(l1);
    localStringBuilder.append(" getLast:").append(l2);
    localStringBuilder.append(" getFirstCreateTime:").append(l3);
    localStringBuilder.append(" getLastCreateTime:").append(l4);
    localStringBuilder.append("\nblock ");
    paramLinkedList = new com.tencent.mm.h.a.a.c();
    paramLinkedList.lPP = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aLk(paramString) + 1L);
    paramLinkedList.lPR = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aLm(paramString) + 1L);
    paramLinkedList.lPQ = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aLj(paramString);
    paramLinkedList.lPS = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aLl(paramString);
    if (paramLinkedList.lPQ - paramLinkedList.lPP >= 0L) {
      ((d)localObject1).lPT.add(paramLinkedList);
    }
    for (;;)
    {
      paramString = new LinkedList();
      paramLinkedList = ((d)localObject1).lPT.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject1 = (com.tencent.mm.h.a.a.c)paramLinkedList.next();
        int j = 0;
        long l5 = ((com.tencent.mm.h.a.a.c)localObject1).lPP;
        long l6 = ((com.tencent.mm.h.a.a.c)localObject1).lPQ;
        long l7 = ((com.tencent.mm.h.a.a.c)localObject1).lPR;
        long l8 = ((com.tencent.mm.h.a.a.c)localObject1).lPS;
        localStringBuilder.append("[").append(l5).append(":").append(l6).append("][").append(l7).append(":").append(l8).append("] | ");
        int i = j;
        if (l5 <= l1)
        {
          i = j;
          if (l1 <= l6)
          {
            localObject2 = new com.tencent.mm.h.a.a.c();
            ((com.tencent.mm.h.a.a.c)localObject2).lPP = ((com.tencent.mm.h.a.a.c)localObject1).lPP;
            ((com.tencent.mm.h.a.a.c)localObject2).lPQ = (l1 - 1L);
            ((com.tencent.mm.h.a.a.c)localObject2).lPR = l7;
            ((com.tencent.mm.h.a.a.c)localObject2).lPS = (l3 - 1L);
            i = j;
            if (((com.tencent.mm.h.a.a.c)localObject2).lPQ - ((com.tencent.mm.h.a.a.c)localObject2).lPP >= 0L)
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
            localObject2 = new com.tencent.mm.h.a.a.c();
            ((com.tencent.mm.h.a.a.c)localObject2).lPP = (1L + l2);
            ((com.tencent.mm.h.a.a.c)localObject2).lPQ = l6;
            ((com.tencent.mm.h.a.a.c)localObject2).lPR = (1L + l4);
            ((com.tencent.mm.h.a.a.c)localObject2).lPS = l8;
            j = i;
            if (((com.tencent.mm.h.a.a.c)localObject2).lPQ - ((com.tencent.mm.h.a.a.c)localObject2).lPP >= 0L)
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
      Log.w("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] lastSeq[%s]<firstSeq[%s]", new Object[] { Long.valueOf(paramLinkedList.lPQ), Long.valueOf(paramLinkedList.lPP) });
    }
    paramLinkedList = new StringBuilder();
    localObject1 = paramString.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.h.a.a.c)((Iterator)localObject1).next();
      paramLinkedList.append("[").append(((com.tencent.mm.h.a.a.c)localObject2).lPP).append(":").append(((com.tencent.mm.h.a.a.c)localObject2).lPQ).append("][").append(((com.tencent.mm.h.a.a.c)localObject2).lPR).append(":").append(((com.tencent.mm.h.a.a.c)localObject2).lPS).append("] | ");
    }
    Log.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] " + localStringBuilder.toString() + "\nnew blockList:" + paramLinkedList.toString());
    AppMethodBeat.o(20509);
    return paramString;
  }
  
  private static void e(Map<Long, bv> paramMap, String paramString)
  {
    AppMethodBeat.i(20511);
    if ((paramMap.size() == 0) || (ab.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(20511);
      return;
    }
    paramMap = paramMap.values().iterator();
    if (paramMap != null) {
      while (paramMap.hasNext())
      {
        Object localObject1 = (bv)paramMap.next();
        if ((localObject1 != null) && (paramString.equals(((bv)localObject1).field_fromUserName)))
        {
          bh.bCz();
          Object localObject2 = com.tencent.mm.model.c.bzD().aU(paramString, ((bv)localObject1).field_originSvrId);
          if (((fi)localObject2).field_msgId != 0L)
          {
            Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", new Object[] { Long.valueOf(((fi)localObject2).field_msgId), Long.valueOf(((fi)localObject2).field_msgSvrId) });
            localObject2 = new dl();
            ((dl)localObject2).Njv = ((bv)localObject1).field_newMsgId;
            ((dl)localObject2).YFE = w.Sk(((bv)localObject1).field_fromUserName);
            ((dl)localObject2).YFF = w.Sk(((bv)localObject1).field_toUserName);
            ((dl)localObject2).CreateTime = ((int)((bv)localObject1).field_createTime);
            ((dl)localObject2).YFG = w.Sk(((bv)localObject1).field_content);
            ((dl)localObject2).YFJ = ((bv)localObject1).field_msgSource;
            ((dl)localObject2).YFL = ((bv)localObject1).field_msgSeq;
            int i = ((bv)localObject1).field_flag;
            ((dl)localObject2).IIs = 10002;
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
              ((cl)localObject1).b(new g.a((dl)localObject2, bool1, bool2, bool3));
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
  
  public final void a(String paramString, boolean paramBoolean1, LinkedList<cc> paramLinkedList, com.tencent.mm.h.a.a.c paramc, boolean paramBoolean2)
  {
    AppMethodBeat.i(20507);
    long l1;
    long l2;
    long l3;
    if ((paramLinkedList.size() <= 0) || (paramBoolean2))
    {
      Log.w("MicroMsg.GetChatroomMsgReceiver", "[onFetched] fetchList.size() == 0! removeBlock! isBlockAll:".concat(String.valueOf(paramBoolean2)));
      l1 = paramc.lPP;
      l2 = paramc.lPQ;
      Log.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString);
      paramLinkedList = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaU();
      paramc = paramLinkedList.aLq(paramString);
      if ((paramc != null) && (paramc.field_seqBlockInfo != null))
      {
        localObject1 = new LinkedList();
        localObject2 = paramc.field_seqBlockInfo.lPT.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.h.a.a.c localc = (com.tencent.mm.h.a.a.c)((Iterator)localObject2).next();
          if ((localc.lPP == l1) && (localc.lPQ == l2)) {
            ((List)localObject1).add(localc);
          }
        }
        paramc.field_seqBlockInfo.lPT.removeAll((Collection)localObject1);
        l3 = paramLinkedList.b(paramc);
        Log.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString + " ret:" + l3 + " remove list:" + ((List)localObject1).size());
        if (((List)localObject1).size() > 0)
        {
          localObject1 = com.tencent.mm.ui.chatting.i.c.aeJl;
          com.tencent.mm.ui.chatting.i.c.jwQ();
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
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaU();
    Object localObject2 = a(paramString, paramLinkedList);
    paramc = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aLn(paramString);
    if (paramc == null)
    {
      paramc = new d();
      paramc.lPT.clear();
      paramc.lPT.addAll((Collection)localObject2);
      paramBoolean1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).a(paramString, paramc);
      l1 = ((cc)paramLinkedList.getLast()).field_msgSeq;
      l2 = ((cc)paramLinkedList.getLast()).getCreateTime();
      l3 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aLk(paramString);
      long l4 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aLm(paramString);
      Log.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] blockList size:%s ret:%s GetSeq:[last %s:old %s] GetLocalCreateTime:[last %s:old %s]", new Object[] { Integer.valueOf(paramc.lPT.size()), Boolean.valueOf(paramBoolean1), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4) });
      if (l3 >= l1) {
        break label707;
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aP(paramString, l1);
      ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aN(paramString, l2);
    }
    for (;;)
    {
      e(new HashMap(this.oFg), paramString);
      AppMethodBeat.o(20507);
      return;
      break;
      label707:
      Log.w("MicroMsg.GetChatroomMsgReceiver", "oldGetSeq>=lastGetSeq [%s:%s]", new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
    }
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, final Object paramObject)
  {
    AppMethodBeat.i(20508);
    if ((paramMStorageEx == ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG()) && ((paramObject instanceof String)) && (5 == paramInt)) {
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231765);
          com.tencent.mm.plugin.messenger.foundation.a.a.b localb = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaU();
          String str = (String)paramObject;
          if (localb.aLo(str))
          {
            al localal = localb.aLq(str);
            if (localal.field_seqBlockInfo != null) {
              localal.field_seqBlockInfo.lPT.clear();
            }
            localal.field_lastLocalSeq = localal.field_lastPushSeq;
            localal.field_lastLocalCreateTime = localal.field_lastPushCreateTime;
            long l = localb.b(localal);
            Log.i("MicroMsg.GetChatroomMsgReceiver", "[onNotifyChange] username:" + str + " ret:" + l + " chatroomMsgSeq:" + localal.toString());
          }
          AppMethodBeat.o(231765);
        }
      });
    }
    AppMethodBeat.o(20508);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(20510);
    if (!ab.isNullOrNil(paramString)) {
      try
      {
        long l = Long.valueOf(paramString).longValue();
        paramString = new bv();
        paramString.field_originSvrId = l;
        u.bKZ();
        if (u.bKX().get(paramString, new String[0]))
        {
          this.oFg.put(Long.valueOf(l), paramString);
          Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange put info systemRowid[%d], svrId[%d]", new Object[] { Long.valueOf(paramString.systemRowid), Long.valueOf(l) });
          AppMethodBeat.o(20510);
          return;
        }
        this.oFg.remove(Long.valueOf(l));
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
    xs oFi;
    
    private a(xs paramxs)
    {
      this.oFi = paramxs;
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
        if (!com.tencent.mm.kernel.h.baz())
        {
          Log.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] accHasReady no!");
          Log.d("MicroMsg.GetChatroomMsgReceiver", "[HandlePushTask$run] cost:" + (System.currentTimeMillis() - l3));
          AppMethodBeat.o(20505);
          return;
        }
        localObject1 = this.oFi.ibg.data;
        if (localObject1 != null) {
          localObject3 = new dm();
        }
      }
      catch (Exception localException1)
      {
        label521:
        label1805:
        label1810:
        label1815:
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
            ((dm)localObject3).parseFrom((byte[])localObject1);
            long l4 = System.currentTimeMillis();
            str = w.a(((dm)localObject3).YFM);
            i = ((dm)localObject3).YFL;
            l5 = 1000L * ((dm)localObject3).CreateTime;
            localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaU();
            if (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject4).aLo(str))
            {
              Log.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#update] chatRoomId:%s updatePushSeqRet[%s]:%s updatePushCreateTimeRet[%s]:%s", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject4).aM(str, i)), Long.valueOf(l5), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject4).aO(str, l5)) });
              Log.d("MicroMsg.GetChatroomMsgReceiver", "[updateChatroomMsgSeq] cost:" + (System.currentTimeMillis() - l4));
              l2 = System.currentTimeMillis();
              str = w.a(((dm)localObject3).YFM);
              n = ((dm)localObject3).YFL;
              l1 = ((dm)localObject3).Njv;
              j = ((dm)localObject3).CreateTime;
              int k = ((dm)localObject3).YFP;
              m = ((dm)localObject3).IIs;
              i = ((dm)localObject3).YFN;
              localObject3 = w.a(((dm)localObject3).YFO);
              Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", new Object[] { str, Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Util.secPrint((String)localObject3) });
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM(str);
              if (localObject1 != null) {
                break label1238;
              }
              localObject1 = new bb(str);
              ((bb)localObject1).gR(j * 1000L);
              ((bb)localObject1).gT(n);
              ((bb)localObject1).pG(1);
              ((bb)localObject1).pN(1);
              b.bJr();
              b.NJ(str);
              l1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bAd().aLs(str);
              Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", new Object[] { Long.valueOf(l1), Integer.valueOf(n) });
              if (l1 <= 0L) {
                break label1792;
              }
              ((bb)localObject1).gU(l1);
              i = 1;
              if (k > 0) {
                ((bb)localObject1).pL(((bd)localObject1).field_atCount + k);
              }
              localObject4 = new cc();
              ((cc)localObject4).pI(0);
              ((cc)localObject4).BS(str);
              ((cc)localObject4).setType(m);
              ((cc)localObject4).setContent((String)localObject3);
              if (m != 49) {
                break label1572;
              }
              localObject5 = k.b.Hf(k.ph(str, (String)localObject3));
              ((cc)localObject4).setType(com.tencent.mm.pluginsdk.model.app.n.h((k.b)localObject5));
              if (!((cc)localObject4).iYe()) {
                break label1815;
              }
              localObject3 = ((k.b)localObject5).content;
              ((cc)localObject4).setContent((String)localObject3);
              ((bb)localObject1).pI(0);
              ((bb)localObject1).setContent(((fi)localObject4).field_content);
              ((bb)localObject1).BE(Integer.toString(((cc)localObject4).getType()));
              localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().aDH();
              if (localObject3 == null) {
                break label1632;
              }
              localObject5 = new PString();
              PString localPString = new PString();
              PInt localPInt = new PInt();
              ((by.b)localObject3).a((cc)localObject4, (PString)localObject5, localPString, localPInt, false);
              ((bb)localObject1).BF(((PString)localObject5).value);
              ((bb)localObject1).BG(localPString.value);
              ((bb)localObject1).pJ(localPInt.value);
              if (((cc)localObject4).getType() == 49)
              {
                localObject3 = (String)XmlParser.parseXml(((bd)localObject1).field_content, "msg", null).get(".msg.appmsg.title");
                localObject4 = Util.nullAsNil(((bd)localObject1).field_digest);
                if (!Util.isNullOrNil((String)localObject3)) {
                  break label1606;
                }
                localObject3 = "";
                label809:
                ((bb)localObject1).BF(((String)localObject4).concat((String)localObject3));
              }
              label821:
              if (i == 0) {
                break label1645;
              }
              Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { str, Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().h((bb)localObject1)), Long.valueOf(((bd)localObject1).field_firstUnDeliverSeq), Long.valueOf(((bd)localObject1).field_lastSeq), Integer.valueOf(((bd)localObject1).field_UnDeliverCount) });
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
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLI(str);
            if (localObject2 == null) {
              break label1753;
            }
          }
          label1017:
          long l6;
          if (((fi)localObject2).field_msgId == 0L)
          {
            Log.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] has not any ReceivedMsg!");
            localObject2 = null;
            if (localObject2 != null)
            {
              localObject5 = com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd HH:mm:ss", ((cc)localObject2).getCreateTime() / 1000L);
              Log.w("MicroMsg.GetChatroomMsgReceiver", "[lastFaultMsgInfo] lastFaultMsgInfo:%s timeFormat:%s", new Object[] { Util.secPrint(((fi)localObject2).field_content), localObject5 });
            }
            localObject5 = new al();
            ((al)localObject5).field_username = str;
            ((al)localObject5).field_lastPushSeq = i;
            if (localObject2 == null) {
              break label1756;
            }
            l1 = ((fi)localObject2).field_msgSeq;
            label1102:
            ((al)localObject5).field_lastLocalSeq = l1;
            ((al)localObject5).field_lastPushCreateTime = l5;
            if (localObject2 == null) {
              break label1765;
            }
            l1 = ((cc)localObject2).getCreateTime();
            label1128:
            ((al)localObject5).field_lastLocalCreateTime = l1;
            l6 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject4).a((al)localObject5);
            if (localObject2 == null) {
              break label1774;
            }
            l1 = ((fi)localObject2).field_msgSeq;
            if (localObject2 == null) {
              break label1783;
            }
          }
          label1238:
          label1632:
          label1645:
          label1774:
          label1783:
          for (long l2 = ((cc)localObject2).getCreateTime();; l2 = l5 - 1L)
          {
            Log.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#insert] ret:%s,chatRoomId:%s updatePushSeq:%s updatePushCreateTime:%s field_lastLocalSeq:%s field_lastLocalCreateTime:%s", new Object[] { Long.valueOf(l6), str, Integer.valueOf(i), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l2) });
            localObject2 = com.tencent.mm.ui.chatting.i.c.aeJl;
            com.tencent.mm.ui.chatting.i.c.jwO();
            break label216;
            int i1 = (int)((bd)localObject2).field_lastSeq;
            if (n > i1)
            {
              ((bb)localObject2).gT(n);
              int i2 = ((bd)localObject2).field_UnDeliverCount;
              ((bb)localObject2).pN(i);
              ((bb)localObject2).gR(j * 1000L);
              if (i > ((bd)localObject2).field_unReadCount) {}
              for (;;)
              {
                j = i;
                if (i < 0)
                {
                  Log.e("MicroMsg.GetChatroomMsgReceiver", "why???, unreadCount %d", new Object[] { Integer.valueOf(i) });
                  j = 0;
                }
                ((bb)localObject2).pG(j);
                l1 = ((bd)localObject2).field_firstUnDeliverSeq;
                Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv  msgSeq[%d], firstSeq[%d], lastseq[%d]", new Object[] { Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1) });
                if (l1 <= 0L) {
                  break;
                }
                localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aV(str, i1);
                if ((localObject4 == null) || (((fi)localObject4).field_msgId <= 0L)) {
                  break label1800;
                }
                ((bb)localObject2).gU(((fi)localObject4).field_msgSeq);
                break label1800;
                i = i - i2 + ((bd)localObject2).field_unReadCount;
              }
              l1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bAd().aLs(str);
              if (l1 > 0L)
              {
                ((bb)localObject2).gU(l1);
                i = 0;
                break label521;
              }
              l1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aMa(str);
              Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv lastMsgSeq[%s]", new Object[] { Long.valueOf(l1) });
              if (l1 <= 0L) {
                break label1805;
              }
              ((bb)localObject2).gU(l1);
              break label1805;
            }
            if ((n != i1) || (i != 0) || (((bd)localObject2).field_unReadCount <= 0)) {
              break label1810;
            }
            ((bb)localObject2).pG(0);
            break label1810;
            if (m != 10002) {
              break label624;
            }
            ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension();
            cl.e((cc)localObject4, (String)localObject3);
            break label624;
            localObject3 = " " + Util.nullAsNil((String)localObject3);
            break label809;
            ((bb)localObject2).BF(((bd)localObject2).field_content);
            break label821;
            ((bb)localObject2).pK(((bd)localObject2).field_attrflag & 0xFFEFFFFF);
            Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { str, Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().a((bb)localObject2, str, true)), Long.valueOf(((bd)localObject2).field_firstUnDeliverSeq), Long.valueOf(((bd)localObject2).field_lastSeq), Integer.valueOf(((bd)localObject2).field_UnDeliverCount) });
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
          label1572:
          label1606:
          label1753:
          label1756:
          label1765:
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
 * Qualified Name:     com.tencent.mm.modelgetchatroommsg.GetChatroomMsgReceiver
 * JD-Core Version:    0.7.0.1
 */