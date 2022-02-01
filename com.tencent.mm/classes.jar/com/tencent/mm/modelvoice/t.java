package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class t
  implements f
{
  private static Set<c> idZ;
  
  static
  {
    AppMethodBeat.i(148498);
    idZ = new HashSet();
    AppMethodBeat.o(148498);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(148495);
    idZ.remove(paramc);
    AppMethodBeat.o(148495);
  }
  
  public static void c(c paramc)
  {
    AppMethodBeat.i(148494);
    if (!idZ.contains(paramc)) {
      idZ.add(paramc);
    }
    AppMethodBeat.o(148494);
  }
  
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(148496);
    cu localcu = parama.fXi;
    if (localcu == null)
    {
      ac.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(148496);
      return null;
    }
    ac.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + localcu.vTQ);
    Object localObject2 = z.a(localcu.DPT);
    if (((String)localObject2).equals(u.axw())) {}
    for (Object localObject1 = z.a(localcu.DPU);; localObject1 = localObject2)
    {
      Object localObject3 = ((k)g.ab(k.class)).dcr().aF((String)localObject1, localcu.vTQ);
      if ((((dy)localObject3).field_msgId != 0L) && (((dy)localObject3).field_createTime + 604800000L < bi.z((String)localObject1, localcu.CreateTime)))
      {
        ac.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", new Object[] { Long.valueOf(localcu.vTQ) });
        bi.A((String)localObject1, localcu.vTQ);
        localObject3 = o.aKp().qx(localcu.vTQ);
        if ((localObject3 != null) && (!bs.isNullOrNil(((r)localObject3).fileName))) {
          s.EI(((r)localObject3).fileName);
        }
      }
      final r localr = new r();
      localr.drG = ((String)localObject1);
      localr.createTime = localcu.CreateTime;
      localr.dpl = localcu.vTQ;
      localr.eul = localcu.DPY;
      ac.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", new Object[] { localcu.DPY });
      localObject3 = z.a(localcu.DPV);
      if (com.tencent.mm.model.w.sQ((String)localObject2))
      {
        localObject2 = bi.ym((String)localObject3);
        ac.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=".concat(String.valueOf(localObject2)));
      }
      for (;;)
      {
        localObject3 = bv.L((String)localObject2, "msg");
        if (localObject3 == null)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 227L, 1L, false);
          AppMethodBeat.o(148496);
          return null;
        }
        try
        {
          localr.hZn = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$length")).intValue();
          localr.clientId = ((String)((Map)localObject3).get(".msg.voicemsg.$clientmsgid"));
          i = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$endflag")).intValue();
          int j = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$cancelflag")).intValue();
          localr.idR = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$voicelength")).intValue();
          localr.iaC = ((String)((Map)localObject3).get(".msg.voicemsg.$fromusername"));
          localObject2 = (String)((Map)localObject3).get(".msg.commenturl");
          localr.icM = Integer.valueOf(bs.bG((String)((Map)localObject3).get(".msg.voicemsg.$forwardflag"), "0")).intValue();
          localr.icF = ((String)((Map)localObject3).get(".msg.voicemsg.$voiceformat"));
          localr.idT = bs.getLong((String)((Map)localObject3).get(".msg.voicemsg.$bufid"), 0L);
          if (j == 1)
          {
            ac.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + localcu.vTQ);
            parama = o.aKp().qx(localr.dpl);
            if (parama != null) {
              s.EG(parama.fileName);
            }
            AppMethodBeat.o(148496);
            return null;
          }
        }
        catch (Exception parama)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 227L, 1L, false);
          ac.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
          ac.e("MicroMsg.VoiceMsgExtension", "exception:%s", new Object[] { bs.m(parama) });
          AppMethodBeat.o(148496);
          return null;
        }
        if (i == 1)
        {
          ac.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + localcu.vTQ);
          localr.hux = localr.hZn;
        }
        localr.drx = 284334;
        localObject3 = z.a(localcu.DPX);
        if (localObject3 != null) {
          ac.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + localObject3.length + " srvId:" + localcu.vTQ);
        }
        int i = s.a(localr, (byte[])localObject3, localcu.ndj, (String)localObject2, localcu.DPY, parama);
        if (i > 0)
        {
          ac.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(localcu.vTQ), Integer.valueOf(localcu.DQa) });
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 228L, 1L, false);
          localObject2 = ((k)g.ab(k.class)).dcr().aF(localr.drG, localr.dpl);
          ((bo)localObject2).YN(0);
          localObject3 = idZ.iterator();
          for (;;)
          {
            parama = (f.a)localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148493);
                this.icK.V(((k)g.ab(k.class)).dcr().aF(localr.drG, localr.dpl));
                AppMethodBeat.o(148493);
              }
            });
          }
        }
        ac.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(localcu.vTQ), Integer.valueOf(localcu.DQa), bs.eWi() });
        parama = null;
        if (parama != null)
        {
          localObject2 = ((k)g.ab(k.class)).awG().aNI((String)localObject1);
          if (localObject2 != null)
          {
            ((com.tencent.mm.storage.ap)localObject2).lq(16777216);
            ((k)g.ab(k.class)).awG().a((com.tencent.mm.storage.ap)localObject2, (String)localObject1);
          }
        }
        if ((parama != null) && (parama.field_msgId > 0L)) {}
        for (boolean bool = true;; bool = false)
        {
          parama = new f.b(parama, bool);
          AppMethodBeat.o(148496);
          return parama;
        }
        localObject2 = localObject3;
      }
    }
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(148497);
    paramc = paramc.dpq;
    ac.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + paramc.field_imgPath + " " + paramc.field_talker);
    if (!com.tencent.mm.model.w.xd(paramc.field_talker)) {
      s.EI(paramc.field_imgPath);
    }
    AppMethodBeat.o(148497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.t
 * JD-Core Version:    0.7.0.1
 */