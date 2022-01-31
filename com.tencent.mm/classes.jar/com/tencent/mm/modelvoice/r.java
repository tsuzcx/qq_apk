package com.tencent.mm.modelvoice;

import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class r
  implements e
{
  private static Set<c> eLe = new HashSet();
  
  public static void b(c paramc)
  {
    eLe.remove(paramc);
  }
  
  public static void c(c paramc)
  {
    if (!eLe.contains(paramc)) {
      eLe.add(paramc);
    }
  }
  
  public final void a(e.c paramc)
  {
    paramc = paramc.bWO;
    y.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + paramc.field_imgPath + " " + paramc.field_talker);
    if (!s.hH(paramc.field_talker)) {
      q.oD(paramc.field_imgPath);
    }
  }
  
  public final e.b b(e.a parama)
  {
    cd localcd = parama.dBs;
    if (localcd == null)
    {
      y.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      return null;
    }
    y.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + localcd.ndp);
    Object localObject2 = aa.a(localcd.svF);
    if (((String)localObject2).equals(com.tencent.mm.model.q.Gj())) {}
    for (Object localObject1 = aa.a(localcd.svG);; localObject1 = localObject2)
    {
      Object localObject3 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().O((String)localObject1, localcd.ndp);
      if ((((cs)localObject3).field_msgId != 0L) && (((cs)localObject3).field_createTime + 604800000L < bd.o((String)localObject1, localcd.mPL)))
      {
        y.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", new Object[] { Long.valueOf(localcd.ndp) });
        bd.p((String)localObject1, localcd.ndp);
        localObject3 = m.Tg().cl(localcd.ndp);
        if ((localObject3 != null) && (!bk.bl(((p)localObject3).fileName))) {
          q.oD(((p)localObject3).fileName);
        }
      }
      p localp = new p();
      localp.bVI = ((String)localObject1);
      localp.createTime = localcd.mPL;
      localp.bXr = localcd.ndp;
      localp.czr = localcd.svK;
      y.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", new Object[] { localcd.svK });
      localObject3 = aa.a(localcd.svH);
      if (s.fn((String)localObject2))
      {
        localObject2 = bd.iJ((String)localObject3);
        y.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=" + (String)localObject2);
      }
      for (;;)
      {
        localObject3 = bn.s((String)localObject2, "msg");
        if (localObject3 == null)
        {
          h.nFQ.a(111L, 227L, 1L, false);
          return null;
        }
        try
        {
          localp.eGk = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$length")).intValue();
          localp.clientId = ((String)((Map)localObject3).get(".msg.voicemsg.$clientmsgid"));
          i = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$endflag")).intValue();
          int j = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$cancelflag")).intValue();
          localp.eKW = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$voicelength")).intValue();
          localp.eHA = ((String)((Map)localObject3).get(".msg.voicemsg.$fromusername"));
          localObject2 = (String)((Map)localObject3).get(".msg.commenturl");
          localp.eJW = Integer.valueOf(bk.aM((String)((Map)localObject3).get(".msg.voicemsg.$forwardflag"), "0")).intValue();
          localp.eJP = ((String)((Map)localObject3).get(".msg.voicemsg.$voiceformat"));
          localp.eKY = bk.getLong((String)((Map)localObject3).get(".msg.voicemsg.$bufid"), 0L);
          if (j == 1)
          {
            y.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + localcd.ndp);
            parama = m.Tg().cl(localp.bXr);
            if (parama != null) {
              q.oB(parama.fileName);
            }
            return null;
          }
        }
        catch (Exception parama)
        {
          h.nFQ.a(111L, 227L, 1L, false);
          y.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
          y.e("MicroMsg.VoiceMsgExtension", "exception:%s", new Object[] { bk.j(parama) });
          return null;
        }
        if (i == 1)
        {
          y.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + localcd.ndp);
          localp.ebK = localp.eGk;
        }
        localp.bcw = 284334;
        localObject3 = aa.a(localcd.svJ);
        if (localObject3 != null) {
          y.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + localObject3.length + " srvId:" + localcd.ndp);
        }
        int i = q.a(localp, (byte[])localObject3, localcd.hQq, (String)localObject2, localcd.svK, parama);
        if (i > 0)
        {
          y.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(localcd.ndp), Integer.valueOf(localcd.svM) });
          h.nFQ.a(111L, 228L, 1L, false);
          localObject2 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().O(localp.bVI, localp.bXr);
          ((bi)localObject2).Fq(0);
          localObject3 = eLe.iterator();
          for (;;)
          {
            parama = (e.a)localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            ai.d(new r.1(this, (c)((Iterator)localObject3).next(), localp));
          }
        }
        y.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(localcd.ndp), Integer.valueOf(localcd.svM), bk.csb() });
        parama = null;
        if (parama != null)
        {
          localObject2 = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abv((String)localObject1);
          if (localObject2 != null)
          {
            ((ak)localObject2).gU(16777216);
            ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a((ak)localObject2, (String)localObject1);
          }
        }
        if ((parama != null) && (parama.field_msgId > 0L)) {}
        for (boolean bool = true;; bool = false) {
          return new e.b(parama, bool);
        }
        localObject2 = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.r
 * JD-Core Version:    0.7.0.1
 */