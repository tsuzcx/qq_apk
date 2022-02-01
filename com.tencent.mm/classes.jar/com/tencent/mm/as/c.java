package com.tencent.mm.as;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.g.a.jk.a;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.ux.a;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.df;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.SemiXml;
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
  extends IListener<ux>
  implements b.a, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  public final IListener iWd;
  private Map<Long, bt> iWe;
  
  public c()
  {
    AppMethodBeat.i(20506);
    this.iWd = new IListener()
    {
      private static boolean a(jk paramAnonymousjk)
      {
        AppMethodBeat.i(231543);
        long l2 = System.currentTimeMillis();
        for (;;)
        {
          ca localca;
          try
          {
            Object localObject1 = ((l)g.af(l.class)).eit();
            if (!((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aEf(paramAnonymousjk.dOf.username))
            {
              localObject2 = new aj();
              ((aj)localObject2).field_username = paramAnonymousjk.dOf.username;
              if (paramAnonymousjk.dOf.dOg <= paramAnonymousjk.dOf.dOi)
              {
                l1 = paramAnonymousjk.dOf.dOi;
                ((aj)localObject2).field_lastPushSeq = l1;
                ((aj)localObject2).field_lastLocalSeq = paramAnonymousjk.dOf.dOi;
                ((aj)localObject2).field_lastPushCreateTime = paramAnonymousjk.dOf.dOh;
                ((aj)localObject2).field_lastLocalCreateTime = paramAnonymousjk.dOf.dOj;
                l1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).a((aj)localObject2, true);
                localObject1 = com.tencent.mm.ui.chatting.l.c.PEZ;
                com.tencent.mm.ui.chatting.l.c.gTH();
                Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] ret:%s,chatRoomId:%s lastPushSeq:%s lastPushCreateTime:%s lastLocalSeq:%s lastLocalCreateTime:%s", new Object[] { Long.valueOf(l1), paramAnonymousjk.dOf.username, Long.valueOf(paramAnonymousjk.dOf.dOg), Long.valueOf(paramAnonymousjk.dOf.dOh), Long.valueOf(paramAnonymousjk.dOf.dOi), Long.valueOf(paramAnonymousjk.dOf.dOj) });
                return true;
              }
              l1 = paramAnonymousjk.dOf.dOg;
              continue;
            }
            Object localObject2 = paramAnonymousjk.dOf.username;
            localca = ((l)g.af(l.class)).eiy().aEz((String)localObject2);
            l1 = paramAnonymousjk.dOf.dOg;
            long l3 = paramAnonymousjk.dOf.dOh;
            paramAnonymousjk = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aEh((String)localObject2);
            long l4 = paramAnonymousjk.field_lastLocalSeq;
            long l5 = paramAnonymousjk.field_lastLocalCreateTime;
            long l6 = paramAnonymousjk.field_lastPushSeq;
            long l7 = paramAnonymousjk.field_lastPushCreateTime;
            Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] isGetChatroom! %s conPushSeq:%s conPushCreateTime:%s localSeq:%s localCreateTime:%s pushSeq:%s pushCreateTime:%s", new Object[] { localObject2, Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7) });
            if ((localca != null) && (localca.field_msgId != 0L))
            {
              long l8 = localca.field_msgSeq;
              if (l8 > l4)
              {
                paramAnonymousjk.field_lastLocalSeq = l8;
                paramAnonymousjk.field_lastLocalCreateTime = localca.field_createTime;
                com.tencent.mm.k.a.a.c localc = new com.tencent.mm.k.a.a.c();
                localc.gCy = (1L + l4);
                localc.gCA = (l5 + 1L);
                localc.gCz = (l8 - 1L);
                localc.gCB = (l7 - 1L);
                if (paramAnonymousjk.field_seqBlockInfo == null) {
                  paramAnonymousjk.field_seqBlockInfo = new d();
                }
                paramAnonymousjk.field_seqBlockInfo.gCC.addLast(localc);
                Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage local seq is smaller than MsgInfoStg local seq! ret:[%s]", new Object[] { Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).b(paramAnonymousjk)) });
              }
              if (l6 < l1) {
                Log.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage push seq is smaller than conversation seq! ret:[%s,%s] [%s,%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aB((String)localObject2, l1)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aD((String)localObject2, l3)), Long.valueOf(localca.field_msgSeq), Long.valueOf(l4) });
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
            AppMethodBeat.o(231543);
          }
          continue;
          label743:
          long l1 = localca.field_msgId;
        }
      }
    };
    this.iWe = new HashMap();
    EventCenter.instance.addListener(this.iWd);
    b.bch().iVW = this;
    ((l)g.af(l.class)).aST().add(this, g.aAk().getLooper());
    p.bdT();
    p.bdR().add(this, bg.aAk().getLooper());
    this.__eventId = ux.class.getName().hashCode();
    AppMethodBeat.o(20506);
  }
  
  private static List<com.tencent.mm.k.a.a.c> a(String paramString, LinkedList<ca> paramLinkedList)
  {
    AppMethodBeat.i(20509);
    Object localObject2 = ((l)g.af(l.class)).eit();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aEe(paramString);
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
    paramLinkedList.gCy = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aEb(paramString) + 1L);
    paramLinkedList.gCA = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aEd(paramString) + 1L);
    paramLinkedList.gCz = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aEa(paramString);
    paramLinkedList.gCB = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).aEc(paramString);
    if (paramLinkedList.gCz - paramLinkedList.gCy >= 0L) {
      ((d)localObject1).gCC.add(paramLinkedList);
    }
    for (;;)
    {
      paramString = new LinkedList();
      paramLinkedList = ((d)localObject1).gCC.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject1 = (com.tencent.mm.k.a.a.c)paramLinkedList.next();
        int j = 0;
        long l5 = ((com.tencent.mm.k.a.a.c)localObject1).gCy;
        long l6 = ((com.tencent.mm.k.a.a.c)localObject1).gCz;
        long l7 = ((com.tencent.mm.k.a.a.c)localObject1).gCA;
        long l8 = ((com.tencent.mm.k.a.a.c)localObject1).gCB;
        localStringBuilder.append("[").append(l5).append(":").append(l6).append("][").append(l7).append(":").append(l8).append("] | ");
        int i = j;
        if (l5 <= l1)
        {
          i = j;
          if (l1 <= l6)
          {
            localObject2 = new com.tencent.mm.k.a.a.c();
            ((com.tencent.mm.k.a.a.c)localObject2).gCy = ((com.tencent.mm.k.a.a.c)localObject1).gCy;
            ((com.tencent.mm.k.a.a.c)localObject2).gCz = (l1 - 1L);
            ((com.tencent.mm.k.a.a.c)localObject2).gCA = l7;
            ((com.tencent.mm.k.a.a.c)localObject2).gCB = (l3 - 1L);
            i = j;
            if (((com.tencent.mm.k.a.a.c)localObject2).gCz - ((com.tencent.mm.k.a.a.c)localObject2).gCy >= 0L)
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
            ((com.tencent.mm.k.a.a.c)localObject2).gCy = (1L + l2);
            ((com.tencent.mm.k.a.a.c)localObject2).gCz = l6;
            ((com.tencent.mm.k.a.a.c)localObject2).gCA = (1L + l4);
            ((com.tencent.mm.k.a.a.c)localObject2).gCB = l8;
            j = i;
            if (((com.tencent.mm.k.a.a.c)localObject2).gCz - ((com.tencent.mm.k.a.a.c)localObject2).gCy >= 0L)
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
      Log.w("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] lastSeq[%s]<firstSeq[%s]", new Object[] { Long.valueOf(paramLinkedList.gCz), Long.valueOf(paramLinkedList.gCy) });
    }
    paramLinkedList = new StringBuilder();
    localObject1 = paramString.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.k.a.a.c)((Iterator)localObject1).next();
      paramLinkedList.append("[").append(((com.tencent.mm.k.a.a.c)localObject2).gCy).append(":").append(((com.tencent.mm.k.a.a.c)localObject2).gCz).append("][").append(((com.tencent.mm.k.a.a.c)localObject2).gCA).append(":").append(((com.tencent.mm.k.a.a.c)localObject2).gCB).append("] | ");
    }
    Log.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] " + localStringBuilder.toString() + "\nnew blockList:" + paramLinkedList.toString());
    AppMethodBeat.o(20509);
    return paramString;
  }
  
  private static void d(Map<Long, bt> paramMap, String paramString)
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
        Object localObject1 = (bt)paramMap.next();
        if ((localObject1 != null) && (paramString.equals(((bt)localObject1).field_fromUserName)))
        {
          bg.aVF();
          Object localObject2 = com.tencent.mm.model.c.aSQ().aJ(paramString, ((bt)localObject1).field_originSvrId);
          if (((eo)localObject2).field_msgId != 0L)
          {
            Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", new Object[] { Long.valueOf(((eo)localObject2).field_msgId), Long.valueOf(((eo)localObject2).field_msgSvrId) });
            localObject2 = new de();
            ((de)localObject2).Brn = ((bt)localObject1).field_newMsgId;
            ((de)localObject2).KHl = z.Su(((bt)localObject1).field_fromUserName);
            ((de)localObject2).KHm = z.Su(((bt)localObject1).field_toUserName);
            ((de)localObject2).CreateTime = ((int)((bt)localObject1).field_createTime);
            ((de)localObject2).KHn = z.Su(((bt)localObject1).field_content);
            ((de)localObject2).KHq = ((bt)localObject1).field_msgSource;
            ((de)localObject2).KHs = ((bt)localObject1).field_msgSeq;
            int i = ((bt)localObject1).field_flag;
            ((de)localObject2).xKb = 10002;
            localObject1 = bg.getSysCmdMsgExtension();
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
              ((cj)localObject1).b(new h.a((de)localObject2, bool1, bool2, bool3));
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
      l1 = paramc.gCy;
      l2 = paramc.gCz;
      Log.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString);
      paramLinkedList = ((l)g.af(l.class)).eit();
      paramc = paramLinkedList.aEh(paramString);
      if (paramc.field_seqBlockInfo != null)
      {
        localObject1 = new LinkedList();
        localObject2 = paramc.field_seqBlockInfo.gCC.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.k.a.a.c localc = (com.tencent.mm.k.a.a.c)((Iterator)localObject2).next();
          if ((localc.gCy == l1) && (localc.gCz == l2)) {
            ((List)localObject1).add(localc);
          }
        }
        paramc.field_seqBlockInfo.gCC.removeAll((Collection)localObject1);
        l3 = paramLinkedList.b(paramc);
        Log.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString + " ret:" + l3 + " remove list:" + ((List)localObject1).size());
        if (((List)localObject1).size() > 0)
        {
          localObject1 = com.tencent.mm.ui.chatting.l.c.PEZ;
          com.tencent.mm.ui.chatting.l.c.gTJ();
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
    paramc = ((l)g.af(l.class)).eit();
    Object localObject1 = a(paramString, paramLinkedList);
    Object localObject2 = paramc.aEe(paramString);
    ((d)localObject2).gCC.clear();
    ((d)localObject2).gCC.addAll((Collection)localObject1);
    paramBoolean1 = paramc.a(paramString, (d)localObject2);
    long l1 = ((ca)paramLinkedList.getLast()).field_msgSeq;
    long l2 = ((ca)paramLinkedList.getLast()).field_createTime;
    long l3 = paramc.aEb(paramString);
    long l4 = paramc.aEd(paramString);
    Log.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] blockList size:%s ret:%s GetSeq:[last %s:old %s] GetLocalCreateTime:[last %s:old %s]", new Object[] { Integer.valueOf(((d)localObject2).gCC.size()), Boolean.valueOf(paramBoolean1), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4) });
    if (l3 < l1)
    {
      paramc.aE(paramString, l1);
      paramc.aC(paramString, l2);
    }
    for (;;)
    {
      d(new HashMap(this.iWe), paramString);
      AppMethodBeat.o(20507);
      return;
      Log.w("MicroMsg.GetChatroomMsgReceiver", "oldGetSeq>=lastGetSeq [%s:%s]", new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
    }
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, final Object paramObject)
  {
    AppMethodBeat.i(20508);
    if ((paramMStorageEx == ((l)g.af(l.class)).aST()) && ((paramObject instanceof String)) && (5 == paramInt)) {
      h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231541);
          com.tencent.mm.plugin.messenger.foundation.a.a.b localb = ((l)g.af(l.class)).eit();
          String str = (String)paramObject;
          if (localb.aEf(str))
          {
            aj localaj = localb.aEh(str);
            if (localaj.field_seqBlockInfo != null) {
              localaj.field_seqBlockInfo.gCC.clear();
            }
            localaj.field_lastLocalSeq = localaj.field_lastPushSeq;
            localaj.field_lastLocalCreateTime = localaj.field_lastPushCreateTime;
            long l = localb.b(localaj);
            Log.i("MicroMsg.GetChatroomMsgReceiver", "[onNotifyChange] username:" + str + " ret:" + l + " chatroomMsgSeq:" + localaj.toString());
          }
          AppMethodBeat.o(231541);
        }
      });
    }
    AppMethodBeat.o(20508);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(20510);
    if (!af.isNullOrNil(paramString)) {
      try
      {
        long l = Long.valueOf(paramString).longValue();
        paramString = new bt();
        paramString.field_originSvrId = l;
        p.bdT();
        if (p.bdR().get(paramString, new String[0]))
        {
          this.iWe.put(Long.valueOf(l), paramString);
          Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange put info systemRowid[%d], svrId[%d]", new Object[] { Long.valueOf(paramString.systemRowid), Long.valueOf(l) });
          AppMethodBeat.o(20510);
          return;
        }
        this.iWe.remove(Long.valueOf(l));
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
    ux iWg;
    
    private a(ux paramux)
    {
      this.iWg = paramux;
    }
    
    public final void run()
    {
      AppMethodBeat.i(20505);
      long l3 = System.currentTimeMillis();
      label512:
      label521:
      label809:
      label2095:
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
        ca localca;
        label617:
        label624:
        Object localObject2;
        try
        {
          if (!g.aAc())
          {
            Log.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] accHasReady no!");
            Log.d("MicroMsg.GetChatroomMsgReceiver", "[HandlePushTask$run] cost:" + (System.currentTimeMillis() - l3));
            AppMethodBeat.o(20505);
            return;
          }
          localObject1 = this.iWg.ebm.data;
          if (localObject1 == null) {
            break label2009;
          }
          localObject3 = new df();
        }
        catch (Exception localException1)
        {
          try
          {
            Object localObject1;
            ((df)localObject3).parseFrom((byte[])localObject1);
            long l4 = System.currentTimeMillis();
            localObject4 = z.a(((df)localObject3).KHt);
            i = ((df)localObject3).KHs;
            l5 = 1000L * ((df)localObject3).CreateTime;
            localObject5 = ((l)g.af(l.class)).eit();
            if (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).aEf((String)localObject4))
            {
              Log.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#update] chatRoomId:%s updatePushSeqRet[%s]:%s updatePushCreateTimeRet[%s]:%s", new Object[] { localObject4, Integer.valueOf(i), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).aB((String)localObject4, i)), Long.valueOf(l5), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).aD((String)localObject4, l5)) });
              Log.d("MicroMsg.GetChatroomMsgReceiver", "[updateChatroomMsgSeq] cost:" + (System.currentTimeMillis() - l4));
              l2 = System.currentTimeMillis();
              localObject6 = z.a(((df)localObject3).KHt);
              n = ((df)localObject3).KHs;
              l1 = ((df)localObject3).Brn;
              j = ((df)localObject3).CreateTime;
              int k = ((df)localObject3).KHw;
              m = ((df)localObject3).xKb;
              i = ((df)localObject3).KHu;
              localObject3 = z.a(((df)localObject3).KHv);
              Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", new Object[] { localObject6, Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Util.secPrint((String)localObject3) });
              localObject1 = ((l)g.af(l.class)).aST().bjY((String)localObject6);
              if (localObject1 != null) {
                break label1238;
              }
              localObject1 = new az((String)localObject6);
              ((az)localObject1).yA(j * 1000L);
              ((az)localObject1).yC(n);
              ((az)localObject1).nt(1);
              ((az)localObject1).nA(1);
              b.bch();
              b.Om((String)localObject6);
              l1 = ((l)g.af(l.class)).aTq().aEj((String)localObject6);
              Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", new Object[] { Long.valueOf(l1), Integer.valueOf(n) });
              if (l1 <= 0L) {
                break label2059;
              }
              ((az)localObject1).yD(l1);
              i = 1;
              if (k > 0) {
                ((az)localObject1).ny(((bb)localObject1).field_atCount + k);
              }
              localca = new ca();
              localca.nv(0);
              localca.Cy((String)localObject6);
              localca.setType(m);
              localca.setContent((String)localObject3);
              if (m != 49) {
                break label1567;
              }
              localObject4 = k.b.HD(k.mx((String)localObject6, (String)localObject3));
              localca.setType(m.g((k.b)localObject4));
              if (!localca.gAt()) {
                break label2082;
              }
              localObject3 = ((k.b)localObject4).content;
              localca.setContent((String)localObject3);
              ((az)localObject1).nv(0);
              ((az)localObject1).setContent(localca.field_content);
              ((az)localObject1).Cl(Integer.toString(localca.getType()));
              localObject3 = ((l)g.af(l.class)).aST().Xh();
              if (localObject3 == null) {
                break label1899;
              }
              localObject4 = new PString();
              localObject5 = new PString();
              PInt localPInt = new PInt();
              ((bw.b)localObject3).a(localca, (PString)localObject4, (PString)localObject5, localPInt, false);
              ((az)localObject1).Cm(((PString)localObject4).value);
              ((az)localObject1).Cn(((PString)localObject5).value);
              ((az)localObject1).nw(localPInt.value);
              if (localca.getType() == 49)
              {
                localObject3 = (String)XmlParser.parseXml(((bb)localObject1).field_content, "msg", null).get(".msg.appmsg.title");
                localObject4 = Util.nullAsNil(((bb)localObject1).field_digest);
                if (!Util.isNullOrNil((String)localObject3)) {
                  break label1873;
                }
                localObject3 = "";
                ((az)localObject1).Cm(((String)localObject4).concat((String)localObject3));
              }
              label821:
              if (i == 0) {
                break label1912;
              }
              Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { localObject6, Long.valueOf(((l)g.af(l.class)).aST().e((az)localObject1)), Long.valueOf(((bb)localObject1).field_firstUnDeliverSeq), Long.valueOf(((bb)localObject1).field_lastSeq), Integer.valueOf(((bb)localObject1).field_UnDeliverCount) });
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
            localObject2 = ((l)g.af(l.class)).eiy().aEz((String)localObject4);
            if (localObject2 == null) {
              break label2020;
            }
          }
        }
        if (((eo)localObject2).field_msgId == 0L)
        {
          Log.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] has not any ReceivedMsg!");
          localObject2 = null;
          label1017:
          if (localObject2 != null)
          {
            localObject6 = f.formatTime("yyyy-MM-dd HH:mm:ss", ((eo)localObject2).field_createTime / 1000L);
            Log.w("MicroMsg.GetChatroomMsgReceiver", "[lastFaultMsgInfo] lastFaultMsgInfo:%s timeFormat:%s", new Object[] { Util.secPrint(((eo)localObject2).field_content), localObject6 });
          }
          localObject6 = new aj();
          ((aj)localObject6).field_username = ((String)localObject4);
          ((aj)localObject6).field_lastPushSeq = i;
          if (localObject2 == null) {
            break label2023;
          }
          l1 = ((eo)localObject2).field_msgSeq;
          label1102:
          ((aj)localObject6).field_lastLocalSeq = l1;
          ((aj)localObject6).field_lastPushCreateTime = l5;
          if (localObject2 == null) {
            break label2032;
          }
          l1 = ((eo)localObject2).field_createTime;
          label1128:
          ((aj)localObject6).field_lastLocalCreateTime = l1;
          long l6 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).a((aj)localObject6);
          if (localObject2 == null) {
            break label2041;
          }
          l1 = ((eo)localObject2).field_msgSeq;
          if (localObject2 == null) {
            break label2050;
          }
          l2 = ((eo)localObject2).field_createTime;
          Log.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#insert] ret:%s,chatRoomId:%s updatePushSeq:%s updatePushCreateTime:%s field_lastLocalSeq:%s field_lastLocalCreateTime:%s", new Object[] { Long.valueOf(l6), localObject4, Integer.valueOf(i), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l2) });
          localObject2 = com.tencent.mm.ui.chatting.l.c.PEZ;
          com.tencent.mm.ui.chatting.l.c.gTH();
          continue;
          label1238:
          int i1 = (int)((bb)localObject2).field_lastSeq;
          if (n > i1)
          {
            ((az)localObject2).yC(n);
            int i2 = ((bb)localObject2).field_UnDeliverCount;
            ((az)localObject2).nA(i);
            ((az)localObject2).yA(j * 1000L);
            if (i > ((bb)localObject2).field_unReadCount) {}
            for (;;)
            {
              j = i;
              if (i < 0)
              {
                Log.e("MicroMsg.GetChatroomMsgReceiver", "why???, unreadCount %d", new Object[] { Integer.valueOf(i) });
                j = 0;
              }
              ((az)localObject2).nt(j);
              l1 = ((bb)localObject2).field_firstUnDeliverSeq;
              Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv  msgSeq[%d], firstSeq[%d], lastseq[%d]", new Object[] { Integer.valueOf(n), Long.valueOf(l1), Integer.valueOf(i1) });
              if (l1 <= 0L) {
                break;
              }
              localObject4 = ((l)g.af(l.class)).eiy().aK((String)localObject6, i1);
              if (((eo)localObject4).field_msgId <= 0L) {
                break label2067;
              }
              ((az)localObject2).yD(((eo)localObject4).field_msgSeq);
              break label2067;
              i = i - i2 + ((bb)localObject2).field_unReadCount;
            }
            l1 = ((l)g.af(l.class)).aTq().aEj((String)localObject6);
            if (l1 > 0L)
            {
              ((az)localObject2).yD(l1);
              i = 0;
              continue;
            }
            l1 = ((l)g.af(l.class)).eiy().aER((String)localObject6);
            Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv lastMsgSeq[%s]", new Object[] { Long.valueOf(l1) });
            if (l1 <= 0L) {
              break label2072;
            }
            ((az)localObject2).yD(l1);
            break label2072;
          }
          if ((n != i1) || (i != 0) || (((bb)localObject2).field_unReadCount <= 0)) {
            break label2077;
          }
          ((az)localObject2).nt(0);
          break label2077;
          if (m != 10002) {
            continue;
          }
          ((s)g.ah(s.class)).getSysCmdMsgExtension();
          if ((localca.getType() != 10002) || (Util.isNullOrNil((String)localObject3))) {
            continue;
          }
          if (Util.isNullOrNil((String)localObject3))
          {
            Log.e("MicroMsg.SysCmdMsgExtension", "null msg content");
            continue;
          }
          if (((String)localObject3).startsWith("~SEMI_XML~"))
          {
            localObject5 = SemiXml.decode((String)localObject3);
            if (localObject5 != null) {
              break label2085;
            }
            Log.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[] { localObject3 });
            continue;
          }
        }
        for (;;)
        {
          if ((localObject4 == null) || (!((String)localObject4).equals("revokemsg"))) {
            break label2095;
          }
          Log.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
          ((Map)localObject3).get(".sysmsg.revokemsg.session");
          localObject4 = (String)((Map)localObject3).get(".sysmsg.revokemsg.newmsgid");
          localObject3 = (String)((Map)localObject3).get(".sysmsg.revokemsg.replacemsg");
          Log.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject4, localObject3 });
          localca.setContent((String)localObject3);
          localca.setType(10000);
          break label624;
          j = ((String)localObject3).indexOf("<sysmsg");
          if (j == -1)
          {
            Log.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
            break label624;
          }
          localObject4 = XmlParser.parseXml(((String)localObject3).substring(j), "sysmsg", null);
          if (localObject4 == null)
          {
            Log.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject3 });
            break label624;
          }
          localObject5 = (String)((Map)localObject4).get(".sysmsg.$type");
          localObject3 = localObject4;
          localObject4 = localObject5;
          continue;
          label1873:
          localObject3 = " " + Util.nullAsNil((String)localObject3);
          break label809;
          label1899:
          ((az)localObject2).Cm(((bb)localObject2).field_content);
          break label821;
          label1912:
          ((az)localObject2).nx(((bb)localObject2).field_attrflag & 0xFFEFFFFF);
          Log.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { localObject6, Long.valueOf(((l)g.af(l.class)).aST().a((az)localObject2, (String)localObject6, true)), Long.valueOf(((bb)localObject2).field_firstUnDeliverSeq), Long.valueOf(((bb)localObject2).field_lastSeq), Integer.valueOf(((bb)localObject2).field_UnDeliverCount) });
          break label901;
          label2009:
          Log.e("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] data is null");
          break;
          label2020:
          break label1017;
          label2023:
          l1 = i - 1;
          break label1102;
          label2032:
          l1 = l5 - 1L;
          break label1128;
          label2041:
          l1 = i - 1;
          break label1158;
          l2 = l5 - 1L;
          break label1170;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.as.c
 * JD-Core Version:    0.7.0.1
 */