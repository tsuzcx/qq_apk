package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class t
  implements com.tencent.mm.an.h
{
  private static Set<c> mlf;
  
  static
  {
    AppMethodBeat.i(148498);
    mlf = new HashSet();
    AppMethodBeat.o(148498);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(148495);
    mlf.remove(paramc);
    AppMethodBeat.o(148495);
  }
  
  public static void c(c paramc)
  {
    AppMethodBeat.i(148494);
    if (!mlf.contains(paramc)) {
      mlf.add(paramc);
    }
    AppMethodBeat.o(148494);
  }
  
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(148496);
    db localdb = parama.jQG;
    if (localdb == null)
    {
      Log.e("MicroMsg.VoiceMsgExtension", "onPreAddMessage cmdAM is null , give up.");
      AppMethodBeat.o(148496);
      return null;
    }
    Log.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg srvId:" + localdb.HlH);
    Object localObject2 = com.tencent.mm.platformtools.z.a(localdb.RID);
    if (((String)localObject2).equals(com.tencent.mm.model.z.bcZ())) {}
    for (Object localObject1 = com.tencent.mm.platformtools.z.a(localdb.RIE);; localObject1 = localObject2)
    {
      Object localObject3 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL((String)localObject1, localdb.HlH);
      if ((((et)localObject3).field_msgId != 0L) && (((et)localObject3).field_createTime + 604800000L < bq.z((String)localObject1, localdb.CreateTime)))
      {
        Log.w("MicroMsg.VoiceMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d", new Object[] { Long.valueOf(localdb.HlH) });
        bq.A((String)localObject1, localdb.HlH);
        localObject3 = o.brz().GX(localdb.HlH);
        if ((localObject3 != null) && (!Util.isNullOrNil(((r)localObject3).fileName))) {
          s.YI(((r)localObject3).fileName);
        }
      }
      final r localr = new r();
      localr.fPV = ((String)localObject1);
      localr.createTime = localdb.CreateTime;
      localr.fNu = localdb.HlH;
      localr.hxy = localdb.RII;
      Log.d("MicroMsg.VoiceMsgExtension", "voiceMsgExtension, onPreAddMessage.(MsgSource : %s)", new Object[] { localdb.RII });
      localObject3 = com.tencent.mm.platformtools.z.a(localdb.RIF);
      if (ab.Lj((String)localObject2))
      {
        localObject2 = bq.RM((String)localObject3);
        Log.i("MicroMsg.VoiceMsgExtension", "chatroom voicemsg, new content=".concat(String.valueOf(localObject2)));
      }
      for (;;)
      {
        localObject3 = XmlParser.parseXml((String)localObject2, "msg", null);
        if (localObject3 == null)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 227L, 1L, false);
          AppMethodBeat.o(148496);
          return null;
        }
        try
        {
          localr.mgq = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$length")).intValue();
          localr.clientId = ((String)((Map)localObject3).get(".msg.voicemsg.$clientmsgid"));
          i = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$endflag")).intValue();
          int j = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$cancelflag")).intValue();
          localr.mkW = Integer.valueOf((String)((Map)localObject3).get(".msg.voicemsg.$voicelength")).intValue();
          localr.mhK = ((String)((Map)localObject3).get(".msg.voicemsg.$fromusername"));
          localObject2 = (String)((Map)localObject3).get(".msg.commenturl");
          localr.mjT = Integer.valueOf(Util.nullAs((String)((Map)localObject3).get(".msg.voicemsg.$forwardflag"), "0")).intValue();
          localr.mjM = ((String)((Map)localObject3).get(".msg.voicemsg.$voiceformat"));
          localr.mkY = Util.getLong((String)((Map)localObject3).get(".msg.voicemsg.$bufid"), 0L);
          if (j == 1)
          {
            Log.v("MicroMsg.VoiceMsgExtension", "cancelFlag = 1 srvId:" + localdb.HlH);
            parama = o.brz().GX(localr.fNu);
            if (parama != null) {
              s.YG(parama.fileName);
            }
            AppMethodBeat.o(148496);
            return null;
          }
        }
        catch (Exception parama)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 227L, 1L, false);
          Log.e("MicroMsg.VoiceMsgExtension", "parsing voice msg xml failed");
          Log.e("MicroMsg.VoiceMsgExtension", "exception:%s", new Object[] { Util.stackTraceToString(parama) });
          AppMethodBeat.o(148496);
          return null;
        }
        if (i == 1)
        {
          Log.v("MicroMsg.VoiceMsgExtension", "endFlag = 1 srvId:" + localdb.HlH);
          localr.lAW = localr.mgq;
        }
        localr.cUP = 284334;
        localObject3 = com.tencent.mm.platformtools.z.a(localdb.RIH);
        if (localObject3 != null) {
          Log.d("MicroMsg.VoiceMsgExtension", "Voice Buf Len:" + localObject3.length + " srvId:" + localdb.HlH);
        }
        int i = s.a(localr, (byte[])localObject3, localdb.rVU, (String)localObject2, localdb.RII, parama);
        if (i > 0)
        {
          Log.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(localdb.HlH), Integer.valueOf(localdb.RIK) });
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 228L, 1L, false);
          localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL(localr.fPV, localr.fNu);
          ((ca)localObject2).asJ(0);
          localObject3 = mlf.iterator();
          for (;;)
          {
            parama = (h.a)localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148493);
                this.mjR.ap(((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL(localr.fPV, localr.fNu));
                AppMethodBeat.o(148493);
              }
            });
          }
        }
        Log.i("MicroMsg.VoiceMsgExtension", "summerbadcr parseVoiceMsg setRecvSync[%d], svrId[%d], msgseq[%d], stack[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(localdb.HlH), Integer.valueOf(localdb.RIK), Util.getStack() });
        parama = null;
        if (parama != null)
        {
          localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx((String)localObject1);
          if (localObject2 != null)
          {
            ((az)localObject2).ro(16777216);
            ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a((az)localObject2, (String)localObject1);
          }
        }
        if ((parama != null) && (parama.field_msgId > 0L)) {}
        for (boolean bool = true;; bool = false)
        {
          parama = new h.b(parama, bool);
          AppMethodBeat.o(148496);
          return parama;
        }
        localObject2 = localObject3;
      }
    }
  }
  
  public final void b(h.c paramc)
  {
    AppMethodBeat.i(148497);
    paramc = paramc.fNz;
    Log.d("MicroMsg.VoiceMsgExtension", "onPreDelMessage " + paramc.field_imgPath + " " + paramc.field_talker);
    if (!ab.QI(paramc.field_talker)) {
      s.YI(paramc.field_imgPath);
    }
    AppMethodBeat.o(148497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.t
 * JD-Core Version:    0.7.0.1
 */