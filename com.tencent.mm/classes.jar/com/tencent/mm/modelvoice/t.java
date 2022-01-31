package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class t
  implements e
{
  private static Set<c> gaL;
  
  static
  {
    AppMethodBeat.i(116657);
    gaL = new HashSet();
    AppMethodBeat.o(116657);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(116654);
    gaL.remove(paramc);
    AppMethodBeat.o(116654);
  }
  
  public static void c(c paramc)
  {
    AppMethodBeat.i(116653);
    if (!gaL.contains(paramc)) {
      gaL.add(paramc);
    }
    AppMethodBeat.o(116653);
  }
  
  public final void a(e.c paramc)
  {
    AppMethodBeat.i(116656);
    paramc = paramc.cEE;
    ab.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + paramc.field_imgPath + " " + paramc.field_talker);
    if (!com.tencent.mm.model.t.oq(paramc.field_talker)) {
      s.vQ(paramc.field_imgPath);
    }
    AppMethodBeat.o(116656);
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(116655);
    cm localcm = parama.eyJ;
    if (localcm == null)
    {
      ab.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(116655);
      return null;
    }
    ab.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + localcm.pIG);
    Object localObject2 = aa.a(localcm.woP);
    if (((String)localObject2).equals(com.tencent.mm.model.r.Zn())) {}
    for (Object localObject1 = aa.a(localcm.woQ);; localObject1 = localObject2)
    {
      Object localObject3 = ((j)g.E(j.class)).bPQ().ag((String)localObject1, localcm.pIG);
      if ((((dd)localObject3).field_msgId != 0L) && (((dd)localObject3).field_createTime + 604800000L < bf.x((String)localObject1, localcm.CreateTime)))
      {
        ab.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", new Object[] { Long.valueOf(localcm.pIG) });
        bf.y((String)localObject1, localcm.pIG);
        localObject3 = o.ams().hj(localcm.pIG);
        if ((localObject3 != null) && (!bo.isNullOrNil(((r)localObject3).fileName))) {
          s.vQ(((r)localObject3).fileName);
        }
      }
      r localr = new r();
      localr.cDt = ((String)localObject1);
      localr.createTime = localcm.CreateTime;
      localr.cFn = localcm.pIG;
      localr.dns = localcm.woU;
      ab.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", new Object[] { localcm.woU });
      localObject3 = aa.a(localcm.woR);
      if (com.tencent.mm.model.t.lA((String)localObject2))
      {
        localObject2 = bf.pv((String)localObject3);
        ab.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=".concat(String.valueOf(localObject2)));
      }
      for (;;)
      {
        localObject3 = br.F((String)localObject2, "msg");
        if (localObject3 == null)
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 227L, 1L, false);
          AppMethodBeat.o(116655);
          return null;
        }
        try
        {
          localr.fWa = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$length")).intValue();
          localr.clientId = ((String)((Map)localObject3).get(".msg.voicemsg.$clientmsgid"));
          i = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$endflag")).intValue();
          int j = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$cancelflag")).intValue();
          localr.gaD = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$voicelength")).intValue();
          localr.fXq = ((String)((Map)localObject3).get(".msg.voicemsg.$fromusername"));
          localObject2 = (String)((Map)localObject3).get(".msg.commenturl");
          localr.fZy = Integer.valueOf(bo.bf((String)((Map)localObject3).get(".msg.voicemsg.$forwardflag"), "0")).intValue();
          localr.fZr = ((String)((Map)localObject3).get(".msg.voicemsg.$voiceformat"));
          localr.gaF = bo.getLong((String)((Map)localObject3).get(".msg.voicemsg.$bufid"), 0L);
          if (j == 1)
          {
            ab.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + localcm.pIG);
            parama = o.ams().hj(localr.cFn);
            if (parama != null) {
              s.vO(parama.fileName);
            }
            AppMethodBeat.o(116655);
            return null;
          }
        }
        catch (Exception parama)
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 227L, 1L, false);
          ab.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
          ab.e("MicroMsg.VoiceMsgExtension", "exception:%s", new Object[] { bo.l(parama) });
          AppMethodBeat.o(116655);
          return null;
        }
        if (i == 1)
        {
          ab.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + localcm.pIG);
          localr.fsd = localr.fWa;
        }
        localr.bsY = 284334;
        localObject3 = aa.a(localcm.woT);
        if (localObject3 != null) {
          ab.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + localObject3.length + " srvId:" + localcm.pIG);
        }
        int i = s.a(localr, (byte[])localObject3, localcm.jJS, (String)localObject2, localcm.woU, parama);
        if (i > 0)
        {
          ab.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(localcm.pIG), Integer.valueOf(localcm.woW) });
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 228L, 1L, false);
          localObject2 = ((j)g.E(j.class)).bPQ().ag(localr.cDt, localr.cFn);
          ((bi)localObject2).Nx(0);
          localObject3 = gaL.iterator();
          for (;;)
          {
            parama = (e.a)localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            al.d(new t.1(this, (c)((Iterator)localObject3).next(), localr));
          }
        }
        ab.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(localcm.pIG), Integer.valueOf(localcm.woW), bo.dtY() });
        parama = null;
        if (parama != null)
        {
          localObject2 = ((j)g.E(j.class)).YF().arH((String)localObject1);
          if (localObject2 != null)
          {
            ((ak)localObject2).jh(16777216);
            ((j)g.E(j.class)).YF().a((ak)localObject2, (String)localObject1);
          }
        }
        if ((parama != null) && (parama.field_msgId > 0L)) {}
        for (boolean bool = true;; bool = false)
        {
          parama = new e.b(parama, bool);
          AppMethodBeat.o(116655);
          return parama;
        }
        localObject2 = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelvoice.t
 * JD-Core Version:    0.7.0.1
 */