package com.tencent.mm.ap;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.pw;
import com.tencent.mm.h.a.pw.a;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ce;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.w;
import java.util.Map;

final class c$a
  implements Runnable
{
  pw emk;
  
  private c$a(pw parampw)
  {
    this.emk = parampw;
  }
  
  public final void run()
  {
    long l3 = System.currentTimeMillis();
    if (!com.tencent.mm.kernel.g.DK()) {
      y.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] accHasReady no!");
    }
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
    label492:
    label501:
    bi localbi;
    for (;;)
    {
      y.d("MicroMsg.GetChatroomMsgReceiver", "[HandlePushTask$run] cost:" + (System.currentTimeMillis() - l3));
      return;
      Object localObject1 = this.emk.bZv.data;
      if (localObject1 == null) {
        break label1974;
      }
      localObject3 = new ce();
      try
      {
        ((ce)localObject3).aH((byte[])localObject1);
        long l4 = System.currentTimeMillis();
        localObject4 = aa.a(((ce)localObject3).svN);
        i = ((ce)localObject3).svM;
        l5 = 1000L * ((ce)localObject3).mPL;
        localObject5 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhJ();
        if (((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).Hk((String)localObject4))
        {
          y.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#update] chatRoomId:%s updatePushSeqRet[%s]:%s updatePushCreateTimeRet[%s]:%s", new Object[] { localObject4, Integer.valueOf(i), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).G((String)localObject4, i)), Long.valueOf(l5), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).I((String)localObject4, l5)) });
          y.d("MicroMsg.GetChatroomMsgReceiver", "[updateChatroomMsgSeq] cost:" + (System.currentTimeMillis() - l4));
          l2 = System.currentTimeMillis();
          localObject6 = aa.a(((ce)localObject3).svN);
          i = ((ce)localObject3).svM;
          l1 = ((ce)localObject3).ndp;
          m = ((ce)localObject3).mPL;
          j = ((ce)localObject3).svQ;
          k = ((ce)localObject3).kSW;
          n = ((ce)localObject3).svO;
          localObject3 = aa.a(((ce)localObject3).svP);
          y.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", new Object[] { localObject6, Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(n), bk.aac((String)localObject3) });
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abv((String)localObject6);
          if (localObject1 != null) {
            break label1234;
          }
          localObject1 = new ak((String)localObject6);
          ((ak)localObject1).ba(m * 1000L);
          ((ak)localObject1).bc(i);
          ((ak)localObject1).fy(n);
          ((ak)localObject1).fF(n);
          l1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Gb().Ho((String)localObject6);
          y.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", new Object[] { Long.valueOf(l1), Integer.valueOf(i) });
          if (l1 <= 0L) {
            break label1227;
          }
          ((ak)localObject1).bd(l1);
          i = 1;
          if (j > 0) {
            ((ak)localObject1).fD(((as)localObject1).field_atCount + j);
          }
          localbi = new bi();
          localbi.fA(0);
          localbi.ec((String)localObject6);
          localbi.setType(k);
          localbi.setContent((String)localObject3);
          if (k != 49) {
            break label1525;
          }
          localObject4 = g.a.gp(com.tencent.mm.pluginsdk.model.app.j.fS((String)localObject6, (String)localObject3));
          localbi.setType(l.d((g.a)localObject4));
          if (!localbi.ctz()) {
            break label1522;
          }
          localObject3 = ((g.a)localObject4).content;
          label595:
          localbi.setContent((String)localObject3);
          label602:
          ((ak)localObject1).fA(0);
          ((ak)localObject1).setContent(localbi.field_content);
          ((ak)localObject1).dP(Integer.toString(localbi.getType()));
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().tt();
          if (localObject3 == null) {
            break label1864;
          }
          localObject4 = new PString();
          localObject5 = new PString();
          PInt localPInt = new PInt();
          ((be.b)localObject3).a(localbi, (PString)localObject4, (PString)localObject5, localPInt, false);
          ((ak)localObject1).dQ(((PString)localObject4).value);
          ((ak)localObject1).dR(((PString)localObject5).value);
          ((ak)localObject1).fB(localPInt.value);
          if (localbi.getType() == 49)
          {
            localObject3 = (String)bn.s(((as)localObject1).field_content, "msg").get(".msg.appmsg.title");
            localObject4 = bk.pm(((as)localObject1).field_digest);
            if (!bk.bl((String)localObject3)) {
              break label1838;
            }
            localObject3 = "";
            label786:
            ((ak)localObject1).dQ(((String)localObject4).concat((String)localObject3));
          }
          label798:
          if (i == 0) {
            break label1877;
          }
          y.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { localObject6, Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().d((ak)localObject1)), Long.valueOf(((as)localObject1).field_firstUnDeliverSeq), Long.valueOf(((as)localObject1).field_lastSeq), Integer.valueOf(((as)localObject1).field_UnDeliverCount) });
          label878:
          y.d("MicroMsg.GetChatroomMsgReceiver", "[updateConv] cost:" + (System.currentTimeMillis() - l2));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", localException, "", new Object[0]);
        }
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HB((String)localObject4);
        if (((cs)localObject2).field_msgId != 0L) {
          break label1985;
        }
      }
    }
    y.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] has not any ReceivedMsg!");
    Object localObject2 = null;
    label1055:
    label1081:
    label1985:
    for (;;)
    {
      if (localObject2 != null)
      {
        localObject6 = h.g("yyyy-MM-dd HH:mm:ss", ((cs)localObject2).field_createTime / 1000L);
        y.w("MicroMsg.GetChatroomMsgReceiver", "[lastFaultMsgInfo] lastFaultMsgInfo:%s timeFormat:%s", new Object[] { bk.aac(((cs)localObject2).field_content), localObject6 });
      }
      localObject6 = new w();
      ((w)localObject6).field_username = ((String)localObject4);
      ((w)localObject6).field_lastPushSeq = i;
      long l6;
      if (localObject2 != null)
      {
        l1 = ((cs)localObject2).field_msgSeq;
        ((w)localObject6).field_lastLocalSeq = l1;
        ((w)localObject6).field_lastPushCreateTime = l5;
        if (localObject2 == null) {
          break label1200;
        }
        l1 = ((cs)localObject2).field_createTime;
        ((w)localObject6).field_lastLocalCreateTime = l1;
        l6 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject5).a((w)localObject6);
        if (localObject2 == null) {
          break label1209;
        }
        l1 = ((cs)localObject2).field_msgSeq;
        label1111:
        if (localObject2 == null) {
          break label1218;
        }
      }
      label1218:
      for (l2 = ((cs)localObject2).field_createTime;; l2 = l5 - 1L)
      {
        y.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#insert] ret:%s,chatRoomId:%s updatePushSeq:%s updatePushCreateTime:%s field_lastLocalSeq:%s field_lastLocalCreateTime:%s", new Object[] { Long.valueOf(l6), localObject4, Integer.valueOf(i), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l2) });
        localObject2 = com.tencent.mm.ui.chatting.i.b.vzo;
        com.tencent.mm.ui.chatting.i.b.cGQ();
        break;
        l1 = i - 1;
        break label1055;
        l1 = l5 - 1L;
        break label1081;
        l1 = i - 1;
        break label1111;
      }
      label1227:
      l1 = i;
      break label492;
      label1234:
      int i1 = (int)((as)localObject2).field_lastSeq;
      if (i > i1)
      {
        ((ak)localObject2).bc(i);
        ((ak)localObject2).fF(n);
        ((ak)localObject2).ba(m * 1000L);
        if (n > ((as)localObject2).field_unReadCount) {
          ((ak)localObject2).fy(n);
        }
        l1 = ((as)localObject2).field_firstUnDeliverSeq;
        y.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv  msgSeq[%d], firstSeq[%d], lastseq[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(i1) });
        if (l1 > 0L)
        {
          localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().P((String)localObject6, i1);
          if (((cs)localObject4).field_msgId > 0L) {
            ((ak)localObject2).bd(((cs)localObject4).field_msgSeq);
          }
          i = 0;
          break label501;
        }
        l1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Gb().Ho((String)localObject6);
        if (l1 > 0L)
        {
          ((ak)localObject2).bd(l1);
          i = 0;
          break label501;
        }
        l1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HW((String)localObject6);
        y.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv lastMsgSeq[%s]", new Object[] { Long.valueOf(l1) });
        if (l1 > 0L) {
          ((ak)localObject2).bd(l1);
        }
        i = 0;
        break label501;
      }
      if ((i == i1) && (n == 0) && (((as)localObject2).field_unReadCount > 0)) {
        ((ak)localObject2).fy(0);
      }
      i = 0;
      break label501;
      label1522:
      break label595;
      label1525:
      if (k != 10002) {
        break label602;
      }
      ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension();
      if ((localbi.getType() != 10002) || (bk.bl((String)localObject3))) {
        break label602;
      }
      if (bk.bl((String)localObject3))
      {
        y.e("MicroMsg.SysCmdMsgExtension", "null msg content");
        break label602;
      }
      if (((String)localObject3).startsWith("~SEMI_XML~"))
      {
        localObject4 = ba.Zx((String)localObject3);
        if (localObject4 == null)
        {
          y.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[] { localObject3 });
          break label602;
        }
        localObject3 = localObject4;
      }
      for (localObject4 = "brand_service";; localObject4 = localObject5)
      {
        if ((localObject4 == null) || (!((String)localObject4).equals("revokemsg"))) {
          break label1836;
        }
        y.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
        ((Map)localObject3).get(".sysmsg.revokemsg.session");
        localObject4 = (String)((Map)localObject3).get(".sysmsg.revokemsg.newmsgid");
        localObject3 = (String)((Map)localObject3).get(".sysmsg.revokemsg.replacemsg");
        y.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject4, localObject3 });
        localbi.setContent((String)localObject3);
        localbi.setType(10000);
        break;
        j = ((String)localObject3).indexOf("<sysmsg");
        if (j == -1)
        {
          y.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
          break;
        }
        localObject4 = bn.s(((String)localObject3).substring(j), "sysmsg");
        if (localObject4 == null)
        {
          y.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject3 });
          break;
        }
        localObject5 = (String)((Map)localObject4).get(".sysmsg.$type");
        localObject3 = localObject4;
      }
      break label602;
      localObject3 = " " + bk.pm((String)localObject3);
      break label786;
      label1864:
      ((ak)localObject2).dQ(((as)localObject2).field_content);
      break label798;
      label1877:
      ((ak)localObject2).fC(((as)localObject2).field_attrflag & 0xFFEFFFFF);
      y.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", new Object[] { localObject6, Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().a((ak)localObject2, (String)localObject6, true)), Long.valueOf(((as)localObject2).field_firstUnDeliverSeq), Long.valueOf(((as)localObject2).field_lastSeq), Integer.valueOf(((as)localObject2).field_UnDeliverCount) });
      break label878;
      y.e("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] data is null");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ap.c.a
 * JD-Core Version:    0.7.0.1
 */