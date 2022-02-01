package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class t
  implements f
{
  private static Set<c> hDx;
  
  static
  {
    AppMethodBeat.i(148498);
    hDx = new HashSet();
    AppMethodBeat.o(148498);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(148495);
    hDx.remove(paramc);
    AppMethodBeat.o(148495);
  }
  
  public static void c(c paramc)
  {
    AppMethodBeat.i(148494);
    if (!hDx.contains(paramc)) {
      hDx.add(paramc);
    }
    AppMethodBeat.o(148494);
  }
  
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(148496);
    cs localcs = parama.fTo;
    if (localcs == null)
    {
      ad.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(148496);
      return null;
    }
    ad.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + localcs.uKZ);
    Object localObject2 = z.a(localcs.Cxx);
    if (((String)localObject2).equals(u.aqG())) {}
    for (Object localObject1 = z.a(localcs.Cxy);; localObject1 = localObject2)
    {
      Object localObject3 = ((k)g.ab(k.class)).cOI().aD((String)localObject1, localcs.uKZ);
      if ((((du)localObject3).field_msgId != 0L) && (((du)localObject3).field_createTime + 604800000L < bi.y((String)localObject1, localcs.CreateTime)))
      {
        ad.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", new Object[] { Long.valueOf(localcs.uKZ) });
        bi.z((String)localObject1, localcs.uKZ);
        localObject3 = o.aDy().mJ(localcs.uKZ);
        if ((localObject3 != null) && (!bt.isNullOrNil(((r)localObject3).fileName))) {
          s.AD(((r)localObject3).fileName);
        }
      }
      final r localr = new r();
      localr.dtV = ((String)localObject1);
      localr.createTime = localcs.CreateTime;
      localr.drA = localcs.uKZ;
      localr.esh = localcs.CxC;
      ad.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", new Object[] { localcs.CxC });
      localObject3 = z.a(localcs.Cxz);
      if (com.tencent.mm.model.w.pF((String)localObject2))
      {
        localObject2 = bi.ug((String)localObject3);
        ad.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=".concat(String.valueOf(localObject2)));
      }
      for (;;)
      {
        localObject3 = bw.K((String)localObject2, "msg");
        if (localObject3 == null)
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 227L, 1L, false);
          AppMethodBeat.o(148496);
          return null;
        }
        try
        {
          localr.hyM = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$length")).intValue();
          localr.clientId = ((String)((Map)localObject3).get(".msg.voicemsg.$clientmsgid"));
          i = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$endflag")).intValue();
          int j = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$cancelflag")).intValue();
          localr.hDp = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$voicelength")).intValue();
          localr.hAb = ((String)((Map)localObject3).get(".msg.voicemsg.$fromusername"));
          localObject2 = (String)((Map)localObject3).get(".msg.commenturl");
          localr.hCl = Integer.valueOf(bt.by((String)((Map)localObject3).get(".msg.voicemsg.$forwardflag"), "0")).intValue();
          localr.hCe = ((String)((Map)localObject3).get(".msg.voicemsg.$voiceformat"));
          localr.hDr = bt.getLong((String)((Map)localObject3).get(".msg.voicemsg.$bufid"), 0L);
          if (j == 1)
          {
            ad.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + localcs.uKZ);
            parama = o.aDy().mJ(localr.drA);
            if (parama != null) {
              s.AB(parama.fileName);
            }
            AppMethodBeat.o(148496);
            return null;
          }
        }
        catch (Exception parama)
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 227L, 1L, false);
          ad.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
          ad.e("MicroMsg.VoiceMsgExtension", "exception:%s", new Object[] { bt.m(parama) });
          AppMethodBeat.o(148496);
          return null;
        }
        if (i == 1)
        {
          ad.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + localcs.uKZ);
          localr.gTY = localr.hyM;
        }
        localr.dtM = 284334;
        localObject3 = z.a(localcs.CxB);
        if (localObject3 != null) {
          ad.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + localObject3.length + " srvId:" + localcs.uKZ);
        }
        int i = s.a(localr, (byte[])localObject3, localcs.mBi, (String)localObject2, localcs.CxC, parama);
        if (i > 0)
        {
          ad.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(localcs.uKZ), Integer.valueOf(localcs.CxE) });
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 228L, 1L, false);
          localObject2 = ((k)g.ab(k.class)).cOI().aD(localr.dtV, localr.drA);
          ((bl)localObject2).WD(0);
          localObject3 = hDx.iterator();
          for (;;)
          {
            parama = (f.a)localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148493);
                this.hCj.V(((k)g.ab(k.class)).cOI().aD(localr.dtV, localr.drA));
                AppMethodBeat.o(148493);
              }
            });
          }
        }
        ad.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(localcs.uKZ), Integer.valueOf(localcs.CxE), bt.eGN() });
        parama = null;
        if (parama != null)
        {
          localObject2 = ((k)g.ab(k.class)).apR().aIn((String)localObject1);
          if (localObject2 != null)
          {
            ((am)localObject2).lv(16777216);
            ((k)g.ab(k.class)).apR().a((am)localObject2, (String)localObject1);
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
    paramc = paramc.drF;
    ad.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + paramc.field_imgPath + " " + paramc.field_talker);
    if (!com.tencent.mm.model.w.ta(paramc.field_talker)) {
      s.AD(paramc.field_imgPath);
    }
    AppMethodBeat.o(148497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.t
 * JD-Core Version:    0.7.0.1
 */