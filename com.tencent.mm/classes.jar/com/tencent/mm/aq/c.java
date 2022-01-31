package com.tencent.mm.aq;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.re.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.j.a.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bz;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.cn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.w;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  extends com.tencent.mm.sdk.b.c<re>
  implements b.a, k.a, n.b
{
  public final com.tencent.mm.sdk.b.c fCE;
  private Map<Long, bb> fCF;
  
  public c()
  {
    AppMethodBeat.i(16460);
    this.fCE = new c.1(this);
    this.fCF = new HashMap();
    a.ymk.c(this.fCE);
    b.agX().fCx = this;
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().a(this, g.RO().oNc.getLooper());
    com.tencent.mm.modelmulti.n.aip();
    com.tencent.mm.modelmulti.n.ain().add(this, aw.RO().oNc.getLooper());
    this.__eventId = re.class.getName().hashCode();
    AppMethodBeat.o(16460);
  }
  
  private static List<com.tencent.mm.j.a.a.c> a(String paramString, LinkedList<bi> paramLinkedList)
  {
    AppMethodBeat.i(16463);
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPL();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).SV(paramString);
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
    paramLinkedList = new com.tencent.mm.j.a.a.c();
    paramLinkedList.elA = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).SS(paramString) + 1L);
    paramLinkedList.elC = (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).SU(paramString) + 1L);
    paramLinkedList.elB = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).SR(paramString);
    paramLinkedList.elD = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject2).ST(paramString);
    if (paramLinkedList.elB - paramLinkedList.elA >= 0L) {
      ((d)localObject1).elE.add(paramLinkedList);
    }
    for (;;)
    {
      paramString = new LinkedList();
      paramLinkedList = ((d)localObject1).elE.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject1 = (com.tencent.mm.j.a.a.c)paramLinkedList.next();
        int j = 0;
        long l5 = ((com.tencent.mm.j.a.a.c)localObject1).elA;
        long l6 = ((com.tencent.mm.j.a.a.c)localObject1).elB;
        long l7 = ((com.tencent.mm.j.a.a.c)localObject1).elC;
        long l8 = ((com.tencent.mm.j.a.a.c)localObject1).elD;
        localStringBuilder.append("[").append(l5).append(":").append(l6).append("][").append(l7).append(":").append(l8).append("] | ");
        int i = j;
        if (l5 <= l1)
        {
          i = j;
          if (l1 <= l6)
          {
            localObject2 = new com.tencent.mm.j.a.a.c();
            ((com.tencent.mm.j.a.a.c)localObject2).elA = ((com.tencent.mm.j.a.a.c)localObject1).elA;
            ((com.tencent.mm.j.a.a.c)localObject2).elB = (l1 - 1L);
            ((com.tencent.mm.j.a.a.c)localObject2).elC = l7;
            ((com.tencent.mm.j.a.a.c)localObject2).elD = (l3 - 1L);
            i = j;
            if (((com.tencent.mm.j.a.a.c)localObject2).elB - ((com.tencent.mm.j.a.a.c)localObject2).elA >= 0L)
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
            ((com.tencent.mm.j.a.a.c)localObject2).elA = (1L + l2);
            ((com.tencent.mm.j.a.a.c)localObject2).elB = l6;
            ((com.tencent.mm.j.a.a.c)localObject2).elC = (1L + l4);
            ((com.tencent.mm.j.a.a.c)localObject2).elD = l8;
            j = i;
            if (((com.tencent.mm.j.a.a.c)localObject2).elB - ((com.tencent.mm.j.a.a.c)localObject2).elA >= 0L)
            {
              paramString.add(localObject2);
              j = 1;
            }
          }
        }
        if ((j == 0) && ((l1 > l6) || (l2 < l5)))
        {
          paramString.add(localObject1);
          ab.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] add raw block!");
        }
      }
      ab.w("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] lastSeq[%s]<firstSeq[%s]", new Object[] { Long.valueOf(paramLinkedList.elB), Long.valueOf(paramLinkedList.elA) });
    }
    paramLinkedList = new StringBuilder();
    localObject1 = paramString.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.j.a.a.c)((Iterator)localObject1).next();
      paramLinkedList.append("[").append(((com.tencent.mm.j.a.a.c)localObject2).elA).append(":").append(((com.tencent.mm.j.a.a.c)localObject2).elB).append("][").append(((com.tencent.mm.j.a.a.c)localObject2).elC).append(":").append(((com.tencent.mm.j.a.a.c)localObject2).elD).append("] | ");
    }
    ab.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] " + localStringBuilder.toString() + "\nnew blockList:" + paramLinkedList.toString());
    AppMethodBeat.o(16463);
    return paramString;
  }
  
  private static void e(Map<Long, bb> paramMap, String paramString)
  {
    AppMethodBeat.i(16465);
    if ((paramMap.size() == 0) || (ah.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(16465);
      return;
    }
    paramMap = paramMap.values().iterator();
    if (paramMap != null) {
      while (paramMap.hasNext())
      {
        Object localObject1 = (bb)paramMap.next();
        if ((localObject1 != null) && (paramString.equals(((bb)localObject1).field_fromUserName)))
        {
          aw.aaz();
          Object localObject2 = com.tencent.mm.model.c.YC().ag(paramString, ((bb)localObject1).field_originSvrId);
          if (((dd)localObject2).field_msgId != 0L)
          {
            ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", new Object[] { Long.valueOf(((dd)localObject2).field_msgId), Long.valueOf(((dd)localObject2).field_msgSvrId) });
            localObject2 = new cm();
            ((cm)localObject2).pIG = ((bb)localObject1).field_newMsgId;
            ((cm)localObject2).woP = aa.wA(((bb)localObject1).field_fromUserName);
            ((cm)localObject2).woQ = aa.wA(((bb)localObject1).field_toUserName);
            ((cm)localObject2).CreateTime = ((int)((bb)localObject1).field_createTime);
            ((cm)localObject2).woR = aa.wA(((bb)localObject1).field_content);
            ((cm)localObject2).woU = ((bb)localObject1).field_msgSource;
            ((cm)localObject2).woW = ((bb)localObject1).field_msgSeq;
            int i = ((bb)localObject1).field_flag;
            ((cm)localObject2).nqW = 10002;
            localObject1 = aw.getSysCmdMsgExtension();
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
              ((bz)localObject1).b(new e.a((cm)localObject2, bool1, bool2, bool3));
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
    AppMethodBeat.o(16465);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(16462);
    if ((paramn == ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF()) && ((paramObject instanceof String)) && (5 == paramInt))
    {
      paramn = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPL();
      paramObject = (String)paramObject;
      if (paramn.SW(paramObject))
      {
        w localw = paramn.SY(paramObject);
        if (localw.field_seqBlockInfo != null) {
          localw.field_seqBlockInfo.elE.clear();
        }
        localw.field_lastLocalSeq = localw.field_lastPushSeq;
        localw.field_lastLocalCreateTime = localw.field_lastPushCreateTime;
        long l = paramn.b(localw);
        ab.i("MicroMsg.GetChatroomMsgReceiver", "[onNotifyChange] username:" + paramObject + " ret:" + l + " chatroomMsgSeq:" + localw.toString());
      }
    }
    AppMethodBeat.o(16462);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(16464);
    if (!ah.isNullOrNil(paramString)) {
      try
      {
        long l = Long.valueOf(paramString).longValue();
        paramString = new bb();
        paramString.field_originSvrId = l;
        com.tencent.mm.modelmulti.n.aip();
        if (com.tencent.mm.modelmulti.n.ain().get(paramString, new String[0]))
        {
          this.fCF.put(Long.valueOf(l), paramString);
          ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange put info systemRowid[%d], svrId[%d]", new Object[] { Long.valueOf(paramString.systemRowid), Long.valueOf(l) });
          AppMethodBeat.o(16464);
          return;
        }
        this.fCF.remove(Long.valueOf(l));
        ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange remove info svrId[%d]", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(16464);
        return;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", paramString, "summerbadcr dealSysCmdMsg onNotifyChange:", new Object[0]);
      }
    }
    AppMethodBeat.o(16464);
  }
  
  public final void a(String paramString, boolean paramBoolean1, LinkedList<bi> paramLinkedList, com.tencent.mm.j.a.a.c paramc, boolean paramBoolean2)
  {
    AppMethodBeat.i(16461);
    if ((paramLinkedList.size() <= 0) || (paramBoolean2))
    {
      ab.w("MicroMsg.GetChatroomMsgReceiver", "[onFetched] fetchList.size() == 0! removeBlock! isBlockAll:".concat(String.valueOf(paramBoolean2)));
      l1 = paramc.elA;
      l2 = paramc.elB;
      ab.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString);
      paramLinkedList = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPL();
      paramc = paramLinkedList.SY(paramString);
      if (paramc.field_seqBlockInfo != null)
      {
        localObject1 = new LinkedList();
        localObject2 = paramc.field_seqBlockInfo.elE.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.j.a.a.c localc = (com.tencent.mm.j.a.a.c)((Iterator)localObject2).next();
          if ((localc.elA == l1) && (localc.elB == l2)) {
            ((List)localObject1).add(localc);
          }
        }
        paramc.field_seqBlockInfo.elE.removeAll((Collection)localObject1);
        l3 = paramLinkedList.b(paramc);
        ab.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString + " ret:" + l3 + " remove list:" + ((List)localObject1).size());
        if (((List)localObject1).size() > 0)
        {
          localObject1 = com.tencent.mm.ui.chatting.j.b.zPL;
          com.tencent.mm.ui.chatting.j.b.dLe();
        }
      }
      paramc.field_lastLocalSeq = paramc.field_lastPushSeq;
      paramc.field_lastLocalCreateTime = paramc.field_lastPushCreateTime;
      l3 = paramLinkedList.b(paramc);
      ab.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + l1 + " lastMsgSeq:" + l2 + " chatroomId:" + paramString + " ret:" + l3 + " lastPushSeq:" + paramc.field_lastPushSeq + " field_lastPushCreateTime:" + paramc.field_lastPushCreateTime);
      AppMethodBeat.o(16461);
      return;
    }
    ab.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] insert msg count[%s] isFetchUp:%s", new Object[] { Integer.valueOf(paramLinkedList.size()), Boolean.valueOf(paramBoolean1) });
    paramc = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPL();
    Object localObject1 = a(paramString, paramLinkedList);
    Object localObject2 = paramc.SV(paramString);
    ((d)localObject2).elE.clear();
    ((d)localObject2).elE.addAll((Collection)localObject1);
    paramBoolean1 = paramc.a(paramString, (d)localObject2);
    long l1 = ((bi)paramLinkedList.getLast()).field_msgSeq;
    long l2 = ((bi)paramLinkedList.getLast()).field_createTime;
    long l3 = paramc.SS(paramString);
    long l4 = paramc.SU(paramString);
    ab.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] blockList size:%s ret:%s GetSeq:[last %s:old %s] GetLocalCreateTime:[last %s:old %s]", new Object[] { Integer.valueOf(((d)localObject2).elE.size()), Boolean.valueOf(paramBoolean1), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4) });
    if (l3 < l1)
    {
      paramc.ab(paramString, l1);
      paramc.Z(paramString, l2);
    }
    for (;;)
    {
      e(new HashMap(this.fCF), paramString);
      AppMethodBeat.o(16461);
      return;
      ab.w("MicroMsg.GetChatroomMsgReceiver", "oldGetSeq>=lastGetSeq [%s:%s]", new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
    }
  }
  
  static final class a
    implements Runnable
  {
    re fCH;
    
    private a(re paramre)
    {
      this.fCH = paramre;
    }
    
    public final void run()
    {
      AppMethodBeat.i(16459);
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
        bi localbi;
        label614:
        label621:
        Object localObject2;
        try
        {
          if (!g.RG())
          {
            ab.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] accHasReady no!");
            ab.d("MicroMsg.GetChatroomMsgReceiver", "[HandlePushTask$run] cost:" + (System.currentTimeMillis() - l3));
            AppMethodBeat.o(16459);
            return;
          }
          localObject1 = this.fCH.cHK.data;
          if (localObject1 == null) {
            break label1982;
          }
          localObject3 = new cn();
        }
        catch (Exception localException1)
        {
          try
          {
            Object localObject1;
            ((cn)localObject3).parseFrom((byte[])localObject1);
            long l4 = System.currentTimeMillis();
            localObject4 = aa.a(((cn)localObject3).woX);
            i = ((cn)localObject3).woW;
            l5 = 1000L * ((cn)localObject3).CreateTime;
            localObject5 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPL();
            if (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).SW((String)localObject4))
            {
              ab.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#update] chatRoomId:%s updatePushSeqRet[%s]:%s updatePushCreateTimeRet[%s]:%s", new Object[] { localObject4, Integer.valueOf(i), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).Y((String)localObject4, i)), Long.valueOf(l5), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).aa((String)localObject4, l5)) });
              ab.d("MicroMsg.GetChatroomMsgReceiver", "[updateChatroomMsgSeq] cost:" + (System.currentTimeMillis() - l4));
              l2 = System.currentTimeMillis();
              localObject6 = aa.a(((cn)localObject3).woX);
              i = ((cn)localObject3).woW;
              l1 = ((cn)localObject3).pIG;
              m = ((cn)localObject3).CreateTime;
              j = ((cn)localObject3).wpa;
              k = ((cn)localObject3).nqW;
              n = ((cn)localObject3).woY;
              localObject3 = aa.a(((cn)localObject3).woZ);
              ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", new Object[] { localObject6, Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(n), bo.aqg((String)localObject3) });
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arH((String)localObject6);
              if (localObject1 != null) {
                break label1234;
              }
              localObject1 = new ak((String)localObject6);
              ((ak)localObject1).fK(m * 1000L);
              ((ak)localObject1).fM(i);
              ((ak)localObject1).hJ(1);
              ((ak)localObject1).hQ(1);
              b.agX();
              b.sS((String)localObject6);
              l1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Zc().Ta((String)localObject6);
              ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", new Object[] { Long.valueOf(l1), Integer.valueOf(i) });
              if (l1 <= 0L) {
                break label2032;
              }
              ((ak)localObject1).fN(l1);
              i = 1;
              if (j > 0) {
                ((ak)localObject1).hO(((au)localObject1).field_atCount + j);
              }
              localbi = new bi();
              localbi.hL(0);
              localbi.kj((String)localObject6);
              localbi.setType(k);
              localbi.setContent((String)localObject3);
              if (k != 49) {
                break label1542;
              }
              localObject4 = j.b.mY(com.tencent.mm.pluginsdk.model.app.j.hS((String)localObject6, (String)localObject3));
              localbi.setType(l.c((j.b)localObject4));
              if (!localbi.dvV()) {
                break label2054;
              }
              localObject3 = ((j.b)localObject4).content;
              localbi.setContent((String)localObject3);
              ((ak)localObject1).hL(0);
              ((ak)localObject1).setContent(localbi.field_content);
              ((ak)localObject1).jV(Integer.toString(localbi.getType()));
              localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().BX();
              if (localObject3 == null) {
                break label1872;
              }
              localObject4 = new PString();
              localObject5 = new PString();
              PInt localPInt = new PInt();
              ((be.b)localObject3).a(localbi, (PString)localObject4, (PString)localObject5, localPInt, false);
              ((ak)localObject1).jW(((PString)localObject4).value);
              ((ak)localObject1).jX(((PString)localObject5).value);
              ((ak)localObject1).hM(localPInt.value);
              if (localbi.getType() == 49)
              {
                localObject3 = (String)br.F(((au)localObject1).field_content, "msg").get(".msg.appmsg.title");
                localObject4 = bo.nullAsNil(((au)localObject1).field_digest);
                if (!bo.isNullOrNil((String)localObject3)) {
                  break label1846;
                }
                localObject3 = "";
                label805:
                ((ak)localObject1).jW(((String)localObject4).concat((String)localObject3));
              }
              label817:
              if (i == 0) {
                break label1885;
              }
              ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { localObject6, Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().d((ak)localObject1)), Long.valueOf(((au)localObject1).field_firstUnDeliverSeq), Long.valueOf(((au)localObject1).field_lastSeq), Integer.valueOf(((au)localObject1).field_UnDeliverCount) });
              ab.d("MicroMsg.GetChatroomMsgReceiver", "[updateConv] cost:" + (System.currentTimeMillis() - l2));
              continue;
              localException1 = localException1;
              ab.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", localException1, "", new Object[0]);
            }
          }
          catch (Exception localException2)
          {
            ab.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", localException2, "", new Object[0]);
            continue;
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Tn((String)localObject4);
            if (localObject2 == null) {
              break label1993;
            }
          }
        }
        if (((dd)localObject2).field_msgId == 0L)
        {
          ab.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] has not any ReceivedMsg!");
          localObject2 = null;
          label1013:
          if (localObject2 != null)
          {
            localObject6 = com.tencent.mm.pluginsdk.f.h.formatTime("yyyy-MM-dd HH:mm:ss", ((dd)localObject2).field_createTime / 1000L);
            ab.w("MicroMsg.GetChatroomMsgReceiver", "[lastFaultMsgInfo] lastFaultMsgInfo:%s timeFormat:%s", new Object[] { bo.aqg(((dd)localObject2).field_content), localObject6 });
          }
          localObject6 = new w();
          ((w)localObject6).field_username = ((String)localObject4);
          ((w)localObject6).field_lastPushSeq = i;
          if (localObject2 == null) {
            break label1996;
          }
          l1 = ((dd)localObject2).field_msgSeq;
          label1098:
          ((w)localObject6).field_lastLocalSeq = l1;
          ((w)localObject6).field_lastPushCreateTime = l5;
          if (localObject2 == null) {
            break label2005;
          }
          l1 = ((dd)localObject2).field_createTime;
          label1124:
          ((w)localObject6).field_lastLocalCreateTime = l1;
          long l6 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).a((w)localObject6);
          if (localObject2 == null) {
            break label2014;
          }
          l1 = ((dd)localObject2).field_msgSeq;
          if (localObject2 == null) {
            break label2023;
          }
          l2 = ((dd)localObject2).field_createTime;
          ab.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#insert] ret:%s,chatRoomId:%s updatePushSeq:%s updatePushCreateTime:%s field_lastLocalSeq:%s field_lastLocalCreateTime:%s", new Object[] { Long.valueOf(l6), localObject4, Integer.valueOf(i), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l2) });
          localObject2 = com.tencent.mm.ui.chatting.j.b.zPL;
          com.tencent.mm.ui.chatting.j.b.dLc();
          continue;
          label1234:
          int i1 = (int)((au)localObject2).field_lastSeq;
          if (i > i1)
          {
            ((ak)localObject2).fM(i);
            int i2 = ((au)localObject2).field_UnDeliverCount;
            ((ak)localObject2).hQ(n);
            ((ak)localObject2).fK(m * 1000L);
            if (n > ((au)localObject2).field_unReadCount) {
              ((ak)localObject2).hJ(n);
            }
            for (;;)
            {
              l1 = ((au)localObject2).field_firstUnDeliverSeq;
              ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv  msgSeq[%d], firstSeq[%d], lastseq[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(i1) });
              if (l1 <= 0L) {
                break;
              }
              localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().ah((String)localObject6, i1);
              if (((dd)localObject4).field_msgId <= 0L) {
                break label2039;
              }
              ((ak)localObject2).fN(((dd)localObject4).field_msgSeq);
              break label2039;
              ((ak)localObject2).hJ(n - i2 + ((au)localObject2).field_unReadCount);
            }
            l1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Zc().Ta((String)localObject6);
            if (l1 > 0L)
            {
              ((ak)localObject2).fN(l1);
              i = 0;
              continue;
            }
            l1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().TF((String)localObject6);
            ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv lastMsgSeq[%s]", new Object[] { Long.valueOf(l1) });
            if (l1 <= 0L) {
              break label2044;
            }
            ((ak)localObject2).fN(l1);
            break label2044;
          }
          if ((i != i1) || (n != 0) || (((au)localObject2).field_unReadCount <= 0)) {
            break label2049;
          }
          ((ak)localObject2).hJ(0);
          break label2049;
          if (k != 10002) {
            continue;
          }
          ((p)g.G(p.class)).getSysCmdMsgExtension();
          if ((localbi.getType() != 10002) || (bo.isNullOrNil((String)localObject3))) {
            continue;
          }
          if (bo.isNullOrNil((String)localObject3))
          {
            ab.e("MicroMsg.SysCmdMsgExtension", "null msg content");
            continue;
          }
          if (((String)localObject3).startsWith("~SEMI_XML~"))
          {
            localObject5 = com.tencent.mm.sdk.platformtools.be.apC((String)localObject3);
            if (localObject5 != null) {
              break label2057;
            }
            ab.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[] { localObject3 });
            continue;
          }
        }
        for (;;)
        {
          if ((localObject4 == null) || (!((String)localObject4).equals("revokemsg"))) {
            break label2067;
          }
          ab.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
          ((Map)localObject3).get(".sysmsg.revokemsg.session");
          localObject4 = (String)((Map)localObject3).get(".sysmsg.revokemsg.newmsgid");
          localObject3 = (String)((Map)localObject3).get(".sysmsg.revokemsg.replacemsg");
          ab.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject4, localObject3 });
          localbi.setContent((String)localObject3);
          localbi.setType(10000);
          break label621;
          j = ((String)localObject3).indexOf("<sysmsg");
          if (j == -1)
          {
            ab.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
            break label621;
          }
          localObject4 = br.F(((String)localObject3).substring(j), "sysmsg");
          if (localObject4 == null)
          {
            ab.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject3 });
            break label621;
          }
          localObject5 = (String)((Map)localObject4).get(".sysmsg.$type");
          localObject3 = localObject4;
          localObject4 = localObject5;
          continue;
          label1846:
          localObject3 = " " + bo.nullAsNil((String)localObject3);
          break label805;
          label1872:
          ((ak)localObject2).jW(((au)localObject2).field_content);
          break label817;
          label1885:
          ((ak)localObject2).hN(((au)localObject2).field_attrflag & 0xFFEFFFFF);
          ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { localObject6, Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().a((ak)localObject2, (String)localObject6, true)), Long.valueOf(((au)localObject2).field_firstUnDeliverSeq), Long.valueOf(((au)localObject2).field_lastSeq), Integer.valueOf(((au)localObject2).field_UnDeliverCount) });
          break label897;
          label1982:
          ab.e("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] data is null");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aq.c
 * JD-Core Version:    0.7.0.1
 */