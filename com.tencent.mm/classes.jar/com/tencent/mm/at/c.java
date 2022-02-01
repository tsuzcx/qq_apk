package com.tencent.mm.at;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.f.a;
import com.tencent.mm.g.a.if;
import com.tencent.mm.g.a.if.a;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.a.sx.a;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.j.a.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cc;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.ct;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bh.b;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  extends com.tencent.mm.sdk.b.c<sx>
  implements b.a, k.a, n.b
{
  public final com.tencent.mm.sdk.b.c hff;
  private Map<Long, be> hfg;
  
  public c()
  {
    AppMethodBeat.i(20506);
    this.hff = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(if paramAnonymousif)
      {
        AppMethodBeat.i(20503);
        long l2 = System.currentTimeMillis();
        for (;;)
        {
          bl localbl;
          try
          {
            Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOD();
            if (!((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).afZ(paramAnonymousif.dlY.username))
            {
              localObject2 = new y();
              ((y)localObject2).field_username = paramAnonymousif.dlY.username;
              if (paramAnonymousif.dlY.dlZ <= paramAnonymousif.dlY.dmb)
              {
                l1 = paramAnonymousif.dlY.dmb;
                ((y)localObject2).field_lastPushSeq = l1;
                ((y)localObject2).field_lastLocalSeq = paramAnonymousif.dlY.dmb;
                ((y)localObject2).field_lastPushCreateTime = paramAnonymousif.dlY.dma;
                ((y)localObject2).field_lastLocalCreateTime = paramAnonymousif.dlY.dmc;
                l1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).a((y)localObject2, true);
                localObject1 = com.tencent.mm.ui.chatting.k.b.GGk;
                com.tencent.mm.ui.chatting.k.b.faq();
                ad.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] ret:%s,chatRoomId:%s lastPushSeq:%s lastPushCreateTime:%s lastLocalSeq:%s lastLocalCreateTime:%s", new Object[] { Long.valueOf(l1), paramAnonymousif.dlY.username, Long.valueOf(paramAnonymousif.dlY.dlZ), Long.valueOf(paramAnonymousif.dlY.dma), Long.valueOf(paramAnonymousif.dlY.dmb), Long.valueOf(paramAnonymousif.dlY.dmc) });
                return true;
              }
              l1 = paramAnonymousif.dlY.dlZ;
              continue;
            }
            Object localObject2 = paramAnonymousif.dlY.username;
            localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agr((String)localObject2);
            l1 = paramAnonymousif.dlY.dlZ;
            long l3 = paramAnonymousif.dlY.dma;
            paramAnonymousif = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).agb((String)localObject2);
            long l4 = paramAnonymousif.field_lastLocalSeq;
            long l5 = paramAnonymousif.field_lastLocalCreateTime;
            long l6 = paramAnonymousif.field_lastPushSeq;
            long l7 = paramAnonymousif.field_lastPushCreateTime;
            ad.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] isGetChatroom! %s conPushSeq:%s conPushCreateTime:%s localSeq:%s localCreateTime:%s pushSeq:%s pushCreateTime:%s", new Object[] { localObject2, Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7) });
            if ((localbl != null) && (localbl.field_msgId != 0L))
            {
              long l8 = localbl.field_msgSeq;
              if (l8 > l4)
              {
                paramAnonymousif.field_lastLocalSeq = l8;
                paramAnonymousif.field_lastLocalCreateTime = localbl.field_createTime;
                com.tencent.mm.j.a.a.c localc = new com.tencent.mm.j.a.a.c();
                localc.fyr = (1L + l4);
                localc.fyt = (l5 + 1L);
                localc.fys = (l8 - 1L);
                localc.fyu = (l7 - 1L);
                if (paramAnonymousif.field_seqBlockInfo == null) {
                  paramAnonymousif.field_seqBlockInfo = new d();
                }
                paramAnonymousif.field_seqBlockInfo.fyv.addLast(localc);
                ad.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage local seq is smaller than MsgInfoStg local seq! ret:[%s]", new Object[] { Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).b(paramAnonymousif)) });
              }
              if (l6 < l1) {
                ad.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage push seq is smaller than conversation seq! ret:[%s,%s] [%s,%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).av((String)localObject2, l1)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).ax((String)localObject2, l3)), Long.valueOf(localbl.field_msgSeq), Long.valueOf(l4) });
              }
              return true;
            }
            if (localbl == null)
            {
              bool = true;
              if (localbl != null) {
                break label747;
              }
              l1 = -1L;
              ad.w("MicroMsg.GetChatroomMsgReceiver", "lastMsgInfo is null? %s lastMsgInfo id:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
              continue;
            }
            boolean bool = false;
          }
          finally
          {
            ad.i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
            AppMethodBeat.o(20503);
          }
          continue;
          label747:
          long l1 = localbl.field_msgId;
        }
      }
    };
    this.hfg = new HashMap();
    a.ESL.c(this.hff);
    b.axZ().heY = this;
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().a(this, g.afE().EUN.getLooper());
    o.azw();
    o.azu().add(this, az.afE().EUN.getLooper());
    this.__eventId = sx.class.getName().hashCode();
    AppMethodBeat.o(20506);
  }
  
  private static List<com.tencent.mm.j.a.a.c> a(String paramString, LinkedList<bl> paramLinkedList)
  {
    AppMethodBeat.i(20509);
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOD();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).afY(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nchatroomId:").append(paramString);
    long l1 = ((bl)paramLinkedList.getFirst()).field_msgSeq;
    long l2 = ((bl)paramLinkedList.getLast()).field_msgSeq;
    long l3 = ((bl)paramLinkedList.getFirst()).field_createTime;
    long l4 = ((bl)paramLinkedList.getLast()).field_createTime;
    localStringBuilder.append("\ngetFirst:").append(l1);
    localStringBuilder.append(" getLast:").append(l2);
    localStringBuilder.append(" getFirstCreateTime:").append(l3);
    localStringBuilder.append(" getLastCreateTime:").append(l4);
    localStringBuilder.append("\nblock ");
    paramLinkedList = new com.tencent.mm.j.a.a.c();
    paramLinkedList.fyr = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).afV(paramString) + 1L);
    paramLinkedList.fyt = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).afX(paramString) + 1L);
    paramLinkedList.fys = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).afU(paramString);
    paramLinkedList.fyu = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).afW(paramString);
    if (paramLinkedList.fys - paramLinkedList.fyr >= 0L) {
      ((d)localObject1).fyv.add(paramLinkedList);
    }
    for (;;)
    {
      paramString = new LinkedList();
      paramLinkedList = ((d)localObject1).fyv.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject1 = (com.tencent.mm.j.a.a.c)paramLinkedList.next();
        int j = 0;
        long l5 = ((com.tencent.mm.j.a.a.c)localObject1).fyr;
        long l6 = ((com.tencent.mm.j.a.a.c)localObject1).fys;
        long l7 = ((com.tencent.mm.j.a.a.c)localObject1).fyt;
        long l8 = ((com.tencent.mm.j.a.a.c)localObject1).fyu;
        localStringBuilder.append("[").append(l5).append(":").append(l6).append("][").append(l7).append(":").append(l8).append("] | ");
        int i = j;
        if (l5 <= l1)
        {
          i = j;
          if (l1 <= l6)
          {
            localObject2 = new com.tencent.mm.j.a.a.c();
            ((com.tencent.mm.j.a.a.c)localObject2).fyr = ((com.tencent.mm.j.a.a.c)localObject1).fyr;
            ((com.tencent.mm.j.a.a.c)localObject2).fys = (l1 - 1L);
            ((com.tencent.mm.j.a.a.c)localObject2).fyt = l7;
            ((com.tencent.mm.j.a.a.c)localObject2).fyu = (l3 - 1L);
            i = j;
            if (((com.tencent.mm.j.a.a.c)localObject2).fys - ((com.tencent.mm.j.a.a.c)localObject2).fyr >= 0L)
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
            ((com.tencent.mm.j.a.a.c)localObject2).fyr = (1L + l2);
            ((com.tencent.mm.j.a.a.c)localObject2).fys = l6;
            ((com.tencent.mm.j.a.a.c)localObject2).fyt = (1L + l4);
            ((com.tencent.mm.j.a.a.c)localObject2).fyu = l8;
            j = i;
            if (((com.tencent.mm.j.a.a.c)localObject2).fys - ((com.tencent.mm.j.a.a.c)localObject2).fyr >= 0L)
            {
              paramString.add(localObject2);
              j = 1;
            }
          }
        }
        if ((j == 0) && ((l1 > l6) || (l2 < l5)))
        {
          paramString.add(localObject1);
          ad.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] add raw block!");
        }
      }
      ad.w("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] lastSeq[%s]<firstSeq[%s]", new Object[] { Long.valueOf(paramLinkedList.fys), Long.valueOf(paramLinkedList.fyr) });
    }
    paramLinkedList = new StringBuilder();
    localObject1 = paramString.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.j.a.a.c)((Iterator)localObject1).next();
      paramLinkedList.append("[").append(((com.tencent.mm.j.a.a.c)localObject2).fyr).append(":").append(((com.tencent.mm.j.a.a.c)localObject2).fys).append("][").append(((com.tencent.mm.j.a.a.c)localObject2).fyt).append(":").append(((com.tencent.mm.j.a.a.c)localObject2).fyu).append("] | ");
    }
    ad.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] " + localStringBuilder.toString() + "\nnew blockList:" + paramLinkedList.toString());
    AppMethodBeat.o(20509);
    return paramString;
  }
  
  private static void d(Map<Long, be> paramMap, String paramString)
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
        Object localObject1 = (be)paramMap.next();
        if ((localObject1 != null) && (paramString.equals(((be)localObject1).field_fromUserName)))
        {
          az.arV();
          Object localObject2 = com.tencent.mm.model.c.apO().aD(paramString, ((be)localObject1).field_originSvrId);
          if (((du)localObject2).field_msgId != 0L)
          {
            ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", new Object[] { Long.valueOf(((du)localObject2).field_msgId), Long.valueOf(((du)localObject2).field_msgSvrId) });
            localObject2 = new cs();
            ((cs)localObject2).uKZ = ((be)localObject1).field_newMsgId;
            ((cs)localObject2).Cxx = z.BE(((be)localObject1).field_fromUserName);
            ((cs)localObject2).Cxy = z.BE(((be)localObject1).field_toUserName);
            ((cs)localObject2).CreateTime = ((int)((be)localObject1).field_createTime);
            ((cs)localObject2).Cxz = z.BE(((be)localObject1).field_content);
            ((cs)localObject2).CxC = ((be)localObject1).field_msgSource;
            ((cs)localObject2).CxE = ((be)localObject1).field_msgSeq;
            int i = ((be)localObject1).field_flag;
            ((cs)localObject2).saz = 10002;
            localObject1 = az.getSysCmdMsgExtension();
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
              ((cc)localObject1).b(new f.a((cs)localObject2, bool1, bool2, bool3));
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
    if ((paramn == ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR()) && ((paramObject instanceof String)) && (5 == paramInt))
    {
      paramn = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOD();
      paramObject = (String)paramObject;
      if (paramn.afZ(paramObject))
      {
        y localy = paramn.agb(paramObject);
        if (localy.field_seqBlockInfo != null) {
          localy.field_seqBlockInfo.fyv.clear();
        }
        localy.field_lastLocalSeq = localy.field_lastPushSeq;
        localy.field_lastLocalCreateTime = localy.field_lastPushCreateTime;
        long l = paramn.b(localy);
        ad.i("MicroMsg.GetChatroomMsgReceiver", "[onNotifyChange] username:" + paramObject + " ret:" + l + " chatroomMsgSeq:" + localy.toString());
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
        paramString = new be();
        paramString.field_originSvrId = l;
        o.azw();
        if (o.azu().get(paramString, new String[0]))
        {
          this.hfg.put(Long.valueOf(l), paramString);
          ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange put info systemRowid[%d], svrId[%d]", new Object[] { Long.valueOf(paramString.systemRowid), Long.valueOf(l) });
          AppMethodBeat.o(20510);
          return;
        }
        this.hfg.remove(Long.valueOf(l));
        ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange remove info svrId[%d]", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(20510);
        return;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", paramString, "summerbadcr dealSysCmdMsg onNotifyChange:", new Object[0]);
      }
    }
    AppMethodBeat.o(20510);
  }
  
  public final void a(String paramString, boolean paramBoolean1, LinkedList<bl> paramLinkedList, com.tencent.mm.j.a.a.c paramc, boolean paramBoolean2)
  {
    AppMethodBeat.i(20507);
    if ((paramLinkedList.size() <= 0) || (paramBoolean2))
    {
      ad.w("MicroMsg.GetChatroomMsgReceiver", "[onFetched] fetchList.size() == 0! removeBlock! isBlockAll:".concat(String.valueOf(paramBoolean2)));
      l1 = paramc.fyr;
      l2 = paramc.fys;
      ad.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString);
      paramLinkedList = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOD();
      paramc = paramLinkedList.agb(paramString);
      if (paramc.field_seqBlockInfo != null)
      {
        localObject1 = new LinkedList();
        localObject2 = paramc.field_seqBlockInfo.fyv.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.j.a.a.c localc = (com.tencent.mm.j.a.a.c)((Iterator)localObject2).next();
          if ((localc.fyr == l1) && (localc.fys == l2)) {
            ((List)localObject1).add(localc);
          }
        }
        paramc.field_seqBlockInfo.fyv.removeAll((Collection)localObject1);
        l3 = paramLinkedList.b(paramc);
        ad.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString + " ret:" + l3 + " remove list:" + ((List)localObject1).size());
        if (((List)localObject1).size() > 0)
        {
          localObject1 = com.tencent.mm.ui.chatting.k.b.GGk;
          com.tencent.mm.ui.chatting.k.b.fas();
        }
      }
      paramc.field_lastLocalSeq = paramc.field_lastPushSeq;
      paramc.field_lastLocalCreateTime = paramc.field_lastPushCreateTime;
      l3 = paramLinkedList.b(paramc);
      ad.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString + " ret:" + l3 + " lastPushSeq:" + paramc.field_lastPushSeq + " field_lastPushCreateTime:" + paramc.field_lastPushCreateTime);
      AppMethodBeat.o(20507);
      return;
    }
    ad.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] insert msg count[%s] isFetchUp:%s", new Object[] { Integer.valueOf(paramLinkedList.size()), Boolean.valueOf(paramBoolean1) });
    paramc = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOD();
    Object localObject1 = a(paramString, paramLinkedList);
    Object localObject2 = paramc.afY(paramString);
    ((d)localObject2).fyv.clear();
    ((d)localObject2).fyv.addAll((Collection)localObject1);
    paramBoolean1 = paramc.a(paramString, (d)localObject2);
    long l1 = ((bl)paramLinkedList.getLast()).field_msgSeq;
    long l2 = ((bl)paramLinkedList.getLast()).field_createTime;
    long l3 = paramc.afV(paramString);
    long l4 = paramc.afX(paramString);
    ad.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] blockList size:%s ret:%s GetSeq:[last %s:old %s] GetLocalCreateTime:[last %s:old %s]", new Object[] { Integer.valueOf(((d)localObject2).fyv.size()), Boolean.valueOf(paramBoolean1), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4) });
    if (l3 < l1)
    {
      paramc.ay(paramString, l1);
      paramc.aw(paramString, l2);
    }
    for (;;)
    {
      d(new HashMap(this.hfg), paramString);
      AppMethodBeat.o(20507);
      return;
      ad.w("MicroMsg.GetChatroomMsgReceiver", "oldGetSeq>=lastGetSeq [%s:%s]", new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
    }
  }
  
  static final class a
    implements Runnable
  {
    sx hfi;
    
    private a(sx paramsx)
    {
      this.hfi = paramsx;
    }
    
    public final void run()
    {
      AppMethodBeat.i(20505);
      long l3 = System.currentTimeMillis();
      label520:
      label1166:
      label2067:
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        int i;
        long l5;
        Object localObject5;
        long l2;
        Object localObject6;
        long l1;
        int m;
        int j;
        int k;
        int n;
        label511:
        bl localbl;
        label614:
        label621:
        Object localObject2;
        try
        {
          if (!g.afw())
          {
            ad.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] accHasReady no!");
            ad.d("MicroMsg.GetChatroomMsgReceiver", "[HandlePushTask$run] cost:" + (System.currentTimeMillis() - l3));
            AppMethodBeat.o(20505);
            return;
          }
          localObject1 = this.hfi.dyz.data;
          if (localObject1 == null) {
            break label1982;
          }
          localObject3 = new ct();
        }
        catch (Exception localException1)
        {
          try
          {
            Object localObject1;
            ((ct)localObject3).parseFrom((byte[])localObject1);
            long l4 = System.currentTimeMillis();
            localObject4 = z.a(((ct)localObject3).CxF);
            i = ((ct)localObject3).CxE;
            l5 = 1000L * ((ct)localObject3).CreateTime;
            localObject5 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOD();
            if (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).afZ((String)localObject4))
            {
              ad.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#update] chatRoomId:%s updatePushSeqRet[%s]:%s updatePushCreateTimeRet[%s]:%s", new Object[] { localObject4, Integer.valueOf(i), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).av((String)localObject4, i)), Long.valueOf(l5), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).ax((String)localObject4, l5)) });
              ad.d("MicroMsg.GetChatroomMsgReceiver", "[updateChatroomMsgSeq] cost:" + (System.currentTimeMillis() - l4));
              l2 = System.currentTimeMillis();
              localObject6 = z.a(((ct)localObject3).CxF);
              i = ((ct)localObject3).CxE;
              l1 = ((ct)localObject3).uKZ;
              m = ((ct)localObject3).CreateTime;
              j = ((ct)localObject3).CxI;
              k = ((ct)localObject3).saz;
              n = ((ct)localObject3).CxG;
              localObject3 = z.a(((ct)localObject3).CxH);
              ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", new Object[] { localObject6, Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(n), bt.aGs((String)localObject3) });
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIn((String)localObject6);
              if (localObject1 != null) {
                break label1234;
              }
              localObject1 = new am((String)localObject6);
              ((am)localObject1).kS(m * 1000L);
              ((am)localObject1).kU(i);
              ((am)localObject1).jT(1);
              ((am)localObject1).ka(1);
              b.axZ();
              b.xV((String)localObject6);
              l1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).aqo().agd((String)localObject6);
              ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", new Object[] { Long.valueOf(l1), Integer.valueOf(i) });
              if (l1 <= 0L) {
                break label2032;
              }
              ((am)localObject1).kV(l1);
              i = 1;
              if (j > 0) {
                ((am)localObject1).jY(((ay)localObject1).field_atCount + j);
              }
              localbl = new bl();
              localbl.jV(0);
              localbl.nY((String)localObject6);
              localbl.setType(k);
              localbl.setContent((String)localObject3);
              if (k != 49) {
                break label1542;
              }
              localObject4 = k.b.rx(com.tencent.mm.pluginsdk.model.app.k.ky((String)localObject6, (String)localObject3));
              localbl.setType(com.tencent.mm.pluginsdk.model.app.m.f((k.b)localObject4));
              if (!localbl.eJL()) {
                break label2054;
              }
              localObject3 = ((k.b)localObject4).content;
              localbl.setContent((String)localObject3);
              ((am)localObject1).jV(0);
              ((am)localObject1).setContent(localbl.field_content);
              ((am)localObject1).nK(Integer.toString(localbl.getType()));
              localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().Lu();
              if (localObject3 == null) {
                break label1872;
              }
              localObject4 = new PString();
              localObject5 = new PString();
              PInt localPInt = new PInt();
              ((bh.b)localObject3).a(localbl, (PString)localObject4, (PString)localObject5, localPInt, false);
              ((am)localObject1).nL(((PString)localObject4).value);
              ((am)localObject1).nM(((PString)localObject5).value);
              ((am)localObject1).jW(localPInt.value);
              if (localbl.getType() == 49)
              {
                localObject3 = (String)bw.K(((ay)localObject1).field_content, "msg").get(".msg.appmsg.title");
                localObject4 = bt.nullAsNil(((ay)localObject1).field_digest);
                if (!bt.isNullOrNil((String)localObject3)) {
                  break label1846;
                }
                localObject3 = "";
                label805:
                ((am)localObject1).nL(((String)localObject4).concat((String)localObject3));
              }
              label817:
              if (i == 0) {
                break label1885;
              }
              ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { localObject6, Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().e((am)localObject1)), Long.valueOf(((ay)localObject1).field_firstUnDeliverSeq), Long.valueOf(((ay)localObject1).field_lastSeq), Integer.valueOf(((ay)localObject1).field_UnDeliverCount) });
              ad.d("MicroMsg.GetChatroomMsgReceiver", "[updateConv] cost:" + (System.currentTimeMillis() - l2));
              continue;
              localException1 = localException1;
              ad.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", localException1, "", new Object[0]);
            }
          }
          catch (Exception localException2)
          {
            ad.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", localException2, "", new Object[0]);
            continue;
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agr((String)localObject4);
            if (localObject2 == null) {
              break label1993;
            }
          }
        }
        if (((du)localObject2).field_msgId == 0L)
        {
          ad.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] has not any ReceivedMsg!");
          localObject2 = null;
          label1013:
          if (localObject2 != null)
          {
            localObject6 = com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", ((du)localObject2).field_createTime / 1000L);
            ad.w("MicroMsg.GetChatroomMsgReceiver", "[lastFaultMsgInfo] lastFaultMsgInfo:%s timeFormat:%s", new Object[] { bt.aGs(((du)localObject2).field_content), localObject6 });
          }
          localObject6 = new y();
          ((y)localObject6).field_username = ((String)localObject4);
          ((y)localObject6).field_lastPushSeq = i;
          if (localObject2 == null) {
            break label1996;
          }
          l1 = ((du)localObject2).field_msgSeq;
          label1098:
          ((y)localObject6).field_lastLocalSeq = l1;
          ((y)localObject6).field_lastPushCreateTime = l5;
          if (localObject2 == null) {
            break label2005;
          }
          l1 = ((du)localObject2).field_createTime;
          label1124:
          ((y)localObject6).field_lastLocalCreateTime = l1;
          long l6 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).a((y)localObject6);
          if (localObject2 == null) {
            break label2014;
          }
          l1 = ((du)localObject2).field_msgSeq;
          if (localObject2 == null) {
            break label2023;
          }
          l2 = ((du)localObject2).field_createTime;
          ad.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#insert] ret:%s,chatRoomId:%s updatePushSeq:%s updatePushCreateTime:%s field_lastLocalSeq:%s field_lastLocalCreateTime:%s", new Object[] { Long.valueOf(l6), localObject4, Integer.valueOf(i), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l2) });
          localObject2 = com.tencent.mm.ui.chatting.k.b.GGk;
          com.tencent.mm.ui.chatting.k.b.faq();
          continue;
          label1234:
          int i1 = (int)((ay)localObject2).field_lastSeq;
          if (i > i1)
          {
            ((am)localObject2).kU(i);
            int i2 = ((ay)localObject2).field_UnDeliverCount;
            ((am)localObject2).ka(n);
            ((am)localObject2).kS(m * 1000L);
            if (n > ((ay)localObject2).field_unReadCount) {
              ((am)localObject2).jT(n);
            }
            for (;;)
            {
              l1 = ((ay)localObject2).field_firstUnDeliverSeq;
              ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv  msgSeq[%d], firstSeq[%d], lastseq[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(i1) });
              if (l1 <= 0L) {
                break;
              }
              localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().aE((String)localObject6, i1);
              if (((du)localObject4).field_msgId <= 0L) {
                break label2039;
              }
              ((am)localObject2).kV(((du)localObject4).field_msgSeq);
              break label2039;
              ((am)localObject2).jT(n - i2 + ((ay)localObject2).field_unReadCount);
            }
            l1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).aqo().agd((String)localObject6);
            if (l1 > 0L)
            {
              ((am)localObject2).kV(l1);
              i = 0;
              continue;
            }
            l1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agJ((String)localObject6);
            ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv lastMsgSeq[%s]", new Object[] { Long.valueOf(l1) });
            if (l1 <= 0L) {
              break label2044;
            }
            ((am)localObject2).kV(l1);
            break label2044;
          }
          if ((i != i1) || (n != 0) || (((ay)localObject2).field_unReadCount <= 0)) {
            break label2049;
          }
          ((am)localObject2).jT(0);
          break label2049;
          if (k != 10002) {
            continue;
          }
          ((q)g.ad(q.class)).getSysCmdMsgExtension();
          if ((localbl.getType() != 10002) || (bt.isNullOrNil((String)localObject3))) {
            continue;
          }
          if (bt.isNullOrNil((String)localObject3))
          {
            ad.e("MicroMsg.SysCmdMsgExtension", "null msg content");
            continue;
          }
          if (((String)localObject3).startsWith("~SEMI_XML~"))
          {
            localObject5 = bj.aFP((String)localObject3);
            if (localObject5 != null) {
              break label2057;
            }
            ad.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[] { localObject3 });
            continue;
          }
        }
        for (;;)
        {
          if ((localObject4 == null) || (!((String)localObject4).equals("revokemsg"))) {
            break label2067;
          }
          ad.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
          ((Map)localObject3).get(".sysmsg.revokemsg.session");
          localObject4 = (String)((Map)localObject3).get(".sysmsg.revokemsg.newmsgid");
          localObject3 = (String)((Map)localObject3).get(".sysmsg.revokemsg.replacemsg");
          ad.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject4, localObject3 });
          localbl.setContent((String)localObject3);
          localbl.setType(10000);
          break label621;
          j = ((String)localObject3).indexOf("<sysmsg");
          if (j == -1)
          {
            ad.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
            break label621;
          }
          localObject4 = bw.K(((String)localObject3).substring(j), "sysmsg");
          if (localObject4 == null)
          {
            ad.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject3 });
            break label621;
          }
          localObject5 = (String)((Map)localObject4).get(".sysmsg.$type");
          localObject3 = localObject4;
          localObject4 = localObject5;
          continue;
          label1846:
          localObject3 = " " + bt.nullAsNil((String)localObject3);
          break label805;
          label1872:
          ((am)localObject2).nL(((ay)localObject2).field_content);
          break label817;
          label1885:
          ((am)localObject2).jX(((ay)localObject2).field_attrflag & 0xFFEFFFFF);
          ad.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { localObject6, Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().a((am)localObject2, (String)localObject6, true)), Long.valueOf(((ay)localObject2).field_firstUnDeliverSeq), Long.valueOf(((ay)localObject2).field_lastSeq), Integer.valueOf(((ay)localObject2).field_UnDeliverCount) });
          break label897;
          label1982:
          ad.e("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] data is null");
          break;
          label1993:
          break label1013;
          label1996:
          l1 = i - 1;
          break label1098;
          label2005:
          l1 = l5 - 1L;
          break label1124;
          label2014:
          l1 = i - 1;
          break label1154;
          label2023:
          l2 = l5 - 1L;
          break label1166;
          label2032:
          l1 = i;
          break label511;
          label2039:
          i = 0;
          break label520;
          label2044:
          i = 0;
          break label520;
          i = 0;
          break label520;
          break label614;
          localObject4 = "brand_service";
          localObject3 = localObject5;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.at.c
 * JD-Core Version:    0.7.0.1
 */