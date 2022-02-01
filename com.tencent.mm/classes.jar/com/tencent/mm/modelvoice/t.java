package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class t
  implements e
{
  private static Set<c> ixu;
  
  static
  {
    AppMethodBeat.i(148498);
    ixu = new HashSet();
    AppMethodBeat.o(148498);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(148495);
    ixu.remove(paramc);
    AppMethodBeat.o(148495);
  }
  
  public static void c(c paramc)
  {
    AppMethodBeat.i(148494);
    if (!ixu.contains(paramc)) {
      ixu.add(paramc);
    }
    AppMethodBeat.o(148494);
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(148496);
    cv localcv = parama.gqE;
    if (localcv == null)
    {
      ad.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(148496);
      return null;
    }
    ad.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + localcv.xbt);
    Object localObject2 = z.a(localcv.Fvi);
    if (((String)localObject2).equals(u.aAm())) {}
    for (Object localObject1 = z.a(localcv.Fvj);; localObject1 = localObject2)
    {
      Object localObject3 = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aI((String)localObject1, localcv.xbt);
      if ((((ei)localObject3).field_msgId != 0L) && (((ei)localObject3).field_createTime + 604800000L < bj.B((String)localObject1, localcv.CreateTime)))
      {
        ad.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", new Object[] { Long.valueOf(localcv.xbt) });
        bj.C((String)localObject1, localcv.xbt);
        localObject3 = o.aNy().sw(localcv.xbt);
        if ((localObject3 != null) && (!bt.isNullOrNil(((r)localObject3).fileName))) {
          s.HX(((r)localObject3).fileName);
        }
      }
      final r localr = new r();
      localr.dDy = ((String)localObject1);
      localr.createTime = localcv.CreateTime;
      localr.dAY = localcv.xbt;
      localr.eLs = localcv.Fvn;
      ad.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", new Object[] { localcv.Fvn });
      localObject3 = z.a(localcv.Fvk);
      if (com.tencent.mm.model.w.vF((String)localObject2))
      {
        localObject2 = bj.Bl((String)localObject3);
        ad.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=".concat(String.valueOf(localObject2)));
      }
      for (;;)
      {
        localObject3 = bw.M((String)localObject2, "msg");
        if (localObject3 == null)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 227L, 1L, false);
          AppMethodBeat.o(148496);
          return null;
        }
        try
        {
          localr.isJ = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$length")).intValue();
          localr.clientId = ((String)((Map)localObject3).get(".msg.voicemsg.$clientmsgid"));
          i = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$endflag")).intValue();
          int j = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$cancelflag")).intValue();
          localr.ixm = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$voicelength")).intValue();
          localr.itY = ((String)((Map)localObject3).get(".msg.voicemsg.$fromusername"));
          localObject2 = (String)((Map)localObject3).get(".msg.commenturl");
          localr.iwi = Integer.valueOf(bt.bI((String)((Map)localObject3).get(".msg.voicemsg.$forwardflag"), "0")).intValue();
          localr.iwb = ((String)((Map)localObject3).get(".msg.voicemsg.$voiceformat"));
          localr.ixo = bt.getLong((String)((Map)localObject3).get(".msg.voicemsg.$bufid"), 0L);
          if (j == 1)
          {
            ad.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + localcv.xbt);
            parama = o.aNy().sw(localr.dAY);
            if (parama != null) {
              s.HV(parama.fileName);
            }
            AppMethodBeat.o(148496);
            return null;
          }
        }
        catch (Exception parama)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 227L, 1L, false);
          ad.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
          ad.e("MicroMsg.VoiceMsgExtension", "exception:%s", new Object[] { bt.n(parama) });
          AppMethodBeat.o(148496);
          return null;
        }
        if (i == 1)
        {
          ad.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + localcv.xbt);
          localr.hMP = localr.isJ;
        }
        localr.dDp = 284334;
        localObject3 = z.a(localcv.Fvm);
        if (localObject3 != null) {
          ad.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + localObject3.length + " srvId:" + localcv.xbt);
        }
        int i = s.a(localr, (byte[])localObject3, localcv.nDG, (String)localObject2, localcv.Fvn, parama);
        if (i > 0)
        {
          ad.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(localcv.xbt), Integer.valueOf(localcv.Fvp) });
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 228L, 1L, false);
          localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aI(localr.dDy, localr.dAY);
          ((bu)localObject2).aaW(0);
          localObject3 = ixu.iterator();
          for (;;)
          {
            parama = (e.a)localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148493);
                this.iwg.Y(((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aI(localr.dDy, localr.dAY));
                AppMethodBeat.o(148493);
              }
            });
          }
        }
        ad.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(localcv.xbt), Integer.valueOf(localcv.Fvp), bt.flS() });
        parama = null;
        if (parama != null)
        {
          localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTz((String)localObject1);
          if (localObject2 != null)
          {
            ((at)localObject2).lP(16777216);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().a((at)localObject2, (String)localObject1);
          }
        }
        if ((parama != null) && (parama.field_msgId > 0L)) {}
        for (boolean bool = true;; bool = false)
        {
          parama = new e.b(parama, bool);
          AppMethodBeat.o(148496);
          return parama;
        }
        localObject2 = localObject3;
      }
    }
  }
  
  public final void b(e.c paramc)
  {
    AppMethodBeat.i(148497);
    paramc = paramc.dBd;
    ad.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + paramc.field_imgPath + " " + paramc.field_talker);
    if (!com.tencent.mm.model.w.Aa(paramc.field_talker)) {
      s.HX(paramc.field_imgPath);
    }
    AppMethodBeat.o(148497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.t
 * JD-Core Version:    0.7.0.1
 */