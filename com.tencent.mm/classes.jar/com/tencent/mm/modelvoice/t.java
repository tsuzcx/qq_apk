package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class t
  implements e
{
  private static Set<c> iAn;
  
  static
  {
    AppMethodBeat.i(148498);
    iAn = new HashSet();
    AppMethodBeat.o(148498);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(148495);
    iAn.remove(paramc);
    AppMethodBeat.o(148495);
  }
  
  public static void c(c paramc)
  {
    AppMethodBeat.i(148494);
    if (!iAn.contains(paramc)) {
      iAn.add(paramc);
    }
    AppMethodBeat.o(148494);
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(148496);
    cv localcv = parama.gte;
    if (localcv == null)
    {
      ae.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(148496);
      return null;
    }
    ae.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + localcv.xrk);
    Object localObject2 = z.a(localcv.FNG);
    if (((String)localObject2).equals(v.aAC())) {}
    for (Object localObject1 = z.a(localcv.FNH);; localObject1 = localObject2)
    {
      Object localObject3 = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aJ((String)localObject1, localcv.xrk);
      if ((((ei)localObject3).field_msgId != 0L) && (((ei)localObject3).field_createTime + 604800000L < bl.B((String)localObject1, localcv.CreateTime)))
      {
        ae.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", new Object[] { Long.valueOf(localcv.xrk) });
        bl.C((String)localObject1, localcv.xrk);
        localObject3 = o.aNW().sJ(localcv.xrk);
        if ((localObject3 != null) && (!bu.isNullOrNil(((r)localObject3).fileName))) {
          s.Iz(((r)localObject3).fileName);
        }
      }
      final r localr = new r();
      localr.dED = ((String)localObject1);
      localr.createTime = localcv.CreateTime;
      localr.dCd = localcv.xrk;
      localr.eNd = localcv.FNL;
      ae.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", new Object[] { localcv.FNL });
      localObject3 = z.a(localcv.FNI);
      if (x.wb((String)localObject2))
      {
        localObject2 = bl.BN((String)localObject3);
        ae.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=".concat(String.valueOf(localObject2)));
      }
      for (;;)
      {
        localObject3 = bx.M((String)localObject2, "msg");
        if (localObject3 == null)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 227L, 1L, false);
          AppMethodBeat.o(148496);
          return null;
        }
        try
        {
          localr.ivD = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$length")).intValue();
          localr.clientId = ((String)((Map)localObject3).get(".msg.voicemsg.$clientmsgid"));
          i = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$endflag")).intValue();
          int j = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$cancelflag")).intValue();
          localr.iAf = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$voicelength")).intValue();
          localr.iwS = ((String)((Map)localObject3).get(".msg.voicemsg.$fromusername"));
          localObject2 = (String)((Map)localObject3).get(".msg.commenturl");
          localr.izb = Integer.valueOf(bu.bI((String)((Map)localObject3).get(".msg.voicemsg.$forwardflag"), "0")).intValue();
          localr.iyU = ((String)((Map)localObject3).get(".msg.voicemsg.$voiceformat"));
          localr.iAh = bu.getLong((String)((Map)localObject3).get(".msg.voicemsg.$bufid"), 0L);
          if (j == 1)
          {
            ae.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + localcv.xrk);
            parama = o.aNW().sJ(localr.dCd);
            if (parama != null) {
              s.Ix(parama.fileName);
            }
            AppMethodBeat.o(148496);
            return null;
          }
        }
        catch (Exception parama)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 227L, 1L, false);
          ae.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
          ae.e("MicroMsg.VoiceMsgExtension", "exception:%s", new Object[] { bu.o(parama) });
          AppMethodBeat.o(148496);
          return null;
        }
        if (i == 1)
        {
          ae.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + localcv.xrk);
          localr.hPI = localr.ivD;
        }
        localr.dEu = 284334;
        localObject3 = z.a(localcv.FNK);
        if (localObject3 != null) {
          ae.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + localObject3.length + " srvId:" + localcv.xrk);
        }
        int i = s.a(localr, (byte[])localObject3, localcv.nJb, (String)localObject2, localcv.FNL, parama);
        if (i > 0)
        {
          ae.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(localcv.xrk), Integer.valueOf(localcv.FNN) });
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(111L, 228L, 1L, false);
          localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aJ(localr.dED, localr.dCd);
          ((bv)localObject2).abE(0);
          localObject3 = iAn.iterator();
          for (;;)
          {
            parama = (e.a)localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148493);
                this.iyZ.X(((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aJ(localr.dED, localr.dCd));
                AppMethodBeat.o(148493);
              }
            });
          }
        }
        ae.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(localcv.xrk), Integer.valueOf(localcv.FNN), bu.fpN() });
        parama = null;
        if (parama != null)
        {
          localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVa((String)localObject1);
          if (localObject2 != null)
          {
            ((au)localObject2).lR(16777216);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().a((au)localObject2, (String)localObject1);
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
    paramc = paramc.dCi;
    ae.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + paramc.field_imgPath + " " + paramc.field_talker);
    if (!x.AK(paramc.field_talker)) {
      s.Iz(paramc.field_imgPath);
    }
    AppMethodBeat.o(148497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.t
 * JD-Core Version:    0.7.0.1
 */